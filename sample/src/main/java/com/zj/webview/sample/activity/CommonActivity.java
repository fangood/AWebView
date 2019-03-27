package com.zj.webview.sample.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.KeyEvent;
import android.widget.FrameLayout;

import com.zj.webview.sample.R;
import com.zj.webview.sample.common.FragmentKeyDown;
import com.zj.webview.sample.fragment.QKWebFragment;
import com.zj.webview.sample.fragment.BounceWebFragment;
import com.zj.webview.sample.fragment.CustomIndicatorFragment;
import com.zj.webview.sample.fragment.CustomSettingsFragment;
import com.zj.webview.sample.fragment.CustomWebViewFragment;
import com.zj.webview.sample.fragment.JsAgentWebFragment;
import com.zj.webview.sample.fragment.JsbridgeWebFragment;
import com.zj.webview.sample.fragment.SmartRefreshWebFragment;
import com.zj.webview.sample.fragment.VasSonicFragment;

import static com.zj.webview.sample.activity.MainActivity.FLAG_GUIDE_DICTIONARY_BOUNCE_EFFACT;
import static com.zj.webview.sample.activity.MainActivity.FLAG_GUIDE_DICTIONARY_CUSTOM_PROGRESSBAR;
import static com.zj.webview.sample.activity.MainActivity.FLAG_GUIDE_DICTIONARY_CUSTOM_WEBVIEW_SETTINGS;
import static com.zj.webview.sample.activity.MainActivity.FLAG_GUIDE_DICTIONARY_CUTSTOM_WEBVIEW;
import static com.zj.webview.sample.activity.MainActivity.FLAG_GUIDE_DICTIONARY_FILE_DOWNLOAD;
import static com.zj.webview.sample.activity.MainActivity.FLAG_GUIDE_DICTIONARY_INPUT_TAG_PROBLEM;
import static com.zj.webview.sample.activity.MainActivity.FLAG_GUIDE_DICTIONARY_JSBRIDGE_SAMPLE;
import static com.zj.webview.sample.activity.MainActivity.FLAG_GUIDE_DICTIONARY_JS_JAVA_COMMUNICATION;
import static com.zj.webview.sample.activity.MainActivity.FLAG_GUIDE_DICTIONARY_JS_JAVA_COMUNICATION_UPLOAD_FILE;
import static com.zj.webview.sample.activity.MainActivity.FLAG_GUIDE_DICTIONARY_LINKS;
import static com.zj.webview.sample.activity.MainActivity.FLAG_GUIDE_DICTIONARY_MAP;
import static com.zj.webview.sample.activity.MainActivity.FLAG_GUIDE_DICTIONARY_PULL_DOWN_REFRESH;
import static com.zj.webview.sample.activity.MainActivity.FLAG_GUIDE_DICTIONARY_USE_IN_FRAGMENT;
import static com.zj.webview.sample.activity.MainActivity.FLAG_GUIDE_DICTIONARY_VASSONIC_SAMPLE;
import static com.zj.webview.sample.activity.MainActivity.FLAG_GUIDE_DICTIONARY_VIDEO_FULL_SCREEN;
import static com.zj.webview.sample.sonic.SonicJavaScriptInterface.PARAM_CLICK_TIME;


public class CommonActivity extends AppCompatActivity {


