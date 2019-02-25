package com.aytekincomez.contentproviderrehber;

import android.app.ListActivity;
import android.database.Cursor;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends ListActivity implements AdapterView.OnItemClickListener {
    ArrayAdapter<String> adapter;
    ListView liste;
    ArrayList<String> arrayList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        kisileriGoster();
        liste = (ListView)findViewById(R.id.listView);
        arrayList = new ArrayList<>();

    }

    private void kisileriGoster(){
        //Uri uri = Uri.parse("content://icc/adn"); Sim kartindaki kisiler
        Cursor cursor = getContentResolver().query(
                ContactsContract.Data.CONTENT_URI, null,null,null,
                ContactsContract.Data.CONTACT_ID + " ASC"
        );

        while (cursor.moveToNext()){
            Log.d("Kişiler","Kişi"+cursor.getString(0));
            Log.d("Kişiler","Kişi"+cursor.getString(1));
        }
        cursor.close();
        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_2, android.R.id.text2,arrayList);
        liste.setAdapter(adapter);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

    }
}
