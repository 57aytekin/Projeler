package com.aytekincomez.yemektarifiapp.Activity;

import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.app.Activity;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.aytekincomez.yemektarifiapp.Database.DatabaseHelper;
import com.aytekincomez.yemektarifiapp.Model.Yemekler;
import com.aytekincomez.yemektarifiapp.R;
import com.bumptech.glide.Glide;

import java.io.IOException;

public class YemekDetayActivity extends Activity {

    TextView tvBaslik, tvKategori, tvHazirlanisi, tvKisiSayisi, tvPisirmeSuresi, tvZorluk, tvHazirlamaSuresi;
    LinearLayout linearMalzemeler, linearAlerjenler;
    ImageView ivResim;
    DatabaseHelper dbHelper;
    SQLiteDatabase db;

    public void degerleriDoldur(String str, String islem){
        String[] dizi = str.split(",");

        if ("malzeme".equals(islem)){
            for (int i=0; i<dizi.length-1; i++){
                CheckBox checkBox = new CheckBox(this);
                checkBox.setText(dizi[i]);
                linearMalzemeler.addView(checkBox);
            }
        }else if ("alerjenler".equals(islem)){
            for (int i=0; i<dizi.length-1; i++){
                CheckBox checkBox = new CheckBox(this);
                checkBox.setText(dizi[i]);
                linearAlerjenler.addView(checkBox);
            }
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_yemek_detay);
        try {
            dbHelper = new DatabaseHelper(this);
            db = dbHelper.getReadableDatabase();
        } catch (IOException e) {
            e.printStackTrace();
        }

        ivResim = findViewById(R.id.ivYemekDetayResim);
        tvBaslik = findViewById(R.id.tvYemekDetayBaslik);
        tvKategori = findViewById(R.id.tvYemekDetayKategoriAd);
        tvHazirlamaSuresi = findViewById(R.id.tvYemekDetayHazirlamaSuresi);
        tvPisirmeSuresi = findViewById(R.id.tvYemekDetayPisirmeSuresi);
        tvKisiSayisi = findViewById(R.id.tvYemekDetayKisiSayisi);
        tvZorluk = findViewById(R.id.tvYemekDetayZorlukSeviyesi);
        tvHazirlanisi = findViewById(R.id.tvYemekDetayHazirlanisi);
        linearMalzemeler = findViewById(R.id.linearMalzemeler);
        linearAlerjenler = findViewById(R.id.linearAlerjenler);

        Yemekler yemek =(Yemekler) getIntent().getSerializableExtra("yemek");

        degerleriDoldur(yemek.getMalzemeler(),"malzeme");
        degerleriDoldur(yemek.getAlerjenler(),"alerjenler");

        tvBaslik.setText(yemek.getYemek_adi());
        tvHazirlanisi.setText(yemek.getHazirlanisi());
        if (yemek.getZorluk_seviyesi() == 1){
            tvZorluk.setText("Kolay");
        }else if (yemek.getZorluk_seviyesi() == 2){
            tvZorluk.setText("Orta");
        }else if (yemek.getZorluk_seviyesi() == 3){
            tvZorluk.setText("Zor");
        }
        tvHazirlamaSuresi.setText(""+yemek.getHazirlama_suresi()+ " dakika");
        tvPisirmeSuresi.setText(""+yemek.getPisirme_suresi()+" dakika");
        tvKisiSayisi.setText(""+yemek.getKisi_sayisi()+" kişilik");
        tvKategori.setText(dbHelper.getCategoryName(yemek.getKategori_id()));

        int id = getResources().getIdentifier(yemek.getResim_konumu(),"drawable",getPackageName());
        Glide.with(this).load(id).into(ivResim);


    }
}
