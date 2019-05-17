package com.corwinminds.hesmb.Adapter;

import android.content.Context;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.corwinminds.hesmb.Model.SubMachineModel;
import com.corwinminds.hesmb.R;

import java.util.List;

public class SubMachineAdpater extends RecyclerView.Adapter<SubMachineAdpater.MyViewHolder> {

    private Context mContext;
    private List<SubMachineModel> subMachineModelList;

    //private  Bundle bundle;
    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView subMachieName;

        public MyViewHolder(View view) {
            super(view);
            subMachieName=view.findViewById(R.id.sub_machice_name);


        }
    }
    public SubMachineAdpater(Context mContext, List<SubMachineModel> subMachineModelList) {
        this.mContext = mContext;
        this.subMachineModelList = subMachineModelList;
    }

    @Override
    public SubMachineAdpater.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.sub_machine_card_view, parent, false);
        return new SubMachineAdpater.MyViewHolder(itemView);
    }



    @Override
    public void onBindViewHolder(SubMachineAdpater.MyViewHolder holder, final int position) {
        final SubMachineModel submachineModel = subMachineModelList.get(position);
        holder.subMachieName.setText(submachineModel.getSubMachineName());




    }
    @Override
    public int getItemCount() {
        return subMachineModelList.size();
    }
}



