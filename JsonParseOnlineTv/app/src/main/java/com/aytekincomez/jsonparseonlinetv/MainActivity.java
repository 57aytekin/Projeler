package com.aytekincomez.jsonparseonlinetv;

import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.ListView;

import com.aytekincomez.jsonparseonlinetv.Adapter.MyAdapter;
import com.aytekincomez.jsonparseonlinetv.Helper.HttpHandler;
import com.aytekincomez.jsonparseonlinetv.Model.Kanal;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ListView listView;
    MyAdapter myAdapter;
    ArrayList<Kanal> kanallar;
    HttpHandler httpHandler;
    ProgressDialog progressDialog;
    private static String URL = "https://raw.githubusercontent.com/57aytekin/kanallar/master/kanallar.json";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = (ListView)findViewById(R.id.liste);

        new getChannel().execute();

    }

    private class getChannel extends AsyncTask<Void,Void,Void>{
        ArrayList<Kanal> kanalArrayList = new ArrayList<>();

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            progressDialog = new ProgressDialog(MainActivity.this);
            progressDialog.setMessage("Lütfen Bekleyiniz...");
            progressDialog.setCancelable(false);
            progressDialog.show();
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);
            if(progressDialog.isShowing()){
                progressDialog.dismiss();
            }
            myAdapter = new MyAdapter(MainActivity.this, kanalArrayList );
            listView.setAdapter(myAdapter);
        }

        @Override
        protected Void doInBackground(Void... voids) {

            httpHandler = new HttpHandler();
            String str = httpHandler.makeServiceCall(URL);

            Log.d("LOG",str);

            if(str != null){
                try {

                    JSONObject jsonObject = new JSONObject(str);
                    JSONArray kanallar = jsonObject.getJSONArray("kanallar");
/*

		"kanalId":1,
		"kanalKategoriId":"",
		"kanalAdi":"Doe",
		"kanalResim":"",
		"kanalUrl":"",
		"kanalAciklama":"",
		"kanalDil":"",
 */
                    for(int i=0; i<kanallar.length(); i++){
                        JSONObject kanal = kanallar.getJSONObject(i);

                        int kanalId = kanal.getInt("kanalId");
                        String kanalKategoriId = kanal.getString("kanalKategoriId");
                        String kanalAdi = kanal.getString("kanalAdi");
                        String kanalResim = kanal.getString("kanalResim");
                        String kanalUrl = kanal.getString("kanalUrl");
                        String kanalAciklama = kanal.getString("kanalAciklama");
                        String kanalDil = kanal.getString("kanalDil");

                        Kanal knl = new Kanal(
                                kanalId,
                                kanalKategoriId,
                                kanalAdi,
                                kanalResim,
                                kanalUrl,
                                kanalAciklama,
                                kanalDil
                        );
                        kanalArrayList.add(knl);

                    }
                }catch (Exception e){

                }
            }else {
                Log.d("JSON","Veri boş");
            }

            return  null;
        }
    }
}
