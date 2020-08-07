package com.zhangtao.taobaounion.presenter.impl;

import com.google.android.material.tabs.TabLayout;
import com.zhangtao.taobaounion.R;
import com.zhangtao.taobaounion.model.domain.Api;
import com.zhangtao.taobaounion.model.Categories;
import com.zhangtao.taobaounion.presenter.IHomePresenter;
import com.zhangtao.taobaounion.utils.LogUtils;
import com.zhangtao.taobaounion.utils.RetrofitManager;
import com.zhangtao.taobaounion.view.IHomeCallback;

import java.net.HttpURLConnection;

import butterknife.BindView;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class HomePresenter implements IHomePresenter {

    private IHomeCallback mCallback;


    @Override
    public void getCategories() {
        Retrofit retrofit = RetrofitManager.getRetrofitManager().getRetrofit();
        Api api = retrofit.create(Api.class);
        Call<Categories> categories = api.getCategories();
        categories.enqueue(new Callback<Categories>() {
            @Override
            public void onResponse(Call<Categories> call, Response<Categories> response) {
//                LogUtils.d(HomePresenter.this, response.code() + "") ;
                if(response.code() == HttpURLConnection.HTTP_OK){
                    LogUtils.d(HomePresenter.this, response.body().toString());
                    Categories body = response.body();
                    if (mCallback != null) {
                        mCallback.onCategoriesLoaded(body);
                    }
//                    for (Categories.DataBean datum : body.getData()) {
//                        LogUtils.d(HomePresenter.class, String.format("ID:%d <===> NAME: %s", datum.getId(), datum.getTitle()));
//                    }
                }else{
                    LogUtils.d(HomePresenter.this, "请求数据失败！" + "code == " + response.code());
                }
            }

            @Override
            public void onFailure(Call<Categories> call, Throwable t) {
                LogUtils.d(HomePresenter.this, "请求数据失败" + " msg ->" + t);
            }
        });

    }

    @Override
    public void registerCallback(IHomeCallback callback) {
        mCallback = callback;
    }

    @Override
    public void unRegisterCallback() {
        if (mCallback != null) {
            mCallback = null;
        }
    }
}
