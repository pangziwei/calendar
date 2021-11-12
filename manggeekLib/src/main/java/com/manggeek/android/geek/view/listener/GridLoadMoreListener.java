package com.manggeek.android.geek.view.listener;

import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AbsListView;

import com.manggeek.android.geek.R;
import com.manggeek.android.geek.view.GridViewWithHeaderAndFooter;


/**
 * gridView加载更多
 * Created by Administrator on 2016/6/16.
 */
public class GridLoadMoreListener implements AbsListView.OnScrollListener {

    private boolean isLastRow = false;
    private boolean isMore = true;
    private View footerView;
    private LoadMoreCallBack callBack;

    public GridLoadMoreListener(GridViewWithHeaderAndFooter gridView, LayoutInflater inflater, LoadMoreCallBack callBack) {
        View footer = inflater.inflate(R.layout.view_footer_view, null);
        footerView = footer.findViewById(R.id.footer_view);
        gridView.addFooterView(footer);
        this.callBack = callBack;
    }

    @Override
    public void onScrollStateChanged(AbsListView view, int scrollState) {
        if (isLastRow && scrollState == AbsListView.OnScrollListener.SCROLL_STATE_IDLE) {
            isMore = false;
            footerView.setVisibility(View.VISIBLE);
            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    isMore = true;
                    callBack.loadMore(footerView);
                }
            }, 2000);
        }
    }

    @Override
    public void onScroll(AbsListView view, int firstVisibleItem, int visibleItemCount, int totalItemCount) {
        isLastRow = isMore && (firstVisibleItem + visibleItemCount) == totalItemCount;
    }

    public interface LoadMoreCallBack {
        public void loadMore(View footerView);
    }

    public View getFooterView() {
        return footerView;
    }
}
