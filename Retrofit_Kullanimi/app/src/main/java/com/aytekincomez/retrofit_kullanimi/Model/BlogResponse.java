package com.aytekincomez.retrofit_kullanimi.Model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class BlogResponse {
    @SerializedName("blogs")
    private List<Blog> blogs;

    public List<Blog> getBlogs() {
        return blogs;
    }

    public void setBlogs(List<Blog> blogs) {
        this.blogs = blogs;
    }
}
