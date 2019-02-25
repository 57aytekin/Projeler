package com.aytekincomez.retrofit_kullanimi.Adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.aytekincomez.retrofit_kullanimi.Fragment.FragmentBlogs;
import com.aytekincomez.retrofit_kullanimi.Fragment.FragmentCategories;

public class FragmentAdapter extends FragmentStatePagerAdapter {

    int tabSayisi;

    public FragmentAdapter(FragmentManager fm, int tabSayisi) {
        super(fm);
        this.tabSayisi = tabSayisi;
    }

    @Override
    public Fragment getItem(int i) {
        Fragment fragment = null;
        switch (i){
            case 0:
                fragment = new FragmentBlogs();
                break;
            case 1:
                fragment = new FragmentCategories();
                break;
            default:
                fragment = new FragmentBlogs();
                break;
        }

        return fragment;
    }

    @Override
    public int getCount() {
        return tabSayisi;
    }
}
