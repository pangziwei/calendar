package com.juyou.calendar.util;


import com.juyou.calendar.R;
import com.juyou.calendar.constant.WeatherContentUtil;

public class IconUtils {

    /**
     * 获取白天深色天气图标
     */
    public static int getDayIconDark(String weather) {
        int imageId;
        switch (weather) {
            case "3":
                imageId = R.mipmap.icon_311d;
                break;
            case "4":
                imageId = R.mipmap.icon_303d;
                break;
            case "5":
                imageId = R.mipmap.icon_405d;
                break;
            case "7":
                imageId = R.mipmap.icon_404n;
                break;
            case "8":
                imageId = R.mipmap.icon_313d;
                break;
            case "9":
                imageId = R.mipmap.icon_309d;
                break;
            case "10":
                imageId = R.mipmap.icon_399d;
                break;
            case "11":
                imageId = R.mipmap.icon_305d;
                break;
            case "12":
                imageId = R.mipmap.icon_399d;
                break;
            case "14":
                imageId = R.mipmap.icon_400d;
                break;
            case "16":
                imageId = R.mipmap.icon_499d;
                break;
            case "20":
                imageId = R.mipmap.icon_501d;
                break;
            case "24":
                imageId = R.mipmap.icon_103d;
                break;
            case "26":
                imageId = R.mipmap.icon_101d;
                break;
            case "27":
                imageId = R.mipmap.icon_101d;
                break;
            case "28":
                imageId = R.mipmap.icon_101d;
                break;
            case "29":
                imageId = R.mipmap.icon_101d;
                break;
            case "30":
                imageId = R.mipmap.icon_103d;
                break;
            case "31":
                imageId = R.mipmap.icon_100d;
                break;
            case "32":
                imageId = R.mipmap.icon_100d;
                break;
            case "33":
                imageId = R.mipmap.icon_103d;
                break;
            case "34":
                imageId = R.mipmap.icon_101d;
                break;
            case "37":
                imageId = R.mipmap.icon_302d;
                break;
            case "38":
                imageId = R.mipmap.icon_304d;
                break;
            case "40":
                imageId = R.mipmap.icon_307d;
                break;
            case "42":
                imageId = R.mipmap.icon_402d;
                break;
            case "47":
                imageId = R.mipmap.icon_302d;
                break;
            default:
                imageId = R.mipmap.icon_999d;
                break;

        }
        return imageId;
    }


