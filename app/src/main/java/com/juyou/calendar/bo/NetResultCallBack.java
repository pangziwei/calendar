package com.juyou.calendar.bo;

import android.app.Activity;
import android.content.Intent;
import android.text.TextUtils;

import com.juyou.calendar.mine.newlogin.NewLoginActivity;
import com.manggeek.android.geek.cache.StringCache;
import com.manggeek.android.geek.http.GeekHttp;
import com.manggeek.android.geek.http.RetCode;
import com.manggeek.android.geek.manager.ActivityManager;
import com.manggeek.android.geek.utils.JSONUtil;
import com.manggeek.android.geek.utils.PrintUtil;
import com.yanzhenjie.nohttp.rest.OnResponseListener;
import com.yanzhenjie.nohttp.rest.Response;


public abstract class NetResultCallBack implements OnResponseListener<String> {


    @Override
    public void onStart(int what) {

    }

    @Override
    public void onSucceed(int what, Response<String> response) {
        String resultStr = response.get();
        String url = response.request().url();
        PrintUtil.log(GeekHttp.TAG, url +"请求响应\n"+"onSucceed:" + what + "\n" + resultStr);

        CurrentBean currentBean = null;
        if (!TextUtils.isEmpty(resultStr)) {
            currentBean = JSONUtil.getObj(resultStr, CurrentBean.class);
        }

        if (currentBean == null) {
            currentBean = new CurrentBean();
            currentBean.setRetCode(RetCode.WRONG_DATA);
            currentBean.setErrorMsg("数据异常");
            onFail(what, currentBean);
        } else {
            currentBean.setJson(resultStr);
            if (RetCode.NO_PERMITTION.equals(currentBean.getRetCode())) {
                StringCache.put("token", "");
                Activity mActivity = ActivityManager.getActivity().get();
//                Intent intent = new Intent(mActivity, LoginActivity.class);
                Intent intent = new Intent(mActivity, NewLoginActivity.class);
                mActivity.startActivity(intent);
                PrintUtil.toastMakeText("请重新登录");
            }
            if (currentBean.getCode().equals("200")){
                onSuccess(what, currentBean);
            }else {
                onFail(what,currentBean);
            }
        }
    }


    @Override
    public void onFailed(int what, Response<String> response) {
        PrintUtil.log(GeekHttp.TAG, "onFailed:" + what + "\nurl:" + response.get() + "\ntag:" + response.getTag() + "\nexception:" + response.getException() + "\nresponseCode:" + response.responseCode() + "\nnetworkMillis:" + response.getNetworkMillis());
        CurrentBean currentBean = new CurrentBean();
        currentBean.setRetCode("E" + response.responseCode());
        currentBean.setException(response.getException());
        currentBean.setErrorMsg("网络异常");
        onFail(what, currentBean);
    }

    @Override
    public void onFinish(int what) {
    }

    public abstract void onSuccess(int what, CurrentBean currentBean);

    public abstract void onFail(int what, CurrentBean currentBean);
}
