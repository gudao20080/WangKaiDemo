package com.wangkai.pagertabstriptest;

import android.app.Activity;
import android.support.v4.view.PagerTabStrip;
import android.support.v4.view.ViewPager;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;


public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ViewPager pager = (ViewPager) findViewById(R.id.vp);
        PagerTabStrip tabStrip = (PagerTabStrip) findViewById(R.id.pts);

        PtPagerAdapter adapter = new PtPagerAdapter(this);

        pager.setAdapter(adapter);
    }



}
