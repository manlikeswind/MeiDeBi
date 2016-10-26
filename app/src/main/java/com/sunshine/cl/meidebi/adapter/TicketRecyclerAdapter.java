package com.sunshine.cl.meidebi.adapter;
import android.content.Context;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;
import com.sunshine.cl.meidebi.R;
import com.sunshine.cl.meidebi.bean.TicketInfo;
import com.sunshine.cl.meidebi.callback.OnItemClickListener;

import java.util.List;

/**
 * Created by Administrator on 2016/10/22.
 */
public class TicketRecyclerAdapter extends RecyclerView.Adapter<ViewHolder>{

    OnItemClickListener onItemClickListener;
    List<TicketInfo.DataEntity.LinklistEntity> list;
    Context context;

    public TicketRecyclerAdapter(List<TicketInfo.DataEntity.LinklistEntity> list, Context context) {
        this.list = list;
        this.context = context;
    }

    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }


    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        final View view = LayoutInflater.from(context).inflate(R.layout.conversion_list_item,null);
        ContentViewHolder contentViewHolder = new ContentViewHolder(view);
        //添加点击事件
        if(onItemClickListener!=null){
            view.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    onItemClickListener.OnItemClick((int)view.getTag());
                }
            });
        }
        return contentViewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Picasso.with(context).load(list.get(position).getImgUrl())
                .into(((ContentViewHolder)holder).img);
        ((ContentViewHolder)holder).tv1.setText(list.get(position).getJian());
        ((ContentViewHolder)holder).tv2.setText("满"+list.get(position).getMan()+"使用");
        ((ContentViewHolder)holder).itemView.setTag(position);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public static class ContentViewHolder extends RecyclerView.ViewHolder{
        ImageView img;
        TextView tv1;
        TextView tv2;
        public ContentViewHolder(View itemView) {
            super(itemView);
            img = (ImageView) itemView.findViewById(R.id.conversion_logo);
            tv1 = (TextView) itemView.findViewById(R.id.conversion_price);
            tv2 = (TextView) itemView.findViewById(R.id.conversion_price_detail);
            itemView.setTag(this);
        }
    }

    //获取数据集的大小
    public int getListSize(){
        return list.size();
    }

    //返回数据集合
    public List<TicketInfo.DataEntity.LinklistEntity> getList(){
        return list;
    }
}
