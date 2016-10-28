package com.sunshine.cl.meidebi.adapter;

import android.content.Context;

import android.graphics.Bitmap;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.LayoutInflater;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;
import com.sunshine.cl.meidebi.R;
import com.sunshine.cl.meidebi.bean.HaiDetailInfo;
import com.sunshine.cl.meidebi.bean.MyCollectInfo;

import java.util.List;
/**
 * Created by Administrator on 2016/10/27.
 */
public class MyCollectTwoListViewAdapter extends BaseAdapter{

    List<HaiDetailInfo.DataBean> list;
    Context context;

    public MyCollectTwoListViewAdapter(List<HaiDetailInfo.DataBean> list, Context context) {
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
        ViewHolder viewHolder;
        if (convertView == null){
            convertView = LayoutInflater.from(context).inflate(R.layout.my_collect_item,null);
            viewHolder = new ViewHolder();
            viewHolder.iv = (ImageView)convertView.findViewById(R.id.my_collect_item_iv);
            viewHolder.tv = (TextView)convertView.findViewById(R.id.my_collect_item_tv);
            convertView.setTag(viewHolder);
        }else {
            viewHolder = (ViewHolder) convertView.getTag();
        }
        Picasso.with(context).load(list.get(position).getImage()).config(Bitmap.Config.RGB_565).into(viewHolder.iv);
        viewHolder.tv.setText(list.get(position).getTitle());
        return convertView;
    }

    class ViewHolder{
        ImageView iv;
        TextView tv;
    }
}
