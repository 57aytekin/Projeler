package com.aytekincomez.volleyloginandregister.Model;

public class Paylasim {
    private int id;
    private String tarih;
    private String icerik;
    private String paylasanEmal;

    public Paylasim() {
    }

    public Paylasim(int id, String tarih, String icerik, String paylasanEmal) {
        this.id = id;
        this.tarih = tarih;
        this.icerik = icerik;
        this.paylasanEmal = paylasanEmal;
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

    public String getIcerik() {
        return icerik;
    }

    public void setIcerik(String icerik) {
        this.icerik = icerik;
    }

    public String getPaylasanEmal() {
        return paylasanEmal;
    }

    public void setPaylasanEmal(String paylasanEmal) {
        this.paylasanEmal = paylasanEmal;
    }
}
