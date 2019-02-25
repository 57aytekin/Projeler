package com.aytekincomez.yemektarifiapp.Activity;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.aytekincomez.yemektarifiapp.Adapter.GridView_KategorilerAdapter;
import com.aytekincomez.yemektarifiapp.Database.DatabaseHelper;
import com.aytekincomez.yemektarifiapp.Model.Kategoriler;
import com.aytekincomez.yemektarifiapp.R;

import java.io.IOException;
import java.util.ArrayList;

public class KategoriActivity extends AppCompatActivity {

    RecyclerView recyclerViewKategori;
    GridView_KategorilerAdapter adapter;
    DatabaseHelper dbHelper;
    SQLiteDatabase db;

    public ArrayList<Kategoriler> kategorileriDoldur(){
        ArrayList<Kategoriler> kategori = new ArrayList<>();

        try {
            dbHelper = new DatabaseHelper(this);
            db = dbHelper.getReadableDatabase();

            Cursor c = db.rawQuery("select * from Kategoriler",null);

            while (c.moveToNext()){
                int id = c.getInt(c.getColumnIndex("id"));
                String resim_konumu = c.getString(c.getColumnIndex("resim_konumu"));
                String baslik = c.getString(c.getColumnIndex("baslik"));

                kategori.add(new Kategoriler(id,resim_konumu,baslik));

            }
            c.close();
            db.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
        return kategori;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        recyclerViewKategori = findViewById(R.id.recyclerViewKategori);
        adapter = new GridView_KategorilerAdapter(this, kategorileriDoldur());
        recyclerViewKategori.setLayoutManager(new LinearLayoutManager(this));
        recyclerViewKategori.setAdapter(adapter);
    }
}
