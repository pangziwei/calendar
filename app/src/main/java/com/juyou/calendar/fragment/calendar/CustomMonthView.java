package com.juyou.calendar.fragment.calendar;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.text.TextUtils;
import android.util.Log;

import com.haibin.calendarview.Calendar;
import com.haibin.calendarview.MonthView;
import com.juyou.calendar.R;

/**
 * 演示一个变态需求的月视图
 * Created by huanghaibin on 2018/2/9.
 */

public class CustomMonthView extends MonthView {

    private int mRadius;

    /**
     * 自定义魅族标记的文本画笔
     */
    private Paint mTextPaint = new Paint();


    /**
     * 24节气画笔
     */
    private Paint mSolarTermTextPaint = new Paint();

    /**
     * 节假日画笔
     */
    private Paint holidayTextPaint = new Paint();

    /**
     * 背景圆点
     */
    private Paint mPointPaint = new Paint();

    /**
     * 今天的背景色
     */
    private Paint mCurrentDayPaint = new Paint();

    /**
     * 圆点半径
     */
    private float mPointRadius;

    private int mPadding;

    private float mCircleRadius;
    /**
     * 自定义魅族标记的圆形背景
     */
    private Paint mSchemeBasicPaint = new Paint();

    private float mSchemeBaseLine;

    public CustomMonthView(Context context) {
        super(context);

        mTextPaint.setTextSize(dipToPx(context, 8));
        mTextPaint.setColor(0xffffffff);
        mTextPaint.setAntiAlias(true);
        mTextPaint.setFakeBoldText(true);


        mSolarTermTextPaint.setColor(0xff489dff);
        mSolarTermTextPaint.setAntiAlias(true);
        mSolarTermTextPaint.setTextAlign(Paint.Align.CENTER);

        holidayTextPaint.setColor(0xffff0000);
        holidayTextPaint.setAntiAlias(true);
        holidayTextPaint.setTextAlign(Paint.Align.CENTER);

        mSchemeBasicPaint.setAntiAlias(true);
        mSchemeBasicPaint.setStyle(Paint.Style.FILL);
        mSchemeBasicPaint.setTextAlign(Paint.Align.CENTER);
        mSchemeBasicPaint.setFakeBoldText(true);
        mSchemeBasicPaint.setColor(Color.WHITE);


        mCurrentDayPaint.setAntiAlias(true);
        mCurrentDayPaint.setStyle(Paint.Style.FILL);
        mCurrentDayPaint.setColor(0xFFeaeaea);

        mPointPaint.setAntiAlias(true);
        mPointPaint.setStyle(Paint.Style.FILL);
        mPointPaint.setTextAlign(Paint.Align.CENTER);
        mPointPaint.setColor(Color.RED);

        mCircleRadius = dipToPx(getContext(), 7);

        mPadding = dipToPx(getContext(), 3);

        mPointRadius = dipToPx(context, 2);

        Paint.FontMetrics metrics = mSchemeBasicPaint.getFontMetrics();
        mSchemeBaseLine = mCircleRadius - metrics.descent + (metrics.bottom - metrics.top) / 2 + dipToPx(getContext(), 1);

    }


    @Override
    protected void onPreviewHook() {
        mSolarTermTextPaint.setTextSize(mCurMonthLunarTextPaint.getTextSize());
        holidayTextPaint.setTextSize(mSelectedLunarTextPaint.getTextSize());
        mRadius = Math.min(mItemWidth, mItemHeight) / 11 * 5;
    }


    @Override
    protected boolean onDrawSelected(Canvas canvas, Calendar calendar, int x, int y, boolean hasScheme) {
        int cx = x + mItemWidth / 2;
        int cy = y + mItemHeight / 2;

        canvas.drawCircle(cx, cy, mRadius, mSelectedPaint);
        return true;
    }

    @Override
    protected void onDrawScheme(Canvas canvas, Calendar calendar, int x, int y) {

        boolean isSelected = isSelected(calendar);
        if (isSelected) {
            mPointPaint.setColor(Color.WHITE);
        } else {
            mPointPaint.setColor(Color.GRAY);
        }

        canvas.drawCircle(x + mItemWidth / 2, y + mItemHeight - 3 * mPadding, mPointRadius, mPointPaint);
    }

