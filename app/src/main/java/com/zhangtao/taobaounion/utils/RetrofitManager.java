package com.zhangtao.taobaounion.utils;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class RetrofitManager {

    private static final RetrofitManager instance = new RetrofitManager();
    private final Retrofit mRetrofit;

    private RetrofitManager(){
        mRetrofit = new Retrofit.Builder()
                .baseUrl(Constants.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

    }

    public static RetrofitManager getRetrofitManager(){
        return instance;
    }

    public Retrofit getRetrofit(){
        return mRetrofit;
    }
}
