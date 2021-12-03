package com.juyou.calendar.bo;

import android.content.Context;
import android.util.Log;

import com.google.gson.Gson;
import com.juyou.calendar.util.SystemUtil;
import com.manggeek.android.geek.http.GeekHttp;
import com.manggeek.android.geek.http.HttpParams;


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



    //58账号密码登陆
    //code返回455--没有该用户请注册 code返回456--该用户没有设置密码请设置密码 code返回451--账号已被禁用 code 返回500 内部服务错误
    public static void pwdLogin(Context context, String telephone, String pwd, NetResultCallBack listener) {
        BaseParams httpParams = new BaseParams();
        BaseHeadParams headParams = new BaseHeadParams();
        httpParams.put("telephone", telephone);
        httpParams.put("pwd", pwd);
        GeekHttp.getHttp().postJson(0, Api.BaseUrl + "api/v2/login", httpParams, headParams, listener);
    }




    public static void SendSms(Context context, String telephone, String smsType, NetResultCallBack listener) {
        HttpParams httpParams = new HttpParams();
        httpParams.put("telephone", telephone);
        httpParams.put("type", smsType);

        GeekHttp.getHttp().get(0, Api.BaseUrl + "sms/send", httpParams, listener);

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








    //60判断用户是否设置密码或者是否注册
    /*判断用户状态 0未注册 1未设置密码 2设置密码*/
    public static void isRegistered(Context context, String telephone, NetResultCallBack listener) {
        BaseParams httpParams = new BaseParams();
        BaseHeadParams headParams = new BaseHeadParams();
        httpParams.put("telephone", telephone);
        GeekHttp.getHttp().get(context, 0, Api.BaseUrl + "userWhetherExist", httpParams, headParams, listener);
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
//        Log.e("测试登录接口", "登录的url---------" + Api.BaseUrl + "user/login");
//        Log.e("测试登录接口", "登录的url---httpParams------" + httpParams);
    }
    // 判断是否有上级
    //登录
    public static void Login_third(Context context, String loginBean, NetResultCallBack listener) {
        //参数
        BaseParams httpParams = new BaseParams();
        httpParams.put("data", loginBean);
        GeekHttp.getHttp().postJson(0, Api.JY_HOST + "account/login_third", httpParams, listener);
        Log.e("测试登录接口", "登录的测试---------" + Api.JY_HOST + "account/login_third");
        Log.e("测试登录接口", "登录的url---httpParams------" + httpParams);
    }
}
