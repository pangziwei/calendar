package com.juyou.calendar.mine.about;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.Toolbar;

import com.juyou.calendar.R;
import com.juyou.calendar.activity.MyMainActivity;
import com.juyou.calendar.base.BaseActivity;
import com.juyou.calendar.bo.StringCache;
import com.juyou.calendar.util.WebUtils;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class AboutActivity extends BaseActivity {


    @BindView(R.id.tv_title_left)
    TextView tvTitleLeft;
    @BindView(R.id.tv_lef_back)
    ImageView tvLefBack;
    @BindView(R.id.view_actionBar_title)
    TextView viewActionBarTitle;
    @BindView(R.id.iv_title_right)
    ImageView ivTitleRight;
    @BindView(R.id._about_vesion)
    TextView AboutVesion;
    @BindView(R.id.ll_about_user_agreement)
    LinearLayout llAboutUserAgreement;
    @BindView(R.id.ll_about_privacy_agreement)
    LinearLayout llAboutPrivacyAgreement;
    @BindView(R.id.ll_about_contact_us)
    LinearLayout llAboutContactUs;
    @BindView(R.id.ll_title_left)
    LinearLayout ll_title_left;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);
        ButterKnife.bind(this);
        initView();

    }


    private void initView() {
        viewActionBarTitle.setText("关于我们");
        viewActionBarTitle.setTextColor(getResources().getColor(R.color.white));
        ivTitleRight.setVisibility(View.GONE);
        tvLefBack.setVisibility(View.VISIBLE);
        tvTitleLeft.setVisibility(View.GONE);
    }


    @OnClick({R.id.ll_title_left, R.id.ll_about_user_agreement, R.id.ll_about_privacy_agreement, R.id.ll_about_contact_us})
    public void onViewClicked(View view) {
        switch (view.getId()) {

            case R.id.ll_title_left:
                finish();
                break;
            case R.id.ll_about_user_agreement:
                WebUtils.loadTitleWeb(AboutActivity.this, "https://www.77tianqi.com/h5/rules.html?hideCloseBtn=1", "用户协议");

                break;
            case R.id.ll_about_privacy_agreement:
                WebUtils.loadTitleWeb(AboutActivity.this, "https://www.77tianqi.com/h5/rules.html?hideCloseBtn=1", "隐私协议");

                break;
            case R.id.ll_about_contact_us:
                Toast.makeText(AboutActivity.this, "跳转联系我们", Toast.LENGTH_SHORT).show();
                break;
        }
    }
}
