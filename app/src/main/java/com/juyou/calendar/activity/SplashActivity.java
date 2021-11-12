package com.juyou.calendar.activity;


import android.Manifest;
import android.app.Activity;
import android.app.ActivityManager;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.webkit.WebView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import com.baidu.mobads.sdk.api.AdSettings;
import com.baidu.mobads.sdk.api.BDAdConfig;
import com.baidu.mobads.sdk.api.BDDialogParams;
import com.baidu.mobads.sdk.api.MobadsPermissionSettings;
import com.baidu.mobads.sdk.api.NovelSDKConfig;
import com.baidu.mobads.sdk.api.RequestParameters;
import com.baidu.mobads.sdk.api.SplashAd;
import com.baidu.mobads.sdk.api.SplashInteractionListener;
import com.google.gson.Gson;
import com.juyou.calendar.R;
import com.juyou.calendar.constant.WeatherContentUtil;
import com.juyou.calendar.weather.CrashHandler;
import com.juyou.calendar.weather.LocationService;

import org.apache.log4j.Level;

import java.io.File;
import java.util.logging.Logger;

import de.mindpipe.android.logging.log4j.LogConfigurator;
import interfaces.heweather.com.interfacesmodule.view.HeConfig;

public class SplashActivity extends Activity {
    private static final String TAG = "RSplashActivity";
    final int REQUEST_PERMISSION_LOCATION = 10;
    public Logger log;
    private TextView mSplashHolder;
    // 推荐使用全局变量，以便统一释放资源
    private SplashAd splashAd;
    private boolean canJumpImmediately = false;

