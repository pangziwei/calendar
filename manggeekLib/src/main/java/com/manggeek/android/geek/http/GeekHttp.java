package com.manggeek.android.geek.http;

import android.content.Context;
import android.util.Log;

import com.manggeek.android.geek.utils.PrintUtil;
import com.yanzhenjie.nohttp.Binary;
import com.yanzhenjie.nohttp.FileBinary;
import com.yanzhenjie.nohttp.NoHttp;
import com.yanzhenjie.nohttp.RequestMethod;
import com.yanzhenjie.nohttp.rest.OnResponseListener;
import com.yanzhenjie.nohttp.rest.Request;
import com.yanzhenjie.nohttp.rest.RequestQueue;

import java.io.File;

/**
 * 提供访问网络快捷功能
 * Created by wanglei on 16/3/28.
 */
public class GeekHttp {

    public static final String TAG = "request";

    private static GeekHttp geekHttp;
    private RequestQueue queue;


    public static GeekHttp getHttp() {
        if (geekHttp == null) {
            synchronized (GeekHttp.class) {
                if (geekHttp == null) {
                    geekHttp = new GeekHttp();
                }
            }
        }
        return geekHttp;
    }

    public GeekHttp() {
        this.queue = NoHttp.newRequestQueue();
    }

    public void cancelBySign(Object sign) {
        this.queue.cancelBySign(sign);
    }

    /**
     * GET请求
     *
     * @param what
     * @param URL
     * @param responseListener
     */
    public void get(int what, String URL, OnResponseListener responseListener) {
        PrintUtil.log(TAG + " GET", URL);
        Log.e("weather", "1111111111111");

        Request<String> request = NoHttp.createStringRequest(URL, RequestMethod.GET);
        queue.add(what, request, responseListener);
    }

    public void get(Context context, int what, String URL, OnResponseListener responseListener) {
        PrintUtil.log(TAG + " GET", URL);
        Log.e("weather", "22222222222222222222");

        Request<String> request = NoHttp.createStringRequest(URL, RequestMethod.GET);
        request.setCancelSign(context);
        queue.add(what, request, responseListener);
    }

    /**
     * GET请求
     *
     * @param what
     * @param URL
     * @param params
     * @param responseListener
     */
    public void get(int what, String URL, HttpParams params, OnResponseListener responseListener) {
        PrintUtil.log(TAG + " GET", URL + "?" + params.toString());
        Log.e("weather", TAG + " GET"+URL + "?" + params.toString());
        Log.e("weather", "33333333333333");

        Request<String> request = NoHttp.createStringRequest(URL, RequestMethod.GET);
        params.handle(request);
        queue.add(what, request, responseListener);
    }

    public void get(Context context, int what, String URL, HttpParams params, OnResponseListener responseListener) {
        PrintUtil.log(TAG + " GET", URL + "?" + params.toString());
        Log.e("weather", TAG + " GET------"+URL + "?" + params.toString());
        Log.e("weather", "4444444444444");
        Request<String> request = NoHttp.createStringRequest(URL, RequestMethod.GET);
        request.setCancelSign(context);
        params.handle(request);
        queue.add(what, request, responseListener);
    }


    public void get(Context context, int what, String URL, HttpParams params,HttpParams headParams, OnResponseListener responseListener) {
        PrintUtil.log(TAG + " GET", URL + "?" + params.toString());
        Log.e("weather", "55555555555555");

        Request<String> request = NoHttp.createStringRequest(URL, RequestMethod.GET);
        request.setCancelSign(context);
        params.handle(request);
        headParams.handleHead(request);
        queue.add(what, request, responseListener);
    }

    /**
     * POST请求
     *
     * @param what
     * @param URL
     * @param responseListener
     */
    public void post(int what, String URL, OnResponseListener responseListener) {
        PrintUtil.log(TAG + " POST", URL);
        Log.e("TAG", "URL----POST请求-------"+URL);

        Request<String> request = NoHttp.createStringRequest(URL, RequestMethod.POST);
        queue.add(what, request, responseListener);
    }

    public void post(Context context, int what, String URL, OnResponseListener responseListener) {
        PrintUtil.log(TAG + " POST", URL);
        Log.e("TAG", "URL-----------"+URL);
        Request<String> request = NoHttp.createStringRequest(URL, RequestMethod.POST);
        request.setCancelSign(context);
        queue.add(what, request, responseListener);
    }

