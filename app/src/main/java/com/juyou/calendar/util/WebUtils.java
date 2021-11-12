package com.juyou.calendar.util;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import com.juyou.calendar.activity.WebViewActivity;


public class WebUtils {
    /**
     * @desc 加载h5页面  titleName为null时自动获取标题
     */
    public static void loadTitleWeb(Context context, String loadUrl, String titleName) {
        Intent intent = new Intent(context, WebViewActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        Bundle bundle = new Bundle();
        bundle.putString(WebViewActivity.URL, loadUrl);
        bundle.putString(WebViewActivity.TITLE, titleName);
        intent.putExtras(bundle);
        context.startActivity(intent);
        Log.e("TAG", "加载h5页面---------url-" + loadUrl);
    }
}
