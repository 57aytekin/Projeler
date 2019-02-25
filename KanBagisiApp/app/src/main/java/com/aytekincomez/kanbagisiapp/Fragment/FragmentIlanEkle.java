package com.aytekincomez.kanbagisiapp.Fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.aytekincomez.kanbagisiapp.Model.NewIlan;
import com.aytekincomez.kanbagisiapp.R;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class FragmentIlanEkle extends Fragment {
    EditText etAd, etSoyad, etKanGrubu, etIl, etIlce, etHastane, etTelNo;
    Button btnYayinla;
    FirebaseUser user;
    FirebaseAuth mAuth;
    DatabaseReference myRef;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.layout_fragment_ilanekle, container, false);
        uiElement(view);

        mAuth = FirebaseAuth.getInstance();
        myRef = FirebaseDatabase.getInstance().getReference();

        btnYayinla.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (etAd.getText().toString().equals("") || etSoyad.getText().toString().equals("") || etKanGrubu.getText().toString().equals("") ||
                        etIl.getText().toString().equals("") || etIlce.getText().toString().equals("") || etHastane.getText().toString().equals("") || etTelNo.getText().toString().equals("")){
                    Toast.makeText(view.getContext(),"Lütfen tüm alanları doldurduğunuzdan emin olun!",Toast.LENGTH_SHORT).show();
                }else{
                    user = mAuth.getCurrentUser();
                    writeIlan(etAd.getText().toString(), etSoyad.getText().toString(), etKanGrubu.getText().toString(),
                            etIl.getText().toString(),etIlce.getText().toString(),etHastane.getText().toString(),etTelNo.getText().toString());
                    Toast.makeText(view.getContext(),"Kayıt Oluşturuldu.",Toast.LENGTH_SHORT).show();
                    FragmentManager fragmentManager = getFragmentManager();
                    FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                    fragmentTransaction.replace(R.id.container, new FragmentArananKanlar());
                    fragmentTransaction.commit();
                }

            }
        });
        return view;
    }

    private void writeIlan(String ad, String soyad, String kanGurubu, String il, String ilce, String hastane, String tel){
        NewIlan ilan = new NewIlan(ad,soyad,kanGurubu,il,ilce,hastane,tel);
        myRef.push().child(user.getUid()).setValue(ilan);
    }
    private void uiElement(View view){
        etAd = (EditText)view.findViewById(R.id.etFragmentIlanEkleAd);
        etSoyad = (EditText)view.findViewById(R.id.etFragmentIlanEkleSoyad);
        etKanGrubu = (EditText)view.findViewById(R.id.etFragmentIlanEkleKanGrubu);
        etIl = (EditText)view.findViewById(R.id.etFragmentIlanEkleIl);
        etIlce = (EditText)view.findViewById(R.id.etFragmentIlanEkleIlce);
        etHastane = (EditText)view.findViewById(R.id.etFragmentIlanEkleHastaneAdi);
        etTelNo = (EditText)view.findViewById(R.id.etFragmentIlanEkleTel);
        btnYayinla = (Button)view.findViewById(R.id.btnFragmentYayinla);
    }
}
