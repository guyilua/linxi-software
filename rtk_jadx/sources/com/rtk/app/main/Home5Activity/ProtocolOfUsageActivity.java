package com.rtk.app.main.Home5Activity;

import android.R;
import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.widget.LinearLayout;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.rtk.app.base.BaseActivity;
import com.rtk.app.bean.ProtocolOfUsageBean;
import com.rtk.app.tool.o.h;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class ProtocolOfUsageActivity extends BaseActivity implements h.j {

    @BindView
    WebView helpContent;

    @BindView
    TextView protocolOfUsageBack;

    @BindView
    LinearLayout protocolOfUsageLayout;
    private Context q;

    @Override // com.rtk.app.base.BaseActivity
    protected void A() {
        com.rtk.app.tool.t.S1(this.q, this.protocolOfUsageLayout, null, null, ((ViewGroup) findViewById(R.id.content)).getChildAt(0));
    }

    public void L(int... iArr) {
        com.rtk.app.tool.o.h.l(this.q, this, 1, com.rtk.app.tool.o.h.h(new String[0]).a("system/agreement" + com.rtk.app.tool.y.u(this.q) + "&key=" + com.rtk.app.tool.t.c0(com.rtk.app.tool.c0.e(com.rtk.app.tool.y.v(this.q, new String[0])))));
    }

    @Override // com.rtk.app.tool.o.h.j
    public void d(String str, int i) {
        if (i != 1) {
            return;
        }
        com.rtk.app.tool.c0.u("ProtocolOfUsageActivity", "使用协议" + str);
        this.helpContent.loadDataWithBaseURL(null, ((ProtocolOfUsageBean) this.g.fromJson(str, ProtocolOfUsageBean.class)).getData().getContent(), "text/html", "utf-8", null);
        this.helpContent.getSettings().setJavaScriptEnabled(true);
        this.helpContent.setWebChromeClient(new WebChromeClient());
    }

    @Override // com.rtk.app.tool.o.h.j
    public void g(int i, String str, int i2) {
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
        if (view.getId() != 2131299938) {
            return;
        }
        com.rtk.app.tool.c.a((Activity) this.q);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.rtk.app.base.BaseActivity, com.rtk.app.custom.SwipeBackActivity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(com.rtk.app.R.layout.activity_protocol_of_usage);
        ButterKnife.a(this);
        this.q = this;
        L(new int[0]);
    }
}
