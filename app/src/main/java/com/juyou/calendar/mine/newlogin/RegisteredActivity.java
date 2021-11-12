package com.juyou.calendar.mine.newlogin;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.Toolbar;

import androidx.appcompat.app.AppCompatActivity;

import com.google.gson.Gson;
import com.juyou.calendar.R;
import com.juyou.calendar.activity.MyMainActivity;
import com.juyou.calendar.bo.CurrentBean;
import com.juyou.calendar.bo.LoveChallengeBo;
import com.juyou.calendar.bo.NetResultCallBack;
import com.juyou.calendar.bo.StringCache;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class RegisteredActivity extends AppCompatActivity {


    public String PhoneTel;
    public String statusCode;
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
    @BindView(R.id.et_logpaw_get_paw)
    EditText etLogpawGetPaw;
    @BindView(R.id.btn_reg_next)
    TextView btnRegNext;
    @BindView(R.id.tv_logingpas_forgetpaw)
    TextView tvLogingpasForgetpaw;
    @BindView(R.id.tv_logingpas_use_code)
    TextView tvLogingpasUseCode;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registered);
        ButterKnife.bind(this);
        initView();
    }

    private void initView() {
        viewActionBarTitle.setText("登录");

        if (getIntent() != null) {
            PhoneTel = getIntent().getStringExtra("PhoneTel");
            statusCode = getIntent().getStringExtra("statusCode");
            Log.e("RegisteredActivity", "PhoneTel------------------" + PhoneTel);
            Log.e("RegisteredActivity", "statusCode------------------" + statusCode);
        }

    }


    @OnClick({R.id.btn_reg_next, R.id.tv_logingpas_forgetpaw, R.id.tv_logingpas_use_code})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.btn_reg_next://下一步
//                登录
//                Toast.makeText(RegisteredActivity.this, "您点击了下一步\n 请求接口判断用户", Toast.LENGTH_SHORT).show();
                pwdLogin();
                break;
            case R.id.tv_logingpas_forgetpaw://忘记密码
//                Toast.makeText(RegisteredActivity.this, "您点击了忘记密码", Toast.LENGTH_SHORT).show();
                break;
            case R.id.tv_logingpas_use_code://验证码
                Intent intent = new Intent(RegisteredActivity.this, VerCodeLoginActivity.class);
                intent.putExtra("statusCode", statusCode);
                intent.putExtra("PhoneTel", PhoneTel);
                startActivity(intent);
                break;
        }
    }


    private void pwdLogin() {
        LoveChallengeBo.pwdLogin(RegisteredActivity.this, PhoneTel, etLogpawGetPaw.getText().toString(), new NetResultCallBack() {
            @Override
            public void onSuccess(int what, CurrentBean currentBean) {
                if (currentBean.getCode().equals("200")) {

                    if (currentBean.getData() != null) {
                        String token = String.valueOf(currentBean.getData());
                        StringCache.put("token", token);
                        Log.e("TAG", "token--------密码登录的界面-------" + token);
                        StringCache.put("login", "true");
                        StringCache.put("telPhone", PhoneTel.toString().trim());
                        String clientid = StringCache.get("GTCID");
                        Log.e("RegisteredActivity", "token--------LoginActivity-------" + clientid);

                        LoveChallengeBo.SubmitCid(RegisteredActivity.this, clientid, new NetResultCallBack() {
                            @Override
                            public void onSuccess(int what, CurrentBean currentBean) {
                                Log.e("CID", "密码登录的 cid----------onSuccess------clientid-------------" + new Gson().toJson(currentBean));
                            }

                            @Override
                            public void onFail(int what, CurrentBean currentBean) {
                                Log.e("CID", "密码登录的  cid---------onFail----------clientid---------" + new Gson().toJson(currentBean));

                            }
                        });

//                        Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                        Intent intent = new Intent(RegisteredActivity.this, MyMainActivity.class);
                        intent.putExtra("SelectIndex", 1);
                        startActivity(intent);
                        finish();
                    } else {

                    }

                }
            }

            @Override
            public void onFail(int what, CurrentBean currentBean) {
                if (new Gson().toJson(currentBean.getMsg()).contains("null")) {
                } else {
                    Toast.makeText(RegisteredActivity.this, currentBean.getMsg(), Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

}
