package com.aytekincomez.jsonparseonlinetv.Adapter;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.aytekincomez.jsonparseonlinetv.Model.Kanal;
import com.aytekincomez.jsonparseonlinetv.R;

import java.util.ArrayList;

public class MyAdapter extends BaseAdapter{
    Context context;
    ArrayList<Kanal> kanallar;
    LayoutInflater layoutInflater;

    public MyAdapter(Activity activity, ArrayList<Kanal> kanallar){
        this.context = activity;
        this.kanallar = kanallar;
        this.layoutInflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }
    @Override
    public int getCount() {
        return kanallar.size();
    }

    @Override
    public Kanal getItem(int position) {
        return kanallar.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = layoutInflater.inflate(R.layout.kanal_list_gorunumu, null);

        ImageView ivResim = (ImageView)view.findViewById(R.id.ivResim);
        TextView tvBaslik = (TextView)view.findViewById(R.id.tvBaslik);
        TextView tvAciklama = (TextView)view.findViewById(R.id.tvAciklama);

        tvBaslik.setText(kanallar.get(position).getKanalAdi());
        tvAciklama.setText(kanallar.get(position).getKanalAciklama());

        return view;
    }
}
