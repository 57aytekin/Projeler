package com.aytekincomez.sqlitekullanimicalisma1.Database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.aytekincomez.sqlitekullanimicalisma1.Model.Gunluk;

public class BasitTabloYapisi {

    Gunluk gunluk;
    String dbName = "GunlukDb";
    Context context;

    public BasitTabloYapisi(Context context){
        this.context = context;
    }

    public void gunlukEkle(Gunluk gunluk){
        SQLiteDatabase db = context.openOrCreateDatabase(dbName, Context.MODE_PRIVATE, null);

        StringBuffer sb = new StringBuffer();
        sb.append("Create Table if not exists Gunluk ");
        sb.append("(id INTEGER PRIMARY KEY,");
        sb.append("timestamp_tarih varchar,");
        sb.append("baslik varchar,");
        sb.append("icerik varchar,");
        sb.append("forograf varchar)");

        db.execSQL(sb.toString());//Tablo yoksa olustur.
        db.execSQL("insert into Gunluk (NULL,'"+gunluk.getTimestamp_tarih()+"','"+gunluk.getBaslik()+"','"+gunluk.getIcerik()+"','"+gunluk.getFotograf().getPath()+"')");


    }

    public void gunlukSil(Gunluk gunluk){
        SQLiteDatabase db = context.openOrCreateDatabase(dbName, Context.MODE_PRIVATE, null);
        db.execSQL("delete from Gunluk where id="+gunluk.getId());
    }
    public void gunlukGuncelle(Gunluk gunluk){
        SQLiteDatabase db = context.openOrCreateDatabase(dbName, Context.MODE_PRIVATE, null);
        db.execSQL("update Gunluk set baslik='"+gunluk.getBaslik()+"',icerik='"+gunluk.getIcerik()+"'");
    }
    public void gunlukListele(Gunluk gunluk){

    }
}
