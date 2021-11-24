package com.juyou.calendar.mine;

import android.Manifest;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.icu.text.UnicodeSetSpanner;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.juyou.calendar.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import pub.devrel.easypermissions.AppSettingsDialog;
import pub.devrel.easypermissions.EasyPermissions;

public class FeedbackActivity extends AppCompatActivity {

    @BindView(R.id.iv_title_right)
    ImageView ivTitleRight;
    @BindView(R.id.tv_title_left)
    TextView tvTitleLeft;
    @BindView(R.id.ll_title_left)
    LinearLayout ll_title_left;
    @BindView(R.id.tv_lef_back)
    ImageView tvLefBack;
    @BindView(R.id.view_actionBar_title)
    TextView viewActionBarTitle;
    @BindView(R.id.et_feedbavk_describe)
    EditText etFeedbavkDescribe;
    @BindView(R.id.et_feedback_contact)
    EditText etFeedbackContact;
    @BindView(R.id.iv_feedback_photo)
    ImageView ivFeedbackPhoto;
    @BindView(R.id.btn_feedback_sub)
    TextView btnFeedbackSub;


    private AlertDialog.Builder builder;
    private AlertDialog alertDialog;
    private AppSettingsDialog.Builder appSettingsDialog;
    static final String[] PERMISSIONS = new String[]{
            Manifest.permission.READ_EXTERNAL_STORAGE,
            Manifest.permission.WRITE_EXTERNAL_STORAGE,
            Manifest.permission.CAMERA};
    private static final int RC_CAMERA_AND_LOCATION = 100;
    private final static int REQUESTCODE = 10; // 返回的结果码
    private final int IMAGE_OPEN = 1; //打开图片标记
    private final int REQUEST_CODE_CAMERA = 2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_feedback);
        ButterKnife.bind(this);
        initView();
    }

    private void initView() {
        viewActionBarTitle.setText("反馈信息");
        viewActionBarTitle.setTextColor(getResources().getColor(R.color.white));
        ivTitleRight.setVisibility(View.GONE);
        tvLefBack.setVisibility(View.VISIBLE);
        tvTitleLeft.setVisibility(View.GONE);
    }

    @OnClick({R.id.ll_title_left, R.id.iv_feedback_photo, R.id.btn_feedback_sub})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.ll_title_left:
                finish();
                break;
            case R.id.iv_feedback_photo:
                onclickBtn();
                break;
            case R.id.btn_feedback_sub:
                Toast.makeText(FeedbackActivity.this, "提交反馈", Toast.LENGTH_SHORT).show();
                break;
        }
    }

    public void onclickBtn() {
        alertDialog = new AlertDialog.Builder(FeedbackActivity.this).setMessage("您拒绝储存空间的权限").setPositiveButton("设置权限", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
                appSettingsDialog = new AppSettingsDialog.Builder(FeedbackActivity.this);
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

    private void checkPerm() {
        if (EasyPermissions.hasPermissions(FeedbackActivity.this, PERMISSIONS)) {
            /**此处为在安装程序时直接授权，直接调用*/
            Log.e("tag", "此处为在安装程序时直接授权，直接调用");
            View view1 = LayoutInflater.from(FeedbackActivity.this).inflate(R.layout.activity_change_headimg_dialog, null);
            builder = new AlertDialog.Builder(FeedbackActivity.this);
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

    @Override
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == REQUESTCODE) {

        } else if (resultCode == RESULT_OK && requestCode == IMAGE_OPEN) {
//            imgPaht = ChangeHeadImg.getImgPaht(data.getData(), getActivity(), cvMineHead);
            Log.e("data", "IMAGE_OPEN------相册--------" + data.getData().toString());
            ivFeedbackPhoto.setImageURI(data.getData());//展示照片
        } else if (resultCode == RESULT_OK && requestCode == REQUEST_CODE_CAMERA) {//这个是拍照
            Bundle bundle = data.getExtras();
            Bitmap bitmap = (Bitmap) bundle.get("data");
            Log.e("data", "REQUEST_CODE_CAMERA-------拍照-------" + data.getData().toString());
            ivFeedbackPhoto.setImageURI(data.getData());//展示照片

//            imgPaht = ChangeHeadImg.getImageFormCamera(bitmap, getActivity());
        } else if (requestCode == AppSettingsDialog.DEFAULT_SETTINGS_REQ_CODE) {
            if (!EasyPermissions.hasPermissions(FeedbackActivity.this, PERMISSIONS)) {
                Toast.makeText(FeedbackActivity.this, "拍照,储存空间权限未打开", Toast.LENGTH_LONG).show();
            } else {
                /**此处在跳转到权限界面 打开权限之后返回本程序调用*/
                Toast.makeText(FeedbackActivity.this, "权限获取成功", Toast.LENGTH_LONG).show();
            }
        }

    }

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
}
