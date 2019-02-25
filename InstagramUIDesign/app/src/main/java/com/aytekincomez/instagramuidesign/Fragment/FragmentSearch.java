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
import android.widget.EditText;

import com.aytekincomez.instagramuidesign.Adapter.SearchView_RecyclerviewMediaAdapter;
import com.aytekincomez.instagramuidesign.Model.SearchItems;
import com.aytekincomez.instagramuidesign.R;

import java.util.ArrayList;

public class FragmentSearch extends Fragment {
    RecyclerView recyclerView;
    GridLayoutManager lLayout;
    ArrayList<SearchItems> arrayList;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_layout_search, container, false);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        lLayout = new GridLayoutManager(getContext().getApplicationContext(), 1);
        EditText etSearch = (EditText)view.findViewById(R.id.etSearch);
        recyclerView = (RecyclerView)view.findViewById(R.id.recyclerViewSearch);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(lLayout);

        SearchView_RecyclerviewMediaAdapter adapter = new SearchView_RecyclerviewMediaAdapter(getContext(), getAllItemList());
        recyclerView.setAdapter(adapter);
        recyclerView.setNestedScrollingEnabled(false);
    }

    private ArrayList<SearchItems> getAllItemList() {
        ArrayList<SearchItems> items  = new ArrayList<>();
        ArrayList<String> resimUrl = new ArrayList<>();
        resimUrl.add("https://galeri13.uludagsozluk.com/633/sozluk-yazarlarinin-profil-resmi_1363249.png");
        resimUrl.add("http://www.atasunoptik.com.tr/blog/wp-content/uploads/2017/11/ideal-profil-fotosu-i%C3%A7in-ipu%C3%A7lar%C4%B1-02.jpg");
        resimUrl.add("https://galeri13.uludagsozluk.com/633/sozluk-yazarlarinin-profil-resmi_1363249.png");
        resimUrl.add("https://icdn.ensonhaber.com/resimler/diger/123_5690_4.jpg");
        resimUrl.add("https://galeri13.uludagsozluk.com/633/sozluk-yazarlarinin-profil-resmi_1363249.png");
        resimUrl.add("http://www.atasunoptik.com.tr/blog/wp-content/uploads/2017/11/ideal-profil-fotosu-i%C3%A7in-ipu%C3%A7lar%C4%B1-02.jpg");
        resimUrl.add("https://galeri13.uludagsozluk.com/633/sozluk-yazarlarinin-profil-resmi_1363249.png");
        resimUrl.add("https://icdn.ensonhaber.com/resimler/diger/123_5690_4.jpg");

        items.add(new SearchItems(resimUrl,"videoUrl"));
        items.add(new SearchItems(resimUrl,"videoUrl"));
        items.add(new SearchItems(resimUrl,"videoUrl"));
        items.add(new SearchItems(resimUrl,"videoUrl"));
        items.add(new SearchItems(resimUrl,"videoUrl"));

        return items;
    }
}
