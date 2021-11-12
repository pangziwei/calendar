package com.manggeek.android.geek.bitmap;

import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.RequestOptions;
import com.bumptech.glide.util.Util;
import com.manggeek.android.geek.utils.PrintUtil;

/**
 * 提供图片相关处理
 * Created by huangwenfei on 17/5/4.
 */
public class GeekBitmap {
    /**
     * 显示网络/本地图片
     *
     * @param activity
     * @param imageView
     * @param path
     */
    public static void display(Activity activity, ImageView imageView, String path) {
        if (activity != null && !activity.isFinishing()) {
            if (Util.isOnMainThread()) {
                Glide.with(activity).load(path).apply(new RequestOptions().placeholder(imageView.getDrawable())).into(imageView);
            }
        }
    }

    public static void display(Activity activity, ImageView imageView, String path, boolean printLog) {
        if (printLog) {
            PrintUtil.log("GeekBitmap,path:" + path);
        }
        if (activity != null && !activity.isFinishing()) {
            if (Util.isOnMainThread()) {
                Glide.with(activity).load(path).apply(new RequestOptions().placeholder(imageView.getDrawable())).into(imageView);
            }
        }
    }

    public static void display(Context mContext, ImageView imageView, String path, RequestOptions myOptions) {
//        PrintUtil.log("imageView:" + path);
        if (Util.isOnMainThread()) {
            Glide.with(mContext).load(path).apply(new RequestOptions().placeholder(imageView.getDrawable())).apply(myOptions).into(imageView);
        }
    }

    public static void display(Context mContext, ImageView imageView, String path, RequestOptions myOptions,  RequestListener<Drawable> requestListener) {
//        PrintUtil.log("imageView:" + path);
        if (Util.isOnMainThread()) {
            Glide.with(mContext).load(path).apply(myOptions).apply(new RequestOptions().placeholder(imageView.getDrawable())).listener(requestListener).into(imageView);
        }
    }

    /**
     * 显示资源图片
     *
     * @param activity
     * @param imageView
     * @param resId
     */
    public static void display(Activity activity, ImageView imageView, int resId) {
        if (Util.isOnMainThread()) {
            Glide.with(activity).load(resId).apply(new RequestOptions().placeholder(imageView.getDrawable())).into(imageView);
        }
    }

    /**
     * 显示图片
     *
     * @param activity
     * @param imageView
     * @param object
     */
    public static void display(Activity activity, ImageView imageView, Object object) {
        if (Util.isOnMainThread()) {
            Glide.with(activity).load(object).apply(new RequestOptions().placeholder(imageView.getDrawable())).into(imageView);
        }
    }

    /**
     * 显示网络/本地图片
     *
     * @param context
     * @param imageView
     * @param object
     */
    public static void display(Context context, ImageView imageView, Object object) {
        if (Util.isOnMainThread()) {
            Glide.with(context).load(object)
                    .apply(new RequestOptions().placeholder(imageView.getDrawable()))
                    .into(imageView);
        }
    }

    public static void display(Context context, ImageView imageView, Object object, boolean printLog) {
        if (printLog) {
            PrintUtil.log("GeekBitmap,path:" + object);
        }
        if (Util.isOnMainThread()) {
            Glide.with(context).load(object).apply(new RequestOptions().placeholder(imageView.getDrawable())).into(imageView);
        }
    }

    //显示圆形图片
    public static void displayCirclePicture(Context context, ImageView imageView, Object object) {
        if (Util.isOnMainThread()) {
            RequestOptions requestOptions = RequestOptions.circleCropTransform();
            Glide.with(context).load(object).apply(requestOptions).into(imageView);
        }
    }

    //显示圆角图片
    public static void displayRoundPicture(Context context, int dp, ImageView imageView, Object object) {
        if (Util.isOnMainThread()) {
//            Glide.with(context).load(object).transform(new GlideRoundTransform(context, dp)).into(imageView);
        }
    }


}
