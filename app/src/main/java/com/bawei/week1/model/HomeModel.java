package com.bawei.week1.model;

import com.bawei.week1.contract.IHomeContract;
import com.bawei.week1.model.bean.JavaBean;
import com.bawei.week1.util.NetUtil;
import com.google.gson.Gson;

/**
 * 功能:  页面
 * 作者:  胡锦涛
 * 时间:  2019/12/29 0029 上午 10:59
 */
public class HomeModel implements IHomeContract.IModel {
    @Override
    public void getHomeData(IModelCallback iModelCallback) {
        NetUtil.getInstance().getJsonGet("http://blog.zhaoliang5156.cn/api/shop/fulishe1.json", new NetUtil.MyCallback() {
            @Override
            public void onGetJson(String json) {
                JavaBean javaBean = new Gson().fromJson(json, JavaBean.class);
                iModelCallback.onSuccess(javaBean);
            }

            @Override
            public void onError(Throwable e) {
                iModelCallback.onFailure(e);
            }
        });
    }
}
