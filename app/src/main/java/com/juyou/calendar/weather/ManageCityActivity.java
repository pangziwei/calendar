package com.juyou.calendar.weather;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

import com.juyou.calendar.R;
import com.juyou.calendar.bean.weather.CityBean;
import com.juyou.calendar.bean.weather.CityBeanList;
import com.juyou.calendar.constant.WeatherContentUtil;
import com.juyou.calendar.util.SpUtils;

import java.util.ArrayList;
import java.util.List;

public class ManageCityActivity extends AppCompatActivity {
    private List<CityBean> datas = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_manage_city);


        ImageView ivBack = findViewById(R.id.iv_control_back);
        ivBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });

        RecyclerView rcControl = findViewById(R.id.recycle_control);
        CityBeanList cityBeanList = SpUtils.getBean(this, "cityBean", CityBeanList.class);
        if (WeatherContentUtil.APP_SETTING_LANG.equals("en") || WeatherContentUtil.APP_SETTING_LANG.equals("sys") && WeatherContentUtil.SYS_LANG.equals("en")) {
            cityBeanList = SpUtils.getBean(this, "cityBeanEn", CityBeanList.class);
        }
        if (cityBeanList != null) {
            datas = cityBeanList.getCityBeans();
        }
        LinearLayoutManager forecastManager = new LinearLayoutManager(this);
        forecastManager.setOrientation(LinearLayoutManager.VERTICAL);
        ControlCityAdapter followCityAdapter = new ControlCityAdapter(this, datas);

        rcControl.setAdapter(followCityAdapter);
        rcControl.setLayoutManager(forecastManager);
        rcControl.setItemAnimator(new DefaultItemAnimator());
    }
}
