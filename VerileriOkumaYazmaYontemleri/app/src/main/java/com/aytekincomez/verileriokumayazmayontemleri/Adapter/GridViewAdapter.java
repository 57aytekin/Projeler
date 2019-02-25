package com.aytekincomez.verileriokumayazmayontemleri.Adapter;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.aytekincomez.verileriokumayazmayontemleri.Model.Haber;
import com.aytekincomez.verileriokumayazmayontemleri.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class GridViewAdapter extends BaseAdapter {

    ArrayList<Haber> haberler;
    Context context;
    LayoutInflater layoutInflater;

    public GridViewAdapter(Activity activity, ArrayList<Haber> haberler){
        this.context = activity;
        this.haberler = haberler;
        this.layoutInflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return haberler.size();
    }

    @Override
    public Object getItem(int position) {
        return haberler.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = layoutInflater.inflate(R.layout.ozel_gridview_gorunumu,null);

        ImageView ivResim = (ImageView)view.findViewById(R.id.ivResim);
        TextView tvBaslik= (TextView) view.findViewById(R.id.tvBaslik);

        tvBaslik.setText(haberler.get(position).getHaberAdi());
        Picasso.with(view.getContext())
                .load(haberler.get(position).getHaberUrl())
                .into(ivResim);

        return view;
    }
}
