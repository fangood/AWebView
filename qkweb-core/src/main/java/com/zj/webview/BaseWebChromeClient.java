package com.zj.webview;

import android.os.Build;
import android.support.annotation.RequiresApi;
import android.webkit.PermissionRequest;

import com.tencent.smtt.export.external.interfaces.ConsoleMessage;
import com.tencent.smtt.sdk.WebChromeClient;

public class BaseWebChromeClient extends WebChromeClient {

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public void onPermissionRequest(PermissionRequest request) {

    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public void onPermissionRequestCanceled(PermissionRequest request) {

    }

    /**
     * @deprecated
     */
    @Deprecated
    public void onConsoleMessage(String message, int lineNumber, String sourceID) {
        LogUtils.e(sourceID, message);
    }

    public boolean onConsoleMessage(ConsoleMessage consoleMessage) {
        if (consoleMessage != null) {
            LogUtils.e(consoleMessage.sourceId(), consoleMessage.message());
        }
        return true;
    }

}

