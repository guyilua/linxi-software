package com.rtk.app.custom.TestPost;

import android.R;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.rtk.app.base.BaseActivity;
import com.rtk.app.tool.c0;
import com.rtk.app.tool.t;
import com.ss.android.download.api.constant.BaseConstants;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class TestPostHtmlPageActivity extends BaseActivity {
    private String q;
    private String r;

    @BindView
    ImageView testPostHtmlBack;

    @BindView
    ImageView testPostHtmlGo;

    @BindView
    ImageView testPostHtmlHome;

    @BindView
    TextView testPostHtmlPageBack;

    @BindView
    LinearLayout testPostHtmlPageLv;

    @BindView
    ProgressBar testPostHtmlProgressBar;

    @BindView
    TextView testPostHtmlUseBrowser;

    @BindView
    WebView testPostHtmlWebView;

    /* loaded from: /tmp/rtk_apk/classes3.dex */
    class a extends WebChromeClient {
        a() {
        }

        @Override // android.webkit.WebChromeClient
        public void onProgressChanged(WebView webView, int i) {
            super.onProgressChanged(webView, i);
            if (i == 100) {
                TestPostHtmlPageActivity.this.testPostHtmlProgressBar.setVisibility(8);
                return;
            }
            TestPostHtmlPageActivity.this.testPostHtmlProgressBar.setVisibility(0);
            TestPostHtmlPageActivity.this.testPostHtmlProgressBar.setProgress(i);
            TestPostHtmlPageActivity.this.testPostHtmlProgressBar.setMax(100);
        }
    }

    /* loaded from: /tmp/rtk_apk/classes3.dex */
    class b extends WebViewClient {
        b() {
        }

        @Override // android.webkit.WebViewClient
        public void onLoadResource(WebView webView, String str) {
            super.onLoadResource(webView, str);
            if (str.contains(".apk?")) {
                TestPostHtmlPageActivity.this.f147c.startActivity(new Intent("android.intent.action.VIEW", Uri.parse(str)));
            }
        }

        @Override // android.webkit.WebViewClient
        public boolean shouldOverrideUrlLoading(WebView webView, String str) {
            c0.u("TestPostHtmlPageActivity", "链接地址shouldOverrideUrlLoading   " + str);
            TestPostHtmlPageActivity.this.q = str;
            if (str.endsWith(".apk")) {
                TestPostHtmlPageActivity.this.f147c.startActivity(new Intent("android.intent.action.VIEW", Uri.parse(str)));
                return true;
            }
            if (str.startsWith(BaseConstants.SCHEME_HTTPS) || str.startsWith("http") || str.startsWith("file.")) {
                TestPostHtmlPageActivity.this.testPostHtmlWebView.loadUrl(str);
            }
            return true;
        }
    }

    @Override // com.rtk.app.base.BaseActivity
    protected void A() {
        t.S1(this.f147c, this.testPostHtmlPageLv, null, null, ((ViewGroup) findViewById(R.id.content)).getChildAt(0));
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.rtk.app.base.f
    public void initData() {
        String stringExtra = getIntent().getStringExtra("url");
        this.r = stringExtra;
        this.q = stringExtra;
        this.testPostHtmlWebView.getSettings().setJavaScriptEnabled(true);
        this.testPostHtmlWebView.getSettings().setUseWideViewPort(true);
        this.testPostHtmlWebView.getSettings().setLoadsImagesAutomatically(true);
        this.testPostHtmlWebView.getSettings().setNeedInitialFocus(true);
        this.testPostHtmlWebView.getSettings().setUseWideViewPort(true);
        this.testPostHtmlWebView.getSettings().setLoadWithOverviewMode(true);
        this.testPostHtmlWebView.getSettings().setDomStorageEnabled(true);
        this.testPostHtmlWebView.getSettings().setBuiltInZoomControls(true);
        this.testPostHtmlWebView.getSettings().setSupportZoom(true);
        this.testPostHtmlWebView.getSettings().setAllowFileAccess(true);
        this.testPostHtmlWebView.getSettings().setAllowFileAccessFromFileURLs(true);
        this.testPostHtmlWebView.getSettings().setAllowUniversalAccessFromFileURLs(true);
        this.testPostHtmlWebView.setWebChromeClient(new a());
        this.testPostHtmlWebView.setWebViewClient(new b());
        this.testPostHtmlWebView.loadUrl(this.r);
    }

    @Override // com.rtk.app.base.f
    public void initListener() {
    }

    @Override // com.rtk.app.base.f
    public void initView() {
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        switch (view.getId()) {
            case com.rtk.app.R.id.test_post_html_back /* 2131300376 */:
                this.testPostHtmlWebView.goBack();
                return;
            case com.rtk.app.R.id.test_post_html_go /* 2131300377 */:
                this.testPostHtmlWebView.goForward();
                return;
            case com.rtk.app.R.id.test_post_html_home /* 2131300378 */:
                this.testPostHtmlWebView.loadUrl(this.r);
                return;
            case com.rtk.app.R.id.test_post_html_page_back /* 2131300379 */:
                finish();
                return;
            case com.rtk.app.R.id.test_post_html_page_lv /* 2131300380 */:
            case com.rtk.app.R.id.test_post_html_progressBar /* 2131300381 */:
            default:
                return;
            case com.rtk.app.R.id.test_post_html_useBrowser /* 2131300382 */:
                c0.u("TestPostHtmlPageActivity", "地址" + this.q);
                if (c0.q(this.q)) {
                    return;
                }
                try {
                    this.f147c.startActivity(new Intent("android.intent.action.VIEW", Uri.parse(this.q)));
                    return;
                } catch (Exception unused) {
                    this.f147c.startActivity(new Intent("android.intent.action.VIEW", Uri.parse(this.r)));
                    return;
                }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.rtk.app.base.BaseActivity, com.rtk.app.custom.SwipeBackActivity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(com.rtk.app.R.layout.activity_test_post_html_page);
        ButterKnife.a(this);
    }
}
