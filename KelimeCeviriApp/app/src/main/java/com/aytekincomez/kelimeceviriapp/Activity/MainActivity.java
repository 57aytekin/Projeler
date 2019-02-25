package com.aytekincomez.kelimeceviriapp.Activity;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.aytekincomez.kelimeceviriapp.Database.DatabaseHelper;
import com.aytekincomez.kelimeceviriapp.R;

import java.io.IOException;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private String dil = "en";
    TextView tvBaslik;
    EditText etAranan;
    ImageView ivAra;
    ArrayAdapter arrayAdapter;
    DatabaseHelper databaseHelper;
    SQLiteDatabase db;
    ListView listView;

    public ArrayList<String> degerleriDondur(String aranan, String aranacakDil){
        ArrayList<String> list = new ArrayList();

        try {
            databaseHelper = new DatabaseHelper(this);
            db = databaseHelper.getReadableDatabase();

            Cursor c = null;
            if ("tr".equalsIgnoreCase(aranacakDil)){
                c = db.rawQuery("select * from Sozluk where tr_kelime='"+aranan+"'", null);
            }else if ("en".equalsIgnoreCase(aranacakDil)){
                c = db.rawQuery("select * from Sozluk where ing_kelime='"+aranan+"'", null);
            }

            while (c.moveToNext()){
                if ("tr".equalsIgnoreCase(aranacakDil)){
                    list.add(c.getString(c.getColumnIndex("ing_kelime")));
                }else if ("en".equalsIgnoreCase(aranacakDil)){
                    list.add(c.getString(c.getColumnIndex("tr_kelime")));
                }
            }
            c.close();
            db.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.nav_tr:
                    dil = "en";
                    tvBaslik.setText("Kelimenin Ingilizcesini Ara");
                    return true;
                case R.id.nav_eng:
                    tvBaslik.setText("Search for Turkish");
                    dil = "tr";
                    return true;
            }
            return false;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvBaslik = findViewById(R.id.tvBaslik);
        tvBaslik.setText("Kelimenin Ingilizcesini Ara");

        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);


        ivAra = findViewById(R.id.ivAra);
        etAranan = findViewById(R.id.etAranan);
        listView = findViewById(R.id.listView);

        ivAra.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                arrayAdapter = new ArrayAdapter(getApplicationContext(),
                        android.R.layout.simple_list_item_1,
                        degerleriDondur(etAranan.getText().toString(), dil));
                listView.setAdapter(arrayAdapter);
            }
        });
    }

}
