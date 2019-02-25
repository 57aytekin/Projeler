package com.aytekincomez.ruyatabirleriapp.Model;

import java.io.Serializable;

public class Tabir implements Serializable {
    private int id;
    private String baslik;
    private String icerik;
    private String resim_url;

    public Tabir() {
    }

    public Tabir(int id, String baslik, String icerik, String resim_url) {
        this.id = id;
        this.baslik = baslik;
        this.icerik = icerik;
        this.resim_url = resim_url;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getBaslik() {
        return baslik;
    }

    public void setBaslik(String baslik) {
        this.baslik = baslik;
    }

    public String getIcerik() {
        return icerik;
    }

    public void setIcerik(String icerik) {
        this.icerik = icerik;
    }

    public String getResim_url() {
        return resim_url;
    }

    public void setResim_url(String resim_url) {
        this.resim_url = resim_url;
    }
}
