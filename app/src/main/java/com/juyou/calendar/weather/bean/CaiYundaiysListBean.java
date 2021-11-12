package com.juyou.calendar.weather.bean;

import java.util.List;

/**
 * @author
 * @datetime 2021-11-10 14:28
 * @detail :
 */
public class CaiYundaiysListBean {

    private List<CaiYunDailyBean.ResultBean.DailyBean.TemperatureBean> temperature;//温度
    private List<CaiYunDailyBean.ResultBean.DailyBean.SkyconBean> skycon;//天气状态

    public List<CaiYunDailyBean.ResultBean.DailyBean.TemperatureBean> getTemperature() {
        return temperature;
    }

    public void setTemperature(List<CaiYunDailyBean.ResultBean.DailyBean.TemperatureBean> temperature) {
        this.temperature = temperature;
    }

    public List<CaiYunDailyBean.ResultBean.DailyBean.SkyconBean> getSkycon() {
        return skycon;
    }

    public void setSkycon(List<CaiYunDailyBean.ResultBean.DailyBean.SkyconBean> skycon) {
        this.skycon = skycon;
    }
}
