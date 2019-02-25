package com.aytekincomez.yemektarifiapp.Model;

public class Favoriler {
    int id;
    int yemek_id;

    public Favoriler() {
    }

    public Favoriler(int id, int yemek_id) {
        this.id = id;
        this.yemek_id = yemek_id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getYemek_id() {
        return yemek_id;
    }

    public void setYemek_id(int yemek_id) {
        this.yemek_id = yemek_id;
    }
}