    /**
     * POST请求
     *
     * @param what
     * @param URL
     * @param params
     * @param responseListener
     */
    public void post(int what, String URL, HttpParams params, OnResponseListener responseListener) {
        PrintUtil.log(TAG + " POST", URL + "?" + params.toString());
        Log.e("TAG", URL + "?" + params.toString());

        Request<String> request = NoHttp.createStringRequest(URL, RequestMethod.POST);
        params.handle(request);
        queue.add(what, request, responseListener);
    }

    public void post(Context context, int what, String URL, HttpParams params, OnResponseListener responseListener) {
        PrintUtil.log(TAG + " POST", URL + "?" + params.toString());
        Log.e("TAG", URL + "?" + params.toString());
        Request<String> request = NoHttp.createStringRequest(URL, RequestMethod.POST);
        request.setCancelSign(context);
        params.handle(request);
        queue.add(what, request, responseListener);
    }

    /**
     * post表单请求
     *
     * @param what
     * @param URL
     * @param params
     * @param responseListener
     */
    public void postJson(int what, String URL, HttpParams params , OnResponseListener responseListener) {
//        Log.e("TAG", "requestType = post\nrequestUrl =" + URL + "\nrequestParams=" + params.toString());
        Log.d(GeekHttp.TAG, "requestType = post\nrequestUrl =" + URL + "\nrequestParams=" + params.toString());
        Request<String> request = NoHttp.createStringRequest(URL, RequestMethod.POST);
        params.handleJson(request);
        queue.add(what, request, responseListener);
    }
    /**
     * post表单请求
     *
     * @param what
     * @param URL
     * @param params
     * @param responseListener
     */
    public void postJson(int what, String URL, HttpParams params ,HttpParams headParams, OnResponseListener responseListener) {
//        Log.d(GeekHttp.TAG, "requestType = post\nrequestUrl =" + URL + "\nrequestParams=" + params.toString());
        Log.e("TAG", "requestType = post\nrequestUrl =" + URL + "\nrequestParams=" + params.toString());
        Request<String> request = NoHttp.createStringRequest(URL, RequestMethod.POST);
        params.handleJson(request);
        headParams.handleHead(request);
        Log.e("TAG", "request-------------"+request);
        queue.add(what, request, responseListener);
    }
    public void postNewJson(int what, String URL, Object obj ,HttpParams headParams, OnResponseListener responseListener) {
//        Log.d(GeekHttp.TAG, "requestType = post\nrequestUrl =" + URL + "\nrequestParams=" + params.toString());
        Log.e("TAG", "requestType = post\nrequestUrl =" + URL + "\nrequestParams=" + obj.toString());
        Request<String> request = NoHttp.createStringRequest(URL, RequestMethod.POST);

        headParams.handleHead(request);
        Log.e("TAG", "request-------------"+request);
        queue.add(what, request, responseListener);
    }


    public void postJson(Context context, int what, String URL, HttpParams params, OnResponseListener responseListener) {
//        Log.e("TAG", "requestType = post\nrequestUrl =" + URL + "\nrequestParams=" + params.toString());
        Log.d(GeekHttp.TAG, "requestType = post\nrequestUrl =" + URL + "\nrequestParams=" + params.toString());
        Request<String> request = NoHttp.createStringRequest(URL, RequestMethod.POST);
        request.setCancelSign(context);
        params.handleJson(request);
        queue.add(what, request, responseListener);
    }

    /**
     * post表单请求
     *
     * @param what
     * @param URL
     * @param params
     * @param responseListener
     */
    public void postJsonAddHeader(int what, String URL, HttpParams params, OnResponseListener responseListener) {
        PrintUtil.log(TAG + " POST", URL + "?" + params.toString());
        Request<String> request = NoHttp.createStringRequest(URL, RequestMethod.POST);
//        HttpParams.Param tokenParam = params.getParam("token");
//        if (tokenParam != null) {
//            request.addHeader("token", (String) tokenParam.getValue());
//            params.remove(tokenParam);
//        }
        params.handleJson(request);
        queue.add(what, request, responseListener);
    }

    /**
     * 上传文件
     *
     * @param what
     * @param URL
     * @param path
     * @param token
     * @param responseListener
     */
    public void postFile(int what, String URL, String path, String token, OnResponseListener responseListener) {
        PrintUtil.log(TAG + " POST", URL + "?path=" + path + ",toekn:" + token);
        Request<String> request = NoHttp.createStringRequest(URL, RequestMethod.POST);
        request.addHeader("token", token);
        Binary binary = new FileBinary(new File(path));
        request.add("file", binary);
        queue.add(what, request, responseListener);
    }

    /**
     * 获取请求队列
     *
     * @return
     */
    public RequestQueue getQueue() {
        return queue;
    }

}
