package com.aytekincomez.multipleviewholdersornek.Adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.aytekincomez.multipleviewholdersornek.Holder.KisiViewHolder;
import com.aytekincomez.multipleviewholdersornek.Holder.ReklamViewHolder;
import com.aytekincomez.multipleviewholdersornek.Model.Kisi;
import com.aytekincomez.multipleviewholdersornek.Model.Reklam;
import com.aytekincomez.multipleviewholdersornek.R;

import java.util.List;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private List<Object> list;
    private Context context;
    private static final int TIP_KISI = 1;
    private static final int  TIP_REKLAM = 2;

    public RecyclerViewAdapter(List<Object> list, Context context) {
        this.list = list;
        this.context = context;
    }

    public void setKisiFeed(List<Object> list){
        this.list = list;
    }

    @Override
    public int getItemViewType(int position) {
        if(list.get(position) instanceof Kisi){
            return TIP_KISI;
        }else if (list.get(position) instanceof Reklam){
            return TIP_REKLAM;
        }
        return -1;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        int layout = 0;
        RecyclerView.ViewHolder viewHolder;

        switch (i){
            case TIP_KISI:
                layout = R.layout.layout_kisi;
                View kisiView = LayoutInflater.from(viewGroup.getContext()).inflate(layout,  viewGroup, false);
                viewHolder = new KisiViewHolder(kisiView);
                break;
            case TIP_REKLAM:
                layout = R.layout.layout_reklam;
                View reklamView = LayoutInflater.from(viewGroup.getContext()).inflate(layout, viewGroup, false);
                viewHolder = new ReklamViewHolder(reklamView);
                break;
                default:
                    viewHolder = null;
        }
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i) {
        int viewType = viewHolder.getItemViewType();
        switch (viewType){
            case TIP_KISI:
                Kisi kisi = (Kisi) list.get(i);
                ((KisiViewHolder)viewHolder).showKisiDetails(kisi);
                break;
            case TIP_REKLAM:
                Reklam reklam = (Reklam) list.get(i);
                ((ReklamViewHolder)viewHolder).showReklamDetails(reklam);
                break;
        }
    }

    @Override
    public int getItemCount() {
        return list.size();
    }
}
