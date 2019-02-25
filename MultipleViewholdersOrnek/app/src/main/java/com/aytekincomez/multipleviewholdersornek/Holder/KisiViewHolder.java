package com.aytekincomez.multipleviewholdersornek.Holder;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.aytekincomez.multipleviewholdersornek.Model.Kisi;
import com.aytekincomez.multipleviewholdersornek.R;

public class KisiViewHolder extends RecyclerView.ViewHolder {

    private ImageView ımageView;
    private TextView tvAdSoyad, tvYas;

    public KisiViewHolder(@NonNull View itemView) {
        super(itemView);
        ımageView = itemView.findViewById(R.id.imageView);
        tvAdSoyad = itemView.findViewById(R.id.tvAdSoyad);
        tvYas = itemView.findViewById(R.id.tvYas);
    }

    public void showKisiDetails(Kisi kisi){
        String adSoyad = kisi.getAdSoyad();
        int yas = kisi.getYas();
        int resim = kisi.getResimId();

        tvAdSoyad.setText(adSoyad);
        tvYas.setText(""+yas);
        ımageView.setImageResource(resim);

    }
}
