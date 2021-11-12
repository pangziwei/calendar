package com.manggeek.android.geek;

import android.os.Bundle;

import com.manggeek.android.geek.http.GeekHttp;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

/**
 * Fragment基础Activity
 * 提供FragmentActivity快捷功能
 * Created by wanglei on 16/3/25.
 */
public class GeekFragmentActivity extends GeekActivity {

    public FragmentManager mFManager;
    private Fragment tempFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mFManager = getSupportFragmentManager();
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

    protected void setDefaultFragment(Fragment fm, int layoutId) {
        FragmentTransaction mFragmentTrans = mFManager.beginTransaction();
        mFragmentTrans.add(layoutId, fm).commitAllowingStateLoss();
        tempFragment = fm;
    }

    protected void switchFragment(Fragment to, int layoutId) {
        if (tempFragment != to) {
            FragmentTransaction transaction = mFManager.beginTransaction();
            if (!to.isAdded()) { // 先判断是否被add过
                transaction.setCustomAnimations(
                        R.anim.slide_right_in,
                        R.anim.slide_left_out,
                        R.anim.slide_left_in,
                        R.anim.slide_right_out)
                        .hide(tempFragment)
                        .add(layoutId, to)
                        .commitAllowingStateLoss(); // 隐藏当前的fragment，add下一个到Activity中
            } else {
                transaction.setCustomAnimations(
                        R.anim.slide_left_in,
                        R.anim.slide_right_out,
                        R.anim.slide_right_in,
                        R.anim.slide_left_out)
                        .hide(tempFragment)
                        .show(to)
                        .commitAllowingStateLoss(); // 隐藏当前的fragment，显示下一个
            }
            tempFragment = to;
        }
    }

    @Override
    protected void onDestroy() {
        GeekHttp http = GeekHttp.getHttp();
        if (http != null) {
            http.cancelBySign(this);
        }
        super.onDestroy();
    }


}
