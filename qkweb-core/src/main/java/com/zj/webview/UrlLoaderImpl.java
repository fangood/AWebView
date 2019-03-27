package com.zj.webview;

import android.os.Handler;
import android.os.Looper;

import com.tencent.smtt.sdk.WebView;

import java.util.Map;


public class UrlLoaderImpl implements IUrlLoader {


	private Handler mHandler = null;
	private WebView mWebView;
	private HttpHeaders mHttpHeaders;

	UrlLoaderImpl(WebView webView, HttpHeaders httpHeaders) {
		this.mWebView = webView;
		if (this.mWebView == null) {
			new NullPointerException("webview cannot be null .");
		}

		this.mHttpHeaders = httpHeaders;
		mHandler = new Handler(Looper.getMainLooper());
	}

	private void safeLoadUrl(final String url) {

		mHandler.post(new Runnable() {
			@Override
			public void run() {
				loadUrl(url);
			}
		});
	}

	private void safeReload() {

		mHandler.post(new Runnable() {
			@Override
			public void run() {
				reload();
			}
		});
	}

	@Override
	public void loadUrl(String url) {
		this.loadUrl(url, null);
	}

	@Override
	public void loadUrl(final String url, final Map<String, String> headers) {

		if (!AgentWebUtils.isUIThread()) {
			AgentWebUtils.runInUiThread(new Runnable() {
				@Override
				public void run() {
					loadUrl(url, headers);
				}
			});
		}
		if (headers == null || headers.isEmpty()) {
			this.mWebView.loadUrl(url);
		} else {
			this.mWebView.loadUrl(url, headers);
		}
	}

	@Override
	public void reload() {
		if (!AgentWebUtils.isUIThread()) {
			mHandler.post(new Runnable() {
				@Override
				public void run() {
					reload();
				}
			});
			return;
		}
		this.mWebView.reload();


	}

	@Override
	public void loadData(final String data, final String mimeType, final String encoding) {

		if (!AgentWebUtils.isUIThread()) {
			mHandler.post(new Runnable() {
				@Override
				public void run() {
					loadData(data, mimeType, encoding);
				}
			});
			return;
		}
		this.mWebView.loadData(data, mimeType, encoding);

	}

	@Override
	public void stopLoading() {

		if (!AgentWebUtils.isUIThread()) {
			mHandler.post(new Runnable() {
				@Override
				public void run() {
					stopLoading();
				}
			});
			return;
		}
		this.mWebView.stopLoading();

	}

	@Override
	public void loadDataWithBaseURL(final String baseUrl, final String data, final String mimeType, final String encoding, final String historyUrl) {

		if (!AgentWebUtils.isUIThread()) {
			mHandler.post(new Runnable() {
				@Override
				public void run() {
					loadDataWithBaseURL(baseUrl, data, mimeType, encoding, historyUrl);
				}
			});
			return;
		}
		this.mWebView.loadDataWithBaseURL(baseUrl, data, mimeType, encoding, historyUrl);

	}

	@Override
	public void postUrl(final String url, final byte[] postData) {

		if (!AgentWebUtils.isUIThread()) {
			mHandler.post(new Runnable() {
				@Override
				public void run() {
					postUrl(url, postData);
				}
			});
			return;
		}

		this.mWebView.postUrl(url, postData);
	}

	@Override
	public HttpHeaders getHttpHeaders() {
		return this.mHttpHeaders == null ? this.mHttpHeaders = HttpHeaders.create() : this.mHttpHeaders;
	}
}
