package com.juyou.calendar.fragment.calendar;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.ColorInt;

import com.bigkoo.pickerview.listener.CustomListener;
import com.bigkoo.pickerview.listener.OnTimeSelectChangeListener;
import com.bigkoo.pickerview.listener.OnTimeSelectListener;
import com.contrarywind.view.WheelView;

import java.util.Calendar;

/**
 * @author
 * @datetime 2021-10-11 15:41
 * @detail :
 */
public class mTimePickerBuilder {
    private MyPickerOptions MyPickerOptions;

    //Required
    public mTimePickerBuilder(Context context, OnTimeSelectListener listener) {
        MyPickerOptions = new MyPickerOptions(MyPickerOptions.TYPE_PICKER_TIME);
        MyPickerOptions.context = context;
        MyPickerOptions.timeSelectListener = listener;
    }

    //Option
    public mTimePickerBuilder setGravity(int gravity) {
        MyPickerOptions.textGravity = gravity;
        return this;
    }

    public mTimePickerBuilder addOnCancelClickListener(View.OnClickListener cancelListener) {
        MyPickerOptions.cancelListener = cancelListener;
        return this;
    }

    /**
     * new boolean[]{true, true, true, false, false, false}
     * control the "year","month","day","hours","minutes","seconds " display or hide.
     * 分别控制“年”“月”“日”“时”“分”“秒”的显示或隐藏。
     *
     * @param type 布尔型数组，长度需要设置为6。
     * @return mTimePickerBuilder
     */
    public mTimePickerBuilder setType(boolean[] type) {
        MyPickerOptions.type = type;
        return this;
    }

    public mTimePickerBuilder setSubmitText(String textContentConfirm) {
        MyPickerOptions.textContentConfirm = textContentConfirm;
        return this;
    }

    public mTimePickerBuilder isDialog(boolean isDialog) {
        MyPickerOptions.isDialog = isDialog;
        return this;
    }

    public mTimePickerBuilder setCancelText(String textContentCancel) {
        MyPickerOptions.textContentCancel = textContentCancel;
        return this;
    }

    public mTimePickerBuilder setTitleText(String textContentTitle) {
        MyPickerOptions.textContentTitle = textContentTitle;
        return this;
    }

    public mTimePickerBuilder setSubmitColor(int textColorConfirm) {
        MyPickerOptions.textColorConfirm = textColorConfirm;
        return this;
    }

    public mTimePickerBuilder setCancelColor(int textColorCancel) {
        MyPickerOptions.textColorCancel = textColorCancel;
        return this;
    }

    /**
     * ViewGroup 类型的容器
     *
     * @param decorView 选择器会被添加到此容器中
     * @return mTimePickerBuilder
     */
    public mTimePickerBuilder setDecorView(ViewGroup decorView) {
        MyPickerOptions.decorView = decorView;
        return this;
    }

    public mTimePickerBuilder setBgColor(int bgColorWheel) {
        MyPickerOptions.bgColorWheel = bgColorWheel;
        return this;
    }

    public mTimePickerBuilder setTitleBgColor(int bgColorTitle) {
        MyPickerOptions.bgColorTitle = bgColorTitle;
        return this;
    }

    public mTimePickerBuilder setTitleColor(int textColorTitle) {
        MyPickerOptions.textColorTitle = textColorTitle;
        return this;
    }

    public mTimePickerBuilder setSubCalSize(int textSizeSubmitCancel) {
        MyPickerOptions.textSizeSubmitCancel = textSizeSubmitCancel;
        return this;
    }

    public mTimePickerBuilder setTitleSize(int textSizeTitle) {
        MyPickerOptions.textSizeTitle = textSizeTitle;
        return this;
    }

    public mTimePickerBuilder setContentTextSize(int textSizeContent) {
        MyPickerOptions.textSizeContent = textSizeContent;
        return this;
    }

    /**
     * 因为系统Calendar的月份是从0-11的,所以如果是调用Calendar的set方法来设置时间,月份的范围也要是从0-11
     *
     * @param date
     * @return mTimePickerBuilder
     */
    public mTimePickerBuilder setDate(Calendar date) {
        MyPickerOptions.date = date;
        return this;
    }

    public mTimePickerBuilder setLayoutRes(int res, CustomListener customListener) {
        MyPickerOptions.layoutRes = res;
        MyPickerOptions.customListener = customListener;
        return this;
    }


    /**
     * 设置起始时间
     * 因为系统Calendar的月份是从0-11的,所以如果是调用Calendar的set方法来设置时间,月份的范围也要是从0-11
     */

