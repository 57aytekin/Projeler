package com.aytekincomez.volleyloginandregister.Activity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
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
import com.aytekincomez.volleyloginandregister.R;

import java.util.HashMap;
import java.util.Map;

public class LoginActivity extends AppCompatActivity {

    EditText etEmail, etPassword;
    Button btnLogin, btnRegister;
    RequestQueue queue;
    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;

    public void kayitOl(final String email, final String password){
        StringRequest request = new StringRequest(
                Request.Method.POST,
                "http://192.168.49.1/loginAndRegister/login.php",
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        Log.d("WEB_SERVİCES", response);
                        if(response.equals("100")){
                            Toast.makeText(getApplicationContext(), "Giriş başarılı", Toast.LENGTH_LONG).show();
                            startActivity(new Intent(getApplicationContext(), LoggedActivity.class));

                            editor.putString("email",etEmail.getText().toString());
                            editor.putString("sifre",etPassword.getText().toString());
                            editor.commit();

                        }else if(response.equals("101")){
                            Toast.makeText(getApplicationContext(), "Hatali email veya şifre", Toast.LENGTH_LONG).show();
                        }else if(response.equals("102")){
                            Toast.makeText(getApplicationContext(), "Sunucu tarafında hata ile karşılaşıldı", Toast.LENGTH_LONG).show();
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
        queue = Volley.newRequestQueue(getApplicationContext());
        sharedPreferences = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
        editor = sharedPreferences.edit();

        etEmail = findViewById(R.id.etLoginEmail);
        etPassword = findViewById(R.id.etLoginPassword);
        btnLogin = findViewById(R.id.btnLogin);
        btnRegister = findViewById(R.id.btnRegister);

        etEmail.setText(sharedPreferences.getString("email",""));
        etPassword.setText(sharedPreferences.getString("sifre",""));

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                kayitOl(etEmail.getText().toString(), etPassword.getText().toString());
            }
        });

        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(LoginActivity.this, RegisterActivity.class));
            }
        });
    }
}
