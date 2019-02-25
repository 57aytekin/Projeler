package com.aytekincomez.toplusmsgonderimi;

import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.provider.Contacts;
import android.provider.ContactsContract;
import android.support.v7.app.AppCompatActivity;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    EditText etMesaj;
    Button btnGonder, btnKisiEkle;
    ArrayList<String> telefonNumaralari;
    Thread thread;
    SmsManager smsManager;

    private void smsGonderThread(){
        thread = new Thread(){
            @Override
            public void run() {
              try {
                  Thread.sleep(2500);
                  for(int i=0; i<telefonNumaralari.size(); i++){
                      Thread.sleep(3000);
                      smsManager.sendTextMessage(
                              telefonNumaralari.get(i).toString(),
                              null,
                              etMesaj.getText().toString(),
                              null,
                              null
                      );
                  }
              }catch (Exception e){

              }
            };
        };
        thread.start();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        telefonNumaralari = new ArrayList<>();

        etMesaj = (EditText)findViewById(R.id.etMesaj);
        btnGonder = (Button)findViewById(R.id.btnGonder);
        btnKisiEkle = (Button)findViewById(R.id.btnKisiEkle);

        btnKisiEkle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_PICK, Contacts.CONTENT_URI);
                intent.setType(ContactsContract.CommonDataKinds.Phone.CONTENT_TYPE);
                startActivityForResult(intent, 10);
            }
        });

        btnGonder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                smsManager = SmsManager.getDefault();
                smsGonderThread();
                etMesaj.setText("");
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if(requestCode == 10){
            Cursor cursor = null;
            try {
                Uri uri = data.getData();
                cursor = getContentResolver().query(
                        uri,new String[]{
                                ContactsContract.CommonDataKinds.Phone.NUMBER
                        },
                        null,
                        null,
                        null
                );
                if(cursor != null){
                    while (cursor.moveToNext()){
                        String phone = cursor.getString(0);
                        telefonNumaralari.add(phone);

                        Toast.makeText(getApplicationContext(), phone, Toast.LENGTH_LONG).show();
                    }
                }
            }catch (Exception e){

            }
        }
    }
}