    /**
     * 获取白天深色天气图标
     */
    public static int getNightIconDark(String weather) {
        int imageId;
        switch (weather) {
            case "100":
                imageId = R.mipmap.icon_100n;
                break;
            case "101":
                imageId = R.mipmap.icon_101n;
                break;
            case "102":
                imageId = R.mipmap.icon_102n;
                break;
            case "103":
                imageId = R.mipmap.icon_103n;
                break;
            case "104":
                imageId = R.mipmap.icon_104n;
                break;
            case "200":
                imageId = R.mipmap.icon_200n;
                break;
            case "201":
                imageId = R.mipmap.icon_210n;
                break;
            case "202":
                imageId = R.mipmap.icon_202n;
                break;
            case "203":
                imageId = R.mipmap.icon_203n;
                break;
            case "204":
                imageId = R.mipmap.icon_204n;
                break;
            case "205":
                imageId = R.mipmap.icon_205n;
                break;
            case "206":
                imageId = R.mipmap.icon_206n;
                break;
            case "207":
                imageId = R.mipmap.icon_207n;
                break;
            case "208":
                imageId = R.mipmap.icon_208n;
                break;
            case "209":
                imageId = R.mipmap.icon_209n;
                break;
            case "210":
                imageId = R.mipmap.icon_210n;
                break;
            case "211":
                imageId = R.mipmap.icon_211n;
                break;
            case "212":
                imageId = R.mipmap.icon_212n;
                break;
            case "213":
                imageId = R.mipmap.icon_213n;
                break;
            case "300":
                imageId = R.mipmap.icon_300n;
                break;
            case "301":
                imageId = R.mipmap.icon_301n;
                break;
            case "302":
                imageId = R.mipmap.icon_302n;
                break;
            case "303":
                imageId = R.mipmap.icon_303n;
                break;
            case "304":
                imageId = R.mipmap.icon_304n;
                break;
            case "305":
                imageId = R.mipmap.icon_305n;
                break;
            case "306":
                imageId = R.mipmap.icon_306n;
                break;
            case "307":
                imageId = R.mipmap.icon_307n;
                break;
            case "308":
                imageId = R.mipmap.icon_308n;
                break;
            case "309":
                imageId = R.mipmap.icon_309n;
                break;
            case "310":
                imageId = R.mipmap.icon_310n;
                break;
            case "311":
                imageId = R.mipmap.icon_311n;
                break;
            case "312":
                imageId = R.mipmap.icon_312n;
                break;
            case "313":
                imageId = R.mipmap.icon_313n;
                break;
            case "314":
                imageId = R.mipmap.icon_314n;
                break;
            case "315":
                imageId = R.mipmap.icon_315n;
                break;
            case "316":
                imageId = R.mipmap.icon_316n;
                break;
            case "317":
                imageId = R.mipmap.icon_317n;
                break;
            case "318":
                imageId = R.mipmap.icon_318n;
                break;
            case "399":
                imageId = R.mipmap.icon_399n;
                break;
            case "400":
                imageId = R.mipmap.icon_400n;
                break;
            case "401":
                imageId = R.mipmap.icon_401n;
                break;
            case "402":
                imageId = R.mipmap.icon_402n;
                break;
            case "403":
                imageId = R.mipmap.icon_403n;
                break;
            case "404":
                imageId = R.mipmap.icon_404n;
                break;
            case "405":
                imageId = R.mipmap.icon_405n;
                break;
            case "406":
                imageId = R.mipmap.icon_406n;
                break;
            case "407":
                imageId = R.mipmap.icon_407n;
                break;
            case "408":
                imageId = R.mipmap.icon_408n;
                break;
            case "409":
                imageId = R.mipmap.icon_409n;
                break;
            case "410":
                imageId = R.mipmap.icon_410n;
                break;
            case "499":
                imageId = R.mipmap.icon_499n;
                break;
            case "500":
                imageId = R.mipmap.icon_500n;
                break;
            case "501":
                imageId = R.mipmap.icon_501n;
                break;
            case "502":
                imageId = R.mipmap.icon_502n;
                break;
            case "503":
                imageId = R.mipmap.icon_503n;
                break;
            case "504":
                imageId = R.mipmap.icon_504n;
                break;
            case "507":
                imageId = R.mipmap.icon_507n;
                break;
            case "508":
                imageId = R.mipmap.icon_508n;
                break;
            case "509":
                imageId = R.mipmap.icon_509n;
                break;
            case "510":
                imageId = R.mipmap.icon_510n;
                break;
            case "511":
                imageId = R.mipmap.icon_511n;
                break;
            case "512":
                imageId = R.mipmap.icon_512n;
                break;
            case "513":
                imageId = R.mipmap.icon_513n;
                break;
            case "514":
                imageId = R.mipmap.icon_514n;
                break;
            case "515":
                imageId = R.mipmap.icon_515n;
                break;
            case "900":
                imageId = R.mipmap.icon_900n;
                break;
            case "901":
                imageId = R.mipmap.icon_901n;
                break;
            case "999":
                imageId = R.mipmap.icon_999n;
                break;
            default:
                imageId = R.mipmap.icon_100n;
                break;

        }
        return imageId;
    }

    /**
     * 获取天气图标
     * xue、lei、shachen、wu、bingbao、yun、yu、yin、qing
     */
    public static int getWeatherIcon(String weather) {
        int imageId;
        switch (weather) {
            case "xue":
                imageId = R.mipmap.xue;
                break;
            case "lei":
                imageId = R.mipmap.lei;
                break;
            case "shachen":
                imageId = R.mipmap.shachen;
                break;
            case "wu":
                imageId = R.mipmap.wu;
                break;
            case "bingbao":
                imageId = R.mipmap.bingbao;
                break;
            case "yun":
                imageId = R.mipmap.yun;
                break;
            case "yu":
                imageId = R.mipmap.yu;
                break;
            case "yin":
                imageId = R.mipmap.yin;
                break;
            case "qing":
                imageId = R.mipmap.qing;
                break;
            case "yujiaxue":
                imageId = R.mipmap.yujiaxue;
                break;

            default:
                imageId = R.mipmap.icon_999d;
                break;

        }
        return imageId;
    }


