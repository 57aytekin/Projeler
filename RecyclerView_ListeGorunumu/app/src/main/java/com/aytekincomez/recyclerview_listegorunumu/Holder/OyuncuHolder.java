package com.aytekincomez.recyclerview_listegorunumu.Holder;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.aytekincomez.recyclerview_listegorunumu.R;

public class OyuncuHolder extends RecyclerView.ViewHolder {

    public ImageView ivOyuncuResim;
    public TextView tvOyuncuAdSoyad;
    public OyuncuHolder(@NonNull View itemView) {
        super(itemView);
        ivOyuncuResim = itemView.findViewById(R.id.ivOyuncuResim);
        tvOyuncuAdSoyad = itemView.findViewById(R.id.tvOyuncuAdSoyad);
    }
}
