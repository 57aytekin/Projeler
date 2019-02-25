package com.aytekincomez.verileriokumayazmayontemleri.Model;

public class Haber {

    private String haberUrl;
    private String haberAdi;

    public Haber() {
    }

    public Haber(String haberUrl, String haberAdi) {
        this.haberUrl = haberUrl;
        this.haberAdi = haberAdi;
    }

    public String getHaberUrl() {
        return haberUrl;
    }

    public void setHaberUrl(String haberUrl) {
        this.haberUrl = haberUrl;
    }

    public String getHaberAdi() {
        return haberAdi;
    }

    public void setHaberAdi(String haberAdi) {
        this.haberAdi = haberAdi;
    }
}
