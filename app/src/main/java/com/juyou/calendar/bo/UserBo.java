package com.juyou.calendar.bo;

import android.util.Log;


import com.google.gson.Gson;
import com.manggeek.android.geek.http.GeekHttp;
import com.manggeek.android.geek.http.HttpParams;
import com.yanzhenjie.nohttp.rest.OnResponseListener;


/**
 * 用户业务类
 */

public class UserBo {
    /**
     * 检查版本更新
     *
     * @param listener osType 手机系统类型 0-安卓 1-苹果
     *                 editionId   版本id
     */
    public static void update(OnResponseListener listener) {
        HttpParams httpParams = new HttpParams();
        httpParams.put("osType", "0");
        Log.e("osType", "--------osType-----"+new Gson().toJson(httpParams));
        GeekHttp.getHttp().get(0, URL.USD_UPDATE, httpParams, listener);
    }

}
