package com.juyou.calendar.constant;

import com.juyou.calendar.base.BaseApplication;
import com.juyou.calendar.util.SpUtils;

public class WeatherContentUtil {
    //省市区json文件
    public static final String AREA_JSON = "AREA_JSON";
    //初始化和风天气的key和userName
    public static final String HE_PUBLIC_ID = "HE2110271712351913";
    //用户秘钥
    public static final String HE_APK_KEY = "d8f9930db8784825b9d6a3df91cd315f";
    //当前所在位置
    public static Double NOW_LON = 116.20;
    public static Double NOW_LAT = 39.56;

    public static boolean FIRST_OPEN = SpUtils.getBoolean(BaseApplication.getContext(), "first_open", true);
    //当前城市
    public static String NOW_CITY_ID = SpUtils.getString(BaseApplication.getContext(), "lastLocation", "CN101010100");
    public static String NOW_CITY_NAME = SpUtils.getString(BaseApplication.getContext(), "nowCityName", "北京");
    //应用设置里的文字
    public static String SYS_LANG = "zh";
    public static String APP_SETTING_LANG = SpUtils.getString(BaseApplication.getContext(), "language", "sys");

    public static boolean CITY_CHANGE = false;



    public static final String CLEAR_DAY = "CLEAR_DAY";//晴（白天）
    public static final String CLEAR_NIGHT = "CLEAR_NIGHT";//晴（夜间）
    public static final String PARTLY_CLOUDY_DAY = "PARTLY_CLOUDY_DAY";//多云（白天）
    public static final String PARTLY_CLOUDY_NIGHT = "PARTLY_CLOUDY_NIGHT";//多云（夜间）
    public static final String CLOUDY = "CLOUDY";//阴
    public static final String LIGHT_HAZE = "LIGHT_HAZE";//轻度雾霾
    public static final String MODERATE_HAZE = "MODERATE_HAZE";//重度雾霾
    public static final String HEAVY_HAZE = "HEAVY_HAZE";//重度雾霾
    public static final String LIGHT_RAIN = "LIGHT_RAIN";//小雨
    public static final String MODERATE_RAIN = "MODERATE_RAIN";//中雨
    public static final String HEAVY_RAIN = "HEAVY_RAIN";//大雨
    public static final String STORM_RAIN = "STORM_RAIN";//暴雨
    public static final String FOG = "FOG";////雾
    public static final String LIGHT_SNOW = "LIGHT_SNOW";//小雪
    public static final String MODERATE_SNOW = "MODERATE_SNOW";//中雪
    public static final String HEAVY_SNOW = "HEAVY_SNOW";//大雪
    public static final String STORM_SNOW = "STORM_SNOW";//暴雪
    public static final String DUST = "DUST";//浮尘
    public static final String SAND = "SAND";//沙尘
    public static final String WIND = "WIND";//大风
}
