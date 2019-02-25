package com.aytekincomez.retrofit_kullanimi.Fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.aytekincomez.retrofit_kullanimi.Adapter.BlogAdapter;
import com.aytekincomez.retrofit_kullanimi.Helper.ApiClient;
import com.aytekincomez.retrofit_kullanimi.Interfaces.ApiInterface;
import com.aytekincomez.retrofit_kullanimi.Model.Blog;
import com.aytekincomez.retrofit_kullanimi.Model.BlogResponse;
import com.aytekincomez.retrofit_kullanimi.R;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class FragmentBlogs extends Fragment {
    ListView listView;
    BlogAdapter blogAdapter;
    List<Blog> blogs;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fargment_blogs, null);
        listView = view.findViewById(R.id.listViewBlogs);

        ApiInterface apiInterface = ApiClient.getClient().create(ApiInterface.class);
        Call<BlogResponse> call = apiInterface.getBloglar("");
        call.enqueue(new Callback<BlogResponse>() {
            @Override
            public void onResponse(Call<BlogResponse> call, Response<BlogResponse> response) {
                blogs = response.body().getBlogs();
                blogAdapter = new BlogAdapter(blogs, getContext());
                listView.setAdapter(blogAdapter);
            }

            @Override
            public void onFailure(Call<BlogResponse> call, Throwable t) {

            }
        });


        return view;
    }
}
