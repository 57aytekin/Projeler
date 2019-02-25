package com.aytekincomez.volleyloginandregister.Activity;

import android.app.Dialog;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.aytekincomez.volleyloginandregister.Adapter.PaylasimAdapter;
import com.aytekincomez.volleyloginandregister.Model.Paylasim;
import com.aytekincomez.volleyloginandregister.R;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class LoggedActivity extends AppCompatActivity {

    PaylasimAdapter adapter;
    ArrayList<Paylasim> paylasimlar = new ArrayList<>();
    ListView listView;
    SharedPreferences sharedPreferences;

    RequestQueue queue;

    public void icerikEkle(final String icerikYazisi){
        StringRequest request = new StringRequest(
                Request.Method.POST,
                "http://192.168.49.1/loginAndRegister/icerik_ekle.php",
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {

                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {

                    }
                }
        ){
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> map = new HashMap<>();
                map.put("icerik", icerikYazisi);
                map.put("mail", sharedPreferences.getString("email",""));
                return map;
            }
        };
        queue.add(request);
    }



    public void paylasimlariListele(){
        StringRequest request = new StringRequest(
                Request.Method.POST,
                "http://192.168.49.1/loginAndRegister/paylasim_listele.php",
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        Log.d("WEB_SERVİCE", response);

                        try {
                            JSONObject jsonObject = new JSONObject(response);
                            JSONArray jsonArray = jsonObject.optJSONArray("paylasimlar");
                            int elemanSayisi = jsonArray.length();

                            for(int i=0; i<elemanSayisi; i++){
                                JSONObject eleman = jsonArray.getJSONObject(i);

                                int id = eleman.getInt("id");
                                String tarih = eleman.getString("tarih");
                                String paylasan_mail = eleman.getString("paylasan_mail");
                                String paylasim_icerik = eleman.getString("paylasim_icerik");

                                paylasimlar.add(new Paylasim(id, tarih, paylasim_icerik, paylasan_mail));
                            }
                            adapter = new PaylasimAdapter(paylasimlar, getApplicationContext());
                            listView.setAdapter(adapter);

                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {

                    }
                }
        ){
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                return super.getParams();
            }
        };
        queue.add(request);
    }
    public void dialogCagir(){
        final Dialog d = new Dialog(LoggedActivity.this);
        d.setContentView(R.layout.yazi_ekle_layout);
        d.setTitle("İçerik");

        final EditText etIcerik = d.findViewById(R.id.etIcerik);
        Button btn = d.findViewById(R.id.btnEkle);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                icerikEkle(etIcerik.getText().toString());
                d.dismiss();

            }
        });

        d.show();
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_logged, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(item.getItemId() == R.id.item_add){
            dialogCagir();
        }else if(item.getItemId() == R.id.item_yenile){
            paylasimlar.clear();
            paylasimlariListele();
        }
        return true;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_logged);
        queue = Volley.newRequestQueue(getApplicationContext());
        sharedPreferences = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());

        listView = findViewById(R.id.listView);
        /*
        paylasimlar.add(new Paylasim(1,"01.01.2019","BU benim ilk palasımım","asd"));
        paylasimlar.add(new Paylasim(1,"01.01.2019","BU benim ilk palasımım","asd"));
        paylasimlar.add(new Paylasim(1,"01.01.2019","BU benim ilk palasımım","asd"));
        paylasimlar.add(new Paylasim(1,"01.01.2019","BU benim ilk palasımım","asd"));
        */
        paylasimlariListele();


    }
}
