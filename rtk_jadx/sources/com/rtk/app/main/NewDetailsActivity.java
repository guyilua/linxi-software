package com.rtk.app.main;

import android.R;
import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.qq.e.comm.managers.setting.GlobalSetting;
import com.rtk.app.base.BaseActivity;
import com.rtk.app.bean.NewsDetailsBean;
import com.rtk.app.tool.o.h;
import org.apache.log4j.Level;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class NewDetailsActivity extends BaseActivity implements h.j {

    @BindView
    TextView newsDetailasType;

    @BindView
    ImageView newsDetailsAppIcon;

    @BindView
    ImageView newsDetailsAppIcon2;

    @BindView
    LinearLayout newsDetailsAppLv;

    @BindView
    LinearLayout newsDetailsAppLv2;

    @BindView
    WebView newsDetailsContent;

    @BindView
    LinearLayout newsDetailsLv;

    @BindView
    TextView newsDetailsName2;

    @BindView
    TextView newsDetailsTime;

    @BindView
    TextView newsDetailsTitles;

    @BindView
    TextView newsDetalisAppName;

    @BindView
    TextView newsDetalisAppSize;

    @BindView
    TextView newsDetalisAppType;

    @BindView
    TextView newsDetalisAppVersion;
    private Context q;
    private int r = 0;
    private NewsDetailsBean s;
    private String t;

    @Override // com.rtk.app.base.BaseActivity
    protected void A() {
        com.rtk.app.tool.t.S1(this.q, this.newsDetailsLv, null, null, ((ViewGroup) findViewById(R.id.content)).getChildAt(0));
    }

    public void L(int... iArr) {
        if (iArr[0] != 1) {
            return;
        }
        Context context = this.q;
        com.rtk.app.tool.o.i h = com.rtk.app.tool.o.h.h(new String[0]);
        StringBuilder sb = new StringBuilder();
        sb.append("news/newsDetail");
        sb.append(com.rtk.app.tool.y.u(this.q));
        sb.append("&id=");
        sb.append(this.r);
        sb.append("&key=");
        sb.append(com.rtk.app.tool.t.c0(com.rtk.app.tool.c0.e(com.rtk.app.tool.y.v(this.q, "id=" + this.r))));
        com.rtk.app.tool.o.h.l(context, this, 1, h.a(sb.toString()));
        StringBuilder sb2 = new StringBuilder();
        sb2.append("新闻URI");
        sb2.append(com.rtk.app.tool.y.d);
        sb2.append("news/newsDetail");
        sb2.append(com.rtk.app.tool.y.u(this.q));
        sb2.append("&id=");
        sb2.append(this.r);
        sb2.append("&key=");
        sb2.append(com.rtk.app.tool.t.c0(com.rtk.app.tool.c0.e(com.rtk.app.tool.y.v(this.q, "id=" + this.r))));
        com.rtk.app.tool.c0.u("NewDetailsActivity", sb2.toString());
    }

    @Override // com.rtk.app.tool.o.h.j
    public void d(String str, int i) {
        Gson create = new GsonBuilder().enableComplexMapKeySerialization().create();
        if (i != 1) {
            return;
        }
        com.rtk.app.tool.c0.a("NewDetailsActivity", "资讯详情" + str, 3, new Level[0]);
        NewsDetailsBean newsDetailsBean = (NewsDetailsBean) create.fromJson(str, NewsDetailsBean.class);
        this.s = newsDetailsBean;
        this.newsDetailsContent.loadDataWithBaseURL(null, newsDetailsBean.getData().getDescription(), "text/html", "utf-8", null);
        this.newsDetailsContent.getSettings().setJavaScriptEnabled(true);
        this.newsDetailsContent.setWebChromeClient(new WebChromeClient());
        this.newsDetailsTime.setText("更新：" + com.rtk.app.tool.c0.g(Long.parseLong(this.s.getData().getEdittime())));
        this.newsDetalisAppName.setText(this.s.getData().getGame_name());
        this.newsDetailsName2.setText(this.s.getData().getGame_name());
        if (this.s.getData().getCate_id().equals("1")) {
            this.newsDetailasType.setText("资料");
            return;
        }
        if (this.s.getData().getCate_id().equals("2")) {
            this.newsDetailasType.setText("攻略");
            return;
        }
        if (this.s.getData().getCate_id().equals(GlobalSetting.SPLASH_AD)) {
            this.newsDetailasType.setText("评测");
        } else if (this.s.getData().getCate_id().equals(GlobalSetting.NATIVE_EXPRESS_AD)) {
            this.newsDetailasType.setText("活动");
        } else if (this.s.getData().getCate_id().equals("5")) {
            this.newsDetailasType.setText("公告");
        }
    }

    @Override // com.rtk.app.tool.o.h.j
    public void g(int i, String str, int i2) {
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.rtk.app.base.f
    public void initData() {
        this.r = getIntent().getExtras().getInt("id");
        this.t = getIntent().getExtras().getString("title");
        L(1);
    }

    @Override // com.rtk.app.base.f
    public void initListener() {
    }

    @Override // com.rtk.app.base.f
    public void initView() {
        this.newsDetailsTitles.setText(this.t);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getId() != 2131299568) {
            return;
        }
        com.rtk.app.tool.c.a((Activity) this.q);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.rtk.app.base.BaseActivity, com.rtk.app.custom.SwipeBackActivity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(com.rtk.app.R.layout.activity_new_details);
        ButterKnife.a(this);
        this.q = this;
    }
}
