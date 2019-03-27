package com.zj.webview.sample.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;

import com.zj.webview.sample.R;
import com.zj.webview.sample.fragment.EasyWebFragment;

public class ContainerActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_common);

        Fragment mFragment = EasyWebFragment.getInstance(new Bundle());
        getSupportFragmentManager()
                .beginTransaction()
                .add(R.id.container_framelayout, mFragment, EasyWebFragment.class.getName())
                .show(mFragment)
                .commit();
    }
}
