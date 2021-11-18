package com.juyou.calendar.fragment;

import android.Manifest;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;

import com.juyou.calendar.R;
import com.juyou.calendar.base.MyExFragment;
import com.juyou.calendar.mine.about.AboutActivity;
import com.manggeek.android.geek.view.CircleImageView;

import butterknife.BindView;
import butterknife.OnClick;
import pub.devrel.easypermissions.AppSettingsDialog;
import pub.devrel.easypermissions.EasyPermissions;

import static android.app.Activity.RESULT_OK;

public class MineFragment extends MyExFragment {
    public static final String TAG = "MineFragment";

    @BindView(R.id.cv_mine_head)
    CircleImageView cvMineHead;
    @BindView(R.id.tv_mine_login)
    TextView tvMineLogin;
    @BindView(R.id.ll_mine_star_query)
    LinearLayout llMineStarQuery;
    @BindView(R.id.ll_mine_jiri_query)
    LinearLayout llMineJiriQuery;
    @BindView(R.id.ll_mine_fortune_query)
    LinearLayout llMineFortuneQuery;
    @BindView(R.id.ll_mine_yellow_query)
    LinearLayout llMineYellowQuery;
    @BindView(R.id.ll_mine_jieqian)
    ImageView llMineJieqian;
    @BindView(R.id.ll_mine_dream)
    LinearLayout llMineDream;
    @BindView(R.id.ll_mine_day_weather)
    LinearLayout llMineDayWeather;
    @BindView(R.id.ll_mine_name_test)
    LinearLayout llMineNameTest;
    @BindView(R.id.ll_mine_star)
    LinearLayout llMineStar;
    @BindView(R.id.btn_mine_about)
    TextView btnMineAbout;


    private AlertDialog.Builder builder;
    private AlertDialog alertDialog;


    @Override
    public void loadData() {
    }

    @Override
    public int getLayoutId() {
        return R.layout.fragment_mine;
    }

    @Override
    protected void initView(View view, Bundle savedInstanceState) {

    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
    }


    @OnClick({R.id.cv_mine_head, R.id.tv_mine_login, R.id.ll_mine_star_query, R.id.ll_mine_jiri_query, R.id.ll_mine_fortune_query, R.id.ll_mine_yellow_query, R.id.ll_mine_jieqian, R.id.ll_mine_dream, R.id.ll_mine_day_weather, R.id.ll_mine_name_test, R.id.ll_mine_star, R.id.btn_mine_about})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.cv_mine_head:
                onclickBtn();
                break;
            case R.id.tv_mine_login:
                break;
            case R.id.ll_mine_star_query:
                break;
            case R.id.ll_mine_jiri_query:
                break;
            case R.id.ll_mine_fortune_query:
                break;
            case R.id.ll_mine_yellow_query:
                break;
            case R.id.ll_mine_jieqian:
                break;
            case R.id.ll_mine_dream:
                break;
            case R.id.ll_mine_day_weather:
                break;
            case R.id.ll_mine_name_test:
                break;
            case R.id.ll_mine_star:
                break;
            case R.id.btn_mine_about:
                startActivity(new Intent(getActivity(), AboutActivity.class));
                break;
        }
    }

    private AppSettingsDialog.Builder appSettingsDialog;

    public void onclickBtn() {
        alertDialog = new AlertDialog.Builder(getActivity()).setMessage("您拒绝储存空间的权限").setPositiveButton("设置权限", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
                appSettingsDialog = new AppSettingsDialog.Builder(getActivity());
                appSettingsDialog.setRationale("请在设置中打开应用拍照,储存空间权限")
                        .setTitle("应用权限")
                        .setPositiveButton("打开权限")
                        .build().show();
            }
        }).setNegativeButton("取消", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        }).create();
        checkPerm();
    }

    static final String[] PERMISSIONS = new String[]{
            Manifest.permission.READ_EXTERNAL_STORAGE,
            Manifest.permission.WRITE_EXTERNAL_STORAGE,
            Manifest.permission.CAMERA
    };
    private static final int RC_CAMERA_AND_LOCATION = 100;

    private void checkPerm() {
        if (EasyPermissions.hasPermissions(getActivity(), PERMISSIONS)) {
            /**此处为在安装程序时直接授权，直接调用*/
            Log.e("tag", "此处为在安装程序时直接授权，直接调用");
            View view1 = LayoutInflater.from(getActivity()).inflate(R.layout.activity_change_headimg_dialog, null);
            builder = new AlertDialog.Builder(getActivity());
            alertDialog = builder.create();
            alertDialog.setView(view1);
            alertDialog.show();
            alertDialog.setCancelable(true);
            LinearLayout llCancle = (LinearLayout) view1.findViewById(R.id.ll_cancle);
            llCancle.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    alertDialog.dismiss();
                }
            });
            setOnlistenter(view1);
        } else {
            Log.e("tag", "需要打开应用拍照,储存空间权限");
            EasyPermissions.requestPermissions(this, "需要打开应用拍照,储存空间权限", RC_CAMERA_AND_LOCATION, PERMISSIONS);
        }
    }

    private final int IMAGE_OPEN = 1; //打开图片标记
    private final int REQUEST_CODE_CAMERA = 2;

    private void setOnlistenter(View view) {
        LinearLayout llPhoto = view.findViewById(R.id.ll_Photograph);
        LinearLayout llAmtub = view.findViewById(R.id.ll_Album);
        llAmtub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_PICK,
                        MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                startActivityForResult(intent, IMAGE_OPEN);
                alertDialog.dismiss();
            }
        });
        llPhoto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                startActivityForResult(intent, REQUEST_CODE_CAMERA);
                alertDialog.dismiss();
            }
        });
    }

    private final static int REQUESTCODE = 10; // 返回的结果码

    @Override
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == REQUESTCODE) {

        } else if (resultCode == RESULT_OK && requestCode == IMAGE_OPEN) {
//            imgPaht = ChangeHeadImg.getImgPaht(data.getData(), getActivity(), cvMineHead);
            Log.e("data", "IMAGE_OPEN------相册--------" + data.getData().toString());
            cvMineHead.setImageURI(data.getData());//展示照片
        } else if (resultCode == RESULT_OK && requestCode == REQUEST_CODE_CAMERA) {//这个是拍照
            Bundle bundle = data.getExtras();
            Bitmap bitmap = (Bitmap) bundle.get("data");
            Log.e("data", "REQUEST_CODE_CAMERA-------拍照-------" + data.getData().toString());
            cvMineHead.setImageURI(data.getData());//展示照片

//            imgPaht = ChangeHeadImg.getImageFormCamera(bitmap, getActivity());
        } else if (requestCode == AppSettingsDialog.DEFAULT_SETTINGS_REQ_CODE) {
            if (!EasyPermissions.hasPermissions(getActivity(), PERMISSIONS)) {
                Toast.makeText(getActivity(), "拍照,储存空间权限未打开", Toast.LENGTH_LONG).show();
            } else {
                /**此处在跳转到权限界面 打开权限之后返回本程序调用*/
                Toast.makeText(getActivity(), "权限获取成功", Toast.LENGTH_LONG).show();
            }
        }

    }

}
