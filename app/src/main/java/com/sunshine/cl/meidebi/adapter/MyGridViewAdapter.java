package com.sunshine.cl.meidebi.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.view.LayoutInflater;
import android.widget.BaseAdapter;

import com.sunshine.cl.meidebi.R;

/**
 * Created by Administrator on 2016/10/22.
 */
public class MyGridViewAdapter extends BaseAdapter{

    int[] imgs;
    String[] title;
    Context context;

    public MyGridViewAdapter(int[] imgs, String[] title, Context context) {
        this.imgs = imgs;
        this.title = title;
        this.context = context;
    }

    @Override
    public int getCount() {
        return imgs.length;
    }

    @Override
    public Object getItem(int position) {
        return imgs[position];
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
        viewHodler.iv.setImageResource(imgs[position]);
        viewHodler.tv.setText(title[position]);
        return convertView;
    }

    class ViewHodler{
        ImageView iv;
        TextView tv;
    }
}
