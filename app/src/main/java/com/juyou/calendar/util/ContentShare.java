package com.juyou.calendar.util;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.google.gson.Gson;
import com.juyou.calendar.R;
import com.juyou.calendar.activity.MyMainActivity;
import com.juyou.calendar.fragment.mine.OneClickLoginActivity;
import com.tencent.connect.share.QQShare;
import com.tencent.connect.share.QzoneShare;
import com.tencent.tauth.Tencent;
import com.umeng.socialize.ShareAction;
import com.umeng.socialize.ShareContent;
import com.umeng.socialize.UMShareListener;
import com.umeng.socialize.bean.SHARE_MEDIA;
import com.umeng.socialize.media.UMImage;
import com.umeng.socialize.media.UMWeb;

import java.util.ArrayList;
import java.util.List;

import interfaces.heweather.com.interfacesmodule.bean.geo.GeoBean;

import static com.juyou.calendar.activity.MyMainActivity.mTencent;


/**
 * @desc 配置分享内容及分享平台
 */
public class ContentShare {
    private static final String Tag = "shareTag";

    private ShareContent content;  //分享内容对象
    private Context context;

    public ContentShare(Context context) {
        this.context = context;
    }

    /**
     * @desc 设置分享图片
     * @author zhengjun
     * @created at 2018/8/30 14:34
     */
    public void setShareBitmap(Bitmap bitmap) {
        content = new ShareContent();
        UMImage image = new UMImage(context, bitmap);
        UMImage thumb = new UMImage(context, bitmap);
        image.setThumb(thumb); //设置缩略图 如果不设置 微信分享时的弹框不会显示分享的图片
        image.compressStyle = UMImage.CompressStyle.SCALE;//大小压缩，默认为大小压缩，适合普通很大的图
        image.compressFormat = Bitmap.CompressFormat.JPEG;
        content.mMedia = image;
    }

    /**
     * @desc 设置分享链接
     * @author zhengjun
     * @created at 2018/8/30 14:35
     */
    public void setShareContent(final String shareTitle, final String shareContent, final String Url) {
        content = new ShareContent();
        UMWeb web = new UMWeb(Url);
        Log.e("分享", "shareTitle---------------" + shareTitle);
        Log.e("分享", "shareContent---------------" + shareContent);
        Log.e("分享", "Url---------------" + Url);
        web.setTitle(shareTitle);//标题
        UMImage thumb = new UMImage(context, R.drawable.pzw);
        web.setThumb(thumb);  //缩略图
        web.setDescription(shareContent);//描述
        content.mMedia = web;
    }

    /**
     * @desc 设置分享链接
     * @author zhengjun
     * @created at 2018/8/30 14:35
     */
    public void setShareSpannedContent(final String shareTitle, final String shareContent, final String Url, final String bitmap) {
        content = new ShareContent();
        UMWeb web = new UMWeb(Url);
        web.setTitle(shareTitle);//标题
        Log.e("分享", "shareTitle--------标题-------" + shareTitle);
        Log.e("分享", "shareContent-------标题--------" + shareContent);
        Log.e("分享", "Url---------标题-----" + Url);
//        UMImage thumb = new UMImage(context, R.drawable.pzw);
        UMImage thumb = new UMImage(context, bitmap);
        web.setThumb(thumb);  //缩略图
        web.setDescription(String.valueOf(shareContent));//描述
        content.mMedia = web;
    }

    /**
     * 分享到QQ
     */
    public void ShareToQQ(String s, String b, String cc, String dd) {
        final Bundle params = new Bundle();
        params.putInt(QQShare.SHARE_TO_QQ_KEY_TYPE, QQShare.SHARE_TO_QQ_TYPE_DEFAULT);
        params.putString(QQShare.SHARE_TO_QQ_TITLE, s);
        params.putString(QQShare.SHARE_TO_QQ_SUMMARY, b);
        params.putString(QQShare.SHARE_TO_QQ_TARGET_URL, cc);
        params.putString(QQShare.SHARE_TO_QQ_IMAGE_URL, dd);
        params.putString(QQShare.SHARE_TO_QQ_APP_NAME, "测试应用222222");
//        params.putInt(QQShare.SHARE_TO_QQ_EXT_INT, Integer.parseInt("其他附加功能"));
        mTencent.shareToQQ((Activity) context, params, new MyMainActivity.BaseUiListener());
    }

