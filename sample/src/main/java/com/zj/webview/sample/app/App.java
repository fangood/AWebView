package com.zj.webview.sample.app;

import android.app.Application;
import android.util.Log;

import com.squareup.leakcanary.LeakCanary;
import com.tencent.smtt.sdk.QbSdk;

public class App extends Application {

    @Override
    public void onCreate() {
        super.onCreate();

        /**
         * 说明， WebView 初处初始化耗时 250ms 左右。
         * 提前初始化WebView ，好处可以提升页面初始化速度，减少白屏时间，
         * 坏处，拖慢了App 冷启动速度，如果 WebView 配合 VasSonic 使用，
         * 建议不要在此处提前初始化 WebView 。
         */
//        WebView mWebView=new WebView(new MutableContextWrapper(this));

        if (LeakCanary.isInAnalyzerProcess(this)) {
            // This process is dedicated to LeakCanary for heap analysis.
            // You should not init your app in this process.
            return;
        }
        LeakCanary.install(this);
        // Normal app init code...
        initX5();
    }
    /**
     * 初始化X5
     */
    private void initX5() {
        QbSdk.initX5Environment(this, new QbSdk.PreInitCallback() {
            @Override
            public void onCoreInitFinished() {
                //x5内核初始化完成回调接口，此接口回调并表示已经加载起来了x5，有可能特殊情况下x5内核加载失败，切换到系统内核。

            }

            @Override
            public void onViewInitFinished(boolean isX5Core) {
                //isX5Core为true表示x5内核加载成功；false表示加载失败，此时会自动切换到系统内核。如果在此回调前创建webview会导致使用系统内核
                Log.i("onViewInitFinished", "==========================="+isX5Core);
            }
        });
    }
}
