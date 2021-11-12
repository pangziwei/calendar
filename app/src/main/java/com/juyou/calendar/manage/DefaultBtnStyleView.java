package com.juyou.calendar.manage;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.Button;

import com.juyou.calendar.R;
import com.juyou.calendar.util.DisplayUtil;
import com.yuan.library.selector.SelectorFactory;
import com.yuan.library.selector.SelectorShape;
import com.yuan.library.selector.Shape;

/**
 * @desc 全局样式 app默认提交按钮样式
 */
@SuppressLint("AppCompatCustomView")
public class DefaultBtnStyleView extends Button {
    private Context context;

    public DefaultBtnStyleView(Context context) {
        super(context);
        this.context = context;
        setDrawable();
    }

    public DefaultBtnStyleView(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.context = context;
        setDrawable();
    }

    private void setDrawable() {
        Drawable drawable = SelectorFactory.create(new SelectorShape.SelectorBuilder()
                .normalColor(getResources().getColor(R.color.btnNormalColor))//正常颜色
                .pressColor(getResources().getColor(R.color.btnPressColor))//选中时颜色
                .disableColor(getResources().getColor(R.color.btnDisableColor))
                .shapeBuilder(new Shape.ShapeBuilder()
                        .leftBottomCorner(DisplayUtil.dip2px(context, 20))//圆角
                        .leftTopCorner(DisplayUtil.dip2px(context, 20))
                        .rightBottomCorner(DisplayUtil.dip2px(context, 20))
                        .rightTopCorner(DisplayUtil.dip2px(context, 20))).build());
        this.setBackgroundDrawable(drawable);
        setMinHeight(0);
    }
}
