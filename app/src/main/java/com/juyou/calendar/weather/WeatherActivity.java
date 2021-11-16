package com.juyou.calendar.weather;

import android.Manifest;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import com.amap.api.location.AMapLocation;
import com.amap.api.location.AMapLocationClient;
import com.amap.api.location.AMapLocationClientOption;
import com.amap.api.location.AMapLocationListener;
import com.google.gson.Gson;
import com.juyou.calendar.R;
import com.juyou.calendar.activity.MyMainActivity;
import com.juyou.calendar.adapter.weather.ViewPagerAdapter;
import com.juyou.calendar.bean.weather.CityBean;
import com.juyou.calendar.bean.weather.CityBeanList;
import com.juyou.calendar.constant.WeatherContentUtil;
import com.juyou.calendar.dialog.LocListWindow;
import com.juyou.calendar.util.DisplayUtil;
import com.juyou.calendar.util.SpUtils;

import org.joda.time.DateTime;

import java.util.ArrayList;
import java.util.List;

import interfaces.heweather.com.interfacesmodule.bean.base.Code;
import interfaces.heweather.com.interfacesmodule.bean.base.Lang;
import interfaces.heweather.com.interfacesmodule.bean.base.Mode;
import interfaces.heweather.com.interfacesmodule.bean.base.Range;
import interfaces.heweather.com.interfacesmodule.bean.geo.GeoBean;
import interfaces.heweather.com.interfacesmodule.bean.weather.WeatherNowBean;
import interfaces.heweather.com.interfacesmodule.view.HeWeather;

import static android.view.ViewGroup.LayoutParams.MATCH_PARENT;

public class WeatherActivity extends AppCompatActivity implements View.OnClickListener {
    final int REQUEST_PERMISSION_LOCATION = 10;
    public final String TAG = "WeatherActivity";


    private List<Fragment> fragments;
    private List<String> locaitons;
    private List<String> locaitonsEn;
    private List<String> cityIds;
    private List<String> lons;
    private List<String> lats;
    private ViewPager viewPager;
    private LinearLayout llRound;
    private int mNum = 0;
    private TextView tvLocation;
    private ImageView ivLoc;
    CityBeanList cityBeanList = new CityBeanList();
    //    private ImageView ivBack;
    private String condCode;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weather);
        Window window = getWindow();
        //透明状态栏
        window.addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);

        viewPager = findViewById(R.id.view_pager);
        llRound = findViewById(R.id.ll_round);
        tvLocation = findViewById(R.id.tv_location);
        ivLoc = findViewById(R.id.iv_loc);
