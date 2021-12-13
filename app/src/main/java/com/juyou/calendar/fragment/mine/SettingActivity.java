package com.juyou.calendar.fragment.mine;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Switch;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.juyou.calendar.R;
import com.juyou.calendar.activity.MyMainActivity;
import com.juyou.calendar.bo.StringCache;
import com.juyou.calendar.mine.FeedbackActivity;
import com.juyou.calendar.mine.about.AboutActivity;
import com.juyou.calendar.util.ISharedPreference;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class SettingActivity extends AppCompatActivity implements View.OnClickListener {

    @BindView(R.id.tv_title_left)
    TextView tvTitleLeft;
    @BindView(R.id.tv_lef_back)
    ImageView tvLefBack;
    @BindView(R.id.view_actionBar_title)
    TextView viewActionBarTitle;
    @BindView(R.id.iv_title_right)
    ImageView ivTitleRight;
    @BindView(R.id.notice)
    Switch notice;
    @BindView(R.id.ll_setting_feed_back)
    LinearLayout llSettingFeedBack;
    @BindView(R.id.ll_setting_about_us)
    LinearLayout llSettingAboutUs;
    @BindView(R.id.ll_title_left)
    LinearLayout ll_title_left;
    @BindView(R.id.btn_exit)
    TextView btnExit;


    public TextView tv_week_sun;
    public TextView tv_week_mon;

    private ISharedPreference sharedPreference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting);
        sharedPreference = ISharedPreference.getInstance(getApplication());

        tv_week_sun = findViewById(R.id.tv_week_sun);
        tv_week_mon = findViewById(R.id.tv_week_mon);
        tv_week_sun.setOnClickListener(this);
        tv_week_mon.setOnClickListener(this);
        //可优化部分
        if (ISharedPreference.getInstance(getApplication()).getWeekMonNotice()) {
            isOnClickSun();
        } else {

        }
        if (ISharedPreference.getInstance(getApplication()).getWeekSunNotice()) {

        } else {
            isOnClickMon();
        }

        ButterKnife.bind(this);
        initView();
    }

    private void initView() {
        viewActionBarTitle.setText("设置");
        viewActionBarTitle.setTextColor(getResources().getColor(R.color.white));
        ivTitleRight.setVisibility(View.GONE);
        tvLefBack.setVisibility(View.VISIBLE);
        tvTitleLeft.setVisibility(View.GONE);
    }

    @OnClick({R.id.ll_title_left, R.id.notice, R.id.ll_setting_feed_back, R.id.ll_setting_about_us, R.id.btn_exit})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.ll_title_left:
                finish();
                break;
            case R.id.notice:
//                notice.setChecked();
                break;
            case R.id.ll_setting_feed_back:
                startActivity(new Intent(SettingActivity.this, FeedbackActivity.class));

                break;
            case R.id.ll_setting_about_us:
                startActivity(new Intent(SettingActivity.this, AboutActivity.class));
                break;
            case R.id.btn_exit:
                StringCache.put("login", "false");
                StringCache.put("token", "");
                Intent intent = new Intent(SettingActivity.this, MyMainActivity.class);
                intent.putExtra("SelectIndex", 1);
                startActivity(intent);
                finish();
                break;
        }
    }

    private void isOnClickMon() {
        tv_week_mon.setTextColor(this.getResources().getColor(R.color.white));
        tv_week_sun.setTextColor(this.getResources().getColor(R.color.color_F04646));
        tv_week_sun.setBackgroundResource(R.drawable.setting_choice_mun);
        tv_week_mon.setBackgroundResource(R.drawable.setting_choice_mun_bg);
    }

    private void isOnClickSun() {
        tv_week_sun.setTextColor(this.getResources().getColor(R.color.white));
        tv_week_mon.setTextColor(this.getResources().getColor(R.color.color_F04646));
        tv_week_sun.setBackgroundResource(R.drawable.setting_chose_sun_bg);
        tv_week_mon.setBackgroundResource(R.drawable.setting_choice_sun);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.tv_week_sun:
                isOnClickSun();
                sharedPreference.saveWeekSunNotice(true);
                sharedPreference.saveWeekMonNotice(false);
                break;
            case R.id.tv_week_mon:
                isOnClickMon();
                sharedPreference.saveWeekSunNotice(false);
                sharedPreference.saveWeekMonNotice(true);
                break;
        }

    }
}
