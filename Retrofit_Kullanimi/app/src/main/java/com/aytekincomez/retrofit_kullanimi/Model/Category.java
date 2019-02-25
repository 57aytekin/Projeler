package com.aytekincomez.retrofit_kullanimi.Model;

import com.google.gson.annotations.SerializedName;

public class Category {
    @SerializedName("id")
    private String id;
    @SerializedName("parent")
    private String parent;
    @SerializedName("ranking_id")
    private String ranking_id;
    @SerializedName("category_name")
    private String category_name;
    @SerializedName("category_link")
    private String category_link;
    @SerializedName("cnt")
    private String cnt;

    public Category() {
    }

    public Category(String id, String parent, String ranking_id, String category_name, String category_link, String cnt) {
        this.id = id;
        this.parent = parent;
        this.ranking_id = ranking_id;
        this.category_name = category_name;
        this.category_link = category_link;
        this.cnt = cnt;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getParent() {
        return parent;
    }

    public void setParent(String parent) {
        this.parent = parent;
    }

    public String getRanking_id() {
        return ranking_id;
    }

    public void setRanking_id(String ranking_id) {
        this.ranking_id = ranking_id;
    }

    public String getCategory_name() {
        return category_name;
    }

    public void setCategory_name(String category_name) {
        this.category_name = category_name;
    }

    public String getCategory_link() {
        return category_link;
    }

    public void setCategory_link(String category_link) {
        this.category_link = category_link;
    }

    public String getCnt() {
        return cnt;
    }

    public void setCnt(String cnt) {
        this.cnt = cnt;
    }
}
