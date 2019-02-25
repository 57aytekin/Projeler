package com.aytekincomez.multipleviewholdersornek.Model;

public class Reklam {
    private int rekalmId;
    private String reklamIcerik;

    public Reklam() {
    }

    public Reklam(int rekalmId, String reklamIcerik) {
        this.rekalmId = rekalmId;
        this.reklamIcerik = reklamIcerik;
    }

    public int getRekalmId() {
        return rekalmId;
    }

    public void setRekalmId(int rekalmId) {
        this.rekalmId = rekalmId;
    }

    public String getReklamIcerik() {
        return reklamIcerik;
    }

    public void setReklamIcerik(String reklamIcerik) {
        this.reklamIcerik = reklamIcerik;
    }
}
