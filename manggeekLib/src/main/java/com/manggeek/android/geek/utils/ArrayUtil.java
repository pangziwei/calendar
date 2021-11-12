package com.manggeek.android.geek.utils;

import android.text.TextUtils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Administrator on 2016/5/25.
 */
public class ArrayUtil {

    /**
     * list转string
     *
     * @param list
     * @return
     */
    public static String listToString(List<String> list) {
        if (list == null) {
            return null;
        }
        StringBuffer result = new StringBuffer();
        boolean flag = false;
        for (String string : list) {
            if (flag) {
                result.append(",");
            } else {
                flag = true;
            }
            result.append(string);
        }
        return result.toString();
    }

    /**
     * 将字符串的集合转成用分号隔开的字符串
     *
     * @param list
     * @return
     */
    public static String listToStringBySemicolon(List<String> list) {
        if (list == null) {
            return null;
        }
        StringBuffer result = new StringBuffer();
        boolean flag = false;
        for (String string : list) {
            if (flag) {
                result.append(";");
            } else {
                flag = true;
            }
            result.append(string);
        }
        return result.toString();
    }

    public static String listIntegerToString(List<Integer> list) {
        if (list == null) {
            return null;
        }
        StringBuffer result = new StringBuffer();
        boolean flag = false;
        for (Integer string : list) {
            if (flag) {
                result.append(",");
            } else {
                flag = true;
            }
            result.append(string);
        }
        return result.toString();
    }

    public static String listIntegerToStringBySemicolon(List<Integer> list) {
        if (list == null) {
            return null;
        }
        StringBuffer result = new StringBuffer();
        boolean flag = false;
        for (Integer string : list) {
            if (flag) {
                result.append(";");
            } else {
                flag = true;
            }
            result.append(string);
        }
        return result.toString();
    }

    public static List<String> strToList(String str) {
        List<String> list = new ArrayList<>();
        if (TextUtils.isEmpty(str)) {
            return list;
        }
        String[] strings = str.split(",");
        Collections.addAll(list, strings);
        return list;
    }

    public static List<String> strToListBySemicolon(String str) {
        List<String> list = new ArrayList<>();
        if (TextUtils.isEmpty(str)) {
            return list;
        }
        String[] strings = str.split(";");
        Collections.addAll(list, strings);
        return list;
    }


    public static List<Integer> getIntegerListBySemicolon(String str) {
        List<Integer> list = new ArrayList<>();
        if (TextUtils.isEmpty(str)) {
            return list;
        }
        String[] strings = str.split(";");
        for (int i = 0; i < strings.length; i++) {
        list.add(Integer.parseInt(strings[i]));
        }
        return list;
    }



    /**
     * 取出数字
     *
     * @param content
     * @return
     */
    public static String getNumStr(String content) {
        String regex = "\\d*";
        Pattern p = Pattern.compile(regex);

        Matcher m = p.matcher(content);

        while (m.find()) {
            if (!"".equals(m.group()))
                return m.group();
        }
        return "";
    }


    public static List<String> getDatas(String[] strings) {
        List<String> list = new java.util.ArrayList<>();
        if (strings == null || strings.length < 1) {
            return list;
        }
        Collections.addAll(list, strings);
        return list;
    }


    public static List<Integer> getDatas(int[] datas) {
        List<Integer> list = new java.util.ArrayList<>();
        if (datas == null || datas.length < 1) {
            return list;
        }
        for (int i = 0; i < datas.length; i++) {
            list.add(datas[i]);
        }
        return list;
    }

    public static List<String> getDatas(String data) {
        List<String> list = new java.util.ArrayList<>();
        if (TextUtils.isEmpty(data)) {
            return list;
        }
        String[] strings = data.split("\\|");
        Collections.addAll(list, strings);
        return list;
    }
}
