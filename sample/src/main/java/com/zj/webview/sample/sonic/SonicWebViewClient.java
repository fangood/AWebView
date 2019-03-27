package com.zj.webview.sample.sonic;

import android.annotation.TargetApi;

import com.zj.webview.MiddlewareWebClientBase;
import com.tencent.smtt.export.external.interfaces.WebResourceRequest;
import com.tencent.smtt.export.external.interfaces.WebResourceResponse;
import com.tencent.smtt.sdk.WebView;
import com.tencent.sonic.sdk.SonicSession;



public class SonicWebViewClient extends MiddlewareWebClientBase {

    private SonicSession sonicSession;

    public SonicWebViewClient(SonicSession sonicSession) {
        this.sonicSession=sonicSession;
    }

    @Override
    public void onPageFinished(WebView view, String url) {
        super.onPageFinished(view, url);
        if (sonicSession != null) {
            sonicSession.getSessionClient().pageFinish(url);
        }
    }

    @TargetApi(21)
    @Override
    public WebResourceResponse shouldInterceptRequest(WebView view, WebResourceRequest request) {
        return shouldInterceptRequest(view, request.getUrl().toString());
    }
    @Override
    public WebResourceResponse shouldInterceptRequest(WebView view, String url) {
        if (sonicSession != null) {
            return (WebResourceResponse) sonicSession.getSessionClient().requestResource(url);
        }
        return null;
    }
}
