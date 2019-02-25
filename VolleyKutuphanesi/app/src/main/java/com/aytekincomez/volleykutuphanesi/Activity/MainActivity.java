package com.aytekincomez.volleykutuphanesi.Activity;

import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.aytekincomez.volleykutuphanesi.Model.UserShare;
import com.aytekincomez.volleykutuphanesi.R;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {
    EditText etPaylasimYazisi;
    Button btnPaylas;
    ListView listViewPaylasimlar;
    RequestQueue queue;
    SharedPreferences sharedPreferences;
    ArrayAdapter<UserShare> adapter;
    ArrayList<UserShare> paylasimList;

    public void paylasimiKaldir(final int paylasimId){
        StringRequest istek = new StringRequest(
                Request.Method.POST,
                "http://192.168.1.35/yeni/remove_share.php",
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
                map.put("shareid",""+paylasimId);
                map.put("userid",""+sharedPreferences.getInt("userid",0));
                return map;
            }
        };
        queue.add(istek);
    }

    public void paylasimlariGetir(){
        StringRequest istek = new StringRequest(
                Request.Method.POST,
                "http://192.168.1.35/yeni/get_shares.php",
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        //Log.d("WEB_RESPONSE", response);
                        paylasimList = new ArrayList<>();

                        try {
                            JSONObject jsonObject = new JSONObject(response);
                            JSONArray jsonArray = jsonObject.getJSONArray("UserShares");

                            for(int i=0; i<jsonArray.length(); i++){
                                JSONObject item = jsonArray.getJSONObject(i);
                                paylasimList.add(
                                        new UserShare(
                                                Integer.parseInt(item.getString("id")),
                                                Integer.parseInt(item.getString("user_id")),
                                                item.getString("share_time"),
                                                item.getString("share_content")
                                        )
                                );
                            }

                        } catch (JSONException e) {
                            e.printStackTrace();
                        }

                        adapter = new ArrayAdapter<UserShare>(getApplicationContext(), android.R.layout.simple_list_item_1, paylasimList){
                            @Override
                            public View getView(int position,View convertView, ViewGroup parent) {
                                View view = super.getView(position, convertView, parent);
                                TextView tv = view.findViewById(android.R.id.text1);
                                tv.setTextColor(Color.BLACK);
                                return view;
                            }
                        };
                        listViewPaylasimlar.setAdapter(adapter);
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
                map.put("userid",""+sharedPreferences.getInt("userid",0));
                return map;
            }
        };
        queue.add(istek);
    }

    public void paylasimYap(){
        StringRequest request = new StringRequest(
                Request.Method.POST,
                "http://192.168.1.35/yeni/share.php",
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        Log.d("WEB_RESPONSE",response);
                        if("ok".equals(response)){
                            Toast.makeText(getApplicationContext(), "Paylasim Yapildi.", Toast.LENGTH_LONG).show();
                            etPaylasimYazisi.setText("");
                            paylasimlariGetir();

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
                Map<String, String> map = new HashMap<>();
                map.put("userid",""+sharedPreferences.getInt("userid",0));
                map.put("paylasim_yazisi",etPaylasimYazisi.getText().toString());
                return map;
            }
        };
        queue.add(request);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        sharedPreferences = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
        queue = Volley.newRequestQueue(getApplicationContext());

        etPaylasimYazisi = findViewById(R.id.etPaylasimYazisi);
        listViewPaylasimlar = findViewById(R.id.listViewPaylasimlar);
        btnPaylas = findViewById(R.id.btnPaylas);

        listViewPaylasimlar.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                paylasimiKaldir(paylasimList.get(position).getId());
                paylasimlariGetir();
                return false;
            }
        });

        btnPaylas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                paylasimYap();
            }
        });
    }
}
