package com.corwinminds.hesmb.Fragment;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.corwinminds.hesmb.R;


public class ReadingFragment extends Fragment {
    public ReadingFragment() {
        // Required empty public constructor
    }
    public static ReadingFragment newInstance() {
        ReadingFragment fragment = new ReadingFragment();
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_reading, container, false);
    }
}
