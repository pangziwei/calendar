package com.juyou.calendar.manage;

import android.content.Context;

import net.grandcentrix.tray.AppPreferences;


/**
 * @desc 本地缓存工具类
 */
public class SharedPreferenceUtil {

    public static AppPreferences sp;
    //是否同意协议
    public final static  String IS_AGREE_PROTOCOL = "IS_AGREE";
    public static void init(Context context) {
        synchronized (SharedPreferenceUtil.class) {
            if (sp == null)
                sp = new AppPreferences(context);
        }
    }
    public static boolean getBooleanValue(String key, boolean flag) {
        return sp.getBoolean(key, flag);
    }
    public static void putBooleanValue(String key, boolean flag) {
        if (sp != null) {
            sp.put(key, flag);
        }
    }
}
