package com.sunshine.cl.meidebi.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Button;

import com.sunshine.cl.meidebi.R;

public class MyTaskActivity extends AppCompatActivity {

    ImageView img_back;
    TextView task_rule;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_task);
        img_back = (ImageView)findViewById(R.id.task_back);
        task_rule = (TextView)findViewById(R.id.task_rule);

        setOnClick();
    }

    public void setOnClick(){
        img_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
                overridePendingTransition(0,R.anim.out);
            }
        });
        task_rule.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MyTaskActivity.this,WebLinkActivity.class);
                intent.putExtra("title","规则");
                intent.putExtra("flag",2);
                intent.putExtra("link","http://a.meidebi.com/new.php/Content-taskrule.html");
                startActivity(intent);
                overridePendingTransition(R.anim.in,0);
            }
        });
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
        overridePendingTransition(0,R.anim.out);
    }
}
