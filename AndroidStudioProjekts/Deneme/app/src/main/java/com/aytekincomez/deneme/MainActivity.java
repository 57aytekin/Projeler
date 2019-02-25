package com.aytekincomez.deneme;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    TextView scoreText, timeText;
    ImageView imageView, imageView1, imageView2, imageView3, imageView4, imageView5, imageView6, imageView7, imageView8;
    int score;
    Handler handler;
    Runnable runnable;
    ImageView[] imageArray;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imageView = (ImageView)findViewById(R.id.imageView);
        imageView1 = (ImageView) findViewById(R.id.imageView1);
        imageView2 = (ImageView) findViewById(R.id.imageView2);
        imageView3 = (ImageView) findViewById(R.id.imageView3);
        imageView4 = (ImageView) findViewById(R.id.imageView4);
        imageView5 = (ImageView) findViewById(R.id.imageView5);
        imageView6 = (ImageView) findViewById(R.id.imageView6);
        imageView7 = (ImageView) findViewById(R.id.imageView7);
        imageView8 = (ImageView) findViewById(R.id.imageView8);

        imageArray = new ImageView[] {imageView, imageView1, imageView2, imageView3, imageView4, imageView5, imageView6, imageView7, imageView8};
        resmiSakla();

        new CountDownTimer(5000,1000){

            @Override
            public void onTick(long l) {

                timeText = (TextView) findViewById(R.id.textTime);
                timeText.setText("Time: "+l/1000);
            }

            @Override
            public void onFinish() {

                timeText.setText("Game Over");

            }
        }.start();

    }

    public void secilen(View view){
        score++;
        scoreText = (TextView) findViewById(R.id.textScore);
        scoreText.setText("Score: "+score);
    }
    public void resmiSakla(){
        handler = new Handler();
        runnable = new Runnable() {
            @Override
            public void run() {
                for(ImageView i : imageArray){
                    i.setVisibility(View.INVISIBLE);
                }
                Random r = new Random();
                int sayi = r.nextInt(9-0);
                imageArray[sayi].setVisibility(View.VISIBLE);

                handler.postDelayed(this, 500);

            }
        };
        handler.post(runnable);
    }
}
