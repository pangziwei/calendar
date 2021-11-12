package com.juyou.calendar.fragment.calendar;

import com.contrarywind.timer.MessageHandler;

import java.util.TimerTask;

/**
 * @author
 * @datetime 2021-10-11 16:07
 * @detail :
 */
public class MySmoothScrollTimerTask extends TimerTask {

    private int realTotalOffset;
    private int realOffset;
    private int offset;
    private final MyWheelView mywheelView;

    public MySmoothScrollTimerTask(MyWheelView mywheelView, int offset) {
        this.mywheelView = mywheelView;
        this.offset = offset;
        realTotalOffset = Integer.MAX_VALUE;
        realOffset = 0;
    }

    @Override
    public final void run() {
        if (realTotalOffset == Integer.MAX_VALUE) {
            realTotalOffset = offset;
        }
        //把要滚动的范围细分成10小份，按10小份单位来重绘
        realOffset = (int) ((float) realTotalOffset * 0.1F);

        if (realOffset == 0) {
            if (realTotalOffset < 0) {
                realOffset = -1;
            } else {
                realOffset = 1;
            }
        }

        if (Math.abs(realTotalOffset) <= 1) {
            mywheelView.cancelFuture();
            mywheelView.getHandler().sendEmptyMessage(MessageHandler.WHAT_ITEM_SELECTED);
        } else {
            mywheelView.setTotalScrollY(mywheelView.getTotalScrollY() + realOffset);

            //这里如果不是循环模式，则点击空白位置需要回滚，不然就会出现选到－1 item的 情况
            if (!mywheelView.isLoop()) {
                float itemHeight = mywheelView.getItemHeight();
                float top = (float) (-mywheelView.getInitPosition()) * itemHeight;
                float bottom = (float) (mywheelView.getItemsCount() - 1 - mywheelView.getInitPosition()) * itemHeight;
                if (mywheelView.getTotalScrollY() <= top || mywheelView.getTotalScrollY() >= bottom) {
                    mywheelView.setTotalScrollY(mywheelView.getTotalScrollY() - realOffset);
                    mywheelView.cancelFuture();
                    mywheelView.getHandler().sendEmptyMessage(MessageHandler.WHAT_ITEM_SELECTED);
                    return;
                }
            }
            mywheelView.getHandler().sendEmptyMessage(MessageHandler.WHAT_INVALIDATE_LOOP_VIEW);
            realTotalOffset = realTotalOffset - realOffset;
        }
    }
}
