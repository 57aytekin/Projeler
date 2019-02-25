package com.aytekincomez.websitegoruntuleyici.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.aytekincomez.websitegoruntuleyici.Model.BlogSiteleri;
import com.aytekincomez.websitegoruntuleyici.R;

import java.util.ArrayList;

public class ListViewBloglarAdapter extends BaseAdapter {
    ArrayList<BlogSiteleri> blogSiteleris;
    Context context;
    LayoutInflater layoutInflater;

    public ListViewBloglarAdapter(Context context, ArrayList<BlogSiteleri> blogSiteleris){
        this.context = context;
        this.blogSiteleris = blogSiteleris;
        layoutInflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }
    @Override
    public int getCount() {
        return blogSiteleris.size();
    }

    @Override
    public Object getItem(int position) {
        return blogSiteleris.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = layoutInflater.inflate(R.layout.custom_listview_row, null);

        TextView tvBlogWebSiteAdi = (TextView)view.findViewById(R.id.tvBlogWebSiteAdi);
        TextView tvWebSiteUrl = (TextView)view.findViewById(R.id.tvWebSiteUrl);
        TextView tvBlogCokluYazar = (TextView)view.findViewById(R.id.tvBlogCokluYazar);
        TextView tvBlogKisiselMi = (TextView)view.findViewById(R.id.tvBlogKisiselMi);

        tvBlogWebSiteAdi.setText(blogSiteleris.get(position).getWebSiteAdi());
        tvWebSiteUrl.setText(blogSiteleris.get(position).getWebSiteUrl());
        if(blogSiteleris.get(position).isKisiselMi()){
            tvBlogKisiselMi.setText("Kişisel Website");
        }else{
            tvBlogKisiselMi.setText("Kişisel değil");
        }

        if(blogSiteleris.get(position).isCokluYazar()){
            tvBlogCokluYazar.setText("Çoklu Yazar");
        }else{
            tvBlogCokluYazar.setText("Çoklu Yazar Degil");
        }

        return view;
    }
}
