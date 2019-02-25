package com.aytekincomez.imsakiyeapp.Activity;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;

import com.aytekincomez.imsakiyeapp.Adapter.RecyclerViewAdapter;
import com.aytekincomez.imsakiyeapp.Database.DatabaseHelper;
import com.aytekincomez.imsakiyeapp.Model.Imsakiye;
import com.aytekincomez.imsakiyeapp.R;

import java.io.IOException;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    DatabaseHelper databaseHelper;
    SQLiteDatabase db;
    RecyclerViewAdapter adapter;

    public ArrayList<Imsakiye> tumVerileriCek(){
        ArrayList<Imsakiye> liste = new ArrayList<>();
        try {
            databaseHelper = new DatabaseHelper(this);
            db = databaseHelper.getReadableDatabase();

            Cursor cursor = db.rawQuery("select * from Gun",null);

            while (cursor.moveToNext()){

                int id = cursor.getInt(cursor.getColumnIndex("id"));
                String tarih = cursor.getString(cursor.getColumnIndex("tarih"));
                String sabah = cursor.getString(cursor.getColumnIndex("sabah"));
                String imsak = cursor.getString(cursor.getColumnIndex("imsak"));
                String gunes = cursor.getString(cursor.getColumnIndex("gunes"));
                String oglen = cursor.getString(cursor.getColumnIndex("oglen"));
                String ikindi = cursor.getString(cursor.getColumnIndex("ikindi"));
                String aksam = cursor.getString(cursor.getColumnIndex("aksam"));
                String yatsi = cursor.getString(cursor.getColumnIndex("yatsi"));
                liste.add(new Imsakiye(id,tarih,imsak,sabah,gunes, oglen, ikindi, aksam, yatsi));

            }
            cursor.close();
            db.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
        return liste;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        recyclerView = findViewById(R.id.recyclerView);
        adapter = new RecyclerViewAdapter(getApplicationContext(), tumVerileriCek());
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);
    }

}
