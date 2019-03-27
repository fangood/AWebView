package com.zj.webview;

import android.support.v4.util.ArrayMap;

import com.tencent.smtt.sdk.WebView;


public interface WebSecurityCheckLogic {
    void dealHoneyComb(WebView view);

    void dealJsInterface(ArrayMap<String, Object> objects,QKWeb.SecurityType securityType);

}
