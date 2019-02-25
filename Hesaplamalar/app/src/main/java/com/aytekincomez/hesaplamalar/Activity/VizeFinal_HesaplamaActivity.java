package com.aytekincomez.hesaplamalar.Activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.InputType;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import com.aytekincomez.hesaplamalar.R;

public class VizeFinal_HesaplamaActivity extends AppCompatActivity {
    RadioButton rdBtn1, rdBtn2;
    LinearLayout linearLayout;
    Button btnHesapla, btnTemizle;


    private EditText et, et2, et3, et4, etGecmePuani;
    private TextView tvSonuc;

    private void icerigiKaldir(String radioButton){
        if("buton1".equals(radioButton)){
            linearLayout.removeView(et);
            linearLayout.removeView(et2);
            linearLayout.removeView(et3);
            linearLayout.removeView(et4);
            linearLayout.removeView(btnHesapla);
            linearLayout.removeView(btnTemizle);
            linearLayout.removeView(tvSonuc);
            icerigiDoldur("buton2");
        }else if("buton2".equals(radioButton)){
            linearLayout.removeView(et);
            linearLayout.removeView(et2);
            linearLayout.removeView(et3);
            linearLayout.removeView(btnHesapla);
            linearLayout.removeView(btnTemizle);
            linearLayout.removeView(tvSonuc);
            icerigiDoldur("buton1");
        }
    }

    private void icerigiDoldur(String radioButton){
        if("buton1".equals(radioButton)){

            et = new EditText(this);
            et.setId(1);
            et.setHint("Vize Puanı");
            et.setInputType(InputType.TYPE_CLASS_NUMBER);
            linearLayout.addView(et);

            et2= new EditText(this);
            et2.setId(2);
            et2.setHint("Vize Puanı Oranı:(Örn:40)");
            et.setInputType(InputType.TYPE_CLASS_NUMBER);
            linearLayout.addView(et2);

            et3 = new EditText(this);
            et3.setId(3);
            et3.setHint("Final Puanı");
            et.setInputType(InputType.TYPE_CLASS_NUMBER);
            linearLayout.addView(et3);

            et4= new EditText(this);
            et4.setId(4);
            et4.setHint("Final Puanı Oranı:(Örn:60)");
            et.setInputType(InputType.TYPE_CLASS_NUMBER);
            linearLayout.addView(et4);

            tvSonuc = new TextView(this);
            tvSonuc.setId(5);
            tvSonuc.setText("Ortalamanız: ");
            tvSonuc.setTextSize(24);
            tvSonuc.setGravity(Gravity.CENTER);
            linearLayout.addView(tvSonuc);

            btnHesapla = new Button(this);
            btnHesapla.setId(20);
            btnHesapla.setText("Hesapla");
            linearLayout.addView(btnHesapla);
            btnHesapla.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    float vizePuan = 0;
                    float vizeOran = 0;
                    float finalPuan = 0;
                    float finalOran =0;
                    float ortalama = 0;

                    vizePuan = Float.parseFloat(et.getText().toString());
                    vizeOran = Float.parseFloat(et2.getText().toString());;
                    finalPuan = Float.parseFloat(et3.getText().toString());;
                    finalOran =Float.parseFloat(et4.getText().toString());;

                    ortalama = ((vizePuan*vizeOran)/100) + ((finalPuan*finalOran)/100);
                    if((vizeOran+finalOran) > 100){
                        Toast.makeText(getApplicationContext(),
                                "Oranların Toplamı 100 den buyuk olamaz.",
                                Toast.LENGTH_LONG).show();
                    }else{
                        if(finalPuan< 50){
                            Toast.makeText(getApplicationContext(),
                                    "Final notunuz 50'nin altında kaldınız.",
                                    Toast.LENGTH_LONG).show();
                        }else{
                            if(ortalama >= 50){
                                tvSonuc.setText("Tebrikler Geçtiniz.Ortalamanız: "+ortalama);
                            }else{
                                tvSonuc.setText("Bütünlemeye çalışmaya başlayın, üzgünüz:( Ortalamanız: "+ortalama);
                            }
                        }
                    }

                }
            });

            btnTemizle = new Button(this);
            btnTemizle.setId(21);
            btnTemizle.setText("Temizle");
            linearLayout.addView(btnTemizle);
            btnTemizle.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    et.setText("");
                    et2.setText("");
                    et3.setText("");
                    et4.setText("");
                    tvSonuc.setText("Ortalamanız: ");
                }
            });


        }else if("buton2".equals(radioButton)){
            et = new EditText(this);
            et.setId(11);
            et.setHint("Vize Puanı");
            et.setInputType(InputType.TYPE_CLASS_NUMBER);
            linearLayout.addView(et);

            et2= new EditText(this);
            et2.setId(12);
            et2.setHint("Vize Puanı Oranı:(Örn:40)");
            et.setInputType(InputType.TYPE_CLASS_NUMBER);
            linearLayout.addView(et2);

            et3 = new EditText(this);
            et3.setId(13);
            et3.setHint("Final Puanı Oranı:(Örn:60)");
            et.setInputType(InputType.TYPE_CLASS_NUMBER);
            linearLayout.addView(et3);

            tvSonuc = new TextView(this);
            tvSonuc.setId(5);
            tvSonuc.setText("Almanız Gereken Not: ");
            tvSonuc.setTextSize(24);
            tvSonuc.setGravity(Gravity.CENTER);
            linearLayout.addView(tvSonuc);

            btnHesapla = new Button(this);
            btnHesapla.setId(30);
            btnHesapla.setText("Hesapla");
            linearLayout.addView(btnHesapla);
            btnHesapla.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    float vizePuan = 0;
                    float vizeOran = 0;
                    float finalOran =0;
                    int bulunacakOrtalama = 0;
                    int x = 1;


                    vizePuan = Float.parseFloat(et.getText().toString());
                    vizeOran = Float.parseFloat(et2.getText().toString());;
                    finalOran =Float.parseFloat(et3.getText().toString());;
                    float sayi = 50-(vizePuan*vizeOran/100); //34
                    bulunacakOrtalama = (int)sayi;
                    int carpilmis =100*bulunacakOrtalama;
                    int sonuc = carpilmis / (int)finalOran;

                    if((vizeOran+finalOran) > 100){
                        Toast.makeText(getApplicationContext(),
                                "Oranların Toplamı 100 den buyuk olamaz.",
                                Toast.LENGTH_LONG).show();
                    }else{
                        tvSonuc.setText("Almanız Gereken Not: "+sonuc);
                    }
                }
            });

            btnTemizle = new Button(this);
            btnTemizle.setId(31);
            btnTemizle.setText("Temizle");
            linearLayout.addView(btnTemizle);
            btnTemizle.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    et.setText("");
                    et2.setText("");
                    et3.setText("");
                    tvSonuc.setText("Almanız Gereken Not: ");
                }
            });
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vize_final__hesaplama);

        rdBtn1 = (RadioButton)findViewById(R.id.rdItem1);
        rdBtn2 = (RadioButton)findViewById(R.id.rdItem2);
        linearLayout = (LinearLayout)findViewById(R.id.linearLayout1);


        rdBtn1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(rdBtn1.isChecked()){
                    icerigiKaldir("buton2");
                }else{

                }
            }
        });
        rdBtn2.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(rdBtn2.isChecked()){
                    icerigiKaldir("buton1");
                }else{

                }
            }
        });
    }
}
