package com.aytekincomez.sharedpreferencekullaniciverileri;

import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;

public class SecondActivity extends AppCompatActivity {

    EditText etSecondAd, etSecondSoyad, etSecondYas;
    SharedPreferences sp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        sp = PreferenceManager.getDefaultSharedPreferences(this);

        etSecondAd = (EditText)findViewById(R.id.etSecondAd);
        etSecondSoyad = (EditText)findViewById(R.id.etSecondSoyad);
        etSecondYas = (EditText)findViewById(R.id.etSecondYas);

        etSecondAd.setText(sp.getString("ad",""));
        etSecondSoyad.setText(sp.getString("soyad",""));
        etSecondYas.setText(""+sp.getInt("yas",0));
    }
}
