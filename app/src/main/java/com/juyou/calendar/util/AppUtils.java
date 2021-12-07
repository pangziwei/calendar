package com.juyou.calendar.util;

import android.app.Activity;
import android.app.ActivityManager;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.graphics.Color;
import android.net.Uri;
import android.os.Build;
import android.text.TextUtils;
import android.text.format.Formatter;
import android.view.MotionEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.juyou.calendar.R;
import com.juyou.calendar.share.DecorViewUtil;
import com.juyou.calendar.share.TitleBar;
import com.juyou.calendar.share.ToastFactory;

import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import java.util.Random;
import java.util.regex.Pattern;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.recyclerview.widget.RecyclerView;

/**
 * @desc 工具类
 */

public class AppUtils {

    //跳转到应用在应用市场的详情页面进行评分
    public static void goMarketDetail(Context context) {
        try {
            Uri uri = Uri.parse("market://details?id=" + context.getPackageName());
            Intent intent = new Intent(Intent.ACTION_VIEW, uri);
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            context.startActivity(intent);
        } catch (Exception e) {
            Toast.makeText(context, "您的手机没有安装Android应用市场", Toast.LENGTH_SHORT).show();
            e.printStackTrace();
        }
    }

    /**
     * @desc 把list集合转为字符创
     */
    public static String getListValue(List<String> list) {
        if (list != null && list.size() > 0) {
            String value = "";
            for (String city : list) {
                if (TextUtils.isEmpty(value)) {
                    value = city;
                } else {
                    value = String.format("%s,%s", value, city);
                }
            }
            return value;
        }
        return "";
    }

    /**
     * @param value 需要转换的值
     * @param regex 转换的规则即是以什么符合为分隔符
     * @desc 将字符串转化为list集合
     */
    public static List<String> getStringToList(String value, String regex) {
        if (TextUtils.isEmpty(value)) {
            return new ArrayList<>();
        }
        return java.util.Arrays.asList(value.split(regex));
    }

    /**
     * 根据文件大小自动转化为KB, MB, GB
     *
     * @param target_size
     */
    public static String formatSize(Context context, long target_size) {
        return Formatter.formatFileSize(context, target_size);
    }


    /**
     * 返回app运行状态
     *
     * @param context     一个context
     * @param packageName 要判断应用的包名
     * @return int 1:前台 2:后台 0:不存在
     */
    @RequiresApi(api = Build.VERSION_CODES.Q)
    public static int isAppAlive(Context context, String packageName) {
        ActivityManager activityManager = (ActivityManager) context
                .getSystemService(Context.ACTIVITY_SERVICE);
        List<ActivityManager.RunningTaskInfo> listInfos = activityManager
                .getRunningTasks(20);
        // 判断程序是否在栈顶
        if (listInfos.get(0).topActivity.getPackageName().equals(packageName)) {
            return 1;
        } else {
            // 判断程序是否在栈里
            for (ActivityManager.RunningTaskInfo info : listInfos) {
                if (info.topActivity.getPackageName().equals(packageName)) {
                    return 2;
                }
            }
            return 0;// 栈里找不到，返回0
        }
    }

    /**
     * @desc 获取0-number之间的随机数
     */
    public static int getRandomNumber(int number) {
        Random random = new Random();
        return random.nextInt(number);
    }

    public static int mDistanceY;
    public static void setTitleBgAlpha(Context mContext, RecyclerView recyclerView, TitleBar title) {
        recyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(@NonNull RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);
            }

