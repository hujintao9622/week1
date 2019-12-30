package com.bawei.week1.presenter;

import com.bawei.week1.base.BasePresenter;
import com.bawei.week1.contract.IHomeContract;
import com.bawei.week1.model.HomeModel;
import com.bawei.week1.model.bean.JavaBean;

/**
 * 功能:  页面
 * 作者:  胡锦涛
 * 时间:  2019/12/29 0029 上午 11:00
 */
public class HomePresenter extends BasePresenter<IHomeContract.IView> implements IHomeContract.IPresenter {

    private HomeModel homeModel;

    @Override
    protected void initModel() {
        homeModel = new HomeModel();
    }

    @Override
    public void getHomeData() {
        homeModel.getHomeData(new IHomeContract.IModel.IModelCallback() {
            @Override
            public void onSuccess(JavaBean javaBean) {
                view.onSuccess(javaBean);
            }

            @Override
            public void onFailure(Throwable throwable) {
                view.onFailure(throwable );
            }
        });
    }
}
