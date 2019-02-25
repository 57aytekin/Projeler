package com.aytekincomez.yemektarifiapp.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Window;
import android.view.WindowManager;

import com.aytekincomez.yemektarifiapp.R;
import com.flaviofaria.kenburnsview.KenBurnsView;

import java.util.Random;

public class SplashActivity extends AppCompatActivity {

    KenBurnsView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_splash);

        getSupportActionBar().hide();

        imageView = findViewById(R.id.imageView);
        String[] appBackgrounds = {"app_bg_001","app_bg_002","app_bg_003","app_bg_004"};
        int randomId = new Random().nextInt(appBackgrounds.length);
        String rastgeleDonenDeger = appBackgrounds[randomId];

        int resorceId = getResources().getIdentifier(rastgeleDonenDeger,"drawable",getPackageName());
        imageView.setImageResource(resorceId);
        new SayfaGecisi().start();
    }

    private class SayfaGecisi extends Thread{
        @Override
        public void run() {
            super.run();

            try {
                Thread.sleep(5000);
            }catch (Exception e){

            }finally {
                startActivity(new Intent(SplashActivity.this, KategoriActivity.class));
                finish();
            }
        }
    }
}
