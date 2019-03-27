package com.zj.webview;

/**
 * 修改包名路径需修改此类
 */
public class ClassPathConstans {
    public static final String FILE_CHOOLSER_PATH = "com.zj.webview.filechooser.FileChooser";
    /**
     * Android WebChromeClient path ，用于反射，用户是否重写来该方法
     */
    public static final String ANDROID_WEBCHROMECLIENT_PATH = "com.tencent.smtt.sdk.WebChromeClient";
    /**
     * Android  WebViewClient ' path 用于反射，判断用户是否重写了WebViewClient的某一个方法
     */
    public static final String ANDROID_WEBVIEWCLIENT_PATH = "com.tencent.smtt.sdk.WebViewClient";


    public static final String DefaultDownloadImpl = "com.zj.webview.download.DefaultDownloadImpl";
    public static final String DownloadListener = "com.zj.webview.download.DownloadListener";
    public static final String DownloadingListener = "com.zj.webview.download.DownloadingListener";
    public static final String Snackbar = "android.support.design.widget.Snackbar";
    public static final String BottomSheetDialog = "android.support.design.widget.BottomSheetDialog";
}
