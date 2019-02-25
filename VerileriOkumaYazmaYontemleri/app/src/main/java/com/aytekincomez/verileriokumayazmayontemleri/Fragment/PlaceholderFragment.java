package com.aytekincomez.verileriokumayazmayontemleri.Fragment;

import android.content.res.AssetManager;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.ListView;

import com.aytekincomez.verileriokumayazmayontemleri.Adapter.GridViewAdapter;
import com.aytekincomez.verileriokumayazmayontemleri.Adapter.ListViewAdapter;
import com.aytekincomez.verileriokumayazmayontemleri.GetJson;
import com.aytekincomez.verileriokumayazmayontemleri.Model.Haber;
import com.aytekincomez.verileriokumayazmayontemleri.Model.Ogrenci;
import com.aytekincomez.verileriokumayazmayontemleri.R;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

public class PlaceholderFragment extends Fragment {

    private static final String ARG_SECTION_NUMBER = "section_number";

    public PlaceholderFragment() {
    }

    public String icerigiOku(InputStream inputStream) throws IOException{
        ByteArrayOutputStream byteStream = new ByteArrayOutputStream();
        byte[] bytes = new byte[4096];

        int uzunluk = 0;
        while((uzunluk = inputStream.read(bytes)) > 0){
            byteStream.write(bytes, 0, uzunluk);
        }

        return  new String(byteStream.toByteArray(), "UTF8");
    }

    public static PlaceholderFragment newInstance(int sectionNumber) {
        PlaceholderFragment fragment = new PlaceholderFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_SECTION_NUMBER, sectionNumber);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = null;

        int id = getArguments().getInt(ARG_SECTION_NUMBER);
        switch (id){
            case 1:
                rootView =  inflater.inflate(R.layout.fragment_tab1, container, false);
                break;
            case 2:
                rootView = inflater.inflate(R.layout.fragment_tab2, container, false);
                ArrayList<Haber> haberler = new ArrayList<>();
                haberler.add(new Haber("http://i.gercekfethiye.com/img/w730-h411-c730x411-q70/dosya/haber-475064417.jpeg","Ana Haberler"));
                haberler.add(new Haber("http://i.gercekfethiye.com/img/w730-h411-c730x411-q70/dosya/haber-475064417.jpeg","Ana Haberler"));

                GridView gridView = (GridView)rootView.findViewById(R.id.gridView);
                GridViewAdapter adapter = new GridViewAdapter(getActivity(), haberler );
                gridView.setAdapter(adapter);

                break;
            case 3:
                rootView = inflater.inflate(R.layout.fragment_tab3, container, false);

                final EditText etMakaleIcerik = (EditText)rootView.findViewById(R.id.etMakaleIcerik);
                Button btnIcerigiDoldur = (Button)rootView.findViewById(R.id.btnMakaleOku);
                btnIcerigiDoldur.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        AssetManager assestManager = getActivity().getAssets();
                        InputStream inputStream = null;

                        try {
                            inputStream = assestManager.open("makale.txt");
                            String metin = icerigiOku(inputStream);
                            etMakaleIcerik.setText(metin);
                        }catch (IOException e){
                            Log.d("HATA","Dosya okuma hatasi olustu");
                        }
                    }
                });
                break;
            case 4:
                rootView = inflater.inflate(R.layout.fragment_tab4, container, false);

                ArrayList<Ogrenci> ogrenciler = new ArrayList<>();
                /*
                ogrenciler.add(new Ogrenci(1,"ad","soyad","okul"));
                ogrenciler.add(new Ogrenci(1,"ad","soyad","okul"));
                ogrenciler.add(new Ogrenci(1,"ad","soyad","okul"));
                ogrenciler.add(new Ogrenci(1,"ad","soyad","okul"));
                */
                GetJson json = new GetJson();
                json.execute();
                ogrenciler = json.ogrenciler;

                ListViewAdapter listViewAdapter = new ListViewAdapter(getActivity(), ogrenciler );
                ListView listView = (ListView)rootView.findViewById(R.id.listView);
                listView.setAdapter(listViewAdapter);
                break;
        }

        //getString(R.string.section_format, getArguments().getInt(ARG_SECTION_NUMBER)));
        return rootView;
    }
}