package com.sunshine.cl.meidebi.adapter;

import android.content.Context;
import android.graphics.Bitmap;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.view.LayoutInflater;
import android.widget.BaseAdapter;

import com.squareup.picasso.Picasso;
import com.sunshine.cl.meidebi.R;
import com.sunshine.cl.meidebi.bean.HotStoreGridInfo;

import java.util.List;
/**
 * Created by Administrator on 2016/10/19.
 */
public class SearchHotGridViewHaiAdapter extends BaseAdapter{

    List<HotStoreGridInfo.DataBean.HaitaoBean> list;
    Context context;

    public SearchHotGridViewHaiAdapter(List<HotStoreGridInfo.DataBean.HaitaoBean> list, Context context) {
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
            convertView = LayoutInflater.from(context).inflate(R.layout.search_hot_grid_item,null);
            viewHolder = new ViewHolder();
            viewHolder.iv = (ImageView)convertView.findViewById(R.id.search_hot_item_img);
            convertView.setTag(viewHolder);
        }else {
            viewHolder = (ViewHolder) convertView.getTag();
        }
        Picasso.with(context).load(list.get(position).getAndroidicon()).config(Bitmap.Config.RGB_565).into(viewHolder.iv);
        return convertView;
    }

    class ViewHolder{
        ImageView iv;
    }
}
