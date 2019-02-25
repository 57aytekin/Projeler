package com.aytekincomez.sharedpreferencekullaniciverileri;

import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    EditText etYas, etAd, etsoyad;
    Button btnEkle, btnGoruntule;
    SharedPreferences sp;
    SharedPreferences.Editor spe;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        sp = PreferenceManager.getDefaultSharedPreferences(this);

        etAd = (EditText)findViewById(R.id.etAd);
        etsoyad = (EditText)findViewById(R.id.etSoyad);
        etYas = (EditText)findViewById(R.id.etYas);

        btnEkle = (Button)findViewById(R.id.btnEkle);
        btnGoruntule = (Button)findViewById(R.id.btnGoruntule);

        btnEkle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                spe = sp.edit();
                spe.putString("ad",etAd.getText().toString());
                spe.putString("soyad",etsoyad.getText().toString());
                spe.putInt("yas", Integer.parseInt(etYas.getText().toString()));
                spe.commit();
            }
        });

        btnGoruntule.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, SecondActivity.class));
            }
        });
    }
}
