package com.juyou.calendar.fragment.calendar;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;

import com.baidu.mobads.sdk.api.CPUWebAdRequestParam;
import com.baidu.mobads.sdk.api.CpuAdView;
import com.baidu.mobads.sdk.api.CpuLpFontSize;
import com.haibin.calendarview.Calendar;
import com.haibin.calendarview.CalendarUtil;
import com.haibin.calendarview.CalendarView;
import com.juyou.calendar.R;
import com.juyou.calendar.base.MyExFragment;
import com.juyou.calendar.bean.LunarChangeDateBean;
import com.juyou.calendar.bo.CurrentBean;
import com.juyou.calendar.bo.JuYouBo;
import com.juyou.calendar.bo.NetResultCallBack;
import com.juyou.calendar.manage.GradationScrollView;
import com.juyou.calendar.util.ISharedPreference;
import com.juyou.calendar.util.SharedPreUtils;
import com.littlejie.circleprogress.CircleProgress;
import com.manggeek.android.geek.utils.JSONUtil;

import org.joda.time.LocalDate;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class CalendarFragment extends MyExFragment implements GradationScrollView.ScrollViewListener, CalendarView.OnCalendarSelectListener {


    @BindView(R.id.ll_title_left)
    LinearLayout llTitleLeft;
    @BindView(R.id.ll_calendar_fortune)
    LinearLayout llCalendarFortune;
    @BindView(R.id.view_actionBar_title)
    TextView viewActionBarTitle;
    @BindView(R.id.img_right)
    ImageView imgRight;
    @BindView(R.id.ll_right)
    LinearLayout llRight;
    @BindView(R.id.rl_pa)
    LinearLayout rlPa;
    @BindView(R.id.ll02)
    LinearLayout ll02;
    @BindView(R.id.channel)
    Spinner channel;
    @BindView(R.id.button)
    Button button;
    @BindView(R.id.parent_block)
    RelativeLayout parentBlock;
    @BindView(R.id.gs_scrollview)
    GradationScrollView gsScrollview;
    @BindView(R.id.tv_title_left)
    TextView tvTitleLeft;
    @BindView(R.id.go_back_calendar)
    TextView goBackCalendar;
    @BindView(R.id.circle_progress)
    CircleProgress circleProgress;
    @BindView(R.id.ll_center_title)
    LinearLayout llCenterTitle;
    @BindView(R.id.tv_date)
    TextView tvDate;
    @BindView(R.id.ll_date)
    LinearLayout llDate;
    @BindView(R.id.ll_test)
    LinearLayout llTest;
    @BindView(R.id.ll_01)
    LinearLayout ll01;
    @BindView(R.id.calendarView)
    CalendarView calendarView;
    @BindView(R.id.tv_lef_back)
    ImageView tvLefBack;
    @BindView(R.id.iv_title_right)
    ImageView ivTitleRight;
    @BindView(R.id.tv_calendar_today)
    TextView tvCalendarToday;
    @BindView(R.id.tv_calendar_lunar_year)
    TextView tvCalendarLunarYear;
    @BindView(R.id.tv_calendar_lunar_month)
    TextView tvCalendarLunarMonth;
    @BindView(R.id.tv_calendar_lunar_day)
    TextView tvCalendarLunarDay;
    @BindView(R.id.tv_calendar_lunar_week)
    TextView tvCalendarLunarWeek;
    @BindView(R.id.tv_yi_one)
    TextView tvYiOne;
    @BindView(R.id.tv_yi_two)
    TextView tvYiTwo;
    @BindView(R.id.tv_ji_one)
    TextView tvJiOne;
    @BindView(R.id.tv_ji_two)
    TextView tvJiTwo;
    @BindView(R.id.tv_calendar_lunar_jieri)
    TextView tvCalendarLunarJieri;
    @BindView(R.id.tv_calendar_lunar_jieri_holiday)
    TextView tvCalendarLunarJieriHoliday;
    @BindView(R.id.tv_calendar_lunar_after_jieri_date)
    TextView tvCalendarLunarAfterJieriDate;
    @BindView(R.id.tv_calendar_lunar_after_jieri_week)
    TextView tvCalendarLunarAfterJieriWeek;
    @BindView(R.id.tv_calendar_lunar_jieri_date)
    TextView tvCalendarLunarJieriDate;
    @BindView(R.id.tv_calendar_my_fortune)
    TextView tvCalendarMyFortune;
    @BindView(R.id.tv_calendar_zonghe)
    TextView tvCalendarZonghe;
    @BindView(R.id.tv_calendar_shiye)
    TextView tvCalendarShiye;
    @BindView(R.id.tv_calendar_caifu)
    TextView tvCalendarCaifu;
    @BindView(R.id.tv_calendar_ganqing)
    TextView tvCalendarGanqing;
    private int[] cDate = CalendarUtil.getCurrentDate();
    //???????????????????????????
    protected List<LocalDate> mHolidayList;
    protected List<LocalDate> mWorkdayList;

    /**
     * ??????????????????-??????????????????
     */
    private int height;


    //    ???????????????
    public static final String TAG = "CpuAdActivity";
    // ??????id
    private static String DEFAULT_APPSID = "c0da1ec4";
//    private static String DEFAULT_APPSID = "d756fa87";

    private CpuLpFontSize mDefaultCpuLpFontSize = CpuLpFontSize.REGULAR;
    private boolean isDarkMode = false;
    private CpuAdView mCpuView;

    @Override
    public int getLayoutId() {
        return R.layout.fragment_calendar;
    }

    @Override
    public void onScrollChanged(GradationScrollView scrollView, int x, int y, int oldx, int oldy) {
        if (y <= 0) {   //???????????????????????????
//            rlOut.setBackgroundColor(Color.argb((int) 0, 255, 0, 0));
            tvTitleLeft.setVisibility(View.VISIBLE);
            llRight.setVisibility(View.VISIBLE);
            llCenterTitle.setVisibility(View.VISIBLE);
            goBackCalendar.setVisibility(View.GONE);
            llDate.setVisibility(View.GONE);


            Log.e(TAG, "y <= 0");
        } else if (y > 0 && y <= height) { //??????????????????banner??????????????????????????????????????????????????????????????????
            //?????????????????????????????????????????????????????? = ??????????????? ??? ???????????????
            //??????????????? =  (???????????????/????????????)*255
            //(???????????????/????????????)
//            float scale = (float) y / height;
//            //?????????
//            float alpha = (scale * 255);

            tvTitleLeft.setVisibility(View.VISIBLE);
            llRight.setVisibility(View.VISIBLE);
            llCenterTitle.setVisibility(View.VISIBLE);
            goBackCalendar.setVisibility(View.GONE);
            llDate.setVisibility(View.GONE);
//            ll01.setBackgroundColor(Color.argb((int) alpha, 255, 0, 0));

            Log.e(TAG, "y <= height----" + height);
            Log.e(TAG, "y <=----" + y);
        } else {    //?????????banner????????????????????????
            //y>height
            //????????????0~255
//            rlOut.setVisibility(View.GONE);
            //y>height
            //????????????0~255

            tvTitleLeft.setVisibility(View.GONE);
            llRight.setVisibility(View.GONE);
            llCenterTitle.setVisibility(View.GONE);
            goBackCalendar.setVisibility(View.VISIBLE);
            llDate.setVisibility(View.VISIBLE);
            Log.e(TAG, "y --------height-----" + y);
//            ll02.setVisibility(View.GONE);
//            llGo.setVisibility(View.GONE);
//            gsScrollview.setVisibility(View.GONE);
//            ll01.setBackgroundColor(Color.argb((int) 0, 255,0,0));
//            ll01.setBackgroundColor(Color.argb((int) 255, 255,0,0));
//            gsScrollview.setBackgroundColor(Color.argb((int) 0, 255,0,0));
        }

    }

    @Override
    public void onCalendarOutOfRange(Calendar calendar) {
        Log.e(TAG, "calendar-----------" + calendar);
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onCalendarSelect(Calendar calendar, boolean isClick) {
        viewActionBarTitle.setText(calendar.getYear() + "???" + calendar.getMonth() + "???" + calendar.getDay() + "???");
        tvDate.setText(calendar.getYear() + "???" + calendar.getMonth() + "???" + calendar.getDay() + "???");
    }


    public enum CpuChannel {
        /**
         * ????????????
         */
        CHANNEL_ENTERTAINMENT(1001),
        /**
         * ????????????
         */
        CHANNEL_SPORT(1002),
        /**
         * ????????????
         */
        CHANNEL_PICTURE(1003),
        /**
         * ????????????
         */
        CHANNEL_MOBILE(1005),
        /**
         * ????????????
         */
        CHANNEL_FINANCE(1006),
        /**
         * ????????????
         */
        CHANNEL_AUTOMOTIVE(1007),
        /**
         * ????????????
         */
        CHANNEL_HOUSE(1008),
        /**
         * ????????????
         */

        CHANNEL_HOTSPOT(1021),

        /**
         * ????????????
         */
        CHANNEL_LOCAL(1080),

        /**
         * ????????????
         */
        CHANNEL_HOT(1090);

        private int value;

        CpuChannel(int value) {
            this.value = value;
        }

    }

    @Override
    protected void initView(View view, Bundle savedInstanceState) {
        ButterKnife.bind(this, view);
        init();
        initAD();
        initListeners();//?????????????????????
        initCalendar();

    }


    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
    }

    private void initCalendar() {
        mHolidayList = new ArrayList<>();
        mWorkdayList = new ArrayList<>();
        List<String> holidayList = CalendarUtil.getHolidayList();
        for (int i = 0; i < holidayList.size(); i++) {
            mHolidayList.add(new LocalDate(holidayList.get(i)));
        }
        List<String> workdayList = CalendarUtil.getWorkdayList();
        for (int i = 0; i < workdayList.size(); i++) {
            mWorkdayList.add(new LocalDate(workdayList.get(i)));
        }
        Map<String, Calendar> map = new HashMap<>();
        for (int i = 0; i < mHolidayList.size(); i++) {
            map.put(getSchemeCalendar(mHolidayList.get(i).toString().substring(0, 4), mHolidayList.get(i).toString().substring(5, 7), mHolidayList.get(i).toString().substring(8, 10), 0xFF40db25, "???").toString(),
                    getSchemeCalendar(mHolidayList.get(i).toString().substring(0, 4), mHolidayList.get(i).toString().substring(5, 7), mHolidayList.get(i).toString().substring(8, 10), 0xFF40db25, "???"));
            for (int j = 0; j < mWorkdayList.size(); j++) {
                map.put(getSchemeCalendar(mWorkdayList.get(j).toString().substring(0, 4), mWorkdayList.get(j).toString().substring(5, 7), mWorkdayList.get(j).toString().substring(8, 10), 0xFFFF1493, "???").toString(),
                        getSchemeCalendar(mWorkdayList.get(j).toString().substring(0, 4), mWorkdayList.get(j).toString().substring(5, 7), mWorkdayList.get(j).toString().substring(8, 10), 0xFFFF1493, "???"));
            }
        }
        calendarView.setSchemeDate(map);
    }


    private Calendar getSchemeCalendar(String year, String month, String day, int color, String text) {
        Calendar calendar = new Calendar();
        calendar.setYear(Integer.parseInt(year));
        calendar.setMonth(Integer.parseInt(month));
        calendar.setDay(Integer.parseInt(day));
        calendar.setSchemeColor(color);//???????????????????????????????????????????????????
        calendar.setScheme(text);
        calendar.addScheme(new Calendar.Scheme());
        calendar.addScheme(0xFF008800, "???");
        calendar.addScheme(0xFF008800, "???");
        return calendar;
    }


    private void initListeners() {
        ViewTreeObserver vto = calendarView.getViewTreeObserver();

        vto.addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
            @Override
            public void onGlobalLayout() {
                //????????????
                calendarView.getViewTreeObserver().removeGlobalOnLayoutListener(
                        this);

                //????????????????????????
                height = ll01.getHeight();
//                Log.e("llCalendOut", "llCalendOut-----???????????????-------------" + height);
                //??????ScrollView???????????????
                gsScrollview.setScrollViewListener(CalendarFragment.this);
            }
        });
    }

    private void initAD() {
        initSpinner();
        showSelectedCpuWebPage();

        button.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                showSelectedCpuWebPage();
            }
        });
    }


    private void init() {
        viewActionBarTitle.setText(calendarView.getCurYear() + "???" + calendarView.getCurMonth() + "???" + calendarView.getCurDay() + "???");
        circleProgress.setHint("76");//76
        circleProgress.setUnit("??????");//??????
        circleProgress.setValue(76);//??????????????????---????????????????????????v63
        tvDate.setText(cDate[0] + "???" + cDate[1] + "???" + cDate[2] + "???" + " ");

        calendarView.setOnCalendarSelectListener(this);

        initChangeLunar(cDate[0], cDate[1], cDate[2]);//????????????

    }

    @Override
    public void loadData() {
    }


    @OnClick({R.id.ll_test, R.id.view_actionBar_title, R.id.ll_calendar_fortune, R.id.ll_right, R.id.go_back_calendar})
    public void onViewClicked(View view) {
        switch (view.getId()) {

            case R.id.view_actionBar_title:
                chooseTime(viewActionBarTitle);
                break;
            case R.id.ll_test:

                break;
            case R.id.ll_calendar_fortune:
                Toast.makeText(getActivity(), "????????????", Toast.LENGTH_SHORT).show();
                break;
            case R.id.ll_right:
                Toast.makeText(getActivity(), "??????", Toast.LENGTH_SHORT).show();
//                WebUtils.loadTitleWeb(getActivity(), "https://www.77tianqi.com/h5/rules.html?hideCloseBtn=1", "dfsg");
                break;
//            case R.id.ll_calendar_to_weather:
//                startActivity(new Intent(getActivity(), WeatherActivity.class));
//                Toast.makeText(getActivity(), "????????????", Toast.LENGTH_SHORT).show();
//                break;
            case R.id.go_back_calendar:
                calendarView.scrollToCalendar(cDate[0], cDate[1], cDate[2]);

                viewActionBarTitle.setText(cDate[0] + "." + cDate[1] + "." + cDate[2]);
                gsScrollview.post(new Runnable() {
                    @Override
                    public void run() {
                        gsScrollview.post(new Runnable() {
                            @Override
                            public void run() {
//                                ll01.setVisibility(View.VISIBLE);
//                                gsScrollview.setVisibility(View.VISIBLE);
                                gsScrollview.fullScroll(ScrollView.FOCUS_UP);
                            }
                        });
                    }
                });
                break;
        }
    }

    private String getTime(Date date) {//???????????????????????????????????????
        SimpleDateFormat format = (SimpleDateFormat) SimpleDateFormat.getDateInstance();
        format.applyPattern("yyyy-MM-dd");
        return format.format(date);
    }

    /**
     * ????????????
     */
    private void chooseTime(TextView timeView) {
        //???????????????
        mTimePickerView pTime = new mTimePickerBuilder(getActivity(), (date, v) -> {
            timeView.setText(getTime(date));

            int yead = Integer.parseInt(getNeedTime(date).substring(0, 4));
            int month = Integer.parseInt(getNeedTime(date).substring(4, 6));
            int day = Integer.parseInt(getNeedTime(date).substring(6, 8));
            calendarView.scrollToCalendar(yead, month, day);//?????????????????????
            initChangeLunar(yead, month, day);//????????????
        })
                .setType(new boolean[]{true, true, true, false, false, false})// ?????????????????????????????????????????????????????????????????????????????????????????????new boolean[]{true, true, true, false, false, false}
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
                dialogWindow.setWindowAnimations(com.bigkoo.pickerview.R.style.picker_view_slide_anim);//??????????????????
                dialogWindow.setGravity(Gravity.BOTTOM);//??????Bottom,????????????
            }
            mDialog.show();
        }
    }

    private String getNeedTime(Date date) {//???????????????????????????????????????
        SimpleDateFormat format = (SimpleDateFormat) SimpleDateFormat.getDateInstance();
        format.applyPattern("yyyyMMdd");
        return format.format(date);
    }

    private void initChangeLunar(int yead, int month, int day) {
        JuYouBo.LunarToNongLi(getActivity(), yead, month, day, new NetResultCallBack() {
            @Override
            public void onSuccess(int what, CurrentBean currentBean) {

                LunarChangeDateBean lunarChangeDateBean = JSONUtil.getObj(String.valueOf(currentBean.getData()), LunarChangeDateBean.class);
                tvCalendarToday.setText(lunarChangeDateBean.getNl_yue() + lunarChangeDateBean.getNl_ri());
                tvCalendarLunarYear.setText(lunarChangeDateBean.getGz_nian() + lunarChangeDateBean.getShengxiao() + "???");
                tvCalendarLunarMonth.setText(lunarChangeDateBean.getGz_yue() + "???");
                tvCalendarLunarDay.setText(lunarChangeDateBean.getGz_ri() + "???");
                tvCalendarLunarWeek.setText(lunarChangeDateBean.getWeek_3());
                tvYiOne.setText(lunarChangeDateBean.getYi().get(0));
                tvYiTwo.setText(lunarChangeDateBean.getYi().get(1));
                tvJiOne.setText(lunarChangeDateBean.getJi().get(0));
                tvJiTwo.setText(lunarChangeDateBean.getJi().get(1));


            }

            @Override
            public void onFail(int what, CurrentBean currentBean) {

            }
        });
    }

    /**
     * ???????????????????????????????????????
     */
    private void showSelectedCpuWebPage() {
        /**
         *  ????????????????????????setCustomUserId ???????????????
         *  ?????????outerId??????????????????????????????????????????????????????
         *  outerId?????????????????? ????????????????????????16??? ???????????????
         */

        /**
         *  ?????????outerId???????????????
         */

        SharedPreUtils sharedPreUtils = SharedPreUtils.getInstance();
        String outerId = sharedPreUtils.getString(SharedPreUtils.OUTER_ID);
        if (TextUtils.isEmpty(outerId)) {
            outerId = UUID.randomUUID().toString()
                    .replace("-", "")
                    .substring(0, 16);
            sharedPreUtils.putString(SharedPreUtils.OUTER_ID, outerId);
        }

        CPUWebAdRequestParam cpuWebAdRequestParam = new CPUWebAdRequestParam.Builder()
                .setLpFontSize(mDefaultCpuLpFontSize)
                .setLpDarkMode(isDarkMode)
                .setCityIfLocalChannel("??????")
                .setCustomUserId(outerId)
                .build();

        mCpuView = new CpuAdView(getActivity(), getAppsid(), 1003, cpuWebAdRequestParam,
                new CpuAdView.CpuAdViewInternalStatusListener() {
                    @Override
                    public void loadDataError(String message) {
                        Log.e(TAG, "loadDataError: " + message);
                    }

                    @Override
                    public void onAdClick() {
                        Log.e(TAG, "onAdClick: ");
                    }

                    @Override
                    public void onAdImpression(String impressionAdNums) {
                        Log.e(TAG, "onAdImpression: impressionAdNums " + impressionAdNums);
                    }

                    @Override
                    public void onContentClick() {
                        Log.e(TAG, "onContentClick: ");
                    }

                    @Override
                    public void onContentImpression(String impressionContentNums) {

                        Log.e(TAG, "onContentImpression: impressionContentNums = " + impressionContentNums);
                    }
                });

        // ?????????????????? ???????????????????????? ???????????????????????????SDK???????????????????????????
        // ????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????
        mCpuView.requestData();

        RelativeLayout.LayoutParams reLayoutParams = new RelativeLayout.LayoutParams(
                RelativeLayout.LayoutParams.WRAP_CONTENT, RelativeLayout.LayoutParams.WRAP_CONTENT);
        reLayoutParams.addRule(RelativeLayout.CENTER_IN_PARENT);
        parentBlock.addView(mCpuView, reLayoutParams);
    }


    /**
     * ??????????????????
     */
    private void initSpinner() {
        channel.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }

        });
        List<SpinnerItem> list = new ArrayList<SpinnerItem>();
        list.add(new SpinnerItem("????????????", CpuChannel.CHANNEL_ENTERTAINMENT));
        list.add(new SpinnerItem("????????????", CpuChannel.CHANNEL_SPORT));
        list.add(new SpinnerItem("????????????", CpuChannel.CHANNEL_PICTURE));
        list.add(new SpinnerItem("????????????", CpuChannel.CHANNEL_MOBILE));
        list.add(new SpinnerItem("????????????", CpuChannel.CHANNEL_FINANCE));
        list.add(new SpinnerItem("????????????", CpuChannel.CHANNEL_AUTOMOTIVE));
        list.add(new SpinnerItem("????????????", CpuChannel.CHANNEL_HOUSE));
        list.add(new SpinnerItem("????????????", CpuChannel.CHANNEL_HOTSPOT));
        list.add(new SpinnerItem("????????????", CpuChannel.CHANNEL_LOCAL));
        list.add(new SpinnerItem("??????", CpuChannel.CHANNEL_HOT));
        ArrayAdapter<SpinnerItem> dataAdapter = new ArrayAdapter<SpinnerItem>(getActivity(),
                android.R.layout.simple_spinner_item, list);
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        channel.setAdapter(dataAdapter);

    }


    @Override
    public void onResume() {
        super.onResume();
        if (mCpuView != null) {
            mCpuView.onResume();
        }
        //???????????????
        if (ISharedPreference.getInstance(getActivity().getApplication()).getWeekMonNotice()) {
//            ???????????????
            calendarView.setWeekStarWithMon();
        } else {
            calendarView.setWeekStarWithSun();
        }

    }

    @Override
    public void onPause() {
        super.onPause();
        if (mCpuView != null) {
            mCpuView.onPause();
        }

    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        if (mCpuView != null) {
            mCpuView.onDestroy();
        }
    }

    /**
     * ??????appsid
     *
     * @return
     */
    private String getAppsid() {
        return DEFAULT_APPSID;
    }


    class SpinnerItem extends Object {
        /**
         * ????????????
         */
        String text;
        /**
         * ??????id
         */
        CpuChannel channel;

        public SpinnerItem(String text, CpuChannel cpuChannel) {
            this.text = text;
            this.channel = cpuChannel;
        }

        @Override
        public String toString() {
            return text;
        }

    }
}
