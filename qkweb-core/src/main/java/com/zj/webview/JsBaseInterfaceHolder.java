package com.zj.webview;

import android.os.Build;
import android.webkit.JavascriptInterface;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;


public abstract class JsBaseInterfaceHolder implements JsInterfaceHolder {

    private QKWeb.SecurityType mSecurityType;

    protected JsBaseInterfaceHolder(QKWeb.SecurityType securityType) {
        this.mSecurityType = securityType;
    }

    @Override
    public boolean checkObject(Object v) {

        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.JELLY_BEAN_MR1){
            return true;
        }
        if (QKWebConfig.WEBVIEW_TYPE == QKWebConfig.WEBVIEW_AGENTWEB_SAFE_TYPE){
            return true;
        }
        boolean tag = false;
        Class clazz = v.getClass();

        Method[] mMethods = clazz.getMethods();

        for (Method mMethod : mMethods) {

            Annotation[] mAnnotations = mMethod.getAnnotations();

            for (Annotation mAnnotation : mAnnotations) {

                if (mAnnotation instanceof JavascriptInterface) {
                    tag = true;
                    break;
                }

            }
            if (tag){
                break;
            }
        }

        return tag;
    }

    protected boolean checkSecurity() {
        return mSecurityType != QKWeb.SecurityType.STRICT_CHECK
                ? true : QKWebConfig.WEBVIEW_TYPE == QKWebConfig.WEBVIEW_AGENTWEB_SAFE_TYPE
                ? true : Build.VERSION.SDK_INT > Build.VERSION_CODES.JELLY_BEAN_MR1;
    }


}
