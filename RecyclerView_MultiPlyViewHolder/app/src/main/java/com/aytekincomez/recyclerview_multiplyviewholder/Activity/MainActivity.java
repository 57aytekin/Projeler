package com.aytekincomez.recyclerview_multiplyviewholder.Activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.aytekincomez.recyclerview_multiplyviewholder.Adapter.CallSMSAdapter;
import com.aytekincomez.recyclerview_multiplyviewholder.Model.Call;
import com.aytekincomez.recyclerview_multiplyviewholder.Model.SMS;
import com.aytekincomez.recyclerview_multiplyviewholder.R;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private LinearLayoutManager linearLayoutManager;
    private List<Object> callSMSList;
    private CallSMSAdapter callSMSAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView=(RecyclerView)findViewById(R.id.recyclerView);
        // Set Layout Manager
        linearLayoutManager=new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);
        // Limiting the size
        recyclerView.setHasFixedSize(true);
        // Initialize list items
        init();
    }
    private void init(){
        callSMSList =new ArrayList<>();
        // Initiating Adapter
        callSMSAdapter =new CallSMSAdapter(MainActivity.this);
        recyclerView.setAdapter(callSMSAdapter);
        // Adding some demo data(Call &amp; SMS Objects).
        // You can get them from your data server
        callSMSList.add(new Call("John","9:30 AM"));
        callSMSList.add(new Call("Rob","9:40 AM"));
        callSMSList.add(new SMS("Sandy","Hey, what's up?","9:42 AM"));
        callSMSList.add(new Call("Peter","9:45 AM"));
        callSMSList.add(new SMS("John","Are you writing blog?","9:48 AM"));
        callSMSList.add(new Call("Jack","9:50 AM"));
        callSMSList.add(new Call("Bob","9:55 AM"));
        callSMSList.add(new SMS("Kora","Thanks dude","9:57 AM"));
        callSMSList.add(new Call("Sandy","10:00 AM"));
        callSMSList.add(new Call("Kate","10:05 AM"));
        callSMSList.add(new SMS("Nick","Let's hang up","10:10 AM"));
        callSMSList.add(new Call("Roger","10:15 AM"));
        callSMSList.add(new Call("Sid","10:20 AM"));
        callSMSList.add(new Call("Kora","10:25 AM"));
        callSMSList.add(new Call("Nick","10:30 AM"));
        callSMSList.add(new SMS("Rose","Bring me some chocolates","1035:10 AM"));
        callSMSList.add(new Call("Mia","10:40 AM"));
        callSMSList.add(new Call("Scott","10:45 AM"));
        // Set items to adapter
        callSMSAdapter.setCallSMSFeed(callSMSList);
        callSMSAdapter.notifyDataSetChanged();
    }
}
