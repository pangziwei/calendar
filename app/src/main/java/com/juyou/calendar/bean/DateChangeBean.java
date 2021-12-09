package com.juyou.calendar.bean;

/**
 * @author 聚友互动
 * @datetime 2021-12-07 15:15
 * @detail :阴历农历变换后的日期
 */
public class DateChangeBean {

    /**
     * dayOfMonth : 9
     * hourOfDay : 0
     * minute : 0
     * month : 11
     * second : 0
     * year : 2021
     */

    private int dayOfMonth;
    private int hourOfDay;
    private int minute;
    private int month;
    private int second;
    private int year;

    public int getDayOfMonth() {
        return dayOfMonth;
    }

    public void setDayOfMonth(int dayOfMonth) {
        this.dayOfMonth = dayOfMonth;
    }

    public int getHourOfDay() {
        return hourOfDay;
    }

    public void setHourOfDay(int hourOfDay) {
        this.hourOfDay = hourOfDay;
    }

    public int getMinute() {
        return minute;
    }

    public void setMinute(int minute) {
        this.minute = minute;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public int getSecond() {
        return second;
    }

    public void setSecond(int second) {
        this.second = second;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }
}
