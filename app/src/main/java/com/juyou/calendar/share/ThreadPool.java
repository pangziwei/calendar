package com.juyou.calendar.share;

import android.os.Handler;
import android.os.Looper;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by xin on 2016/1/14.
 */
public class ThreadPool {

    private static ExecutorService pool = null;
    private static Handler mainHandler = null;

    static {
        pool = Executors.newFixedThreadPool(3);
    }

    public static void execute(Runnable runnable) {
        pool.execute(runnable);
    }

    public static Handler getMainHandler() {
        if(mainHandler==null) {
            synchronized (ThreadPool.class) {
                if(mainHandler==null) {
                    mainHandler = new Handler(Looper.getMainLooper());
                }
            }
        }
        return mainHandler;
    }
}
