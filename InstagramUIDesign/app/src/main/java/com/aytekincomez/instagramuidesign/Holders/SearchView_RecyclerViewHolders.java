package com.aytekincomez.instagramuidesign.Holders;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.VideoView;

import com.aytekincomez.instagramuidesign.R;

public class SearchView_RecyclerViewHolders extends RecyclerView.ViewHolder {

    Context context = null;
    public ImageView iv1, iv2, iv3, iv4, iv5, iv6, iv7, iv8;
    public VideoView vv1;

    public SearchView_RecyclerViewHolders(@NonNull View itemView) {
        super(itemView);
        context = itemView.getContext();
        iv1 = (ImageView)itemView.findViewById(R.id.ivSearchPhoto1);
        iv2 = (ImageView)itemView.findViewById(R.id.ivSearchPhoto2);
        iv3 = (ImageView)itemView.findViewById(R.id.ivSearchPhoto3);
        iv4 = (ImageView)itemView.findViewById(R.id.ivSearchPhoto4);
        iv5 = (ImageView)itemView.findViewById(R.id.ivSearchPhoto5);
        iv6 = (ImageView)itemView.findViewById(R.id.ivSearchPhoto6);
        iv7 = (ImageView)itemView.findViewById(R.id.ivSearchPhoto7);
        iv8 = (ImageView)itemView.findViewById(R.id.ivSearchPhoto8);
        vv1 = (VideoView)itemView.findViewById(R.id.vwSearchVideo1);
    }
}
