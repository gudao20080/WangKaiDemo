package com.wangkai.test;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * User: WangKai(123940232@qq.com)
 * 2015-06-16 17:09
 */
public class SelectMarkAdapter extends BaseAdapter {
    private Context mContext;

    private List<String> mMarks;
    private List<String> mSelectedMarks;

    public SelectMarkAdapter(Context mContext, List<String> mMarks, List<String> mSelectedMarks) {
        this.mContext = mContext;
        this.mMarks = mMarks;
        this.mSelectedMarks = mSelectedMarks;
    }


    @Override
    public int getCount() {
        return mMarks.size();
    }

    @Override
    public Object getItem(int position) {
        return mMarks.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        ViewHolder holder;
        if (null == convertView) {
            holder = new ViewHolder();
            convertView = View.inflate(mContext, R.layout.layout_mark_item, null);
            holder.mDescTv = (TextView) convertView.findViewById(R.id.tv_desc);
            holder.mImageView = (ImageView) convertView.findViewById(R.id.iv_select);
        }else {
            holder = (ViewHolder) convertView.getTag();
        }

        holder.mDescTv.setText(mMarks.get(position));


        convertView.setTag(holder);
        return convertView;
    }

   class ViewHolder{

        private TextView mDescTv;
        private ImageView mImageView;

    }


}
