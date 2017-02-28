package com.kobe.ubersplash.fragment;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import java.util.List;

/**
 * Created by Jack on 2017/2/8.
 */

public class FragmentApdater extends FragmentStatePagerAdapter {

    private List<String> titleList;
    private List<Fragment> fragments;

    public FragmentApdater(FragmentManager fm, List<String> titleList, List<Fragment> fragments) {
        super(fm);
        this.fragments = fragments;
        this.titleList = titleList;
    }

    @Override
    public Fragment getItem(int position) {
        return fragments.get(position);
    }

    @Override
    public int getCount() {
        return titleList.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return titleList.get(position);
    }
}
