package com.rtk.app.main.Home5Activity;

import android.R;
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
import com.rtk.app.bean.PrivacyOfUsageBean;
import com.rtk.app.tool.o.h;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class PrivacyOfUsageActivity extends BaseActivity implements h.j {

    @BindView
    WebView helpContent;

    @BindView
    TextView privacyOfUsageBack;

    @BindView
    LinearLayout privacyOfUsageLayout;

    @Override // com.rtk.app.base.BaseActivity
    protected void A() {
        com.rtk.app.tool.t.S1(this.f147c, this.privacyOfUsageLayout, null, null, ((ViewGroup) findViewById(R.id.content)).getChildAt(0));
    }

    @Override // com.rtk.app.tool.o.h.j
    public void d(String str, int i) {
        com.rtk.app.tool.c0.u("PrivacyOfUsageActivity", "隐私协议" + str);
        if (i != 1) {
            return;
        }
        this.helpContent.loadDataWithBaseURL(null, ((PrivacyOfUsageBean) this.g.fromJson(str, PrivacyOfUsageBean.class)).getData().getAgreement_privacy(), "text/html", "utf-8", null);
        this.helpContent.getSettings().setJavaScriptEnabled(true);
        this.helpContent.setWebChromeClient(new WebChromeClient());
    }

    @Override // com.rtk.app.tool.o.h.j
    public void g(int i, String str, int i2) {
    }

    @Override // com.rtk.app.base.f
    public void initData() {
        com.rtk.app.tool.o.h.l(this.f147c, this, 1, com.rtk.app.tool.o.h.h(new String[0]).a("system/privacy" + com.rtk.app.tool.y.u(this.f147c) + "&key=" + com.rtk.app.tool.t.c0(com.rtk.app.tool.c0.e(com.rtk.app.tool.y.v(this.f147c, new String[0])))));
    }

    @Override // com.rtk.app.base.f
    public void initListener() {
    }

    @Override // com.rtk.app.base.f
    public void initView() {
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getId() != 2131299931) {
            return;
        }
        finish();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.rtk.app.base.BaseActivity, com.rtk.app.custom.SwipeBackActivity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(com.rtk.app.R.layout.activity_privacy_of_usage);
        ButterKnife.a(this);
    }
}
