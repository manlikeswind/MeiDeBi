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
import com.sunshine.cl.meidebi.bean.MyExplodeInfo;

import java.util.List;
import java.util.Date;
import java.text.SimpleDateFormat;

/**
 * Created by Administrator on 2016/10/24.
 */
public class MyExplodeListViewAdapter extends BaseAdapter{

    List<MyExplodeInfo.DataBean> list;
    Context context;

    public MyExplodeListViewAdapter(List<MyExplodeInfo.DataBean> list, Context context) {
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
            convertView = LayoutInflater.from(context).inflate(R.layout.my_explode_list_item,null);
            viewHolder = new ViewHolder();
            viewHolder.iv = (ImageView)convertView.findViewById(R.id.my_explode_item_img);
            viewHolder.tv1 = (TextView)convertView.findViewById(R.id.my_explode_item_tv1);
            viewHolder.tv2 = (TextView)convertView.findViewById(R.id.my_explode_item_tv2);
            viewHolder.tv3 = (TextView)convertView.findViewById(R.id.my_explode_item_tv3);
            viewHolder.tv4 = (TextView)convertView.findViewById(R.id.my_explode_item_tv4);
            viewHolder.tv5 = (TextView)convertView.findViewById(R.id.my_explode_item_tv5);
            convertView.setTag(viewHolder);
        }else {
            viewHolder = (ViewHolder) convertView.getTag();
        }
        Picasso.with(context).load(list.get(position).getImage()).config(Bitmap.Config.RGB_565).into(viewHolder.iv);
        viewHolder.tv1.setText(list.get(position).getTitle());
        viewHolder.tv2.setText("￥"+list.get(position).getPrice());
        viewHolder.tv3.setText("商城:"+list.get(position).getSitename());
        Date date = new Date(Long.parseLong(list.get(position).getCreatetime())*1000);
        SimpleDateFormat sdf = new SimpleDateFormat("MM月dd日 HH:mm");
        String sdfDate = sdf.format(date);
        viewHolder.tv4.setText("爆料时间:"+sdfDate);
        viewHolder.tv5.setText("状态:"+list.get(position).getStatustext());
        return convertView;
    }

    class ViewHolder{
        ImageView iv;
        TextView tv1;
        TextView tv2;
        TextView tv3;
        TextView tv4;
        TextView tv5;
    }
}
