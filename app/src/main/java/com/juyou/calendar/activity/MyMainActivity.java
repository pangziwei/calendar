package com.juyou.calendar.activity;

import android.Manifest;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.provider.Settings;
import android.text.TextUtils;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.google.gson.Gson;
import com.juyou.calendar.R;
import com.juyou.calendar.base.BaseActivity;
import com.juyou.calendar.base.BaseApplication;
import com.juyou.calendar.base.MyExFragment;
import com.juyou.calendar.bean.MyTestLoginBean;
import com.juyou.calendar.bean.VersionEntity;
import com.juyou.calendar.bo.CurrentBean;
import com.juyou.calendar.bo.JuYouBo;
import com.juyou.calendar.bo.NetResultCallBack;
import com.juyou.calendar.bo.NewResultCallBack;
import com.juyou.calendar.bo.StringCache;
import com.juyou.calendar.bo.UserBo;
import com.juyou.calendar.dialog.UpdataDialog;
import com.juyou.calendar.fragment.calendar.CalendarFragment;
import com.juyou.calendar.fragment.mine.MineFragment;
import com.juyou.calendar.fragment.stare.StareFragment;
import com.juyou.calendar.fragment.yellowcalendar.YellowCalendarFragment;
import com.juyou.calendar.mine.newlogin.NewLoginActivity;
import com.juyou.calendar.util.ConstantUtil;
import com.juyou.calendar.weather.WeatherActivity;
import com.juyou.calendar.weather.WeatherFragment;
import com.manggeek.android.geek.utils.JSONUtil;
import com.manggeek.android.geek.utils.PermissionUtils;
import com.manggeek.android.geek.utils.PrintUtil;
import com.tencent.mm.opensdk.constants.ConstantsAPI;
import com.tencent.mm.opensdk.modelbase.BaseReq;
import com.tencent.mm.opensdk.modelbase.BaseResp;
import com.tencent.mm.opensdk.openapi.IWXAPI;
import com.tencent.mm.opensdk.openapi.IWXAPIEventHandler;
import com.tencent.mm.opensdk.openapi.WXAPIFactory;
import com.tencent.tauth.IUiListener;
import com.tencent.tauth.Tencent;
import com.tencent.tauth.UiError;
import com.umeng.commonsdk.UMConfigure;
import com.umeng.socialize.PlatformConfig;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MyMainActivity extends BaseActivity implements IWXAPIEventHandler {
    @BindView(R.id.main_star)
    TextView mainStar;
    @BindView(R.id.main_weather)
    TextView mainWeather;
    private VersionEntity versionEntity;
    private UpdataDialog updataDialog;
    int i = 0;
    MineFragment mineFragment;
    CalendarFragment calendarFragment;
    StareFragment stareFragment;
    //    FortuneFragment fortuneFragment;
    WeatherFragment weatherFragment;
    YellowCalendarFragment yellowCalendarFragment;
    @BindView(R.id.frame_layout)
    FrameLayout frameLayout;
    @BindView(R.id.main_calendar)
    TextView mainCalendar;
    @BindView(R.id.main_yellow)
    TextView mainYellow;
    @BindView(R.id.main_my)
    TextView mainMine;
    @BindView(R.id.main_radioGroup)
    LinearLayout mainRadioGroup;
    public MyTestLoginBean myTestLoginBean;

    public static Tencent mTencent;//qq?????????????????????

    public static IWXAPI api;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_my_main);

        mTencent = Tencent.createInstance(ConstantUtil.QQ_APP_ID, this.getApplicationContext());

        try {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                Window window = this.getWindow();
                window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
                window.setStatusBarColor(this.getResources().getColor(R.color.textbarColor));

            }
        } catch (Exception e) {
            e.printStackTrace();
        }


        UMConfigure.init(this, ConstantUtil.UMENG_APP_KEY, "umeng", UMConfigure.DEVICE_TYPE_PHONE, "");//58edcfeb310c93091c000be2 5965ee00734be40b580001a0
