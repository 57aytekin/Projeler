package com.aytekincomez.recyclerview_staggeredgridview.Model;

public class Photo {
    private int id;
    private String photoUrl;
    private String photoTitle;
    private String userPhotoUrl;
    private String userName;
    private String userDescription;

    public Photo() {
    }

    public Photo(int id, String photoUrl, String photoTitle, String userPhotoUrl, String userName, String userDescription) {
        this.id = id;
        this.photoUrl = photoUrl;
        this.photoTitle = photoTitle;
        this.userPhotoUrl = userPhotoUrl;
        this.userName = userName;
        this.userDescription = userDescription;
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

    public String getPhotoTitle() {
        return photoTitle;
    }

    public void setPhotoTitle(String photoTitle) {
        this.photoTitle = photoTitle;
    }

    public String getUserPhotoUrl() {
        return userPhotoUrl;
    }

    public void setUserPhotoUrl(String userPhotoUrl) {
        this.userPhotoUrl = userPhotoUrl;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserDescription() {
        return userDescription;
    }

    public void setUserDescription(String userDescription) {
        this.userDescription = userDescription;
    }
}