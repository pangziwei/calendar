package com.juyou.calendar.util;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;

import com.juyou.calendar.base.MyExFragment;

/**
 * @author LianZheng
 * @create at 2021-03-30，10:23
 * @desc 自定义检查手机网络状态是否切换的广播接受器
 */
public class NetBroadcastReceiver extends BroadcastReceiver {
    public NetEvevt evevt = MyExFragment.evevt;

    @Override
    public void onReceive(Context context, Intent intent) {
        if (intent.getAction().equals(ConnectivityManager.CONNECTIVITY_ACTION)) {
            int netWorkState = NetUtil.getNetWorkState(context);
            // 接口回调传过去状态的类型
            evevt.onNetChange(netWorkState);
        }
    }

    public interface NetEvevt {

        public void onNetChange(int netMobile);

    }
}
