package com.rtk.app.main.family;

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
import com.rtk.app.tool.o.h;
import com.sigmob.sdk.downloader.f;
import java.util.HashMap;
import org.json.JSONObject;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class AuthRealNameProtocolActivity extends BaseActivity implements h.j {

    @BindView
    TextView upProtocolBack;

    @BindView
    WebView upProtocolContent;

    @BindView
    LinearLayout upProtocolLayout;

    @Override // com.rtk.app.base.BaseActivity
    protected void A() {
        com.rtk.app.tool.t.S1(this.f147c, this.upProtocolLayout, null, null, ((ViewGroup) findViewById(R.id.content)).getChildAt(0));
    }

    public void L(int... iArr) {
        if (iArr[0] != 1) {
            return;
        }
        HashMap<String, String> k = com.rtk.app.tool.y.k();
        k.put("key", com.rtk.app.tool.t.L(k));
        com.rtk.app.tool.o.h.l(this.f147c, this, iArr[0], com.rtk.app.tool.o.h.h(com.rtk.app.tool.y.e).a(com.rtk.app.tool.y.w("user/agreement/realname", k)));
    }

    @Override // com.rtk.app.tool.o.h.j
    public void d(String str, int i) {
        com.rtk.app.tool.c0.u("AuthRealNameProtocolActivity", str + "   实名认证使用协议   ");
        if (i == 1) {
            try {
                this.upProtocolContent.loadDataWithBaseURL(null, new JSONObject(str).optJSONObject("data").getString("content"), "text/html", "utf-8", null);
                this.upProtocolContent.getSettings().setJavaScriptEnabled(true);
                this.upProtocolContent.setWebChromeClient(new WebChromeClient());
            } catch (Exception unused) {
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.rtk.app.tool.o.h.j
    public void g(int i, String str, int i2) {
        com.rtk.app.tool.f.a(this, str, f.a.f);
    }

    @Override // com.rtk.app.base.f
    public void initData() {
        L(1);
    }

    @Override // com.rtk.app.base.f
    public void initListener() {
    }

    @Override // com.rtk.app.base.f
    public void initView() {
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getId() != 2131300984) {
            return;
        }
        finish();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.rtk.app.base.BaseActivity, com.rtk.app.custom.SwipeBackActivity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(com.rtk.app.R.layout.activity_family_protocol);
        ButterKnife.a(this);
        this.upProtocolBack.setText("《实名认证使用协议》");
    }
}
