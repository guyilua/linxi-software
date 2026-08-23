package com.rtk.app.main.Home5Activity;

import android.R;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.google.gson.GsonBuilder;
import com.rtk.app.adapter.u2;
import com.rtk.app.base.BaseActivity;
import com.rtk.app.bean.AboutAndHelpBean;
import com.rtk.app.custom.CustomListView;
import com.rtk.app.tool.o.h;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class AboutUsAndHelpActivity extends BaseActivity implements h.j {

    @BindView
    TextView aboutUsAndHelpBack;

    @BindView
    TextView aboutUsAndHelpBeian;

    @BindView
    TextView aboutUsAndHelpCopyright;

    @BindView
    TextView aboutUsAndHelpEmail;

    @BindView
    LinearLayout aboutUsAndHelpEmailLayout;

    @BindView
    LinearLayout aboutUsAndHelpHeadLv;

    @BindView
    LinearLayout aboutUsAndHelpLayout;

    @BindView
    View aboutUsAndHelpLogo;

    @BindView
    TextView aboutUsAndHelpQDQQ;

    @BindView
    LinearLayout aboutUsAndHelpQDQQLayout;

    @BindView
    TextView aboutUsAndHelpQQ;

    @BindView
    LinearLayout aboutUsAndHelpQQLayout;

    @BindView
    CustomListView aboutUsAndHelpQqLstView;

    @BindView
    TextView aboutUsAndHelpVersion;

    @BindView
    TextView aboutUsAndHelpWebUrl;

    @BindView
    LinearLayout aboutUsAndHelpWebUrlLayout;

    @BindView
    TextView aboutUsAndHelpWechat;

    @BindView
    LinearLayout aboutUsAndHelpWechatLayout;
    private Context q;
    private AboutAndHelpBean r;
    private int s = 0;
    private Handler t = new Handler();
    private Runnable u = new a();

    /* loaded from: /tmp/rtk_apk/classes3.dex */
    class a implements Runnable {
        a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            AboutUsAndHelpActivity.this.s = 0;
        }
    }

    /* loaded from: /tmp/rtk_apk/classes3.dex */
    class b extends com.rtk.app.custom.AutoListView.b {
        b() {
        }

        @Override // com.rtk.app.custom.AutoListView.b
        public void a(AdapterView<?> adapterView, View view, int i, long j) {
            com.rtk.app.tool.t.j(AboutUsAndHelpActivity.this.f147c, AboutUsAndHelpActivity.this.r.getData().getServe_group_key().get(i) + "");
        }
    }

    @Override // com.rtk.app.base.BaseActivity
    protected void A() {
        com.rtk.app.tool.t.S1(this.q, this.aboutUsAndHelpLayout, null, null, ((ViewGroup) findViewById(R.id.content)).getChildAt(0), this.aboutUsAndHelpHeadLv);
    }

    public void N(int... iArr) {
        com.rtk.app.tool.o.h.l(this.q, this, 1, com.rtk.app.tool.o.h.h(new String[0]).a("system/aboutUs" + com.rtk.app.tool.y.u(this.q) + "&newversion=1&key=" + com.rtk.app.tool.t.c0(com.rtk.app.tool.c0.e(com.rtk.app.tool.y.v(this.q, new String[0])))));
    }

    public void O(TextView textView, LinearLayout linearLayout, String str, String str2) {
        if (com.rtk.app.tool.c0.q(str2)) {
            linearLayout.setVisibility(8);
            return;
        }
        textView.setText(str + str2);
    }

    @Override // com.rtk.app.tool.o.h.j
    public void d(String str, int i) {
        com.rtk.app.tool.c0.u("AboutUsAndHelpActivity", "帮助关于" + str);
        AboutAndHelpBean aboutAndHelpBean = (AboutAndHelpBean) new GsonBuilder().enableComplexMapKeySerialization().create().fromJson(str, AboutAndHelpBean.class);
        this.r = aboutAndHelpBean;
        O(this.aboutUsAndHelpQDQQ, this.aboutUsAndHelpQDQQLayout, "QQ公众号:", aboutAndHelpBean.getData().getServe_qdkf());
        O(this.aboutUsAndHelpQQ, this.aboutUsAndHelpQQLayout, "客服QQ:", this.r.getData().getServe_qq());
        O(this.aboutUsAndHelpWebUrl, this.aboutUsAndHelpWebUrlLayout, "访问官网:", this.r.getData().getRuansky_url());
        O(this.aboutUsAndHelpWechat, this.aboutUsAndHelpWechatLayout, "官方微信:", this.r.getData().getServe_wechat());
        O(this.aboutUsAndHelpEmail, this.aboutUsAndHelpEmailLayout, "官方Email:", this.r.getData().getServe_email());
        this.aboutUsAndHelpQqLstView.setAdapter((ListAdapter) new u2(this.q, this.r.getData().getServe_group()));
        this.aboutUsAndHelpCopyright.setText(this.r.getData().getServe_descrip());
        this.aboutUsAndHelpBeian.setText(this.r.getData().getBeian().getForTheRecord());
    }

    @Override // com.rtk.app.tool.o.h.j
    public void g(int i, String str, int i2) {
    }

    @Override // com.rtk.app.base.f
    public void initData() {
        this.aboutUsAndHelpVersion.setText("软天空 V" + com.rtk.app.tool.t.a0(this.q));
    }

    @Override // com.rtk.app.base.f
    public void initListener() {
        this.aboutUsAndHelpQqLstView.setOnItemClickListener(new b());
    }

    @Override // com.rtk.app.base.f
    public void initView() {
        N(new int[0]);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        switch (view.getId()) {
            case com.rtk.app.R.id.about_us_and_help_Email_layout /* 2131296279 */:
                com.rtk.app.tool.t.I1(this.q, this.r.getData().getServe_email());
                return;
            case com.rtk.app.R.id.about_us_and_help_QDQQ_layout /* 2131296281 */:
                com.rtk.app.tool.t.p((Activity) this.q, this.r.getData().getServe_qdkf());
                return;
            case com.rtk.app.R.id.about_us_and_help_QQ_layout /* 2131296283 */:
                com.rtk.app.tool.t.I1(this.q, this.r.getData().getServe_qq());
                return;
            case com.rtk.app.R.id.about_us_and_help_back /* 2131296284 */:
                com.rtk.app.tool.c.a((Activity) this.q);
                return;
            case com.rtk.app.R.id.about_us_and_help_beian /* 2131296285 */:
                startActivity(new Intent("android.intent.action.VIEW", Uri.parse(this.r.getData().getBeian().getBeianUrl())));
                return;
            case com.rtk.app.R.id.about_us_and_help_logo /* 2131296289 */:
                int i = this.s + 1;
                this.s = i;
                if (i == 5) {
                    startActivity(new Intent((Context) this, (Class<?>) RTKLogActivity.class));
                    this.t.postDelayed(this.u, 1000L);
                    return;
                } else {
                    if (i > 5) {
                        this.t.removeCallbacks(this.u);
                        this.t.post(this.u);
                        return;
                    }
                    return;
                }
            case com.rtk.app.R.id.about_us_and_help_webUrl_layout /* 2131296294 */:
                startActivity(new Intent("android.intent.action.VIEW", Uri.parse(this.r.getData().getRuansky_url())));
                return;
            case com.rtk.app.R.id.about_us_and_help_wechat_layout /* 2131296296 */:
                com.rtk.app.tool.t.I1(this.q, this.r.getData().getServe_wechat());
                return;
            default:
                return;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.rtk.app.base.BaseActivity, com.rtk.app.custom.SwipeBackActivity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(com.rtk.app.R.layout.activity_about_us_and_help);
        ButterKnife.a(this);
        this.q = this;
    }
}
