package com.aytekincomez.adapterkullanimivecustomlistview.Activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import com.aytekincomez.adapterkullanimivecustomlistview.Adapter.MyAdapter;
import com.aytekincomez.adapterkullanimivecustomlistview.Model.Unluler;
import com.aytekincomez.adapterkullanimivecustomlistview.R;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ListView liste;
    MyAdapter myAdapter;
    ArrayList<Unluler> unluler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        liste = findViewById(R.id.listView);
        unluler = new ArrayList<>();
        myAdapter = new MyAdapter(this, unluler);

        unluler.add(new Unluler(50,"Cem","Yilmaz","cemyilmaz"));
        unluler.add(new Unluler(50,"Kenan","İmirzalioğlu","kenan"));
        unluler.add(new Unluler(50,"Beren","Saat","berensaat"));

        liste.setAdapter(myAdapter);
    }
}
