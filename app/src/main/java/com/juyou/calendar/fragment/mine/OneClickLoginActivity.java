package com.juyou.calendar.fragment.mine;

import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.os.Build;
import android.os.Bundle;
import android.text.SpannableStringBuilder;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.gson.Gson;
import com.juyou.calendar.R;
import com.juyou.calendar.bean.LoginToApiBean;
import com.juyou.calendar.bean.LoginbackBean;
import com.juyou.calendar.bo.CurrentBean;
import com.juyou.calendar.bo.LoveChallengeBo;
import com.juyou.calendar.bo.NetResultCallBack;
import com.juyou.calendar.dialog.ShowAllSpan;
import com.juyou.calendar.eventbus.QQLoginEventBus;
import com.juyou.calendar.util.H5UrlMananger;
import com.juyou.calendar.util.WebUtils;
import com.manggeek.android.geek.utils.JSONUtil;
import com.tencent.connect.UnionInfo;
import com.tencent.connect.UserInfo;
import com.tencent.connect.auth.QQToken;
import com.tencent.connect.common.Constants;
import com.tencent.connect.share.QQShare;
import com.tencent.tauth.IUiListener;
import com.tencent.tauth.Tencent;
import com.tencent.tauth.UiError;
import com.zrq.spanbuilder.SpanBuilder;

import org.greenrobot.eventbus.EventBus;
import org.json.JSONObject;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class OneClickLoginActivity extends AppCompatActivity {
    private static final String TAG = "OneClickLoginActivity";
    private static final String APP_ID = "101980039";


    public static Tencent mTencent;
    //QQ包名
    private static final String PACKAGE_QQ = "com.tencent.mobileqq";
    @BindView(R.id.ll_title_left)
    LinearLayout llTitleLeft;
    @BindView(R.id.ll_wx_login)
    LinearLayout llWxLogin;
    @BindView(R.id.ll_qq_login)
    LinearLayout llQqLogin;
    @BindView(R.id.iv_wb_icon)
    ImageView ivWbIcon;
    @BindView(R.id.tv_wb)
    TextView tvWb;
    @BindView(R.id.ll_wb_login)
    LinearLayout llWbLogin;
    @BindView(R.id.ck_agree_login)
    CheckBox ckAgreeLogin;
    @BindView(R.id.tv_link_login)
    TextView tvLinkLogin;
    @BindView(R.id.ll_login_shake)
    LinearLayout llLoginShake;

    //登录参数
    String LoginOpen;
    String LoginToken;
    String LoginUser;
    private LoginToApiBean loginToApiBean;
    private LoginbackBean loginbackBean;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_one_click_login);


        loginToApiBean = new LoginToApiBean();
//        全屏展示
        try {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                Window window = this.getWindow();
                window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
                window.setStatusBarColor(this.getResources().getColor(R.color.textbarColor));

            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        Tencent.setIsPermissionGranted(true);
        ButterKnife.bind(this);
        mTencent = Tencent.createInstance(APP_ID, this.getApplicationContext());
        SpannableStringBuilder stringBuilder = new SpannableStringBuilder();
        stringBuilder.append(new SpanBuilder("登录即同意", 14, getResources().getColor(R.color.blackTrans)))
                .append(new SpanBuilder("《用户协议》", 14, getResources().getColor(R.color.main_but_down)).setClick(tvLinkLogin, new ShowAllSpan(this, widget -> WebUtils.loadTitleWeb(this, H5UrlMananger.USER_AGGREMENT_URL, "用户协议"))))
                .append(new SpanBuilder("和", 14, getResources().getColor(R.color.blackTrans)))
                .append(new SpanBuilder("《隐私政策》", 14, getResources().getColor(R.color.main_but_down)).setClick(tvLinkLogin, new ShowAllSpan(this, widget -> WebUtils.loadTitleWeb(this, H5UrlMananger.USER_PRIVACYPOLICY_URL, "隐私政策"))));
        tvLinkLogin.setText(stringBuilder);
    }


    @OnClick({R.id.ll_qq_login, R.id.ll_wx_login, R.id.ll_wb_login, R.id.ck_agree_login, R.id.ll_title_left})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.ll_qq_login:
                if (!ckAgreeLogin.isChecked()) {
                    Toast.makeText(OneClickLoginActivity.this, "请同意并勾选用户协议与隐私政策", Toast.LENGTH_SHORT).show();
                    initShake();
                    return;
                }

                if (!hasApp(PACKAGE_QQ)) {
                    Toast.makeText(OneClickLoginActivity.this, "未安装QQ应用",
                            Toast.LENGTH_SHORT).show();
                    return;
                }
