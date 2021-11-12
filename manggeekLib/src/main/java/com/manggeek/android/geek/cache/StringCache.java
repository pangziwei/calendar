package com.manggeek.android.geek.cache;

import android.text.TextUtils;

/**
 * 字符串类型缓存
 * @author wanglei 2015年8月3日 上午11:26:55
 */
public class StringCache extends GeekCache {
    public static final String CACHE_KEY_CITY_HISTORY = "cityHistory";


    /**
     * 插入缓存
     */
    public static void put(String key, String value) {
        cache().edit().putString(key, value).commit();
    }

    /**
     * 获取缓存
     */
    public static String get(String key, String defValue) {
        return cache().getString(key, defValue);
    }

    /**
     * 获取缓存
     */
    public static String get(String key) {
        return get(key, "");
    }

    /**
     * 判断缓存是否存在
     * @return true is null
     */
    public static boolean isValue(String key) {
        return TextUtils.isEmpty(get(key));

    }

    /**
     * 删除缓存
     * @return true is success
     */
    public static boolean remove(String key) {
        if (!isValue(key)) {
            cache().edit().remove(key).commit();
            return true;
        }
        return false;
    }
}
