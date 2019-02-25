package com.aytekincomez.firebasedatabase.Activity;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.GridView;

import com.aytekincomez.firebasedatabase.Adapter.GridAdapter;
import com.aytekincomez.firebasedatabase.Model.User;
import com.aytekincomez.firebasedatabase.R;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class ListeleActivity extends AppCompatActivity {

    ArrayList<User> users;
    Button btnListele;
    GridAdapter gridAdapter;
    GridView gridView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listele);
        users = new ArrayList<>();
        gridAdapter = new GridAdapter(this, users);
        gridView = (GridView)findViewById(R.id.gridView);

        btnListele = (Button)findViewById(R.id.btnListele);
        btnListele.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                /*
                for(int i=0; i<users.size(); i++){
                    Log.d("UYE",users.get(i).getAd());
                }*/
                gridView.setAdapter(gridAdapter);
            }
        });

        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myRef = database.getReference();

        myRef.child("users").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                for(DataSnapshot postSnapshot : dataSnapshot.getChildren()){
                    User user = postSnapshot.getValue(User.class);
                    users.add(new User(
                            user.getEmail(),
                            user.getSifre(),
                            user.getAd(),
                            user.getSoyad()
                    ));
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }
}
