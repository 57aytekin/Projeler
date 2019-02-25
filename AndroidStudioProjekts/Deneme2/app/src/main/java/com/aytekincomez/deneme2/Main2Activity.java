package com.aytekincomez.deneme2;

import android.content.Intent;
import android.graphics.Bitmap;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class Main2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        ImageView imageView = (ImageView) findViewById(R.id.imageView);
        TextView textView = (TextView) findViewById(R.id.textView);

        Intent intent = getIntent();

        String name = intent.getStringExtra("name");
        textView.setText(name);

        //imageView.setImageBitmap(MainActivity.selectedImages);
        Globals globals = Globals.getInstance();

        Bitmap bitmap = globals.getData();
        imageView.setImageBitmap(bitmap);
    }
}
