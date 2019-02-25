package com.aytekincomez.verileriokumayazmayontemleri.Adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.aytekincomez.verileriokumayazmayontemleri.Fragment.PlaceholderFragment;

public class SectionsPagerAdapter extends FragmentPagerAdapter {

    public SectionsPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        // getItem is called to instantiate the fragment for the given page.
        // Return a PlaceholderFragment (defined as a static inner class below).
        return PlaceholderFragment.newInstance(position + 1);
    }

    @Override
    public int getCount() {
        // Show 3 total pages.
        return 4;
    }


    @Override
    public CharSequence getPageTitle(int position) {
        switch (position){
            case 0:
                return "ANASAYFA";
            case 1:
                return "ARRAYLİST";
            case 2:
                return "DOSOYA";
            case 3:
                return "JSON VERİ OKUMA";
        }
        return null;
    }
}