package com.aytekincomez.sqlitekullanimicalisma1.Model;

import java.io.File;

public class Gunluk {
    private int id;
    private String timestamp_tarih;
    private String baslik;
    private String icerik;
    private File fotograf;

    public Gunluk() {
    }

    public Gunluk(int id, String timestamp_tarih,String baslik, String icerik, File fotograf) {
        this.id = id;
        this.baslik = baslik;
        this.timestamp_tarih = timestamp_tarih;
        this.icerik = icerik;
        this.fotograf = fotograf;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTimestamp_tarih() {
        return timestamp_tarih;
    }

    public void setTimestamp_tarih(String timestamp_tarih) {
        this.timestamp_tarih = timestamp_tarih;
    }

    public String getIcerik() {
        return icerik;
    }

    public void setIcerik(String icerik) {
        this.icerik = icerik;
    }

    public File getFotograf() {
        return fotograf;
    }

    public void setFotograf(File fotograf) {
        this.fotograf = fotograf;
    }

    public String getBaslik() {
        return baslik;
    }

    public void setBaslik(String baslik) {
        this.baslik = baslik;
    }
}
