
package com.zj.webview;

import android.support.v4.util.ArrayMap;

import java.util.Map;


@Deprecated
public class HttpHeaders {


    public static HttpHeaders create() {
        return new HttpHeaders();
    }

    private Map<String, String> mHeaders = null;

    HttpHeaders() {
        mHeaders = new ArrayMap<>();
    }

    public Map<String, String> getHeaders() {
        return mHeaders;
    }

    public void additionalHttpHeader(String k, String v) {
        mHeaders.put(k, v);
    }

    public void removeHttpHeader(String k) {
        mHeaders.remove(k);
    }

    public boolean isEmptyHeaders() {
        return mHeaders == null || mHeaders.isEmpty();
    }


    @Override
    public String toString() {
        return "HttpHeaders{" +
                "mHeaders=" + mHeaders +
                '}';
    }
}
