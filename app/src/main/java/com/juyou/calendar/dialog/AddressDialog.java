package com.juyou.calendar.dialog;

import android.content.Context;
import android.content.res.AssetManager;
import android.graphics.Color;
import android.os.Handler;
import android.text.TextUtils;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.view.WindowManager;
import android.widget.CompoundButton;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.google.gson.Gson;
import com.juyou.calendar.R;
import com.juyou.calendar.bean.ProvinceEntity;
import com.juyou.calendar.constant.WeatherContentUtil;
import com.littlejie.circleprogress.utils.Constant;
import com.manggeek.android.geek.GeekActivity;
import com.manggeek.android.geek.GeekDialog;
import com.manggeek.android.geek.cache.StringCache;
import com.manggeek.android.geek.utils.JSONUtil;
import com.manggeek.android.geek.utils.PrintUtil;
import com.manggeek.android.geek.utils.Window;
import com.manggeek.android.geek.view.FindViewById;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class AddressDialog extends GeekDialog {

    private @FindViewById(id = R.id.title_layout)
    LinearLayout titleLayout;
    private @FindViewById(id = R.id.confirm)
    View confirmTv;
    private @FindViewById(id = R.id.address_layout)
    RadioGroup addressLayout;

    private List<ProvinceEntity> provinceList = new ArrayList<>();
    //省份
    private String provinceName;
    //城市编码
    private String provinceCode;
    //市
    private String cityName;
    //区
    private String areaName;

    private int provincePosition;
    private int cityPosition;
    private Handler mHandler = new Handler();


    /**
     * 弹框默认浮层
     *
     * @param activity
     */
    public AddressDialog(GeekActivity activity) {
        super(activity);

        init();
    }


    public void setProvinceName(String provinceName, String cityName, String areaName) {
        this.provinceName = provinceName;
        this.cityName = cityName;
        this.areaName = areaName;
        addProvinceTextView();//添加选择的省份到标题栏
        addCityTextView();  //添加选择的城市到标题栏
        addAreaTextView();//添加选择的区到标题栏
        initAreaByName();//
    }

    private void init() {
        setContentView(R.layout.dialog_address, WindowManager.LayoutParams.MATCH_PARENT, Window.toPx(400));
        setGravity(Gravity.BOTTOM);

        getData();
//        Log.e("TAG", "init");
    }

    private void getData() {
        String areaJson = StringCache.get(WeatherContentUtil.AREA_JSON);
        if (TextUtils.isEmpty(areaJson)) {
            areaJson = getJson("area.json", mActivity);//选择的市区
            StringCache.put(WeatherContentUtil.AREA_JSON, areaJson);
        }
        provinceList = JSONUtil.getListObj(areaJson, ProvinceEntity.class);
        confirmTv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!TextUtils.isEmpty(provinceName) && !TextUtils.isEmpty(cityName) && !TextUtils.isEmpty(areaName)) {
                    if (selectAreaListener != null) {
                        selectAreaListener.select(provinceName, cityName, areaName);
                    }
                    dismiss();
                } else {
                    PrintUtil.toastMakeText("请选择省市区");
                }
            }
        });
        //显示省份
        initProvince();
    }

    public static String getJson(String fileName, Context context) {
        //将json数据变成字符串
        StringBuilder stringBuilder = new StringBuilder();
        try {
            //获取assets资源管理器
            AssetManager assetManager = context.getAssets();
            //通过管理器打开文件并读取
            BufferedReader bf = new BufferedReader(new InputStreamReader(assetManager.open(fileName)));
            String line;
            while ((line = bf.readLine()) != null) {
                stringBuilder.append(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return stringBuilder.toString();
    }

    //显示省份
    private void initProvince() {
//        Log.e("TAG", "显示省份");
        addressLayout.removeAllViews();
        for (int i = 0; i < provinceList.size(); i++) {
            ProvinceEntity provinceEntity = provinceList.get(i);
            RadioButton textView = (RadioButton) mInflater.inflate(R.layout.item_city_button, null);
            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(WindowManager.LayoutParams.MATCH_PARENT, Window.toPx(34));
            params.leftMargin = Window.toPx(18);
            textView.setLayoutParams(params);
            textView.setText(provinceEntity.getName());
//            textView.setText(provinceEntity.getCode());
            if (provinceEntity.getName().equals(provinceName)) {
                textView.setChecked(true);
            } else {
                textView.setChecked(false);
            }
            int finalI = i;
            textView.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                    if (isChecked) {
                        provincePosition = finalI;
                        provinceName = provinceEntity.getName();
//                        provinceCode = provinceEntity.getCode();
                        addProvinceTextView();//添加选择的省份到标题栏
                        mHandler.postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                initCity();//添加城市
                            }
                        }, 100);
                    }
                }
            });
            addressLayout.addView(textView);
        }
    }

    //添加选择的省份到标题栏
    private void addProvinceTextView() {
        titleLayout.removeAllViews();
        TextView textView = new TextView(mActivity);
        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(WindowManager.LayoutParams.WRAP_CONTENT, WindowManager.LayoutParams.MATCH_PARENT);
        params.leftMargin = Window.toPx(20);
        textView.setLayoutParams(params);
        textView.setTextColor(Color.parseColor("#333333"));
        textView.setTextSize(18);
        textView.setGravity(Gravity.CENTER);
        textView.setText(provinceName);
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                initProvince();//添加选择的省份到标题栏
            }
        });
        titleLayout.addView(textView);
    }

    //显示城市
    private void initCity() {
        addressLayout.removeAllViews();
        ProvinceEntity provinceEntity = provinceList.get(provincePosition);
        List<ProvinceEntity.CityListBean> arrayList = provinceEntity.getCityList();
        for (int i = 0; i < arrayList.size(); i++) {
            ProvinceEntity.CityListBean cityBean = arrayList.get(i);
            RadioButton textView = (RadioButton) mInflater.inflate(R.layout.item_city_button, null);
            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(WindowManager.LayoutParams.MATCH_PARENT, Window.toPx(34));
            params.leftMargin = Window.toPx(18);
            textView.setLayoutParams(params);
            textView.setText(cityBean.getName());
            if (cityBean.getName().equals(cityName)) {
                textView.setChecked(true);
            } else {
                textView.setChecked(false);
            }
            int finalI = i;
            textView.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                    if (isChecked) {
                        cityPosition = finalI;
                        cityName = cityBean.getName();
                        addCityTextView();  //添加选择的城市到标题栏
                        mHandler.postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                initArea();
                            }
                        }, 100);
                    }
                }
            });
            addressLayout.addView(textView);
        }
    }

    //添加选择的城市到标题栏
    private void addCityTextView() {
        titleLayout.removeViews(1, titleLayout.getChildCount() - 1);
        TextView textView = new TextView(mActivity);
        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(WindowManager.LayoutParams.WRAP_CONTENT, WindowManager.LayoutParams.MATCH_PARENT);
        params.leftMargin = Window.toPx(20);
        textView.setLayoutParams(params);
        textView.setTextColor(Color.parseColor("#333333"));
        textView.setTextSize(18);
        textView.setGravity(Gravity.CENTER);
        textView.setText(cityName);
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                initCity();//添加选择的城市到标题栏
            }
        });
        titleLayout.addView(textView);
    }

    private void initArea() {
        addressLayout.removeAllViews();
        ProvinceEntity provinceEntity = provinceList.get(provincePosition);
        List<ProvinceEntity.CityListBean> cityList = provinceEntity.getCityList();
        List<ProvinceEntity.CityListBean.AreaListBean> areaList = cityList.get(cityPosition).getAreaList();
        for (int i = 0; i < areaList.size(); i++) {
            ProvinceEntity.CityListBean.AreaListBean areaBean = areaList.get(i);
            RadioButton textView = (RadioButton) mInflater.inflate(R.layout.item_city_button, null);
            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(WindowManager.LayoutParams.MATCH_PARENT, Window.toPx(34));
            params.leftMargin = Window.toPx(18);
            textView.setLayoutParams(params);
            textView.setText(areaBean.getName());
            Log.e("地址", "--是区的--" + new Gson().toJson(areaBean.getCode()));
//            Log.e("地址", "--是区的长度--"+areaList.size());
            textView.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                    if (isChecked) {
                        areaName = areaBean.getName();
//                        provinceCode = areaBean.getCode();
                        addAreaTextView();//添加选择的区域到标题栏
                    }
                }
            });
            addressLayout.addView(textView);

            if (areaBean.getName().equals(areaName)) {
                addressLayout.check(textView.getId());
            } else {
                textView.setChecked(false);
            }
        }
    }

    private void initAreaByName() {
        for (int i = 0; i < provinceList.size(); i++) {
            ProvinceEntity provinceEntity = provinceList.get(i);
//            Log.e("地址", "地址-----"+provinceEntity);
            if (provinceEntity.getName().equals(provinceName)) {
                provincePosition = i;
                break;
            }
        }
        ProvinceEntity provinceEntity = provinceList.get(provincePosition);
        List<ProvinceEntity.CityListBean> arrayList = provinceEntity.getCityList();

        for (int i = 0; i < arrayList.size(); i++) {
            ProvinceEntity.CityListBean cityBean = arrayList.get(i);
            if (cityBean.getName().equals(cityName)) {
                cityPosition = i;
                break;
            }
        }
//        Log.e("地址", "--是区的长度--"+arrayList.size());
        initArea();//初始化
    }

    //添加选择的区域到标题栏
    private void addAreaTextView() {
        titleLayout.removeViews(2, titleLayout.getChildCount() - 2);
        TextView textView = new TextView(mActivity);
        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(WindowManager.LayoutParams.WRAP_CONTENT, WindowManager.LayoutParams.MATCH_PARENT);
        params.leftMargin = Window.toPx(20);
        textView.setLayoutParams(params);
        textView.setTextColor(Color.parseColor("#333333"));
        textView.setTextSize(18);
        textView.setGravity(Gravity.CENTER);
        textView.setText(areaName);
        titleLayout.addView(textView);
    }

    public interface SelectAreaListener {
        void select(String province, String city, String area);
    }

    private SelectAreaListener selectAreaListener;

    public void setSelectAreaListener(SelectAreaListener selectAreaListener) {
        this.selectAreaListener = selectAreaListener;
    }
}
