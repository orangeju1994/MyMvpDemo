package com.orange.mymvpdemo;

import android.app.Application;

import com.orange.mymvpdemo.okhttp.OkHttpManager;

/**
 * <p>
 * Created by zhangjian on 2019/5/29.
 */
public class MyApplication extends Application {
    public static MyApplication gContext;

    @Override
    public void onCreate() {
        super.onCreate();
        gContext = this;
        OkHttpManager.init(this);
    }
}
