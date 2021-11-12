package com.juyou.calendar.weather.bean;

import java.util.List;

/**
 * @author
 * @datetime 2021-11-09 15:00
 * @detail :彩云天气的天级预报接口
 */
public class CaiYunDailyBean {

    /**
     * status : ok 返回状态
     * api_version : v2.5 版本号
     * api_status : active 服务状态
     * lang : zh_CN 语言
     * unit : metric 单位制
     * tzshift : 28800 时区偏移秒数
     * timezone : Asia/Shanghai 时区信息
     * server_time : 1636441318 响应时刻服务器时间
     * location : [45.75696,126.64246]  纬度，纬度
     * result : {"daily":{"status":"ok","astro":[{"date":"2021-11-09T00:00+08:00","sunrise":{"time":"06:24"},"sunset":{"time":"16:09"}},{"date":"2021-11-10T00:00+08:00","sunrise":{"time":"06:26"},"sunset":{"time":"16:08"}},{"date":"2021-11-11T00:00+08:00","sunrise":{"time":"06:27"},"sunset":{"time":"16:07"}}],"precipitation":[{"date":"2021-11-09T00:00+08:00","max":0.3283,"min":0,"avg":0.0053},{"date":"2021-11-10T00:00+08:00","max":0.0845,"min":0,"avg":0.0053},{"date":"2021-11-11T00:00+08:00","max":0.1346,"min":0,"avg":0.0241}],"temperature":[{"date":"2021-11-09T00:00+08:00","max":-2,"min":-12,"avg":-6.19},{"date":"2021-11-10T00:00+08:00","max":-3,"min":-7,"avg":-4.74},{"date":"2021-11-11T00:00+08:00","max":-2,"min":-11,"avg":-4.56}],"wind":[{"date":"2021-11-09T00:00+08:00","max":{"speed":12.09,"direction":171.84},"min":{"speed":1.69,"direction":236.54},"avg":{"speed":5.96,"direction":157.12}},{"date":"2021-11-10T00:00+08:00","max":{"speed":8.39,"direction":309.12},"min":{"speed":2.57,"direction":266.33},"avg":{"speed":6.31,"direction":241.17}},{"date":"2021-11-11T00:00+08:00","max":{"speed":20.33,"direction":312.53},"min":{"speed":11.11,"direction":262.88},"avg":{"speed":16.34,"direction":303.55}}],"humidity":[{"date":"2021-11-09T00:00+08:00","max":0.97,"min":0.76,"avg":0.93},{"date":"2021-11-10T00:00+08:00","max":0.97,"min":0.78,"avg":0.92},{"date":"2021-11-11T00:00+08:00","max":0.97,"min":0.81,"avg":0.9}],"cloudrate":[{"date":"2021-11-09T00:00+08:00","max":1,"min":0.3,"avg":0.83},{"date":"2021-11-10T00:00+08:00","max":1,"min":0.63,"avg":0.96},{"date":"2021-11-11T00:00+08:00","max":1,"min":0.06,"avg":0.74}],"pressure":[{"date":"2021-11-09T00:00+08:00","max":98633.59,"min":98473.59,"avg":98566.8},{"date":"2021-11-10T00:00+08:00","max":98749.27,"min":98553.59,"avg":98644.33},{"date":"2021-11-11T00:00+08:00","max":99067.05,"min":98713.59,"avg":98860.35}],"visibility":[{"date":"2021-11-09T00:00+08:00","max":24.13,"min":0.2,"avg":3.52},{"date":"2021-11-10T00:00+08:00","max":6.55,"min":3.11,"avg":3.8},{"date":"2021-11-11T00:00+08:00","max":5.55,"min":3.18,"avg":4.04}],"dswrf":[{"date":"2021-11-09T00:00+08:00","max":272.6,"min":0,"avg":44.6},{"date":"2021-11-10T00:00+08:00","max":331.3,"min":0,"avg":84.2},{"date":"2021-11-11T00:00+08:00","max":262.4,"min":0,"avg":74.9}],"air_quality":{"aqi":[{"date":"2021-11-09T00:00+08:00","max":{"chn":71,"usa":71},"avg":{"chn":23.89,"usa":23.89},"min":{"chn":11,"usa":11}},{"date":"2021-11-10T00:00+08:00","max":{"chn":31,"usa":31},"avg":{"chn":26.67,"usa":26.67},"min":{"chn":23,"usa":23}},{"date":"2021-11-11T00:00+08:00","max":{"chn":46,"usa":46},"avg":{"chn":32.5,"usa":32.5},"min":{"chn":24,"usa":24}}],"pm25":[{"date":"2021-11-09T00:00+08:00","max":52,"avg":15.33,"min":6},{"date":"2021-11-10T00:00+08:00","max":22,"avg":18.67,"min":16},{"date":"2021-11-11T00:00+08:00","max":32,"avg":22.71,"min":17}]},"skycon":[{"date":"2021-11-09T00:00+08:00","value":"CLOUDY"},{"date":"2021-11-10T00:00+08:00","value":"CLOUDY"},{"date":"2021-11-11T00:00+08:00","value":"PARTLY_CLOUDY_DAY"}],"skycon_08h_20h":[{"date":"2021-11-09T00:00+08:00","value":"CLOUDY"},{"date":"2021-11-10T00:00+08:00","value":"CLOUDY"},{"date":"2021-11-11T00:00+08:00","value":"PARTLY_CLOUDY_DAY"}],"skycon_20h_32h":[{"date":"2021-11-09T00:00+08:00","value":"CLOUDY"},{"date":"2021-11-10T00:00+08:00","value":"LIGHT_SNOW"},{"date":"2021-11-11T00:00+08:00","value":"PARTLY_CLOUDY_NIGHT"}],"life_index":{"ultraviolet":[{"date":"2021-11-09T00:00+08:00","index":"1","desc":"最弱"},{"date":"2021-11-10T00:00+08:00","index":"1","desc":"最弱"},{"date":"2021-11-11T00:00+08:00","index":"1","desc":"最弱"}],"carWashing":[{"date":"2021-11-09T00:00+08:00","index":"3","desc":"较不适宜"},{"date":"2021-11-10T00:00+08:00","index":"3","desc":"较不适宜"},{"date":"2021-11-11T00:00+08:00","index":"3","desc":"较不适宜"}],"dressing":[{"date":"2021-11-09T00:00+08:00","index":"8","desc":"极冷"},{"date":"2021-11-10T00:00+08:00","index":"8","desc":"极冷"},{"date":"2021-11-11T00:00+08:00","index":"8","desc":"极冷"}],"comfort":[{"date":"2021-11-09T00:00+08:00","index":"12","desc":"湿冷"},{"date":"2021-11-10T00:00+08:00","index":"12","desc":"湿冷"},{"date":"2021-11-11T00:00+08:00","index":"11","desc":"刺骨的冷"}],"coldRisk":[{"date":"2021-11-09T00:00+08:00","index":"4","desc":"极易发"},{"date":"2021-11-10T00:00+08:00","index":"3","desc":"易发"},{"date":"2021-11-11T00:00+08:00","index":"4","desc":"极易发"}]}},"primary":0}
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
    private List<Double> location;

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

    public List<Double> getLocation() {
        return location;
    }

    public void setLocation(List<Double> location) {
        this.location = location;
    }

    public static class ResultBean {
        /**
         * daily : {"status":"ok",
         * "astro":[{"date":"2021-11-09T00:00+08:00","sunrise":{"time":"06:24"}," 日出与日落时刻
         * sunset":{"time":"16:09"}},{"date":"2021-11-10T00:00+08:00","sunrise":{"time":"06:26"},
         * "sunset":{"time":"16:08"}},{"date":"2021-11-11T00:00+08:00","sunrise":{"time":"06:27"},
         * "sunset":{"time":"16:07"}}],
         * "precipitation":[{"date":"2021-11-09T00:00+08:00","max":0.3283,"min":0,"avg":0.0053},
         * {"date":"2021-11-10T00:00+08:00","max":0.0845,"min":0,"avg":0.0053}
         * ,{"date":"2021-11-11T00:00+08:00","max":0.1346,"min":0,"avg":0.0241}],"
         * temperature":[{"date":"2021-11-09T00:00+08:00","max":-2,"min":-12,"avg":-6.19},{"date":"2021-11-10T00:00+08:00","max":-3,"min":-7,"avg":-4.74},{"date":"2021-11-11T00:00+08:00","max":-2,"min":-11,"avg":-4.56}],"wind":[{"date":"2021-11-09T00:00+08:00","max":{"speed":12.09,"direction":171.84},"min":{"speed":1.69,"direction":236.54},"avg":{"speed":5.96,"direction":157.12}},{"date":"2021-11-10T00:00+08:00","max":{"speed":8.39,"direction":309.12},"min":{"speed":2.57,"direction":266.33},"avg":{"speed":6.31,"direction":241.17}},{"date":"2021-11-11T00:00+08:00","max":{"speed":20.33,"direction":312.53},"min":{"speed":11.11,"direction":262.88},"avg":{"speed":16.34,"direction":303.55}}],"humidity":[{"date":"2021-11-09T00:00+08:00","max":0.97,"min":0.76,"avg":0.93},{"date":"2021-11-10T00:00+08:00","max":0.97,"min":0.78,"avg":0.92},{"date":"2021-11-11T00:00+08:00","max":0.97,"min":0.81,"avg":0.9}],"cloudrate":[{"date":"2021-11-09T00:00+08:00","max":1,"min":0.3,"avg":0.83},{"date":"2021-11-10T00:00+08:00","max":1,"min":0.63,"avg":0.96},{"date":"2021-11-11T00:00+08:00","max":1,"min":0.06,"avg":0.74}],"pressure":[{"date":"2021-11-09T00:00+08:00","max":98633.59,"min":98473.59,"avg":98566.8},{"date":"2021-11-10T00:00+08:00","max":98749.27,"min":98553.59,"avg":98644.33},{"date":"2021-11-11T00:00+08:00","max":99067.05,"min":98713.59,"avg":98860.35}],"visibility":[{"date":"2021-11-09T00:00+08:00","max":24.13,"min":0.2,"avg":3.52},{"date":"2021-11-10T00:00+08:00","max":6.55,"min":3.11,"avg":3.8},{"date":"2021-11-11T00:00+08:00","max":5.55,"min":3.18,"avg":4.04}],"dswrf":[{"date":"2021-11-09T00:00+08:00","max":272.6,"min":0,"avg":44.6},{"date":"2021-11-10T00:00+08:00","max":331.3,"min":0,"avg":84.2},{"date":"2021-11-11T00:00+08:00","max":262.4,"min":0,"avg":74.9}],"air_quality":{"aqi":[{"date":"2021-11-09T00:00+08:00","max":{"chn":71,"usa":71},"avg":{"chn":23.89,"usa":23.89},"min":{"chn":11,"usa":11}},{"date":"2021-11-10T00:00+08:00","max":{"chn":31,"usa":31},"avg":{"chn":26.67,"usa":26.67},"min":{"chn":23,"usa":23}},{"date":"2021-11-11T00:00+08:00","max":{"chn":46,"usa":46},"avg":{"chn":32.5,"usa":32.5},"min":{"chn":24,"usa":24}}],"pm25":[{"date":"2021-11-09T00:00+08:00","max":52,"avg":15.33,"min":6},{"date":"2021-11-10T00:00+08:00","max":22,"avg":18.67,"min":16},{"date":"2021-11-11T00:00+08:00","max":32,"avg":22.71,"min":17}]},"skycon":[{"date":"2021-11-09T00:00+08:00","value":"CLOUDY"},{"date":"2021-11-10T00:00+08:00","value":"CLOUDY"},{"date":"2021-11-11T00:00+08:00","value":"PARTLY_CLOUDY_DAY"}],"skycon_08h_20h":[{"date":"2021-11-09T00:00+08:00","value":"CLOUDY"},{"date":"2021-11-10T00:00+08:00","value":"CLOUDY"},{"date":"2021-11-11T00:00+08:00","value":"PARTLY_CLOUDY_DAY"}],"skycon_20h_32h":[{"date":"2021-11-09T00:00+08:00","value":"CLOUDY"},{"date":"2021-11-10T00:00+08:00","value":"LIGHT_SNOW"},{"date":"2021-11-11T00:00+08:00","value":"PARTLY_CLOUDY_NIGHT"}],"life_index":{"ultraviolet":[{"date":"2021-11-09T00:00+08:00","index":"1","desc":"最弱"},{"date":"2021-11-10T00:00+08:00","index":"1","desc":"最弱"},{"date":"2021-11-11T00:00+08:00","index":"1","desc":"最弱"}],"carWashing":[{"date":"2021-11-09T00:00+08:00","index":"3","desc":"较不适宜"},{"date":"2021-11-10T00:00+08:00","index":"3","desc":"较不适宜"},{"date":"2021-11-11T00:00+08:00","index":"3","desc":"较不适宜"}],"dressing":[{"date":"2021-11-09T00:00+08:00","index":"8","desc":"极冷"},{"date":"2021-11-10T00:00+08:00","index":"8","desc":"极冷"},{"date":"2021-11-11T00:00+08:00","index":"8","desc":"极冷"}],"comfort":[{"date":"2021-11-09T00:00+08:00","index":"12","desc":"湿冷"},{"date":"2021-11-10T00:00+08:00","index":"12","desc":"湿冷"},{"date":"2021-11-11T00:00+08:00","index":"11","desc":"刺骨的冷"}],"coldRisk":[{"date":"2021-11-09T00:00+08:00","index":"4","desc":"极易发"},{"date":"2021-11-10T00:00+08:00","index":"3","desc":"易发"},{"date":"2021-11-11T00:00+08:00","index":"4","desc":"极易发"}]}}
         * primary : 0
         */

