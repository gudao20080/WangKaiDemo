package com.wk.materialnewfeaturedemo;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import java.util.ArrayList;

public class TabLayoutActivity extends AppCompatActivity {
    private TabLayout mTabLayout;
    private ViewPager mViewPager;
    private ArrayList<Fragment> mFragments;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tab_layout);
        mTabLayout = (TabLayout) findViewById(R.id.tabLayout);
        mViewPager = (ViewPager) findViewById(R.id.viewPager);
//        mTabLayout.addTab(mTabLayout.newTab().setText("Tab A"));
//        mTabLayout.addTab(mTabLayout.newTab().setText("Tab B"));
//        mTabLayout.addTab(mTabLayout.newTab().setText("Tab C"));
//        mTabLayout.addTab(mTabLayout.newTab().setText("Tab D"));

        mFragments = new ArrayList<>();
        mFragments.add(TabFragment.newInstance("Tab A", ""));
        mFragments.add(TabFragment.newInstance("Tab B", ""));
        mFragments.add(TabFragment.newInstance("Tab C", ""));
        mFragments.add(TabFragment.newInstance("Tab D", ""));
        mTabLayout.setTabMode(TabLayout.MODE_FIXED);
        mTabLayout.setTabGravity(TabLayout.GRAVITY_FILL);  //屏幕旋转后，使tab的宽度仍然等宽
//        mTabLayout.setTabGravity(TabLayout.GRAVITY_CENTER);
        mTabLayout.setTabTextColors(getResources().getColorStateList(R.color.tab_text_selector));
        mViewPager.setAdapter(new MyPagerAdapter(getSupportFragmentManager()));
        mTabLayout.setupWithViewPager(mViewPager);
        mViewPager.setOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(mTabLayout));

        mTabLayout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });



    }

    class MyPagerAdapter extends FragmentPagerAdapter{


        public MyPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            return mFragments.get(position);
        }

        @Override
        public int getCount() {
            return mFragments.size();
        }

        @Override
        public CharSequence getPageTitle(int position) {
           TabFragment tabFragment = (TabFragment) mFragments.get(position);
            String title = tabFragment.getArguments().getString("param1");

            return title;
        }
    }


}