//        ivBack = findViewById(R.id.iv_main_back);
        RelativeLayout rvTitle = findViewById(R.id.rv_title);
        initFragments(true);
        ImageView ivSet = findViewById(R.id.iv_set);
        ImageView ivAdd = findViewById(R.id.iv_add_city);
        ivSet.setOnClickListener(this);
        ivAdd.setOnClickListener(this);
        setMargins(viewPager, 0, getStatusBarHeight(this) + DisplayUtil.dip2px(this, 52), 0, 0);
        setMargins(rvTitle, 0, getStatusBarHeight(this), 0, 0);
        initPermission();
    }


    //声明AMapLocationClient类对象
    public AMapLocationClient mLocationClient = null;
    //声明定位回调监听器
    public AMapLocationListener mLocationListener = new AMapLocationListener() {
        @Override
        public void onLocationChanged(AMapLocation aMapLocation) {
            if (aMapLocation.getErrorCode() == 0) {
                WeatherContentUtil.NOW_LON = aMapLocation.getLongitude();
                WeatherContentUtil.NOW_LAT = aMapLocation.getLatitude();
                getNowCity(true);
                mLocationClient.onDestroy();
            } else {
                if (ContextCompat.checkSelfPermission(WeatherActivity.this, Manifest.permission.ACCESS_FINE_LOCATION)
                        != PackageManager.PERMISSION_GRANTED || ContextCompat.checkSelfPermission(WeatherActivity.this, Manifest.permission.READ_EXTERNAL_STORAGE)
                        != PackageManager.PERMISSION_GRANTED || ContextCompat.checkSelfPermission(WeatherActivity.this, Manifest.permission.READ_PHONE_STATE)
                        != PackageManager.PERMISSION_GRANTED) {
                    // 没有权限
                    View view = LayoutInflater.from(WeatherActivity.this).inflate(R.layout.pop_loc_list, null);
                    LocListWindow locListWindow = new LocListWindow(view, MATCH_PARENT, MATCH_PARENT, WeatherActivity.this);
                    locListWindow.show();
                    locListWindow.showAtLocation(tvLocation, Gravity.CENTER, 0, 0);
                    if (WeatherContentUtil.FIRST_OPEN) {
                        WeatherContentUtil.FIRST_OPEN = false;
                        SpUtils.putBoolean(WeatherActivity.this, "first_open", false);
                    }
                }
                getNowCity(true);
                mLocationClient.onDestroy();
            }
        }
    };

    /**
     * 兼容全面屏的状态栏高度
     */
    public void setMargins(View view, int l, int t, int r, int b) {
        if (view.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) {
            ViewGroup.MarginLayoutParams p = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
            p.setMargins(l, t, r, b);
            view.requestLayout();
        }
    }

    /**
     * 获取状态栏高度
     */
    private static int getStatusBarHeight(Context context) {
        int resourceId = context.getResources().getIdentifier("status_bar_height", "dimen", "android");
        return context.getResources().getDimensionPixelSize(resourceId);
    }

    private void initFragments(boolean first) {
        cityBeanList = SpUtils.getBean(WeatherActivity.this, "cityBean", CityBeanList.class);
        CityBeanList cityBeanEn = SpUtils.getBean(WeatherActivity.this, "cityBeanEn", CityBeanList.class);
        CityBeanList cityBean = SpUtils.getBean(WeatherActivity.this, "cityBean", CityBeanList.class);
        locaitonsEn = new ArrayList<>();
        locaitons = new ArrayList<>();
        if (cityBeanEn != null) {
            for (CityBean city : cityBeanEn.getCityBeans()) {
                String cityName = city.getCityName();
                locaitonsEn.add(cityName);
            }
        }
        if (cityBean != null) {
            for (CityBean city : cityBean.getCityBeans()) {
                String cityName = city.getCityName();
                locaitons.add(cityName);
            }
        }
        cityIds = new ArrayList<>();
        lons = new ArrayList<>();
        lats = new ArrayList<>();
        fragments = new ArrayList<>();
        if (first) {
            initLocation();
        } else {
            getNowCity(false);
            Log.e("HeWeather", "--------555------------" + WeatherContentUtil.NOW_LON + "," + WeatherContentUtil.NOW_LAT);
        }

    }

    private void initLocation() {
        //初始化定位
        mLocationClient = new AMapLocationClient(getApplicationContext());
        //设置定位回调监听

        //声明AMapLocationClientOption对象
        AMapLocationClientOption mLocationOption = new AMapLocationClientOption();
        //设置定位模式为AMapLocationMode.Hight_Accuracy，高精度模式。
        mLocationOption.setLocationMode(AMapLocationClientOption.AMapLocationMode.Hight_Accuracy);
        //设置定位间隔,单位毫秒,默认为2000ms，最低1000ms。
        mLocationOption.setInterval(10000);
        //单位是毫秒，默认30000毫秒，建议超时时间不要低于8000毫秒。
        mLocationOption.setHttpTimeOut(20000);
        mLocationClient.setLocationListener(mLocationListener);
        //给定位客户端对象设置定位参数
        mLocationClient.setLocationOption(mLocationOption);
        //启动定位
        mLocationClient.startLocation();
    }

    private void getNowCity(final boolean first) {
        Lang lang;
        if (WeatherContentUtil.APP_SETTING_LANG.equals("en") || WeatherContentUtil.APP_SETTING_LANG.equals("sys") && WeatherContentUtil.SYS_LANG.equals("en")) {
            lang = Lang.EN;
        } else {
            lang = Lang.ZH_HANS;
        }
        HeWeather.getGeoCityLookup(this, WeatherContentUtil.NOW_LON + "," + WeatherContentUtil.NOW_LAT, Mode.FUZZY, Range.WORLD, 3, lang, new HeWeather.OnResultGeoListener() {
            @Override
            public void onError(Throwable throwable) {
                List<CityBean> cityBeans = new ArrayList<>();
                CityBean cityBean = new CityBean();
                cityBean.setCityName("北京");
                cityBean.setCityId("CN101010100");
                cityBeans.add(cityBean);
                getData(cityBeans, first);
            }

            @Override
            public void onSuccess(GeoBean search) {
                GeoBean.LocationBean basic = search.getLocationBean().get(0);
                String cid = basic.getId();
                String location = basic.getName();
                Log.e("HeWeather", "-----1111--DVD发---------HeWeather.getGeoCityLookup");
                if (first) {
                    Log.e("HeWeather", "--first---1111");

                    WeatherContentUtil.NOW_CITY_ID = cid;
                    WeatherContentUtil.NOW_CITY_NAME = location;
                }

                List<CityBean> cityBeans = new ArrayList<>();
                CityBean cityBean = new CityBean();
                cityBean.setCityName(location);
                cityBean.setCityId(cid);
                cityBean.setLat(basic.getLat());
                cityBean.setLon(basic.getLon());

                locaitons.add(0, location);
                locaitonsEn.add(0, location);
                if (cityBeanList != null && cityBeanList.getCityBeans() != null && cityBeanList.getCityBeans().size() > 0) {
                    cityBeans = cityBeanList.getCityBeans();
                    cityBeans.add(0, cityBean);
                } else {
                    cityBeans.add(cityBean);
                }
                tvLocation.setText(location);//地理位置，西湖
//                Log.e("HeWeather", "cityBeans-------发多个-------" + new Gson().toJson(cityBeans));

                getData(cityBeans, first);
            }
        });
    }

    private void getNow(String location, final boolean nowCity) {
        Log.e("HeWeather", "----------222------HeWeather.getGeoCityLookup" + location);

        HeWeather.getGeoCityLookup(this, location, Mode.FUZZY, Range.WORLD, 3, Lang.ZH_HANS, new HeWeather.OnResultGeoListener() {
            @Override
            public void onError(Throwable throwable) {

            }

            @Override
            public void onSuccess(GeoBean search) {
                GeoBean.LocationBean basic = search.getLocationBean().get(0);
                String cid = basic.getId();
                String location = basic.getName();

                if (nowCity) {
                    WeatherContentUtil.NOW_CITY_ID = cid;
                    WeatherContentUtil.NOW_CITY_NAME = location;
                    if (cityIds != null && cityIds.size() > 0) {
                        cityIds.add(0, cid);
                        cityIds.remove(1);
                        Log.e("HeWeather", "----------222--" + cityIds);

                    }
                }
                HeWeather.getWeatherNow(WeatherActivity.this, cid, new HeWeather.OnResultWeatherNowListener() {
                    @Override
                    public void onError(Throwable throwable) {

                    }

                    @Override
                    public void onSuccess(WeatherNowBean weatherNowBean) {
                        if (Code.OK.getCode().equalsIgnoreCase(weatherNowBean.getCode())) {
//                            Log.e("HeWeather", "--------333333333-------HeWeather.getWeatherNow");

                            WeatherNowBean.NowBaseBean now = weatherNowBean.getNow();
                            condCode = now.getIcon();
                            DateTime nowTime = DateTime.now();
                            int hourOfDay = nowTime.getHourOfDay();
                            Log.e("HeWeather", "--------333333333------condCode" + condCode);

//                            if (hourOfDay > 6 && hourOfDay < 19) {
//                                ivBack.setImageResource(IconUtils.getDayIconDark(condCode));
//                            } else {
//                                ivBack.setImageResource(IconUtils.getDayIconDark(condCode));
//                            }
                        }
                    }

                });
            }
        });
    }

    /**
     * 获取数据
     */
    private void getData(List<CityBean> cityBeans, boolean first) {
        fragments = new ArrayList<>();
        llRound.removeAllViews();
        for (CityBean city : cityBeans) {
            String cityId = city.getCityId();
            String cityLon = city.getLon();
            String cityLat = city.getLat();
            cityIds.add(cityId);
            lats.add(cityLat);
            lons.add(cityLon);
            WeatherFragment weatherFragment = WeatherFragment.newInstance(cityId, cityLat, cityLon);
            fragments.add(weatherFragment);
        }
//        if (cityIds.get(0).equalsIgnoreCase(WeatherContentUtil.NOW_CITY_ID)) {
//            ivLoc.setVisibility(View.VISIBLE);
//        } else {
//            ivLoc.setVisibility(View.INVISIBLE);
//        }
        View view;
        for (int i = 0; i < fragments.size(); i++) {
            //创建底部指示器(小圆点)
            view = new View(WeatherActivity.this);
            view.setBackgroundResource(R.drawable.background);
            view.setEnabled(false);
            //设置宽高
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(DisplayUtil.dip2px(this, 4), DisplayUtil.dip2px(this, 4));
            //设置间隔
            if (fragments.get(i) != fragments.get(0)) {
                layoutParams.leftMargin = 10;
            }
            //添加到LinearLayout
            llRound.addView(view, layoutParams);
        }
        viewPager.setAdapter(new ViewPagerAdapter(getSupportFragmentManager(), fragments));
        //第一次显示小白点
        llRound.getChildAt(0).setEnabled(true);
        mNum = 0;
        if (fragments.size() == 1) {
            llRound.setVisibility(View.GONE);
        } else {
            llRound.setVisibility(View.VISIBLE);
        }
        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int i, float v, int i1) {

            }

            @Override
            public void onPageSelected(int i) {
                if (cityIds.get(i).equalsIgnoreCase(WeatherContentUtil.NOW_CITY_ID)) {
                    ivLoc.setVisibility(View.VISIBLE);
                } else {
                    ivLoc.setVisibility(View.INVISIBLE);
                }
                llRound.getChildAt(mNum).setEnabled(false);
                llRound.getChildAt(i).setEnabled(true);
                mNum = i;
                tvLocation.setText(locaitons.get(i));
                if (WeatherContentUtil.SYS_LANG.equalsIgnoreCase("en")) {
                    tvLocation.setText(locaitonsEn.get(i));
                }
            }

            @Override
            public void onPageScrollStateChanged(int i) {

            }
        });
        if (!first && fragments.size() > 1) {
            viewPager.setCurrentItem(1);
            getNow(cityIds.get(1), false);
        } else {
            viewPager.setCurrentItem(0);
            getNow(WeatherContentUtil.NOW_LON + "," + WeatherContentUtil.NOW_LAT, true);
        }
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.iv_set:
                startActivity(new Intent(this, ManageCityActivity.class));
                break;
            case R.id.iv_add_city:
                startActivity(new Intent(this, AddCityActivity.class));
                break;
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.e("Weather", "onResume-----");
    }

    private void initPermission() {

        if (Build.VERSION.SDK_INT >= 23) {
            // Here, thisActivity is the current activity
            if (ContextCompat.checkSelfPermission(this,
                    Manifest.permission.ACCESS_FINE_LOCATION)
                    != PackageManager.PERMISSION_GRANTED) {
                Log.e(TAG, "checkSelfPermission");
                // Should we show an explanation?
                if (ActivityCompat.shouldShowRequestPermissionRationale(this,
                        Manifest.permission.ACCESS_FINE_LOCATION)) {
                    Log.e(TAG, "shouldShowRequestPermissionRationale");
                    // Show an expanation to the user *asynchronously* -- don't block
                    // this thread waiting for the user's response! After the user
                    // sees the explanation, try again to request the permission.

                    ActivityCompat.requestPermissions(this,
                            new String[]{Manifest.permission.ACCESS_FINE_LOCATION},
                            REQUEST_PERMISSION_LOCATION);

                } else {
                    Log.e(TAG, "requestPermissions");
                    // No explanation needed, we can request the permission.
                    ActivityCompat.requestPermissions(this,
                            new String[]{Manifest.permission.ACCESS_FINE_LOCATION},
                            REQUEST_PERMISSION_LOCATION);
                    // REQUEST_PERMISSION_LOCATION is an
                    // app-defined int constant. The callback method gets the
                    // result of the request.
                }
            } else {

            }
        }

    }

    @Override
    public void onRequestPermissionsResult(int requestCode,
                                           String permissions[], int[] grantResults) {
        switch (requestCode) {
            case REQUEST_PERMISSION_LOCATION: {
                // If request is cancelled, the result arrays are empty.
                if (grantResults.length > 0
                        && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    Log.i(TAG, "onRequestPermissionsResult granted");
                    // permission was granted, yay! Do the
                    // contacts-related task you need to do.

                } else {
                    Log.i(TAG, "onRequestPermissionsResult denied");
                    // permission denied, boo! Disable the
                    // functionality that depends on this permission.
                    showWaringDialog();
                }
                return;
            }

            // other 'case' lines to check for other
            // permissions this app might request
        }
    }

    private void showWaringDialog() {
        AlertDialog dialog = new AlertDialog.Builder(this)
                .setTitle("警告！")
                .setMessage("请前往设置->应用->PermissionDemo->权限中打开相关权限，否则功能无法正常运行！")
                .setPositiveButton("确定", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        // 一般情况下如果用户不授权的话，功能是无法运行的，做退出处理
                        finish();
                    }
                }).show();
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            Intent intent = new Intent(WeatherActivity.this, MyMainActivity.class);
            intent.putExtra("SelectIndex", 1);
            startActivity(intent);
            finish();
        }
        return false;
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.e("Weather", "onRestart");
        //在这刷新fragment
        initFragments(true);
    }

}
