package com.aytekincomez.toplusmsgonderimi;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    EditText etMesaj;
    Button btnGonder;
    String[] mobilPhoneNumbers;
    private Thread myThread;
    SmsManager smsManager;

    private void islemThread(){
        myThread = new Thread(){
            @Override
            public void run() {
                try{
                    Thread.sleep(3500);
                    for(int i =0; i<mobilPhoneNumbers.length; i++){
                        Thread.sleep(500);
                        //smsManager
                        smsManager.sendTextMessage(
                                mobilPhoneNumbers[i].toString(),
                                null,
                                etMesaj.getText().toString(),
                                null,null);
                    }
                }catch (Exception e){

                }
            }
        };
        myThread.start();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mobilPhoneNumbers = new String[3];
        mobilPhoneNumbers[0] = "TEL1";
        mobilPhoneNumbers[1] = "TEL1";
        mobilPhoneNumbers[2] = "TEL1";

        etMesaj = (EditText)findViewById(R.id.etMesaj);
        btnGonder = (Button)findViewById(R.id.btnGonder);
        btnGonder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                smsManager = SmsManager.getDefault();
                try{
                    islemThread();
                }catch (Exception e){

                }
            }
        });
    }
}
