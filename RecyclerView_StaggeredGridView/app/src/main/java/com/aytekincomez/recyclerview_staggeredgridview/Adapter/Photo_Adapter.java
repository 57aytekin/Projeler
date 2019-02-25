package com.aytekincomez.recyclerview_staggeredgridview.Adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.aytekincomez.recyclerview_staggeredgridview.Holder.Photo_ViewHolder;
import com.aytekincomez.recyclerview_staggeredgridview.Model.Photo;
import com.aytekincomez.recyclerview_staggeredgridview.R;
import com.bumptech.glide.Glide;

import java.util.List;

public class Photo_Adapter extends RecyclerView.Adapter<Photo_ViewHolder> {
    List<Photo> photos;

    public Photo_Adapter(){}

    public Photo_Adapter(List<Photo> photos){
        /*
        Adapter sınıfındaki Liste değerlerini dolu constructor üzerinden çağırdık.
         */
        this.photos = photos;
    }

    @NonNull
    @Override
    public Photo_ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        /*
        Adapter sınıfının layout görünümüne bağlanması işlemini yürütür.
         */
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.image_row,null);
        return new Photo_ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull Photo_ViewHolder holder, int position) {
        /*
        Nesnelerin tanımlanması ViewHolder sınıfı içerisinde gerçekleşmişti.
        holder. diyerek, holder sınıfı içerisinde tanımlamış olduğumuz nesneleri
        değişken olarak çağırabiliyoruz.

        - Tanımlanmış nesnelerin doldurulma (gettext,settext,onclicklistener) işlemlerini
        sağlayan metot.
         */

        holder.tvTitle.setText(photos.get(position).getPhotoTitle());
        holder.tvUserName.setText(photos.get(position).getUserName());
        holder.tvDescription.setText(photos.get(position).getUserDescription());
        Glide
                .with(holder.itemView.getContext())
                .load(photos.get(position).getPhotoUrl())
                .into(holder.ivPhoto);

        Glide
                .with(holder.itemView.getContext())
                .load(photos.get(position).getUserPhotoUrl())
                .into(holder.ivUserPhoto);

    }

    @Override
    public int getItemCount() {
        // Listenin eleman sayısını döndürmesi gerekir.
        return photos.size();
    }

}