    public mTimePickerBuilder setRangDate(Calendar startDate, Calendar endDate) {
        MyPickerOptions.startDate = startDate;
        MyPickerOptions.endDate = endDate;
        return this;
    }


    /**
     * 设置间距倍数,但是只能在1.0-4.0f之间
     *
     * @param lineSpacingMultiplier
     */
    public mTimePickerBuilder setLineSpacingMultiplier(float lineSpacingMultiplier) {
        MyPickerOptions.lineSpacingMultiplier = lineSpacingMultiplier;
        return this;
    }

    /**
     * 设置分割线的颜色
     *
     * @param dividerColor
     */

    public mTimePickerBuilder setDividerColor(@ColorInt int dividerColor) {
        MyPickerOptions.dividerColor = dividerColor;
        return this;
    }

    /**
     * 设置分割线的类型
     *
     * @param dividerType
     */
    public mTimePickerBuilder setDividerType(WheelView.DividerType dividerType) {
        MyPickerOptions.dividerType = dividerType;
        return this;
    }

    /**
     * {@link #setOutSideColor} instead.
     *
     * @param backgroundId color resId.
     */
    @Deprecated
    public mTimePickerBuilder setBackgroundId(int backgroundId) {
        MyPickerOptions.outSideColor = backgroundId;
        return this;
    }

    /**
     * 显示时的外部背景色颜色,默认是灰色
     *
     * @param outSideColor
     */
    public mTimePickerBuilder setOutSideColor(@ColorInt int outSideColor) {
        MyPickerOptions.outSideColor = outSideColor;
        return this;
    }

    /**
     * 设置分割线之间的文字的颜色
     *
     * @param textColorCenter
     */
    public mTimePickerBuilder setTextColorCenter(@ColorInt int textColorCenter) {
        MyPickerOptions.textColorCenter = textColorCenter;
        return this;
    }

    /**
     * 设置分割线以外文字的颜色
     *
     * @param textColorOut
     */
    public mTimePickerBuilder setTextColorOut(@ColorInt int textColorOut) {
        MyPickerOptions.textColorOut = textColorOut;
        return this;
    }

    public mTimePickerBuilder isCyclic(boolean cyclic) {
        MyPickerOptions.cyclic = cyclic;
        return this;
    }

    public mTimePickerBuilder setOutSideCancelable(boolean cancelable) {
        MyPickerOptions.cancelable = cancelable;
        return this;
    }

    //是否显示农历
    public mTimePickerBuilder setLunarCalendar(boolean lunarCalendar) {
        MyPickerOptions.isLunarCalendar = lunarCalendar;
        return this;
    }


    public mTimePickerBuilder setLabel(String label_year, String label_month, String label_day, String label_hours, String label_mins, String label_seconds) {
        MyPickerOptions.label_year = label_year;
        MyPickerOptions.label_month = label_month;
        MyPickerOptions.label_day = label_day;
        MyPickerOptions.label_hours = label_hours;
        MyPickerOptions.label_minutes = label_mins;
        MyPickerOptions.label_seconds = label_seconds;
        return this;
    }

    /**
     * 设置X轴倾斜角度[ -90 , 90°]
     *
     * @param x_offset_year    年
     * @param x_offset_month   月
     * @param x_offset_day     日
     * @param x_offset_hours   时
     * @param x_offset_minutes 分
     * @param x_offset_seconds 秒
     * @return
     */
    public mTimePickerBuilder setTextXOffset(int x_offset_year, int x_offset_month, int x_offset_day,
                                             int x_offset_hours, int x_offset_minutes, int x_offset_seconds) {
        MyPickerOptions.x_offset_year = x_offset_year;
        MyPickerOptions.x_offset_month = x_offset_month;
        MyPickerOptions.x_offset_day = x_offset_day;
        MyPickerOptions.x_offset_hours = x_offset_hours;
        MyPickerOptions.x_offset_minutes = x_offset_minutes;
        MyPickerOptions.x_offset_seconds = x_offset_seconds;
        return this;
    }

    public mTimePickerBuilder isCenterLabel(boolean isCenterLabel) {
        MyPickerOptions.isCenterLabel = isCenterLabel;
        return this;
    }

    /**
     * @param listener 切换item项滚动停止时，实时回调监听。
     * @return
     */
    public mTimePickerBuilder setTimeSelectChangeListener(OnTimeSelectChangeListener listener) {
        MyPickerOptions.timeSelectChangeListener = listener;
        return this;
    }

    public mTimePickerView build() {
        return new mTimePickerView(MyPickerOptions);
    }
}