    private FrameLayout mFrameLayout;
    public static final String TYPE_KEY = "type_key";
    private FragmentManager mFragmentManager;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_common);

        mFrameLayout = findViewById(R.id.container_framelayout);
        int key = getIntent().getIntExtra(TYPE_KEY, -1);
        mFragmentManager = this.getSupportFragmentManager();
        openFragment(key);
    }


    private QKWebFragment mAgentWebFragment;

    private void openFragment(int key) {

        FragmentTransaction ft = mFragmentManager.beginTransaction();
        Bundle mBundle = null;
        switch (key) {
            /*Fragment 使用Web*/
            case FLAG_GUIDE_DICTIONARY_USE_IN_FRAGMENT: //项目中请使用常量代替0 ， 代码可读性更高
                ft.add(R.id.container_framelayout, mAgentWebFragment = QKWebFragment.getInstance(mBundle = new Bundle()), QKWebFragment.class.getName());
//                mBundle.putString(QKWebFragment.URL_KEY, "https://m.vip.com/?source=www&jump_https=1");
                mBundle.putString(QKWebFragment.URL_KEY, "https://m.jd.com/");
                break;
            /*下载文件*/
            case FLAG_GUIDE_DICTIONARY_FILE_DOWNLOAD:
                ft.add(R.id.container_framelayout, mAgentWebFragment = QKWebFragment.getInstance(mBundle = new Bundle()), QKWebFragment.class.getName());
                mBundle.putString(QKWebFragment.URL_KEY, "http://android.myapp.com/");
                break;
            /*input标签上传文件*/
            case FLAG_GUIDE_DICTIONARY_INPUT_TAG_PROBLEM:
                ft.add(R.id.container_framelayout, mAgentWebFragment = QKWebFragment.getInstance(mBundle = new Bundle()), QKWebFragment.class.getName());
                mBundle.putString(QKWebFragment.URL_KEY, "file:///android_asset/upload_file/uploadfile.html");
                break;
            /*Js上传文件*/
            case FLAG_GUIDE_DICTIONARY_JS_JAVA_COMUNICATION_UPLOAD_FILE:
                ft.add(R.id.container_framelayout, mAgentWebFragment = QKWebFragment.getInstance(mBundle = new Bundle()), QKWebFragment.class.getName());
                mBundle.putString(QKWebFragment.URL_KEY, "file:///android_asset/upload_file/jsuploadfile.html");
                break;
            /*Js*/
            case FLAG_GUIDE_DICTIONARY_JS_JAVA_COMMUNICATION:
                ft.add(R.id.container_framelayout, mAgentWebFragment = JsAgentWebFragment.getInstance(mBundle = new Bundle()), JsAgentWebFragment.class.getName());
                mBundle.putString(QKWebFragment.URL_KEY, "file:///android_asset/js_interaction/hello.html");
                break;

            /*优酷全屏播放视屏*/
            case FLAG_GUIDE_DICTIONARY_VIDEO_FULL_SCREEN:
                ft.add(R.id.container_framelayout, mAgentWebFragment = QKWebFragment.getInstance(mBundle = new Bundle()), QKWebFragment.class.getName());
                mBundle.putString(QKWebFragment.URL_KEY, "http://m.youku.com/video/id_XODEzMjU1MTI4.html");
//                mBundle.putString(QKWebFragment.URL_KEY, "https://v.qq.com/x/page/i0530nu6z1a.html");
                break;
            /*淘宝自定义进度条*/
            case FLAG_GUIDE_DICTIONARY_CUSTOM_PROGRESSBAR:
                ft.add(R.id.container_framelayout, mAgentWebFragment = CustomIndicatorFragment.getInstance(mBundle = new Bundle()), CustomIndicatorFragment.class.getName());
                mBundle.putString(QKWebFragment.URL_KEY, "https://m.taobao.com/?sprefer=sypc00");
                break;
            /*豌豆荚*/
            case FLAG_GUIDE_DICTIONARY_CUSTOM_WEBVIEW_SETTINGS:
                ft.add(R.id.container_framelayout, mAgentWebFragment = CustomSettingsFragment.getInstance(mBundle = new Bundle()), CustomSettingsFragment.class.getName());
                mBundle.putString(QKWebFragment.URL_KEY, "http://www.wandoujia.com/apps");
                break;

            /*短信*/
            case FLAG_GUIDE_DICTIONARY_LINKS:
                ft.add(R.id.container_framelayout, mAgentWebFragment = QKWebFragment.getInstance(mBundle = new Bundle()), QKWebFragment.class.getName());
                mBundle.putString(QKWebFragment.URL_KEY, "file:///android_asset/sms/sms.html");
                break;
            /* 自定义 WebView */
            case FLAG_GUIDE_DICTIONARY_CUTSTOM_WEBVIEW:
                ft.add(R.id.container_framelayout, mAgentWebFragment = CustomWebViewFragment.getInstance(mBundle = new Bundle()), CustomWebViewFragment.class.getName());
                mBundle.putString(QKWebFragment.URL_KEY, "");
                break;
            /*回弹效果*/
            case FLAG_GUIDE_DICTIONARY_BOUNCE_EFFACT:
                ft.add(R.id.container_framelayout, mAgentWebFragment = BounceWebFragment.getInstance(mBundle = new Bundle()), BounceWebFragment.class.getName());
                mBundle.putString(QKWebFragment.URL_KEY, "http://m.mogujie.com/?f=mgjlm&ptp=_qd._cps______3069826.152.1.0");
                break;

            /*JsBridge 演示*/
            case FLAG_GUIDE_DICTIONARY_JSBRIDGE_SAMPLE:
                ft.add(R.id.container_framelayout, mAgentWebFragment = JsbridgeWebFragment.getInstance(mBundle = new Bundle()), JsbridgeWebFragment.class.getName());
                mBundle.putString(QKWebFragment.URL_KEY, "file:///android_asset/jsbridge/demo.html");
                break;

            /*SmartRefresh 下拉刷新*/
            case FLAG_GUIDE_DICTIONARY_PULL_DOWN_REFRESH:
                ft.add(R.id.container_framelayout, mAgentWebFragment = SmartRefreshWebFragment.getInstance(mBundle = new Bundle()), SmartRefreshWebFragment.class.getName());
                mBundle.putString(QKWebFragment.URL_KEY, "http://www.163.com/");
                break;
            /*地图*/
            case FLAG_GUIDE_DICTIONARY_MAP:
                ft.add(R.id.container_framelayout, mAgentWebFragment = QKWebFragment.getInstance(mBundle = new Bundle()), QKWebFragment.class.getName());
                mBundle.putString(QKWebFragment.URL_KEY, "https://map.baidu.com/mobile/webapp/index/index/#index/index/foo=bar/vt=map");
                break;
            /*首屏秒开*/
            case FLAG_GUIDE_DICTIONARY_VASSONIC_SAMPLE:
                ft.add(R.id.container_framelayout, mAgentWebFragment = VasSonicFragment.create(mBundle = new Bundle()), QKWebFragment.class.getName());
                mBundle.putLong(PARAM_CLICK_TIME, getIntent().getLongExtra(PARAM_CLICK_TIME, -1L));
                //mBundle.putString(QKWebFragment.URL_KEY, "http://mc.vip.qq.com/demo/indexv3");
                mBundle.putString(QKWebFragment.URL_KEY, "https://mp.weixin.qq.com/s?__biz=MzA3Mzc0MjUyMQ==&mid=2672683055&idx=1&sn=c70c07262fecc6ecd7111c5ad40e7891&chksm=85b329f9b2c4a0ef10da302ac820ccfa906dd7a6eecc39ef6cadb387227aa48b08abfb02ca51&scene=0&xtrack=1#rd");
                break;
            default:
                break;

        }
        ft.commit();

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        //一定要保证 mAentWebFragemnt 回调
//		mAgentWebFragment.onActivityResult(requestCode, resultCode, data);
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {

        QKWebFragment mAgentWebFragment = this.mAgentWebFragment;
        if (mAgentWebFragment != null) {
            FragmentKeyDown mFragmentKeyDown = mAgentWebFragment;
            if (mFragmentKeyDown.onFragmentKeyDown(keyCode, event)) {
                return true;
            } else {
                return super.onKeyDown(keyCode, event);
            }
        }

        return super.onKeyDown(keyCode, event);
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();

    }
}
