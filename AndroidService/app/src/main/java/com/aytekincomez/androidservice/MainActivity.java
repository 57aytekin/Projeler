package com.aytekincomez.androidservice;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button btnBasla, btnBitir;

    private BroadcastReceiver mReceiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            Bundle bundle = intent.getExtras();
            Toast.makeText(MainActivity.this, bundle.getString("mesaj"), Toast.LENGTH_LONG).show();
        }
    };

    @Override
    protected void onPause() {
        getApplicationContext().unregisterReceiver(mReceiver);
        super.onPause();
    }

    @Override
    protected void onResume() {
        super.onResume();
        getApplicationContext().registerReceiver(mReceiver,
                new IntentFilter(BasitServis.ACTION_BROADCAST));
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnBasla = (Button)findViewById(R.id.bnBasla);
        btnBitir = (Button)findViewById(R.id.btnBitir);

        btnBasla.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startService(new Intent(getApplicationContext(), BasitServis.class));
                btnBasla.setEnabled(false);
                btnBitir.setEnabled(true);
            }
        });

        btnBitir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                stopService(new Intent(getApplicationContext(), BasitServis.class));
                btnBasla.setEnabled(true);
                btnBitir.setEnabled(false);
            }
        });
    }
}
