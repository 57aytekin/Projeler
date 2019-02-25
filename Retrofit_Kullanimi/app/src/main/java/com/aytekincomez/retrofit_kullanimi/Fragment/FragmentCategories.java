package com.aytekincomez.retrofit_kullanimi.Fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.aytekincomez.retrofit_kullanimi.Adapter.CategoryAdapter;
import com.aytekincomez.retrofit_kullanimi.Helper.ApiClient;
import com.aytekincomez.retrofit_kullanimi.Interfaces.ApiInterface;
import com.aytekincomez.retrofit_kullanimi.Model.Category;
import com.aytekincomez.retrofit_kullanimi.Model.CategoryResponse;
import com.aytekincomez.retrofit_kullanimi.R;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class FragmentCategories extends Fragment {
    ListView listView;
    CategoryAdapter categoryAdapter;
    List<Category> categories;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_categories, null);
        listView = view.findViewById(R.id.listViewCategories);

        ApiInterface apiInterface = ApiClient.getClient().create(ApiInterface.class);
            Call<CategoryResponse> call = apiInterface.getKategoriler("");
        call.enqueue(new Callback<CategoryResponse>() {
            @Override
            public void onResponse(Call<CategoryResponse> call, Response<CategoryResponse> response) {
                categories = response.body().getCategories();
                categoryAdapter = new CategoryAdapter(categories, getContext());
                listView.setAdapter(categoryAdapter);
            }

            @Override
            public void onFailure(Call<CategoryResponse> call, Throwable t) {

            }
        });


        return view;
    }
}
