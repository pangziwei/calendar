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
import com.juyou.calendar.activity.MyMainActivity;
import com.juyou.calendar.bean.LoginToApiBean;
import com.juyou.calendar.bean.LoginbackBean;
import com.juyou.calendar.bo.CurrentBean;
import com.juyou.calendar.bo.JuYouBo;
import com.juyou.calendar.bo.NetResultCallBack;
import com.juyou.calendar.dialog.ShowAllSpan;
import com.juyou.calendar.eventbus.QQLoginEventBus;
import com.juyou.calendar.util.ConstantUtil;
import com.juyou.calendar.util.H5UrlMananger;
import com.juyou.calendar.util.WebUtils;
import com.manggeek.android.geek.utils.JSONUtil;
import com.tencent.connect.UnionInfo;
import com.tencent.connect.UserInfo;
import com.tencent.connect.auth.QQToken;
import com.tencent.connect.common.Constants;
import com.tencent.connect.share.QQShare;
import com.tencent.mm.opensdk.modelmsg.SendMessageToWX;
import com.tencent.tauth.IUiListener;
import com.tencent.tauth.Tencent;
import com.tencent.tauth.UiError;
import com.umeng.socialize.bean.SHARE_MEDIA;
import com.zrq.spanbuilder.SpanBuilder;

import org.greenrobot.eventbus.EventBus;
import org.json.JSONObject;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

import static com.juyou.calendar.activity.MyMainActivity.api;
import static com.juyou.calendar.activity.MyMainActivity.mTencent;

public class OneClickLoginActivity extends AppCompatActivity {
    private static final String TAG = "OneClickLoginActivity";


    //    public static Tencent mTencent;
    //QQ??????
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

    //????????????
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
//        ????????????
        try {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                Window window = this.getWindow();
                window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
                window.setStatusBarColor(this.getResources().getColor(R.color.textbarColor));

            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        ButterKnife.bind(this);
//        mTencent = Tencent.createInstance(ConstantUtil.QQ_APP_ID, this.getApplicationContext());
        SpannableStringBuilder stringBuilder = new SpannableStringBuilder();
        stringBuilder.append(new SpanBuilder("???????????????", 14, getResources().getColor(R.color.blackTrans)))
                .append(new SpanBuilder("??????????????????", 14, getResources().getColor(R.color.main_but_down)).setClick(tvLinkLogin, new ShowAllSpan(this, widget -> WebUtils.loadTitleWeb(this, H5UrlMananger.USER_AGGREMENT_URL, "????????????"))))
                .append(new SpanBuilder("???", 14, getResources().getColor(R.color.blackTrans)))
                .append(new SpanBuilder("??????????????????", 14, getResources().getColor(R.color.main_but_down)).setClick(tvLinkLogin, new ShowAllSpan(this, widget -> WebUtils.loadTitleWeb(this, H5UrlMananger.USER_PRIVACYPOLICY_URL, "????????????"))));
        tvLinkLogin.setText(stringBuilder);
    }


    @OnClick({R.id.ll_qq_login, R.id.ll_wx_login, R.id.ll_wb_login, R.id.ck_agree_login, R.id.ll_title_left})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.ll_qq_login:
                if (!ckAgreeLogin.isChecked()) {
                    Toast.makeText(OneClickLoginActivity.this, "?????????????????????????????????????????????", Toast.LENGTH_SHORT).show();
                    initShake();
                    return;
                }

                if (!hasApp(PACKAGE_QQ)) {
                    Toast.makeText(OneClickLoginActivity.this, "?????????QQ??????",
                            Toast.LENGTH_SHORT).show();
                    return;
                }
//                //??????session?????????????????????????????????
                if (!mTencent.isSessionValid()) {
                    loginToApiBean.setWay("qq");
                    loginQQ();
                }
//                loginQQ();
                break;
            case R.id.ll_wx_login:
                if (!ckAgreeLogin.isChecked()) {
                    initShake();
                    Toast.makeText(OneClickLoginActivity.this, "?????????????????????????????????????????????", Toast.LENGTH_SHORT).show();
                    return;
                }
                //????????????
//                mTencent.logout(this);
//                Final SendAuth.SendMessageToWX.Req req = new SendAuth.Req();
//                req.scope = "snsapi_userinfo";
//                req.state = "wechat_sdk_demo_test";
//                api.sendReq(req);

                break;
            case R.id.ll_wb_login:
                if (!ckAgreeLogin.isChecked()) {
                    Toast.makeText(OneClickLoginActivity.this, "?????????????????????????????????????????????", Toast.LENGTH_SHORT).show();
                    initShake();
                    return;
                }

                onClickShare();
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

    private void onClickShareQQ() {
        final Bundle params = new Bundle();
        params.putInt(QQShare.SHARE_TO_QQ_KEY_TYPE, QQShare.SHARE_TO_QQ_TYPE_DEFAULT);
        params.putString(QQShare.SHARE_TO_QQ_TITLE, "??????????????????");
        params.putString(QQShare.SHARE_TO_QQ_SUMMARY, "??????????????????");
        params.putString(QQShare.SHARE_TO_QQ_TARGET_URL, "http://www.qq.com/news/1.html");
        params.putString(QQShare.SHARE_TO_QQ_IMAGE_URL, "http://imgcache.qq.com/qzone/space_item/pre/0/66768.gif");
        params.putString(QQShare.SHARE_TO_QQ_APP_NAME, "????????????????????????");
//        params.putInt(QQShare.SHARE_TO_QQ_EXT_INT,  "??????????????????");
        mTencent.shareToQQ(OneClickLoginActivity.this, params, new MyMainActivity.BaseUiListener());
    }


