package com.aytekincomez.imsakiyeapp.Holder;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.aytekincomez.imsakiyeapp.R;

public class RecyclerViewHolder extends RecyclerView.ViewHolder {
    Context context;
    public TextView tvSabah, tvOgle, tvIkindi, tvAksam, tvYatsi, tvImsak, tvGunes, tvTarih;

    public RecyclerViewHolder(@NonNull final View itemView) {
        super(itemView);
        context = itemView.getContext();

        tvTarih = itemView.findViewById(R.id.tvTarih);
        tvOgle = itemView.findViewById(R.id.tvOglen);
        tvSabah = itemView.findViewById(R.id.tvSabah);
        tvIkindi = itemView.findViewById(R.id.tvIkindi);
        tvAksam = itemView.findViewById(R.id.tvAksam);
        tvYatsi = itemView.findViewById(R.id.tvYatsi);
        tvImsak = itemView.findViewById(R.id.tvImsak);
        tvGunes = itemView.findViewById(R.id.tvGunes);
    }
}
