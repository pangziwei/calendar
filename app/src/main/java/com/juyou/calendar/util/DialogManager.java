package com.juyou.calendar.util;

import android.content.Context;
import android.util.Log;
import android.widget.ImageView;

import com.google.gson.Gson;
import com.lxj.xpopup.XPopup;
import com.lxj.xpopup.interfaces.SimpleCallback;
import java.util.ArrayList;
import java.util.List;

/**
 * @desc 自定义pop弹框管理类
 */
public class DialogManager {
    private static DialogManager instance;

    public static DialogManager getInstance() {
        if (instance == null) {
            synchronized (DialogManager.class) {
                if (instance == null) {
                    instance = new DialogManager();
                }
            }
        }
        return instance;
    }
    //显示分享弹框
    public void showShareDialog(Context mContext, ContentShare contentShare) {
        ShareBottomDialog shareDialog = new ShareBottomDialog(mContext);
        shareDialog.initShareContent(contentShare);
        new XPopup.Builder(mContext)
                .dismissOnTouchOutside(false)
                .asCustom(shareDialog)
                .show();
    }

}
