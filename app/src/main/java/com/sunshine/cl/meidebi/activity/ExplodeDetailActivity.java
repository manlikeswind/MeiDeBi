package com.sunshine.cl.meidebi.activity;

import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.EditText;

import com.google.gson.Gson;
import com.squareup.picasso.Picasso;
import com.sunshine.cl.meidebi.constants.Constants;
import com.sunshine.cl.meidebi.R;
import com.sunshine.cl.meidebi.bean.DialogInfo;
import com.sunshine.cl.meidebi.bean.ExplodeDetailInfo;
import com.sunshine.cl.meidebi.callback.DataCallBack;
import com.sunshine.cl.meidebi.utils.HttpUtils;

import java.util.ArrayList;
import java.util.List;

public class ExplodeDetailActivity extends AppCompatActivity implements DataCallBack{

    String fixPath = Constants.EXPLODE.EXPLODE_DETAIL ;
    TextView mUrl;
    ImageView mImg;
    TextView mName;
    TextView mPrice;
    ImageView mOptions;
    ListView mListView;
    TextView mCancel;
    TextView mEditOption;
    TextView mCancelExplode;
    TextView mExplode;
    List<String> firstList;
    ArrayAdapter<String> mAdapter;
    DialogInfo dialogInfo;
    EditText editText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_explode_detail);
        initViews();
        String urlSegment = getIntent().getStringExtra("path");
        String newPath = handleUrl(urlSegment);
        HttpUtils.getInstance().setDataCallBack(this);
        HttpUtils.getInstance().getDataFromNetWork(newPath);
    }

    public void initViews(){
        mUrl = (TextView) findViewById(R.id.explode_detail_url);
        mImg = (ImageView) findViewById(R.id.explode_detail_img);
        mName = (TextView) findViewById(R.id.explode_detail_name);
        mPrice = (TextView) findViewById(R.id.explode_detail_good_price_content);
        mOptions = (ImageView) findViewById(R.id.explode_detail_class_options);
        mEditOption = (TextView) findViewById(R.id.explode_detail_options);
        editText = (EditText)findViewById(R.id.explode_detail_reason_content);

        mCancelExplode = (TextView) findViewById(R.id.explode_detail_cancel);
        mExplode = (TextView) findViewById(R.id.explode_detail_sure);

        //取消爆料
        mCancelExplode.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
                overridePendingTransition(0,R.anim.out);
            }
        });

        //立即爆料的点击事件
        mExplode.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if ("".equals(editText.getText().toString())){
                    setMyDialog("请填写推荐理由");
                }else if ("".equals(mEditOption.getText())){
                    setMyDialog("请选择商品分类");
                }else {
                    Toast.makeText(ExplodeDetailActivity.this, "爆料成功", Toast.LENGTH_SHORT).show();
                }
            }
        });



        //商品分类点击事件
        mOptions.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(ExplodeDetailActivity.this);
                View view = LayoutInflater.from(ExplodeDetailActivity.this).inflate(R.layout.explode_detail_dialog,null);
                builder.setView(view);
                mListView = (ListView) view.findViewById(R.id.explode_detail_dialog);
                mCancel = (TextView) view.findViewById(R.id.dialog_cancel);
                firstList = new ArrayList<>();

                HttpUtils.getInstance().getDataFromNetWork(Constants.EXPLODE.EXPLODE_DETAIL_GOOD_CLASS);
                HttpUtils.getInstance().setDataCallBack(new DataCallBack() {
                    @Override
                    public void getDataCallBack(String data) {
                        dialogInfo = new Gson().fromJson(data,DialogInfo.class);
                        int count = dialogInfo.getData().size();
                        for(int i = 0;i<count;i++){
                            firstList.add(dialogInfo.getData().get(i).getName());
                        }
                        mAdapter = new ArrayAdapter<>(ExplodeDetailActivity.this,android.R.layout.simple_list_item_1,firstList);
                        mListView.setAdapter(mAdapter);
                    }
                });

                final AlertDialog dialog = builder.create();
                dialog.show();
                Window window = dialog.getWindow();

                //获取window的默认布局参数
                WindowManager.LayoutParams lp = window.getAttributes();

                //对默认布局参数进行修改
                lp.gravity = Gravity.CENTER;
                lp.width = 500;
                lp.height = 400;
                //修改的内容进行设置使其生效
                window.setAttributes(lp);

                //取消的点击事件
                mCancel.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        dialog.dismiss();
                    }
                });

                //listView的点击事件
                mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                        int count = dialogInfo.getData().get(position).getValue().size();
                        firstList.clear();
                        for(int i = 0;i<count;i++){
                            firstList.add(dialogInfo.getData().get(position).getValue().get(i).getName());
                        }
                        mListView.setAdapter(new ArrayAdapter<>(ExplodeDetailActivity.this,android.R.layout.simple_list_item_1,firstList));

                        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                            @Override
                            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                                dialog.dismiss();
                                mEditOption.setText(dialogInfo.getData().get(position).getValue().get(position).getName());
                            }
                        });
                    }
                });



            }
        });
    }


    public String handleUrl(String urlSegment){
        String[] urls = fixPath.split("&");
        urls[2] = "url="+urlSegment;
        int count = urls.length;
        StringBuffer buffer = new StringBuffer();
        for(int i = 0;i<count-1;i++){
            buffer.append(urls[i]).append("&");
        }
        buffer.append(urls[count-1]);
        return buffer.toString();
    }

    @Override
    public void getDataCallBack(String data) {
        ExplodeDetailInfo info = new Gson().fromJson(data,ExplodeDetailInfo.class);
        mUrl.setText(info.getData().getLinkinfo().getLinkurl());
        Picasso.with(this).load(info.getData().getLinkinfo().getLinkimge()).into(mImg);
        mName.setText(info.getData().getLinkinfo().getTitle());
        mPrice.setText(info.getData().getLinkinfo().getProprice());
    }

    public void setMyDialog(String word){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage(word);
        builder.create().show();
    }
}
