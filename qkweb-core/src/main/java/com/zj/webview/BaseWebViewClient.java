package com.zj.webview;


import android.net.http.SslError;

import com.tencent.smtt.export.external.interfaces.SslErrorHandler;
import com.tencent.smtt.sdk.WebView;
import com.tencent.smtt.sdk.WebViewClient;

public class BaseWebViewClient extends WebViewClient {
    public void onPageCommitVisible(WebView view, String url) {

    }

    public void onReceivedSslError(android.webkit.WebView view, SslErrorHandler handler, SslError error) {

    }
}
