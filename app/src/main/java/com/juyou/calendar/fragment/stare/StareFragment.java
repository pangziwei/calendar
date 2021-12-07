package com.juyou.calendar.fragment.stare;


import android.os.Bundle;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import com.flyco.tablayout.SegmentTabLayout;
import com.flyco.tablayout.listener.OnTabSelectListener;
import com.juyou.calendar.R;
import com.juyou.calendar.base.MyExFragment;

import java.util.ArrayList;

import butterknife.BindView;

public class StareFragment extends MyExFragment {
    private ArrayList<Fragment> fragments;
    private String[] mTitles = {"天蝎运势", "天蝎档案", "星座测试"};//服务器获取

    @BindView(R.id.stare_title)
    SegmentTabLayout segmentTabLayoutTitle;
    @BindView(R.id.stare_viewpager)
    ViewPager stareViewPager;



    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }


    @Override
    public int getLayoutId() {
        return R.layout.fragment_stare;
    }

    @Override
    protected void initView(View view, Bundle savedInstanceState) {
        init();
    }

    private void init() {
        initViewPageData();
    }


    private void initViewPageData() {
        fragments = new ArrayList<>();
        fragments.add(new StareFortuneFragment());//星座运势
        fragments.add(new StareArchivesFragment());//星座档案
        fragments.add(new StareTextFragment());//星座测试

        stareViewPager.setAdapter(new FrgViewPagerAdapter(getChildFragmentManager(), fragments));
        segmentTabLayoutTitle.setTabData(mTitles);
        segmentTabLayoutTitle.setOnTabSelectListener(new OnTabSelectListener() {
            @Override
            public void onTabSelect(int position) {
                stareViewPager.setCurrentItem(position);
            }

            @Override
            public void onTabReselect(int position) {
            }
        });
        stareViewPager.setOffscreenPageLimit(fragments.size());
        stareViewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                segmentTabLayoutTitle.setCurrentTab(position);
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }

    @Override
    public void loadData() {
    }


}
