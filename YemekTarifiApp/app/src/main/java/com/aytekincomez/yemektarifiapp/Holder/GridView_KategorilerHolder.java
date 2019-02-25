package com.aytekincomez.yemektarifiapp.Holder;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.aytekincomez.yemektarifiapp.R;

public class GridView_KategorilerHolder extends RecyclerView.ViewHolder {

    Context context;
    public ImageView ivKategoriResim;
    public TextView tvKategoriBaslik;
    public TextView tvKategoriSayi;

    public GridView_KategorilerHolder(@NonNull View itemView) {
        super(itemView);
        context = itemView.getContext();
        ivKategoriResim = itemView.findViewById(R.id.ivKategoriResim);
        tvKategoriBaslik = itemView.findViewById(R.id.tvKategoriBaslik);
        tvKategoriSayi = itemView.findViewById(R.id.tvKategoriSayi);

        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }
}
