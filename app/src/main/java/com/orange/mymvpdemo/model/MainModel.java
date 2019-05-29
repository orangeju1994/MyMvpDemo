package com.orange.mymvpdemo.model;

import com.orange.mymvpdemo.okhttp.OkHttpManager;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * Created by zhangjian on 2019/5/29.
 */
public class MainModel {
    public void getData(int page, OkHttpManager.HttpRequestCallBack callBack) {
        //todo 设置数据 如果可以的话 尽量在子线程做 成功和失败进行回调
        Map<String, String> params = new HashMap<>();
        params.put("page", String.valueOf(page));
        OkHttpManager.getInstance().doGetRequest("url", params, callBack);

        if (callBack != null) {
            callBack.onResponse(null);
        }
    }
}
