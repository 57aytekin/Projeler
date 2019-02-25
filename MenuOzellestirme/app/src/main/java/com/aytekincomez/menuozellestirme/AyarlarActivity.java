package com.aytekincomez.menuozellestirme;

import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;

public class AyarlarActivity extends AppCompatActivity {

    Button btnayarlariKaydet;
    EditText etAdiniz;
    CheckBox chkbeniHatirla;
    RadioButton btn1, btn2, btn3;

    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(item.getItemId() == R.id.homeAsUp){
            finish();
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ayarlar);
        this.getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        sharedPreferences = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
        editor = sharedPreferences.edit();

        btnayarlariKaydet = (Button)findViewById(R.id.btnAyarlarKaydet);
        etAdiniz = (EditText)findViewById(R.id.etAyarlarKullaniciAdi);
        chkbeniHatirla = (CheckBox) findViewById(R.id.chkBeniHatirla);
        btn1 = (RadioButton)findViewById(R.id.bildirimYok);
        btn2 = (RadioButton)findViewById(R.id.bildirimHerSaat);
        btn3 = (RadioButton)findViewById(R.id.bildirimHerYarimSaat);

        etAdiniz.setText(sharedPreferences.getString("adsoyad",""));
        if(sharedPreferences.getBoolean("benihatirla",false) == true){
            chkbeniHatirla.setChecked(true);
        }

        if(sharedPreferences.getInt("bildirim",0) == 1){
            btn1.setChecked(true);
        }else if (sharedPreferences.getInt("bildirim",0) == 2){
            btn2.setChecked(true);
        }else if (sharedPreferences.getInt("bildirim",0) == 3){
            btn3.setChecked(true);
        }
        btnayarlariKaydet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!etAdiniz.getText().toString().equals("")){
                    editor.putString("adsoyad",etAdiniz.getText().toString());
                }

                if(chkbeniHatirla.isChecked()){
                    editor.putBoolean("benihatirla",true);
                }else{
                    editor.putBoolean("benihatirla",false);
                }

                if(btn1.isChecked()){
                    editor.putInt("bildirim",1);
                }else if(btn2.isChecked()){
                    editor.putInt("bildirim",2);
                }else if(btn3.isChecked()){
                    editor.putInt("bildirim",3);
                }

                editor.commit();

            }
        });
    }
}
