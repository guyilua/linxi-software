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
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.rtk.app.base.BaseActivity;
import com.rtk.app.bean.RegisterAgreementBean;
import com.rtk.app.tool.o.h;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class RegisterProtocolActivity extends BaseActivity implements h.j {

    @BindView
    WebView helpContent;

    @BindView
    TextView registerProtocolback;

    @BindView
    LinearLayout registerProtocollayout;

    @Override // com.rtk.app.base.BaseActivity
    protected void A() {
        com.rtk.app.tool.t.S1(this.f147c, this.registerProtocollayout, null, null, ((ViewGroup) findViewById(R.id.content)).getChildAt(0));
    }

    public void L(int... iArr) {
        if (iArr[0] != 1) {
            return;
        }
        com.rtk.app.tool.o.h.l(this.f147c, this, 1, com.rtk.app.tool.o.h.h(new String[0]).a("member/registerAgreement" + com.rtk.app.tool.y.u(this.f147c) + "&key=" + com.rtk.app.tool.t.c0(com.rtk.app.tool.c0.e(com.rtk.app.tool.y.v(this.f147c, new String[0])))));
    }

    @Override // com.rtk.app.tool.o.h.j
    public void d(String str, int i) {
        Gson create = new GsonBuilder().enableComplexMapKeySerialization().create();
        if (i != 1) {
            return;
        }
        com.rtk.app.tool.c0.u("RegisterProtocolActivity", "用户协议" + str);
        this.helpContent.loadDataWithBaseURL(null, ((RegisterAgreementBean) create.fromJson(str, RegisterAgreementBean.class)).getData().getRegisterAgreement(), "text/html", "utf-8", null);
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
        if (view.getId() != 2131299994) {
            return;
        }
        com.rtk.app.tool.c.a(this.f147c);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.rtk.app.base.BaseActivity, com.rtk.app.custom.SwipeBackActivity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(com.rtk.app.R.layout.activity_register_protocol);
        ButterKnife.a(this);
        L(1);
    }
}
