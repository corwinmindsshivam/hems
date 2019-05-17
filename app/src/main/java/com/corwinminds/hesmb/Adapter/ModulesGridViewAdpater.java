package com.corwinminds.hesmb.Adapter;

import android.app.Activity;
import android.content.Context;

import androidx.fragment.app.FragmentTransaction;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.corwinminds.hesmb.Fragment.MachineFragment;
import com.corwinminds.hesmb.Model.ModulesModel;
import com.corwinminds.hesmb.R;

import java.util.ArrayList;

public class ModulesGridViewAdpater extends ArrayAdapter<ModulesModel> {
    private Context mContext;
    private int layoutResourceId;
    private ArrayList<ModulesModel> mGridData = new ArrayList<ModulesModel>();

    public ModulesGridViewAdpater(Context mContext, int layoutResourceId, ArrayList<ModulesModel> mGridData) {
        super(mContext, layoutResourceId, mGridData);
        this.layoutResourceId = layoutResourceId;
        this.mContext = mContext;
        this.mGridData = mGridData;
    }


    /**
     * Updates grid data and refresh grid items.
     * @param mGridData
     */
    public void setGridData(ArrayList<ModulesModel> mGridData) {
        this.mGridData = mGridData;
        notifyDataSetChanged();
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        View row = convertView;
        ViewHolder holder;

        if (row == null) {
            LayoutInflater inflater = ((Activity) mContext).getLayoutInflater();
            row = inflater.inflate(layoutResourceId, parent, false);
            holder = new ViewHolder();
            holder.ModulesModelName = (TextView) row.findViewById(R.id.modules_name);
            holder.ModulesModelUnitOne = (TextView) row.findViewById(R.id.modules_unit_1);
            holder.ModulesModelUnitTwo=(TextView)row.findViewById(R.id.machine_unit_2);
            holder.cardView=(CardView)row.findViewById(R.id.modules_card_view);
            holder.cardView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    ModulesModel modulesModel=mGridData.get(position);
                    MachineFragment  fragment=new MachineFragment();
                    FragmentTransaction ft = ((AppCompatActivity) mContext).getSupportFragmentManager()
                            .beginTransaction();
                    ft.replace(R.id.frame_layout,fragment).commit();
                }
            });
            row.setTag(holder);
        } else {
            holder = (ViewHolder) row.getTag();
        }

        ModulesModel item = mGridData.get(position);
        System.out.println(item.getModulesModelName()+item.getModulesModelUnitOne()+item.getModulesModelUnitTwo());
        holder.ModulesModelName.setText(item.getModulesModelName());
        holder.ModulesModelUnitOne.setText(item.getModulesModelUnitOne());
     //   holder.ModulesModelUnitTwo.setText(item.getModulesModelUnitTwo());
        return row;
    }

    static class ViewHolder {
        TextView ModulesModelName,ModulesModelUnitOne,ModulesModelUnitTwo;
        CardView cardView;


    }

}
