package com.zhangtao.taobaounion.presenter;

import com.zhangtao.taobaounion.view.IHomeCallback;

public interface IHomePresenter {

    void getCategories();

    void registerCallback(IHomeCallback callback);

    void unRegisterCallback();
}
