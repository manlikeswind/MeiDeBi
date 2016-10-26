package com.sunshine.cl.meidebi.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.view.LayoutInflater;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.sunshine.cl.meidebi.R;
import com.sunshine.cl.meidebi.bean.MyCommentInfo;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
/**
 * Created by Administrator on 2016/10/25.
 */
public class MyCommentListViewAdapter extends BaseAdapter{

    List<MyCommentInfo.DataBean> list;
    Context context;

    public MyCommentListViewAdapter(List<MyCommentInfo.DataBean> list, Context context) {
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
        viewHolder.tv1.setText(list.get(position).getCreatetime());
        viewHolder.tv2.setText("在"+list.get(position).getFromtitle()+"中评论:"+list.get(position).getComment());
        return convertView;
    }

    class ViewHolder{
        TextView tv1;
        TextView tv2;
    }
}
