package com.aytekincomez.volleyloginandregister.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.aytekincomez.volleyloginandregister.Model.Paylasim;
import com.aytekincomez.volleyloginandregister.R;

import java.util.ArrayList;

public class PaylasimAdapter extends BaseAdapter {
    ArrayList<Paylasim> paylasimlar;
    LayoutInflater layoutInflater;

    public PaylasimAdapter(ArrayList<Paylasim> paylasimlar, Context context){
        this.layoutInflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        this.paylasimlar = paylasimlar;
    }

    @Override
    public int getCount() {
        return paylasimlar.size();
    }

    @Override
    public Object getItem(int position) {
        return paylasimlar.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = layoutInflater.inflate(R.layout.paylasim_satiri, null);

        TextView tvTarih = view.findViewById(R.id.tvTarih);
        TextView tvEmail = view.findViewById(R.id.tvEmail);
        TextView tvIcerik = view.findViewById(R.id.tvIcerik);

        tvTarih.setText(paylasimlar.get(position).getTarih());
        tvEmail.setText(paylasimlar.get(position).getPaylasanEmal());
        tvIcerik.setText(paylasimlar.get(position).getIcerik());

        return view;
    }
}
