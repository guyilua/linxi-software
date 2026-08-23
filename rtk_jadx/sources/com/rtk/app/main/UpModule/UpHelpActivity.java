package com.rtk.app.main.UpModule;

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
import com.rtk.app.bean.ProtocolOfUpBean;
import com.rtk.app.tool.o.h;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class UpHelpActivity extends BaseActivity implements h.j {

    @BindView
    TextView upHelpBack;

    @BindView
    WebView upHelpContent;

    @BindView
    LinearLayout upHelpLayout;

    @Override // com.rtk.app.base.BaseActivity
    protected void A() {
        com.rtk.app.tool.t.S1(this.f147c, this.upHelpLayout, null, null, ((ViewGroup) findViewById(R.id.content)).getChildAt(0));
    }

    public void L(int... iArr) {
        if (iArr[0] != 1) {
            return;
        }
        com.rtk.app.tool.o.h.l(this.f147c, this, iArr[0], com.rtk.app.tool.o.h.h(new String[0]).a("members/sourceUseHlep" + com.rtk.app.tool.y.u(this.f147c) + "&key=" + com.rtk.app.tool.t.c0(com.rtk.app.tool.c0.e(com.rtk.app.tool.y.v(this.f147c, new String[0])))));
    }

    @Override // com.rtk.app.tool.o.h.j
    public void d(String str, int i) {
        com.rtk.app.tool.c0.u("UpHelpActivity", str + "   软天空使用协议   ");
        if (i != 1) {
            return;
        }
        this.upHelpContent.loadDataWithBaseURL(null, ((ProtocolOfUpBean) this.g.fromJson(str, ProtocolOfUpBean.class)).getData().getAbout(), "text/html", "utf-8", null);
        this.upHelpContent.getSettings().setJavaScriptEnabled(true);
        this.upHelpContent.setWebChromeClient(new WebChromeClient());
    }

    @Override // com.rtk.app.tool.o.h.j
    public void g(int i, String str, int i2) {
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
        if (view.getId() != 2131300963) {
            return;
        }
        finish();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.rtk.app.base.BaseActivity, com.rtk.app.custom.SwipeBackActivity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(com.rtk.app.R.layout.activity_up_help);
        ButterKnife.a(this);
    }
}
