package com.gxz.pagerslidingtabstrip.activity;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;

import com.gxz.PagerSlidingTabStrip;
import com.gxz.pagerslidingtabstrip.R;
import com.gxz.pagerslidingtabstrip.adapter.MyPagerAdapter;

import java.util.ArrayList;

/***
 * Android-导航栏特效
 * 主要是导航栏字体大小和颜色的渐变特效.
 * Created by guxiuzhong on 2015/7/6.
 */
public class CodeActivity extends FragmentActivity {

    private PagerSlidingTabStrip tabs;
    private ViewPager pager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.code);
        pager = (ViewPager) findViewById(R.id.pager);
        tabs = (PagerSlidingTabStrip) findViewById(R.id.tabs);
        ArrayList<String> list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            list.add("Tab " + i);
        }
        pager.setAdapter(new MyPagerAdapter(getSupportFragmentManager(), list));
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
        // 设置分割线的上下的间距,传入的是dp
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

        //是否支持动画渐变(颜色渐变和文字大小渐变)
        tabs.setFadeEnabled(true);
        // 设置最大缩放,是正常状态的0.3倍
        tabs.setZoomMax(0.3F);
        //设置Tab文字的左右间距,传入的是dp
        tabs.setTabPaddingLeftRight(20);
    }
}
