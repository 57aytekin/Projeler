package com.aytekincomez.kanbagisiapp.Activity;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.Html;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import com.aytekincomez.kanbagisiapp.Fragment.FragmentArananKanlar;
import com.aytekincomez.kanbagisiapp.Fragment.FragmentIlanEkle;
import com.aytekincomez.kanbagisiapp.R;

public class MainActivity extends AppCompatActivity {

    TabLayout tabLayout;
    TextView tvTool;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);

        tvTool = (TextView)findViewById(R.id.tvTool);
        String next = "<font color='#F51818'>KAN</font>";
        tvTool.setText(Html.fromHtml("Bi'"+next+" VER"));
        tabLayout = (TabLayout) findViewById(R.id.tabs);
        tabLayout.addTab(tabLayout.newTab().setText("Aranan Kanlar"));
        tabLayout.addTab(tabLayout.newTab().setText("İlan Ekle"));
        tabLayout.addTab(tabLayout.newTab().setText("İlan Ekle"));
        tabLayout.setTabGravity(TabLayout.GRAVITY_FILL);
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.container, new FragmentArananKanlar());
        fragmentTransaction.commit();

        tabLayout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            Fragment fragment = null;
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                switch (tab.getPosition()){
                    case 0:
                        fragment = new FragmentArananKanlar();
                        break;
                    case 1:
                        fragment = new FragmentIlanEkle();
                        break;
                    case 2:
                        fragment = new FragmentIlanEkle();
                        break;
                }
                FragmentManager fragmentManager = getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.container, fragment);
                fragmentTransaction.commit();
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
