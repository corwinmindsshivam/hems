package com.corwinminds.hesmb.Fragment;


import android.content.pm.ActivityInfo;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.corwinminds.hesmb.Adapter.EnergyAdapter;
import com.corwinminds.hesmb.R;
import com.google.android.material.tabs.TabLayout;

/**
 * A simple {@link Fragment} subclass.
 */
public class EnergyDashboard extends Fragment {

    EnergyAdapter adapter;
    private TabLayout tabLayout;
    private ViewPager viewPager;
    public EnergyDashboard() {
        // Required empty public constructor
    }

    public static EnergyDashboard newInstance() {
        EnergyDashboard fragment = new EnergyDashboard();
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_energy_dashboard, container, false);
        //((AppCompatActivity) getActivity()).setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_REVERSE_PORTRAIT);
        ((AppCompatActivity) getActivity()).getSupportActionBar().setTitle("NET ENERGY");
        viewPager =view.findViewById(R.id.viewPager);
        tabLayout = view.findViewById(R.id.tabLayout);
        adapter = new EnergyAdapter(getFragmentManager());
        adapter.addFragment(new TodayFragment(), "Today");
        adapter.addFragment(new WeekFragment(), "Week");
        adapter.addFragment(new MonthFragment(), "Month");
        viewPager.setAdapter(adapter);
        tabLayout.setupWithViewPager(viewPager);

   return view;
    }



}