    public static int getSkyIcon(String icon) {
        int imageId;
        switch (icon) {
            case WeatherContentUtil.CLEAR_DAY:
                imageId = R.mipmap.ic_weather_clear;
                break;
            case WeatherContentUtil.CLEAR_NIGHT:
                imageId = R.mipmap.ic_weather_qing_night;
                break;
            case WeatherContentUtil.PARTLY_CLOUDY_DAY:
                imageId = R.mipmap.ic_weather_cloudy_day;
                break;
            case WeatherContentUtil.PARTLY_CLOUDY_NIGHT:
                imageId = R.mipmap.ic_weather_cloudy_night;
                break;
            case WeatherContentUtil.CLOUDY:
                imageId = R.mipmap.ic_weather_cloudy;
                break;
            case WeatherContentUtil.LIGHT_HAZE:
                imageId = R.mipmap.ic_weather_light_haze;
                break;
            case WeatherContentUtil.MODERATE_HAZE:
                imageId = R.mipmap.ic_weather_moderate_haze;
                break;
            case WeatherContentUtil.HEAVY_HAZE:
                imageId = R.mipmap.ic_weather_heavy_haze;
                break;
            case WeatherContentUtil.LIGHT_RAIN:
                imageId = R.mipmap.ic_weather_light_rain;
                break;
            case WeatherContentUtil.MODERATE_RAIN:
                imageId = R.mipmap.ic_weather_moderate_rain;
                break;
            case WeatherContentUtil.HEAVY_RAIN:
                imageId = R.mipmap.ic_weather_heavy_rain;
                break;
            case WeatherContentUtil.STORM_RAIN:
                imageId = R.mipmap.ic_weather_storm_rain;
                break;
            case WeatherContentUtil.FOG:
                imageId = R.mipmap.ic_weather_fog;
                break;
            case WeatherContentUtil.LIGHT_SNOW:
                imageId = R.mipmap.ic_weather_light_snow;
                break;
            case WeatherContentUtil.MODERATE_SNOW:
                imageId = R.mipmap.ic_weather_moderate_snow;
                break;
            case WeatherContentUtil.HEAVY_SNOW:
                imageId = R.mipmap.ic_weather_heavy_snow;
                break;
            case WeatherContentUtil.STORM_SNOW:
                imageId = R.mipmap.ic_weather_storm_snow;
                break;
            case WeatherContentUtil.DUST:
                imageId = R.mipmap.ic_weather_dust;
                break;
            case WeatherContentUtil.SAND:
                imageId = R.mipmap.ic_weather_sand;
                break;
            case WeatherContentUtil.WIND:
                imageId = R.mipmap.ic_weather_wind;
                break;
            default:
                imageId = R.mipmap.ic_weather_clear;
                break;
        }
        return imageId;
    }


