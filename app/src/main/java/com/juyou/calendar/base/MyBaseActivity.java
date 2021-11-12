package com.juyou.calendar.base;

import android.os.Bundle;

import androidx.appcompat.app.ActionBar;

import com.juyou.calendar.R;
import com.juyou.calendar.share.DecorViewUtil;
import com.manggeek.android.geek.GeekFragmentActivity;
import com.manggeek.android.geek.dialog.WaitDialog;
import com.umeng.analytics.MobclickAgent;

public class MyBaseActivity extends GeekFragmentActivity {
    WaitDialog waitDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActionBar actionBar = getSupportActionBar();
        if (null != actionBar) {
            actionBar.hide();
        }

        MobclickAgent.setScenarioType(mActivity, MobclickAgent.EScenarioType.E_UM_NORMAL);
        MobclickAgent.setDebugMode(true);
        waitDialog = new WaitDialog(mActivity);
        ActivityManager.getInstance().add(this);
    }

    //销毁当前的Activity
    public void removeCurrentActivity() {
        ActivityManager.getInstance().removeCurrent();
    }

    //销毁所有的activity
    public void removeAll() {
        ActivityManager.getInstance().removeAll();
    }


    //设置状态栏透明
    public void setTranslate() {
        DecorViewUtil.setStatusBarLightMode(mActivity);
    }

    //
    public void setFullAndTranslucent() {
        DecorViewUtil.setFullAndTranslucent(mActivity);
    }

    //设置状态栏白色
    public void setWindowsWhite() {
        DecorViewUtil.setWindowStatusBarColor(mActivity, R.color.colorWhite);
    }

    @Override
    protected void onResume() {
        super.onResume();
        MobclickAgent.onResume(mActivity);
    }

    @Override
    protected void onPause() {
        super.onPause();
        MobclickAgent.onPause(mActivity);
    }

    /**
     * 显示加载中
     */
    public void showWaitDialog() {
        if (waitDialog == null) {
            waitDialog = new WaitDialog(mActivity);
        }
        waitDialog.show();
    }


    /**
     * 关闭加载中
     */
    public void dismissWaitDialog() {
        if (waitDialog == null) {
            waitDialog = new WaitDialog(this);
        }
        waitDialog.dismiss();
    }


}
