package com.aytekincomez.hesaplamalar.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.aytekincomez.hesaplamalar.Activity.SigaraMaliyeti_HesaplamaActivity;
import com.aytekincomez.hesaplamalar.Activity.VKI_HesaplamaActivity;
import com.aytekincomez.hesaplamalar.Activity.Yas_HesaplamaActivity;
import com.aytekincomez.hesaplamalar.R;

public class ViewTabFragmentSaglikHesaplamalari extends Fragment {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.view_tabfragment_saglik_hesaplamalari,
                                            container, false);

        Button btn = (Button)view.findViewById(R.id.btnVKI);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(new Intent(view.getContext(), VKI_HesaplamaActivity.class));
            }
        });

        Button btnYasHesaplama = (Button)view.findViewById(R.id.btnYasHesaplama);
        btnYasHesaplama.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(view.getContext(), Yas_HesaplamaActivity.class));
            }
        });

        Button btnsigaraMaliyetiHesaplama = (Button)view.findViewById(R.id.btnSigaraMaliyetiHesaplama);
        btnsigaraMaliyetiHesaplama.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(view.getContext(), SigaraMaliyeti_HesaplamaActivity.class));
            }
        });
        return  view;
    }
}