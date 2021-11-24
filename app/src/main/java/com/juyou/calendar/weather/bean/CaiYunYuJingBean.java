package com.juyou.calendar.weather.bean;

import java.util.List;

/**
 * @author 聚友互动
 * @datetime 2021-11-24 10:11
 * @detail :https://api.caiyunapp.com/v2.5/nWupmHyRqEh1BVyk/112.57,35.08/weather.json?alert=true
 * 济源 经度112.57 纬度35.08 卫星经度138 方位140.40 俯仰41.11 极化31.44
 *
 */
public class CaiYunYuJingBean {

    /**
     * status : ok
     * api_version : v2.5
     * api_status : active
     * lang : zh_CN
     * unit : metric
     * tzshift : 28800
     * timezone : Asia/Shanghai
     * server_time : 1637719694
     * location : [35.08,112.57]
     * result : {"alert":{"status":"ok","content":[{"province":"河南省","status":"预警中","code":"0501","description":"济源市气象台2021年11月24日09时15分发布大风蓝色预警信号：预计今天白天，我市邵原、王屋、下冶、克井、五龙口等镇将有5到6级西北风，局部阵风7到8级。请注意做好防灾减灾和安全生产工作。","regionId":"101181801","county":"济源市","pubtimestamp":1637717036,"latlon":[35.067243,112.601918],"city":"济源市","alertId":"41900141600000_20211124092356","title":"济源市气象台发布大风蓝色预警[IV级/一般]","adcode":"419001","source":"国家预警信息发布中心","location":"河南省济源市济源市","request_status":"ok"}]},"realtime":{"status":"ok","temperature":9,"humidity":0.33,"cloudrate":0,"skycon":"CLEAR_DAY","visibility":11.2,"dswrf":271.5,"wind":{"speed":6.12,"direction":249},"pressure":97873.79,"apparent_temperature":6.3,"precipitation":{"local":{"status":"ok","datasource":"radar","intensity":0},"nearest":{"status":"ok","distance":137.52,"intensity":0.1875}},"air_quality":{"pm25":32,"pm10":87,"o3":16,"so2":1,"no2":43,"co":0.6,"aqi":{"chn":69,"usa":69},"description":{"chn":"良","usa":"良"}},"life_index":{"ultraviolet":{"index":5,"desc":"中等"},"comfort":{"index":8,"desc":"很冷"}}},"minutely":{"status":"ok","datasource":"radar","precipitation_2h":[0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0],"precipitation":[0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0],"probability":[0,0,0,0],"description":"未来两小时不会下雨，放心出门吧"},"hourly":{"status":"ok","description":"未来24小时晴","precipitation":[{"datetime":"2021-11-24T10:00+08:00","value":0},{"datetime":"2021-11-24T11:00+08:00","value":0},{"datetime":"2021-11-24T12:00+08:00","value":0},{"datetime":"2021-11-24T13:00+08:00","value":0},{"datetime":"2021-11-24T14:00+08:00","value":0},{"datetime":"2021-11-24T15:00+08:00","value":0},{"datetime":"2021-11-24T16:00+08:00","value":0},{"datetime":"2021-11-24T17:00+08:00","value":0},{"datetime":"2021-11-24T18:00+08:00","value":0},{"datetime":"2021-11-24T19:00+08:00","value":0},{"datetime":"2021-11-24T20:00+08:00","value":0},{"datetime":"2021-11-24T21:00+08:00","value":0},{"datetime":"2021-11-24T22:00+08:00","value":0},{"datetime":"2021-11-24T23:00+08:00","value":0},{"datetime":"2021-11-25T00:00+08:00","value":0},{"datetime":"2021-11-25T01:00+08:00","value":0},{"datetime":"2021-11-25T02:00+08:00","value":0},{"datetime":"2021-11-25T03:00+08:00","value":0},{"datetime":"2021-11-25T04:00+08:00","value":0},{"datetime":"2021-11-25T05:00+08:00","value":0},{"datetime":"2021-11-25T06:00+08:00","value":0},{"datetime":"2021-11-25T07:00+08:00","value":0},{"datetime":"2021-11-25T08:00+08:00","value":0},{"datetime":"2021-11-25T09:00+08:00","value":0},{"datetime":"2021-11-25T10:00+08:00","value":0},{"datetime":"2021-11-25T11:00+08:00","value":0},{"datetime":"2021-11-25T12:00+08:00","value":0},{"datetime":"2021-11-25T13:00+08:00","value":0},{"datetime":"2021-11-25T14:00+08:00","value":0},{"datetime":"2021-11-25T15:00+08:00","value":0},{"datetime":"2021-11-25T16:00+08:00","value":0},{"datetime":"2021-11-25T17:00+08:00","value":0},{"datetime":"2021-11-25T18:00+08:00","value":0},{"datetime":"2021-11-25T19:00+08:00","value":0},{"datetime":"2021-11-25T20:00+08:00","value":0},{"datetime":"2021-11-25T21:00+08:00","value":0},{"datetime":"2021-11-25T22:00+08:00","value":0},{"datetime":"2021-11-25T23:00+08:00","value":0},{"datetime":"2021-11-26T00:00+08:00","value":0},{"datetime":"2021-11-26T01:00+08:00","value":0},{"datetime":"2021-11-26T02:00+08:00","value":0},{"datetime":"2021-11-26T03:00+08:00","value":0},{"datetime":"2021-11-26T04:00+08:00","value":0},{"datetime":"2021-11-26T05:00+08:00","value":0},{"datetime":"2021-11-26T06:00+08:00","value":0},{"datetime":"2021-11-26T07:00+08:00","value":0},{"datetime":"2021-11-26T08:00+08:00","value":0},{"datetime":"2021-11-26T09:00+08:00","value":0}],"temperature":[{"datetime":"2021-11-24T10:00+08:00","value":9},{"datetime":"2021-11-24T11:00+08:00","value":11.5},{"datetime":"2021-11-24T12:00+08:00","value":13},{"datetime":"2021-11-24T13:00+08:00","value":13.5},{"datetime":"2021-11-24T14:00+08:00","value":15},{"datetime":"2021-11-24T15:00+08:00","value":15.5},{"datetime":"2021-11-24T16:00+08:00","value":15},{"datetime":"2021-11-24T17:00+08:00","value":14},{"datetime":"2021-11-24T18:00+08:00","value":8},{"datetime":"2021-11-24T19:00+08:00","value":8},{"datetime":"2021-11-24T20:00+08:00","value":7.5},{"datetime":"2021-11-24T21:00+08:00","value":6.2},{"datetime":"2021-11-24T22:00+08:00","value":5.1},{"datetime":"2021-11-24T23:00+08:00","value":4.2},{"datetime":"2021-11-25T00:00+08:00","value":3.5},{"datetime":"2021-11-25T01:00+08:00","value":3.4},{"datetime":"2021-11-25T02:00+08:00","value":3.3},{"datetime":"2021-11-25T03:00+08:00","value":3},{"datetime":"2021-11-25T04:00+08:00","value":3},{"datetime":"2021-11-25T05:00+08:00","value":3},{"datetime":"2021-11-25T06:00+08:00","value":4.3},{"datetime":"2021-11-25T07:00+08:00","value":5.6},{"datetime":"2021-11-25T08:00+08:00","value":6.9},{"datetime":"2021-11-25T09:00+08:00","value":8.2},{"datetime":"2021-11-25T10:00+08:00","value":9.5},{"datetime":"2021-11-25T11:00+08:00","value":10.8},{"datetime":"2021-11-25T12:00+08:00","value":12.1},{"datetime":"2021-11-25T13:00+08:00","value":13.4},{"datetime":"2021-11-25T14:00+08:00","value":14.7},{"datetime":"2021-11-25T15:00+08:00","value":16},{"datetime":"2021-11-25T16:00+08:00","value":15.9},{"datetime":"2021-11-25T17:00+08:00","value":15.26},{"datetime":"2021-11-25T18:00+08:00","value":14.48},{"datetime":"2021-11-25T19:00+08:00","value":13.73},{"datetime":"2021-11-25T20:00+08:00","value":12.82},{"datetime":"2021-11-25T21:00+08:00","value":11.86},{"datetime":"2021-11-25T22:00+08:00","value":10.04},{"datetime":"2021-11-25T23:00+08:00","value":8.4},{"datetime":"2021-11-26T00:00+08:00","value":6.95},{"datetime":"2021-11-26T01:00+08:00","value":5.59},{"datetime":"2021-11-26T02:00+08:00","value":4.93},{"datetime":"2021-11-26T03:00+08:00","value":4.43},{"datetime":"2021-11-26T04:00+08:00","value":3.96},{"datetime":"2021-11-26T05:00+08:00","value":4.29},{"datetime":"2021-11-26T06:00+08:00","value":4.74},{"datetime":"2021-11-26T07:00+08:00","value":3},{"datetime":"2021-11-26T08:00+08:00","value":6.15},{"datetime":"2021-11-26T09:00+08:00","value":6.49}],"wind":[{"datetime":"2021-11-24T10:00+08:00","speed":6.12,"direction":249},{"datetime":"2021-11-24T11:00+08:00","speed":13.27,"direction":287.02},{"datetime":"2021-11-24T12:00+08:00","speed":15.34,"direction":289.68},{"datetime":"2021-11-24T13:00+08:00","speed":15.67,"direction":283.13},{"datetime":"2021-11-24T14:00+08:00","speed":16.07,"direction":278.95},{"datetime":"2021-11-24T15:00+08:00","speed":15.88,"direction":285.56},{"datetime":"2021-11-24T16:00+08:00","speed":15.41,"direction":286.24},{"datetime":"2021-11-24T17:00+08:00","speed":14.69,"direction":290.31},{"datetime":"2021-11-24T18:00+08:00","speed":11.67,"direction":302.78},{"datetime":"2021-11-24T19:00+08:00","speed":11.06,"direction":311.28},{"datetime":"2021-11-24T20:00+08:00","speed":10.09,"direction":316.82},{"datetime":"2021-11-24T21:00+08:00","speed":8.92,"direction":321.05},{"datetime":"2021-11-24T22:00+08:00","speed":8.6,"direction":318.83},{"datetime":"2021-11-24T23:00+08:00","speed":8.84,"direction":321.11},{"datetime":"2021-11-25T00:00+08:00","speed":8.89,"direction":317.62},{"datetime":"2021-11-25T01:00+08:00","speed":8.98,"direction":316.35},{"datetime":"2021-11-25T02:00+08:00","speed":9.22,"direction":320.3},{"datetime":"2021-11-25T03:00+08:00","speed":8.84,"direction":321.42},{"datetime":"2021-11-25T04:00+08:00","speed":9.18,"direction":318.77},{"datetime":"2021-11-25T05:00+08:00","speed":10.09,"direction":317.73},{"datetime":"2021-11-25T06:00+08:00","speed":9.79,"direction":317.49},{"datetime":"2021-11-25T07:00+08:00","speed":9.12,"direction":313.78},{"datetime":"2021-11-25T08:00+08:00","speed":8.25,"direction":312.08},{"datetime":"2021-11-25T09:00+08:00","speed":6.65,"direction":312.58},{"datetime":"2021-11-25T10:00+08:00","speed":6.01,"direction":311.13},{"datetime":"2021-11-25T11:00+08:00","speed":5.35,"direction":303.19},{"datetime":"2021-11-25T12:00+08:00","speed":5.96,"direction":308.42},{"datetime":"2021-11-25T13:00+08:00","speed":5.9,"direction":320.02},{"datetime":"2021-11-25T14:00+08:00","speed":4.67,"direction":308.41},{"datetime":"2021-11-25T15:00+08:00","speed":4.49,"direction":290.65},{"datetime":"2021-11-25T16:00+08:00","speed":2.87,"direction":266.4},{"datetime":"2021-11-25T17:00+08:00","speed":2.64,"direction":273.84},{"datetime":"2021-11-25T18:00+08:00","speed":5.6,"direction":304.61},{"datetime":"2021-11-25T19:00+08:00","speed":7.57,"direction":313.94},{"datetime":"2021-11-25T20:00+08:00","speed":7.99,"direction":320.74},{"datetime":"2021-11-25T21:00+08:00","speed":8.42,"direction":321.8},{"datetime":"2021-11-25T22:00+08:00","speed":8.47,"direction":316.61},{"datetime":"2021-11-25T23:00+08:00","speed":8.2,"direction":316.62},{"datetime":"2021-11-26T00:00+08:00","speed":8.33,"direction":322.24},{"datetime":"2021-11-26T01:00+08:00","speed":8.82,"direction":327.97},{"datetime":"2021-11-26T02:00+08:00","speed":9.46,"direction":330.66},{"datetime":"2021-11-26T03:00+08:00","speed":9.61,"direction":331.18},{"datetime":"2021-11-26T04:00+08:00","speed":9.52,"direction":333.51},{"datetime":"2021-11-26T05:00+08:00","speed":9.08,"direction":341.28},{"datetime":"2021-11-26T06:00+08:00","speed":8.01,"direction":350.55},{"datetime":"2021-11-26T07:00+08:00","speed":6.76,"direction":351.18},{"datetime":"2021-11-26T08:00+08:00","speed":6.89,"direction":359.19},{"datetime":"2021-11-26T09:00+08:00","speed":4.85,"direction":12.59}],"humidity":[{"datetime":"2021-11-24T10:00+08:00","value":0.33},{"datetime":"2021-11-24T11:00+08:00","value":0.27},{"datetime":"2021-11-24T12:00+08:00","value":0.23},{"datetime":"2021-11-24T13:00+08:00","value":0.2},{"datetime":"2021-11-24T14:00+08:00","value":0.2},{"datetime":"2021-11-24T15:00+08:00","value":0.21},{"datetime":"2021-11-24T16:00+08:00","value":0.25},{"datetime":"2021-11-24T17:00+08:00","value":0.29},{"datetime":"2021-11-24T18:00+08:00","value":0.31},{"datetime":"2021-11-24T19:00+08:00","value":0.33},{"datetime":"2021-11-24T20:00+08:00","value":0.34},{"datetime":"2021-11-24T21:00+08:00","value":0.35},{"datetime":"2021-11-24T22:00+08:00","value":0.35},{"datetime":"2021-11-24T23:00+08:00","value":0.36},{"datetime":"2021-11-25T00:00+08:00","value":0.36},{"datetime":"2021-11-25T01:00+08:00","value":0.36},{"datetime":"2021-11-25T02:00+08:00","value":0.36},{"datetime":"2021-11-25T03:00+08:00","value":0.36},{"datetime":"2021-11-25T04:00+08:00","value":0.36},{"datetime":"2021-11-25T05:00+08:00","value":0.36},{"datetime":"2021-11-25T06:00+08:00","value":0.36},{"datetime":"2021-11-25T07:00+08:00","value":0.36},{"datetime":"2021-11-25T08:00+08:00","value":0.37},{"datetime":"2021-11-25T09:00+08:00","value":0.34},{"datetime":"2021-11-25T10:00+08:00","value":0.28},{"datetime":"2021-11-25T11:00+08:00","value":0.25},{"datetime":"2021-11-25T12:00+08:00","value":0.23},{"datetime":"2021-11-25T13:00+08:00","value":0.21},{"datetime":"2021-11-25T14:00+08:00","value":0.2},{"datetime":"2021-11-25T15:00+08:00","value":0.21},{"datetime":"2021-11-25T16:00+08:00","value":0.27},{"datetime":"2021-11-25T17:00+08:00","value":0.3},{"datetime":"2021-11-25T18:00+08:00","value":0.3},{"datetime":"2021-11-25T19:00+08:00","value":0.31},{"datetime":"2021-11-25T20:00+08:00","value":0.32},{"datetime":"2021-11-25T21:00+08:00","value":0.33},{"datetime":"2021-11-25T22:00+08:00","value":0.35},{"datetime":"2021-11-25T23:00+08:00","value":0.36},{"datetime":"2021-11-26T00:00+08:00","value":0.36},{"datetime":"2021-11-26T01:00+08:00","value":0.37},{"datetime":"2021-11-26T02:00+08:00","value":0.37},{"datetime":"2021-11-26T03:00+08:00","value":0.38},{"datetime":"2021-11-26T04:00+08:00","value":0.38},{"datetime":"2021-11-26T05:00+08:00","value":0.39},{"datetime":"2021-11-26T06:00+08:00","value":0.4},{"datetime":"2021-11-26T07:00+08:00","value":0.4},{"datetime":"2021-11-26T08:00+08:00","value":0.41},{"datetime":"2021-11-26T09:00+08:00","value":0.37}],"cloudrate":[{"datetime":"2021-11-24T10:00+08:00","value":0},{"datetime":"2021-11-24T11:00+08:00","value":0},{"datetime":"2021-11-24T12:00+08:00","value":0},{"datetime":"2021-11-24T13:00+08:00","value":0},{"datetime":"2021-11-24T14:00+08:00","value":0},{"datetime":"2021-11-24T15:00+08:00","value":0},{"datetime":"2021-11-24T16:00+08:00","value":0},{"datetime":"2021-11-24T17:00+08:00","value":0},{"datetime":"2021-11-24T18:00+08:00","value":0},{"datetime":"2021-11-24T19:00+08:00","value":0},{"datetime":"2021-11-24T20:00+08:00","value":0},{"datetime":"2021-11-24T21:00+08:00","value":0},{"datetime":"2021-11-24T22:00+08:00","value":0},{"datetime":"2021-11-24T23:00+08:00","value":0},{"datetime":"2021-11-25T00:00+08:00","value":0},{"datetime":"2021-11-25T01:00+08:00","value":0},{"datetime":"2021-11-25T02:00+08:00","value":0},{"datetime":"2021-11-25T03:00+08:00","value":0},{"datetime":"2021-11-25T04:00+08:00","value":0},{"datetime":"2021-11-25T05:00+08:00","value":0},{"datetime":"2021-11-25T06:00+08:00","value":0},{"datetime":"2021-11-25T07:00+08:00","value":0},{"datetime":"2021-11-25T08:00+08:00","value":0},{"datetime":"2021-11-25T09:00+08:00","value":0},{"datetime":"2021-11-25T10:00+08:00","value":0},{"datetime":"2021-11-25T11:00+08:00","value":0},{"datetime":"2021-11-25T12:00+08:00","value":0},{"datetime":"2021-11-25T13:00+08:00","value":0},{"datetime":"2021-11-25T14:00+08:00","value":0},{"datetime":"2021-11-25T15:00+08:00","value":0},{"datetime":"2021-11-25T16:00+08:00","value":0},{"datetime":"2021-11-25T17:00+08:00","value":0},{"datetime":"2021-11-25T18:00+08:00","value":0},{"datetime":"2021-11-25T19:00+08:00","value":0},{"datetime":"2021-11-25T20:00+08:00","value":0},{"datetime":"2021-11-25T21:00+08:00","value":0},{"datetime":"2021-11-25T22:00+08:00","value":0},{"datetime":"2021-11-25T23:00+08:00","value":0},{"datetime":"2021-11-26T00:00+08:00","value":0},{"datetime":"2021-11-26T01:00+08:00","value":0},{"datetime":"2021-11-26T02:00+08:00","value":0},{"datetime":"2021-11-26T03:00+08:00","value":0},{"datetime":"2021-11-26T04:00+08:00","value":0},{"datetime":"2021-11-26T05:00+08:00","value":0},{"datetime":"2021-11-26T06:00+08:00","value":0},{"datetime":"2021-11-26T07:00+08:00","value":0},{"datetime":"2021-11-26T08:00+08:00","value":0.04},{"datetime":"2021-11-26T09:00+08:00","value":0.07}],"skycon":[{"datetime":"2021-11-24T10:00+08:00","value":"CLEAR_DAY"},{"datetime":"2021-11-24T11:00+08:00","value":"CLEAR_DAY"},{"datetime":"2021-11-24T12:00+08:00","value":"CLEAR_DAY"},{"datetime":"2021-11-24T13:00+08:00","value":"CLEAR_DAY"},{"datetime":"2021-11-24T14:00+08:00","value":"CLEAR_DAY"},{"datetime":"2021-11-24T15:00+08:00","value":"CLEAR_DAY"},{"datetime":"2021-11-24T16:00+08:00","value":"CLEAR_DAY"},{"datetime":"2021-11-24T17:00+08:00","value":"CLEAR_DAY"},{"datetime":"2021-11-24T18:00+08:00","value":"CLEAR_NIGHT"},{"datetime":"2021-11-24T19:00+08:00","value":"CLEAR_NIGHT"},{"datetime":"2021-11-24T20:00+08:00","value":"CLEAR_NIGHT"},{"datetime":"2021-11-24T21:00+08:00","value":"CLEAR_NIGHT"},{"datetime":"2021-11-24T22:00+08:00","value":"CLEAR_NIGHT"},{"datetime":"2021-11-24T23:00+08:00","value":"CLEAR_NIGHT"},{"datetime":"2021-11-25T00:00+08:00","value":"CLEAR_NIGHT"},{"datetime":"2021-11-25T01:00+08:00","value":"CLEAR_NIGHT"},{"datetime":"2021-11-25T02:00+08:00","value":"CLEAR_NIGHT"},{"datetime":"2021-11-25T03:00+08:00","value":"CLEAR_NIGHT"},{"datetime":"2021-11-25T04:00+08:00","value":"CLEAR_NIGHT"},{"datetime":"2021-11-25T05:00+08:00","value":"CLEAR_NIGHT"},{"datetime":"2021-11-25T06:00+08:00","value":"CLEAR_NIGHT"},{"datetime":"2021-11-25T07:00+08:00","value":"CLEAR_NIGHT"},{"datetime":"2021-11-25T08:00+08:00","value":"CLEAR_DAY"},{"datetime":"2021-11-25T09:00+08:00","value":"CLEAR_DAY"},{"datetime":"2021-11-25T10:00+08:00","value":"CLEAR_DAY"},{"datetime":"2021-11-25T11:00+08:00","value":"CLEAR_DAY"},{"datetime":"2021-11-25T12:00+08:00","value":"CLEAR_DAY"},{"datetime":"2021-11-25T13:00+08:00","value":"CLEAR_DAY"},{"datetime":"2021-11-25T14:00+08:00","value":"CLEAR_DAY"},{"datetime":"2021-11-25T15:00+08:00","value":"CLEAR_DAY"},{"datetime":"2021-11-25T16:00+08:00","value":"CLEAR_DAY"},{"datetime":"2021-11-25T17:00+08:00","value":"CLEAR_DAY"},{"datetime":"2021-11-25T18:00+08:00","value":"CLEAR_NIGHT"},{"datetime":"2021-11-25T19:00+08:00","value":"CLEAR_NIGHT"},{"datetime":"2021-11-25T20:00+08:00","value":"CLEAR_NIGHT"},{"datetime":"2021-11-25T21:00+08:00","value":"CLEAR_NIGHT"},{"datetime":"2021-11-25T22:00+08:00","value":"CLEAR_NIGHT"},{"datetime":"2021-11-25T23:00+08:00","value":"CLEAR_NIGHT"},{"datetime":"2021-11-26T00:00+08:00","value":"CLEAR_NIGHT"},{"datetime":"2021-11-26T01:00+08:00","value":"CLEAR_NIGHT"},{"datetime":"2021-11-26T02:00+08:00","value":"CLEAR_NIGHT"},{"datetime":"2021-11-26T03:00+08:00","value":"CLEAR_NIGHT"},{"datetime":"2021-11-26T04:00+08:00","value":"CLEAR_NIGHT"},{"datetime":"2021-11-26T05:00+08:00","value":"CLEAR_NIGHT"},{"datetime":"2021-11-26T06:00+08:00","value":"CLEAR_NIGHT"},{"datetime":"2021-11-26T07:00+08:00","value":"CLEAR_NIGHT"},{"datetime":"2021-11-26T08:00+08:00","value":"CLEAR_DAY"},{"datetime":"2021-11-26T09:00+08:00","value":"CLEAR_DAY"}],"pressure":[{"datetime":"2021-11-24T10:00+08:00","value":97873.792},{"datetime":"2021-11-24T11:00+08:00","value":97819.392},{"datetime":"2021-11-24T12:00+08:00","value":97739.392},{"datetime":"2021-11-24T13:00+08:00","value":97579.392},{"datetime":"2021-11-24T14:00+08:00","value":97545.728},{"datetime":"2021-11-24T15:00+08:00","value":97506.56},{"datetime":"2021-11-24T16:00+08:00","value":97524.992},{"datetime":"2021-11-24T17:00+08:00","value":97586.56},{"datetime":"2021-11-24T18:00+08:00","value":97659.392},{"datetime":"2021-11-24T19:00+08:00","value":97684.992},{"datetime":"2021-11-24T20:00+08:00","value":97739.392},{"datetime":"2021-11-24T21:00+08:00","value":97780.224},{"datetime":"2021-11-24T22:00+08:00","value":97819.392},{"datetime":"2021-11-24T23:00+08:00","value":97819.392},{"datetime":"2021-11-25T00:00+08:00","value":97834.624},{"datetime":"2021-11-25T01:00+08:00","value":97819.392},{"datetime":"2021-11-25T02:00+08:00","value":97819.392},{"datetime":"2021-11-25T03:00+08:00","value":97819.392},{"datetime":"2021-11-25T04:00+08:00","value":97819.392},{"datetime":"2021-11-25T05:00+08:00","value":97819.392},{"datetime":"2021-11-25T06:00+08:00","value":97834.624},{"datetime":"2021-11-25T07:00+08:00","value":97899.392},{"datetime":"2021-11-25T08:00+08:00","value":97979.392},{"datetime":"2021-11-25T09:00+08:00","value":98059.392},{"datetime":"2021-11-25T10:00+08:00","value":98059.392},{"datetime":"2021-11-25T11:00+08:00","value":98059.392},{"datetime":"2021-11-25T12:00+08:00","value":97979.392},{"datetime":"2021-11-25T13:00+08:00","value":97899.392},{"datetime":"2021-11-25T14:00+08:00","value":97819.392},{"datetime":"2021-11-25T15:00+08:00","value":97764.992},{"datetime":"2021-11-25T16:00+08:00","value":97819.392},{"datetime":"2021-11-25T17:00+08:00","value":97844.992},{"datetime":"2021-11-25T18:00+08:00","value":97924.992},{"datetime":"2021-11-25T19:00+08:00","value":98004.992},{"datetime":"2021-11-25T20:00+08:00","value":98059.392},{"datetime":"2021-11-25T21:00+08:00","value":98084.992},{"datetime":"2021-11-25T22:00+08:00","value":98139.392},{"datetime":"2021-11-25T23:00+08:00","value":98164.992},{"datetime":"2021-11-26T00:00+08:00","value":98219.392},{"datetime":"2021-11-26T01:00+08:00","value":98219.392},{"datetime":"2021-11-26T02:00+08:00","value":98260.224},{"datetime":"2021-11-26T03:00+08:00","value":98299.392},{"datetime":"2021-11-26T04:00+08:00","value":98299.392},{"datetime":"2021-11-26T05:00+08:00","value":98314.624},{"datetime":"2021-11-26T06:00+08:00","value":98394.624},{"datetime":"2021-11-26T07:00+08:00","value":98513.792},{"datetime":"2021-11-26T08:00+08:00","value":98616.192},{"datetime":"2021-11-26T09:00+08:00","value":98696.192}],"visibility":[{"datetime":"2021-11-24T10:00+08:00","value":11.2},{"datetime":"2021-11-24T11:00+08:00","value":4.48},{"datetime":"2021-11-24T12:00+08:00","value":4.67},{"datetime":"2021-11-24T13:00+08:00","value":5.09},{"datetime":"2021-11-24T14:00+08:00","value":5.89},{"datetime":"2021-11-24T15:00+08:00","value":7},{"datetime":"2021-11-24T16:00+08:00","value":8},{"datetime":"2021-11-24T17:00+08:00","value":9.33},{"datetime":"2021-11-24T18:00+08:00","value":10.18},{"datetime":"2021-11-24T19:00+08:00","value":10.18},{"datetime":"2021-11-24T20:00+08:00","value":8.62},{"datetime":"2021-11-24T21:00+08:00","value":7.47},{"datetime":"2021-11-24T22:00+08:00","value":6.22},{"datetime":"2021-11-24T23:00+08:00","value":5.33},{"datetime":"2021-11-25T00:00+08:00","value":4.87},{"datetime":"2021-11-25T01:00+08:00","value":4.67},{"datetime":"2021-11-25T02:00+08:00","value":4.31},{"datetime":"2021-11-25T03:00+08:00","value":4.15},{"datetime":"2021-11-25T04:00+08:00","value":4},{"datetime":"2021-11-25T05:00+08:00","value":3.86},{"datetime":"2021-11-25T06:00+08:00","value":3.61},{"datetime":"2021-11-25T07:00+08:00","value":3.5},{"datetime":"2021-11-25T08:00+08:00","value":3.29},{"datetime":"2021-11-25T09:00+08:00","value":3.2},{"datetime":"2021-11-25T10:00+08:00","value":3.2},{"datetime":"2021-11-25T11:00+08:00","value":3.2},{"datetime":"2021-11-25T12:00+08:00","value":3.39},{"datetime":"2021-11-25T13:00+08:00","value":3.73},{"datetime":"2021-11-25T14:00+08:00","value":4.31},{"datetime":"2021-11-25T15:00+08:00","value":4.87},{"datetime":"2021-11-25T16:00+08:00","value":5.6},{"datetime":"2021-11-25T17:00+08:00","value":5.6},{"datetime":"2021-11-25T18:00+08:00","value":5.33},{"datetime":"2021-11-25T19:00+08:00","value":4.87},{"datetime":"2021-11-25T20:00+08:00","value":4.48},{"datetime":"2021-11-25T21:00+08:00","value":4.15},{"datetime":"2021-11-25T22:00+08:00","value":4},{"datetime":"2021-11-25T23:00+08:00","value":4},{"datetime":"2021-11-26T00:00+08:00","value":4},{"datetime":"2021-11-26T01:00+08:00","value":4},{"datetime":"2021-11-26T02:00+08:00","value":3.73},{"datetime":"2021-11-26T03:00+08:00","value":3.5},{"datetime":"2021-11-26T04:00+08:00","value":3.29},{"datetime":"2021-11-26T05:00+08:00","value":3.11},{"datetime":"2021-11-26T06:00+08:00","value":2.95},{"datetime":"2021-11-26T07:00+08:00","value":2.8},{"datetime":"2021-11-26T08:00+08:00","value":2.67},{"datetime":"2021-11-26T09:00+08:00","value":2.55}],"dswrf":[{"datetime":"2021-11-24T10:00+08:00","value":271.4592},{"datetime":"2021-11-24T11:00+08:00","value":345.4592},{"datetime":"2021-11-24T12:00+08:00","value":402.9488},{"datetime":"2021-11-24T13:00+08:00","value":440.6688},{"datetime":"2021-11-24T14:00+08:00","value":458.1584},{"datetime":"2021-11-24T15:00+08:00","value":436.3296},{"datetime":"2021-11-24T16:00+08:00","value":357.6496},{"datetime":"2021-11-24T17:00+08:00","value":271.6496},{"datetime":"2021-11-24T18:00+08:00","value":204.2496},{"datetime":"2021-11-24T19:00+08:00","value":163.5696},{"datetime":"2021-11-24T20:00+08:00","value":136.08},{"datetime":"2021-11-24T21:00+08:00","value":0},{"datetime":"2021-11-24T22:00+08:00","value":0},{"datetime":"2021-11-24T23:00+08:00","value":0},{"datetime":"2021-11-25T00:00+08:00","value":0},{"datetime":"2021-11-25T01:00+08:00","value":0},{"datetime":"2021-11-25T02:00+08:00","value":0},{"datetime":"2021-11-25T03:00+08:00","value":0},{"datetime":"2021-11-25T04:00+08:00","value":0},{"datetime":"2021-11-25T05:00+08:00","value":0},{"datetime":"2021-11-25T06:00+08:00","value":0},{"datetime":"2021-11-25T07:00+08:00","value":0},{"datetime":"2021-11-25T08:00+08:00","value":3.7696},{"datetime":"2021-11-25T09:00+08:00","value":178.24},{"datetime":"2021-11-25T10:00+08:00","value":264.4992},{"datetime":"2021-11-25T11:00+08:00","value":338.2192},{"datetime":"2021-11-25T12:00+08:00","value":394.7088},{"datetime":"2021-11-25T13:00+08:00","value":431.9392},{"datetime":"2021-11-25T14:00+08:00","value":448.9392},{"datetime":"2021-11-25T15:00+08:00","value":427.3296},{"datetime":"2021-11-25T16:00+08:00","value":350.3296},{"datetime":"2021-11-25T17:00+08:00","value":265.6496},{"datetime":"2021-11-25T18:00+08:00","value":199.9696},{"datetime":"2021-11-25T19:00+08:00","value":159.5696},{"datetime":"2021-11-25T20:00+08:00","value":133.08},{"datetime":"2021-11-25T21:00+08:00","value":0},{"datetime":"2021-11-25T22:00+08:00","value":0},{"datetime":"2021-11-25T23:00+08:00","value":0},{"datetime":"2021-11-26T00:00+08:00","value":0},{"datetime":"2021-11-26T01:00+08:00","value":0},{"datetime":"2021-11-26T02:00+08:00","value":0},{"datetime":"2021-11-26T03:00+08:00","value":0},{"datetime":"2021-11-26T04:00+08:00","value":0},{"datetime":"2021-11-26T05:00+08:00","value":0},{"datetime":"2021-11-26T06:00+08:00","value":0},{"datetime":"2021-11-26T07:00+08:00","value":0},{"datetime":"2021-11-26T08:00+08:00","value":3.1904},{"datetime":"2021-11-26T09:00+08:00","value":172.0496}],"air_quality":{"aqi":[{"datetime":"2021-11-24T10:00+08:00","value":{"chn":69,"usa":69}},{"datetime":"2021-11-24T11:00+08:00","value":{"chn":75,"usa":75}},{"datetime":"2021-11-24T12:00+08:00","value":{"chn":74,"usa":74}},{"datetime":"2021-11-24T13:00+08:00","value":{"chn":71,"usa":71}},{"datetime":"2021-11-24T14:00+08:00","value":{"chn":67,"usa":67}},{"datetime":"2021-11-24T15:00+08:00","value":{"chn":64,"usa":64}},{"datetime":"2021-11-24T16:00+08:00","value":{"chn":61,"usa":61}},{"datetime":"2021-11-24T17:00+08:00","value":{"chn":59,"usa":59}},{"datetime":"2021-11-24T18:00+08:00","value":{"chn":57,"usa":57}},{"datetime":"2021-11-24T19:00+08:00","value":{"chn":57,"usa":57}},{"datetime":"2021-11-24T20:00+08:00","value":{"chn":60,"usa":60}},{"datetime":"2021-11-24T21:00+08:00","value":{"chn":62,"usa":62}},{"datetime":"2021-11-24T22:00+08:00","value":{"chn":66,"usa":66}},{"datetime":"2021-11-24T23:00+08:00","value":{"chn":70,"usa":70}},{"datetime":"2021-11-25T00:00+08:00","value":{"chn":72,"usa":72}},{"datetime":"2021-11-25T01:00+08:00","value":{"chn":74,"usa":74}},{"datetime":"2021-11-25T02:00+08:00","value":{"chn":76,"usa":76}},{"datetime":"2021-11-25T03:00+08:00","value":{"chn":77,"usa":77}},{"datetime":"2021-11-25T04:00+08:00","value":{"chn":79,"usa":79}},{"datetime":"2021-11-25T05:00+08:00","value":{"chn":80,"usa":80}},{"datetime":"2021-11-25T06:00+08:00","value":{"chn":82,"usa":82}},{"datetime":"2021-11-25T07:00+08:00","value":{"chn":84,"usa":84}},{"datetime":"2021-11-25T08:00+08:00","value":{"chn":86,"usa":86}},{"datetime":"2021-11-25T09:00+08:00","value":{"chn":87,"usa":87}},{"datetime":"2021-11-25T10:00+08:00","value":{"chn":87,"usa":87}},{"datetime":"2021-11-25T11:00+08:00","value":{"chn":87,"usa":87}},{"datetime":"2021-11-25T12:00+08:00","value":{"chn":85,"usa":85}},{"datetime":"2021-11-25T13:00+08:00","value":{"chn":81,"usa":81}},{"datetime":"2021-11-25T14:00+08:00","value":{"chn":76,"usa":76}},{"datetime":"2021-11-25T15:00+08:00","value":{"chn":72,"usa":72}},{"datetime":"2021-11-25T16:00+08:00","value":{"chn":69,"usa":69}},{"datetime":"2021-11-25T17:00+08:00","value":{"chn":69,"usa":69}},{"datetime":"2021-11-25T18:00+08:00","value":{"chn":70,"usa":70}},{"datetime":"2021-11-25T19:00+08:00","value":{"chn":72,"usa":72}},{"datetime":"2021-11-25T20:00+08:00","value":{"chn":75,"usa":75}},{"datetime":"2021-11-25T21:00+08:00","value":{"chn":77,"usa":77}},{"datetime":"2021-11-25T22:00+08:00","value":{"chn":79,"usa":79}},{"datetime":"2021-11-25T23:00+08:00","value":{"chn":79,"usa":79}},{"datetime":"2021-11-26T00:00+08:00","value":{"chn":79,"usa":79}},{"datetime":"2021-11-26T01:00+08:00","value":{"chn":79,"usa":79}},{"datetime":"2021-11-26T02:00+08:00","value":{"chn":81,"usa":81}},{"datetime":"2021-11-26T03:00+08:00","value":{"chn":84,"usa":84}},{"datetime":"2021-11-26T04:00+08:00","value":{"chn":86,"usa":86}},{"datetime":"2021-11-26T05:00+08:00","value":{"chn":89,"usa":89}},{"datetime":"2021-11-26T06:00+08:00","value":{"chn":91,"usa":91}},{"datetime":"2021-11-26T07:00+08:00","value":{"chn":94,"usa":94}},{"datetime":"2021-11-26T08:00+08:00","value":{"chn":96,"usa":96}},{"datetime":"2021-11-26T09:00+08:00","value":{"chn":99,"usa":99}}],"pm25":[{"datetime":"2021-11-24T10:00+08:00","value":32},{"datetime":"2021-11-24T11:00+08:00","value":55},{"datetime":"2021-11-24T12:00+08:00","value":54},{"datetime":"2021-11-24T13:00+08:00","value":52},{"datetime":"2021-11-24T14:00+08:00","value":49},{"datetime":"2021-11-24T15:00+08:00","value":46},{"datetime":"2021-11-24T16:00+08:00","value":44},{"datetime":"2021-11-24T17:00+08:00","value":42},{"datetime":"2021-11-24T18:00+08:00","value":41},{"datetime":"2021-11-24T19:00+08:00","value":41},{"datetime":"2021-11-24T20:00+08:00","value":43},{"datetime":"2021-11-24T21:00+08:00","value":45},{"datetime":"2021-11-24T22:00+08:00","value":48},{"datetime":"2021-11-24T23:00+08:00","value":51},{"datetime":"2021-11-25T00:00+08:00","value":53},{"datetime":"2021-11-25T01:00+08:00","value":54},{"datetime":"2021-11-25T02:00+08:00","value":56},{"datetime":"2021-11-25T03:00+08:00","value":57},{"datetime":"2021-11-25T04:00+08:00","value":58},{"datetime":"2021-11-25T05:00+08:00","value":59},{"datetime":"2021-11-25T06:00+08:00","value":61},{"datetime":"2021-11-25T07:00+08:00","value":62},{"datetime":"2021-11-25T08:00+08:00","value":64},{"datetime":"2021-11-25T09:00+08:00","value":65},{"datetime":"2021-11-25T10:00+08:00","value":65},{"datetime":"2021-11-25T11:00+08:00","value":65},{"datetime":"2021-11-25T12:00+08:00","value":63},{"datetime":"2021-11-25T13:00+08:00","value":60},{"datetime":"2021-11-25T14:00+08:00","value":56},{"datetime":"2021-11-25T15:00+08:00","value":53},{"datetime":"2021-11-25T16:00+08:00","value":50},{"datetime":"2021-11-25T17:00+08:00","value":50},{"datetime":"2021-11-25T18:00+08:00","value":51},{"datetime":"2021-11-25T19:00+08:00","value":53},{"datetime":"2021-11-25T20:00+08:00","value":55},{"datetime":"2021-11-25T21:00+08:00","value":57},{"datetime":"2021-11-25T22:00+08:00","value":58},{"datetime":"2021-11-25T23:00+08:00","value":58},{"datetime":"2021-11-26T00:00+08:00","value":58},{"datetime":"2021-11-26T01:00+08:00","value":58},{"datetime":"2021-11-26T02:00+08:00","value":60},{"datetime":"2021-11-26T03:00+08:00","value":62},{"datetime":"2021-11-26T04:00+08:00","value":64},{"datetime":"2021-11-26T05:00+08:00","value":66},{"datetime":"2021-11-26T06:00+08:00","value":68},{"datetime":"2021-11-26T07:00+08:00","value":70},{"datetime":"2021-11-26T08:00+08:00","value":72},{"datetime":"2021-11-26T09:00+08:00","value":74}]}},"daily":{"status":"ok","astro":[{"date":"2021-11-24T00:00+08:00","sunrise":{"time":"07:12"},"sunset":{"time":"17:19"}},{"date":"2021-11-25T00:00+08:00","sunrise":{"time":"07:13"},"sunset":{"time":"17:19"}},{"date":"2021-11-26T00:00+08:00","sunrise":{"time":"07:14"},"sunset":{"time":"17:19"}},{"date":"2021-11-27T00:00+08:00","sunrise":{"time":"07:15"},"sunset":{"time":"17:18"}},{"date":"2021-11-28T00:00+08:00","sunrise":{"time":"07:16"},"sunset":{"time":"17:18"}}],"precipitation":[{"date":"2021-11-24T00:00+08:00","max":0,"min":0,"avg":0},{"date":"2021-11-25T00:00+08:00","max":0,"min":0,"avg":0},{"date":"2021-11-26T00:00+08:00","max":0,"min":0,"avg":0},{"date":"2021-11-27T00:00+08:00","max":0,"min":0,"avg":0},{"date":"2021-11-28T00:00+08:00","max":0,"min":0,"avg":0}],"temperature":[{"date":"2021-11-24T00:00+08:00","max":15.5,"min":1,"avg":10.39},{"date":"2021-11-25T00:00+08:00","max":16,"min":3,"avg":9.3},{"date":"2021-11-26T00:00+08:00","max":13,"min":3,"avg":7.77},{"date":"2021-11-27T00:00+08:00","max":11,"min":4,"avg":7.67},{"date":"2021-11-28T00:00+08:00","max":14,"min":6,"avg":9.56}],"wind":[{"date":"2021-11-24T00:00+08:00","max":{"speed":16.07,"direction":278.95},"min":{"speed":6.12,"direction":249},"avg":{"speed":10.43,"direction":296.25}},{"date":"2021-11-25T00:00+08:00","max":{"speed":10.09,"direction":317.73},"min":{"speed":2.64,"direction":273.84},"avg":{"speed":7.21,"direction":313.74}},{"date":"2021-11-26T00:00+08:00","max":{"speed":10.73,"direction":115.85},"min":{"speed":4.85,"direction":12.59},"avg":{"speed":7.74,"direction":45.25}},{"date":"2021-11-27T00:00+08:00","max":{"speed":10.72,"direction":57.83},"min":{"speed":4.15,"direction":65.38},"avg":{"speed":6.34,"direction":72.65}},{"date":"2021-11-28T00:00+08:00","max":{"speed":6.65,"direction":109.12},"min":{"speed":1.61,"direction":239.12},"avg":{"speed":4.62,"direction":44.3}}],"humidity":[{"date":"2021-11-24T00:00+08:00","max":0.44,"min":0.2,"avg":0.29},{"date":"2021-11-25T00:00+08:00","max":0.37,"min":0.2,"avg":0.31},{"date":"2021-11-26T00:00+08:00","max":0.49,"min":0.29,"avg":0.38},{"date":"2021-11-27T00:00+08:00","max":0.61,"min":0.42,"avg":0.51},{"date":"2021-11-28T00:00+08:00","max":0.79,"min":0.52,"avg":0.66}],"cloudrate":[{"date":"2021-11-24T00:00+08:00","max":0,"min":0,"avg":0},{"date":"2021-11-25T00:00+08:00","max":0,"min":0,"avg":0},{"date":"2021-11-26T00:00+08:00","max":1,"min":0,"avg":0.41},{"date":"2021-11-27T00:00+08:00","max":1,"min":0.85,"avg":0.99},{"date":"2021-11-28T00:00+08:00","max":0.94,"min":0.05,"avg":0.27}],"pressure":[{"date":"2021-11-24T00:00+08:00","max":97994.62,"min":97506.56,"avg":97691.33},{"date":"2021-11-25T00:00+08:00","max":98164.99,"min":97764.99,"avg":97930.39},{"date":"2021-11-26T00:00+08:00","max":98753.79,"min":98219.39,"avg":98544.53},{"date":"2021-11-27T00:00+08:00","max":98769.02,"min":98360.96,"avg":98576.15},{"date":"2021-11-28T00:00+08:00","max":98513.79,"min":98219.39,"avg":98389.3}],"visibility":[{"date":"2021-11-24T00:00+08:00","max":24.13,"min":4.48,"avg":7.4},{"date":"2021-11-25T00:00+08:00","max":5.6,"min":3.2,"avg":4.17},{"date":"2021-11-26T00:00+08:00","max":4,"min":2.49,"avg":3.06},{"date":"2021-11-27T00:00+08:00","max":2.8,"min":2.11,"avg":2.44},{"date":"2021-11-28T00:00+08:00","max":3.73,"min":1.25,"avg":2.59}],"dswrf":[{"date":"2021-11-24T00:00+08:00","max":458.2,"min":0,"avg":249.2},{"date":"2021-11-25T00:00+08:00","max":448.9,"min":0,"avg":149.8},{"date":"2021-11-26T00:00+08:00","max":439.3,"min":0,"avg":142.2},{"date":"2021-11-27T00:00+08:00","max":242.1,"min":0,"avg":74.4},{"date":"2021-11-28T00:00+08:00","max":412.6,"min":0,"avg":136.5}],"air_quality":{"aqi":[{"date":"2021-11-24T00:00+08:00","max":{"chn":103,"usa":103},"avg":{"chn":65.14,"usa":65.14},"min":{"chn":57,"usa":57}},{"date":"2021-11-25T00:00+08:00","max":{"chn":87,"usa":87},"avg":{"chn":78.12,"usa":78.12},"min":{"chn":69,"usa":69}},{"date":"2021-11-26T00:00+08:00","max":{"chn":100,"usa":100},"avg":{"chn":90.17,"usa":90.17},"min":{"chn":79,"usa":79}},{"date":"2021-11-27T00:00+08:00","max":{"chn":110,"usa":110},"avg":{"chn":101.38,"usa":101.38},"min":{"chn":94,"usa":94}},{"date":"2021-11-28T00:00+08:00","max":{"chn":110,"usa":110},"avg":{"chn":94.42,"usa":94.42},"min":{"chn":81,"usa":81}}],"pm25":[{"date":"2021-11-24T00:00+08:00","max":56,"avg":45.93,"min":32},{"date":"2021-11-25T00:00+08:00","max":65,"avg":57.62,"min":50},{"date":"2021-11-26T00:00+08:00","max":75,"avg":67.21,"min":58},{"date":"2021-11-27T00:00+08:00","max":83,"avg":76.21,"min":70},{"date":"2021-11-28T00:00+08:00","max":83,"avg":70.67,"min":60}]},"skycon":[{"date":"2021-11-24T00:00+08:00","value":"CLEAR_DAY"},{"date":"2021-11-25T00:00+08:00","value":"CLEAR_DAY"},{"date":"2021-11-26T00:00+08:00","value":"PARTLY_CLOUDY_DAY"},{"date":"2021-11-27T00:00+08:00","value":"LIGHT_HAZE"},{"date":"2021-11-28T00:00+08:00","value":"PARTLY_CLOUDY_DAY"}],"skycon_08h_20h":[{"date":"2021-11-24T00:00+08:00","value":"CLEAR_DAY"},{"date":"2021-11-25T00:00+08:00","value":"CLEAR_DAY"},{"date":"2021-11-26T00:00+08:00","value":"PARTLY_CLOUDY_DAY"},{"date":"2021-11-27T00:00+08:00","value":"LIGHT_HAZE"},{"date":"2021-11-28T00:00+08:00","value":"CLEAR_DAY"}],"skycon_20h_32h":[{"date":"2021-11-24T00:00+08:00","value":"CLEAR_NIGHT"},{"date":"2021-11-25T00:00+08:00","value":"CLEAR_NIGHT"},{"date":"2021-11-26T00:00+08:00","value":"CLOUDY"},{"date":"2021-11-27T00:00+08:00","value":"PARTLY_CLOUDY_NIGHT"},{"date":"2021-11-28T00:00+08:00","value":"PARTLY_CLOUDY_NIGHT"}],"life_index":{"ultraviolet":[{"date":"2021-11-24T00:00+08:00","index":"4","desc":"强"},{"date":"2021-11-25T00:00+08:00","index":"4","desc":"强"},{"date":"2021-11-26T00:00+08:00","index":"4","desc":"强"},{"date":"2021-11-27T00:00+08:00","index":"1","desc":"最弱"},{"date":"2021-11-28T00:00+08:00","index":"4","desc":"强"}],"carWashing":[{"date":"2021-11-24T00:00+08:00","index":"2","desc":"较适宜"},{"date":"2021-11-25T00:00+08:00","index":"2","desc":"较适宜"},{"date":"2021-11-26T00:00+08:00","index":"2","desc":"较适宜"},{"date":"2021-11-27T00:00+08:00","index":"2","desc":"较适宜"},{"date":"2021-11-28T00:00+08:00","index":"2","desc":"较适宜"}],"dressing":[{"date":"2021-11-24T00:00+08:00","index":"5","desc":"凉爽"},{"date":"2021-11-25T00:00+08:00","index":"6","desc":"冷"},{"date":"2021-11-26T00:00+08:00","index":"6","desc":"冷"},{"date":"2021-11-27T00:00+08:00","index":"6","desc":"冷"},{"date":"2021-11-28T00:00+08:00","index":"6","desc":"冷"}],"comfort":[{"date":"2021-11-24T00:00+08:00","index":"8","desc":"很冷"},{"date":"2021-11-25T00:00+08:00","index":"8","desc":"很冷"},{"date":"2021-11-26T00:00+08:00","index":"8","desc":"很冷"},{"date":"2021-11-27T00:00+08:00","index":"8","desc":"很冷"},{"date":"2021-11-28T00:00+08:00","index":"8","desc":"很冷"}],"coldRisk":[{"date":"2021-11-24T00:00+08:00","index":"4","desc":"极易发"},{"date":"2021-11-25T00:00+08:00","index":"4","desc":"极易发"},{"date":"2021-11-26T00:00+08:00","index":"4","desc":"极易发"},{"date":"2021-11-27T00:00+08:00","index":"3","desc":"易发"},{"date":"2021-11-28T00:00+08:00","index":"4","desc":"极易发"}]}},"primary":0,"forecast_keypoint":"未来两小时不会下雨，放心出门吧"}
     */

