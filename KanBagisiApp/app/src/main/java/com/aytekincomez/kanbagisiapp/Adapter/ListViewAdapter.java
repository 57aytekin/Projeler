package com.aytekincomez.kanbagisiapp.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.aytekincomez.kanbagisiapp.Model.NewIlan;
import com.aytekincomez.kanbagisiapp.R;

import java.util.ArrayList;

public class ListViewAdapter extends BaseAdapter {
    Context context;
    ArrayList<NewIlan> arananKanSatirs;
    LayoutInflater layoutInflater;

    public ListViewAdapter(Context context, ArrayList<NewIlan> arananKanSatirs){
        this.context = context;
        this.arananKanSatirs = arananKanSatirs;
        layoutInflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return arananKanSatirs.size();
    }

    @Override
    public Object getItem(int position) {
        return arananKanSatirs.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = layoutInflater.inflate(R.layout.custom_listview_aranankan, null);
        TextView tvAd = (TextView)view.findViewById(R.id.tvArananKanAdSoyad);
        TextView tvKanGrubu = (TextView)view.findViewById(R.id.tvArananKanGrub);
        TextView tvYer = (TextView)view.findViewById(R.id.tvArananKanMekan);
        TextView tvZaman = (TextView)view.findViewById(R.id.tvArananKanZaman);

        tvAd.setText(arananKanSatirs.get(position).getAd());
        tvKanGrubu.setText(arananKanSatirs.get(position).getKangurubu());
        tvYer.setText(arananKanSatirs.get(position).getIl());
        tvZaman.setText(arananKanSatirs.get(position).getHastaneAdi());

        return view;
    }
}
