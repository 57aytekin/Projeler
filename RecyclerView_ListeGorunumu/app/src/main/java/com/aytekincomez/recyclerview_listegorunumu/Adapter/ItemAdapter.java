package com.aytekincomez.recyclerview_listegorunumu.Adapter;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.aytekincomez.recyclerview_listegorunumu.Activity.DetayActivity;
import com.aytekincomez.recyclerview_listegorunumu.Holder.ItemHolder;
import com.aytekincomez.recyclerview_listegorunumu.Model.Film;
import com.aytekincomez.recyclerview_listegorunumu.R;
import com.bumptech.glide.Glide;

import java.util.List;

public class ItemAdapter extends RecyclerView.Adapter<ItemHolder> {
    private List<Film> filmList;

    public ItemAdapter(List<Film> filmList){
        this.filmList = filmList;
    }

    @NonNull
    @Override
    public ItemHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        //Satır görüntüsü layoutunu ireten metod
        View itemView = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.film_satir, null);
        return new ItemHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull final ItemHolder ıtemHolder, final int i) {
        //ItemHolder içerisinde tanımlanan nesnelerin  olaylarınıc yazıldığı metod
        Film film = filmList.get(i);
        ıtemHolder.tvAd.setText(film.getAd());
        ıtemHolder.tvTur.setText(film.getTuru());
        ıtemHolder.tvSure.setText(""+film.getSure());
        ıtemHolder.tvYonetmen.setText(film.getYonetmen());
        ıtemHolder.tvYapimci.setText(film.getYapimci());
        ıtemHolder.tvVizyonaGirisTarihi.setText(film.getVizyonaGirisTarihi());
        Glide.with(ıtemHolder.itemView.getContext())
                .load(film.getAfis())
                .into(ıtemHolder.ivAfis);

        ıtemHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), DetayActivity.class);
                intent.putExtra("film", filmList.get(i));
                v.getContext().startActivity(intent);

            }
        });
    }

    @Override
    public int getItemCount() {
        return filmList.size();
    }
}
