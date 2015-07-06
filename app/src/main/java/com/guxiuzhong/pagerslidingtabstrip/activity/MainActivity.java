package com.guxiuzhong.pagerslidingtabstrip.activity;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.ViewGroup;

import com.guxiuzhong.pagerslidingtabstrip.R;
import com.guxiuzhong.pagerslidingtabstrip.fragment.FragmentContent;
import com.guxiuzhong.pagerslidingtabstrip.view.MyJazzyViewPager;
import com.guxiuzhong.pagerslidingtabstrip.view.PagerSlidingTabStrip;

/***
 * Android-导航栏特效
 新闻类APP(比网易，今日头条)
 主要是导航栏字体大小和颜色的渐变特效.
 Created by guxiuzhong on 2015/7/6.
 */
public class MainActivity extends FragmentActivity {

    private DisplayMetrics dm;
    private PagerSlidingTabStrip tabs;
    private MyJazzyViewPager pager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        dm = getResources().getDisplayMetrics();
        pager = (MyJazzyViewPager) findViewById(R.id.pager);
        tabs = (PagerSlidingTabStrip) findViewById(R.id.tabs);
        pager.setAdapter(new MyPagerAdapter(getSupportFragmentManager()));

        tabs.setViewPager(pager);
        setTabsValue();

        tabs.setFadeEnabled(true);
        pager.setCurrentItem(1);
    }

    /**
     * 对PagerSlidingTabStrip的各项属性进行赋值。
     */
    private void setTabsValue() {
        // 设置Tab是自动填充满屏幕的
        tabs.setShouldExpand(true);
        // 设置Tab的分割线是透明的
        tabs.setDividerColor(Color.TRANSPARENT);
        // 设置Tab底部线的高度
        tabs.setUnderlineHeight((int) TypedValue.applyDimension(
                TypedValue.COMPLEX_UNIT_DIP, 1, dm));
        // 设置Tab Indicator的高度
        tabs.setIndicatorHeight((int) TypedValue.applyDimension(
                TypedValue.COMPLEX_UNIT_DIP, 4, dm));
        // 设置Tab标题文字的大小
        tabs.setTextSize((int) TypedValue.applyDimension(
                TypedValue.COMPLEX_UNIT_SP, 16, dm));
        // 设置Tab Indicator的颜色
        tabs.setIndicatorColor(Color.parseColor("#45c01a"));
        // 设置选中Tab文字的颜色 (这是我自定义的一个方法)
        tabs.setSelectedTextColor(Color.parseColor("#45c01a"));
        //设置正常Tab文字的颜色 (这是我自定义的一个方法)
        tabs.setTextColor(Color.parseColor("#C231C7"));
        // 取消点击Tab时的背景色
        tabs.setTabBackground(0);
    }

    public class MyPagerAdapter extends FragmentPagerAdapter {

        public MyPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        private final String[] titles = {"TAB1", "TAB2", "TAB3", "TAB4",
                "TAB5", "TAB6", "TAB7", "TAB8", "TAB9", "TAB10", "TAB11", "TAB12", "TAB13", "TAB14"
                , "TAB15", "TAB16", "TAB17", "TAB18", "TAB19", "TAB20"};

        @Override
        public CharSequence getPageTitle(int position) {
            return titles[position];
        }

        @Override
        public int getCount() {
            return titles.length;
        }

        @Override
        public Object instantiateItem(ViewGroup container, int position) {
            return super.instantiateItem(container, position);
        }

        @Override
        public Fragment getItem(int position) {
            Bundle b = new Bundle();
            b.putString("title", titles[position]);
            return FragmentContent.getInstance(b);
        }
    }
}
