package com.juyou.calendar.dialog;

import android.app.ActionBar;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.os.Handler;
import android.text.Html;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;


import com.juyou.calendar.R;
import com.juyou.calendar.base.BaseApplication;
import com.juyou.calendar.bean.VersionEntity;
import com.juyou.calendar.util.AppUtils;
import com.manggeek.android.geek.GeekActivity;
import com.manggeek.android.geek.GeekDialog;
import com.manggeek.android.geek.utils.JSONUtil;
import com.manggeek.android.geek.utils.PrintUtil;
import com.manggeek.android.geek.view.FindViewById;
import com.yanzhenjie.nohttp.Headers;
import com.yanzhenjie.nohttp.NoHttp;
import com.yanzhenjie.nohttp.RequestMethod;
import com.yanzhenjie.nohttp.download.DownloadListener;
import com.yanzhenjie.nohttp.download.DownloadQueue;
import com.yanzhenjie.nohttp.download.DownloadRequest;

import java.io.File;

import androidx.core.content.FileProvider;

import static com.juyou.calendar.upapp.UpdateService.FILEPATH;


public class UpdataDialog extends GeekDialog {
    private @FindViewById(id = R.id.content)
    TextView contentTv;
    private @FindViewById(id = R.id.tv_new_version)
    TextView tvNewVersion;
    private @FindViewById(id = R.id.cancel)
    View cancelTv;
    private @FindViewById(id = R.id.submit)
    View submitTv;
    private VersionEntity versionEntity;
    private @FindViewById(id = R.id.progress_bar)
    ProgressBar progressBar;

    private @FindViewById(id = R.id.progress)
    TextView progressTv;
    private @FindViewById(id = R.id.msg)
    TextView msg;

//    public void setVersionEntity(VersionEntity versionEntity) {
//        this.versionEntity = versionEntity;
//        if (null != versionEntity) {
////            contentTv.setText(versionEntity.getContent());//版本更新说明
//            String HTML_TEXT = versionEntity.getContent();
//            contentTv.setText(Html.fromHtml(HTML_TEXT));
//            tvNewVersion.setText(versionEntity.getVersion());
//            try {
//                PackageInfo packageInfo = BaseApplication.getPackageInfo();
//                String name = packageInfo.versionName;
//                Log.e("TAG", "UpdataDialog--------versionEntity.getMinVersion()--------------" + versionEntity.getMinVersion());
//                if (versionEntity.getMinVersion().equals("")) {
//                    cancelTv.setVisibility(View.VISIBLE);//隐藏按钮取消按钮，只能强制更新
//                } else {
//                    //服务器版本--最小版本
//                    double versionMinDouble = Double.parseDouble(versionEntity.getMinVersion().replace(".", ""));
//                    //服务器版本
//                    double versionDouble = Double.parseDouble(versionEntity.getVersion().replace(".", ""));
//                    //app版本
//                    double nameDouble = Double.parseDouble(name.replace(".", ""));//比这个大小
//                    Log.e("TAG", "UpdataDialog--------服务器版本------------" + versionDouble);
//                    Log.e("TAG", "UpdataDialog--------服务器版本----最小版本--------" + versionMinDouble);
//                    Log.e("TAG", "UpdataDialog--------app版本------------" + nameDouble);
//                    if (nameDouble < versionMinDouble) {//强更
////                    cancelTv.setVisibility(View.VISIBLE);//隐藏按钮取消按钮，只能强制更新
//                        cancelTv.setVisibility(View.GONE);
//                        Log.e("TAG", "UpdataDialog--------需要put更新");
//                    } else if (nameDouble < versionDouble) {
//                        cancelTv.setVisibility(View.VISIBLE);//隐藏按钮取消按钮，只能强制更新
//                        Log.e("TAG", "UpdataDialog--------不需要put更新");
//
//                    }
//
////                    msg.setText("服务器版本--最小版本----->"+versionMinDouble+"<-------服务器版本------->"+versionDouble+"<------app版本----->"+nameDouble+"<------服务器返回的数据------>"+new Gson().toJson(versionEntity));
////                    {
////                        cancelTv.setVisibility(View.VISIBLE);//隐藏按钮取消按钮，只能强制更新
////                    }
//                }
//
//            } catch (PackageManager.NameNotFoundException e) {
//                e.printStackTrace();
//            }
//
//
////            if (0 == versionEntity.getType()) {//是否强制弹窗升级 1是 0普通
////                cancelTv.setVisibility(View.VISIBLE);//隐藏按钮取消按钮，只能强制更新
////            }
//
//
//        }
//    }


    public void setVersionEntity(VersionEntity versionEntity) {
        this.versionEntity = versionEntity;
        if (null != versionEntity) {
            contentTv.setText(versionEntity.getContent());//版本更新说明
            String HTML_TEXT = versionEntity.getContent();
            contentTv.setText(Html.fromHtml(HTML_TEXT));
//            tvNewVersion.setText(versionEntity.getVersion());
            PackageInfo packageInfo = null;
            try {
                packageInfo = BaseApplication.getPackageInfo();
                String name = packageInfo.versionName;

                int nameDouble = (int) Double.parseDouble(name.replace(".", ""));//
//                int i = Integer.parseInt(name);//默认十进制
                int c = nameDouble + 1;
                Log.e("appVersionCode", "appVersionCode---fgfff-----" + c);
//                int b = (int) Double.parseDouble(name.replace("", "."));//
//                Log.e("appVersionCode", "appVersionCode---fgfff---bb--" + b);

                String bb = Integer.toString(c);
                Log.e("appVersionCode", "appVersionCode---fgfff---b-" +bb);
                for (int i = 0; i < bb.length(); i++) {
                    char ch = bb.charAt(i);
                    Log.e("appVersionCode", "appVersionCode---fgfff--- ch-" + ch);

                }




                tvNewVersion.setText(name);
            } catch (PackageManager.NameNotFoundException e) {
                e.printStackTrace();
            }


            if (0 == versionEntity.getType()) {
                cancelTv.setVisibility(View.VISIBLE);
            }
        }
    }
//


