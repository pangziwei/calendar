package com.juyou.calendar.weather.bean;


import java.util.List;

/**
 * @author
 * @datetime 2021-11-10 10:54
 * @detail :
 */
public class CaiYunHourlysBean {

    /**
     * status : ok
     * api_version : v2.5
     * api_status : active
     * lang : zh_CN
     * unit : metric
     * tzshift : 28800
     * timezone : Asia/Taipei
     * server_time : 1636512658
     * location : [25.1552,121.6544]
     * result : {"hourly":{"status":"ok","description":"多云，今天午后14点钟后转晴","precipitation":[{"datetime":"2021-11-10T10:00+08:00","value":0},{"datetime":"2021-11-10T11:00+08:00","value":0},{"datetime":"2021-11-10T12:00+08:00","value":0},{"datetime":"2021-11-10T13:00+08:00","value":0},{"datetime":"2021-11-10T14:00+08:00","value":0},{"datetime":"2021-11-10T15:00+08:00","value":0},{"datetime":"2021-11-10T16:00+08:00","value":0},{"datetime":"2021-11-10T17:00+08:00","value":0},{"datetime":"2021-11-10T18:00+08:00","value":0},{"datetime":"2021-11-10T19:00+08:00","value":0},{"datetime":"2021-11-10T20:00+08:00","value":0},{"datetime":"2021-11-10T21:00+08:00","value":0}],"temperature":[{"datetime":"2021-11-10T10:00+08:00","value":19},{"datetime":"2021-11-10T11:00+08:00","value":19},{"datetime":"2021-11-10T12:00+08:00","value":19},{"datetime":"2021-11-10T13:00+08:00","value":19},{"datetime":"2021-11-10T14:00+08:00","value":19},{"datetime":"2021-11-10T15:00+08:00","value":18.8},{"datetime":"2021-11-10T16:00+08:00","value":18.6},{"datetime":"2021-11-10T17:00+08:00","value":17.7},{"datetime":"2021-11-10T18:00+08:00","value":17.6},{"datetime":"2021-11-10T19:00+08:00","value":16.5},{"datetime":"2021-11-10T20:00+08:00","value":16.2},{"datetime":"2021-11-10T21:00+08:00","value":16.4}],"wind":[{"datetime":"2021-11-10T10:00+08:00","speed":14.76,"direction":37.47},{"datetime":"2021-11-10T11:00+08:00","speed":12.39,"direction":28.11},{"datetime":"2021-11-10T12:00+08:00","speed":12.49,"direction":23.26},{"datetime":"2021-11-10T13:00+08:00","speed":11.78,"direction":26.17},{"datetime":"2021-11-10T14:00+08:00","speed":11.4,"direction":29.94},{"datetime":"2021-11-10T15:00+08:00","speed":11.4,"direction":32.04},{"datetime":"2021-11-10T16:00+08:00","speed":11.77,"direction":43.04},{"datetime":"2021-11-10T17:00+08:00","speed":11.42,"direction":50.95},{"datetime":"2021-11-10T18:00+08:00","speed":11.44,"direction":55.45},{"datetime":"2021-11-10T19:00+08:00","speed":11.2,"direction":61.48},{"datetime":"2021-11-10T20:00+08:00","speed":10.93,"direction":69.43},{"datetime":"2021-11-10T21:00+08:00","speed":10.84,"direction":75.29}],"humidity":[{"datetime":"2021-11-10T10:00+08:00","value":0.57},{"datetime":"2021-11-10T11:00+08:00","value":0.55},{"datetime":"2021-11-10T12:00+08:00","value":0.53},{"datetime":"2021-11-10T13:00+08:00","value":0.51},{"datetime":"2021-11-10T14:00+08:00","value":0.51},{"datetime":"2021-11-10T15:00+08:00","value":0.51},{"datetime":"2021-11-10T16:00+08:00","value":0.53},{"datetime":"2021-11-10T17:00+08:00","value":0.57},{"datetime":"2021-11-10T18:00+08:00","value":0.57},{"datetime":"2021-11-10T19:00+08:00","value":0.58},{"datetime":"2021-11-10T20:00+08:00","value":0.58},{"datetime":"2021-11-10T21:00+08:00","value":0.58}],"cloudrate":[{"datetime":"2021-11-10T10:00+08:00","value":0.68},{"datetime":"2021-11-10T11:00+08:00","value":0.42},{"datetime":"2021-11-10T12:00+08:00","value":0.84},{"datetime":"2021-11-10T13:00+08:00","value":0.08},{"datetime":"2021-11-10T14:00+08:00","value":0.04},{"datetime":"2021-11-10T15:00+08:00","value":0.03},{"datetime":"2021-11-10T16:00+08:00","value":0.01},{"datetime":"2021-11-10T17:00+08:00","value":0.01},{"datetime":"2021-11-10T18:00+08:00","value":0.01},{"datetime":"2021-11-10T19:00+08:00","value":0.01},{"datetime":"2021-11-10T20:00+08:00","value":0.02},{"datetime":"2021-11-10T21:00+08:00","value":0.01}],"skycon":[{"datetime":"2021-11-10T10:00+08:00","value":"PARTLY_CLOUDY_DAY"},{"datetime":"2021-11-10T11:00+08:00","value":"PARTLY_CLOUDY_DAY"},{"datetime":"2021-11-10T12:00+08:00","value":"CLOUDY"},{"datetime":"2021-11-10T13:00+08:00","value":"CLEAR_DAY"},{"datetime":"2021-11-10T14:00+08:00","value":"CLEAR_DAY"},{"datetime":"2021-11-10T15:00+08:00","value":"CLEAR_DAY"},{"datetime":"2021-11-10T16:00+08:00","value":"CLEAR_DAY"},{"datetime":"2021-11-10T17:00+08:00","value":"CLEAR_NIGHT"},{"datetime":"2021-11-10T18:00+08:00","value":"CLEAR_NIGHT"},{"datetime":"2021-11-10T19:00+08:00","value":"CLEAR_NIGHT"},{"datetime":"2021-11-10T20:00+08:00","value":"CLEAR_NIGHT"},{"datetime":"2021-11-10T21:00+08:00","value":"CLEAR_NIGHT"}],"pressure":[{"datetime":"2021-11-10T10:00+08:00","value":100347.1554560001},{"datetime":"2021-11-10T11:00+08:00","value":100285.8909696001},{"datetime":"2021-11-10T12:00+08:00","value":100236.4829696001},{"datetime":"2021-11-10T13:00+08:00","value":100187.1554560001},{"datetime":"2021-11-10T14:00+08:00","value":100125.8909696},{"datetime":"2021-11-10T15:00+08:00","value":100125.8909696001},{"datetime":"2021-11-10T16:00+08:00","value":100187.1554560001},{"datetime":"2021-11-10T17:00+08:00","value":100205.8909696001},{"datetime":"2021-11-10T18:00+08:00","value":100267.1554560001},{"datetime":"2021-11-10T19:00+08:00","value":100297.4914560001},{"datetime":"2021-11-10T20:00+08:00","value":100377.4914560001},{"datetime":"2021-11-10T21:00+08:00","value":100377.4914560001}],"visibility":[{"datetime":"2021-11-10T10:00+08:00","value":14.29},{"datetime":"2021-11-10T11:00+08:00","value":14.29},{"datetime":"2021-11-10T12:00+08:00","value":14.29},{"datetime":"2021-11-10T13:00+08:00","value":14.29},{"datetime":"2021-11-10T14:00+08:00","value":14.29},{"datetime":"2021-11-10T15:00+08:00","value":14.29},{"datetime":"2021-11-10T16:00+08:00","value":14.29},{"datetime":"2021-11-10T17:00+08:00","value":14.29},{"datetime":"2021-11-10T18:00+08:00","value":14.29},{"datetime":"2021-11-10T19:00+08:00","value":14.29},{"datetime":"2021-11-10T20:00+08:00","value":14.29},{"datetime":"2021-11-10T21:00+08:00","value":14.29}],"dswrf":[{"datetime":"2021-11-10T10:00+08:00","value":503.23570944},{"datetime":"2021-11-10T11:00+08:00","value":550.82739456},{"datetime":"2021-11-10T12:00+08:00","value":591.14917632},{"datetime":"2021-11-10T13:00+08:00","value":604.32969728},{"datetime":"2021-11-10T14:00+08:00","value":610.6308608},{"datetime":"2021-11-10T15:00+08:00","value":489.92704256},{"datetime":"2021-11-10T16:00+08:00","value":391.44064256},{"datetime":"2021-11-10T17:00+08:00","value":288.8050304},{"datetime":"2021-11-10T18:00+08:00","value":216.5602304},{"datetime":"2021-11-10T19:00+08:00","value":173.40781824},{"datetime":"2021-11-10T20:00+08:00","value":144.02121216},{"datetime":"2021-11-10T21:00+08:00","value":0}],"air_quality":{"aqi":[{"datetime":"2021-11-10T10:00+08:00","value":{"chn":10,"usa":10}},{"datetime":"2021-11-10T11:00+08:00","value":{"chn":9,"usa":9}},{"datetime":"2021-11-10T12:00+08:00","value":{"chn":8,"usa":8}},{"datetime":"2021-11-10T13:00+08:00","value":{"chn":7,"usa":7}},{"datetime":"2021-11-10T14:00+08:00","value":{"chn":7,"usa":7}},{"datetime":"2021-11-10T15:00+08:00","value":{"chn":7,"usa":7}},{"datetime":"2021-11-10T16:00+08:00","value":{"chn":7,"usa":7}},{"datetime":"2021-11-10T17:00+08:00","value":{"chn":7,"usa":7}},{"datetime":"2021-11-10T18:00+08:00","value":{"chn":8,"usa":8}},{"datetime":"2021-11-10T19:00+08:00","value":{"chn":9,"usa":9}},{"datetime":"2021-11-10T20:00+08:00","value":{"chn":10,"usa":10}},{"datetime":"2021-11-10T21:00+08:00","value":{"chn":12,"usa":12}}],"pm25":[{"datetime":"2021-11-10T10:00+08:00","value":5},{"datetime":"2021-11-10T11:00+08:00","value":5},{"datetime":"2021-11-10T12:00+08:00","value":5},{"datetime":"2021-11-10T13:00+08:00","value":4},{"datetime":"2021-11-10T14:00+08:00","value":4},{"datetime":"2021-11-10T15:00+08:00","value":4},{"datetime":"2021-11-10T16:00+08:00","value":5},{"datetime":"2021-11-10T17:00+08:00","value":5},{"datetime":"2021-11-10T18:00+08:00","value":6},{"datetime":"2021-11-10T19:00+08:00","value":6},{"datetime":"2021-11-10T20:00+08:00","value":7},{"datetime":"2021-11-10T21:00+08:00","value":9}]}},"primary":0,"forecast_keypoint":"多云，今天午后14点钟后转晴"}
     */

