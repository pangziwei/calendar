package com.manggeek.android.geek.countdown;

import android.os.CountDownTimer;
import android.widget.TextView;

public class GeekCountDownTimer extends CountDownTimer {
    private TextView remainingTv;

    public GeekCountDownTimer(long millisInFuture, long countDownInterval, TextView remainingTv) {
        super(millisInFuture, countDownInterval);
        if (remainingTv != null) {
            this.remainingTv = remainingTv;
        }
    }

    public GeekCountDownTimer(TextView remainingTv) {
        this(60 * 1000, 1000, remainingTv);

    }

    public GeekCountDownTimer(long millisInFuture, long countDownInterval) {
        super(millisInFuture, countDownInterval);
    }

    @Override
    public void onTick(long millisUntilFinished) {
        if (remainingTv != null) {
            remainingTv.setClickable(false);
            remainingTv.setText(millisUntilFinished / 1000 + "秒");
        }
        if (onTickListener != null) {
            onTickListener.onTick(millisUntilFinished);
        }
    }

    @Override
    public void onFinish() {
        if (remainingTv != null) {
            remainingTv.setClickable(true);
            remainingTv.setText("发送验证码");
        }
        if (onTickListener != null) {
            onTickListener.finish();
        }
    }

    public interface OnTickListener {
        void finish();

        void onTick(long millisUntilFinished);
    }

    private OnTickListener onTickListener;

    public void setOnTickListener(OnTickListener onTickListener) {
        this.onTickListener = onTickListener;
    }
}
