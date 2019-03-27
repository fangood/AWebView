
package com.zj.webview;

import android.widget.FrameLayout;

import com.tencent.smtt.sdk.WebView;

public interface WebCreator extends IWebIndicator {
    WebCreator create();

    WebView getWebView();

    FrameLayout getWebParentLayout();
}
