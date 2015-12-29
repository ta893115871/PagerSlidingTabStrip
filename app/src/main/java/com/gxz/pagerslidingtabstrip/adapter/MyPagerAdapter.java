package com.gxz.pagerslidingtabstrip.adapter;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.view.ViewGroup;

import com.gxz.pagerslidingtabstrip.fragment.FragmentContent;

import java.util.ArrayList;

/**
 * @author 顾修忠-guxiuzhong@youku.com/gfj19900401@163.com
 * @Title: MyPagerAdapter
 * @Package com.guxiuzhong.pagerslidingtabstrip.adapter
 * @Description:
 * @date 15/11/29
 * @time 下午12:53
 */
public class MyPagerAdapter extends FragmentPagerAdapter {

    private ArrayList<String> titles;

    public MyPagerAdapter(FragmentManager fm, ArrayList<String> list) {
        super(fm);
        this.titles = list;
    }


    @Override
    public CharSequence getPageTitle(int position) {
        return titles.get(position);
    }

    @Override
    public int getCount() {
        return titles.size();
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        return super.instantiateItem(container, position);
    }

    @Override
    public Fragment getItem(int position) {
        Bundle b = new Bundle();
        b.putString("title", titles.get(position));
        return FragmentContent.getInstance(b);
    }
}
