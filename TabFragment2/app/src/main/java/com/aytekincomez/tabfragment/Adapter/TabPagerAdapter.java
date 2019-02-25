package com.aytekincomez.tabfragment.Adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.aytekincomez.tabfragment.Fragment.FragmentTab1;
import com.aytekincomez.tabfragment.Fragment.FragmentTab2;

public class TabPagerAdapter extends FragmentStatePagerAdapter {

    int tabCount;

    public TabPagerAdapter(FragmentManager fm, int tabCount) {
        super(fm);
        this.tabCount = tabCount;
    }

    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0:
                FragmentTab1 tab1 = new FragmentTab1();
                return tab1;
            case 1:
                FragmentTab2 tab2 = new FragmentTab2();
                return tab2;
            case 2:
                FragmentTab2 tab3 = new FragmentTab2();
                return tab3;
            default:
                    return null;
        }
    }

    @Override
    public int getCount() {
        return tabCount;
    }
}
