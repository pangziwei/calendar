package com.juyou.calendar.mine.about;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toolbar;

import com.juyou.calendar.R;
import com.juyou.calendar.activity.MyMainActivity;
import com.juyou.calendar.base.BaseActivity;
import com.juyou.calendar.bo.StringCache;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class AboutActivity extends BaseActivity {


    @BindView(R.id.tv_title_left)
    TextView tvTitleLeft;
    @BindView(R.id.view_actionBar_title)
    TextView viewActionBarTitle;
    @BindView(R.id.img_right)
    ImageView imgRight;
    @BindView(R.id.ll_right)
    LinearLayout llRight;
    @BindView(R.id.bill_toolbar)
    Toolbar billToolbar;
    @BindView(R.id.rl_pa)
    LinearLayout rlPa;
    @BindView(R.id.btn_isExit)
    TextView btnIsExit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);
        ButterKnife.bind(this);
        initView();

    }


    private void initView() {
        viewActionBarTitle.setText("关于");


    }

    @OnClick({R.id.btn_isExit,})
    public void onViewClicked(View view) {
        switch (view.getId()) {


            case R.id.btn_isExit:
                StringCache.put("login", "false");
                StringCache.put("token", "");
                //下次默认的收款方式
                StringCache.put("strNumber", "");
                StringCache.put("payType", "");
                //下次默认的收款方式
                StringCache.put("payTypeWechat", "");
                StringCache.put("payTypeAlipay", "");
                StringCache.put("payTypeBank", "");
                //CID的设置为空
//                StringCache.put("GTCID", "");
//                Intent intent = new Intent(AboutActivity.this, MainActivity.class);
                Intent intent = new Intent(AboutActivity.this, MyMainActivity.class);
                intent.putExtra("SelectIndex", 1);
                startActivity(intent);
                finish();
                break;

        }
    }
}
