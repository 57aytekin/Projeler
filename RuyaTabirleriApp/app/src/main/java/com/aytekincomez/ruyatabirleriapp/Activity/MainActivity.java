package com.aytekincomez.ruyatabirleriapp.Activity;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import com.aytekincomez.ruyatabirleriapp.Adapter.ListeAdapter;
import com.aytekincomez.ruyatabirleriapp.Database.DatabaseHelper;
import com.aytekincomez.ruyatabirleriapp.Model.RuyaTabirleri;
import com.aytekincomez.ruyatabirleriapp.R;

import java.io.IOException;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ListView liste;
    ListeAdapter listeAdapter;
    ArrayList<RuyaTabirleri> ruyaTabirleri;
    DatabaseHelper databaseHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        liste = (ListView)findViewById(R.id.liste);

        ruyaTabirleri = new ArrayList<>();
        //ruyaTabirleri.add(new RuyaTabirleri(1, "baslik","aciklama","resim"));
        SQLiteDatabase db;
        Cursor c;

        try {
            databaseHelper = new DatabaseHelper(getApplicationContext());
            databaseHelper.createDatabase();
            db = databaseHelper.getReadableDatabase();

            c = db.rawQuery("select * from Tabirler order by id desc", null);

            while (c.moveToNext()){
                ruyaTabirleri.add(
                        new RuyaTabirleri(
                                c.getInt(0),
                                c.getString(1),
                                c.getString(2),
                                c.getString(3)
                        )
                );
            }
        }catch (IOException e){

        }

        listeAdapter = new ListeAdapter(this, ruyaTabirleri );
        liste.setAdapter(listeAdapter);
    }
}
