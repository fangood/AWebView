package com.zj.webview;

import android.os.Build;
import android.support.annotation.RequiresApi;

import com.tencent.smtt.sdk.ValueCallback;

public interface QuickCallJs {

    @RequiresApi(Build.VERSION_CODES.KITKAT)
    void quickCallJs(String method, ValueCallback<String> callback, String... params);

    void quickCallJs(String method, String... params);

    void quickCallJs(String method);


}
