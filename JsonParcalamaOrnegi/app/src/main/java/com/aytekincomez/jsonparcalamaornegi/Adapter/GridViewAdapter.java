package com.aytekincomez.jsonparcalamaornegi.Adapter;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.aytekincomez.jsonparcalamaornegi.Model.Ogrenci;
import com.aytekincomez.jsonparcalamaornegi.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class GridViewAdapter extends BaseAdapter {
    LayoutInflater layoutInflater;
    Context context;
    ArrayList<Ogrenci> ogrenciler;

    public GridViewAdapter(Activity activity, ArrayList<Ogrenci> ogrenciler) {
        this.ogrenciler = ogrenciler;
        this.context = activity;
        this.layoutInflater = (LayoutInflater) activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return ogrenciler.size();
    }

    @Override
    public Object getItem(int position) {
        return ogrenciler.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        context = parent.getContext();

        View view = layoutInflater.inflate(R.layout.custom_grid_gorunumu,null);
        ImageView ivResim = (ImageView)view.findViewById(R.id.ivResim);
        TextView tvAd = (TextView)view.findViewById(R.id.tvAd);
        TextView tvSoyad = (TextView)view.findViewById(R.id.tvSoyad);
        TextView tvBolum = (TextView)view.findViewById(R.id.tvBolum);

        tvAd.setText(ogrenciler.get(position).getOgrenciAdi());
        tvSoyad.setText(ogrenciler.get(position).getOgrenciSoyad());
        tvBolum.setText(ogrenciler.get(position).getBolumAdi());

        Picasso.with(context).load(ogrenciler.get(position).getOgrenciResim())
                .into(ivResim);


        return view;
    }
}
