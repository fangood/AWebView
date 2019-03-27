package com.zj.webview.sample.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;

import com.zj.webview.MiddlewareWebClientBase;
import com.zj.webview.sample.sonic.SonicImpl;
import com.zj.webview.sample.sonic.SonicJavaScriptInterface;

import static com.zj.webview.sample.sonic.SonicJavaScriptInterface.PARAM_CLICK_TIME;


public class VasSonicFragment extends QKWebFragment {
    private SonicImpl mSonicImpl;

    public static VasSonicFragment create(Bundle bundle) {

        VasSonicFragment mVasSonicFragment = new VasSonicFragment();
        if (bundle != null) {
            mVasSonicFragment.setArguments(bundle);
        }
        return mVasSonicFragment;
    }


    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {

        // 1. 首先创建SonicImpl
        mSonicImpl = new SonicImpl(this.getArguments().getString(URL_KEY), this.getContext());
        // 2. 调用 onCreateSession
        mSonicImpl.onCreateSession();
        //3. 创建AgentWeb ，注意创建AgentWeb的时候应该使用加入SonicWebViewClient中间件
        super.onViewCreated(view, savedInstanceState); // 创建 QKWeb 注意的 go("") 传入的 mUrl 应该null 或者""
        //4. 注入 JavaScriptInterface
        mAgentWeb.getJsInterfaceHolder().addJavaObject("sonic",
                new SonicJavaScriptInterface(mSonicImpl.getSonicSessionClient(),
                        new Intent().putExtra(PARAM_CLICK_TIME,
                                getArguments().getLong(PARAM_CLICK_TIME)).putExtra("loadUrlTime", System.currentTimeMillis())));
        //5. 最后绑定AgentWeb
        mSonicImpl.bindAgentWeb(mAgentWeb);

    }

    //在步骤3的时候应该传入给AgentWeb
    @Override
    public MiddlewareWebClientBase getMiddlewareWebClient() {
        return mSonicImpl.createSonicClientMiddleWare();
    }

    //getUrl 应该为null
    @Override
    public String getUrl() {
        return null;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        //销毁SonicSession
        if (mSonicImpl != null) {
            mSonicImpl.destrory();
        }
    }
}
