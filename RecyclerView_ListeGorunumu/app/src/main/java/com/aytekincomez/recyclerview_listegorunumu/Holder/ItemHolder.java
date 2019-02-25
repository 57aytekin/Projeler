package com.aytekincomez.recyclerview_listegorunumu.Holder;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.aytekincomez.recyclerview_listegorunumu.R;

public class ItemHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

    public TextView tvAd, tvTur, tvVizyonaGirisTarihi, tvYonetmen, tvYapimci, tvSure;
    public ImageView ivAfis;

    public ItemHolder(@NonNull View itemView) {
        super(itemView);
        tvAd = itemView.findViewById(R.id.tvAd);
        tvTur = itemView.findViewById(R.id.tvTur);
        tvVizyonaGirisTarihi = itemView.findViewById(R.id.tvVizyonaGiris);
        tvYonetmen = itemView.findViewById(R.id.tvYonetmen);
        tvYapimci = itemView.findViewById(R.id.tvYapimci);
        tvSure = itemView.findViewById(R.id.tvSure);
        ivAfis = itemView.findViewById(R.id.ivAfis);
        itemView.setOnClickListener(this);


    }


    @Override
    public void onClick(View v) {

    }
}
