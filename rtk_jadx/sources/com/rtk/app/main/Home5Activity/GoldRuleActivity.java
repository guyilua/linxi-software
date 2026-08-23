package com.rtk.app.main.Home5Activity;

import android.R;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.LinearLayout;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.rtk.app.base.BaseActivity;
import com.rtk.app.bean.OtherRuleCuntributeBean;
import com.rtk.app.main.HomeCommunityPack.PostAdapter.PostDetailsHolderClass.WebViewHolder;
import com.rtk.app.tool.o.h;
import com.sigmob.sdk.downloader.f;
import org.apache.log4j.Level;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class GoldRuleActivity extends BaseActivity implements h.j {

    @BindView
    TextView goldRuleBack;

    @BindView
    LinearLayout goldRuleLayout;

    @BindView
    WebView goldRuleWebView;

    @Override // com.rtk.app.base.BaseActivity
    protected void A() {
        com.rtk.app.tool.t.S1(this.f147c, this.goldRuleLayout, null, null, ((ViewGroup) findViewById(R.id.content)).getChildAt(0));
    }

    public void L(int... iArr) {
        String str;
        if (iArr[0] != 1) {
            str = "";
        } else {
            str = "members/coinRules" + com.rtk.app.tool.y.u(this.f147c) + "&rid=3&key=" + com.rtk.app.tool.t.c0(com.rtk.app.tool.c0.e(com.rtk.app.tool.y.v(this.f147c, "rid=3")));
        }
        com.rtk.app.tool.o.h.l(this.f147c, this, iArr[0], com.rtk.app.tool.o.h.h(new String[0]).a(str));
    }

    @Override // com.rtk.app.tool.o.h.j
    public void d(String str, int i) {
        com.rtk.app.tool.c0.a("GoldRuleActivity", getClass() + "我的等级   ----   经验值规则" + str, 3, new Level[0]);
        if (i != 1) {
            return;
        }
        WebViewHolder.b(this.goldRuleWebView, ((OtherRuleCuntributeBean) this.g.fromJson(str, OtherRuleCuntributeBean.class)).getData().getMsg(), this.f147c, null);
    }

    @Override // com.rtk.app.tool.o.h.j
    public void g(int i, String str, int i2) {
        com.rtk.app.tool.f.a(this.f147c, str, f.a.f);
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
        if (view.getId() != 2131297804) {
            return;
        }
        finish();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.rtk.app.base.BaseActivity, com.rtk.app.custom.SwipeBackActivity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(com.rtk.app.R.layout.activity_gold_rule);
        ButterKnife.a(this);
    }
}
