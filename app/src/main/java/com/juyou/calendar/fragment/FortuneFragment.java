package com.juyou.calendar.fragment;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toolbar;

import com.juyou.calendar.R;
import com.juyou.calendar.base.MyExFragment;
import com.juyou.calendar.util.WebUtils;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class FortuneFragment extends MyExFragment {


    @BindView(R.id.tv_title_left)
    TextView tvTitleLeft;
    @BindView(R.id.view_actionBar_title)
    TextView viewActionBarTitle;
    @BindView(R.id.img_right)
    ImageView imgRight;
    @BindView(R.id.ll_right)
    LinearLayout llRight;
    @BindView(R.id.bill_toolbar)
    Toolbar billToolbar;
    @BindView(R.id.rl_pa)
    LinearLayout rlPa;
    @BindView(R.id.tv_retry)
    TextView tvRetry;

    @Override
    protected void initView(View view, Bundle savedInstanceState) {
        ButterKnife.bind(this, view);
        init();

    }

    private void init() {
        viewActionBarTitle.setText("我是万年历");

        WebUtils.loadTitleWeb(getActivity(), "https://www.77tianqi.com/h5/rules.html?hideCloseBtn=1", "dfsg");
    }

    @Override
    public void loadData() {
    }

    @Override
    public int getLayoutId() {
        return R.layout.fragment_fortune;
    }

    @OnClick({R.id.tv_retry})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.tv_retry:

                break;

        }
    }


}
