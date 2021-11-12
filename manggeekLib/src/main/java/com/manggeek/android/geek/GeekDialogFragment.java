package com.manggeek.android.geek;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.manggeek.android.geek.view.InjectedView;

import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

public class GeekDialogFragment extends DialogFragment {
    public GeekFragmentActivity mActivity;
    public LayoutInflater mInflater;
    public FragmentManager mFManager;
    public Bundle mBundle;
    public Fragment mFragment;

    @Override
    public void onCreate( Bundle savedInstanceState) {
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


}
