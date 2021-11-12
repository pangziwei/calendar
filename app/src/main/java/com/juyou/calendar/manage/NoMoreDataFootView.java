package com.juyou.calendar.manage;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.juyou.calendar.R;

import androidx.annotation.Nullable;


/**
 * @desc 上拉加载更多  当无更多数据，没有数据时显示的footview
 */

public class NoMoreDataFootView extends LinearLayout {
    Context context;
    TextView tv_foot;
    ImageView iv_empty;
    ViewGroup rlParent;
    public final static int FOOT_NO_MORE = 1;   //显示底部footview 显示文案为 已经到底了
    public final static int FOOT_NO_DATA = 2;    //无数据
    public final static int FOOT_HIDE = 3;    //隐藏
    public final static int FOOT_LOAD_ERROR = 4;     //加载出错
    DefaultBtnStyleView btn_go;

    public NoMoreDataFootView(Context context) {
        super(context);
        initView(context);
    }

    public NoMoreDataFootView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        this.context = context;
        initView(context);
    }

    private void initView(Context context) {
        this.context = context;
        LayoutInflater.from(getContext()).inflate(R.layout.footview_nomore_data, this, true);
        tv_foot = findViewById(R.id.tv_foot);
        iv_empty = findViewById(R.id.iv_empty);
        rlParent = findViewById(R.id.rl_parent);
        btn_go = findViewById(R.id.btn_go);
    }

    public int getFootViewState() {
        return state;
    }

    int state;

    public void setFootViewState(int state) {
        this.state = state;
        switch (state) {
            case FOOT_NO_MORE:
                tv_foot.setVisibility(VISIBLE);
                tv_foot.setText(R.string.no_more_data);
                iv_empty.setVisibility(GONE);
                break;
            case FOOT_HIDE:
                tv_foot.setVisibility(GONE);
                iv_empty.setVisibility(GONE);
                break;
            case FOOT_NO_DATA:
                tv_foot.setVisibility(VISIBLE);
                iv_empty.setVisibility(VISIBLE);
                tv_foot.setText(R.string.no_data);
                break;
            case FOOT_LOAD_ERROR:
                tv_foot.setVisibility(VISIBLE);
                iv_empty.setVisibility(VISIBLE);
                tv_foot.setText(R.string.load_fail);
                break;
        }
    }

    public void setEmptyImage(int drawbleId) {
        iv_empty.setImageResource(drawbleId);
    }

    /**
     * @desc 设置没有内容时显示的文案
     */
    public void setFootText(String text) {
        tv_foot.setText(text);
    }


    public void setBtnClickListener(String text, OnClickListener clickListener) {
        if (getFootViewState() == FOOT_NO_DATA){
            btn_go.setVisibility(VISIBLE);
            btn_go.setText(text);
            btn_go.setOnClickListener(clickListener);
        }else {
            btn_go.setVisibility(GONE);
        }
    }

    //设置背景颜色
    public void setCustomBackGroudnColor(int colorId) {
        rlParent.setBackgroundColor(getResources().getColor(colorId));
    }

    public void setCustomBackGround(int drawbleId) {
        rlParent.setBackgroundResource(drawbleId);
    }
}
