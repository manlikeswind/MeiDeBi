package com.sunshine.cl.meidebi.activity;

import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.LayoutInflater;
import android.widget.ImageView;
import android.widget.TextView;
import android.webkit.WebView;
import android.widget.CheckBox;
import android.widget.Button;

import com.google.gson.Gson;
import com.squareup.picasso.Picasso;
import com.sunshine.cl.meidebi.R;
import com.sunshine.cl.meidebi.constants.Constants;
import com.sunshine.cl.meidebi.bean.ConversionDetailInfo;
import com.sunshine.cl.meidebi.callback.DataCallBack;
import com.sunshine.cl.meidebi.utils.HttpUtils;

import java.text.SimpleDateFormat;
import java.util.Date;

public class ConversionDetailActivity extends AppCompatActivity implements DataCallBack {

    String id;
    ImageView mImg;
    TextView mTicketName;
    TextView mPrice;
    TextView mConversionEndTime;
    TextView mUseStartTime;
    TextView mUseEndTime;
    WebView mContent;
    CheckBox mCollect;
    TextView mPraise;
    TextView mComment;
    Button btn;

    int collect = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_conversion_detail);
        Intent intent = getIntent();
        id = intent.getStringExtra("id");
        String[] urls = Constants.CONVERSION.CONVERSION_DETAIL.split("&");
        urls[2] = "id=" + id;
        StringBuffer buffer = new StringBuffer();
        int count = urls.length;
        for (int i = 0; i < count - 1; i++) {
            buffer.append(urls[i]).append("&");
        }
        buffer.append(urls[count - 1]);
        String path = buffer.toString();
        initViews();
        HttpUtils.getInstance().setDataCallBack(this);
        HttpUtils.getInstance().getDataFromNetWork(path);
        findViewById(R.id.conversion_detail_back).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
                overridePendingTransition(0,R.anim.out);
            }
        });
    }

    public void initViews() {
        mImg = (ImageView) findViewById(R.id.conversion_detail_pic);
        mTicketName = (TextView) findViewById(R.id.conversion_detail_ticket_name);
        mPrice = (TextView) findViewById(R.id.conversion_detail_price);
        mConversionEndTime = (TextView) findViewById(R.id.conversion_detail_content_endTime);
        mUseStartTime = (TextView) findViewById(R.id.conversion_detail_content_startTime);
        mUseEndTime = (TextView) findViewById(R.id.conversion_detail_content_ues_endTime);
        mContent = (WebView) findViewById(R.id.conversion_detail_description);
        mCollect = (CheckBox) findViewById(R.id.conversion_detail_good_img);
        mPraise = (TextView) findViewById(R.id.conversion_detail_good_tv);
        mComment = (TextView) findViewById(R.id.conversion_detail_comment_tv);
        btn = (Button) findViewById(R.id.conversion_detail_btn);
    }

    public String timeTransform(String time) {
        Date date = new Date(Long.parseLong(time) * 1000);
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        return format.format(date).toString();
    }

    @Override
    public void getDataCallBack(String data) {
        ConversionDetailInfo conversionDetailInfo = new Gson().fromJson(data, ConversionDetailInfo.class);
        final ConversionDetailInfo.DataBean.CouponBean bean = conversionDetailInfo.getData().getCoupon();
        Picasso.with(this).load(bean.getImgUrl()).into(mImg);
        mTicketName.setText(bean.getTitle());
        mPrice.setText(bean.getCopper() + "铜币兑换");
        mConversionEndTime.setText(timeTransform(bean.getGetend()));
        mUseStartTime.setText(timeTransform(bean.getUsestart()));
        mUseEndTime.setText(timeTransform(bean.getUseend()));
        mContent.loadData(bean.getDescription(), "text/html;charset=utf-8", null);
        mPraise.setText(bean.getFavnum());
        mCollect.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (collect == 0) {
                    collect++;
                    mCollect.setChecked(true);
                    mPraise.setText(String.valueOf(Integer.parseInt(bean.getFavnum()) + 1));
                    setMyDialog("已收藏");
                } else {
                    collect--;
                    mCollect.setChecked(false);
                    mPraise.setText(String.valueOf(Integer.parseInt(bean.getFavnum())));
                }
            }
        });
        mComment.setText(bean.getCommentcount());
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(ConversionDetailActivity.this);
                View view = LayoutInflater.from(ConversionDetailActivity.this).inflate(R.layout.dialog_conversion_layout, null);
                TextView tv_count = (TextView) view.findViewById(R.id.dialog_conversion_count);
                TextView tv_yes = (TextView) view.findViewById(R.id.dialog_conversion_yes);
                TextView tv_no = (TextView) view.findViewById(R.id.dialog_conversion_no);
                tv_count.setText(bean.getCopper());
                builder.setView(view);
                final AlertDialog dialog = builder.create();
                dialog.show();
                tv_yes.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (2 < Integer.parseInt(bean.getCopper())) {
                            dialog.dismiss();
                            setMyDialog("铜币不足");
                        } else {
                            dialog.dismiss();
                            setMyDialog("兑换成功");
                        }
                    }
                });
                tv_no.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        dialog.dismiss();
                    }
                });
            }
        });
    }

    public void setMyDialog(String word) {
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

