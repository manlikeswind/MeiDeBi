package com.sunshine.cl.meidebi.activity;

import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.ImageView;
import android.widget.TimePicker;
import android.widget.RelativeLayout;
import android.view.LayoutInflater;

import com.sunshine.cl.meidebi.R;

public class PushActivity extends AppCompatActivity {

    ImageView img_back;
    TextView tv_time;
    RelativeLayout push_time;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_push);
        img_back = (ImageView)findViewById(R.id.push_back);
        tv_time = (TextView)findViewById(R.id.push_timer);
        push_time = (RelativeLayout)findViewById(R.id.push_time);
        push_time.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(PushActivity.this);
                View view = LayoutInflater.from(PushActivity.this).inflate(R.layout.dialog_push_layout,null);
                TimePicker timePicker = (TimePicker)view.findViewById(R.id.timePicker);
                final TextView tv_yes = (TextView)view.findViewById(R.id.dialog_push_yes);
                TextView tv_no = (TextView)view.findViewById(R.id.dialog_push_no);
                builder.setView(view);
                final AlertDialog dialog = builder.create();
                tv_no.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        dialog.dismiss();
                    }
                });
                timePicker.setOnTimeChangedListener(new TimePicker.OnTimeChangedListener() {
                    @Override
                    public void onTimeChanged(TimePicker view, final int hourOfDay, final int minute) {
                        tv_yes.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                tv_time.setText(hourOfDay+":"+minute+"--8:00");
                                dialog.dismiss();
                            }
                        });
                    }
                });
                dialog.show();
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
