package com.juyou.calendar.bean.weather;

import java.util.List;

/**
 * @author
 * @datetime 2021-10-20 15:01
 * @detail :63接口api----http://tianqiapi.com/index/doc?version=worldchina
 */
public class WeatherBean {


    /**
     * cityid : 101210101
     * date : 2021-10-25
     * week : 星期一
     * update_time : 17:34
     * city : 杭州
     * cityEn : hangzhou
     * country : 中国
     * countryEn : China
     * wea : 多云
     * wea_img : yun
     * tem : 18
     * tem1 : 21
     * tem2 : 12
     * win : 东北风
     * win_speed : 1级
     * win_meter : 2km/h
     * humidity : 65%
     * visibility : 17km
     * pressure : 1016
     * air : 42
     * air_pm25 : 17
     * air_level : 优
     * air_tips : 空气很好，可以外出活动，呼吸新鲜空气，拥抱大自然！
     * alarm : []
     * wea_day : 阴
     * wea_day_img : yin
     * wea_night : 多云
     * wea_night_img : yun
     * sunrise : 06:08
     * sunset : 17:18
     * hours : [{"hours":"现在","wea":"多云","wea_img":"yun","tem":"18","win":"东北风","win_speed":"1级","aqi":"优","aqinum":"39"},{"hours":"18:00","wea":"阴转多云","wea_img":"yun","tem":"18","win":"东南风","win_speed":"2级","aqi":"优","aqinum":"20"},{"hours":"19:00","wea":"阴转多云","wea_img":"yun","tem":"18","win":"东南风","win_speed":"2级","aqi":"优","aqinum":"21"},{"hours":"20:00","wea":"阴转多云","wea_img":"yun","tem":"17","win":"东南风","win_speed":"1级","aqi":"优","aqinum":"21"},{"hours":"21:00","wea":"阴转多云","wea_img":"yun","tem":"16","win":"东南风","win_speed":"1级","aqi":"优","aqinum":"23"},{"hours":"22:00","wea":"多云","wea_img":"yun","tem":"15","win":"东南风","win_speed":"2级","aqi":"优","aqinum":"24"},{"hours":"23:00","wea":"多云","wea_img":"yun","tem":"15","win":"东南风","win_speed":"2级","aqi":"优","aqinum":"27"},{"hours":"10/26","wea":"多云","wea_img":"yun","tem":"16","win":"东南风","win_speed":"2级","aqi":"优","aqinum":"29"},{"hours":"01:00","wea":"多云","wea_img":"yun","tem":"16","win":"东风","win_speed":"2级","aqi":"优","aqinum":"29"},{"hours":"02:00","wea":"晴","wea_img":"qing","tem":"14","win":"东风","win_speed":"2级","aqi":"优","aqinum":"29"},{"hours":"03:00","wea":"晴","wea_img":"qing","tem":"14","win":"东南风","win_speed":"2级","aqi":"优","aqinum":"29"},{"hours":"04:00","wea":"晴","wea_img":"qing","tem":"13","win":"东南风","win_speed":"1级","aqi":"优","aqinum":"29"},{"hours":"05:00","wea":"晴","wea_img":"qing","tem":"13","win":"南风","win_speed":"1级","aqi":"优","aqinum":"29"},{"hours":"06:00","wea":"晴","wea_img":"qing","tem":"13","win":"西南风","win_speed":"1级","aqi":"优","aqinum":"30"},{"hours":"07:00","wea":"晴","wea_img":"qing","tem":"13","win":"西南风","win_speed":"1级","aqi":"优","aqinum":"31"},{"hours":"08:00","wea":"晴","wea_img":"qing","tem":"15","win":"西南风","win_speed":"1级","aqi":"优","aqinum":"33"},{"hours":"09:00","wea":"多云","wea_img":"yun","tem":"17","win":"东南风","win_speed":"1级","aqi":"优","aqinum":"34"},{"hours":"10:00","wea":"多云","wea_img":"yun","tem":"18","win":"东南风","win_speed":"1级","aqi":"优","aqinum":"36"},{"hours":"11:00","wea":"多云","wea_img":"yun","tem":"20","win":"东风","win_speed":"1级","aqi":"优","aqinum":"36"},{"hours":"12:00","wea":"多云","wea_img":"yun","tem":"20","win":"东风","win_speed":"1级","aqi":"优","aqinum":"37"},{"hours":"13:00","wea":"多云","wea_img":"yun","tem":"21","win":"东北风","win_speed":"2级","aqi":"优","aqinum":"37"},{"hours":"14:00","wea":"多云","wea_img":"yun","tem":"21","win":"东北风","win_speed":"2级","aqi":"优","aqinum":"37"},{"hours":"15:00","wea":"多云","wea_img":"yun","tem":"20","win":"东北风","win_speed":"2级","aqi":"优","aqinum":"36"},{"hours":"16:00","wea":"多云","wea_img":"yun","tem":"20","win":"东北风","win_speed":"2级","aqi":"优","aqinum":"36"}]
     * aqi : {"update_time":"17:24","air":"42","air_level":"优","air_tips":"空气很好，可以外出活动，呼吸新鲜空气，拥抱大自然！","pm25":"17","pm25_desc":"优","pm10":"42","pm10_desc":"优","o3":"93","o3_desc":"优","no2":"31","no2_desc":"优","so2":"7","so2_desc":"优","co":"-","co_desc":"-","kouzhao":"不用佩戴口罩","yundong":"非常适宜运动","waichu":"适宜外出","kaichuang":"适宜开窗","jinghuaqi":"关闭净化器"}
     */

