package com.sunshine.cl.meidebi.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.view.View;
import android.widget.ImageView;
import android.webkit.WebView;
import android.widget.ProgressBar;
import android.webkit.WebChromeClient;
import android.webkit.WebViewClient;

import com.sunshine.cl.meidebi.R;
import com.sunshine.cl.meidebi.constants.Constants;

public class WebTeachActivity extends AppCompatActivity {

    ImageView teach_back;
    ImageView teach_share;
    ProgressBar teach_pb;
    WebView webView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web_teach);
        teach_back = (ImageView)findViewById(R.id.teach_back);
        teach_share = (ImageView)findViewById(R.id.teach_share);
        teach_pb = (ProgressBar)findViewById(R.id.teach_pb);
        webView = (WebView)findViewById(R.id.teach_webView);
        String str = getIntent().getStringExtra("teach");

        webView.setWebViewClient(new WebViewClient());
        webView.setWebChromeClient(new WebChromeClient(){
            @Override
            public void onProgressChanged(WebView view, int newProgress) {
                super.onProgressChanged(view, newProgress);
                teach_pb.setProgress(newProgress);
                if (newProgress==100){
                    teach_pb.setVisibility(View.GONE);
                }
            }
        });
        webView.loadUrl(Constants.BASE_PATH+str);

        teach_back.setOnClickListener(new View.OnClickListener() {
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
