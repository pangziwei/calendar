package com.juyou.calendar.bo;

import com.manggeek.android.geek.http.HttpParams;

import java.io.Serializable;

public class BaseHeadParams extends HttpParams implements Serializable {
    public BaseHeadParams() {
        put("Authorization","bearer "+StringCache.get("token"));
    }
}
