package com.rtk.app.main;

import android.R;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.rtk.app.base.BaseActivity;
import com.rtk.app.bean.GiftDetailsBean;
import com.rtk.app.bean.GiftNumberBean;
import com.rtk.app.main.dialogPack.DilalogLibao;
import com.rtk.app.tool.ApkInfo;
import com.rtk.app.tool.o.h;
import com.sigmob.sdk.downloader.f;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class GiftDetailsActivity extends BaseActivity implements h.j {

    @BindView
    TextView giftDetailBack;

    @BindView
    TextView giftDetailDetail;

    @BindView
    TextView giftDetailDrawTime;

    @BindView
    TextView giftDetailExchangeTime;

    @BindView
    TextView giftDetailGiftInformation;

    @BindView
    ImageView giftDetailLogo;

    @BindView
    LinearLayout giftDetailLv;

    @BindView
    TextView giftDetailName;

    @BindView
    TextView giftDetailNo;

    @BindView
    ProgressBar giftDetailProgressbar;

    @BindView
    LinearLayout giftDetailProgressbarLv;

    @BindView
    TextView giftDetailRemaining;

    @BindView
    TextView giftDetailState;

    @BindView
    LinearLayout giftDetailState2Ly;

    @BindView
    TextView giftDetailTip;

    @BindView
    TextView giftDetailUseMethod;

    @BindView
    TextView giftDetailsHintView;
    private String q;
    private Context r;
    private String s = "";
    private GiftDetailsBean t;
    private int u;

    @Override // com.rtk.app.base.BaseActivity
    protected void A() {
        com.rtk.app.tool.t.S1(this.r, this.giftDetailLv, null, null, ((ViewGroup) findViewById(R.id.content)).getChildAt(0));
    }

    public void L(int... iArr) {
        this.s = "&uid=" + com.rtk.app.tool.y.K();
        int i = iArr[0];
        if (i == 1) {
            Context context = this.r;
            com.rtk.app.tool.o.i h = com.rtk.app.tool.o.h.h(new String[0]);
            StringBuilder sb = new StringBuilder();
            sb.append("game/gift_detail");
            sb.append(com.rtk.app.tool.y.u(this.r));
            sb.append("&giftbag_id=");
            sb.append(this.q);
            sb.append(this.s);
            sb.append("&key=");
            sb.append(com.rtk.app.tool.t.c0(com.rtk.app.tool.c0.e(com.rtk.app.tool.y.v(this.r, "giftbag_id=" + this.q))));
            com.rtk.app.tool.o.h.l(context, this, 1, h.a(sb.toString()));
            return;
        }
        if (i == 3) {
            int I = com.rtk.app.tool.y.I(this.r);
            Context context2 = this.r;
            com.rtk.app.tool.o.i h2 = com.rtk.app.tool.o.h.h(new String[0]);
            StringBuilder sb2 = new StringBuilder();
            sb2.append("game/reservation_cancel");
            sb2.append(com.rtk.app.tool.y.u(this.r));
            sb2.append("&uid=");
            sb2.append(I);
            sb2.append("&giftbag_id=");
            sb2.append(this.q);
            sb2.append("&key=");
            sb2.append(com.rtk.app.tool.t.c0(com.rtk.app.tool.c0.e(com.rtk.app.tool.y.v(this.r, "uid=" + I, "giftbag_id=" + this.q))));
            com.rtk.app.tool.o.h.l(context2, this, 3, h2.a(sb2.toString()));
            return;
        }
        if (i == 4) {
            int I2 = com.rtk.app.tool.y.I(this.r);
            Context context3 = this.r;
            com.rtk.app.tool.o.i h3 = com.rtk.app.tool.o.h.h(new String[0]);
            StringBuilder sb3 = new StringBuilder();
            sb3.append("game/reservation");
            sb3.append(com.rtk.app.tool.y.u(this.r));
            sb3.append("&uid=");
            sb3.append(I2);
            sb3.append("&giftbag_id=");
            sb3.append(this.q);
            sb3.append("&key=");
            sb3.append(com.rtk.app.tool.t.c0(com.rtk.app.tool.c0.e(com.rtk.app.tool.y.v(this.r, "uid=" + I2, "giftbag_id=" + this.q))));
            com.rtk.app.tool.o.h.l(context3, this, 4, h3.a(sb3.toString()));
            return;
        }
        if (i == 6) {
            int I3 = com.rtk.app.tool.y.I(this.r);
            Context context4 = this.r;
            com.rtk.app.tool.o.i h4 = com.rtk.app.tool.o.h.h(new String[0]);
            StringBuilder sb4 = new StringBuilder();
            sb4.append("game/take_out");
            sb4.append(com.rtk.app.tool.y.u(this.r));
            sb4.append("&uid=");
            sb4.append(I3);
            sb4.append("&giftbag_id=");
            sb4.append(this.q);
            sb4.append("&key=");
            sb4.append(com.rtk.app.tool.t.c0(com.rtk.app.tool.c0.e(com.rtk.app.tool.y.v(this.r, "uid=" + I3, "giftbag_id=" + this.q))));
            com.rtk.app.tool.o.h.l(context4, this, 6, h4.a(sb4.toString()));
            return;
        }
        if (i != 7) {
            return;
        }
        int I4 = com.rtk.app.tool.y.I(this.r);
        Context context5 = this.r;
        com.rtk.app.tool.o.i h5 = com.rtk.app.tool.o.h.h(new String[0]);
        StringBuilder sb5 = new StringBuilder();
        sb5.append("game/gift_receive");
        sb5.append(com.rtk.app.tool.y.u(this.r));
        sb5.append("&uid=");
        sb5.append(I4);
        sb5.append("&giftbag_id=");
        sb5.append(this.q);
        sb5.append("&key=");
        sb5.append(com.rtk.app.tool.t.c0(com.rtk.app.tool.c0.e(com.rtk.app.tool.y.v(this.r, "uid=" + I4, "giftbag_id=" + this.q))));
        com.rtk.app.tool.o.h.l(context5, this, 7, h5.a(sb5.toString()));
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.rtk.app.tool.o.h.j
    public void d(String str, int i) {
        com.rtk.app.tool.c0.u("GiftDetailsActivity", "礼包详情" + str);
        Gson create = new GsonBuilder().enableComplexMapKeySerialization().create();
        Intent intent = new Intent();
        intent.putExtra("giftbag_id", this.q);
        intent.putExtra("position", this.u);
        if (i == 1) {
            GiftDetailsBean giftDetailsBean = (GiftDetailsBean) create.fromJson(str, GiftDetailsBean.class);
            this.t = giftDetailsBean;
            com.rtk.app.tool.t.d(this.r, giftDetailsBean.getData().getGame_logo(), this.giftDetailLogo);
            this.giftDetailName.setText(this.t.getData().getGame_name());
            this.giftDetailProgressbar.setProgress((int) (this.t.getData().getGift_surplus_percent() * 100.0d));
            this.giftDetailRemaining.setText((((int) this.t.getData().getGift_surplus_percent()) * 100) + "%");
            this.giftDetailDrawTime.setText(com.rtk.app.tool.c0.f((long) this.t.getData().getTime_start()) + " 至 " + com.rtk.app.tool.c0.f(this.t.getData().getWays_to_convert_time_end()));
            this.giftDetailTip.setText(this.t.getData().getTips());
            this.giftDetailUseMethod.setText(this.t.getData().getWays_to_convert_info());
            this.giftDetailGiftInformation.setText(this.t.getData().getGift_description());
            this.giftDetailExchangeTime.setText(com.rtk.app.tool.c0.f(this.t.getData().getWays_to_convert_time_start()) + " 至 " + com.rtk.app.tool.c0.f(this.t.getData().getWays_to_convert_time_end()));
            com.rtk.app.tool.t.K1(this.t.getData().getGift_status(), this.giftDetailState, this.giftDetailProgressbarLv, this.giftDetailNo, this.t.getData().getGift_content(), this.giftDetailsHintView);
            return;
        }
        if (i == 3) {
            if (((GiftNumberBean) create.fromJson(str, GiftNumberBean.class)).getCode() == 0) {
                this.t.getData().setGift_status(4);
                intent.putExtra("giftStatus", 4);
                setResult(3, intent);
                com.rtk.app.tool.t.K1(this.t.getData().getGift_status(), this.giftDetailState, this.giftDetailProgressbarLv, this.giftDetailNo, this.t.getData().getGift_content(), this.giftDetailsHintView);
                return;
            }
            return;
        }
        if (i == 4) {
            if (((GiftNumberBean) create.fromJson(str, GiftNumberBean.class)).getCode() == 0) {
                this.t.getData().setGift_status(3);
                intent.putExtra("giftStatus", 3);
                setResult(4, intent);
                com.rtk.app.tool.t.K1(this.t.getData().getGift_status(), this.giftDetailState, this.giftDetailProgressbarLv, this.giftDetailNo, this.t.getData().getGift_content(), this.giftDetailsHintView);
                return;
            }
            return;
        }
        if (i == 6) {
            setResult(6, intent);
            GiftNumberBean giftNumberBean = (GiftNumberBean) create.fromJson(str, GiftNumberBean.class);
            if (giftNumberBean.getCode() == 0) {
                this.t.getData().setGift_content(giftNumberBean.getData().getTake_out_code());
                new DilalogLibao(MyApplication.b(), giftNumberBean.getData().getTake_out_code(), new ApkInfo(this.t.getData().getGame_id(), this.t.getData().getGame_name(), this.t.getData().getGame_package_name(), this.t.getData().getGame_logo(), null, null, 0, 0, null)).show();
                com.rtk.app.tool.t.K1(this.t.getData().getGift_status(), this.giftDetailState, this.giftDetailProgressbarLv, this.giftDetailNo, this.t.getData().getGift_content(), this.giftDetailsHintView);
                intent.putExtra("giftStatus", 6);
                intent.putExtra("giftContent", this.t.getData().getGift_content());
                return;
            }
            return;
        }
        if (i != 7) {
            return;
        }
        GiftNumberBean giftNumberBean2 = (GiftNumberBean) create.fromJson(str, GiftNumberBean.class);
        com.rtk.app.tool.c0.u("GiftDetailsActivity", "抢礼包" + str);
        if (giftNumberBean2.getCode() == 0) {
            this.t.getData().setGift_content(giftNumberBean2.getData().getReceive_code());
            this.t.getData().setGift_status(1);
            new DilalogLibao(MyApplication.b(), giftNumberBean2.getData().getReceive_code(), new ApkInfo(this.t.getData().getGame_id(), this.t.getData().getGame_name(), this.t.getData().getGame_package_name(), this.t.getData().getGame_logo(), null, null, 0, 0, null)).show();
            com.rtk.app.tool.t.K1(this.t.getData().getGift_status(), this.giftDetailState, this.giftDetailProgressbarLv, this.giftDetailNo, this.t.getData().getGift_content(), this.giftDetailsHintView);
            intent.putExtra("giftStatus", 1);
            intent.putExtra("giftContent", this.t.getData().getGift_content());
            setResult(7, intent);
        }
    }

    @Override // com.rtk.app.tool.o.h.j
    public void g(int i, String str, int i2) {
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.rtk.app.base.f
    public void initData() {
        Bundle extras = getIntent().getExtras();
        this.q = extras.getString("giftbag_id");
        this.u = extras.getInt("position");
    }

    @Override // com.rtk.app.base.f
    public void initListener() {
    }

    @Override // com.rtk.app.base.f
    public void initView() {
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        try {
            switch (view.getId()) {
                case com.rtk.app.R.id.gift_detail_back /* 2131297780 */:
                    com.rtk.app.tool.c.a((Activity) this.r);
                    return;
                case com.rtk.app.R.id.gift_detail_detail /* 2131297781 */:
                    ApkInfo apkInfo = new ApkInfo(this.t.getData().getGame_id(), this.t.getData().getGame_name(), this.t.getData().getGame_package_name(), this.t.getData().getGame_logo(), null, null, 0, 0, null);
                    LiBaoListActivity.w = true;
                    com.rtk.app.tool.t.e0(this.r, apkInfo);
                    return;
                case com.rtk.app.R.id.gift_detail_state /* 2131297792 */:
                    String trim = ((TextView) view).getText().toString().trim();
                    char c2 = 65535;
                    switch (trim.hashCode()) {
                        case 727753:
                            if (trim.equals("复制")) {
                                c2 = 0;
                                break;
                            }
                            break;
                        case 893215:
                            if (trim.equals("淘号")) {
                                c2 = 5;
                                break;
                            }
                            break;
                        case 1233814:
                            if (trim.equals("预定")) {
                                c2 = 3;
                                break;
                            }
                            break;
                        case 24279466:
                            if (trim.equals("已过期")) {
                                c2 = 1;
                                break;
                            }
                            break;
                        case 25248619:
                            if (trim.equals("抢礼包")) {
                                c2 = 6;
                                break;
                            }
                            break;
                        case 659957586:
                            if (trim.equals("即将淘号")) {
                                c2 = 4;
                                break;
                            }
                            break;
                        case 667554696:
                            if (trim.equals("取消预定")) {
                                c2 = 2;
                                break;
                            }
                            break;
                    }
                    if (c2 == 0) {
                        com.rtk.app.tool.t.I1(this.r, this.t.getData().getGift_content());
                        return;
                    }
                    if (c2 == 2) {
                        L(3);
                        return;
                    }
                    if (c2 == 3) {
                        L(4);
                        return;
                    }
                    if (c2 == 5) {
                        L(6);
                        return;
                    }
                    if (c2 != 6) {
                        return;
                    }
                    com.rtk.app.tool.c0.u("GiftDetailsActivity", "礼包包名" + this.t.getData().getGame_package_name() + "   " + this.t.getData().getOtherPackage());
                    if (this.t.getData().getNeed_install_game() != 0 && !com.rtk.app.tool.t.q1(this.r, this.t.getData().getGame_package_name()) && !com.rtk.app.tool.t.q1(this.r, this.t.getData().getOtherPackage())) {
                        com.rtk.app.tool.f.a(this.r, "请安装游戏后再领取", f.a.f);
                        return;
                    }
                    L(7);
                    return;
                default:
                    return;
            }
        } catch (Exception unused) {
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.rtk.app.base.BaseActivity, com.rtk.app.custom.SwipeBackActivity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(com.rtk.app.R.layout.activity_gift_details);
        ButterKnife.a(this);
        this.r = this;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.rtk.app.base.BaseActivity
    public void onResume() {
        super.onResume();
        L(1);
    }
}
