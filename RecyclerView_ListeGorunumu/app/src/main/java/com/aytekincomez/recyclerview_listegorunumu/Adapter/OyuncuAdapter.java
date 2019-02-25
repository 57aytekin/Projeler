package com.aytekincomez.recyclerview_listegorunumu.Adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.aytekincomez.recyclerview_listegorunumu.Holder.OyuncuHolder;
import com.aytekincomez.recyclerview_listegorunumu.Model.Oyuncu;
import com.aytekincomez.recyclerview_listegorunumu.R;
import com.bumptech.glide.Glide;

import java.util.List;

public class OyuncuAdapter extends RecyclerView.Adapter<OyuncuHolder> {
    List<Oyuncu> oyuncular;

    public OyuncuAdapter(List<Oyuncu> oyuncular){
        this.oyuncular = oyuncular;
    }

    @NonNull
    @Override
    public OyuncuHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.film_satiri, null);
        return new OyuncuHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull OyuncuHolder oyuncuHolder, int i) {
        oyuncuHolder.tvOyuncuAdSoyad.setText(oyuncular.get(i).getAdsoyad());
        Glide.with(oyuncuHolder.itemView.getContext())
                .load(oyuncular.get(i).getResim())
                .into(oyuncuHolder.ivOyuncuResim);
    }

    @Override
    public int getItemCount() {
        return oyuncular.size();
    }
}
