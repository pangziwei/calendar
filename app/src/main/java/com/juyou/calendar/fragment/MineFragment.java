package com.juyou.calendar.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.Nullable;

import com.juyou.calendar.R;
import com.juyou.calendar.base.MyExFragment;
import com.juyou.calendar.mine.about.AboutActivity;

import butterknife.BindView;
import butterknife.OnClick;

public class MineFragment extends MyExFragment {
    public static final String TAG = "MineFragment";
    @BindView(R.id.btn_mine_about)
    TextView btnMineAbout;


    @Override
    public void loadData() {
    }

    @Override
    public int getLayoutId() {
        return R.layout.fragment_mine;
    }

    @Override
    protected void initView(View view, Bundle savedInstanceState) {

    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
    }

    @OnClick({R.id.btn_mine_about})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.btn_mine_about://关于我们
                startActivity(new Intent(getActivity(), AboutActivity.class));
                break;
        }
    }
}
