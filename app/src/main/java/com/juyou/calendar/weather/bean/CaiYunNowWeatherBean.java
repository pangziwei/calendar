package com.juyou.calendar.weather.bean;

import java.util.List;

/**
 * @author
 * @datetime 2021-11-11 13:43
 * @detail :彩云实况天气，获取体感二氧化硫等参数
 */
public class CaiYunNowWeatherBean {
    /**
     * api_status : active
     * api_version : v2.5
     * lang : zh_CN
     * location : [45.75696,126.64246]
     * result : {"primary":0,"realtime":{"air_quality":{"aqi":{"chn":15,"usa":16},"co":0.5,"description":{"chn":"u4f18","usa":"u4f18"},"no2":15,"o3":47,"pm10":14,"pm25":10,"so2":7},"apparent_temperature":-4.2,"cloudrate":0.3,"dswrf":273.2,"humidity":0.65,"life_index":{"comfort":{"desc":"u6e7fu51b7","index":12},"ultraviolet":{"desc":"u5f88u5f31","index":2}},"precipitation":{"local":{"datasource":"radar","intensity":0,"status":"ok"},"nearest":{"distance":77.18,"intensity":0.1875,"status":"ok"}},"pressure":98748.46,"skycon":"PARTLY_CLOUDY_DAY","status":"ok","temperature":0,"visibility":30,"wind":{"direction":283,"speed":12.6}}}
     * server_time : 1636610453
     * status : ok
     * timezone : Asia/Shanghai
     * tzshift : 28800
     * unit : metric
     */

    private String api_status;
    private String api_version;
    private String lang;
    private ResultBean result;
    private int server_time;
    private String status;
    private String timezone;
    private int tzshift;
    private String unit;
    private List<Double> location;

    public String getApi_status() {
        return api_status;
    }

    public void setApi_status(String api_status) {
        this.api_status = api_status;
    }

    public String getApi_version() {
        return api_version;
    }

    public void setApi_version(String api_version) {
        this.api_version = api_version;
    }

    public String getLang() {
        return lang;
    }

    public void setLang(String lang) {
        this.lang = lang;
    }

    public ResultBean getResult() {
        return result;
    }

    public void setResult(ResultBean result) {
        this.result = result;
    }

    public int getServer_time() {
        return server_time;
    }

