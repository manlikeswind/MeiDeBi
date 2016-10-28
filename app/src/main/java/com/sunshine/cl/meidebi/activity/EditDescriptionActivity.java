package com.sunshine.cl.meidebi.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import com.sunshine.cl.meidebi.R;
import com.sunshine.cl.meidebi.utils.BitmapUtil;
import com.sunshine.cl.meidebi.utils.FinalNumInter;
import com.sunshine.cl.meidebi.view.DragGridView;


import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class EditDescriptionActivity extends AppCompatActivity implements FinalNumInter, View.OnClickListener{
    @BindView(R.id.tv_back)
    ImageView tvBack;//返回按钮
    @BindView(R.id.tv_right)
    Button tvRight;//发布晒单按钮
    @BindView(R.id.dragGridView)
    DragGridView dragGridView;//显示图片
    @BindView(R.id.ediText)
    EditText ediText;//编辑发布的内容
    private List<String> dataSourceList = new ArrayList<>();
    private ImageAdaper adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_description);
        ButterKnife.bind(this);
        initView();
    }

    private void initView() {
        initData();
        initOnClickListener();
    }

    private void initOnClickListener() {
        tvBack.setOnClickListener(this);
        tvRight.setOnClickListener(this);
    }

    private void initData() {
        adapter = new ImageAdaper(this, dataSourceList);
        dragGridView.setAdapter(adapter);
        dragGridView.setOnChangeListener(new DragGridView.OnChanageListener() {
            @Override
            public void onChange(int form, int to) {
                String temp = (String) adapter.getItem(form);
                if (to < dataSourceList.size()) {
                    Collections.swap(dataSourceList, form, to);
                } else {
                    dataSourceList.add(dataSourceList.remove(form));
                }
                dataSourceList.set(to, temp);
                adapter.notifyDataSetChanged();
            }

            @Override
            public boolean onDown(int position) {
                if (position == adapter.getCount() - 1 || position == adapter.getCount() - 2) {
                    return false;
                } else {
                    return true;
                }
            }
        });
        dragGridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                ImageAdaper adapter = (ImageAdaper) parent.getAdapter();
                if (adapter.objects.size() < 9 && position == parent.getCount() - 1) {
                    Intent intent = new Intent(EditDescriptionActivity.this, SelectPictureActivity.class);
                    intent.putExtra("intent_max_num", dataSourceList.size());
                    startActivityForResult(intent, PHOTOCODE);
                } else if (position >= adapter.objects.size()) {
                    adapter.setShowDel(!adapter.getShowDel());
                    adapter.notifyDataSetInvalidated();
                } else {
                    String map = (String) adapter.getItem(position);
                    if (adapter.getShowDel()) {
                        if (null == adapter.getItem(0)) {
                        } else {
                            dataSourceList.remove(map);
                            adapter.update(dataSourceList);
                            if (dataSourceList.size() == 0) {
                            }
                        }
                    } else {

                    }
                }
            }
        });
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == PHOTOCODE && resultCode == PHOTORESULT) {
            List<String> phothpathList = data.getStringArrayListExtra("paths");
            for (String path : phothpathList) {
                dataSourceList.add(path);
            }
            adapter.setShowDel(false);
            adapter.update(dataSourceList);
        }
    }

    public class ImageAdaper extends BaseAdapter {
        private boolean isShowDel = false;
        private Context ctx;
        private List<String> objects;


        public ImageAdaper(Context ctx, List<String> objects) {
            this.objects = objects;
            this.ctx = ctx;
        }

        @Override
        public int getCount() {
            if (objects.size() < 9 && objects.size() > 0) {
                return objects.size() + 2;
            } else {
                return objects.size() + 1;
            }
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public Object getItem(int position) {
            if (position >= objects.size()) {
                return null;
            } else {
                return objects.get(position);
            }
        }

        public boolean getShowDel() {
            return isShowDel;
        }

        public void setShowDel(boolean isShowDel) {
            this.isShowDel = isShowDel;
        }

        @SuppressWarnings({"unchecked", "rawtypes"})
        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            ViewHolder viewHolder;
            String map = (String) getItem(position);//获取选中的图片的路径

            viewHolder = new ViewHolder();
            if (null == convertView) {
                convertView = LayoutInflater.from(ctx).inflate(R.layout.draggridview_items, null);
                viewHolder.dragGridView_image = (ImageView) convertView.findViewById(R.id.dragGridView_image);
                viewHolder.dragGridView_del = (ImageView) convertView.findViewById(R.id.dragGridView_del);
                convertView.setTag(viewHolder);
            } else {
                viewHolder = (ViewHolder) convertView.getTag();
            }
            if (getShowDel()) {
                viewHolder.dragGridView_del.setVisibility(View.VISIBLE);
            } else {
                viewHolder.dragGridView_del.setVisibility(View.INVISIBLE);
            }
            if (null != map) {
                BitmapUtil.setImageViewByImagLoading(ctx, map, viewHolder.dragGridView_image);
            } else {
                viewHolder.dragGridView_image.setImageResource(R.mipmap.ic_launcher);
                viewHolder.dragGridView_del.setVisibility(View.GONE);
                if (position == getCount() - 1) {
                    if (objects.size() >= 9) {
                        viewHolder.dragGridView_image.setImageDrawable(ctx.getResources().getDrawable(R.mipmap.reduce));
                    } else {
                        viewHolder.dragGridView_image.setImageDrawable(ctx.getResources().getDrawable(R.mipmap.raise));
                    }
                } else if (position == getCount() - 2) {
                    viewHolder.dragGridView_image.setImageDrawable(ctx.getResources().getDrawable(R.mipmap.reduce));
                }
            }
            return convertView;
        }

        public void update(List<String> dataSourceList) {
            this.objects = dataSourceList;
            notifyDataSetChanged();
        }

        final class ViewHolder {
            ImageView dragGridView_del;
            ImageView dragGridView_image;
        }
    }

    @Override
    public void onBackPressed() {
        finish();
        overridePendingTransition(0,R.anim.out);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.tv_back:// this is on celan
                finish();
                overridePendingTransition(0,R.anim.out);
                break;
            case R.id.tv_right: //send message
                String mContent = ediText.getText().toString().trim();
                if ("".equals(mContent)) {
                    Toast.makeText(this, "内容不能为空", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(this,"正在发布...",Toast.LENGTH_LONG).show();
                }
                break;
            default:
                break;
        }
    }

}
