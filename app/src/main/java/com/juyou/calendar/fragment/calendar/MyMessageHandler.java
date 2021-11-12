package com.juyou.calendar.fragment.calendar;

import android.os.Handler;
import android.os.Message;

import com.contrarywind.view.WheelView;

/**
 * @author
 * @datetime 2021-10-11 16:05
 * @detail :
 */
public class MyMessageHandler extends Handler {
    public static final int WHAT_INVALIDATE_LOOP_VIEW = 1000;
    public static final int WHAT_SMOOTH_SCROLL = 2000;
    public static final int WHAT_ITEM_SELECTED = 3000;

    private final MyWheelView mywheelView;

    public MyMessageHandler(MyWheelView mywheelView) {
        this.mywheelView = mywheelView;
    }

    @Override
    public final void handleMessage(Message msg) {
        switch (msg.what) {
            case WHAT_INVALIDATE_LOOP_VIEW:
                mywheelView.invalidate();
                break;

            case WHAT_SMOOTH_SCROLL:
                mywheelView.smoothScroll(WheelView.ACTION.FLING);
                break;

            case WHAT_ITEM_SELECTED:
                mywheelView.onItemSelected();
                break;
        }
    }

}