    private String status;
    private String api_version;
    private String api_status;
    private String lang;
    private String unit;
    private String tzshift;
    private String timezone;
    private String server_time;
    private ResultBean result;
    private List<String> location;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getApi_version() {
        return api_version;
    }

    public void setApi_version(String api_version) {
        this.api_version = api_version;
    }

    public String getApi_status() {
        return api_status;
    }

    public void setApi_status(String api_status) {
        this.api_status = api_status;
    }

    public String getLang() {
        return lang;
    }

    public void setLang(String lang) {
        this.lang = lang;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public String getTzshift() {
        return tzshift;
    }

    public void setTzshift(String tzshift) {
        this.tzshift = tzshift;
    }

    public String getTimezone() {
        return timezone;
    }

    public void setTimezone(String timezone) {
        this.timezone = timezone;
    }

    public String getServer_time() {
        return server_time;
    }

    public void setServer_time(String server_time) {
        this.server_time = server_time;
    }

    public ResultBean getResult() {
        return result;
    }

    public void setResult(ResultBean result) {
        this.result = result;
    }

    public List<String> getLocation() {
        return location;
    }

    public void setLocation(List<String> location) {
        this.location = location;
    }

    public static class ResultBean {
        /**
         * hourly : {"status":"ok","description":"多云，今天午后14点钟后转晴","precipitation":[{"datetime":"2021-11-10T10:00+08:00","value":0},{"datetime":"2021-11-10T11:00+08:00","value":0},{"datetime":"2021-11-10T12:00+08:00","value":0},{"datetime":"2021-11-10T13:00+08:00","value":0},{"datetime":"2021-11-10T14:00+08:00","value":0},{"datetime":"2021-11-10T15:00+08:00","value":0},{"datetime":"2021-11-10T16:00+08:00","value":0},{"datetime":"2021-11-10T17:00+08:00","value":0},{"datetime":"2021-11-10T18:00+08:00","value":0},{"datetime":"2021-11-10T19:00+08:00","value":0},{"datetime":"2021-11-10T20:00+08:00","value":0},{"datetime":"2021-11-10T21:00+08:00","value":0}],"temperature":[{"datetime":"2021-11-10T10:00+08:00","value":19},{"datetime":"2021-11-10T11:00+08:00","value":19},{"datetime":"2021-11-10T12:00+08:00","value":19},{"datetime":"2021-11-10T13:00+08:00","value":19},{"datetime":"2021-11-10T14:00+08:00","value":19},{"datetime":"2021-11-10T15:00+08:00","value":18.8},{"datetime":"2021-11-10T16:00+08:00","value":18.6},{"datetime":"2021-11-10T17:00+08:00","value":17.7},{"datetime":"2021-11-10T18:00+08:00","value":17.6},{"datetime":"2021-11-10T19:00+08:00","value":16.5},{"datetime":"2021-11-10T20:00+08:00","value":16.2},{"datetime":"2021-11-10T21:00+08:00","value":16.4}],"wind":[{"datetime":"2021-11-10T10:00+08:00","speed":14.76,"direction":37.47},{"datetime":"2021-11-10T11:00+08:00","speed":12.39,"direction":28.11},{"datetime":"2021-11-10T12:00+08:00","speed":12.49,"direction":23.26},{"datetime":"2021-11-10T13:00+08:00","speed":11.78,"direction":26.17},{"datetime":"2021-11-10T14:00+08:00","speed":11.4,"direction":29.94},{"datetime":"2021-11-10T15:00+08:00","speed":11.4,"direction":32.04},{"datetime":"2021-11-10T16:00+08:00","speed":11.77,"direction":43.04},{"datetime":"2021-11-10T17:00+08:00","speed":11.42,"direction":50.95},{"datetime":"2021-11-10T18:00+08:00","speed":11.44,"direction":55.45},{"datetime":"2021-11-10T19:00+08:00","speed":11.2,"direction":61.48},{"datetime":"2021-11-10T20:00+08:00","speed":10.93,"direction":69.43},{"datetime":"2021-11-10T21:00+08:00","speed":10.84,"direction":75.29}],"humidity":[{"datetime":"2021-11-10T10:00+08:00","value":0.57},{"datetime":"2021-11-10T11:00+08:00","value":0.55},{"datetime":"2021-11-10T12:00+08:00","value":0.53},{"datetime":"2021-11-10T13:00+08:00","value":0.51},{"datetime":"2021-11-10T14:00+08:00","value":0.51},{"datetime":"2021-11-10T15:00+08:00","value":0.51},{"datetime":"2021-11-10T16:00+08:00","value":0.53},{"datetime":"2021-11-10T17:00+08:00","value":0.57},{"datetime":"2021-11-10T18:00+08:00","value":0.57},{"datetime":"2021-11-10T19:00+08:00","value":0.58},{"datetime":"2021-11-10T20:00+08:00","value":0.58},{"datetime":"2021-11-10T21:00+08:00","value":0.58}],"cloudrate":[{"datetime":"2021-11-10T10:00+08:00","value":0.68},{"datetime":"2021-11-10T11:00+08:00","value":0.42},{"datetime":"2021-11-10T12:00+08:00","value":0.84},{"datetime":"2021-11-10T13:00+08:00","value":0.08},{"datetime":"2021-11-10T14:00+08:00","value":0.04},{"datetime":"2021-11-10T15:00+08:00","value":0.03},{"datetime":"2021-11-10T16:00+08:00","value":0.01},{"datetime":"2021-11-10T17:00+08:00","value":0.01},{"datetime":"2021-11-10T18:00+08:00","value":0.01},{"datetime":"2021-11-10T19:00+08:00","value":0.01},{"datetime":"2021-11-10T20:00+08:00","value":0.02},{"datetime":"2021-11-10T21:00+08:00","value":0.01}],"skycon":[{"datetime":"2021-11-10T10:00+08:00","value":"PARTLY_CLOUDY_DAY"},{"datetime":"2021-11-10T11:00+08:00","value":"PARTLY_CLOUDY_DAY"},{"datetime":"2021-11-10T12:00+08:00","value":"CLOUDY"},{"datetime":"2021-11-10T13:00+08:00","value":"CLEAR_DAY"},{"datetime":"2021-11-10T14:00+08:00","value":"CLEAR_DAY"},{"datetime":"2021-11-10T15:00+08:00","value":"CLEAR_DAY"},{"datetime":"2021-11-10T16:00+08:00","value":"CLEAR_DAY"},{"datetime":"2021-11-10T17:00+08:00","value":"CLEAR_NIGHT"},{"datetime":"2021-11-10T18:00+08:00","value":"CLEAR_NIGHT"},{"datetime":"2021-11-10T19:00+08:00","value":"CLEAR_NIGHT"},{"datetime":"2021-11-10T20:00+08:00","value":"CLEAR_NIGHT"},{"datetime":"2021-11-10T21:00+08:00","value":"CLEAR_NIGHT"}],"pressure":[{"datetime":"2021-11-10T10:00+08:00","value":100347.1554560001},{"datetime":"2021-11-10T11:00+08:00","value":100285.8909696001},{"datetime":"2021-11-10T12:00+08:00","value":100236.4829696001},{"datetime":"2021-11-10T13:00+08:00","value":100187.1554560001},{"datetime":"2021-11-10T14:00+08:00","value":100125.8909696},{"datetime":"2021-11-10T15:00+08:00","value":100125.8909696001},{"datetime":"2021-11-10T16:00+08:00","value":100187.1554560001},{"datetime":"2021-11-10T17:00+08:00","value":100205.8909696001},{"datetime":"2021-11-10T18:00+08:00","value":100267.1554560001},{"datetime":"2021-11-10T19:00+08:00","value":100297.4914560001},{"datetime":"2021-11-10T20:00+08:00","value":100377.4914560001},{"datetime":"2021-11-10T21:00+08:00","value":100377.4914560001}],"visibility":[{"datetime":"2021-11-10T10:00+08:00","value":14.29},{"datetime":"2021-11-10T11:00+08:00","value":14.29},{"datetime":"2021-11-10T12:00+08:00","value":14.29},{"datetime":"2021-11-10T13:00+08:00","value":14.29},{"datetime":"2021-11-10T14:00+08:00","value":14.29},{"datetime":"2021-11-10T15:00+08:00","value":14.29},{"datetime":"2021-11-10T16:00+08:00","value":14.29},{"datetime":"2021-11-10T17:00+08:00","value":14.29},{"datetime":"2021-11-10T18:00+08:00","value":14.29},{"datetime":"2021-11-10T19:00+08:00","value":14.29},{"datetime":"2021-11-10T20:00+08:00","value":14.29},{"datetime":"2021-11-10T21:00+08:00","value":14.29}],"dswrf":[{"datetime":"2021-11-10T10:00+08:00","value":503.23570944},{"datetime":"2021-11-10T11:00+08:00","value":550.82739456},{"datetime":"2021-11-10T12:00+08:00","value":591.14917632},{"datetime":"2021-11-10T13:00+08:00","value":604.32969728},{"datetime":"2021-11-10T14:00+08:00","value":610.6308608},{"datetime":"2021-11-10T15:00+08:00","value":489.92704256},{"datetime":"2021-11-10T16:00+08:00","value":391.44064256},{"datetime":"2021-11-10T17:00+08:00","value":288.8050304},{"datetime":"2021-11-10T18:00+08:00","value":216.5602304},{"datetime":"2021-11-10T19:00+08:00","value":173.40781824},{"datetime":"2021-11-10T20:00+08:00","value":144.02121216},{"datetime":"2021-11-10T21:00+08:00","value":0}],"air_quality":{"aqi":[{"datetime":"2021-11-10T10:00+08:00","value":{"chn":10,"usa":10}},{"datetime":"2021-11-10T11:00+08:00","value":{"chn":9,"usa":9}},{"datetime":"2021-11-10T12:00+08:00","value":{"chn":8,"usa":8}},{"datetime":"2021-11-10T13:00+08:00","value":{"chn":7,"usa":7}},{"datetime":"2021-11-10T14:00+08:00","value":{"chn":7,"usa":7}},{"datetime":"2021-11-10T15:00+08:00","value":{"chn":7,"usa":7}},{"datetime":"2021-11-10T16:00+08:00","value":{"chn":7,"usa":7}},{"datetime":"2021-11-10T17:00+08:00","value":{"chn":7,"usa":7}},{"datetime":"2021-11-10T18:00+08:00","value":{"chn":8,"usa":8}},{"datetime":"2021-11-10T19:00+08:00","value":{"chn":9,"usa":9}},{"datetime":"2021-11-10T20:00+08:00","value":{"chn":10,"usa":10}},{"datetime":"2021-11-10T21:00+08:00","value":{"chn":12,"usa":12}}],"pm25":[{"datetime":"2021-11-10T10:00+08:00","value":5},{"datetime":"2021-11-10T11:00+08:00","value":5},{"datetime":"2021-11-10T12:00+08:00","value":5},{"datetime":"2021-11-10T13:00+08:00","value":4},{"datetime":"2021-11-10T14:00+08:00","value":4},{"datetime":"2021-11-10T15:00+08:00","value":4},{"datetime":"2021-11-10T16:00+08:00","value":5},{"datetime":"2021-11-10T17:00+08:00","value":5},{"datetime":"2021-11-10T18:00+08:00","value":6},{"datetime":"2021-11-10T19:00+08:00","value":6},{"datetime":"2021-11-10T20:00+08:00","value":7},{"datetime":"2021-11-10T21:00+08:00","value":9}]}}
         * primary : 0
         * forecast_keypoint : 多云，今天午后14点钟后转晴
         */

        private HourlyBean hourly;
        private String primary;
        private String forecast_keypoint;

        public HourlyBean getHourly() {
            return hourly;
        }

        public void setHourly(HourlyBean hourly) {
            this.hourly = hourly;
        }

        public String getPrimary() {
            return primary;
        }

        public void setPrimary(String primary) {
            this.primary = primary;
        }

        public String getForecast_keypoint() {
            return forecast_keypoint;
        }

        public void setForecast_keypoint(String forecast_keypoint) {
            this.forecast_keypoint = forecast_keypoint;
        }

        public static class HourlyBean {
            /**
             * status : ok
             * description : 多云，今天午后14点钟后转晴
             * precipitation : [{"datetime":"2021-11-10T10:00+08:00","value":0},{"datetime":"2021-11-10T11:00+08:00","value":0},{"datetime":"2021-11-10T12:00+08:00","value":0},{"datetime":"2021-11-10T13:00+08:00","value":0},{"datetime":"2021-11-10T14:00+08:00","value":0},{"datetime":"2021-11-10T15:00+08:00","value":0},{"datetime":"2021-11-10T16:00+08:00","value":0},{"datetime":"2021-11-10T17:00+08:00","value":0},{"datetime":"2021-11-10T18:00+08:00","value":0},{"datetime":"2021-11-10T19:00+08:00","value":0},{"datetime":"2021-11-10T20:00+08:00","value":0},{"datetime":"2021-11-10T21:00+08:00","value":0}]
             * temperature : [{"datetime":"2021-11-10T10:00+08:00","value":19},{"datetime":"2021-11-10T11:00+08:00","value":19},{"datetime":"2021-11-10T12:00+08:00","value":19},{"datetime":"2021-11-10T13:00+08:00","value":19},{"datetime":"2021-11-10T14:00+08:00","value":19},{"datetime":"2021-11-10T15:00+08:00","value":18.8},{"datetime":"2021-11-10T16:00+08:00","value":18.6},{"datetime":"2021-11-10T17:00+08:00","value":17.7},{"datetime":"2021-11-10T18:00+08:00","value":17.6},{"datetime":"2021-11-10T19:00+08:00","value":16.5},{"datetime":"2021-11-10T20:00+08:00","value":16.2},{"datetime":"2021-11-10T21:00+08:00","value":16.4}]
             * wind : [{"datetime":"2021-11-10T10:00+08:00","speed":14.76,"direction":37.47},{"datetime":"2021-11-10T11:00+08:00","speed":12.39,"direction":28.11},{"datetime":"2021-11-10T12:00+08:00","speed":12.49,"direction":23.26},{"datetime":"2021-11-10T13:00+08:00","speed":11.78,"direction":26.17},{"datetime":"2021-11-10T14:00+08:00","speed":11.4,"direction":29.94},{"datetime":"2021-11-10T15:00+08:00","speed":11.4,"direction":32.04},{"datetime":"2021-11-10T16:00+08:00","speed":11.77,"direction":43.04},{"datetime":"2021-11-10T17:00+08:00","speed":11.42,"direction":50.95},{"datetime":"2021-11-10T18:00+08:00","speed":11.44,"direction":55.45},{"datetime":"2021-11-10T19:00+08:00","speed":11.2,"direction":61.48},{"datetime":"2021-11-10T20:00+08:00","speed":10.93,"direction":69.43},{"datetime":"2021-11-10T21:00+08:00","speed":10.84,"direction":75.29}]
             * humidity : [{"datetime":"2021-11-10T10:00+08:00","value":0.57},{"datetime":"2021-11-10T11:00+08:00","value":0.55},{"datetime":"2021-11-10T12:00+08:00","value":0.53},{"datetime":"2021-11-10T13:00+08:00","value":0.51},{"datetime":"2021-11-10T14:00+08:00","value":0.51},{"datetime":"2021-11-10T15:00+08:00","value":0.51},{"datetime":"2021-11-10T16:00+08:00","value":0.53},{"datetime":"2021-11-10T17:00+08:00","value":0.57},{"datetime":"2021-11-10T18:00+08:00","value":0.57},{"datetime":"2021-11-10T19:00+08:00","value":0.58},{"datetime":"2021-11-10T20:00+08:00","value":0.58},{"datetime":"2021-11-10T21:00+08:00","value":0.58}]
             * cloudrate : [{"datetime":"2021-11-10T10:00+08:00","value":0.68},{"datetime":"2021-11-10T11:00+08:00","value":0.42},{"datetime":"2021-11-10T12:00+08:00","value":0.84},{"datetime":"2021-11-10T13:00+08:00","value":0.08},{"datetime":"2021-11-10T14:00+08:00","value":0.04},{"datetime":"2021-11-10T15:00+08:00","value":0.03},{"datetime":"2021-11-10T16:00+08:00","value":0.01},{"datetime":"2021-11-10T17:00+08:00","value":0.01},{"datetime":"2021-11-10T18:00+08:00","value":0.01},{"datetime":"2021-11-10T19:00+08:00","value":0.01},{"datetime":"2021-11-10T20:00+08:00","value":0.02},{"datetime":"2021-11-10T21:00+08:00","value":0.01}]
             * skycon : [{"datetime":"2021-11-10T10:00+08:00","value":"PARTLY_CLOUDY_DAY"},{"datetime":"2021-11-10T11:00+08:00","value":"PARTLY_CLOUDY_DAY"},{"datetime":"2021-11-10T12:00+08:00","value":"CLOUDY"},{"datetime":"2021-11-10T13:00+08:00","value":"CLEAR_DAY"},{"datetime":"2021-11-10T14:00+08:00","value":"CLEAR_DAY"},{"datetime":"2021-11-10T15:00+08:00","value":"CLEAR_DAY"},{"datetime":"2021-11-10T16:00+08:00","value":"CLEAR_DAY"},{"datetime":"2021-11-10T17:00+08:00","value":"CLEAR_NIGHT"},{"datetime":"2021-11-10T18:00+08:00","value":"CLEAR_NIGHT"},{"datetime":"2021-11-10T19:00+08:00","value":"CLEAR_NIGHT"},{"datetime":"2021-11-10T20:00+08:00","value":"CLEAR_NIGHT"},{"datetime":"2021-11-10T21:00+08:00","value":"CLEAR_NIGHT"}]
             * pressure : [{"datetime":"2021-11-10T10:00+08:00","value":100347.1554560001},{"datetime":"2021-11-10T11:00+08:00","value":100285.8909696001},{"datetime":"2021-11-10T12:00+08:00","value":100236.4829696001},{"datetime":"2021-11-10T13:00+08:00","value":100187.1554560001},{"datetime":"2021-11-10T14:00+08:00","value":100125.8909696},{"datetime":"2021-11-10T15:00+08:00","value":100125.8909696001},{"datetime":"2021-11-10T16:00+08:00","value":100187.1554560001},{"datetime":"2021-11-10T17:00+08:00","value":100205.8909696001},{"datetime":"2021-11-10T18:00+08:00","value":100267.1554560001},{"datetime":"2021-11-10T19:00+08:00","value":100297.4914560001},{"datetime":"2021-11-10T20:00+08:00","value":100377.4914560001},{"datetime":"2021-11-10T21:00+08:00","value":100377.4914560001}]
             * visibility : [{"datetime":"2021-11-10T10:00+08:00","value":14.29},{"datetime":"2021-11-10T11:00+08:00","value":14.29},{"datetime":"2021-11-10T12:00+08:00","value":14.29},{"datetime":"2021-11-10T13:00+08:00","value":14.29},{"datetime":"2021-11-10T14:00+08:00","value":14.29},{"datetime":"2021-11-10T15:00+08:00","value":14.29},{"datetime":"2021-11-10T16:00+08:00","value":14.29},{"datetime":"2021-11-10T17:00+08:00","value":14.29},{"datetime":"2021-11-10T18:00+08:00","value":14.29},{"datetime":"2021-11-10T19:00+08:00","value":14.29},{"datetime":"2021-11-10T20:00+08:00","value":14.29},{"datetime":"2021-11-10T21:00+08:00","value":14.29}]
             * dswrf : [{"datetime":"2021-11-10T10:00+08:00","value":503.23570944},{"datetime":"2021-11-10T11:00+08:00","value":550.82739456},{"datetime":"2021-11-10T12:00+08:00","value":591.14917632},{"datetime":"2021-11-10T13:00+08:00","value":604.32969728},{"datetime":"2021-11-10T14:00+08:00","value":610.6308608},{"datetime":"2021-11-10T15:00+08:00","value":489.92704256},{"datetime":"2021-11-10T16:00+08:00","value":391.44064256},{"datetime":"2021-11-10T17:00+08:00","value":288.8050304},{"datetime":"2021-11-10T18:00+08:00","value":216.5602304},{"datetime":"2021-11-10T19:00+08:00","value":173.40781824},{"datetime":"2021-11-10T20:00+08:00","value":144.02121216},{"datetime":"2021-11-10T21:00+08:00","value":0}]
             * air_quality : {"aqi":[{"datetime":"2021-11-10T10:00+08:00","value":{"chn":10,"usa":10}},{"datetime":"2021-11-10T11:00+08:00","value":{"chn":9,"usa":9}},{"datetime":"2021-11-10T12:00+08:00","value":{"chn":8,"usa":8}},{"datetime":"2021-11-10T13:00+08:00","value":{"chn":7,"usa":7}},{"datetime":"2021-11-10T14:00+08:00","value":{"chn":7,"usa":7}},{"datetime":"2021-11-10T15:00+08:00","value":{"chn":7,"usa":7}},{"datetime":"2021-11-10T16:00+08:00","value":{"chn":7,"usa":7}},{"datetime":"2021-11-10T17:00+08:00","value":{"chn":7,"usa":7}},{"datetime":"2021-11-10T18:00+08:00","value":{"chn":8,"usa":8}},{"datetime":"2021-11-10T19:00+08:00","value":{"chn":9,"usa":9}},{"datetime":"2021-11-10T20:00+08:00","value":{"chn":10,"usa":10}},{"datetime":"2021-11-10T21:00+08:00","value":{"chn":12,"usa":12}}],"pm25":[{"datetime":"2021-11-10T10:00+08:00","value":5},{"datetime":"2021-11-10T11:00+08:00","value":5},{"datetime":"2021-11-10T12:00+08:00","value":5},{"datetime":"2021-11-10T13:00+08:00","value":4},{"datetime":"2021-11-10T14:00+08:00","value":4},{"datetime":"2021-11-10T15:00+08:00","value":4},{"datetime":"2021-11-10T16:00+08:00","value":5},{"datetime":"2021-11-10T17:00+08:00","value":5},{"datetime":"2021-11-10T18:00+08:00","value":6},{"datetime":"2021-11-10T19:00+08:00","value":6},{"datetime":"2021-11-10T20:00+08:00","value":7},{"datetime":"2021-11-10T21:00+08:00","value":9}]}
             */

            private String status;
            private String description;
            private AirQualityBean air_quality;
            private List<PrecipitationBean> precipitation;
            private List<TemperatureBean> temperature;
            private List<WindBean> wind;
            private List<HumidityBean> humidity;
            private List<CloudrateBean> cloudrate;
            private List<SkyconBean> skycon;
            private List<PressureBean> pressure;
            private List<VisibilityBean> visibility;
            private List<DswrfBean> dswrf;

            public String getStatus() {
                return status;
            }

            public void setStatus(String status) {
                this.status = status;
            }

            public String getDescription() {
                return description;
            }

            public void setDescription(String description) {
                this.description = description;
            }

            public AirQualityBean getAir_quality() {
                return air_quality;
            }

            public void setAir_quality(AirQualityBean air_quality) {
                this.air_quality = air_quality;
            }

            public List<PrecipitationBean> getPrecipitation() {
                return precipitation;
            }

            public void setPrecipitation(List<PrecipitationBean> precipitation) {
                this.precipitation = precipitation;
            }

            public List<TemperatureBean> getTemperature() {
                return temperature;
            }

            public void setTemperature(List<TemperatureBean> temperature) {
                this.temperature = temperature;
            }

            public List<WindBean> getWind() {
                return wind;
            }

            public void setWind(List<WindBean> wind) {
                this.wind = wind;
            }

            public List<HumidityBean> getHumidity() {
                return humidity;
            }

            public void setHumidity(List<HumidityBean> humidity) {
                this.humidity = humidity;
            }

            public List<CloudrateBean> getCloudrate() {
                return cloudrate;
            }

            public void setCloudrate(List<CloudrateBean> cloudrate) {
                this.cloudrate = cloudrate;
            }

            public List<SkyconBean> getSkycon() {
                return skycon;
            }

            public void setSkycon(List<SkyconBean> skycon) {
                this.skycon = skycon;
            }

            public List<PressureBean> getPressure() {
                return pressure;
            }

            public void setPressure(List<PressureBean> pressure) {
                this.pressure = pressure;
            }

            public List<VisibilityBean> getVisibility() {
                return visibility;
            }

            public void setVisibility(List<VisibilityBean> visibility) {
                this.visibility = visibility;
            }

            public List<DswrfBean> getDswrf() {
                return dswrf;
            }

            public void setDswrf(List<DswrfBean> dswrf) {
                this.dswrf = dswrf;
            }

            public static class AirQualityBean {
                private List<AqiBean> aqi;
                private List<Pm25Bean> pm25;

                public List<AqiBean> getAqi() {
                    return aqi;
                }

                public void setAqi(List<AqiBean> aqi) {
                    this.aqi = aqi;
                }

                public List<Pm25Bean> getPm25() {
                    return pm25;
                }

                public void setPm25(List<Pm25Bean> pm25) {
                    this.pm25 = pm25;
                }

                public static class AqiBean {
                    /**
                     * datetime : 2021-11-10T10:00+08:00
                     * value : {"chn":10,"usa":10}
                     */

                    private String datetime;
                    private ValueBean value;

                    public String getDatetime() {
                        return datetime;
                    }

                    public void setDatetime(String datetime) {
                        this.datetime = datetime;
                    }

                    public ValueBean getValue() {
                        return value;
                    }

                    public void setValue(ValueBean value) {
                        this.value = value;
                    }

                    public static class ValueBean {
                        /**
                         * chn : 10
                         * usa : 10
                         */

                        private String chn;
                        private String usa;

                        public String getChn() {
                            return chn;
                        }

                        public void setChn(String chn) {
                            this.chn = chn;
                        }

                        public String getUsa() {
                            return usa;
                        }

                        public void setUsa(String usa) {
                            this.usa = usa;
                        }
                    }
                }

                public static class Pm25Bean {
                    /**
                     * datetime : 2021-11-10T10:00+08:00
                     * value : 5
                     */

                    private String datetime;
                    private String value;

                    public String getDatetime() {
                        return datetime;
                    }

                    public void setDatetime(String datetime) {
                        this.datetime = datetime;
                    }

                    public String getValue() {
                        return value;
                    }

                    public void setValue(String value) {
                        this.value = value;
                    }
                }
            }

            public static class PrecipitationBean {
                /**
                 * datetime : 2021-11-10T10:00+08:00
                 * value : 0
                 */

                private String datetime;
                private String value;

                public String getDatetime() {
                    return datetime;
                }

                public void setDatetime(String datetime) {
                    this.datetime = datetime;
                }

                public String getValue() {
                    return value;
                }

                public void setValue(String value) {
                    this.value = value;
                }
            }

            public static class TemperatureBean {
                /**
                 * datetime : 2021-11-10T10:00+08:00
                 * value : 19
                 */

                private String datetime;
                private String value;

                public String getDatetime() {
                    return datetime;
                }

                public void setDatetime(String datetime) {
                    this.datetime = datetime;
                }

                public String getValue() {
                    return value;
                }

                public void setValue(String value) {
                    this.value = value;
                }
            }

            public static class WindBean {
                /**
                 * datetime : 2021-11-10T10:00+08:00
                 * speed : 14.76
                 * direction : 37.47
                 */

                private String datetime;
                private String speed;
                private String direction;

                public String getDatetime() {
                    return datetime;
                }

                public void setDatetime(String datetime) {
                    this.datetime = datetime;
                }

                public String getSpeed() {
                    return speed;
                }

                public void setSpeed(String speed) {
                    this.speed = speed;
                }

                public String getDirection() {
                    return direction;
                }

                public void setDirection(String direction) {
                    this.direction = direction;
                }
            }

            public static class HumidityBean {
                /**
                 * datetime : 2021-11-10T10:00+08:00
                 * value : 0.57
                 */

                private String datetime;
                private String value;

                public String getDatetime() {
                    return datetime;
                }

                public void setDatetime(String datetime) {
                    this.datetime = datetime;
                }

                public String getValue() {
                    return value;
                }

                public void setValue(String value) {
                    this.value = value;
                }
            }

            public static class CloudrateBean {
                /**
                 * datetime : 2021-11-10T10:00+08:00
                 * value : 0.68
                 */

                private String datetime;
                private String value;

                public String getDatetime() {
                    return datetime;
                }

                public void setDatetime(String datetime) {
                    this.datetime = datetime;
                }

                public String getValue() {
                    return value;
                }

                public void setValue(String value) {
                    this.value = value;
                }
            }

            public static class SkyconBean {
                /**
                 * datetime : 2021-11-10T10:00+08:00
                 * value : PARTLY_CLOUDY_DAY
                 */

                private String datetime;
                private String value;

                public String getDatetime() {
                    return datetime;
                }

                public void setDatetime(String datetime) {
                    this.datetime = datetime;
                }

                public String getValue() {
                    return value;
                }

                public void setValue(String value) {
                    this.value = value;
                }
            }

            public static class PressureBean {
                /**
                 * datetime : 2021-11-10T10:00+08:00
                 * value : 100347.1554560001
                 */

                private String datetime;
                private String value;

                public String getDatetime() {
                    return datetime;
                }

                public void setDatetime(String datetime) {
                    this.datetime = datetime;
                }

                public String getValue() {
                    return value;
                }

                public void setValue(String value) {
                    this.value = value;
                }
            }

            public static class VisibilityBean {
                /**
                 * datetime : 2021-11-10T10:00+08:00
                 * value : 14.29
                 */

                private String datetime;
                private String value;

                public String getDatetime() {
                    return datetime;
                }

                public void setDatetime(String datetime) {
                    this.datetime = datetime;
                }

                public String getValue() {
                    return value;
                }

                public void setValue(String value) {
                    this.value = value;
                }
            }

            public static class DswrfBean {
                /**
                 * datetime : 2021-11-10T10:00+08:00
                 * value : 503.23570944
                 */

                private String datetime;
                private String value;

                public String getDatetime() {
                    return datetime;
                }

                public void setDatetime(String datetime) {
                    this.datetime = datetime;
                }

                public String getValue() {
                    return value;
                }

                public void setValue(String value) {
                    this.value = value;
                }
            }
        }
    }
}
