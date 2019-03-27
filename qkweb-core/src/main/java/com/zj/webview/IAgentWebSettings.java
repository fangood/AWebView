
package com.zj.webview;


import com.tencent.smtt.sdk.WebSettings;
import com.tencent.smtt.sdk.WebView;

public interface IAgentWebSettings<T extends WebSettings> {

    IAgentWebSettings toSetting(WebView webView);

    T getWebSettings();

}
