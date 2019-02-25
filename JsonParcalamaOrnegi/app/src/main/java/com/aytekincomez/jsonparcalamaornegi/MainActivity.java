package com.aytekincomez.jsonparcalamaornegi;

import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.GridView;

import com.aytekincomez.jsonparcalamaornegi.Adapter.GridViewAdapter;
import com.aytekincomez.jsonparcalamaornegi.Helper.HttpHandler;
import com.aytekincomez.jsonparcalamaornegi.Model.Ogrenci;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    GridView gridView;
    HttpHandler httpHandler;
    ProgressDialog progressDialog;
    GridViewAdapter gridViewAdapter;
    private static String URL= "https://raw.githubusercontent.com/57aytekin/test/master/ogrenciler.json";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        gridView = (GridView)findViewById(R.id.gridView);
        new getOgrenciler().execute();
    }

    private class getOgrenciler extends AsyncTask<Void, Void, Void>{
        ArrayList<Ogrenci> ogrenciArrayList = new ArrayList<>();
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
            gridViewAdapter = new GridViewAdapter(MainActivity.this, ogrenciArrayList);
            gridView.setAdapter(gridViewAdapter);
            if(progressDialog.isShowing()){
                progressDialog.dismiss();
            }

        }

        @Override
        protected Void doInBackground(Void... voids) {
            httpHandler = new HttpHandler();
            String jsonString =httpHandler.makeServiceCall(URL);

            Log.d("JSON_RESPONSE",jsonString);
            if(jsonString != null){

                try {
                    JSONObject jsonObject = new JSONObject(jsonString);
                    JSONArray ogrencier = jsonObject.getJSONArray("ogrenciler");

                    for(int i=0; i< ogrencier.length(); i++){
                        JSONObject ogrenci = ogrencier.getJSONObject(i);
                        int ogrenciiId = ogrenci.getInt("ogrenciNo");
                        String ogrenciAdi = ogrenci.getString("ogrenciAdi");
                        String ogrenciSoyad = ogrenci.getString("ogrenciSoyad");
                        String bolumAdi = ogrenci.getString("bolumAdi");
                        String okulAdi = ogrenci.getString("okulAdi");
                        int ogreciSinif = ogrenci.getInt("ogreciSinif");
                        String ogrenciResim = ogrenci.getString("ogrenciResim");

                        Ogrenci ogr = new Ogrenci(
                                ogrenciiId,
                                ogrenciAdi,
                                ogrenciSoyad,
                                bolumAdi,
                                okulAdi,
                                ogreciSinif,
                                ogrenciResim
                        );
                        ogrenciArrayList.add(ogr);
                        /*
                        "ogrenciNo":"1",
		"ogrenciAdi":"Aytekin",
		"ogrenciSoyad":"Çömez",
		"bolumAdi":"Ybs",
		"okulAdi":"Adü",
		"ogreciSinif":"4",
		"ogrenciResim":"https://www.edukanada.com/wp-content/uploads/2017/06/sturdy-permit-ogrenci-vizesi.jpg"
                         */
                    }
                }catch (Exception e){

                }
            }else{
                Log.d("JSON_RESPONSE","JsonString boşş");
            }
            return null;
        }
    }
}
