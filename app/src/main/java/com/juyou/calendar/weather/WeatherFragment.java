package com.juyou.calendar.weather;


import android.annotation.SuppressLint;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.GridLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.gson.Gson;
import com.juyou.calendar.R;
import com.juyou.calendar.weather.adapter.ForecastAdapter;
import com.juyou.calendar.base.MyExFragment;
import com.juyou.calendar.bo.Api;
import com.juyou.calendar.constant.WeatherContentUtil;
import com.juyou.calendar.weather.adapter.CaiYunHourlysListAdapter;
import com.juyou.calendar.weather.bean.CaiYunDailyBean;
import com.juyou.calendar.weather.bean.CaiYunHourlysBean;
import com.juyou.calendar.weather.bean.CaiYunNowWeatherBean;
import com.juyou.calendar.weather.bean.CaiYundaiysListBean;
import com.juyou.calendar.weather.bean.CaiYunhourlysListBean;
import com.juyou.calendar.weather.horizonview.SunView;
import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;
import com.loopj.android.http.RequestParams;

import org.joda.time.DateTime;
import org.joda.time.DateTimeZone;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import interfaces.heweather.com.interfacesmodule.bean.base.Lang;

public class WeatherFragment extends MyExFragment {


    @BindView(R.id.iv_back)
    ImageView ivBack;
    @BindView(R.id.tv_today_tmp)
    TextView tvTodayTmp;
    @BindView(R.id.tv_today_cond)
    TextView tvTodayCond;
    @BindView(R.id.tv_today_alarm)
    TextView tvTodayAlarm;
    @BindView(R.id.tv_retry)
    TextView tvRetry;
    @BindView(R.id.rv_api_recycle)
    RecyclerView rvApiRecycle;
    @BindView(R.id.rv_forecast)
    RecyclerView rvForecast;
    @BindView(R.id.tv_today_title)
    TextView tvTodayTitle;
    @BindView(R.id.tv_car_index)
    TextView tvCarIndex;
    @BindView(R.id.tv_cold_index)
    TextView tvColdIndex;
    @BindView(R.id.tv_comfortable_index)
    TextView tvComfortableIndex;
    @BindView(R.id.tv_dressing_index)
    TextView tvDressingIndex;
    @BindView(R.id.tv_ultraviolet_index)
    TextView tvUltravioletIndex;
    @BindView(R.id.tv_hum_index)
    TextView tvHumIndex;
    @BindView(R.id.tv_pressure_index)
    TextView tvPressureIndex;
    @BindView(R.id.tv_visible_index)
    TextView tvVisibleIndex;
    @BindView(R.id.iv_line)
    ImageView ivLine;
    @BindView(R.id.air_title)
    TextView airTitle;
    @BindView(R.id.tv_pm25)
    TextView tvPm25;
    @BindView(R.id.tv_today_pm25)
    TextView tvTodayPm25;
    @BindView(R.id.tv_pm10)
    TextView tvPm10;
    @BindView(R.id.tv_today_pm10)
    TextView tvTodayPm10;
    @BindView(R.id.tv_so2)
    TextView tvSo2;
    @BindView(R.id.tv_today_so2)
    TextView tvTodaySo2;
    @BindView(R.id.tv_no2)
    TextView tvNo2;
    @BindView(R.id.tv_today_no2)
    TextView tvTodayNo2;
    @BindView(R.id.tv_co)
    TextView tvCo;
    @BindView(R.id.tv_today_co)
    TextView tvTodayCo;
    @BindView(R.id.tv_o3)
    TextView tvO3;
    @BindView(R.id.tv_today_o3)
    TextView tvTodayO3;
    @BindView(R.id.grid_air)
    GridLayout gridAir;
    @BindView(R.id.tv_sun_title)
    TextView tvSunTitle;
    @BindView(R.id.sun_view)
    SunView sunView;

    @BindView(R.id.tv_from)
    TextView tvFrom;
    @BindView(R.id.ll_bottom)
    LinearLayout llBottom;

    private CaiYunHourlysBean caiYunHourlysBean;//彩云天气24小时
    private ForecastAdapter forecastAdapter;
    private CaiYunHourlysListAdapter caiYunHourlysListAdapter;
    private static final String PARAM = "LOCATION";
    private static final String CITY_LON = "LON";
    private static final String CITY_LAT = "LAT";
    private boolean isEn = false;
    private String tz = "+8.0";
    private String currentTime;
    private String location;
    private String lon;
    private String lat;

