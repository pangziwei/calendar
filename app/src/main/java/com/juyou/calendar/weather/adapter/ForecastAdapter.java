package com.juyou.calendar.weather.adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.juyou.calendar.R;
import com.juyou.calendar.util.IconUtils;
import com.juyou.calendar.weather.bean.CaiYundaiysListBean;

import java.util.List;


public class ForecastAdapter extends RecyclerView.Adapter<ForecastAdapter.MyViewHolder> {
    TextView tvDailyTime;
    ImageView tvDailyAirIcon;
    TextView tvDailyAirDes;
    TextView tvDailyTem;

    public Context context;
    public List<CaiYundaiysListBean> datas;

    public ForecastAdapter(Context context, List<CaiYundaiysListBean> datas) {
        this.context = context;
        this.datas = datas;

    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_forecast, viewGroup, false);
        return new MyViewHolder(view);
    }

    public void refreshData(Context context, List<CaiYundaiysListBean> datas) {
        this.context = context;
        this.datas = datas;

        notifyDataSetChanged();
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onBindViewHolder(@NonNull MyViewHolder myViewHolder, @SuppressLint("RecyclerView") final int i) {

        tvDailyTime.setText((datas.get(i).getTemperature().get(i).getDate()).substring(0, 10));
        tvDailyAirDes.setText(IconUtils.getSkyDes(datas.get(i).getSkycon().get(i).getValue()));
        tvDailyAirIcon.setImageResource(IconUtils.getSkyIcon(datas.get(i).getSkycon().get(i).getValue()));
        tvDailyTem.setText((datas.get(i).getTemperature().get(i).getMin()) + "/" + datas.get(i).getTemperature().get(i).getMax() + "℃");

    }


    @Override
    public int getItemCount() {
        return datas.size();
    }


    class MyViewHolder extends RecyclerView.ViewHolder {

        MyViewHolder(@NonNull View itemView) {
            super(itemView);
            tvDailyTime = itemView.findViewById(R.id.tv_daily_time);
            tvDailyAirIcon = itemView.findViewById(R.id.tv_daily_air_icon);
            tvDailyAirDes = itemView.findViewById(R.id.tv_daily_air_des);
            tvDailyTem = itemView.findViewById(R.id.tv_daily_tem);

        }
    }


}
