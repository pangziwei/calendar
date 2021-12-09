package com.juyou.calendar.fragment.yellowcalendar;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.google.gson.Gson;
import com.haibin.calendarview.CalendarUtil;
import com.juyou.calendar.R;
import com.juyou.calendar.base.MyExFragment;
import com.juyou.calendar.bean.DateChangeBean;
import com.juyou.calendar.bean.LunarDateBean;
import com.juyou.calendar.bo.CurrentBean;
import com.juyou.calendar.bo.JuYouBo;
import com.juyou.calendar.bo.NetResultCallBack;
import com.juyou.calendar.fragment.yellowcalendar.adapter.YellowCalendarJiAdapter;
import com.juyou.calendar.fragment.yellowcalendar.adapter.YellowCalendarTimeAdapter;
import com.juyou.calendar.fragment.yellowcalendar.adapter.YellowCalendarYiAdapter;
import com.juyou.calendar.fragment.yellowcalendar.bean.YellowLunarJiListBean;
import com.juyou.calendar.fragment.yellowcalendar.bean.YellowLunarTimeListBean;
import com.juyou.calendar.fragment.yellowcalendar.bean.YellowLunarYiListBean;
import com.juyou.calendar.weather.bean.CaiYunhourlysListBean;
import com.manggeek.android.geek.utils.JSONUtil;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class YellowCalendarFragment extends MyExFragment {
    private static final String TAG = "YellowCalendarFragment";

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
    @BindView(R.id.ll_ic_fortune_read)
    LinearLayout llIcFortuneRead;
    @BindView(R.id.rv_yi_recycle)
    RecyclerView rvYiRecycle;
    @BindView(R.id.ll_yellow_jiri_query)
    LinearLayout llYellowJiriQuery;
    @BindView(R.id.rv_ji_recycle)
    RecyclerView rvJiRecycle;
    @BindView(R.id.rv_time_yiji_recycle)
    RecyclerView rvTimeYijiRecycle;
    @BindView(R.id.yellow_wealth_direction)
    TextView yellowWealthDirection;
    @BindView(R.id.yellow_blessing_direction)
    TextView yellowBlessingDirection;
    @BindView(R.id.yellow_joy_direction)
    TextView yellowJoyDirection;
    @BindView(R.id.yellow_students_direction)
    TextView yellowStudentsDirection;
    @BindView(R.id.yellow_lucky_day_up)
    TextView yellowLuckyDayUp;
    @BindView(R.id.yellow_lucky_day_down)
    TextView yellowLuckyDayDown;
    @BindView(R.id.yellow_cho_sha_up)
    TextView yellowChoShaUp;
    @BindView(R.id.yellow_cho_sha_down)
    TextView yellowChoShaDown;
    @BindView(R.id.yellow_five)
    TextView yellowFive;
    @BindView(R.id.yellow_today_fetal_up)
    TextView yellowTodayFetalUp;
    @BindView(R.id.yellow_today_fetal_down)
    TextView yellowTodayFetalDown;
    @BindView(R.id.yellow_pe_zu_up)
    TextView yellowPeZuUp;
    @BindView(R.id.yellow_pe_zu_down)
    TextView yellowPeZuDown;
    @BindView(R.id.yellow_constellation_up)
    TextView yellowConstellationUp;
    @BindView(R.id.yellow_constellation_down)
    TextView yellowConstellationDown;
    private int[] cDate = CalendarUtil.getCurrentDate();
    Calendar calendar;
    DateChangeBean dateChangeBean;//变换后的日期
    LunarDateBean lunarDateBean;//请求接口获取的农历禁忌什么的数据
    YellowCalendarJiAdapter yellowCalendarJiAdapter;
    YellowCalendarYiAdapter yellowCalendarYiAdapter;
    YellowCalendarTimeAdapter yellowCalendarTimeAdapter;

    @Override
    protected void initView(View view, Bundle savedInstanceState) {
        ButterKnife.bind(this, view);
        init();
        calendar = Calendar.getInstance();

    }

    private void initData() {
//        JuYouBo.LunarToNongLi(getActivity(), cDate[0], cDate[1], cDate[2], new NetResultCallBack() {
        JuYouBo.LunarToNongLi(getActivity(), 1900, 1, 8, new NetResultCallBack() {
            @Override
            public void onSuccess(int what, CurrentBean currentBean) {
                lunarDateBean = JSONUtil.getObj(String.valueOf(currentBean.getData()), LunarDateBean.class);
                Log.e(TAG, "lunarDateBean-----yi----------" + lunarDateBean.getYi());
                Log.e(TAG, "lunarDateBean-----initDataToLunar--ji----------" + lunarDateBean.getJi());
                showJiDateYi(lunarDateBean.getYi());//黄历上的宜
                showJiDate(lunarDateBean.getJi());//黄历上的忌
                showTimeDate(lunarDateBean.getJi());//黄历上的时辰宜忌
            }

            @Override
            public void onFail(int what, CurrentBean currentBean) {

            }
        });
    }

    private void showTimeDate(List<String> ji) {
        List<YellowLunarTimeListBean> LunarTime = new ArrayList<>();
        for (int i = 0; i < ji.size(); i++) {
            YellowLunarTimeListBean yellowLunarTimeListBean = new YellowLunarTimeListBean();
            yellowLunarTimeListBean.setYellowLunarTime(ji.get(i));
            LunarTime.add(yellowLunarTimeListBean);
        }

        if (yellowCalendarTimeAdapter == null) {
            yellowCalendarTimeAdapter = new YellowCalendarTimeAdapter(getActivity(), LunarTime);
            LinearLayoutManager forecastManager = new LinearLayoutManager(getActivity());
            forecastManager.setOrientation(LinearLayoutManager.HORIZONTAL);
            rvTimeYijiRecycle.setLayoutManager(forecastManager);
            rvTimeYijiRecycle.setAdapter(yellowCalendarTimeAdapter);
        } else {
            yellowCalendarTimeAdapter.refreshData(getActivity(), LunarTime);
        }


    }

    private void showJiDateYi(List<String> yi) {

        List<YellowLunarYiListBean> LunarYi = new ArrayList<>();
        for (int i = 0; i < yi.size(); i++) {
            YellowLunarYiListBean yellowLunarYiListBean = new YellowLunarYiListBean();
            yellowLunarYiListBean.setYellowLunarYi(yi.get(i));
            LunarYi.add(yellowLunarYiListBean);
        }

        if (yellowCalendarYiAdapter == null) {
            yellowCalendarYiAdapter = new YellowCalendarYiAdapter(getActivity(), LunarYi);
            GridLayoutManager forecastManager = new GridLayoutManager(getActivity(), 3);
            forecastManager.setOrientation(LinearLayoutManager.VERTICAL);
            rvYiRecycle.setLayoutManager(forecastManager);
            rvYiRecycle.setAdapter(yellowCalendarYiAdapter);
        } else {
            yellowCalendarYiAdapter.refreshData(getActivity(), LunarYi);
        }

    }

    private void showJiDate(List<String> ji) {
        List<YellowLunarJiListBean> LunarJi = new ArrayList<>();
        for (int i = 0; i < ji.size(); i++) {
            YellowLunarJiListBean yellowLunarJiListBean = new YellowLunarJiListBean();
            yellowLunarJiListBean.setYellowLunarJi(ji.get(i));
            LunarJi.add(yellowLunarJiListBean);
        }

        if (yellowCalendarJiAdapter == null) {
            yellowCalendarJiAdapter = new YellowCalendarJiAdapter(getActivity(), LunarJi);
            LinearLayoutManager forecastManager = new LinearLayoutManager(getActivity());
            forecastManager.setOrientation(LinearLayoutManager.HORIZONTAL);
            rvJiRecycle.setLayoutManager(forecastManager);
            rvJiRecycle.setAdapter(yellowCalendarJiAdapter);
        } else {
            yellowCalendarJiAdapter.refreshData(getActivity(), LunarJi);
        }

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


    @OnClick({R.id.iv_title_right, R.id.ll_center_title, R.id.iv_fortune_last_day, R.id.iv_fortune_next_day, R.id.ll_ic_fortune_read, R.id.ll_yellow_jiri_query})
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
            case R.id.ll_yellow_jiri_query:
                Toast.makeText(getActivity(), "吉日查询", Toast.LENGTH_SHORT).show();
                break;
        }
    }

    private void initDataToLunar(int year, int month, int dayOfMonth) {
        JuYouBo.LunarToNongLi(getActivity(), year, month, dayOfMonth, new NetResultCallBack() {
            @Override
            public void onSuccess(int what, CurrentBean currentBean) {
                Log.e("测试接口", "currentBean------------------" + currentBean);
                lunarDateBean = JSONUtil.getObj(String.valueOf(currentBean.getData()), LunarDateBean.class);
//                Log.e(TAG, "lunarDateBean-----initDataToLunar------------" + new Gson().toJson(lunarDateBean));
                Log.e(TAG, "lunarDateBean-----initDataToLunar--ji----------" + lunarDateBean.getJi());
//                Log.e(TAG, "lunarDateBean-----initDataToLunar---yi---------" + lunarDateBean.getYi());
//                Log.e(TAG, "lunarDateBean------initDataToLunar--jieri---------" + lunarDateBean.getJieri());

//                showYiDate(lunarDateBean.getYi());
//                showJiDate(lunarDateBean.getJi());
//                showTimeDate(lunarDateBean.getYi());
            }

            @Override
            public void onFail(int what, CurrentBean currentBean) {

            }
        });
    }


}
