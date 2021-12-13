package com.juyou.calendar.util;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;

/**
 * 本地存储类
 */
public class ISharedPreference {
    private static ISharedPreference preference;
    private SharedPreferences sharedPreferences;//存储对象

    private ISharedPreference(Application app) {
        sharedPreferences = app.getSharedPreferences("jy", Context.MODE_PRIVATE);
    }

    /**
     * 使用单例模式
     *
     * @param app app
     * @return
     */
    public static ISharedPreference getInstance(Application app) {
        if (preference == null) {
            synchronized (ISharedPreference.class) {
                if (preference == null) {
                    preference = new ISharedPreference(app);
                }
            }
        }
        return preference;
    }


    /**
     * 保存token
     *
     * @param token token
     */
    public void saveToken(String token) {
        sharedPreferences.edit().putString("token", token).apply();
    }

    public String getToken() {
        return sharedPreferences.getString("token", "");
    }

    //周一为首日
    public boolean getWeekMonNotice() {
        return sharedPreferences.getBoolean("MonWeek", true);
    }

    //周一为首日
    public void saveWeekMonNotice(boolean is) {
        sharedPreferences.edit().putBoolean("MonWeek", is).apply();
    }

    //周日为首日
    public boolean getWeekSunNotice() {
        return sharedPreferences.getBoolean("SunWeek", true);
    }

    //周日为首日
    public void saveWeekSunNotice(boolean is) {
        sharedPreferences.edit().putBoolean("SunWeek", is).apply();
    }

}
