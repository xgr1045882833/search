package com.arron.searchdemo.adapter;

import android.content.Context;

import com.arron.searchdemo.R;
import com.arron.searchdemo.bean.Bean;

import java.util.List;

/**
 * create by Aaron Xie
 * on 2021/1/23
 * description:
 */
public class SearchAdapter extends CommonAdapter<Bean> {

    public SearchAdapter(Context context, List<Bean> data, int layoutId) {
        super(context, data, layoutId);
    }

    @Override
    public void convert(ViewHolder holder, int position) {
        holder.setImageResource(R.id.item_search_iv_icon, mData.get(position).getIconId())
                .setText(R.id.item_search_tv_title, mData.get(position).getTitle())
                .setText(R.id.item_search_tv_content, mData.get(position).getContent())
                .setText(R.id.item_search_tv_comments, mData.get(position).getComments());
    }
}
