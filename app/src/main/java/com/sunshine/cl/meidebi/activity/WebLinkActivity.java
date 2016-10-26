package com.sunshine.cl.meidebi.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.webkit.WebView;
import android.widget.ProgressBar;
import android.webkit.WebChromeClient;
import android.webkit.WebViewClient;

import com.sunshine.cl.meidebi.R;
import com.sunshine.cl.meidebi.constants.Constants;

public class WebLinkActivity extends AppCompatActivity {

    ImageView link_back;
    TextView link_title;
    ProgressBar link_pb;
    WebView webView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web_link);
        link_back = (ImageView)findViewById(R.id.link_back);
        link_title = (TextView) findViewById(R.id.link_title);
        link_pb = (ProgressBar)findViewById(R.id.link_pb);
        webView = (WebView)findViewById(R.id.link_webView);
        String str = getIntent().getStringExtra("link");
        String title = getIntent().getStringExtra("title");
        int flag = getIntent().getIntExtra("flag",0);
        if (flag == 1||flag == 2){
            findViewById(R.id.link_share).setVisibility(View.GONE);
        }

        link_title.setText(title);
        webView.setWebViewClient(new WebViewClient());
        webView.setWebChromeClient(new WebChromeClient(){
            @Override
            public void onProgressChanged(WebView view, int newProgress) {
                super.onProgressChanged(view, newProgress);
                link_pb.setProgress(newProgress);
                if (newProgress==100){
                    link_pb.setVisibility(View.GONE);
                }
            }
        });
        webView.loadUrl(str);

        link_back.setOnClickListener(new View.OnClickListener() {
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
