package com.zj.webview;


public interface BaseIndicatorSpec {
    /**
     * indicator
     */
    void show();

    void hide();

    void reset();

    void setProgress(int newProgress);

}
