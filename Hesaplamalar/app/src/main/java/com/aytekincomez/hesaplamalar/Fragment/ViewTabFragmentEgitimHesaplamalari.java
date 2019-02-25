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

import com.aytekincomez.hesaplamalar.Activity.VizeFinal_HesaplamaActivity;
import com.aytekincomez.hesaplamalar.R;

public class ViewTabFragmentEgitimHesaplamalari extends Fragment {
    Button btnVizeFinalHesapla;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        final View view = inflater.inflate(
                R.layout.view_tabfragment_egitim_hesaplamlari,
                container,
                false
        );
        btnVizeFinalHesapla = (Button)view.findViewById(R.id.btnVizeFinalHesapla);
        btnVizeFinalHesapla.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(view.getContext(), VizeFinal_HesaplamaActivity.class));
            }
        });

        return  view;
    }
}
