package com.aytekincomez.kediyiyakala;

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
    ImageView imageView, imageView2, imageView3, imageView4, imageView5, imageView6, imageView7, imageView8, imageView9;
    int score;
    ImageView[] imageArray;
    Handler handler;
    Runnable runnable;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imageView = (ImageView) findViewById(R.id.imageView);
        imageView2 = (ImageView) findViewById(R.id.imageView2);
        imageView3 = (ImageView) findViewById(R.id.imageView3);
        imageView4 = (ImageView) findViewById(R.id.imageView4);
        imageView5 = (ImageView) findViewById(R.id.imageView5);
        imageView6 = (ImageView) findViewById(R.id.imageView6);
        imageView7 = (ImageView) findViewById(R.id.imageView7);
        imageView8 = (ImageView) findViewById(R.id.imageView8);
        imageView9 = (ImageView) findViewById(R.id.imageView9);

        imageArray = new ImageView[]{imageView, imageView2, imageView3, imageView4, imageView5, imageView6, imageView7, imageView8, imageView9};

        score = 0;
        hideImages();

        new CountDownTimer(5000,1000){

            @Override
            public void onTick(long l) {

                timeText = (TextView ) findViewById(R.id.textTime);
                timeText.setText("Time: "+l/1000);
            }

            @Override
            public void onFinish() {
                timeText = (TextView) findViewById(R.id.textTime);
                timeText.setText("Game Over");
                handler.removeCallbacks(runnable);
                for(ImageView resim : imageArray){
                    resim.setVisibility(View.INVISIBLE);
                }
            }
        }.start();
    }

    public void increaseScore (View view){
        scoreText = (TextView) findViewById(R.id.textScore);
        score++;
        scoreText.setText("Score: "+score);

    }

    public void  hideImages(){

        handler = new Handler();
        runnable = new Runnable() {
            @Override
            public void run() {
                for(ImageView image : imageArray) {
                    image.setVisibility(View.INVISIBLE);
                }
                Random r = new Random();
                int i = r.nextInt(9-0);
                imageArray[i].setVisibility(View.VISIBLE);

                handler.postDelayed(this, 500);
            }
        };
        handler.post(runnable);

    }

}









