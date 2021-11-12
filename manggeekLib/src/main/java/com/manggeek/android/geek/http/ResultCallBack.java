package com.manggeek.android.geek.http;

import android.text.TextUtils;
import android.util.Log;

import com.manggeek.android.geek.utils.JSONUtil;
import com.manggeek.android.geek.utils.PrintUtil;
import com.yanzhenjie.nohttp.rest.OnResponseListener;
import com.yanzhenjie.nohttp.rest.Response;

/**
 * 提供请求结果快捷功能
 * Created by wanglei on 16/3/29.
 */
public abstract class ResultCallBack implements OnResponseListener<String> {

    @Override
    public void onStart(int what) {

    }

    @Override
    public void onSucceed(int what, Response<String> response) {
        String resultStr = response.get();
        Log.e("TAG", "onSucceed:" + what + "\n" + resultStr);
        PrintUtil.log(GeekHttp.TAG, "onSucceed:" + what + "\n" + resultStr);
        Result result = null;
        if (!TextUtils.isEmpty(resultStr)) {
            result = JSONUtil.getObj(resultStr, Result.class);
        }
        if (result == null) {
            result = new Result();
            result.setRetCode(RetCode.WRONG_DATA);
            result.setErrorMsg("数据异常");
        } else {
            result.setJson(resultStr);
        }
        onSuccess(what, result);
    }


    @Override
    public void onFailed(int what, Response<String> response) {
        Log.e("TAG", "onFailed:" + what + "\nurl:" + response.get() + "\ntag:" + response.getTag() + "\nexception:" + response.getException() + "\nresponseCode:" + response.responseCode() + "\nnetworkMillis:" + response.getNetworkMillis());
        PrintUtil.log(GeekHttp.TAG, "onFailed:" + what + "\nurl:" + response.get() + "\ntag:" + response.getTag() + "\nexception:" + response.getException() + "\nresponseCode:" + response.responseCode() + "\nnetworkMillis:" + response.getNetworkMillis());
        Result result = new Result();
        result.setRetCode("E" + response.responseCode());
        result.setException(response.getException());
        result.setErrorMsg("网络异常");
        onSuccess(what, result);
    }

    @Override
    public void onFinish(int what) {
    }

    public abstract void onSuccess(int what, Result result);

}
