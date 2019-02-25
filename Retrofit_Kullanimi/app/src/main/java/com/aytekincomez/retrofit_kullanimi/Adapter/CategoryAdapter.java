package com.aytekincomez.retrofit_kullanimi.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.aytekincomez.retrofit_kullanimi.Model.Category;
import com.aytekincomez.retrofit_kullanimi.R;

import java.util.List;

public class CategoryAdapter extends BaseAdapter {
    private List<Category> categories;
    private Context context;
    LayoutInflater layoutInflater;

    public CategoryAdapter() {
    }

    public CategoryAdapter(List<Category> categories, Context context ) {
        this.layoutInflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        this.context = context;
        this.categories = categories;
    }


    @Override
    public int getCount() {
        return categories.size();
    }

    @Override
    public Category getItem(int position) {
        return categories.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = layoutInflater.inflate(R.layout.custom_category_row, null);

        TextView tvTitle = view.findViewById(R.id.tvCategoryName);
        TextView tvCount = view.findViewById(R.id.tvCategoryBlogCount);

        tvTitle.setText(""+categories.get(position).getCategory_name());
        tvCount.setText(""+categories.get(position).getCnt());
        return view;
    }
}
