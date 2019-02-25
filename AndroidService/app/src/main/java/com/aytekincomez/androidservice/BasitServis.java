package com.aytekincomez.androidservice;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.util.Log;

import java.util.Timer;
import java.util.TimerTask;

public class BasitServis extends Service {

    private MiniServiceBinder mBinder = new MiniServiceBinder();
    public class MiniServiceBinder extends Binder{}

    private Timer mTimer;
    private long mStartTime;

    static String ACTION_BROADCAST = "Bu bir BroadCast";

    private TimerTask mTimerTast = new TimerTask() {
        @Override
        public void run() {
            long currentTime = System.currentTimeMillis();

            final Intent broadcastIntent = new Intent(ACTION_BROADCAST);
            broadcastIntent.putExtra("mesaj",
                        String.valueOf((int) (currentTime - mStartTime) /1000)

            );

            getApplicationContext().sendBroadcast(broadcastIntent);
        }
    };
    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return mBinder;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        Log.d("SERVİCE_DURUM","onCreate metodu calisti.");
        mTimer = new Timer();
        mStartTime = System.currentTimeMillis();

    }

    @Override
    public void onStart(Intent intent, int startId) {
        super.onStart(intent, startId);
        Log.d("SERVİCE_DURUM","onStart metodu calisti.");
        mTimer.scheduleAtFixedRate(mTimerTast, 0, 1000);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        mTimer.cancel();
        Log.d("SERVİCE_DURUM","onDestroy metodu calisti.");
    }
}
