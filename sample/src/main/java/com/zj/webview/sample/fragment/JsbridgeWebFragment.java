package com.zj.webview.sample.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.google.gson.Gson;
import com.zj.webview.QKWeb;
import com.zj.webview.jsbridge.BridgeHandler;
import com.zj.webview.jsbridge.BridgeWebView;
import com.zj.webview.jsbridge.BridgeWebViewClient;
import com.zj.webview.jsbridge.CallBackFunction;



public class JsbridgeWebFragment extends QKWebFragment {

    public static JsbridgeWebFragment getInstance(Bundle bundle) {

        JsbridgeWebFragment mJsbridgeWebFragment = new JsbridgeWebFragment();
        if (mJsbridgeWebFragment != null) {
            mJsbridgeWebFragment.setArguments(bundle);
        }

        return mJsbridgeWebFragment;
    }

    private BridgeWebView mBridgeWebView;

    @Override
    public String getUrl() {
        return super.getUrl();
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {

        mBridgeWebView = new BridgeWebView(getActivity());
        mAgentWeb = QKWeb.with(this)//
                .setAgentWebParent((ViewGroup) view, new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT))//
                .useDefaultIndicator(-1, 2)//
                .setAgentWebWebSettings(getSettings())//
                .setWebViewClient(new BridgeWebViewClient(mBridgeWebView))
                .setWebChromeClient(mWebChromeClient)
                .setWebView(mBridgeWebView)
                .setSecurityType(QKWeb.SecurityType.STRICT_CHECK)
//                .setDownloadListener(mDownloadListener) 4.0.0 删除该API
                .createAgentWeb()//
                .ready()//
                .go(getUrl());


        initView(view);


        mBridgeWebView.registerHandler("submitFromWeb", new BridgeHandler() {

            @Override
            public void handler(String data, CallBackFunction function) {
                function.onCallBack("submitFromWeb exe, response data 中文 from Java");
            }

        });

        User user = new User();
        Location location = new Location();
        location.address = "SDU";
        user.location = location;
        user.name = "Agentweb --> Jsbridge";


        mBridgeWebView.callHandler("functionInJs", new Gson().toJson(user), new CallBackFunction() {
            @Override
            public void onCallBack(String data) {
                Log.i(TAG, "data:" + data);
            }
        });

        mBridgeWebView.send("hello");
    }

    static class Location {
        String address;
    }

    static class User {
        String name;
        Location location;
        String testStr;
    }


}
