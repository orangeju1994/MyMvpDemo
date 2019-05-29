package com.orange.mymvpdemo.base;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;


/**
 * MVP模式基础Activity，所有使用Fragment的Activity必须继承该类
 */

public abstract class MVPBaseActivity<UIInterface, Presenter extends BasePresenter<UIInterface>>
        extends AppCompatActivity {

    protected Presenter mPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        int contentViewId = getContentViewId();
        if (contentViewId != 0) {
            setContentView(getContentViewId());
        }
        findView();
        setView();
        setListener();
        mPresenter = createPresenter();
        if (mPresenter != null) {
            mPresenter.attachView((UIInterface) this);
            mPresenter.onCreate();
        }
        initiate();
    }

    @Override
    protected void onResume() {
        super.onResume();
        if (mPresenter != null) {
            mPresenter.onResume();
        }
    }

    @Override
    protected void onPause() {
        super.onPause();
        if (mPresenter != null) {
            mPresenter.onPause();
        }
    }

    @NonNull
    protected abstract Presenter createPresenter();


    protected abstract int getContentViewId();

    public abstract void findView();

    public abstract void setView();

    public abstract void setListener();

    public abstract void initiate();

    @Deprecated
    public boolean isCanBackDrawView() {
        return false;
    }

}
