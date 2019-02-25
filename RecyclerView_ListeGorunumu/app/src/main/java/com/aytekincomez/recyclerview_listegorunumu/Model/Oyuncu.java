package com.aytekincomez.recyclerview_listegorunumu.Model;

import java.io.Serializable;

public class Oyuncu implements Serializable {
    private int id;
    private String adsoyad;
    private int yas;
    private String resim;

    public Oyuncu() {
    }

    public Oyuncu(int id, String adsoyad, int yas, String resim) {
        this.id = id;
        this.adsoyad = adsoyad;
        this.yas = yas;
        this.resim = resim;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAdsoyad() {
        return adsoyad;
    }

    public void setAdsoyad(String adsoyad) {
        this.adsoyad = adsoyad;
    }

    public int getYas() {
        return yas;
    }

    public void setYas(int yas) {
        this.yas = yas;
    }

    public String getResim() {
        return resim;
    }

    public void setResim(String resim) {
        this.resim = resim;
    }
}
