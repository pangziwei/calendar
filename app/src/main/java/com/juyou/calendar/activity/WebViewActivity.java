package com.juyou.calendar.activity;

import android.os.Bundle;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.juyou.calendar.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class WebViewActivity extends AppCompatActivity {

    public static final String URL = "url";
    public static final String TITLE = "title";


    @BindView(R.id.webview)
    WebView webView;
    @BindView(R.id.iv_back)
    ImageView ivBack;
    @BindView(R.id.titleName)
    TextView titleName;
    private String url = "";
    private String title = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web_view);
        ButterKnife.bind(this);
        initView();
        ivBack.setVisibility(View.VISIBLE);
    }

    private void initView() {
        if (getIntent() != null) {
            Bundle bundle = getIntent().getExtras();
            url = bundle.getString(URL);
            title = bundle.getString(TITLE);
        }
//        Log.e("tag","token---"+ StringCache.get("token"));
        webView.loadUrl(url);//加载url
        WebSettings webSettings = webView.getSettings();
        webSettings.setJavaScriptEnabled(true);//允许使用js
        webSettings.setCacheMode(WebSettings.LOAD_NO_CACHE);//不使用缓存，只从网络获取数据.
        webView.setWebViewClient(new WebViewClient() {
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                view.loadUrl(url);
                return super.shouldOverrideUrlLoading(view, url);
            }
        });

        titleName.setText(title);
    }


    @OnClick(R.id.iv_back)
    public void onViewClicked() {
        finish();
    }
}
