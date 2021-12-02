/*
 * Copyright (C) 2016 huanghaibin_dev <huanghaibin_dev@163.com>
 * WebSite https://github.com/MiracleTimes-Dev
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *         http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.haibin.calendarview;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.TimeZone;

/**
 * 农历计算方法
 */
public final class LunarUtil {


    private static int[] LUNAR_MONTH_DAYS = {1887, 0x1694, 0x16aa, 0x4ad5, 0xab6, 0xc4b7, 0x4ae, 0xa56, 0xb52a, 0x1d2a,
            0xd54, 0x75aa, 0x156a, 0x1096d, 0x95c, 0x14ae, 0xaa4d, 0x1a4c, 0x1b2a, 0x8d55, 0xad4, 0x135a, 0x495d, 0x95c,
            0xd49b, 0x149a, 0x1a4a, 0xbaa5, 0x16a8, 0x1ad4, 0x52da, 0x12b6, 0xe937, 0x92e, 0x1496, 0xb64b, 0xd4a, 0xda8,
            0x95b5, 0x56c, 0x12ae, 0x492f, 0x92e, 0xcc96, 0x1a94, 0x1d4a, 0xada9, 0xb5a, 0x56c, 0x726e, 0x125c, 0xf92d,
            0x192a, 0x1a94, 0xdb4a, 0x16aa, 0xad4, 0x955b, 0x4ba, 0x125a, 0x592b, 0x152a, 0xf695, 0xd94, 0x16aa, 0xaab5,
            0x9b4, 0x14b6, 0x6a57, 0xa56, 0x1152a, 0x1d2a, 0xd54, 0xd5aa, 0x156a, 0x96c, 0x94ae, 0x14ae, 0xa4c, 0x7d26,
            0x1b2a, 0xeb55, 0xad4, 0x12da, 0xa95d, 0x95a, 0x149a, 0x9a4d, 0x1a4a, 0x11aa5, 0x16a8, 0x16d4, 0xd2da,
            0x12b6, 0x936, 0x9497, 0x1496, 0x1564b, 0xd4a, 0xda8, 0xd5b4, 0x156c, 0x12ae, 0xa92f, 0x92e, 0xc96, 0x6d4a,
            0x1d4a, 0x10d65, 0xb58, 0x156c, 0xb26d, 0x125c, 0x192c, 0x9a95, 0x1a94, 0x1b4a, 0x4b55, 0xad4, 0xf55b,
            0x4ba, 0x125a, 0xb92b, 0x152a, 0x1694, 0x96aa, 0x15aa, 0x12ab5, 0x974, 0x14b6, 0xca57, 0xa56, 0x1526,
            0x8e95, 0xd54, 0x15aa, 0x49b5, 0x96c, 0xd4ae, 0x149c, 0x1a4c, 0xbd26, 0x1aa6, 0xb54, 0x6d6a, 0x12da,
            0x1695d, 0x95a, 0x149a, 0xda4b, 0x1a4a, 0x1aa4, 0xbb54, 0x16b4, 0xada, 0x495b, 0x936, 0xf497, 0x1496,
            0x154a, 0xb6a5, 0xda4, 0x15b4, 0x6ab6, 0x126e, 0x1092f, 0x92e, 0xc96, 0xcd4a, 0x1d4a, 0xd64, 0x956c, 0x155c,
            0x125c, 0x792e, 0x192c, 0xfa95, 0x1a94, 0x1b4a, 0xab55, 0xad4, 0x14da, 0x8a5d, 0xa5a, 0x1152b, 0x152a,
            0x1694, 0xd6aa, 0x15aa, 0xab4, 0x94ba, 0x14b6, 0xa56, 0x7527, 0xd26, 0xee53, 0xd54, 0x15aa, 0xa9b5, 0x96c,
            0x14ae, 0x8a4e, 0x1a4c, 0x11d26, 0x1aa4, 0x1b54, 0xcd6a, 0xada, 0x95c, 0x949d, 0x149a, 0x1a2a, 0x5b25,
            0x1aa4, 0xfb52, 0x16b4, 0xaba, 0xa95b, 0x936, 0x1496, 0x9a4b, 0x154a, 0x136a5, 0xda4, 0x15ac};

