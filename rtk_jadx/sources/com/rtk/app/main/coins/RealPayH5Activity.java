package com.rtk.app.main.coins;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.rtk.app.R;
import com.rtk.app.main.family.FamilyBaseActivity;
import com.rtk.app.tool.c0;
import com.rtk.app.tool.f;
import com.rtk.app.tool.o.h;
import com.rtk.app.tool.t;
import com.rtk.app.tool.y;
import com.sigmob.sdk.downloader.f;
import com.umeng.analytics.pro.ak;
import java.util.HashMap;
import org.json.JSONObject;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class RealPayH5Activity extends FamilyBaseActivity implements h.j {
    private int r;
    private String s;
    private String t;

    @BindView
    TextView upProtocolBack;

    @BindView
    WebView upProtocolContent;

    /* loaded from: /tmp/rtk_apk/classes3.dex */
    class a extends WebChromeClient {
        a(RealPayH5Activity realPayH5Activity) {
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void N(int... iArr) {
        if (iArr[0] != 1) {
            return;
        }
        HashMap<String, String> l = y.l();
        l.put("amount", this.t + "");
        l.put(ak.y, y.D());
        l.put(ak.J, y.p(this.f147c));
        l.put("device_id", y.o(this.f147c));
        l.put("key", t.L(l));
        h.j(this, this, this.s, 1, l);
    }

    @Override // com.rtk.app.main.family.FamilyBaseActivity, com.rtk.app.tool.o.h.j
    public void d(String str, int i) {
        c0.u("RealPayH5Activity", str + "   H5 支付   ");
        if (i == 1) {
            try {
                this.upProtocolContent.getSettings().setJavaScriptEnabled(true);
                this.upProtocolContent.setWebChromeClient(new a(this));
                JSONObject jSONObject = new JSONObject(str);
                if (this.r == 7) {
                    startActivity(new Intent("android.intent.action.VIEW", Uri.parse(jSONObject.optJSONObject("data").getString("h5_url"))));
                    finish();
                } else {
                    this.upProtocolContent.loadDataWithBaseURL(null, jSONObject.optJSONObject("data").getString("html"), "text/html", "utf-8", null);
                    finish();
                }
            } catch (Exception unused) {
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.rtk.app.main.family.FamilyBaseActivity, com.rtk.app.tool.o.h.j
    public void g(int i, String str, int i2) {
        f.a(this, str, f.a.f);
    }

    @Override // com.rtk.app.main.family.FamilyBaseActivity, com.rtk.app.base.f
    public void initData() {
        N(1);
    }

    @Override // com.rtk.app.main.family.FamilyBaseActivity, com.rtk.app.base.f
    public void initListener() {
    }

    @Override // com.rtk.app.main.family.FamilyBaseActivity, com.rtk.app.base.f
    public void initView() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.rtk.app.main.family.FamilyBaseActivity, com.rtk.app.base.BaseActivity, com.rtk.app.custom.SwipeBackActivity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_real_pay_h5);
        ButterKnife.a(this);
        this.t = getIntent().getStringExtra("amount");
        this.s = getIntent().getStringExtra("url");
        int intExtra = getIntent().getIntExtra(com.umeng.analytics.pro.d.y, 7);
        this.r = intExtra;
        if (intExtra == 7) {
            this.upProtocolBack.setText("微信支付");
        } else {
            this.upProtocolBack.setText("支付宝支付");
        }
    }
}
