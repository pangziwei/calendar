package com.manggeek.android.geek;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.manggeek.android.geek.view.InjectedView;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

/**
 * 基础的Fragment
 * 提供Fragment快捷功能
 * Created by wanglei on 16/3/25.
 */
public class GeekFragment extends Fragment {

    public GeekFragmentActivity mActivity;
    public LayoutInflater mInflater;
    public FragmentManager mFManager;
    public Bundle mBundle;
    public Fragment mFragment;

    @Override public void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.mActivity = (GeekFragmentActivity) getActivity();
        this.mBundle = getArguments();
        this.mFragment = this;
        this.mFManager = getChildFragmentManager();
    }


    public View setContentView(LayoutInflater inflater, int layoutResID, ViewGroup container) {
        return setContentView(inflater, layoutResID, container, false);
    }

    public View setContentView(LayoutInflater inflater, int layoutResID, ViewGroup container, boolean attachToRoot) {
        this.mInflater = inflater;
        View viewRoot = inflater.inflate(layoutResID, container, attachToRoot);
        InjectedView.init(this, viewRoot);
        viewRoot.setOnClickListener(null);
        return viewRoot;
    }

    /**
     * 添加Fragment
     *
     * @param isAddBackStack 是否添加回退栈
     */
    public FragmentTransaction addFragment(int contentId, Fragment fragment, String tag, boolean isAddBackStack) {
        FragmentTransaction transaction = mFManager.beginTransaction();
        transaction.add(contentId, fragment, tag);
        if (isAddBackStack) {
            transaction.addToBackStack(tag);
        }
        return transaction;
    }

    /**
     * 覆盖Fragment
     *
     * @param isAddBackStack 是否添加回退栈
     */
    public FragmentTransaction replaceFragment(int contentId, Fragment fragment, String tag, boolean isAddBackStack) {
        FragmentTransaction transaction = mFManager.beginTransaction();
        transaction.replace(contentId, fragment, tag);
        if (isAddBackStack) {
            transaction.addToBackStack(tag);
        }
        return transaction;
    }

    private Fragment tempFragment;

    protected void setDefaultFragment(Fragment fm, int layoutId) {
        FragmentTransaction mFragmentTrans = mFManager.beginTransaction();
        mFragmentTrans.add(layoutId, fm).commitAllowingStateLoss();
        tempFragment = fm;
    }

    protected void switchFragment(Fragment to, int layoutId) {
        if (tempFragment != to) {
            FragmentTransaction transaction = mFManager.beginTransaction();
            if (!to.isAdded()) { // 先判断是否被add过
                transaction.hide(tempFragment).add(layoutId, to).commitAllowingStateLoss(); // 隐藏当前的fragment，add下一个到Activity中
            } else {
                transaction.hide(tempFragment).show(to).commitAllowingStateLoss(); // 隐藏当前的fragment，显示下一个
            }
            tempFragment = to;
        }
    }


}
