package com.rtk.app.main.Home5Activity;

import android.R;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import androidx.viewpager.widget.ViewPager;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.rtk.app.base.BaseActivity;
import com.rtk.app.bean.GoodsDetailsBean;
import com.rtk.app.main.MyApplication;
import com.rtk.app.main.dialogPack.DialogForGoodsOrderForm;
import com.rtk.app.main.dialogPack.DialogForToAccountSecurityActivity;
import com.rtk.app.tool.o.h;
import com.youth.banner.Banner;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class GoodsDetailsActivity extends BaseActivity implements h.j {

    @BindView
    TextView availableNum;

    @BindView
    Banner goodsDetailsBanner;

    @BindView
    TextView goodsDetailsIntegral;

    @BindView
    WebView goodsDetailsIntro;

    @BindView
    TextView goodsDetailsName;

    @BindView
    TextView goodsDetailsNum;

    @BindView
    LinearLayout goodsDetailsParent;

    @BindView
    TextView goodsDetailsSubmit;

    @BindView
    SwipeRefreshLayout goodsDetailsSwipeRefresh;

    @BindView
    TextView goodsDetailsTopBack;

    @BindView
    LinearLayout goodsDetailsTopLayout;

    @BindView
    TextView monthNum;
    private Bundle q;
    private String r = "";
    private GoodsDetailsBean s;

    /* loaded from: /tmp/rtk_apk/classes3.dex */
    class a implements ViewPager.OnPageChangeListener {
        a(GoodsDetailsActivity goodsDetailsActivity) {
        }

        public void onPageScrollStateChanged(int i) {
        }

        public void onPageScrolled(int i, float f, int i2) {
        }

        public void onPageSelected(int i) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: M, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void N(String[] strArr) {
        L(1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: O, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void P() {
        L(1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: Q, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void R(DialogInterface dialogInterface) {
        L(1);
    }

    @Override // com.rtk.app.base.BaseActivity
    protected void A() {
        com.rtk.app.tool.t.S1(this.f147c, this.goodsDetailsTopLayout, null, null, ((ViewGroup) findViewById(R.id.content)).getChildAt(0));
    }

    public void L(int... iArr) {
        String sb;
        if (iArr[0] != 1) {
            sb = "";
        } else {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("members/gift_detail");
            sb2.append(com.rtk.app.tool.y.u(this.f147c));
            sb2.append("&uid=");
            sb2.append(com.rtk.app.tool.y.K());
            sb2.append("&token=");
            sb2.append(com.rtk.app.tool.y.H());
            sb2.append("&gid=");
            sb2.append(this.r);
            sb2.append("&key=");
            sb2.append(com.rtk.app.tool.t.c0(com.rtk.app.tool.c0.e(com.rtk.app.tool.y.v(this.f147c, "token=" + com.rtk.app.tool.y.H(), "gid=" + this.r, "uid=" + com.rtk.app.tool.y.K()))));
            sb = sb2.toString();
        }
        com.rtk.app.tool.o.h.l(this.f147c, this, iArr[0], com.rtk.app.tool.o.h.h(new String[0]).a(sb));
        com.rtk.app.tool.c0.u("GoodsDetailsActivity", "商城列表链接" + com.rtk.app.tool.y.d + sb);
    }

    @Override // com.rtk.app.tool.o.h.j
    public void d(String str, int i) {
        this.goodsDetailsSwipeRefresh.setRefreshing(false);
        if (i != 1) {
            return;
        }
        F();
        com.rtk.app.tool.c0.u("GoodsDetailsActivity", " 商品详情  " + com.rtk.app.c.a.b(str));
        this.s = (GoodsDetailsBean) this.g.fromJson(str, GoodsDetailsBean.class);
        this.goodsDetailsBanner.w(new com.rtk.app.tool.l());
        this.goodsDetailsBanner.x(this.s.getData().getGift_pic());
        this.goodsDetailsBanner.B();
        this.goodsDetailsName.setText(this.s.getData().getGift_name());
        this.goodsDetailsIntegral.setText(this.s.getData().getCoin());
        this.goodsDetailsNum.setText(this.s.getData().getNum() + "");
        this.availableNum.setText(this.s.getData().getAvailableNum());
        this.monthNum.setText(this.s.getData().getMonthNum());
        this.goodsDetailsIntro.loadDataWithBaseURL(null, this.s.getData().getGift_msg(), "text/html", "utf-8", null);
        this.goodsDetailsIntro.getSettings().setJavaScriptEnabled(true);
        this.goodsDetailsIntro.getSettings().setSupportZoom(false);
        this.goodsDetailsIntro.setWebChromeClient(new WebChromeClient());
        if (!this.s.getData().getOnline().equals("1")) {
            this.goodsDetailsSubmit.setEnabled(false);
            this.goodsDetailsSubmit.setText("尚未开放兑换");
        } else {
            if (this.s.getData().getNum() > 0) {
                if (Integer.parseInt(this.s.getData().getUsercoin()) < Integer.parseInt(this.s.getData().getCoin())) {
                    this.goodsDetailsSubmit.setEnabled(false);
                    this.goodsDetailsSubmit.setText("金币不足");
                    return;
                } else {
                    this.goodsDetailsSubmit.setEnabled(true);
                    this.goodsDetailsSubmit.setText("申请兑换");
                    return;
                }
            }
            this.goodsDetailsSubmit.setEnabled(false);
            this.goodsDetailsSubmit.setText("本月库存不足");
        }
    }

    @Override // com.rtk.app.tool.o.h.j
    public void g(int i, String str, int i2) {
        this.goodsDetailsSwipeRefresh.setRefreshing(false);
        if (i2 != 1) {
            return;
        }
        I(str, new com.rtk.app.tool.s() { // from class: com.rtk.app.main.Home5Activity.m
            @Override // com.rtk.app.tool.s
            public final void a(String[] strArr) {
                GoodsDetailsActivity.this.N(strArr);
            }
        });
    }

    @Override // com.rtk.app.base.f
    public void initData() {
    }

    @Override // com.rtk.app.base.f
    public void initListener() {
        this.goodsDetailsSwipeRefresh.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() { // from class: com.rtk.app.main.Home5Activity.j
            public final void onRefresh() {
                GoodsDetailsActivity.this.P();
            }
        });
        this.goodsDetailsBanner.setOnPageChangeListener(new a(this));
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.rtk.app.base.f
    public void initView() {
        Bundle extras = getIntent().getExtras();
        this.q = extras;
        this.r = extras.getString("gid");
        L(1);
        LinearLayout linearLayout = this.goodsDetailsParent;
        G(linearLayout, linearLayout);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int id = view.getId();
        if (id != 2131297814) {
            if (id != 2131297816) {
                return;
            }
            finish();
        } else {
            if (com.rtk.app.tool.y.B()) {
                DialogForGoodsOrderForm dialogForGoodsOrderForm = new DialogForGoodsOrderForm(this.f147c, this.s.getData());
                dialogForGoodsOrderForm.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.rtk.app.main.Home5Activity.k
                    @Override // android.content.DialogInterface.OnDismissListener
                    public final void onDismiss(DialogInterface dialogInterface) {
                        GoodsDetailsActivity.this.R(dialogInterface);
                    }
                });
                dialogForGoodsOrderForm.show();
                return;
            }
            new DialogForToAccountSecurityActivity(this.f147c, getResources().getString(com.rtk.app.R.string.no_bound_qq_or_wechat), new com.rtk.app.tool.s() { // from class: com.rtk.app.main.Home5Activity.l
                @Override // com.rtk.app.tool.s
                public final void a(String[] strArr) {
                    com.rtk.app.tool.t.g0(MyApplication.b());
                }
            }).show();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.rtk.app.base.BaseActivity, com.rtk.app.custom.SwipeBackActivity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(com.rtk.app.R.layout.activity_goods_details);
        ButterKnife.a(this);
    }
}
