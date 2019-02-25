package com.aytekincomez.verileriokumayazmayontemleri.Model;

public class Ogrenci {

    private int ogrenciNo;
    private String ad;
    private String soyad;
    private String universite;

    public Ogrenci() {
    }

    public Ogrenci(int ogrenciNo, String ad, String soyad, String universite) {
        this.ogrenciNo = ogrenciNo;
        this.ad = ad;
        this.soyad = soyad;
        this.universite = universite;
    }

    public int getOgrenciNo() {
        return ogrenciNo;
    }

    public void setOgrenciNo(int ogrenciNo) {
        this.ogrenciNo = ogrenciNo;
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

    public String getUniversite() {
        return universite;
    }

    public void setUniversite(String universite) {
        this.universite = universite;
    }
}
