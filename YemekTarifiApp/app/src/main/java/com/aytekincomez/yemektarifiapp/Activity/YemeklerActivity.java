package com.aytekincomez.yemektarifiapp.Activity;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.ListView;

import com.aytekincomez.yemektarifiapp.Adapter.ListViewYemeklerAdapter;
import com.aytekincomez.yemektarifiapp.Database.DatabaseHelper;
import com.aytekincomez.yemektarifiapp.Model.Yemekler;
import com.aytekincomez.yemektarifiapp.R;

import java.io.IOException;
import java.util.ArrayList;

public class YemeklerActivity extends AppCompatActivity {
    ListView listView;
    ArrayList<Yemekler> yemekler;
    DatabaseHelper dbHelper;
    SQLiteDatabase db;
    ListViewYemeklerAdapter adapter;

    public void yemekleriListele(int kategoriId){
        try {
            dbHelper = new DatabaseHelper(this);
            db = dbHelper.getReadableDatabase();

            Cursor c = db.rawQuery("select * from Yemekler where kategori_id="+kategoriId,null);
            while (c.moveToNext()){
                int id = c.getInt(c.getColumnIndex("id"));
                String yemek_adi = c.getString(c.getColumnIndex("yemek_adi"));
                int pisirme_suresi = c.getInt(c.getColumnIndex("pisirme_suresi"));
                int hazirlama_suresi = c.getInt(c.getColumnIndex("hazirlama_suresi"));
                int kisi_sayisi = c.getInt(c.getColumnIndex("kisi_sayisi"));
                int zorluk_seviesi = c.getInt(c.getColumnIndex("zorluk_seviyesi"));
                int kategori_id = c.getInt(c.getColumnIndex("kategori_id"));
                String resim_konumu = c.getString(c.getColumnIndex("resim_konumu"));
                String hazirlanisi = c.getString(c.getColumnIndex("hazirlanisi"));
                String malzemeler = c.getString(c.getColumnIndex("malzemeler"));
                String alerjenler = c.getString(c.getColumnIndex("alerjenler"));

                yemekler.add(new Yemekler(id, yemek_adi, pisirme_suresi, hazirlama_suresi, kisi_sayisi,
                                            zorluk_seviesi, kategori_id, resim_konumu, hazirlanisi, malzemeler, alerjenler));

            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_yemekler);
        this.getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        int id = getIntent().getIntExtra("kategori_id",0);
        String baslik = getIntent().getStringExtra("kategori_baslik");
        this.setTitle(baslik);

        listView = findViewById(R.id.listView);
        yemekler = new ArrayList<>();
        yemekleriListele(id);

        adapter = new ListViewYemeklerAdapter(this, yemekler);
        listView.setAdapter(adapter);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(item.getItemId() == android.R.id.home){
            finish();
        }

        return super.onOptionsItemSelected(item);
    }
}
