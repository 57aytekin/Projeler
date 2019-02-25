package com.aytekincomez.verileriokumayazmayontemleri;

import android.os.AsyncTask;
import android.util.Log;

import com.aytekincomez.verileriokumayazmayontemleri.Helper.HttpHandler;
import com.aytekincomez.verileriokumayazmayontemleri.Model.Ogrenci;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;

public class GetJson extends AsyncTask<Void, Void, Void> {

    public ArrayList<Ogrenci> ogrenciler = new ArrayList<>();
    private String URL = "http://raw.githubusercontent.com/serifgungor/AdnroidCourseTutorials/master/forExample/muzeler3.json";


    public String getURL() {
        return URL;
    }

    public void setURL(String URL) {
        this.URL = URL;
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();

    }

    @Override
    protected void onPostExecute(Void aVoid) {
        super.onPostExecute(aVoid);

    }

    @Override
    protected Void doInBackground(Void... voids) {
        HttpHandler httpHandler = new HttpHandler();
        String jsonString = httpHandler.makeServiceCall(URL);

        if(jsonString != null){

            Log.d("JSON", jsonString);
            try {
                JSONObject jsonObject = new JSONObject(jsonString);
                JSONArray ogrencis = jsonObject.getJSONArray("ogrenciler");

                for(int i=0; i<ogrencis.length(); i++){
                    JSONObject ogrenci = ogrencis.getJSONObject(i);
                    int ogrenciNo = ogrenci.getInt("ogrenci_no");
                    String ogrenciAd = ogrenci.getString("ogrenci_ad");
                    String ogrenciSoyad = ogrenci.getString("ogrenci_soyad");
                    String ogrenciOkul = ogrenci.getString("ogreci_okul");

                    Ogrenci ogr = new Ogrenci(
                            ogrenciNo,
                            ogrenciAd,
                            ogrenciSoyad,
                            ogrenciOkul
                    );

                    ogrenciler.add(ogr);
                }
            }catch (Exception e){
                Log.d("Hata",e.getLocalizedMessage());
            }
        }else{
            Log.d("JSON_RESPONSE","Sayfa Kaynagı Boş");
        }
        return null;
            /*
            İşlmein gerceklestirme zamanında.
             */
    }
}