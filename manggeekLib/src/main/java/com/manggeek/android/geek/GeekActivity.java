package com.manggeek.android.geek;

import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.LayoutInflater;

import com.bumptech.glide.Glide;
import com.bumptech.glide.util.Util;
import com.manggeek.android.geek.manager.ActivityManager;
import com.manggeek.android.geek.view.InjectedView;

import androidx.annotation.LayoutRes;
import androidx.appcompat.app.AppCompatActivity;


/**
 * APP基础Activity
 * 提供Activity快捷功能
 * Created by wanglei on 16/3/23.
 */
public class GeekActivity extends AppCompatActivity {

    public GeekActivity mActivity;
    public LayoutInflater mInflater;


    @Override
    protected void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityManager.getActivity().add(this);
        mActivity = this;
        mInflater = LayoutInflater.from(this);
    }

    @Override
    public void setContentView(@LayoutRes int layoutResID) {
        super.setContentView(layoutResID);
        InjectedView.init(this);
    }

    @Override
    protected void onDestroy() {
        ActivityManager.getActivity().remove(this);
        if (Util.isOnMainThread()) {
            Glide.with(getApplicationContext()).pauseRequests();
        }
        super.onDestroy();
    }

    @Override
    public Resources getResources() {
        Resources res = super.getResources();
        Configuration config = new Configuration();
        config.setToDefaults();
        res.updateConfiguration(config, res.getDisplayMetrics());
        return res;
    }

}
