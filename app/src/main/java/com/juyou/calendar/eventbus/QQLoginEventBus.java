package com.juyou.calendar.eventbus;

/**
 * @author 聚友互动
 * @datetime 2021-11-22 13:18
 * @detail :qq登录的eventBus的数据头像传递
 */
public class QQLoginEventBus {
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String message;

    public QQLoginEventBus(String message) {
        this.message = message;
    }


    @Override
    public String toString() {
        return "QQLoginEventBus{" +
                "message='" + message + '\'' +
                '}';
    }
}