//        PlatformConfig.setWeixin("wx27924c382baf48f5", "b702dba0329eee9852dca6d68eed7b79");
        catchException();


        ButterKnife.bind(this);
        //?????????qq?????????????????????
        Tencent.setIsPermissionGranted(true);

        // ??????WXAPIFactory???????????????IWXAPI?????????
        api = WXAPIFactory.createWXAPI(this, ConstantUtil.WX_APP_ID);
        // ????????????appId???????????????
        api.registerApp(ConstantUtil.WX_APP_ID);

        api.handleIntent(getIntent(), this);

        //?????????????????????????????????????????????????????????
        registerReceiver(new BroadcastReceiver() {
            @Override
            public void onReceive(Context context, Intent intent) {

                // ??????app???????????????
                api.registerApp(ConstantUtil.WX_APP_ID);
            }
        }, new IntentFilter(ConstantsAPI.ACTION_REFRESH_WXAPP));


        initView();
        updataDialog = new UpdataDialog(mActivity);
        Intent intert = getIntent();
        int id = intert.getIntExtra("grxx", -1);
        if (id > 0) {
            Log.e("?????????", "-----------" + id);
            if (id == 1) {
                resImg();
                setSelect(2);
                Log.e("?????????", "?????????fvdgdfgdgdfgd??????");
            }
        }
        update();
        Log.e("TAG", "-----------" + id);
        initLogin();

    }

    private void initLogin() {
        JuYouBo.TestLogin("admin", "123456", "10001", new NetResultCallBack() {
            @Override
            public void onSuccess(int what, CurrentBean currentBean) {
                Log.e("??????????????????", "--??????-----" + new Gson().toJson(currentBean));
                myTestLoginBean = JSONUtil.getObj(String.valueOf(currentBean.getData()), MyTestLoginBean.class);
            }

            @Override
            public void onFail(int what, CurrentBean currentBean) {
//                Log.e("??????????????????", "------??????-----" + currentBean.getMsg());
            }
        });
    }


    //??????????????????????????????????????????app?????????????????????????????????????????????????????????????????????????????????bug
    private void catchException() {
        Thread.setDefaultUncaughtExceptionHandler((t, e) ->
                Log.e("??????", "????????????------------" + Thread.currentThread().getName() +
                        "--------???:------" + e.getStackTrace()[0].getClassName())
        );
        //?????????????????????!
        new Handler(Looper.getMainLooper()).post(() -> {
            while (true) {
                try {
                    Looper.loop(); //????????????????????????,??????????????????????????????????????????!
//                    java.lang.RuntimeException: Unable to start activity ComponentInfo {com.ailaila.love/com.ailaila.love.wxapi.WXPayEntryActivity}: java.lang.IllegalStateException: Only fullscreen opaque activities can request orientation
                } catch (Exception e) {
                    Log.e("??????", "?????????????????????:-------------" + Thread.currentThread().getName() + "-----------???:------------" + e.getStackTrace()[0].getClassName());
                    e.printStackTrace();
                }
            }
        });
    }

    private void initView() {
        resImg();//???????????????
        setSelect(0);
        mainCalendar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                resImg();
                setSelect(0);
                //
            }
        });

        mainYellow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                resImg();
                setSelect(1);
            }
        });
        mainStar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                resImg();
                setSelect(2);
                //
            }
        });
        mainWeather.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                resImg();
