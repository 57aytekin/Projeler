package com.aytekincomez.whatsapptasarim.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.aytekincomez.whatsapptasarim.Model.Durumlar;
import com.aytekincomez.whatsapptasarim.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import de.hdodenhof.circleimageview.CircleImageView;

public class GridViewDurumlarAdapter extends BaseAdapter {
    private ArrayList<Durumlar> durumlar;
    Context context;
    LayoutInflater layoutInflater;

    public GridViewDurumlarAdapter(Context context, ArrayList<Durumlar> durumlar){
        this.context = context;
        this.durumlar = durumlar;
        this.layoutInflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return durumlar.size();
    }

    @Override
    public Object getItem(int position) {
        return durumlar.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = layoutInflater.inflate(R.layout.custom_durumlar_gorunum, null);

        CircleImageView ivResim = (CircleImageView)view.findViewById(R.id.ivCustomDurumlarResim);
        TextView tvAdSoyad = (TextView)view.findViewById(R.id.tvCustomDurumlarAdSoyad);
        TextView tvZaman = (TextView)view.findViewById(R.id.tvCustomDurumlarZaman);

        Picasso.with(context).load(durumlar.get(position).getResimUrl()).into(ivResim);
        tvAdSoyad.setText(durumlar.get(position).getAdSoyad());
        tvZaman.setText(durumlar.get(position).getPaylasimZamani());

        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        return view;
    }
}
