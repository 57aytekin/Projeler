package com.aytekincomez.hesaplamalar.Activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;

import com.aytekincomez.hesaplamalar.R;

public class Kdv_HesaplamaActivity extends AppCompatActivity {

    EditText etMatrah;
    RadioButton rdBtn1, rdBtn8, rdBtn18;
    Button btnHesap;
    TextView tvKdvSonuc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kdv__hesaplama);

        tvKdvSonuc = (TextView)findViewById(R.id.tvKdvSonuc);
        etMatrah = (EditText)findViewById(R.id.etKdvMatrah);
        rdBtn1 = (RadioButton)findViewById(R.id.rdBtnKdv1);
        rdBtn8 = (RadioButton)findViewById(R.id.rdBtnKdv8);
        rdBtn18 = (RadioButton)findViewById(R.id.rdBtnKdv18);
        btnHesap = (Button)findViewById(R.id.btnKdvHesap);
        btnHesap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                float kdv = 0;
                float matrah = Float.parseFloat(etMatrah.getText().toString());
                float kdvSonuc = 0;
                float yekun = 0;

                if(rdBtn1.isChecked()){
                    kdv = 0.01f;
                }else if(rdBtn8.isChecked()){
                    kdv = 0.08f;
                }else if(rdBtn18.isChecked()){
                    kdv = 0.18f;
                }
                kdvSonuc = matrah * kdv;
                yekun = matrah + kdvSonuc;

                StringBuilder sb = new StringBuilder();
                sb.append("Matrah: ").append(matrah);
                sb.append("\n");
                sb.append("Kdv'si: ").append(kdvSonuc);
                sb.append("\n");
                sb.append("Yekun: ").append(yekun);

                tvKdvSonuc.setText(sb.toString());
            }
        });
    }
}
