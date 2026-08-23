package com.rtk.app.main.Home5Activity;

import android.R;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import butterknife.BindView;
import butterknife.ButterKnife;
import cn.sharesdk.framework.Platform;
import cn.sharesdk.framework.PlatformActionListener;
import cn.sharesdk.framework.ShareSDK;
import cn.sharesdk.tencent.qq.QQ;
import cn.sharesdk.wechat.friends.Wechat;
import com.makeramen.roundedimageview.RoundedImageView;
import com.rtk.app.base.BaseActivity;
import com.rtk.app.bean.Home5ImfromationBean;
import com.rtk.app.bean.LoginBean;
import com.rtk.app.custom.YcSwipeRefreshLayout;
import com.rtk.app.main.Home5Activity.AccountSecurityActivity;
import com.rtk.app.main.MainActivityPack.MainActivity;
import com.rtk.app.main.dialogPack.DialogChangePhone;
import com.rtk.app.main.dialogPack.DialogForCheckPsw;
import com.rtk.app.main.dialogPack.DialogForEnSure;
import com.rtk.app.main.dialogPack.DialogForProgressTip;
import com.rtk.app.main.dialogPack.DialogUpdatePsw;
import com.rtk.app.main.login.InformationActivity;
import com.rtk.app.tool.o.h;
import com.sigmob.sdk.downloader.f;
import com.umeng.analytics.pro.ak;
import java.util.HashMap;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class AccountSecurityActivity extends BaseActivity implements h.j, PlatformActionListener {
    private Home5ImfromationBean B;
    private String C;

    @BindView
    TextView accountSecurityBoundPhone;

    @BindView
    LinearLayout accountSecurityBoundQQLv;

    @BindView
    LinearLayout accountSecurityHeadLv;

    @BindView
    RoundedImageView accountSecurityLogo;

    @BindView
    TextView accountSecurityNickName;

    @BindView
    TextView accountSecurityPhone;

    @BindView
    TextView accountSecurityQQ;

    @BindView
    ImageView accountSecurityQQFace;

    @BindView
    YcSwipeRefreshLayout accountSecurityRefreshLayout;

    @BindView
    TextView accountSecurityRegisterTime;

    @BindView
    TextView accountSecuritySignature;

    @BindView
    TextView accountSecurityTopBack;

    @BindView
    LinearLayout accountSecurityTopLayout;

    @BindView
    TextView accountSecurityUpdataPsw;

    @BindView
    ImageView accountSecurityWFace;

    @BindView
    TextView accountSecurityWechat;

    @BindView
    LinearLayout accountSecurityWechatLv;
    private DialogForProgressTip q;
    private DialogForEnSure r;
    private Platform s;
    private int u;
    private String t = "";
    private String v = "";
    private String w = "";
    private String x = "";
    private String y = "";
    private String z = "";
    private String A = "";

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: /tmp/rtk_apk/classes3.dex */
    public class a implements DialogForCheckPsw.a {
        a() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public /* synthetic */ void d(String[] strArr) {
            MainActivity.p.getData().setMobile(strArr[0]);
            AccountSecurityActivity.this.accountSecurityPhone.setText(strArr[0]);
            AccountSecurityActivity accountSecurityActivity = AccountSecurityActivity.this;
            com.rtk.app.tool.v.h(accountSecurityActivity.f147c, "userInformation", accountSecurityActivity.g.toJson(MainActivity.p));
            com.rtk.app.tool.c0.u("AccountSecurityActivity", "保存Login  或者说更新信息" + AccountSecurityActivity.this.g.toJson(MainActivity.p));
        }

        @Override // com.rtk.app.main.dialogPack.DialogForCheckPsw.a
        public void a() {
        }

        /* JADX WARN: Type inference failed for: r1v0, types: [android.content.Context, com.rtk.app.main.Home5Activity.AccountSecurityActivity] */
        @Override // com.rtk.app.main.dialogPack.DialogForCheckPsw.a
        public void b() {
            ?? r1 = AccountSecurityActivity.this;
            new DialogChangePhone(r1, ((AccountSecurityActivity) r1).C, new com.rtk.app.tool.s() { // from class: com.rtk.app.main.Home5Activity.a
                @Override // com.rtk.app.tool.s
                public final void a(String[] strArr) {
                    AccountSecurityActivity.a.this.d(strArr);
                }
            }).show();
        }
    }

    /* loaded from: /tmp/rtk_apk/classes3.dex */
    class b implements com.rtk.app.tool.s {
        b() {
        }

        @Override // com.rtk.app.tool.s
        public void a(String... strArr) {
            AccountSecurityActivity.this.t = "&unbind=1";
            AccountSecurityActivity.this.u = 1;
            AccountSecurityActivity accountSecurityActivity = AccountSecurityActivity.this;
            accountSecurityActivity.v = accountSecurityActivity.B.getData().getQqLogin().getOpenid();
            AccountSecurityActivity.this.S(3);
        }
    }

    /* loaded from: /tmp/rtk_apk/classes3.dex */
    class c implements com.rtk.app.tool.s {
        c() {
        }

        @Override // com.rtk.app.tool.s
        public void a(String... strArr) {
            AccountSecurityActivity.this.r.show();
            AccountSecurityActivity.this.t = "&unbind=1";
            AccountSecurityActivity.this.u = 2;
            AccountSecurityActivity accountSecurityActivity = AccountSecurityActivity.this;
            accountSecurityActivity.v = accountSecurityActivity.B.getData().getWxLogin().getUnionid();
            AccountSecurityActivity.this.S(3);
        }
    }

    /* loaded from: /tmp/rtk_apk/classes3.dex */
    class d implements SwipeRefreshLayout.OnRefreshListener {
        d() {
        }

        public void onRefresh() {
            AccountSecurityActivity.this.S(0);
        }
    }

    /* loaded from: /tmp/rtk_apk/classes3.dex */
    class e implements com.rtk.app.tool.s {
        e() {
        }

        @Override // com.rtk.app.tool.s
        public void a(String... strArr) {
            AccountSecurityActivity.this.A = "&alread=1";
            AccountSecurityActivity.this.S(3);
            AccountSecurityActivity.this.A = "";
        }
    }

    @Override // com.rtk.app.base.BaseActivity
    protected void A() {
        com.rtk.app.tool.t.S1(this.f147c, this.accountSecurityTopLayout, null, null, ((ViewGroup) findViewById(R.id.content)).getChildAt(0), this.accountSecurityHeadLv);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void S(int... iArr) {
        int i = iArr[0];
        String str = "";
        if (i == 0) {
            StringBuilder sb = new StringBuilder();
            sb.append("members/userBaseInfo");
            sb.append(com.rtk.app.tool.y.u(this.f147c));
            sb.append("&uid=");
            sb.append(com.rtk.app.tool.y.K());
            sb.append("&token=");
            sb.append(com.rtk.app.tool.y.H());
            sb.append("&key=");
            sb.append(com.rtk.app.tool.t.c0(com.rtk.app.tool.c0.e(com.rtk.app.tool.y.v(this.f147c, "uid=" + com.rtk.app.tool.y.K(), "token=" + com.rtk.app.tool.y.H()))));
            str = sb.toString();
        } else if (i == 3) {
            HashMap hashMap = new HashMap();
            hashMap.put("channel", com.rtk.app.tool.y.m(this.f147c, getPackageName()));
            hashMap.put("version", com.rtk.app.tool.y.i(this.f147c));
            hashMap.put(ak.aj, com.rtk.app.tool.y.g());
            hashMap.put("phone_model", com.rtk.app.tool.y.T());
            hashMap.put("uid", com.rtk.app.tool.y.K());
            hashMap.put("token", com.rtk.app.tool.y.H());
            hashMap.put("number", this.v);
            hashMap.put("tag", this.u + "");
            if (!com.rtk.app.tool.c0.q(this.t)) {
                hashMap.put("unbind", "1");
            }
            if (!com.rtk.app.tool.c0.q(this.A)) {
                hashMap.put("alread", "1");
            }
            if (this.u == 1) {
                hashMap.put("q_nickname", this.w);
                hashMap.put("q_face", this.x);
            } else {
                hashMap.put("w_nickname", this.y);
                hashMap.put("w_face", this.z);
            }
            hashMap.put("key", com.rtk.app.tool.t.c0(com.rtk.app.tool.c0.e(com.rtk.app.tool.y.v(this.f147c, "tag=" + this.u, "uid=" + MainActivity.p.getData().getUid(), "token=" + com.rtk.app.tool.y.H()))));
            StringBuilder sb2 = new StringBuilder();
            sb2.append("绑定QQ/微信传送的数据  ");
            sb2.append(hashMap.toString());
            com.rtk.app.tool.c0.u("AccountSecurityActivity", sb2.toString());
            AppCompatActivity appCompatActivity = this.f147c;
            StringBuilder sb3 = new StringBuilder();
            sb3.append(com.rtk.app.tool.y.d);
            sb3.append("members/bindWebchat");
            com.rtk.app.tool.o.h.j(appCompatActivity, this, sb3.toString(), iArr[0], hashMap);
        }
        if (com.rtk.app.tool.c0.q(str)) {
            return;
        }
        com.rtk.app.tool.o.h.l(this.f147c, this, iArr[0], com.rtk.app.tool.o.h.h(new String[0]).a(str));
    }

    @Override // com.rtk.app.tool.o.h.j
    public void d(String str, int i) {
        LoginBean loginBean;
        if (i == 0) {
            com.rtk.app.tool.c0.u("AccountSecurityActivity", "个人信息  " + str);
            this.accountSecurityRefreshLayout.setRefreshing(false);
            this.B = (Home5ImfromationBean) this.g.fromJson(str, Home5ImfromationBean.class);
            com.rtk.app.tool.v.h(this.f147c, com.rtk.app.tool.v.f, str);
            if (this.B.getData() != null && (loginBean = MainActivity.p) != null && loginBean.getData() != null) {
                MainActivity.p.getData().setHome5BeanToLoginBean(this.B);
            }
            initView();
            com.rtk.app.tool.c0.u("AccountSecurityActivity", "时间  " + MainActivity.p.getData().getCreated());
            this.accountSecurityRegisterTime.setText(com.rtk.app.tool.c0.g(this.B.getData().getCreated()));
            return;
        }
        if (i != 3) {
            return;
        }
        this.q.dismiss();
        if (this.u == 1) {
            com.rtk.app.tool.c0.u("AccountSecurityActivity", "22");
            com.rtk.app.tool.y.Q(this.v, this.x, this.w);
        } else {
            com.rtk.app.tool.c0.u("AccountSecurityActivity", "33");
            com.rtk.app.tool.y.R(this.v, this.z, this.y);
        }
        com.rtk.app.tool.c0.u("AccountSecurityActivity", "44");
        com.rtk.app.tool.c0.u("AccountSecurityActivity", "绑定成功" + str);
        if (!com.rtk.app.tool.c0.q(this.t)) {
            com.rtk.app.tool.f.a(this.f147c, "已解绑", f.a.f);
            this.r.dismiss();
        } else {
            com.rtk.app.tool.f.a(this.f147c, "已绑定", f.a.f);
        }
        S(0);
        this.t = "";
    }

    @Override // com.rtk.app.tool.o.h.j
    public void g(int i, String str, int i2) {
        if (i2 == 0) {
            this.accountSecurityRefreshLayout.setRefreshing(false);
            com.rtk.app.tool.f.a(this.f147c, str, f.a.f);
            if (i == 2001) {
                com.rtk.app.tool.t.w0(this.f147c);
                return;
            }
            return;
        }
        if (i2 != 3) {
            return;
        }
        this.q.dismiss();
        com.rtk.app.tool.f.a(this.f147c, str, f.a.f);
        if (i == 9107) {
            new DialogForEnSure(this.f147c, str, new e()).show();
        }
    }

    @Override // com.rtk.app.base.f
    public void initData() {
        S(0);
        this.q = new DialogForProgressTip(this.f147c, "绑定中，请稍后...");
        this.B = (Home5ImfromationBean) this.g.fromJson(com.rtk.app.tool.v.d(this.f147c, com.rtk.app.tool.v.f), Home5ImfromationBean.class);
    }

    @Override // com.rtk.app.base.f
    public void initListener() {
        this.accountSecurityRefreshLayout.setOnRefreshListener(new d());
    }

    @Override // com.rtk.app.base.f
    public void initView() {
        com.rtk.app.tool.t.c(this.f147c, MainActivity.p.getData().getFace(), this.accountSecurityLogo, new boolean[0]);
        this.accountSecurityNickName.setText(MainActivity.p.getData().getNickname());
        this.accountSecurityPhone.setText(MainActivity.p.getData().getMobile());
        this.accountSecuritySignature.setText(MainActivity.p.getData().getSignature());
        try {
            if (com.rtk.app.tool.c0.q(this.B.getData().getQqLogin().getOpenid())) {
                this.accountSecurityQQFace.setImageBitmap(null);
                this.accountSecurityQQ.setText("未绑定");
            } else {
                com.rtk.app.tool.t.c(this.f147c, this.B.getData().getQqLogin().getQ_face(), this.accountSecurityQQFace, new boolean[0]);
                this.accountSecurityQQ.setText(this.B.getData().getQqLogin().getQ_nickname());
            }
            if (com.rtk.app.tool.c0.q(this.B.getData().getWxLogin().getUnionid())) {
                this.accountSecurityWFace.setImageBitmap(null);
                this.accountSecurityWechat.setText("未绑定");
            } else {
                com.rtk.app.tool.t.c(this.f147c, this.B.getData().getWxLogin().getW_face(), this.accountSecurityWFace, new boolean[0]);
                this.accountSecurityWechat.setText(this.B.getData().getWxLogin().getW_nickname());
            }
        } catch (Exception unused) {
        }
    }

    public void onCancel(Platform platform, int i) {
        com.rtk.app.tool.f.a(this.f147c, "授权取消", f.a.f);
        this.q.dismiss();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        switch (view.getId()) {
            case com.rtk.app.R.id.account_security_boundPhone /* 2131296335 */:
                new DialogForCheckPsw(this.f147c, new a()).show();
                return;
            case com.rtk.app.R.id.account_security_bound_QQ_lv /* 2131296336 */:
                if (!com.rtk.app.tool.y.A() && com.rtk.app.tool.c0.q(MainActivity.p.getData().getQqLogin().getOpenid())) {
                    this.q.show();
                    Platform platform = ShareSDK.getPlatform(QQ.NAME);
                    this.s = platform;
                    platform.removeAccount(true);
                    this.s.SSOSetting(false);
                    this.s.setPlatformActionListener(this);
                    this.s.showUser((String) null);
                    return;
                }
                DialogForEnSure dialogForEnSure = new DialogForEnSure(this.f147c, "确定解除绑定吗？", new b());
                this.r = dialogForEnSure;
                dialogForEnSure.show();
                return;
            case com.rtk.app.R.id.account_security_head_lv /* 2131296337 */:
                com.rtk.app.tool.c.b(this.f147c, InformationActivity.class, null);
                return;
            case com.rtk.app.R.id.account_security_topBack /* 2131296344 */:
                finish();
                return;
            case com.rtk.app.R.id.account_security_updata_psw /* 2131296346 */:
                new DialogUpdatePsw(this.f147c).show();
                return;
            case com.rtk.app.R.id.account_security_wechat_lv /* 2131296349 */:
                if (!com.rtk.app.tool.y.L() && com.rtk.app.tool.c0.q(MainActivity.p.getData().getWxLogin().getUnionid())) {
                    this.q.show();
                    Platform platform2 = ShareSDK.getPlatform(Wechat.NAME);
                    this.s = platform2;
                    platform2.removeAccount(true);
                    this.s.SSOSetting(false);
                    this.s.setPlatformActionListener(this);
                    this.s.showUser((String) null);
                    return;
                }
                DialogForEnSure dialogForEnSure2 = new DialogForEnSure(this.f147c, "确定解除绑定吗？", new c());
                this.r = dialogForEnSure2;
                dialogForEnSure2.show();
                return;
            default:
                return;
        }
    }

    public void onComplete(Platform platform, int i, HashMap<String, Object> hashMap) {
        this.q.show();
        this.v = platform.getDb().getUserId();
        if (platform.getName().equals("QQ")) {
            this.u = 1;
            this.w = com.rtk.app.tool.u.c(platform.getDb().getUserName().trim().getBytes());
            this.x = com.rtk.app.tool.u.c(platform.getDb().getUserIcon().trim().getBytes());
        } else if (platform.getName().equals("Wechat")) {
            this.u = 2;
            this.y = com.rtk.app.tool.u.c(platform.getDb().getUserName().trim().getBytes());
            this.z = com.rtk.app.tool.u.c(platform.getDb().getUserIcon().trim().getBytes());
        }
        S(3);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.rtk.app.base.BaseActivity, com.rtk.app.custom.SwipeBackActivity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(com.rtk.app.R.layout.activity_account_security);
        ButterKnife.a(this);
    }

    public void onError(Platform platform, int i, Throwable th) {
        this.q.dismiss();
        com.rtk.app.tool.f.a(this.f147c, "授权失败" + th.getMessage(), f.a.f);
    }
}
