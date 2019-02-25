package com.aytekincomez.whatsapptasarim.Activity;

import android.content.Intent;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import com.aytekincomez.whatsapptasarim.Adapter.FragmentPagerAdapter;
import com.aytekincomez.whatsapptasarim.R;

public class MainActivity extends AppCompatActivity {

    Toolbar toolbar;
    ViewPager viewPager;
    TabLayout tabLayout;
    FragmentPagerAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toolbar = (Toolbar)findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        this.getSupportActionBar().setTitle("");

        viewPager = (ViewPager)findViewById(R.id.viewPager);
        tabLayout = (TabLayout)findViewById(R.id.tabLayout);

        tabLayout.addTab(tabLayout.newTab().setText("SOHBETLER"));
        tabLayout.addTab(tabLayout.newTab().setText("DURUM"));
        tabLayout.addTab(tabLayout.newTab().setText("ARAMALAR"));
        tabLayout.setTabGravity(TabLayout.GRAVITY_FILL);

        adapter = new FragmentPagerAdapter(getSupportFragmentManager(), tabLayout.getTabCount());
        viewPager.setAdapter(adapter);

        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
        tabLayout.addOnTabSelectedListener(new TabLayout.ViewPagerOnTabSelectedListener(viewPager));
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        Intent intent = null;

        switch (item.getItemId()){
            case R.id.ayarlar:
                intent = new Intent(MainActivity.this, AyarlarActivity.class);
                startActivity(intent);
                break;
            case R.id.yeniTopluMesaj:
                break;
            case  R.id.yildizliMesaj:
                break;
            case R.id.whatsappWeb:
                break;
            case R.id.search:
                break;
            case R.id.message:
                break;
            case R.id.yeniGrup:
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}
