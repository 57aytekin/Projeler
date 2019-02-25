package com.aytekincomez.sharedpreferencesactivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    Button btnAyar, btn2;
    EditText editText;

    SharedPreferences sp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnAyar = (Button)findViewById(R.id.btnAyar);
        btn2 = (Button)findViewById(R.id.button2);
        editText = (EditText)findViewById(R.id.editText);
        sp = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());

        btnAyar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, SettingActivity.class));
            }
        });

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editText.setText(sp.getString("isim",""));
            }
        });

    }
}
