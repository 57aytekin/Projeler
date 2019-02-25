package com.aytekincomez.retrofit_kullanimi.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.aytekincomez.retrofit_kullanimi.Helper.ApiClient;
import com.aytekincomez.retrofit_kullanimi.Model.Blog;
import com.aytekincomez.retrofit_kullanimi.R;
import com.bumptech.glide.Glide;

import java.util.List;

public class BlogAdapter extends BaseAdapter {
    private List<Blog> bloglar;
    private Context context;
    private LayoutInflater layoutInflater;

    public BlogAdapter(List<Blog> bloglar, Context context) {
        this.context = context;
        this.bloglar = bloglar;
        this.layoutInflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return bloglar.size();
    }

    @Override
    public Object getItem(int position) {
        return bloglar.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = layoutInflater.inflate(R.layout.custom_blogs_row, null);

        ImageView ivBlogPhoto = view.findViewById(R.id.ivBlogPhoto);
        TextView tvBlogTitle = view.findViewById(R.id.tvBlogTitle);
        TextView tvBlogViewCount = view.findViewById(R.id.tvBlogViewCout);
        TextView tvBlogShareTime = view.findViewById(R.id.tvBlogShareTime);

        Glide
                .with(view.getContext())
                .load(ApiClient.BASE_URL+bloglar.get(position).getImage())
                .into(ivBlogPhoto);
        tvBlogTitle.setText(""+bloglar.get(position).getBlog_seo_title());
        tvBlogViewCount.setText(""+bloglar.get(position).getBlog_do_viewcount());
        tvBlogShareTime.setText(""+bloglar.get(position).getSharetime());

        return view;
    }
}
