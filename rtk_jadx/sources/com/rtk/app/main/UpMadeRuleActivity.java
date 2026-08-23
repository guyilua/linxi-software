package com.rtk.app.main;

import android.R;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.LinearLayout;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.rtk.app.base.BaseActivity;
import com.rtk.app.bean.UpMadeRuleBean;
import com.rtk.app.tool.o.h;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class UpMadeRuleActivity extends BaseActivity implements h.j {
    private String q = "members/sourceZipHelp";

    @BindView
    TextView upMadeRuleBack;

    @BindView
    WebView upMadeRuleContent;

    @BindView
    LinearLayout upMadeRuleLayout;

    /* loaded from: /tmp/rtk_apk/classes3.dex */
    private class b extends WebViewClient {
        private b() {
        }

        @Override // android.webkit.WebViewClient
        public void onPageFinished(WebView webView, String str) {
            super.onPageFinished(webView, str);
            UpMadeRuleActivity.this.N();
        }

        @Override // android.webkit.WebViewClient
        public boolean shouldOverrideUrlLoading(WebView webView, String str) {
            webView.loadUrl(str);
            return true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void N() {
        this.upMadeRuleContent.loadUrl("javascript:(function(){var objs = document.getElementsByTagName('img'); for(var i=0;i<objs.length;i++)  {var img = objs[i];       img.style.maxWidth = '100%'; img.style.height = 'auto';  }})()");
    }

    @Override // com.rtk.app.base.BaseActivity
    protected void A() {
        com.rtk.app.tool.t.S1(this.f147c, this.upMadeRuleLayout, null, null, ((ViewGroup) findViewById(R.id.content)).getChildAt(0));
    }

    public void M(int... iArr) {
        String str;
        if (iArr[0] != 1) {
            str = "";
        } else {
            str = this.q + com.rtk.app.tool.y.u(this.f147c) + "&key=" + com.rtk.app.tool.t.c0(com.rtk.app.tool.c0.e(com.rtk.app.tool.y.v(this.f147c, new String[0])));
        }
        if (com.rtk.app.tool.c0.q(str)) {
            return;
        }
        com.rtk.app.tool.c0.u("UpMadeRuleActivity", "请求地址   " + com.rtk.app.tool.y.d + str);
        com.rtk.app.tool.o.h.l(this.f147c, this, iArr[0], com.rtk.app.tool.o.h.h(new String[0]).a(str));
    }

    @Override // com.rtk.app.tool.o.h.j
    public void d(String str, int i) {
        com.rtk.app.tool.c0.u("UpMadeRuleActivity", str + "   软天空使用协议   ");
        if (i != 1) {
            return;
        }
        this.upMadeRuleContent.loadDataWithBaseURL(null, ((UpMadeRuleBean) this.g.fromJson(str, UpMadeRuleBean.class)).getData().getData_desc(), "text/html", "utf-8", null);
        this.upMadeRuleContent.getSettings().setJavaScriptEnabled(true);
        this.upMadeRuleContent.getSettings().setSupportZoom(false);
        this.upMadeRuleContent.setWebViewClient(new b());
    }

    @Override // com.rtk.app.tool.o.h.j
    public void g(int i, String str, int i2) {
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.rtk.app.base.f
    public void initData() {
        this.q = getIntent().getExtras().getString("pathUrl", this.q);
        M(1);
    }

    @Override // com.rtk.app.base.f
    public void initListener() {
    }

    @Override // com.rtk.app.base.f
    public void initView() {
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getId() != 2131300980) {
            return;
        }
        finish();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.rtk.app.base.BaseActivity, com.rtk.app.custom.SwipeBackActivity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(com.rtk.app.R.layout.activity_up_made_rule);
        ButterKnife.a(this);
    }
}
