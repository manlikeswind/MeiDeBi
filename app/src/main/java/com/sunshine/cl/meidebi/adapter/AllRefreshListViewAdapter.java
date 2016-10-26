
package com.sunshine.cl.meidebi.adapter;


import android.content.Context;
import android.graphics.Bitmap;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.squareup.picasso.Picasso;
import com.sunshine.cl.meidebi.R;
import com.sunshine.cl.meidebi.bean.AllListViewInfo;
import com.sunshine.cl.meidebi.callback.OnItemClickListener;

import java.util.List;

/**
 * Created by Administrator on 2016/10/18.
 */
public class AllRefreshListViewAdapter extends RecyclerView.Adapter<ViewHolder> {

    OnItemClickListener onItemClickListener;

    private static final int TYPE_CONTENT = 0;
    private static final int TYPE_FOOT = 1;
    ProgressBar mProgress;
    List<AllListViewInfo.DataBean.LinklistBean> list;
    Context context;


    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }

    public AllRefreshListViewAdapter(List<AllListViewInfo.DataBean.LinklistBean> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if (viewType == TYPE_CONTENT) {
            final View view = LayoutInflater.from(context).inflate(R.layout.all_listview_item, null);
            ContentViewHolder viewHolder = new ContentViewHolder(view);
            //添加点击事件
            if (onItemClickListener != null) {
                view.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        onItemClickListener.OnItemClick((int) view.getTag());
                    }
                });
            }
            return viewHolder;
        } else if (viewType == TYPE_FOOT) {
            View view = LayoutInflater.from(context).inflate(R.layout.list_item_footer, null);
            FootViewHolder footViewHolder = new FootViewHolder(view);
            return footViewHolder;
        }
        return null;
    }


    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {

        int type = getItemViewType(position);
        if (type == TYPE_CONTENT) {
            Picasso.with(context).load(list.get(position).getImage()).config(Bitmap.Config.RGB_565).into(((ContentViewHolder) holder).img);
            ((ContentViewHolder) holder).tv1.setText(list.get(position).getTitle());
            if (list.get(position).getPrice() != null) {
                ((ContentViewHolder) holder).tv2.setText("￥" + list.get(position).getPrice());
            } else {
                ((ContentViewHolder) holder).tv2.setText("");
            }
            ((ContentViewHolder) holder).tv3.setText(list.get(position).getSitename());
            int time = ((int)(System.currentTimeMillis()/1000)-Integer.parseInt(list.get(position).getCreatetime()))/60;
            if (time < 60) {
                ((ContentViewHolder) holder).tv4.setText(String.valueOf(time) + "分钟前");
            } else {
                int hour = time / 60;
                if (hour > 24) {
                    int day = hour / 24;
                    ((ContentViewHolder) holder).tv4.setText(String.valueOf(day) + "天前");
                } else {
                    ((ContentViewHolder) holder).tv4.setText(String.valueOf(hour) + "小时前");
                }
            }
            ((ContentViewHolder) holder).tv5.setText(String.valueOf(list.get(position).getVotesp()));
            ((ContentViewHolder) holder).tv6.setText(String.valueOf(list.get(position).getCommentcount()));
            //设置标志
            ((ContentViewHolder) holder).itemView.setTag(position);
        } else if (type == TYPE_FOOT) {
            mProgress = ((FootViewHolder) holder).mProgress;
        }

    }

    @Override
    public int getItemCount() {
        return list.size() + 1;
    }

    public static class ContentViewHolder extends RecyclerView.ViewHolder {
        ImageView img;//图标
        ImageView iv1;//
        ImageView iv2;
        TextView tv1;
        TextView tv2;
        TextView tv3;
        TextView tv4;
        TextView tv5;
        TextView tv6;

        public ContentViewHolder(final View itemView) {
            super(itemView);

            img = (ImageView) itemView.findViewById(R.id.all_item_img);
            iv1 = (ImageView) itemView.findViewById(R.id.all_item_iv1);
            iv2 = (ImageView) itemView.findViewById(R.id.all_item_iv2);
            tv1 = (TextView) itemView.findViewById(R.id.all_item_tv1);
            tv2 = (TextView) itemView.findViewById(R.id.all_item_tv2);
            tv3 = (TextView) itemView.findViewById(R.id.all_item_tv3);
            tv4 = (TextView) itemView.findViewById(R.id.all_item_tv4);
            tv5 = (TextView) itemView.findViewById(R.id.all_item_tv5);
            tv6 = (TextView) itemView.findViewById(R.id.all_item_tv6);
        }
    }

    public static class FootViewHolder extends RecyclerView.ViewHolder {
        ProgressBar mProgress;

        public FootViewHolder(View itemView) {
            super(itemView);
            mProgress = (ProgressBar) itemView.findViewById(R.id.progressbar);
        }
    }

    @Override
    public int getItemViewType(int position) {
        if (position + 1 == getItemCount()) {
            return TYPE_FOOT;
        } else {
            return TYPE_CONTENT;
        }
    }


    //显示正在加载的进度条
    public void showLoading() {
        if (mProgress != null) {
            mProgress.setVisibility(View.VISIBLE);
        }
    }

    //清除所有数据
    public void clear() {
        list.clear();
        notifyDataSetChanged();
    }

    //将新增数据加载到尾部,用于上拉刷新历史数据
    public void addDataAll(List<AllListViewInfo.DataBean.LinklistBean> beanList) {
        list.addAll(beanList);
        notifyDataSetChanged();
    }

    public void refreshCompleted() {
        if (mProgress != null) {
            mProgress.setVisibility(View.GONE);
        }
    }

    //获取数据集的大小
    public int getListSize() {
        return list.size();
    }

    //返回数据集合
    public List<AllListViewInfo.DataBean.LinklistBean> getList() {
        return list;
    }
}

