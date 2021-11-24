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
import com.juyou.calendar.mine.about.AboutActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class SettingActivity extends AppCompatActivity {

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
    @BindView(R.id.tv_week_sun)
    TextView tvWeekSun;
    @BindView(R.id.tv_week_mon)
    TextView tvWeekMon;
    @BindView(R.id.ll_setting_feed_back)
    LinearLayout llSettingFeedBack;
    @BindView(R.id.ll_setting_about_us)
    LinearLayout llSettingAboutUs;
    @BindView(R.id.ll_title_left)
    LinearLayout ll_title_left;
    @BindView(R.id.btn_exit)
    TextView btnExit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting);
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

    @OnClick({R.id.ll_title_left, R.id.notice, R.id.tv_week_sun, R.id.tv_week_mon, R.id.ll_setting_feed_back, R.id.ll_setting_about_us, R.id.btn_exit})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.ll_title_left:
                finish();
                break;
            case R.id.notice:
                break;
            case R.id.tv_week_sun:
                tvWeekSun.setTextColor(getResources().getColor(R.color.white));
                tvWeekMon.setTextColor(getResources().getColor(R.color.color_F04646));
                tvWeekSun.setBackgroundResource(R.drawable.setting_chose_sun_bg);
                tvWeekMon.setBackgroundResource(R.drawable.setting_choice_sun);

                break;
            case R.id.tv_week_mon:
                tvWeekMon.setTextColor(getResources().getColor(R.color.white));
                tvWeekSun.setTextColor(getResources().getColor(R.color.color_F04646));
                tvWeekSun.setBackgroundResource(R.drawable.setting_choice_mun);
                tvWeekMon.setBackgroundResource(R.drawable.setting_choice_mun_bg);
                break;
            case R.id.ll_setting_feed_back:
                break;
            case R.id.ll_setting_about_us:
                startActivity(new Intent(SettingActivity.this, AboutActivity.class));
                break;
            case R.id.btn_exit:
                StringCache.put("login", "false");
                StringCache.put("token", "");
                //下次默认的收款方式
                StringCache.put("strNumber", "");
                StringCache.put("payType", "");
                //下次默认的收款方式
                StringCache.put("payTypeWechat", "");
                StringCache.put("payTypeAlipay", "");
                StringCache.put("payTypeBank", "");
                //CID的设置为空
//                StringCache.put("GTCID", "");
//                Intent intent = new Intent(AboutActivity.this, MainActivity.class);
                Intent intent = new Intent(SettingActivity.this, MyMainActivity.class);
                intent.putExtra("SelectIndex", 1);
                startActivity(intent);
                finish();
                break;
        }
    }
}
