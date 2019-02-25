package com.aytekincomez.androidvolleyphp.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.aytekincomez.androidvolleyphp.R;
import com.aytekincomez.androidvolleyphp.app.AppConfig;

import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class LoginActivity extends AppCompatActivity {

    EditText etEmail, etPassword;
    Button btnLogin, btnRegister;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        etEmail = (EditText)findViewById(R.id.etEmail);
        etPassword = (EditText)findViewById(R.id.etPassword);
        btnLogin = (Button)findViewById(R.id.btnGiris);
        btnRegister = (Button)findViewById(R.id.btnKayıtOl);

        final StringRequest postRequest = new StringRequest(
                Request.Method.POST,
                AppConfig.URL_GIRIS,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        Log.d("RESPONSE",response);
                        try {
                            JSONObject jsonObject = new JSONObject(response);
                            boolean error = jsonObject.getBoolean("error");

                            if(error){
                                String hataMesaji = jsonObject.getString("error_msg");
                                AlertDialog.Builder alert = new AlertDialog.Builder(LoginActivity.this);
                                alert.setMessage(hataMesaji);
                                alert.setTitle("Bir Sorun Var");
                                alert.show();
                            }else{

                                String uid = jsonObject.getString("uid");

                                JSONObject user = new JSONObject("user");
                                String name = user.getString("name");
                                String email = user.getString("email");

                                Intent i = new Intent(LoginActivity.this, MainActivity.class);
                                i.putExtra("userid",uid);
                                i.putExtra("name",name);
                                i.putExtra("email",email);

                                startActivity(i);
                            }
                        }catch (Exception e){

                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Log.e("RESPONSE",error.getMessage());
                    }
                }

        ){
            @Override
            protected Map<String, String> getPostParams() {

                Map<String, String> params = new HashMap<String, String>();
                params.put("email",etEmail.getText().toString());
                params.put("password",etPassword.getText().toString());
                return params;
            }
        };

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = etEmail.getText().toString();
                String pass = etPassword.getText().toString();

                RequestQueue queue = Volley.newRequestQueue(getApplicationContext());
                queue.add(postRequest);
            }
        });

        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), RegisterActivity.class));
            }
        });
    }
}
