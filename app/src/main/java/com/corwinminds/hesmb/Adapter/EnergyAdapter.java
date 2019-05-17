package com.corwinminds.hesmb.Adapter;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

import com.corwinminds.hesmb.Fragment.MonthFragment;
import com.corwinminds.hesmb.Fragment.TodayFragment;
import com.corwinminds.hesmb.Fragment.WeekFragment;

import java.util.ArrayList;
import java.util.List;

public class EnergyAdapter extends FragmentStatePagerAdapter {
    private final List<Fragment> mFragmentList = new ArrayList<>();
    private final List<String> mFragmentTitleList = new ArrayList<>();
    public EnergyAdapter(FragmentManager fm) {
        super(fm);
    }
    @Override
    public Fragment getItem(int position) {

        switch (position) {
            case 0:
                TodayFragment tab1 = new TodayFragment();
                return tab1;
            case 1:
                WeekFragment tab2 = new WeekFragment();
                return tab2;
            case 2:
                MonthFragment tab3 = new MonthFragment();
                return tab3;
            default:
                return null;
        }
    }
    public void addFragment(Fragment fragment, String title) {
        mFragmentList.add(fragment);
        mFragmentTitleList.add(title);
    }
    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return mFragmentTitleList.get(position);
    }
    @Override
    public int getCount() {
        return mFragmentList.size();
    }
}