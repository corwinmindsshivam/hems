package com.corwinminds.hesmb.Fragment;


import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.corwinminds.hesmb.R;


/**
 * A simple {@link Fragment} subclass.
 */
public class EnergyUsageFragment extends Fragment {


    public EnergyUsageFragment() {
        // Required empty public constructor
    }

    public static EnergyUsageFragment newInstance() {
        EnergyUsageFragment fragment = new EnergyUsageFragment();
        return fragment;
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        ((AppCompatActivity) getActivity()).getSupportActionBar().setTitle("ENERGY Usgaes");

        return inflater.inflate(R.layout.fragment_energy_usage, container, false);
    }

}
