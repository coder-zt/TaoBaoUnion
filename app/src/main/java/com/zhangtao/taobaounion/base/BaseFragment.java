package com.zhangtao.taobaounion.base;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import butterknife.ButterKnife;
import butterknife.Unbinder;


/**
 * fragment的基类
 */
public abstract class BaseFragment extends Fragment {

    private Unbinder mBind;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = loadRootView(inflater, container, savedInstanceState);
        mBind = ButterKnife.bind(this, view);
        initPresenter();
        loadData();
        return view;
    }

    protected void loadData(){
        //加载数据
    }

    protected void initPresenter() {
        //初始化Presenter
    }

    private View loadRootView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        int resId = getRootViewResId();
        return inflater.inflate(resId, container, false);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        if (mBind != null) {
            mBind.unbind();
        }
        release();
    }

    protected void release(){

    }

    protected abstract int getRootViewResId();
}
