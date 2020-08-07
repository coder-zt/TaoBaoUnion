package com.zhangtao.taobaounion.ui.activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.zhangtao.taobaounion.R;
import com.zhangtao.taobaounion.base.BaseFragment;
import com.zhangtao.taobaounion.ui.adapter.TestAdapter;
import com.zhangtao.taobaounion.ui.adapter.TestData;
import com.zhangtao.taobaounion.ui.fragement.HomeFragment;
import com.zhangtao.taobaounion.ui.fragement.RecommendFragment;
import com.zhangtao.taobaounion.ui.fragement.RedPacketFragment;
import com.zhangtao.taobaounion.ui.fragement.SearchFragment;
import com.zhangtao.taobaounion.utils.LogUtils;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

public class MainActivity extends AppCompatActivity {

    public static final String TAG = "MainActivity";
    //主页的四个fragment
    private HomeFragment mHomeFragment;
    private RecommendFragment mRecommendFragment;
    private RedPacketFragment mRedPacketFragment;
    private SearchFragment mSearchFragment;
    private FragmentManager mFm;
    @BindView(R.id.bottom_bar)
    public BottomNavigationView mNavigationView;
    private Unbinder mBind;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mBind = ButterKnife.bind(this);
        initFragment();
        initListener();
    }

    private void initFragment() {
        mHomeFragment = new HomeFragment();
        mRecommendFragment = new RecommendFragment();
        mRedPacketFragment = new RedPacketFragment();
        mSearchFragment = new SearchFragment();
        mFm = getSupportFragmentManager();
        switchFragment(mHomeFragment);
    }


    private void initListener() {
        mNavigationView.setOnNavigationItemSelectedListener(
                new BottomNavigationView.OnNavigationItemSelectedListener() {
                    @Override
                    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                        switch (item.getItemId()) {
                            case R.id.action_home:
                                switchFragment(mHomeFragment);
                                break;
                            case R.id.action_select:
                                switchFragment(mRecommendFragment);
                                break;
                            case R.id.action_red_packet:
                                switchFragment(mRedPacketFragment);
                                break;
                            case R.id.action_search:
                                switchFragment(mSearchFragment);
                                break;
                        }
                        return true;
                    }
                });
    }

    private void switchFragment(BaseFragment baseFragment) {
        FragmentTransaction fragmentTransaction = mFm.beginTransaction();
        fragmentTransaction.replace(R.id.page_container, baseFragment);
        fragmentTransaction.commit();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mBind.unbind();
    }
}
