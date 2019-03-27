package com.zj.webview.sample.client;

import android.util.Log;

import com.zj.webview.MiddlewareWebChromeBase;
import com.tencent.smtt.export.external.interfaces.JsResult;
import com.tencent.smtt.sdk.WebView;


public class MiddlewareChromeClient extends MiddlewareWebChromeBase {
    public MiddlewareChromeClient() {
    }
    @Override
    public boolean onJsAlert(WebView view, String url, String message, JsResult result) {
        Log.i("Info","onJsAlert:"+url);
        return super.onJsAlert(view, url, message, result);
    }

    @Override
    public void onProgressChanged(WebView view, int newProgress) {
        super.onProgressChanged(view, newProgress);
        Log.i("Info","onProgressChanged:");
    }
}
