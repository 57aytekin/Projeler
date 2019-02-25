package com.aytekincomez.recyclerview_searchview.Holder;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.aytekincomez.recyclerview_searchview.R;

public class UlkeHolder extends RecyclerView.ViewHolder {

    public ImageView ivUlkeBayrak;
    public TextView tvUlkeAd, tvBaskent, tvKurulus, tvTelKodu;

    public UlkeHolder(@NonNull View itemView) {
        super(itemView);
        tvUlkeAd = itemView.findViewById(R.id.tvUlkeAd);
        tvBaskent = itemView.findViewById(R.id.tvBaskent);
        tvKurulus = itemView.findViewById(R.id.tvKurulus);
        tvTelKodu = itemView.findViewById(R.id.tvTelKodu);
        ivUlkeBayrak = itemView.findViewById(R.id.ivUlkeBayrak);
    }
}
