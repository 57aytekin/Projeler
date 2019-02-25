package com.aytekincomez.hesaplamalar.Activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.TextView;

import com.aytekincomez.hesaplamalar.R;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class SigaraMaliyeti_HesaplamaActivity extends AppCompatActivity {

    RadioButton rdSigaraMaliyetDal, rdSigaraMaliyetPaket;
    Button btnSigaraMaliyetHesapla;
    LinearLayout linearLayoutSigara;
    TextView tvSigaraMaliyetYazi;

    EditText et, et1,et2;
    TextView tv,tv1,tv2;

    private void icerigiDoldur(String radioButton){
        if("rd1".equals(radioButton)){
                tv = new TextView(this);
                tv.setId(1);
                tv.setText("Başlama Tarihi");
                linearLayoutSigara.addView(tv);

                et = new EditText(this);
                et.setId(2);
                et.setHint("01.2010");
                linearLayoutSigara.addView(et);

                tv1 = new TextView(this);
                tv1.setId(3);
                tv1.setText("Günlük Dal Adedi");
                linearLayoutSigara.addView(tv1);

                et1 = new EditText(this);
                et1.setId(4);
                et1.setHint("15");
                linearLayoutSigara.addView(et1);

                tv2 = new TextView(this);
                tv2.setId(5);
                tv2.setText("Güncel Paket Fiyatı");
                linearLayoutSigara.addView(tv2);

                et2 = new EditText(this);
                et2.setId(6);
                et2.setHint("12.50");
                linearLayoutSigara.addView(et2);


        }else if("rd2".equals(radioButton)){
                tv = new TextView(this);
                tv.setId(1);
                tv.setText("Başlama Tarihi");
                linearLayoutSigara.addView(tv);

                et = new EditText(this);
                et.setId(2);
                et.setHint("01.2010");
                linearLayoutSigara.addView(et);

                tv1 = new TextView(this);
                tv1.setId(3);
                tv1.setText("Günlük Paket Adedi");
                linearLayoutSigara.addView(tv1);

                et1 = new EditText(this);
                et1.setId(4);
                et1.setHint("2");
                linearLayoutSigara.addView(et1);

                tv2 = new TextView(this);
                tv2.setId(5);
                tv2.setText("Güncel Paket Fiyatı");
                linearLayoutSigara.addView(tv2);

                et2 = new EditText(this);
                et2.setId(6);
                et2.setHint("12.50");
                linearLayoutSigara.addView(et2);
        }
    }

    private void icerigiKaldir(){
        linearLayoutSigara.removeView(et);
        linearLayoutSigara.removeView(et1);
        linearLayoutSigara.removeView(et2);
        linearLayoutSigara.removeView(tv);
        linearLayoutSigara.removeView(tv1);
        linearLayoutSigara.removeView(tv2);
    }
    public String hesapla(EditText editText){
        Calendar calendar = Calendar.getInstance();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("MM.yyyy", Locale.US);

        try {
            calendar.setTime(simpleDateFormat.parse(editText.getText().toString()));
        }catch (ParseException e){

        }

        Calendar calendar2 = Calendar.getInstance();

        Date d1 = new Date(calendar.getTimeInMillis());
        Date d2 = new Date(calendar2.getTimeInMillis());

        long zamanFarki = d2.getTime() - d1.getTime();

        String sonuc = ""+ (zamanFarki / (1000*60*60*24));

        return sonuc;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sigara_maliyeti__hesaplama);

        rdSigaraMaliyetDal = (RadioButton)findViewById(R.id.rdSigaraMaliyetDal);
        rdSigaraMaliyetPaket = (RadioButton)findViewById(R.id.rdSigaraMaliyetPaket);
        linearLayoutSigara = (LinearLayout)findViewById(R.id.linearLayoutSigara);
        tvSigaraMaliyetYazi = (TextView)findViewById(R.id.tvSigaraMaliyetYazi);
        btnSigaraMaliyetHesapla = (Button)findViewById(R.id.btnSigaraMaliyetHesapla);

        rdSigaraMaliyetDal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                icerigiKaldir();
                icerigiDoldur("rd1");
            }
        });

        rdSigaraMaliyetPaket.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                icerigiKaldir();
                icerigiDoldur("rd2");
                tvSigaraMaliyetYazi.setText("");
            }
        });

        btnSigaraMaliyetHesapla.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(rdSigaraMaliyetDal.isChecked()){


                    if(
                            et.getText().toString().isEmpty() == false
                            && et1.getText().toString().isEmpty() == false
                            && et2.getText().toString().isEmpty() == false){

                        String fark = hesapla(et);
                        String baslamaTarihi = et.getText().toString();
                        float gunlukDalAdedi = Float.parseFloat(et1.getText().toString());
                        float guncelPketFiyati = Float.parseFloat(et2.getText().toString());

                        int kacGunGecti = Integer.parseInt(fark);
                        float paketSayisi = gunlukDalAdedi * kacGunGecti  /19;
                        float toplamMaliyet = paketSayisi * guncelPketFiyati;

                        tvSigaraMaliyetYazi.setText("Toplam Harcanan Maaliyet: "+toplamMaliyet);

                    }




                }else if(rdSigaraMaliyetPaket.isChecked()){

                }
            }
        });
    }
}