//                //如果session无效，就开始做登录操作
                if (!mTencent.isSessionValid()) {
                    loginToApiBean.setWay("qq");
                    loginQQ();
                }
//                loginQQ();
                break;
            case R.id.ll_wx_login:
                if (!ckAgreeLogin.isChecked()) {
                    initShake();
                    Toast.makeText(OneClickLoginActivity.this, "请同意并勾选用户协议与隐私政策", Toast.LENGTH_SHORT).show();
                    return;
                }
                //注销登录
                mTencent.logout(this);

                break;
            case R.id.ll_wb_login:
                if (!ckAgreeLogin.isChecked()) {
                    Toast.makeText(OneClickLoginActivity.this, "请同意并勾选用户协议与隐私政策", Toast.LENGTH_SHORT).show();
                    initShake();
                    return;
                }
//                onClickShare();//分享

                break;
            case R.id.ll_title_left:
                finish();
                break;

        }
    }

    private void initShake() {
        Animation animation = AnimationUtils.loadAnimation(this, R.anim.translate_checkbox_shake);
        llLoginShake.startAnimation(animation);
    }

    private void onClickShare() {
        final Bundle params = new Bundle();
        params.putInt(QQShare.SHARE_TO_QQ_KEY_TYPE, QQShare.SHARE_TO_QQ_TYPE_DEFAULT);
        params.putString(QQShare.SHARE_TO_QQ_TITLE, "要分享的标题");
        params.putString(QQShare.SHARE_TO_QQ_SUMMARY, "要分享的摘要");
        params.putString(QQShare.SHARE_TO_QQ_TARGET_URL, "http://www.qq.com/news/1.html");
        params.putString(QQShare.SHARE_TO_QQ_IMAGE_URL, "http://imgcache.qq.com/qzone/space_item/pre/0/66768.gif");
        params.putString(QQShare.SHARE_TO_QQ_APP_NAME, "测试应用发货单款");
//        params.putInt(QQShare.SHARE_TO_QQ_EXT_INT,  "其他附加功能");
        mTencent.shareToQQ(OneClickLoginActivity.this, params, new BaseUiListener());
    }

    private class BaseUiListener implements IUiListener {
        //        @Override
//        public void onComplete(JSONObject response) {
//            mBaseMessageText.setText("onComplete:");
//            mMessageText.setText(response.toString());
//            doComplete(response);
//        }
        protected void doComplete(JSONObject values) {
        }

        @Override
        public void onComplete(Object o) {

        }

        @Override
        public void onError(UiError e) {

            Log.e("onError:", "code:" + e.errorCode + ", msg:"
                    + e.errorMessage + ", detail:" + e.errorDetail);
        }

        @Override
        public void onCancel() {
            Log.e("onError:", "onCancel");
        }

        @Override
        public void onWarning(int i) {

        }
    }

    /**
     * QQ登录
     */
    private IUiListener listener;

    private void getUnionId() {
        if (mTencent != null && mTencent.isSessionValid()) {
            IUiListener listener = new IUiListener() {
                @Override
                public void onError(UiError e) {
                    Toast.makeText(OneClickLoginActivity.this, "onError", Toast.LENGTH_LONG).show();
                }

                @Override
                public void onComplete(final Object response) {
                    if (response != null) {
                        JSONObject jsonObject = (JSONObject) response;
                        LoginOpen = jsonObject.toString();
                        loginToApiBean.setOpen(LoginOpen);
                        Log.e(TAG, "-------登录参数open-----" + jsonObject.toString());
                        Log.e(TAG, "-------登录参数LoginOpen----" + LoginOpen);
                        try {
                            String unionid = jsonObject.getString("unionid");
                            Log.e(TAG, "---cvcvxz ----------" + ((JSONObject) response).toString());
//                            Util.showResultDialog(OneClickLoginActivity.this, "unionid:\n" + unionid, "onComplete");
//                            Util.dismissDialog();
                        } catch (Exception e) {
                            Toast.makeText(OneClickLoginActivity.this, "no unionid", Toast.LENGTH_LONG).show();
                        }
                    } else {
                        Toast.makeText(OneClickLoginActivity.this, "no unionid", Toast.LENGTH_LONG).show();
                    }
                }

                @Override
                public void onCancel() {
                    Toast.makeText(OneClickLoginActivity.this, "onCancel", Toast.LENGTH_LONG).show();
                }

                @Override
                public void onWarning(int i) {

                }
            };
            UnionInfo unionInfo = new UnionInfo(this, mTencent.getQQToken());
            unionInfo.getUnionId(listener);
        } else {
            Toast.makeText(this, "please login frist!", Toast.LENGTH_LONG).show();
        }
    }

    private void loginQQ() {
        listener = new IUiListener() {
            @Override
            public void onComplete(Object object) {
                LoginToken = object.toString();
                loginToApiBean.setToken(LoginToken);
                Log.e(TAG, "登录成功:--参数token-- " + object.toString());
                Log.e(TAG, "登录成功:--参数LoginToken-- " + LoginToken);

                JSONObject jsonObject = (JSONObject) object;
                try {
                    //得到token、expires、openId等参数
                    String token = jsonObject.getString(Constants.PARAM_ACCESS_TOKEN);
                    String expires = jsonObject.getString(Constants.PARAM_EXPIRES_IN);
                    String openId = jsonObject.getString(Constants.PARAM_OPEN_ID);
                    Log.e(TAG, "jsonObject--------------" + jsonObject);
                    mTencent.setAccessToken(token, expires);
                    mTencent.setOpenId(openId);
                    Log.e(TAG, "token: " + token);
                    Log.e(TAG, "expires: " + expires);
                    Log.e(TAG, "openId: " + openId);
                    getUnionId();
                    //获取个人信息
                    getQQInfo();
                } catch (Exception e) {
                }
            }

            @Override
            public void onError(UiError uiError) {
                //登录失败
                Log.e(TAG, "登录失败" + uiError.errorDetail);
                Log.e(TAG, "登录失败" + uiError.errorMessage);
                Log.e(TAG, "登录失败" + uiError.errorCode + "");

            }

            @Override
            public void onCancel() {
                //登录取消
                Log.e(TAG, "登录取消");

            }

            @Override
            public void onWarning(int i) {

            }
        };
        //context上下文、第二个参数SCOPO 是一个String类型的字符串，表示一些权限
        //应用需要获得权限，由“,”分隔。例如：SCOPE = “get_user_info,add_t”；所有权限用“all”
        //第三个参数事件监听器
        mTencent.login(this, "all", listener);
        //注销登录
        //mTencent.logout(this);
    }

    String avatar;

    /**
     * 获取QQ个人信息
     */
    private void getQQInfo() {
        //获取基本信息
        QQToken qqToken = mTencent.getQQToken();
        UserInfo info = new UserInfo(this, qqToken);
        info.getUserInfo(new IUiListener() {
            @Override
            public void onComplete(Object object) {
//                try {
//
                    LoginUser = object.toString();
                    loginToApiBean.setUser(LoginUser);
//                    Log.e(TAG, "个人信息：登录参数----user-----" + object.toString());
//                    Log.e(TAG, "个人信息：登录参数----user---LoginUser--" + LoginUser);
//                    //头像
////                    avatar = ((JSONObject) object).getString("figureurl_2");
////                    String nickName = ((JSONObject) object).getString("nickname");
//
////                    if (!avatar.equals("")) {
////                        Glide.with(OneClickLoginActivity.this).load(avatar).into(ivWbIcon);
////
////                    }
////                    tvWb.setText(nickName);
//
////                    finish();
//
//
//                    goLogin();
//
//                    EventBus.getDefault().post(new QQLoginEventBus(avatar));
//                } catch (JSONException e) {
//                    e.printStackTrace();
//                }


                goLogin();

//                EventBus.getDefault().post(new QQLoginEventBus(avatar));
            }

            @Override
            public void onError(UiError uiError) {
            }

            @Override
            public void onCancel() {
            }

            @Override
            public void onWarning(int i) {

            }
        });
    }


    private void goLogin() {
        Log.e("测试登录接口", "参数测试登录接口----loginToApiBean--------------" + new Gson().toJson(loginToApiBean));
        LoveChallengeBo.Login_third(this, new Gson().toJson(loginToApiBean), new NetResultCallBack() {
            @Override
            public void onSuccess(int what, CurrentBean currentBean) {
                Log.e("测试登录接口", "--成功-----" + new Gson().toJson(currentBean));

                loginbackBean = JSONUtil.getObj(String.valueOf(currentBean.getData()), LoginbackBean.class);
//                Log.e("测试登录接口", "--成功-----" + new Gson().toJson(loginbackBean));
                Log.e("测试登录接口", "loginbackBean---------getAvatar-------" + loginbackBean.getAvatar());
                Log.e("测试登录接口", "loginbackBean----getNickname------------" + loginbackBean.getNickname());
//                Log.e("测试登录接口", "loginbackBean----------getToken------" + loginbackBean.getToken());
//                Log.e("测试登录接口", "loginbackBean-------getUuid---------" + loginbackBean.getUuid());
                try {
//                    URLDecoder.decode(loginbackBean.getNickname(), "utf-8");
                    EventBus.getDefault().post(new QQLoginEventBus(loginbackBean.getAvatar(), URLDecoder.decode(loginbackBean.getNickname(), "utf-8")));
                    finish();
                } catch (UnsupportedEncodingException e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void onFail(int what, CurrentBean currentBean) {
                Log.e("测试登录接口", "------失败-的信息----" + new Gson().toJson(currentBean));
                Log.e("测试登录接口", "------失败-----" + currentBean.getMsg());
            }
        });

    }

    /**
     * 回调必不可少,官方文档未说明
     */
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        Log.e("TAG", "回调必不可少,官方文档未说明");

        //腾讯QQ回调
        Tencent.onActivityResultData(requestCode, resultCode, data, listener);
        if (requestCode == Constants.REQUEST_API) {
            if (resultCode == Constants.REQUEST_LOGIN) {
                Tencent.handleResultData(data, listener);
            }
        }
    }


    //    /**
//     * true 安装了相应包名的app
//     */
    private boolean hasApp(String packName) {
//        Log.e("packageName", "packName----------------" + packName);
        boolean is = false;
        List<PackageInfo> packages = getPackageManager()
                .getInstalledPackages(0);
//        Log.e("packageName", "packageName------dfg----------" + packages.size());


        for (PackageInfo packageInfo : packages) {
            // 判断系统/非系统应用
            if ((packageInfo.applicationInfo.flags & ApplicationInfo.FLAG_SYSTEM) == 0) // 非系统应用
            {

                String packageName = packageInfo.packageName;
//            Log.e("packageName", "packageName------dfg----------" + packageName);

                if (packageName.equals(packName)) {
                    is = true;
                }
//                Log.e("packageName", "packName----------------" + packageName);
//                Log.e("packageName", "packName-------packName---------" + packName);
//                System.out.println("OneClickLoginActivity.getAppList, packageInfo=" + packageInfo.packageName);
            } else {
                // 系统应用
            }
        }

        return is;
    }


}
