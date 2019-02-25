package com.aytekincomez.tabfragment.Adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.aytekincomez.tabfragment.Fragment.ViewTabFragment1;
import com.aytekincomez.tabfragment.Fragment.ViewTabFragment2;

public class PagerAdapter extends FragmentStatePagerAdapter {

    int tabSayisi;

    public PagerAdapter(FragmentManager fm, int tabSayisi) {
        super(fm);
        this.tabSayisi = tabSayisi;
    }

    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0:
                ViewTabFragment1 tab1 = new ViewTabFragment1();
                return tab1;
            case 1:
                ViewTabFragment2 tab2 = new ViewTabFragment2();
                return  tab2;
                default:
                    return null;
        }
    }

    @Override
    public int getCount() {
        return tabSayisi;
    }
}
