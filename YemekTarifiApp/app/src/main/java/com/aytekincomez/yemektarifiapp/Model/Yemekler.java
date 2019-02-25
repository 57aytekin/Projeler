package com.aytekincomez.yemektarifiapp.Model;

import java.io.Serializable;

public class Yemekler implements Serializable {
    int id;
    String yemek_adi;
    int pisirme_suresi;
    int hazirlama_suresi;
    int kisi_sayisi;
    int zorluk_seviyesi;
    int kategori_id;
    String resim_konumu;
    String hazirlanisi;
    String malzemeler;
    String alerjenler;

    public Yemekler() {
    }

    public Yemekler(int id, String yemek_adi, int pisirme_suresi, int hazirlama_suresi, int kisi_sayisi, int zorluk_seviyesi, int kategori_id, String resim_konumu, String hazirlanisi, String malzemeler, String alerjenler) {
        this.id = id;
        this.yemek_adi = yemek_adi;
        this.pisirme_suresi = pisirme_suresi;
        this.hazirlama_suresi = hazirlama_suresi;
        this.kisi_sayisi = kisi_sayisi;
        this.zorluk_seviyesi = zorluk_seviyesi;
        this.kategori_id = kategori_id;
        this.resim_konumu = resim_konumu;
        this.hazirlanisi = hazirlanisi;
        this.malzemeler = malzemeler;
        this.alerjenler = alerjenler;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getYemek_adi() {
        return yemek_adi;
    }

    public void setYemek_adi(String yemek_adi) {
        this.yemek_adi = yemek_adi;
    }

    public int getPisirme_suresi() {
        return pisirme_suresi;
    }

    public void setPisirme_suresi(int pisirme_suresi) {
        this.pisirme_suresi = pisirme_suresi;
    }

    public int getHazirlama_suresi() {
        return hazirlama_suresi;
    }

    public void setHazirlama_suresi(int hazirlama_suresi) {
        this.hazirlama_suresi = hazirlama_suresi;
    }

    public int getKisi_sayisi() {
        return kisi_sayisi;
    }

    public void setKisi_sayisi(int kisi_sayisi) {
        this.kisi_sayisi = kisi_sayisi;
    }

    public int getZorluk_seviyesi() {
        return zorluk_seviyesi;
    }

    public void setZorluk_seviyesi(int zorluk_seviyesi) {
        this.zorluk_seviyesi = zorluk_seviyesi;
    }

    public int getKategori_id() {
        return kategori_id;
    }

    public void setKategori_id(int kategori_id) {
        this.kategori_id = kategori_id;
    }

    public String getResim_konumu() {
        return resim_konumu;
    }

    public void setResim_konumu(String resim_konumu) {
        this.resim_konumu = resim_konumu;
    }

    public String getHazirlanisi() {
        return hazirlanisi;
    }

    public void setHazirlanisi(String hazirlanisi) {
        this.hazirlanisi = hazirlanisi;
    }

    public String getMalzemeler() {
        return malzemeler;
    }

    public void setMalzemeler(String malzemeler) {
        this.malzemeler = malzemeler;
    }

    public String getAlerjenler() {
        return alerjenler;
    }

    public void setAlerjenler(String alerjenler) {
        this.alerjenler = alerjenler;
    }
}
