package com.juyou.calendar.share;

import android.annotation.TargetApi;
import android.app.ActionBar;
import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.os.Build;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

import com.manggeek.android.geek.utils.PrintUtil;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

import androidx.appcompat.app.AppCompatActivity;

/**
 * Created by ThinkPad on 2017/10/13.
 */

public class DecorViewUtil {

    /**
     * 适配5.0以上
     * 仿美团效果
     * 1 应用主体内容占用系统状态栏空间
     * 2 隐藏actionbar
     * 3 导航栏设置透明背景
     *
     * @param activity
     * @param isNavigationPadding     导航栏间距
     * @param isNavigationTransparent 设置导航栏是否透明
     */
    public static void setFullAndTranslucent(Activity activity, boolean isNavigationPadding, boolean isNavigationTransparent) {
        //着色前先清除MIUI或flyme或6.0以上版本状态栏黑色字体 可根据需求调整
        clearnBlackMode(activity);

        //获取DecorView
        View decorView = activity.getWindow().getDecorView();
        int option = option = View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                //下面两个FLAG同时使用,表示会让应用的主体内容占用系统状态栏的空间
                | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN | View.SYSTEM_UI_FLAG_LAYOUT_STABLE;
        decorView.setSystemUiVisibility(option);

        //版本大于等于5.0时,状态栏和导航栏设置为透明
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            activity.getWindow().setStatusBarColor(Color.TRANSPARENT);
            if (isNavigationTransparent) {
                activity.getWindow().setNavigationBarColor(Color.TRANSPARENT);
            } else {
                activity.getWindow().setNavigationBarColor(Color.BLACK);
            }
        }

        //隐藏ActionBar
        ActionBar actionBar = activity.getActionBar();
        if (actionBar != null) {
            actionBar.hide();
        }

        //设置视图与底部导航栏边距, 此时导航栏颜色应改为黑色
        if (checkDeviceHasNavigationBar(activity)) {
            setBottomPadding(activity, isNavigationPadding);
        }
    }

    /**
     * 内容侵入状态栏， 不对导航栏做处理，（导航栏跟随系统设置）
     *
     * @param activity
     */
    public static void setFullAndTranslucent(Activity activity) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            Window window = activity.getWindow();
            window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS | WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION);
            window.getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN | View.SYSTEM_UI_FLAG_LAYOUT_STABLE);
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);

            //给状态栏设置颜色。我设置透明。
            window.setStatusBarColor(Color.TRANSPARENT);
        }

    }

    /**
     * 全屏，会覆盖掉状态栏
     *
     * @param activity
     */
    public static void setFullScreen(Activity activity) {
        activity.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);  //全屏
    }

    /**
     * 状态栏着色
     * 支持4.4以上版本
     * 1 添加 FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS Flag(绘制系统栏).
     * 2 清除 FLAG_TRANSLUCENT_STATUS Flag(透明状态栏).
     * 3 调用 setStatusBarColor() 设置状态栏颜色.
     * 4.设置布局边距，防止布局填充到导航栏上面
     *
     * @param activity
     * @param colorResId
     */
    public static void setWindowStatusBarColor(Activity activity, int colorResId) {
        //着色前先清除MIUI或flyme或6.0以上版本状态栏黑色字体 可根据需求调整
        clearnBlackMode(activity);

        //获取DecorView
        View decorView = activity.getWindow().getDecorView();
        decorView.setSystemUiVisibility(View.SYSTEM_UI_FLAG_VISIBLE);
        PrintUtil.log("version:" + Build.VERSION.SDK_INT);
        try {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                Window window = activity.getWindow();
                window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);  //
                window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
                window.setStatusBarColor(activity.getResources().getColor(colorResId));
                //底部导航栏颜色
                //window.setNavigationBarColor(activity.getResources().getColor(colorResId));
            }
