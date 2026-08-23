package com.rtk.app.main;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.webkit.JsPromptResult;
import android.webkit.JsResult;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import androidx.appcompat.app.AppCompatActivity;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.rtk.app.R;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class Html5GameActivity extends AppCompatActivity implements View.OnClickListener, com.rtk.app.base.f {

    @BindView
    WebView html5GameWebview;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: /tmp/rtk_apk/classes3.dex */
    public class a extends WebViewClient {
        a() {
        }

        @Override // android.webkit.WebViewClient
        public void onPageFinished(WebView webView, String str) {
            super.onPageFinished(webView, str);
            str.startsWith("http://h5.wuzhiyou.com/game/gameStart?");
        }

        @Override // android.webkit.WebViewClient
        public void onReceivedError(WebView webView, int i, String str, String str2) {
            super.onReceivedError(webView, i, str, str2);
        }

        @Override // android.webkit.WebViewClient
        public boolean shouldOverrideUrlLoading(WebView webView, String str) {
            boolean z = str.indexOf("http://h5.wuzhiyou.com/game/api") != -1;
            boolean z2 = str.indexOf("type=wxpay") != -1;
            boolean z3 = str.indexOf("type=alipay") != -1;
            if (z && z3) {
                Intent intent = new Intent("android.intent.action.VIEW");
                intent.setData(Uri.parse(str));
                Html5GameActivity.this.startActivity(intent);
                return true;
            }
            if (z && z2) {
                Intent intent2 = new Intent("android.intent.action.VIEW");
                intent2.setData(Uri.parse(str));
                Html5GameActivity.this.startActivity(intent2);
                return true;
            }
            return super.shouldOverrideUrlLoading(webView, str);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: /tmp/rtk_apk/classes3.dex */
    public class b extends WebChromeClient {
        b(Html5GameActivity html5GameActivity) {
        }

        @Override // android.webkit.WebChromeClient
        public boolean onJsAlert(WebView webView, String str, String str2, JsResult jsResult) {
            return super.onJsAlert(webView, str, str2, jsResult);
        }

        @Override // android.webkit.WebChromeClient
        public boolean onJsConfirm(WebView webView, String str, String str2, JsResult jsResult) {
            return super.onJsConfirm(webView, str, str2, jsResult);
        }

        @Override // android.webkit.WebChromeClient
        public boolean onJsPrompt(WebView webView, String str, String str2, String str3, JsPromptResult jsPromptResult) {
            return super.onJsPrompt(webView, str, str2, str3, jsPromptResult);
        }
    }

    @Override // com.rtk.app.base.f
    public void initView() {
        this.html5GameWebview.loadUrl("http://www.17byh.com/media.php?s=/game/index/gid/70/a/7ptm");
        WebSettings settings = this.html5GameWebview.getSettings();
        settings.setJavaScriptEnabled(true);
        settings.setDomStorageEnabled(true);
        settings.setPluginState(WebSettings.PluginState.ON);
        settings.setRenderPriority(WebSettings.RenderPriority.HIGH);
        settings.setUseWideViewPort(true);
        settings.setLoadWithOverviewMode(true);
        settings.setSupportZoom(true);
        settings.setBuiltInZoomControls(true);
        settings.setDisplayZoomControls(false);
        settings.setLayoutAlgorithm(WebSettings.LayoutAlgorithm.SINGLE_COLUMN);
        settings.supportMultipleWindows();
        settings.setCacheMode(-1);
        settings.setAllowFileAccess(true);
        settings.setNeedInitialFocus(true);
        settings.setJavaScriptCanOpenWindowsAutomatically(true);
        settings.setLoadsImagesAutomatically(true);
        this.html5GameWebview.setWebViewClient(new a());
        this.html5GameWebview.setWebChromeClient(new b(this));
        this.html5GameWebview.loadUrl("http://www.17byh.com/media.php?s=/game/index/gid/70/a/7ptm");
        this.html5GameWebview.requestFocus();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }

    /* JADX WARN: Multi-variable type inference failed */
    protected void onCreate(Bundle bundle) {
        super/*androidx.fragment.app.FragmentActivity*/.onCreate(bundle);
        setContentView(R.layout.activity_html5_game);
        ButterKnife.a(this);
        initView();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        com.rtk.app.main.dialogPack.y.c(this);
        return true;
    }
}
