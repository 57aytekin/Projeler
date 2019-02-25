package com.aytekincomez.volleykutuphanesi.Activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.aytekincomez.volleykutuphanesi.R;

import java.util.HashMap;
import java.util.Map;

public class RegisterActivity extends AppCompatActivity {
    Button btnKayitOl;
    EditText etAdSoyad, etEmail, etPassword, etSehir, etDogumTarihi;
    RequestQueue istekKuyrugu;

    public void kayitOl(final String email, final String adsoyad, final String password, final String sehir, final String dogumtarihi){
        StringRequest request = new StringRequest(
                Request.Method.POST,
                "http://192.168.1.35/yeni/register.php",
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
                map.put("email",email);
                map.put("adsoyad",adsoyad);
                map.put("pass",password);
                map.put("sehir",sehir);
                map.put("dogumtarihi",dogumtarihi);
                return map;
            }
        };
        istekKuyrugu.add(request);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        istekKuyrugu = Volley.newRequestQueue(getApplicationContext());

        btnKayitOl = findViewById(R.id.btnRegisterSignUp);
        etEmail = findViewById(R.id.etRegisterEmail);
        etPassword = findViewById(R.id.etRegisterPassword);
        etSehir = findViewById(R.id.etRegisterSehir);
        etDogumTarihi = findViewById(R.id.etRegisterDogumT);
        etAdSoyad = findViewById(R.id.etRegisterAdSoyad);
        btnKayitOl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                kayitOl(etEmail.getText().toString(), etAdSoyad.getText().toString(), etPassword.getText().toString(),etSehir.getText().toString(),etDogumTarihi.getText().toString());
            }
        });
    }
}
