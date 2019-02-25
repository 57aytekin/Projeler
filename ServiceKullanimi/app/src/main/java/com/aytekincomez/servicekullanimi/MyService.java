package com.aytekincomez.servicekullanimi;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.util.Log;

public class MyService extends Service {

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        Log.d("SERVİS_DURUMU","OnCreate metodu calisti");
    }

    @Override
    public void onStart(Intent intent, int startId) {
        super.onStart(intent, startId);
        Log.d("SERVİS_DURUMU","OnStart metodu calisti");
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.d("SERVİS_DURUMU","onDestroy metodu calisti");
    }
}
