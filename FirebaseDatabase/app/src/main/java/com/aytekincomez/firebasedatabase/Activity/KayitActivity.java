package com.aytekincomez.firebasedatabase.Activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.aytekincomez.firebasedatabase.R;
import com.aytekincomez.firebasedatabase.Model.User;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class KayitActivity extends AppCompatActivity {

    EditText etEmail, etSifre, etAd, etSoyad;
    Button btnKaydet;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kayit);

        etEmail = (EditText)findViewById(R.id.etEmail);
        etSifre = (EditText)findViewById(R.id.etSifre);
        etAd = (EditText)findViewById(R.id.etAd);
        etSoyad = (EditText)findViewById(R.id.etSoyad);
        btnKaydet = (Button)findViewById(R.id.btnKaydet);
        btnKaydet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DatabaseReference dbRef = FirebaseDatabase.getInstance().getReference().child("users");
                dbRef.push().setValue(
                        new User(
                                etEmail.getText().toString(),
                                etSifre.getText().toString(),
                                etAd.getText().toString(),
                                etSoyad.getText().toString()
                        )
                );
            }
        });
    }
}
