package com.aytekincomez.recyclerview_listegorunumu.Model;

import java.io.Serializable;
import java.util.ArrayList;

public class Film implements Serializable {
    private int filmId;
    private int puan;
    private String vizyonaGirisTarihi;
    private String afis;
    private String konusu;
    private String turu;
    private String ad;
    private int sure;
    private String ulke;
    private ArrayList<Oyuncu> oyuncular;
    private String yapimci;
    private String yonetmen;

    public Film() {
    }

    public Film(int filmId, int puan, String vizyonaGirisTarihi, String afis, String konusu, String turu, String ad, int sure, String ulke, ArrayList<Oyuncu> oyuncular, String yapimci, String yonetmen) {
        this.filmId = filmId;
        this.puan = puan;
        this.vizyonaGirisTarihi = vizyonaGirisTarihi;
        this.afis = afis;
        this.konusu = konusu;
        this.turu = turu;
        this.ad = ad;
        this.sure = sure;
        this.ulke = ulke;
        this.oyuncular = oyuncular;
        this.yapimci = yapimci;
        this.yonetmen = yonetmen;
    }

    public int getFilmId() {
        return filmId;
    }

    public void setFilmId(int filmId) {
        this.filmId = filmId;
    }

    public int getPuan() {
        return puan;
    }

    public void setPuan(int puan) {
        this.puan = puan;
    }

    public String getVizyonaGirisTarihi() {
        return vizyonaGirisTarihi;
    }

    public void setVizyonaGirisTarihi(String vizyonaGirisTarihi) {
        this.vizyonaGirisTarihi = vizyonaGirisTarihi;
    }

    public String getAfis() {
        return afis;
    }

    public void setAfis(String afis) {
        this.afis = afis;
    }

    public String getKonusu() {
        return konusu;
    }

    public void setKonusu(String konusu) {
        this.konusu = konusu;
    }

    public String getTuru() {
        return turu;
    }

    public void setTuru(String turu) {
        this.turu = turu;
    }

    public String getAd() {
        return ad;
    }

    public void setAd(String ad) {
        this.ad = ad;
    }

    public int getSure() {
        return sure;
    }

    public void setSure(int sure) {
        this.sure = sure;
    }

    public String getUlke() {
        return ulke;
    }

    public void setUlke(String ulke) {
        this.ulke = ulke;
    }

    public ArrayList<Oyuncu> getOyuncular() {
        return oyuncular;
    }

    public void setOyuncular(ArrayList<Oyuncu> oyuncular) {
        this.oyuncular = oyuncular;
    }

    public String getYapimci() {
        return yapimci;
    }

    public void setYapimci(String yapimci) {
        this.yapimci = yapimci;
    }

    public String getYonetmen() {
        return yonetmen;
    }

    public void setYonetmen(String yonetmen) {
        this.yonetmen = yonetmen;
    }
}
