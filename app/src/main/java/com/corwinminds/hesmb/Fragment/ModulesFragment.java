package com.corwinminds.hesmb.Fragment;


import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.appcompat.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;

import com.corwinminds.hesmb.Adapter.ModulesGridViewAdpater;
import com.corwinminds.hesmb.Model.ModulesModel;
import com.corwinminds.hesmb.R;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class ModulesFragment extends Fragment {

    private GridView mGridView;

    private ModulesGridViewAdpater mGridAdapter;
    private ArrayList<ModulesModel> mGridData;
    ModulesModel item,item1,item2,item3,item4;


    public static ModulesFragment newInstance() {
        ModulesFragment fragment = new ModulesFragment();
        return fragment;
    }
    public ModulesFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_modules, container, false);
        ((AppCompatActivity) getActivity()).getSupportActionBar().setTitle("Modules");
        mGridView = (GridView) view.findViewById(R.id.modules_gridView);
        mGridData = new ArrayList<>();

        item = new ModulesModel();
        item.setModulesModelName("Shivam");
        item.setModulesModelUnitOne("3201");
        item.setModulesModelUnitTwo("1");
        item1 = new ModulesModel();
        item1.setModulesModelName("Shivam");
        item1.setModulesModelUnitOne("3201");
        item1.setModulesModelUnitTwo("1");
        item2 = new ModulesModel();
        item2.setModulesModelName("Shivam");
        item2.setModulesModelUnitOne("3201");
        item2.setModulesModelUnitTwo("1");
        item3 = new ModulesModel();
        item3.setModulesModelName("Shivam");
        item3.setModulesModelUnitOne("3201");
        item3.setModulesModelUnitTwo("1");
        item4 = new ModulesModel();
        item4.setModulesModelName("Shivam");
        item4.setModulesModelUnitOne("3201");
        item4.setModulesModelUnitTwo("1");

        mGridData.add(item);
        mGridData.add(item1);
        mGridData.add(item2);
        mGridData.add(item3);
        mGridData.add(item4);
        mGridAdapter = new ModulesGridViewAdpater(getContext(), R.layout.modules_grid_view, mGridData);

        mGridAdapter.setGridData(mGridData);
        mGridView.setAdapter(mGridAdapter);

        return view;
    }

}
