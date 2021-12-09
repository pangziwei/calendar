package com.juyou.calendar.fragment.yellowcalendar.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.juyou.calendar.R;
import com.juyou.calendar.fragment.yellowcalendar.bean.YellowLunarTimeListBean;

import java.util.List;


/**
 * @author 聚友互动
 * @datetime 2021-12-08 15:02
 * @detail :
 */
public class YellowCalendarTimeAdapter extends RecyclerView.Adapter<YellowCalendarTimeAdapter.MyViewHolder> {
    public Context context;
    public List<YellowLunarTimeListBean> data;

    public YellowCalendarTimeAdapter(Context context, List<YellowLunarTimeListBean> data) {
        this.context = context;
        this.data = data;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_yellow_time, viewGroup, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull YellowCalendarTimeAdapter.MyViewHolder holder, int position) {
        holder.totayTime.setText( data.get(position).getYellowLunarTime());
    }

    public void refreshData(Context context, List<YellowLunarTimeListBean> data) {
        this.context = context;
        this.data = data;
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder {
        TextView totayTime;

        MyViewHolder(@NonNull View itemView) {
            super(itemView);
            totayTime = itemView.findViewById(R.id.tv_item_lunar_time);
        }
    }
}
