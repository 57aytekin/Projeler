package com.aytekincomez.xmlparser.Adapter;

import android.app.Activity;
import android.content.Context;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.aytekincomez.xmlparser.Model.Kurs;
import com.aytekincomez.xmlparser.R;

import java.util.ArrayList;

public class MyAdapter extends BaseAdapter {
    Context context;
    ArrayList<Kurs> kurslar;
    LayoutInflater layoutInflater;

    public MyAdapter(Activity activity, ArrayList<Kurs> kurslar){
        this.context = activity;
        this.kurslar = kurslar;
        this.layoutInflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }
    @Override
    public int getCount() {
        return kurslar.size();
    }

    @Override
    public Kurs getItem(int position) {
        return kurslar.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = layoutInflater.inflate(R.layout.kurs_gorunumu,null);

        TextView tvAd = (TextView)view.findViewById(R.id.tvAd);
        TextView tvSaat = (TextView)view.findViewById(R.id.tvSaatSayisi);
        TextView tvKontenjan = (TextView)view.findViewById(R.id.tvKontenjan);
        TextView tvEgitmen = (TextView)view.findViewById(R.id.tvEgitmen);

        tvAd.setText(Html.fromHtml("<br>Kurs Adi:</br>"+kurslar.get(position).getAd()));
        tvEgitmen.setText(Html.fromHtml("<br>Egitmen:</br>"+kurslar.get(position).getEgitmen()));
        tvKontenjan.setText(
                Html.fromHtml("<br>Kontenjan:</br>"+""+kurslar.get(position).getKontenjanSayisi()));
        tvSaat.setText(Html.fromHtml("<br>Saat Sayisi:</br>"+""+kurslar.get(position).getSaatSayisi()));
        return view;
    }
}
