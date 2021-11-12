package com.manggeek.android.geek;

import android.annotation.SuppressLint;
import android.app.Application;
import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Environment;
import android.util.DisplayMetrics;

import com.yanzhenjie.nohttp.Logger;
import com.yanzhenjie.nohttp.NoHttp;

import androidx.multidex.MultiDex;


public class GeekApplication extends Application {

    @SuppressLint("StaticFieldLeak")
    private static Context context;
    private static String packageName;
    public static String mSdRootPath = Environment.getExternalStorageDirectory().getAbsolutePath()+"/love";
    // 保存Image的目录名

    private final static String FOLDER_NAME = "/cache/images";
    private static String mDataRootPath = null;
    /**
     * 每次app开启会调用
     */
    @Override
    public void onCreate() {
        super.onCreate();
        context = getApplicationContext();
        packageName = getPackageName();

        MultiDex.install(this);
        NoHttp.initialize(this, new NoHttp.Config()
                .setConnectTimeout(30 * 1000) // 全局连接超时时间，单位毫秒。
                .setReadTimeout(30 * 1000) // 全局服务器响应超时时间，单位毫秒。
        );
        Logger.setDebug(true);

        //设置app使用手机默认尺寸，不受用户在手机设置的改变而变化
        DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
        displayMetrics.scaledDensity = displayMetrics.density;

    }

    /**
     * 全局上下文对象
     */
    public static Context getContext() {
        return context;
    }

    /**
     * 项目包名
     */
    public static String getPackage() {
        return packageName;
    }

    public static PackageInfo getPackageInfo() throws PackageManager.NameNotFoundException {
        PackageManager manager = context.getPackageManager();
        return manager.getPackageInfo(packageName, 0);
    }

    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);


    }
    public static String getStorageDirectory() {
        return Environment.getExternalStorageState().equals(
                Environment.MEDIA_MOUNTED) ? mSdRootPath + FOLDER_NAME
                : mDataRootPath + FOLDER_NAME;
    }
}
