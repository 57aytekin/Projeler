package com.aytekincomez.websitegoruntuleyici.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextView;

import com.aytekincomez.websitegoruntuleyici.R;

public class SplashActivity extends AppCompatActivity {
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        getSupportActionBar().hide();

        textView = (TextView)findViewById(R.id.textView);
        Animation a = AnimationUtils.loadAnimation(this, R.anim.scale);
        a.reset();
        textView.clearAnimation();
        textView.startAnimation(a);

        new mySplash().start();
    }

    public class mySplash extends Thread{
        @Override
        public void run() {
            try {
                Thread.sleep(5000);
            }catch (Exception e){
                e.printStackTrace();
            }finally {
                startActivity(new Intent(SplashActivity.this, MainActivity.class));
                finish();
            }
        }
    }
}
