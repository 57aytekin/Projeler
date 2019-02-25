package com.aytekincomez.nodejsfirstproject;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.github.nkzawa.emitter.Emitter;
import com.github.nkzawa.socketio.client.IO;
import com.github.nkzawa.socketio.client.Socket;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    EditText etMesaj;
    Button btnGonder, btnBaglan;
    TextView tvDurum;
    Socket socket;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etMesaj = findViewById(R.id.etMesaj);
        tvDurum = findViewById(R.id.tvDurum);
        btnGonder = findViewById(R.id.btnGonder);
        btnBaglan = findViewById(R.id.btnBaglan);

        try {
            socket = IO.socket("http://192.168.49.1:3001");
        }catch (Exception e){

        }
        socket.on("mesajAl", new Emitter.Listener() {
            @Override
            public void call(Object... args) {
                Random random = new Random();
                int sayi = random.nextInt(6000);
                
                //Log.d("RESPONSE",args[0].toString());
            }
        });

        btnBaglan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                socket.connect();
            }
        });
        btnGonder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                socket.emit("mesaj",etMesaj.getText().toString());
            }
        });

    }
}
