package com.juyou.calendar.fragment.calendar;

import android.view.MotionEvent;

/**
 * @author
 * @datetime 2021-10-11 16:11
 * @detail :
 */
public final class MyLoopViewGestureListener  extends android.view.GestureDetector.SimpleOnGestureListener {

    private final MyWheelView wheelView;


    public MyLoopViewGestureListener(MyWheelView wheelView) {
        this.wheelView = wheelView;
    }

    @Override
    public final boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {
        wheelView.scrollBy(velocityY);
        return true;
    }
}
