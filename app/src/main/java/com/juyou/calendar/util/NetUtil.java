package com.juyou.calendar.util;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

/**
 * @author LianZheng
 * @create at 2021-03-30，10:06
 * @desc 判断网络工具类
 */
public class NetUtil {


    /**
     * 没有连接网络
     */
    public static final int NETWORK_NONE = -1;
    /**
     * 移动网络
     */
    public static final int NETWORK_MOBILE = 0;
    /**
     * 无线网络
     */
    public static final int NETWORK_WIFI = 1;

    public static int getNetWorkState(Context context) {
        // 得到连接管理器对象
        ConnectivityManager connectivityManager = (ConnectivityManager) context
                .getSystemService(Context.CONNECTIVITY_SERVICE);

        NetworkInfo activeNetworkInfo = connectivityManager
                .getActiveNetworkInfo();
        if (activeNetworkInfo != null && activeNetworkInfo.isConnected()) {

            if (activeNetworkInfo.getType() == (ConnectivityManager.TYPE_WIFI)) {
                return NETWORK_WIFI;
            } else if (activeNetworkInfo.getType() == (ConnectivityManager.TYPE_MOBILE)) {
                return NETWORK_MOBILE;
            }
        } else {
            return NETWORK_NONE;
        }
        return NETWORK_NONE;
    }


//
//    记得在manifest中注册
//<receiver android:name="cn.broadcastreceiver.NetBroadcastReceiver">
//            <intent-filter>
//                <action android:name="android.net.conn.CONNECTIVITY_CHANGE"/>
//            </intent-filter>
//        </receiver>


//    abstract public static class BaseActivity extends FragmentActivity implements NetBroadcastReceiver.NetEvevt {
//
//        public static NetBroadcastReceiver.NetEvevt evevt;
//        /**
//         * 网络类型
//         */
//        private int netMobile;
//
//        @Override
//        protected void onCreate(Bundle arg0) {
//            // TODO Auto-generated method stub
//            super.onCreate(arg0);
//            evevt = this;
//            inspectNet();
//        }
//
//
//        /**
//         * 初始化时判断有没有网络
//         */
//
//        public boolean inspectNet() {
//            this.netMobile = NetUtil.getNetWorkState(BaseActivity.this);
//            return isNetConnect();
//
//            // if (netMobile == 1) {
//            // System.out.println("inspectNet：连接wifi");
//            // } else if (netMobile == 0) {
//            // System.out.println("inspectNet:连接移动数据");
//            // } else if (netMobile == -1) {
//            // System.out.println("inspectNet:当前没有网络");
//            //
//            // }
//        }
//
//        /**
//         * 网络变化之后的类型
//         */
//        @Override
//        public void onNetChange(int netMobile) {
//            // TODO Auto-generated method stub
//            this.netMobile = netMobile;
//            isNetConnect();
//
//        }
//
//        /**
//         * 判断有无网络 。
//         *
//         * @return true 有网, false 没有网络.
//         */
//        public boolean isNetConnect() {
//            if (netMobile == 1) {
//                return true;
//            } else if (netMobile == 0) {
//                return true;
//            } else if (netMobile == -1) {
//                return false;
//
//            }
//            return false;
//        }
//
//    }
//
//
//    public class MainActivity extends BaseActivity {
//
//        @Override
//        protected void onCreate(Bundle savedInstanceState) {
//            super.onCreate(savedInstanceState);
//
//            setContentView(R.layout.activity_main);
//
//        }
//
//        @Override
//        public void onNetChange(int netMobile) {
//            // TODO Auto-generated method stub
//            //在这个判断，根据需要做处理
//        }
//
//
//    }
}
