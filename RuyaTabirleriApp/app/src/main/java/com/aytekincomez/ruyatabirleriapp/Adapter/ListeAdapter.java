package com.aytekincomez.ruyatabirleriapp.Adapter;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.aytekincomez.ruyatabirleriapp.Activity.DetayActivity;
import com.aytekincomez.ruyatabirleriapp.Model.RuyaTabirleri;
import com.aytekincomez.ruyatabirleriapp.R;

import java.util.ArrayList;

public class ListeAdapter extends BaseAdapter {
    ArrayList<RuyaTabirleri> ruyaTabirleriArrayList;
    Context context;
    LayoutInflater layoutInflater;

    public ListeAdapter(Activity activity, ArrayList<RuyaTabirleri> ruyaTabirleri){
        this.context = activity;
        this.ruyaTabirleriArrayList = ruyaTabirleri;
        this.layoutInflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return ruyaTabirleriArrayList.size();
    }

    @Override
    public Object getItem(int position) {
        return ruyaTabirleriArrayList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        final View view = layoutInflater.inflate(R.layout.listview_item_gorunumu,null);

        TextView tvBaslik = (TextView)view.findViewById(R.id.tvBaslik);
        ImageView ivResim = (ImageView)view.findViewById(R.id.ivResim);

        tvBaslik.setText(ruyaTabirleriArrayList.get(position).getBaslik());

        int resId = view.getResources().getIdentifier(
          ruyaTabirleriArrayList.get(position).getResim(),
          "drawable",
          view.getContext().getPackageName()
        );
        ivResim.setImageResource(resId);

        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                view.getContext().startActivity(
                        new Intent(view.getContext(), DetayActivity.class)
                        .putExtra("id",ruyaTabirleriArrayList.get(position).getId())
                );
            }
        });

        return view;
    }
}
