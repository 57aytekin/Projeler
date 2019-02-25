package com.aytekincomez.adapterkullanimivecustomlistview.Adapter;

import android.app.Activity;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.aytekincomez.adapterkullanimivecustomlistview.Activity.MainActivity;
import com.aytekincomez.adapterkullanimivecustomlistview.Model.Unluler;
import com.aytekincomez.adapterkullanimivecustomlistview.R;

import java.util.ArrayList;

public class MyAdapter extends BaseAdapter {
    Context context;
    ArrayList<Unluler> unluler;
    LayoutInflater layoutInflater;

    public MyAdapter(Activity activity, ArrayList<Unluler> kisiler){
        this.context = activity;
        this.unluler = kisiler;
        this.layoutInflater =
                (LayoutInflater)context.getSystemService(Service.LAYOUT_INFLATER_SERVICE);
    }
    @Override
    public int getCount() {
        return unluler.size();
    }

    @Override
    public Object getItem(int position) {
        return unluler.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = layoutInflater.inflate(R.layout.unluler_satir_gorunumu, null);
        TextView tvAd = (TextView)view.findViewById(R.id.tvAd);
        TextView tvSoyad = (TextView)view.findViewById(R.id.tvSoyad);
        TextView tvYas = (TextView)view.findViewById(R.id.tvYas);
        ImageView ivResim = (ImageView)view.findViewById(R.id.imageView2);

        tvAd.setText(unluler.get(position).getAd());
        tvSoyad.setText(unluler.get(position).getSoyad());
        tvYas.setText(unluler.get(position).getYas());

        int id = context.getResources().getIdentifier(unluler.get(position).getResim(),"drawable",
                                                        context.getPackageName());

        ivResim.setImageResource(id);

        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                context.startActivity(new Intent(context, MainActivity.class).putExtra("sayi",1));
            }
        });

        return view;
    }
}
