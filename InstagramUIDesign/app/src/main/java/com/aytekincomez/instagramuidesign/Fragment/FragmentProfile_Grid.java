package com.aytekincomez.instagramuidesign.Fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.aytekincomez.instagramuidesign.Adapter.GridViewRecyclerViewPhotoAdapter;
import com.aytekincomez.instagramuidesign.Model.ProfilePhotoGridModel;
import com.aytekincomez.instagramuidesign.R;

import java.util.ArrayList;

public class FragmentProfile_Grid extends Fragment {

    RecyclerView recyclerViewPhotos;
    GridLayoutManager lLayout;

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_profile_grid, null);

        recyclerViewPhotos = (RecyclerView)view.findViewById(R.id.recyclerViewPhotos);

        lLayout = new GridLayoutManager(getContext().getApplicationContext(), 3);

        recyclerViewPhotos.setHasFixedSize(true);
        recyclerViewPhotos.setLayoutManager(lLayout);

        GridViewRecyclerViewPhotoAdapter adapter = new GridViewRecyclerViewPhotoAdapter(getContext(), getAllItemList());
        recyclerViewPhotos.setAdapter(adapter);
        recyclerViewPhotos.setNestedScrollingEnabled(false);

        return view;
    }



    private ArrayList<ProfilePhotoGridModel> getAllItemList() {
        ArrayList<ProfilePhotoGridModel> arrayList = new ArrayList<>();
        arrayList.add(new ProfilePhotoGridModel(1,"https://galeri13.uludagsozluk.com/633/sozluk-yazarlarinin-profil-resmi_1363249.png","Tarih"));
        arrayList.add(new ProfilePhotoGridModel(1,"https://icdn.ensonhaber.com/resimler/diger/123_5690_4.jpg","Tarih"));
        arrayList.add(new ProfilePhotoGridModel(1,"https://icdn.ensonhaber.com/resimler/diger/123_5690_4.jpg","Tarih"));
        arrayList.add(new ProfilePhotoGridModel(1,"https://icdn.ensonhaber.com/resimler/diger/123_5690_4.jpg","Tarih"));

        arrayList.add(new ProfilePhotoGridModel(1,"https://galeri13.uludagsozluk.com/633/sozluk-yazarlarinin-profil-resmi_1363249.png","Tarih"));
        arrayList.add(new ProfilePhotoGridModel(1,"https://icdn.ensonhaber.com/resimler/diger/123_5690_4.jpg","Tarih"));
        arrayList.add(new ProfilePhotoGridModel(1,"https://icdn.ensonhaber.com/resimler/diger/123_5690_4.jpg","Tarih"));
        arrayList.add(new ProfilePhotoGridModel(1,"https://icdn.ensonhaber.com/resimler/diger/123_5690_4.jpg","Tarih"));

        arrayList.add(new ProfilePhotoGridModel(1,"https://galeri13.uludagsozluk.com/633/sozluk-yazarlarinin-profil-resmi_1363249.png","Tarih"));
        arrayList.add(new ProfilePhotoGridModel(1,"https://icdn.ensonhaber.com/resimler/diger/123_5690_4.jpg","Tarih"));
        arrayList.add(new ProfilePhotoGridModel(1,"https://icdn.ensonhaber.com/resimler/diger/123_5690_4.jpg","Tarih"));
        arrayList.add(new ProfilePhotoGridModel(1,"https://icdn.ensonhaber.com/resimler/diger/123_5690_4.jpg","Tarih"));


        return arrayList;
    }

}
