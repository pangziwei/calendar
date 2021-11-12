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
    //    public static class SkyconBean {
//        /**
//         * datetime : 2021-11-10T10:00+08:00
//         * value : PARTLY_CLOUDY_DAY
//         */
//
//        private String datetime;
//        private String value;
//
//        public String getDatetime() {
//            return datetime;
//        }
//
//        public void setDatetime(String datetime) {
//            this.datetime = datetime;
//        }
//
//        public String getValue() {
//            return value;
//        }
//
//        public void setValue(String value) {
//            this.value = value;
//        }
//    }
//
//
//    public List<CaiYunHourlysBean.ResultBean.HourlyBean.TemperatureBean> getTemperature() {
//        return temperature;
//    }
//
//    public void setTemperature(List<CaiYunHourlysBean.ResultBean.HourlyBean.TemperatureBean> temperature) {
//        this.temperature = temperature;
//    }
//
//    public List<CaiYunHourlysBean.ResultBean.HourlyBean.WindBean> getWind() {
//        return wind;
//    }
//
//    public void setWind(List<CaiYunHourlysBean.ResultBean.HourlyBean.WindBean> wind) {
//        this.wind = wind;
//    }
//
//    public List<CaiYunHourlysBean.ResultBean.HourlyBean.CloudrateBean> getCloudrate() {
//        return cloudrate;
//    }
//
//    public void setCloudrate(List<CaiYunHourlysBean.ResultBean.HourlyBean.CloudrateBean> cloudrate) {
//        this.cloudrate = cloudrate;
//    }

//    public static class TemperatureBean {
//        /**
//         * datetime : 2021-11-10T10:00+08:00
//         * value : 19
//         */
//
//        private String datetime;
//        private String value;
//
//        public String getDatetime() {
//            return datetime;
//        }
//
//        public void setDatetime(String datetime) {
//            this.datetime = datetime;
//        }
//
//        public String getValue() {
//            return value;
//        }
//
//        public void setValue(String value) {
//            this.value = value;
//        }
//    }
//
//    public static class WindBean {
//        /**
//         * datetime : 2021-11-10T10:00+08:00
//         * speed : 14.76
//         * direction : 37.47
//         */
//
//        private String datetime;
//        private String speed;
//        private String direction;
//
//        public String getDatetime() {
//            return datetime;
//        }
//
//        public void setDatetime(String datetime) {
//            this.datetime = datetime;
//        }
//
//        public String getSpeed() {
//            return speed;
//        }
//
//        public void setSpeed(String speed) {
//            this.speed = speed;
//        }
//
//        public String getDirection() {
//            return direction;
//        }
//
//        public void setDirection(String direction) {
//            this.direction = direction;
//        }
//    }
//
//
//    public static class CloudrateBean {
//        /**
//         * datetime : 2021-11-10T10:00+08:00
//         * value : 0.68
//         */
//
//        private String datetime;
//        private String value;
//
//        public String getDatetime() {
//            return datetime;
//        }
//
//        public void setDatetime(String datetime) {
//            this.datetime = datetime;
//        }
//
//        public String getValue() {
//            return value;
//        }
//
//        public void setValue(String value) {
//            this.value = value;
//        }
//    }
}
