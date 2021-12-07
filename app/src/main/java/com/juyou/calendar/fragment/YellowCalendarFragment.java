package com.juyou.calendar.fragment;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.webkit.WebView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.google.gson.Gson;
import com.haibin.calendarview.CalendarUtil;
import com.juyou.calendar.R;
import com.juyou.calendar.base.MyExFragment;
import com.juyou.calendar.bean.DateChangeBean;
import com.juyou.calendar.bo.CurrentBean;
import com.juyou.calendar.bo.JuYouBo;
import com.juyou.calendar.bo.NetResultCallBack;
import com.juyou.calendar.util.DateUtil;
import com.manggeek.android.geek.utils.JSONUtil;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.Map;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class YellowCalendarFragment extends MyExFragment {

    @BindView(R.id.view_actionBar_title)
    TextView viewActionBarTitle;
    @BindView(R.id.img_right)
    ImageView imgRight;
    @BindView(R.id.ll_right)
    LinearLayout llRight;
    @BindView(R.id.ll_title_left)
    LinearLayout ll_title_left;
    @BindView(R.id.tv_study_title)
    TextView tvStudyTitle;
    @BindView(R.id.tv_title_left)
    TextView tvTitleLeft;
    @BindView(R.id.go_back_calendar)
    TextView goBackCalendar;
    @BindView(R.id.tv_lef_back)
    ImageView tvLefBack;
    @BindView(R.id.iv_title_right)
    ImageView ivTitleRight;
    @BindView(R.id.ll_center_title)
    LinearLayout llCenterTitle;
    @BindView(R.id.tv_date)
    TextView tvDate;
    @BindView(R.id.ll_date)
    LinearLayout llDate;
    @BindView(R.id.rl_pa)
    LinearLayout rlPa;
    @BindView(R.id.iv_fortune_last_day)
    ImageView ivFortuneLastDay;
    @BindView(R.id.tv_fortune_lunar_date)
    TextView tvFortuneLunarDate;
    @BindView(R.id.tv_fortune_tgdz_year)
    TextView tvFortuneTgdzYear;
    @BindView(R.id.tv_fortune_tgdz_month)
    TextView tvFortuneTgdzMonth;
    @BindView(R.id.tv_fortune_tgdz_day)
    TextView tvFortuneTgdzDay;
    @BindView(R.id.tv_fortune_week)
    TextView tvFortuneWeek;
    @BindView(R.id.iv_fortune_next_day)
    ImageView ivFortuneNextDay;
    @BindView(R.id.fortune_web)
    WebView fortuneWeb;
    @BindView(R.id.ll_ic_fortune_read)
    LinearLayout llIcFortuneRead;
    private int[] cDate = CalendarUtil.getCurrentDate();
    Calendar calendar;
    DateChangeBean dateChangeBean;//变换后的日期

    @Override
    protected void initView(View view, Bundle savedInstanceState) {
        ButterKnife.bind(this, view);
        init();
        calendar = Calendar.getInstance();

    }

    private void initData() {
        JuYouBo.LunarToNongLi(getActivity(), cDate[0], cDate[1], cDate[2], new NetResultCallBack() {
            @Override
            public void onSuccess(int what, CurrentBean currentBean) {
                Log.e("转农历", "currentBean-----一进来的就是------------" + currentBean);

            }

            @Override
            public void onFail(int what, CurrentBean currentBean) {

            }
        });
    }

    private void init() {
        viewActionBarTitle.setText(cDate[0] + "年" + cDate[1] + "月" + cDate[2] + "日" + " ");
        llRight.setVisibility(View.VISIBLE);
        ll_title_left.setVisibility(View.INVISIBLE);
        viewActionBarTitle.setTextColor(getResources().getColor(R.color.white));
        Glide.with(getActivity()).load(R.mipmap.share).into(imgRight);
        initData();//一进来的就是转一下农历
    }


    @Override
    public void loadData() {

    }

    @Override
    public int getLayoutId() {
        return R.layout.fragment_yellow_calendar;
    }


    @Override
    public void onDestroy() {
        super.onDestroy();

    }


    @OnClick({R.id.iv_title_right, R.id.ll_center_title, R.id.iv_fortune_last_day, R.id.iv_fortune_next_day, R.id.ll_ic_fortune_read})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.iv_title_right:
                Toast.makeText(getActivity(), "右上角分享", Toast.LENGTH_SHORT).show();
                break;
            case R.id.ll_center_title:
                Toast.makeText(getActivity(), "选择日期", Toast.LENGTH_SHORT).show();
                break;
            case R.id.iv_fortune_last_day:
//                Toast.makeText(getActivity(), "上一天", Toast.LENGTH_SHORT).show();
                calendar.set(Calendar.MILLISECOND, 0);
                calendar.set(Calendar.SECOND, 0);
                calendar.set(Calendar.MINUTE, 0);
                calendar.set(Calendar.HOUR_OF_DAY, 0);
                calendar.set(Calendar.HOUR_OF_DAY, -24);
                dateChangeBean = JSONUtil.getObj(String.valueOf(new Gson().toJson(calendar)), DateChangeBean.class);
                viewActionBarTitle.setText(dateChangeBean.getYear() + "年" + (dateChangeBean.getMonth() + 1) + "月" + dateChangeBean.getDayOfMonth() + "日" + " ");
                initDataToLunar(dateChangeBean.getYear(), (dateChangeBean.getMonth() + 1), dateChangeBean.getDayOfMonth());

                break;
            case R.id.iv_fortune_next_day:
                Toast.makeText(getActivity(), "下一天", Toast.LENGTH_SHORT).show();
                calendar.set(Calendar.MILLISECOND, 0);
                calendar.set(Calendar.SECOND, 0);
                calendar.set(Calendar.MINUTE, 0);
                calendar.set(Calendar.HOUR_OF_DAY, +24);
                dateChangeBean = JSONUtil.getObj(String.valueOf(new Gson().toJson(calendar)), DateChangeBean.class);
                viewActionBarTitle.setText(dateChangeBean.getYear() + "年" + (dateChangeBean.getMonth() + 1) + "月" + dateChangeBean.getDayOfMonth() + "日" + " ");
                initDataToLunar(dateChangeBean.getYear(), (dateChangeBean.getMonth() + 1), dateChangeBean.getDayOfMonth());
                break;
            case R.id.ll_ic_fortune_read:
                Toast.makeText(getActivity(), "现在文阅读", Toast.LENGTH_SHORT).show();
                break;
        }
    }

    private void initDataToLunar(int year, int month, int dayOfMonth) {
        JuYouBo.LunarToNongLi(getActivity(), year, month, dayOfMonth, new NetResultCallBack() {
            @Override
            public void onSuccess(int what, CurrentBean currentBean) {
                Log.e("测试接口", "currentBean------------------" + currentBean);
            }

            @Override
            public void onFail(int what, CurrentBean currentBean) {

            }
        });
    }

}
