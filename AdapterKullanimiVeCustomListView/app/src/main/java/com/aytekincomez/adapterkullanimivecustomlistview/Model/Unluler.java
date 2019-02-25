package com.aytekincomez.adapterkullanimivecustomlistview.Model;

public class Unluler {
    private int yas;
    private String ad;
    private String soyad;
    private String resim;

    public Unluler() {
    }

    public Unluler(int yas, String ad, String soyad, String resim) {
        this.yas = yas;
        this.ad = ad;
        this.soyad = soyad;
        this.resim = resim;
    }

    public int getYas() {
        return yas;
    }

    public void setYas(int yas) {
        this.yas = yas;
    }

    public String getAd() {
        return ad;
    }

    public void setAd(String ad) {
        this.ad = ad;
    }

    public String getSoyad() {
        return soyad;
    }

    public void setSoyad(String soyad) {
        this.soyad = soyad;
    }

    public String getResim() {
        return resim;
    }

    public void setResim(String resim) {
        this.resim = resim;
    }
}
