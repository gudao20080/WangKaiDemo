package com.wangkai.pagertabstriptest;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

/**
 * User: WangKai(123940232@qq.com)
 * 2015-03-13 10:48
 */
public class PtPagerAdapter extends PagerAdapter {
    private Context mContext;
    private List<String> titleList;
    private List<View> viewList;
    private View view1, view2, view3;//需要滑动的页卡


    public PtPagerAdapter(Context context) {

        mContext = context;

        titleList = new ArrayList<>();// 每个页面的Title数据
        titleList.add("wp");
        titleList.add("jy");
        titleList.add("jh");

        viewList = new ArrayList<>();


        view1 = View.inflate(context, R.layout.layout_a, null);

        view2 = View.inflate(context, R.layout.layout_b, null);
        view3 = View.inflate(context, R.layout.layout_c, null);

        viewList = new ArrayList<View>();// 将要分页显示的View装入数组中
        viewList.add(view1);
        viewList.add(view2);
        viewList.add(view3);
    }

    @Override
    public int getCount() {
        return titleList.size();
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        View view = viewList.get(position);
        container.addView(view, position);

        return view;
    }

    @Override
    public int getItemPosition(Object object) {
        return super.getItemPosition(object);
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return titleList.get(position);
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView(viewList.get(position));
    }
}
