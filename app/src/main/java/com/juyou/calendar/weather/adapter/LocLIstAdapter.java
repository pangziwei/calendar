package com.juyou.calendar.weather.adapter;


import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.juyou.calendar.R;
import com.juyou.calendar.activity.MyMainActivity;
import com.juyou.calendar.weather.bean.CityBean;
import com.juyou.calendar.weather.bean.CityBeanList;
import com.juyou.calendar.dialog.LocListWindow;
import com.juyou.calendar.util.SpUtils;
import com.juyou.calendar.weather.DataUtil;

import java.util.ArrayList;
import java.util.List;

public class LocLIstAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private List<CityBean> data;
    private LocListWindow locListWindow;
    private MyMainActivity activity;

    public LocLIstAdapter(LocListWindow locListWindow, List<CityBean> data, MyMainActivity context) {
        this.data = data;
        this.locListWindow = locListWindow;
        this.activity = context;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view;
        view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_search_favorite_light, viewGroup, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, final int i) {
        MyViewHolder myViewHolder = (MyViewHolder) viewHolder;
        myViewHolder.tvCity.setText(data.get(i).getCityName());
        myViewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String city = data.get(i).getCityId();
                String cityName = data.get(i).getCityName();

                CityBean cityBean = new CityBean();
                cityBean.setCityName(cityName);
                cityBean.setCityId(city);
                CityBeanList cityBeans;
                List<CityBean> citys = new ArrayList<>();

                cityBeans = SpUtils.getBean(activity, "cityBean", CityBeanList.class);
                if (cityBeans != null && cityBeans.getCityBeans() != null) {
                    citys = cityBeans.getCityBeans();
                }else {
                    cityBeans = new CityBeanList();
                }
                citys.add(0, cityBean);
                cityBeans.setCityBeans(citys);
                SpUtils.saveBean(activity, "cityBean", cityBeans);
                SpUtils.saveBean(activity, "cityBeanEn", cityBeans);

                SpUtils.putString(activity, "lastLocation", city);
                DataUtil.setCid(city);
                locListWindow.dismiss();
            }
        });
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder {

        private final TextView tvCity;

        MyViewHolder(@NonNull View itemView) {
            super(itemView);
            tvCity = itemView.findViewById(R.id.tv_item_favorite_city);

        }
    }
}
