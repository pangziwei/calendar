package com.juyou.calendar.bo;

import com.manggeek.android.geek.http.HttpParams;

import java.io.Serializable;

/**
 * @author: ${huangwenfei}
 * @description 传入用户token鉴权
 * @date: Create in 17:31 2019/10/22
 */
public class BaseParams extends HttpParams implements Serializable {
    public BaseParams() {
//        String token = StringCache.get("token");
//        put("Authorization", "bearer "+token);
    }
}
