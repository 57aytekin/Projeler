package com.aytekincomez.servicekullanimi;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button btnBasla, btnBitir;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnBasla = (Button)findViewById(R.id.btnBasla);
        btnBasla.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startService(new Intent(getApplicationContext(), MyService.class));
                btnBasla.setEnabled(false);
                btnBitir.setEnabled(true);
            }
        });

        btnBitir = (Button)findViewById(R.id.btnDurdur);
        btnBitir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                stopService(new Intent(getApplicationContext(), MyService.class));
                btnBasla.setEnabled(true);
                btnBitir.setEnabled(false);
            }
        });
    }
}
