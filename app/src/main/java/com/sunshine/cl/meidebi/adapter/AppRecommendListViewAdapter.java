package com.sunshine.cl.meidebi.adapter;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AlertDialog;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;
import com.sunshine.cl.meidebi.R;
import com.sunshine.cl.meidebi.bean.AppRecommendInfo;
import java.util.List;

/**
 * Created by Administrator on 2016/10/24.
 */
public class AppRecommendListViewAdapter extends BaseAdapter {
    TextView mCancel;
    TextView mSure;
    TextView mUrl;

    List<AppRecommendInfo.DataBean> list;
    Context context;
    WindowManager.LayoutParams lp;

    public AppRecommendListViewAdapter(List<AppRecommendInfo.DataBean> list, Context context) {
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
        lp = new WindowManager.LayoutParams();
        if(convertView==null){
            convertView = LayoutInflater.from(context).inflate(R.layout.app_recommend_list_item,null);
            viewHolder = new ViewHolder(convertView);
        }else{
            viewHolder = (ViewHolder) convertView.getTag();
        }
        Picasso.with(context).load(list.get(position).getApplogo()).into(viewHolder.mImg);
        viewHolder.mAppName.setText(list.get(position).getAppname());
        viewHolder.mDescription.setText(list.get(position).getAppdesc());
        final String mAppUrl = list.get(position).getAppurl();
        viewHolder.mDownload.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //弹窗
                AlertDialog.Builder builder = new AlertDialog.Builder(context);
                View view = LayoutInflater.from(context).inflate(R.layout.layout_options,null);
                mCancel = (TextView) view.findViewById(R.id.options_cancel);
                mSure = (TextView) view.findViewById(R.id.options_sure);
                mUrl = (TextView) view.findViewById(R.id.options_url);
                mUrl.setText(mAppUrl);
                builder.setView(view);
                final AlertDialog dialog = builder.create();
                dialog.show();
                Window window = dialog.getWindow();
                window.setBackgroundDrawableResource(android.R.color.white);
                //设置对话框的window与屏幕之间的间隙
                window.getDecorView().setPadding(0,0,0,0);
                //给window窗口设置动画
                window.setWindowAnimations(R.style.dialogAnimation);
                lp = window.getAttributes();
                lp.gravity = Gravity.BOTTOM;
                lp.height = 155;
                window.setAttributes(lp);
                //取消
                mCancel.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        dialog.dismiss();
                    }
                });
                //确定,就下载
                mSure.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(Intent.ACTION_VIEW);
                        intent.setData(Uri.parse(mAppUrl));
                        context.startActivity(intent);
                    }
                });
            }
        });
        return convertView;
    }
    class ViewHolder{
        ImageView mImg;
        TextView mAppName;
        TextView mDescription;
        Button mDownload;
        View view;

        public ViewHolder(View view) {
            this.view = view;
            mImg = (ImageView) view.findViewById(R.id.app_recommend_list_logo);
            mAppName = (TextView) view.findViewById(R.id.app_recommend_list_title);
            mDescription = (TextView) view.findViewById(R.id.app_recommend_list_logo_description);
            mDownload = (Button) view.findViewById(R.id.app_recommend_list_download);
            view.setTag(this);
        }
    }
}
