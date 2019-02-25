package com.aytekincomez.asynctaskimageload;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class MainActivity extends AppCompatActivity {

    ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imageView = (ImageView)findViewById(R.id.imageView);

        new ResimYukleyici().execute("https://ifyazilim.nyc3.digitaloceanspaces.com/EtkIO/PublicDepo/EtkinlikAfis/2018/3/masterpiece-bostanci-resim-pop-art-95738.jpg");
    }

    private class ResimYukleyici extends AsyncTask<String, Void, Bitmap>{
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
        }

        @Override
        protected void onPostExecute(Bitmap bitmap) {
            super.onPostExecute(bitmap);
            if(bitmap != null){
                imageView.setImageBitmap(bitmap);
            }
        }

        @Override
        protected Bitmap doInBackground(String... strings) {
            try {
                return getImage(strings[0]);
            }catch (IOException e){
                return null;
            }

        }

        public Bitmap getImage(String url) throws IOException{
            URL baglanti = new URL(url);
            HttpURLConnection connection = (HttpURLConnection)baglanti.openConnection();

            int uzunluk = connection.getContentLength();

            InputStream is = (InputStream)baglanti.getContent();
            byte[] imageData = new byte[uzunluk];
            int bufferSize = (int) Math.ceil(uzunluk / (double)100);
            int downloaded = 0;
            int read;

            while (downloaded < uzunluk){
                if(uzunluk < bufferSize){
                    read = is.read(imageData, downloaded, uzunluk);
                }else if((uzunluk - downloaded) <= bufferSize){
                    read = is.read(imageData, downloaded, uzunluk- downloaded);
                }else{
                    read = is.read(imageData, downloaded, bufferSize);
                }
                downloaded += read;
            }

            Bitmap bitmap = BitmapFactory.decodeByteArray(imageData, 0, uzunluk);
            if(bitmap != null){
                Log.d("LOG","Bitmap olsuruldu");
            }else {
                Log.d("LOG","Bitmap olusturulamadı");
            }
            is.close();
            return bitmap;
        }
    }
}
