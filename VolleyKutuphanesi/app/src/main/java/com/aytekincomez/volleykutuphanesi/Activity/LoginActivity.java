package com.aytekincomez.volleykutuphanesi.Activity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.aytekincomez.volleykutuphanesi.R;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class LoginActivity extends AppCompatActivity {
    Button btnLogin, btnRegister;
    EditText etEmail, etPassword;

    RequestQueue queue;

    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;

    public void login(final String email, final String password){
        StringRequest request = new StringRequest(
                Request.Method.POST,
                "http://192.168.1.35/yeni/login.php",
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        if ("fail".equals(response)){
                            Toast.makeText(getApplicationContext(), "Kullanıcı adı veya sifre hatalı", Toast.LENGTH_LONG).show();
                        }else{
                            try {
                                JSONObject jsonObject = new JSONObject(response);
                                JSONArray jsonArray = jsonObject.getJSONArray("userdetails");

                                JSONObject user = jsonArray.getJSONObject(0);

                                int userid = Integer.parseInt(user.getString("id"));
                                String adsoyad = user.getString("adsoyad");
                                String email = user.getString("email");
                                String sehir = user.getString("sehir");
                                String dogumtarihi = user.getString("dogumtarihi");
                                String kayit_tarihi = user.getString("kayit_tarihi");

                                editor.putInt("userid",userid);
                                editor.putString("adsoyad",adsoyad);
                                editor.putString("email",email);
                                editor.putString("sehir",sehir);
                                editor.putString("dogumtarihi",dogumtarihi);
                                editor.putString("kayit_tarihi",kayit_tarihi);
                                editor.commit();

                            } catch (JSONException e) {
                                e.printStackTrace();
                            }

                            startActivity(new Intent(LoginActivity.this, MainActivity.class));
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
                map.put("email",email);
                map.put("pass",password);

                return map;
            }
        };
        queue.add(request);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        sharedPreferences = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
        editor = sharedPreferences.edit();

        queue = Volley.newRequestQueue(getApplicationContext());

        etEmail = findViewById(R.id.etEmail);
        etPassword = findViewById(R.id.etPassword);
        btnLogin = findViewById(R.id.btnLogin);
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                login(etEmail.getText().toString(), etPassword.getText().toString());
            }
        });
        btnRegister = findViewById(R.id.btnRegister);
        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(LoginActivity.this, RegisterActivity.class));
            }
        });
    }
}
