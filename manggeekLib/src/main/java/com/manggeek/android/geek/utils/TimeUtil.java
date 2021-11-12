package com.manggeek.android.geek.utils;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * 时间工具类
 *
 * @author wanglei 2015年8月1日 上午7:03:28
 */
public class TimeUtil {

    /**
     * yyyy-MM-dd HH:mm:ss
     */
    public static String DEFAULT_DATE_FORMAT = "yyyy-MM-dd HH:mm:ss";

    public static String DEFAULT_DATE = "yyyy年MM月dd日 HH:mm:ss";

    /**
     * yyyy-MM-dd HH:mm
     */
    public static String DEFAULT_HOUR_MINUTE_FORMAT = "yyyy-MM-dd HH:mm";
    /**
     * dd/MM/yyyy
     */
    public static final String DEFAULT_HOUR_MINUTE_FORMAT_TWO = "yyyy/MM/dd HH:mm";
    /**
     * MM月dd日 HH:mm
     */
    public static String HOUR_MINUTE_FORMAT = "MM月dd日  HH:mm";
    //月-日
    public static String MONTH_DAY = "MM-dd";
    /**
     * HH:mm
     */
    public static String HOUR_MINUTE = "HH:mm";
    /**
     * yyyy-MM-dd
     */
    public static String DEFAULT_DAY_FORMAT = "yyyy-MM-dd";
    /**
     * yyyyMMddHHmmss
     */
    public static String DEFAULT_DATE_NO_SEPRATOR_FORMAT = "yyyyMMddHHmmss";
    /**
     * yyyyMMdd
     */
    public static final String DEFAULT_DAY_NO_SEPRATOR_FORMAT = "yyyyMMdd";
    /**
     * yyyyMMdd
     */
    public static final String DEFAULT_DAY_NO_SEPRATOR = "yyyy.MM.dd";
    /**
     * dd/MM/yyyy
     */
    public static final String DEFAULT_SLASH_FORMAT = "dd/MM/yyyy";
    /**
     * dd/MM/yyyy
     */
    public static final String DEFAULT_FORMAT = "yyyy/MM/dd";
    public static String YEAR_MONTH_DAY = "yyyy年MM月dd日";

    /**
     * 指定日期格式，转化时间字符串为Date对象
     *
     * @param pattern
     * @param dateString
     * @return
     */
    public static Date parseDate(String dateString, String pattern) {
        DateFormat df = new SimpleDateFormat(pattern);
        try {
            return df.parse(dateString);
        } catch (Exception e) {
            return new Date();
        }
    }

    /**
     * 指定日期格式，转化时间字符串为Date对象
     *
     * @return
     */
    public static Date parseDate(String dateString) {
        return parseDate(dateString, DEFAULT_DATE_FORMAT);
    }


    /**
     * 指定日期格式，转化Date对象为时间字符串
     *
     * @param date
     * @return
     */
    public static String parseString(Date date) {
        SimpleDateFormat sdf = new SimpleDateFormat(DEFAULT_DATE_FORMAT);
        return sdf.format(date);
    }

    /**
     * 指定日期格式，转化Date对象为时间字符串
     *
     * @param date
     * @param dateStr
     * @return
     */
    public static String parseString(Date date, String dateStr) {
        SimpleDateFormat sdf = new SimpleDateFormat(dateStr);
        return sdf.format(date);
    }


    /**
     * 时间字符串转化为时间戳
     *
     * @return
     */
    public static Long dateToLong(String dateStr) {
        SimpleDateFormat format = new SimpleDateFormat(DEFAULT_DATE_FORMAT);
        Date date = null;
        try {
            date = format.parse(dateStr);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return date.getTime();
    }

    /**
     * 时间字符串转化为时间戳
     *
     * @param dateStr
     * @param pattern
     * @return
     */
    public static Long dateToLong(String dateStr, String pattern) {
        SimpleDateFormat format = new SimpleDateFormat(pattern);
        Date date = null;
        try {
            date = format.parse(dateStr);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return date.getTime();
    }


    /* 时间戳转换成字符窜 */
    public static String getDateToString(long time) {
        Date d = new Date(time);
        SimpleDateFormat sf = new SimpleDateFormat(DEFAULT_DATE_FORMAT);
        return sf.format(d);
    }

    /* 时间戳转换成字符窜,精确到分 */
    public static String getDateToMinuteString(long time) {
        Date d = new Date(time);
        SimpleDateFormat sf = new SimpleDateFormat(DEFAULT_HOUR_MINUTE_FORMAT);
        return sf.format(d);
    }

    /**
     * 时间戳转换成字符窜
     *
     * @param time
     * @param pattern
     * @return
     */
    public static String getDateToString(long time, String pattern) {
        Date d = new Date(time);
        SimpleDateFormat sf = new SimpleDateFormat(pattern);
        return sf.format(d);
    }
    /**
     * 判断是否为今日
     *
     * @param time
     * @return
     * @throws Exception
     */
    public static boolean isToday(long time){
        Date date = new Date(time);
        Calendar c1 = Calendar.getInstance();
        c1.setTime(date);
        int year1 = c1.get(Calendar.YEAR);
        int month1 = c1.get(Calendar.MONTH) + 1;
        int day1 = c1.get(Calendar.DAY_OF_MONTH);
        Calendar c2 = Calendar.getInstance();
        c2.setTime(new Date());
        int year2 = c2.get(Calendar.YEAR);
        int month2 = c2.get(Calendar.MONTH) + 1;
        int day2 = c2.get(Calendar.DAY_OF_MONTH);
        if (year1 == year2 && month1 == month2 && day1 == day2) {
            return true;
        }
        return false;
    }
}
