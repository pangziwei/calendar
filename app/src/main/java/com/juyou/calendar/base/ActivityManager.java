package com.juyou.calendar.base;

import android.app.Activity;

import java.util.Stack;

/*
 * 链证科技 2021年08月20日，星期五，15:37:13
 * 作用：
 */
public class ActivityManager {
    //单例模式(懒汉)
    private ActivityManager() {
    }

    private static ActivityManager activityManager;

    public static ActivityManager getInstance() {
        if (activityManager == null) {
            activityManager = new ActivityManager();
        }
        return activityManager;
    }

    //提供栈对象
    private Stack<Activity> stack = new Stack<>();

    //添加到栈中
    public void add(Activity activity) {
        if (activity != null) {
            stack.add(activity);
        }
    }


    //  //删除指定的activity

    private void remove(Activity activity) {
        if (activity != null) {
            for (int i = stack.size(); i >= 0; i--) {
                Activity activity1 = stack.get(i);
                if (activity1.getClass().equals(activity.getClass())) {
                    activity.finish();
                    stack.remove(activity);
                }
            }
        }
    }

    //删除当前的activity
    public void removeCurrent() {
        Activity activity = stack.lastElement();//获得当前activity
        activity.finish();
        stack.remove(activity);
    }

    //删除所有的activity
    public void removeAll() {
        for (int i = stack.size() - 1; i >= 0; i--) {
            Activity activity = stack.get(i);
            activity.finish();
            stack.remove(activity);
        }
    }

    //返回栈大小
    public int size() {
        return stack.size();
    }
}
