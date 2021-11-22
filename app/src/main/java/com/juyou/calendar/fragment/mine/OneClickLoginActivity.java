package com.juyou.calendar.fragment.mine;

import android.os.Bundle;
import android.text.SpannableStringBuilder;
import android.view.View;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.juyou.calendar.R;
import com.juyou.calendar.dialog.ShowAllSpan;
import com.juyou.calendar.mine.newlogin.NewLoginActivity;
import com.juyou.calendar.util.H5UrlMananger;
import com.juyou.calendar.util.WebUtils;
import com.zrq.spanbuilder.SpanBuilder;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class OneClickLoginActivity extends AppCompatActivity {

    @BindView(R.id.ll_qq_login)
    LinearLayout llQqLogin;
    @BindView(R.id.ll_wx_login)
    LinearLayout llWxLogin;
    @BindView(R.id.ll_wb_login)
    LinearLayout llWbLogin;
    @BindView(R.id.ck_agree_login)
    CheckBox ckAgreeLogin;
    @BindView(R.id.tv_link_login)
    TextView tvLinkLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_one_click_login);
        ButterKnife.bind(this);

        SpannableStringBuilder stringBuilder = new SpannableStringBuilder();
        stringBuilder.append(new SpanBuilder("《用户协议》", 14, getResources().getColor(R.color.textcoloeff9239)).setClick(tvLinkLogin, new ShowAllSpan(this, widget -> WebUtils.loadTitleWeb(this, H5UrlMananger.USER_AGGREMENT_URL, "用户协议"))))
                .append(new SpanBuilder("和", 14, getResources().getColor(R.color.blackTrans)))
                .append(new SpanBuilder("《隐私政策》", 14, getResources().getColor(R.color.textcoloeff9239)).setClick(tvLinkLogin, new ShowAllSpan(this, widget -> WebUtils.loadTitleWeb(this, H5UrlMananger.USER_PRIVACYPOLICY_URL, "隐私政策"))));
        tvLinkLogin.setText(stringBuilder);
    }

    @OnClick({R.id.ll_qq_login, R.id.ll_wx_login, R.id.ll_wb_login, R.id.ck_agree_login})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.ll_qq_login:
                if (!ckAgreeLogin.isChecked()) {
                    Toast.makeText(OneClickLoginActivity.this, "请同意并勾选用户协议与隐私政策", Toast.LENGTH_SHORT).show();
                    return;
                }
                break;
            case R.id.ll_wx_login:
                if (!ckAgreeLogin.isChecked()) {
                    Toast.makeText(OneClickLoginActivity.this, "请同意并勾选用户协议与隐私政策", Toast.LENGTH_SHORT).show();
                    return;
                }
                break;
            case R.id.ll_wb_login:
                if (!ckAgreeLogin.isChecked()) {
                    Toast.makeText(OneClickLoginActivity.this, "请同意并勾选用户协议与隐私政策", Toast.LENGTH_SHORT).show();
                    return;
                }
                break;

        }
    }
}
