package com.aytekincomez.instagramuidesign.Activity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Typeface;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.aytekincomez.instagramuidesign.R;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class LoginActivity extends AppCompatActivity {
    TextView textView;
    Typeface typeface;
    EditText etEmail;
    EditText etSifre;
    Button btnLogin, btnRegister;
    RequestQueue queue;
    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;

    public void login(final String email, final String pass){
        StringRequest request = new StringRequest(
                Request.Method.POST,
                "http://192.168.49.1/instagram/login.php",
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        Log.d("WEB_SERVİCE",response);
                        if(response.equals("101")){
                            Toast.makeText(getApplicationContext(),"Hatalı giriş", Toast.LENGTH_LONG).show();
                        }else if (response.equals("102")){
                            Toast.makeText(getApplicationContext(), "Sunucu tarafında hata olustu.", Toast.LENGTH_LONG).show();
                        }else if(response.equals("103")){
                            Toast.makeText(getApplicationContext(), "Istek hatası.", Toast.LENGTH_LONG).show();
                        }else{
                            try {
                                JSONObject jsonObject = new JSONObject(response);
                                JSONArray jsonArray = jsonObject.getJSONArray("user");

                                JSONObject user = jsonArray.optJSONObject(0);
                                String email = user.getString("email");
                                String namesurname = user.getString("namesurname");
                                int userid = Integer.parseInt(user.getString("userid"));
                                String gender = user.getString("gender");
                                String username = user.getString("username");
                                String description = user.getString("description");
                                String profilePhoto = user.getString("profilePhoto");
                                String website = user.getString("website");
                                String phoneNumber = user.getString("phoneNumber");
                                String registerDate = user.getString("registerDate");
                                int verified_user = Integer.parseInt(user.getString("verified_user"));
                                int private_mode = Integer.parseInt(user.getString("private_mode"));
                                int business_mode = Integer.parseInt(user.getString("business_mode"));

                                Log.d("LOGIN",email+" "+username);
                                editor.putInt("userid",userid);
                                editor.putString("email", email);
                                editor.putString("namesurname", namesurname);
                                editor.putString("gender", gender);
                                editor.putString("description", description);
                                editor.putString("profilePhoto", profilePhoto);
                                editor.putString("website", website);
                                editor.putString("phoneNumber", phoneNumber);
                                editor.putString("registerDate", registerDate);
                                editor.putInt("verified_user", verified_user);
                                editor.putInt("private_mode", private_mode);
                                editor.putInt("business_mode", business_mode);

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
                map.put("password",pass);
                map.put("email",email);
                return map;
            }
        };
        queue.add(request);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        getSupportActionBar().hide();
        queue = Volley.newRequestQueue(getApplicationContext());
        sharedPreferences = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
        editor = sharedPreferences.edit();

        typeface = Typeface.createFromAsset(getAssets(), "fonts/Billabong.ttf");
        textView = (TextView)findViewById(R.id.textView1);
        textView.setTypeface(typeface);

        etEmail = (EditText)findViewById(R.id.etEmail);
        etSifre = (EditText)findViewById(R.id.etSifre);
        btnLogin = (Button)findViewById(R.id.btnLogin);
        btnRegister = findViewById(R.id.btnRegister);
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                login(etEmail.getText().toString(), etSifre.getText().toString());
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
