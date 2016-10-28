package com.sunshine.cl.meidebi.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.sunshine.cl.meidebi.R;

public class DisplayActivity extends AppCompatActivity {

    ImageView img_back;
    EditText editText;
    Button btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display);
        img_back = (ImageView)findViewById(R.id.display_back);
        editText = (EditText)findViewById(R.id.display_editText);
        btn = (Button)findViewById(R.id.display_btn);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (editText.getText().toString().indexOf("http") != -1){
                    Intent intent = new Intent(DisplayActivity.this,ExplodeDetailActivity.class);
                    intent.putExtra("path",editText.getText().toString());
                    startActivity(intent);
                }else {
                    Toast.makeText(DisplayActivity.this, "请输入正确的网址", Toast.LENGTH_SHORT).show();
                }
            }
        });
        img_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
                overridePendingTransition(0,R.anim.out);
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
