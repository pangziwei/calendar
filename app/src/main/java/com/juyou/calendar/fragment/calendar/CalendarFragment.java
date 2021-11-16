package com.juyou.calendar.fragment.calendar;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.content.res.AssetManager;
import android.location.Geocoder;
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
import android.widget.Toolbar;

import com.baidu.mobads.sdk.api.CPUWebAdRequestParam;
import com.baidu.mobads.sdk.api.CpuAdView;
import com.baidu.mobads.sdk.api.CpuLpFontSize;
import com.google.gson.Gson;
import com.juyou.calendar.R;
import com.juyou.calendar.base.MyExFragment;
import com.juyou.calendar.bean.weather.WeatherV61Bean;
import com.juyou.calendar.bo.Api;
import com.juyou.calendar.constant.WeatherContentUtil;
import com.juyou.calendar.dialog.AddressDialog;
import com.juyou.calendar.weather.WeatherActivity;
import com.juyou.calendar.manage.GradationScrollView;
import com.juyou.calendar.util.IconUtils;
import com.juyou.calendar.util.SharedPreUtils;
import com.juyou.calendar.util.WebUtils;
import com.littlejie.circleprogress.CircleProgress;
import com.littlejie.circleprogress.utils.Constant;
import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;
import com.loopj.android.http.RequestParams;
import com.manggeek.android.geek.GeekActivity;
import com.manggeek.android.geek.cache.StringCache;
import com.manggeek.android.geek.utils.JSONUtil;
import com.manggeek.android.geek.utils.PrintUtil;
import com.othershe.calendarview.bean.DateBean;
import com.othershe.calendarview.listener.OnPagerChangeListener;
import com.othershe.calendarview.listener.OnSingleChooseListener;
import com.othershe.calendarview.utils.CalendarUtil;
import com.othershe.calendarview.weiget.CalendarView;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import interfaces.heweather.com.interfacesmodule.bean.geo.GeoBean;

public class CalendarFragment extends MyExFragment implements GradationScrollView.ScrollViewListener {


    @BindView(R.id.ll_title_left)
    LinearLayout llTitleLeft;
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
    @BindView(R.id.calendar)
    CalendarView calendar;
    @BindView(R.id.ll_calendar_out)
    LinearLayout llCalendarOut;
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
    @BindView(R.id.test_textview)
    TextView test_textview;
    @BindView(R.id.ll_date)
    LinearLayout llDate;
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
    public void onScrollChanged(GradationScrollView scrollView, int x, int y, int oldx, int oldy) {
        if (y <= 0) {   //设置标题的背景颜色
//            rlOut.setBackgroundColor(Color.argb((int) 0, 255, 0, 0));
            tvTitleLeft.setVisibility(View.VISIBLE);
            llRight.setVisibility(View.VISIBLE);
            llCenterTitle.setVisibility(View.VISIBLE);
            goBackCalendar.setVisibility(View.GONE);
            llDate.setVisibility(View.GONE);
            Log.e("llCalendOut", "height-----at fags gbas dfv asaest va--设置标题的背景颜色-----");
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
            Log.e("llCalendOut", "height-----at fags gbas dfv asaest va-------");
//            calendar.setBackgroundColor(Color.argb((int) alpha, 255, 0, 0));
        } else {    //滑动到banner下面设置普通颜色
            //y>height
            //透明度：0~255
//            rlOut.setVisibility(View.GONE);
            Log.e("llCalendOut", "height------------");
            //y>height
            //透明度：0~255
            Log.e("llCalendOut", "height-----at fags gbas dfv asaest va-------");
//            calendar.setBackgroundColor(Color.argb((int) alpha, 255, 0, 0));
//            rlOut.setBackgroundColor(Color.argb((int) 255, 255, 0, 0));
            tvTitleLeft.setVisibility(View.GONE);
            llRight.setVisibility(View.GONE);
            llCenterTitle.setVisibility(View.GONE);
            goBackCalendar.setVisibility(View.VISIBLE);
            llDate.setVisibility(View.VISIBLE);
        }

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

        initCalendar();

        initAD();

//        initNowDay();//天气的初始化

        initListeners();//渐变的高度监听

        addressDialog = new AddressDialog((GeekActivity) getActivity());
        addressDialog.setSelectAreaListener(selectAreaListener);//地址的弹框




    }

