package com.sunshine.cl.meidebi.adapter;

import android.content.Context;
import android.graphics.Bitmap;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.view.LayoutInflater;
import android.widget.BaseAdapter;

import com.squareup.picasso.Picasso;
import com.sunshine.cl.meidebi.R;
import com.sunshine.cl.meidebi.bean.TradeClassGridInfo;

import java.util.List;

/**
 * Created by Administrator on 2016/10/18.
 */
public class SearchClassGridViewAdapter extends BaseAdapter {

    List<TradeClassGridInfo.DataBean> list;
    Context context;

    public SearchClassGridViewAdapter(List<TradeClassGridInfo.DataBean> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHodler viewHodler;
        if (convertView == null){
            convertView = LayoutInflater.from(context).inflate(R.layout.search_class_grid_item,null);
            viewHodler = new ViewHodler();
            viewHodler.iv = (ImageView)convertView.findViewById(R.id.search_class_item_img);
            viewHodler.tv = (TextView)convertView.findViewById(R.id.search_class_item_tv);
            convertView.setTag(viewHodler);
        }else {
            viewHodler = (ViewHodler) convertView.getTag();
        }
        Picasso.with(context).load(list.get(position).getAndroidicon()).config(Bitmap.Config.RGB_565).into(viewHodler.iv);
        viewHodler.tv.setText(list.get(position).getName());
        return convertView;
    }

    class ViewHodler{
        ImageView iv;
        TextView tv;
    }
}
