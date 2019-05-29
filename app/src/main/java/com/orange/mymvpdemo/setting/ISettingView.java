package com.orange.mymvpdemo.setting;

import com.orange.mymvpdemo.bean.SettingData;

/**
 * <p>
 * Created by zhangjian on 2019/5/29.
 */
public interface ISettingView {
    void setSettingData(SettingData pageData);

    void setSettingDataFailView(Exception e);
}