    private String status;
    private String api_version;
    private String api_status;
    private String lang;
    private String unit;
    private int tzshift;
    private String timezone;
    private int server_time;
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

    public int getTzshift() {
        return tzshift;
    }

    public void setTzshift(int tzshift) {
        this.tzshift = tzshift;
    }

    public String getTimezone() {
        return timezone;
    }

    public void setTimezone(String timezone) {
        this.timezone = timezone;
    }

    public int getServer_time() {
        return server_time;
    }

    public void setServer_time(int server_time) {
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
         * alert : {"status":"ok","content":[{"province":"河南省","status":"预警中","code":"0501","description":"济源市气象台2021年11月24日09时15分发布大风蓝色预警信号：预计今天白天，我市邵原、王屋、下冶、克井、五龙口等镇将有5到6级西北风，局部阵风7到8级。请注意做好防灾减灾和安全生产工作。","regionId":"101181801","county":"济源市","pubtimestamp":1637717036,"latlon":[35.067243,112.601918],"city":"济源市","alertId":"41900141600000_20211124092356","title":"济源市气象台发布大风蓝色预警[IV级/一般]","adcode":"419001","source":"国家预警信息发布中心","location":"河南省济源市济源市","request_status":"ok"}]}
         * realtime : {"status":"ok","temperature":9,"humidity":0.33,"cloudrate":0,"skycon":"CLEAR_DAY","visibility":11.2,"dswrf":271.5,"wind":{"speed":6.12,"direction":249},"pressure":97873.79,"apparent_temperature":6.3,"precipitation":{"local":{"status":"ok","datasource":"radar","intensity":0},"nearest":{"status":"ok","distance":137.52,"intensity":0.1875}},"air_quality":{"pm25":32,"pm10":87,"o3":16,"so2":1,"no2":43,"co":0.6,"aqi":{"chn":69,"usa":69},"description":{"chn":"良","usa":"良"}},"life_index":{"ultraviolet":{"index":5,"desc":"中等"},"comfort":{"index":8,"desc":"很冷"}}}
         * minutely : {"status":"ok","datasource":"radar","precipitation_2h":[0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0],"precipitation":[0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0],"probability":[0,0,0,0],"description":"未来两小时不会下雨，放心出门吧"}
         * hourly : {"status":"ok","description":"未来24小时晴","precipitation":[{"datetime":"2021-11-24T10:00+08:00","value":0},{"datetime":"2021-11-24T11:00+08:00","value":0},{"datetime":"2021-11-24T12:00+08:00","value":0},{"datetime":"2021-11-24T13:00+08:00","value":0},{"datetime":"2021-11-24T14:00+08:00","value":0},{"datetime":"2021-11-24T15:00+08:00","value":0},{"datetime":"2021-11-24T16:00+08:00","value":0},{"datetime":"2021-11-24T17:00+08:00","value":0},{"datetime":"2021-11-24T18:00+08:00","value":0},{"datetime":"2021-11-24T19:00+08:00","value":0},{"datetime":"2021-11-24T20:00+08:00","value":0},{"datetime":"2021-11-24T21:00+08:00","value":0},{"datetime":"2021-11-24T22:00+08:00","value":0},{"datetime":"2021-11-24T23:00+08:00","value":0},{"datetime":"2021-11-25T00:00+08:00","value":0},{"datetime":"2021-11-25T01:00+08:00","value":0},{"datetime":"2021-11-25T02:00+08:00","value":0},{"datetime":"2021-11-25T03:00+08:00","value":0},{"datetime":"2021-11-25T04:00+08:00","value":0},{"datetime":"2021-11-25T05:00+08:00","value":0},{"datetime":"2021-11-25T06:00+08:00","value":0},{"datetime":"2021-11-25T07:00+08:00","value":0},{"datetime":"2021-11-25T08:00+08:00","value":0},{"datetime":"2021-11-25T09:00+08:00","value":0},{"datetime":"2021-11-25T10:00+08:00","value":0},{"datetime":"2021-11-25T11:00+08:00","value":0},{"datetime":"2021-11-25T12:00+08:00","value":0},{"datetime":"2021-11-25T13:00+08:00","value":0},{"datetime":"2021-11-25T14:00+08:00","value":0},{"datetime":"2021-11-25T15:00+08:00","value":0},{"datetime":"2021-11-25T16:00+08:00","value":0},{"datetime":"2021-11-25T17:00+08:00","value":0},{"datetime":"2021-11-25T18:00+08:00","value":0},{"datetime":"2021-11-25T19:00+08:00","value":0},{"datetime":"2021-11-25T20:00+08:00","value":0},{"datetime":"2021-11-25T21:00+08:00","value":0},{"datetime":"2021-11-25T22:00+08:00","value":0},{"datetime":"2021-11-25T23:00+08:00","value":0},{"datetime":"2021-11-26T00:00+08:00","value":0},{"datetime":"2021-11-26T01:00+08:00","value":0},{"datetime":"2021-11-26T02:00+08:00","value":0},{"datetime":"2021-11-26T03:00+08:00","value":0},{"datetime":"2021-11-26T04:00+08:00","value":0},{"datetime":"2021-11-26T05:00+08:00","value":0},{"datetime":"2021-11-26T06:00+08:00","value":0},{"datetime":"2021-11-26T07:00+08:00","value":0},{"datetime":"2021-11-26T08:00+08:00","value":0},{"datetime":"2021-11-26T09:00+08:00","value":0}],"temperature":[{"datetime":"2021-11-24T10:00+08:00","value":9},{"datetime":"2021-11-24T11:00+08:00","value":11.5},{"datetime":"2021-11-24T12:00+08:00","value":13},{"datetime":"2021-11-24T13:00+08:00","value":13.5},{"datetime":"2021-11-24T14:00+08:00","value":15},{"datetime":"2021-11-24T15:00+08:00","value":15.5},{"datetime":"2021-11-24T16:00+08:00","value":15},{"datetime":"2021-11-24T17:00+08:00","value":14},{"datetime":"2021-11-24T18:00+08:00","value":8},{"datetime":"2021-11-24T19:00+08:00","value":8},{"datetime":"2021-11-24T20:00+08:00","value":7.5},{"datetime":"2021-11-24T21:00+08:00","value":6.2},{"datetime":"2021-11-24T22:00+08:00","value":5.1},{"datetime":"2021-11-24T23:00+08:00","value":4.2},{"datetime":"2021-11-25T00:00+08:00","value":3.5},{"datetime":"2021-11-25T01:00+08:00","value":3.4},{"datetime":"2021-11-25T02:00+08:00","value":3.3},{"datetime":"2021-11-25T03:00+08:00","value":3},{"datetime":"2021-11-25T04:00+08:00","value":3},{"datetime":"2021-11-25T05:00+08:00","value":3},{"datetime":"2021-11-25T06:00+08:00","value":4.3},{"datetime":"2021-11-25T07:00+08:00","value":5.6},{"datetime":"2021-11-25T08:00+08:00","value":6.9},{"datetime":"2021-11-25T09:00+08:00","value":8.2},{"datetime":"2021-11-25T10:00+08:00","value":9.5},{"datetime":"2021-11-25T11:00+08:00","value":10.8},{"datetime":"2021-11-25T12:00+08:00","value":12.1},{"datetime":"2021-11-25T13:00+08:00","value":13.4},{"datetime":"2021-11-25T14:00+08:00","value":14.7},{"datetime":"2021-11-25T15:00+08:00","value":16},{"datetime":"2021-11-25T16:00+08:00","value":15.9},{"datetime":"2021-11-25T17:00+08:00","value":15.26},{"datetime":"2021-11-25T18:00+08:00","value":14.48},{"datetime":"2021-11-25T19:00+08:00","value":13.73},{"datetime":"2021-11-25T20:00+08:00","value":12.82},{"datetime":"2021-11-25T21:00+08:00","value":11.86},{"datetime":"2021-11-25T22:00+08:00","value":10.04},{"datetime":"2021-11-25T23:00+08:00","value":8.4},{"datetime":"2021-11-26T00:00+08:00","value":6.95},{"datetime":"2021-11-26T01:00+08:00","value":5.59},{"datetime":"2021-11-26T02:00+08:00","value":4.93},{"datetime":"2021-11-26T03:00+08:00","value":4.43},{"datetime":"2021-11-26T04:00+08:00","value":3.96},{"datetime":"2021-11-26T05:00+08:00","value":4.29},{"datetime":"2021-11-26T06:00+08:00","value":4.74},{"datetime":"2021-11-26T07:00+08:00","value":3},{"datetime":"2021-11-26T08:00+08:00","value":6.15},{"datetime":"2021-11-26T09:00+08:00","value":6.49}],"wind":[{"datetime":"2021-11-24T10:00+08:00","speed":6.12,"direction":249},{"datetime":"2021-11-24T11:00+08:00","speed":13.27,"direction":287.02},{"datetime":"2021-11-24T12:00+08:00","speed":15.34,"direction":289.68},{"datetime":"2021-11-24T13:00+08:00","speed":15.67,"direction":283.13},{"datetime":"2021-11-24T14:00+08:00","speed":16.07,"direction":278.95},{"datetime":"2021-11-24T15:00+08:00","speed":15.88,"direction":285.56},{"datetime":"2021-11-24T16:00+08:00","speed":15.41,"direction":286.24},{"datetime":"2021-11-24T17:00+08:00","speed":14.69,"direction":290.31},{"datetime":"2021-11-24T18:00+08:00","speed":11.67,"direction":302.78},{"datetime":"2021-11-24T19:00+08:00","speed":11.06,"direction":311.28},{"datetime":"2021-11-24T20:00+08:00","speed":10.09,"direction":316.82},{"datetime":"2021-11-24T21:00+08:00","speed":8.92,"direction":321.05},{"datetime":"2021-11-24T22:00+08:00","speed":8.6,"direction":318.83},{"datetime":"2021-11-24T23:00+08:00","speed":8.84,"direction":321.11},{"datetime":"2021-11-25T00:00+08:00","speed":8.89,"direction":317.62},{"datetime":"2021-11-25T01:00+08:00","speed":8.98,"direction":316.35},{"datetime":"2021-11-25T02:00+08:00","speed":9.22,"direction":320.3},{"datetime":"2021-11-25T03:00+08:00","speed":8.84,"direction":321.42},{"datetime":"2021-11-25T04:00+08:00","speed":9.18,"direction":318.77},{"datetime":"2021-11-25T05:00+08:00","speed":10.09,"direction":317.73},{"datetime":"2021-11-25T06:00+08:00","speed":9.79,"direction":317.49},{"datetime":"2021-11-25T07:00+08:00","speed":9.12,"direction":313.78},{"datetime":"2021-11-25T08:00+08:00","speed":8.25,"direction":312.08},{"datetime":"2021-11-25T09:00+08:00","speed":6.65,"direction":312.58},{"datetime":"2021-11-25T10:00+08:00","speed":6.01,"direction":311.13},{"datetime":"2021-11-25T11:00+08:00","speed":5.35,"direction":303.19},{"datetime":"2021-11-25T12:00+08:00","speed":5.96,"direction":308.42},{"datetime":"2021-11-25T13:00+08:00","speed":5.9,"direction":320.02},{"datetime":"2021-11-25T14:00+08:00","speed":4.67,"direction":308.41},{"datetime":"2021-11-25T15:00+08:00","speed":4.49,"direction":290.65},{"datetime":"2021-11-25T16:00+08:00","speed":2.87,"direction":266.4},{"datetime":"2021-11-25T17:00+08:00","speed":2.64,"direction":273.84},{"datetime":"2021-11-25T18:00+08:00","speed":5.6,"direction":304.61},{"datetime":"2021-11-25T19:00+08:00","speed":7.57,"direction":313.94},{"datetime":"2021-11-25T20:00+08:00","speed":7.99,"direction":320.74},{"datetime":"2021-11-25T21:00+08:00","speed":8.42,"direction":321.8},{"datetime":"2021-11-25T22:00+08:00","speed":8.47,"direction":316.61},{"datetime":"2021-11-25T23:00+08:00","speed":8.2,"direction":316.62},{"datetime":"2021-11-26T00:00+08:00","speed":8.33,"direction":322.24},{"datetime":"2021-11-26T01:00+08:00","speed":8.82,"direction":327.97},{"datetime":"2021-11-26T02:00+08:00","speed":9.46,"direction":330.66},{"datetime":"2021-11-26T03:00+08:00","speed":9.61,"direction":331.18},{"datetime":"2021-11-26T04:00+08:00","speed":9.52,"direction":333.51},{"datetime":"2021-11-26T05:00+08:00","speed":9.08,"direction":341.28},{"datetime":"2021-11-26T06:00+08:00","speed":8.01,"direction":350.55},{"datetime":"2021-11-26T07:00+08:00","speed":6.76,"direction":351.18},{"datetime":"2021-11-26T08:00+08:00","speed":6.89,"direction":359.19},{"datetime":"2021-11-26T09:00+08:00","speed":4.85,"direction":12.59}],"humidity":[{"datetime":"2021-11-24T10:00+08:00","value":0.33},{"datetime":"2021-11-24T11:00+08:00","value":0.27},{"datetime":"2021-11-24T12:00+08:00","value":0.23},{"datetime":"2021-11-24T13:00+08:00","value":0.2},{"datetime":"2021-11-24T14:00+08:00","value":0.2},{"datetime":"2021-11-24T15:00+08:00","value":0.21},{"datetime":"2021-11-24T16:00+08:00","value":0.25},{"datetime":"2021-11-24T17:00+08:00","value":0.29},{"datetime":"2021-11-24T18:00+08:00","value":0.31},{"datetime":"2021-11-24T19:00+08:00","value":0.33},{"datetime":"2021-11-24T20:00+08:00","value":0.34},{"datetime":"2021-11-24T21:00+08:00","value":0.35},{"datetime":"2021-11-24T22:00+08:00","value":0.35},{"datetime":"2021-11-24T23:00+08:00","value":0.36},{"datetime":"2021-11-25T00:00+08:00","value":0.36},{"datetime":"2021-11-25T01:00+08:00","value":0.36},{"datetime":"2021-11-25T02:00+08:00","value":0.36},{"datetime":"2021-11-25T03:00+08:00","value":0.36},{"datetime":"2021-11-25T04:00+08:00","value":0.36},{"datetime":"2021-11-25T05:00+08:00","value":0.36},{"datetime":"2021-11-25T06:00+08:00","value":0.36},{"datetime":"2021-11-25T07:00+08:00","value":0.36},{"datetime":"2021-11-25T08:00+08:00","value":0.37},{"datetime":"2021-11-25T09:00+08:00","value":0.34},{"datetime":"2021-11-25T10:00+08:00","value":0.28},{"datetime":"2021-11-25T11:00+08:00","value":0.25},{"datetime":"2021-11-25T12:00+08:00","value":0.23},{"datetime":"2021-11-25T13:00+08:00","value":0.21},{"datetime":"2021-11-25T14:00+08:00","value":0.2},{"datetime":"2021-11-25T15:00+08:00","value":0.21},{"datetime":"2021-11-25T16:00+08:00","value":0.27},{"datetime":"2021-11-25T17:00+08:00","value":0.3},{"datetime":"2021-11-25T18:00+08:00","value":0.3},{"datetime":"2021-11-25T19:00+08:00","value":0.31},{"datetime":"2021-11-25T20:00+08:00","value":0.32},{"datetime":"2021-11-25T21:00+08:00","value":0.33},{"datetime":"2021-11-25T22:00+08:00","value":0.35},{"datetime":"2021-11-25T23:00+08:00","value":0.36},{"datetime":"2021-11-26T00:00+08:00","value":0.36},{"datetime":"2021-11-26T01:00+08:00","value":0.37},{"datetime":"2021-11-26T02:00+08:00","value":0.37},{"datetime":"2021-11-26T03:00+08:00","value":0.38},{"datetime":"2021-11-26T04:00+08:00","value":0.38},{"datetime":"2021-11-26T05:00+08:00","value":0.39},{"datetime":"2021-11-26T06:00+08:00","value":0.4},{"datetime":"2021-11-26T07:00+08:00","value":0.4},{"datetime":"2021-11-26T08:00+08:00","value":0.41},{"datetime":"2021-11-26T09:00+08:00","value":0.37}],"cloudrate":[{"datetime":"2021-11-24T10:00+08:00","value":0},{"datetime":"2021-11-24T11:00+08:00","value":0},{"datetime":"2021-11-24T12:00+08:00","value":0},{"datetime":"2021-11-24T13:00+08:00","value":0},{"datetime":"2021-11-24T14:00+08:00","value":0},{"datetime":"2021-11-24T15:00+08:00","value":0},{"datetime":"2021-11-24T16:00+08:00","value":0},{"datetime":"2021-11-24T17:00+08:00","value":0},{"datetime":"2021-11-24T18:00+08:00","value":0},{"datetime":"2021-11-24T19:00+08:00","value":0},{"datetime":"2021-11-24T20:00+08:00","value":0},{"datetime":"2021-11-24T21:00+08:00","value":0},{"datetime":"2021-11-24T22:00+08:00","value":0},{"datetime":"2021-11-24T23:00+08:00","value":0},{"datetime":"2021-11-25T00:00+08:00","value":0},{"datetime":"2021-11-25T01:00+08:00","value":0},{"datetime":"2021-11-25T02:00+08:00","value":0},{"datetime":"2021-11-25T03:00+08:00","value":0},{"datetime":"2021-11-25T04:00+08:00","value":0},{"datetime":"2021-11-25T05:00+08:00","value":0},{"datetime":"2021-11-25T06:00+08:00","value":0},{"datetime":"2021-11-25T07:00+08:00","value":0},{"datetime":"2021-11-25T08:00+08:00","value":0},{"datetime":"2021-11-25T09:00+08:00","value":0},{"datetime":"2021-11-25T10:00+08:00","value":0},{"datetime":"2021-11-25T11:00+08:00","value":0},{"datetime":"2021-11-25T12:00+08:00","value":0},{"datetime":"2021-11-25T13:00+08:00","value":0},{"datetime":"2021-11-25T14:00+08:00","value":0},{"datetime":"2021-11-25T15:00+08:00","value":0},{"datetime":"2021-11-25T16:00+08:00","value":0},{"datetime":"2021-11-25T17:00+08:00","value":0},{"datetime":"2021-11-25T18:00+08:00","value":0},{"datetime":"2021-11-25T19:00+08:00","value":0},{"datetime":"2021-11-25T20:00+08:00","value":0},{"datetime":"2021-11-25T21:00+08:00","value":0},{"datetime":"2021-11-25T22:00+08:00","value":0},{"datetime":"2021-11-25T23:00+08:00","value":0},{"datetime":"2021-11-26T00:00+08:00","value":0},{"datetime":"2021-11-26T01:00+08:00","value":0},{"datetime":"2021-11-26T02:00+08:00","value":0},{"datetime":"2021-11-26T03:00+08:00","value":0},{"datetime":"2021-11-26T04:00+08:00","value":0},{"datetime":"2021-11-26T05:00+08:00","value":0},{"datetime":"2021-11-26T06:00+08:00","value":0},{"datetime":"2021-11-26T07:00+08:00","value":0},{"datetime":"2021-11-26T08:00+08:00","value":0.04},{"datetime":"2021-11-26T09:00+08:00","value":0.07}],"skycon":[{"datetime":"2021-11-24T10:00+08:00","value":"CLEAR_DAY"},{"datetime":"2021-11-24T11:00+08:00","value":"CLEAR_DAY"},{"datetime":"2021-11-24T12:00+08:00","value":"CLEAR_DAY"},{"datetime":"2021-11-24T13:00+08:00","value":"CLEAR_DAY"},{"datetime":"2021-11-24T14:00+08:00","value":"CLEAR_DAY"},{"datetime":"2021-11-24T15:00+08:00","value":"CLEAR_DAY"},{"datetime":"2021-11-24T16:00+08:00","value":"CLEAR_DAY"},{"datetime":"2021-11-24T17:00+08:00","value":"CLEAR_DAY"},{"datetime":"2021-11-24T18:00+08:00","value":"CLEAR_NIGHT"},{"datetime":"2021-11-24T19:00+08:00","value":"CLEAR_NIGHT"},{"datetime":"2021-11-24T20:00+08:00","value":"CLEAR_NIGHT"},{"datetime":"2021-11-24T21:00+08:00","value":"CLEAR_NIGHT"},{"datetime":"2021-11-24T22:00+08:00","value":"CLEAR_NIGHT"},{"datetime":"2021-11-24T23:00+08:00","value":"CLEAR_NIGHT"},{"datetime":"2021-11-25T00:00+08:00","value":"CLEAR_NIGHT"},{"datetime":"2021-11-25T01:00+08:00","value":"CLEAR_NIGHT"},{"datetime":"2021-11-25T02:00+08:00","value":"CLEAR_NIGHT"},{"datetime":"2021-11-25T03:00+08:00","value":"CLEAR_NIGHT"},{"datetime":"2021-11-25T04:00+08:00","value":"CLEAR_NIGHT"},{"datetime":"2021-11-25T05:00+08:00","value":"CLEAR_NIGHT"},{"datetime":"2021-11-25T06:00+08:00","value":"CLEAR_NIGHT"},{"datetime":"2021-11-25T07:00+08:00","value":"CLEAR_NIGHT"},{"datetime":"2021-11-25T08:00+08:00","value":"CLEAR_DAY"},{"datetime":"2021-11-25T09:00+08:00","value":"CLEAR_DAY"},{"datetime":"2021-11-25T10:00+08:00","value":"CLEAR_DAY"},{"datetime":"2021-11-25T11:00+08:00","value":"CLEAR_DAY"},{"datetime":"2021-11-25T12:00+08:00","value":"CLEAR_DAY"},{"datetime":"2021-11-25T13:00+08:00","value":"CLEAR_DAY"},{"datetime":"2021-11-25T14:00+08:00","value":"CLEAR_DAY"},{"datetime":"2021-11-25T15:00+08:00","value":"CLEAR_DAY"},{"datetime":"2021-11-25T16:00+08:00","value":"CLEAR_DAY"},{"datetime":"2021-11-25T17:00+08:00","value":"CLEAR_DAY"},{"datetime":"2021-11-25T18:00+08:00","value":"CLEAR_NIGHT"},{"datetime":"2021-11-25T19:00+08:00","value":"CLEAR_NIGHT"},{"datetime":"2021-11-25T20:00+08:00","value":"CLEAR_NIGHT"},{"datetime":"2021-11-25T21:00+08:00","value":"CLEAR_NIGHT"},{"datetime":"2021-11-25T22:00+08:00","value":"CLEAR_NIGHT"},{"datetime":"2021-11-25T23:00+08:00","value":"CLEAR_NIGHT"},{"datetime":"2021-11-26T00:00+08:00","value":"CLEAR_NIGHT"},{"datetime":"2021-11-26T01:00+08:00","value":"CLEAR_NIGHT"},{"datetime":"2021-11-26T02:00+08:00","value":"CLEAR_NIGHT"},{"datetime":"2021-11-26T03:00+08:00","value":"CLEAR_NIGHT"},{"datetime":"2021-11-26T04:00+08:00","value":"CLEAR_NIGHT"},{"datetime":"2021-11-26T05:00+08:00","value":"CLEAR_NIGHT"},{"datetime":"2021-11-26T06:00+08:00","value":"CLEAR_NIGHT"},{"datetime":"2021-11-26T07:00+08:00","value":"CLEAR_NIGHT"},{"datetime":"2021-11-26T08:00+08:00","value":"CLEAR_DAY"},{"datetime":"2021-11-26T09:00+08:00","value":"CLEAR_DAY"}],"pressure":[{"datetime":"2021-11-24T10:00+08:00","value":97873.792},{"datetime":"2021-11-24T11:00+08:00","value":97819.392},{"datetime":"2021-11-24T12:00+08:00","value":97739.392},{"datetime":"2021-11-24T13:00+08:00","value":97579.392},{"datetime":"2021-11-24T14:00+08:00","value":97545.728},{"datetime":"2021-11-24T15:00+08:00","value":97506.56},{"datetime":"2021-11-24T16:00+08:00","value":97524.992},{"datetime":"2021-11-24T17:00+08:00","value":97586.56},{"datetime":"2021-11-24T18:00+08:00","value":97659.392},{"datetime":"2021-11-24T19:00+08:00","value":97684.992},{"datetime":"2021-11-24T20:00+08:00","value":97739.392},{"datetime":"2021-11-24T21:00+08:00","value":97780.224},{"datetime":"2021-11-24T22:00+08:00","value":97819.392},{"datetime":"2021-11-24T23:00+08:00","value":97819.392},{"datetime":"2021-11-25T00:00+08:00","value":97834.624},{"datetime":"2021-11-25T01:00+08:00","value":97819.392},{"datetime":"2021-11-25T02:00+08:00","value":97819.392},{"datetime":"2021-11-25T03:00+08:00","value":97819.392},{"datetime":"2021-11-25T04:00+08:00","value":97819.392},{"datetime":"2021-11-25T05:00+08:00","value":97819.392},{"datetime":"2021-11-25T06:00+08:00","value":97834.624},{"datetime":"2021-11-25T07:00+08:00","value":97899.392},{"datetime":"2021-11-25T08:00+08:00","value":97979.392},{"datetime":"2021-11-25T09:00+08:00","value":98059.392},{"datetime":"2021-11-25T10:00+08:00","value":98059.392},{"datetime":"2021-11-25T11:00+08:00","value":98059.392},{"datetime":"2021-11-25T12:00+08:00","value":97979.392},{"datetime":"2021-11-25T13:00+08:00","value":97899.392},{"datetime":"2021-11-25T14:00+08:00","value":97819.392},{"datetime":"2021-11-25T15:00+08:00","value":97764.992},{"datetime":"2021-11-25T16:00+08:00","value":97819.392},{"datetime":"2021-11-25T17:00+08:00","value":97844.992},{"datetime":"2021-11-25T18:00+08:00","value":97924.992},{"datetime":"2021-11-25T19:00+08:00","value":98004.992},{"datetime":"2021-11-25T20:00+08:00","value":98059.392},{"datetime":"2021-11-25T21:00+08:00","value":98084.992},{"datetime":"2021-11-25T22:00+08:00","value":98139.392},{"datetime":"2021-11-25T23:00+08:00","value":98164.992},{"datetime":"2021-11-26T00:00+08:00","value":98219.392},{"datetime":"2021-11-26T01:00+08:00","value":98219.392},{"datetime":"2021-11-26T02:00+08:00","value":98260.224},{"datetime":"2021-11-26T03:00+08:00","value":98299.392},{"datetime":"2021-11-26T04:00+08:00","value":98299.392},{"datetime":"2021-11-26T05:00+08:00","value":98314.624},{"datetime":"2021-11-26T06:00+08:00","value":98394.624},{"datetime":"2021-11-26T07:00+08:00","value":98513.792},{"datetime":"2021-11-26T08:00+08:00","value":98616.192},{"datetime":"2021-11-26T09:00+08:00","value":98696.192}],"visibility":[{"datetime":"2021-11-24T10:00+08:00","value":11.2},{"datetime":"2021-11-24T11:00+08:00","value":4.48},{"datetime":"2021-11-24T12:00+08:00","value":4.67},{"datetime":"2021-11-24T13:00+08:00","value":5.09},{"datetime":"2021-11-24T14:00+08:00","value":5.89},{"datetime":"2021-11-24T15:00+08:00","value":7},{"datetime":"2021-11-24T16:00+08:00","value":8},{"datetime":"2021-11-24T17:00+08:00","value":9.33},{"datetime":"2021-11-24T18:00+08:00","value":10.18},{"datetime":"2021-11-24T19:00+08:00","value":10.18},{"datetime":"2021-11-24T20:00+08:00","value":8.62},{"datetime":"2021-11-24T21:00+08:00","value":7.47},{"datetime":"2021-11-24T22:00+08:00","value":6.22},{"datetime":"2021-11-24T23:00+08:00","value":5.33},{"datetime":"2021-11-25T00:00+08:00","value":4.87},{"datetime":"2021-11-25T01:00+08:00","value":4.67},{"datetime":"2021-11-25T02:00+08:00","value":4.31},{"datetime":"2021-11-25T03:00+08:00","value":4.15},{"datetime":"2021-11-25T04:00+08:00","value":4},{"datetime":"2021-11-25T05:00+08:00","value":3.86},{"datetime":"2021-11-25T06:00+08:00","value":3.61},{"datetime":"2021-11-25T07:00+08:00","value":3.5},{"datetime":"2021-11-25T08:00+08:00","value":3.29},{"datetime":"2021-11-25T09:00+08:00","value":3.2},{"datetime":"2021-11-25T10:00+08:00","value":3.2},{"datetime":"2021-11-25T11:00+08:00","value":3.2},{"datetime":"2021-11-25T12:00+08:00","value":3.39},{"datetime":"2021-11-25T13:00+08:00","value":3.73},{"datetime":"2021-11-25T14:00+08:00","value":4.31},{"datetime":"2021-11-25T15:00+08:00","value":4.87},{"datetime":"2021-11-25T16:00+08:00","value":5.6},{"datetime":"2021-11-25T17:00+08:00","value":5.6},{"datetime":"2021-11-25T18:00+08:00","value":5.33},{"datetime":"2021-11-25T19:00+08:00","value":4.87},{"datetime":"2021-11-25T20:00+08:00","value":4.48},{"datetime":"2021-11-25T21:00+08:00","value":4.15},{"datetime":"2021-11-25T22:00+08:00","value":4},{"datetime":"2021-11-25T23:00+08:00","value":4},{"datetime":"2021-11-26T00:00+08:00","value":4},{"datetime":"2021-11-26T01:00+08:00","value":4},{"datetime":"2021-11-26T02:00+08:00","value":3.73},{"datetime":"2021-11-26T03:00+08:00","value":3.5},{"datetime":"2021-11-26T04:00+08:00","value":3.29},{"datetime":"2021-11-26T05:00+08:00","value":3.11},{"datetime":"2021-11-26T06:00+08:00","value":2.95},{"datetime":"2021-11-26T07:00+08:00","value":2.8},{"datetime":"2021-11-26T08:00+08:00","value":2.67},{"datetime":"2021-11-26T09:00+08:00","value":2.55}],"dswrf":[{"datetime":"2021-11-24T10:00+08:00","value":271.4592},{"datetime":"2021-11-24T11:00+08:00","value":345.4592},{"datetime":"2021-11-24T12:00+08:00","value":402.9488},{"datetime":"2021-11-24T13:00+08:00","value":440.6688},{"datetime":"2021-11-24T14:00+08:00","value":458.1584},{"datetime":"2021-11-24T15:00+08:00","value":436.3296},{"datetime":"2021-11-24T16:00+08:00","value":357.6496},{"datetime":"2021-11-24T17:00+08:00","value":271.6496},{"datetime":"2021-11-24T18:00+08:00","value":204.2496},{"datetime":"2021-11-24T19:00+08:00","value":163.5696},{"datetime":"2021-11-24T20:00+08:00","value":136.08},{"datetime":"2021-11-24T21:00+08:00","value":0},{"datetime":"2021-11-24T22:00+08:00","value":0},{"datetime":"2021-11-24T23:00+08:00","value":0},{"datetime":"2021-11-25T00:00+08:00","value":0},{"datetime":"2021-11-25T01:00+08:00","value":0},{"datetime":"2021-11-25T02:00+08:00","value":0},{"datetime":"2021-11-25T03:00+08:00","value":0},{"datetime":"2021-11-25T04:00+08:00","value":0},{"datetime":"2021-11-25T05:00+08:00","value":0},{"datetime":"2021-11-25T06:00+08:00","value":0},{"datetime":"2021-11-25T07:00+08:00","value":0},{"datetime":"2021-11-25T08:00+08:00","value":3.7696},{"datetime":"2021-11-25T09:00+08:00","value":178.24},{"datetime":"2021-11-25T10:00+08:00","value":264.4992},{"datetime":"2021-11-25T11:00+08:00","value":338.2192},{"datetime":"2021-11-25T12:00+08:00","value":394.7088},{"datetime":"2021-11-25T13:00+08:00","value":431.9392},{"datetime":"2021-11-25T14:00+08:00","value":448.9392},{"datetime":"2021-11-25T15:00+08:00","value":427.3296},{"datetime":"2021-11-25T16:00+08:00","value":350.3296},{"datetime":"2021-11-25T17:00+08:00","value":265.6496},{"datetime":"2021-11-25T18:00+08:00","value":199.9696},{"datetime":"2021-11-25T19:00+08:00","value":159.5696},{"datetime":"2021-11-25T20:00+08:00","value":133.08},{"datetime":"2021-11-25T21:00+08:00","value":0},{"datetime":"2021-11-25T22:00+08:00","value":0},{"datetime":"2021-11-25T23:00+08:00","value":0},{"datetime":"2021-11-26T00:00+08:00","value":0},{"datetime":"2021-11-26T01:00+08:00","value":0},{"datetime":"2021-11-26T02:00+08:00","value":0},{"datetime":"2021-11-26T03:00+08:00","value":0},{"datetime":"2021-11-26T04:00+08:00","value":0},{"datetime":"2021-11-26T05:00+08:00","value":0},{"datetime":"2021-11-26T06:00+08:00","value":0},{"datetime":"2021-11-26T07:00+08:00","value":0},{"datetime":"2021-11-26T08:00+08:00","value":3.1904},{"datetime":"2021-11-26T09:00+08:00","value":172.0496}],"air_quality":{"aqi":[{"datetime":"2021-11-24T10:00+08:00","value":{"chn":69,"usa":69}},{"datetime":"2021-11-24T11:00+08:00","value":{"chn":75,"usa":75}},{"datetime":"2021-11-24T12:00+08:00","value":{"chn":74,"usa":74}},{"datetime":"2021-11-24T13:00+08:00","value":{"chn":71,"usa":71}},{"datetime":"2021-11-24T14:00+08:00","value":{"chn":67,"usa":67}},{"datetime":"2021-11-24T15:00+08:00","value":{"chn":64,"usa":64}},{"datetime":"2021-11-24T16:00+08:00","value":{"chn":61,"usa":61}},{"datetime":"2021-11-24T17:00+08:00","value":{"chn":59,"usa":59}},{"datetime":"2021-11-24T18:00+08:00","value":{"chn":57,"usa":57}},{"datetime":"2021-11-24T19:00+08:00","value":{"chn":57,"usa":57}},{"datetime":"2021-11-24T20:00+08:00","value":{"chn":60,"usa":60}},{"datetime":"2021-11-24T21:00+08:00","value":{"chn":62,"usa":62}},{"datetime":"2021-11-24T22:00+08:00","value":{"chn":66,"usa":66}},{"datetime":"2021-11-24T23:00+08:00","value":{"chn":70,"usa":70}},{"datetime":"2021-11-25T00:00+08:00","value":{"chn":72,"usa":72}},{"datetime":"2021-11-25T01:00+08:00","value":{"chn":74,"usa":74}},{"datetime":"2021-11-25T02:00+08:00","value":{"chn":76,"usa":76}},{"datetime":"2021-11-25T03:00+08:00","value":{"chn":77,"usa":77}},{"datetime":"2021-11-25T04:00+08:00","value":{"chn":79,"usa":79}},{"datetime":"2021-11-25T05:00+08:00","value":{"chn":80,"usa":80}},{"datetime":"2021-11-25T06:00+08:00","value":{"chn":82,"usa":82}},{"datetime":"2021-11-25T07:00+08:00","value":{"chn":84,"usa":84}},{"datetime":"2021-11-25T08:00+08:00","value":{"chn":86,"usa":86}},{"datetime":"2021-11-25T09:00+08:00","value":{"chn":87,"usa":87}},{"datetime":"2021-11-25T10:00+08:00","value":{"chn":87,"usa":87}},{"datetime":"2021-11-25T11:00+08:00","value":{"chn":87,"usa":87}},{"datetime":"2021-11-25T12:00+08:00","value":{"chn":85,"usa":85}},{"datetime":"2021-11-25T13:00+08:00","value":{"chn":81,"usa":81}},{"datetime":"2021-11-25T14:00+08:00","value":{"chn":76,"usa":76}},{"datetime":"2021-11-25T15:00+08:00","value":{"chn":72,"usa":72}},{"datetime":"2021-11-25T16:00+08:00","value":{"chn":69,"usa":69}},{"datetime":"2021-11-25T17:00+08:00","value":{"chn":69,"usa":69}},{"datetime":"2021-11-25T18:00+08:00","value":{"chn":70,"usa":70}},{"datetime":"2021-11-25T19:00+08:00","value":{"chn":72,"usa":72}},{"datetime":"2021-11-25T20:00+08:00","value":{"chn":75,"usa":75}},{"datetime":"2021-11-25T21:00+08:00","value":{"chn":77,"usa":77}},{"datetime":"2021-11-25T22:00+08:00","value":{"chn":79,"usa":79}},{"datetime":"2021-11-25T23:00+08:00","value":{"chn":79,"usa":79}},{"datetime":"2021-11-26T00:00+08:00","value":{"chn":79,"usa":79}},{"datetime":"2021-11-26T01:00+08:00","value":{"chn":79,"usa":79}},{"datetime":"2021-11-26T02:00+08:00","value":{"chn":81,"usa":81}},{"datetime":"2021-11-26T03:00+08:00","value":{"chn":84,"usa":84}},{"datetime":"2021-11-26T04:00+08:00","value":{"chn":86,"usa":86}},{"datetime":"2021-11-26T05:00+08:00","value":{"chn":89,"usa":89}},{"datetime":"2021-11-26T06:00+08:00","value":{"chn":91,"usa":91}},{"datetime":"2021-11-26T07:00+08:00","value":{"chn":94,"usa":94}},{"datetime":"2021-11-26T08:00+08:00","value":{"chn":96,"usa":96}},{"datetime":"2021-11-26T09:00+08:00","value":{"chn":99,"usa":99}}],"pm25":[{"datetime":"2021-11-24T10:00+08:00","value":32},{"datetime":"2021-11-24T11:00+08:00","value":55},{"datetime":"2021-11-24T12:00+08:00","value":54},{"datetime":"2021-11-24T13:00+08:00","value":52},{"datetime":"2021-11-24T14:00+08:00","value":49},{"datetime":"2021-11-24T15:00+08:00","value":46},{"datetime":"2021-11-24T16:00+08:00","value":44},{"datetime":"2021-11-24T17:00+08:00","value":42},{"datetime":"2021-11-24T18:00+08:00","value":41},{"datetime":"2021-11-24T19:00+08:00","value":41},{"datetime":"2021-11-24T20:00+08:00","value":43},{"datetime":"2021-11-24T21:00+08:00","value":45},{"datetime":"2021-11-24T22:00+08:00","value":48},{"datetime":"2021-11-24T23:00+08:00","value":51},{"datetime":"2021-11-25T00:00+08:00","value":53},{"datetime":"2021-11-25T01:00+08:00","value":54},{"datetime":"2021-11-25T02:00+08:00","value":56},{"datetime":"2021-11-25T03:00+08:00","value":57},{"datetime":"2021-11-25T04:00+08:00","value":58},{"datetime":"2021-11-25T05:00+08:00","value":59},{"datetime":"2021-11-25T06:00+08:00","value":61},{"datetime":"2021-11-25T07:00+08:00","value":62},{"datetime":"2021-11-25T08:00+08:00","value":64},{"datetime":"2021-11-25T09:00+08:00","value":65},{"datetime":"2021-11-25T10:00+08:00","value":65},{"datetime":"2021-11-25T11:00+08:00","value":65},{"datetime":"2021-11-25T12:00+08:00","value":63},{"datetime":"2021-11-25T13:00+08:00","value":60},{"datetime":"2021-11-25T14:00+08:00","value":56},{"datetime":"2021-11-25T15:00+08:00","value":53},{"datetime":"2021-11-25T16:00+08:00","value":50},{"datetime":"2021-11-25T17:00+08:00","value":50},{"datetime":"2021-11-25T18:00+08:00","value":51},{"datetime":"2021-11-25T19:00+08:00","value":53},{"datetime":"2021-11-25T20:00+08:00","value":55},{"datetime":"2021-11-25T21:00+08:00","value":57},{"datetime":"2021-11-25T22:00+08:00","value":58},{"datetime":"2021-11-25T23:00+08:00","value":58},{"datetime":"2021-11-26T00:00+08:00","value":58},{"datetime":"2021-11-26T01:00+08:00","value":58},{"datetime":"2021-11-26T02:00+08:00","value":60},{"datetime":"2021-11-26T03:00+08:00","value":62},{"datetime":"2021-11-26T04:00+08:00","value":64},{"datetime":"2021-11-26T05:00+08:00","value":66},{"datetime":"2021-11-26T06:00+08:00","value":68},{"datetime":"2021-11-26T07:00+08:00","value":70},{"datetime":"2021-11-26T08:00+08:00","value":72},{"datetime":"2021-11-26T09:00+08:00","value":74}]}}
         * daily : {"status":"ok","astro":[{"date":"2021-11-24T00:00+08:00","sunrise":{"time":"07:12"},"sunset":{"time":"17:19"}},{"date":"2021-11-25T00:00+08:00","sunrise":{"time":"07:13"},"sunset":{"time":"17:19"}},{"date":"2021-11-26T00:00+08:00","sunrise":{"time":"07:14"},"sunset":{"time":"17:19"}},{"date":"2021-11-27T00:00+08:00","sunrise":{"time":"07:15"},"sunset":{"time":"17:18"}},{"date":"2021-11-28T00:00+08:00","sunrise":{"time":"07:16"},"sunset":{"time":"17:18"}}],"precipitation":[{"date":"2021-11-24T00:00+08:00","max":0,"min":0,"avg":0},{"date":"2021-11-25T00:00+08:00","max":0,"min":0,"avg":0},{"date":"2021-11-26T00:00+08:00","max":0,"min":0,"avg":0},{"date":"2021-11-27T00:00+08:00","max":0,"min":0,"avg":0},{"date":"2021-11-28T00:00+08:00","max":0,"min":0,"avg":0}],"temperature":[{"date":"2021-11-24T00:00+08:00","max":15.5,"min":1,"avg":10.39},{"date":"2021-11-25T00:00+08:00","max":16,"min":3,"avg":9.3},{"date":"2021-11-26T00:00+08:00","max":13,"min":3,"avg":7.77},{"date":"2021-11-27T00:00+08:00","max":11,"min":4,"avg":7.67},{"date":"2021-11-28T00:00+08:00","max":14,"min":6,"avg":9.56}],"wind":[{"date":"2021-11-24T00:00+08:00","max":{"speed":16.07,"direction":278.95},"min":{"speed":6.12,"direction":249},"avg":{"speed":10.43,"direction":296.25}},{"date":"2021-11-25T00:00+08:00","max":{"speed":10.09,"direction":317.73},"min":{"speed":2.64,"direction":273.84},"avg":{"speed":7.21,"direction":313.74}},{"date":"2021-11-26T00:00+08:00","max":{"speed":10.73,"direction":115.85},"min":{"speed":4.85,"direction":12.59},"avg":{"speed":7.74,"direction":45.25}},{"date":"2021-11-27T00:00+08:00","max":{"speed":10.72,"direction":57.83},"min":{"speed":4.15,"direction":65.38},"avg":{"speed":6.34,"direction":72.65}},{"date":"2021-11-28T00:00+08:00","max":{"speed":6.65,"direction":109.12},"min":{"speed":1.61,"direction":239.12},"avg":{"speed":4.62,"direction":44.3}}],"humidity":[{"date":"2021-11-24T00:00+08:00","max":0.44,"min":0.2,"avg":0.29},{"date":"2021-11-25T00:00+08:00","max":0.37,"min":0.2,"avg":0.31},{"date":"2021-11-26T00:00+08:00","max":0.49,"min":0.29,"avg":0.38},{"date":"2021-11-27T00:00+08:00","max":0.61,"min":0.42,"avg":0.51},{"date":"2021-11-28T00:00+08:00","max":0.79,"min":0.52,"avg":0.66}],"cloudrate":[{"date":"2021-11-24T00:00+08:00","max":0,"min":0,"avg":0},{"date":"2021-11-25T00:00+08:00","max":0,"min":0,"avg":0},{"date":"2021-11-26T00:00+08:00","max":1,"min":0,"avg":0.41},{"date":"2021-11-27T00:00+08:00","max":1,"min":0.85,"avg":0.99},{"date":"2021-11-28T00:00+08:00","max":0.94,"min":0.05,"avg":0.27}],"pressure":[{"date":"2021-11-24T00:00+08:00","max":97994.62,"min":97506.56,"avg":97691.33},{"date":"2021-11-25T00:00+08:00","max":98164.99,"min":97764.99,"avg":97930.39},{"date":"2021-11-26T00:00+08:00","max":98753.79,"min":98219.39,"avg":98544.53},{"date":"2021-11-27T00:00+08:00","max":98769.02,"min":98360.96,"avg":98576.15},{"date":"2021-11-28T00:00+08:00","max":98513.79,"min":98219.39,"avg":98389.3}],"visibility":[{"date":"2021-11-24T00:00+08:00","max":24.13,"min":4.48,"avg":7.4},{"date":"2021-11-25T00:00+08:00","max":5.6,"min":3.2,"avg":4.17},{"date":"2021-11-26T00:00+08:00","max":4,"min":2.49,"avg":3.06},{"date":"2021-11-27T00:00+08:00","max":2.8,"min":2.11,"avg":2.44},{"date":"2021-11-28T00:00+08:00","max":3.73,"min":1.25,"avg":2.59}],"dswrf":[{"date":"2021-11-24T00:00+08:00","max":458.2,"min":0,"avg":249.2},{"date":"2021-11-25T00:00+08:00","max":448.9,"min":0,"avg":149.8},{"date":"2021-11-26T00:00+08:00","max":439.3,"min":0,"avg":142.2},{"date":"2021-11-27T00:00+08:00","max":242.1,"min":0,"avg":74.4},{"date":"2021-11-28T00:00+08:00","max":412.6,"min":0,"avg":136.5}],"air_quality":{"aqi":[{"date":"2021-11-24T00:00+08:00","max":{"chn":103,"usa":103},"avg":{"chn":65.14,"usa":65.14},"min":{"chn":57,"usa":57}},{"date":"2021-11-25T00:00+08:00","max":{"chn":87,"usa":87},"avg":{"chn":78.12,"usa":78.12},"min":{"chn":69,"usa":69}},{"date":"2021-11-26T00:00+08:00","max":{"chn":100,"usa":100},"avg":{"chn":90.17,"usa":90.17},"min":{"chn":79,"usa":79}},{"date":"2021-11-27T00:00+08:00","max":{"chn":110,"usa":110},"avg":{"chn":101.38,"usa":101.38},"min":{"chn":94,"usa":94}},{"date":"2021-11-28T00:00+08:00","max":{"chn":110,"usa":110},"avg":{"chn":94.42,"usa":94.42},"min":{"chn":81,"usa":81}}],"pm25":[{"date":"2021-11-24T00:00+08:00","max":56,"avg":45.93,"min":32},{"date":"2021-11-25T00:00+08:00","max":65,"avg":57.62,"min":50},{"date":"2021-11-26T00:00+08:00","max":75,"avg":67.21,"min":58},{"date":"2021-11-27T00:00+08:00","max":83,"avg":76.21,"min":70},{"date":"2021-11-28T00:00+08:00","max":83,"avg":70.67,"min":60}]},"skycon":[{"date":"2021-11-24T00:00+08:00","value":"CLEAR_DAY"},{"date":"2021-11-25T00:00+08:00","value":"CLEAR_DAY"},{"date":"2021-11-26T00:00+08:00","value":"PARTLY_CLOUDY_DAY"},{"date":"2021-11-27T00:00+08:00","value":"LIGHT_HAZE"},{"date":"2021-11-28T00:00+08:00","value":"PARTLY_CLOUDY_DAY"}],"skycon_08h_20h":[{"date":"2021-11-24T00:00+08:00","value":"CLEAR_DAY"},{"date":"2021-11-25T00:00+08:00","value":"CLEAR_DAY"},{"date":"2021-11-26T00:00+08:00","value":"PARTLY_CLOUDY_DAY"},{"date":"2021-11-27T00:00+08:00","value":"LIGHT_HAZE"},{"date":"2021-11-28T00:00+08:00","value":"CLEAR_DAY"}],"skycon_20h_32h":[{"date":"2021-11-24T00:00+08:00","value":"CLEAR_NIGHT"},{"date":"2021-11-25T00:00+08:00","value":"CLEAR_NIGHT"},{"date":"2021-11-26T00:00+08:00","value":"CLOUDY"},{"date":"2021-11-27T00:00+08:00","value":"PARTLY_CLOUDY_NIGHT"},{"date":"2021-11-28T00:00+08:00","value":"PARTLY_CLOUDY_NIGHT"}],"life_index":{"ultraviolet":[{"date":"2021-11-24T00:00+08:00","index":"4","desc":"强"},{"date":"2021-11-25T00:00+08:00","index":"4","desc":"强"},{"date":"2021-11-26T00:00+08:00","index":"4","desc":"强"},{"date":"2021-11-27T00:00+08:00","index":"1","desc":"最弱"},{"date":"2021-11-28T00:00+08:00","index":"4","desc":"强"}],"carWashing":[{"date":"2021-11-24T00:00+08:00","index":"2","desc":"较适宜"},{"date":"2021-11-25T00:00+08:00","index":"2","desc":"较适宜"},{"date":"2021-11-26T00:00+08:00","index":"2","desc":"较适宜"},{"date":"2021-11-27T00:00+08:00","index":"2","desc":"较适宜"},{"date":"2021-11-28T00:00+08:00","index":"2","desc":"较适宜"}],"dressing":[{"date":"2021-11-24T00:00+08:00","index":"5","desc":"凉爽"},{"date":"2021-11-25T00:00+08:00","index":"6","desc":"冷"},{"date":"2021-11-26T00:00+08:00","index":"6","desc":"冷"},{"date":"2021-11-27T00:00+08:00","index":"6","desc":"冷"},{"date":"2021-11-28T00:00+08:00","index":"6","desc":"冷"}],"comfort":[{"date":"2021-11-24T00:00+08:00","index":"8","desc":"很冷"},{"date":"2021-11-25T00:00+08:00","index":"8","desc":"很冷"},{"date":"2021-11-26T00:00+08:00","index":"8","desc":"很冷"},{"date":"2021-11-27T00:00+08:00","index":"8","desc":"很冷"},{"date":"2021-11-28T00:00+08:00","index":"8","desc":"很冷"}],"coldRisk":[{"date":"2021-11-24T00:00+08:00","index":"4","desc":"极易发"},{"date":"2021-11-25T00:00+08:00","index":"4","desc":"极易发"},{"date":"2021-11-26T00:00+08:00","index":"4","desc":"极易发"},{"date":"2021-11-27T00:00+08:00","index":"3","desc":"易发"},{"date":"2021-11-28T00:00+08:00","index":"4","desc":"极易发"}]}}
         * primary : 0
         * forecast_keypoint : 未来两小时不会下雨，放心出门吧
         */

        private AlertBean alert;
        private RealtimeBean realtime;
        private MinutelyBean minutely;
        private HourlyBean hourly;
        private DailyBean daily;
        private int primary;
        private String forecast_keypoint;

        public AlertBean getAlert() {
            return alert;
        }

        public void setAlert(AlertBean alert) {
            this.alert = alert;
        }

        public RealtimeBean getRealtime() {
            return realtime;
        }

        public void setRealtime(RealtimeBean realtime) {
            this.realtime = realtime;
        }

        public MinutelyBean getMinutely() {
            return minutely;
        }

        public void setMinutely(MinutelyBean minutely) {
            this.minutely = minutely;
        }

        public HourlyBean getHourly() {
            return hourly;
        }

        public void setHourly(HourlyBean hourly) {
            this.hourly = hourly;
        }

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

        public String getForecast_keypoint() {
            return forecast_keypoint;
        }

        public void setForecast_keypoint(String forecast_keypoint) {
            this.forecast_keypoint = forecast_keypoint;
        }

        public static class AlertBean {
            /**
             * status : ok
             * content : [{"province":"河南省","status":"预警中","code":"0501","description":"济源市气象台2021年11月24日09时15分发布大风蓝色预警信号：预计今天白天，我市邵原、王屋、下冶、克井、五龙口等镇将有5到6级西北风，局部阵风7到8级。请注意做好防灾减灾和安全生产工作。","regionId":"101181801","county":"济源市","pubtimestamp":1637717036,"latlon":[35.067243,112.601918],"city":"济源市","alertId":"41900141600000_20211124092356","title":"济源市气象台发布大风蓝色预警[IV级/一般]","adcode":"419001","source":"国家预警信息发布中心","location":"河南省济源市济源市","request_status":"ok"}]
             */

            private String status;
            private List<ContentBean> content;

            public String getStatus() {
                return status;
            }

            public void setStatus(String status) {
                this.status = status;
            }

            public List<ContentBean> getContent() {
                return content;
            }

            public void setContent(List<ContentBean> content) {
                this.content = content;
            }

            public static class ContentBean {
                /**
                 * province : 河南省
                 * status : 预警中
                 * code : 0501
                 * description : 济源市气象台2021年11月24日09时15分发布大风蓝色预警信号：预计今天白天，我市邵原、王屋、下冶、克井、五龙口等镇将有5到6级西北风，局部阵风7到8级。请注意做好防灾减灾和安全生产工作。
                 * regionId : 101181801
                 * county : 济源市
                 * pubtimestamp : 1637717036
                 * latlon : [35.067243,112.601918]
                 * city : 济源市
                 * alertId : 41900141600000_20211124092356
                 * title : 济源市气象台发布大风蓝色预警[IV级/一般]
                 * adcode : 419001
                 * source : 国家预警信息发布中心
                 * location : 河南省济源市济源市
                 * request_status : ok
                 */

                private String province;
                private String status;
                private String code;
                private String description;
                private String regionId;
                private String county;
                private int pubtimestamp;
                private String city;
                private String alertId;
                private String title;
                private String adcode;
                private String source;
                private String location;
                private String request_status;
                private List<Double> latlon;

                public String getProvince() {
                    return province;
                }

                public void setProvince(String province) {
                    this.province = province;
                }

                public String getStatus() {
                    return status;
                }

                public void setStatus(String status) {
                    this.status = status;
                }

                public String getCode() {
                    return code;
                }

                public void setCode(String code) {
                    this.code = code;
                }

                public String getDescription() {
                    return description;
                }

                public void setDescription(String description) {
                    this.description = description;
                }

                public String getRegionId() {
                    return regionId;
                }

                public void setRegionId(String regionId) {
                    this.regionId = regionId;
                }

                public String getCounty() {
                    return county;
                }

                public void setCounty(String county) {
                    this.county = county;
                }

                public int getPubtimestamp() {
                    return pubtimestamp;
                }

                public void setPubtimestamp(int pubtimestamp) {
                    this.pubtimestamp = pubtimestamp;
                }

                public String getCity() {
                    return city;
                }

                public void setCity(String city) {
                    this.city = city;
                }

                public String getAlertId() {
                    return alertId;
                }

                public void setAlertId(String alertId) {
                    this.alertId = alertId;
                }

                public String getTitle() {
                    return title;
                }

                public void setTitle(String title) {
                    this.title = title;
                }

                public String getAdcode() {
                    return adcode;
                }

                public void setAdcode(String adcode) {
                    this.adcode = adcode;
                }

                public String getSource() {
                    return source;
                }

                public void setSource(String source) {
                    this.source = source;
                }

                public String getLocation() {
                    return location;
                }

                public void setLocation(String location) {
                    this.location = location;
                }

                public String getRequest_status() {
                    return request_status;
                }

                public void setRequest_status(String request_status) {
                    this.request_status = request_status;
                }

                public List<Double> getLatlon() {
                    return latlon;
                }

                public void setLatlon(List<Double> latlon) {
                    this.latlon = latlon;
                }
            }
        }

        public static class RealtimeBean {
            /**
             * status : ok
             * temperature : 9
             * humidity : 0.33
             * cloudrate : 0
             * skycon : CLEAR_DAY
             * visibility : 11.2
             * dswrf : 271.5
             * wind : {"speed":6.12,"direction":249}
             * pressure : 97873.79
             * apparent_temperature : 6.3
             * precipitation : {"local":{"status":"ok","datasource":"radar","intensity":0},"nearest":{"status":"ok","distance":137.52,"intensity":0.1875}}
             * air_quality : {"pm25":32,"pm10":87,"o3":16,"so2":1,"no2":43,"co":0.6,"aqi":{"chn":69,"usa":69},"description":{"chn":"良","usa":"良"}}
             * life_index : {"ultraviolet":{"index":5,"desc":"中等"},"comfort":{"index":8,"desc":"很冷"}}
             */

            private String status;
            private int temperature;
            private double humidity;
            private int cloudrate;
            private String skycon;
            private double visibility;
            private double dswrf;
            private WindBean wind;
            private double pressure;
            private double apparent_temperature;
            private PrecipitationBean precipitation;
            private AirQualityBean air_quality;
            private LifeIndexBean life_index;

            public String getStatus() {
                return status;
            }

            public void setStatus(String status) {
                this.status = status;
            }

            public int getTemperature() {
                return temperature;
            }

            public void setTemperature(int temperature) {
                this.temperature = temperature;
            }

            public double getHumidity() {
                return humidity;
            }

            public void setHumidity(double humidity) {
                this.humidity = humidity;
            }

            public int getCloudrate() {
                return cloudrate;
            }

            public void setCloudrate(int cloudrate) {
                this.cloudrate = cloudrate;
            }

            public String getSkycon() {
                return skycon;
            }

            public void setSkycon(String skycon) {
                this.skycon = skycon;
            }

            public double getVisibility() {
                return visibility;
            }

            public void setVisibility(double visibility) {
                this.visibility = visibility;
            }

            public double getDswrf() {
                return dswrf;
            }

            public void setDswrf(double dswrf) {
                this.dswrf = dswrf;
            }

            public WindBean getWind() {
                return wind;
            }

            public void setWind(WindBean wind) {
                this.wind = wind;
            }

            public double getPressure() {
                return pressure;
            }

            public void setPressure(double pressure) {
                this.pressure = pressure;
            }

            public double getApparent_temperature() {
                return apparent_temperature;
            }

            public void setApparent_temperature(double apparent_temperature) {
                this.apparent_temperature = apparent_temperature;
            }

            public PrecipitationBean getPrecipitation() {
                return precipitation;
            }

            public void setPrecipitation(PrecipitationBean precipitation) {
                this.precipitation = precipitation;
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

            public static class WindBean {
                /**
                 * speed : 6.12
                 * direction : 249
                 */

                private double speed;
                private int direction;

                public double getSpeed() {
                    return speed;
                }

                public void setSpeed(double speed) {
                    this.speed = speed;
                }

                public int getDirection() {
                    return direction;
                }

                public void setDirection(int direction) {
                    this.direction = direction;
                }
            }

            public static class PrecipitationBean {
                /**
                 * local : {"status":"ok","datasource":"radar","intensity":0}
                 * nearest : {"status":"ok","distance":137.52,"intensity":0.1875}
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
                     * status : ok
                     * datasource : radar
                     * intensity : 0
                     */

                    private String status;
                    private String datasource;
                    private int intensity;

                    public String getStatus() {
                        return status;
                    }

                    public void setStatus(String status) {
                        this.status = status;
                    }

                    public String getDatasource() {
                        return datasource;
                    }

                    public void setDatasource(String datasource) {
                        this.datasource = datasource;
                    }

                    public int getIntensity() {
                        return intensity;
                    }

                    public void setIntensity(int intensity) {
                        this.intensity = intensity;
                    }
                }

                public static class NearestBean {
                    /**
                     * status : ok
                     * distance : 137.52
                     * intensity : 0.1875
                     */

                    private String status;
                    private double distance;
                    private double intensity;

                    public String getStatus() {
                        return status;
                    }

                    public void setStatus(String status) {
                        this.status = status;
                    }

                    public double getDistance() {
                        return distance;
                    }

                    public void setDistance(double distance) {
                        this.distance = distance;
                    }

                    public double getIntensity() {
                        return intensity;
                    }

                    public void setIntensity(double intensity) {
                        this.intensity = intensity;
                    }
                }
            }

            public static class AirQualityBean {
                /**
                 * pm25 : 32
                 * pm10 : 87
                 * o3 : 16
                 * so2 : 1
                 * no2 : 43
                 * co : 0.6
                 * aqi : {"chn":69,"usa":69}
                 * description : {"chn":"良","usa":"良"}
                 */

                private int pm25;
                private int pm10;
                private int o3;
                private int so2;
                private int no2;
                private double co;
                private AqiBean aqi;
                private DescriptionBean description;

                public int getPm25() {
                    return pm25;
                }

                public void setPm25(int pm25) {
                    this.pm25 = pm25;
                }

                public int getPm10() {
                    return pm10;
                }

                public void setPm10(int pm10) {
                    this.pm10 = pm10;
                }

                public int getO3() {
                    return o3;
                }

                public void setO3(int o3) {
                    this.o3 = o3;
                }

                public int getSo2() {
                    return so2;
                }

                public void setSo2(int so2) {
                    this.so2 = so2;
                }

                public int getNo2() {
                    return no2;
                }

                public void setNo2(int no2) {
                    this.no2 = no2;
                }

                public double getCo() {
                    return co;
                }

                public void setCo(double co) {
                    this.co = co;
                }

                public AqiBean getAqi() {
                    return aqi;
                }

                public void setAqi(AqiBean aqi) {
                    this.aqi = aqi;
                }

                public DescriptionBean getDescription() {
                    return description;
                }

                public void setDescription(DescriptionBean description) {
                    this.description = description;
                }

                public static class AqiBean {
                    /**
                     * chn : 69
                     * usa : 69
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
                     * chn : 良
                     * usa : 良
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
                 * ultraviolet : {"index":5,"desc":"中等"}
                 * comfort : {"index":8,"desc":"很冷"}
                 */

                private UltravioletBean ultraviolet;
                private ComfortBean comfort;

                public UltravioletBean getUltraviolet() {
                    return ultraviolet;
                }

                public void setUltraviolet(UltravioletBean ultraviolet) {
                    this.ultraviolet = ultraviolet;
                }

                public ComfortBean getComfort() {
                    return comfort;
                }

                public void setComfort(ComfortBean comfort) {
                    this.comfort = comfort;
                }

                public static class UltravioletBean {
                    /**
                     * index : 5
                     * desc : 中等
                     */

                    private int index;
                    private String desc;

                    public int getIndex() {
                        return index;
                    }

                    public void setIndex(int index) {
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
                     * index : 8
                     * desc : 很冷
                     */

                    private int index;
                    private String desc;

                    public int getIndex() {
                        return index;
                    }

                    public void setIndex(int index) {
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
        }

        public static class MinutelyBean {
            /**
             * status : ok
             * datasource : radar
             * precipitation_2h : [0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0]
             * precipitation : [0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0]
             * probability : [0,0,0,0]
             * description : 未来两小时不会下雨，放心出门吧
             */

            private String status;
            private String datasource;
            private String description;
            private List<Integer> precipitation_2h;
            private List<Integer> precipitation;
            private List<Integer> probability;

            public String getStatus() {
                return status;
            }

            public void setStatus(String status) {
                this.status = status;
            }

            public String getDatasource() {
                return datasource;
            }

            public void setDatasource(String datasource) {
                this.datasource = datasource;
            }

            public String getDescription() {
                return description;
            }

            public void setDescription(String description) {
                this.description = description;
            }

            public List<Integer> getPrecipitation_2h() {
                return precipitation_2h;
            }

            public void setPrecipitation_2h(List<Integer> precipitation_2h) {
                this.precipitation_2h = precipitation_2h;
            }

            public List<Integer> getPrecipitation() {
                return precipitation;
            }

            public void setPrecipitation(List<Integer> precipitation) {
                this.precipitation = precipitation;
            }

            public List<Integer> getProbability() {
                return probability;
            }

            public void setProbability(List<Integer> probability) {
                this.probability = probability;
            }
        }

        public static class HourlyBean {
            /**
             * status : ok
             * description : 未来24小时晴
             * precipitation : [{"datetime":"2021-11-24T10:00+08:00","value":0},{"datetime":"2021-11-24T11:00+08:00","value":0},{"datetime":"2021-11-24T12:00+08:00","value":0},{"datetime":"2021-11-24T13:00+08:00","value":0},{"datetime":"2021-11-24T14:00+08:00","value":0},{"datetime":"2021-11-24T15:00+08:00","value":0},{"datetime":"2021-11-24T16:00+08:00","value":0},{"datetime":"2021-11-24T17:00+08:00","value":0},{"datetime":"2021-11-24T18:00+08:00","value":0},{"datetime":"2021-11-24T19:00+08:00","value":0},{"datetime":"2021-11-24T20:00+08:00","value":0},{"datetime":"2021-11-24T21:00+08:00","value":0},{"datetime":"2021-11-24T22:00+08:00","value":0},{"datetime":"2021-11-24T23:00+08:00","value":0},{"datetime":"2021-11-25T00:00+08:00","value":0},{"datetime":"2021-11-25T01:00+08:00","value":0},{"datetime":"2021-11-25T02:00+08:00","value":0},{"datetime":"2021-11-25T03:00+08:00","value":0},{"datetime":"2021-11-25T04:00+08:00","value":0},{"datetime":"2021-11-25T05:00+08:00","value":0},{"datetime":"2021-11-25T06:00+08:00","value":0},{"datetime":"2021-11-25T07:00+08:00","value":0},{"datetime":"2021-11-25T08:00+08:00","value":0},{"datetime":"2021-11-25T09:00+08:00","value":0},{"datetime":"2021-11-25T10:00+08:00","value":0},{"datetime":"2021-11-25T11:00+08:00","value":0},{"datetime":"2021-11-25T12:00+08:00","value":0},{"datetime":"2021-11-25T13:00+08:00","value":0},{"datetime":"2021-11-25T14:00+08:00","value":0},{"datetime":"2021-11-25T15:00+08:00","value":0},{"datetime":"2021-11-25T16:00+08:00","value":0},{"datetime":"2021-11-25T17:00+08:00","value":0},{"datetime":"2021-11-25T18:00+08:00","value":0},{"datetime":"2021-11-25T19:00+08:00","value":0},{"datetime":"2021-11-25T20:00+08:00","value":0},{"datetime":"2021-11-25T21:00+08:00","value":0},{"datetime":"2021-11-25T22:00+08:00","value":0},{"datetime":"2021-11-25T23:00+08:00","value":0},{"datetime":"2021-11-26T00:00+08:00","value":0},{"datetime":"2021-11-26T01:00+08:00","value":0},{"datetime":"2021-11-26T02:00+08:00","value":0},{"datetime":"2021-11-26T03:00+08:00","value":0},{"datetime":"2021-11-26T04:00+08:00","value":0},{"datetime":"2021-11-26T05:00+08:00","value":0},{"datetime":"2021-11-26T06:00+08:00","value":0},{"datetime":"2021-11-26T07:00+08:00","value":0},{"datetime":"2021-11-26T08:00+08:00","value":0},{"datetime":"2021-11-26T09:00+08:00","value":0}]
             * temperature : [{"datetime":"2021-11-24T10:00+08:00","value":9},{"datetime":"2021-11-24T11:00+08:00","value":11.5},{"datetime":"2021-11-24T12:00+08:00","value":13},{"datetime":"2021-11-24T13:00+08:00","value":13.5},{"datetime":"2021-11-24T14:00+08:00","value":15},{"datetime":"2021-11-24T15:00+08:00","value":15.5},{"datetime":"2021-11-24T16:00+08:00","value":15},{"datetime":"2021-11-24T17:00+08:00","value":14},{"datetime":"2021-11-24T18:00+08:00","value":8},{"datetime":"2021-11-24T19:00+08:00","value":8},{"datetime":"2021-11-24T20:00+08:00","value":7.5},{"datetime":"2021-11-24T21:00+08:00","value":6.2},{"datetime":"2021-11-24T22:00+08:00","value":5.1},{"datetime":"2021-11-24T23:00+08:00","value":4.2},{"datetime":"2021-11-25T00:00+08:00","value":3.5},{"datetime":"2021-11-25T01:00+08:00","value":3.4},{"datetime":"2021-11-25T02:00+08:00","value":3.3},{"datetime":"2021-11-25T03:00+08:00","value":3},{"datetime":"2021-11-25T04:00+08:00","value":3},{"datetime":"2021-11-25T05:00+08:00","value":3},{"datetime":"2021-11-25T06:00+08:00","value":4.3},{"datetime":"2021-11-25T07:00+08:00","value":5.6},{"datetime":"2021-11-25T08:00+08:00","value":6.9},{"datetime":"2021-11-25T09:00+08:00","value":8.2},{"datetime":"2021-11-25T10:00+08:00","value":9.5},{"datetime":"2021-11-25T11:00+08:00","value":10.8},{"datetime":"2021-11-25T12:00+08:00","value":12.1},{"datetime":"2021-11-25T13:00+08:00","value":13.4},{"datetime":"2021-11-25T14:00+08:00","value":14.7},{"datetime":"2021-11-25T15:00+08:00","value":16},{"datetime":"2021-11-25T16:00+08:00","value":15.9},{"datetime":"2021-11-25T17:00+08:00","value":15.26},{"datetime":"2021-11-25T18:00+08:00","value":14.48},{"datetime":"2021-11-25T19:00+08:00","value":13.73},{"datetime":"2021-11-25T20:00+08:00","value":12.82},{"datetime":"2021-11-25T21:00+08:00","value":11.86},{"datetime":"2021-11-25T22:00+08:00","value":10.04},{"datetime":"2021-11-25T23:00+08:00","value":8.4},{"datetime":"2021-11-26T00:00+08:00","value":6.95},{"datetime":"2021-11-26T01:00+08:00","value":5.59},{"datetime":"2021-11-26T02:00+08:00","value":4.93},{"datetime":"2021-11-26T03:00+08:00","value":4.43},{"datetime":"2021-11-26T04:00+08:00","value":3.96},{"datetime":"2021-11-26T05:00+08:00","value":4.29},{"datetime":"2021-11-26T06:00+08:00","value":4.74},{"datetime":"2021-11-26T07:00+08:00","value":3},{"datetime":"2021-11-26T08:00+08:00","value":6.15},{"datetime":"2021-11-26T09:00+08:00","value":6.49}]
             * wind : [{"datetime":"2021-11-24T10:00+08:00","speed":6.12,"direction":249},{"datetime":"2021-11-24T11:00+08:00","speed":13.27,"direction":287.02},{"datetime":"2021-11-24T12:00+08:00","speed":15.34,"direction":289.68},{"datetime":"2021-11-24T13:00+08:00","speed":15.67,"direction":283.13},{"datetime":"2021-11-24T14:00+08:00","speed":16.07,"direction":278.95},{"datetime":"2021-11-24T15:00+08:00","speed":15.88,"direction":285.56},{"datetime":"2021-11-24T16:00+08:00","speed":15.41,"direction":286.24},{"datetime":"2021-11-24T17:00+08:00","speed":14.69,"direction":290.31},{"datetime":"2021-11-24T18:00+08:00","speed":11.67,"direction":302.78},{"datetime":"2021-11-24T19:00+08:00","speed":11.06,"direction":311.28},{"datetime":"2021-11-24T20:00+08:00","speed":10.09,"direction":316.82},{"datetime":"2021-11-24T21:00+08:00","speed":8.92,"direction":321.05},{"datetime":"2021-11-24T22:00+08:00","speed":8.6,"direction":318.83},{"datetime":"2021-11-24T23:00+08:00","speed":8.84,"direction":321.11},{"datetime":"2021-11-25T00:00+08:00","speed":8.89,"direction":317.62},{"datetime":"2021-11-25T01:00+08:00","speed":8.98,"direction":316.35},{"datetime":"2021-11-25T02:00+08:00","speed":9.22,"direction":320.3},{"datetime":"2021-11-25T03:00+08:00","speed":8.84,"direction":321.42},{"datetime":"2021-11-25T04:00+08:00","speed":9.18,"direction":318.77},{"datetime":"2021-11-25T05:00+08:00","speed":10.09,"direction":317.73},{"datetime":"2021-11-25T06:00+08:00","speed":9.79,"direction":317.49},{"datetime":"2021-11-25T07:00+08:00","speed":9.12,"direction":313.78},{"datetime":"2021-11-25T08:00+08:00","speed":8.25,"direction":312.08},{"datetime":"2021-11-25T09:00+08:00","speed":6.65,"direction":312.58},{"datetime":"2021-11-25T10:00+08:00","speed":6.01,"direction":311.13},{"datetime":"2021-11-25T11:00+08:00","speed":5.35,"direction":303.19},{"datetime":"2021-11-25T12:00+08:00","speed":5.96,"direction":308.42},{"datetime":"2021-11-25T13:00+08:00","speed":5.9,"direction":320.02},{"datetime":"2021-11-25T14:00+08:00","speed":4.67,"direction":308.41},{"datetime":"2021-11-25T15:00+08:00","speed":4.49,"direction":290.65},{"datetime":"2021-11-25T16:00+08:00","speed":2.87,"direction":266.4},{"datetime":"2021-11-25T17:00+08:00","speed":2.64,"direction":273.84},{"datetime":"2021-11-25T18:00+08:00","speed":5.6,"direction":304.61},{"datetime":"2021-11-25T19:00+08:00","speed":7.57,"direction":313.94},{"datetime":"2021-11-25T20:00+08:00","speed":7.99,"direction":320.74},{"datetime":"2021-11-25T21:00+08:00","speed":8.42,"direction":321.8},{"datetime":"2021-11-25T22:00+08:00","speed":8.47,"direction":316.61},{"datetime":"2021-11-25T23:00+08:00","speed":8.2,"direction":316.62},{"datetime":"2021-11-26T00:00+08:00","speed":8.33,"direction":322.24},{"datetime":"2021-11-26T01:00+08:00","speed":8.82,"direction":327.97},{"datetime":"2021-11-26T02:00+08:00","speed":9.46,"direction":330.66},{"datetime":"2021-11-26T03:00+08:00","speed":9.61,"direction":331.18},{"datetime":"2021-11-26T04:00+08:00","speed":9.52,"direction":333.51},{"datetime":"2021-11-26T05:00+08:00","speed":9.08,"direction":341.28},{"datetime":"2021-11-26T06:00+08:00","speed":8.01,"direction":350.55},{"datetime":"2021-11-26T07:00+08:00","speed":6.76,"direction":351.18},{"datetime":"2021-11-26T08:00+08:00","speed":6.89,"direction":359.19},{"datetime":"2021-11-26T09:00+08:00","speed":4.85,"direction":12.59}]
             * humidity : [{"datetime":"2021-11-24T10:00+08:00","value":0.33},{"datetime":"2021-11-24T11:00+08:00","value":0.27},{"datetime":"2021-11-24T12:00+08:00","value":0.23},{"datetime":"2021-11-24T13:00+08:00","value":0.2},{"datetime":"2021-11-24T14:00+08:00","value":0.2},{"datetime":"2021-11-24T15:00+08:00","value":0.21},{"datetime":"2021-11-24T16:00+08:00","value":0.25},{"datetime":"2021-11-24T17:00+08:00","value":0.29},{"datetime":"2021-11-24T18:00+08:00","value":0.31},{"datetime":"2021-11-24T19:00+08:00","value":0.33},{"datetime":"2021-11-24T20:00+08:00","value":0.34},{"datetime":"2021-11-24T21:00+08:00","value":0.35},{"datetime":"2021-11-24T22:00+08:00","value":0.35},{"datetime":"2021-11-24T23:00+08:00","value":0.36},{"datetime":"2021-11-25T00:00+08:00","value":0.36},{"datetime":"2021-11-25T01:00+08:00","value":0.36},{"datetime":"2021-11-25T02:00+08:00","value":0.36},{"datetime":"2021-11-25T03:00+08:00","value":0.36},{"datetime":"2021-11-25T04:00+08:00","value":0.36},{"datetime":"2021-11-25T05:00+08:00","value":0.36},{"datetime":"2021-11-25T06:00+08:00","value":0.36},{"datetime":"2021-11-25T07:00+08:00","value":0.36},{"datetime":"2021-11-25T08:00+08:00","value":0.37},{"datetime":"2021-11-25T09:00+08:00","value":0.34},{"datetime":"2021-11-25T10:00+08:00","value":0.28},{"datetime":"2021-11-25T11:00+08:00","value":0.25},{"datetime":"2021-11-25T12:00+08:00","value":0.23},{"datetime":"2021-11-25T13:00+08:00","value":0.21},{"datetime":"2021-11-25T14:00+08:00","value":0.2},{"datetime":"2021-11-25T15:00+08:00","value":0.21},{"datetime":"2021-11-25T16:00+08:00","value":0.27},{"datetime":"2021-11-25T17:00+08:00","value":0.3},{"datetime":"2021-11-25T18:00+08:00","value":0.3},{"datetime":"2021-11-25T19:00+08:00","value":0.31},{"datetime":"2021-11-25T20:00+08:00","value":0.32},{"datetime":"2021-11-25T21:00+08:00","value":0.33},{"datetime":"2021-11-25T22:00+08:00","value":0.35},{"datetime":"2021-11-25T23:00+08:00","value":0.36},{"datetime":"2021-11-26T00:00+08:00","value":0.36},{"datetime":"2021-11-26T01:00+08:00","value":0.37},{"datetime":"2021-11-26T02:00+08:00","value":0.37},{"datetime":"2021-11-26T03:00+08:00","value":0.38},{"datetime":"2021-11-26T04:00+08:00","value":0.38},{"datetime":"2021-11-26T05:00+08:00","value":0.39},{"datetime":"2021-11-26T06:00+08:00","value":0.4},{"datetime":"2021-11-26T07:00+08:00","value":0.4},{"datetime":"2021-11-26T08:00+08:00","value":0.41},{"datetime":"2021-11-26T09:00+08:00","value":0.37}]
             * cloudrate : [{"datetime":"2021-11-24T10:00+08:00","value":0},{"datetime":"2021-11-24T11:00+08:00","value":0},{"datetime":"2021-11-24T12:00+08:00","value":0},{"datetime":"2021-11-24T13:00+08:00","value":0},{"datetime":"2021-11-24T14:00+08:00","value":0},{"datetime":"2021-11-24T15:00+08:00","value":0},{"datetime":"2021-11-24T16:00+08:00","value":0},{"datetime":"2021-11-24T17:00+08:00","value":0},{"datetime":"2021-11-24T18:00+08:00","value":0},{"datetime":"2021-11-24T19:00+08:00","value":0},{"datetime":"2021-11-24T20:00+08:00","value":0},{"datetime":"2021-11-24T21:00+08:00","value":0},{"datetime":"2021-11-24T22:00+08:00","value":0},{"datetime":"2021-11-24T23:00+08:00","value":0},{"datetime":"2021-11-25T00:00+08:00","value":0},{"datetime":"2021-11-25T01:00+08:00","value":0},{"datetime":"2021-11-25T02:00+08:00","value":0},{"datetime":"2021-11-25T03:00+08:00","value":0},{"datetime":"2021-11-25T04:00+08:00","value":0},{"datetime":"2021-11-25T05:00+08:00","value":0},{"datetime":"2021-11-25T06:00+08:00","value":0},{"datetime":"2021-11-25T07:00+08:00","value":0},{"datetime":"2021-11-25T08:00+08:00","value":0},{"datetime":"2021-11-25T09:00+08:00","value":0},{"datetime":"2021-11-25T10:00+08:00","value":0},{"datetime":"2021-11-25T11:00+08:00","value":0},{"datetime":"2021-11-25T12:00+08:00","value":0},{"datetime":"2021-11-25T13:00+08:00","value":0},{"datetime":"2021-11-25T14:00+08:00","value":0},{"datetime":"2021-11-25T15:00+08:00","value":0},{"datetime":"2021-11-25T16:00+08:00","value":0},{"datetime":"2021-11-25T17:00+08:00","value":0},{"datetime":"2021-11-25T18:00+08:00","value":0},{"datetime":"2021-11-25T19:00+08:00","value":0},{"datetime":"2021-11-25T20:00+08:00","value":0},{"datetime":"2021-11-25T21:00+08:00","value":0},{"datetime":"2021-11-25T22:00+08:00","value":0},{"datetime":"2021-11-25T23:00+08:00","value":0},{"datetime":"2021-11-26T00:00+08:00","value":0},{"datetime":"2021-11-26T01:00+08:00","value":0},{"datetime":"2021-11-26T02:00+08:00","value":0},{"datetime":"2021-11-26T03:00+08:00","value":0},{"datetime":"2021-11-26T04:00+08:00","value":0},{"datetime":"2021-11-26T05:00+08:00","value":0},{"datetime":"2021-11-26T06:00+08:00","value":0},{"datetime":"2021-11-26T07:00+08:00","value":0},{"datetime":"2021-11-26T08:00+08:00","value":0.04},{"datetime":"2021-11-26T09:00+08:00","value":0.07}]
             * skycon : [{"datetime":"2021-11-24T10:00+08:00","value":"CLEAR_DAY"},{"datetime":"2021-11-24T11:00+08:00","value":"CLEAR_DAY"},{"datetime":"2021-11-24T12:00+08:00","value":"CLEAR_DAY"},{"datetime":"2021-11-24T13:00+08:00","value":"CLEAR_DAY"},{"datetime":"2021-11-24T14:00+08:00","value":"CLEAR_DAY"},{"datetime":"2021-11-24T15:00+08:00","value":"CLEAR_DAY"},{"datetime":"2021-11-24T16:00+08:00","value":"CLEAR_DAY"},{"datetime":"2021-11-24T17:00+08:00","value":"CLEAR_DAY"},{"datetime":"2021-11-24T18:00+08:00","value":"CLEAR_NIGHT"},{"datetime":"2021-11-24T19:00+08:00","value":"CLEAR_NIGHT"},{"datetime":"2021-11-24T20:00+08:00","value":"CLEAR_NIGHT"},{"datetime":"2021-11-24T21:00+08:00","value":"CLEAR_NIGHT"},{"datetime":"2021-11-24T22:00+08:00","value":"CLEAR_NIGHT"},{"datetime":"2021-11-24T23:00+08:00","value":"CLEAR_NIGHT"},{"datetime":"2021-11-25T00:00+08:00","value":"CLEAR_NIGHT"},{"datetime":"2021-11-25T01:00+08:00","value":"CLEAR_NIGHT"},{"datetime":"2021-11-25T02:00+08:00","value":"CLEAR_NIGHT"},{"datetime":"2021-11-25T03:00+08:00","value":"CLEAR_NIGHT"},{"datetime":"2021-11-25T04:00+08:00","value":"CLEAR_NIGHT"},{"datetime":"2021-11-25T05:00+08:00","value":"CLEAR_NIGHT"},{"datetime":"2021-11-25T06:00+08:00","value":"CLEAR_NIGHT"},{"datetime":"2021-11-25T07:00+08:00","value":"CLEAR_NIGHT"},{"datetime":"2021-11-25T08:00+08:00","value":"CLEAR_DAY"},{"datetime":"2021-11-25T09:00+08:00","value":"CLEAR_DAY"},{"datetime":"2021-11-25T10:00+08:00","value":"CLEAR_DAY"},{"datetime":"2021-11-25T11:00+08:00","value":"CLEAR_DAY"},{"datetime":"2021-11-25T12:00+08:00","value":"CLEAR_DAY"},{"datetime":"2021-11-25T13:00+08:00","value":"CLEAR_DAY"},{"datetime":"2021-11-25T14:00+08:00","value":"CLEAR_DAY"},{"datetime":"2021-11-25T15:00+08:00","value":"CLEAR_DAY"},{"datetime":"2021-11-25T16:00+08:00","value":"CLEAR_DAY"},{"datetime":"2021-11-25T17:00+08:00","value":"CLEAR_DAY"},{"datetime":"2021-11-25T18:00+08:00","value":"CLEAR_NIGHT"},{"datetime":"2021-11-25T19:00+08:00","value":"CLEAR_NIGHT"},{"datetime":"2021-11-25T20:00+08:00","value":"CLEAR_NIGHT"},{"datetime":"2021-11-25T21:00+08:00","value":"CLEAR_NIGHT"},{"datetime":"2021-11-25T22:00+08:00","value":"CLEAR_NIGHT"},{"datetime":"2021-11-25T23:00+08:00","value":"CLEAR_NIGHT"},{"datetime":"2021-11-26T00:00+08:00","value":"CLEAR_NIGHT"},{"datetime":"2021-11-26T01:00+08:00","value":"CLEAR_NIGHT"},{"datetime":"2021-11-26T02:00+08:00","value":"CLEAR_NIGHT"},{"datetime":"2021-11-26T03:00+08:00","value":"CLEAR_NIGHT"},{"datetime":"2021-11-26T04:00+08:00","value":"CLEAR_NIGHT"},{"datetime":"2021-11-26T05:00+08:00","value":"CLEAR_NIGHT"},{"datetime":"2021-11-26T06:00+08:00","value":"CLEAR_NIGHT"},{"datetime":"2021-11-26T07:00+08:00","value":"CLEAR_NIGHT"},{"datetime":"2021-11-26T08:00+08:00","value":"CLEAR_DAY"},{"datetime":"2021-11-26T09:00+08:00","value":"CLEAR_DAY"}]
             * pressure : [{"datetime":"2021-11-24T10:00+08:00","value":97873.792},{"datetime":"2021-11-24T11:00+08:00","value":97819.392},{"datetime":"2021-11-24T12:00+08:00","value":97739.392},{"datetime":"2021-11-24T13:00+08:00","value":97579.392},{"datetime":"2021-11-24T14:00+08:00","value":97545.728},{"datetime":"2021-11-24T15:00+08:00","value":97506.56},{"datetime":"2021-11-24T16:00+08:00","value":97524.992},{"datetime":"2021-11-24T17:00+08:00","value":97586.56},{"datetime":"2021-11-24T18:00+08:00","value":97659.392},{"datetime":"2021-11-24T19:00+08:00","value":97684.992},{"datetime":"2021-11-24T20:00+08:00","value":97739.392},{"datetime":"2021-11-24T21:00+08:00","value":97780.224},{"datetime":"2021-11-24T22:00+08:00","value":97819.392},{"datetime":"2021-11-24T23:00+08:00","value":97819.392},{"datetime":"2021-11-25T00:00+08:00","value":97834.624},{"datetime":"2021-11-25T01:00+08:00","value":97819.392},{"datetime":"2021-11-25T02:00+08:00","value":97819.392},{"datetime":"2021-11-25T03:00+08:00","value":97819.392},{"datetime":"2021-11-25T04:00+08:00","value":97819.392},{"datetime":"2021-11-25T05:00+08:00","value":97819.392},{"datetime":"2021-11-25T06:00+08:00","value":97834.624},{"datetime":"2021-11-25T07:00+08:00","value":97899.392},{"datetime":"2021-11-25T08:00+08:00","value":97979.392},{"datetime":"2021-11-25T09:00+08:00","value":98059.392},{"datetime":"2021-11-25T10:00+08:00","value":98059.392},{"datetime":"2021-11-25T11:00+08:00","value":98059.392},{"datetime":"2021-11-25T12:00+08:00","value":97979.392},{"datetime":"2021-11-25T13:00+08:00","value":97899.392},{"datetime":"2021-11-25T14:00+08:00","value":97819.392},{"datetime":"2021-11-25T15:00+08:00","value":97764.992},{"datetime":"2021-11-25T16:00+08:00","value":97819.392},{"datetime":"2021-11-25T17:00+08:00","value":97844.992},{"datetime":"2021-11-25T18:00+08:00","value":97924.992},{"datetime":"2021-11-25T19:00+08:00","value":98004.992},{"datetime":"2021-11-25T20:00+08:00","value":98059.392},{"datetime":"2021-11-25T21:00+08:00","value":98084.992},{"datetime":"2021-11-25T22:00+08:00","value":98139.392},{"datetime":"2021-11-25T23:00+08:00","value":98164.992},{"datetime":"2021-11-26T00:00+08:00","value":98219.392},{"datetime":"2021-11-26T01:00+08:00","value":98219.392},{"datetime":"2021-11-26T02:00+08:00","value":98260.224},{"datetime":"2021-11-26T03:00+08:00","value":98299.392},{"datetime":"2021-11-26T04:00+08:00","value":98299.392},{"datetime":"2021-11-26T05:00+08:00","value":98314.624},{"datetime":"2021-11-26T06:00+08:00","value":98394.624},{"datetime":"2021-11-26T07:00+08:00","value":98513.792},{"datetime":"2021-11-26T08:00+08:00","value":98616.192},{"datetime":"2021-11-26T09:00+08:00","value":98696.192}]
             * visibility : [{"datetime":"2021-11-24T10:00+08:00","value":11.2},{"datetime":"2021-11-24T11:00+08:00","value":4.48},{"datetime":"2021-11-24T12:00+08:00","value":4.67},{"datetime":"2021-11-24T13:00+08:00","value":5.09},{"datetime":"2021-11-24T14:00+08:00","value":5.89},{"datetime":"2021-11-24T15:00+08:00","value":7},{"datetime":"2021-11-24T16:00+08:00","value":8},{"datetime":"2021-11-24T17:00+08:00","value":9.33},{"datetime":"2021-11-24T18:00+08:00","value":10.18},{"datetime":"2021-11-24T19:00+08:00","value":10.18},{"datetime":"2021-11-24T20:00+08:00","value":8.62},{"datetime":"2021-11-24T21:00+08:00","value":7.47},{"datetime":"2021-11-24T22:00+08:00","value":6.22},{"datetime":"2021-11-24T23:00+08:00","value":5.33},{"datetime":"2021-11-25T00:00+08:00","value":4.87},{"datetime":"2021-11-25T01:00+08:00","value":4.67},{"datetime":"2021-11-25T02:00+08:00","value":4.31},{"datetime":"2021-11-25T03:00+08:00","value":4.15},{"datetime":"2021-11-25T04:00+08:00","value":4},{"datetime":"2021-11-25T05:00+08:00","value":3.86},{"datetime":"2021-11-25T06:00+08:00","value":3.61},{"datetime":"2021-11-25T07:00+08:00","value":3.5},{"datetime":"2021-11-25T08:00+08:00","value":3.29},{"datetime":"2021-11-25T09:00+08:00","value":3.2},{"datetime":"2021-11-25T10:00+08:00","value":3.2},{"datetime":"2021-11-25T11:00+08:00","value":3.2},{"datetime":"2021-11-25T12:00+08:00","value":3.39},{"datetime":"2021-11-25T13:00+08:00","value":3.73},{"datetime":"2021-11-25T14:00+08:00","value":4.31},{"datetime":"2021-11-25T15:00+08:00","value":4.87},{"datetime":"2021-11-25T16:00+08:00","value":5.6},{"datetime":"2021-11-25T17:00+08:00","value":5.6},{"datetime":"2021-11-25T18:00+08:00","value":5.33},{"datetime":"2021-11-25T19:00+08:00","value":4.87},{"datetime":"2021-11-25T20:00+08:00","value":4.48},{"datetime":"2021-11-25T21:00+08:00","value":4.15},{"datetime":"2021-11-25T22:00+08:00","value":4},{"datetime":"2021-11-25T23:00+08:00","value":4},{"datetime":"2021-11-26T00:00+08:00","value":4},{"datetime":"2021-11-26T01:00+08:00","value":4},{"datetime":"2021-11-26T02:00+08:00","value":3.73},{"datetime":"2021-11-26T03:00+08:00","value":3.5},{"datetime":"2021-11-26T04:00+08:00","value":3.29},{"datetime":"2021-11-26T05:00+08:00","value":3.11},{"datetime":"2021-11-26T06:00+08:00","value":2.95},{"datetime":"2021-11-26T07:00+08:00","value":2.8},{"datetime":"2021-11-26T08:00+08:00","value":2.67},{"datetime":"2021-11-26T09:00+08:00","value":2.55}]
             * dswrf : [{"datetime":"2021-11-24T10:00+08:00","value":271.4592},{"datetime":"2021-11-24T11:00+08:00","value":345.4592},{"datetime":"2021-11-24T12:00+08:00","value":402.9488},{"datetime":"2021-11-24T13:00+08:00","value":440.6688},{"datetime":"2021-11-24T14:00+08:00","value":458.1584},{"datetime":"2021-11-24T15:00+08:00","value":436.3296},{"datetime":"2021-11-24T16:00+08:00","value":357.6496},{"datetime":"2021-11-24T17:00+08:00","value":271.6496},{"datetime":"2021-11-24T18:00+08:00","value":204.2496},{"datetime":"2021-11-24T19:00+08:00","value":163.5696},{"datetime":"2021-11-24T20:00+08:00","value":136.08},{"datetime":"2021-11-24T21:00+08:00","value":0},{"datetime":"2021-11-24T22:00+08:00","value":0},{"datetime":"2021-11-24T23:00+08:00","value":0},{"datetime":"2021-11-25T00:00+08:00","value":0},{"datetime":"2021-11-25T01:00+08:00","value":0},{"datetime":"2021-11-25T02:00+08:00","value":0},{"datetime":"2021-11-25T03:00+08:00","value":0},{"datetime":"2021-11-25T04:00+08:00","value":0},{"datetime":"2021-11-25T05:00+08:00","value":0},{"datetime":"2021-11-25T06:00+08:00","value":0},{"datetime":"2021-11-25T07:00+08:00","value":0},{"datetime":"2021-11-25T08:00+08:00","value":3.7696},{"datetime":"2021-11-25T09:00+08:00","value":178.24},{"datetime":"2021-11-25T10:00+08:00","value":264.4992},{"datetime":"2021-11-25T11:00+08:00","value":338.2192},{"datetime":"2021-11-25T12:00+08:00","value":394.7088},{"datetime":"2021-11-25T13:00+08:00","value":431.9392},{"datetime":"2021-11-25T14:00+08:00","value":448.9392},{"datetime":"2021-11-25T15:00+08:00","value":427.3296},{"datetime":"2021-11-25T16:00+08:00","value":350.3296},{"datetime":"2021-11-25T17:00+08:00","value":265.6496},{"datetime":"2021-11-25T18:00+08:00","value":199.9696},{"datetime":"2021-11-25T19:00+08:00","value":159.5696},{"datetime":"2021-11-25T20:00+08:00","value":133.08},{"datetime":"2021-11-25T21:00+08:00","value":0},{"datetime":"2021-11-25T22:00+08:00","value":0},{"datetime":"2021-11-25T23:00+08:00","value":0},{"datetime":"2021-11-26T00:00+08:00","value":0},{"datetime":"2021-11-26T01:00+08:00","value":0},{"datetime":"2021-11-26T02:00+08:00","value":0},{"datetime":"2021-11-26T03:00+08:00","value":0},{"datetime":"2021-11-26T04:00+08:00","value":0},{"datetime":"2021-11-26T05:00+08:00","value":0},{"datetime":"2021-11-26T06:00+08:00","value":0},{"datetime":"2021-11-26T07:00+08:00","value":0},{"datetime":"2021-11-26T08:00+08:00","value":3.1904},{"datetime":"2021-11-26T09:00+08:00","value":172.0496}]
             * air_quality : {"aqi":[{"datetime":"2021-11-24T10:00+08:00","value":{"chn":69,"usa":69}},{"datetime":"2021-11-24T11:00+08:00","value":{"chn":75,"usa":75}},{"datetime":"2021-11-24T12:00+08:00","value":{"chn":74,"usa":74}},{"datetime":"2021-11-24T13:00+08:00","value":{"chn":71,"usa":71}},{"datetime":"2021-11-24T14:00+08:00","value":{"chn":67,"usa":67}},{"datetime":"2021-11-24T15:00+08:00","value":{"chn":64,"usa":64}},{"datetime":"2021-11-24T16:00+08:00","value":{"chn":61,"usa":61}},{"datetime":"2021-11-24T17:00+08:00","value":{"chn":59,"usa":59}},{"datetime":"2021-11-24T18:00+08:00","value":{"chn":57,"usa":57}},{"datetime":"2021-11-24T19:00+08:00","value":{"chn":57,"usa":57}},{"datetime":"2021-11-24T20:00+08:00","value":{"chn":60,"usa":60}},{"datetime":"2021-11-24T21:00+08:00","value":{"chn":62,"usa":62}},{"datetime":"2021-11-24T22:00+08:00","value":{"chn":66,"usa":66}},{"datetime":"2021-11-24T23:00+08:00","value":{"chn":70,"usa":70}},{"datetime":"2021-11-25T00:00+08:00","value":{"chn":72,"usa":72}},{"datetime":"2021-11-25T01:00+08:00","value":{"chn":74,"usa":74}},{"datetime":"2021-11-25T02:00+08:00","value":{"chn":76,"usa":76}},{"datetime":"2021-11-25T03:00+08:00","value":{"chn":77,"usa":77}},{"datetime":"2021-11-25T04:00+08:00","value":{"chn":79,"usa":79}},{"datetime":"2021-11-25T05:00+08:00","value":{"chn":80,"usa":80}},{"datetime":"2021-11-25T06:00+08:00","value":{"chn":82,"usa":82}},{"datetime":"2021-11-25T07:00+08:00","value":{"chn":84,"usa":84}},{"datetime":"2021-11-25T08:00+08:00","value":{"chn":86,"usa":86}},{"datetime":"2021-11-25T09:00+08:00","value":{"chn":87,"usa":87}},{"datetime":"2021-11-25T10:00+08:00","value":{"chn":87,"usa":87}},{"datetime":"2021-11-25T11:00+08:00","value":{"chn":87,"usa":87}},{"datetime":"2021-11-25T12:00+08:00","value":{"chn":85,"usa":85}},{"datetime":"2021-11-25T13:00+08:00","value":{"chn":81,"usa":81}},{"datetime":"2021-11-25T14:00+08:00","value":{"chn":76,"usa":76}},{"datetime":"2021-11-25T15:00+08:00","value":{"chn":72,"usa":72}},{"datetime":"2021-11-25T16:00+08:00","value":{"chn":69,"usa":69}},{"datetime":"2021-11-25T17:00+08:00","value":{"chn":69,"usa":69}},{"datetime":"2021-11-25T18:00+08:00","value":{"chn":70,"usa":70}},{"datetime":"2021-11-25T19:00+08:00","value":{"chn":72,"usa":72}},{"datetime":"2021-11-25T20:00+08:00","value":{"chn":75,"usa":75}},{"datetime":"2021-11-25T21:00+08:00","value":{"chn":77,"usa":77}},{"datetime":"2021-11-25T22:00+08:00","value":{"chn":79,"usa":79}},{"datetime":"2021-11-25T23:00+08:00","value":{"chn":79,"usa":79}},{"datetime":"2021-11-26T00:00+08:00","value":{"chn":79,"usa":79}},{"datetime":"2021-11-26T01:00+08:00","value":{"chn":79,"usa":79}},{"datetime":"2021-11-26T02:00+08:00","value":{"chn":81,"usa":81}},{"datetime":"2021-11-26T03:00+08:00","value":{"chn":84,"usa":84}},{"datetime":"2021-11-26T04:00+08:00","value":{"chn":86,"usa":86}},{"datetime":"2021-11-26T05:00+08:00","value":{"chn":89,"usa":89}},{"datetime":"2021-11-26T06:00+08:00","value":{"chn":91,"usa":91}},{"datetime":"2021-11-26T07:00+08:00","value":{"chn":94,"usa":94}},{"datetime":"2021-11-26T08:00+08:00","value":{"chn":96,"usa":96}},{"datetime":"2021-11-26T09:00+08:00","value":{"chn":99,"usa":99}}],"pm25":[{"datetime":"2021-11-24T10:00+08:00","value":32},{"datetime":"2021-11-24T11:00+08:00","value":55},{"datetime":"2021-11-24T12:00+08:00","value":54},{"datetime":"2021-11-24T13:00+08:00","value":52},{"datetime":"2021-11-24T14:00+08:00","value":49},{"datetime":"2021-11-24T15:00+08:00","value":46},{"datetime":"2021-11-24T16:00+08:00","value":44},{"datetime":"2021-11-24T17:00+08:00","value":42},{"datetime":"2021-11-24T18:00+08:00","value":41},{"datetime":"2021-11-24T19:00+08:00","value":41},{"datetime":"2021-11-24T20:00+08:00","value":43},{"datetime":"2021-11-24T21:00+08:00","value":45},{"datetime":"2021-11-24T22:00+08:00","value":48},{"datetime":"2021-11-24T23:00+08:00","value":51},{"datetime":"2021-11-25T00:00+08:00","value":53},{"datetime":"2021-11-25T01:00+08:00","value":54},{"datetime":"2021-11-25T02:00+08:00","value":56},{"datetime":"2021-11-25T03:00+08:00","value":57},{"datetime":"2021-11-25T04:00+08:00","value":58},{"datetime":"2021-11-25T05:00+08:00","value":59},{"datetime":"2021-11-25T06:00+08:00","value":61},{"datetime":"2021-11-25T07:00+08:00","value":62},{"datetime":"2021-11-25T08:00+08:00","value":64},{"datetime":"2021-11-25T09:00+08:00","value":65},{"datetime":"2021-11-25T10:00+08:00","value":65},{"datetime":"2021-11-25T11:00+08:00","value":65},{"datetime":"2021-11-25T12:00+08:00","value":63},{"datetime":"2021-11-25T13:00+08:00","value":60},{"datetime":"2021-11-25T14:00+08:00","value":56},{"datetime":"2021-11-25T15:00+08:00","value":53},{"datetime":"2021-11-25T16:00+08:00","value":50},{"datetime":"2021-11-25T17:00+08:00","value":50},{"datetime":"2021-11-25T18:00+08:00","value":51},{"datetime":"2021-11-25T19:00+08:00","value":53},{"datetime":"2021-11-25T20:00+08:00","value":55},{"datetime":"2021-11-25T21:00+08:00","value":57},{"datetime":"2021-11-25T22:00+08:00","value":58},{"datetime":"2021-11-25T23:00+08:00","value":58},{"datetime":"2021-11-26T00:00+08:00","value":58},{"datetime":"2021-11-26T01:00+08:00","value":58},{"datetime":"2021-11-26T02:00+08:00","value":60},{"datetime":"2021-11-26T03:00+08:00","value":62},{"datetime":"2021-11-26T04:00+08:00","value":64},{"datetime":"2021-11-26T05:00+08:00","value":66},{"datetime":"2021-11-26T06:00+08:00","value":68},{"datetime":"2021-11-26T07:00+08:00","value":70},{"datetime":"2021-11-26T08:00+08:00","value":72},{"datetime":"2021-11-26T09:00+08:00","value":74}]}
             */

            private String status;
            private String description;
            private AirQualityBeanX air_quality;
            private List<PrecipitationBeanX> precipitation;
            private List<TemperatureBean> temperature;
            private List<WindBeanX> wind;
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

            public AirQualityBeanX getAir_quality() {
                return air_quality;
            }

            public void setAir_quality(AirQualityBeanX air_quality) {
                this.air_quality = air_quality;
            }

            public List<PrecipitationBeanX> getPrecipitation() {
                return precipitation;
            }

            public void setPrecipitation(List<PrecipitationBeanX> precipitation) {
                this.precipitation = precipitation;
            }

            public List<TemperatureBean> getTemperature() {
                return temperature;
            }

            public void setTemperature(List<TemperatureBean> temperature) {
                this.temperature = temperature;
            }

            public List<WindBeanX> getWind() {
                return wind;
            }

            public void setWind(List<WindBeanX> wind) {
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

            public static class AirQualityBeanX {
                private List<AqiBeanX> aqi;
                private List<Pm25Bean> pm25;

                public List<AqiBeanX> getAqi() {
                    return aqi;
                }

                public void setAqi(List<AqiBeanX> aqi) {
                    this.aqi = aqi;
                }

                public List<Pm25Bean> getPm25() {
                    return pm25;
                }

                public void setPm25(List<Pm25Bean> pm25) {
                    this.pm25 = pm25;
                }

                public static class AqiBeanX {
                    /**
                     * datetime : 2021-11-24T10:00+08:00
                     * value : {"chn":69,"usa":69}
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
                         * chn : 69
                         * usa : 69
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
                     * datetime : 2021-11-24T10:00+08:00
                     * value : 32
                     */

                    private String datetime;
                    private int value;

                    public String getDatetime() {
                        return datetime;
                    }

                    public void setDatetime(String datetime) {
                        this.datetime = datetime;
                    }

                    public int getValue() {
                        return value;
                    }

                    public void setValue(int value) {
                        this.value = value;
                    }
                }
            }

            public static class PrecipitationBeanX {
                /**
                 * datetime : 2021-11-24T10:00+08:00
                 * value : 0
                 */

                private String datetime;
                private int value;

                public String getDatetime() {
                    return datetime;
                }

                public void setDatetime(String datetime) {
                    this.datetime = datetime;
                }

                public int getValue() {
                    return value;
                }

                public void setValue(int value) {
                    this.value = value;
                }
            }

            public static class TemperatureBean {
                /**
                 * datetime : 2021-11-24T10:00+08:00
                 * value : 9
                 */

                private String datetime;
                private int value;

                public String getDatetime() {
                    return datetime;
                }

                public void setDatetime(String datetime) {
                    this.datetime = datetime;
                }

                public int getValue() {
                    return value;
                }

                public void setValue(int value) {
                    this.value = value;
                }
            }

            public static class WindBeanX {
                /**
                 * datetime : 2021-11-24T10:00+08:00
                 * speed : 6.12
                 * direction : 249
                 */

                private String datetime;
                private double speed;
                private int direction;

                public String getDatetime() {
                    return datetime;
                }

                public void setDatetime(String datetime) {
                    this.datetime = datetime;
                }

                public double getSpeed() {
                    return speed;
                }

                public void setSpeed(double speed) {
                    this.speed = speed;
                }

                public int getDirection() {
                    return direction;
                }

                public void setDirection(int direction) {
                    this.direction = direction;
                }
            }

            public static class HumidityBean {
                /**
                 * datetime : 2021-11-24T10:00+08:00
                 * value : 0.33
                 */

                private String datetime;
                private double value;

                public String getDatetime() {
                    return datetime;
                }

                public void setDatetime(String datetime) {
                    this.datetime = datetime;
                }

                public double getValue() {
                    return value;
                }

                public void setValue(double value) {
                    this.value = value;
                }
            }

            public static class CloudrateBean {
                /**
                 * datetime : 2021-11-24T10:00+08:00
                 * value : 0
                 */

                private String datetime;
                private int value;

                public String getDatetime() {
                    return datetime;
                }

                public void setDatetime(String datetime) {
                    this.datetime = datetime;
                }

                public int getValue() {
                    return value;
                }

                public void setValue(int value) {
                    this.value = value;
                }
            }

            public static class SkyconBean {
                /**
                 * datetime : 2021-11-24T10:00+08:00
                 * value : CLEAR_DAY
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
                 * datetime : 2021-11-24T10:00+08:00
                 * value : 97873.792
                 */

                private String datetime;
                private double value;

                public String getDatetime() {
                    return datetime;
                }

                public void setDatetime(String datetime) {
                    this.datetime = datetime;
                }

                public double getValue() {
                    return value;
                }

                public void setValue(double value) {
                    this.value = value;
                }
            }

            public static class VisibilityBean {
                /**
                 * datetime : 2021-11-24T10:00+08:00
                 * value : 11.2
                 */

                private String datetime;
                private double value;

                public String getDatetime() {
                    return datetime;
                }

                public void setDatetime(String datetime) {
                    this.datetime = datetime;
                }

                public double getValue() {
                    return value;
                }

                public void setValue(double value) {
                    this.value = value;
                }
            }

            public static class DswrfBean {
                /**
                 * datetime : 2021-11-24T10:00+08:00
                 * value : 271.4592
                 */

                private String datetime;
                private double value;

                public String getDatetime() {
                    return datetime;
                }

                public void setDatetime(String datetime) {
                    this.datetime = datetime;
                }

                public double getValue() {
                    return value;
                }

                public void setValue(double value) {
                    this.value = value;
                }
            }
        }

        public static class DailyBean {
            /**
             * status : ok
             * astro : [{"date":"2021-11-24T00:00+08:00","sunrise":{"time":"07:12"},"sunset":{"time":"17:19"}},{"date":"2021-11-25T00:00+08:00","sunrise":{"time":"07:13"},"sunset":{"time":"17:19"}},{"date":"2021-11-26T00:00+08:00","sunrise":{"time":"07:14"},"sunset":{"time":"17:19"}},{"date":"2021-11-27T00:00+08:00","sunrise":{"time":"07:15"},"sunset":{"time":"17:18"}},{"date":"2021-11-28T00:00+08:00","sunrise":{"time":"07:16"},"sunset":{"time":"17:18"}}]
             * precipitation : [{"date":"2021-11-24T00:00+08:00","max":0,"min":0,"avg":0},{"date":"2021-11-25T00:00+08:00","max":0,"min":0,"avg":0},{"date":"2021-11-26T00:00+08:00","max":0,"min":0,"avg":0},{"date":"2021-11-27T00:00+08:00","max":0,"min":0,"avg":0},{"date":"2021-11-28T00:00+08:00","max":0,"min":0,"avg":0}]
             * temperature : [{"date":"2021-11-24T00:00+08:00","max":15.5,"min":1,"avg":10.39},{"date":"2021-11-25T00:00+08:00","max":16,"min":3,"avg":9.3},{"date":"2021-11-26T00:00+08:00","max":13,"min":3,"avg":7.77},{"date":"2021-11-27T00:00+08:00","max":11,"min":4,"avg":7.67},{"date":"2021-11-28T00:00+08:00","max":14,"min":6,"avg":9.56}]
             * wind : [{"date":"2021-11-24T00:00+08:00","max":{"speed":16.07,"direction":278.95},"min":{"speed":6.12,"direction":249},"avg":{"speed":10.43,"direction":296.25}},{"date":"2021-11-25T00:00+08:00","max":{"speed":10.09,"direction":317.73},"min":{"speed":2.64,"direction":273.84},"avg":{"speed":7.21,"direction":313.74}},{"date":"2021-11-26T00:00+08:00","max":{"speed":10.73,"direction":115.85},"min":{"speed":4.85,"direction":12.59},"avg":{"speed":7.74,"direction":45.25}},{"date":"2021-11-27T00:00+08:00","max":{"speed":10.72,"direction":57.83},"min":{"speed":4.15,"direction":65.38},"avg":{"speed":6.34,"direction":72.65}},{"date":"2021-11-28T00:00+08:00","max":{"speed":6.65,"direction":109.12},"min":{"speed":1.61,"direction":239.12},"avg":{"speed":4.62,"direction":44.3}}]
             * humidity : [{"date":"2021-11-24T00:00+08:00","max":0.44,"min":0.2,"avg":0.29},{"date":"2021-11-25T00:00+08:00","max":0.37,"min":0.2,"avg":0.31},{"date":"2021-11-26T00:00+08:00","max":0.49,"min":0.29,"avg":0.38},{"date":"2021-11-27T00:00+08:00","max":0.61,"min":0.42,"avg":0.51},{"date":"2021-11-28T00:00+08:00","max":0.79,"min":0.52,"avg":0.66}]
             * cloudrate : [{"date":"2021-11-24T00:00+08:00","max":0,"min":0,"avg":0},{"date":"2021-11-25T00:00+08:00","max":0,"min":0,"avg":0},{"date":"2021-11-26T00:00+08:00","max":1,"min":0,"avg":0.41},{"date":"2021-11-27T00:00+08:00","max":1,"min":0.85,"avg":0.99},{"date":"2021-11-28T00:00+08:00","max":0.94,"min":0.05,"avg":0.27}]
             * pressure : [{"date":"2021-11-24T00:00+08:00","max":97994.62,"min":97506.56,"avg":97691.33},{"date":"2021-11-25T00:00+08:00","max":98164.99,"min":97764.99,"avg":97930.39},{"date":"2021-11-26T00:00+08:00","max":98753.79,"min":98219.39,"avg":98544.53},{"date":"2021-11-27T00:00+08:00","max":98769.02,"min":98360.96,"avg":98576.15},{"date":"2021-11-28T00:00+08:00","max":98513.79,"min":98219.39,"avg":98389.3}]
             * visibility : [{"date":"2021-11-24T00:00+08:00","max":24.13,"min":4.48,"avg":7.4},{"date":"2021-11-25T00:00+08:00","max":5.6,"min":3.2,"avg":4.17},{"date":"2021-11-26T00:00+08:00","max":4,"min":2.49,"avg":3.06},{"date":"2021-11-27T00:00+08:00","max":2.8,"min":2.11,"avg":2.44},{"date":"2021-11-28T00:00+08:00","max":3.73,"min":1.25,"avg":2.59}]
             * dswrf : [{"date":"2021-11-24T00:00+08:00","max":458.2,"min":0,"avg":249.2},{"date":"2021-11-25T00:00+08:00","max":448.9,"min":0,"avg":149.8},{"date":"2021-11-26T00:00+08:00","max":439.3,"min":0,"avg":142.2},{"date":"2021-11-27T00:00+08:00","max":242.1,"min":0,"avg":74.4},{"date":"2021-11-28T00:00+08:00","max":412.6,"min":0,"avg":136.5}]
             * air_quality : {"aqi":[{"date":"2021-11-24T00:00+08:00","max":{"chn":103,"usa":103},"avg":{"chn":65.14,"usa":65.14},"min":{"chn":57,"usa":57}},{"date":"2021-11-25T00:00+08:00","max":{"chn":87,"usa":87},"avg":{"chn":78.12,"usa":78.12},"min":{"chn":69,"usa":69}},{"date":"2021-11-26T00:00+08:00","max":{"chn":100,"usa":100},"avg":{"chn":90.17,"usa":90.17},"min":{"chn":79,"usa":79}},{"date":"2021-11-27T00:00+08:00","max":{"chn":110,"usa":110},"avg":{"chn":101.38,"usa":101.38},"min":{"chn":94,"usa":94}},{"date":"2021-11-28T00:00+08:00","max":{"chn":110,"usa":110},"avg":{"chn":94.42,"usa":94.42},"min":{"chn":81,"usa":81}}],"pm25":[{"date":"2021-11-24T00:00+08:00","max":56,"avg":45.93,"min":32},{"date":"2021-11-25T00:00+08:00","max":65,"avg":57.62,"min":50},{"date":"2021-11-26T00:00+08:00","max":75,"avg":67.21,"min":58},{"date":"2021-11-27T00:00+08:00","max":83,"avg":76.21,"min":70},{"date":"2021-11-28T00:00+08:00","max":83,"avg":70.67,"min":60}]}
             * skycon : [{"date":"2021-11-24T00:00+08:00","value":"CLEAR_DAY"},{"date":"2021-11-25T00:00+08:00","value":"CLEAR_DAY"},{"date":"2021-11-26T00:00+08:00","value":"PARTLY_CLOUDY_DAY"},{"date":"2021-11-27T00:00+08:00","value":"LIGHT_HAZE"},{"date":"2021-11-28T00:00+08:00","value":"PARTLY_CLOUDY_DAY"}]
             * skycon_08h_20h : [{"date":"2021-11-24T00:00+08:00","value":"CLEAR_DAY"},{"date":"2021-11-25T00:00+08:00","value":"CLEAR_DAY"},{"date":"2021-11-26T00:00+08:00","value":"PARTLY_CLOUDY_DAY"},{"date":"2021-11-27T00:00+08:00","value":"LIGHT_HAZE"},{"date":"2021-11-28T00:00+08:00","value":"CLEAR_DAY"}]
             * skycon_20h_32h : [{"date":"2021-11-24T00:00+08:00","value":"CLEAR_NIGHT"},{"date":"2021-11-25T00:00+08:00","value":"CLEAR_NIGHT"},{"date":"2021-11-26T00:00+08:00","value":"CLOUDY"},{"date":"2021-11-27T00:00+08:00","value":"PARTLY_CLOUDY_NIGHT"},{"date":"2021-11-28T00:00+08:00","value":"PARTLY_CLOUDY_NIGHT"}]
             * life_index : {"ultraviolet":[{"date":"2021-11-24T00:00+08:00","index":"4","desc":"强"},{"date":"2021-11-25T00:00+08:00","index":"4","desc":"强"},{"date":"2021-11-26T00:00+08:00","index":"4","desc":"强"},{"date":"2021-11-27T00:00+08:00","index":"1","desc":"最弱"},{"date":"2021-11-28T00:00+08:00","index":"4","desc":"强"}],"carWashing":[{"date":"2021-11-24T00:00+08:00","index":"2","desc":"较适宜"},{"date":"2021-11-25T00:00+08:00","index":"2","desc":"较适宜"},{"date":"2021-11-26T00:00+08:00","index":"2","desc":"较适宜"},{"date":"2021-11-27T00:00+08:00","index":"2","desc":"较适宜"},{"date":"2021-11-28T00:00+08:00","index":"2","desc":"较适宜"}],"dressing":[{"date":"2021-11-24T00:00+08:00","index":"5","desc":"凉爽"},{"date":"2021-11-25T00:00+08:00","index":"6","desc":"冷"},{"date":"2021-11-26T00:00+08:00","index":"6","desc":"冷"},{"date":"2021-11-27T00:00+08:00","index":"6","desc":"冷"},{"date":"2021-11-28T00:00+08:00","index":"6","desc":"冷"}],"comfort":[{"date":"2021-11-24T00:00+08:00","index":"8","desc":"很冷"},{"date":"2021-11-25T00:00+08:00","index":"8","desc":"很冷"},{"date":"2021-11-26T00:00+08:00","index":"8","desc":"很冷"},{"date":"2021-11-27T00:00+08:00","index":"8","desc":"很冷"},{"date":"2021-11-28T00:00+08:00","index":"8","desc":"很冷"}],"coldRisk":[{"date":"2021-11-24T00:00+08:00","index":"4","desc":"极易发"},{"date":"2021-11-25T00:00+08:00","index":"4","desc":"极易发"},{"date":"2021-11-26T00:00+08:00","index":"4","desc":"极易发"},{"date":"2021-11-27T00:00+08:00","index":"3","desc":"易发"},{"date":"2021-11-28T00:00+08:00","index":"4","desc":"极易发"}]}
             */

            private String status;
            private AirQualityBeanXX air_quality;
            private LifeIndexBeanX life_index;
            private List<AstroBean> astro;
            private List<PrecipitationBeanXX> precipitation;
            private List<TemperatureBeanX> temperature;
            private List<WindBeanXX> wind;
            private List<HumidityBeanX> humidity;
            private List<CloudrateBeanX> cloudrate;
            private List<PressureBeanX> pressure;
            private List<VisibilityBeanX> visibility;
            private List<DswrfBeanX> dswrf;
            private List<SkyconBeanX> skycon;
            private List<Skycon08h20hBean> skycon_08h_20h;
            private List<Skycon20h32hBean> skycon_20h_32h;

            public String getStatus() {
                return status;
            }

            public void setStatus(String status) {
                this.status = status;
            }

            public AirQualityBeanXX getAir_quality() {
                return air_quality;
            }

            public void setAir_quality(AirQualityBeanXX air_quality) {
                this.air_quality = air_quality;
            }

            public LifeIndexBeanX getLife_index() {
                return life_index;
            }

            public void setLife_index(LifeIndexBeanX life_index) {
                this.life_index = life_index;
            }

            public List<AstroBean> getAstro() {
                return astro;
            }

            public void setAstro(List<AstroBean> astro) {
                this.astro = astro;
            }

            public List<PrecipitationBeanXX> getPrecipitation() {
                return precipitation;
            }

            public void setPrecipitation(List<PrecipitationBeanXX> precipitation) {
                this.precipitation = precipitation;
            }

            public List<TemperatureBeanX> getTemperature() {
                return temperature;
            }

            public void setTemperature(List<TemperatureBeanX> temperature) {
                this.temperature = temperature;
            }

            public List<WindBeanXX> getWind() {
                return wind;
            }

            public void setWind(List<WindBeanXX> wind) {
                this.wind = wind;
            }

            public List<HumidityBeanX> getHumidity() {
                return humidity;
            }

            public void setHumidity(List<HumidityBeanX> humidity) {
                this.humidity = humidity;
            }

            public List<CloudrateBeanX> getCloudrate() {
                return cloudrate;
            }

            public void setCloudrate(List<CloudrateBeanX> cloudrate) {
                this.cloudrate = cloudrate;
            }

            public List<PressureBeanX> getPressure() {
                return pressure;
            }

            public void setPressure(List<PressureBeanX> pressure) {
                this.pressure = pressure;
            }

            public List<VisibilityBeanX> getVisibility() {
                return visibility;
            }

            public void setVisibility(List<VisibilityBeanX> visibility) {
                this.visibility = visibility;
            }

            public List<DswrfBeanX> getDswrf() {
                return dswrf;
            }

            public void setDswrf(List<DswrfBeanX> dswrf) {
                this.dswrf = dswrf;
            }

            public List<SkyconBeanX> getSkycon() {
                return skycon;
            }

            public void setSkycon(List<SkyconBeanX> skycon) {
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

            public static class AirQualityBeanXX {
                private List<AqiBeanXX> aqi;
                private List<Pm25BeanX> pm25;

                public List<AqiBeanXX> getAqi() {
                    return aqi;
                }

                public void setAqi(List<AqiBeanXX> aqi) {
                    this.aqi = aqi;
                }

                public List<Pm25BeanX> getPm25() {
                    return pm25;
                }

                public void setPm25(List<Pm25BeanX> pm25) {
                    this.pm25 = pm25;
                }

                public static class AqiBeanXX {
                    /**
                     * date : 2021-11-24T00:00+08:00
                     * max : {"chn":103,"usa":103}
                     * avg : {"chn":65.14,"usa":65.14}
                     * min : {"chn":57,"usa":57}
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
                         * chn : 103
                         * usa : 103
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
                         * chn : 65.14
                         * usa : 65.14
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
                         * chn : 57
                         * usa : 57
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

                public static class Pm25BeanX {
                    /**
                     * date : 2021-11-24T00:00+08:00
                     * max : 56
                     * avg : 45.93
                     * min : 32
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

            public static class LifeIndexBeanX {
                private List<UltravioletBeanX> ultraviolet;
                private List<CarWashingBean> carWashing;
                private List<DressingBean> dressing;
                private List<ComfortBeanX> comfort;
                private List<ColdRiskBean> coldRisk;

                public List<UltravioletBeanX> getUltraviolet() {
                    return ultraviolet;
                }

                public void setUltraviolet(List<UltravioletBeanX> ultraviolet) {
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

                public List<ComfortBeanX> getComfort() {
                    return comfort;
                }

                public void setComfort(List<ComfortBeanX> comfort) {
                    this.comfort = comfort;
                }

                public List<ColdRiskBean> getColdRisk() {
                    return coldRisk;
                }

                public void setColdRisk(List<ColdRiskBean> coldRisk) {
                    this.coldRisk = coldRisk;
                }

                public static class UltravioletBeanX {
                    /**
                     * date : 2021-11-24T00:00+08:00
                     * index : 4
                     * desc : 强
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
                     * date : 2021-11-24T00:00+08:00
                     * index : 2
                     * desc : 较适宜
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
                     * date : 2021-11-24T00:00+08:00
                     * index : 5
                     * desc : 凉爽
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

                public static class ComfortBeanX {
                    /**
                     * date : 2021-11-24T00:00+08:00
                     * index : 8
                     * desc : 很冷
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
                     * date : 2021-11-24T00:00+08:00
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
                 * date : 2021-11-24T00:00+08:00
                 * sunrise : {"time":"07:12"}
                 * sunset : {"time":"17:19"}
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
                     * time : 07:12
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
                     * time : 17:19
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

            public static class PrecipitationBeanXX {
                /**
                 * date : 2021-11-24T00:00+08:00
                 * max : 0
                 * min : 0
                 * avg : 0
                 */

                private String date;
                private int max;
                private int min;
                private int avg;

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

                public int getMin() {
                    return min;
                }

                public void setMin(int min) {
                    this.min = min;
                }

                public int getAvg() {
                    return avg;
                }

                public void setAvg(int avg) {
                    this.avg = avg;
                }
            }

            public static class TemperatureBeanX {
                /**
                 * date : 2021-11-24T00:00+08:00
                 * max : 15.5
                 * min : 1
                 * avg : 10.39
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

            public static class WindBeanXX {
                /**
                 * date : 2021-11-24T00:00+08:00
                 * max : {"speed":16.07,"direction":278.95}
                 * min : {"speed":6.12,"direction":249}
                 * avg : {"speed":10.43,"direction":296.25}
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
                     * speed : 16.07
                     * direction : 278.95
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
                     * speed : 6.12
                     * direction : 249
                     */

                    private double speed;
                    private int direction;

                    public double getSpeed() {
                        return speed;
                    }

                    public void setSpeed(double speed) {
                        this.speed = speed;
                    }

                    public int getDirection() {
                        return direction;
                    }

                    public void setDirection(int direction) {
                        this.direction = direction;
                    }
                }

                public static class AvgBeanX {
                    /**
                     * speed : 10.43
                     * direction : 296.25
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

            public static class HumidityBeanX {
                /**
                 * date : 2021-11-24T00:00+08:00
                 * max : 0.44
                 * min : 0.2
                 * avg : 0.29
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

            public static class CloudrateBeanX {
                /**
                 * date : 2021-11-24T00:00+08:00
                 * max : 0
                 * min : 0
                 * avg : 0
                 */

                private String date;
                private int max;
                private int min;
                private int avg;

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

                public int getMin() {
                    return min;
                }

                public void setMin(int min) {
                    this.min = min;
                }

                public int getAvg() {
                    return avg;
                }

                public void setAvg(int avg) {
                    this.avg = avg;
                }
            }

            public static class PressureBeanX {
                /**
                 * date : 2021-11-24T00:00+08:00
                 * max : 97994.62
                 * min : 97506.56
                 * avg : 97691.33
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

            public static class VisibilityBeanX {
                /**
                 * date : 2021-11-24T00:00+08:00
                 * max : 24.13
                 * min : 4.48
                 * avg : 7.4
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

            public static class DswrfBeanX {
                /**
                 * date : 2021-11-24T00:00+08:00
                 * max : 458.2
                 * min : 0
                 * avg : 249.2
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

            public static class SkyconBeanX {
                /**
                 * date : 2021-11-24T00:00+08:00
                 * value : CLEAR_DAY
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
                 * date : 2021-11-24T00:00+08:00
                 * value : CLEAR_DAY
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
                 * date : 2021-11-24T00:00+08:00
                 * value : CLEAR_NIGHT
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
