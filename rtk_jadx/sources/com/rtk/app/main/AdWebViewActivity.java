package com.rtk.app.main;

import android.R;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.rtk.app.base.BaseActivity;
import com.rtk.app.bean.HomeAdDetailsBean;
import com.rtk.app.tool.o.h;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class AdWebViewActivity extends BaseActivity implements h.j {

    @BindView
    TextView adWebBack;

    @BindView
    WebView adWebContent;

    @BindView
    LinearLayout adWebLayout;
    private String q;

    @Override // com.rtk.app.base.BaseActivity
    protected void A() {
        com.rtk.app.tool.t.S1(this.f147c, this.adWebLayout, null, null, ((ViewGroup) findViewById(R.id.content)).getChildAt(0));
    }

    public void L(int... iArr) {
        AppCompatActivity appCompatActivity = this.f147c;
        com.rtk.app.tool.o.i h = com.rtk.app.tool.o.h.h(new String[0]);
        StringBuilder sb = new StringBuilder();
        sb.append("ad/ad_detail");
        sb.append(com.rtk.app.tool.y.u(this.f147c));
        sb.append("&ad_id=");
        sb.append(this.q);
        sb.append("&key=");
        sb.append(com.rtk.app.tool.t.c0(com.rtk.app.tool.c0.e(com.rtk.app.tool.y.v(this.f147c, "ad_id=" + this.q))));
        com.rtk.app.tool.o.h.l(appCompatActivity, this, 1, h.a(sb.toString()));
    }

    @Override // com.rtk.app.tool.o.h.j
    public void d(String str, int i) {
        Gson create = new GsonBuilder().enableComplexMapKeySerialization().create();
        if (i != 1) {
            return;
        }
        this.adWebContent.loadDataWithBaseURL(null, ((HomeAdDetailsBean) create.fromJson(str, HomeAdDetailsBean.class)).getData().getAd_content(), "text/html", "utf-8", null);
        this.adWebContent.getSettings().setJavaScriptEnabled(true);
        this.adWebContent.setWebChromeClient(new WebChromeClient());
    }

    @Override // com.rtk.app.tool.o.h.j
    public void g(int i, String str, int i2) {
        com.rtk.app.tool.f.a(this.f147c, "获取错误" + str, 200);
        finish();
    }

    @Override // com.rtk.app.base.f
    public void initData() {
    }

    @Override // com.rtk.app.base.f
    public void initListener() {
    }

    @Override // com.rtk.app.base.f
    public void initView() {
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getId() != 2131296412) {
            return;
        }
        finish();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.rtk.app.base.BaseActivity, com.rtk.app.custom.SwipeBackActivity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(com.rtk.app.R.layout.activity_ad_web_view);
        ButterKnife.a(this);
        this.q = getIntent().getExtras().getString("adId");
        L(new int[0]);
    }
}
