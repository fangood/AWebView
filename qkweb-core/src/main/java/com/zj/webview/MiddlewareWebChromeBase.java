package com.zj.webview;

public class MiddlewareWebChromeBase extends WebChromeClientDelegate {

    private MiddlewareWebChromeBase mMiddlewareWebChromeBase;

    protected MiddlewareWebChromeBase(BaseWebChromeClient webChromeClient) {
        super(webChromeClient);
    }

    protected MiddlewareWebChromeBase() {
        super(null);
    }

    @Override
    final void setDelegate(BaseWebChromeClient delegate) {
        super.setDelegate(delegate);
    }

    final MiddlewareWebChromeBase enq(MiddlewareWebChromeBase middlewareWebChromeBase) {
        setDelegate(middlewareWebChromeBase);
        this.mMiddlewareWebChromeBase = middlewareWebChromeBase;
        return this.mMiddlewareWebChromeBase;
    }


    final MiddlewareWebChromeBase next() {
        return this.mMiddlewareWebChromeBase;
    }

}
