package com.aytekincomez.kanbagisiapp.Fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.aytekincomez.kanbagisiapp.Adapter.ListViewAdapter;
import com.aytekincomez.kanbagisiapp.Model.NewIlan;
import com.aytekincomez.kanbagisiapp.R;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class FragmentArananKanlar extends Fragment {

    private DatabaseReference mDatabase;
    ListView listView;
    ArrayList<NewIlan> arrayList = new ArrayList<>();
    ListViewAdapter adapter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.layout_fragment_aranankanlar, container, false);
        listView = (ListView)view.findViewById(R.id.listViewArananKan);
        mDatabase = FirebaseDatabase.getInstance().getReference();

        adapter = new ListViewAdapter(getContext(), arrayList);
        listView.setAdapter(adapter);
        //init();
        mDatabase.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                arrayList.clear();
                for (DataSnapshot ds: dataSnapshot.getChildren()){
                    NewIlan arananKanSatir = ds.getValue(NewIlan.class);
                    arrayList.add(arananKanSatir);
                }
                adapter.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Log.w("TAG", "loadPost:onCancelled", databaseError.toException());
            }
        });
        return view;
    }
}
