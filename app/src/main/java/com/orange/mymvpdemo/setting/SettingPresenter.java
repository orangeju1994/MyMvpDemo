package com.orange.mymvpdemo.setting;

import com.orange.mymvpdemo.base.BasePresenter;
import com.orange.mymvpdemo.base.MyCallBack;
import com.orange.mymvpdemo.bean.SettingData;
import com.orange.mymvpdemo.model.SettingModel;

import java.util.logging.Handler;

/**
 * <p>
 * Created by zhangjian on 2019/5/29.
 */
public class SettingPresenter extends BasePresenter<ISettingView> {
    private SettingModel mSettingModel;
    private Handler mHandler;

    public SettingPresenter() {
        mSettingModel = new SettingModel();
    }

    public void setSettingData(final SettingData settingData) {
        mSettingModel.setData(settingData, new MyCallBack<String>() {
            @Override
            public void onSuccess(String data) {
                if (getView() != null) {
                    getView().setSettingData(settingData);
                }
            }

            @Override
            public void onFail(Exception e) {
                if (getView() != null) {
                    getView().setSettingDataFailView(e);
                }
            }

        });
    }

    @Override
    public void release() {
        super.release();
        mSettingModel.getMainHandler().removeCallbacksAndMessages(null);
        mSettingModel.setMainHandler(null);
    }
}
