package com.juyou.calendar.eventbus;

/**
 * @author 聚友互动
 * @datetime 2021-11-22 13:18
 * @detail :qq登录的eventBus的数据头像传递
 */
public class QQLoginEventBus {
    public String avatar;
    public String nickname;

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public QQLoginEventBus(String avatar ,String nickname) {
        this.avatar = avatar;
        this.nickname = nickname;
    }

}
