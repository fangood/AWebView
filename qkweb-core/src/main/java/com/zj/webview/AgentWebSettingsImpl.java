
package com.zj.webview;

import android.app.Activity;

import com.tencent.smtt.sdk.DownloadListener;
import com.tencent.smtt.sdk.WebView;


public class AgentWebSettingsImpl extends AbsAgentWebSettings {
    private QKWeb mAgentWeb;

    @Override
    protected void bindAgentWebSupport(QKWeb agentWeb) {
        this.mAgentWeb = agentWeb;
    }


    @Override
    public WebListenerManager setDownloader(WebView webView, DownloadListener downloadListener) {
        Class<?> clazz = null;
        Object mDefaultDownloadImpl$Extra = null;
        try {
            clazz = Class.forName(ClassPathConstans.DefaultDownloadImpl);
            mDefaultDownloadImpl$Extra =
                    clazz.getDeclaredMethod("create", Activity.class, WebView.class,
                            Class.forName(ClassPathConstans.DownloadListener),
                            Class.forName(ClassPathConstans.DownloadingListener),
                            PermissionInterceptor.class)
                            .invoke(mDefaultDownloadImpl$Extra, (Activity) webView.getContext()
                                    , webView, null, null, mAgentWeb.getPermissionInterceptor());

        } catch (Throwable ignore) {
            if (LogUtils.isDebug()) {
                ignore.printStackTrace();
            }
        }
        return super.setDownloader(webView, mDefaultDownloadImpl$Extra == null ? downloadListener : (DownloadListener) mDefaultDownloadImpl$Extra);
    }
}
