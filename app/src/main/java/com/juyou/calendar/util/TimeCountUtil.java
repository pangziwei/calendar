package com.juyou.calendar.util;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.os.CountDownTimer;
import android.view.Gravity;
import android.widget.TextView;

import com.juyou.calendar.R;

/**
 * Created by Administrator on 2016/2/22.
 */
public class TimeCountUtil extends CountDownTimer {
    private Activity mActivity;
    private TextView btn;//按钮
    private String strType = "";
    // 在这个构造方法里需要传入三个参数，一个是Activity，一个是总的时间millisInFuture，一个是countDownInterval，然后就是你在哪个按钮上做这个是，就把这个按钮传过来就可以了
    public TimeCountUtil(Activity mActivity, long millisInFuture, long countDownInterval, TextView btn,String type) {
        super(millisInFuture, countDownInterval);
        this.mActivity = mActivity;
        this.btn =btn;
        this.strType = type;
    }


    @SuppressLint("NewApi")
    @Override
    public void onTick(long millisUntilFinished) {
        btn.setClickable(false);//设置不能点击
        btn.setText(millisUntilFinished / 1000 +" 秒后可重新获取验证码");//设置倒计时时间
        if (strType.equals("login")){
            btn.setTextColor(mActivity.getResources().getColor(R.color.white));//设置字体颜色
            btn.setBackground(mActivity.getResources().getDrawable(R.drawable.mine_business_bg_gray));
        }else {
            btn.setTextColor(mActivity.getResources().getColor(R.color.red));//设置字体颜色
        }
        btn.setGravity(Gravity.CENTER);
    }


    @SuppressLint("NewApi")
    @Override
    public void onFinish() {
        btn.setText("重新获取验证码");
        if (strType.equals("login")){
            btn.setTextColor(mActivity.getResources().getColor(R.color.new_mine_recode));//设置字体颜色
        }else {
            btn.setTextColor(mActivity.getResources().getColor(R.color.red));//设置字体颜色
        }
        btn.setGravity(Gravity.CENTER);
        btn.setClickable(true);//重新获得点击
    }
}
