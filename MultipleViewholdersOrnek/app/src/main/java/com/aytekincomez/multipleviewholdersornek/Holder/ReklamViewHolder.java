package com.aytekincomez.multipleviewholdersornek.Holder;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.aytekincomez.multipleviewholdersornek.Model.Reklam;
import com.aytekincomez.multipleviewholdersornek.R;

public class ReklamViewHolder extends RecyclerView.ViewHolder {

    private TextView tvReklam;

    public ReklamViewHolder(@NonNull View itemView) {
        super(itemView);
        tvReklam = itemView.findViewById(R.id.tvReklam);
    }

    public void showReklamDetails(Reklam reklam){
        String reklamlar = reklam.getReklamIcerik();
        tvReklam.setText(reklamlar);
    }
}