    private String cityid;
    private String date;
    private String week;
    private String update_time;
    private String city;
    private String cityEn;
    private String country;
    private String countryEn;
    private String wea;
    private String wea_img;
    private String tem;
    private String tem1;
    private String tem2;
    private String win;
    private String win_speed;
    private String win_meter;
    private String humidity;
    private String visibility;
    private String pressure;
    private String air;
    private String air_pm25;
    private String air_level;
    private String air_tips;
    private String wea_day;
    private String wea_day_img;
    private String wea_night;
    private String wea_night_img;
    private String sunrise;
    private String sunset;
    private AqiBean aqi;
    private List<?> alarm;
    private List<HoursBean> hours;

    public String getCityid() {
        return cityid;
    }

    public void setCityid(String cityid) {
        this.cityid = cityid;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getWeek() {
        return week;
    }

    public void setWeek(String week) {
        this.week = week;
    }

    public String getUpdate_time() {
        return update_time;
    }

    public void setUpdate_time(String update_time) {
        this.update_time = update_time;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCityEn() {
        return cityEn;
    }

    public void setCityEn(String cityEn) {
        this.cityEn = cityEn;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCountryEn() {
        return countryEn;
    }

    public void setCountryEn(String countryEn) {
        this.countryEn = countryEn;
    }

    public String getWea() {
        return wea;
    }

    public void setWea(String wea) {
        this.wea = wea;
    }

    public String getWea_img() {
        return wea_img;
    }

    public void setWea_img(String wea_img) {
        this.wea_img = wea_img;
    }

    public String getTem() {
        return tem;
    }

    public void setTem(String tem) {
        this.tem = tem;
    }

    public String getTem1() {
        return tem1;
    }

    public void setTem1(String tem1) {
        this.tem1 = tem1;
    }

    public String getTem2() {
        return tem2;
    }

    public void setTem2(String tem2) {
        this.tem2 = tem2;
    }

    public String getWin() {
        return win;
    }

    public void setWin(String win) {
        this.win = win;
    }

    public String getWin_speed() {
        return win_speed;
    }

    public void setWin_speed(String win_speed) {
        this.win_speed = win_speed;
    }

    public String getWin_meter() {
        return win_meter;
    }

    public void setWin_meter(String win_meter) {
        this.win_meter = win_meter;
    }

    public String getHumidity() {
        return humidity;
    }

    public void setHumidity(String humidity) {
        this.humidity = humidity;
    }

    public String getVisibility() {
        return visibility;
    }

    public void setVisibility(String visibility) {
        this.visibility = visibility;
    }

    public String getPressure() {
        return pressure;
    }

    public void setPressure(String pressure) {
        this.pressure = pressure;
    }

    public String getAir() {
        return air;
    }

    public void setAir(String air) {
        this.air = air;
    }

    public String getAir_pm25() {
        return air_pm25;
    }

    public void setAir_pm25(String air_pm25) {
        this.air_pm25 = air_pm25;
    }

    public String getAir_level() {
        return air_level;
    }

    public void setAir_level(String air_level) {
        this.air_level = air_level;
    }

    public String getAir_tips() {
        return air_tips;
    }

    public void setAir_tips(String air_tips) {
        this.air_tips = air_tips;
    }

    public String getWea_day() {
        return wea_day;
    }

    public void setWea_day(String wea_day) {
        this.wea_day = wea_day;
    }

    public String getWea_day_img() {
        return wea_day_img;
    }

    public void setWea_day_img(String wea_day_img) {
        this.wea_day_img = wea_day_img;
    }

    public String getWea_night() {
        return wea_night;
    }

    public void setWea_night(String wea_night) {
        this.wea_night = wea_night;
    }

    public String getWea_night_img() {
        return wea_night_img;
    }

    public void setWea_night_img(String wea_night_img) {
        this.wea_night_img = wea_night_img;
    }

    public String getSunrise() {
        return sunrise;
    }

    public void setSunrise(String sunrise) {
        this.sunrise = sunrise;
    }

    public String getSunset() {
        return sunset;
    }

    public void setSunset(String sunset) {
        this.sunset = sunset;
    }

    public AqiBean getAqi() {
        return aqi;
    }

    public void setAqi(AqiBean aqi) {
        this.aqi = aqi;
    }

    public List<?> getAlarm() {
        return alarm;
    }

    public void setAlarm(List<?> alarm) {
        this.alarm = alarm;
    }

    public List<HoursBean> getHours() {
        return hours;
    }

    public void setHours(List<HoursBean> hours) {
        this.hours = hours;
    }

    public static class AqiBean {
        /**
         * update_time : 17:24
         * air : 42
         * air_level : 优
         * air_tips : 空气很好，可以外出活动，呼吸新鲜空气，拥抱大自然！
         * pm25 : 17
         * pm25_desc : 优
         * pm10 : 42
         * pm10_desc : 优
         * o3 : 93
         * o3_desc : 优
         * no2 : 31
         * no2_desc : 优
         * so2 : 7
         * so2_desc : 优
         * co : -
         * co_desc : -
         * kouzhao : 不用佩戴口罩
         * yundong : 非常适宜运动
         * waichu : 适宜外出
         * kaichuang : 适宜开窗
         * jinghuaqi : 关闭净化器
         */

        private String update_time;
        private String air;
        private String air_level;
        private String air_tips;
        private String pm25;
        private String pm25_desc;
        private String pm10;
        private String pm10_desc;
        private String o3;
        private String o3_desc;
        private String no2;
        private String no2_desc;
        private String so2;
        private String so2_desc;
        private String co;
        private String co_desc;
        private String kouzhao;
        private String yundong;
        private String waichu;
        private String kaichuang;
        private String jinghuaqi;

        public String getUpdate_time() {
            return update_time;
        }

        public void setUpdate_time(String update_time) {
            this.update_time = update_time;
        }

        public String getAir() {
            return air;
        }

        public void setAir(String air) {
            this.air = air;
        }

        public String getAir_level() {
            return air_level;
        }

        public void setAir_level(String air_level) {
            this.air_level = air_level;
        }

        public String getAir_tips() {
            return air_tips;
        }

        public void setAir_tips(String air_tips) {
            this.air_tips = air_tips;
        }

        public String getPm25() {
            return pm25;
        }

        public void setPm25(String pm25) {
            this.pm25 = pm25;
        }

        public String getPm25_desc() {
            return pm25_desc;
        }

        public void setPm25_desc(String pm25_desc) {
            this.pm25_desc = pm25_desc;
        }

        public String getPm10() {
            return pm10;
        }

        public void setPm10(String pm10) {
            this.pm10 = pm10;
        }

        public String getPm10_desc() {
            return pm10_desc;
        }

        public void setPm10_desc(String pm10_desc) {
            this.pm10_desc = pm10_desc;
        }

        public String getO3() {
            return o3;
        }

        public void setO3(String o3) {
            this.o3 = o3;
        }

        public String getO3_desc() {
            return o3_desc;
        }

        public void setO3_desc(String o3_desc) {
            this.o3_desc = o3_desc;
        }

        public String getNo2() {
            return no2;
        }

        public void setNo2(String no2) {
            this.no2 = no2;
        }

        public String getNo2_desc() {
            return no2_desc;
        }

        public void setNo2_desc(String no2_desc) {
            this.no2_desc = no2_desc;
        }

        public String getSo2() {
            return so2;
        }

        public void setSo2(String so2) {
            this.so2 = so2;
        }

        public String getSo2_desc() {
            return so2_desc;
        }

        public void setSo2_desc(String so2_desc) {
            this.so2_desc = so2_desc;
        }

        public String getCo() {
            return co;
        }

        public void setCo(String co) {
            this.co = co;
        }

        public String getCo_desc() {
            return co_desc;
        }

        public void setCo_desc(String co_desc) {
            this.co_desc = co_desc;
        }

        public String getKouzhao() {
            return kouzhao;
        }

        public void setKouzhao(String kouzhao) {
            this.kouzhao = kouzhao;
        }

        public String getYundong() {
            return yundong;
        }

        public void setYundong(String yundong) {
            this.yundong = yundong;
        }

        public String getWaichu() {
            return waichu;
        }

        public void setWaichu(String waichu) {
            this.waichu = waichu;
        }

        public String getKaichuang() {
            return kaichuang;
        }

        public void setKaichuang(String kaichuang) {
            this.kaichuang = kaichuang;
        }

        public String getJinghuaqi() {
            return jinghuaqi;
        }

        public void setJinghuaqi(String jinghuaqi) {
            this.jinghuaqi = jinghuaqi;
        }
    }

    public static class HoursBean {
        /**
         * hours : 现在
         * wea : 多云
         * wea_img : yun
         * tem : 18
         * win : 东北风
         * win_speed : 1级
         * aqi : 优
         * aqinum : 39
         */

        private String hours;
        private String wea;
        private String wea_img;
        private String tem;
        private String win;
        private String win_speed;
        private String aqi;
        private String aqinum;

        public String getHours() {
            return hours;
        }

        public void setHours(String hours) {
            this.hours = hours;
        }

        public String getWea() {
            return wea;
        }

        public void setWea(String wea) {
            this.wea = wea;
        }

        public String getWea_img() {
            return wea_img;
        }

        public void setWea_img(String wea_img) {
            this.wea_img = wea_img;
        }

        public String getTem() {
            return tem;
        }

        public void setTem(String tem) {
            this.tem = tem;
        }

        public String getWin() {
            return win;
        }

        public void setWin(String win) {
            this.win = win;
        }

        public String getWin_speed() {
            return win_speed;
        }

        public void setWin_speed(String win_speed) {
            this.win_speed = win_speed;
        }

        public String getAqi() {
            return aqi;
        }

        public void setAqi(String aqi) {
            this.aqi = aqi;
        }

        public String getAqinum() {
            return aqinum;
        }

        public void setAqinum(String aqinum) {
            this.aqinum = aqinum;
        }
    }
}


