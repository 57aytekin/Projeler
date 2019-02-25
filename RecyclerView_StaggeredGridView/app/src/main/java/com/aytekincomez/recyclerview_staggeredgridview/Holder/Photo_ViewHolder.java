package com.aytekincomez.recyclerview_staggeredgridview.Holder;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.aytekincomez.recyclerview_staggeredgridview.R;

public class Photo_ViewHolder extends RecyclerView.ViewHolder {

    /*
    ViewHolder sınıfı, Layout içerisinde bulunan nesnelerin referansının
    tanımlanması için kullanılır.
     */

    public ImageView ivPhoto,ivUserPhoto;
    public TextView tvTitle,tvUserName,tvDescription;

    public Photo_ViewHolder(final View itemView) {
        super(itemView);
        ivPhoto = itemView.findViewById(R.id.ivPhoto);
        ivUserPhoto = itemView.findViewById(R.id.ivUserPhoto);
        tvTitle = itemView.findViewById(R.id.tvTitle);
        tvUserName = itemView.findViewById(R.id.tvUser);
        tvDescription = itemView.findViewById(R.id.tvDescription);
    }

}