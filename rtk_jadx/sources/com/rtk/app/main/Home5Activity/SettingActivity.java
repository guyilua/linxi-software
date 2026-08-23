package com.rtk.app.main.Home5Activity;

import android.R;
import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.rtk.app.base.BaseActivity;
import com.rtk.app.bean.MainUseProtocolUpdateNoticeBean;
import com.rtk.app.main.MainActivityPack.MainActivity;
import com.rtk.app.main.MyApplication;
import com.rtk.app.main.dialogPack.DialogEditTipEnsure;
import com.rtk.app.main.dialogPack.DialogUpdata;
import com.rtk.app.main.dialogPack.TeenModeTipDialog;
import com.rtk.app.main.login.InformationActivity;
import com.rtk.app.main.login.UpdataPswActivity;
import com.rtk.app.tool.o.h;
import com.sigmob.sdk.downloader.f;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class SettingActivity extends BaseActivity implements h.j {
    private boolean A;
    private boolean B;
    private boolean C;
    private boolean D;
    private String E;
    private Context q;
    private boolean r;
    private boolean s;

    @BindView
    TextView settingAboutUs;

    @BindView
    TextView settingBackBackTV;

    @BindView
    LinearLayout settingBackLayout;

    @BindView
    TextView settingCheckUpdata;

    @BindView
    CheckBox settingDeleteAfterInstallation;

    @BindView
    CheckBox settingDeleteLineFeed;

    @BindView
    CheckBox settingDevelop;

    @BindView
    LinearLayout settingDevelopLv;

    @BindView
    TextView settingDownAdd;

    @BindView
    TextView settingDownAddUp;

    @BindView
    TextView settingDownNum;

    @BindView
    TextView settingDownNumUp;

    @BindView
    TextView settingDownReduce;

    @BindView
    TextView settingDownReduceUp;

    @BindView
    TextView settingFeedBack;

    @BindView
    CheckBox settingInstallSelectorImg;

    @BindView
    TextView settingLoginOut;

    @BindView
    CheckBox settingMouldPostJustTitle;

    @BindView
    CheckBox settingMouldRule;

    @BindView
    CheckBox settingNightOriginal;

    @BindView
    CheckBox settingNoWifiTips;

    @BindView
    CheckBox settingPostConcise;

    @BindView
    TextView settingRealNameAuth;

    @BindView
    CheckBox settingTeenMode;

    @BindView
    TextView settingUpdataPsw;

    @BindView
    CheckBox settingUpgradableNotice;

    @BindView
    TextView settingUsagePrivacy;

    @BindView
    TextView settingUsageProtocol;
    private boolean t;
    private boolean u;
    private MainUseProtocolUpdateNoticeBean v;
    private DialogUpdata w;
    private boolean x;
    private boolean y;
    private boolean z;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: /tmp/rtk_apk/classes3.dex */
    public class a implements com.rtk.app.base.h {
        a() {
        }

        @Override // com.rtk.app.base.h
        public void a(String... strArr) {
            SettingActivity settingActivity = SettingActivity.this;
            settingActivity.settingTeenMode.setChecked(settingActivity.D);
        }

        @Override // com.rtk.app.base.h
        public void b(String... strArr) {
            if (strArr.length < 1) {
                com.rtk.app.tool.c0.u("SettingActivity", "密码为空");
                com.rtk.app.tool.f.a(SettingActivity.this.f147c, "密码为空", f.a.f);
                return;
            }
            if (com.rtk.app.tool.v.d(SettingActivity.this.f147c, "TEEN_MODE_PASSWORD").equals(strArr[0])) {
                com.rtk.app.tool.v.e(SettingActivity.this.f147c, "IS_OPEN_TENN_MODE", Boolean.FALSE);
                SettingActivity.this.D = false;
                com.rtk.app.tool.f.a(SettingActivity.this.f147c, "青少年模式已关闭", f.a.f);
            } else {
                com.rtk.app.tool.f.a(SettingActivity.this.f147c, "密码错误，可联系客服找回", f.a.f);
            }
            SettingActivity settingActivity = SettingActivity.this;
            settingActivity.settingTeenMode.setChecked(settingActivity.D);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: /tmp/rtk_apk/classes3.dex */
    public class b implements com.rtk.app.base.h {
        b() {
        }

        @Override // com.rtk.app.base.h
        public void a(String... strArr) {
            SettingActivity settingActivity = SettingActivity.this;
            settingActivity.settingTeenMode.setChecked(settingActivity.D);
        }

        @Override // com.rtk.app.base.h
        public void b(String... strArr) {
            if (strArr.length >= 2) {
                SettingActivity.this.E = strArr[0];
                SettingActivity settingActivity = SettingActivity.this;
                com.rtk.app.tool.v.h(settingActivity.f147c, "TEEN_MODE_PASSWORD", settingActivity.E);
                com.rtk.app.tool.v.e(SettingActivity.this.f147c, "IS_OPEN_TENN_MODE", Boolean.TRUE);
                com.rtk.app.tool.g.e.h(SettingActivity.this.f147c);
                com.rtk.app.tool.g.e.c().o((long) (Double.parseDouble(strArr[1]) * 60000.0d));
                com.rtk.app.tool.g.d.c(SettingActivity.this.f147c).e(com.rtk.app.c.d.b(), System.currentTimeMillis(), 0L);
                SettingActivity.this.D = true;
                SettingActivity.this.settingTeenMode.setChecked(true);
                com.rtk.app.tool.f.a(SettingActivity.this.f147c, "青少年模式已开启", f.a.f);
                SettingActivity.this.Q(2);
                return;
            }
            com.rtk.app.tool.c0.s("SettingActivity", "未完整输入");
            com.rtk.app.tool.f.a(SettingActivity.this.f147c, "未完整输入", 5000);
        }
    }

    private void P() {
        DialogEditTipEnsure dialogEditTipEnsure = new DialogEditTipEnsure(this.f147c, "关闭青少年模式", new a());
        dialogEditTipEnsure.q("请输入青少年模式密码");
        dialogEditTipEnsure.t(4, "密码长度为4位");
        dialogEditTipEnsure.show();
    }

    private void R() {
        new TeenModeTipDialog(this.f147c, new b()).show();
    }

    @Override // com.rtk.app.base.BaseActivity
    protected void A() {
        com.rtk.app.tool.t.S1(this.q, this.settingBackLayout, null, null, ((ViewGroup) findViewById(R.id.content)).getChildAt(0));
    }

    public void Q(int... iArr) {
        int i = iArr[0];
        String str = "";
        if (i == 1) {
            if (!com.rtk.app.tool.c0.q(com.rtk.app.tool.y.K())) {
                str = "&uid=" + com.rtk.app.tool.y.K() + "&token=" + com.rtk.app.tool.y.H();
            }
            Context context = this.q;
            com.rtk.app.tool.o.i h = com.rtk.app.tool.o.h.h(new String[0]);
            StringBuilder sb = new StringBuilder();
            sb.append("system/checkAppVersion");
            sb.append(com.rtk.app.tool.y.u(this.q));
            sb.append("&app_version=");
            sb.append(com.rtk.app.tool.t.Y(this.q));
            sb.append("&device_id=");
            sb.append(com.rtk.app.tool.y.o(this.q));
            sb.append(str);
            sb.append("&params=all&key=");
            sb.append(com.rtk.app.tool.t.c0(com.rtk.app.tool.c0.e(com.rtk.app.tool.y.v(this.q, "app_version=" + com.rtk.app.tool.t.Y(this.q)))));
            com.rtk.app.tool.o.h.l(context, this, 1, h.a(sb.toString()));
            return;
        }
        if (i != 2) {
            return;
        }
        String K = com.rtk.app.tool.y.K();
        String H = com.rtk.app.tool.y.H();
        if (!com.rtk.app.tool.c0.q(K) && !com.rtk.app.tool.c0.q(H)) {
            str = "&uid=" + K + "&token=" + H;
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append("other/adolescent");
        sb2.append(com.rtk.app.tool.y.u(this.q));
        sb2.append("&device_name=");
        sb2.append(com.rtk.app.tool.y.p(this.q));
        sb2.append("&device_id=");
        sb2.append(com.rtk.app.tool.y.o(this.q));
        sb2.append("&password=");
        sb2.append(this.E);
        sb2.append(str);
        sb2.append("&key=");
        sb2.append(com.rtk.app.tool.t.c0(com.rtk.app.tool.c0.e(com.rtk.app.tool.y.v(this.q, "device_name=" + com.rtk.app.tool.y.p(this.q), "device_id=" + com.rtk.app.tool.y.o(this.q), "password=" + this.E))));
        com.rtk.app.tool.o.h.l(this.q, this, iArr[0], com.rtk.app.tool.o.h.h(com.rtk.app.tool.y.e).a(sb2.toString()));
    }

    @Override // com.rtk.app.tool.o.h.j
    public void d(String str, int i) {
        Gson create = new GsonBuilder().enableComplexMapKeySerialization().create();
        if (i != 1) {
            if (i != 2) {
                return;
            }
            com.rtk.app.tool.c0.u("SettingActivity", "更新青少年模式密码" + str);
            return;
        }
        com.rtk.app.tool.c0.u("SettingActivity", "更新app" + str);
        this.v = (MainUseProtocolUpdateNoticeBean) create.fromJson(str, MainUseProtocolUpdateNoticeBean.class);
        DialogUpdata dialogUpdata = new DialogUpdata(MyApplication.b(), this.v.getData().getCheckupdates());
        this.w = dialogUpdata;
        dialogUpdata.p();
    }

    @Override // com.rtk.app.tool.o.h.j
    public void g(int i, String str, int i2) {
    }

    @Override // com.rtk.app.base.f
    public void initData() {
        this.settingDownNum.setText(com.rtk.app.tool.y.q + "");
        this.settingDownNumUp.setText(com.rtk.app.tool.y.r + "");
        this.r = com.rtk.app.tool.v.a(this.q, "settingNoWifiVALUE");
        this.s = com.rtk.app.tool.v.a(this.q, "settingInstallVALUE");
        this.t = com.rtk.app.tool.v.a(this.q, "settingDeleteAfterInstallVALUE");
        this.C = com.rtk.app.tool.v.a(this.f147c, "postJustTitle");
        this.D = com.rtk.app.tool.v.a(this.f147c, "IS_OPEN_TENN_MODE");
        this.u = com.rtk.app.tool.v.a(this.q, "settingUpgradableNoticeVALUE");
        this.x = com.rtk.app.tool.v.a(this.q, "postConciseVALUE");
        this.y = com.rtk.app.tool.v.a(this.q, "postModuleRuleVaule");
        this.A = com.rtk.app.tool.v.a(this.f147c, com.rtk.app.tool.v.i);
        this.z = com.rtk.app.tool.v.a(this.q, "developOpen");
        this.B = com.rtk.app.tool.v.a(this.f147c, com.rtk.app.tool.v.j);
        this.settingNoWifiTips.setChecked(this.r);
        this.settingInstallSelectorImg.setChecked(this.s);
        this.settingDeleteAfterInstallation.setChecked(this.t);
        this.settingMouldPostJustTitle.setChecked(this.C);
        this.settingTeenMode.setChecked(this.D);
        this.settingUpgradableNotice.setChecked(this.u);
        this.settingUpgradableNotice.setChecked(this.u);
        this.settingPostConcise.setChecked(this.x);
        this.settingMouldRule.setChecked(this.y);
        this.settingDeleteLineFeed.setChecked(this.A);
        this.settingDevelop.setChecked(this.z);
        this.settingNightOriginal.setChecked(this.B);
    }

    @Override // com.rtk.app.base.f
    public void initListener() {
    }

    @Override // com.rtk.app.base.f
    public void initView() {
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        switch (view.getId()) {
            case com.rtk.app.R.id.setting_aboutUs /* 2131300162 */:
                com.rtk.app.tool.c.b((Activity) this.q, AboutUsAndHelpActivity.class, null);
                return;
            case com.rtk.app.R.id.setting_back_backTV /* 2131300163 */:
                com.rtk.app.tool.c.a((Activity) this.q);
                return;
            case com.rtk.app.R.id.setting_back_layout /* 2131300164 */:
            case com.rtk.app.R.id.setting_develop_lv /* 2131300170 */:
            case com.rtk.app.R.id.setting_down_num /* 2131300173 */:
            case com.rtk.app.R.id.setting_down_num_up /* 2131300174 */:
            default:
                return;
            case com.rtk.app.R.id.setting_blacklist_manage /* 2131300165 */:
                com.rtk.app.tool.c.b(this, BlacklistListActivity.class, null);
                return;
            case com.rtk.app.R.id.setting_checkUpdata /* 2131300166 */:
                Q(1);
                return;
            case com.rtk.app.R.id.setting_delete_after_installation /* 2131300167 */:
                boolean a2 = com.rtk.app.tool.v.a(this.q, "settingDeleteAfterInstallVALUE");
                this.t = a2;
                boolean z = !a2;
                this.t = z;
                com.rtk.app.tool.v.e(this.q, "settingDeleteAfterInstallVALUE", Boolean.valueOf(z));
                this.settingDeleteAfterInstallation.setChecked(this.t);
                return;
            case com.rtk.app.R.id.setting_delete_line_feed /* 2131300168 */:
                boolean a3 = com.rtk.app.tool.v.a(this.f147c, com.rtk.app.tool.v.i);
                this.A = a3;
                boolean z2 = !a3;
                this.A = z2;
                com.rtk.app.tool.v.e(this.f147c, com.rtk.app.tool.v.i, Boolean.valueOf(z2));
                this.settingDeleteLineFeed.setChecked(this.A);
                return;
            case com.rtk.app.R.id.setting_develop /* 2131300169 */:
                boolean a4 = com.rtk.app.tool.v.a(this.q, "developOpen");
                this.z = a4;
                boolean z3 = !a4;
                this.z = z3;
                com.rtk.app.tool.v.e(this.q, "developOpen", Boolean.valueOf(z3));
                this.settingDevelop.setChecked(this.z);
                return;
            case com.rtk.app.R.id.setting_down_add /* 2131300171 */:
                int i = com.rtk.app.tool.y.q;
                if (i < 5) {
                    Context context = this.q;
                    int i2 = i + 1;
                    com.rtk.app.tool.y.q = i2;
                    com.rtk.app.tool.v.f(context, "settingDownStackNum", i2);
                }
                this.settingDownNum.setText(com.rtk.app.tool.y.q + "");
                return;
            case com.rtk.app.R.id.setting_down_add_up /* 2131300172 */:
                int i3 = com.rtk.app.tool.y.r;
                if (i3 < 5) {
                    Context context2 = this.q;
                    int i4 = i3 + 1;
                    com.rtk.app.tool.y.r = i4;
                    com.rtk.app.tool.v.f(context2, "settingDownStackNumUp", i4);
                }
                this.settingDownNumUp.setText(com.rtk.app.tool.y.r + "");
                return;
            case com.rtk.app.R.id.setting_down_reduce /* 2131300175 */:
                int i5 = com.rtk.app.tool.y.q;
                if (i5 > 1) {
                    Context context3 = this.q;
                    int i6 = i5 - 1;
                    com.rtk.app.tool.y.q = i6;
                    com.rtk.app.tool.v.f(context3, "settingDownStackNum", i6);
                }
                this.settingDownNum.setText(com.rtk.app.tool.y.q + "");
                return;
            case com.rtk.app.R.id.setting_down_reduce_up /* 2131300176 */:
                int i7 = com.rtk.app.tool.y.r;
                if (i7 > 1) {
                    Context context4 = this.q;
                    int i8 = i7 - 1;
                    com.rtk.app.tool.y.r = i8;
                    com.rtk.app.tool.v.f(context4, "settingDownStackNumUp", i8);
                }
                this.settingDownNumUp.setText(com.rtk.app.tool.y.r + "");
                return;
            case com.rtk.app.R.id.setting_edit_into /* 2131300177 */:
                if (!com.rtk.app.tool.y.x(this.q)) {
                    com.rtk.app.tool.t.w0(this.q);
                    return;
                } else {
                    com.rtk.app.tool.c.b((Activity) this.q, InformationActivity.class, null);
                    return;
                }
            case com.rtk.app.R.id.setting_feedBack /* 2131300178 */:
                com.rtk.app.tool.c.b((Activity) this.q, FeedBackdActivity.class, null);
                return;
            case com.rtk.app.R.id.setting_install_selector_img /* 2131300179 */:
                boolean a5 = com.rtk.app.tool.v.a(this.q, "settingInstallVALUE");
                this.s = a5;
                boolean z4 = !a5;
                this.s = z4;
                com.rtk.app.tool.v.e(this.q, "settingInstallVALUE", Boolean.valueOf(z4));
                this.settingInstallSelectorImg.setChecked(this.s);
                return;
            case com.rtk.app.R.id.setting_loginOut /* 2131300180 */:
                com.rtk.app.tool.y.e(this.q);
                MainActivity.p = null;
                com.rtk.app.tool.c.a((Activity) this.q);
                return;
            case com.rtk.app.R.id.setting_mould_post_just_title /* 2131300181 */:
                boolean a6 = com.rtk.app.tool.v.a(this.f147c, "postJustTitle");
                this.C = a6;
                boolean z5 = !a6;
                this.C = z5;
                com.rtk.app.tool.v.e(this.f147c, "postJustTitle", Boolean.valueOf(z5));
                this.settingMouldPostJustTitle.setChecked(this.C);
                return;
            case com.rtk.app.R.id.setting_mould_rule /* 2131300182 */:
                boolean a7 = com.rtk.app.tool.v.a(this.q, "postModuleRuleVaule");
                this.y = a7;
                boolean z6 = !a7;
                this.y = z6;
                com.rtk.app.tool.v.e(this.q, "postModuleRuleVaule", Boolean.valueOf(z6));
                this.settingMouldRule.setChecked(this.y);
                return;
            case com.rtk.app.R.id.setting_night_original /* 2131300183 */:
                boolean a8 = com.rtk.app.tool.v.a(this.f147c, com.rtk.app.tool.v.j);
                this.B = a8;
                boolean z7 = !a8;
                this.B = z7;
                com.rtk.app.tool.v.e(this.f147c, com.rtk.app.tool.v.j, Boolean.valueOf(z7));
                this.settingNightOriginal.setChecked(this.B);
                return;
            case com.rtk.app.R.id.setting_noWifi_tips /* 2131300184 */:
                boolean a9 = com.rtk.app.tool.v.a(this.q, "settingNoWifiVALUE");
                this.r = a9;
                boolean z8 = !a9;
                this.r = z8;
                com.rtk.app.tool.v.e(this.q, "settingNoWifiVALUE", Boolean.valueOf(z8));
                this.settingNoWifiTips.setChecked(this.r);
                return;
            case com.rtk.app.R.id.setting_post_concise /* 2131300185 */:
                boolean a10 = com.rtk.app.tool.v.a(this.q, "postConciseVALUE");
                this.x = a10;
                boolean z9 = !a10;
                this.x = z9;
                com.rtk.app.tool.v.e(this.q, "postConciseVALUE", Boolean.valueOf(z9));
                this.settingPostConcise.setChecked(this.x);
                return;
            case com.rtk.app.R.id.setting_real_name_auth /* 2131300186 */:
                com.rtk.app.tool.c.b((Activity) this.q, RealNameAuthActivity.class, null);
                return;
            case com.rtk.app.R.id.setting_teen_mode /* 2131300187 */:
                com.rtk.app.tool.c0.u("SettingActivity", "青少年模式" + this.D);
                boolean a11 = com.rtk.app.tool.v.a(this.f147c, "IS_OPEN_TENN_MODE");
                this.D = a11;
                if (!a11) {
                    R();
                    return;
                } else {
                    P();
                    return;
                }
            case com.rtk.app.R.id.setting_updataPsw /* 2131300188 */:
                com.rtk.app.tool.c.b((Activity) this.q, UpdataPswActivity.class, null);
                return;
            case com.rtk.app.R.id.setting_upgradable_notice /* 2131300189 */:
                boolean a12 = com.rtk.app.tool.v.a(this.q, "settingUpgradableNoticeVALUE");
                this.u = a12;
                boolean z10 = !a12;
                this.u = z10;
                com.rtk.app.tool.v.e(this.q, "settingUpgradableNoticeVALUE", Boolean.valueOf(z10));
                this.settingUpgradableNotice.setChecked(this.u);
                return;
            case com.rtk.app.R.id.setting_usage_privacy /* 2131300190 */:
                com.rtk.app.tool.c.b((Activity) this.q, PrivacyOfUsageActivity.class, null);
                return;
            case com.rtk.app.R.id.setting_usage_protocol /* 2131300191 */:
                com.rtk.app.tool.c.b((Activity) this.q, ProtocolOfUsageActivity.class, null);
                return;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.rtk.app.base.BaseActivity, com.rtk.app.custom.SwipeBackActivity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(com.rtk.app.R.layout.activity_setting);
        ButterKnife.a(this);
        this.q = this;
    }
}
