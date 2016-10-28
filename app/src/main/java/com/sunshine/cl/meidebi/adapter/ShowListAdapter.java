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
import com.sunshine.cl.meidebi.bean.ShowInfo;
import com.sunshine.cl.meidebi.callback.OnItemClickListener;
import java.util.List;
import de.hdodenhof.circleimageview.CircleImageView;

/**
 * Created by Administrator on 2016/10/24.
 */
public class ShowListAdapter extends RecyclerView.Adapter<ViewHolder> {
    List<ShowInfo.DataBean.LinklistBean> list ;
    Context context;
    OnItemClickListener onItemClickListener;
    public static int CONTENT_TYPE = 0;
    public static int FOOT_TYPE = 1;

    ProgressBar mProgress;

    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }

    public ShowListAdapter(List<ShowInfo.DataBean.LinklistBean> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if (viewType == CONTENT_TYPE) {
            final View view = LayoutInflater.from(context).inflate(R.layout.show_list_item,null);
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
        else if(viewType==FOOT_TYPE){
            View view = LayoutInflater.from(context).inflate(R.layout.list_item_footer,null);
            FootViewHolder footViewHolder = new FootViewHolder(view);
            return footViewHolder;
        }
        return null;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        int type = getItemViewType(position);
        if(type==CONTENT_TYPE){

            //还有图片没有设置
            Picasso.with(context).load(list.get(position).getPic()).config(Bitmap.Config.RGB_565).into(((ContentViewHolder) holder).mImg);
            ((ContentViewHolder)holder).mTitle.setText(list.get(position).getTitle());
            Picasso.with(context).load(list.get(position).getHeadphoto()).into(((ContentViewHolder) holder).mUserPic);
            ((ContentViewHolder)holder).mUserName.setText(list.get(position).getName());
            ((ContentViewHolder)holder).mPraise.setText(list.get(position).getVotesp());
            ((ContentViewHolder)holder).mComment.setText(list.get(position).getCommentcount());

            String content = list.get(position).getContent();
            String[] strings = content.split("\n");
            StringBuffer buffer = new StringBuffer();
            for(String temp:strings){
                buffer.append(temp);
            }
            ((ContentViewHolder)holder).mContent.setText(buffer.toString());
            //设置标志
            ((ContentViewHolder)holder).itemView.setTag(position);

        }else if(type==FOOT_TYPE){
            mProgress = ((FootViewHolder)holder).mProgress;
        }
    }

    public static class ContentViewHolder extends RecyclerView.ViewHolder{
        ImageView mImg;
        TextView mTitle;
        CircleImageView mUserPic;
        TextView mUserName;
        TextView mPraise;
        TextView mComment;
        TextView mContent;

        public ContentViewHolder(View itemView) {
            super(itemView);
            mImg = (ImageView) itemView.findViewById(R.id.show_img);
            mTitle = (TextView) itemView.findViewById(R.id.show_tv_title);
            mUserPic = (CircleImageView) itemView.findViewById(R.id.show_user_pic);
            mUserName = (TextView) itemView.findViewById(R.id.show_user_name);
            mPraise = (TextView) itemView.findViewById(R.id.show_tv_good);
            mComment = (TextView) itemView.findViewById(R.id.show_tv_comment);
            mContent = (TextView) itemView.findViewById(R.id.show_tv_content);
        }
    }

    public static class FootViewHolder extends RecyclerView.ViewHolder{
        ProgressBar mProgress;
        public FootViewHolder(View itemView) {
            super(itemView);
            mProgress = (ProgressBar) itemView.findViewById(R.id.progressbar);
        }
    }

    @Override
    public int getItemCount() {
        return list.size()+1;
    }


    @Override
    public int getItemViewType(int position) {
        if(position+1==getItemCount()){
            return FOOT_TYPE;
        }else{
            return CONTENT_TYPE;
        }
    }

    //显示正在加载的进度条
    public void showLoading(){
        if(mProgress!=null){
            mProgress.setVisibility(View.VISIBLE);
        }
    }

    public void refreshCompleted(){
        if(mProgress!=null){
            mProgress.setVisibility(View.GONE);
        }
    }

    //将新增数据加载到尾部,用于上拉刷新历史数据
    public void addDataAll(List<ShowInfo.DataBean.LinklistBean> beanList){
        list.addAll(beanList);
        notifyDataSetChanged();
    }

    //返回数据集合
    public List<ShowInfo.DataBean.LinklistBean> getList(){
        return list;
    }
}