    private static SplashActivity sInstance;//初始化百度广告页


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        /**
         * 【注意】开屏点睛需要开屏和主页的窗口具有特性 {@linkplain Window.FEATURE_ACTIVITY_TRANSITIONS}
         * Tips: 一般具有Material Design风格的App主题，系统会默认开启该特性。
         *       若没有该特性，可以在{@link #setContentView(int)}之前
         *       调用 {@link #requestWindowFeature(int)} 即可开启特性，如下：
         */
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            requestWindowFeature(Window.FEATURE_ACTIVITY_TRANSITIONS);
        }
        /* 设置开屏全屏显示&透明状态栏 */
        getWindow().clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
        getWindow().getDecorView().setSystemUiVisibility(
                View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN);
        getWindow().setStatusBarColor(Color.TRANSPARENT);
        // 把requestWindowFeature放在super前面，要不然部分机型会上报异常
        super.onCreate(savedInstanceState);
        initBaiDuSDK();
        setContentView(R.layout.activity_splash);
        // 调用获取版本号的方法,下方的值为版本号
        String SDKVersion = AdSettings.getSDKVersion();
        // 打印出版本号的值
        Log.e(TAG, "广告SDK的版本号为：" + SDKVersion);
        mSplashHolder = findViewById(R.id.splash_holder);
        fetchSplashAD();
        initHeFeng();

    }

    private void initHeFeng() {

//        和风选地址的配置
        //在主线程中new的handler就是主线程的handler
        //初始化Handler
        HeConfig.init(WeatherContentUtil.HE_PUBLIC_ID, WeatherContentUtil.HE_APK_KEY);
//        SDK 默认访问商业版服务，开发版用户可通过以下方法进行调整（全局执行一次即可）
//切换至开发版服务
        HeConfig.switchToDevService();
//切换至商业版服务
//        HeConfig.switchToBizService();
        configLog();
    }

    private void initBaiDuSDK() {
        // 初始化信息，初始化一次即可，（此处用startsWith()，可包括激励/全屏视频的进程）
        // https、视频缓存空间有特殊需求可动态配置，一般取默认值即可，无需设置
        BDAdConfig bdAdConfig = new BDAdConfig.Builder()
                // 1、设置app名称，可选
                .setAppName("网盟demo")
                // 2、应用在mssp平台申请到的appsid，和包名一一对应，此处设置等同于在AndroidManifest.xml里面设置
                .setAppsid("e866cfb0")
                // 3、设置下载弹窗的类型和按钮动效样式，可选
                .setDialogParams(new BDDialogParams.Builder()
                        .setDlDialogType(BDDialogParams.TYPE_BOTTOM_POPUP)
                        .setDlDialogAnimStyle(BDDialogParams.ANIM_STYLE_NONE)
                        .build())
                .build(this);
        bdAdConfig.init();

        // 设置SDK可以使用的权限，包含：设备信息、定位、存储、APP LIST
        // 注意：建议授权SDK读取设备信息，SDK会在应用获得系统权限后自行获取IMEI等设备信息
        // 授权SDK获取设备信息会有助于提升ECPM
        //设置SDK获取设备信息权限（建议）
        MobadsPermissionSettings.setPermissionReadDeviceID(true);
        //设置SDK获取应用列表权限（建议）
        MobadsPermissionSettings.setPermissionAppList(true);
        //设置SDK获取粗略定位权限
        MobadsPermissionSettings.setPermissionLocation(false);
        //设置SDK获取外部存储权限
        MobadsPermissionSettings.setPermissionStorage(false);
    }

    private void fetchSplashAD() {
        // 默认请求https广告，若需要请求http广告，请设置AdSettings.setSupportHttps为false
        //         AdSettings.setSupportHttps(false);
        final RelativeLayout adsParent = (RelativeLayout) this.findViewById(R.id.adsRl);

        SplashInteractionListener listener = new SplashInteractionListener() {
            @Override
            public void onLpClosed() {
                Log.i(TAG, "lp页面关闭");
                Toast.makeText(SplashActivity.this, "lp页面关闭", Toast.LENGTH_SHORT).show();
                jump();
            }

            @Override
            public void onAdDismissed() {
                Log.i(TAG, "onAdDismissed");
                jumpWhenCanClick(); // 跳转至您的应用主界面
            }

            @Override
            public void onADLoaded() {
                Log.i(TAG, "onADLoaded");
            }

            @Override
            public void onAdFailed(String arg0) {
                Log.i(TAG, "" + arg0);
                jump();
            }

            @Override
            public void onAdPresent() {
                Log.i(TAG, "onAdPresent");
                mSplashHolder.setVisibility(View.GONE);
            }

            @Override
            public void onAdClick() {
                Log.i(TAG, "onAdClick");
                // 设置开屏可接受点击时，该回调可用
            }

            @Override
            public void onAdCacheSuccess() {
                Log.i(TAG, "onAdCacheSuccess");
            }

            @Override
            public void onAdCacheFailed() {
                Log.i(TAG, "onAdCacheFailed");
            }
        };

        String adPlaceId = "2058622"; // 重要：请填上您的广告位ID，代码位错误会导致无法请求到广告


//        splashAd = new SplashAd(this, adPlaceId, listener);
//        splashAd.loadAndShow(adsParent);

        // 如果开屏需要load广告和show广告分开，请参考类RSplashManagerActivity的写法
        // 如果需要修改开屏超时时间、隐藏工信部下载整改展示，请设置下面代码;
        final RequestParameters.Builder parameters = new RequestParameters.Builder();
        // sdk内部默认超时时间为4200，单位：毫秒
        parameters.addExtra(SplashAd.KEY_TIMEOUT, "4200");
        // sdk内部默认值为true
        parameters.addExtra(SplashAd.KEY_DISPLAY_DOWNLOADINFO, "true");
        // 是否限制点击区域，默认不限制
        parameters.addExtra(SplashAd.KEY_LIMIT_REGION_CLICK, "false");
        // 是否展示点击引导按钮，默认不展示，若设置可限制点击区域，则此选项默认打开
        parameters.addExtra(SplashAd.KEY_DISPLAY_CLICK_REGION, "true");
        // 用户点击开屏下载类广告时，是否弹出Dialog
        // 此选项设置为true的情况下，会覆盖掉 {SplashAd.KEY_DISPLAY_DOWNLOADINFO} 的设置
        parameters.addExtra(SplashAd.KEY_POPDIALOG_DOWNLOAD, "true");
        splashAd = new SplashAd(this, adPlaceId, parameters.build(), listener);
        splashAd.loadAndShow(adsParent);
    }

    private void jumpWhenCanClick() {
        if (canJumpImmediately) {
            if (splashAd != null) {
                Intent intent = new Intent(SplashActivity.this, MyMainActivity.class);
                /**
                 * 1. 结束当前Activity并启动主页，建议在该方法的回调中执行开屏Activity的结束操作。
                 * 2. 若仅传入Intent而不设置回调，则会在启动主页后自动结束当前开屏Activity，
                 *    例如： {@link SplashAd#finishAndJump(Intent)}
                 * 3. 建议配合主页onCreate阶段中的 {@link SplashAd#registerEnterTransition(
                 *Activity, SplashAd.SplashFocusAdListener)} 使用
                 */
                splashAd.finishAndJump(intent, new SplashAd.OnFinishListener() {
                    @Override
                    public void onFinishActivity() {
                        Log.i(TAG, "onFinishActivity");
                        finish();
                    }
                });
                splashAd.destroy();
            }
        } else {
            canJumpImmediately = true;
        }

    }

    @Override
    protected void onPause() {
        super.onPause();
        canJumpImmediately = false;
    }

    /**
     * 不可点击的开屏，使用该jump方法，而不是用jumpWhenCanClick
     */
    private void jump() {
        if (canJumpImmediately) {
            if (splashAd != null) {
                Intent intent = new Intent(SplashActivity.this, MyMainActivity.class);
                /**
                 * 1. 结束当前Activity并启动主页，建议在该方法的回调中执行开屏Activity的结束操作。
                 * 2. 若仅传入Intent而不设置回调，则会在启动主页后自动结束当前开屏Activity，
                 *    例如： {@link SplashAd#finishAndJump(Intent)}
                 * 3. 建议配合主页onCreate阶段中的 {@link SplashAd#registerEnterTransition(
                 *Activity, SplashAd.SplashFocusAdListener)} 使用
                 */
                splashAd.finishAndJump(intent, new SplashAd.OnFinishListener() {
                    @Override
                    public void onFinishActivity() {
                        Log.i(TAG, "onFinishActivity");
                        finish();
                    }
                });
                splashAd.destroy();
            }
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        if (canJumpImmediately) {
            jumpWhenCanClick();
        }
        canJumpImmediately = true;
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        // Activity销毁时，销毁广告对象释放资源，避免潜在的内存泄露
        if (splashAd != null) {
            splashAd.destroy();
            splashAd = null;
        }
        this.finish();
    }


    private String getProcessName(Context context) {
        if (context == null) return null;
        ActivityManager manager = (ActivityManager) context.getSystemService(Context.ACTIVITY_SERVICE);
        for (ActivityManager.RunningAppProcessInfo processInfo : manager.getRunningAppProcesses()) {
            if (processInfo.pid == android.os.Process.myPid()) {
                return processInfo.processName;
            }
        }
        return null;
    }

    public static SplashActivity getContext() {
        return sInstance;
    }


    private void initPermission() {

        if (Build.VERSION.SDK_INT >= 23) {
            if (ContextCompat.checkSelfPermission(SplashActivity.this, Manifest.permission.ACCESS_FINE_LOCATION)
                    != PackageManager.PERMISSION_GRANTED || ContextCompat.checkSelfPermission(SplashActivity.this, Manifest.permission.READ_EXTERNAL_STORAGE)
                    != PackageManager.PERMISSION_GRANTED || ContextCompat.checkSelfPermission(SplashActivity.this, Manifest.permission.READ_PHONE_STATE)
                    != PackageManager.PERMISSION_GRANTED) {
                // 没有权限
                ActivityCompat.requestPermissions(SplashActivity.this, new String[]{Manifest.permission.ACCESS_FINE_LOCATION,
                                Manifest.permission.READ_EXTERNAL_STORAGE,
                                Manifest.permission.READ_PHONE_STATE},
                        REQUEST_PERMISSION_LOCATION);
            } else {
                startService(new Intent(this, LocationService.class));
                startIntent();
            }
        } else {


        }


    }

    private void startIntent() {
        startActivity(new Intent(this, MyMainActivity.class));
        finish();
    }


    public void configLog() {
        try {
            final LogConfigurator logConfigurator = new LogConfigurator();

            logConfigurator.setFileName(Environment.getExternalStorageDirectory() + File.separator + "crifanli_log4j.log");
            // Set the root log level
            logConfigurator.setRootLevel(Level.DEBUG);
            // Set log level of a specific logger
            logConfigurator.setLevel("org.apache", Level.ERROR);
            logConfigurator.configure();
            CrashHandler catchHandler = CrashHandler.getInstance();
            catchHandler.init(getApplicationContext());
        } catch (Exception e) {
            String TAG = "sky";
            Log.i(TAG, "configLog: " + e);
        }

        //gLogger = Logger.getLogger(this.getClass());
        log = Logger.getLogger("CrifanLiLog4jTest");
    }



}

