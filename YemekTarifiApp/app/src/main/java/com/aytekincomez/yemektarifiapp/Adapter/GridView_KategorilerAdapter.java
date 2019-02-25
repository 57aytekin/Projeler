package com.aytekincomez.yemektarifiapp.Adapter;

import android.content.Context;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.aytekincomez.yemektarifiapp.Activity.YemeklerActivity;
import com.aytekincomez.yemektarifiapp.Database.DatabaseHelper;
import com.aytekincomez.yemektarifiapp.Holder.GridView_KategorilerHolder;
import com.aytekincomez.yemektarifiapp.Model.Kategoriler;
import com.aytekincomez.yemektarifiapp.R;
import com.bumptech.glide.Glide;

import java.io.IOException;
import java.util.ArrayList;

public class GridView_KategorilerAdapter extends RecyclerView.Adapter<GridView_KategorilerHolder> {
    private ArrayList<Kategoriler> kategorilers;
    private Context context;
    private LayoutInflater layoutInflater;
    private DatabaseHelper dbHelper;
    private SQLiteDatabase db;

    public GridView_KategorilerAdapter(Context context, ArrayList<Kategoriler> kategorilers) {
        this.context = context;
        this.kategorilers = kategorilers;

        try {
            dbHelper = new DatabaseHelper(context);
            db = dbHelper.getReadableDatabase();
        } catch (IOException e) {
            e.printStackTrace();
        }

        this.layoutInflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @NonNull
    @Override
    public GridView_KategorilerHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = layoutInflater.from(viewGroup.getContext()).inflate(R.layout.ozel_kategori_satiri, null);
        GridView_KategorilerHolder holder = new GridView_KategorilerHolder(view);

        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull final GridView_KategorilerHolder gridView_kategorilerHolder, final int i) {
        gridView_kategorilerHolder.tvKategoriBaslik.setText(kategorilers.get(i).getBaslik());
        gridView_kategorilerHolder.tvKategoriSayi.setText(""+dbHelper.getKategoridekiYemekSayisi(kategorilers.get(i).getId())+" tarif");

        try {

            int id = context.getResources().getIdentifier(kategorilers.get(i).getResim_konumu(),
                    "drawable",
                    context.getPackageName()
            );
            Glide.with(context).load(id).into(gridView_kategorilerHolder.ivKategoriResim);
        }catch (Exception e){

        }

        gridView_kategorilerHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, YemeklerActivity.class);
                intent.putExtra("kategori_id",kategorilers.get(i).getId());
                intent.putExtra("kategori_baslik",kategorilers.get(i).getBaslik());
                context.startActivity(intent);
            }
        });
    }

    @Override
    public long getItemId(int position) {
        return kategorilers.get(position).getId();
    }

    @Override
    public int getItemCount() {
        return kategorilers.size();
    }
}
