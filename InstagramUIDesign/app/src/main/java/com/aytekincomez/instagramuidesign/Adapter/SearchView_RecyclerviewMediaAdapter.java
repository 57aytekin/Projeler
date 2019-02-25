package com.aytekincomez.instagramuidesign.Adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.aytekincomez.instagramuidesign.Holders.SearchView_RecyclerViewHolders;
import com.aytekincomez.instagramuidesign.Model.SearchItems;
import com.aytekincomez.instagramuidesign.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class SearchView_RecyclerviewMediaAdapter extends RecyclerView.Adapter<SearchView_RecyclerViewHolders> {

    private ArrayList<SearchItems> arrayList;
    private Context context;
    private LayoutInflater layoutInflater;

    public SearchView_RecyclerviewMediaAdapter(Context context, ArrayList<SearchItems> arrayList){
        this.arrayList = arrayList;
        this.context = context;

    }

    @NonNull
    @Override
    public SearchView_RecyclerViewHolders onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View layoutView = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.searchview_media, null);
        SearchView_RecyclerViewHolders holders = new SearchView_RecyclerViewHolders(layoutView);
        return holders;
    }

    @Override
    public void onBindViewHolder(@NonNull SearchView_RecyclerViewHolders holders, int i) {
        //Glide
        Picasso.with(context).load(arrayList.get(i).getItemsUrl().get(0)).into(holders.iv1);
        Picasso.with(context).load(arrayList.get(i).getItemsUrl().get(1)).into(holders.iv2);
        Picasso.with(context).load(arrayList.get(i).getItemsUrl().get(2)).into(holders.iv3);
        Picasso.with(context).load(arrayList.get(i).getItemsUrl().get(3)).into(holders.iv4);
        Picasso.with(context).load(arrayList.get(i).getItemsUrl().get(4)).into(holders.iv5);
        Picasso.with(context).load(arrayList.get(i).getItemsUrl().get(5)).into(holders.iv6);
        Picasso.with(context).load(arrayList.get(i).getItemsUrl().get(6)).into(holders.iv7);
        Picasso.with(context).load(arrayList.get(i).getItemsUrl().get(7)).into(holders.iv8);

    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }
}
