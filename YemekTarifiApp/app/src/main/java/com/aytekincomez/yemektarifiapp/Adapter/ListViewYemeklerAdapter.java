package com.aytekincomez.yemektarifiapp.Adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.aytekincomez.yemektarifiapp.Activity.YemekDetayActivity;
import com.aytekincomez.yemektarifiapp.Model.Yemekler;
import com.aytekincomez.yemektarifiapp.R;
import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class ListViewYemeklerAdapter extends BaseAdapter {
    private Context context;
    private ArrayList<Yemekler> yemekler;
    private LayoutInflater layoutInflater;

    public  ListViewYemeklerAdapter(Context context, ArrayList<Yemekler> yemekler){
        this.context = context;
        this.yemekler = yemekler;
        this.layoutInflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }
    @Override
    public int getCount() {
        return yemekler.size();
    }

    @Override
    public Object getItem(int position) {
        return yemekler.get(position);
    }

    @Override
    public long getItemId(int position) {
        return yemekler.get(position).getId();
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        View view = layoutInflater.inflate(R.layout.ozel_listview_satir, null);
        ImageView ivYemekResim = view.findViewById(R.id.ivYemekResim);
        TextView tvYemekBaslik = view.findViewById(R.id.tvYemekBaslik);
        TextView tvYemekPisirmSuresi = view.findViewById(R.id.tvYemekPisirmeSuresi);
        TextView tvYemekHazirlamaSuresi = view.findViewById(R.id.tvYemekHazirlamaSuresi);
        TextView tvYemekKisiSayisi = view.findViewById(R.id.tvYemekKisiSayisi);

        tvYemekBaslik.setText(yemekler.get(position).getYemek_adi());
        tvYemekPisirmSuresi.setText(""+yemekler.get(position).getPisirme_suresi());
        tvYemekHazirlamaSuresi.setText(""+yemekler.get(position).getHazirlama_suresi());
        tvYemekKisiSayisi.setText(""+yemekler.get(position).getKisi_sayisi());

        final int id = view.getResources().getIdentifier(yemekler.get(position).getResim_konumu(),"drawable",context.getPackageName());

        Glide.with(context).load(id).into(ivYemekResim);
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, YemekDetayActivity.class);
                intent.putExtra("yemek",yemekler.get(position));
                context.startActivity(intent);
            }
        });

        return view;
    }
}
