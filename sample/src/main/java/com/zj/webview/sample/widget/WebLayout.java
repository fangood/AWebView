package com.zj.webview.sample.widget;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.zj.webview.IWebLayout;
import com.zj.webview.sample.R;
import com.lcodecore.tkrefreshlayout.TwinklingRefreshLayout;
import com.tencent.smtt.sdk.WebView;


public class WebLayout implements IWebLayout {

    private Activity mActivity;
    private WebView mWebView;
    private final TwinklingRefreshLayout mTwinklingRefreshLayout;

    public WebLayout(Activity activity) {
        this.mActivity = activity;
        mTwinklingRefreshLayout = (TwinklingRefreshLayout) LayoutInflater.from(activity).inflate(R.layout.fragment_twk_web, null);
        mTwinklingRefreshLayout.setPureScrollModeOn();
        mWebView = mTwinklingRefreshLayout.findViewById(R.id.webView);
    }

    @NonNull
    @Override
    public ViewGroup getLayout() {
        return mTwinklingRefreshLayout;
    }

    @Nullable
    @Override
    public WebView getWebView() {
        return mWebView;
    }



}
