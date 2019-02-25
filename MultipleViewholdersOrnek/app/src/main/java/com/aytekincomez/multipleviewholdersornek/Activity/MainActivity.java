package com.aytekincomez.multipleviewholdersornek.Activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.animation.AnimationUtils;
import android.view.animation.LayoutAnimationController;

import com.aytekincomez.multipleviewholdersornek.Adapter.RecyclerViewAdapter;
import com.aytekincomez.multipleviewholdersornek.Model.Kisi;
import com.aytekincomez.multipleviewholdersornek.Model.Reklam;
import com.aytekincomez.multipleviewholdersornek.R;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private LinearLayoutManager linearLayoutManager;
    private List<Object> list;
    private RecyclerViewAdapter recyclerViewAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerView);
        linearLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setHasFixedSize(true);
        init();
    }

    private void init() {
        list = new ArrayList<>();
        recyclerViewAdapter = new RecyclerViewAdapter(list, getApplicationContext());
        recyclerView.setAdapter(recyclerViewAdapter);

        list.add(new Kisi(R.drawable.resim1,24,"Beyazıt Özturk"));
        list.add(new Kisi(R.drawable.resim2,30,"Mustafa Sandal"));
        list.add(new Kisi(R.drawable.resim3,31,"Kemal Sunal"));
        list.add(new Reklam(1,"Bu bir reklamdır"));
        list.add(new Kisi(R.drawable.resim4,31,"Cem Yılmaz"));

        int resId = R.anim.layout_animation_fall_down;
        LayoutAnimationController animation = AnimationUtils.loadLayoutAnimation(getApplicationContext(), resId);
        recyclerView.setLayoutAnimation(animation);
        recyclerView.scheduleLayoutAnimation();

        recyclerViewAdapter.setKisiFeed(list);
        recyclerViewAdapter.notifyDataSetChanged();
    }
}
