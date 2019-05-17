package com.corwinminds.hesmb.Fragment;


import android.app.Activity;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.appcompat.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;

import com.corwinminds.hesmb.Adapter.DashboardGridViewAdapter;
import com.corwinminds.hesmb.Model.DashboardMenu;
import com.corwinminds.hesmb.R;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class DashboardFragment extends Fragment {
    private GridView mGridView;

    private DashboardGridViewAdapter mGridAdapter;
    private ArrayList<DashboardMenu> mGridData;
    DashboardMenu item;

    public DashboardFragment() {
        // Required empty public constructor
    }
    public static DashboardFragment newInstance() {
        DashboardFragment fragment = new DashboardFragment();
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_dashboard, container, false);

        ((AppCompatActivity) getActivity()).getSupportActionBar().setTitle("Dashboard");
        mGridView = (GridView) view.findViewById(R.id.dashboard_gridView);
        mGridData = new ArrayList<>();

        item = new DashboardMenu();
item.setDashboardMenu_name("Shivam");

        mGridData.add(item);
        mGridAdapter = new DashboardGridViewAdapter(getContext(), R.layout.dashboard_menu_grid_view, mGridData);

        mGridAdapter.setGridData(mGridData);
        mGridView.setAdapter(mGridAdapter);

        return view;
    }

}
