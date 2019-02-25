package com.aytekincomez.landmarkbook;

import android.graphics.Bitmap;

/**
 * Created by aytek on 1.10.2017.
 */

public class Globals {
    private static Globals instance;
    private Bitmap chosenImage;

    private Globals() {

    }
    public void setData(Bitmap chosenImage) {
        this.chosenImage = chosenImage;
    }

    public Bitmap getData() {
        return this.chosenImage;
    }

    public static Globals getInstance () {
        if(instance == null) {
            instance = new Globals();
        }
        return instance;
    }
}
