package com.orange.mymvpdemo.model;

import android.os.Handler;

import com.orange.mymvpdemo.MyApplication;
import com.orange.mymvpdemo.base.MyCallBack;
import com.orange.mymvpdemo.bean.SettingData;

/**
 * <p>
 * Created by zhangjian on 2019/5/29.
 */
public class SettingModel {
    private Handler mainHandler = new Handler(MyApplication.gContext.getMainLooper());

    public Handler getMainHandler() {
        return mainHandler;
    }

    public void setMainHandler(Handler mainHandler) {
        this.mainHandler = mainHandler;
    }

    public void setData(SettingData settingData, final MyCallBack callBack) {
        //todo 设置数据 如果可以的话 尽量在子线程做 成功和失败进行回调
        mainHandler.postDelayed(new Runnable() {
            @Override
            public void run() {
                if (callBack != null) {
                    callBack.onSuccess(null);
                }
            }
        }, 2000);
    }
}
