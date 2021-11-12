package com.juyou.calendar.bo;

public class Api {
    /**
     * 1 正式 2预发 3测试
     * 切换环境只需切换这个值
     */
    private static final int NETTYPE = 2;

    public static final String BaseUrl = NETTYPE == 1 ? "https://fl.ailaila.com/digital_ip/" : NETTYPE == 2 ? "https://betafl.ailaila.com/digital_ip/" : "http://account.juyouhudong.com.cn/";//http://testdigital.ailaila.com/digital_ip/

    public static final String YKWeatherUrl = NETTYPE == 1 ? "https://v0.yiketianqi.com/" : NETTYPE == 2 ? "https://v0.yiketianqi.com/" : "https://v0.yiketianqi.com/api?unescape=1&version=v62&";//http://testdigital.ailaila.com/digital_ip/

//    彩云天气 API 览表---https://open.caiyunapp.com/%E5%BD%A9%E4%BA%91%E5%A4%A9%E6%B0%94_API_%E4%B8%80%E8%A7%88%E8%A1%A8
    public static final String CaiYunWeatherUrl = NETTYPE == 1 ? "https://api.caiyunapp.com/v2.5/" : NETTYPE == 2 ? "https://api.caiyunapp.com/v2.5/" : "https://api.caiyunapp.com/v2.5/";//http://testdigital.ailaila.com/digital_ip/

    //h5页面地址
    public static final String H5_HOST = NETTYPE == 1 ? "https://h5.ailaila.com/" : NETTYPE == 2 ? "https://betah5.ailaila.com/" : "http://testh5.cupidbit.com/";

}
