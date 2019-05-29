package com.orange.mymvpdemo.setting;

import android.support.annotation.NonNull;
import android.widget.TextView;

import com.orange.mymvpdemo.R;
import com.orange.mymvpdemo.base.MVPBaseActivity;
import com.orange.mymvpdemo.bean.SettingData;
import com.orange.mymvpdemo.util.CoreUtils;

public class SettingActivity extends MVPBaseActivity<ISettingView, SettingPresenter> implements ISettingView {
    private TextView mTextView;

    @NonNull
    @Override
    protected SettingPresenter createPresenter() {
        return new SettingPresenter();
    }

    @Override
    protected int getContentViewId() {
        return R.layout.activity_main;
    }

    @Override
    public void findView() {
        //不用Butterknife时 在这里findViewById
        mTextView = findViewById(R.id.tv);
    }

    @Override
    public void setView() {
        //设置view的属性啥的
        mTextView.setText("正在设置数据...");
    }

    @Override
    public void setListener() {
        //设置各种Listener
    }

    @Override
    public void initiate() {
        setData(new SettingData());
    }

    private void setData(SettingData data) {
        mPresenter.setSettingData(data);
    }

    @Override
    public void setSettingData(SettingData settingData) {
        //todo 显示数据
        mTextView.setText("已设置数据，EventBust已发送事件，通知所有监听该事件的地方进行处理");
        CoreUtils.send(new SettingChangeEvent.OnSuccess(settingData));//一般哪里都可以发数据 但是事件要在Presenter中接收处理
    }

    @Override
    public void setSettingDataFailView(Exception e) {
        //todo 显示失败view
    }
}
