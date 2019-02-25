package com.aytekincomez.jsonparseonlinetv.Model;

public class Kanal {
    private int kanalId;
    private String kanalKategoriId;
    private String kanalAdi;
    private String kanalResim;
    private String kanalUrl;
    private String kanalAciklama;
    private String  kanalDil;

    public Kanal() {
    }

    public Kanal(int kanalId, String kanalKategoriId, String kanalAdi, String kanalResim, String kanalUrl, String kanalAciklama, String kanalDil) {
        this.kanalId = kanalId;
        this.kanalKategoriId = kanalKategoriId;
        this.kanalAdi = kanalAdi;
        this.kanalResim = kanalResim;
        this.kanalUrl = kanalUrl;
        this.kanalAciklama = kanalAciklama;
        this.kanalDil = kanalDil;
    }

    public int getKanalId() {
        return kanalId;
    }

    public void setKanalId(int kanalId) {
        this.kanalId = kanalId;
    }

    public String getKanalKategoriId() {
        return kanalKategoriId;
    }

    public void setKanalKategoriId(String kanalKategoriId) {
        this.kanalKategoriId = kanalKategoriId;
    }

    public String getKanalAdi() {
        return kanalAdi;
    }

    public void setKanalAdi(String kanalAdi) {
        this.kanalAdi = kanalAdi;
    }

    public String getKanalResim() {
        return kanalResim;
    }

    public void setKanalResim(String kanalResim) {
        this.kanalResim = kanalResim;
    }

    public String getKanalUrl() {
        return kanalUrl;
    }

    public void setKanalUrl(String kanalUrl) {
        this.kanalUrl = kanalUrl;
    }

    public String getKanalAciklama() {
        return kanalAciklama;
    }

    public void setKanalAciklama(String kanalAciklama) {
        this.kanalAciklama = kanalAciklama;
    }

    public String getKanalDil() {
        return kanalDil;
    }

    public void setKanalDil(String kanalDil) {
        this.kanalDil = kanalDil;
    }
}
