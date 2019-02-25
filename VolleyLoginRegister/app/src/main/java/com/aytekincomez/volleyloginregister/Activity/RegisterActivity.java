package com.aytekincomez.volleyloginregister.Activity;

import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.aytekincomez.volleyloginregister.R;
import com.aytekincomez.volleyloginregister.databinding.RegisterActivityBinding;

import java.util.HashMap;
import java.util.Map;

public class RegisterActivity extends AppCompatActivity {

    RegisterActivityBinding binding;
    RequestQueue queue;

    private void fillData(final String city, final String country, final String email, final String nameSurname, final String password){
        StringRequest postReqest = new StringRequest(
                Request.Method.POST,
                "http://serifgungor.com/webapi/adduser.php",
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        Log.d("RESPONSE", response);
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
                Map<String, String> params = new HashMap<String, String>();
                params.put("city",city);
                params.put("country",country);
                params.put("email",email);
                params.put("nameSurname",nameSurname);
                params.put("password",password);
                return params;
            }
        };
        queue.add(postReqest);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.register_activity);
        queue = Volley.newRequestQueue(getApplicationContext());

        binding = DataBindingUtil.setContentView(this,R.layout.register_activity);
        binding.btnReg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String city = binding.etRegisterCity.getText().toString();
                String coutry = binding.etRegisterCountry.getText().toString();
                String email = binding.etRegisterEmail.getText().toString();
                String nameSurname = binding.etRegisterNameSurname.getText().toString();
                String password = binding.etRegisterPassword.getText().toString();

                fillData(city,coutry,email,nameSurname,password);
            }
        });
    }
}
