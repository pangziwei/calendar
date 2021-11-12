package com.juyou.calendar.manage.refres;

import android.content.Context;
import android.view.ViewGroup;

import com.juyou.calendar.manage.NoMoreDataFootView;



public interface IrefreshProcessor {
    void initRefresh(Context context, NoMoreDataFootView footView, boolean isLoadMore, ViewGroup refreshLayout, IRefreshCallBack callback);
}
