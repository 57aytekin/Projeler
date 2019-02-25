package com.aytekincomez.whatsapptasarim.Model;

public class Durumlar {

    private int id;
    private String resimUrl;
    private String adSoyad;
    private String paylasimZamani;

    public Durumlar() {
    }

    public Durumlar(int id, String resimUrl, String adSoyad, String paylasimZamani) {
        this.id = id;
        this.resimUrl = resimUrl;
        this.adSoyad = adSoyad;
        this.paylasimZamani = paylasimZamani;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getResimUrl() {
        return resimUrl;
    }

    public void setResimUrl(String resimUrl) {
        this.resimUrl = resimUrl;
    }

    public String getAdSoyad() {
        return adSoyad;
    }

    public void setAdSoyad(String adSoyad) {
        this.adSoyad = adSoyad;
    }

    public String getPaylasimZamani() {
        return paylasimZamani;
    }

    public void setPaylasimZamani(String paylasimZamani) {
        this.paylasimZamani = paylasimZamani;
    }
}
