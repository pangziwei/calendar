package com.juyou.calendar.bo;

import android.content.Context;
import android.util.Log;

import com.google.gson.Gson;
import com.juyou.calendar.constant.WeatherContentUtil;
import com.juyou.calendar.util.SystemUtil;
import com.manggeek.android.geek.http.GeekHttp;
import com.manggeek.android.geek.http.HttpParams;

import java.util.List;


public class LoveChallengeBo {

    //登录
    public static void Login(Context context, String telephone, String captcha, NetResultCallBack listener) {
        //参数
        BaseParams httpParams = new BaseParams();
        httpParams.put("telephone", telephone);
        httpParams.put("captcha", captcha);
        httpParams.put("systemMode", SystemUtil.getSystemModel());//获取手机型号
        httpParams.put("deviceBrand", SystemUtil.getDeviceBrand());//获取手机厂商systemMode, deviceBrand
        GeekHttp.getHttp().postJson(0, Api.BaseUrl + "login", httpParams, listener);
        Log.e("TAG", "登录的url---------" + Api.BaseUrl + "login");
        Log.e("TAG", "登录的url---httpParams------" + httpParams);
    }

//    //    请求示例
////    https://v0.yiketianqi.com/api?unescape=1&version=v62&appid=69384542&appsecret=4QxOcjyX
////    请求参数说明：
////    参数名	必选	类型	说明	备注（示例）
////    appid	是	string	用户appid	注册开发账号
////    appsecret	是	string	用户appsecret
////    version	是	string	接口版本标识	固定值: v62 每个接口的version值都不一样
////    cityid	否	string	城市ID	请参考 城市ID列表
////    city	否	string	城市名称	不要带市和区; 如: 青岛、铁西
////    province	否	string	所在省	如果您担心city重名可传此参数, 不要带省和市; 如: 山东、上海
////    ip	否	string	IP地址	查询IP所在城市天气
////    lng	否	String	经度	如: 119.545023 (需付费开通lbs权限, 500/年, 2000/5年)
////    lat	否	String	纬度	如: 36.044254
////    point	否	String	坐标体系	默认百度坐标, 如使用高德坐标, 请传参: gaode
////    callback	否	string	jsonp参数	如: jQuery.Callbacks
////    vue	否	string	跨域参数	如果您使用的是react、vue、angular请填写值: 1
////    unescape	否	Int	是否转义中文	如果您希望json不被unicode, 直接输出中文, 请传此参数: 1
//    public static void GetTest(Context context,String unescape, String version, String appid, String appsecret, NetResultCallBack listener) {
//        BaseMyParams Params = new BaseMyParams();
//        Params.put("unescape", unescape);
//        Params.put("version", version);
//        Params.put("appid", appid);
//        Params.put("appsecret",appsecret);
//        GeekHttp.getHttp().get(context, 0, Api.YKWeatherUrl + "api", Params, listener);
//        Log.e("weather", "天气测试的数据--------" + Api.YKWeatherUrl + "api");
//        Log.e("weather", "天气测试的数据---httpParams------" + new Gson().toJson(Params));
//    }


    //【我的】 用户价值IP 实体类 UserIpSimple
    public static void UserIpSimple(Context context, NetResultCallBack listener) {
        BaseParams httpParams = new BaseParams();
        BaseHeadParams headParams = new BaseHeadParams();
        GeekHttp.getHttp().get(context, 0, Api.BaseUrl + "user/digitalips/worth/simple", httpParams, headParams, listener);
    }

    //58账号密码登陆
    //code返回455--没有该用户请注册 code返回456--该用户没有设置密码请设置密码 code返回451--账号已被禁用 code 返回500 内部服务错误
    public static void pwdLogin(Context context, String telephone, String pwd, NetResultCallBack listener) {
        BaseParams httpParams = new BaseParams();
        BaseHeadParams headParams = new BaseHeadParams();
        httpParams.put("telephone", telephone);
        httpParams.put("pwd", pwd);
        GeekHttp.getHttp().postJson(0, Api.BaseUrl + "api/v2/login", httpParams, headParams, listener);
    }


    //【我的】 我的ip价值、份额等 实体类 MineIpAndnum
    public static void MineIpAndNum(Context context, NetResultCallBack listener) {
        HttpParams httpParams = new HttpParams();
        BaseHeadParams headParams = new BaseHeadParams();
        GeekHttp.getHttp().get(context, 0, Api.BaseUrl + "user/digitalips/worth/info", httpParams, headParams, listener);
    }


    public static void SendSms(Context context, String telephone, String smsType, NetResultCallBack listener) {
        HttpParams httpParams = new HttpParams();
        httpParams.put("telephone", telephone);
        httpParams.put("type", smsType);

        GeekHttp.getHttp().get(0, Api.BaseUrl + "sms/send", httpParams, listener);

    }


    //【学习互动】置顶文章列表
    public static void ArticleList(Context context, NetResultCallBack listener) {
        BaseParams httpParams = new BaseParams();
        BaseHeadParams headParams = new BaseHeadParams();
        GeekHttp.getHttp().get(context, 0, Api.BaseUrl + "articles/tops", httpParams, headParams, listener);
    }

    //【学习互动】互动列表 实体类StudyEntry
    public static void StudyList(Context context, String lastId, String size, NetResultCallBack listener) {
        BaseParams httpParams = new BaseParams();
        httpParams.put("lastId", lastId);
        httpParams.put("size", size);
        BaseHeadParams headParams = new BaseHeadParams();

//        Log.e("TAG", "【学习互动】互动列表 httpParams----"+httpParams);
//        Log.e("TAG", "【学习互动】互动列表 headParams----"+headParams);
//        Log.e("TAG", "【学习互动】互动列表 url----"+Api.BaseUrl + "interacts");

        GeekHttp.getHttp().get(context, 0, Api.BaseUrl + "interacts", httpParams, headParams, listener);
    }

