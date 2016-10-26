package com.sunshine.cl.meidebi.adapter;

import android.content.Context;

import android.graphics.Bitmap;
import android.view.View;
import android.view.ViewGroup;
import android.view.LayoutInflater;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;
import com.sunshine.cl.meidebi.R;
import com.sunshine.cl.meidebi.bean.MyShowInfo;

import android.util.Log;
import java.util.List;
import java.util.Date;
import java.text.SimpleDateFormat;

/**
 * Created by Administrator on 2016/10/25.
 */
public class MyShowListViewAdapter extends BaseAdapter {

    List<MyShowInfo.DataBean> list;
    Context context;

    public MyShowListViewAdapter(List<MyShowInfo.DataBean> list, Context context) {
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
            convertView = LayoutInflater.from(context).inflate(R.layout.my_show_done_list_item,null);
            viewHolder = new ViewHolder();
            viewHolder.iv = (ImageView)convertView.findViewById(R.id.my_show_done_item_iv);
            viewHolder.tv1 = (TextView)convertView.findViewById(R.id.my_show_done_item_tv1);
            viewHolder.tv2 = (TextView)convertView.findViewById(R.id.my_show_done_item_tv2);
            viewHolder.tv3 = (TextView)convertView.findViewById(R.id.my_show_done_item_tv3);
            viewHolder.tv4 = (TextView)convertView.findViewById(R.id.my_show_done_item_tv4);
            convertView.setTag(viewHolder);
        }else {
            viewHolder = (ViewHolder) convertView.getTag();
        }
        String[] str = list.get(position).getOrgimages().split("\"");
        Picasso.with(context).load(str[1]).config(Bitmap.Config.RGB_565).into(viewHolder.iv);
        viewHolder.tv1.setText(list.get(position).getTitle());
        Date date1 = new Date(Long.parseLong(list.get(position).getCreatetime())*1000);
        SimpleDateFormat sdf = new SimpleDateFormat("MM月dd日 HH:mm");
        String sdfDate1 = sdf.format(date1);
        viewHolder.tv2.setText("晒单时间:"+sdfDate1);
        viewHolder.tv3.setText("晒单来源:手机");
        if (list.get(position).getStatus().equals("0")){
            viewHolder.tv4.setText("晒单状态:审核未通过");
        }else {
            viewHolder.tv4.setText("晒单状态:审核已通过");
        }
        return convertView;
    }

    class ViewHolder{
        ImageView iv;
        TextView tv1;
        TextView tv2;
        TextView tv3;
        TextView tv4;
    }
}
