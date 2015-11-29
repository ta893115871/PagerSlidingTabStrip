package com.guxiuzhong.pagerslidingtabstrip.activity;

import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import com.example.guxiuzhong.pagerslidingtab_lib.PagerSlidingTabStrip;
import com.guxiuzhong.pagerslidingtabstrip.R;
import com.guxiuzhong.pagerslidingtabstrip.adapter.MyPagerAdapter;

import java.util.ArrayList;

public class LayoutActivity extends AppCompatActivity {
    private PagerSlidingTabStrip tabs;
    private ViewPager pager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_layout);
        pager = (ViewPager) findViewById(R.id.pager);
        tabs = (PagerSlidingTabStrip) findViewById(R.id.tabs);
        ArrayList<String> list=new ArrayList<>();
        for (int i=0;i<10;i++){
            list.add("TAB "+i);
        }
        pager.setAdapter(new MyPagerAdapter(getSupportFragmentManager(),list));
        tabs.setViewPager(pager);
        pager.setCurrentItem(1);
    }
}
