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

import com.aytekincomez.hesaplamalar.Activity.Kdv_HesaplamaActivity;
import com.aytekincomez.hesaplamalar.Activity.Maas_HesaplamaActivity;
import com.aytekincomez.hesaplamalar.R;

public class ViewTabFragmentMuhasebeHesaplamalari extends Fragment {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.view_tabfragment_muhasebe_hesaplamalari,
                container, false);

        Button btnMuhasebe_MaasHesaplama = (Button)view.findViewById(R.id.btnMuhasebe_MaasHesaplama);
        btnMuhasebe_MaasHesaplama.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(view.getContext(), Maas_HesaplamaActivity.class));
            }
        });

        Button btnKdvHesaplama = (Button)view.findViewById(R.id.btnKdvHesapla);
        btnKdvHesaplama.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(view.getContext(), Kdv_HesaplamaActivity.class));
            }
        });

        return view;
    }
}
