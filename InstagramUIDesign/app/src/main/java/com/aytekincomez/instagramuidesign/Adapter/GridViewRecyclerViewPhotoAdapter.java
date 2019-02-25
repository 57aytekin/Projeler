package com.aytekincomez.instagramuidesign.Adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.aytekincomez.instagramuidesign.Holders.GridView_RcyclerViewHolders;
import com.aytekincomez.instagramuidesign.Model.ProfilePhotoGridModel;
import com.aytekincomez.instagramuidesign.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class GridViewRecyclerViewPhotoAdapter extends RecyclerView.Adapter<GridView_RcyclerViewHolders> {

    private ArrayList<ProfilePhotoGridModel> arrayList;
    private Context context;
    private LayoutInflater layoutInflater;

    public GridViewRecyclerViewPhotoAdapter(Context context, ArrayList<ProfilePhotoGridModel> arrayList){
        this.context = context;
        this.arrayList = arrayList;
    }

    @NonNull
    @Override
    public GridView_RcyclerViewHolders onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View layoutView  = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.recyclerview_photo_profile, null);
        GridView_RcyclerViewHolders holders = new GridView_RcyclerViewHolders(layoutView);
        return holders;
    }

    @Override
    public void onBindViewHolder(@NonNull GridView_RcyclerViewHolders gridView_rcyclerViewHolders, int i) {
        Picasso.with(context).load(arrayList.get(i).getPhotoUrl()).into(gridView_rcyclerViewHolders.imgPhoto);
    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    @Override
    public long getItemId(int position) {
        return arrayList.get(position).getId();
    }
}
