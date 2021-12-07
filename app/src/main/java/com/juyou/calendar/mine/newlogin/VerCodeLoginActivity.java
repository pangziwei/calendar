package com.juyou.calendar.mine.newlogin;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.gson.Gson;
import com.juyou.calendar.R;
import com.juyou.calendar.activity.MyMainActivity;
import com.juyou.calendar.bean.LoginInfo;
import com.juyou.calendar.bo.CurrentBean;
import com.juyou.calendar.bo.JuYouBo;
import com.juyou.calendar.bo.NetResultCallBack;
import com.juyou.calendar.bo.StringCache;
import com.juyou.calendar.util.TimeCountUtil;
import com.manggeek.android.geek.utils.JSONUtil;
import com.wynsbin.vciv.VerificationCodeInputView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class VerCodeLoginActivity extends AppCompatActivity {


    public String PhoneTel;
    public String CodeVer;
    public String smsType;
    @BindView(R.id.tv_title_left)
    TextView tvTitleLeft;
    @BindView(R.id.view_actionBar_title)
    TextView viewActionBarTitle;
    @BindView(R.id.img_right)
    ImageView imgRight;
    @BindView(R.id.ll_right)
    LinearLayout llRight;

    @BindView(R.id.rl_pa)
    LinearLayout rlPa;
    @BindView(R.id.tv_vercode_phone)
    TextView tvVercodePhone;
    @BindView(R.id.vciv_code3)
    VerificationCodeInputView vcivCode3;
    @BindView(R.id.btn_get_Code)
    TextView btnGetCode;
    private TimeCountUtil timeCountUtil;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ver_code_login);
        ButterKnife.bind(this);
        initView();

        timeCountUtil = new TimeCountUtil(VerCodeLoginActivity.this, 60000, 1000, btnGetCode, "login");
        timeCountUtil.start();


        if (getIntent() != null) {
            PhoneTel = getIntent().getStringExtra("PhoneTel");
            CodeVer = getIntent().getStringExtra("statusCode");
            tvVercodePhone.setText(PhoneTel);

//             //发送短信
//    // smsType 登录 - LOGIN
//    //设置支付密码 - SET_PAYMENT_PASSWORD
//    //商业节点认证 - AUTH_DIGITAL_IP
////    发送短信 新增两种类型
////    注册-REGISTERED
////    修改密码-UPDATE_PWD
            if (CodeVer.contains("0")) {
//            注册
                smsType = "REGISTERED";
                getVerCode(PhoneTel, smsType);
                Log.e("GetVerCodeActivity", "已注册未设置密码");

            } else if (CodeVer.contains("1")) {
//                已注册未设置密码
                smsType = "LOGIN";
                Log.e("GetVerCodeActivity", "已注册未设置密码");
                getVerCode(PhoneTel, smsType);
            } else if (CodeVer.contains("2")) {
//                已注册并设置密码
                smsType = "LOGIN";
                getVerCode(PhoneTel, smsType);
                Log.e("GetVerCodeActivity", "已注册未设置密码");

            }

        }


    }

    private void initView() {
        viewActionBarTitle.setText("登录");


        vcivCode3.setOnInputListener(new VerificationCodeInputView.OnInputListener() {
            @Override
            public void onComplete(String VerCode) {
                //获得验证码
                login(VerCode);
            }

            @Override
            public void onInput() {

            }


        });


    }


    private void login(String VerCode) {

        JuYouBo.Login(VerCodeLoginActivity.this, PhoneTel, VerCode, new NetResultCallBack() {
            @Override
            public void onSuccess(int what, CurrentBean currentBean) {
                if (currentBean.getCode().equals("200")) {

                    if (currentBean.getData() != null) {
                        LoginInfo loginInfo = JSONUtil.getObj((String.valueOf(currentBean.getData())), LoginInfo.class);
                        StringCache.put("token", loginInfo.getAccessToken());
                        StringCache.put("login", "true");
                        StringCache.put("telPhone", PhoneTel);
                        String clientid = StringCache.get("GTCID");

                        JuYouBo.SubmitCid(VerCodeLoginActivity.this, clientid, new NetResultCallBack() {
                            @Override
                            public void onSuccess(int what, CurrentBean currentBean) {
                                Log.e("CID", "验证码的VerCodeLoginActivity-----成功-----clientid--------------" + clientid);
                            }

                            @Override
                            public void onFail(int what, CurrentBean currentBean) {
                                Log.e("CID", "验证码的VerCodeLoginActivity-----失败---currentBean-----" + new Gson().toJson(currentBean));

                            }
                        });

                        Intent intent = new Intent(VerCodeLoginActivity.this, MyMainActivity.class);
                        intent.putExtra("SelectIndex", 1);
                        startActivity(intent);
                        finish();
                    } else {

                    }

                }
            }

            @Override
            public void onFail(int what, CurrentBean currentBean) {
                Log.e("登录失败", "验证码的VerCodeLoginActivity-----失败---currentBean-----" + new Gson().toJson(currentBean));

                if (new Gson().toJson(currentBean.getMsg()).contains("null")) {
                } else {
                    Toast.makeText(VerCodeLoginActivity.this, currentBean.getMsg(), Toast.LENGTH_SHORT).show();
                    Toast.makeText(VerCodeLoginActivity.this, currentBean.getErrorMsg(), Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    @OnClick({R.id.btn_get_Code})
    public void onViewClicked(View view) {
        switch (view.getId()) {

            case R.id.btn_get_Code:

                getVerCode(PhoneTel, smsType);
                break;
        }
    }


    private void getVerCode(String phong, String smsType) {
        JuYouBo.SendSms(VerCodeLoginActivity.this, PhoneTel, smsType, new NetResultCallBack() {
            @Override
            public void onSuccess(int what, CurrentBean currentBean) {
                if (currentBean.getCode().equals("200")) {
                    Toast.makeText(VerCodeLoginActivity.this, "验证码已发送", Toast.LENGTH_SHORT).show();
                    timeCountUtil = new TimeCountUtil(VerCodeLoginActivity.this, 60000, 1000, btnGetCode, "login");
                    timeCountUtil.start();

                } else {

                }
            }

            @Override
            public void onFail(int what, CurrentBean currentBean) {
                if (new Gson().toJson(currentBean.getMsg()).contains("null")) {
                } else {
                    Toast.makeText(VerCodeLoginActivity.this, currentBean.getMsg(), Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
