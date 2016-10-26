package com.sunshine.cl.meidebi.adapter;

import android.content.Context;
import android.graphics.Bitmap;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.view.LayoutInflater;

import com.squareup.picasso.Picasso;
import com.sunshine.cl.meidebi.R;
import com.sunshine.cl.meidebi.bean.AllListViewInfo;

import java.util.List;


/**
 * Created by Administrator on 2016/10/18.
 */
public class AllListViewAdapter extends BaseAdapter {

    List<AllListViewInfo.DataBean.LinklistBean> list;
    Context context;

    public AllListViewAdapter(List<AllListViewInfo.DataBean.LinklistBean> list, Context context) {
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
            convertView = LayoutInflater.from(context).inflate(R.layout.all_listview_item,null);
            viewHolder = new ViewHolder();
            viewHolder.img = (ImageView)convertView.findViewById(R.id.all_item_img);
            viewHolder.iv1 = (ImageView)convertView.findViewById(R.id.all_item_iv1);
            viewHolder.iv2 = (ImageView)convertView.findViewById(R.id.all_item_iv2);
            viewHolder.tv1 = (TextView) convertView.findViewById(R.id.all_item_tv1);
            viewHolder.tv2 = (TextView) convertView.findViewById(R.id.all_item_tv2);
            viewHolder.tv3 = (TextView) convertView.findViewById(R.id.all_item_tv3);
            viewHolder.tv4 = (TextView) convertView.findViewById(R.id.all_item_tv4);
            viewHolder.tv5 = (TextView) convertView.findViewById(R.id.all_item_tv5);
            viewHolder.tv6 = (TextView) convertView.findViewById(R.id.all_item_tv6);
            convertView.setTag(viewHolder);
        }else {
            viewHolder = (ViewHolder) convertView.getTag();
        }
        Picasso.with(context).load(list.get(position).getImage()).config(Bitmap.Config.RGB_565).into(viewHolder.img);
        viewHolder.tv1.setText(list.get(position).getTitle());
        if (list.get(position).getPrice() != null){
            viewHolder.tv2.setText("￥"+list.get(position).getPrice());
        }else {
            viewHolder.tv2.setText(" ");
        }
        viewHolder.tv3.setText(list.get(position).getSitename());
        int time = ((int)(System.currentTimeMillis()/1000)-Integer.parseInt(list.get(position).getCreatetime()))/60;
        if (time<60){
            viewHolder.tv4.setText(String.valueOf(time)+"分钟前");
        }else {
            int hour = time/60;
            if (hour<24){
                viewHolder.tv4.setText(String.valueOf(hour)+"小时前");
            }else {
                viewHolder.tv4.setText(String.valueOf(hour/24)+"天前");
            }
        }
        viewHolder.tv5.setText(String.valueOf(list.get(position).getVotesp()));
        viewHolder.tv6.setText(String.valueOf(list.get(position).getCommentcount()));
        return convertView;
    }

    class ViewHolder{
        ImageView img;
        ImageView iv1;
        ImageView iv2;
        TextView tv1;
        TextView tv2;
        TextView tv3;
        TextView tv4;
        TextView tv5;
        TextView tv6;
    }
}