    @Override
    public void onBackPressed() {
        return;
    }

    /**
     * 弹框默认浮层
     */
    public UpdataDialog(GeekActivity activity) {
        super(activity);
        setContentView(R.layout.dialog_up_app, ActionBar.LayoutParams.MATCH_PARENT, ActionBar.LayoutParams.WRAP_CONTENT, false);
        setGravity(Gravity.CENTER);
        setPadding();

        setCanceledOnTouchOutside(false);

        submitTv.setOnClickListener(view -> {
            download();//内部下载
            Log.e("UpdataDialog", "versionEntity.getLink()-------------" + versionEntity.getLink());
//            WebUtils.loadWeb(mActivity, versionEntity.getLink());
//            submitTv.setEnabled(false);
        });
        cancelTv.setOnClickListener(v -> {
            if (cancelUpdateListener != null) {
                cancelUpdateListener.cancel();
            }
            dismiss();
        });
    }


    public interface CancelUpdateListener {
        void cancel();
    }

    private CancelUpdateListener cancelUpdateListener;

    public void setCancelUpdateListener(CancelUpdateListener cancelUpdateListener) {
        this.cancelUpdateListener = cancelUpdateListener;
    }

    private void download() {
        final File file = new File(FILEPATH);
        if (!file.exists()) {
            file.mkdirs();
        }
        DownloadQueue downloadQueue = NoHttp.newDownloadQueue();
        DownloadRequest downloadRequest = NoHttp.createDownloadRequest(versionEntity.getLink(), RequestMethod.GET, FILEPATH, "EternalLove.apk", false, true);
//        "https://download.ailaila.com/apk/love_1.0.6.apk"
//        DownloadRequest downloadRequest = NoHttp.createDownloadRequest("https://download.ailaila.com/apk/love_1.0.10.apk", RequestMethod.GET, FILEPATH, "Pzwlove.apk", false, true);
        downloadQueue.add(0, downloadRequest, new DownloadListener() {
            @Override
            public void onDownloadError(int what, Exception exception) {
//                PrintUtil.log("http---->exception:" + JSONUtil.toString(exception));
//                Log.e("UpdataDialog", "http---->exception:" + JSONUtil.toString(exception));
//                Log.e("UpdataDialog", "http---->exception:" + new Gson().toJson(exception));
                Log.e("更新app", "http---->exception:" + JSONUtil.toString(exception));


                PrintUtil.toastMakeText("请先打开应用读取权限，否则无法更新");
            }

            @Override
            public void onStart(int what, boolean isResume, long rangeSize, Headers responseHeaders, long allCount) {
                PrintUtil.log("http---->开始下载");
                Log.e("UpdataDialog", "http---->开始下载");

                progressBar.setVisibility(View.VISIBLE);
                progressBar.setProgress(0);
                progressTv.setText("0%");
                progressTv.setVisibility(View.VISIBLE);
                submitTv.setVisibility(View.GONE);
            }

            @Override//
            public void onProgress(int what, int progress, long fileCount, long speed) {
                PrintUtil.log("http---->下载进度：" + progress);
                Log.e("UpdataDialog", "http---->下载进度：" + progress);
                progressBar.setVisibility(View.VISIBLE);
                progressBar.setProgress(progress);
                progressTv.setText(String.format("%s%%", progress));
                submitTv.setVisibility(View.GONE);
            }

            @Override
            public void onFinish(int what, final String filePath) {
                new Handler().postDelayed(() -> {
                    Intent intent = new Intent();
                    intent.setAction(Intent.ACTION_VIEW);

                    if (Build.VERSION.SDK_INT > 23) {
                        /**Android 7.0以上的方式**/
                        intent.setFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION);
                        PrintUtil.log("http---->filePath:" + filePath);
                        Log.e("TAG", "http---->filePath:" + filePath);
//                      FileProvider 需要在清单文件中注册
                        String authority = AppUtils.getPackageName(mActivity) + ".provider";
                        Log.e("UpdataDialog", "自动更新contentUri---------" + authority);
                        Uri contentUri = FileProvider.getUriForFile(getContext(), authority, new File(filePath));
                        intent.setDataAndType(contentUri, "application/vnd.android.package-archive");
                        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);

                        Log.e("UpdataDialog", "自动更新contentUri---------" + contentUri);
                    } else {
                        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                        intent.setDataAndType(Uri.fromFile(new File(filePath)), "application/vnd.android.package-archive");
                    }
                    mActivity.startActivity(intent);
                    System.exit(0);
                }, 1000);
            }

            @Override
            public void onCancel(int what) {

            }
        });
    }


}
