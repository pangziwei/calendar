package com.manggeek.android.geek;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.manggeek.android.geek.bitmap.GeekBitmap;
import com.manggeek.android.geek.utils.JSONUtil;

import java.util.ArrayList;
import java.util.List;

import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;


/**
 * Created by Wuzhihan on 2017/6/23.
 */

public class ImagePageActivity extends GeekFragmentActivity {
    public static final String PICLIST = "PICLIST";
    public static final String INDEX = "INDEX";
    private ViewPager viewPagerVp;
    private TextView indicatorTv;
    private static final String STATE_POSITION = "STATE_POSITION";
    private List<String> dataList = new ArrayList<>();
    private int pagerPosition;

    @Override protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_imges_page);
        initView();
        if (savedInstanceState != null) {
            pagerPosition = savedInstanceState.getInt(STATE_POSITION);
        }
        viewPagerVp.setCurrentItem(pagerPosition);
    }

    private void initView() {
        viewPagerVp = (ViewPager) findViewById(R.id.view_pager);
        indicatorTv = (TextView) findViewById(R.id.indicator);

        Intent intent = getIntent();
        dataList = JSONUtil.getListObj(getIntent().getStringExtra(PICLIST), String.class);

        viewPagerVp.setAdapter(new MyAdapter());
        pagerPosition = intent.getIntExtra(INDEX, 0);
        indicatorTv.setText((pagerPosition + 1) + "/" + viewPagerVp.getAdapter().getCount());
        // 更新下标
        viewPagerVp.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {

            @Override public void onPageScrollStateChanged(int arg0) {
            }

            @Override public void onPageScrolled(int arg0, float arg1, int arg2) {
            }

            @Override public void onPageSelected(int position) {
                indicatorTv.setText((position + 1) + "/" + dataList.size());
            }
        });
    }

    @Override public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt(STATE_POSITION, viewPagerVp.getCurrentItem());
    }

    private class MyAdapter extends PagerAdapter {

        @Override public int getCount() {
            return dataList.size();
        }

        @Override public Object instantiateItem(ViewGroup container, int position) {
            ImageView photoView = new ImageView(container.getContext());
            photoView.setScaleType(ImageView.ScaleType.FIT_CENTER);
            GeekBitmap.display(mActivity, photoView, dataList.get(position));
            container.addView(photoView, ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
            return photoView;
        }

        @Override public boolean isViewFromObject(View view, Object obj) {
            return view == obj;
        }

        @Override public void destroyItem(ViewGroup container, int position, Object object) {
            container.removeView((View) object);
        }
    }
}