        private DailyBean daily;
        private int primary;

        public DailyBean getDaily() {
            return daily;
        }

        public void setDaily(DailyBean daily) {
            this.daily = daily;
        }

        public int getPrimary() {
            return primary;
        }

        public void setPrimary(int primary) {
            this.primary = primary;
        }

        public static class DailyBean {
            /**
             * status : ok
             * astro : [{"date":"2021-11-09T00:00+08:00","sunrise":{"time":"06:24"},"sunset":{"time":"16:09"}},{"date":"2021-11-10T00:00+08:00","sunrise":{"time":"06:26"},"sunset":{"time":"16:08"}},{"date":"2021-11-11T00:00+08:00","sunrise":{"time":"06:27"},"sunset":{"time":"16:07"}}]
             * precipitation : [{"date":"2021-11-09T00:00+08:00","max":0.3283,"min":0,"avg":0.0053},{"date":"2021-11-10T00:00+08:00","max":0.0845,"min":0,"avg":0.0053},{"date":"2021-11-11T00:00+08:00","max":0.1346,"min":0,"avg":0.0241}]
             * temperature : [{"date":"2021-11-09T00:00+08:00","max":-2,"min":-12,"avg":-6.19},{"date":"2021-11-10T00:00+08:00","max":-3,"min":-7,"avg":-4.74},{"date":"2021-11-11T00:00+08:00","max":-2,"min":-11,"avg":-4.56}]
             * wind : [{"date":"2021-11-09T00:00+08:00","max":{"speed":12.09,"direction":171.84},"min":{"speed":1.69,"direction":236.54},"avg":{"speed":5.96,"direction":157.12}},{"date":"2021-11-10T00:00+08:00","max":{"speed":8.39,"direction":309.12},"min":{"speed":2.57,"direction":266.33},"avg":{"speed":6.31,"direction":241.17}},{"date":"2021-11-11T00:00+08:00","max":{"speed":20.33,"direction":312.53},"min":{"speed":11.11,"direction":262.88},"avg":{"speed":16.34,"direction":303.55}}]
             * humidity : [{"date":"2021-11-09T00:00+08:00","max":0.97,"min":0.76,"avg":0.93},{"date":"2021-11-10T00:00+08:00","max":0.97,"min":0.78,"avg":0.92},{"date":"2021-11-11T00:00+08:00","max":0.97,"min":0.81,"avg":0.9}]
             * cloudrate : [{"date":"2021-11-09T00:00+08:00","max":1,"min":0.3,"avg":0.83},{"date":"2021-11-10T00:00+08:00","max":1,"min":0.63,"avg":0.96},{"date":"2021-11-11T00:00+08:00","max":1,"min":0.06,"avg":0.74}]
             * pressure : [{"date":"2021-11-09T00:00+08:00","max":98633.59,"min":98473.59,"avg":98566.8},{"date":"2021-11-10T00:00+08:00","max":98749.27,"min":98553.59,"avg":98644.33},{"date":"2021-11-11T00:00+08:00","max":99067.05,"min":98713.59,"avg":98860.35}]
             * visibility : [{"date":"2021-11-09T00:00+08:00","max":24.13,"min":0.2,"avg":3.52},{"date":"2021-11-10T00:00+08:00","max":6.55,"min":3.11,"avg":3.8},{"date":"2021-11-11T00:00+08:00","max":5.55,"min":3.18,"avg":4.04}]
             * dswrf : [{"date":"2021-11-09T00:00+08:00","max":272.6,"min":0,"avg":44.6},{"date":"2021-11-10T00:00+08:00","max":331.3,"min":0,"avg":84.2},{"date":"2021-11-11T00:00+08:00","max":262.4,"min":0,"avg":74.9}]
             * air_quality : {"aqi":[{"date":"2021-11-09T00:00+08:00","max":{"chn":71,"usa":71},"avg":{"chn":23.89,"usa":23.89},"min":{"chn":11,"usa":11}},{"date":"2021-11-10T00:00+08:00","max":{"chn":31,"usa":31},"avg":{"chn":26.67,"usa":26.67},"min":{"chn":23,"usa":23}},{"date":"2021-11-11T00:00+08:00","max":{"chn":46,"usa":46},"avg":{"chn":32.5,"usa":32.5},"min":{"chn":24,"usa":24}}],"pm25":[{"date":"2021-11-09T00:00+08:00","max":52,"avg":15.33,"min":6},{"date":"2021-11-10T00:00+08:00","max":22,"avg":18.67,"min":16},{"date":"2021-11-11T00:00+08:00","max":32,"avg":22.71,"min":17}]}
             * skycon : [{"date":"2021-11-09T00:00+08:00","value":"CLOUDY"},{"date":"2021-11-10T00:00+08:00","value":"CLOUDY"},{"date":"2021-11-11T00:00+08:00","value":"PARTLY_CLOUDY_DAY"}]
             * skycon_08h_20h : [{"date":"2021-11-09T00:00+08:00","value":"CLOUDY"},{"date":"2021-11-10T00:00+08:00","value":"CLOUDY"},{"date":"2021-11-11T00:00+08:00","value":"PARTLY_CLOUDY_DAY"}]
             * skycon_20h_32h : [{"date":"2021-11-09T00:00+08:00","value":"CLOUDY"},{"date":"2021-11-10T00:00+08:00","value":"LIGHT_SNOW"},{"date":"2021-11-11T00:00+08:00","value":"PARTLY_CLOUDY_NIGHT"}]
             * life_index : {"ultraviolet":[{"date":"2021-11-09T00:00+08:00","index":"1","desc":"最弱"},{"date":"2021-11-10T00:00+08:00","index":"1","desc":"最弱"},{"date":"2021-11-11T00:00+08:00","index":"1","desc":"最弱"}],"carWashing":[{"date":"2021-11-09T00:00+08:00","index":"3","desc":"较不适宜"},{"date":"2021-11-10T00:00+08:00","index":"3","desc":"较不适宜"},{"date":"2021-11-11T00:00+08:00","index":"3","desc":"较不适宜"}],"dressing":[{"date":"2021-11-09T00:00+08:00","index":"8","desc":"极冷"},{"date":"2021-11-10T00:00+08:00","index":"8","desc":"极冷"},{"date":"2021-11-11T00:00+08:00","index":"8","desc":"极冷"}],"comfort":[{"date":"2021-11-09T00:00+08:00","index":"12","desc":"湿冷"},{"date":"2021-11-10T00:00+08:00","index":"12","desc":"湿冷"},{"date":"2021-11-11T00:00+08:00","index":"11","desc":"刺骨的冷"}],"coldRisk":[{"date":"2021-11-09T00:00+08:00","index":"4","desc":"极易发"},{"date":"2021-11-10T00:00+08:00","index":"3","desc":"易发"},{"date":"2021-11-11T00:00+08:00","index":"4","desc":"极易发"}]}
             */

