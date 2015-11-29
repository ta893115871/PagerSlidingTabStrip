package com.guxiuzhong.pagerslidingtabstrip.activity;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.ViewGroup;

import com.example.guxiuzhong.pagerslidingtab_lib.PagerSlidingTabStrip;
import com.guxiuzhong.pagerslidingtabstrip.R;
import com.guxiuzhong.pagerslidingtabstrip.fragment.FragmentContent;

/***
 * Android-导航栏特效
 * 新闻类APP(比网易，今日头条)
 * 主要是导航栏字体大小和颜色的渐变特效.
 * Created by guxiuzhong on 2015/7/6.
 */
public class CodeActivity extends FragmentActivity {

    private PagerSlidingTabStrip tabs;
    private ViewPager pager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        pager = (ViewPager) findViewById(R.id.pager);
        tabs = (PagerSlidingTabStrip) findViewById(R.id.tabs);
        pager.setAdapter(new MyPagerAdapter(getSupportFragmentManager()));
        tabs.setViewPager(pager);
        pager.setCurrentItem(1);
        setTabsValue();
    }

    /**
     * 对PagerSlidingTabStrip的各项属性进行赋值。
     */
    private void setTabsValue() {
        // 设置Tab是自动填充满屏幕的
        tabs.setShouldExpand(true);

        // 设置Tab的分割线的颜色
        tabs.setDividerColor(getResources().getColor(R.color.color_80cbc4));
        // 设置分割线的上线的间距,传入的是dp
        tabs.setDividerPaddingTopBottom(12);

        // 设置Tab底部线的高度,传入的是dp
        tabs.setUnderlineHeight(1);
        //设置Tab底部线的颜色
        tabs.setUnderlineColor(getResources().getColor(R.color.color_1A000000));

        // 设置Tab 指示器Indicator的高度,传入的是dp
        tabs.setIndicatorHeight(4);
        // 设置Tab Indicator的颜色
        tabs.setIndicatorColor(getResources().getColor(R.color.color_45c01a));

        // 设置Tab标题文字的大小,传入的是dp
        tabs.setTextSize(16);
        // 设置选中Tab文字的颜色
        tabs.setSelectedTextColor(getResources().getColor(R.color.color_45c01a));
        //设置正常Tab文字的颜色
        tabs.setTextColor(getResources().getColor(R.color.color_C231C7));

        //  设置点击Tab时的背景色
        tabs.setTabBackground(R.drawable.background_tab);

        //是否支持动画渐变(及透明度和大小)
        tabs.setFadeEnabled(true);
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
