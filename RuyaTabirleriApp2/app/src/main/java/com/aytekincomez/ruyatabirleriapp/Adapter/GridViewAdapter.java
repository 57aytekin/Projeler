package com.aytekincomez.ruyatabirleriapp.Adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.aytekincomez.ruyatabirleriapp.Activity.DetayActivity;
import com.aytekincomez.ruyatabirleriapp.Model.Tabir;
import com.aytekincomez.ruyatabirleriapp.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class GridViewAdapter extends BaseAdapter {
    private Context context;
    private ArrayList<Tabir> tabir;
    private LayoutInflater layoutInflater;

    public GridViewAdapter(Context context, ArrayList<Tabir> tabir){
        this.context = context;
        this.tabir = tabir;
        layoutInflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return tabir.size();
    }

    @Override
    public Object getItem(int position) {
        return tabir.get(position);
    }

    @Override
    public long getItemId(int position) {
        return tabir.get(position).getId();
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        View view = layoutInflater.inflate(R.layout.gridview_satir_gorunumu, null);
        ImageView ivResim = view.findViewById(R.id.imageView);
        TextView tvBaslik = view.findViewById(R.id.textView2);

        Picasso.with(context).load(tabir.get(position).getResim_url()).into(ivResim);
        tvBaslik.setText(tabir.get(position).getBaslik());

        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, DetayActivity.class);
                intent.putExtra("model",tabir.get(position));
                context.startActivity(intent);
            }
        });

        return view;
    }
}
