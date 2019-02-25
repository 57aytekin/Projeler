package com.aytekincomez.retrofit_kullanimi.Model;

import com.google.gson.annotations.SerializedName;

public class Blog {

    @SerializedName("id")
    private String id;
    @SerializedName("sharetime")
    private String sharetime;
    @SerializedName("updatetime")
    private String updatetime;
    @SerializedName("blog_do_viewcount")
    private String blog_do_viewcount;
    @SerializedName("url")
    private String url;
    @SerializedName("image")
    private String image;
    @SerializedName("blog_seo_title")
    private String blog_seo_title;

    public Blog() {
    }

    public Blog(String id, String sharetime, String updatetime, String blog_do_viewcount, String url, String image, String blog_seo_title) {
        this.id = id;
        this.sharetime = sharetime;
        this.updatetime = updatetime;
        this.blog_do_viewcount = blog_do_viewcount;
        this.url = url;
        this.image = image;
        this.blog_seo_title = blog_seo_title;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getSharetime() {
        return sharetime;
    }

    public void setSharetime(String sharetime) {
        this.sharetime = sharetime;
    }

    public String getUpdatetime() {
        return updatetime;
    }

    public void setUpdatetime(String updatetime) {
        this.updatetime = updatetime;
    }

    public String getBlog_do_viewcount() {
        return blog_do_viewcount;
    }

    public void setBlog_do_viewcount(String blog_do_viewcount) {
        this.blog_do_viewcount = blog_do_viewcount;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getBlog_seo_title() {
        return blog_seo_title;
    }

    public void setBlog_seo_title(String blog_seo_title) {
        this.blog_seo_title = blog_seo_title;
    }
}