    //    List<String> list = new List<String>();
//  //新增数据
//     list.Add(123);


    /**
     * 分享到QQ空间
     */
    public void shareToQQSpace() {
        ArrayList<String> obj = new ArrayList<String>();
        obj.add("https://c-ssl.duitang.com/uploads/blog/202104/14/20210414192842_631a0.jpg");
        obj.add("https://c-ssl.duitang.com/uploads/blog/202104/15/20210415222059_1bd06.jpg");
        obj.add("https://c-ssl.duitang.com/uploads/blog/202112/02/20211202164710_fac86.jpg");
//分享类型
        final Bundle params = new Bundle();
        params.putString(QQShare.SHARE_TO_QQ_KEY_TYPE, String.valueOf(QQShare.SHARE_TO_QQ_TYPE_DEFAULT));
        params.putString(QzoneShare.SHARE_TO_QQ_TITLE, "标dvfcxbv b 题");//必填
        params.putString(QzoneShare.SHARE_TO_QQ_SUMMARY, "摘aesfcdsa要");//选填
        params.putString(QzoneShare.SHARE_TO_QQ_TARGET_URL, "https://blog.csdn.net/qq_37328546?spm=1019.2139.3001.5343");//必填
        params.putStringArrayList(QzoneShare.SHARE_TO_QQ_IMAGE_URL, obj);
        mTencent.shareToQzone((Activity) context, params, new MyMainActivity.BaseUiListener());
    }

//

//
//    /**
//     * @desc 设置分享链接
//     * @author zhengjun
//     * @created at 2018/8/30 14:35
//     */
//    public void setShareContentText(final String shareTitle, final String shareContent) {
//        content = new ShareContent();
//        UMWeb web = new UMWeb(Url);
//        web.setTitle(shareTitle);//标题
//        UMImage thumb = new UMImage(context, R.drawable.pzw);
//        web.setThumb(thumb);  //缩略图
//        web.setDescription(shareContent);//描述
//        content.mMedia = web;
//    }

    /**
     * @desc 分享到qq
     * @author zhengjun
     * @created at 2018/8/24 9:53
     */
    void shareToQQ() {
        new ShareAction((Activity) context).setPlatform(SHARE_MEDIA.QQ).setCallback(umShareListener).setShareContent(content).share();
    }

    /**
     * @desc 分享到qq空间
     * @author zhengjun
     * @created at 2018/8/24 9:53
     */
    void shareToQZone() {
        new ShareAction((Activity) context).setPlatform(SHARE_MEDIA.QZONE).setCallback(umShareListener).setShareContent(content).share();
    }

    /**
     * @desc 分享到微信
     * @author zhengjun
     * @created at 2018/8/24 9:53
     */
    void shareToWeiXin() {
        new ShareAction((Activity) context).setPlatform(SHARE_MEDIA.WEIXIN).setCallback(umShareListener).setShareContent(content).share();
    }

    /**
     * @desc 分享到微信朋友圈
     * @author zhengjun
     * @created at 2018/8/24 9:53
     */
    void shareToWeiXinCircle() {
        new ShareAction((Activity) context).setPlatform(SHARE_MEDIA.WEIXIN_CIRCLE).setCallback(umShareListener).setShareContent(content).share();
    }

    /**
     * @desc 分享到新浪微博
     * @author zhengjun
     * @created at 2018/8/24 9:53
     */
    void shareToSinaWb() {
        new ShareAction((Activity) context).setPlatform(SHARE_MEDIA.SINA).setCallback(umShareListener).setShareContent(content).share();
    }

    private UMShareListener umShareListener = new UMShareListener() {
        @Override
        public void onStart(SHARE_MEDIA share_media) {
            Log.e("TAG", "分享开始");
        }

        @Override
        public void onResult(SHARE_MEDIA platform) {
            Log.e("TAG", "分享成功");
        }

        @Override
        public void onError(SHARE_MEDIA platform, Throwable t) {
            if (t != null) {
                Log.e("分享", "throw:-------" + t.getMessage());
                Toast.makeText(context, "分享失败:" + t.getMessage(), Toast.LENGTH_SHORT).show();
                return;
            }
            Toast.makeText(context, "分享失败:", Toast.LENGTH_SHORT).show();

        }

        @Override
        public void onCancel(SHARE_MEDIA platform) {
            Log.e("TAG", "分享被用户主动取消");
        }
    };


}
