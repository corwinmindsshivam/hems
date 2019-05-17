package com.corwinminds.hesmb.Fragment;


import android.annotation.SuppressLint;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.ActivityInfo;
import android.graphics.Color;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.preference.PreferenceManager;
import androidx.viewpager.widget.ViewPager;

import android.os.CountDownTimer;
import android.os.Vibrator;
import android.preference.EditTextPreference;
import android.provider.Settings;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.cardiomood.android.controls.gauge.SpeedometerGauge;
import com.corwinminds.hesmb.R;


import java.util.Random;


/**
 * A simple {@link Fragment} subclass.
 */
public class FireAlarm extends Fragment {
    TextView FireLimit;
    ImageView alertr,alerty,alertb,rt,yt,bt;
    int r=0,r1=0,r2=0;
    private SpeedometerGauge rphase,yphase,bphase ;
    public FireAlarm() {
        // Required empty public constructor
    }
    public static FireAlarm newInstance() {
        FireAlarm fragment = new FireAlarm ();
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
      ((AppCompatActivity) getActivity()).setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_SENSOR_LANDSCAPE);
        ((AppCompatActivity) getActivity()).getSupportActionBar().setTitle("Fire Alarm");
        SharedPreferences sharedPreference=PreferenceManager.getDefaultSharedPreferences(getContext());
        final String firelist=sharedPreference.getString("price","100");
        View view= inflater.inflate(R.layout.fragment_fire_alarm, container, false);
        rphase=view.findViewById(R.id.rphase);
        yphase=view.findViewById(R.id.yphase);
        bphase=view.findViewById(R.id.bphase);
        FireLimit=view.findViewById(R.id.firelimit);
        rt=view.findViewById(R.id.r);
        yt=view.findViewById(R.id.y);
        bt=view.findViewById(R.id.b);
        FireLimit.setText(firelist);
        rphase.setLabelTextSize(20);
        yphase.setLabelTextSize(20);
        bphase.setLabelTextSize(20);
        rphase.setLabelConverter(new SpeedometerGauge.LabelConverter() {
            @Override
            public String getLabelFor(double progress, double maxProgress) {
                return String.valueOf((int) Math.round(progress));
            }
        });

        // configure value range and ticks
        rphase.setMaxSpeed(300);
        rphase.setMajorTickStep(40);
        rphase.setMinorTicks(2);

        // Configure value range colors
        rphase.addColoredRange(30, 140, Color.GREEN);
        rphase.addColoredRange(140, 180, Color.YELLOW);
        rphase.addColoredRange(Double.parseDouble(firelist), 300, Color.RED);



        yphase.setLabelConverter(new SpeedometerGauge.LabelConverter() {
            @Override
            public String getLabelFor(double progress, double maxProgress) {
                return String.valueOf((int) Math.round(progress));
            }
        });

        // configure value range and ticks
        yphase.setMaxSpeed(300);
        yphase.setMajorTickStep(40);
        yphase.setMinorTicks(2);

        // Configure value range colors
        yphase.addColoredRange(30, 140, Color.GREEN);
        yphase.addColoredRange(140,180, Color.YELLOW);
        yphase.addColoredRange(Double.parseDouble(firelist), 300, Color.RED);


        bphase.setLabelConverter(new SpeedometerGauge.LabelConverter() {
            @Override
            public String getLabelFor(double progress, double maxProgress) {
                return String.valueOf((int) Math.round(progress));
            }
        });

        // configure value range and ticks
        bphase.setMaxSpeed(300);
        bphase.setMajorTickStep(40);
        bphase.setMinorTicks(2);

        // Configure value range colors
        bphase.addColoredRange(30, 140, Color.GREEN);
        bphase.addColoredRange(140, 180, Color.YELLOW);
        bphase.addColoredRange(Double.parseDouble(firelist), 300, Color.RED);


        final Random random = new Random();
        final Random random1 = new Random();
        final Random random2 = new Random();

        final CountDownTimer timer = new CountDownTimer(60000, 2500) {

            @Override
            public void onTick(long millisUntilFinished) {
                r = random.nextInt(400);
                r1 = random1.nextInt(400);
                r2 = random2.nextInt(400);

                if (r >= Integer.parseInt(firelist)) {
                    rphase.setSpeed(r);
                      rt.setVisibility(View.INVISIBLE);
                    //  vibe.vibrate(1000);
                } else {
                    rphase.setSpeed(r);
                       rt.setVisibility(View.VISIBLE);
                }
                if (r1 >= Integer.parseInt(firelist)) {
                    yphase.setSpeed(r1);
                     yt.setVisibility(View.INVISIBLE);
                    // vibe.vibrate(1000);
                } else {
                    yphase.setSpeed(r1);
                        yt.setVisibility(View.VISIBLE);
                }
                if (r2 >= Integer.parseInt(firelist)) {
                    bphase.setSpeed(r2);
                      bt.setVisibility(View.INVISIBLE);
                    //vibe.vibrate(1000);
                } else {
                    bphase.setSpeed(r2);
                    bt.setVisibility(View.VISIBLE);
                }

            }


            @Override
            public void onFinish() {
                // rphase.setTargetValue(0);
            }
        };
        timer.start();


        return view;
    }




}
