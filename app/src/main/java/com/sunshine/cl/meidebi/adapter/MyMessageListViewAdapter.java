package com.sunshine.cl.meidebi.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.view.LayoutInflater;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.sunshine.cl.meidebi.R;
import com.sunshine.cl.meidebi.bean.MyMessageInfo;

import java.util.List;
import java.util.Date;
import java.text.SimpleDateFormat;
/**
 * Created by Administrator on 2016/10/24.
 */
public class MyMessageListViewAdapter extends BaseAdapter{

    List<MyMessageInfo.DataBean> list;
    Context context;

    public MyMessageListViewAdapter(List<MyMessageInfo.DataBean> list, Context context) {
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
            convertView = LayoutInflater.from(context).inflate(R.layout.my_message_list_item,null);
            viewHolder = new ViewHolder();
            viewHolder.tv1 = (TextView)convertView.findViewById(R.id.my_message_item_tv1);
            viewHolder.tv2 = (TextView)convertView.findViewById(R.id.my_message_item_tv2);
            convertView.setTag(viewHolder);
        }else {
            viewHolder = (ViewHolder) convertView.getTag();
        }
        Date date = new Date(Long.parseLong(list.get(position).getCreatetime())*1000);
        SimpleDateFormat sdf = new SimpleDateFormat("MM月dd日 HH:mm");
        String sdfDate = sdf.format(date);
        viewHolder.tv1.setText(sdfDate);
        viewHolder.tv2.setText(list.get(position).getCon());
        return convertView;
    }

    class ViewHolder{
        TextView tv1;
        TextView tv2;
    }
}
