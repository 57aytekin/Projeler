package com.aytekincomez.websitegoruntuleyici.Fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.aytekincomez.websitegoruntuleyici.Adapter.ListViewBloglarAdapter;
import com.aytekincomez.websitegoruntuleyici.Model.BlogSiteleri;
import com.aytekincomez.websitegoruntuleyici.R;

import java.util.ArrayList;

public class FragmentBloglar extends Fragment {
    ArrayList<BlogSiteleri> arrayList = new ArrayList<>();

    public void init(){
        arrayList.add(new BlogSiteleri(false, "Serif Gungor","http://serifgungor.com",true));
        arrayList.add(new BlogSiteleri(false, "Serif Gungor","http://serifgungor.com",true));
        arrayList.add(new BlogSiteleri(false, "Serif Gungor","http://serifgungor.com",true));
        arrayList.add(new BlogSiteleri(false, "Serif Gungor","http://serifgungor.com",true));
        arrayList.add(new BlogSiteleri(false, "Serif Gungor","http://serifgungor.com",true));

        arrayList.add(new BlogSiteleri(false, "Serif Gungor","http://serifgungor.com",true));
        arrayList.add(new BlogSiteleri(false, "Serif Gungor","http://serifgungor.com",true));
        arrayList.add(new BlogSiteleri(false, "Serif Gungor","http://serifgungor.com",true));
        arrayList.add(new BlogSiteleri(false, "Serif Gungor","http://serifgungor.com",true));
        arrayList.add(new BlogSiteleri(false, "Serif Gungor","http://serifgungor.com",true));
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.layout_fragment_blog, container, false);
        ListView listView = (ListView)view.findViewById(R.id.listViewBloglar);
        init();
        ListViewBloglarAdapter adapter = new ListViewBloglarAdapter(getContext(), arrayList);
        listView.setAdapter(adapter);

        return view;
    }
}
