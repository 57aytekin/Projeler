package com.aytekincomez.storingdata;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        SharedPreferences sharedPreferences = this.getSharedPreferences("com.aytekincomez.storingdata", Context.MODE_PRIVATE);

        int age = 40;
        //sharedPreferences.edit().putInt("userage", age).apply();

        int savedAge = sharedPreferences.getInt("userage", 0);
        System.out.println("Saved volue :"+savedAge);

        age = 10;
        sharedPreferences.edit().putInt("userage", age).apply();

        int savedAge2 = sharedPreferences.getInt("userage",0);
        System.out.println("Saved value :"+savedAge2);

        sharedPreferences.edit().remove("userage").apply();
        int saveAge3 = sharedPreferences.getInt("userage", 0);
        System.out.println("Saved value :"+saveAge3);


    }
}
