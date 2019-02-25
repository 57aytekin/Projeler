package com.aytekincomez.kanbagisiapp.Model;

import com.google.firebase.database.Exclude;

import java.util.HashMap;
import java.util.Map;

public class NewIlan {
    private String ad;
    private String soyad;
    private String kangurubu;
    private String il;
    private String ilce;
    private String hastaneAdi;
    private String telNo;
    public Map<String, Boolean> ilan = new HashMap<>();

    public NewIlan() {
    }

    public NewIlan(String ad, String kangurubu, String il, String hastaneAdi){
        this.ad = ad;
        this.kangurubu = kangurubu;
        this.il = il;
        this.hastaneAdi = hastaneAdi;
    }

    public NewIlan(String ad, String soyad, String kangurubu, String il, String ilce, String hastaneAdi, String telNo) {
        this.ad = ad;
        this.soyad = soyad;
        this.kangurubu = kangurubu;
        this.il = il;
        this.ilce = ilce;
        this.hastaneAdi = hastaneAdi;
        this.telNo = telNo;
    }

    @Exclude
    public Map<String, Object> toMap() {
        HashMap<String, Object> result = new HashMap<>();
        result.put("ad", ad);
        result.put("soyad", soyad);
        result.put("kangurubu", kangurubu);
        result.put("il", il);
        result.put("ilce", ilce);
        result.put("hastaneAdi", hastaneAdi);
        result.put("telNo", telNo);

        return result;
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

    public String getKangurubu() {
        return kangurubu;
    }

    public void setKangurubu(String kangurubu) {
        this.kangurubu = kangurubu;
    }

    public String getIl() {
        return il;
    }

    public void setIl(String il) {
        this.il = il;
    }

    public String getIlce() {
        return ilce;
    }

    public void setIlce(String ilce) {
        this.ilce = ilce;
    }

    public String getHastaneAdi() {
        return hastaneAdi;
    }

    public void setHastaneAdi(String hastaneAdi) {
        this.hastaneAdi = hastaneAdi;
    }

    public String getTelNo() {
        return telNo;
    }

    public void setTelNo(String telNo) {
        this.telNo = telNo;
    }
}