            private String status;
            private AirQualityBean air_quality;
            private LifeIndexBean life_index;
            private List<AstroBean> astro;
            private List<PrecipitationBean> precipitation;
            private List<TemperatureBean> temperature;
            private List<WindBean> wind;
            private List<HumidityBean> humidity;
            private List<CloudrateBean> cloudrate;
            private List<PressureBean> pressure;
            private List<VisibilityBean> visibility;
            private List<DswrfBean> dswrf;
            private List<SkyconBean> skycon;
            private List<Skycon08h20hBean> skycon_08h_20h;
            private List<Skycon20h32hBean> skycon_20h_32h;

            public String getStatus() {
                return status;
            }

            public void setStatus(String status) {
                this.status = status;
            }

            public AirQualityBean getAir_quality() {
                return air_quality;
            }

            public void setAir_quality(AirQualityBean air_quality) {
                this.air_quality = air_quality;
            }

            public LifeIndexBean getLife_index() {
                return life_index;
            }

            public void setLife_index(LifeIndexBean life_index) {
                this.life_index = life_index;
            }

            public List<AstroBean> getAstro() {
                return astro;
            }

            public void setAstro(List<AstroBean> astro) {
                this.astro = astro;
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

            public List<SkyconBean> getSkycon() {
                return skycon;
            }

            public void setSkycon(List<SkyconBean> skycon) {
                this.skycon = skycon;
            }

            public List<Skycon08h20hBean> getSkycon_08h_20h() {
                return skycon_08h_20h;
            }

            public void setSkycon_08h_20h(List<Skycon08h20hBean> skycon_08h_20h) {
                this.skycon_08h_20h = skycon_08h_20h;
            }

            public List<Skycon20h32hBean> getSkycon_20h_32h() {
                return skycon_20h_32h;
            }

            public void setSkycon_20h_32h(List<Skycon20h32hBean> skycon_20h_32h) {
                this.skycon_20h_32h = skycon_20h_32h;
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
                     * date : 2021-11-09T00:00+08:00
                     * max : {"chn":71,"usa":71}
                     * avg : {"chn":23.89,"usa":23.89}
                     * min : {"chn":11,"usa":11}
                     */

                    private String date;
                    private MaxBean max;
                    private AvgBean avg;
                    private MinBean min;

                    public String getDate() {
                        return date;
                    }

                    public void setDate(String date) {
                        this.date = date;
                    }

                    public MaxBean getMax() {
                        return max;
                    }

                    public void setMax(MaxBean max) {
                        this.max = max;
                    }

                    public AvgBean getAvg() {
                        return avg;
                    }

                    public void setAvg(AvgBean avg) {
                        this.avg = avg;
                    }

                    public MinBean getMin() {
                        return min;
                    }

                    public void setMin(MinBean min) {
                        this.min = min;
                    }

                    public static class MaxBean {
                        /**
                         * chn : 71
                         * usa : 71
                         */

                        private int chn;
                        private int usa;

                        public int getChn() {
                            return chn;
                        }

                        public void setChn(int chn) {
                            this.chn = chn;
                        }

                        public int getUsa() {
                            return usa;
                        }

                        public void setUsa(int usa) {
                            this.usa = usa;
                        }
                    }

                    public static class AvgBean {
                        /**
                         * chn : 23.89
                         * usa : 23.89
                         */

                        private double chn;
                        private double usa;

                        public double getChn() {
                            return chn;
                        }

                        public void setChn(double chn) {
                            this.chn = chn;
                        }

                        public double getUsa() {
                            return usa;
                        }

                        public void setUsa(double usa) {
                            this.usa = usa;
                        }
                    }

                    public static class MinBean {
                        /**
                         * chn : 11
                         * usa : 11
                         */

                        private int chn;
                        private int usa;

                        public int getChn() {
                            return chn;
                        }

                        public void setChn(int chn) {
                            this.chn = chn;
                        }

                        public int getUsa() {
                            return usa;
                        }

                        public void setUsa(int usa) {
                            this.usa = usa;
                        }
                    }
                }

                public static class Pm25Bean {
                    /**
                     * date : 2021-11-09T00:00+08:00
                     * max : 52
                     * avg : 15.33
                     * min : 6
                     */

                    private String date;
                    private int max;
                    private double avg;
                    private int min;

                    public String getDate() {
                        return date;
                    }

                    public void setDate(String date) {
                        this.date = date;
                    }

                    public int getMax() {
                        return max;
                    }

                    public void setMax(int max) {
                        this.max = max;
                    }

                    public double getAvg() {
                        return avg;
                    }

                    public void setAvg(double avg) {
                        this.avg = avg;
                    }

                    public int getMin() {
                        return min;
                    }

                    public void setMin(int min) {
                        this.min = min;
                    }
                }
            }

