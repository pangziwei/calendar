package com.juyou.calendar.weather;


import android.annotation.SuppressLint;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.recyclerview.widget.RecyclerView;

import com.juyou.calendar.R;
import com.juyou.calendar.bean.weather.CityBean;
import com.juyou.calendar.bean.weather.CityBeanList;
import com.juyou.calendar.constant.WeatherContentUtil;
import com.juyou.calendar.util.SpUtils;

import java.util.List;

public class ControlCityAdapter extends RecyclerView.Adapter<ControlCityAdapter.MyViewHolder> {

    private List<CityBean> datas;
    private ManageCityActivity activity;

    public ControlCityAdapter(ManageCityActivity controlCityActivity, List<CityBean> datas) {
        activity = controlCityActivity;
        this.datas = datas;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_follow_city, viewGroup, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder myViewHolder, @SuppressLint("RecyclerView") final int i) {
        myViewHolder.tvItemCity.setText(datas.get(i).getCityName());
        myViewHolder.ivDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog dialog = new AlertDialog.Builder(activity)
                        .setTitle("警告！")
                        .setMessage("将删除城市")
                        .setPositiveButton("确定", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                // 一般情况下如果用户不授权的话，功能是无法运行的，做退出处理
                                CityBeanList favorCity = SpUtils.getBean(activity, "cityBean", CityBeanList.class);
                                CityBeanList favorCityEn = SpUtils.getBean(activity, "cityBeanEn", CityBeanList.class);
                                List<CityBean> cityBeans = favorCity.getCityBeans();
                                List<CityBean> cityBeansEn = favorCityEn.getCityBeans();
                                for (int x = 0; x < cityBeans.size(); x++) {
                                    if (cityBeans.get(x).getCityId().equals(datas.get(i).getCityId())) {
                                        cityBeans.remove(x);
                                    }
                                }
                                for (int x = 0; x < cityBeansEn.size(); x++) {
                                    if (cityBeansEn.get(x).getCityId().equals(datas.get(i).getCityId())) {
                                        cityBeansEn.remove(x);
                                    }
                                }

                                datas.remove(i);

                                CityBeanList cityBeanList = new CityBeanList();
                                cityBeanList.setCityBeans(cityBeans);
                                CityBeanList cityBeanListEn = new CityBeanList();
                                cityBeanListEn.setCityBeans(cityBeansEn);
                                SpUtils.saveBean(activity, "cityBeanEn", cityBeanListEn);
                                SpUtils.saveBean(activity, "cityBean", cityBeanList);
                                //删除动画
                                notifyItemRemoved(i);
                                notifyDataSetChanged();
                                WeatherContentUtil.CITY_CHANGE = true;
//                DataUtil.deleteId(i);
                            }
                        }).show();
            }
        });
    }


    @Override
    public int getItemCount() {
        return datas.size();
    }


    class MyViewHolder extends RecyclerView.ViewHolder {

        private final ImageView ivDelete;
        private final TextView tvItemCity;

        MyViewHolder(@NonNull View itemView) {
            super(itemView);
            ivDelete = itemView.findViewById(R.id.iv_item_delete);
            tvItemCity = itemView.findViewById(R.id.tv_item_city);

        }
    }
}
