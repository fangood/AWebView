package com.zj.webview;


import com.tencent.smtt.sdk.DownloadListener;
import com.tencent.smtt.sdk.WebView;

public interface WebListenerManager {


    WebListenerManager setWebChromeClient(WebView webview, BaseWebChromeClient webChromeClient);

    WebListenerManager setWebViewClient(WebView webView, BaseWebViewClient webViewClient);

    WebListenerManager setDownloader(WebView webView, DownloadListener downloadListener);


}
