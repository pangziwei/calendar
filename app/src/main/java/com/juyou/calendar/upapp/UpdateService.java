package com.juyou.calendar.upapp;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;
import android.os.Handler;
import android.os.IBinder;
import android.text.TextUtils;
import android.util.Log;
import android.widget.RemoteViews;

import com.juyou.calendar.R;
import com.manggeek.android.geek.utils.JSONUtil;
import com.manggeek.android.geek.utils.PrintUtil;
import com.yanzhenjie.nohttp.Headers;
import com.yanzhenjie.nohttp.NoHttp;
import com.yanzhenjie.nohttp.RequestMethod;
import com.yanzhenjie.nohttp.download.DownloadListener;
import com.yanzhenjie.nohttp.download.DownloadQueue;
import com.yanzhenjie.nohttp.download.DownloadRequest;

import java.io.File;

import androidx.core.app.NotificationCompat;
import androidx.core.content.FileProvider;

/**
 * 更新app服务
 *
 * @author wanglei
 */
public class UpdateService extends Service {
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    private NotificationManager manager;
    private Notification notification;
    private NotificationCompat.Builder builder;
    private RemoteViews rViews;

    public static final String FILEPATH = Environment.getExternalStorageDirectory() + "/Eternal/";

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        String downloadURL = intent.getStringExtra("URL");
        PrintUtil.log("http---->DownLoadURL:" + downloadURL);
        Log.e("TAG", "http--更新下载地址-->DownLoadURL:" + downloadURL);
        startUpdateAPP(downloadURL);

        return super.onStartCommand(intent, flags, startId);
    }

    public void startUpdateAPP(String downloadURL) {
        if (!Environment.MEDIA_MOUNTED.equals(Environment.getExternalStorageState())) {
            PrintUtil.toastMakeText("没有安装存储卡，无法下载更新");
            UpdateService.this.stopSelf();
            return;
        }
        if (TextUtils.isEmpty(downloadURL)) {
            PrintUtil.log("错误下载地址");
            return;
        }
        manager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);//创建一个通知管理类
        String title = "下载" + getString(R.string.app_name);
        rViews = new RemoteViews(getPackageName(), R.layout.view_updateversion);
//        rViews.setImageViewResource(R.id.logo, R.mipmap.ic_launcherss);
        rViews.setImageViewResource(R.id.logo, R.mipmap.ic_app);
        rViews.setTextViewText(R.id.title, title);

        Intent sendIntent = new Intent();
        PendingIntent pendingIntent = PendingIntent.getActivity(this, 0, sendIntent, 0);
        builder = new NotificationCompat.Builder(this);
        builder.setContentIntent(pendingIntent);
        builder.setSmallIcon(R.mipmap.ic_app);
        builder.setContentTitle(title);
        builder.setContentText(title);
        builder.setTicker(title);

        notification = builder.build();
        notification.contentView = rViews;
        notification.flags = Notification.FLAG_ONGOING_EVENT; // 设置常驻 Flag
        manager.notify(1001, notification);

        final File file = new File(FILEPATH);
        if (!file.exists()) {
            file.mkdirs();
        }

        DownloadQueue downloadQueue = NoHttp.getDownloadQueueInstance();
        DownloadRequest downloadRequest = NoHttp.createDownloadRequest(downloadURL, RequestMethod.GET, FILEPATH, "kuaibite.apk", false, true);
        downloadQueue.add(0, downloadRequest, new DownloadListener() {
            @Override
            public void onDownloadError(int what, Exception exception) {
                PrintUtil.log("http--dfg-->exception:" + JSONUtil.toString(exception));
                Log.e("更新app", "http--dfg-->exception:" + JSONUtil.toString(exception));
                PrintUtil.toastMakeText("请先打开应用读取权限，否则无法更新");
            }

            @Override
            public void onStart(int what, boolean isResume, long rangeSize, Headers responseHeaders, long allCount) {
                PrintUtil.log("http---->开始下载");
            }

            @Override
            public void onProgress(int what, int progress, long fileCount, long speed) {
                PrintUtil.log("http---->下载进度：" + progress);
                rViews.setProgressBar(R.id.upadte_bar, 100, progress, false);
                rViews.setTextViewText(R.id.update_progress, "下载 " + progress + "%");
                notification.contentView = rViews;
                notification.flags = Notification.FLAG_ONGOING_EVENT; // 设置常驻 Flag
                manager.notify(1001, notification);
            }

            @Override
            public void onFinish(int what, final String filePath) {
                rViews.setProgressBar(R.id.upadte_bar, 100, 100, false);
                rViews.setTextViewText(R.id.update_progress, "下载完成");
                notification.contentView = rViews;
                manager.notify(1001, notification);

                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        Intent intent = new Intent();
                        intent.setAction(Intent.ACTION_VIEW);

                        if (Build.VERSION.SDK_INT > 23) {
                            /**Android 7.0以上的方式**/
                            intent.setFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION);
                            PrintUtil.log("http---->filePath:" + filePath);
//                            Uri contentUri = FileProvider.getUriForFile(getApplicationContext(),
//                                    "uk.co.senab.photoview." + getPackageName() + ".provider", new File(filePath));
//                            FileProvider 需要在清单文件中注册
                            String authority = getPackageName() + ".provider";
                            Uri contentUri = FileProvider.getUriForFile(getApplicationContext(), authority, new File(filePath));
                            intent.setDataAndType(contentUri, "application/vnd.android.package-archive");
                            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                        } else {
                            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                            intent.setDataAndType(Uri.fromFile(new File(filePath)), "application/vnd.android.package-archive");
                        }
                        startActivity(intent);
                        manager.cancel(1001);
                        UpdateService.this.stopSelf();
                    }
                }, 1000);
            }

            @Override
            public void onCancel(int what) {

            }
        });
    }


}
