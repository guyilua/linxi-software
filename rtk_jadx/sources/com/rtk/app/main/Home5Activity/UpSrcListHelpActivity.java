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
import com.rtk.app.bean.UpPermisionBean;
import com.rtk.app.tool.o.h;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class UpSrcListHelpActivity extends BaseActivity implements h.j {

    @BindView
    TextView upSrcListHelpBack;

    @BindView
    WebView upSrcListHelpIntro;

    @BindView
    LinearLayout upSrcListHelpLayout;

    @Override // com.rtk.app.base.BaseActivity
    protected void A() {
        com.rtk.app.tool.t.S1(this.f147c, this.upSrcListHelpLayout, null, null, ((ViewGroup) findViewById(R.id.content)).getChildAt(0));
    }

    public void L(int... iArr) {
        String str;
        if (iArr[0] != 1) {
            str = "";
        } else {
            str = "members/permissionDescription" + com.rtk.app.tool.y.u(this.f147c) + "&key=" + com.rtk.app.tool.t.c0(com.rtk.app.tool.c0.e(com.rtk.app.tool.y.v(this.f147c, new String[0])));
        }
        if (com.rtk.app.tool.c0.q(str)) {
            return;
        }
        com.rtk.app.tool.c0.u("UpSrcListHelpActivity", "超链接  " + com.rtk.app.tool.y.d + str);
        com.rtk.app.tool.o.h.l(this.f147c, this, iArr[0], com.rtk.app.tool.o.h.h(new String[0]).a(str));
    }

    @Override // com.rtk.app.tool.o.h.j
    public void d(String str, int i) {
        if (i != 1) {
            return;
        }
        com.rtk.app.tool.c0.u("UpSrcListHelpActivity", " up帮助  " + str);
        this.upSrcListHelpIntro.loadDataWithBaseURL(null, ((UpPermisionBean) this.g.fromJson(str, UpPermisionBean.class)).getData().getPermissionMsg(), "text/html", "utf-8", null);
        this.upSrcListHelpIntro.getSettings().setJavaScriptEnabled(true);
        this.upSrcListHelpIntro.getSettings().setSupportZoom(false);
        this.upSrcListHelpIntro.setWebChromeClient(new WebChromeClient());
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
        L(1);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getId() != 2131301036) {
            return;
        }
        finish();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.rtk.app.base.BaseActivity, com.rtk.app.custom.SwipeBackActivity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(com.rtk.app.R.layout.activity_up_src_list_help);
        ButterKnife.a(this);
    }
}
