package com.zj.webview.sample.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.zj.webview.QKWeb;
import com.zj.webview.AgentWebSettingsImpl;
import com.zj.webview.DefaultWebClient;
import com.zj.webview.sample.widget.CoolIndicatorLayout;


public class CustomIndicatorFragment extends QKWebFragment {
	public static CustomIndicatorFragment getInstance(Bundle bundle) {
		CustomIndicatorFragment mCustomIndicatorFragment = new CustomIndicatorFragment();
		if (bundle != null)
			mCustomIndicatorFragment.setArguments(bundle);
		return mCustomIndicatorFragment;
	}

	@Override
	public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {

//        CommonIndicator mCommonIndicator=new CommonIndicator(this.getActivity());
//        FrameLayout.LayoutParams lp=new FrameLayout.LayoutParams(-2,-2);
//        lp.gravity= Gravity.CENTER;
//        ProgressBar mProgressBar=new ProgressBar(this.getActivity());
//        mProgressBar.setBackground(this.getResources().getDrawable(R.drawable.indicator_shape));
//        mCommonIndicator.addView(mProgressBar,lp);


		CoolIndicatorLayout mCoolIndicatorLayout = new CoolIndicatorLayout(this.getActivity());
		this.mAgentWeb = QKWeb.with(this)//
				.setAgentWebParent((ViewGroup) view, new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT))
				.setCustomIndicator(mCoolIndicatorLayout)
				.setAgentWebWebSettings(AgentWebSettingsImpl.getInstance())
				.setWebViewClient(mWebViewClient)
				.setPermissionInterceptor(mPermissionInterceptor)
				.setSecurityType(QKWeb.SecurityType.STRICT_CHECK)
				.interceptUnkownUrl()
				.setOpenOtherPageWays(DefaultWebClient.OpenOtherPageWays.ASK)
				.createAgentWeb()//
				.ready()//
				.go(getUrl());


		initView(view);
	}
}