    private static int[] SOLAR = {1887, 0xec04c, 0xec23f, 0xec435, 0xec649, 0xec83e, 0xeca51, 0xecc46, 0xece3a,
            0xed04d, 0xed242, 0xed436, 0xed64a, 0xed83f, 0xeda53, 0xedc48, 0xede3d, 0xee050, 0xee244, 0xee439, 0xee64d,
            0xee842, 0xeea36, 0xeec4a, 0xeee3e, 0xef052, 0xef246, 0xef43a, 0xef64e, 0xef843, 0xefa37, 0xefc4b, 0xefe41,
            0xf0054, 0xf0248, 0xf043c, 0xf0650, 0xf0845, 0xf0a38, 0xf0c4d, 0xf0e42, 0xf1037, 0xf124a, 0xf143e, 0xf1651,
            0xf1846, 0xf1a3a, 0xf1c4e, 0xf1e44, 0xf2038, 0xf224b, 0xf243f, 0xf2653, 0xf2848, 0xf2a3b, 0xf2c4f, 0xf2e45,
            0xf3039, 0xf324d, 0xf3442, 0xf3636, 0xf384a, 0xf3a3d, 0xf3c51, 0xf3e46, 0xf403b, 0xf424e, 0xf4443, 0xf4638,
            0xf484c, 0xf4a3f, 0xf4c52, 0xf4e48, 0xf503c, 0xf524f, 0xf5445, 0xf5639, 0xf584d, 0xf5a42, 0xf5c35, 0xf5e49,
            0xf603e, 0xf6251, 0xf6446, 0xf663b, 0xf684f, 0xf6a43, 0xf6c37, 0xf6e4b, 0xf703f, 0xf7252, 0xf7447, 0xf763c,
            0xf7850, 0xf7a45, 0xf7c39, 0xf7e4d, 0xf8042, 0xf8254, 0xf8449, 0xf863d, 0xf8851, 0xf8a46, 0xf8c3b, 0xf8e4f,
            0xf9044, 0xf9237, 0xf944a, 0xf963f, 0xf9853, 0xf9a47, 0xf9c3c, 0xf9e50, 0xfa045, 0xfa238, 0xfa44c, 0xfa641,
            0xfa836, 0xfaa49, 0xfac3d, 0xfae52, 0xfb047, 0xfb23a, 0xfb44e, 0xfb643, 0xfb837, 0xfba4a, 0xfbc3f, 0xfbe53,
            0xfc048, 0xfc23c, 0xfc450, 0xfc645, 0xfc839, 0xfca4c, 0xfcc41, 0xfce36, 0xfd04a, 0xfd23d, 0xfd451, 0xfd646,
            0xfd83a, 0xfda4d, 0xfdc43, 0xfde37, 0xfe04b, 0xfe23f, 0xfe453, 0xfe648, 0xfe83c, 0xfea4f, 0xfec44, 0xfee38,
            0xff04c, 0xff241, 0xff436, 0xff64a, 0xff83e, 0xffa51, 0xffc46, 0xffe3a, 0x10004e, 0x100242, 0x100437,
            0x10064b, 0x100841, 0x100a53, 0x100c48, 0x100e3c, 0x10104f, 0x101244, 0x101438, 0x10164c, 0x101842,
            0x101a35, 0x101c49, 0x101e3d, 0x102051, 0x102245, 0x10243a, 0x10264e, 0x102843, 0x102a37, 0x102c4b,
            0x102e3f, 0x103053, 0x103247, 0x10343b, 0x10364f, 0x103845, 0x103a38, 0x103c4c, 0x103e42, 0x104036,
            0x104249, 0x10443d, 0x104651, 0x104846, 0x104a3a, 0x104c4e, 0x104e43, 0x105038, 0x10524a, 0x10543e,
            0x105652, 0x105847, 0x105a3b, 0x105c4f, 0x105e45, 0x106039, 0x10624c, 0x106441, 0x106635, 0x106849,
            0x106a3d, 0x106c51, 0x106e47, 0x10703c, 0x10724f, 0x107444, 0x107638, 0x10784c, 0x107a3f, 0x107c53,
            0x107e48};

    private static int getBitInt(int data, int length, int shift) {
        return (data & (((1 << length) - 1) << shift)) >> shift;
    }

