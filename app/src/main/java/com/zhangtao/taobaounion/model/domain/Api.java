package com.zhangtao.taobaounion.model.domain;

import com.zhangtao.taobaounion.model.Categories;

import retrofit2.Call;
import retrofit2.http.GET;

public interface Api {

    @GET("discovery/categories")
    Call<Categories> getCategories();
}
