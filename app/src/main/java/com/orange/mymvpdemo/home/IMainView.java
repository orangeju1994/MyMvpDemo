package com.orange.mymvpdemo.home;

import com.orange.mymvpdemo.bean.PageData;
import com.orange.mymvpdemo.bean.SettingData;

/**
 * <p>
 * Created by zhangjian on 2019/5/29.
 */
public interface IMainView {
    void setPageData(PageData pageData);

    void setPageDataFailView();

    void setSettingData(SettingData settingData);
}
