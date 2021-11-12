package com.manggeek.android.geek.view;

import android.app.Activity;
import android.view.View;

import java.lang.reflect.Field;

/**
 * 通过注解生成View
 * Created by wanglei on 16/3/24.
 */
public class InjectedView {

    public static void init(Activity activity) {
        init(activity, activity.getWindow().getDecorView());
    }

    public static void init(Object injectedSource, View sourceView) {
        Field[] fields = injectedSource.getClass().getDeclaredFields();
        if (fields != null && fields.length > 0) {
            for (Field field : fields) {
                try {
                    field.setAccessible(true);
                    if (field.get(injectedSource) != null)
                        continue;
                    FindViewById viewInject = field.getAnnotation(FindViewById.class);
                    if (viewInject != null) {
                        int viewId = viewInject.id();
                        field.set(injectedSource, sourceView.findViewById(viewId));
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
