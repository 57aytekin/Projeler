package com.aytekincomez.menuozellestirme;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    Toolbar toolbar;
    TextView toolbar_Baslik;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toolbar = (Toolbar)findViewById(R.id.toolBar);
        toolbar_Baslik = (TextView)findViewById(R.id.toolbarBaslik);

        //this.getSupportActionBar().hide();

        toolbar_Baslik.setText("Activity Baaşlığı");

        this.setSupportActionBar(toolbar);
        this.getSupportActionBar().setDisplayShowTitleEnabled(false);
        this.getSupportActionBar().setDisplayHomeAsUpEnabled(true);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        if(item.getItemId() == R.id.ayarlar){
            startActivity(new Intent(MainActivity.this, AyarlarActivity.class));

        }else if(item.getItemId() == R.id.iletisim){
            startActivity(new Intent(MainActivity.this, IletisimActivity.class));
        }else if(item.getItemId() == R.id.arama){
            Intent intent = new Intent(Intent.ACTION_VIEW);
            Uri uri = Uri.parse("tel:+905319102510");
            intent.setData(uri);
            startActivity(intent);
        }
        return super.onOptionsItemSelected(item);
    }
}
