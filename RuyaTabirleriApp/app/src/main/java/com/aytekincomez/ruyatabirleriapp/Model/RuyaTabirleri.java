package com.aytekincomez.ruyatabirleriapp.Model;

public class RuyaTabirleri {

    private int id;
    private String baslik;
    private String aciklama;
    private String resim;

    public RuyaTabirleri() {
    }

    public RuyaTabirleri(int id, String baslik, String aciklama, String resim) {
        this.id = id;
        this.baslik = baslik;
        this.aciklama = aciklama;
        this.resim = resim;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getBaslik() {
        return baslik;
    }

    public void setBaslik(String baslik) {
        this.baslik = baslik;
    }

    public String getAciklama() {
        return aciklama;
    }

    public void setAciklama(String aciklama) {
        this.aciklama = aciklama;
    }

    public String getResim() {
        return resim;
    }

    public void setResim(String resim) {
        this.resim = resim;
    }
}
