package com.juyou.calendar.util;


import android.view.View;

import com.jakewharton.rxbinding.view.RxView;

import java.util.concurrent.TimeUnit;

import rx.android.schedulers.AndroidSchedulers;

/**
 * @desc 防止重复点击
 */
public class ClickUtils {
    public static void viewClick(View svNext, final OnClickListener clickListener) {
        RxView.clicks(svNext)
                .throttleFirst(5, TimeUnit.SECONDS)
                .subscribeOn(AndroidSchedulers.mainThread())
                .subscribe(aVoid -> clickListener.onClick(svNext));
    }
    public static void viewZanClick(View svNext, final OnClickListener clickListener) {
        RxView.clicks(svNext)
                .throttleFirst(2, TimeUnit.SECONDS)
                .subscribeOn(AndroidSchedulers.mainThread())
                .subscribe(aVoid -> clickListener.onClick(svNext));
    }

    public interface OnClickListener {
        void onClick(View view);
    }
}
