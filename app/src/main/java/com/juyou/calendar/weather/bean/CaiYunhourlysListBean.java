package com.juyou.calendar.weather.bean;

import java.util.List;

/**
 * @author
 * @datetime 2021-11-10 14:28
 * @detail :
 */
public class CaiYunhourlysListBean {

    private List<CaiYunHourlysBean.ResultBean.HourlyBean.TemperatureBean> temperature;
    private List<CaiYunHourlysBean.ResultBean.HourlyBean.SkyconBean> skycon;

    public List<CaiYunHourlysBean.ResultBean.HourlyBean.TemperatureBean> getTemperature() {
        return temperature;
    }

    public void setTemperature(List<CaiYunHourlysBean.ResultBean.HourlyBean.TemperatureBean> temperature) {
        this.temperature = temperature;
    }

    public List<CaiYunHourlysBean.ResultBean.HourlyBean.SkyconBean> getSkycon() {
        return skycon;
    }

    public void setSkycon(List<CaiYunHourlysBean.ResultBean.HourlyBean.SkyconBean> skycon) {
        this.skycon = skycon;
    }
}
