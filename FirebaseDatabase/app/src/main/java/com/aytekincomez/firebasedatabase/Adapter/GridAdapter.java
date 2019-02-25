package com.aytekincomez.firebasedatabase.Adapter;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.aytekincomez.firebasedatabase.Model.User;
import com.aytekincomez.firebasedatabase.R;

import java.util.ArrayList;

public class GridAdapter extends BaseAdapter {
    ArrayList<User> users;
    LayoutInflater layoutInflater;
    Context context;

    public GridAdapter(Activity activity, ArrayList<User> users){
        this.context = activity;
        this.users = users;
        this.layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return users.size();
    }

    @Override
    public Object getItem(int position) {
        return users.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = layoutInflater.inflate(R.layout.gridview_gorunum,null);
        TextView tvAd = (TextView)view.findViewById(R.id.tvAd);
        TextView tvSoyad = (TextView)view.findViewById(R.id.tvSoyad);
        TextView tvEmail = (TextView)view.findViewById(R.id.tvEmail);

        tvAd.setText(users.get(position).getAd());
        tvSoyad.setText(users.get(position).getSoyad());
        tvEmail.setText(users.get(position).getEmail());

        return view;
    }
}
