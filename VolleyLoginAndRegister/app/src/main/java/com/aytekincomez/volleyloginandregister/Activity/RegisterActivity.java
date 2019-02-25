package com.aytekincomez.volleyloginandregister.Activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
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
import com.aytekincomez.volleyloginandregister.R;

import java.util.HashMap;
import java.util.Map;

public class RegisterActivity extends AppCompatActivity {

    EditText etNameSurname, etEmail, etPassword, etCountry, etCity;
    Button btnRegister;
    RequestQueue queue;

    public void fillData(final String city, final String country, final String email, final String nameSurname, final String password){
        StringRequest request = new StringRequest(
                Request.Method.POST,
                "http://192.168.49.1/loginAndRegister/kayit.php",
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
                map.put("pass",password);
                map.put("country",country);
                map.put("city",city);
                map.put("nameSurname",nameSurname);
                return map;
            }
        };
        queue.add(request);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        queue = Volley.newRequestQueue(getApplicationContext());

        etEmail = findViewById(R.id.etRegisterEmail);
        etNameSurname = findViewById(R.id.etRegisterNameSurname);
        etPassword = findViewById(R.id.etRegisterPassword);
        etCountry = findViewById(R.id.etRegisterCountry);
        etCity = findViewById(R.id.etRegisterCity);

        btnRegister = findViewById(R.id.btnReg);
        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String city = etCity.getText().toString();
                String country = etCountry.getText().toString();
                String nameSurname = etNameSurname.getText().toString();
                String email = etEmail.getText().toString();
                String password = etPassword.getText().toString();
                fillData(city, country, email, nameSurname, password);
            }
        });
    }
}
