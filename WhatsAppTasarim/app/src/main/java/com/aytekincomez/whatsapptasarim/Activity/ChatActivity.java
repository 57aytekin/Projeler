package com.aytekincomez.whatsapptasarim.Activity;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.aytekincomez.whatsapptasarim.R;

public class ChatActivity extends AppCompatActivity {

    LinearLayout linearLayout;
    ImageView btnSendMessage;
    EditText etMessage;


    public void doldur(String mesaj, boolean gondericiSemMisin){

        LinearLayout linear = new LinearLayout(this);
        linear.setOrientation(LinearLayout.VERTICAL);
        linear.setGravity(Gravity.RIGHT);

        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.WRAP_CONTENT,
                LinearLayout.LayoutParams.WRAP_CONTENT
        );
        layoutParams.setMargins(5,5,5,5);

        if(gondericiSemMisin){
            linear.setBackgroundResource(R.color.colorMyTextBackground);
            layoutParams.gravity = Gravity.RIGHT;

        }else{
            linear.setBackgroundResource(R.color.colorSenderTextBackground);
            layoutParams.gravity = Gravity.LEFT;
        }

        TextView tv = new TextView(this);
        tv.setText(mesaj);
        tv.setTextColor(Color.parseColor("#000000"));
        tv.setTextSize(18f);

        tv.setLayoutParams(layoutParams);
        tv.setPadding(5,5,5,5);
        linear.addView(tv);

        linearLayout.addView(linear, layoutParams);

    }

    private void ekle(String icerik){
        LinearLayout linear = new LinearLayout(this);
        linear.setOrientation(LinearLayout.VERTICAL);
        linear.setGravity(Gravity.RIGHT);
        linear.setBackgroundResource(R.color.colorMyTextBackground);

        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.WRAP_CONTENT,
                LinearLayout.LayoutParams.WRAP_CONTENT
        );
        layoutParams.setMargins(10,10,10,10);
        linear.setLayoutParams(layoutParams);
        layoutParams.gravity = Gravity.RIGHT;

        TextView tv = new TextView(this);
        tv.setText(icerik);
        tv.setTextColor(Color.parseColor("#000000"));
        tv.setTextSize(18f);
        tv.setPadding(10,10,10,10);
        linear.addView(tv);

        linearLayout.addView(linear);
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat);

        linearLayout = (LinearLayout)findViewById(R.id.linearLayoutChat);
        doldur("Selam Nasılsın",true);
        doldur("İyiyim, sen nasılsın",false);

        String adSoyad = getIntent().getStringExtra("adsoyad");

        int userid = getIntent().getIntExtra("userid",0);
        this.setTitle(adSoyad);
        this.getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        etMessage = (EditText)findViewById(R.id.etMessage);

        btnSendMessage = (ImageView)findViewById(R.id.btnSendMessage);
        btnSendMessage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ekle(etMessage.getText().toString());
            }
        });
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case android.R.id.home:
                finish();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
