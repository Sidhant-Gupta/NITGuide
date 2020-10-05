package com.example.nit_guide.adapters;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.example.nit_guide.fragments.ftab1;
import com.example.nit_guide.fragments.ftab2;
import com.example.nit_guide.fragments.ftab3;

public class PageAdapter extends FragmentPagerAdapter {
    int tabCount;

    public PageAdapter(FragmentManager fm,int numOfTabs) {
        super(fm);
        tabCount=numOfTabs;
    }


    @Override
    public Fragment getItem(int position) {
        // ussi no of fragment ko bhejega vpager mein jo select hoga
        switch(position){
            case 0: return new ftab1();
            case 1: return new ftab2();
            case 2: return new ftab3();
            default: return null;
        }
    }

    @Override
    public int getCount() {
        return tabCount;
    }
}
