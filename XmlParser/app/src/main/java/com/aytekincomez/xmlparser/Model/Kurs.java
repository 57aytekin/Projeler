package com.aytekincomez.xmlparser.Model;

public class Kurs {
    private String ad;
    private int saatSayisi;
    private String egitmen;
    private int kontenjanSayisi;

    public Kurs() {
    }

    public Kurs(String ad, int saatSayisi, String egitmen, int kontenjanSayisi) {
        this.ad = ad;
        this.saatSayisi = saatSayisi;
        this.egitmen = egitmen;
        this.kontenjanSayisi = kontenjanSayisi;
    }

    public String getAd() {
        return ad;
    }

    public void setAd(String ad) {
        this.ad = ad;
    }

    public int getSaatSayisi() {
        return saatSayisi;
    }

    public void setSaatSayisi(int saatSayisi) {
        this.saatSayisi = saatSayisi;
    }

    public String getEgitmen() {
        return egitmen;
    }

    public void setEgitmen(String egitmen) {
        this.egitmen = egitmen;
    }

    public int getKontenjanSayisi() {
        return kontenjanSayisi;
    }

    public void setKontenjanSayisi(int kontenjanSayisi) {
        this.kontenjanSayisi = kontenjanSayisi;
    }
}
