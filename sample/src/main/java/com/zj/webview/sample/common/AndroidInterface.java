package com.zj.webview.sample.common;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import android.webkit.JavascriptInterface;
import android.widget.Toast;

import com.zj.webview.QKWeb;


public class AndroidInterface {

    private Handler deliver = new Handler(Looper.getMainLooper());
    private QKWeb agent;
    private Context context;

    public AndroidInterface(QKWeb agent, Context context) {
        this.agent = agent;
        this.context = context;
    }



    @JavascriptInterface
    public void callAndroid(final String msg) {


        deliver.post(new Runnable() {
            @Override
            public void run() {

                Log.i("Info", "main Thread:" + Thread.currentThread());
                Toast.makeText(context.getApplicationContext(), "" + msg, Toast.LENGTH_LONG).show();
            }
        });


        Log.i("Info", "Thread:" + Thread.currentThread());

    }

}
