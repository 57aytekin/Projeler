package com.aytekincomez.verileriokumayazmayontemleri.Activity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;

import com.aytekincomez.verileriokumayazmayontemleri.R;

public class LoginActivity extends AppCompatActivity {
    SharedPreferences sharedPreferences;
    SharedPreferences.Editor sharedPreferencesEditor;

    EditText etEmail, etPassword;
    CheckBox chRememberMe;
    Button btnLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        sharedPreferences = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());

        etEmail = (EditText) findViewById(R.id.etEmail);
        etPassword = (EditText) findViewById(R.id.etPassword);
        chRememberMe = (CheckBox) findViewById(R.id.chRememberMe);

        String email = sharedPreferences.getString("email","");
        String password = sharedPreferences.getString("pass","");

        if(!"".equals(email) && !"".equals(password)){
            etEmail.setText(email);
            etPassword.setText(password);
        }

        btnLogin = (Button) findViewById(R.id.btnLogin);
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sharedPreferencesEditor = sharedPreferences.edit();

                if(chRememberMe.isChecked()){
                    sharedPreferencesEditor.putString("email",etEmail.getText().toString());
                    sharedPreferencesEditor.putString("pass",etPassword.getText().toString());
                    sharedPreferencesEditor.commit();
                }else{
                    sharedPreferencesEditor.putString("email","");
                    sharedPreferencesEditor.putString("pass","");
                    sharedPreferencesEditor.commit();
                }

                startActivity(new Intent
                        (getApplicationContext(), MainActivity.class)
                        .putExtra("email",etEmail.getText().toString())
                );
            }
        });
    }
}
