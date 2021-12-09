package com.juyou.calendar.fragment.yellowcalendar.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.juyou.calendar.R;
import com.juyou.calendar.fragment.yellowcalendar.bean.YellowLunarYiListBean;

import java.util.List;


/**
 * @author 聚友互动
 * @datetime 2021-12-08 15:02
 * @detail :
 */
public class YellowCalendarYiAdapter extends RecyclerView.Adapter<YellowCalendarYiAdapter.MyViewHolder> {
    public Context context;
    public List<YellowLunarYiListBean> data;

    public YellowCalendarYiAdapter(Context context, List<YellowLunarYiListBean> data) {
        this.context = context;
        this.data = data;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_yellow_yi, viewGroup, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull YellowCalendarYiAdapter.MyViewHolder holder, int position) {
        holder.totayYi.setText( data.get(position).getYellowLunarYi());
    }

    public void refreshData(Context context, List<YellowLunarYiListBean> data) {
        this.context = context;
        this.data = data;
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder {
        TextView totayYi;

        MyViewHolder(@NonNull View itemView) {
            super(itemView);
            totayYi = itemView.findViewById(R.id.tv_item_today_yi);
        }
    }
}
