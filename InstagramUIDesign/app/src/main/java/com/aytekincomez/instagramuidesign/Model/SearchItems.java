package com.aytekincomez.instagramuidesign.Model;

import java.util.ArrayList;

public class SearchItems {

    private ArrayList<String> itemsUrl;
    private String videoUrl;

    public SearchItems() {
    }

    public SearchItems(ArrayList<String> itemsUrl, String videoUrl) {
        this.itemsUrl = itemsUrl;
        this.videoUrl = videoUrl;
    }

    public ArrayList<String> getItemsUrl() {
        return itemsUrl;
    }

    public void setItemsUrl(ArrayList<String> itemsUrl) {
        this.itemsUrl = itemsUrl;
    }

    public String getVideoUrl() {
        return videoUrl;
    }

    public void setVideoUrl(String videoUrl) {
        this.videoUrl = videoUrl;
    }
}
