package com.bawei.week1.contract;

import com.bawei.week1.model.bean.JavaBean;

/**
 * 功能:  页面
 * 作者:  胡锦涛
 * 时间:  2019/12/29 0029 上午 11:17
 */
public interface IHomeContract {
    interface IView{
        void onSuccess(JavaBean javaBean);
        void onFailure(Throwable throwable);
    }
    interface IPresenter{
        void getHomeData();
    }
    interface IModel{
        void getHomeData(IModelCallback iModelCallback);
        interface IModelCallback{
            void onSuccess(JavaBean javaBean);
            void onFailure(Throwable throwable);
        }
    }
}
