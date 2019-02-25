package com.aytekincomez.instagramuidesign.Activity;

import android.os.Bundle;
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
import com.aytekincomez.instagramuidesign.R;

import java.util.HashMap;
import java.util.Map;

public class RegisterActivity extends AppCompatActivity {
    EditText etUsername, etPass, etNameSurname, etMail;
    Button btnReg;
    RequestQueue queue;

    public void register(final String email, final String password, final String namesurname, final String username){
        StringRequest request = new StringRequest(
                Request.Method.POST,
                "http://192.168.49.1/instagram/register.php",
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        if(response.equals("ok")){
                            Toast.makeText(getApplicationContext(), "Kayıt Başarılı", Toast.LENGTH_LONG).show();
                        }else if(response.equals("-1")){
                            Toast.makeText(getApplicationContext(), "Tüm alanları doldurunuz", Toast.LENGTH_LONG).show();
                        }else if(response.equals("-2")){
                            Toast.makeText(getApplicationContext(), "Veritabanına bağlantı yapılamadı",Toast.LENGTH_LONG).show();
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
                map.put("password",password);
                map.put("namesurname",namesurname);
                map.put("username",username);
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

        etUsername = findViewById(R.id.etRegisterUsername);
        etPass = findViewById(R.id.etRegisterPassword);
        etNameSurname = findViewById(R.id.etRegisterNameSurname);
        etMail = findViewById(R.id.etRegisterEmail);
        btnReg = findViewById(R.id.btnSignUp);
        btnReg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                register(etMail.getText().toString(), etPass.getText().toString(), etNameSurname.getText().toString(), etUsername.getText().toString());
                finish();
            }
        });
    }
}
