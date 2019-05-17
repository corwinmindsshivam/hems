package com.corwinminds.hesmb.Adapter;

import android.app.Activity;
import android.content.Context;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.corwinminds.hesmb.Model.MachineModel;

import com.corwinminds.hesmb.R;

import java.util.ArrayList;

public class MachineAdpater extends ArrayAdapter<MachineModel> {
    private Context mContext;
    private int layoutResourceId;
    private ArrayList<MachineModel> mGridData = new ArrayList<MachineModel>();

    public MachineAdpater(Context mContext, int layoutResourceId, ArrayList<MachineModel> mGridData) {
        super(mContext, layoutResourceId, mGridData);
        this.layoutResourceId = layoutResourceId;
        this.mContext = mContext;
        this.mGridData = mGridData;
    }


    /**
     * Updates grid data and refresh grid items.
     * @param mGridData
     */
    public void setGridData(ArrayList<MachineModel> mGridData) {
        this.mGridData = mGridData;
        notifyDataSetChanged();
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        View row = convertView;
        MachineAdpater.ViewHolder holder;

        if (row == null) {
            LayoutInflater inflater = ((Activity) mContext).getLayoutInflater();
            row = inflater.inflate(layoutResourceId, parent, false);
            holder = new MachineAdpater.ViewHolder();
            holder.MachineModelName = (TextView) row.findViewById(R.id.machine_name);
            holder.MachineModelUnitOne = (TextView) row.findViewById(R.id.machine_unit_1);
            holder.MachineModelUnitTwo=(TextView)row.findViewById(R.id.machine_unit_2);
            row.setTag(holder);
        } else {
            holder = (MachineAdpater.ViewHolder) row.getTag();
        }

        MachineModel item = mGridData.get(position);
        System.out.println(item.getMachineModelName()+item.getMachineModelUnitOne()+item.getMachineModelUnitTwo());
        holder.MachineModelName.setText(item.getMachineModelName());
        holder.MachineModelUnitOne.setText(item.getMachineModelUnitOne());
        //holder.MachineModelUnitTwo.setText(item.getMachineModelUnitTwo());
        //   holder.ModulesModelUnitTwo.setText(item.getModulesModelUnitTwo());
        return row;
    }

    static class ViewHolder {
        TextView MachineModelName,MachineModelUnitOne,MachineModelUnitTwo;


    }


}


