package com.manggeek.android.geek.dialog;


import android.os.Handler;

import com.manggeek.android.geek.GeekActivity;
import com.manggeek.android.geek.GeekDialog;
import com.manggeek.android.geek.R;


/**
 * 等待弹框
 *
 * @author wanglei 2014年12月14日 下午6:55:31
 */
public class WaitDialog extends GeekDialog {


    public WaitDialog(GeekActivity activity) {
        super(activity);
        setContentView(R.layout.dialog_wait);
    }

//    public WaitDialog(FragmentActivity activity) {
//        super(activity);
//    }


    /**
     * 显示弹框
     */
    public static WaitDialog show(GeekActivity activity) {
        WaitDialog dialog = new WaitDialog(activity);
        dialog.show();
        return dialog;
    }


    public void show(long time) {
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                dismiss();
            }
        }, time);
        show();
    }

    @Override
    public void dismiss() {
        if (getContext() == null || mActivity.isFinishing()) {
            return;
        } else {
            super.dismiss();
        }
    }
}
