package com.orange.mymvpdemo.setting;

import com.orange.mymvpdemo.bean.SettingData;

/**
 * <p>
 * Created by zhangjian on 2019/5/29.
 */
public class SettingChangeEvent {
    public static class OnSuccess {
        private SettingData settingData;

        public OnSuccess(SettingData settingData) {
            this.settingData = settingData;
        }

        public SettingData getSettingData() {
            return settingData;
        }

        public void setSettingData(SettingData settingData) {
            this.settingData = settingData;
        }
    }
}
