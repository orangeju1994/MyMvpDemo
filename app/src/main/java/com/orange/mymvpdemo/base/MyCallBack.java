package com.orange.mymvpdemo.base;

/**
 * <p>
 * Created by zhangjian on 2019/5/29.
 */
public interface MyCallBack<T> {
    void onSuccess(T data);

    void onFail(Exception e);
}
