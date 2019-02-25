package com.aytekincomez.ruyatabirleriapp.Activity;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.GridView;

import com.aytekincomez.ruyatabirleriapp.Adapter.GridViewAdapter;
import com.aytekincomez.ruyatabirleriapp.Database.DatabaseHelper;
import com.aytekincomez.ruyatabirleriapp.Model.Tabir;
import com.aytekincomez.ruyatabirleriapp.R;

import java.io.IOException;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    GridView gridView;
    DatabaseHelper databaseHelper;
    SQLiteDatabase db;
    GridViewAdapter adapter;


    public ArrayList<Tabir> verileriCek(){
        ArrayList<Tabir> tabir = new ArrayList<>();
        Cursor c = db.rawQuery("select * from Tabirler",null);

        while (c.moveToNext()){
            int id = c.getInt(c.getColumnIndex("id"));
            String baslik = c.getString(c.getColumnIndex("baslik"));
            String icerik = c.getString(c.getColumnIndex("icerik"));
            String resim_url = c.getString(c.getColumnIndex("resim_url"));
            tabir.add(new Tabir(id, baslik, icerik, resim_url));
        }
        c.close();
        db.close();

        return tabir;
    }

    @Override
    protected void onResume() {
        super.onResume();
        try {
            databaseHelper = new DatabaseHelper(getApplicationContext());
            db = databaseHelper.getReadableDatabase();
            adapter = new GridViewAdapter(this, verileriCek());
            gridView.setAdapter(adapter);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        gridView = findViewById(R.id.gridView);

        try {
            databaseHelper = new DatabaseHelper(this);
            db = databaseHelper.getReadableDatabase();
            adapter = new GridViewAdapter(this, verileriCek());
            gridView.setAdapter(adapter);

        } catch (IOException e) {
            e.printStackTrace();
        }

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
