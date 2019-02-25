package com.aytekincomez.websitegoruntuleyici.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.aytekincomez.websitegoruntuleyici.Model.HaberSiteleri;
import com.aytekincomez.websitegoruntuleyici.R;

import java.util.ArrayList;

public class ListViewHaberlerAdapter extends BaseAdapter {
    Context context;
    ArrayList<HaberSiteleri> haberSiteleris;
    LayoutInflater layoutInflater;

    public ListViewHaberlerAdapter(Context context, ArrayList<HaberSiteleri> haberSiteleris){
        this.context = context;
        this.haberSiteleris = haberSiteleris;
        layoutInflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return haberSiteleris.size();
    }

    @Override
    public Object getItem(int position) {
        return haberSiteleris.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = layoutInflater.inflate(R.layout.custom_listview_haber_row, null);
        TextView tvWebSiteAdi = (TextView)view.findViewById(R.id.tvWebSiteAdi);
        TextView tvHaberSiteUrl = (TextView)view.findViewById(R.id.tvHaberSiteUrl);
        TextView tvHaberCokluYazar = (TextView)view.findViewById(R.id.tvHaberCokluYazar);

        tvWebSiteAdi.setText(haberSiteleris.get(position).getWebSiteAdi());
        tvHaberSiteUrl.setText(haberSiteleris.get(position).getWebSiteUrl());

        if(haberSiteleris.get(position).isCokluYazar()){
            tvHaberCokluYazar.setText("Çoklu Yazar");
        }else{
            tvHaberCokluYazar.setText("Çoklu Yazar Degil");
        }

        return view;
    }
}
