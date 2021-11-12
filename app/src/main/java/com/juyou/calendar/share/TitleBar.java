package com.juyou.calendar.share;


import android.app.Activity;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.juyou.calendar.R;
/**
 * 标题文件 属性：titleLeftArrow:boolean 返回箭头是否显示，默认显示 titleLeftText:String 左边按钮内容
 * titleName:String 标题名字 titleRight：String 右侧按钮名字
 * <p>
 * 如果需要隐藏左边窗口，需要把titleLeftArrow设置为false，并把titleLeftText设置为"".
 * <p>
 * titleOnClickListener:按钮点击事件。
 * <p>
 * 1.设置左边back 箭头，则显示返回
 * <p>
 * 2.不设置左边箭头，则显示取消
 * <p>
 * 3.可自定义标题
 * <p>
 * 4.可自定义左边按钮文字
 * <p>
 * 5.可自定义右边按钮文字（确定、发送、取消等）
 *
 * @author Administrator
 */
public class TitleBar extends LinearLayout {

    private Context context;
    private ImageView iv_back;
    private TextView titleName;
    private TextView title_right_btn;
    private ViewGroup titleView;
    public TitleBar(Context context) {
        super(context);
        init(context, null);
    }

    public TitleBar(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context, attrs);
    }

    public TitleBar(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        init(context, attrs);
    }

    private void init(Context context, AttributeSet attrs) {
        initView(context);
        TypedArray attrArray = context.obtainStyledAttributes(attrs, R.styleable.TitleBarAttr);
        int color = attrArray.getColor(R.styleable.TitleBarAttr_titleBgColor, 0);
        int titleColor = attrArray.getColor(R.styleable.TitleBarAttr_titleColor,0);
        int titleRightColor = attrArray.getColor(R.styleable.TitleBarAttr_titleRightColor,0);
        if (titleRightColor!=0){
            title_right_btn.setTextColor(titleRightColor);
        }
        if (titleColor!=0){
            titleName.setTextColor(titleColor);
        }
        if (color !=0){
            titleView.setBackgroundColor(color);
        }
        // 设置左边返回按钮上的文字以及箭头是否显示。默认箭头显示，文字为返回
        Drawable leftDrawable = attrArray.getDrawable(R.styleable.TitleBarAttr_titleLeftIco);
        if (leftDrawable != null) {
            iv_back.setImageDrawable(leftDrawable);
        }
        if (attrArray.getBoolean(R.styleable.TitleBarAttr_titleShowBackButton, true)) {
            iv_back.setVisibility(View.VISIBLE);
        } else {
            iv_back.setVisibility(View.GONE);
        }

        // 设置titleName
        String title = attrArray.getString(R.styleable.TitleBarAttr_titleName);
        if (!TextUtils.isEmpty(title)) {
            titleName.setText(title);
        }
        // 设置右边文字的内容
        String rightText = attrArray.getString(R.styleable.TitleBarAttr_titleRightName);
        Drawable rightDrawable = attrArray.getDrawable(R.styleable.TitleBarAttr_titleRightIco);
        if (rightDrawable != null) {
            title_right_btn.setCompoundDrawablesWithIntrinsicBounds(rightDrawable, null, null, null);
        }
        if (!TextUtils.isEmpty(rightText)) {
            title_right_btn.setText(rightText);
        }
        title_right_btn.setOnClickListener(listener);
        iv_back.setOnClickListener(listener);
        attrArray.recycle();
    }

    private void initView(Context context) {
        this.context = context;
        LayoutInflater.from(context).inflate(R.layout.title_bar, this, true);
        iv_back = findViewById(R.id.iv_back);
        titleName = findViewById(R.id.titleName);
        title_right_btn = findViewById(R.id.title_right_btn);
        titleView = findViewById(R.id.titleView);
    }

    TitleButtonOnClickListener titleBtnClickListener = new TitleButtonOnClickListener() {

        @Override
        public void RightButtonOnClick(View v) {
        }

        @Override
        public void LeftButtonOnClick(View v) {
            if (context instanceof Activity) {
                ((Activity) context).finish();
            }
        }
    };

    OnClickListener listener = new OnClickListener() {

        @Override
        public void onClick(View v) {
            int i = v.getId();
            if (i == R.id.iv_back) {
                if (titleBtnClickListener != null) {
                    titleBtnClickListener.LeftButtonOnClick(v);
                }
            } else if (i == R.id.title_right_btn) {
                if (titleBtnClickListener != null) {
                    title_right_btn.setEnabled(false);
                    titleBtnClickListener.RightButtonOnClick(v);
                    title_right_btn.setEnabled(true);
                }
            }

        }
    };

    /**
     * 标题中的按钮被点击监听
     *
     * @author Administrator
     */
    public interface TitleButtonOnClickListener {

        /**
         * 左边按钮被点击
         *
         * @param v
         */
        void LeftButtonOnClick(View v);


        /**
         * 右边按钮被点击
         *
         * @param v
         */
        void RightButtonOnClick(View v);
    }

    /**
     * 设置标题按钮被点击的事件
     *
     * @param titleBtnClickListener
     */
    public void setTitleButtonOnClickListener(TitleButtonOnClickListener titleBtnClickListener) {

        this.titleBtnClickListener = titleBtnClickListener;
    }

    /**
     * 设置titleName
     *
     * @param title
     */
    public void setTitleName(String title) {

        titleName.setText(title);
    }
    public void setTitleNameColor(int colorId) {

        titleName.setTextColor(getResources().getColor(colorId));
    }

    public void setTitleAlphaColor(int colorId) {
        titleName.setTextColor(colorId);
    }
    /**
     * 设置右边按钮内容
     *
     * @param title
     */
    public void setTitleRightText(String title) {
        if (TextUtils.isEmpty(title)) {
            title_right_btn.setVisibility(View.GONE);
        } else {
            title_right_btn.setVisibility(View.VISIBLE);
            title_right_btn.setText(title);
        }
    }

    public void setTitleRightdrawble(int drawbleId) {
        Drawable rightDrawable = getResources().getDrawable(drawbleId);
        title_right_btn.setCompoundDrawablesWithIntrinsicBounds(rightDrawable, null, null, null);
    }

    public void setRightVisible(int visible) {
        title_right_btn.setVisibility(visible);
    }

    public void setLeftrdrawble(int drawbleId) {
        Drawable leftDrawable = getResources().getDrawable(drawbleId);
        iv_back.setImageDrawable(leftDrawable);
    }

    public void setTitleRightTextSize(int size_sp) {
        title_right_btn.setTextSize(size_sp);
    }

    public void setBackGroundColor(int colorId){
        titleView.setBackgroundColor(getResources().getColor(colorId));
    }
}
