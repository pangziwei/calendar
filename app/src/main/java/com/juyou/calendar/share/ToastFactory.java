package com.juyou.calendar.share;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.widget.TextView;
import android.widget.Toast;

import com.juyou.calendar.R;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

import androidx.core.app.NotificationManagerCompat;


/**
 * 外部可直接在子线程中调用
 * Created by xievxin on 2017/1/13.
 */

public class ToastFactory {

    private static XxToast toastInstance = null;

    private static XxToast getToastInstance(Context context) {
        if (toastInstance == null) {
            synchronized (ToastFactory.class) {
                if (toastInstance == null) {
                    toastInstance = new XxToast(context);
                }
            }
        }
        return toastInstance;
    }

    public static void toastShort(Context context, CharSequence txt) {
        try {
//            ToastUtils.show(txt);
            Toast.makeText(context, txt, Toast.LENGTH_SHORT).show();

        } catch (Exception e) {
            showToastOnMainThread(context.getApplicationContext(), txt, Toast.LENGTH_SHORT);
        }
    }

    public static void toastLong(Context context, String txt) {
        try {
//            ToastUtils.show(txt);
            Toast.makeText(context, txt, Toast.LENGTH_SHORT).show();
        } catch (Exception e) {
            showToastOnMainThread(context.getApplicationContext(), txt, Toast.LENGTH_LONG);
        }
    }

    private static void showToastOnMainThread(final Context context, final CharSequence txt, final int duration) {
        ThreadPool.getMainHandler().post(new Runnable() {
            @Override
            public void run() {
                XxToast toast = getToastInstance(context);
                toast.setText(txt);
                toast.setDuration(duration);
                //解决华为等部分手机上通知栏权限关闭时 toast显示不出来的问题
//                if (isNotificationEnabled(context)) {
//                    toast.show();
//                } else {
//                    showSystemToast(toast);
//                }
            }
        });
    }


    private static Object iNotificationManagerObj;

    /**
     * 显示系统Toast
     */
    private static void showSystemToast(Toast toast) {
        try {
            @SuppressLint("SoonBlockedPrivateApi") Method getServiceMethod = Toast.class.getDeclaredMethod("getService");
            getServiceMethod.setAccessible(true);
            if (iNotificationManagerObj == null) {
                iNotificationManagerObj = getServiceMethod.invoke(null);
                Class iNotificationManagerCls = Class.forName("android.app.INotificationManager");
                Object iNotificationManagerProxy = Proxy.newProxyInstance(toast.getClass().getClassLoader(), new Class[]{iNotificationManagerCls}, new InvocationHandler() {
                    @Override
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                        //强制使用系统Toast
                        if ("enqueueToast".equals(method.getName())
                                || "enqueueToastEx".equals(method.getName())) {  //华为p20 pro上为enqueueToastEx
                            args[0] = "android";
                        }
                        return method.invoke(iNotificationManagerObj, args);
                    }
                });
                Field sServiceFiled = Toast.class.getDeclaredField("sService");
                sServiceFiled.setAccessible(true);
                sServiceFiled.set(null, iNotificationManagerProxy);
            }
            toast.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 消息通知是否开启
     */
//    private static boolean isNotificationEnabled(Context context) {
//        NotificationManagerCompat notificationManagerCompat = NotificationManagerCompat.from(context);
//        return notificationManagerCompat.areNotificationsEnabled();
//    }


    static class XxToast extends Toast {

        private TextView tv;

        public XxToast(Context context) {
            super(context);
            tv = (TextView) LayoutInflater.from(context).inflate(R.layout.toast, null);
            this.setGravity(Gravity.CENTER, 0, 0);
            this.setView(tv);
        }

        public void setText(CharSequence txt) {
            tv.setText(txt);
        }
    }
}