            public static class LifeIndexBean {
                private List<UltravioletBean> ultraviolet;
                private List<CarWashingBean> carWashing;
                private List<DressingBean> dressing;
                private List<ComfortBean> comfort;
                private List<ColdRiskBean> coldRisk;

                public List<UltravioletBean> getUltraviolet() {
                    return ultraviolet;
                }

                public void setUltraviolet(List<UltravioletBean> ultraviolet) {
                    this.ultraviolet = ultraviolet;
                }

                public List<CarWashingBean> getCarWashing() {
                    return carWashing;
                }

                public void setCarWashing(List<CarWashingBean> carWashing) {
                    this.carWashing = carWashing;
                }

                public List<DressingBean> getDressing() {
                    return dressing;
                }

                public void setDressing(List<DressingBean> dressing) {
                    this.dressing = dressing;
                }

                public List<ComfortBean> getComfort() {
                    return comfort;
                }

                public void setComfort(List<ComfortBean> comfort) {
                    this.comfort = comfort;
                }

                public List<ColdRiskBean> getColdRisk() {
                    return coldRisk;
                }

                public void setColdRisk(List<ColdRiskBean> coldRisk) {
                    this.coldRisk = coldRisk;
                }

                public static class UltravioletBean {
                    /**
                     * date : 2021-11-09T00:00+08:00
                     * index : 1
                     * desc : 最弱
                     */

