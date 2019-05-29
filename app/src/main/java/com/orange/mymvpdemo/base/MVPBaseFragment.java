package com.orange.mymvpdemo.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


/**
 * Fragment基类，所有Fragment都必须继承该类,请勿直接继承Fragment.
 * 注意：所有Fragment相关API直接使用API11以上的API，请不要再使用support包中的fragment接口
 * <p>
 */

public abstract class MVPBaseFragment<UIInterface, Presenter extends BasePresenter<UIInterface>>
        extends Fragment {

    protected Presenter mPresenter;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mPresenter = createPresenter();
        if (mPresenter != null) {
            mPresenter.attachView((UIInterface) this);
            mPresenter.onCreate();
        }
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = super.onCreateView(inflater, container, savedInstanceState);
        if (mPresenter != null) {
            mPresenter.onCreateView();
        }
        return view;
    }

    @Override
    public void onResume() {
        super.onResume();
        if (mPresenter != null) {
            mPresenter.onResume();
        }
    }

    @Override
    public void onPause() {
        super.onPause();
        if (mPresenter != null) {
            mPresenter.onPause();
        }
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        if (mPresenter != null) {
            mPresenter.onDestroyView();
            mPresenter.detachView();
        }
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        if (mPresenter != null) {
            mPresenter.release();
            mPresenter.onDestroy();
            mPresenter.detachView();
        }
    }

    /**
     * Presenter创建方法
     *
     * @return
     */
    protected abstract Presenter createPresenter();

}
