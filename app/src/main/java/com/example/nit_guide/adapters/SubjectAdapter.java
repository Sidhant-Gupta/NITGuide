package com.example.nit_guide.adapters;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.example.nit_guide.fragments.fragment_year1;
import com.example.nit_guide.fragments.fragment_year2;
import com.example.nit_guide.fragments.fragment_year3;
import com.example.nit_guide.fragments.fragment_year4;


public class SubjectAdapter extends FragmentPagerAdapter {
    int numOfTabs;
    public SubjectAdapter(FragmentManager supportFragmentManager, int tabCount) {
        super(supportFragmentManager);
        int numOfTabs = tabCount;
    }

    @Override
    public Fragment getItem(int position) {
        // ussi no of fragment ko bhejega vpager mein jo select hoga
        switch(position){
            case 0: return new fragment_year1 ();
            case 1: return new fragment_year2 ();
            case 2: return new fragment_year3 ();
            case 3: return new fragment_year4 ();
            default: return null;
        }
    }


    @Override
    public int getCount() {
        return 0;
    }
}
