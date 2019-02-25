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

import com.aytekincomez.hesaplamalar.Activity.Birikim_HesaplamaActivity;
import com.aytekincomez.hesaplamalar.Activity.DovizHesaplamaActivity;
import com.aytekincomez.hesaplamalar.R;

public class ViewTabFragmentFinansHesaplamalari extends Fragment{

        @Nullable
        @Override
        public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

            final View view = inflater.inflate(
                    R.layout.view_tabfragment_finans_hesaplamlari,
                    container,
                    false
            );
            Button btnDovizkuru_Hesapla = (Button)view.findViewById(R.id.btnDovizkuru_Hesapla);
            btnDovizkuru_Hesapla.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    startActivity(new Intent(view.getContext(), DovizHesaplamaActivity.class));
                }
            });
            Button btnBirikim_Hesapla = (Button)view.findViewById(R.id.btnBirikim_Hesapla);
            btnBirikim_Hesapla.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    startActivity(new Intent(view.getContext(), Birikim_HesaplamaActivity.class));
                }
            });

            return  view;
        }

}