                    private String date;
                    private String index;
                    private String desc;

                    public String getDate() {
                        return date;
                    }

                    public void setDate(String date) {
                        this.date = date;
                    }

                    public String getIndex() {
                        return index;
                    }

                    public void setIndex(String index) {
                        this.index = index;
                    }

                    public String getDesc() {
                        return desc;
                    }

                    public void setDesc(String desc) {
                        this.desc = desc;
                    }
                }

                public static class CarWashingBean {
                    /**
                     * date : 2021-11-09T00:00+08:00
                     * index : 3
                     * desc : 较不适宜
                     */

                    private String date;
                    private String index;
                    private String desc;

                    public String getDate() {
                        return date;
                    }

                    public void setDate(String date) {
                        this.date = date;
                    }

                    public String getIndex() {
                        return index;
                    }

                    public void setIndex(String index) {
                        this.index = index;
                    }

                    public String getDesc() {
                        return desc;
                    }

                    public void setDesc(String desc) {
                        this.desc = desc;
                    }
                }

                public static class DressingBean {
                    /**
                     * date : 2021-11-09T00:00+08:00
                     * index : 8
                     * desc : 极冷
                     */

                    private String date;
                    private String index;
                    private String desc;

                    public String getDate() {
                        return date;
                    }

                    public void setDate(String date) {
                        this.date = date;
                    }

