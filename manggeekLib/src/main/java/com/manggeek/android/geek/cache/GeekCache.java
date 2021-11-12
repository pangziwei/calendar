package com.manggeek.android.geek.cache;

import android.content.SharedPreferences;

import com.manggeek.android.geek.GeekApplication;


/**
 * 缓存管理(基于SharedPreferences封装)
 * @author wanglei 2015年8月3日 上午10:55:50
 */
public class GeekCache {

    private static SharedPreferences sharedPreferences;

    protected static SharedPreferences cache() {
        if (sharedPreferences == null) {
            sharedPreferences = GeekApplication.getContext().getSharedPreferences(GeekApplication.getPackage(), GeekApplication.MODE_PRIVATE);
        }
        return sharedPreferences;
    }

}
