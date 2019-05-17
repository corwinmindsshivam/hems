package com.corwinminds.hesmb.Adapter;

import android.content.Context;
import android.content.Intent;
import androidx.appcompat.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.corwinminds.hesmb.Model.DashboardMenu;
import com.corwinminds.hesmb.R;

import java.util.ArrayList;

public class DashboardGridViewAdapter extends ArrayAdapter<DashboardMenu> {
    private Context mContext;
    private int layoutResourceId;
    private ArrayList<DashboardMenu> mGridData = new ArrayList<DashboardMenu>();

    public DashboardGridViewAdapter(Context mContext, int layoutResourceId, ArrayList<DashboardMenu> mGridData) {
        super(mContext, layoutResourceId, mGridData);
        this.layoutResourceId = layoutResourceId;
        this.mContext = mContext;
        this.mGridData = mGridData;
    }


    /**
     * Updates grid data and refresh grid items.
     * @param mGridData
     */
    public void setGridData(ArrayList<DashboardMenu> mGridData) {
        this.mGridData = mGridData;
        notifyDataSetChanged();
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        View row = convertView;
        ViewHolder holder;

        if (row == null) {
            Intent intent = ((AppCompatActivity) mContext).getIntent();

            LayoutInflater inflater = ((AppCompatActivity) mContext).getLayoutInflater();
            row = inflater.inflate(layoutResourceId, parent, false);
            holder = new ViewHolder();
            holder.titleTextView = (TextView) row.findViewById(R.id.dashboard_grid_item_title);
            holder.imageView = (ImageView) row.findViewById(R.id.dashboard_grid_item_image);
            holder.imageView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    DashboardMenu item = mGridData.get(position);



                }
            });
            row.setTag(holder);
        } else {
            holder = (ViewHolder) row.getTag();
        }

        DashboardMenu item = mGridData.get(position);

        holder.titleTextView.setText((item.getDashboardMenu_name()));

        //Picasso.with(mContext).load(item.getDashboardMenu_Image_Url()).into(holder.imageView);
        return row;
    }

    static class ViewHolder {
        TextView titleTextView;
        ImageView imageView;
    }

}