                    public String getIndex() {
                        return index;
                    }

                    public void setIndex(String index) {
                        this.index = index;
                    }

                    public String getDesc() {
                        return desc;
                    }

                    public void setDesc(String desc) {
                        this.desc = desc;
                    }
                }

                public static class ComfortBean {
                    /**
                     * date : 2021-11-09T00:00+08:00
                     * index : 12
                     * desc : 湿冷
                     */

                    private String date;
                    private String index;
                    private String desc;

                    public String getDate() {
                        return date;
                    }

                    public void setDate(String date) {
                        this.date = date;
                    }

                    public String getIndex() {
                        return index;
                    }

                    public void setIndex(String index) {
                        this.index = index;
                    }

                    public String getDesc() {
                        return desc;
                    }

                    public void setDesc(String desc) {
                        this.desc = desc;
                    }
                }

                public static class ColdRiskBean {
                    /**
                     * date : 2021-11-09T00:00+08:00
                     * index : 4
                     * desc : 极易发
                     */

                    private String date;
                    private String index;
                    private String desc;

                    public String getDate() {
                        return date;
                    }

                    public void setDate(String date) {
                        this.date = date;
                    }

                    public String getIndex() {
                        return index;
                    }

                    public void setIndex(String index) {
                        this.index = index;
                    }

