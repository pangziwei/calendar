package com.juyou.calendar.bo;


import android.app.Activity;
import android.content.Intent;

import com.juyou.calendar.mine.newlogin.NewLoginActivity;
import com.manggeek.android.geek.cache.StringCache;
import com.manggeek.android.geek.http.RetCode;
import com.manggeek.android.geek.manager.ActivityManager;
import com.manggeek.android.geek.utils.PrintUtil;
import com.yanzhenjie.nohttp.rest.Response;


public abstract class NewResultCallBack extends CallBack {

    @Override
    public void onSuccess(int what, CurrentBean currentBean, Response<String> response) {
        if (RetCode.NO_PERMITTION.equals(currentBean.getRetCode())) {
            StringCache.put("token", "");
            Activity mActivity = ActivityManager.getActivity().get();
//            Intent intent = new Intent(mActivity, LoginActivity.class);
            Intent intent = new Intent(mActivity, NewLoginActivity.class);
            mActivity.startActivity(intent);
            PrintUtil.toastMakeText("请重新登录");
        }
        onResultSuccess(what, currentBean);
    }

    public abstract void onResultSuccess(int what, CurrentBean currentBean);

}
