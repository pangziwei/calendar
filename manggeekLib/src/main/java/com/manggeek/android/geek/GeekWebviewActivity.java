package com.manggeek.android.geek;

import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.appcompat.app.ActionBar;

import com.manggeek.android.geek.utils.PrintUtil;


public class GeekWebviewActivity extends GeekActivity {
    public static final String URL = "URL";
    public static final String TITLE = "TITLE";
    private TextView titleTv;
    private WebView webView;
    private ProgressBar progressBar;


    @Override protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_webview);
        ActionBar actionBar = getSupportActionBar();
        if (null != actionBar) {
            actionBar.hide();
        }
        initView();
        initWebView();
    }

    private void initView() {
        PrintUtil.log("title:" + getIntent().getStringExtra("title"));
        titleTv = findViewById(R.id.title);
        webView = findViewById(R.id.webview);
        progressBar = findViewById(R.id.progressbar);
    }

    private void initWebView() {
//        webView.getSettings. setAllowFileAccess(false);
        WebSettings seting = webView.getSettings();
        //支持缩放，默认为true。
        seting.setSupportZoom(true);
        //调整图片至适合webview的大小
        seting.setUseWideViewPort(true);
        // 缩放至屏幕的大小
        seting.setLoadWithOverviewMode(true);
        //设置webview支持javascript脚本
        seting.setJavaScriptEnabled(true);//20210524风险病毒注释【最初的】
//        seting.setJavaScriptEnabled(false);//20210524风险病毒注释【更改的】
        // 如果需要导出组件，禁止使用File域，webView.getSettings. setAllowFileAccess(false);
        seting.setAllowContentAccess(false);
        //3.如果需要使用File协议，禁止File协议调用JavaScript，webView.getSettings. setJavaScriptEnabled(false);
        seting.setLayoutAlgorithm(WebSettings.LayoutAlgorithm.NARROW_COLUMNS);

        titleTv.setText(getIntent().getStringExtra("title"));
        webView.loadUrl(getIntent().getStringExtra(URL));
        webView.setWebViewClient(new WebViewClient() {
            @Override public boolean shouldOverrideUrlLoading(WebView view, String url) {
                PrintUtil.log("url:" + url);
                view.loadUrl(url);
                return true;
            }
        });
        webView.setWebChromeClient(new WebChromeClient() {
            @Override public void onProgressChanged(WebView view, int newProgress) {
                if (newProgress == 100) {
                    progressBar.setVisibility(View.GONE);//加载完网页进度条消失
                } else {
                    progressBar.setVisibility(View.VISIBLE);//开始加载网页时显示进度条
                    progressBar.setProgress(newProgress);//设置进度值
                }
            }
        });
        webView.setOnClickListener(new View.OnClickListener() {
            @Override public void onClick(View view) {
                finish();
            }
        });
    }


    //设置返回键动作（防止按返回键直接退出程序)
    @Override public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            if (webView.canGoBack()) {//当webview不是处于第一页面时，返回上一个页面
                webView.goBack();
                return true;
            }
        }
        return super.onKeyDown(keyCode, event);
    }

}
