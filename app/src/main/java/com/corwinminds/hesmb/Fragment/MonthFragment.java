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

import java.text.SimpleDateFormat;
import java.util.Date;

    public class MonthFragment extends Fragment {
    private SpeedometerGauge speedometer;
        TextView todayDateMonth;
String strDate;
    public MonthFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view=inflater.inflate(R.layout.fragment_month, container, false);
        todayDateMonth=view.findViewById(R.id.todayDateMonth);
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
        speedometer.setSpeed(260);
        Date date = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("dd MMMM yyyy");
        strDate = formatter.format(date);
        todayDateMonth.setText(strDate);
        System.out.println("Date Format with dd MMMM yyyy : "+strDate);
        return view;

    }

}
