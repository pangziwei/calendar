package com.juyou.calendar.base;

import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.widget.LinearLayout;

import androidx.appcompat.app.ActionBar;

import com.juyou.calendar.R;
import com.juyou.calendar.bean.EventBean;
import com.juyou.calendar.manage.NoMoreDataFootView;
import com.juyou.calendar.manage.refres.MyRefreshLayout;
import com.juyou.calendar.share.DecorViewUtil;
import com.juyou.calendar.share.ThreadPool;
import com.juyou.calendar.share.ToastFactory;
import com.manggeek.android.geek.GeekFragmentActivity;
import com.manggeek.android.geek.dialog.WaitDialog;
import com.umeng.analytics.MobclickAgent;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

import java.lang.ref.SoftReference;

import butterknife.ButterKnife;
import butterknife.Unbinder;


/**
 * @desc 新基类  以后都继承这个activity，之前的基类缺陷太多，封装的不好
 */
public abstract class NewBaseActivity extends GeekFragmentActivity {
    WaitDialog waitDialog;
    public Context mContext;
    private boolean isCreated;

    protected abstract int getLayoutId();

    private Unbinder bind;
    public Handler handler = null;
    public NoMoreDataFootView footView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mContext = this;
        footView = new NoMoreDataFootView(mContext);
        setContentView(getLayoutId());
        init();
        initView();
        initData();
        setStatusBar();
    }

    private void init() {
        bind = ButterKnife.bind(this);
        handler = new MyHandler(this);
        if (!EventBus.getDefault().isRegistered(this)) {
            EventBus.getDefault().register(this);
        }
        ActionBar actionBar = getSupportActionBar();
        if (null != actionBar) {
            actionBar.hide();
        }
        MobclickAgent.setScenarioType(mActivity, MobclickAgent.EScenarioType.E_UM_NORMAL);
        MobclickAgent.setDebugMode(true);
        waitDialog = new WaitDialog(mActivity);
    }

    protected void initRecycleView() {
    }

    protected void initRefresh() {
    }

    //设置沉浸式状态栏
    protected void setStatusBar() {
        View titleView = findViewById(R.id.titleView);
        if (titleView != null) {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) titleView.getLayoutParams();
                layoutParams.topMargin = DecorViewUtil.getStatusBarHeight(mActivity);
                titleView.setLayoutParams(layoutParams);
            }
            DecorViewUtil.setFullAndTranslucent(mActivity);
        }
    }

    //设置状态栏颜色为黑色字体
    protected void setStatusBarLightMode() {
        DecorViewUtil.setStatusBarLightMode(mActivity);
    }

    public abstract void initView();

    public abstract void initData();

    static class MyHandler extends Handler {
        private SoftReference<NewBaseActivity> mDlg;

        public MyHandler(NewBaseActivity mDlg) {
            super();
            this.mDlg = new SoftReference<>(mDlg);
        }

        @Override
        public void handleMessage(Message msg) {
            if (msg != null && mDlg.get() != null)
                mDlg.get().dealHandlerMsg(msg);
        }
    }

    public void dealHandlerMsg(Message msg) {
        //处理handler发送的消息
    }

    //设置状态栏透明
    public void setTranslate() {
        DecorViewUtil.setStatusBarLightMode(mActivity);
    }

    //设置状态栏白色
    public void setWindowsWhite() {
        DecorViewUtil.setWindowStatusBarColor(mActivity, R.color.colorWhite);
    }

    @Override
    public void onWindowFocusChanged(boolean hasFocus) {
        super.onWindowFocusChanged(hasFocus);
        if (hasFocus) {
            isCreated = true;
            synchronized (NewBaseActivity.this) {
                NewBaseActivity.this.notifyAll();
            }
        }
    }

    /**
     * @desc 接收eventBus发送的事件
     */
    @Subscribe(sticky = true)
    public final void onEventMainThread(final EventBean eventBean) {
        if (eventBean == null)
            return;
        if (eventBean.isSendAll() || getClass().getName().equals(eventBean.getmClass())) {
            ThreadPool.execute(() -> {
                synchronized (NewBaseActivity.this) {
                    if (!isCreated) {
                        try {
                            NewBaseActivity.this.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
                postViewTreeHandler(eventBean);
            });
        }
    }

    private void postViewTreeHandler(final EventBean eventBean) {
        handler.post(() -> {
            //保证渲染完成
            onGetEventBusData(eventBean);
        });
    }

    /**
     * 所有View都已经渲染完成，不必担心空指针问题
     * 处理eventbus发送的事件
     *
     * @param eventBean
     */
    public void onGetEventBusData(EventBean eventBean) {

    }

    @Override
    protected void onResume() {
        super.onResume();
        MobclickAgent.onResume(mActivity);
    }

    @Override
    protected void onPause() {
        super.onPause();
        MobclickAgent.onPause(mActivity);
    }

    /**
     * 显示加载中
     */
    public void showWaitDialog() {
        if (waitDialog == null) {
            waitDialog = new WaitDialog(this);
        }
        if (!waitDialog.isShowing()) {
            waitDialog.show();
        }
    }

    /**
     * 关闭加载中
     */
    public void dismissWaitDialog() {
        if (waitDialog == null) {
            waitDialog = new WaitDialog(this);
        }
        if (waitDialog.isShowing()) {
            waitDialog.dismiss();
        }
    }

    protected void showToast(CharSequence msg) {
        if (!TextUtils.isEmpty(msg)) {
            ToastFactory.toastShort(mContext, msg);
        }
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK && event.getAction() == KeyEvent.ACTION_DOWN) {
            return onKeyBack(keyCode, event);
        }
        return super.onKeyDown(keyCode, event);
    }

    /**
     * 继承直接重写返回键监听
     *
     * @param keyCode
     * @param event
     * @return
     */
    public boolean onKeyBack(int keyCode, KeyEvent event) {
        return super.onKeyDown(keyCode, event);
    }

    //设置没有数据时显示的text
    public void setNoDataTips(String content) {
        if (footView.getFootViewState() == NoMoreDataFootView.FOOT_NO_DATA) {
            footView.setFootText(content);
        }
    }

    //加载更多结束
    public void setDataLoadFinish(int pageNum, int size, MyRefreshLayout bgRefresh) {
        if (bgRefresh != null) {
            if (pageNum == 0) {
                if (size > 0) {
                    footView.setFootViewState(NoMoreDataFootView.FOOT_HIDE);
                } else {
                    footView.setFootViewState(NoMoreDataFootView.FOOT_NO_DATA);
                    bgRefresh.finishLoadMoreWithNoMoreData();
                }
                endRefreshing(bgRefresh);
            } else {
                if (size <= 0) {
                    footView.setFootViewState(NoMoreDataFootView.FOOT_NO_MORE);
                    bgRefresh.finishLoadMoreWithNoMoreData();
                } else {
                    footView.setFootViewState(NoMoreDataFootView.FOOT_HIDE);
                    endLoadingMore(bgRefresh);
                }
            }
        }
    }

    //有分页是加载结束
    public void setDataLoadFinish(int pageNum, int size, String totalPage, MyRefreshLayout bgRefresh) {
        if (pageNum == 0) {
            if (size > 0) {
                if (pageNum + 1 == Integer.parseInt(totalPage)) {
                    setNoMoreData(bgRefresh);
                } else {
                    footView.setFootViewState(NoMoreDataFootView.FOOT_HIDE);
                    bgRefresh.setEnableLoadMore(true);
                }
            } else {
                footView.setFootViewState(NoMoreDataFootView.FOOT_NO_DATA);
                bgRefresh.finishLoadMoreWithNoMoreData();
            }
            endRefreshing(bgRefresh);
        } else {
            if (pageNum + 1 == Integer.parseInt(totalPage)) {
                setNoMoreData(bgRefresh);
            } else {
                footView.setFootViewState(NoMoreDataFootView.FOOT_HIDE);
                endLoadingMore(bgRefresh);
            }
        }
    }

    public void setNoMoreData(MyRefreshLayout refreshLayout) {
        footView.setFootViewState(NoMoreDataFootView.FOOT_NO_MORE);
        refreshLayout.finishLoadMoreWithNoMoreData();
    }

    //不分页时数据加载完成
    public void setDataLoadEnd(MyRefreshLayout refreshLayout) {
        if (refreshLayout != null) {
            endRefreshing(refreshLayout);
            footView.setFootViewState(NoMoreDataFootView.FOOT_NO_MORE);
        }
    }

    //加载数据出错时显示的view
    public void loadDataFail(int pageNum, final MyRefreshLayout bgRefresh) {
        if (bgRefresh != null && pageNum == 0) {
            footView.setFootViewState(NoMoreDataFootView.FOOT_LOAD_ERROR);
            endRefreshing(bgRefresh);
            footView.setOnClickListener(v -> beginRefreshing(bgRefresh));
        }
    }

    public void loadErrorMsg(String msg, MyRefreshLayout refreshLayout) {
        if (refreshLayout != null) {
            endLoadingMore(refreshLayout);
            endRefreshing(refreshLayout);
            showToast(msg);
        }
    }

    public void beginRefreshing(MyRefreshLayout bgRefres) {
        bgRefres.autoRefresh();
    }

    public void endRefreshing(MyRefreshLayout bgRefres) {
        bgRefres.finishRefresh();
    }

    public void endLoadingMore(MyRefreshLayout bgRefres) {
        bgRefres.finishLoadMore();
    }

    /**
     * 页面跳转
     */
    public void startActivity(Class<?> clz, Bundle bundle) {
        Intent intent = new Intent();
        intent.setClass(mActivity, clz);
        if (bundle != null) {
            intent.putExtras(bundle);
        }
        startActivity(intent);
    }

    /**
     * 页面跳转
     */
    public void startActivityResult(Class<?> clz, Bundle bundle, int requestCode) {
        Intent intent = new Intent();
        intent.setClass(mActivity, clz);
        if (bundle != null) {
            intent.putExtras(bundle);
        }
        startActivityForResult(intent, requestCode);
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (bind != null)
            bind.unbind();
        if (EventBus.getDefault().isRegistered(this)) {
            //移除所有的粘性事件
            EventBus.getDefault().removeAllStickyEvents();
            //解除注册
            EventBus.getDefault().unregister(this);
        }
        if (handler != null) {
            handler.removeCallbacksAndMessages(null);
        }
    }

//     if (RabbitMqMessage.TYPE_LOVE_RECORD.equals(rabbitMqMessage.getType())) {
//        Intent intent = new Intent(getApplicationContext(), DialogActivity.class);
//        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
//        intent.putExtra(Constant.TYPE, rabbitMqMessage.getType());
//        intent.putExtra(Constant.DATA, rabbitMqMessage);
//        startActivity(intent);
//    } else {
}
