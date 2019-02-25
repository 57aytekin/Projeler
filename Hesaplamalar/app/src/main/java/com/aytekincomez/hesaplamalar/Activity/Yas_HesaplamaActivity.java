package com.aytekincomez.hesaplamalar.Activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.aytekincomez.hesaplamalar.R;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class Yas_HesaplamaActivity extends AppCompatActivity {
    EditText etYasDogumTarihi;
    TextView tvSonuc;
    Button btnHesapla;

    public String hesapla(EditText editText){
        Calendar calendar = Calendar.getInstance();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd.MM.yyyy", Locale.US);

        try {
            calendar.setTime(simpleDateFormat.parse(editText.getText().toString()));
        }catch (ParseException e){

        }

        Calendar calendar2 = Calendar.getInstance();

        Date d1 = new Date(calendar.getTimeInMillis());
        Date d2 = new Date(calendar2.getTimeInMillis());

        long zamanFarki = d2.getTime() - d1.getTime();

        String sonuc = ""+ (zamanFarki / (1000*60*60*24)/365);

        return sonuc;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_yas__hesaplama);

        etYasDogumTarihi = (EditText)findViewById(R.id.etYasDogumTarihi);
        tvSonuc = (TextView)findViewById(R.id.tvSonuc);
        btnHesapla = (Button)findViewById(R.id.btnYasHesapla);
        btnHesapla.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tvSonuc.setText("Yaşınız: "+hesapla(etYasDogumTarihi));
            }
        });

    }
}
