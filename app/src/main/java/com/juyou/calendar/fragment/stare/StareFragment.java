package com.juyou.calendar.fragment.stare;


import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toolbar;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.juyou.calendar.R;
import com.juyou.calendar.base.MyExFragment;

import butterknife.BindView;
import butterknife.OnClick;

public class StareFragment extends MyExFragment {

    @BindView(R.id.view_actionBar_title)
    TextView viewActionBarTitle;


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }


    @Override
    public int getLayoutId() {
        return R.layout.fragment_stare;
    }

    @Override
    protected void initView(View view, Bundle savedInstanceState) {
        init();
    }

    private void init() {
        viewActionBarTitle.setText("我是万年历首页");
        //使用AsyncHttpClient，实现联网的声明
    }

    @Override
    public void loadData() {
    }

    @OnClick(R.id.view_actionBar_title)
    public void onViewClicked() {
    }
}
