package com.zhangtao.taobaounion.ui.fragement;

import com.google.android.material.tabs.TabLayout;
import com.zhangtao.taobaounion.R;
import com.zhangtao.taobaounion.base.BaseFragment;
import com.zhangtao.taobaounion.model.Categories;
import com.zhangtao.taobaounion.presenter.impl.HomePresenter;
import com.zhangtao.taobaounion.view.IHomeCallback;

import butterknife.BindView;
import butterknife.ButterKnife;

public class HomeFragment extends BaseFragment implements IHomeCallback {

    @BindView(R.id.home_indicator)
    public TabLayout mTabLayout;
    private HomePresenter mPresenter;

    @Override
    protected int getRootViewResId() {
        return R.layout.fragment_home;
    }

    @Override
    protected void loadData() {
        //加载数据
        if (mPresenter != null) {
            mPresenter.getCategories();
        }
    }

    @Override
    protected void initPresenter() {
        //初始化presenter
        mPresenter = new HomePresenter();
        mPresenter.registerCallback(this);
    }

    @Override
    public void onCategoriesLoaded(Categories categories) {

    }
}
