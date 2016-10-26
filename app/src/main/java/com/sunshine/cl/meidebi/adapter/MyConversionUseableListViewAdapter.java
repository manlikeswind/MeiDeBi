package com.sunshine.cl.meidebi.adapter;

import android.content.Context;
import android.content.ClipboardManager;

import android.graphics.Bitmap;
import android.view.View;
import android.view.ViewGroup;
import android.view.LayoutInflater;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;
import com.sunshine.cl.meidebi.R;
import com.sunshine.cl.meidebi.bean.MyConversionUseableInfo;

import java.util.List;
import java.util.Date;
import java.text.SimpleDateFormat;

/**
 * Created by Administrator on 2016/10/25.
 */
public class MyConversionUseableListViewAdapter extends BaseAdapter{

    List<MyConversionUseableInfo.DataBean> list;
    Context context;

    public MyConversionUseableListViewAdapter(List<MyConversionUseableInfo.DataBean> list, Context context) {
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
    public View getView(final int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder;
        if (convertView == null){
            convertView = LayoutInflater.from(context).inflate(R.layout.my_conversion_useable_list_item,null);
            viewHolder = new ViewHolder();
            viewHolder.iv = (ImageView)convertView.findViewById(R.id.my_conversion_useable_item_img);
            viewHolder.tv1 = (TextView)convertView.findViewById(R.id.my_conversion_useable_item_tv1);
            viewHolder.tv2 = (TextView)convertView.findViewById(R.id.my_conversion_useable_item_tv2);
            viewHolder.tv3 = (TextView)convertView.findViewById(R.id.my_conversion_useable_item_tv3);
            viewHolder.tv4 = (TextView)convertView.findViewById(R.id.my_conversion_useable_item_tv4);
            viewHolder.tv5 = (TextView)convertView.findViewById(R.id.my_conversion_useable_item_tv5);
            convertView.setTag(viewHolder);
        }else {
            viewHolder = (ViewHolder) convertView.getTag();
        }
        Picasso.with(context).load(list.get(position).getImgUrl()).config(Bitmap.Config.RGB_565).into(viewHolder.iv);
        viewHolder.tv1.setText(list.get(position).getTitle());
        viewHolder.tv2.setText("券号:"+list.get(position).getCard());
        Date date1 = new Date(Long.parseLong(list.get(position).getUsestart())*1000);
        SimpleDateFormat sdf = new SimpleDateFormat("MM月dd日 HH:mm");
        String sdfDate1 = sdf.format(date1);
        viewHolder.tv3.setText("使用开始时间:"+sdfDate1);
        Date date2 = new Date(Long.parseLong(list.get(position).getUseend())*1000);
        String sdfDate2 = sdf.format(date2);
        viewHolder.tv4.setText("使用截止时间:"+sdfDate2);
        final ClipboardManager cmb = (ClipboardManager) context.getSystemService(Context.CLIPBOARD_SERVICE);
        viewHolder.tv5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cmb.setText(list.get(position).getCard());
                Toast.makeText(context, "券码已经复制到剪切板", Toast.LENGTH_SHORT).show();
            }
        });
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
