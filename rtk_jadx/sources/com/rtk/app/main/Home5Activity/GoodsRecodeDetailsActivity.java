package com.rtk.app.main.Home5Activity;

import android.R;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.rtk.app.base.BaseActivity;
import com.rtk.app.custom.CustomTextView;
import com.rtk.app.tool.o.h;
import com.youth.banner.Banner;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class GoodsRecodeDetailsActivity extends BaseActivity implements h.j {

    @BindView
    CustomTextView goodsRecodeDetailsAuditState;

    @BindView
    LinearLayout goodsRecodeDetailsBackLayout;

    @BindView
    TextView goodsRecodeDetailsBackTV;

    @BindView
    Banner goodsRecodeDetailsBanner;

    @BindView
    CustomTextView goodsRecodeDetailsBuyTime;

    @BindView
    TextView goodsRecodeDetailsIntegral;

    @BindView
    TextView goodsRecodeDetailsIntro;

    @BindView
    TextView goodsRecodeDetailsName;

    @BindView
    TextView goodsRecodeDetailsNum;

    @BindView
    LinearLayout goodsRecodeDetailsParent;

    @BindView
    SwipeRefreshLayout goodsRecodeDetailsSwipeRefresh;
    private String q = "";

    @Override // com.rtk.app.base.BaseActivity
    protected void A() {
        com.rtk.app.tool.t.S1(this.f147c, this.goodsRecodeDetailsBackLayout, null, null, ((ViewGroup) findViewById(R.id.content)).getChildAt(0));
    }

    public void L(int... iArr) {
        String sb;
        if (iArr[0] != 1) {
            sb = "";
        } else {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("members/gift_apply_record_detail");
            sb2.append(com.rtk.app.tool.y.u(this.f147c));
            sb2.append("&uid=");
            sb2.append(com.rtk.app.tool.y.K());
            sb2.append("&token=");
            sb2.append(com.rtk.app.tool.y.H());
            sb2.append("&gid=");
            sb2.append(this.q);
            sb2.append("&key=");
            sb2.append(com.rtk.app.tool.t.c0(com.rtk.app.tool.c0.e(com.rtk.app.tool.y.v(this.f147c, "token=" + com.rtk.app.tool.y.H(), "gid=" + this.q, "uid=" + com.rtk.app.tool.y.K()))));
            sb = sb2.toString();
        }
        com.rtk.app.tool.o.h.l(this.f147c, this, iArr[0], com.rtk.app.tool.o.h.h(new String[0]).a(sb));
        com.rtk.app.tool.c0.u("GoodsRecodeDetailsActivity", "积分兑换记录链接" + com.rtk.app.tool.y.d + sb);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:6:0x00b4, code lost:
    
        if (r5.equals("2") != false) goto L18;
     */
    @Override // com.rtk.app.tool.o.h.j
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void d(java.lang.String r5, int r6) {
        /*
            Method dump skipped, instructions count: 288
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.rtk.app.main.Home5Activity.GoodsRecodeDetailsActivity.d(java.lang.String, int):void");
    }

    @Override // com.rtk.app.tool.o.h.j
    public void g(int i, String str, int i2) {
        if (i2 != 1) {
            return;
        }
        this.goodsRecodeDetailsSwipeRefresh.setRefreshing(false);
        com.rtk.app.tool.c0.u("GoodsRecodeDetailsActivity", "积分兑换记录   " + str);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.rtk.app.base.f
    public void initData() {
        this.q = getIntent().getExtras().getString("gid");
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
        if (view.getId() != 2131297819) {
            return;
        }
        finish();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.rtk.app.base.BaseActivity, com.rtk.app.custom.SwipeBackActivity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(com.rtk.app.R.layout.activity_goods_recode_details);
        ButterKnife.a(this);
    }
}