    public static WeatherFragment newInstance(String cityId, String cityLat, String cityLon) {
        WeatherFragment fragment = new WeatherFragment();
        Bundle args = new Bundle();
        args.putString(PARAM, cityId);
        args.putString(CITY_LAT, cityLat);
        args.putString(CITY_LON, cityLon);
        fragment.setArguments(args);
//        Log.e("HeWeather", "args-----------" + args);
//        Log.e("HeWeather", "args---cityLat--------" + cityLat);
//        Log.e("HeWeather", "args-----------" + cityLon);
        return fragment;
    }


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        if (getArguments() != null) {
            isEn = WeatherContentUtil.APP_SETTING_LANG.equals("en") || WeatherContentUtil.APP_SETTING_LANG.equals("sys") && WeatherContentUtil.SYS_LANG.equals("en");
            location = getArguments().getString(PARAM);
            lon = getArguments().getString(CITY_LON);
            lat = getArguments().getString(CITY_LAT);
            init();//得到联网数据
            Log.e("citys", "我是fragment------" + location);
            Lang lang = Lang.ZH_HANS;
            if (isEn) {
                lang = Lang.EN;
            }
        }
    }

    @Override
    public int getLayoutId() {
        return R.layout.fragment_weather;
    }

    @Override
    protected void initView(View view, Bundle savedInstanceState) {
        ButterKnife.bind(this, view);
        init();

    }

    private void init() {
        if (lon != null) {
//            Log.e("HeWeather", "--> " + location + " <-lon-> " + lon + " <-lat-> " + lat);
            initCaiYunNowDay();//天数
            initCaiYunNowHourly();//24小时数
            initCaiYunNowWeather();//实况天气
        } else {

        }

    }

    private void initCaiYunNowWeather() {

        // https://api.caiyunapp.com/v2.5/nWupmHyRqEh1BVyk/121.6544,25.1552/realtime.json
        String register = Api.CaiYunWeatherUrl + "nWupmHyRqEh1BVyk/" + lon + "," + lat + "/realtime.json";
        AsyncHttpClient client = new AsyncHttpClient();
        RequestParams params = new RequestParams();
        client.get(register, params, new AsyncHttpResponseHandler() {
            @Override
            public void onSuccess(String content) {
                CaiYunNowWeatherBean caiYunNowWeatherBean = new Gson().fromJson(content, CaiYunNowWeatherBean.class);
                getWeatherAir(caiYunNowWeatherBean);

            }

            @Override
            public void onFailure(Throwable error, String content) {

            }
        });


    }

    private void initCaiYunNowHourly() {
//https://api.caiyunapp.com/v2.5/TAkhjf8d1nlSlspN/-74.0060,40.7128/hourly.json?hourlysteps=12
//        String register = Api.CaiYunWeatherUrl + "nWupmHyRqEh1BVyk/" + lon + "," + lat + "/hourly.json?hourlysteps=24";
        String register = Api.CaiYunWeatherUrl + "nWupmHyRqEh1BVyk/" + lon + "," + lat + "/hourly.json";
        AsyncHttpClient client = new AsyncHttpClient();
        RequestParams params = new RequestParams();
        params.put("hourlysteps", "24");
        client.get(register, params, new AsyncHttpResponseHandler() {
            @Override
            public void onSuccess(String content) {
                CaiYunHourlysBean caiYunHourlysBean = new Gson().fromJson(content, CaiYunHourlysBean.class);
                initCaiYunHourlys(caiYunHourlysBean);
//                Log.e("天气", "caiYunHourlysBean---------------" + new Gson().toJson(caiYunHourlysBean));
                tvTodayCond.setText(caiYunHourlysBean.getResult().getHourly().getDescription());
            }

            @Override
            public void onFailure(Throwable error, String content) {
            }
        });
    }

    private void initCaiYunHourlys(CaiYunHourlysBean result) {
        List<CaiYunhourlysListBean> dataHour = new ArrayList<>();
//        Log.e("天气", "caiYunHourlysBean---------------" + new Gson().toJson(dataHour));

        if (result != null && result.getResult().getHourly() != null) {
            caiYunHourlysBean = result;
            for (int i = 0; i < result.getResult().getHourly().getTemperature().size(); i++) {
                CaiYunhourlysListBean caiYunhourlysListBean = new CaiYunhourlysListBean();
                caiYunhourlysListBean.setTemperature(result.getResult().getHourly().getTemperature());
                caiYunhourlysListBean.setSkycon(result.getResult().getHourly().getSkycon());
                dataHour.add(caiYunhourlysListBean);
            }
            if (caiYunHourlysListAdapter == null) {
                caiYunHourlysListAdapter = new CaiYunHourlysListAdapter(getActivity(), dataHour);
                LinearLayoutManager forecastManager = new LinearLayoutManager(getActivity());
                forecastManager.setOrientation(LinearLayoutManager.HORIZONTAL);
                rvApiRecycle.setLayoutManager(forecastManager);
                rvApiRecycle.setAdapter(caiYunHourlysListAdapter);
                Log.e("天气", "caiYunHourlysBean---------------" + new Gson().toJson(dataHour));

            } else {
                caiYunHourlysListAdapter.refreshData(getActivity(), dataHour);
            }

        }
    }

    private void initCaiYunNowDay() {
//        https://api.caiyunapp.com/v2.5/TAkhjf8d1nlSlspN/-74.0060,40.7128/daily.json?dailysteps=3
        String registerUrl = Api.CaiYunWeatherUrl + "nWupmHyRqEh1BVyk/" + lon + "," + lat + "/daily.json";
//        String register = Api.CaiYunWeatherUrl + "nWupmHyRqEh1BVyk/" + lon + "," + lat + "/daily.json?dailysteps=3";
        //使用AsyncHttpClient，实现联网的声明
        AsyncHttpClient client = new AsyncHttpClient();
        //这里是要传送的参数
        RequestParams params = new RequestParams();
        params.put("dailysteps", "7");//几天的天气情况
        client.get(registerUrl, params, new AsyncHttpResponseHandler() {
            @Override
            public void onSuccess(String content) {
                CaiYunDailyBean caiYunDailyBean = new Gson().fromJson(content, CaiYunDailyBean.class);

                Log.e("天气", "caiYunHourlysBean------caiYunDailyBean---------" + new Gson().toJson(caiYunDailyBean));

                initCaiYunDailys(caiYunDailyBean);//15天
                CaiYunDailyBean.ResultBean.DailyBean.LifeIndexBean lifeIndexBean = caiYunDailyBean.getResult().getDaily().getLife_index();
//               生活指数
                tvCarIndex.setText(lifeIndexBean.getCarWashing().get(0).getDesc());
                tvColdIndex.setText(lifeIndexBean.getColdRisk().get(0).getDesc());
                tvComfortableIndex.setText(lifeIndexBean.getComfort().get(0).getDesc());
                tvDressingIndex.setText(lifeIndexBean.getDressing().get(0).getDesc());
                tvUltravioletIndex.setText(lifeIndexBean.getUltraviolet().get(0).getDesc());

//                日出日落
                DateTime now = DateTime.now(DateTimeZone.UTC);
                float a = Float.valueOf(tz);
                float minute = a * 60;
                now = now.plusMinutes(((int) minute));
                currentTime = now.toString("HH:mm");
                CaiYunDailyBean.ResultBean.DailyBean.AstroBean astroBean = caiYunDailyBean.getResult().getDaily().getAstro().get(0);
                sunView.setTimes(astroBean.getSunrise().getTime(), astroBean.getSunset().getTime(), currentTime);

            }

            @Override
            public void onFailure(Throwable error, String content) {

            }
        });


    }

    private void initCaiYunDailys(CaiYunDailyBean caiYunDailyBean) {

        List<CaiYundaiysListBean> dataDaily = new ArrayList<>();
        if (caiYunDailyBean != null && caiYunDailyBean.getResult().getDaily() != null) {
            for (int i = 0; i < caiYunDailyBean.getResult().getDaily().getTemperature().size(); i++) {
                CaiYundaiysListBean caiYundaiysListBean = new CaiYundaiysListBean();
                caiYundaiysListBean.setTemperature(caiYunDailyBean.getResult().getDaily().getTemperature());
                caiYundaiysListBean.setSkycon(caiYunDailyBean.getResult().getDaily().getSkycon());
                dataDaily.add(caiYundaiysListBean);
            }
            Log.e("dataDaily", "ji--------------------"+new Gson().toJson(dataDaily));
            if (forecastAdapter == null) {
                forecastAdapter = new ForecastAdapter(getActivity(), dataDaily);
                LinearLayoutManager forecastManager = new LinearLayoutManager(getActivity());
                forecastManager.setOrientation(LinearLayoutManager.VERTICAL);
                rvForecast.setLayoutManager(forecastManager);
                rvForecast.setAdapter(forecastAdapter);
            } else {
                forecastAdapter.refreshData(getActivity(), dataDaily);
            }
        }
    }

    private void getWeatherAir(CaiYunNowWeatherBean caiYunNowWeatherBean) {
        CaiYunNowWeatherBean.ResultBean.RealtimeBean.AirQualityBean bean = caiYunNowWeatherBean.getResult().getRealtime().getAir_quality();
//        空气质量

        tvTodayPm10.setText(bean.getPm10() + "μg/m³");
        tvTodayPm25.setText(bean.getPm25() + "μg/m³");
        tvTodaySo2.setText(bean.getSo2() + "μg/m³");
        tvTodayNo2.setText(bean.getNo2() + "μg/m³");
        tvTodayCo.setText(bean.getCo() + "mg/m³");
        tvTodayO3.setText(bean.getO3() + "μg/m³");
        tvTodayTmp.setText(caiYunNowWeatherBean.getResult().getRealtime().getApparent_temperature() + "℃");
        tvHumIndex.setText(caiYunNowWeatherBean.getResult().getRealtime().getHumidity() + "%");
        tvPressureIndex.setText(caiYunNowWeatherBean.getResult().getRealtime().getPressure() + "Pa");
        tvVisibleIndex.setText(caiYunNowWeatherBean.getResult().getRealtime().getVisibility() + "m");
    }


    @Override
    public void loadData() {
        Log.e("TAG", "我是谁----3333333-------");
        init();
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onResume() {
        super.onResume();
        Log.e("TAG", "我是谁----444444------");
        init();
    }

    @OnClick({R.id.tv_retry})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.tv_retry:

                break;

        }
    }

}
