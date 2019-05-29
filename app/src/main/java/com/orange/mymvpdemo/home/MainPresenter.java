package com.orange.mymvpdemo.home;

import com.orange.mymvpdemo.base.BasePresenter;
import com.orange.mymvpdemo.bean.PageData;
import com.orange.mymvpdemo.bean.SettingData;
import com.orange.mymvpdemo.model.MainModel;
import com.orange.mymvpdemo.okhttp.OkHttpManager;
import com.orange.mymvpdemo.setting.SettingChangeEvent;

import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

/**
 * <p>
 * Created by zhangjian on 2019/5/29.
 */
public class MainPresenter extends BasePresenter<IMainView> {
    private MainModel mMainModel;

    public MainPresenter() {
        mMainModel = new MainModel();
    }

    public void getPageData(int page) {
        mMainModel.getData(page, new OkHttpManager.HttpRequestCallBack<PageData>() {
            @Override
            public void onError(Exception e) {
                if (getView() != null) {
                    getView().setPageDataFailView();
                }
            }

            @Override
            public void onResponse(PageData response) {
                if (getView() != null) {
                    getView().setPageData(response);
                }
            }
        });
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onSettingChange(SettingChangeEvent.OnSuccess onSuccess) {
        SettingData settingData = onSuccess.getSettingData();
        //todo 根据更改的设置 做出不同的显示
        if (getView() != null) {
            getView().setSettingData(settingData);
        }
    }
}
