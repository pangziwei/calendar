package com.juyou.calendar.fragment.calendar;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.graphics.Paint;
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

import com.baidu.mobads.sdk.api.CPUWebAdRequestParam;
import com.baidu.mobads.sdk.api.CpuAdView;
import com.baidu.mobads.sdk.api.CpuLpFontSize;
import com.google.gson.Gson;
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

public class CalendarFragment extends MyExFragment implements
        GradationScrollView.ScrollViewListener,
        CalendarView.OnCalendarSelectListener {


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


    /**
     * 滑动最大区域-相对布局的高
     */
    private int height;


    //    广告的代码
    public static final String TAG = "CpuAdActivity";
    // 测试id
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
        if (y <= 0) {   //设置标题的背景颜色
//            rlOut.setBackgroundColor(Color.argb((int) 0, 255, 0, 0));
            tvTitleLeft.setVisibility(View.VISIBLE);
            llRight.setVisibility(View.VISIBLE);
            llCenterTitle.setVisibility(View.VISIBLE);
            goBackCalendar.setVisibility(View.GONE);
            llDate.setVisibility(View.GONE);
        } else if (y > 0 && y <= height) { //滑动距离小于banner图的高度时，设置背景和字体颜色颜色透明度渐变
            //滑动的距离：最大距离（相对布局高度） = 透明的改变 ： 最大透明度
            //透明的改变 =  (滑动的距离/最大距离)*255
            //(滑动的距离/最大距离)
            float scale = (float) y / height;
            //透明度
            float alpha = (scale * 255);

            tvTitleLeft.setVisibility(View.VISIBLE);
            llRight.setVisibility(View.VISIBLE);
            llCenterTitle.setVisibility(View.VISIBLE);
            goBackCalendar.setVisibility(View.GONE);
            llDate.setVisibility(View.GONE);
//            calendar.setBackgroundColor(Color.argb((int) alpha, 255, 0, 0));
        } else {    //滑动到banner下面设置普通颜色
            //y>height
            //透明度：0~255
//            rlOut.setVisibility(View.GONE);
            //y>height
            //透明度：0~255
//            calendar.setBackgroundColor(Color.argb((int) alpha, 255, 0, 0));
//            rlOut.setBackgroundColor(Color.argb((int) 255, 255, 0, 0));
            tvTitleLeft.setVisibility(View.GONE);
            llRight.setVisibility(View.GONE);
            llCenterTitle.setVisibility(View.GONE);
            goBackCalendar.setVisibility(View.VISIBLE);
            llDate.setVisibility(View.VISIBLE);
        }

    }

    @Override
    public void onCalendarOutOfRange(Calendar calendar) {

    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onCalendarSelect(Calendar calendar, boolean isClick) {
        viewActionBarTitle.setText(calendar.getYear() + "年" + calendar.getMonth() + "月" + calendar.getDay() + "日");
        tvDate.setText(calendar.getYear() + "年" + calendar.getMonth() + "月" + calendar.getDay() + "日");
    }


    public enum CpuChannel {
        /**
         * 娱乐频道
         */
        CHANNEL_ENTERTAINMENT(1001),
        /**
         * 体育频道
         */
        CHANNEL_SPORT(1002),
        /**
         * 图片频道
         */
        CHANNEL_PICTURE(1003),
        /**
         * 手机频道
         */
        CHANNEL_MOBILE(1005),
        /**
         * 财经频道
         */
        CHANNEL_FINANCE(1006),
        /**
         * 汽车频道
         */
        CHANNEL_AUTOMOTIVE(1007),
        /**
         * 房产频道
         */
        CHANNEL_HOUSE(1008),
        /**
         * 热点频道
         */

        CHANNEL_HOTSPOT(1021),

        /**
         * 本地频道
         */
        CHANNEL_LOCAL(1080),

        /**
         * 热榜频道
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

//        initNowDay();//天气的初始化

        initListeners();//渐变的高度监听


        initCalendar();
    }

    protected List<LocalDate> mHolidayList;
    protected List<LocalDate> mWorkdayList;


    private Paint getPaint() {
        Paint paint = new Paint();
        paint.setAntiAlias(true);
        paint.setTextAlign(Paint.Align.CENTER);
        return paint;
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
            map.put(getSchemeCalendar(mHolidayList.get(i).toString().substring(0, 4), mHolidayList.get(i).toString().substring(5, 7), mHolidayList.get(i).toString().substring(8, 10), 0xFF40db25, "假").toString(),
                    getSchemeCalendar(mHolidayList.get(i).toString().substring(0, 4), mHolidayList.get(i).toString().substring(5, 7), mHolidayList.get(i).toString().substring(8, 10), 0xFF40db25, "假"));
            for (int j = 0; j < mWorkdayList.size(); j++) {
                map.put(getSchemeCalendar(mWorkdayList.get(j).toString().substring(0, 4), mWorkdayList.get(j).toString().substring(5, 7), mWorkdayList.get(j).toString().substring(8, 10), 0xFFFF1493, "班").toString(),
                        getSchemeCalendar(mWorkdayList.get(j).toString().substring(0, 4), mWorkdayList.get(j).toString().substring(5, 7), mWorkdayList.get(j).toString().substring(8, 10), 0xFFFF1493, "班"));
            }
        }
        calendarView.setSchemeDate(map);
    }


    private Calendar getSchemeCalendar(String year, String month, String day, int color, String text) {
        Calendar calendar = new Calendar();
        calendar.setYear(Integer.parseInt(year));
        calendar.setMonth(Integer.parseInt(month));
        calendar.setDay(Integer.parseInt(day));
        calendar.setSchemeColor(color);//如果单独标记颜色、则会使用这个颜色
        calendar.setScheme(text);
        calendar.addScheme(new Calendar.Scheme());
        calendar.addScheme(0xFF008800, "假");
        calendar.addScheme(0xFF008800, "节");
        return calendar;
    }


    private void initListeners() {
        ViewTreeObserver vto = calendarView.getViewTreeObserver();

        vto.addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
            @Override
            public void onGlobalLayout() {
                //移除监听
                calendarView.getViewTreeObserver().removeGlobalOnLayoutListener(
                        this);

                //得到相对布局的高
                height = calendarView.getHeight();
//                Log.e("llCalendOut", "llCalendOut-----该方法付付-------------" + height);
                //设置ScrollView的滑动监听
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
        viewActionBarTitle.setText(calendarView.getCurYear() + "年" + calendarView.getCurMonth() + "月" + calendarView.getCurDay() + "日");
        circleProgress.setHint("76");//76
        circleProgress.setUnit("平淡");//平淡
        circleProgress.setValue(76);//这个是进度数---专业实况天气接口v63
        tvDate.setText(cDate[0] + "年" + cDate[1] + "月" + cDate[2] + "日" + " ");

//        calendarView.setOnYearChangeListener(this);
        calendarView.setOnCalendarSelectListener(this);
//        calendarView.setOnMonthChangeListener(this);
//        calendarView.setOnCalendarLongClickListener(this, true);
//        calendarView.setOnWeekChangeListener(this);
//        calendarView.setOnYearViewChangeListener(this);

//        //设置日期拦截事件，仅适用单选模式，当前无效
//        calendarView.setOnCalendarInterceptListener(this);
//
//        calendarView.setOnViewChangeListener(this);


        initChangeLunar(cDate[0], cDate[1], cDate[2]);//农历日期

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
                calendarView.setWeekStarWithMon();

                break;
            case R.id.ll_calendar_fortune:
                Toast.makeText(getActivity(), "今日运势", Toast.LENGTH_SHORT).show();
                calendarView.setWeekStarWithSun();
                break;
            case R.id.ll_right:
                Toast.makeText(getActivity(), "天气", Toast.LENGTH_SHORT).show();
//                WebUtils.loadTitleWeb(getActivity(), "https://www.77tianqi.com/h5/rules.html?hideCloseBtn=1", "dfsg");
                break;
//            case R.id.ll_calendar_to_weather:
//                startActivity(new Intent(getActivity(), WeatherActivity.class));
//                Toast.makeText(getActivity(), "今日天气", Toast.LENGTH_SHORT).show();
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
                                gsScrollview.fullScroll(ScrollView.FOCUS_UP);
                            }
                        });
                    }
                });
                break;
        }
    }

    private String getTime(Date date) {//可根据需要自行截取数据显示
        SimpleDateFormat format = (SimpleDateFormat) SimpleDateFormat.getDateInstance();
        format.applyPattern("yyyy-MM-dd");
        return format.format(date);
    }

    /**
     * 选择时间
     */
    private void chooseTime(TextView timeView) {
        //时间选择器
        mTimePickerView pTime = new mTimePickerBuilder(getActivity(), (date, v) -> {
            timeView.setText(getTime(date));

            int yead = Integer.parseInt(getNeedTime(date).substring(0, 4));
            int month = Integer.parseInt(getNeedTime(date).substring(4, 6));
            int day = Integer.parseInt(getNeedTime(date).substring(6, 8));
            calendarView.scrollToCalendar(yead, month, day);//跳转到选中日期
            initChangeLunar(yead, month, day);//农历日期
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

    private String getNeedTime(Date date) {//可根据需要自行截取数据显示
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
                tvCalendarLunarYear.setText(lunarChangeDateBean.getGz_nian() + lunarChangeDateBean.getShengxiao() + "年");
                tvCalendarLunarMonth.setText(lunarChangeDateBean.getGz_yue() + "月");
                tvCalendarLunarDay.setText(lunarChangeDateBean.getGz_ri() + "日");
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
     * 内容联盟模板渲染，展示频道
     */
    private void showSelectedCpuWebPage() {


        /**
         *  注意构建参数时，setCustomUserId 为必选项，
         *  传入的outerId是为了更好的保证能够获取到广告和内容
         *  outerId的格式要求： 包含数字与字母的16位 任意字符串
         */

        /**
         *  推荐的outerId获取方式：
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
                .setCityIfLocalChannel("杭州")
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

        // 考虑到媒体在 锁屏开关等场景下 有刷新页面的需求，SDK目前将控件的创建与
        // 数据的请求进行拆分，媒体在已创建控件的前提下，可以直接调用下面这行代码来请求或着更新数据
        mCpuView.requestData();

        RelativeLayout.LayoutParams reLayoutParams = new RelativeLayout.LayoutParams(
                RelativeLayout.LayoutParams.WRAP_CONTENT, RelativeLayout.LayoutParams.WRAP_CONTENT);
        reLayoutParams.addRule(RelativeLayout.CENTER_IN_PARENT);
        parentBlock.addView(mCpuView, reLayoutParams);
    }


    /**
     * 初始化下拉框
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
        list.add(new SpinnerItem("娱乐频道", CpuChannel.CHANNEL_ENTERTAINMENT));
        list.add(new SpinnerItem("体育频道", CpuChannel.CHANNEL_SPORT));
        list.add(new SpinnerItem("图片频道", CpuChannel.CHANNEL_PICTURE));
        list.add(new SpinnerItem("手机频道", CpuChannel.CHANNEL_MOBILE));
        list.add(new SpinnerItem("财经频道", CpuChannel.CHANNEL_FINANCE));
        list.add(new SpinnerItem("汽车频道", CpuChannel.CHANNEL_AUTOMOTIVE));
        list.add(new SpinnerItem("房产频道", CpuChannel.CHANNEL_HOUSE));
        list.add(new SpinnerItem("热点频道", CpuChannel.CHANNEL_HOTSPOT));
        list.add(new SpinnerItem("本地频道", CpuChannel.CHANNEL_LOCAL));
        list.add(new SpinnerItem("热榜", CpuChannel.CHANNEL_HOT));
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
     * 获取appsid
     *
     * @return
     */
    private String getAppsid() {
        return DEFAULT_APPSID;
    }


    class SpinnerItem extends Object {
        /**
         * 频道名称
         */
        String text;
        /**
         * 频道id
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
