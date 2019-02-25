package com.aytekincomez.webviewkullanimi;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class WebActivity extends AppCompatActivity {
    WebView webView;
    CustomWEbViewClient wEbViewClient;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web);

        webView = (WebView)findViewById(R.id.webView);
        String str = getIntent().getStringExtra("url");

        webView.loadUrl("https://www.google.com.tr/search?q="+str);
        webView.getSettings().setJavaScriptEnabled(true);
        webView.getSettings().setSupportZoom(true);
        webView.getSettings().setBuiltInZoomControls(true);

        wEbViewClient = new CustomWEbViewClient();
        wEbViewClient.setContext(this);

        webView.setWebViewClient(wEbViewClient);
    }

    private class CustomWEbViewClient extends WebViewClient{

        Activity activity;
        public void setContext(Activity activity){
            this.activity = activity;
        }
        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            view.loadUrl(url);
            activity.setTitle(view.getTitle());
            return true;
        }
    }
}
