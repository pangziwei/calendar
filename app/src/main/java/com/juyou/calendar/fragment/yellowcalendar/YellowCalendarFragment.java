package com.juyou.calendar.fragment.yellowcalendar;

import android.app.Dialog;
import android.os.Bundle;
import android.text.Html;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.FrameLayout;
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
import com.juyou.calendar.bean.LunarChangeDateBean;
import com.juyou.calendar.bean.LunarDateBean;
import com.juyou.calendar.bo.Api;
import com.juyou.calendar.bo.CurrentBean;
import com.juyou.calendar.bo.JuYouBo;
import com.juyou.calendar.bo.NetResultCallBack;
import com.juyou.calendar.fragment.calendar.mTimePickerBuilder;
import com.juyou.calendar.fragment.calendar.mTimePickerView;
import com.juyou.calendar.fragment.yellowcalendar.adapter.YellowCalendarJiAdapter;
import com.juyou.calendar.fragment.yellowcalendar.adapter.YellowCalendarTimeAdapter;
import com.juyou.calendar.fragment.yellowcalendar.adapter.YellowCalendarYiAdapter;
import com.juyou.calendar.fragment.yellowcalendar.bean.YellowLunarJiListBean;
import com.juyou.calendar.fragment.yellowcalendar.bean.YellowLunarTimeListBean;
import com.juyou.calendar.fragment.yellowcalendar.bean.YellowLunarYiListBean;
import com.juyou.calendar.util.ContentShare;
import com.juyou.calendar.util.DialogManager;
import com.juyou.calendar.util.H5UrlMananger;
import com.juyou.calendar.weather.bean.CaiYunhourlysListBean;
import com.manggeek.android.geek.cache.StringCache;
import com.manggeek.android.geek.utils.JSONUtil;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
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
        JuYouBo.LunarToNongLi(getActivity(), cDate[0], cDate[1], cDate[2], new NetResultCallBack() {
            @Override
            public void onSuccess(int what, CurrentBean currentBean) {
                lunarDateBean = JSONUtil.getObj(String.valueOf(currentBean.getData()), LunarDateBean.class);
                showJiDateYi(lunarDateBean.getYi());//黄历上的宜
                showJiDate(lunarDateBean.getJi());//黄历上的忌
                showTimeDate(lunarDateBean.getYi());//黄历上的时辰宜忌
                tvFortuneLunarDate.setText("农历" + lunarDateBean.getNl_yue() + lunarDateBean.getNl_ri());
                tvFortuneTgdzYear.setText(lunarDateBean.getGz_nian() + lunarDateBean.getShengxiao() + "年");
                tvFortuneTgdzMonth.setText(lunarDateBean.getGz_yue() + "月");
                tvFortuneTgdzDay.setText(lunarDateBean.getGz_ri() + "日");
                tvFortuneWeek.setText(lunarDateBean.getWeek_3());
                yellowFive.setText(lunarDateBean.getWx_ri()); //五行日
                char ch;
                String str;
                for (int i = 0; i < lunarDateBean.getXingxiu().length(); i++) {
                    ch = lunarDateBean.getXingxiu().charAt(i);
                    if (ch == '-') {
                        str = lunarDateBean.getXingxiu().replaceAll("-", "\r\n");//正则替换;
                        yellowConstellationUp.setText(str);
                    }
                }
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
            GridLayoutManager forecastManager = new GridLayoutManager(getActivity(), 4);
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


    @OnClick({R.id.ll_right, R.id.ll_center_title, R.id.iv_fortune_last_day, R.id.iv_fortune_next_day, R.id.ll_ic_fortune_read, R.id.ll_yellow_jiri_query})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.ll_right:
                Toast.makeText(getActivity(), "右上角分享", Toast.LENGTH_SHORT).show();
                showShareDialog();
                break;
            case R.id.ll_center_title:
                Toast.makeText(getActivity(), "选择日期", Toast.LENGTH_SHORT).show();
                chooseTime(viewActionBarTitle);
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
//                Toast.makeText(getActivity(), "下一天", Toast.LENGTH_SHORT).show();
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
                if (null == dateChangeBean) {
                    Toast.makeText(getActivity(), "-我是当天-吉日查询--" + cDate[0] + cDate[1] + cDate[2], Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(getActivity(), "吉日查询--我不是当天--" + dateChangeBean.getYear() + (dateChangeBean.getMonth() + 1) + dateChangeBean.getDayOfMonth(), Toast.LENGTH_SHORT).show();
                }
                break;
        }
    }

    private void initDataToLunar(int year, int month, int dayOfMonth) {

        JuYouBo.LunarToNongLi(getActivity(), year, month, dayOfMonth, new NetResultCallBack() {
            @Override
            public void onSuccess(int what, CurrentBean currentBean) {

                Log.e(TAG, "lunarDateBean------currentBean---currentBean----" + new Gson().toJson(currentBean));
                lunarDateBean = JSONUtil.getObj(String.valueOf(currentBean.getData()), LunarDateBean.class);
//                Log.e(TAG, "lunarDateBean-------------" + lunarDateBean);
                showJiDateYi(lunarDateBean.getYi());//黄历上的宜
                showJiDate(lunarDateBean.getJi());//黄历上的忌
                showTimeDate(lunarDateBean.getYi());//黄历上的时辰宜忌

                tvFortuneLunarDate.setText("农历" + lunarDateBean.getNl_yue() + lunarDateBean.getNl_ri());
                tvFortuneTgdzYear.setText(lunarDateBean.getGz_nian() + lunarDateBean.getShengxiao() + "年");
                tvFortuneTgdzMonth.setText(lunarDateBean.getGz_yue() + "月");
                tvFortuneTgdzDay.setText(lunarDateBean.getGz_ri() + "日");
                tvFortuneWeek.setText(lunarDateBean.getWeek_3());
                yellowFive.setText(lunarDateBean.getWx_ri()); //五行日
                char ch;
                String str;
                for (int i = 0; i < lunarDateBean.getXingxiu().length(); i++) {
                    ch = lunarDateBean.getXingxiu().charAt(i);
                    if (ch == '-') {
                        str = lunarDateBean.getXingxiu().replaceAll("-", "\r\n");//正则替换;
                        yellowConstellationUp.setText(str);
                    }
                }
            }

            @Override
            public void onFail(int what, CurrentBean currentBean) {

            }
        });
    }

    int yead;
    int month;
    int day;

    /**
     * 选择时间
     */
    private void chooseTime(TextView timeView) {
        //时间选择器
        mTimePickerView pTime = new mTimePickerBuilder(getActivity(), (date, v) -> {
            timeView.setText(getTime(date));

            yead = Integer.parseInt(getNeedTime(date).substring(0, 4));
            month = Integer.parseInt(getNeedTime(date).substring(4, 6));
            day = Integer.parseInt(getNeedTime(date).substring(6, 8));
            Log.e(TAG, "yead, month, day-----------" + yead + month + day);

            initChangeLunar(yead, month, day);


        })
                .setType(new boolean[]{true, true, true, false, false, false})// 控制分别控制“年”“月”“日”“时”“分”“秒”的显示或隐藏。new boolean[]{true, true, true, false, false, false}
                .isDialog(true)
                .build();
        Dialog mDialog = pTime.getDialog();
        if (mDialog != null) {
            FrameLayout.LayoutParams params = new FrameLayout.LayoutParams(
                    ViewGroup.LayoutParams.MATCH_PARENT,
                    ViewGroup.LayoutParams.WRAP_CONTENT,
                    Gravity.BOTTOM);
            params.leftMargin = 0;
            params.rightMargin = 0;
            pTime.getDialogContainerLayout().setLayoutParams(params);
            Window dialogWindow = mDialog.getWindow();
            if (dialogWindow != null) {
                dialogWindow.setWindowAnimations(com.bigkoo.pickerview.R.style.picker_view_slide_anim);//修改动画样式
                dialogWindow.setGravity(Gravity.BOTTOM);//改成Bottom,底部显示
            }
            mDialog.show();
        }
    }

    private void initChangeLunar(int yead, int month, int day) {
        JuYouBo.LunarToNongLi(getActivity(), yead, month, day, new NetResultCallBack() {
            @Override
            public void onSuccess(int what, CurrentBean currentBean) {

                Log.e(TAG, "initChangeLunar------initChangeLunar---initChangeLunar----" + new Gson().toJson(currentBean));
                LunarChangeDateBean lunarChangeDateBean = JSONUtil.getObj(String.valueOf(currentBean.getData()), LunarChangeDateBean.class);
                Log.e(TAG, "initChangeLunar-------------" + lunarChangeDateBean);
                showJiDateYi(lunarChangeDateBean.getYi());//黄历上的宜
                showJiDate(lunarChangeDateBean.getJi());//黄历上的忌
                showTimeDate(lunarChangeDateBean.getYi());//黄历上的时辰宜忌

                tvFortuneLunarDate.setText("农历" + lunarChangeDateBean.getNl_yue() + lunarChangeDateBean.getNl_ri());
                tvFortuneTgdzYear.setText(lunarChangeDateBean.getGz_nian() + lunarChangeDateBean.getShengxiao() + "年");
                tvFortuneTgdzMonth.setText(lunarChangeDateBean.getGz_yue() + "月");
                tvFortuneTgdzDay.setText(lunarChangeDateBean.getGz_ri() + "日");
                tvFortuneWeek.setText(lunarChangeDateBean.getWeek_3());
                yellowFive.setText(lunarChangeDateBean.getWx_ri()); //五行日
                char ch;
                String str;
                for (int i = 0; i < lunarChangeDateBean.getXingxiu().length(); i++) {
                    ch = lunarChangeDateBean.getXingxiu().charAt(i);
                    if (ch == '-') {
                        str = lunarChangeDateBean.getXingxiu().replaceAll("-", "\r\n");//正则替换;
                        yellowConstellationUp.setText(str);
                    }
                }
            }

            @Override
            public void onFail(int what, CurrentBean currentBean) {

            }
        });
    }


    private String getTime(Date date) {//可根据需要自行截取数据显示
        SimpleDateFormat format = (SimpleDateFormat) SimpleDateFormat.getDateInstance();
        format.applyPattern("yyyy年MM月dd日");
        return format.format(date);
    }

    private String getNeedTime(Date date) {//可根据需要自行截取数据显示
        SimpleDateFormat format = (SimpleDateFormat) SimpleDateFormat.getDateInstance();
        format.applyPattern("yyyyMMdd");
        return format.format(date);
    }

    //显示分享弹框
    private void showShareDialog() {
//        分享吧
        ContentShare contentShare = new ContentShare(getActivity());
//        contentShare.setShareSpannedContent("我是万年历", "大家好我是分享的内容", "https://blog.csdn.net/qq_37328546?spm=1019.2139.3001.5343", "https://image.baidu.com/search/detail?ct=503316480&z=0&ipn=false&word=%E5%A3%81%E7%BA%B8%20%E4%B8%8D%E5%90%8C%E9%A3%8E%E6%A0%BC%20%E5%94%AF%E7%BE%8E&step_word=&hs=0&pn=0&spn=0&di=32120&pi=0&rn=1&tn=baiduimagedetail&is=0%2C0&istype=2&ie=utf-8&oe=utf-8&in=&cl=2&lm=-1&st=-1&cs=3631594132%2C3972221223&os=1799234586%2C1945397593&simid=3631594132%2C3972221223&adpicid=0&lpn=0&ln=3814&fr=&fmq=1526269427171_R&fm=&ic=0&s=undefined&hd=undefined&latest=undefined&copyright=undefined&se=&sme=&tab=0&width=&height=&face=undefined&ist=&jit=&cg=wallpaper&bdtype=0&oriquery=&objurl=https%3A%2F%2Fgimg2.baidu.com%2Fimage_search%2Fsrc%3Dhttp%3A%2F%2Fqqpublic.qpic.cn%2Fqq_public%2F0%2F0-2215652282-11777CCC9C4A35E8002E7EB8A27111DB%2F0%3Ffmt%3Djpg%26size%3D135%26h%3D506%26w%3D900%26ppv%3D1.jpg%26refer%3Dhttp%3A%2F%2Fqqpublic.qpic.cn%26app%3D2002%26size%3Df9999%2C10000%26q%3Da80%26n%3D0%26g%3D0n%26fmt%3Djpeg%3Fsec%3D1642053506%26t%3Dd3d3bbe79c417dc605d24a51b338a935&fromurl=ippr_z2C%24qAzdH3FAzdH3Fh7wtkw5_z%26e3Bqq_z%26e3Bv54AzdH3FfAzdH3FdadaaddbAZOMIaaa%3F6juj6%3Dfrt1j6&gsm=1&rpstart=0&rpnum=0&islist=&querylist=&nojc=undefined");
//        contentShare.ShareToQQ("我是万年历", "大家好我是分享的内容", "https://blog.csdn.net/qq_37328546?spm=1019.2139.3001.5343", "https://image.baidu.com/search/detail?ct=503316480&z=0&ipn=false&word=%E5%A3%81%E7%BA%B8%20%E4%B8%8D%E5%90%8C%E9%A3%8E%E6%A0%BC%20%E5%94%AF%E7%BE%8E&step_word=&hs=0&pn=0&spn=0&di=32120&pi=0&rn=1&tn=baiduimagedetail&is=0%2C0&istype=2&ie=utf-8&oe=utf-8&in=&cl=2&lm=-1&st=-1&cs=3631594132%2C3972221223&os=1799234586%2C1945397593&simid=3631594132%2C3972221223&adpicid=0&lpn=0&ln=3814&fr=&fmq=1526269427171_R&fm=&ic=0&s=undefined&hd=undefined&latest=undefined&copyright=undefined&se=&sme=&tab=0&width=&height=&face=undefined&ist=&jit=&cg=wallpaper&bdtype=0&oriquery=&objurl=https%3A%2F%2Fgimg2.baidu.com%2Fimage_search%2Fsrc%3Dhttp%3A%2F%2Fqqpublic.qpic.cn%2Fqq_public%2F0%2F0-2215652282-11777CCC9C4A35E8002E7EB8A27111DB%2F0%3Ffmt%3Djpg%26size%3D135%26h%3D506%26w%3D900%26ppv%3D1.jpg%26refer%3Dhttp%3A%2F%2Fqqpublic.qpic.cn%26app%3D2002%26size%3Df9999%2C10000%26q%3Da80%26n%3D0%26g%3D0n%26fmt%3Djpeg%3Fsec%3D1642053506%26t%3Dd3d3bbe79c417dc605d24a51b338a935&fromurl=ippr_z2C%24qAzdH3FAzdH3Fh7wtkw5_z%26e3Bqq_z%26e3Bv54AzdH3FfAzdH3FdadaaddbAZOMIaaa%3F6juj6%3Dfrt1j6&gsm=1&rpstart=0&rpnum=0&islist=&querylist=&nojc=undefined");
        DialogManager.getInstance().showShareDialog(getActivity(), contentShare);


    }

}