//                setSelect(3);
                startActivity(new Intent(MyMainActivity.this, WeatherActivity.class));
                //
            }
        });
        mainMine.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Log.e("TAG", "??????-------" + (!StringCache.get("login").equals("true")));
                if (!StringCache.get("login").equals("true")) {
//                    startActivity(new Intent(MyMainActivity.this, LoginActivity.class));
                    startActivity(new Intent(MyMainActivity.this, NewLoginActivity.class));
                    return;
                } else {

                    resImg();
                    setSelect(4);
                    Log.e("?????????", "????????????vxzcb?????????");
                }
            }
        });
    }

    public void setDradle(TextView textView, Drawable drawable) {
        drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumWidth());
        textView.setCompoundDrawables(null, drawable, null, null);
    }

    //???????????????fragment
    private void hideFragment() {
        List<Fragment> fragments = getSupportFragmentManager().getFragments();
        if (fragments != null) {
            if (fragments.size() > 0) {
                for (int i = 0; i < fragments.size(); i++) {
                    getSupportFragmentManager().beginTransaction().hide(fragments.get(i)).commit();
                }
            }
        }
    }

    public void resImg() {
        mainCalendar.setTextColor(getResources().getColor(R.color.main_but));
        setDradle(mainCalendar, getResources().getDrawable(R.mipmap.ic_calendar));
        mainYellow.setTextColor(getResources().getColor(R.color.main_but));
        setDradle(mainYellow, getResources().getDrawable(R.mipmap.ic_yello));
        mainStar.setTextColor(getResources().getColor(R.color.main_but));
        setDradle(mainStar, getResources().getDrawable(R.mipmap.ic_star));
        mainWeather.setTextColor(getResources().getColor(R.color.main_but));
        setDradle(mainWeather, getResources().getDrawable(R.mipmap.ic_weather));
        mainMine.setTextColor(getResources().getColor(R.color.main_but));
        setDradle(mainMine, getResources().getDrawable(R.mipmap.ic_mine));
    }

    private void setSelect(int select) {
        this.i = select;
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction transaction = fm.beginTransaction();
        hideFragment(transaction);
        switch (i) {
            case 0:
//                showFragment(R.id.main_Business);
                calendarFragment = new CalendarFragment();
                addFragment(calendarFragment, R.id.frame_layout);
                mainCalendar.setTextColor(getResources().getColor(R.color.main_but_down));
                setDradle(mainCalendar, getResources().getDrawable(R.mipmap.ic_calendar_down));
                Log.e("????????????", "????????????---------");
                break;
            case 1:
//                showFragment(R.id.main_study);
                yellowCalendarFragment = new YellowCalendarFragment();
                addFragment(yellowCalendarFragment, R.id.frame_layout);
                mainYellow.setTextColor(getResources().getColor(R.color.main_but_down));
                setDradle(mainYellow, getResources().getDrawable(R.mipmap.ic_yello_down));
                Log.e("????????????", "????????????2222222222");
                break;
            case 2:
//                showFragment(R.id.main_my);
                stareFragment = new StareFragment();
                addFragment(stareFragment, R.id.frame_layout);
                mainStar.setTextColor(getResources().getColor(R.color.main_but_down));
                setDradle(mainStar, getResources().getDrawable(R.mipmap.ic_star_down));
                break;
            case 3:
//                showFragment(R.id.main_my);
//                fortuneFragment = new FortuneFragment();
//                addFragment(fortuneFragment, R.id.frame_layout);
                weatherFragment = new WeatherFragment();
                addFragment(weatherFragment, R.id.frame_layout);
                mainWeather.setTextColor(getResources().getColor(R.color.main_but_down));
                setDradle(mainWeather, getResources().getDrawable(R.mipmap.ic_weather_down));
                Log.e("????????????", "????????????3333333333333");
                break;
            case 4:
//                showFragment(R.id.main_my);
                mineFragment = new MineFragment();
                addFragment(mineFragment, R.id.frame_layout);
                mainMine.setTextColor(getResources().getColor(R.color.main_but_down));
                setDradle(mainMine, getResources().getDrawable(R.mipmap.ic_mine_down));
                Log.e("????????????", "????????????3333333333333");
                break;

        }
    }

    //???????????????fragment
    public void hideFragment(FragmentTransaction transaction) {
        if (calendarFragment != null) {
            transaction.hide(calendarFragment);
        }
        if (stareFragment != null) {
            transaction.hide(stareFragment);
        }
        if (weatherFragment != null) {
            transaction.hide(weatherFragment);
        }
//        if (fortuneFragment != null) {
//            transaction.hide(fortuneFragment);
//        }
        if (yellowCalendarFragment != null) {
            transaction.hide(yellowCalendarFragment);
        }
        if (mineFragment != null) {
            transaction.hide(mineFragment);
        }

    }

    //????????????activity??????????????????????????????????????????????????????android:launchMode=???singleTask??????android:launchMode=???signleTop?????????????????????????????????
    //https://www.cnblogs.com/ythzxxq/p/9978229.html
    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        setIntent(intent);
        api.handleIntent(intent, this);
        if (intent != null) {
            int selectIndex = intent.getIntExtra("SelectIndex", -1);
            Log.e("tag", "selectIndex---" + selectIndex);
            if (selectIndex == -1) {
                return;
            } else if (selectIndex == 1) {
                Log.e("tag", "-----1");
                this.resImg();
                this.setSelect(0);
            } else if (selectIndex == 2) {
                Log.e("tag", "-----2");
                this.resImg();
                this.setSelect(1);
            } else if (selectIndex == 3) {
                Log.e("tag", "-----3");
                this.resImg();
                this.setSelect(2);
                Log.e("?????????", "???????????????");
            } else if (selectIndex == 4) {
                Log.e("tag", "-----2");
                this.resImg();
                this.setSelect(4);
            }
        } else {
            return;
        }
    }

    @Override
    protected void onPause() {

        super.onPause();
//        int selectIndex = intent.getIntExtra("SelectIndex", -1);
//        Log.e("tag", "selectIndex---" + selectIndex);
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            exitBy2Click();      //????????????????????????
        }
        return false;
    }

    /**
     * ??????????????????
     */
    private static Boolean isExit = false;

    private void exitBy2Click() {
        Timer tExit = null;
        if (isExit == false) {
            isExit = true; // ????????????
            Toast.makeText(this, "????????????????????????", Toast.LENGTH_SHORT).show();
            tExit = new Timer();
            tExit.schedule(new TimerTask() {
                @Override
                public void run() {
                    isExit = false; // ????????????
                }
            }, 2000); // ??????2?????????????????????????????????????????????????????????????????????????????????

        } else {
            finish();
            System.exit(0);
        }
    }


    //??????fragment
    protected void addFragment(MyExFragment fragment, int contentId) {
        if (fragment != null) {
//            Log.e("tag", "????????????fragment" + fragment.getClass().getSimpleName());
            if (!fragment.isAdded()) {
                hideFragment();
                getSupportFragmentManager().beginTransaction()
//                ft.add(R.id.main_framlayout, fragment, tag);//?????????????????????tag

                        .add(contentId, fragment, fragment.getClass().getSimpleName())
                        .addToBackStack(fragment.getClass().getSimpleName())
                        .commit();
            } else {
                List<Fragment> fragments = getSupportFragmentManager().getFragments();
                for (int i = 0; i < fragments.size(); i++) {
                    if (fragments.get(i).getClass().getSimpleName().equals(fragment.getClass().getSimpleName())) {
                        getSupportFragmentManager().beginTransaction().show(fragments.get(i)).commit();
                    } else {
                        getSupportFragmentManager().beginTransaction().hide(fragments.get(i)).commit();
                    }
                }
            }
        }
    }

    private void update() {//
        UserBo.update(new NewResultCallBack() {
            @Override
            public void onResultSuccess(int what, CurrentBean currentBean) {
                Log.e("TAG", "??????app-----WelcomeActivity--------" + new Gson().toJson(currentBean));
                if (currentBean.getCode().equals("200")) {
                    versionEntity = JSONUtil.getObj(String.valueOf(currentBean.getData()), VersionEntity.class);
//                    Log.e("TAG", "??????app??????-----WelcomeActivity--------" + new Gson().toJson(versionEntity));

                    if (null != versionEntity) {
                        String version = versionEntity.getVersion();
                        if (!TextUtils.isEmpty(version)) {
                            try {
                                PackageInfo packageInfo = BaseApplication.getPackageInfo();
                                String name = packageInfo.versionName;
                                int versionCode = packageInfo.versionCode;
                                //???????????????
                                double versionDouble = Double.parseDouble(version.replace(".", ""));//??????????????????
                                //app??????
                                double nameDouble = Double.parseDouble(name.replace(".", ""));//

                                //????????????????????????????????????

//                                if (nameDouble < versionDouble) {
//                                    download();
//                                } else {
//
//                                }
                                if (versionCode < versionDouble) {
                                    download();
                                } else {

                                }
                            } catch (PackageManager.NameNotFoundException e) {
                                e.printStackTrace();

                            }
                        } else {

                        }
                    } else {

                    }
                } else {

                }
            }
        });
    }


    private void download() {
        boolean flag;
        if (Build.VERSION.SDK_INT >= 26) {
            flag = MyMainActivity.this.getPackageManager().canRequestPackageInstalls();               //????????????????????????????????????????????????
            if (!flag) {      //?????????
                startInstallPermissionSettingActivity();                                    //?????????????????????????????????
            } else {
                checkPermission();
            }
        } else {
            checkPermission();
        }
    }

    private void checkPermission() {
        PermissionUtils.getInstance().checkPermission(MyMainActivity.this, new PermissionUtils.onPermissiionSuccessListener() {
            @Override
            public void onPermissionSuccess(int requestCode, @NonNull List<String> grantPermissions) {
                showDownLoadDialog();
            }
        }, Manifest.permission.READ_EXTERNAL_STORAGE, Manifest.permission.WRITE_EXTERNAL_STORAGE);
    }

    //??????????????????????????????
    @RequiresApi(api = Build.VERSION_CODES.O)
    private void startInstallPermissionSettingActivity() {
        Uri packageURI = Uri.parse("package:" + MyMainActivity.this.getPackageName());
        //???????????????8.0???API
        Intent intent = new Intent(Settings.ACTION_MANAGE_UNKNOWN_APP_SOURCES, packageURI);
        startActivityForResult(intent, 10086);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        //????????????????????????????????????????????????
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 10086) {
            checkPermission();
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

    }

    //????????????
    private void showDownLoadDialog() {
        updataDialog.setVersionEntity(versionEntity);//????????????
        updataDialog.setCanceledOnTouchOutside(false);
        updataDialog.show();
    }

    @Override
    public void onReq(BaseReq baseReq) {
        Log.e("????????????", "??????????????????,??????????????????????????????????????????");

        switch (baseReq.getType()) {
            case ConstantsAPI.COMMAND_GETMESSAGE_FROM_WX:
                Log.e("????????????", "??????????????????,??????????????????????????????????????????");

                break;
            case ConstantsAPI.COMMAND_SHOWMESSAGE_FROM_WX:
                Log.e("????????????", "??????????????????,??????????????????????????????????????????");

                break;
            default:
                break;
        }
    }

    @Override
    public void onResp(BaseResp baseResp) {
        Log.e("????????????", "==========baseResp:" + JSONUtil.toString(baseResp) + "\n" + baseResp.errStr + "\n" + baseResp.getType() + "\n");

        switch (baseResp.errCode) {
            case BaseResp.ErrCode.ERR_COMM:
                // ??????????????????????????????????????????APPID???????????????APPID?????????????????????APPID??????????????????????????????????????????
                PrintUtil.toastMakeText("??????????????????,??????????????????????????????????????????");
                Log.e("????????????", "??????????????????,??????????????????????????????????????????");
                break;
            case BaseResp.ErrCode.ERR_USER_CANCEL:
                PrintUtil.toastMakeText("?????????????????????");
                Log.e("????????????", "?????????????????????");
                break;
            case BaseResp.ErrCode.ERR_OK:
                PrintUtil.toastMakeText("??????????????????");
                Log.e("????????????", "??????????????????");
                break;
            case BaseResp.ErrCode.ERR_AUTH_DENIED:
                PrintUtil.toastMakeText("??????????????????");
                Log.e("????????????", "??????????????????");
                break;
            case BaseResp.ErrCode.ERR_SENT_FAILED:
                PrintUtil.toastMakeText("??????????????????");
                Log.e("????????????", "??????????????????");
                break;
            case BaseResp.ErrCode.ERR_UNSUPPORT:
                Log.e("????????????", "????????????");
                PrintUtil.toastMakeText("????????????");
                break;
        }
        finish();
    }


    public static class BaseUiListener implements IUiListener {
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

}
