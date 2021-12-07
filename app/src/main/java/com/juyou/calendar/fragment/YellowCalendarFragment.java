package com.juyou.calendar.fragment;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.haibin.calendarview.CalendarUtil;
import com.juyou.calendar.R;
import com.juyou.calendar.base.MyExFragment;

import java.util.Calendar;

import butterknife.BindView;
import butterknife.ButterKnife;

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
    private int[] cDate = CalendarUtil.getCurrentDate();

    @Override
    protected void initView(View view, Bundle savedInstanceState) {
        ButterKnife.bind(this, view);
        init();
    }

    private void init() {
        viewActionBarTitle.setText(cDate[0] + "年" + cDate[1] + "月" + cDate[2] + "日" + " ");
        llRight.setVisibility(View.VISIBLE);
        ll_title_left.setVisibility(View.INVISIBLE);
        Glide.with(getActivity()).load(R.mipmap.share).into(imgRight);
        CalendarUtil.getDateBean(cDate[0], +cDate[1], cDate[2]);

//        Log.e(TAG, "-----ccccc-" + new Gson().toJson(LunarUtil.solarToLunar(2021, 6, 10)).substring(2,4));
//        Log.e(TAG, "------ccccc" + new Gson().toJson(LunarUtil.solarToLunar(2021, 6, 10)).substring(7,9));
//        Log.e(TAG, "------" + new Gson().toJson(LunarUtil.solarToLunar(cDate[0], +cDate[1], cDate[2])).substring(2,4));
//        Log.e(TAG, "------" + new Gson().toJson(LunarUtil.solarToLunar(cDate[0], +cDate[1], cDate[2])).substring(7,9));
//        Log.e(TAG, "---获取某一年对应天干文字---" + TrunkBranchAnnals.getTrunkString(cDate[0]));
//        Log.e(TAG, "---获取某一年对应天干---" + TrunkBranchAnnals.getTrunkInt(cDate[0]));
//        Log.e(TAG, "---获取某一年对应地支文字---" + TrunkBranchAnnals.getBranchString(cDate[0]));
//        Log.e(TAG, "---获取某一年对应地支---" + TrunkBranchAnnals.getBranchInt(cDate[0]));
//        Log.e(TAG, "---干支纪年---" + TrunkBranchAnnals.getTrunkBranchYear(cDate[0]));
//        Log.e(TAG, "---干支纪年---" + new Gson().toJson(MyDate.initGanZhi(cDate[0], +cDate[1], cDate[2])));
//        Log.e(TAG, "---干支纪年---" + getGanZhi());
//        Log.e(TAG, "---干支纪年-9999--" + initGanZhi(cDate[0], +cDate[1], cDate[2]));

//        MyDate m = new MyDate();
//        m.initGanZhi(cDate[0], +cDate[1], cDate[2]);
//        String s = m.initGanZhi(cDate[0], +cDate[1], cDate[2]);
//        Log.e("TAG", "-------" + m.initGanZhi(cDate[0], +cDate[1], cDate[2]));


    }


    @Override
    public void loadData() {
        Log.e("TAG", "sdufgsjadfg-----------");
    }

    @Override
    public int getLayoutId() {
        return R.layout.fragment_yellow_calendar;
    }


    @Override
    public void onDestroy() {
        super.onDestroy();

    }


}
