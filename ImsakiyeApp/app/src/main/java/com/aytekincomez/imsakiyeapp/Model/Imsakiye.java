package com.aytekincomez.imsakiyeapp.Model;

public class Imsakiye {
    private int id;
    private String tarih;
    private String imsak;
    private String sabah;
    private String gunes;
    private String oglen;
    private String ikindi;
    private String aksam;
    private String yatsi;

    public Imsakiye() {
    }

    public Imsakiye(int id, String tarih, String imsak, String sabah, String gunes, String oglen, String ikindi, String aksam, String yatsi) {
        this.id = id;
        this.tarih = tarih;
        this.imsak = imsak;
        this.sabah = sabah;
        this.gunes = gunes;
        this.oglen = oglen;
        this.ikindi = ikindi;
        this.aksam = aksam;
        this.yatsi = yatsi;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTarih() {
        return tarih;
    }

    public void setTarih(String tarih) {
        this.tarih = tarih;
    }

    public String getImsak() {
        return imsak;
    }

    public void setImsak(String imsak) {
        this.imsak = imsak;
    }

    public String getSabah() {
        return sabah;
    }

    public void setSabah(String sabah) {
        this.sabah = sabah;
    }

    public String getGunes() {
        return gunes;
    }

    public void setGunes(String gunes) {
        this.gunes = gunes;
    }

    public String getOglen() {
        return oglen;
    }

    public void setOglen(String oglen) {
        this.oglen = oglen;
    }

    public String getIkindi() {
        return ikindi;
    }

    public void setIkindi(String ikindi) {
        this.ikindi = ikindi;
    }

    public String getAksam() {
        return aksam;
    }

    public void setAksam(String aksam) {
        this.aksam = aksam;
    }

    public String getYatsi() {
        return yatsi;
    }

    public void setYatsi(String yatsi) {
        this.yatsi = yatsi;
    }
}
