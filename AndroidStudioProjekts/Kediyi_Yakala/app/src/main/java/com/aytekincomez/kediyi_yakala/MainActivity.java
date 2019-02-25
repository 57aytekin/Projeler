package com.aytekincomez.kediyi_yakala;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    TextView scoreText;
    TextView timeText;
    ImageView imageView1, imageView2, imageView3, imageView4, imageView5, imageView6, imageView7, imageView8, imageView9, imageView10, imageView11, imageView12, imageView13, imageView14, imageView15, imageView16;
    int score;
    ImageView[] imageArray;
    Handler handler;
    Runnable runnable;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        imageView1 = (ImageView) findViewById(R.id.imageView);
        imageView2 = (ImageView) findViewById(R.id.imageView1);
        imageView3 = (ImageView) findViewById(R.id.imageView2);
        imageView4 = (ImageView) findViewById(R.id.imageView3);
        imageView5 = (ImageView) findViewById(R.id.imageView4);
        imageView6 = (ImageView) findViewById(R.id.imageView5);
        imageView7 = (ImageView) findViewById(R.id.imageView6);
        imageView8 = (ImageView) findViewById(R.id.imageView7);
        imageView9 = (ImageView) findViewById(R.id.imageView8);
        imageView10 = (ImageView) findViewById(R.id.imageView9);
        imageView11 = (ImageView) findViewById(R.id.imageView10);
        imageView12 = (ImageView) findViewById(R.id.imageView11);
        imageView13 = (ImageView) findViewById(R.id.imageView12);
        imageView14 = (ImageView) findViewById(R.id.imageView13);
        imageView15 = (ImageView) findViewById(R.id.imageView14);
        imageView16 = (ImageView) findViewById(R.id.imageView15);

        imageArray = new ImageView[]{imageView1,imageView2,imageView3,imageView4,imageView5,imageView6,imageView7,imageView8,imageView9,imageView10,imageView11,imageView12,imageView13,imageView14,imageView15,imageView16};

        hideImages();

        score = 0;

        new CountDownTimer(60000,1000){

            @Override
            public void onTick(long l) {
                timeText = (TextView) findViewById(R.id.textTime);
                timeText.setText("Time: "+l / 1000);
            }

            @Override
            public void onFinish() {
                timeText = (TextView) findViewById(R.id.textTime);
                timeText.setText("Game Over");

                handler.removeCallbacks(runnable );
                for(ImageView i : imageArray){
                    i.setVisibility(View.INVISIBLE);
                }
            }
        }.start();
    }

    public void skorArttir(View view){
        scoreText = (TextView) findViewById(R.id.textScore);
        score++;
        scoreText.setText("Score: "+score);
    }

    public void skorAzalt(View view){
        scoreText = (TextView) findViewById(R.id.textScore);
        if(score > 0){
            score--;
        }
        scoreText.setText("Score: "+score);
    }

    public void hideImages(){

        handler = new Handler();
        runnable = new Runnable() {
            @Override
            public void run() {

                for(ImageView image : imageArray){
                    image.setVisibility(View.INVISIBLE);
                }

                Random r = new Random();
                int i = r.nextInt(16-0);
                imageArray[i].setVisibility(View.VISIBLE);

                handler.postDelayed(this, 500);
            }
        };
        handler.post(runnable);

    }
}














