package com.zj.webview;


import android.os.Build;
import android.view.View;

import com.tencent.smtt.sdk.DownloadListener;
import com.tencent.smtt.sdk.WebSettings;
import com.tencent.smtt.sdk.WebView;


public abstract class AbsAgentWebSettings implements IAgentWebSettings, WebListenerManager {

	private WebSettings mWebSettings;
	private static final String TAG = AbsAgentWebSettings.class.getSimpleName();
	public static final String USERAGENT_UC = " UCBrowser/11.6.4.950 ";
	public static final String USERAGENT_QQ_BROWSER = " MQQBrowser/8.0 ";
	public static final String USERAGENT_AGENTWEB = WebConfig.AGENTWEB_VERSION;
	protected QKWeb mAgentWeb;


	public static AbsAgentWebSettings getInstance() {
		return new AgentWebSettingsImpl();
	}


	public AbsAgentWebSettings() {

	}

	final void bindAgentWeb(QKWeb agentWeb) {
		this.mAgentWeb = agentWeb;
		this.bindAgentWebSupport(agentWeb);

	}

	protected abstract void bindAgentWebSupport(QKWeb agentWeb);

	@Override
	public IAgentWebSettings toSetting(WebView webView) {
		settings(webView);
		return this;
	}

	private void settings(WebView webView) {


		mWebSettings = webView.getSettings();
		mWebSettings.setJavaScriptEnabled(true);
		mWebSettings.setSupportZoom(true);
		mWebSettings.setBuiltInZoomControls(false);
		mWebSettings.setSavePassword(false);
		if (AgentWebUtils.checkNetwork(webView.getContext())) {
			//根据cache-control获取数据。
			mWebSettings.setCacheMode(WebSettings.LOAD_DEFAULT);
		} else {
			//没网，则从本地获取，即离线加载
			mWebSettings.setCacheMode(WebSettings.LOAD_CACHE_ELSE_NETWORK);
		}

		if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
			//适配5.0不允许http和https混合使用情况
			mWebSettings.setMixedContentMode(android.webkit.WebSettings.MIXED_CONTENT_ALWAYS_ALLOW);
			webView.setLayerType(View.LAYER_TYPE_HARDWARE, null);
		} else if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
			webView.setLayerType(View.LAYER_TYPE_HARDWARE, null);
		} else if (Build.VERSION.SDK_INT < Build.VERSION_CODES.KITKAT) {
			webView.setLayerType(View.LAYER_TYPE_SOFTWARE, null);
		}

		mWebSettings.setTextZoom(100);
		mWebSettings.setDatabaseEnabled(true);
		mWebSettings.setAppCacheEnabled(true);
		mWebSettings.setLoadsImagesAutomatically(true);
		mWebSettings.setSupportMultipleWindows(false);
		// 是否阻塞加载网络图片  协议http or https
		mWebSettings.setBlockNetworkImage(false);
		// 允许加载本地文件html  file协议
		mWebSettings.setAllowFileAccess(true);
		if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
			// 通过 file url 加载的 Javascript 读取其他的本地文件 .建议关闭
			mWebSettings.setAllowFileAccessFromFileURLs(false);
			// 允许通过 file url 加载的 Javascript 可以访问其他的源，包括其他的文件和 http，https 等其他的源
			mWebSettings.setAllowUniversalAccessFromFileURLs(false);
		}
		mWebSettings.setJavaScriptCanOpenWindowsAutomatically(true);
		if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {

			mWebSettings.setLayoutAlgorithm(WebSettings.LayoutAlgorithm.SINGLE_COLUMN);
		} else {
			mWebSettings.setLayoutAlgorithm(WebSettings.LayoutAlgorithm.NORMAL);
		}
		mWebSettings.setLoadWithOverviewMode(false);
		mWebSettings.setUseWideViewPort(false);
		mWebSettings.setDomStorageEnabled(true);
		mWebSettings.setNeedInitialFocus(true);
		mWebSettings.setDefaultTextEncodingName("utf-8");//设置编码格式
		mWebSettings.setDefaultFontSize(16);
		mWebSettings.setMinimumFontSize(12);//设置 WebView 支持的最小字体大小，默认为 8
		mWebSettings.setGeolocationEnabled(true);
		//
		String dir = WebConfig.getCachePath(webView.getContext());

		LogUtils.i(TAG, "dir:" + dir + "   appcache:" + WebConfig.getCachePath(webView.getContext()));
		//设置数据库路径  api19 已经废弃,这里只针对 webkit 起作用
		mWebSettings.setGeolocationDatabasePath(dir);
		mWebSettings.setDatabasePath(dir);
		mWebSettings.setAppCachePath(dir);

		//缓存文件最大值
		mWebSettings.setAppCacheMaxSize(Long.MAX_VALUE);

		mWebSettings.setUserAgentString(getWebSettings()
				.getUserAgentString()
				.concat(USERAGENT_AGENTWEB)
				.concat(USERAGENT_UC)
		);


		LogUtils.i(TAG, "UserAgentString : " + mWebSettings.getUserAgentString());


	}

	@Override
	public WebSettings getWebSettings() {
		return mWebSettings;
	}

	@Override
	public WebListenerManager setWebChromeClient(WebView webview, BaseWebChromeClient webChromeClient) {
		webview.setWebChromeClient(webChromeClient);
		return this;
	}

	@Override
	public WebListenerManager setWebViewClient(WebView webView, BaseWebViewClient webViewClient) {
		webView.setWebViewClient(webViewClient);
		return this;
	}

	@Override
	public WebListenerManager setDownloader(WebView webView, DownloadListener downloadListener) {
		webView.setDownloadListener(downloadListener);
		return this;
	}


}
