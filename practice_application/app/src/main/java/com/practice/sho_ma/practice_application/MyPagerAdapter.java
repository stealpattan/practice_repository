package com.practice.sho_ma.practice_application;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.practice.sho_ma.practice_application.Fragments.recommendFragment;
import com.practice.sho_ma.practice_application.Fragments.scheduleFragment;

public class MyPagerAdapter extends FragmentStatePagerAdapter{
    public MyPagerAdapter(FragmentManager fm){
        super(fm);
    }

    @Override
    public Fragment getItem(int i){
        switch(i){
            case 0:
                return new recommendFragment();
            default:
                return new scheduleFragment();
        }
    }

    @Override
    public int getCount(){
        return 2;
    }

    @Override
    public CharSequence getPageTitle(int position){
        return "now you are in page" + position;
    }
}