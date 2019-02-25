package com.aytekincomez.verileriokumayazmayontemleri.Adapter;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.aytekincomez.verileriokumayazmayontemleri.Model.Ogrenci;
import com.aytekincomez.verileriokumayazmayontemleri.R;

import java.util.ArrayList;

public class ListViewAdapter extends BaseAdapter {
    ArrayList<Ogrenci> ogrenciler;
    Context context;
    LayoutInflater layoutInflater;

    public ListViewAdapter(Activity activity, ArrayList<Ogrenci> ogrenciler) {
        this.context = activity;
        this.ogrenciler = ogrenciler;
        this.layoutInflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
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
        View view = layoutInflater.inflate(R.layout.ozel_listview_gorunum, null);

        TextView tvOgrenciNo = (TextView)view.findViewById(R.id.tvOgrenciNo);
        TextView tvOgrenciAd = (TextView)view.findViewById(R.id.tvOgrenciAd);
        TextView tvOgrenciSoyad = (TextView)view.findViewById(R.id.tvOgrenciSoyad);
        TextView tvOgrenciOkul = (TextView)view.findViewById(R.id.tvOgrenciOkul);

        tvOgrenciNo.setText("" + ogrenciler.get(position).getOgrenciNo());
        tvOgrenciAd.setText(ogrenciler.get(position).getAd());
        tvOgrenciSoyad.setText(ogrenciler.get(position).getSoyad());
        tvOgrenciOkul.setText(ogrenciler.get(position).getUniversite());

        return view;
    }
}