//            else if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
//                //使用SystemBarTint库使4.4版本状态栏变色，需要先将状态栏设置为透明
//
//                transparencyBar(activity);
//                SystemBarTintManager tintManager = new SystemBarTintManager(activity);
//                tintManager.setStatusBarTintEnabled(true);
//                tintManager.setNavigationBarTintEnabled(true);
//                tintManager.setStatusBarTintResource(colorResId);
//                decorView.setFitsSystemWindows(true);
//            }
            else if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT && Build.VERSION.SDK_INT < Build.VERSION_CODES.LOLLIPOP) {
//                setTranslucentStatus(activity, true);
//                SystemBarTintManager tintManager = new SystemBarTintManager(activity);
//                tintManager.setStatusBarTintEnabled(true);
                // 使用颜色资源
//                tintManager.setStatusBarTintResource(colorResId);
//                decorView.setFitsSystemWindows(true);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        //判断是否有导航栏，若有设置间距为0， 防止setFullAndTranslucent()方法设置padding后影响
        if (checkDeviceHasNavigationBar(activity)) {
            setBottomPadding(activity, false);
        }

    }

    @TargetApi(19)
    public static void setTranslucentStatus(Activity activity, boolean on) {
        Window win = activity.getWindow();
        WindowManager.LayoutParams winParams = win.getAttributes();
        final int bits = WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS;
        if (on) {
            winParams.flags |= bits;
        } else {
            winParams.flags &= ~bits;
        }
        win.setAttributes(winParams);
    }


    public static void clearnBlackMode(Activity activity) {
        //着色前先清除MIUI或flyme或6.0以上版本状态栏黑色字体
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            if (MIUISetStatusBarLightMode(activity.getWindow(), false)) {

            } else if (FlymeSetStatusBarLightMode(activity.getWindow(), false)) {

            } else if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                activity.getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_VISIBLE);
            }
        }
    }


    /**
     * 修改状态栏为全透明
     *
     * @param activity
     */
    @TargetApi(19)
    public static void transparencyBar(Activity activity) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            Window window = activity.getWindow();
            window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS | WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION);
            window.getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION | View.SYSTEM_UI_FLAG_LAYOUT_STABLE);
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.setStatusBarColor(Color.TRANSPARENT);
            window.setNavigationBarColor(Color.TRANSPARENT);
        } else if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            Window window = activity.getWindow();
            window.setFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS, WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        }

    }


    public static void setBottomPadding(Activity activity, boolean hasPadding) {
        View decorView = activity.getWindow().getDecorView();
        if (hasPadding) {
            decorView.findViewById(android.R.id.content).setPadding(0, 0, 0, getNavigationBarHeight(activity));
        } else {
            decorView.findViewById(android.R.id.content).setPadding(0, 0, 0, 0);
        }

    }


    /**
     * 设置沉浸式模式
     * 4.4及以上支持
     * 1 在Activity中重写onWindowFocusChanged()方法
     * 2 调用以下方法
     */
    public static void setImmersiveMode(AppCompatActivity activity, boolean hasFocus) {
        if (hasFocus && Build.VERSION.SDK_INT >= 19) {
            View decorView = activity.getWindow().getDecorView();
            decorView.setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_STABLE | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION | View.SYSTEM_UI_FLAG_FULLSCREEN | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY);
        }
    }

    /**
     * 其中获取状态栏高度
     *
     * @param context
     * @return
     */
    public static int getStatusBarHeight(Context context) {
        int statusBarHeight = 0;
        Resources res = context.getResources();
        int resourceId = res.getIdentifier("status_bar_height", "dimen", "android");
        if (resourceId > 0) {
            statusBarHeight = res.getDimensionPixelSize(resourceId);
        }
        return statusBarHeight;
    }

    //通过反射判断手机是否有物理按钮NavigationBar
    public static boolean checkDeviceHasNavigationBar(Context context) {
        boolean hasNavigationBar = false;
        Resources rs = context.getResources();
        int id = rs.getIdentifier("config_showNavigationBar", "bool", "android");
        if (id > 0) {
            hasNavigationBar = rs.getBoolean(id);
        }
        try {
            Class systemPropertiesClass = Class.forName("android.os.SystemProperties");
            Method m = systemPropertiesClass.getMethod("get", String.class);
            String navBarOverride = (String) m.invoke(systemPropertiesClass, "qemu.hw.mainkeys");
            if ("1".equals(navBarOverride)) {
                hasNavigationBar = false;
            } else if ("0".equals(navBarOverride)) {
                hasNavigationBar = true;
            }
        } catch (Exception e) {

        }
        return hasNavigationBar;

    }

    /**
     * 获取底部导航栏高度
     *
     * @return
     */
    public static int getNavigationBarHeight(Context context) {
        Resources resources = context.getResources();
        int resourceId = resources.getIdentifier("navigation_bar_height", "dimen", "android");
        //获取NavigationBar的高度
        int navigationHeight = resources.getDimensionPixelSize(resourceId);
        return navigationHeight;
    }

    /**
     * 设置状态栏黑色字体图标，
     * 适配4.4以上版本MIUIV、Flyme和6.0以上版本其他Android
     *
     * @param activity
     * @return 1:MIUUI2:Flyme 3:android6.0
     */
    public static void setStatusBarLightMode(Activity activity) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            if (MIUISetStatusBarLightMode(activity.getWindow(), true)) {
            } else if (FlymeSetStatusBarLightMode(activity.getWindow(), true)) {
            } else if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                activity.getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN | View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);
            }
        }
    }

    /**
     * 清除MIUI或flyme或6.0以上版本状态栏黑色字体
     */
    public static void StatusBarDarkMode(Activity activity, int type) {
        if (type == 1) {
            MIUISetStatusBarLightMode(activity.getWindow(), false);
        } else if (type == 2) {
            FlymeSetStatusBarLightMode(activity.getWindow(), false);
        } else if (type == 3) {
            activity.getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_VISIBLE);
        }

    }


    /**
     * 设置状态栏图标为深色和魅族特定的文字风格
     * 可以用来判断是否为Flyme用户
     *
     * @param window 需要设置的窗口
     * @param dark   是否把状态栏字体及图标颜色设置为深色
     * @return boolean 成功执行返回true
     */
    public static boolean FlymeSetStatusBarLightMode(Window window, boolean dark) {
        boolean result = false;
        if (window != null) {
            try {
                WindowManager.LayoutParams lp = window.getAttributes();
                Field darkFlag = WindowManager.LayoutParams.class.getDeclaredField("MEIZU_FLAG_DARK_STATUS_BAR_ICON");
                Field meizuFlags = WindowManager.LayoutParams.class.getDeclaredField("meizuFlags");
                darkFlag.setAccessible(true);
                meizuFlags.setAccessible(true);
                int bit = darkFlag.getInt(null);
                int value = meizuFlags.getInt(lp);
                if (dark) {
                    value |= bit;
                } else {
                    value &= ~bit;
                }
                meizuFlags.setInt(lp, value);
                window.setAttributes(lp);
                result = true;
            } catch (Exception e) {

            }
        }
        return result;
    }

    /**
     * 设置状态栏字体图标为深色，需要MIUIV6以上
     *
     * @param window 需要设置的窗口
     * @param dark   是否把状态栏字体及图标颜色设置为深色
     * @return boolean 成功执行返回true
     */
    public static boolean MIUISetStatusBarLightMode(Window window, boolean dark) {
        if (Build.VERSION.SDK_INT > Build.VERSION_CODES.M) {
            return false;
        }
        boolean result = false;
        if (window != null) {
            Class clazz = window.getClass();
            try {
                int darkModeFlag = 0;
                Class layoutParams = Class.forName("android.view.MiuiWindowManager$LayoutParams");

                Field field;
                field = layoutParams.getField("EXTRA_FLAG_STATUS_BAR_DARK_MODE");
                darkModeFlag = field.getInt(layoutParams);
                Method extraFlagField = clazz.getMethod("setExtraFlags", int.class, int.class);
                if (dark) {
                    extraFlagField.invoke(window, darkModeFlag, darkModeFlag);//状态栏透明且黑色字体
                } else {
                    extraFlagField.invoke(window, 0, darkModeFlag);//清除黑色字体
                }
                result = true;
            } catch (Exception e) {

            }
        }
        return result;
    }


}

