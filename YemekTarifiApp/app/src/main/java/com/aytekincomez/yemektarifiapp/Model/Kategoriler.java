package com.aytekincomez.yemektarifiapp.Model;

public class Kategoriler {
    int id;
    String resim_konumu;
    String baslik;

    public Kategoriler() {
    }

    public Kategoriler(int id, String resim_konumu, String baslik) {
        this.id = id;
        this.resim_konumu = resim_konumu;
        this.baslik = baslik;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getResim_konumu() {
        return resim_konumu;
    }

    public void setResim_konumu(String resim_konumu) {
        this.resim_konumu = resim_konumu;
    }

    public String getBaslik() {
        return baslik;
    }

    public void setBaslik(String baslik) {
        this.baslik = baslik;
    }
}
