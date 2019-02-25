package com.aytekincomez.websitegoruntuleyici.Fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.aytekincomez.websitegoruntuleyici.Adapter.ListViewHaberlerAdapter;
import com.aytekincomez.websitegoruntuleyici.Model.HaberSiteleri;
import com.aytekincomez.websitegoruntuleyici.R;

import java.util.ArrayList;

public class FragmentHaberler extends Fragment {
    ArrayList<HaberSiteleri> arrayList = new ArrayList<>();

    public void init(){
        arrayList.add(new HaberSiteleri(false,"aytekin Çömez","Http://wwww.aytekincomes.com"));
        arrayList.add(new HaberSiteleri(false,"aytekin Çömez","Http://wwww.aytekincomes.com"));
        arrayList.add(new HaberSiteleri(false,"aytekin Çömez","Http://wwww.aytekincomes.com"));
        arrayList.add(new HaberSiteleri(false,"aytekin Çömez","Http://wwww.aytekincomes.com"));
        arrayList.add(new HaberSiteleri(false,"aytekin Çömez","Http://wwww.aytekincomes.com"));
        arrayList.add(new HaberSiteleri(false,"aytekin Çömez","Http://wwww.aytekincomes.com"));
        arrayList.add(new HaberSiteleri(false,"aytekin Çömez","Http://wwww.aytekincomes.com"));
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.layout_fragment_haberler, container, false);
        ListView listView = (ListView)view.findViewById(R.id.listview_haberler);
        init();

        ListViewHaberlerAdapter adapter = new ListViewHaberlerAdapter(getContext(), arrayList);
        listView.setAdapter(adapter);

        return view;
    }
}