    //【学习互动】互动详情 实体类StudyEntry
    public static void StudyDeatil(Context context, String id, NetResultCallBack listener) {
        BaseParams httpParams = new BaseParams();
        httpParams.put("id", id);
        BaseHeadParams headParams = new BaseHeadParams();
        GeekHttp.getHttp().get(context, 0, Api.BaseUrl + "interacts/info", httpParams, headParams, listener);
    }


    //【学习互动】互动点赞/取消点赞
    public static void StudyZan(Context context, String id, String status, NetResultCallBack listener) {
        BaseParams httpParams = new BaseParams();
        httpParams.put("id", id);
        httpParams.put("status", status);//0-取消点赞，1-点赞
        BaseHeadParams headParams = new BaseHeadParams();
        GeekHttp.getHttp().postJson(0, Api.BaseUrl + "interacts/like", httpParams, headParams, listener);
    }

    //【学习互动】发表互动评论
    public static void StudyComment(Context context, String id, String content, List<String> images, NetResultCallBack listener) {
        BaseParams httpParams = new BaseParams();
        httpParams.put("id", id);
        httpParams.put("content", content);
        if (images.size() != 0) {
            httpParams.put("images", images);
        }
        BaseHeadParams headParams = new BaseHeadParams();
        Log.e("TAG", "发表互动评论 httpParams----" + httpParams);
        Log.e("TAG", "发表互动评论 headParams----" + headParams);
        Log.e("TAG", "发表互动评论 url----" + Api.BaseUrl + "interacts/comment");
        GeekHttp.getHttp().postJson(0, Api.BaseUrl + "interacts/comment", httpParams, headParams, listener);
    }

    //【学习互动】互动评论列表 实体类CommentsEntry
    public static void StudyCommentList(Context context, String interactId, String lastId, String size, NetResultCallBack listener) {
        BaseParams httpParams = new BaseParams();
        httpParams.put("interactId", interactId);
        httpParams.put("lastId", lastId);
        httpParams.put("size", size);
        BaseHeadParams headParams = new BaseHeadParams();
        GeekHttp.getHttp().get(context, 0, Api.BaseUrl + "interacts/comments", httpParams, headParams, listener);
    }


    // 设置用户推送cid
    public static void SubmitCid(Context context, String cid, NetResultCallBack listener) {
        BaseParams httpParams = new BaseParams();
        httpParams.put("cid", cid);
        BaseHeadParams headParams = new BaseHeadParams();
        Log.e("CID", "headParams------------" + new Gson().toJson(headParams));
        Log.e("CID", "httpParams------------" + new Gson().toJson(httpParams));
        GeekHttp.getHttp().postJson(0, Api.BaseUrl + "users/set_push_cid", httpParams, headParams, listener);
    }


    public static void getReadNumb(Context context, String id, NetResultCallBack listener) {
        BaseParams httpParams = new BaseParams();
        httpParams.put("id", id);
        BaseHeadParams headParams = new BaseHeadParams();
        Log.e("TAG", "修改动态信息-------------" + Api.BaseUrl + "/dynamic/update");
        GeekHttp.getHttp().postJson(0, Api.BaseUrl + "/dynamic/update", httpParams, headParams, listener);
    }

    /**
     * 46-获取动态列表
     * GET - /dynamic/top
     */

    public static void getDynamicTop(Context context, NetResultCallBack listener) {
        BaseParams httpParams = new BaseParams();
        GeekHttp.getHttp().get(context, 0, Api.BaseUrl + "dynamic/top", httpParams, listener);
    }


    //首页 轮播
    public static void getBannerInfo(Context context, String id, NetResultCallBack listener) {
        BaseParams httpParams = new BaseParams();
        httpParams.put("id", id);
        BaseHeadParams headParams = new BaseHeadParams();
        Log.e("TAG", "首页轮播-------------" + Api.BaseUrl + "/dynamic/info");
        GeekHttp.getHttp().get(context, 0, Api.BaseUrl + "/dynamic/info", httpParams, headParams, listener);
    }


    //60判断用户是否设置密码或者是否注册
    /*判断用户状态 0未注册 1未设置密码 2设置密码*/
    public static void isRegistered(Context context, String telephone, NetResultCallBack listener) {
        BaseParams httpParams = new BaseParams();
        BaseHeadParams headParams = new BaseHeadParams();
        httpParams.put("telephone", telephone);
        GeekHttp.getHttp().get(context, 0, Api.BaseUrl + "userWhetherExist", httpParams, headParams, listener);
    }

    //合伙人 退出合伙人
    public static void GetPartnerOut(Context context, NetResultCallBack listener) {
        BaseParams httpParams = new BaseParams();
        BaseHeadParams headParams = new BaseHeadParams();
        GeekHttp.getHttp().get(context, 0, Api.BaseUrl + "digitalPartner/cancel", httpParams, headParams, listener);
    }

    // 判断是否有上级
    //登录
    public static void TestLogin(String username, String password, String appid, NetResultCallBack listener) {
        //参数
        BaseParams httpParams = new BaseParams();
        httpParams.put("username", username);
        httpParams.put("password", password);
        httpParams.put("appid", appid);
        GeekHttp.getHttp().postJson(0, Api.BaseUrl + "user/login", httpParams, listener);
        Log.e("测试登录接口", "登录的url---------" + Api.BaseUrl + "user/login");
        Log.e("测试登录接口", "登录的url---httpParams------" + httpParams);
    }
}
