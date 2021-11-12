package com.juyou.calendar.base;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.Nullable;

import com.juyou.calendar.bean.EventBean;
import com.juyou.calendar.manage.NoMoreDataFootView;
import com.juyou.calendar.manage.refres.MyRefreshLayout;
import com.juyou.calendar.share.ThreadPool;
import com.juyou.calendar.share.ToastFactory;
import com.manggeek.android.geek.GeekFragment;
import com.manggeek.android.geek.dialog.WaitDialog;
import com.manggeek.android.geek.http.GeekHttp;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

import java.lang.ref.SoftReference;

import butterknife.ButterKnife;
import butterknife.Unbinder;

public abstract class BaseFragment extends GeekFragment {
    private View mRoot;
    private Unbinder mRootUnbinder;

    public Handler handler = null;
    public NoMoreDataFootView footView;
    private boolean isFirstLoad = false;
    private WaitDialog waitDialog;
    private boolean isCreated;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        if (mRoot == null) {
            int layoutId = getContentLayoutId();
            //初始化当前的根布局,但是不在创建时就添加到container里面
            View root = inflater.inflate(layoutId, container, false);
            mRootUnbinder = ButterKnife.bind(this, root);
            mRoot = root;
            handler = new MyHandler(this);
            footView = new NoMoreDataFootView(mActivity);
            waitDialog = new WaitDialog(mActivity);
            initView();
            isFirstLoad = true;//视图创建完成，将变量置为true

            if (getUserVisibleHint()) {//判断Fragment是否可见
                onLazyLoad();//数据加载操作
                isFirstLoad = false;//将变量置为false
            }
        } else {
            if (mRoot.getParent() != null) {
                //把当前的根布局从其父控件中移除
                ((ViewGroup) mRoot.getParent()).removeView(mRoot);
            }
        }
        return mRoot;
    }

    public View getParentView() {
        return mRoot;
    }

    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        if (isFirstLoad) {
            if (isVisibleToUser) {
                onLazyLoad();//数据加载操作
                isFirstLoad = false;//将变量置为false
            }
        } else {
            if (isVisibleToUser) {
                onReload();
            }
        }
    }

    public void onLazyLoad() {
    }

    public void onReload() {
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        //当View创建完成后初始化数据
        if (!EventBus.getDefault().isRegistered(this)) {
            EventBus.getDefault().register(this);
        }
        isCreated = true;
        synchronized (BaseFragment.this) {
            BaseFragment.this.notifyAll();
        }
        initData();
    }

    /**
     * 获得当前界面的资源文件Id
     *
     * @return 资源文件Id
     */
    protected abstract int getContentLayoutId();

    /**
     * 初始化view
     */
    protected abstract void initView();

    /**
     * 初始化数据
     */
    protected abstract void initData();


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
     * 有回调的的页面跳转
     */
    public void startActivityForResult(Class<?> clz, Bundle bundle, int requestCode) {
        Intent intent = new Intent();
        intent.setClass(mActivity, clz);
        if (bundle != null) {
            intent.putExtras(bundle);
        }
        startActivityForResult(intent, requestCode);
    }

    public void finishActivity() {
        if (mActivity != null) {
            mActivity.finish();
        }
    }

    public void showtoast(String s) {
        if (!TextUtils.isEmpty(s)) {
            ToastFactory.toastShort(mActivity, s);
        }
    }

    static class MyHandler extends Handler {
        private SoftReference<BaseFragment> mDlg;

        private MyHandler(BaseFragment mDlg) {
            super();
            this.mDlg = new SoftReference<>(mDlg);
        }

        @Override
        public void handleMessage(Message msg) {
            if (msg != null && mDlg.get() != null)
                mDlg.get().dealHandlerMsg(msg);
        }
    }

    protected void dealHandlerMsg(Message msg) {

    }

    public String optString(int resId) {
        return mActivity.getString(resId);
    }

    public Resources optResources() {
        return mActivity.getResources();
    }


    //有分页是加载结束
    public void setDataLoadFinish(int pageNum, int size, MyRefreshLayout bgRefresh) {
        if (pageNum == 0) {
            if (size > 0) {
                footView.setFootViewState(NoMoreDataFootView.FOOT_HIDE);
                bgRefresh.setEnableLoadMore(true);
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

    //设置没有数据时显示的text
    public void setNoDataTips(String content) {
        if (footView.getFootViewState() == NoMoreDataFootView.FOOT_NO_DATA) {
            footView.setFootText(content);
        }
    }

    //结束加载更多
    public void endLoadingMore(MyRefreshLayout refreshLayout) {
        refreshLayout.finishLoadMore();
    }

    //开始刷新
    public void beginRefreshing(MyRefreshLayout refreshLayout) {
        if (refreshLayout != null)
            refreshLayout.autoRefresh();
    }

    public void endRefreshing(MyRefreshLayout refreshLayout) {
        if (refreshLayout != null)
            refreshLayout.finishRefresh();
    }


    //不分页时数据加载完成
    public void setDataLoadEnd(MyRefreshLayout refreshLayout, int size) {
        if (size > 0) {
            footView.setFootViewState(NoMoreDataFootView.FOOT_NO_MORE);
        } else {
            footView.setFootViewState(NoMoreDataFootView.FOOT_NO_DATA);
        }
        endRefreshing(refreshLayout);
    }

    //不分页时数据加载完成
    public void setDataLoadEnd(MyRefreshLayout refreshLayout) {
        if (refreshLayout != null) {
            endRefreshing(refreshLayout);
            footView.setFootViewState(NoMoreDataFootView.FOOT_NO_MORE);
        }
    }

    public void setNoMoreData(MyRefreshLayout refreshLayout) {
        footView.setFootViewState(NoMoreDataFootView.FOOT_NO_MORE);
        refreshLayout.finishLoadMoreWithNoMoreData();
    }

    //加载数据出错时显示的view
    public void loadDataFail(int pageNum, final MyRefreshLayout bgRefresh) {
        if (pageNum == 0) {
            footView.setFootViewState(NoMoreDataFootView.FOOT_LOAD_ERROR);
            endRefreshing(bgRefresh);
            footView.setOnClickListener(v -> beginRefreshing(bgRefresh));
        } else {
            endLoadingMore(bgRefresh);
        }
    }

    public void loadErrorMsg(String msg, MyRefreshLayout refreshLayout) {
        endLoadingMore(refreshLayout);
        endRefreshing(refreshLayout);
        showtoast(msg);
    }

    /**
     * 显示加载中
     */
    public void showWaitDialog() {
        if (waitDialog == null) {
            waitDialog = new WaitDialog(mActivity);
        }
        waitDialog.show();
    }

    /**
     * 关闭加载中
     */
    public void dismissWaitDialog() {
        if (waitDialog == null) {
            waitDialog = new WaitDialog(mActivity);
        }
        waitDialog.dismiss();
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
                synchronized (BaseFragment.this) {
                    if (!isCreated) {
                        try {
                            BaseFragment.this.wait();
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
    public void onDestroy() {
        super.onDestroy();
        if (mRootUnbinder != null)
            mRootUnbinder.unbind();
        if (handler != null)
            handler.removeCallbacksAndMessages(null);
        GeekHttp http = GeekHttp.getHttp();
        if (http != null) {
            http.cancelBySign(this);
        }
    }
}
