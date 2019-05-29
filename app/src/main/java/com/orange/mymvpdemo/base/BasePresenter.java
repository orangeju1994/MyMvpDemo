package com.orange.mymvpdemo.base;

import android.support.annotation.Nullable;

import com.orange.mymvpdemo.util.CoreUtils;

import java.lang.ref.Reference;
import java.lang.ref.WeakReference;

/**
 * Prsenter基础类，所有presenter子类必须继承该父类
 */

public abstract class BasePresenter<UIInterface> {
    protected Reference<UIInterface> mViewRef;

    /**
     * view实例化后回调，此时view未完成初始化
     *
     * @param view
     */
    public void attachView(UIInterface view) {
        mViewRef = new WeakReference<UIInterface>(view);
    }

    @Nullable
    public UIInterface getView() {
        if (mViewRef == null) {
            //throw new IllegalArgumentException("the view not attach");
            // detach 后自然返回null
            return null;
        }
        return mViewRef.get();
    }

    public boolean isViewAttatched() {
        return mViewRef != null && mViewRef.get() != null;
    }

    public void detachView() {
        if (mViewRef != null) {
            mViewRef.clear();
            mViewRef = null;
        }
    }

    /**
     * view初始化(findview,setView,setViewListener)完成后回调
     */
    public void onCreate() {
        CoreUtils.register(this);
    }

    public void onCreateView() {
    }

    public void onResume() {

    }

    public void onPause() {

    }

    public void onDestroyView() {
        CoreUtils.unregister(this);
    }

    public void onDestroy() {
        CoreUtils.unregister(this);
    }

    /**
     * 资源释放
     */
    public void release() {

    }
}
