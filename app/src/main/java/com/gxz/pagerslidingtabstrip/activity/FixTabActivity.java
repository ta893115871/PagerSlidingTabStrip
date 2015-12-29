package com.gxz.pagerslidingtabstrip.activity;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import com.gxz.PagerSlidingTabStrip;
import com.gxz.pagerslidingtabstrip.R;
import com.gxz.pagerslidingtabstrip.adapter.MyFrPagerAdapter;
import com.gxz.pagerslidingtabstrip.fragment.FragmentContent;

import java.util.ArrayList;

public class FixTabActivity extends AppCompatActivity {
    private PagerSlidingTabStrip tabs;
    private ViewPager pager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fix_tab);

        pager = (ViewPager) findViewById(R.id.pager);
        tabs = (PagerSlidingTabStrip) findViewById(R.id.tabs);
        ArrayList<String> titles = new ArrayList<>();
        titles.add("聊天");
        titles.add("联系人");
        titles.add("发现");
        titles.add("我");
        ArrayList<Fragment> fragments = new ArrayList<>();
        for (String s : titles) {
            Bundle bundle = new Bundle();
            bundle.putString("title", s);
            fragments.add(FragmentContent.getInstance(bundle));
        }
        pager.setAdapter(new MyFrPagerAdapter(getSupportFragmentManager(), titles, fragments));
        tabs.setViewPager(pager);
        pager.setCurrentItem(1);
    }
}
