package com.juyou.calendar.fragment.mine;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.Nullable;

import com.bumptech.glide.Glide;
import com.juyou.calendar.R;
import com.juyou.calendar.base.MyExFragment;
import com.juyou.calendar.eventbus.QQLoginEventBus;
import com.juyou.calendar.mine.about.AboutActivity;
import com.juyou.calendar.util.WebUtils;
import com.manggeek.android.geek.view.CircleImageView;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import butterknife.BindView;
import butterknife.OnClick;

public class MineFragment extends MyExFragment {
    public static final String TAG = "MineFragment";
    @BindView(R.id.tv_mine_login)
    TextView tvMineLogin;
    @BindView(R.id.ll_mine_star_query)
    LinearLayout llMineStarQuery;
    @BindView(R.id.ll_mine_jiri_query)
    LinearLayout llMineJiriQuery;
    @BindView(R.id.ll_mine_fortune_query)
    LinearLayout llMineFortuneQuery;
    @BindView(R.id.ll_mine_yellow_query)
    LinearLayout llMineYellowQuery;
    @BindView(R.id.ll_mine_jieqian)
    ImageView llMineJieqian;
    @BindView(R.id.ll_mine_dream)
    LinearLayout llMineDream;
    @BindView(R.id.ll_mine_day_weather)
    LinearLayout llMineDayWeather;
    @BindView(R.id.ll_mine_name_test)
    LinearLayout llMineNameTest;
    @BindView(R.id.ll_mine_star)
    LinearLayout llMineStar;
    @BindView(R.id.btn_mine_about)
    TextView btnMineAbout;
    @BindView(R.id.iv_mine_setting)
    ImageView ivMineSetting;
    @BindView(R.id.cv_mine_head)
    CircleImageView cvMineHead;
    @BindView(R.id.tv_login_nicknome)
    TextView tvLoginNicknome;

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
        EventBus.getDefault().register(this);

    }



    @OnClick({R.id.tv_mine_login, R.id.ll_mine_star_query, R.id.ll_mine_jiri_query, R.id.ll_mine_fortune_query, R.id.ll_mine_yellow_query, R.id.ll_mine_jieqian, R.id.ll_mine_dream, R.id.ll_mine_day_weather, R.id.ll_mine_name_test, R.id.ll_mine_star, R.id.btn_mine_about, R.id.iv_mine_setting})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.tv_mine_login:
                Intent intent = new Intent(getActivity(), OneClickLoginActivity.class);
                startActivity(intent);
                break;
            case R.id.ll_mine_star_query:
                break;
            case R.id.ll_mine_jiri_query:
                break;
            case R.id.ll_mine_fortune_query:
                WebUtils.loadTitleWeb(getActivity(), "https://www.77tianqi.com/h5/rules.html?hideCloseBtn=1", "今日运势");
                break;
            case R.id.ll_mine_yellow_query:
                break;
            case R.id.ll_mine_jieqian:
                break;
            case R.id.ll_mine_dream:
                break;
            case R.id.ll_mine_day_weather:
                break;
            case R.id.ll_mine_name_test:
                break;
            case R.id.ll_mine_star:
                break;
            case R.id.btn_mine_about:
                startActivity(new Intent(getActivity(), AboutActivity.class));
                break;
            case R.id.iv_mine_setting:
                startActivity(new Intent(getActivity(), SettingActivity.class));
                break;
        }
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onEventMainThread(QQLoginEventBus messageEvent) {
//        if (!messageEvent.getMessage().equals("")) {
//            Glide.with(getActivity()).load(messageEvent.getMessage()).into(cvMineHead);
//        }
        if (!messageEvent.getAvatar().equals("")) {
            Glide.with(getActivity()).load(messageEvent.getAvatar()).into(cvMineHead);
        }
        if (!messageEvent.getNickname().equals("")) {
            tvLoginNicknome.setText(messageEvent.getNickname());
        }

    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);
    }
}
