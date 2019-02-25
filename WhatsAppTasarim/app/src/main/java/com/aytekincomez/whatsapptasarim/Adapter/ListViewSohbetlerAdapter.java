package com.aytekincomez.whatsapptasarim.Adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.aytekincomez.whatsapptasarim.Activity.ChatActivity;
import com.aytekincomez.whatsapptasarim.Model.Sohbetler;
import com.aytekincomez.whatsapptasarim.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class ListViewSohbetlerAdapter extends BaseAdapter {
    Context context;
    ArrayList<Sohbetler> sohbetler;
    LayoutInflater layoutInflater;

    public ListViewSohbetlerAdapter(Context context, ArrayList<Sohbetler> sohbetler){
        this.context = context;
        this.sohbetler = sohbetler;
        this.layoutInflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return sohbetler.size();
    }

    @Override
    public Object getItem(int position) {
        return sohbetler.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        final View view = layoutInflater.inflate(R.layout.listview_sohbet_gorunum, null);
        ImageView ivSohbetResim = (ImageView)view.findViewById(R.id.ivSohbetResim);
        final TextView tvSohbetAdSoyad = (TextView)view.findViewById(R.id.tvSohbetAdSoyad);
        TextView tvSohbetAciklama = (TextView)view.findViewById(R.id.tvSohbetAciklama);
        TextView tvSohbetTarih = (TextView)view.findViewById(R.id.tvSohbetTarih);
        Picasso.with(context).load(sohbetler.get(position).getResimUrl()).into(ivSohbetResim);

        tvSohbetAdSoyad.setText(sohbetler.get(position).getAdSoyad());
        tvSohbetAciklama.setText(sohbetler.get(position).getAciklama());
        tvSohbetTarih.setText(sohbetler.get(position).getTarih());


        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(view.getContext(), ChatActivity.class);
                intent.putExtra("adsoyad", sohbetler.get(position).getAdSoyad());
                intent.putExtra("userid", sohbetler.get(position).getId());
                context.startActivity(intent);
            }
        });


        return view;
    }
}