    private static long solarToInt(int y, int m, int d) {
        m = (m + 9) % 12;
        y = y - m / 10;
        return 365 * y + y / 4 - y / 100 + y / 400 + (m * 306 + 5) / 10 + (d - 1);
    }

    private static int[] solarFromInt(long g) {
        long y = (10000 * g + 14780) / 3652425;
        long ddd = g - (365 * y + y / 4 - y / 100 + y / 400);
        if (ddd < 0) {
            y--;
            ddd = g - (365 * y + y / 4 - y / 100 + y / 400);
        }
        long mi = (100 * ddd + 52) / 3060;
        long mm = (mi + 2) % 12 + 1;
        y = y + (mi + 2) / 12;
        long dd = ddd - (mi * 306 + 5) / 10 + 1;
        int[] solar = new int[4];
        solar[0] = (int) y;
        solar[1] = (int) mm;
        solar[2] = (int) dd;
        return solar;
    }

    /**
     * 公历转农历 Solar To Lunar
     *
     * @param year  公历年
     * @param month 公历月
     * @param day   公历日
     * @return [0]农历年 [1]农历月 [2]农历日 [3]是否闰月 0 false : 1 true
     */
    @SuppressWarnings("all")
    public static int[] solarToLunarMy(int year, int month, int day) {
        int[] lunarInt = new int[4];
        int index = year - SOLAR[0];
        int data = (year << 9) | (month << 5) | (day);
        int solar11;
        if (SOLAR[index] > data) {
            index--;
        }
        solar11 = SOLAR[index];
        int y = getBitInt(solar11, 12, 9);
        int m = getBitInt(solar11, 4, 5);
        int d = getBitInt(solar11, 5, 0);
        long offset = solarToInt(year, month, day) - solarToInt(y, m, d);

        int days = LUNAR_MONTH_DAYS[index];
        int leap = getBitInt(days, 4, 13);

        int lunarY = index + SOLAR[0];
        int lunarM = 1;
        int lunarD;
        offset += 1;

        for (int i = 0; i < 13; i++) {
            int dm = getBitInt(days, 1, 12 - i) == 1 ? 30 : 29;
            if (offset > dm) {
                lunarM++;
                offset -= dm;
            } else {
                break;
            }
        }
        lunarD = (int) (offset);
        lunarInt[0] = lunarY;
        lunarInt[1] = lunarM;
        lunarInt[3] = 0;

        if (leap != 0 && lunarM > leap) {
            lunarInt[1] = lunarM - 1;
            if (lunarM == leap + 1) {
                lunarInt[3] = 1;
            }
        }
        lunarInt[2] = lunarD;
        return lunarInt;
    }


    /**
     * 农历转公历
     *
     * @param lunarYear  农历年
     * @param lunarMonth 农历月
     * @param lunarDay   农历天
     * @param isLeap     是否是闰年 0 false : 1 true
     * @return [0]新历年 [1]新历月 [2]新历日 [3]是否闰月 0 false : 1 true
     */
    @SuppressWarnings("unused")
    public static int[] lunarToSolar(int lunarYear, int lunarMonth, int lunarDay, boolean isLeap) {
        int days = LUNAR_MONTH_DAYS[lunarYear - LUNAR_MONTH_DAYS[0]];
        int leap = getBitInt(days, 4, 13);
        int offset = 0;
        int loop = leap;
        if (!isLeap) {
            if (lunarMonth <= leap || leap == 0) {
                loop = lunarMonth - 1;
            } else {
                loop = lunarMonth;
            }
        }
        for (int i = 0; i < loop; i++) {
            offset += getBitInt(days, 1, 12 - i) == 1 ? 30 : 29;
        }
        offset += lunarDay;

        int solar11 = SOLAR[lunarYear - SOLAR[0]];

        int y = getBitInt(solar11, 12, 9);
        int m = getBitInt(solar11, 4, 5);
        int d = getBitInt(solar11, 5, 0);

        return solarFromInt(solarToInt(y, m, d) + offset - 1);
    }



