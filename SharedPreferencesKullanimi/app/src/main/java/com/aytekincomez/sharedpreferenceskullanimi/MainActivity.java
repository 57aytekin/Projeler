package com.aytekincomez.sharedpreferenceskullanimi;

import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    SharedPreferences sp;
    SharedPreferences.Editor spe;

    EditText etEmail, etPassword;
    Button btnLogin;
    CheckBox checkBox;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etEmail = (EditText)findViewById(R.id.etEmail);
        etPassword = (EditText)findViewById(R.id.etPassword);
        btnLogin = (Button)findViewById(R.id.btnLogin);
        checkBox = (CheckBox)findViewById(R.id.checkBox);

        sp = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());

        if(sp.getBoolean("rememberme",false) == true){
            checkBox.setChecked(true);
            etEmail.setText(sp.getString("email",""));
            etPassword.setText(sp.getString("password", ""));
        }

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                spe = sp.edit();
                if(checkBox.isChecked()){
                    spe.putString("email", etEmail.getText().toString());
                    spe.putString("password", etPassword.getText().toString());
                    spe.putBoolean("rememberme", true);
                    spe.commit();
                }else {
                    spe.putBoolean("rememberme", false);
                    spe.commit();
                }
            }
        });

    }
}
