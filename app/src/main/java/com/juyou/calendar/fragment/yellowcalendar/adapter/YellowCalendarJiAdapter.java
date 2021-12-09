package com.juyou.calendar.fragment.yellowcalendar.adapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.google.gson.Gson;
import com.juyou.calendar.R;
import com.juyou.calendar.bean.LunarDateBean;
import com.juyou.calendar.fragment.yellowcalendar.bean.YellowLunarJiListBean;
import com.juyou.calendar.weather.adapter.CaiYunHourlysListAdapter;
import com.juyou.calendar.weather.bean.CaiYundaiysListBean;
import com.juyou.calendar.weather.bean.CaiYunhourlysListBean;

import java.util.List;

import interfaces.heweather.com.interfacesmodule.bean.geo.GeoBean;


/**
 * @author 聚友互动
 * @datetime 2021-12-08 15:02
 * @detail :
 */
public class YellowCalendarJiAdapter extends RecyclerView.Adapter<YellowCalendarJiAdapter.MyViewHolder> {
    public Context context;
    public List<YellowLunarJiListBean> data;

    public YellowCalendarJiAdapter(Context context, List<YellowLunarJiListBean> data) {
        this.context = context;
        this.data = data;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_yellow_ji, viewGroup, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull YellowCalendarJiAdapter.MyViewHolder holder, int position) {
        holder.totayJi.setText( data.get(position).getYellowLunarJi());
//        Log.e("YellowCalendarJiAdapter", "----------vcxzv------" + new Gson().toJson(data));
    }

    public void refreshData(Context context, List<YellowLunarJiListBean> data) {
        this.context = context;
        this.data = data;
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder {
        TextView totayJi;

        MyViewHolder(@NonNull View itemView) {
            super(itemView);
            totayJi = itemView.findViewById(R.id.tv_item_today_time);
        }
    }
}
