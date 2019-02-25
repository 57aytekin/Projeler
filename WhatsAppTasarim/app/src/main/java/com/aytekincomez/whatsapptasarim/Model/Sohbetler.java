package com.aytekincomez.whatsapptasarim.Model;

public class Sohbetler {
    private int id;
    private String adSoyad;
    private String aciklama;
    private String tarih;
    private String resimUrl;


    public Sohbetler() {
    }

    public Sohbetler(int id, String adSoyad, String aciklama, String tarih, String resimUrl) {
        this.id = id;
        this.adSoyad = adSoyad;
        this.aciklama = aciklama;
        this.tarih = tarih;
        this.resimUrl = resimUrl;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAdSoyad() {
        return adSoyad;
    }

    public void setAdSoyad(String adSoyad) {
        this.adSoyad = adSoyad;
    }

    public String getAciklama() {
        return aciklama;
    }

    public void setAciklama(String aciklama) {
        this.aciklama = aciklama;
    }

    public String getTarih() {
        return tarih;
    }

    public void setTarih(String tarih) {
        this.tarih = tarih;
    }

    public String getResimUrl() {
        return resimUrl;
    }

    public void setResimUrl(String resimUrl) {
        this.resimUrl = resimUrl;
    }
}