            @Override
            public void onScrolled(@NonNull RecyclerView recyclerView, int dx, int dy) {
                int toolbarHeight = title.getBottom();
                if (toolbarHeight == 0) {
                    title.setTitleNameColor(R.color.white);
                } else {
                    //滑动的距离
                    mDistanceY += dy;
                    //当滑动的距离 <= toolbar高度的时候，改变Toolbar背景色的透明度，达到渐变的效果
                    if (mDistanceY <= toolbarHeight) {
                        float scale = (float) mDistanceY / toolbarHeight;
                        float alpha = scale * 255;
                        title.setBackgroundColor(Color.argb((int) alpha, 255, 255, 255));
                        if (alpha == 0.0) {
                            title.setTitleNameColor(R.color.white);
                        } else {
                            title.setTitleAlphaColor(Color.argb((int) alpha, 21, 21, 21));
                        }
                    } else {
                        //上述虽然判断了滑动距离与toolbar高度相等的情况，但是实际测试时发现，标题栏的背景色
                        //很少能达到完全不透明的情况，所以这里又判断了滑动距离大于toolbar高度的情况，
                        //将标题栏的颜色设置为完全不透明状态
                        title.setBackgroundColor(mContext.getResources().getColor(R.color.white));
                        title.setTitleNameColor(R.color.textcoloe3);
                        DecorViewUtil.setStatusBarLightMode((Activity) mContext);
                    }
                }
            }
        });
    }

    /**
     * 返回text的长度，一个汉字算两个，数字和英文算一个
     * @param text
     * @return
     */
    public static int judgeTextLength(String text) {
        if (TextUtils.isEmpty(text)) {
            return 0;
        }
        int count = 0;
        for (int i = 0; i < text.length(); i++) {
            char item = text.charAt(i);
            if (item < 128) {
                count++;
            } else {
                count += 2;
            }
        }
        return count;
    }
    /**
     * 拨打电话
     *
     * @param numberStr
     */
    public static void call(Context context, String numberStr) {
        if (TextUtils.isEmpty(numberStr))
            return;
        if (!Pattern.matches("[0-9]+", numberStr.replaceAll("-", "")))
            return;
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("tel:" + numberStr.replaceAll("-", "")));
        context.startActivity(intent);
    }
    /**
     * 检测程序是否安装
     * @return
     */
    public static boolean isInstalled(Context mContext,String packageName) {
        PackageManager manager = mContext.getPackageManager();
        //获取所有已安装程序的包信息
        List<PackageInfo> installedPackages = manager.getInstalledPackages(0);
        if (installedPackages != null) {
            for (PackageInfo info : installedPackages) {
                if (info.packageName.equals(packageName))
                    return true;
            }
        }
        return false;
    }


    /*文本复制粘贴*/
    public static void copy(Context context, String txt) {
        if (TextUtils.isEmpty(txt)) {
            ToastFactory.toastShort(context, "复制文本不能为空！");
            return;
        }
        ClipboardManager manager = (ClipboardManager) context.getSystemService(Context.CLIPBOARD_SERVICE);
        manager.setText(txt);
        ToastFactory.toastShort(context, "已复制到粘贴板");
    }

    /**
     * 手动测量摆放View
     * 对于手动 inflate 或者其他方式代码生成加载的View进行测量，避免该View无尺寸
     * @param v
     * @param width
     * @param height
     */
    public static void layoutView(View v, int width, int height) {
        // validate view.width and view.height
        v.layout(0, 0, width, height);
        int measuredWidth = View.MeasureSpec.makeMeasureSpec(width, View.MeasureSpec.EXACTLY);
        int measuredHeight = View.MeasureSpec.makeMeasureSpec(height, View.MeasureSpec.EXACTLY);
        // validate view.measurewidth and view.measureheight
        v.measure(measuredWidth, measuredHeight);
        v.layout(0, 0, v.getMeasuredWidth(), v.getMeasuredHeight());
    }


    public static synchronized String getPackageName(Context context) {
        try {
            PackageManager packageManager = context.getPackageManager();
            PackageInfo packageInfo = packageManager.getPackageInfo(
                    context.getPackageName(), 0);
            return packageInfo.packageName;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "com.juyou.calendar";

    }
    public static Dialog dialogTip(Context context, String text, String posText, DialogInterface.OnClickListener posListener,
                                   String negText) {
        if (posListener == null) {
            posListener = new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    dialog.dismiss();
                }
            };
        }
        AlertDialog dlg = new AlertDialog.Builder(context)
                .setTitle("提示")
                .setMessage(text)
                .setPositiveButton(posText, posListener)
                .setNegativeButton(negText, new DialogInterface.OnClickListener() {

                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                }).create();
        dlg.setOnDismissListener(new DialogInterface.OnDismissListener() {

            @Override
            public void onDismiss(DialogInterface dialog) {
                dialog = null;
            }
        });
        if (context instanceof Activity && !((Activity) context).isFinishing())
            dlg.show();
        return dlg;
    }

    /**
     * 获取渠道号
     *
     * @param context
     * @return
     */
    private static String channel = "";
    public static String getChannel(Context context) {
        if (context == null)
            return "";
        if (!TextUtils.isEmpty(channel)) {
            return channel;
        }
        try {
            ZipFile zipFile = new ZipFile(context.getApplicationInfo().sourceDir);
            Enumeration entries = zipFile.entries();
            while (entries.hasMoreElements()) {
                ZipEntry entry = (ZipEntry) entries.nextElement();
                String entryName = entry.getName();
                if (entryName.contains("META-INF/channel_")) {
                    channel = entryName.replace("META-INF/channel_", "");
                    break;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (TextUtils.isEmpty(channel)) {
            channel = "love";
        }
        return channel;
    }

    public static boolean isShouldHideInput(View v, MotionEvent event) {
        if ((v instanceof EditText)) {
            int[] leftTop = {0, 0};
            v.getLocationInWindow(leftTop);
            int left = leftTop[0], top = leftTop[1], bottom = top + v.getHeight(), right = left
                    + v.getWidth();
            // 保留点击EditText的事件
            return !(event.getX() > left) || !(event.getX() < right)
                    || !(event.getY() > top) || !(event.getY() < bottom);
        }
        return false;
    }

}
