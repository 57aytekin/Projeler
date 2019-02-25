package com.aytekincomez.androidvolleyphp.app;

public class AppConfig {

    //Sunucu tarafında kullanıcı kayıt olabilmesi icin Androidde post isteginde bulunabilecegimiz sayfa.
    public static String URL_KAYIT = "http://10.1.8.20:8080/android_login_api/register.php";
    //Sunucu tarafında kullanıcı giris yapabilmesi icin Androidde post isteginde bulunabilecegimiz sayfa.
    public static String URL_GIRIS = "http://10.1.8.20:8080/android_login_api/login.php";
    //Sunucu tarafında ilgili tabloya deger ekleyebilmek icin kullanılır.
    public static String URL_MESAJ_GONDERME = "http://10.1.8.20:8080/android_login_api/add_post.php";
}