    //1900-2049
    private static final int[] LUNAR_INFO = {
            0x04bd8, 0x04ae0, 0x0a570, 0x054d5, 0x0d260, 0x0d950, 0x16554, 0x056a0, 0x09ad0, 0x055d2,
            0x04ae0, 0x0a5b6, 0x0a4d0, 0x0d250, 0x1d255, 0x0b540, 0x0d6a0, 0x0ada2, 0x095b0, 0x14977,
            0x04970, 0x0a4b0, 0x0b4b5, 0x06a50, 0x06d40, 0x1ab54, 0x02b60, 0x09570, 0x052f2, 0x04970,
            0x06566, 0x0d4a0, 0x0ea50, 0x06e95, 0x05ad0, 0x02b60, 0x186e3, 0x092e0, 0x1c8d7, 0x0c950,
            0x0d4a0, 0x1d8a6, 0x0b550, 0x056a0, 0x1a5b4, 0x025d0, 0x092d0, 0x0d2b2, 0x0a950, 0x0b557,
            0x06ca0, 0x0b550, 0x15355, 0x04da0, 0x0a5d0, 0x14573, 0x052d0, 0x0a9a8, 0x0e950, 0x06aa0,
            0x0aea6, 0x0ab50, 0x04b60, 0x0aae4, 0x0a570, 0x05260, 0x0f263, 0x0d950, 0x05b57, 0x056a0,
            0x096d0, 0x04dd5, 0x04ad0, 0x0a4d0, 0x0d4d4, 0x0d250, 0x0d558, 0x0b540, 0x0b5a0, 0x195a6,
            0x095b0, 0x049b0, 0x0a974, 0x0a4b0, 0x0b27a, 0x06a50, 0x06d40, 0x0af46, 0x0ab60, 0x09570,
            0x04af5, 0x04970, 0x064b0, 0x074a3, 0x0ea50, 0x06b58, 0x055c0, 0x0ab60, 0x096d5, 0x092e0,
            0x0c960, 0x0d954, 0x0d4a0, 0x0da50, 0x07552, 0x056a0, 0x0abb7, 0x025d0, 0x092d0, 0x0cab5,
            0x0a950, 0x0b4a0, 0x0baa4, 0x0ad50, 0x055d9, 0x04ba0, 0x0a5b0, 0x15176, 0x052b0, 0x0a930,
            0x07954, 0x06aa0, 0x0ad50, 0x05b52, 0x04b60, 0x0a6e6, 0x0a4e0, 0x0d260, 0x0ea65, 0x0d530,
            0x05aa0, 0x076a3, 0x096d0, 0x04bd7, 0x04ad0, 0x0a4d0, 0x1d0b6, 0x0d250, 0x0d520, 0x0dd45,
            0x0b5a0, 0x056d0, 0x055b2, 0x049b0, 0x0a577, 0x0a4b0, 0x0aa50, 0x1b255, 0x06d20, 0x0ada0
    };

    private static final int[] solarTermInfo = {
            0, 21208, 42467, 63836, 85337, 107014, 128867, 150921,
            173149, 195551, 218072, 240693, 263343, 285989, 308563, 331033,
            353350, 375494, 397447, 419210, 440795, 462224, 483532, 504758
    };

    private static final String[] solarTerm = {
            "小寒", "大寒", "立春", "雨水", "惊蛰", "春分", "清明", "谷雨", "立夏", "小满", "芒种", "夏至",
            "小暑", "大暑", "立秋", "处暑", "白露", "秋分", "寒露", "霜降", "立冬", "小雪", "大雪", "冬至"};

    private static final String[] monthInfo = new String[]{"", "正月", "二月", "三月", "四月", "五月",
            "六月", "七月", "八月", "九月", "十月", "冬月", "腊月"};

    private static final String[] dayInfo = new String[]{"", "一", "二", "三", "四", "五", "六", "七", "八", "九"};

    // 允许输入的最小年份
    private final static int MIN_YEAR = 1900;
    // 允许输入的最大年份
    private final static int MAX_YEAR = 2049;
    // 阳历日期计算起点
    private final static String START_DATE = "19000130";

