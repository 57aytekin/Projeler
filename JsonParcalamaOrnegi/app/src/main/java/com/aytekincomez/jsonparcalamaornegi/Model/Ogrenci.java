package com.aytekincomez.jsonparcalamaornegi.Model;

public class Ogrenci {
    private int ogrenciNo;
    private String ogrenciAdi;
    private String ogrenciSoyad;
    private String bolumAdi;
    private String okulAdi;
    private int ogreciSinif;
    private String ogrenciResim;

    public Ogrenci() {
    }

    public Ogrenci(int ogrenciNo, String ogrenciAdi, String ogrenciSoyad, String bolumAdi, String okulAdi, int ogreciSinif, String ogrenciResim) {
        this.ogrenciNo = ogrenciNo;
        this.ogrenciAdi = ogrenciAdi;
        this.ogrenciSoyad = ogrenciSoyad;
        this.bolumAdi = bolumAdi;
        this.okulAdi = okulAdi;
        this.ogreciSinif = ogreciSinif;
        this.ogrenciResim = ogrenciResim;
    }

    public int getOgrenciNo() {
        return ogrenciNo;
    }

    public void setOgrenciNo(int ogrenciNo) {
        this.ogrenciNo = ogrenciNo;
    }

    public String getOgrenciAdi() {
        return ogrenciAdi;
    }

    public void setOgrenciAdi(String ogrenciAdi) {
        this.ogrenciAdi = ogrenciAdi;
    }

    public String getOgrenciSoyad() {
        return ogrenciSoyad;
    }

    public void setOgrenciSoyad(String ogrenciSoyad) {
        this.ogrenciSoyad = ogrenciSoyad;
    }

    public String getBolumAdi() {
        return bolumAdi;
    }

    public void setBolumAdi(String bolumAdi) {
        this.bolumAdi = bolumAdi;
    }

    public String getOkulAdi() {
        return okulAdi;
    }

    public void setOkulAdi(String okulAdi) {
        this.okulAdi = okulAdi;
    }

    public int getOgreciSinif() {
        return ogreciSinif;
    }

    public void setOgreciSinif(int ogreciSinif) {
        this.ogreciSinif = ogreciSinif;
    }

    public String getOgrenciResim() {
        return ogrenciResim;
    }

    public void setOgrenciResim(String ogrenciResim) {
        this.ogrenciResim = ogrenciResim;
    }
}
