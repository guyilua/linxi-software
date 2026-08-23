package com.rtk.app.main;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import androidx.appcompat.app.AppCompatActivity;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.rtk.app.R;
import com.sigmob.sdk.downloader.f;
import com.ss.android.download.api.constant.BaseConstants;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class QQWebViewActivity extends AppCompatActivity {
    private long a;

    @BindView
    WebView qqwebview;

    /* loaded from: /tmp/rtk_apk/classes3.dex */
    private class b extends WebViewClient {
        private b() {
        }

        @Override // android.webkit.WebViewClient
        public boolean shouldOverrideUrlLoading(WebView webView, String str) {
            if (!str.startsWith("http") && !str.startsWith(BaseConstants.SCHEME_HTTPS)) {
                try {
                    if (System.currentTimeMillis() - QQWebViewActivity.this.a <= 400) {
                        return true;
                    }
                    QQWebViewActivity.this.startActivity(new Intent("android.intent.action.VIEW", Uri.parse(str)));
                    QQWebViewActivity.this.finish();
                    QQWebViewActivity.this.a = System.currentTimeMillis();
                    return true;
                } catch (Exception unused) {
                    com.rtk.app.tool.f.a(QQWebViewActivity.this, "您的手机未安装QQ客户端", f.a.f);
                    QQWebViewActivity.this.finish();
                    return true;
                }
            }
            return super.shouldOverrideUrlLoading(webView, str);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    protected void onCreate(Bundle bundle) {
        super/*androidx.fragment.app.FragmentActivity*/.onCreate(bundle);
        setContentView(R.layout.activity_qqweb_view);
        ButterKnife.a(this);
        String string = getIntent().getExtras().getString("qqUrl");
        this.qqwebview.getSettings().setJavaScriptEnabled(true);
        this.qqwebview.loadUrl(string);
        this.qqwebview.setWebViewClient(new b());
    }
}
