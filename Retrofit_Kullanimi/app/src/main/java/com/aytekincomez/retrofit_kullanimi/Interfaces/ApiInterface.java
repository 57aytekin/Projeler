package com.aytekincomez.retrofit_kullanimi.Interfaces;

import com.aytekincomez.retrofit_kullanimi.Model.BlogResponse;
import com.aytekincomez.retrofit_kullanimi.Model.CategoryResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiInterface {
    @GET("content/api/post/blogs.php")
    Call<BlogResponse> getBloglar(@Query("api_key") String apiKey);

    @GET("content/api/post/categories.php")
    Call<CategoryResponse> getKategoriler(@Query("api_key") String apiKey);
}
