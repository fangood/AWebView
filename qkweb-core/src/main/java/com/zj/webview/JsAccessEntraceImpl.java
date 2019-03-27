package com.zj.webview;

import android.os.Handler;
import android.os.Looper;

import com.tencent.smtt.sdk.ValueCallback;
import com.tencent.smtt.sdk.WebView;

public class JsAccessEntraceImpl extends BaseJsAccessEntrace {

    private WebView mWebView;
    private Handler mHandler = new Handler(Looper.getMainLooper());


    public static JsAccessEntraceImpl getInstance(WebView webView) {
        return new JsAccessEntraceImpl(webView);
    }

    private JsAccessEntraceImpl(WebView webView) {
        super(webView);
        this.mWebView = webView;
    }



    private void safeCallJs(final String s, final ValueCallback valueCallback) {
        mHandler.post(new Runnable() {
            @Override
            public void run() {
                callJs(s, valueCallback);
            }
        });
    }

    @Override
    public void callJs(String params, final ValueCallback<String> callback) {
        if (Thread.currentThread() != Looper.getMainLooper().getThread()) {
            safeCallJs(params, callback);
            return;
        }

        super.callJs(params,callback);

    }


}
