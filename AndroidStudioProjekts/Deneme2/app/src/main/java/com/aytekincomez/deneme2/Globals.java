package com.aytekincomez.deneme2;

import android.graphics.Bitmap;

/**
 * Created by aytek on 5.11.2017.
 */

public class Globals {

    private static Globals instance;

    private Bitmap chosenImages;

    public Globals(){

    }

    public void setData(Bitmap chosenImages){
        this.chosenImages = chosenImages;
    }
    public Bitmap getData(){
        return this.chosenImages;
    }

    public static Globals getInstance(){
        if(instance == null){
            instance = new Globals();
        }
        return instance;
    }
}
