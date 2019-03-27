
package com.zj.webview.sample.sonic;

import android.os.Bundle;

import com.zj.webview.QKWeb;
import com.tencent.smtt.sdk.WebView;
import com.tencent.sonic.sdk.SonicSessionClient;

import java.util.HashMap;

/**
 *  a implement of SonicSessionClient which need to connect webview and content data.
 */

public class SonicSessionClientImpl extends SonicSessionClient {


    private QKWeb mAgentWeb;
    public void bindWebView(QKWeb agentWeb) {
        this.mAgentWeb = agentWeb;
    }

    public WebView getWebView() {
        return this.mAgentWeb.getWebCreator().getWebView();
    }

    @Override
    public void loadUrl(String url, Bundle extraData) {
        this.mAgentWeb.getUrlLoader().loadUrl(url);

    }

    @Override
    public void loadDataWithBaseUrl(String baseUrl, String data, String mimeType, String encoding, String historyUrl) {
        this.mAgentWeb.getUrlLoader().loadDataWithBaseURL(baseUrl,data,mimeType,encoding,historyUrl);

    }


    @Override
    public void loadDataWithBaseUrlAndHeader(String baseUrl, String data, String mimeType, String encoding, String historyUrl, HashMap<String, String> headers) {
        loadDataWithBaseUrl(baseUrl, data, mimeType, encoding, historyUrl);
    }



}