    private void initListeners() {
        ViewTreeObserver vto = llCalendarOut.getViewTreeObserver();

        vto.addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
            @Override
            public void onGlobalLayout() {
                //移除监听
                llCalendarOut.getViewTreeObserver().removeGlobalOnLayoutListener(
                        this);

                //得到相对布局的高
                height = llCalendarOut.getHeight();
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

    private void initCalendar() {
        calendar
                .setInitDate(cDate[0] + "." + cDate[1])//设置日历初始显示的年月
                .setSingleDate(cDate[0] + "." + cDate[1] + "." + cDate[2])//设置单选时默认选中的日期
                .init();

        viewActionBarTitle.setText(cDate[0] + "." + cDate[1] + "." + cDate[2]);

//        viewActionBarTitle.setText( year.getText() + "年" + month.getText() + "月" + day.getText() + "日");
        calendar.setOnPagerChangeListener(new OnPagerChangeListener() {
            @Override
            public void onPagerChanged(int[] date) {
                viewActionBarTitle.setText(date[0] + "." + date[1] + "." + date[2]);
            }
        });

        calendar.setOnSingleChooseListener(new OnSingleChooseListener() {
            @Override
            public void onSingleChoose(View view, DateBean date) {
                viewActionBarTitle.setText(date.getSolar()[0] + "." + date.getSolar()[1] + "." + date.getSolar()[2]);
                if (date.getType() == 1) {

                }
            }
        });


    }


    private void init() {
        viewActionBarTitle.setText(cDate[0] + "." + cDate[1] + "." + cDate[2]);
        circleProgress.setHint("76");//76
        circleProgress.setUnit("平淡");//平淡
        circleProgress.setValue(76);//这个是进度数---专业实况天气接口v63
        tvDate.setText(cDate[0] + "年" + cDate[1] + "月" + cDate[2] + "日" + " ");
    }

    @Override
    public void loadData() {
    }

    @Override
    public int getLayoutId() {
        return R.layout.fragment_calendar;
    }

    @OnClick({R.id.view_actionBar_title, R.id.tv_title_left, R.id.ll_right,  R.id.go_back_calendar})
    public void onViewClicked(View view) {
        switch (view.getId()) {

            case R.id.view_actionBar_title:
                chooseTime(viewActionBarTitle);
                break;
            case R.id.tv_title_left:
                Toast.makeText(getActivity(), "今日运势", Toast.LENGTH_SHORT).show();
                break;
            case R.id.ll_right:
                Toast.makeText(getActivity(), "天气", Toast.LENGTH_SHORT).show();
//                WebUtils.loadTitleWeb(getActivity(), "https://www.77tianqi.com/h5/rules.html?hideCloseBtn=1", "dfsg");
                addressDialog.show();
                break;
//            case R.id.ll_calendar_to_weather:
//                startActivity(new Intent(getActivity(), WeatherActivity.class));
//                Toast.makeText(getActivity(), "今日天气", Toast.LENGTH_SHORT).show();
//                break;
            case R.id.go_back_calendar:
//                Toast.makeText(getActivity(), "返回日历", Toast.LENGTH_SHORT).show();---gsScrollview

                calendar.today();
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


            boolean result = calendar.toSpecifyDate(Integer.valueOf(getTime(date).substring(0, 4)),
                    Integer.valueOf(getTime(date).substring(5, 7)),
                    Integer.valueOf(getTime(date).substring(8, 10)));
            if (!result) {
                Toast.makeText(getActivity(), "日期越界！", Toast.LENGTH_SHORT).show();
            } else {
            }
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
//
//    private void jubTime(String date) {
//
//        Log.e("TAG", "getTime(date)-------------------"+getTime(date));
//        boolean result = calendar.toSpecifyDate(Integer.valueOf(year.getText().toString()),
//                Integer.valueOf(month.getText().toString()),
//                Integer.valueOf(day.getText().toString()));
//        if (!result) {
//            Toast.makeText(getActivity(), "日期越界！", Toast.LENGTH_SHORT).show();
//        } else {
//            chooseDate.setText("当前选中的日期：" + year.getText() + "年" + month.getText() + "月" + day.getText() + "日");
//        }
//    }


    //以下是广告的


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

    AddressDialog addressDialog;

    //省份
    private String provinceName = "";
    private String provinceCode = "";
    //市
    private String cityName = "";
    //区
    private String areaName = "";
    private AddressDialog.SelectAreaListener selectAreaListener = new AddressDialog.SelectAreaListener() {
        @Override
        public void select(String province, String city, String area) {
            provinceName = province;
            cityName = city;
            areaName = area;
            test_textview.setText(areaName);

        }
    };
}