    /**
     * 阳历转阴历
     *
     * @param year
     * @param month
     * @param day
     * @return
     */
    public static String[] solarToLunar(int year, int month, int day) {
        int i;
        int temp = 0;
        int lunarYear;
        int lunarMonth; //农历月份
        int lunarDay; //农历当月第几天
        boolean leapMonthFlag = false;

        String solarDate = "" + year;

        if (month < 10) {
            solarDate = solarDate + "0" + month;
        } else {
            solarDate = solarDate + month;
        }

        if (day < 10) {
            solarDate = solarDate + "0" + day;
        } else {
            solarDate = solarDate + day;
        }

        SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMdd");
        Date myDate = null;
        Date startDate = null;
        try {
            myDate = formatter.parse(solarDate);
            startDate = formatter.parse(START_DATE);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        int offset = daysBetween(startDate, myDate);

        for (i = MIN_YEAR; i <= MAX_YEAR; i++) {
            temp = getYearDays(i);  //求当年农历年天数
            if (offset - temp < 1) {
                break;
            } else {
                offset -= temp;
            }
        }
        lunarYear = i;

        int leapMonth = getLeapMonth(lunarYear);//计算该年闰哪个月
        //设定当年是否有闰月
        boolean isLeapYear;
        if (leapMonth > 0) {
            isLeapYear = true;
        } else {
            isLeapYear = false;
        }

        for (i = 1; i <= 12; i++) {
            if (i == leapMonth + 1 && isLeapYear) {
                temp = getLeapMonthDays(lunarYear);
                isLeapYear = false;
                leapMonthFlag = true;
                i--;
            } else {
                try {
                    temp = getMonthDays(lunarYear, i);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            offset -= temp;
            if (offset <= 0) {
                break;
            }
        }

        offset += temp;
        lunarMonth = i;
        lunarDay = offset;
        return new String[]{(leapMonthFlag & (lunarMonth == leapMonth) ? "闰" : "") + getLunarMonth(lunarMonth),
                getLunarDay(lunarDay), getLunarHoliday(lunarYear, lunarMonth, lunarDay)};
    }

    /**
     * 计算阴历年 月的天数
     *
     * @param lunarYear 阴历年
     * @param month     阴历月
     * @return 该月天数
     */
    private static int getMonthDays(int lunarYear, int month) throws Exception {
        if ((month > 31) || (month < 0)) {
            throw (new Exception("月份有错！"));
        }
        int bit = 1 << (16 - month);
        if (((LUNAR_INFO[lunarYear - 1900] & 0x0FFFF) & bit) == 0) {
            return 29;
        } else {
            return 30;
        }
    }

    /**
     * 计算两个阳历日期相差的天数。
     *
     * @param startDate 开始时间
     * @param endDate   截至时间
     * @return 天数
     */
    private static int daysBetween(Date startDate, Date endDate) {
        int days = 0;
        //将转换的两个时间对象转换成Calendar对象
        java.util.Calendar can1 = java.util.Calendar.getInstance();
        can1.setTime(startDate);
        java.util.Calendar can2 = java.util.Calendar.getInstance();
        can2.setTime(endDate);
        //拿出两个年份
        int year1 = can1.get(java.util.Calendar.YEAR);
        int year2 = can2.get(java.util.Calendar.YEAR);
        //天数

        java.util.Calendar can = null;
        //如果can1 < can2
        //减去小的时间在这一年已经过了的天数
        //加上大的时间已过的天数
        if (can1.before(can2)) {
            days -= can1.get(java.util.Calendar.DAY_OF_YEAR);
            days += can2.get(java.util.Calendar.DAY_OF_YEAR);
            can = can1;
        } else {
            days -= can2.get(java.util.Calendar.DAY_OF_YEAR);
            days += can1.get(java.util.Calendar.DAY_OF_YEAR);
            can = can2;
        }
        for (int i = 0; i < Math.abs(year2 - year1); i++) {
            //获取小的时间当前年的总天数
            days += can.getActualMaximum(java.util.Calendar.DAY_OF_YEAR);
            //再计算下一年。
            can.add(Calendar.YEAR, 1);
        }
        return days;
    }

    /**
     * 计算阴历年的总天数
     *
     * @param year 阴历年
     * @return 总天数
     */
    private static int getYearDays(int year) {
        int sum = 29 * 12;
        for (int i = 0x8000; i >= 0x8; i >>= 1) {
            if ((LUNAR_INFO[year - 1900] & 0xfff0 & i) != 0) {
                sum++;
            }
        }
        return sum + getLeapMonthDays(year);
    }

    /**
     * 计算阴历年闰月多少天
     *
     * @param year 阴历年
     * @return 天数
     */
    private static int getLeapMonthDays(int year) {
        if (getLeapMonth(year) != 0) {
            if ((LUNAR_INFO[year - MIN_YEAR] & 0xf0000) == 0) {
                return 29;
            } else {
                return 30;
            }
        } else {
            return 0;
        }
    }

    /**
     * 计算阴历年闰哪个月 1-12 , 没闰传回 0
     *
     * @param year 阴历年
     * @return 月份
     */
    private static int getLeapMonth(int year) {
        return LUNAR_INFO[year - 1900] & 0xf;
    }

    private static String getLunarMonth(int month) {
        return monthInfo[month];
    }

    private static String getLunarDay(int day) {
        if (day == 10) {
            return "初十";
        } else if (day == 20) {
            return "二十";
        } else if (day == 30) {
            return "三十";
        }

        String str1 = "";
        int d1 = day / 10;
        if (d1 == 0) {
            str1 = "初";
        } else if (d1 == 1) {
            str1 = "十";
        } else if (d1 == 2) {
            str1 = "廿";
        } else if (d1 == 3) {
            str1 = "卅";
        }
        return str1 + dayInfo[day % 10];
    }

    /**
     * 计算农历节日
     *
     * @param year
     * @param month
     * @param day
     * @return
     */
    private static String getLunarHoliday(int year, int month, int day) {


        String holiday = "";
        if (month == 1 && day == 1) {
            holiday = "春节";
        } else if (month == 1 && day == 15) {
            holiday = "元宵节";
        } else if (month == 2 && day == 2) {
            holiday = "龙抬头";
        } else if (month == 5 && day == 5) {
            holiday = "端午节";
        } else if (month == 7 && day == 7) {
            holiday = "七夕";
        } else if (month == 8 && day == 15) {
            holiday = "中秋节";
        } else if (month == 9 && day == 9) {
            holiday = "重阳节";
        } else if (month == 12 && day == 8) {
            holiday = "腊八";
        } else if (month == 12 && day == 23) {
            holiday = "小年";
        } else {
            if (month == 12) {
                if ((((daysInLunarMonth(year, month) == 29) && day == 29))
                        || ((((daysInLunarMonth(year, month) == 30) && day == 30)))) {
                    holiday = "除夕";
                }
            }
        }
        return holiday;
    }

    public static int daysInLunarMonth(int year, int month) {
        if ((LUNAR_INFO[year - MIN_YEAR] & (0x10000 >> month)) == 0)
            return 29;
        else
            return 30;
    }

    private static GregorianCalendar utcCal = null;

    /**
     * 根据阳历日期计算24节气
     */
    public static String getTermString(int solarYear, int solarMonth, int solarDay) {
        String termString = "";
        if (getSolarTermDay(solarYear, solarMonth * 2) == solarDay) {
            termString = solarTerm[solarMonth * 2];
        } else if (getSolarTermDay(solarYear, solarMonth * 2 + 1) == solarDay) {
            termString = solarTerm[solarMonth * 2 + 1];
        }
        return termString;
    }

    private static int getSolarTermDay(int solarYear, int index) {
        return getUTCDay(getSolarTermCalendar(solarYear, index));
    }

    private static Date getSolarTermCalendar(int solarYear, int index) {
        long l = (long) 31556925974.7 * (solarYear - 1900)
                + solarTermInfo[index] * 60000L;
        l = l + UTC(1900, 0, 6, 2, 5, 0);
        return new Date(l);
    }

    private static synchronized int getUTCDay(Date date) {
        makeUTCCalendar();
        synchronized (utcCal) {
            utcCal.clear();
            utcCal.setTimeInMillis(date.getTime());
            return utcCal.get(java.util.Calendar.DAY_OF_MONTH);
        }
    }

    private static void makeUTCCalendar() {
        if (utcCal == null) {
            utcCal = new GregorianCalendar(TimeZone.getTimeZone("UTC"));
        }
    }

    private static synchronized long UTC(int y, int m, int d, int h, int min, int sec) {
        makeUTCCalendar();
        synchronized (utcCal) {
            utcCal.clear();
            utcCal.set(y, m, d, h, min, sec);
            return utcCal.getTimeInMillis();
        }
    }
    /**计算24节气结束*/






}
