package com.corwinminds.hesmb.Fragment;


import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.appcompat.app.AppCompatActivity;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;

import com.corwinminds.hesmb.Adapter.MachineAdpater;
import com.corwinminds.hesmb.Model.MachineModel;
import com.corwinminds.hesmb.R;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class MachineFragment extends Fragment {



    private GridView mGridView;

    private MachineAdpater mGridAdapter;
    private ArrayList<MachineModel> mGridData;
    MachineModel item,item1,item2,item3,item4;


    public static MachineFragment newInstance() {
        MachineFragment fragment = new MachineFragment();
        return fragment;
    }
    public MachineFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_machine, container, false);
        ((AppCompatActivity) getActivity()).getSupportActionBar().setTitle("Machine");
        mGridView = (GridView) view.findViewById(R.id.machine_gridView);
        mGridData = new ArrayList<>();

        item = new MachineModel();
        item.setMachineModelName("Shivam");
        item.setMachineModelUnitOne("3201");
        item.setMachineModelUnitTwo("1");
        item1 = new MachineModel();

        mGridData.add(item);
        mGridAdapter = new MachineAdpater(getContext(), R.layout.machine_card_view, mGridData);

        mGridAdapter.setGridData(mGridData);
        mGridView.setAdapter(mGridAdapter);

        return view;
    }

}
