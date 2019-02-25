package com.aytekincomez.instagramclonu;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.parse.FindCallback;
import com.parse.GetDataCallback;
import com.parse.ParseException;
import com.parse.ParseFile;
import com.parse.ParseObject;
import com.parse.ParseQuery;

import java.util.ArrayList;
import java.util.List;

public class FeedActivity extends AppCompatActivity {

    ArrayList<String> usernameFromParse;
    ArrayList<Bitmap> userimageFromParse;
    ArrayList<String> usercommentFromParse;
    ListView listView;
    PostClass adapter;

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        MenuInflater menuInflater= getMenuInflater();
        menuInflater.inflate(R.menu.add_post,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(item.getItemId() == R.id.add_post){
            Intent intent = new Intent(getApplicationContext(), UploadActivity.class);
            startActivity(intent);
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_feed);

        usernameFromParse = new ArrayList<String>();
        userimageFromParse = new ArrayList<Bitmap>();
        usercommentFromParse = new ArrayList<String>();

        adapter = new PostClass(usernameFromParse,userimageFromParse,usercommentFromParse,this);

        listView = (ListView) findViewById(R.id.listVİew);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                Toast.makeText(getApplicationContext(),usernameFromParse.get(position)+"'in Resmi Begenildi.",Toast.LENGTH_LONG).show();
            }
        });

        getParseData();
    }

    public void getParseData(){
        ParseQuery<ParseObject> query = ParseQuery.getQuery("Posts");
        query.findInBackground(new FindCallback<ParseObject>() {
            @Override
            public void done(List<ParseObject> objects, ParseException e) {
                if(e == null){

                    if(objects.size() > 0){

                        for(final ParseObject parseObject : objects){
                            ParseFile parseFile = (ParseFile) parseObject.get("image");

                            parseFile.getDataInBackground(new GetDataCallback() {
                                @Override
                                public void done(byte[] data, ParseException e) {
                                    if(e == null && data != null){
                                        Bitmap bitmap = BitmapFactory.decodeByteArray(data, 0, data.length);

                                        userimageFromParse.add(bitmap);
                                        usernameFromParse.add(parseObject.getString("username"));
                                        usercommentFromParse.add(parseObject.getString("comment"));
                                        adapter.notifyDataSetChanged();
                                    }
                                    else{

                                    }

                                }
                            });

                        }
                    }
                }
                else{
                    Toast.makeText(getApplication(),e.getLocalizedMessage().toString(),Toast.LENGTH_LONG).show();
                }
            }
        });
    }
}
















