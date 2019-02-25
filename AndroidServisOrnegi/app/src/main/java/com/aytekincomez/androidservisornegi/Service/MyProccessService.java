package com.aytekincomez.androidservisornegi.Service;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.util.Log;

import java.util.Timer;
import java.util.TimerTask;

public class MyProccessService extends Service {
    Timer timer;
    TimerTask timerTask;
    int i = 0;

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        Log.d("SERVİCE_LOG","Servis Olusturuldu.");
    }

    @Override
    public void onStart(Intent intent, int startId) {
        super.onStart(intent, startId);

    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.d("SERVİCE_LOG","Servis Sonlandirildi");
    }

}
