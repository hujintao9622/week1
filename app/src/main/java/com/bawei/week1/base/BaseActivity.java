package com.bawei.week1.base;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

/**
 * 功能:  页面
 * 作者:  胡锦涛
 * 时间:  2019/12/29 0029 上午 10:59
 */
public abstract class BaseActivity<P extends BasePresenter> extends AppCompatActivity {
    protected P mpresenter;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(layoutId());
        mpresenter=providePresenter();
        if (mpresenter != null) {
            mpresenter.attach(this);
        }
        initView();
        initData();
    }

    protected abstract P providePresenter();

    protected abstract void initView();

    protected abstract int layoutId();

    protected abstract void initData();

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (mpresenter != null) {
            mpresenter.detach();
        }
    }
}
