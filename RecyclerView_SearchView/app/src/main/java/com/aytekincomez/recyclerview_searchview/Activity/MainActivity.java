package com.aytekincomez.recyclerview_searchview.Activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.SearchView;

import com.aytekincomez.recyclerview_searchview.Adapter.UlkeAdapter;
import com.aytekincomez.recyclerview_searchview.Model.Ulke;
import com.aytekincomez.recyclerview_searchview.R;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements android.support.v7.widget.SearchView.OnQueryTextListener {
    SearchView searchView;
    RecyclerView recyclerView;
    UlkeAdapter adapter;
    List<Ulke> ulkeler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerView);
        ulkeler = new ArrayList<>();
        ulkeler.add(new Ulke("Algeria","flag_algaria","533","Cezayir",1800));
        ulkeler.add(new Ulke("Belgium","flag_belgium","533","Brüksel",1800));
        ulkeler.add(new Ulke("Egpty","flag_egypt","533","Kahire",1800));
        ulkeler.add(new Ulke("Greece","flag_greece","533","Atina",1800));
        ulkeler.add(new Ulke("India","flag_hindistan","533","Delhi",1800));
        ulkeler.add(new Ulke("Norway","flag_norway","533","Olso",1800));
        ulkeler.add(new Ulke("USA","flag_usa","533","Washington",1800));
        adapter = new UlkeAdapter(ulkeler,getApplicationContext());
        recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        recyclerView.setAdapter(adapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);

        MenuItem menuItem = menu.findItem(R.id.app_bar_search);
        //searchView = (SearchView) menuItem.getActionView();
        //searchView.setOnQueryTextListener(getApplicationContext());
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onQueryTextSubmit(String s) {
        return false;
    }

    @Override
    public boolean onQueryTextChange(String s) {
        return false;
    }
}
