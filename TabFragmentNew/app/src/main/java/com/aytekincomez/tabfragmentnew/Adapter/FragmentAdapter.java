package com.aytekincomez.tabfragmentnew.Adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.aytekincomez.tabfragmentnew.Fragment.FragmentTab1;
import com.aytekincomez.tabfragmentnew.Fragment.FragmentTab2;
import com.aytekincomez.tabfragmentnew.Fragment.FragmentTab3;

public class FragmentAdapter extends FragmentStatePagerAdapter {
    int tabCount;

    public FragmentAdapter(FragmentManager fm, int tabCount) {
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
                return  tab2;
            case 2:
                FragmentTab3 tab3 = new FragmentTab3();
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
