package com.aytekincomez.whatsapptasarim.Fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;
import android.widget.TextView;

import com.aytekincomez.whatsapptasarim.Adapter.GridViewDurumlarAdapter;
import com.aytekincomez.whatsapptasarim.Model.Durumlar;
import com.aytekincomez.whatsapptasarim.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import de.hdodenhof.circleimageview.CircleImageView;

public class FragmentDurum extends Fragment {

    GridView gridView;
    CircleImageView ivDurumResim;
    TextView tvDurumAdSoyad;
    TextView tvDurumGuncellemeTarihi;
    GridViewDurumlarAdapter adapter;
    ArrayList<Durumlar> durumlar = new ArrayList<>();

    public void doldur(){
        durumlar.add(new Durumlar(1, "https://cdn.pixabay.com/photo/2017/08/06/04/18/people-2588660_960_720.jpg","Aytekin Çömez","Dün"));
        durumlar.add(new Durumlar(1, "https://pbs.twimg.com/profile_images/1003585525293436929/VAhaN_wy_400x400.jpg","Kemal Kılıçtaroğlu","26.11.2018"));
        durumlar.add(new Durumlar(1, "http://img2.cdn.tgrthaber.com.tr/images/haberler/2018_03/buyuk/mhp-lideri-devlet-bahceli-den-yunanistan-ve-ab-ye-uyari--1522137768.jpg","Devllet Bahçeli","Dün"));

        durumlar.add(new Durumlar(1, "https://cdn.pixabay.com/photo/2017/08/06/04/18/people-2588660_960_720.jpg","Aytekin Çömez","Dün"));
        durumlar.add(new Durumlar(1, "https://pbs.twimg.com/profile_images/1003585525293436929/VAhaN_wy_400x400.jpg","Kemal Kılıçtaroğlu","26.11.2018"));
        durumlar.add(new Durumlar(1, "http://img2.cdn.tgrthaber.com.tr/images/haberler/2018_03/buyuk/mhp-lideri-devlet-bahceli-den-yunanistan-ve-ab-ye-uyari--1522137768.jpg","Devllet Bahçeli","Dün"));
    }


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.tab_durum, container, false);

        doldur();
        adapter = new GridViewDurumlarAdapter(view.getContext(), durumlar);

        gridView = (GridView)view.findViewById(R.id.gridViewDurumlar);
        ivDurumResim = (CircleImageView)view.findViewById(R.id.ivDurumResim);
        tvDurumAdSoyad = (TextView)view.findViewById(R.id.tvDurumAdSoyad);
        tvDurumGuncellemeTarihi = (TextView)view.findViewById(R.id.tvDurumGuncellemeTarihi);

        Picasso.with(getContext()).load("https://cdn.pixabay.com/photo/2017/08/06/04/18/people-2588660_960_720.jpg")
                .into(ivDurumResim);
        tvDurumAdSoyad.setText("Aytekin Çömez");
        tvDurumGuncellemeTarihi.setText("Az Önce");

        gridView.setAdapter(adapter);

        return view;

    }
}
