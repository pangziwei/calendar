package com.juyou.calendar.base;

import android.os.Bundle;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.juyou.calendar.util.NetBroadcastReceiver;
import com.juyou.calendar.util.NetUtil;

import androidx.fragment.app.Fragment;
import butterknife.ButterKnife;


public abstract class MyExFragment extends Fragment implements NetBroadcastReceiver.NetEvevt {

    private boolean isViewCreated = false;
    private boolean isUiVisible = false;

    protected abstract void initView(View view, Bundle savedInstanceState);

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
//        Log.e("tag", "测试id----------"+getLayoutId());
        View view = inflater.inflate(getLayoutId(), container, false);
        ButterKnife.bind(this, view);
        isViewCreated = true;
        initView(view, savedInstanceState);
//        Log.e("tag", "-------isUiVisible----"+isUiVisible+"------------"+isViewCreated);
        if (isUiVisible && isViewCreated) {
            loadData();
            isViewCreated = false;
            isUiVisible = false;
        }
        return view;
//        return super.onCreateView(inflater, container, savedInstanceState);
    }

    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
//        Log.e("tag", "懒加载"+isVisibleToUser);
        if (isVisibleToUser) {
            isUiVisible = true;
            if (isUiVisible && isViewCreated) {
                loadData();
                isViewCreated = false;
                isUiVisible = false;
            }
        } else {
            isUiVisible = false;
        }
    }

    public abstract void loadData();

    public abstract int getLayoutId();


    public static NetBroadcastReceiver.NetEvevt evevt;
    /**
     * 网络类型
     */
    private int netMobile;

    @Override
    public void onCreate(Bundle arg0) {
        // TODO Auto-generated method stub
        super.onCreate(arg0);
        evevt = this;
        inspectNet();
    }


    /**
     * 初始化时判断有没有网络
     */

    public boolean inspectNet() {
        this.netMobile = NetUtil.getNetWorkState(getActivity());
        return isNetConnect();

        // if (netMobile == 1) {
        // System.out.println("inspectNet：连接wifi");
        // } else if (netMobile == 0) {
        // System.out.println("inspectNet:连接移动数据");
        // } else if (netMobile == -1) {
        // System.out.println("inspectNet:当前没有网络");
        //
        // }
    }

    /**
     * 网络变化之后的类型
     */
    @Override
    public void onNetChange(int netMobile) {
        // TODO Auto-generated method stub
        this.netMobile = netMobile;
        isNetConnect();

    }

    /**
     * 判断有无网络 。
     *
     * @return true 有网, false 没有网络.
     */
    public boolean isNetConnect() {
        if (netMobile == 1) {
            return true;
        } else if (netMobile == 0) {
            return true;
        } else if (netMobile == -1) {
            return false;

        }
        return false;
    }


}
