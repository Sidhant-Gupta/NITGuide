package com.example.nit_guide.adapters;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.example.nit_guide.fragments.ftab1;
import com.example.nit_guide.fragments.ftab2;
import com.example.nit_guide.fragments.ftab3;
import com.example.nit_guide.fragments.ftab_timetable;

public class PageAdapter extends FragmentPagerAdapter {
    int tabCount;
    String activity;

    public PageAdapter(FragmentManager fm,int numOfTabs,String activity) {
        super(fm);
        tabCount=numOfTabs;
        this.activity=activity;
    }


    @Override
    public Fragment getItem(int position) {
        // ussi no of fragment ko bhejega vpager mein jo select hoga
        if(activity.equalsIgnoreCase("contacts")) {
            switch (position) {
                case 0:
                    return new ftab1();
                case 1:
                    return new ftab2();
                case 2:
                    return new ftab3();
                default:
                    return null;
            }
        }
        else if(activity.equalsIgnoreCase("timetable")){
            switch (position) {
                case 0:
                    return new ftab_timetable(0);
                case 1:
                    return new ftab_timetable(1);
                case 2:
                    return new ftab_timetable(2);
                case 3:
                    return new ftab_timetable(3);
                case 4:
                    return new ftab_timetable(4);
                default:
                    return new ftab_timetable(5);
            }
        }
        else{
            return null;
        }
    }

    @Override
    public int getCount() {
        return tabCount;
    }
}
