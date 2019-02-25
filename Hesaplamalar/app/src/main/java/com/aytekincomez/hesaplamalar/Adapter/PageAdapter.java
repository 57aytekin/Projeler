package com.aytekincomez.hesaplamalar.Adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.aytekincomez.hesaplamalar.Fragment.ViewTabFragmentEgitimHesaplamalari;
import com.aytekincomez.hesaplamalar.Fragment.ViewTabFragmentFinansHesaplamalari;
import com.aytekincomez.hesaplamalar.Fragment.ViewTabFragmentMuhasebeHesaplamalari;
import com.aytekincomez.hesaplamalar.Fragment.ViewTabFragmentSaglikHesaplamalari;

public class PageAdapter extends FragmentStatePagerAdapter {
    int tamSayisi;

    public PageAdapter(FragmentManager fm, int tabsayisi) {
        super(fm);
        this.tamSayisi = tabsayisi;
    }

    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0:
                ViewTabFragmentEgitimHesaplamalari tab1 = new ViewTabFragmentEgitimHesaplamalari();
                return tab1;
            case 1:
                ViewTabFragmentSaglikHesaplamalari tab2 = new ViewTabFragmentSaglikHesaplamalari();
                return tab2;
            case 2:
                ViewTabFragmentFinansHesaplamalari tab3 = new ViewTabFragmentFinansHesaplamalari();
                return tab3;
            case 3:
                ViewTabFragmentMuhasebeHesaplamalari tab4 = new ViewTabFragmentMuhasebeHesaplamalari();
                return tab4;
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return tamSayisi;
    }
}
