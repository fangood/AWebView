package com.zj.webview.sample.widget;

import android.app.Activity;
import android.content.Context;
import android.os.Build;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;

import com.coolindicator.sdk.CoolIndicator;
import com.zj.webview.AgentWebUtils;
import com.zj.webview.BaseIndicatorView;

public class CoolIndicatorLayout extends BaseIndicatorView {


	private static final String TAG = CoolIndicatorLayout.class.getSimpleName();
	private CoolIndicator mCoolIndicator = null;


	public CoolIndicatorLayout(Context context) {
		this(context, null);
	}

	public CoolIndicatorLayout(Context context, @Nullable AttributeSet attrs) {
		this(context, attrs, -1);
	}

	public CoolIndicatorLayout(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
		super(context, attrs, defStyleAttr);
		mCoolIndicator = CoolIndicator.create((Activity) context);
		if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
			mCoolIndicator.setProgressDrawable(context.getResources().getDrawable(com.coolindicator.sdk.R.drawable.default_drawable_indicator, context.getTheme()));
		} else {
			mCoolIndicator.setProgressDrawable(context.getResources().getDrawable(com.coolindicator.sdk.R.drawable.default_drawable_indicator));
		}

		this.addView(mCoolIndicator, offerLayoutParams());

	}

	@Override
	public void show() {
		this.setVisibility(View.VISIBLE);
		mCoolIndicator.start();
	}

	@Override
	public void setProgress(int newProgress) {
	}

	@Override
	public void hide() {
		mCoolIndicator.complete();
	}

	@Override
	public LayoutParams offerLayoutParams() {
		return new FrameLayout.LayoutParams(-1, AgentWebUtils.dp2px(getContext(), 3));
	}
}
