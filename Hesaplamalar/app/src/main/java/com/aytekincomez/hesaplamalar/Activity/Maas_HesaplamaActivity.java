package com.aytekincomez.hesaplamalar.Activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.aytekincomez.hesaplamalar.R;

public class Maas_HesaplamaActivity extends AppCompatActivity {
    EditText etMaasBrut;
    Button btnHesapla;
    LinearLayout linearLayout;

    TextView tvSgkKesintisi, tvVergiKesintisi, tvNetMaas;

    public void icerigiDoldur(EditText et){
        float brutMaas = Float.parseFloat(et.getText().toString());
        float sgkKesintisi = brutMaas * 0.21f;
        float vergiKesitisi = (brutMaas - sgkKesintisi) * 0.2f;
        float netMaas = brutMaas - sgkKesintisi - vergiKesitisi;

        tvSgkKesintisi = new TextView(this);
        tvSgkKesintisi.setTextSize(20);
        tvSgkKesintisi.setText("Sgk Kesintisi: "+sgkKesintisi);
        linearLayout.addView(tvSgkKesintisi);

        tvVergiKesintisi = new TextView(this);
        tvVergiKesintisi.setTextSize(20);
        tvVergiKesintisi.setText("Vergi Kesintisi: "+vergiKesitisi);
        linearLayout.addView(tvVergiKesintisi);

        tvNetMaas = new TextView(this);
        tvNetMaas.setTextSize(20);
        tvNetMaas.setText("Net Maas: "+netMaas);
        linearLayout.addView(tvNetMaas);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maas__hesaplama);

        linearLayout = (LinearLayout)findViewById(R.id.linearLayout);
        etMaasBrut = (EditText)findViewById(R.id.etMaasBrut);
        btnHesapla = (Button)findViewById(R.id.btnMaasiHesapla);
        btnHesapla.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                icerigiDoldur(etMaasBrut);
            }
        });
    }
}