                    public String getDesc() {
                        return desc;
                    }

                    public void setDesc(String desc) {
                        this.desc = desc;
                    }
                }
            }

            public static class AstroBean {
                /**
                 * date : 2021-11-09T00:00+08:00
                 * sunrise : {"time":"06:24"}
                 * sunset : {"time":"16:09"}
                 */

                private String date;
                private SunriseBean sunrise;
                private SunsetBean sunset;

                public String getDate() {
                    return date;
                }

                public void setDate(String date) {
                    this.date = date;
                }

                public SunriseBean getSunrise() {
                    return sunrise;
                }

                public void setSunrise(SunriseBean sunrise) {
                    this.sunrise = sunrise;
                }

                public SunsetBean getSunset() {
                    return sunset;
                }

                public void setSunset(SunsetBean sunset) {
                    this.sunset = sunset;
                }

                public static class SunriseBean {
                    /**
                     * time : 06:24
                     */

                    private String time;

                    public String getTime() {
                        return time;
                    }

                    public void setTime(String time) {
                        this.time = time;
                    }
                }

                public static class SunsetBean {
                    /**
                     * time : 16:09
                     */

                    private String time;

                    public String getTime() {
                        return time;
                    }

                    public void setTime(String time) {
                        this.time = time;
                    }
                }
            }

            public static class PrecipitationBean {
                /**
                 * date : 2021-11-09T00:00+08:00
                 * max : 0.3283
                 * min : 0
                 * avg : 0.0053
                 */

                private String date;
                private double max;
                private int min;
                private double avg;

                public String getDate() {
                    return date;
                }

                public void setDate(String date) {
                    this.date = date;
                }

                public double getMax() {
                    return max;
                }

                public void setMax(double max) {
                    this.max = max;
                }

                public int getMin() {
                    return min;
                }

                public void setMin(int min) {
                    this.min = min;
                }

                public double getAvg() {
                    return avg;
                }

                public void setAvg(double avg) {
                    this.avg = avg;
                }
            }

            public static class TemperatureBean {
                /**
                 * date : 2021-11-09T00:00+08:00
                 * max : -2
                 * min : -12
                 * avg : -6.19
                 */

                private String date;
                private String max;
                private String min;
                private double avg;

                public String getDate() {
                    return date;
                }

                public void setDate(String date) {
                    this.date = date;
                }

                public String getMax() {
                    return max;
                }

                public void setMax(String max) {
                    this.max = max;
                }

                public String getMin() {
                    return min;
                }

                public void setMin(String min) {
                    this.min = min;
                }

                public double getAvg() {
                    return avg;
                }

                public void setAvg(double avg) {
                    this.avg = avg;
                }
            }

            public static class WindBean {
                /**
                 * date : 2021-11-09T00:00+08:00
                 * max : {"speed":12.09,"direction":171.84}
                 * min : {"speed":1.69,"direction":236.54}
                 * avg : {"speed":5.96,"direction":157.12}
                 */

                private String date;
                private MaxBeanX max;
                private MinBeanX min;
                private AvgBeanX avg;

                public String getDate() {
                    return date;
                }

                public void setDate(String date) {
                    this.date = date;
                }

                public MaxBeanX getMax() {
                    return max;
                }

                public void setMax(MaxBeanX max) {
                    this.max = max;
                }

                public MinBeanX getMin() {
                    return min;
                }

                public void setMin(MinBeanX min) {
                    this.min = min;
                }

                public AvgBeanX getAvg() {
                    return avg;
                }

                public void setAvg(AvgBeanX avg) {
                    this.avg = avg;
                }

                public static class MaxBeanX {
                    /**
                     * speed : 12.09
                     * direction : 171.84
                     */

                    private double speed;
                    private double direction;

                    public double getSpeed() {
                        return speed;
                    }

                    public void setSpeed(double speed) {
                        this.speed = speed;
                    }

                    public double getDirection() {
                        return direction;
                    }

                    public void setDirection(double direction) {
                        this.direction = direction;
                    }
                }

                public static class MinBeanX {
                    /**
                     * speed : 1.69
                     * direction : 236.54
                     */

                    private double speed;
                    private double direction;

                    public double getSpeed() {
                        return speed;
                    }

                    public void setSpeed(double speed) {
                        this.speed = speed;
                    }

                    public double getDirection() {
                        return direction;
                    }

                    public void setDirection(double direction) {
                        this.direction = direction;
                    }
                }

