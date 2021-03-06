package com.sunshine.cl.meidebi.activity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.TextView;
import android.net.Uri;

import com.google.gson.Gson;
import com.makeramen.roundedimageview.RoundedImageView;
import com.squareup.picasso.Picasso;
import com.sunshine.cl.meidebi.constants.Constants;
import com.sunshine.cl.meidebi.R;
import com.sunshine.cl.meidebi.bean.ShowDetailInfo;
import com.sunshine.cl.meidebi.callback.DataCallBack;
import com.sunshine.cl.meidebi.utils.HttpUtils;

import java.text.SimpleDateFormat;
import java.util.Date;

public class ShowDetailActivity extends AppCompatActivity implements DataCallBack{

    TextView mTitle;
    RoundedImageView mImg;
    ImageView mUserImg;
    TextView mUserName;
    TextView mTime;
    TextView mSite;

    ImageView mBack;
    ImageView mShare;

    WebView mContent;
    RadioButton mPraise;
    CheckBox mFavor;
    TextView mComment;

    String newPath;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_detail);
        initViews();
        Intent intent = getIntent();
        String id = intent.getStringExtra("id");
        newPath = handleUrl(id);
        HttpUtils.getInstance().setDataCallBack(this);
        HttpUtils.getInstance().getDataFromNetWork(newPath);

    }

    public void initViews(){
        mTitle = (TextView) findViewById(R.id.show_detail_title);
        mImg = (RoundedImageView) findViewById(R.id.show_detail_img);
        mUserImg = (ImageView) findViewById(R.id.show_detail_user_pic);
        mUserName = (TextView) findViewById(R.id.show_detail_tvTitle);
        mTime = (TextView) findViewById(R.id.show_detail_time);
        mSite = (TextView) findViewById(R.id.show_detail_site);
        mBack = (ImageView) findViewById(R.id.show_detail_back);
        mShare = (ImageView) findViewById(R.id.show_detail_share);
        mContent = (WebView) findViewById(R.id.show_detail_webView2);

        mPraise = (RadioButton) findViewById(R.id.show_detail_support);
        mFavor = (CheckBox) findViewById(R.id.show_detail_collect);
        mComment = (TextView) findViewById(R.id.show_detail_comment);

        //返回的点击事件
        mBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
                overridePendingTransition(0,R.anim.out);
            }
        });
    }

    public String handleUrl(String id){
        String path = Constants.SHOW.SHOW_DETAIL;
        String[] urls = path.split("&");
        urls[1] = "id="+id;
        StringBuffer buffer = new StringBuffer();
        int count = urls.length;
        for(int i= 0;i<count-1;i++){
            buffer.append(urls[i]).append("&");
        }
        buffer.append(urls[count-1]);
        return buffer.toString();
    }

    int support = 0;
    int collect = 0;
    @Override
    public void getDataCallBack(String data) {
        final ShowDetailInfo showDetailInfo = new Gson().fromJson(data,ShowDetailInfo.class);
        Picasso.with(this).load(showDetailInfo.getData().getPic()).config(Bitmap.Config.RGB_565).into(mImg);
        mTitle.setText(showDetailInfo.getData().getTitle());
        Picasso.with(this).load(showDetailInfo.getData().getSharephoto()).into(mUserImg);
        mUserName.setText(showDetailInfo.getData().getSharename());
        String publishTime = transferTime(showDetailInfo.getData().getSetpftime());
        mTime.setText(publishTime);
        mSite.setText("商城:"+showDetailInfo.getData().getSite().getName());
        mPraise.setText(showDetailInfo.getData().getVotesp());
        mFavor.setText(showDetailInfo.getData().getFavnum());
        mComment.setText(showDetailInfo.getData().getCommentcount());
        mContent.loadData(showDetailInfo.getData().getContent(),"text/html;charset=utf-8",null);
        //分享的点击事件
        mShare.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Intent.ACTION_SEND);
                intent.setType("text/plain");
                intent.putExtra(Intent.EXTRA_TEXT, newPath);
                startActivity(Intent.createChooser(intent,"分享"));
            }
        });

        mPraise.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (support == 0){
                    support++;
                    mPraise.setText(String.valueOf(Integer.parseInt(showDetailInfo.getData().getVotesp())+1));
                }else {
                    setMyDialog("你已经投票过了");
                }
            }
        });
        mFavor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (collect == 0){
                    collect++;
                    mFavor.setChecked(true);
                    mFavor.setText(String.valueOf(Integer.parseInt(showDetailInfo.getData().getFavnum())+1));
                    setMyDialog("已收藏");
                }else {
                    collect--;
                    mFavor.setChecked(false);
                    mFavor.setText(String.valueOf(Integer.parseInt(showDetailInfo.getData().getFavnum())));
                }
            }
        });
        //评论的点击事件
        mComment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }

    public String transferTime(String string){
        long time = Long.parseLong(string)*1000;
        Date date = new Date(time);
        SimpleDateFormat format = new SimpleDateFormat("MM月dd日 HH:mm");
        return format.format(date);
    }

    public void setMyDialog(String word){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage(word);
        builder.create().show();
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
        overridePendingTransition(0,R.anim.out);
    }
}
