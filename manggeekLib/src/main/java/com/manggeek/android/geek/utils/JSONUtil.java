package com.manggeek.android.geek.utils;

import android.text.TextUtils;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;

import org.json.JSONException;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * json数据解析工具
 *
 * @author wanglei
 */
public class JSONUtil {

    /**
     * 使用JSON工具把数据转换成json对象
     *
     * @param value 是对解析的集合的类型
     */
    public static String toString(Object value) {
        String str = JSON.toJSONString(value);
        return str;
    }

    /**
     * 对单个javabean进行解析
     *
     * @param <T>
     * @param json 要解析的json字符串
     * @param cls
     * @return
     */
    public static <T> T getObj(String json, Class<T> cls) {
        T t = null;
        try {
            t = JSON.parseObject(json, cls);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return t;
    }

    /**
     * 对list类型进行解析
     *
     * @param <T>
     * @param json 要解析的json字符串
     * @param cls
     * @return
     */
    public static <T> List<T> getListObj(String json, Class<T> cls) {
        List<T> list = new ArrayList<T>();
        if (!TextUtils.isEmpty(json)) {
            try {
                list = JSON.parseArray(json, cls);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return list;
    }

    /**
     * 对MapString类型数据进行解析
     *
     * @param json
     * @return
     */
    public static HashMap<String, String> getMapStr(String json) {
        HashMap<String, String> mapStr = new HashMap<>();
        if (!TextUtils.isEmpty(json)) {
            mapStr = JSON.parseObject(json, new TypeReference<HashMap<String, String>>() {
            });
        }
        return mapStr;
    }


    /**
     * 对list map String类型进行解析
     *
     * @param json
     * @return
     */
    public static List<Map<String, String>> getListMapStr(String json) {
        List<Map<String, String>> list = new ArrayList<Map<String, String>>();
        if (!TextUtils.isEmpty(json)) {
            try {
                list = JSON.parseObject(json, new TypeReference<List<Map<String, String>>>() {
                });
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return list;
    }

    /**
     * 对list map Object类型进行解析
     *
     * @param json
     * @return
     */
    public static List<Map<String, Object>> getListMapObj(String json) {
        List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
        if (!TextUtils.isEmpty(json)) {
            try {
                list = JSON.parseObject(json, new TypeReference<List<Map<String, Object>>>() {
                });
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return list;
    }

    public static org.json.JSONObject getJsonObject(String json) {
        try {
            return new org.json.JSONObject(json);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return null;
    }
}