    @SuppressWarnings("IntegerDivisionInFloatingPointContext")
    @Override
    protected void onDrawText(Canvas canvas, Calendar calendar, int x, int y, boolean hasScheme, boolean isSelected) {
        int cx = x + mItemWidth / 2;
        int cy = y + mItemHeight / 2;
        int top = y - mItemHeight / 6;

        if (calendar.isCurrentDay() && !isSelected) {
            canvas.drawCircle(cx, cy, mRadius, mCurrentDayPaint);
        }

        if (hasScheme) {
//            Log.e("日历", "77777777777777777");
            canvas.drawCircle(x + mItemWidth - mPadding - mCircleRadius / 2, y + mPadding + mCircleRadius, mCircleRadius, mSchemeBasicPaint);
            mTextPaint.setColor(calendar.getSchemeColor());
            canvas.drawText(calendar.getScheme(), x + mItemWidth - mPadding - mCircleRadius, y + mPadding + mSchemeBaseLine, mTextPaint);
        }

        //当然可以换成其它对应的画笔就不麻烦，
        if (calendar.isWeekend() && calendar.isCurrentMonth()) {
//            Log.e("日历", "888888888888888888");
            mCurMonthTextPaint.setColor(0xFF489dff);//在本月的界面中，上面阴历显示
            mCurMonthLunarTextPaint.setColor(0xFF489dff);//本月的界面中，下面农历显示，含24节气
            mSchemeTextPaint.setColor(0xFF489dff);
            mSchemeLunarTextPaint.setColor(0xFF489dff);
            mOtherMonthLunarTextPaint.setColor(0xFFff0000);
            mOtherMonthTextPaint.setColor(0xFF489dff);
            mHoulidyCurMonthLunarTextPaint.setColor(getResources().getColor(R.color.red));

        } else {
//            mCurMonthTextPaint.setColor(0xff333333);
//            mCurMonthLunarTextPaint.setColor(0xffCFCFCF);
//            mSchemeTextPaint.setColor(0xff333333);
//            mSchemeLunarTextPaint.setColor(0xffCFCFCF);
//            Log.e("日历", "9999999999999999");
            mCurMonthTextPaint.setColor(0xff333333);//在本月的界面中，上面阴历显示
            mCurMonthLunarTextPaint.setColor(0xffCFCFCF);//本月的界面中，下面农历显示，不含周末和24节气
            mSchemeTextPaint.setColor(0xff333333);//未知
            mSchemeLunarTextPaint.setColor(0xffCFCFCF);//未知
            mOtherMonthTextPaint.setColor(0xFFe1e1e1);//不是本月，但在本月的界面中，上面阴历显示
            mOtherMonthLunarTextPaint.setColor(0xFFe1e1e1);//不是本月，但在本月的界面中，下面农历显示
            mHoulidyCurMonthLunarTextPaint.setColor(getResources().getColor(R.color.red));
        }
//        以下是调节节假日和节气的颜色变化
        if (isSelected) {
//            Log.e("日历", "77777888888888888" + isSelected);
            canvas.drawText(String.valueOf(calendar.getDay()), cx, mTextBaseLine + top,
                    mSelectTextPaint);
            canvas.drawText(calendar.getLunar(), cx, mTextBaseLine + y + mItemHeight / 10, mSelectedLunarTextPaint);
        } else if (hasScheme) {
//            Log.e("日历", "888888888887777777777" + hasScheme);
            canvas.drawText(String.valueOf(calendar.getDay()), cx, mTextBaseLine + top,
                    calendar.isCurrentMonth() ? mSchemeTextPaint : mOtherMonthTextPaint);
            canvas.drawText(calendar.getLunar(), cx, mTextBaseLine + y + mItemHeight / 10,
                    !TextUtils.isEmpty(calendar.getSolarTerm()) ? mSolarTermTextPaint : mSchemeLunarTextPaint);
        } else {
//            Log.e("日历", "------------777" + calendar.getLunar());

            //       Log.e("日历", "农历字符串----------"+calendar.getLunar());//几月初几的，包含24节气
//        Log.e("日历", "24节气------中国特有的24节气-------"+calendar.getSolarTerm());
//        Log.e("日历", "公历节日----国外节日，比我情人节，愚人节啥的-----只有，要么为“”------"+calendar.getGregorianFestival());
//        Log.e("日历", "传统农历节日----春节元宵端午的那种-----卫子---------"+calendar.getTraditionFestival());
//            Log.e("日历", "calendar.getDay()---------" + calendar.getTraditionFestival());
//            calendar.getGregorianFestival());
            canvas.drawText(String.valueOf(calendar.getDay()), cx, mTextBaseLine + top,
                    calendar.isCurrentDay() ? mCurDayTextPaint :
                            calendar.isCurrentMonth() ? mCurMonthTextPaint : mOtherMonthTextPaint);


            canvas.drawText(calendar.getLunar(), cx, mTextBaseLine + y + mItemHeight / 10,
                    calendar.isCurrentDay() ? mCurDayLunarTextPaint :
                            calendar.isCurrentMonth() ? !TextUtils.isEmpty(calendar.getSolarTerm()) ? mSolarTermTextPaint :
                                    mCurMonthLunarTextPaint : mOtherMonthLunarTextPaint);
            //除夕的节日
            canvas.drawText(calendar.getTraditionFestival(), cx, mTextBaseLine + y + mItemHeight / 10,
                    calendar.isCurrentDay() ? mHoulidyCurMonthLunarTextPaint :
                            calendar.isCurrentMonth() ? !TextUtils.isEmpty(calendar.getSolarTerm()) ? holidayTextPaint :
                                    mHoulidyCurMonthLunarTextPaint : mHoulidyCurMonthLunarTextPaint);
            //平安节的节日
            canvas.drawText(calendar.getGregorianFestival(), cx, mTextBaseLine + y + mItemHeight / 10,
                    calendar.isCurrentDay() ? mHoulidyCurMonthLunarTextPaint :
                            calendar.isCurrentMonth() ? !TextUtils.isEmpty(calendar.getSolarTerm()) ? holidayTextPaint :
                                    mHoulidyCurMonthLunarTextPaint : mHoulidyCurMonthLunarTextPaint);
//            canvas.drawText(calendar.getTraditionFestival(), cx, mTextBaseLine + y + mItemHeight / 10,
//                    calendar.isCurrentDay() ? mCurDayTextPaint :
//                            calendar.isCurrentMonth() ? !TextUtils.isEmpty(calendar.getSolarTerm()) ? holidayTextPaint :
//                                    mCurMonthLunarTextPaint : mOtherMonthLunarTextPaint);
        }
    }


    /**
     * dp转px
     *
     * @param context context
     * @param dpValue dp
     * @return px
     */
    private static int dipToPx(Context context, float dpValue) {
        final float scale = context.getResources().getDisplayMetrics().density;
        return (int) (dpValue * scale + 0.5f);
    }


}