    public static String getSkyDes(String des) {
        String skyIcon = " ";
        switch (des) {
            case WeatherContentUtil.CLEAR_DAY:
                skyIcon = "晴";
                break;
            case WeatherContentUtil.CLEAR_NIGHT:
                skyIcon = "晴";
                break;
            case WeatherContentUtil.PARTLY_CLOUDY_DAY:
                skyIcon = "多云";
                break;
            case WeatherContentUtil.PARTLY_CLOUDY_NIGHT:
                skyIcon = "多云";
                break;
            case WeatherContentUtil.CLOUDY:
                skyIcon = "阴";
                break;
            case WeatherContentUtil.LIGHT_HAZE:
                skyIcon = "轻度雾霾";
                break;
            case WeatherContentUtil.MODERATE_HAZE:
                skyIcon = "中度雾霾";
                break;
            case WeatherContentUtil.HEAVY_HAZE:
                skyIcon = "重度雾霾";
                break;
            case WeatherContentUtil.LIGHT_RAIN:
                skyIcon = "小雨";
                break;
            case WeatherContentUtil.MODERATE_RAIN:
                skyIcon = "中雨";
                break;
            case WeatherContentUtil.HEAVY_RAIN:
                skyIcon = "大雨";
                break;
            case WeatherContentUtil.STORM_RAIN:
                skyIcon = "暴雨";
                break;
            case WeatherContentUtil.FOG:
                skyIcon = "雾";
                break;
            case WeatherContentUtil.LIGHT_SNOW:
                skyIcon = "小雪";
                break;
            case WeatherContentUtil.MODERATE_SNOW:
                skyIcon = "中雪";
                break;
            case WeatherContentUtil.HEAVY_SNOW:
                skyIcon = "大雪";
                break;
            case WeatherContentUtil.STORM_SNOW:
                skyIcon = "暴雪";
                break;
            case WeatherContentUtil.DUST:
                skyIcon = "浮尘";
                break;
            case WeatherContentUtil.SAND:
                skyIcon = "沙尘";
                break;
            case WeatherContentUtil.WIND:
                skyIcon = "大风";
                break;
        }
        return skyIcon;
    }


//    /**
//     * 获取白天背景
//     */
//    public static int getDayBack(String weather) {
//        int imageId;
//        switch (weather) {
//            case "100":
//                imageId = R.mipmap.back_100d;
//                break;
//            case "101":
//                imageId = R.mipmap.back_101d;
//                break;
//            case "102":
//                imageId = R.mipmap.back_102d;
//                break;
//            case "103":
//                imageId = R.mipmap.back_103d;
//                break;
//            case "104":
//                imageId = R.mipmap.back_104d;
//                break;
//            case "200":
//                imageId = R.mipmap.back_200d;
//                break;
//            case "201":
//                imageId = R.mipmap.back_210d;
//                break;
//            case "202":
//                imageId = R.mipmap.back_202d;
//                break;
//            case "203":
//                imageId = R.mipmap.back_203d;
//                break;
//            case "204":
//                imageId = R.mipmap.back_204d;
//                break;
//            case "205":
//                imageId = R.mipmap.back_205d;
//                break;
//            case "206":
//                imageId = R.mipmap.back_206d;
//                break;
//            case "207":
//                imageId = R.mipmap.back_207d;
//                break;
//            case "208":
//                imageId = R.mipmap.back_208d;
//                break;
//            case "209":
//                imageId = R.mipmap.back_209d;
//                break;
//            case "210":
//                imageId = R.mipmap.back_210d;
//                break;
//            case "211":
//                imageId = R.mipmap.back_211d;
//                break;
//            case "212":
//                imageId = R.mipmap.back_212d;
//                break;
//            case "213":
//                imageId = R.mipmap.back_213d;
//                break;
//            case "300":
//                imageId = R.mipmap.back_300d;
//                break;
//            case "301":
//                imageId = R.mipmap.back_301d;
//                break;
//            case "302":
//                imageId = R.mipmap.back_302d;
//                break;
//            case "303":
//                imageId = R.mipmap.back_303d;
//                break;
//            case "304":
//                imageId = R.mipmap.back_304d;
//                break;
//            case "305":
//                imageId = R.mipmap.back_305d;
//                break;
//            case "306":
//                imageId = R.mipmap.back_306d;
//                break;
//            case "307":
//                imageId = R.mipmap.back_307d;
//                break;
//            case "308":
//                imageId = R.mipmap.back_308d;
//                break;
//            case "309":
//                imageId = R.mipmap.back_309d;
//                break;
//            case "310":
//                imageId = R.mipmap.back_310d;
//                break;
//            case "311":
//                imageId = R.mipmap.back_311d;
//                break;
//            case "312":
//                imageId = R.mipmap.back_312d;
//                break;
//            case "313":
//                imageId = R.mipmap.back_313d;
//                break;
//            case "314":
//                imageId = R.mipmap.back_314d;
//                break;
//            case "315":
//                imageId = R.mipmap.back_315d;
//                break;
//            case "316":
//                imageId = R.mipmap.back_316d;
//                break;
//            case "317":
//                imageId = R.mipmap.back_317d;
//                break;
//            case "318":
//                imageId = R.mipmap.back_318d;
//                break;
//            case "399":
//                imageId = R.mipmap.back_399d;
//                break;
//            case "400":
//                imageId = R.mipmap.back_400d;
//                break;
//            case "401":
//                imageId = R.mipmap.back_401d;
//                break;
//            case "402":
//                imageId = R.mipmap.back_402d;
//                break;
//            case "403":
//                imageId = R.mipmap.back_403d;
//                break;
//            case "404":
//                imageId = R.mipmap.back_404d;
//                break;
//            case "405":
//                imageId = R.mipmap.back_405d;
//                break;
//            case "406":
//                imageId = R.mipmap.back_406d;
//                break;
//            case "407":
//                imageId = R.mipmap.back_407d;
//                break;
//            case "408":
//                imageId = R.mipmap.back_408d;
//                break;
//            case "409":
//                imageId = R.mipmap.back_409d;
//                break;
//            case "410":
//                imageId = R.mipmap.back_410d;
//                break;
//            case "499":
//                imageId = R.mipmap.back_499d;
//                break;
//            case "500":
//                imageId = R.mipmap.back_500d;
//                break;
//            case "501":
//                imageId = R.mipmap.back_501d;
//                break;
//            case "502":
//                imageId = R.mipmap.back_502d;
//                break;
//            case "503":
//                imageId = R.mipmap.back_503d;
//                break;
//            case "504":
//                imageId = R.mipmap.back_504d;
//                break;
//            case "507":
//                imageId = R.mipmap.back_507d;
//                break;
//            case "508":
//                imageId = R.mipmap.back_508d;
//                break;
//            case "509":
//                imageId = R.mipmap.back_509d;
//                break;
//            case "510":
//                imageId = R.mipmap.back_510d;
//                break;
//            case "511":
//                imageId = R.mipmap.back_511d;
//                break;
//            case "512":
//                imageId = R.mipmap.back_512d;
//                break;
//            case "513":
//                imageId = R.mipmap.back_513d;
//                break;
//            case "514":
//                imageId = R.mipmap.back_514d;
//                break;
//            case "515":
//                imageId = R.mipmap.back_515d;
//                break;
//            case "900":
//                imageId = R.mipmap.back_900d;
//                break;
//            case "901":
//                imageId = R.mipmap.back_901d;
//                break;
//            case "999":
//                imageId = R.mipmap.back_999d;
//                break;
//            default:
//                imageId = R.mipmap.back_100d;
//                break;
//
//        }
//        return imageId;
//    }
//    /**
//     * 获取晚上背景
//     */
//    public static int getNightBack(String weather) {
//        int imageId;
//        switch (weather) {
//            case "100":
//                imageId = R.mipmap.back_100n;
//                break;
//            case "101":
//                imageId = R.mipmap.back_101n;
//                break;
//            case "102":
//                imageId = R.mipmap.back_102n;
//                break;
//            case "103":
//                imageId = R.mipmap.back_103n;
//                break;
//            case "104":
//                imageId = R.mipmap.back_104n;
//                break;
//            case "200":
//                imageId = R.mipmap.back_200n;
//                break;
//            case "201":
//                imageId = R.mipmap.back_210n;
//                break;
//            case "202":
//                imageId = R.mipmap.back_202n;
//                break;
//            case "203":
//                imageId = R.mipmap.back_203n;
//                break;
//            case "204":
//                imageId = R.mipmap.back_204n;
//                break;
//            case "205":
//                imageId = R.mipmap.back_205n;
//                break;
//            case "206":
//                imageId = R.mipmap.back_206n;
//                break;
//            case "207":
//                imageId = R.mipmap.back_207n;
//                break;
//            case "208":
//                imageId = R.mipmap.back_208n;
//                break;
//            case "209":
//                imageId = R.mipmap.back_209n;
//                break;
//            case "210":
//                imageId = R.mipmap.back_210n;
//                break;
//            case "211":
//                imageId = R.mipmap.back_211n;
//                break;
//            case "212":
//                imageId = R.mipmap.back_212n;
//                break;
//            case "213":
//                imageId = R.mipmap.back_213n;
//                break;
//            case "300":
//                imageId = R.mipmap.back_300n;
//                break;
//            case "301":
//                imageId = R.mipmap.back_301n;
//                break;
//            case "302":
//                imageId = R.mipmap.back_302n;
//                break;
//            case "303":
//                imageId = R.mipmap.back_303n;
//                break;
//            case "304":
//                imageId = R.mipmap.back_304n;
//                break;
//            case "305":
//                imageId = R.mipmap.back_305n;
//                break;
//            case "306":
//                imageId = R.mipmap.back_306n;
//                break;
//            case "307":
//                imageId = R.mipmap.back_307n;
//                break;
//            case "308":
//                imageId = R.mipmap.back_308n;
//                break;
//            case "309":
//                imageId = R.mipmap.back_309n;
//                break;
//            case "310":
//                imageId = R.mipmap.back_310n;
//                break;
//            case "311":
//                imageId = R.mipmap.back_311n;
//                break;
//            case "312":
//                imageId = R.mipmap.back_312n;
//                break;
//            case "313":
//                imageId = R.mipmap.back_313n;
//                break;
//            case "314":
//                imageId = R.mipmap.back_314n;
//                break;
//            case "315":
//                imageId = R.mipmap.back_315n;
//                break;
//            case "316":
//                imageId = R.mipmap.back_316n;
//                break;
//            case "317":
//                imageId = R.mipmap.back_317n;
//                break;
//            case "318":
//                imageId = R.mipmap.back_318n;
//                break;
//            case "399":
//                imageId = R.mipmap.back_399n;
//                break;
//            case "400":
//                imageId = R.mipmap.back_400n;
//                break;
//            case "401":
//                imageId = R.mipmap.back_401n;
//                break;
//            case "402":
//                imageId = R.mipmap.back_402n;
//                break;
//            case "403":
//                imageId = R.mipmap.back_403n;
//                break;
//            case "404":
//                imageId = R.mipmap.back_404n;
//                break;
//            case "405":
//                imageId = R.mipmap.back_405n;
//                break;
//            case "406":
//                imageId = R.mipmap.back_406n;
//                break;
//            case "407":
//                imageId = R.mipmap.back_407n;
//                break;
//            case "408":
//                imageId = R.mipmap.back_408n;
//                break;
//            case "409":
//                imageId = R.mipmap.back_409n;
//                break;
//            case "410":
//                imageId = R.mipmap.back_410n;
//                break;
//            case "499":
//                imageId = R.mipmap.back_499n;
//                break;
//            case "500":
//                imageId = R.mipmap.back_500n;
//                break;
//            case "501":
//                imageId = R.mipmap.back_501n;
//                break;
//            case "502":
//                imageId = R.mipmap.back_502n;
//                break;
//            case "503":
//                imageId = R.mipmap.back_503n;
//                break;
//            case "504":
//                imageId = R.mipmap.back_504n;
//                break;
//            case "507":
//                imageId = R.mipmap.back_507n;
//                break;
//            case "508":
//                imageId = R.mipmap.back_508n;
//                break;
//            case "509":
//                imageId = R.mipmap.back_509n;
//                break;
//            case "510":
//                imageId = R.mipmap.back_510n;
//                break;
//            case "511":
//                imageId = R.mipmap.back_511n;
//                break;
//            case "512":
//                imageId = R.mipmap.back_512n;
//                break;
//            case "513":
//                imageId = R.mipmap.back_513n;
//                break;
//            case "514":
//                imageId = R.mipmap.back_514n;
//                break;
//            case "515":
//                imageId = R.mipmap.back_515n;
//                break;
//            case "900":
//                imageId = R.mipmap.back_900n;
//                break;
//            case "901":
//                imageId = R.mipmap.back_901n;
//                break;
//            case "999":
//                imageId = R.mipmap.back_999n;
//                break;
//            default:
//                imageId = R.mipmap.back_100n;
//                break;
//
//        }
//        return imageId;
//    }


}
