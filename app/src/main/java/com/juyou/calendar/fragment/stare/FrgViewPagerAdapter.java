package com.juyou.calendar.fragment.stare;


import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import java.util.List;

public class FrgViewPagerAdapter extends FragmentPagerAdapter {

    private List<Fragment> listfragment; //创建一个List<Fragment>

    public FrgViewPagerAdapter(FragmentManager fm, List<Fragment> list) {
        super(fm);
        this.listfragment = list;
    }

    @Override
    public Fragment getItem(int arg0) {
        return listfragment.get(arg0); //返回第几个fragment
    }

    @Override
    public int getCount() {
        return listfragment.size(); //总共有多少个fragment
    }

}
