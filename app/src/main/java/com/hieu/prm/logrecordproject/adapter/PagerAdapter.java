package com.hieu.prm.logrecordproject.adapter;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.hieu.prm.logrecordproject.HomeFragment;
import com.hieu.prm.logrecordproject.ProfileFragment;
import com.hieu.prm.logrecordproject.SettingsFragment;

public class PagerAdapter extends FragmentPagerAdapter {
    private int tabsNumber;


    public PagerAdapter(@NonNull FragmentManager fm, int behavior, int tabs) {
        super(fm, behavior);
        this.tabsNumber = tabs;
    }

    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0:
                return new HomeFragment();
            case 1:
                return new ProfileFragment();
            case 2:
                return new SettingsFragment();
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return tabsNumber;
    }
}
