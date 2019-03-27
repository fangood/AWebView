package com.zj.webview.sample.activity;


public class WebActivity extends BaseWebActivity {

    @Override
    public String getUrl() {
        return super.getUrl();
    }

    @Override
    protected void onStart() {

        super.onStart();
    }

    @Override
    protected void onResume() {
        super.onResume();



        //测试Cookies
        /*try {

            String targetUrl="";
            Log.i("Info","cookies:"+ QKWebConfig.getCookiesByUrl(targetUrl="http://www.jd.com"));
            QKWebConfig.removeAllCookies(new ValueCallback<Boolean>() {
                @Override
                public void onReceiveValue(Boolean value) {
                    Log.i("Info","onResume():"+value);
                }
            });

            String tagInfo=QKWebConfig.getCookiesByUrl(targetUrl);
            Log.i("Info","tag:"+tagInfo);
            QKWebConfig.syncCookie("http://www.jd.com","ID=IDHl3NVU0N3ltZm9OWHhubHVQZW1BRThLdGhLaFc5TnVtQWd1S2g1REcwNVhTS3RXQVFBQEBFDA984906B62C444931EA0");
            String tag=QKWebConfig.getCookiesByUrl(targetUrl);
            Log.i("Info","tag:"+tag);
            QKWebConfig.removeSessionCookies();
            Log.i("Info","removeSessionCookies:"+QKWebConfig.getCookiesByUrl(targetUrl));
        }catch (Exception e){
            e.printStackTrace();
        }*/

    }
}
