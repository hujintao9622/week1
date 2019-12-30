package com.bawei.week1.view.activity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bawei.week1.R;
import com.bawei.week1.base.BaseActivity;
import com.bawei.week1.contract.IHomeContract;
import com.bawei.week1.model.bean.JavaBean;
import com.bawei.week1.presenter.HomePresenter;
import com.bawei.week1.view.adapter.MyAdapter;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends BaseActivity<HomePresenter> implements IHomeContract.IView {


    @BindView(R.id.ma_rc)
    RecyclerView maRc;

    @Override
    protected HomePresenter providePresenter() {
        return new HomePresenter();
    }

    @Override
    protected void initView() {

    }

    @Override
    protected int layoutId() {
        return R.layout.activity_main;
    }

    @Override
    protected void initData() {
        mpresenter.getHomeData();
    }

    @Override
    public void onSuccess(JavaBean javaBean) {
        List<JavaBean.DataBean> data = javaBean.getData();
        GridLayoutManager gridLayoutManager = new GridLayoutManager(this, 2);
        maRc.setLayoutManager(gridLayoutManager);
        MyAdapter myAdapter = new MyAdapter(data);
        myAdapter.setOnItemClickListener(new MyAdapter.OnItemClickListener() {
            @Override
            public void OnItemClick(int position) {
                Intent intent = new Intent(MainActivity.this, Main2Activity.class);
                startActivity(intent);
                finish();
            }
        });
        maRc.setAdapter(myAdapter);
    }

    @Override
    public void onFailure(Throwable throwable) {
        Log.e("tag", throwable.getMessage());
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }
}
