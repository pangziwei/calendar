package com.juyou.calendar.bo;

import android.text.TextUtils;

import com.manggeek.android.geek.http.GeekHttp;
import com.manggeek.android.geek.http.RetCode;
import com.manggeek.android.geek.utils.JSONUtil;
import com.manggeek.android.geek.utils.PrintUtil;
import com.yanzhenjie.nohttp.rest.OnResponseListener;
import com.yanzhenjie.nohttp.rest.Response;

/**
 * 提供请求结果快捷功能
 * Created by huangwenfei on 16/3/29.
 */
public abstract class CallBack implements OnResponseListener<String> {

    @Override
    public void onStart(int what) {

    }

    @Override
    public void onSucceed(int what, Response<String> response) {
        String resultStr = response.get();
        String url = response.request().url();
        PrintUtil.log(GeekHttp.TAG, url +"请求响应\n"+ "onSucceed:" + what + "\n" + resultStr);
        CurrentBean currentBean = null;
        if (!TextUtils.isEmpty(resultStr)) {
            currentBean = JSONUtil.getObj(resultStr, CurrentBean.class);
        }
        if (currentBean == null) {
            currentBean = new CurrentBean();
            currentBean.setRetCode(RetCode.WRONG_DATA);
            currentBean.setErrorMsg("数据异常");
        } else {
            currentBean.setJson(resultStr);
        }
        onSuccess(what, currentBean, response);
    }


    @Override
    public void onFailed(int what, Response<String> response) {
        PrintUtil.log(GeekHttp.TAG, "onFailed:" + what + "\nurl:" + response.get() + "\ntag:" + response.getTag() + "\nexception:" + response.getException() + "\nresponseCode:" + response.responseCode() + "\nnetworkMillis:" + response.getNetworkMillis());
        CurrentBean currentBean = new CurrentBean();
        currentBean.setRetCode("E" + response.responseCode());
        currentBean.setException(response.getException());
        currentBean.setErrorMsg("网络异常");
        onSuccess(what, currentBean, response);
    }

    @Override
    public void onFinish(int what) {
    }

    public abstract void onSuccess(int what, CurrentBean currentBean, Response<String> response);

}