                public static class AvgBeanX {
                    /**
                     * speed : 5.96
                     * direction : 157.12
                     */

                    private double speed;
                    private double direction;

                    public double getSpeed() {
                        return speed;
                    }

                    public void setSpeed(double speed) {
                        this.speed = speed;
                    }

                    public double getDirection() {
                        return direction;
                    }

                    public void setDirection(double direction) {
                        this.direction = direction;
                    }
                }
            }

            public static class HumidityBean {
                /**
                 * date : 2021-11-09T00:00+08:00
                 * max : 0.97
                 * min : 0.76
                 * avg : 0.93
                 */

                private String date;
                private double max;
                private double min;
                private double avg;

                public String getDate() {
                    return date;
                }

                public void setDate(String date) {
                    this.date = date;
                }

                public double getMax() {
                    return max;
                }

                public void setMax(double max) {
                    this.max = max;
                }

                public double getMin() {
                    return min;
                }

                public void setMin(double min) {
                    this.min = min;
                }

                public double getAvg() {
                    return avg;
                }

                public void setAvg(double avg) {
                    this.avg = avg;
                }
            }

            public static class CloudrateBean {
                /**
                 * date : 2021-11-09T00:00+08:00
                 * max : 1
                 * min : 0.3
                 * avg : 0.83
                 */

                private String date;
                private String max;
                private String min;
                private double avg;

                public String getDate() {
                    return date;
                }

                public void setDate(String date) {
                    this.date = date;
                }

                public String getMax() {
                    return max;
                }

                public void setMax(String max) {
                    this.max = max;
                }

                public String getMin() {
                    return min;
                }

                public void setMin(String min) {
                    this.min = min;
                }

                public double getAvg() {
                    return avg;
                }

                public void setAvg(double avg) {
                    this.avg = avg;
                }
            }

            public static class PressureBean {
                /**
                 * date : 2021-11-09T00:00+08:00
                 * max : 98633.59
                 * min : 98473.59
                 * avg : 98566.8
                 */

                private String date;
                private String max;
                private String min;
                private double avg;

                public String getDate() {
                    return date;
                }

                public void setDate(String date) {
                    this.date = date;
                }

                public String getMax() {
                    return max;
                }

                public void setMax(String max) {
                    this.max = max;
                }

                public String getMin() {
                    return min;
                }

                public void setMin(String min) {
                    this.min = min;
                }

                public double getAvg() {
                    return avg;
                }

                public void setAvg(double avg) {
                    this.avg = avg;
                }
            }

            public static class VisibilityBean {
                /**
                 * date : 2021-11-09T00:00+08:00
                 * max : 24.13
                 * min : 0.2
                 * avg : 3.52
                 */

                private String date;
                private String max;
                private String min;
                private double avg;

                public String getDate() {
                    return date;
                }

                public void setDate(String date) {
                    this.date = date;
                }

                public String getMax() {
                    return max;
                }

                public void setMax(String max) {
                    this.max = max;
                }

                public String getMin() {
                    return min;
                }

                public void setMin(String min) {
                    this.min = min;
                }

                public double getAvg() {
                    return avg;
                }

                public void setAvg(double avg) {
                    this.avg = avg;
                }
            }

            public static class DswrfBean {
                /**
                 * date : 2021-11-09T00:00+08:00
                 * max : 272.6
                 * min : 0
                 * avg : 44.6
                 */

                private String date;
                private String max;
                private String min;
                private double avg;

                public String getDate() {
                    return date;
                }

                public void setDate(String date) {
                    this.date = date;
                }

                public String getMax() {
                    return max;
                }

                public void setMax(String max) {
                    this.max = max;
                }

                public String getMin() {
                    return min;
                }

                public void setMin(String min) {
                    this.min = min;
                }

                public double getAvg() {
                    return avg;
                }

                public void setAvg(double avg) {
                    this.avg = avg;
                }
            }

            public static class SkyconBean {
                /**
                 * date : 2021-11-09T00:00+08:00
                 * value : CLOUDY
                 */

                private String date;
                private String value;

                public String getDate() {
                    return date;
                }

                public void setDate(String date) {
                    this.date = date;
                }

                public String getValue() {
                    return value;
                }

                public void setValue(String value) {
                    this.value = value;
                }
            }

            public static class Skycon08h20hBean {
                /**
                 * date : 2021-11-09T00:00+08:00
                 * value : CLOUDY
                 */

                private String date;
                private String value;

                public String getDate() {
                    return date;
                }

                public void setDate(String date) {
                    this.date = date;
                }

                public String getValue() {
                    return value;
                }

                public void setValue(String value) {
                    this.value = value;
                }
            }

            public static class Skycon20h32hBean {
                /**
                 * date : 2021-11-09T00:00+08:00
                 * value : CLOUDY
                 */

                private String date;
                private String value;

                public String getDate() {
                    return date;
                }

                public void setDate(String date) {
                    this.date = date;
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
