package com.juyou.calendar.base;

import android.app.Activity;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import android.view.inputmethod.InputMethodManager;

import androidx.multidex.MultiDex;

import com.juyou.calendar.manage.SharedPreferenceUtil;
import com.manggeek.android.geek.GeekApplication;
import com.tencent.tauth.Tencent;

import java.math.BigDecimal;

public class BaseApplication extends GeekApplication {
    private Activity topActivity;
    //获取屏幕的高，宽
    private static BaseApplication instance = null;

    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
        SharedPreferenceUtil.init(this);
       //腾讯qq登录初始化
//        Tencent.setIsPermissionGranted(true);


    }


    //全局捕获异常，打造永不闪退的app，建议生产环境打开，测试环境关闭，便于测试环境调试解决bug
    private void catchException() {
        Thread.setDefaultUncaughtExceptionHandler((t, e) ->
                Log.e("异常", "捕获异常------------" + Thread.currentThread().getName() +
                        "--------在:------" + e.getStackTrace()[0].getClassName())
        );
        //下面是新增方法!
        new Handler(Looper.getMainLooper()).post(() -> {
            while (true) {
                try {
                    Looper.loop(); //会先执行这个方法,然后在执行下面的异常捕获方法!
                } catch (Exception e) {
                    Log.e("异常", "捕获异常主线程:-------------" + Thread.currentThread().getName() + "-----------在:------------" + e.getStackTrace()[0].getClassName());
                    e.printStackTrace();
                }
            }
        });
    }

    public static String setScale(BigDecimal bigDecimal, int newScale) {
        return bigDecimal.setScale(2, BigDecimal.ROUND_HALF_UP).toString();
    }

    /**
     * 隐藏软键盘
     *
     * @param activity
     */
    public static void closeKeyboard(Activity activity) {
        InputMethodManager imm = (InputMethodManager) activity.getSystemService(Context.INPUT_METHOD_SERVICE);
        imm.hideSoftInputFromWindow(activity.getWindow().getDecorView().getWindowToken(), 0);
    }

    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);
        MultiDex.install(base);
    }


    //销毁当前的Activity
    public void removeCurrentActivity() {
        ActivityManager.getInstance().removeCurrent();
    }

    //销毁所有的activity
    public void removeAll() {
        ActivityManager.getInstance().removeAll();
    }

    /**
     * 获得实例
     *
     * @return
     */
    public static BaseApplication getInstance() {
        return instance;
    }

    /**
     * 获取context对象
     */
    public static Context getContext() {
        return instance.getApplicationContext();
    }

}
