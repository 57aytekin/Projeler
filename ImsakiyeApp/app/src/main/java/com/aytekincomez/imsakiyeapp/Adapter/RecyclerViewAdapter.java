package com.aytekincomez.imsakiyeapp.Adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.aytekincomez.imsakiyeapp.Holder.RecyclerViewHolder;
import com.aytekincomez.imsakiyeapp.Model.Imsakiye;
import com.aytekincomez.imsakiyeapp.R;

import java.util.ArrayList;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewHolder> {
    private Context context;
    private ArrayList<Imsakiye> liste;
    private LayoutInflater layoutInflater;

    public RecyclerViewAdapter(Context context, ArrayList<Imsakiye> liste){
        this.context = context;
        this.liste = liste;
    }

    @NonNull
    @Override
    public RecyclerViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.imsakiye_satir_gorunumu, null);

        RecyclerViewHolder holder = new RecyclerViewHolder(view);
        return holder;
        //satir görüntüsü onCreateView de olusturulur.
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerViewHolder recyclerViewHolder, int position) {
        //Nesnelerin olaylarının tanımlamdıgı yer
        recyclerViewHolder.tvTarih.setText(liste.get(position).getTarih());
        recyclerViewHolder.tvSabah.setText(liste.get(position).getSabah());
        recyclerViewHolder.tvOgle.setText(liste.get(position).getOglen());
        recyclerViewHolder.tvIkindi.setText(liste.get(position).getIkindi());
        recyclerViewHolder.tvAksam.setText(liste.get(position).getAksam());
        recyclerViewHolder.tvYatsi.setText(liste.get(position).getYatsi());
        recyclerViewHolder.tvImsak.setText(liste.get(position).getImsak());
        recyclerViewHolder.tvGunes.setText(liste.get(position).getGunes());
    }

    @Override
    public int getItemCount() {
        return liste.size();
    }

    @Override
    public long getItemId(int position) {
        return liste.get(position).getId();
    }
}
