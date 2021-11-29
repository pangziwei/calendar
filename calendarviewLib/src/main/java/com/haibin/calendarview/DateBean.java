package com.haibin.calendarview;

import android.graphics.Color;

public class DateBean {
    private int[] solar;//阳历年、月、日
    private String[] lunar;//农历月、日
    private String solarHoliday;//阳历节假日
    private String lunarHoliday;//阴历节假日
    private int lunarHolidayColor = Color.parseColor("#EC9729");
    ;//阴历节假日颜色Color.parseColor("#EC9729");//节假日的颜色（24节气那种）
    private String Customsday;//阴历节假日
    private int type;//0:上月，1:当月，2:下月
    private String term;//节气

    public int getLunarHolidayColor() {
        return lunarHolidayColor;
    }

    public void setLunarHolidayColor(int lunarHolidayColor) {
        this.lunarHolidayColor = lunarHolidayColor;
    }

    public int[] getSolar() {
        return solar;
    }

    public void setSolar(int year, int month, int day) {
        this.solar = new int[]{year, month, day};
    }

    public String[] getLunar() {
        return lunar;
    }

    public void setLunar(String[] lunar) {
        this.lunar = lunar;
    }

    public String getSolarHoliday() {
        return solarHoliday;
    }

    public void setSolarHoliday(String solarHoliday) {
        this.solarHoliday = solarHoliday;
    }

    public String getLunarHoliday() {
        return lunarHoliday;
    }

    public void setLunarHoliday(String lunarHoliday) {
        this.lunarHoliday = lunarHoliday;
    }

    public void setSolar(int[] solar) {
        this.solar = solar;
    }

    public String getCustomsday() {
        return Customsday;
    }

    public void setCustomsday(String customsday) {
        Customsday = customsday;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getTerm() {
        return term;
    }

    public void setTerm(String term) {
        this.term = term;
    }
}
