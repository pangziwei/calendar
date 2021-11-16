package com.juyou.calendar.weather;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;
import android.widget.AutoCompleteTextView;
import android.widget.ImageView;

import com.juyou.calendar.R;
import com.juyou.calendar.weather.bean.CityBean;
import com.juyou.calendar.constant.WeatherContentUtil;

import java.util.ArrayList;
import java.util.List;

import interfaces.heweather.com.interfacesmodule.bean.base.Code;
import interfaces.heweather.com.interfacesmodule.bean.base.Lang;
import interfaces.heweather.com.interfacesmodule.bean.base.Mode;
import interfaces.heweather.com.interfacesmodule.bean.base.Range;
import interfaces.heweather.com.interfacesmodule.bean.geo.GeoBean;
import interfaces.heweather.com.interfacesmodule.view.HeWeather;

public class AddCityActivity extends AppCompatActivity implements View.OnClickListener {

    private AutoCompleteTextView etSearch;
    private RecyclerView rvSearch;
    private Lang lang;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_city);

        if (WeatherContentUtil.APP_SETTING_LANG.equals("en") || WeatherContentUtil.APP_SETTING_LANG.equals("sys") && WeatherContentUtil.SYS_LANG.equals("en")) {
            lang = Lang.EN;
        } else {
            lang = Lang.ZH_HANS;
        }
        initView();
        initSearch();
    }

    private void initView() {
        ImageView ivBack = findViewById(R.id.iv_search_back);
        etSearch = findViewById(R.id.et_search);
        rvSearch = findViewById(R.id.recycle_search);
        LinearLayoutManager sevenManager = new LinearLayoutManager(this);
        sevenManager.setOrientation(LinearLayoutManager.VERTICAL);
        rvSearch.setLayoutManager(sevenManager);
        ivBack.setOnClickListener(this);
    }

    private void initSearch() {
        etSearch.setThreshold(1);
        //编辑框输入监听
        etSearch.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                String searchResult = etSearch.getText().toString();
                if (!TextUtils.isEmpty(searchResult)) {
                    rvSearch.setVisibility(View.VISIBLE);
                    getSearchResult(searchResult);
                }
            }

            @Override
            public void afterTextChanged(Editable s) {
            }
        });

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.iv_search_back:
                onBackPressed();
                break;
        }
    }

    private void getSearchResult(String location) {
        HeWeather.getGeoCityLookup(this, location, Mode.FUZZY, Range.WORLD, 10, lang, new HeWeather.OnResultGeoListener() {
            @Override
            public void onError(Throwable throwable) {
                GeoBean search = new GeoBean();
                search.setStatus("noData");
            }

            @Override
            public void onSuccess(GeoBean search) {
                if (search.getStatus().equals(Code.OK.getCode())) {
                    final List<GeoBean.LocationBean> basic = search.getLocationBean();
                    List<CityBean> data = new ArrayList<>();
                    if (basic != null && basic.size() > 0) {
                        if (data.size() > 0) {
                            data.clear();
                        }
                        for (int i = 0; i < basic.size(); i++) {
                            GeoBean.LocationBean basicData = basic.get(i);
                            String parentCity = basicData.getAdm2();
                            String adminArea = basicData.getAdm1();
                            String cnty = basicData.getCountry();
                            if (TextUtils.isEmpty(parentCity)) {
                                parentCity = adminArea;
                            }
                            if (TextUtils.isEmpty(adminArea)) {
                                parentCity = cnty;
                            }
                            CityBean cityBean = new CityBean();
                            cityBean.setCityName(parentCity + " - " + basicData.getName());
                            cityBean.setCityId(basicData.getId());
                            cityBean.setCnty(cnty);
                            cityBean.setLat(basicData.getLat());//纬度
                            cityBean.setLon(basicData.getLon());//经度
                            cityBean.setAdminArea(adminArea);
                            data.add(cityBean);
                        }

                        SearchAdapter searchAdapter = new SearchAdapter(AddCityActivity.this, data, etSearch.getText().toString(), true);
                        rvSearch.setAdapter(searchAdapter);
                        searchAdapter.notifyDataSetChanged();
                    }
                }
            }
        });
    }

}
