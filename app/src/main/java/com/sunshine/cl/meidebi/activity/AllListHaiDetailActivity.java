package com.sunshine.cl.meidebi.activity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.webkit.WebView;
import de.hdodenhof.circleimageview.CircleImageView;

import com.google.gson.Gson;
import com.squareup.picasso.Picasso;
import com.sunshine.cl.meidebi.R;
import com.sunshine.cl.meidebi.bean.HaiDetailInfo;
import com.sunshine.cl.meidebi.callback.JsonCallBack;
import com.sunshine.cl.meidebi.constants.Constants;
import com.sunshine.cl.meidebi.http.OKHttpGetUtils;

public class AllListHaiDetailActivity extends AppCompatActivity implements JsonCallBack{

    ImageView img_back;
    TextView tv_title;
    ImageView img_share;
    ImageView img;
    TextView tv_tvTitle;
    TextView tv_price;
    TextView tv_orginprice;
    TextView tv_name;
    TextView tv_transitcompany;
    Button btn_teach;
    TextView tv_totalmoney_dec;
    CheckBox tv_otherprice;
    WebView webView1;
    CircleImageView circleImageView;
    TextView tv_myName;
    TextView tv_time;
    WebView webView2;
    RadioButton tv_support;
    CheckBox tv_collect;
    TextView tv_comment;
    TextView tv_past;
    TextView tv_link;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_all_list_hai_detail);
        img_back = (ImageView)findViewById(R.id.search_hai_detail_back);
        tv_title = (TextView)findViewById(R.id.search_hai_detail_title);
        img_share = (ImageView)findViewById(R.id.search_hai_detail_share);
        img = (ImageView)findViewById(R.id.search_hai_detail_img);
        tv_tvTitle = (TextView)findViewById(R.id.search_hai_detail_tvTitle);
        tv_price = (TextView)findViewById(R.id.search_hai_detail_price);
        tv_orginprice = (TextView)findViewById(R.id.search_hai_detail_orginprice);
        tv_name = (TextView)findViewById(R.id.search_hai_detail_name);
        tv_transitcompany = (TextView)findViewById(R.id.search_hai_detail_transitcompany);
        btn_teach = (Button)findViewById(R.id.search_hai_detail_teach);
        tv_totalmoney_dec = (TextView)findViewById(R.id.search_hai_detail_totalmoney_dec);
        tv_otherprice = (CheckBox) findViewById(R.id.search_hai_detail_otherprice);
        webView1 = (WebView)findViewById(R.id.search_hai_detail_webView1);
        circleImageView = (CircleImageView)findViewById(R.id.search_hai_detail_civ);
        tv_myName = (TextView)findViewById(R.id.search_hai_detail_myName);
        webView2 = (WebView)findViewById(R.id.search_hai_detail_webView2);
        tv_time = (TextView)findViewById(R.id.search_hai_detail_time);
        tv_support = (RadioButton) findViewById(R.id.search_hai_detail_support);
        tv_collect = (CheckBox) findViewById(R.id.search_hai_detail_collect);
        tv_comment = (TextView)findViewById(R.id.search_hai_detail_comment);
        tv_past = (TextView)findViewById(R.id.search_hai_detail_past);
        tv_link = (TextView)findViewById(R.id.search_hai_detail_link);
        String id = getIntent().getStringExtra("id");
        String path = "http://a.meidebi.com/new.php/Share-onelink?type=2&id="+id+"&devicetype=2&version=3.2.3 ";

        getShopInfo(path);
        img_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
                overridePendingTransition(0,R.anim.out);
            }
        });
    }

    public void getShopInfo(String path1){
        OKHttpGetUtils okHttpGetUtils = new OKHttpGetUtils(path1);
        okHttpGetUtils.getJsonData();
        okHttpGetUtils.setCallBack(this);
    }

    int support = 0;
    int collect = 0;
    @Override
    public void getJsonCallBack(String str) {
        Gson gson = new Gson();
        final HaiDetailInfo info = gson.fromJson(str,HaiDetailInfo.class);
        Picasso.with(this).load(info.getData().getImage()).config(Bitmap.Config.RGB_565).into(img);
        tv_tvTitle.setText(info.getData().getTitle());
        tv_tvTitle.setTypeface(Typeface.DEFAULT_BOLD);
        if (info.getData().getPrice() == null){
            tv_price.setVisibility(View.GONE);
            tv_title.setText("活动详情");
        }else {
            tv_price.setText(info.getData().getPrice());
        }
        if (info.getData().getOrginprice() == null){
            tv_orginprice.setVisibility(View.GONE);
        }else {
            tv_orginprice.setText("原价: "+info.getData().getOrginprice());
            tv_orginprice.getPaint().setFlags(Paint.STRIKE_THRU_TEXT_FLAG);
        }
        tv_name.setText(info.getData().getSitename());
        if (info.getData().getTransitcompany().getName() == null){
            tv_transitcompany.setVisibility(View.GONE);
        }else {
            tv_transitcompany.setText(info.getData().getTransitcompany().getName());
        }
        if (info.getData().getPrice() == null){
            btn_teach.setVisibility(View.GONE);
        }else {
            btn_teach.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(AllListHaiDetailActivity.this,WebTeachActivity.class);
                    intent.putExtra("teach",info.getData().getHaitaoarticle());
                    startActivity(intent);
                    overridePendingTransition(R.anim.in,0);
                }
            });
        }
        if (info.getData().getTotalmoney_dec() == null){
            tv_totalmoney_dec.setVisibility(View.GONE);
        }else {
            tv_totalmoney_dec.setText(info.getData().getTotalmoney_dec());
            tv_totalmoney_dec.setTypeface(Typeface.DEFAULT_BOLD);
        }
        if (info.getData().getPrice() == null){
            tv_otherprice.setVisibility(View.GONE);
            webView1.setVisibility(View.GONE);
        }else {
            webView1.loadUrl(Constants.BASE_PATH+info.getData().getOtherprice());
            tv_otherprice.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                    if (tv_otherprice.isChecked() == true){
                        webView1.setVisibility(View.VISIBLE);
                    }else {
                        webView1.setVisibility(View.GONE);
                    }
                }
            });
        }
        Picasso.with(this).load(info.getData().getPhoto()).config(Bitmap.Config.RGB_565).into(circleImageView);
        tv_myName.setText(info.getData().getNickname());
        int time = ((int)(System.currentTimeMillis()/1000)-Integer.parseInt(info.getData().getCreatetime()))/60;
        if (time<60){
            tv_time.setText(String.valueOf(time)+"分钟前推荐");
        }else {
            int hour = time/60;
            if (hour<24){
                tv_time.setText(String.valueOf(hour)+"小时前推荐");
            }else {
                tv_time.setText(String.valueOf(hour/24)+"天前推荐");
            }
        }
        webView2.loadUrl(Constants.BASE_PATH+info.getData().getDescription());
        tv_support.setText(info.getData().getVotesp());
        tv_support.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (support == 0){
                    support++;
                    tv_support.setText(String.valueOf(Integer.parseInt(info.getData().getVotesp())+1));
                }else {
                    setMyDialog("你已经投票过了");
                }
            }
        });
        tv_collect.setText(info.getData().getVotesm());
        tv_collect.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (collect == 0){
                    collect++;
                    tv_collect.setChecked(true);
                    tv_collect.setText(String.valueOf(Integer.parseInt(info.getData().getVotesm())+1));
                    setMyDialog("已收藏");
                }else {
                    collect--;
                    tv_collect.setChecked(false);
                    tv_collect.setText(String.valueOf(Integer.parseInt(info.getData().getVotesm())));
                }
            }
        });
        tv_comment.setText(info.getData().getCommentcount());
        tv_past.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(AllListHaiDetailActivity.this);
                builder.setView(R.layout.dialog_past_layout);
                builder.create().show();
            }
        });
        tv_link.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AllListHaiDetailActivity.this,WebLinkActivity.class);
                intent.putExtra("link",info.getData().getOuturl());
                intent.putExtra("title",info.getData().getTitle());
                startActivity(intent);
                overridePendingTransition(R.anim.in,0);
            }
        });
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
