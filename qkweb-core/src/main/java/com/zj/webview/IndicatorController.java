
package com.zj.webview;


import com.tencent.smtt.sdk.WebView;

public interface IndicatorController {

    void progress(WebView v, int newProgress);

    BaseIndicatorSpec offerIndicator();

    void showIndicator();

    void setProgress(int newProgress);

    void finish();
}
