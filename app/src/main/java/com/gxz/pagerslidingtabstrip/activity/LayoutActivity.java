package com.gxz.pagerslidingtabstrip.activity;

import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.Toast;

import com.gxz.PagerSlidingTabStrip;
import com.gxz.pagerslidingtabstrip.R;
import com.gxz.pagerslidingtabstrip.adapter.MyPagerAdapter;

import java.util.ArrayList;

public class LayoutActivity extends AppCompatActivity {
    private static final String TAG = LayoutActivity.class.getSimpleName();
    private PagerSlidingTabStrip mPagerSlidingTabStrip;
    private ViewPager pager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_layout);
        pager = (ViewPager) findViewById(R.id.pager);
        mPagerSlidingTabStrip = (PagerSlidingTabStrip) findViewById(R.id.tabs);
        ArrayList<String> list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            list.add("TAB " + i);
        }
        pager.setAdapter(new MyPagerAdapter(getSupportFragmentManager(), list));
        mPagerSlidingTabStrip.setViewPager(pager);
        pager.setCurrentItem(1);

        mPagerSlidingTabStrip.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                Log.d(TAG, "onPageSelected:" + position);
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
        mPagerSlidingTabStrip.setOnPagerTitleItemClickListener(new PagerSlidingTabStrip.OnPagerTitleItemClickListener() {
            @Override
            public void onSingleClickItem(int position) {
                Toast.makeText(LayoutActivity.this, "单击", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onDoubleClickItem(int position) {
                Toast.makeText(LayoutActivity.this, "双击", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
