package com.juyou.calendar.eventbus;

/**
 * @author 聚友互动
 * @datetime 2021-11-22 13:18
 * @detail :周日还是周一
 */
public class CalendarChangeEventBus {
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String message;

    public CalendarChangeEventBus(String message) {
        this.message = message;
    }


    @Override
    public String toString() {
        return "QQLoginEventBus{" +
                "message='" + message + '\'' +
                '}';
    }
}
