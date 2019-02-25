package com.aytekincomez.dosyaislemleri;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class MainActivity extends AppCompatActivity {

    EditText etYazi;
    Button btn, btn2;

    private static String DOSYA_ADI = "mesaj.txt";
    private static String DIZIN_ISMI = "birdizin";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etYazi = (EditText)findViewById(R.id.etYazi);
        btn = (Button) findViewById(R.id.btnGonder);
        btn2 = (Button) findViewById(R.id.btnOku);

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                File dizin = getDir(DIZIN_ISMI, MODE_APPEND);
                File dossya = new File(dizin, DOSYA_ADI);
                try{
                    FileInputStream fileInputStream = new FileInputStream(dossya);
                    dosyayiOku(fileInputStream);
                }catch (IOException e){

                }
            }
        });
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try{
                    File dizin = getDir(DIZIN_ISMI, MODE_APPEND);
                    File dossya = new File(dizin, DOSYA_ADI);
                    FileOutputStream fileOut = new FileOutputStream(dossya);

                    Log.d("DOSYA_ISLEMI", dossya.getPath());

                    try {
                        dosyayiKaydet(fileOut);
                        setTitle("Dosya Kaydedildi.");

                    }catch (IOException e){
                        setTitle("Dosya Kaydedilemedi.");
                    }
                }catch (Exception e){

                }
            }
        });
    }

    private void dosyayiOku(FileInputStream fileInputStream) throws IOException{
        BufferedReader fileInBuffer = new BufferedReader(
                new InputStreamReader(fileInputStream)
        );
        String text = "";
        String satir;

        try {
            while ((satir = fileInBuffer.readLine()) != null){
                text += satir;
            }
        }catch (IOException e){

        }finally {
            Log.d("DOSYA_ISLEMI",text);
            //etYazi.setText(text);
            fileInBuffer.close();
        }
    }

    private void dosyayiKaydet(FileOutputStream fileOutputStream) throws IOException{
        OutputStreamWriter writer = new OutputStreamWriter(fileOutputStream);
        String metin = etYazi.getText().toString();
        try{
            writer.write(metin);
        }catch (IOException e){

        }finally {
            if(writer != null){
                writer.close();
            }
        }
    }
}
