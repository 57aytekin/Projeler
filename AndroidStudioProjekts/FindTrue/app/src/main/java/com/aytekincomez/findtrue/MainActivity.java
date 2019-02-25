package com.aytekincomez.findtrue;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void changeImage(View view) {
        ImageView imageView = (ImageView)findViewById(R.id.bulB1);
        imageView.setImageResource(R.drawable.cartman);

    }
    public void changeImage1(View view) {
        ImageView imageView1 = (ImageView)findViewById(R.id.bulB2);
        imageView1.setImageResource(R.drawable.kenny);
    }

    public void changeImage3(View view) {
        ImageView imageView3 = (ImageView)findViewById(R.id.bulB3);
        imageView3.setImageResource(R.drawable.kyle);
    }

    public void changeImage2(View view) {
        ImageView imageView2 = (ImageView)findViewById(R.id.bulB4);
        imageView2.setImageResource(R.drawable.stan);
    }
}
