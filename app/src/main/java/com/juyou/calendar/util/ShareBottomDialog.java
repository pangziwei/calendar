package com.juyou.calendar.util;

import android.content.Context;
import android.text.SpannableStringBuilder;
import android.util.Log;
import android.widget.Toast;

import androidx.annotation.NonNull;

import com.google.gson.Gson;
import com.juyou.calendar.R;
import com.juyou.calendar.bean.LunarChangeDateBean;
import com.juyou.calendar.bo.CurrentBean;
import com.juyou.calendar.bo.JuYouBo;
import com.juyou.calendar.bo.NetResultCallBack;
import com.lxj.xpopup.core.BottomPopupView;
import com.manggeek.android.geek.cache.StringCache;
import com.manggeek.android.geek.utils.JSONUtil;
import com.zrq.spanbuilder.SpanBuilder;
import com.zrq.spanbuilder.TextStyle;


/**
 * @desc 分享弹框
 */

public class ShareBottomDialog extends BottomPopupView {
    private ContentShare contentShare;

    public ShareBottomDialog(@NonNull Context context) {
        super(context);
    }

    @Override
    protected int getImplLayoutId() {
        return R.layout.dialog_share_view;
    }

    //分享之前先调用此方法
    public void initShareContent(ContentShare contentShare) {
        this.contentShare = contentShare;
    }

    @Override
    protected void onShow() {
        super.onShow();
        findViewById(R.id.ll_wx).setOnClickListener(v -> {
            dismiss();
            contentShare.shareToWeiXin();
        });
        findViewById(R.id.ll_wxp).setOnClickListener(view12 -> {
            dismiss();
            contentShare.shareToWeiXinCircle();
        });
        findViewById(R.id.ll_qq).setOnClickListener(view13 -> {
            dismiss();
//            contentShare.shareToQQ();
//            contentShare.ShareToQQ();
//            Log.e("分享", "分享数据是---" + new Gson().toJson(contentShare));
//            Toast.makeText(getContext(), "数据是---" + contentShare, Toast.LENGTH_SHORT).show();

            initChangeLunar(2021,12,15);


        });
        findViewById(R.id.ll_qq_space).setOnClickListener(view14 -> {
            dismiss();
//            contentShare.shareToQZone();
            contentShare.shareToQQSpace();

        });
        findViewById(R.id.ll_wb).setOnClickListener(v -> {
            dismiss();
            contentShare.shareToSinaWb();
        });
        findViewById(R.id.ll_share_url).setOnClickListener(v -> {
            dismiss();
            Log.e("分享", "我是url连接");
//            contentShare.setShareContent();
            shareUrl();
        });
        findViewById(R.id.share_closeIv).setOnClickListener(view15 -> dismiss());
    }

    private void shareUrl() {
        ContentShare contentShare = new ContentShare(getContext());
        contentShare.setShareContent("sdfgj", "记录这一时刻的爱，让我们的爱永恒", "https://blog.csdn.net/qq_37328546?spm=1019.2139.3001.5343");
    }


    private void initChangeLunar(int yead, int month, int day) {
        JuYouBo.LunarToNongLi(getContext(), yead, month, day, new NetResultCallBack() {
            @Override
            public void onSuccess(int what, CurrentBean currentBean) {

                Log.e("分享", "initChangeLunar------initChangeLunar---initChangeLunar----" + new Gson().toJson(currentBean));
                LunarChangeDateBean lunarChangeDateBean = JSONUtil.getObj(String.valueOf(currentBean.getData()), LunarChangeDateBean.class);
                Log.e("分享", "initChangeLunar-------------" + lunarChangeDateBean);
                contentShare.ShareToQQ(lunarChangeDateBean.getGz_nian(),lunarChangeDateBean.getJieqi_next(),
                        "https://blog.csdn.net/qq_37328546?spm=1019.2139.3001.5343",
                        "https://c-ssl.duitang.com/uploads/blog/202105/24/20210524205659_d2e97.jpg");
            }

            @Override
            public void onFail(int what, CurrentBean currentBean) {

            }
        });
    }
}
