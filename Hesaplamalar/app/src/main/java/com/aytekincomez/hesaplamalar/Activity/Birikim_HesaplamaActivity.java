package com.aytekincomez.hesaplamalar.Activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.NumberPicker;
import android.widget.TextView;

import com.aytekincomez.hesaplamalar.R;

public class Birikim_HesaplamaActivity extends AppCompatActivity {

    EditText etBirikimTutari, etHaftalikBirikim, etBirikimSuresi;
    Button btnBirikimiHesapla;
    TextView tvBirikimSonuc;
    NumberPicker npBirikimHafta;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_birikim__hesaplama);
        etBirikimTutari = (EditText)findViewById(R.id.etBirikimTutari);
        etHaftalikBirikim = (EditText)findViewById(R.id.etHaftalikBirikim);
        //etBirikimSuresi = (EditText)findViewById(R.id.etBirikimSuresi);
        tvBirikimSonuc = (TextView)findViewById(R.id.tvBirikimSonuc);
        btnBirikimiHesapla = (Button)findViewById(R.id.btnBirikimiHesapla);
        npBirikimHafta = (NumberPicker)findViewById(R.id.npBirikimHafta) ;

        npBirikimHafta.setMinValue(1);
        npBirikimHafta.setMaxValue(100);

        btnBirikimiHesapla.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                float mevcutBirikimTutari = Float.parseFloat(etBirikimTutari.getText().toString());
                float birikimSuresi =(float) npBirikimHafta.getValue(); //Float.parseFloat(etBirikimSuresi.getText().toString());
                float haftalikBirikim = Float.parseFloat(etHaftalikBirikim.getText().toString());
                float toplamBirikimMiktari = 0;

                toplamBirikimMiktari = haftalikBirikim * birikimSuresi + mevcutBirikimTutari;
                tvBirikimSonuc.setText(""+toplamBirikimMiktari);

            }
        });

    }
}
