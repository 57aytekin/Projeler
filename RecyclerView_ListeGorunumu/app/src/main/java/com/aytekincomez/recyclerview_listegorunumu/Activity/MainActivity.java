package com.aytekincomez.recyclerview_listegorunumu.Activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.aytekincomez.recyclerview_listegorunumu.Adapter.ItemAdapter;
import com.aytekincomez.recyclerview_listegorunumu.Model.Film;
import com.aytekincomez.recyclerview_listegorunumu.Model.Oyuncu;
import com.aytekincomez.recyclerview_listegorunumu.R;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    ItemAdapter adapter;
    List<Film> filmList;
    RecyclerView.LayoutManager layoutManager;
    ArrayList<Oyuncu> oyuncular;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        filmList = new ArrayList<>();
        listele();

        recyclerView = findViewById(R.id.recyclerView);
        adapter = new ItemAdapter(filmList);
        layoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
    }

    private void listele() {
        oyuncular.add(new Oyuncu(1,"Oktay Kaynarca",35,"https://www.haberler.com/trend/96/oktay-kaynarca_5532_186.jpg"));
        oyuncular.add(new Oyuncu(1,"Cem Yılmaz",40,"http://tr.web.img2.acsta.net/c_215_290/pictures/15/05/07/13/39/405251.jpg"));

        filmList.add(new Film(
               1,
               5,
               "11.12.2018",
               "http://cdn.filmlerim.com/mi/19/8T/ht6BM1R8bhDtuEWr8oWeCkCQRMnTjvEeNX3K00j0.jpeg",
                "İstanbul şehrinde Organize İşler tam gaz devam etmektedir. Sazanlar yem peşinde, oltalar Asım Noyan ve ekibinin elinde, daha büyük balıklar ise bu ekibin peşindedir.",
                "Komedi/Aksiyon",
                "Organize İşler Sazan Sarmalı",
                120,
                "Türkiye",
                oyuncular,
                "Yılmaz Erdoğan",
                "Yılmaz Erdoğan"
        ));
        filmList.add(new Film(
                1,
                5,
                "11.12.2018",
                "http://tr.web.img4.acsta.net/c_215_290/pictures/18/12/20/07/34/3519831.jpg",
                "İstanbul şehrinde Organize İşler tam gaz devam etmektedir. Sazanlar yem peşinde, oltalar Asım Noyan ve ekibinin elinde, daha büyük balıklar ise bu ekibin peşindedir.",
                "Aksiyon",
                "Can Dostlar",
                120,
                "Türkiye",
                oyuncular,
                "Yılmaz Erdoğan",
                "Yılmaz Erdoğan"
        ));
    }
}
