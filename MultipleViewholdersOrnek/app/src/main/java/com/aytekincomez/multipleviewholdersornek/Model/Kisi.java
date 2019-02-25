package com.aytekincomez.multipleviewholdersornek.Model;

public class Kisi {
    private int resimId;
    private int yas;
    private String adSoyad;

    public Kisi() {
    }

    public Kisi(int resimId, int yas, String adSoyad) {
        this.resimId = resimId;
        this.yas = yas;
        this.adSoyad = adSoyad;
    }

    public int getResimId() {
        return resimId;
    }

    public void setResimId(int resimId) {
        this.resimId = resimId;
    }

    public int getYas() {
        return yas;
    }

    public void setYas(int yas) {
        this.yas = yas;
    }

    public String getAdSoyad() {
        return adSoyad;
    }

    public void setAdSoyad(String adSoyad) {
        this.adSoyad = adSoyad;
    }
}
