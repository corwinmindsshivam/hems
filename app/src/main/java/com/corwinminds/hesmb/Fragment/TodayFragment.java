package com.corwinminds.hesmb.Fragment;

import android.content.Context;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.cardiomood.android.controls.gauge.SpeedometerGauge;
import com.corwinminds.hesmb.R;

public class TodayFragment extends Fragment {
    private SpeedometerGauge speedometer;
double speed=8;
    public TodayFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view=inflater.inflate(R.layout.fragment_today, container, false);
        speedometer = (SpeedometerGauge)view.findViewById(R.id.speedometer);
        speedometer.setLabelTextSize(20);
        // Add label converter
        speedometer.setLabelConverter(new SpeedometerGauge.LabelConverter() {
                                          @Override
                                          public String getLabelFor(double progress, double maxProgress) {
                                              return String.valueOf((int) Math.round(progress));
                                          }
                            });

                // configure value range and ticks
        speedometer.setMaxSpeed(300);
        speedometer.setMajorTickStep(40);
        speedometer.setMinorTicks(2);

        // Configure value range colors
        speedometer.addColoredRange(30, 140, Color.GREEN);
        speedometer.addColoredRange(140, 180, Color.YELLOW);
        speedometer.addColoredRange(180, 300, Color.RED);
        speedometer.setSpeed(speed);

        return view;

    }

}
