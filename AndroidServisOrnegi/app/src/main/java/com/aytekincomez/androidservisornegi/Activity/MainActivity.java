package com.aytekincomez.androidservisornegi.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.ToggleButton;

import com.aytekincomez.androidservisornegi.R;
import com.aytekincomez.androidservisornegi.Service.MyProccessService;

import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity {
    ToggleButton toggleButton;
    Timer timer;
    TimerTask timerTask;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final int[] renkler = {
          android.R.color.holo_blue_bright,
          android.R.color.holo_orange_dark,
          android.R.color.holo_red_dark,
          android.R.color.holo_green_dark,
          android.R.color.holo_purple
        };
        View v = findViewById(R.id.reletive);
        final View root = v.getRootView();

        timer = new Timer();
        timerTask = new TimerTask() {
            @Override
            public void run() {

                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        int sayi = new Random().nextInt(4);
                        root.setBackgroundColor(renkler[sayi]);
                    }
                });
            }
        };
        timer.scheduleAtFixedRate(timerTask,0,5000);

        toggleButton = findViewById(R.id.toggleButton);
        toggleButton.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                Intent intent = new Intent(MainActivity.this, MyProccessService.class);
                if (isChecked){
                    startService(intent);
                }else{
                    stopService(intent);
                }
            }
        });
    }
}