    /**
     * QQ??????
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
                        Log.e(TAG, "-------????????????open-----" + jsonObject.toString());
                        Log.e(TAG, "-------????????????LoginOpen----" + LoginOpen);
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
                Log.e(TAG, "????????????:--??????token-- " + object.toString());
                Log.e(TAG, "????????????:--??????LoginToken-- " + LoginToken);

                JSONObject jsonObject = (JSONObject) object;
                try {
                    //??????token???expires???openId?????????
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
                    //??????????????????
                    getQQInfo();
                } catch (Exception e) {
                }
            }

            @Override
            public void onError(UiError uiError) {
                //????????????
                Log.e(TAG, "????????????" + uiError.errorDetail);
                Log.e(TAG, "????????????" + uiError.errorMessage);
                Log.e(TAG, "????????????" + uiError.errorCode + "");

            }

            @Override
            public void onCancel() {
                //????????????
                Log.e(TAG, "????????????");

            }

            @Override
            public void onWarning(int i) {

            }
        };
        //context???????????????????????????SCOPO ?????????String???????????????????????????????????????
        //?????????????????????????????????,?????????????????????SCOPE = ???get_user_info,add_t????????????????????????all???
        //??????????????????????????????
        mTencent.login(this, "all", listener);
        //????????????
        //mTencent.logout(this);
    }

    String avatar;

    /**
     * ??????QQ????????????
     */
    private void getQQInfo() {
        //??????????????????
        QQToken qqToken = mTencent.getQQToken();
        UserInfo info = new UserInfo(this, qqToken);
        info.getUserInfo(new IUiListener() {
            @Override
            public void onComplete(Object object) {
//                try {
//
                LoginUser = object.toString();
                loginToApiBean.setUser(LoginUser);
//                    Log.e(TAG, "???????????????????????????----user-----" + object.toString());
//                    Log.e(TAG, "???????????????????????????----user---LoginUser--" + LoginUser);
//                    //??????
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
        Log.e("??????????????????", "????????????????????????----loginToApiBean--------------" + new Gson().toJson(loginToApiBean));
        JuYouBo.Login_third(this, new Gson().toJson(loginToApiBean), new NetResultCallBack() {
            @Override
            public void onSuccess(int what, CurrentBean currentBean) {
                Log.e("??????????????????", "--??????-----" + new Gson().toJson(currentBean));

                loginbackBean = JSONUtil.getObj(String.valueOf(currentBean.getData()), LoginbackBean.class);
//                Log.e("??????????????????", "--??????-----" + new Gson().toJson(loginbackBean));
                Log.e("??????????????????", "loginbackBean---------getAvatar-------" + loginbackBean.getAvatar());
                Log.e("??????????????????", "loginbackBean----getNickname------------" + loginbackBean.getNickname());
//                Log.e("??????????????????", "loginbackBean----------getToken------" + loginbackBean.getToken());
//                Log.e("??????????????????", "loginbackBean-------getUuid---------" + loginbackBean.getUuid());
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
                Log.e("??????????????????", "------??????-?????????----" + new Gson().toJson(currentBean));
                Log.e("??????????????????", "------??????-----" + currentBean.getMsg());
            }
        });

    }

    /**
     * ??????????????????,?????????????????????
     */
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        Log.e("TAG", "??????????????????,?????????????????????");

        //??????QQ??????
        Tencent.onActivityResultData(requestCode, resultCode, data, listener);
        if (requestCode == Constants.REQUEST_API) {
            if (resultCode == Constants.REQUEST_LOGIN) {
                Tencent.handleResultData(data, listener);
            }
        }
    }


    //    /**
//     * true ????????????????????????app
//     */
    private boolean hasApp(String packName) {
//        Log.e("packageName", "packName----------------" + packName);
        boolean is = false;
        List<PackageInfo> packages = getPackageManager()
                .getInstalledPackages(0);
//        Log.e("packageName", "packageName------dfg----------" + packages.size());


        for (PackageInfo packageInfo : packages) {
            // ????????????/???????????????
            if ((packageInfo.applicationInfo.flags & ApplicationInfo.FLAG_SYSTEM) == 0) // ???????????????
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
                // ????????????
            }
        }

        return is;
    }


    //    ????????????????????????????????????????????????????????????
    private void onClickShare() {
        final Bundle params = new Bundle();
        params.putInt(QQShare.SHARE_TO_QQ_KEY_TYPE, QQShare.SHARE_TO_QQ_TYPE_DEFAULT);
        params.putString(QQShare.SHARE_TO_QQ_TITLE, "??????????????????");
        params.putString(QQShare.SHARE_TO_QQ_SUMMARY, "??????????????????");
        params.putString(QQShare.SHARE_TO_QQ_TARGET_URL, "http://www.qq.com/news/1.html");
        params.putString(QQShare.SHARE_TO_QQ_IMAGE_URL, "http://imgcache.qq.com/qzone/space_item/pre/0/66768.gif");
        params.putString(QQShare.SHARE_TO_QQ_APP_NAME, "????????????222222");
        mTencent.shareToQQ(OneClickLoginActivity.this, params, new MyMainActivity.BaseUiListener());
    }


}
