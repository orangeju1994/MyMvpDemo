package com.orange.mymvpdemo.home;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.view.View;
import android.widget.TextView;

import com.orange.mymvpdemo.R;
import com.orange.mymvpdemo.base.MVPBaseActivity;
import com.orange.mymvpdemo.bean.PageData;
import com.orange.mymvpdemo.bean.SettingData;
import com.orange.mymvpdemo.constant.Constants;
import com.orange.mymvpdemo.setting.SettingActivity;

public class MainActivity extends MVPBaseActivity<IMainView, MainPresenter> implements IMainView {
    private TextView mTextView;

    @NonNull
    @Override
    protected MainPresenter createPresenter() {
        return new MainPresenter();
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

    }

    @Override
    public void setListener() {
        //设置各种Listener
        mTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, SettingActivity.class));
            }
        });
    }

    @Override
    public void initiate() {
        getData(Constants.PAGE_START);
    }

    private void getData(int page) {
        mPresenter.getPageData(page);
    }

    @Override
    public void setPageData(PageData pageData) {
        //todo 显示数据
        mTextView.setText("通过MVP方式更新了界面，点击打开设置数据页面");
    }

    @Override
    public void setPageDataFailView() {
        //todo 显示失败view
    }

    @Override
    public void setSettingData(SettingData settingData) {
        //todo 显示数据
        mTextView.setText("收到其他地方发过来的SettingChangeEvent.OnSuccess事件，对该事件进行处理");
    }
}
