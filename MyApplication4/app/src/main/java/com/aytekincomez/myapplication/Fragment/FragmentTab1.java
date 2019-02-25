package com.aytekincomez.myapplication.Fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.aytekincomez.myapplication.R;

public class FragmentTab1 extends Fragment {
    Context context;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable final ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.tab1, container, false);

        context = getActivity().getApplicationContext();

        final EditText etVeri = (EditText)view.findViewById(R.id.etGiris);
        Button btnKaydet = (Button)view.findViewById(R.id.btnVeriGoster);

        btnKaydet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(v.getContext(), etVeri.getText().toString(), Toast.LENGTH_LONG).show();
            }
        });
        return view;
    }
}