    public void setServer_time(int server_time) {
        this.server_time = server_time;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getTimezone() {
        return timezone;
    }

    public void setTimezone(String timezone) {
        this.timezone = timezone;
    }

    public int getTzshift() {
        return tzshift;
    }

    public void setTzshift(int tzshift) {
        this.tzshift = tzshift;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public List<Double> getLocation() {
        return location;
    }

    public void setLocation(List<Double> location) {
        this.location = location;
    }

    public static class ResultBean {
        /**
         * primary : 0
         * realtime : {"air_quality":{"aqi":{"chn":15,"usa":16},"co":0.5,"description":{"chn":"u4f18","usa":"u4f18"},"no2":15,"o3":47,"pm10":14,"pm25":10,"so2":7},"apparent_temperature":-4.2,"cloudrate":0.3,"dswrf":273.2,"humidity":0.65,"life_index":{"comfort":{"desc":"u6e7fu51b7","index":12},"ultraviolet":{"desc":"u5f88u5f31","index":2}},"precipitation":{"local":{"datasource":"radar","intensity":0,"status":"ok"},"nearest":{"distance":77.18,"intensity":0.1875,"status":"ok"}},"pressure":98748.46,"skycon":"PARTLY_CLOUDY_DAY","status":"ok","temperature":0,"visibility":30,"wind":{"direction":283,"speed":12.6}}
         */

        private int primary;
        private RealtimeBean realtime;

        public int getPrimary() {
            return primary;
        }

        public void setPrimary(int primary) {
            this.primary = primary;
        }

        public RealtimeBean getRealtime() {
            return realtime;
        }

        public void setRealtime(RealtimeBean realtime) {
            this.realtime = realtime;
        }

        public static class RealtimeBean {
            /**
             * air_quality : {"aqi":{"chn":15,"usa":16},"co":0.5,"description":{"chn":"u4f18","usa":"u4f18"},"no2":15,"o3":47,"pm10":14,"pm25":10,"so2":7}
             * apparent_temperature : -4.2
             * cloudrate : 0.3
             * dswrf : 273.2
             * humidity : 0.65
             * life_index : {"comfort":{"desc":"u6e7fu51b7","index":12},"ultraviolet":{"desc":"u5f88u5f31","index":2}}
             * precipitation : {"local":{"datasource":"radar","intensity":0,"status":"ok"},"nearest":{"distance":77.18,"intensity":0.1875,"status":"ok"}}
             * pressure : 98748.46
             * skycon : PARTLY_CLOUDY_DAY
             * status : ok
             * temperature : 0.0
             * visibility : 30.0
             * wind : {"direction":283,"speed":12.6}
             */

            private AirQualityBean air_quality;
            private String apparent_temperature;
            private double cloudrate;
            private double dswrf;
            private String humidity;
            private LifeIndexBean life_index;
            private PrecipitationBean precipitation;
            private String pressure;
            private String skycon;
            private String status;
            private double temperature;
            private String visibility;
            private WindBean wind;

            public AirQualityBean getAir_quality() {
                return air_quality;
            }

            public void setAir_quality(AirQualityBean air_quality) {
                this.air_quality = air_quality;
            }

            public String getApparent_temperature() {
                return apparent_temperature;
            }

            public void setApparent_temperature(String apparent_temperature) {
                this.apparent_temperature = apparent_temperature;
            }

            public double getCloudrate() {
                return cloudrate;
            }

            public void setCloudrate(double cloudrate) {
                this.cloudrate = cloudrate;
            }

            public double getDswrf() {
                return dswrf;
            }

            public void setDswrf(double dswrf) {
                this.dswrf = dswrf;
            }

            public String getHumidity() {
                return humidity;
            }

            public void setHumidity(String humidity) {
                this.humidity = humidity;
            }

            public LifeIndexBean getLife_index() {
                return life_index;
            }

            public void setLife_index(LifeIndexBean life_index) {
                this.life_index = life_index;
            }

            public PrecipitationBean getPrecipitation() {
                return precipitation;
            }

            public void setPrecipitation(PrecipitationBean precipitation) {
                this.precipitation = precipitation;
            }

            public String getPressure() {
                return pressure;
            }

            public void setPressure(String pressure) {
                this.pressure = pressure;
            }

            public String getSkycon() {
                return skycon;
            }

            public void setSkycon(String skycon) {
                this.skycon = skycon;
            }

            public String getStatus() {
                return status;
            }

            public void setStatus(String status) {
                this.status = status;
            }

            public double getTemperature() {
                return temperature;
            }

            public void setTemperature(double temperature) {
                this.temperature = temperature;
            }

            public String getVisibility() {
                return visibility;
            }

            public void setVisibility(String visibility) {
                this.visibility = visibility;
            }

            public WindBean getWind() {
                return wind;
            }

            public void setWind(WindBean wind) {
                this.wind = wind;
            }

            public static class AirQualityBean {
                /**
                 * aqi : {"chn":15,"usa":16}
                 * co : 0.5
                 * description : {"chn":"u4f18","usa":"u4f18"}
                 * no2 : 15
                 * o3 : 47
                 * pm10 : 14
                 * pm25 : 10
                 * so2 : 7
                 */

                private AqiBean aqi;
                private String co;
                private DescriptionBean description;
                private String no2;
                private String o3;
                private String pm10;
                private String pm25;
                private String so2;

                public AqiBean getAqi() {
                    return aqi;
                }

                public void setAqi(AqiBean aqi) {
                    this.aqi = aqi;
                }

                public String getCo() {
                    return co;
                }

                public void setCo(String co) {
                    this.co = co;
                }

                public DescriptionBean getDescription() {
                    return description;
                }

                public void setDescription(DescriptionBean description) {
                    this.description = description;
                }

                public String getNo2() {
                    return no2;
                }

                public void setNo2(String no2) {
                    this.no2 = no2;
                }

                public String getO3() {
                    return o3;
                }

                public void setO3(String o3) {
                    this.o3 = o3;
                }

                public String getPm10() {
                    return pm10;
                }

                public void setPm10(String pm10) {
                    this.pm10 = pm10;
                }

                public String getPm25() {
                    return pm25;
                }

                public void setPm25(String pm25) {
                    this.pm25 = pm25;
                }

                public String getSo2() {
                    return so2;
                }

                public void setSo2(String so2) {
                    this.so2 = so2;
                }

                public static class AqiBean {
                    /**
                     * chn : 15
                     * usa : 16
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

                public static class DescriptionBean {
                    /**
                     * chn : u4f18
                     * usa : u4f18
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

            public static class LifeIndexBean {
                /**
                 * comfort : {"desc":"u6e7fu51b7","index":12}
                 * ultraviolet : {"desc":"u5f88u5f31","index":2}
                 */

                private ComfortBean comfort;
                private UltravioletBean ultraviolet;

                public ComfortBean getComfort() {
                    return comfort;
                }

                public void setComfort(ComfortBean comfort) {
                    this.comfort = comfort;
                }

                public UltravioletBean getUltraviolet() {
                    return ultraviolet;
                }

                public void setUltraviolet(UltravioletBean ultraviolet) {
                    this.ultraviolet = ultraviolet;
                }

                public static class ComfortBean {
                    /**
                     * desc : u6e7fu51b7
                     * index : 12
                     */

                    private String desc;
                    private int index;

                    public String getDesc() {
                        return desc;
                    }

                    public void setDesc(String desc) {
                        this.desc = desc;
                    }

                    public int getIndex() {
                        return index;
                    }

                    public void setIndex(int index) {
                        this.index = index;
                    }
                }

                public static class UltravioletBean {
                    /**
                     * desc : u5f88u5f31
                     * index : 2.0
                     */

                    private String desc;
                    private String index;

                    public String getDesc() {
                        return desc;
                    }

                    public void setDesc(String desc) {
                        this.desc = desc;
                    }

                    public String getIndex() {
                        return index;
                    }

                    public void setIndex(String index) {
                        this.index = index;
                    }
                }
            }

            public static class PrecipitationBean {
                /**
                 * local : {"datasource":"radar","intensity":0,"status":"ok"}
                 * nearest : {"distance":77.18,"intensity":0.1875,"status":"ok"}
                 */

                private LocalBean local;
                private NearestBean nearest;

                public LocalBean getLocal() {
                    return local;
                }

                public void setLocal(LocalBean local) {
                    this.local = local;
                }

                public NearestBean getNearest() {
                    return nearest;
                }

                public void setNearest(NearestBean nearest) {
                    this.nearest = nearest;
                }

                public static class LocalBean {
                    /**
                     * datasource : radar
                     * intensity : 0.0
                     * status : ok
                     */

                    private String datasource;
                    private double intensity;
                    private String status;

                    public String getDatasource() {
                        return datasource;
                    }

                    public void setDatasource(String datasource) {
                        this.datasource = datasource;
                    }

                    public double getIntensity() {
                        return intensity;
                    }

                    public void setIntensity(double intensity) {
                        this.intensity = intensity;
                    }

                    public String getStatus() {
                        return status;
                    }

                    public void setStatus(String status) {
                        this.status = status;
                    }
                }

                public static class NearestBean {
                    /**
                     * distance : 77.18
                     * intensity : 0.1875
                     * status : ok
                     */

                    private String distance;
                    private String intensity;
                    private String status;

                    public String getDistance() {
                        return distance;
                    }

                    public void setDistance(String distance) {
                        this.distance = distance;
                    }

                    public String getIntensity() {
                        return intensity;
                    }

                    public void setIntensity(String intensity) {
                        this.intensity = intensity;
                    }

                    public String getStatus() {
                        return status;
                    }

                    public void setStatus(String status) {
                        this.status = status;
                    }
                }
            }

            public static class WindBean {
                /**
                 * direction : 283.0
                 * speed : 12.6
                 */

                private double direction;
                private double speed;

                public double getDirection() {
                    return direction;
                }

                public void setDirection(double direction) {
                    this.direction = direction;
                }

                public double getSpeed() {
                    return speed;
                }

                public void setSpeed(double speed) {
                    this.speed = speed;
                }
            }
        }
    }

    /**
     * status : ok
     * api_version : v2.5
     * api_status : active
     * lang : zh_CN
     * unit : metric
     * tzshift : 28800
     * timezone : Asia/Taipei
     * server_time : 1636609443
     * location : [25.1552,121.6544]
     * result : {"realtime":{"status":"ok","temperature":21,"humidity":0.52,"cloudrate":0,"skycon":"CLEAR_DAY","visibility":18.05,"dswrf":672.8,"wind":{"speed":17.09,"direction":83.54},"pressure":100107.16,"apparent_temperature":18.6,"precipitation":{"local":{"status":"ok","datasource":"gfs","intensity":0}},"air_quality":{"pm25":5,"pm10":0,"o3":0,"so2":0,"no2":0,"co":0,"aqi":{"chn":12,"usa":0},"description":{"usa":"","chn":"优"}},"life_index":{"ultraviolet":{"index":7,"desc":"强"},"comfort":{"index":5,"desc":"舒适"}}},"primary":0}
     */


}
