package com.aytekincomez.kanbagisiapp.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Html;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextView;

import com.aytekincomez.kanbagisiapp.R;

public class SplashActivity extends AppCompatActivity {
    TextView tvBiKan, tvBirInsan, tvElEle;
    Animation fromBottom, fromLeft, fromRight;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_splash);
        getSupportActionBar().hide();

        tvBiKan = (TextView)findViewById(R.id.tvBirKan);
        tvBirInsan = (TextView)findViewById(R.id.tvBirInsan);
        tvElEle = (TextView)findViewById(R.id.tvElEle);

        String next = "<font color='#F51818'>KAN</font>";
        tvBiKan.setText(Html.fromHtml("Bi'"+next+" VER"));
        fromBottom = AnimationUtils.loadAnimation(this, R.anim.frombottom);
        fromLeft = AnimationUtils.loadAnimation(this, R.anim.fromleft);
        fromRight = AnimationUtils.loadAnimation(this, R.anim.fromright);

        tvBiKan.startAnimation(fromLeft);
        new AraThread().start();
        tvBirInsan.startAnimation(fromRight);
        new AraThread().start();
        tvElEle.startAnimation(fromBottom);
        new EndThread().start();



    }

    public class AraThread extends Thread{
        @Override
        public void run() {

            try {
                Thread.sleep(2000);
                tvElEle.startAnimation(fromBottom);
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }
    public class EndThread extends Thread{
        @Override
        public void run() {

            try {
                Thread.sleep(3000);
                tvElEle.startAnimation(fromBottom);
            }catch (Exception e){
                e.printStackTrace();
            }finally {
                startActivity(new Intent(SplashActivity.this, LoginActivity.class));
            }
        }
    }
}
