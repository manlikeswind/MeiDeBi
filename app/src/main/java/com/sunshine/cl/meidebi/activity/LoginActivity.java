package com.sunshine.cl.meidebi.activity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.sunshine.cl.meidebi.MainActivity;
import com.sunshine.cl.meidebi.R;

public class LoginActivity extends AppCompatActivity {

    ImageView img_back;
    TextView tv_register;
    EditText edit_name;
    EditText edit_pwd;
    TextView tv_login;
    SharedPreferences sp;
    SharedPreferences.Editor editor;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        img_back = (ImageView)findViewById(R.id.login_back);
        tv_register = (TextView)findViewById(R.id.register);
        edit_name = (EditText)findViewById(R.id.login_tv_name);
        edit_pwd = (EditText)findViewById(R.id.login_pwd);
        tv_login = (TextView)findViewById(R.id.login);
        sp = getSharedPreferences("me",MODE_PRIVATE);
        editor = sp.edit();
        tv_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!"".equals(edit_name.getText().toString())&!"".equals(edit_name.getText().toString())){
                    editor.putInt("status",1);
                    editor.putString("name",edit_name.getText().toString());
                    editor.commit();
                    Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                    intent.putExtra("flag",1);
                    startActivity(intent);
                    overridePendingTransition(0,R.anim.out);
                }else {
                    Toast.makeText(LoginActivity.this, "请填写完整的信息再登录", Toast.LENGTH_SHORT).show();
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
