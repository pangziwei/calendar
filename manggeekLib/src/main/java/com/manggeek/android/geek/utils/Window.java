package com.manggeek.android.geek.utils;


import android.content.Context;
import android.os.Build;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.WindowManager;

import com.manggeek.android.geek.GeekApplication;

/**
 * 手机窗口工具类
 *
 * @author wanglei 2015年8月1日 上午6:10:15
 */
public class Window {
    /**
     * 根据手机的分辨率从 dp 的单位 转成为 px(像素)
     */
    public static int toPx(float dpValue) {
        float scale = GeekApplication.getContext().getResources().getDisplayMetrics().density;
        return (int) (dpValue * scale + 0.5f);
    }

    /**
     * 根据手机的分辨率从 px(像素) 的单位 转成为 dp
     */
    public static int toDp(float pxValue) {
        float scale = GeekApplication.getContext().getResources().getDisplayMetrics().density;
        return (int) (pxValue / scale + 0.5f);
    }

    /**
     * 获得手机屏幕宽度得到像素px
     */
    public static int getWidth() {
        return GeekApplication.getContext().getResources().getDisplayMetrics().widthPixels;
    }

    /**
     * 获得手机屏幕高度得到像素px
     */
    public static int getHeight() {
        return GeekApplication.getContext().getResources().getDisplayMetrics().heightPixels;
    }

    /**
     * 获得手机真实的屏幕高度（像素px）(包含底部虚拟按键的高度)
     */
    public static int getRealHeight() {
        WindowManager wm = (WindowManager) GeekApplication.getContext().getSystemService(Context.WINDOW_SERVICE);
        Display display = wm.getDefaultDisplay();
        DisplayMetrics dm = new DisplayMetrics();
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN_MR1) {
            display.getRealMetrics(dm);
            int defaultDisplay = dm.heightPixels;
            return defaultDisplay;
        }
        return GeekApplication.getContext().getResources().getDisplayMetrics().heightPixels;
    }

    /**
     * 屏幕密度（0.75 / 1.0 / 1.5）
     *
     * @return
     */
    public static float getDensity() {
        WindowManager wm = (WindowManager) GeekApplication.getContext().getSystemService(Context.WINDOW_SERVICE);
        DisplayMetrics dm = new DisplayMetrics();
        wm.getDefaultDisplay().getMetrics(dm);
        return dm.density;
    }

    /**
     * 屏幕密度dpi（120 / 160 / 240）
     *
     * @return
     */
    public static int getDensityDpi() {
        WindowManager wm = (WindowManager) GeekApplication.getContext().getSystemService(Context.WINDOW_SERVICE);
        DisplayMetrics dm = new DisplayMetrics();
        wm.getDefaultDisplay().getMetrics(dm);
        return dm.densityDpi;
    }

    /**
     * 屏幕宽度(dp)
     *
     * @return
     */
    public static int getScreenWidth() {
        WindowManager wm = (WindowManager) GeekApplication.getContext().getSystemService(Context.WINDOW_SERVICE);
        DisplayMetrics dm = new DisplayMetrics();
        wm.getDefaultDisplay().getMetrics(dm);
        float density = dm.density;
        int width = dm.widthPixels;         // 屏幕宽度（像素）
        int screenWidth = (int) (width / density);  // 屏幕宽度(dp)
        return screenWidth;
    }

    /**
     * 屏幕高度(dp)
     *
     * @return
     */
    public static int getScreenHeight() {
        WindowManager wm = (WindowManager) GeekApplication.getContext().getSystemService(Context.WINDOW_SERVICE);
        DisplayMetrics dm = new DisplayMetrics();
        wm.getDefaultDisplay().getMetrics(dm);
        float density = dm.density;
        int height = dm.heightPixels;         // 屏幕宽度（像素）
        int ScreenHeight = (int) (height / density);  // 屏幕宽度(dp)
        return ScreenHeight;
    }
}
