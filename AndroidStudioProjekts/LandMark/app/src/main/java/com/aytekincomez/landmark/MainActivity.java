package com.aytekincomez.landmark;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    static Bitmap selectedImages;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListView listView = (ListView) findViewById(R.id.listView);

        final ArrayList<String> landMarkNames = new ArrayList<>();
        landMarkNames.add("Pisa");
        landMarkNames.add("Collesium");
        landMarkNames.add("Eifel");
        landMarkNames.add("London Bridge");

        Bitmap pisa = BitmapFactory.decodeResource(getApplicationContext().getResources(), R.drawable.pisatower);
        Bitmap colleseum = BitmapFactory.decodeResource(getApplicationContext().getResources(), R.drawable.colleseum);
        Bitmap eifel = BitmapFactory.decodeResource(getApplicationContext().getResources(), R.drawable.eiffel);
        Bitmap london = BitmapFactory.decodeResource(getApplicationContext().getResources(), R.drawable.london);

        final ArrayList<Bitmap> landMarkImages = new ArrayList<>();
        landMarkImages.add(pisa);
        landMarkImages.add(colleseum);
        landMarkImages.add(eifel);
        landMarkImages.add(london);

        ArrayAdapter arrayAdapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, landMarkNames);
        listView.setAdapter(arrayAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(getApplicationContext(), Main2Activity.class);
                intent.putExtra("name",landMarkNames.get(i));
                //selectedImages = landMarkImages.get(i);

                Bitmap bitmap = landMarkImages.get(i);
                Globals globals = Globals.getInstance();
                globals.setData(bitmap);

                startActivity(intent);
            }
        });
    }
}








