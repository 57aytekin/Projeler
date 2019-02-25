package com.aytekincomez.instagramuidesign.Model;

public class ProfilePhotoGridModel {
    private int id;
    private String photoUrl;
    private String photoShareDate;

    public ProfilePhotoGridModel() {
    }

    public ProfilePhotoGridModel(int id, String photoUrl, String photoShareDate) {
        this.id = id;
        this.photoUrl = photoUrl;
        this.photoShareDate = photoShareDate;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPhotoUrl() {
        return photoUrl;
    }

    public void setPhotoUrl(String photoUrl) {
        this.photoUrl = photoUrl;
    }

    public String getPhotoShareDate() {
        return photoShareDate;
    }

    public void setPhotoShareDate(String photoShareDate) {
        this.photoShareDate = photoShareDate;
    }
}
