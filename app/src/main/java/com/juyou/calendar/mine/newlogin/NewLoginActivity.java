package com.juyou.calendar.mine.newlogin;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.SpannableStringBuilder;
import android.text.TextWatcher;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.juyou.calendar.R;
import com.juyou.calendar.base.MyBaseActivity;
import com.juyou.calendar.bo.CurrentBean;
import com.juyou.calendar.bo.JuYouBo;
import com.juyou.calendar.bo.NetResultCallBack;
import com.juyou.calendar.dialog.ShowAllSpan;
import com.juyou.calendar.util.H5UrlMananger;
import com.juyou.calendar.util.WebUtils;
import com.zrq.spanbuilder.SpanBuilder;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class NewLoginActivity extends MyBaseActivity {


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
    @BindView(R.id.tv_mine_welcome)
    TextView tvMineWelcome;
    @BindView(R.id.et_pawlogin_get_tel)
    EditText etPawloginGetTel;
    @BindView(R.id.tv_log_bg)
    TextView tvLogBg;
    @BindView(R.id.btn_pawlogin_get_next)
    TextView btnPawloginGetNext;
    @BindView(R.id.ck_agree_login)
    CheckBox ckAgreeLogin;
    @BindView(R.id.tv_link_login)
    TextView tvLinkLogin;
    @BindView(R.id.ll_lgin_success)
    LinearLayout llLginSuccess;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_paw_login);
        ButterKnife.bind(this);
        initview();

    }

    private void initview() {
        viewActionBarTitle.setText("登录");

        etPawloginGetTel.addTextChangedListener(new TextWatcher() {
            // 输入文本之前的状态
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            // 输入文本中的状态
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            // 输入文本之后的状态
            @Override
            public void afterTextChanged(Editable s) {
                if (etPawloginGetTel.length() == 11) {
                    btnPawloginGetNext.setBackground(NewLoginActivity.this.getResources().getDrawable(R.drawable.mine_business_bg_ff9239));
                    btnPawloginGetNext.setClickable(true);
                } else {
                    btnPawloginGetNext.setBackground(NewLoginActivity.this.getResources().getDrawable(R.drawable.mine_business_bg_gray));
                    btnPawloginGetNext.setClickable(false);//

                }
            }
        });
        SpannableStringBuilder stringBuilder = new SpannableStringBuilder();
        stringBuilder.append(new SpanBuilder("《用户协议》", 14, getResources().getColor(R.color.textcoloe9)).setClick(tvLinkLogin, new ShowAllSpan(this, widget -> WebUtils.loadTitleWeb(this, H5UrlMananger.USER_AGGREMENT_URL, "用户协议"))))
                .append(new SpanBuilder("和", 14, getResources().getColor(R.color.blackTrans)))
                .append(new SpanBuilder("《隐私政策》", 14, getResources().getColor(R.color.textcoloe9)).setClick(tvLinkLogin, new ShowAllSpan(this, widget -> WebUtils.loadTitleWeb(this, H5UrlMananger.USER_PRIVACYPOLICY_URL, "隐私政策"))));

        tvLinkLogin.setText(stringBuilder);
    }

    @OnClick({R.id.btn_pawlogin_get_next})
    public void onViewClicked(View view) {
        switch (view.getId()) {


            case R.id.btn_pawlogin_get_next:
                //访问接口
//                Log.e("TAG", "dksjahfkasdghfjkasgdfjkash0");
//                判断号码用if
//                Intent intent = new Intent(this, RegisteredActivity.class);
//                startActivity(intent);

                if (!ckAgreeLogin.isChecked()) {
                    Toast.makeText(NewLoginActivity.this, "请同意并勾选用户协议与隐私政策", Toast.LENGTH_SHORT).show();
                    return;
                }

                isRegisteredUser();//检验手机号是哪种类型的


                break;
        }
    }

    private void isRegisteredUser() {
        JuYouBo.isRegistered(NewLoginActivity.this, etPawloginGetTel.getText().toString(), new NetResultCallBack() {
            @Override
            public void onSuccess(int what, CurrentBean currentBean) {
                if (currentBean.getCode().equals("200")) {
                    //判断用户状态 0未注册 1未设置密码 2设置密码
                    String statusCode = String.valueOf(currentBean.getData());
                    if ("0".contains(statusCode)) {
                        //未注册新用户---0未注册


                    } else if ("1".contains(statusCode)) {
                        //老用户--已注册的未设置密码


                    } else if ("2".contains(statusCode)) {
//                        //已注册设置密码
                        Intent intent = new Intent(NewLoginActivity.this, RegisteredActivity.class);
                        intent.putExtra("PhoneTel", etPawloginGetTel.getText().toString());//手机号
                        intent.putExtra("statusCode", statusCode);
                        startActivity(intent);

                    }
                } else {
                    Toast.makeText(NewLoginActivity.this, currentBean.getErrorMsg(), Toast.LENGTH_SHORT).show();

                }
            }

            @Override
            public void onFail(int what, CurrentBean currentBean) {
                if (new Gson().toJson(currentBean.getMsg()).contains("null")) {
                } else {
                    Toast.makeText(NewLoginActivity.this, currentBean.getMsg(), Toast.LENGTH_SHORT).show();
                }

            }


        });

    }

}
