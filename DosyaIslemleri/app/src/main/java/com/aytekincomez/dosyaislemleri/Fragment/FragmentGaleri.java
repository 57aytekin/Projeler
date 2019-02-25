package com.aytekincomez.dosyaislemleri.Fragment;

import android.os.Bundle;
import android.os.Environment;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.aytekincomez.dosyaislemleri.R;

import java.io.File;

public class FragmentGaleri extends Fragment {
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_layout_galeri, container, false);

        File file = new File(
                Environment.getExternalStorageDirectory(),"Pictures"
        );

        File[] pictures = file.listFiles();
        for(int i=0; i<pictures.length; i++){
            Log.d("DOSYA",pictures[i].getName());
        }
        return view;
    }
}
