package com.aytekincomez.hesaplamalar.Activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;

import com.aytekincomez.hesaplamalar.R;

public class VKI_HesaplamaActivity extends AppCompatActivity {

    Button btnHesapla;
    EditText etBoy, etKilo;
    RadioButton bay, bayan;
    TextView tvSonuc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vki__hesaplama);

        btnHesapla = (Button)findViewById(R.id.btnVKI_hesapla);
        etBoy = (EditText)findViewById(R.id.etVKI_boy);
        etKilo = (EditText)findViewById(R.id.etVKI_kilo);
        bay = (RadioButton)findViewById(R.id.rdVKI_bay);
        bayan = (RadioButton)findViewById(R.id.rdVKI_bayan);
        tvSonuc = (TextView)findViewById(R.id.tvVKI_sonuc);

        btnHesapla.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                float boyFloat = Float.parseFloat(etBoy.getText().toString());
                float kiloFloat = Float.parseFloat(etKilo.getText().toString());
                float sonuc = kiloFloat/((boyFloat/100) * (boyFloat/100));
                float idealKilo = 0;
                if(bay.isChecked()){
                    idealKilo = (float)((boyFloat-100)*0.89);
                }else if(bayan.isChecked()){
                    idealKilo = (float) ((boyFloat-100) *0.94);
                }

                if(Math.round(sonuc) > 0 && (sonuc)<18.49){
                    tvSonuc.setText("Boyunuza göre uygun ağırlıkta olmadığınızı, zayıf olduğunuzu gösterir.Zayıflık bazı hastalıklar içn risk olsururan  ve istenmeyen bir durumdur.");
                }else if(Math.round(sonuc) > 18.49 && (sonuc)<24.99){
                    tvSonuc.setText("Boyunuza göre uygun agırlıkta oldugunuzu gösterir.Gerekli aktivite ve spor yaparak kilonuzu koruyunuz.");
                }else if(Math.round(sonuc) > 24.99 && (sonuc)<29.99){
                    tvSonuc.setText("Boyunuza göre vücut agırlıgınızın fazla oldugunu gösterir.Gerekli önlemler alınmadıgı takdirde obeziteye kadar gidebiri.");
                }else if(Math.round(sonuc) > 29.99 && (sonuc)<34.99){
                    tvSonuc.setText("Boyunuzu göre vücut agırlıgınızı fazla oldugunu gösterir.Normal kilonuza inmeniz saglıgınız acısından cok önemlidir.Lütfen, saglık kurulusuna basvurunuz.");
                }else if(Math.round(sonuc) > 34.99 && (sonuc)<44.99){
                    tvSonuc.setText("Boyunuzu göre vücut agırlıgınızı fazla oldugunu gösterir.Normal kilonuza inmeniz saglıgınız acısından cok önemlidir.Lütfen, saglık kurulusuna basvurunuz.");
                }else if(Math.round(sonuc) > 44.99){
                    tvSonuc.setText("Boyunuzu göre vücut agırlıgınızı fazla oldugunu gösterir.Normal kilonuza inmeniz saglıgınız acısından cok önemlidir.Lütfen, saglık kurulusuna basvurunuz.");
                }
            }
        });
    }
}
