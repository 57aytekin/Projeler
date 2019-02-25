package com.aytekincomez.whatsapptasarim.Adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.aytekincomez.whatsapptasarim.Fragment.FragmentAramalar;
import com.aytekincomez.whatsapptasarim.Fragment.FragmentDurum;
import com.aytekincomez.whatsapptasarim.Fragment.FragmentSohbetler;

public class FragmentPagerAdapter extends FragmentStatePagerAdapter {

    int tabCount;

    public FragmentPagerAdapter(FragmentManager fm, int tabCount) {
        super(fm);
        this.tabCount = tabCount;
    }

    @Override
    public Fragment getItem(int i) {
        switch (i){
            case 0:
                FragmentSohbetler tab1 = new FragmentSohbetler();
                return tab1;
            case 1:
                FragmentDurum tab2 = new FragmentDurum();
                return tab2;
            case 2:
                FragmentAramalar tab3 = new FragmentAramalar();
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
