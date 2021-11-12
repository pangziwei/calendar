package com.juyou.calendar.weather.adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.juyou.calendar.R;
import com.juyou.calendar.constant.WeatherContentUtil;
import com.juyou.calendar.util.IconUtils;
import com.juyou.calendar.weather.bean.CaiYunhourlysListBean;

import java.util.List;


public class CaiYunHourlysListAdapter extends RecyclerView.Adapter<CaiYunHourlysListAdapter.MyViewHolder> {
    public Context context;
    public List<CaiYunhourlysListBean> data;

    public CaiYunHourlysListAdapter(Context context, List<CaiYunhourlysListBean> data) {
        this.context = context;
        this.data = data;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_caiyun_hourly, viewGroup, false);
        return new MyViewHolder(view);
    }

    public void refreshData(Context context, List<CaiYunhourlysListBean> data) {
        this.context = context;
        this.data = data;
        notifyDataSetChanged();
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onBindViewHolder(@NonNull MyViewHolder myViewHolder, @SuppressLint("RecyclerView") final int i) {
        myViewHolder.totayTime.setText((data.get(i).getTemperature().get(i).getDatetime()).substring(11, 16));
        myViewHolder.skyIcon.setText(IconUtils.getSkyDes(data.get(i).getSkycon().get(i).getValue()));
        myViewHolder.tem.setText(data.get(i).getTemperature().get(i).getValue() + "ºC");
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder {
        TextView totayTime;
        TextView skyIcon;
        TextView tem;

        MyViewHolder(@NonNull View itemView) {
            super(itemView);
            totayTime = itemView.findViewById(R.id.tv_item_today_time);
            skyIcon = itemView.findViewById(R.id.tv_item_today_skyicon);
            tem = itemView.findViewById(R.id.tv_item_today_tem);
        }
    }

}
