package com.aytekincomez.whatsapptasarim.Fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.aytekincomez.whatsapptasarim.Adapter.ListViewSohbetlerAdapter;
import com.aytekincomez.whatsapptasarim.Model.Sohbetler;
import com.aytekincomez.whatsapptasarim.R;

import java.util.ArrayList;

public class FragmentSohbetler extends Fragment {

    ArrayList<Sohbetler> sohbetlerListesi = new ArrayList<>();
    ListViewSohbetlerAdapter adapter;
    ListView listView;

    public void init(){
        sohbetlerListesi.add(new Sohbetler(
           1,"Aytekin Çömez", "EE daha daha napıyon", "27.11.2018", "https://cdn.pixabay.com/photo/2017/08/06/04/18/people-2588660_960_720.jpg"
        ));
        sohbetlerListesi.add(new Sohbetler(
                2,"Kemal Kılıçtaroğlu", "Deneme", "Dün", "https://pbs.twimg.com/profile_images/1003585525293436929/VAhaN_wy_400x400.jpg"
        ));
        sohbetlerListesi.add(new Sohbetler(
                3,"Devlet Bahçeli", "EE daha daha napıyon", "25.11.2018", "http://img2.cdn.tgrthaber.com.tr/images/haberler/2018_03/buyuk/mhp-lideri-devlet-bahceli-den-yunanistan-ve-ab-ye-uyari--1522137768.jpg"
        ));
        sohbetlerListesi.add(new Sohbetler(
                4,"Aytekin Çömez", "Selammm", "27.11.2018", "https://cdn.pixabay.com/photo/2017/08/06/04/18/people-2588660_960_720.jpg"
        ));
        sohbetlerListesi.add(new Sohbetler(
                5,"Kemal Kılıçtaroğlu", "EE daha daha napıyon", "27.11.2018", "https://pbs.twimg.com/profile_images/1003585525293436929/VAhaN_wy_400x400.jpg"
        ));
        sohbetlerListesi.add(new Sohbetler(
                6,"Devlet Bahçeli", "EE daha daha napıyon", "25.11.2018", "http://img2.cdn.tgrthaber.com.tr/images/haberler/2018_03/buyuk/mhp-lideri-devlet-bahceli-den-yunanistan-ve-ab-ye-uyari--1522137768.jpg"
        ));
        sohbetlerListesi.add(new Sohbetler(
                7,"Aytekin Çömez", "EE daha daha napıyon", "27.11.2018", "https://cdn.pixabay.com/photo/2017/08/06/04/18/people-2588660_960_720.jpg"
        ));
        sohbetlerListesi.add(new Sohbetler(
                8,"Kemal Kılıçtaroğlu", "İyi yaw nolsun", "27.11.2018", "https://pbs.twimg.com/profile_images/1003585525293436929/VAhaN_wy_400x400.jpg"
        ));
        sohbetlerListesi.add(new Sohbetler(
                9,"Devlet Bahçeli", "EE daha daha napıyon", "25.11.2018", "http://img2.cdn.tgrthaber.com.tr/images/haberler/2018_03/buyuk/mhp-lideri-devlet-bahceli-den-yunanistan-ve-ab-ye-uyari--1522137768.jpg"
        ));
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.tab_sohbetler, container, false);
        listView = (ListView)view.findViewById(R.id.listViewSohbetler);
        init();
        ListViewSohbetlerAdapter adapter = new ListViewSohbetlerAdapter(getContext(), sohbetlerListesi);
        listView.setAdapter(adapter);

        return view;

    }
}
