package com.aytekincomez.recyclerview_listegorunumu.Activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.widget.ImageView;
import android.widget.TextView;

import com.aytekincomez.recyclerview_listegorunumu.Adapter.OyuncuAdapter;
import com.aytekincomez.recyclerview_listegorunumu.Model.Film;
import com.aytekincomez.recyclerview_listegorunumu.Model.Oyuncu;
import com.aytekincomez.recyclerview_listegorunumu.R;
import com.bumptech.glide.Glide;

import java.util.List;

public class DetayActivity extends AppCompatActivity {

    TextView tvDetayAd, tvDetaySure, tvDetayTur, tvDetayYonetmen, tvDetayYapimci, tvDetayTarih;
    ImageView ivDetayAfis;
    RecyclerView recyclerView;
    OyuncuAdapter adapter;
    List<Oyuncu> oyuncular;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detay);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        tvDetayAd = findViewById(R.id.tvDetayAd);
        tvDetaySure = findViewById(R.id.tvDetaySure);
        tvDetayTur = findViewById(R.id.tvDetayTur);
        tvDetayYonetmen = findViewById(R.id.tvDetayYonetmen);
        tvDetayYapimci = findViewById(R.id.tvDetayYapimci);
        tvDetayTarih = findViewById(R.id.tvDetayTarih);
        ivDetayAfis = findViewById(R.id.ivDetayAfis);
        recyclerView = findViewById(R.id.DetayRecycler);

        Film film = (Film) getIntent().getSerializableExtra("film");

        oyuncular = film.getOyuncular();
        adapter = new OyuncuAdapter(oyuncular);

        LinearLayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);

        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(layoutManager);

        tvDetayAd.setText(film.getAd());
        tvDetaySure.setText(""+film.getSure());
        tvDetayTur.setText(film.getTuru());
        tvDetayYonetmen.setText(film.getYonetmen());
        tvDetayYapimci.setText(film.getYapimci());
        tvDetayTarih.setText(film.getYapimci());
        Glide.with(getApplicationContext())
                .load(film.getAfis())
                .into(ivDetayAfis);
    }
}
