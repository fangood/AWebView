
package com.zj.webview;


public interface PermissionInterceptor {

    boolean intercept(String url, String[] permissions, String action);

}
