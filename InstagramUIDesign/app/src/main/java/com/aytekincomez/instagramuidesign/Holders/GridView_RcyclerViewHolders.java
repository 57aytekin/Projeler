package com.aytekincomez.instagramuidesign.Holders;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.aytekincomez.instagramuidesign.R;

public class GridView_RcyclerViewHolders extends RecyclerView.ViewHolder {
    Context context;
    public ImageView imgPhoto;

    public GridView_RcyclerViewHolders(@NonNull final View itemView) {
        super(itemView);

        context = itemView.getContext();
        imgPhoto = (ImageView)itemView.findViewById(R.id.gridViewProfilePhoto);
        imgPhoto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(itemView.getContext(), "Resme Tıklandı",Toast.LENGTH_LONG).show();
            }
        });
    }
}
