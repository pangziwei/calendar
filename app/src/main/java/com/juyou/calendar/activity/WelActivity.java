package com.juyou.calendar.activity;

import android.content.Intent;
import android.os.Bundle;
import android.text.SpannableStringBuilder;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.juyou.calendar.R;
import com.juyou.calendar.dialog.ShowAllSpan;
import com.juyou.calendar.manage.SharedPreferenceUtil;
import com.juyou.calendar.util.WebUtils;
import com.zrq.spanbuilder.SpanBuilder;
import com.zrq.spanbuilder.TextStyle;

import java.util.Timer;
import java.util.TimerTask;

public class WelActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wel);
        boolean booleanValue = SharedPreferenceUtil.getBooleanValue(SharedPreferenceUtil.IS_AGREE_PROTOCOL, false);//是否同意协议（就是第一次进来的时候会有个协议）
        if (!booleanValue) {
//            不同意
//            finish();
            showAgreeDialog();

        } else {
//            同意
//            startMainActivity();
            startSplashActivity();
        }


    }

    private void startSplashActivity() {
        Log.e("函数来处理", "USD刚发啥大富科技安徽省考点击返回");
        TimerTask delayTask = new TimerTask() {
            @Override
            public void run() {
                Intent mainIntent = new Intent(WelActivity.this, SplashActivity.class);//这个是自动更新的
                startActivity(mainIntent);
                WelActivity.this.finish();
            }
        };
        Timer timer = new Timer();
        timer.schedule(delayTask, 500);//延时秒执行 run 里面的操作
    }
    private void startMainActivity() {
//        定时任务之第二个是个开始执行后或者可以设置服务启动2秒后执行，第三个参数表示时间间隔
        TimerTask delayTask = new TimerTask() {
            @Override
            public void run() {
                Intent mainIntent = new Intent(WelActivity.this, SplashActivity.class);//这个是自动更新的
                startActivity(mainIntent);
                WelActivity.this.finish();
            }
        };
        Timer timer = new Timer();
        timer.schedule(delayTask, 2000);//延时两秒执行 run 里面的操作
    }


    private void showAgreeDialog() {
        final AlertDialog.Builder builder1 = new AlertDialog.Builder(this);
        final AlertDialog builder = builder1.setView(R.layout.dialog_main_agree)
                .create();
        builder.setCanceledOnTouchOutside(false);
        builder.show();
        android.view.Window window = builder.getWindow();
        TextView strNum = window.findViewById(R.id.tvContent);
        TextView btnCancel = window.findViewById(R.id.btn_cancel);
        TextView btnSure = window.findViewById(R.id.btn_sure);
        SpannableStringBuilder stringBuilder = new SpannableStringBuilder();
        stringBuilder.append(new SpanBuilder("我们依据最新的监管要求更新了XXXX\n", 14, getResources().getColor(R.color.blackTrans)))
                .append(new SpanBuilder("《用户协议》", 14, getResources().getColor(R.color.textRedColor)).setTextStyle(TextStyle.BOLD).setClick(strNum, new ShowAllSpan(this, widget -> WebUtils.loadTitleWeb(this, "https://blog.csdn.net/qq_37328546?spm=1019.2139.3001.5343", "用户协议"))))
                .append(new SpanBuilder("和", 14, getResources().getColor(R.color.blackTrans)))
                .append(new SpanBuilder("《隐私政策》", 14, getResources().getColor(R.color.textRedColor)).setTextStyle(TextStyle.BOLD).setClick(strNum, new ShowAllSpan(this, widget -> WebUtils.loadTitleWeb(this, "https://blog.csdn.net/qq_37328546?spm=1019.2139.3001.5343", "隐私政策"))))
                .append(new SpanBuilder("特向您说明如下：\n", 14, getResources().getColor(R.color.blackTrans)))
                .append(new SpanBuilder(" 1.我是要求1；\n", 14, getResources().getColor(R.color.blackTrans)))
                .append(new SpanBuilder(" 2.我是要求2；\n", 14, getResources().getColor(R.color.blackTrans)))
                .append(new SpanBuilder(" 3.我是要求3；\n", 14,getResources().getColor(R.color.blackTrans)))
                .append(new SpanBuilder(" 4.我是要求4；\n", 14, getResources().getColor(R.color.blackTrans)))
                .append(new SpanBuilder(" 5.我是要求5。\n", 14, getResources().getColor(R.color.blackTrans)));



        strNum.setText(stringBuilder);
        btnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                builder.dismiss();
                finish();
            }
        });
        btnSure.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferenceUtil.putBooleanValue(SharedPreferenceUtil.IS_AGREE_PROTOCOL, true);
//                startMainActivity();
                startSplashActivity();
                builder.dismiss();
            }
        });


    }

}
