package com.rtk.app.main.login;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.view.Window;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;
import cn.sharesdk.framework.Platform;
import cn.sharesdk.framework.PlatformActionListener;
import cn.sharesdk.framework.ShareSDK;
import cn.sharesdk.tencent.qq.QQ;
import cn.sharesdk.wechat.friends.Wechat;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.rtk.app.R;
import com.rtk.app.base.BaseActivity;
import com.rtk.app.bean.BoundQQorWechatBean;
import com.rtk.app.bean.Home5ImfromationBean;
import com.rtk.app.bean.LoginBean;
import com.rtk.app.main.Home5Activity.PrivacyOfUsageActivity;
import com.rtk.app.main.Home5Activity.RegisterProtocolActivity;
import com.rtk.app.main.MainActivityPack.MainActivity;
import com.rtk.app.main.MyApplication;
import com.rtk.app.main.dialogPack.DialogForLoginProgressTip;
import com.rtk.app.main.dialogPack.DialogLoginUserAgreement;
import com.rtk.app.main.dialogPack.a0;
import com.rtk.app.tool.c0;
import com.rtk.app.tool.n;
import com.rtk.app.tool.o.h;
import com.rtk.app.tool.s;
import com.rtk.app.tool.t;
import com.rtk.app.tool.u;
import com.rtk.app.tool.v;
import com.rtk.app.tool.y;
import com.sigmob.sdk.downloader.f;
import com.tencent.smtt.sdk.TbsListener;
import com.uc.crashsdk.export.LogType;
import com.umeng.analytics.MobclickAgent;
import java.util.HashMap;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class LoginActivity extends BaseActivity implements View.OnClickListener, com.rtk.app.base.f, h.j, PlatformActionListener {
    public static String w = "";
    public static String x = "";
    public static int y = 0;
    public static boolean z = false;

    @BindView
    ImageView loginClosed;

    @BindView
    ImageView loginForQq;

    @BindView
    ImageView loginForWeChat;

    @BindView
    TextView loginForget;

    @BindView
    TextView loginLoginBtu;

    @BindView
    CheckBox loginProtocol;

    @BindView
    TextView loginProtocolTv;

    @BindView
    EditText loginPwd;

    @BindView
    ImageView loginPwdEye;

    @BindView
    TextView loginRegister;

    @BindView
    ImageView loginRemember;

    @BindView
    EditText loginUsername;

    @BindView
    ImageView loginUsernameClear;
    private Context q;
    private boolean r;
    private Intent s;
    private Platform t;
    private DialogForLoginProgressTip u;
    private BoundQQorWechatBean v;

    /* loaded from: /tmp/rtk_apk/classes3.dex */
    class a implements TextWatcher {
        a(LoginActivity loginActivity) {
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x003e, code lost:
    
        if (r5.equals("0") == false) goto L8;
     */
    /* renamed from: M, reason: merged with bridge method [inline-methods] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public /* synthetic */ void N(java.lang.String[] r5) {
        /*
            r4 = this;
            if (r5 == 0) goto L63
            int r0 = r5.length
            if (r0 > 0) goto L6
            goto L63
        L6:
            r0 = 0
            r5 = r5[r0]
            r5.hashCode()
            r1 = -1
            int r2 = r5.hashCode()
            r3 = 1
            switch(r2) {
                case 48: goto L38;
                case 49: goto L2d;
                case 3521: goto L22;
                case 119527: goto L17;
                default: goto L15;
            }
        L15:
            r0 = -1
            goto L41
        L17:
            java.lang.String r0 = "yes"
            boolean r5 = r5.equals(r0)
            if (r5 != 0) goto L20
            goto L15
        L20:
            r0 = 3
            goto L41
        L22:
            java.lang.String r0 = "no"
            boolean r5 = r5.equals(r0)
            if (r5 != 0) goto L2b
            goto L15
        L2b:
            r0 = 2
            goto L41
        L2d:
            java.lang.String r0 = "1"
            boolean r5 = r5.equals(r0)
            if (r5 != 0) goto L36
            goto L15
        L36:
            r0 = 1
            goto L41
        L38:
            java.lang.String r2 = "0"
            boolean r5 = r5.equals(r2)
            if (r5 != 0) goto L41
            goto L15
        L41:
            r5 = 0
            switch(r0) {
                case 0: goto L5a;
                case 1: goto L50;
                case 2: goto L4c;
                case 3: goto L46;
                default: goto L45;
            }
        L45:
            goto L63
        L46:
            android.widget.CheckBox r5 = r4.loginProtocol
            r5.setChecked(r3)
            goto L63
        L4c:
            r4.finish()
            goto L63
        L50:
            android.content.Context r0 = r4.q
            android.app.Activity r0 = (android.app.Activity) r0
            java.lang.Class<com.rtk.app.main.Home5Activity.PrivacyOfUsageActivity> r1 = com.rtk.app.main.Home5Activity.PrivacyOfUsageActivity.class
            com.rtk.app.tool.c.b(r0, r1, r5)
            goto L63
        L5a:
            android.content.Context r0 = r4.q
            android.app.Activity r0 = (android.app.Activity) r0
            java.lang.Class<com.rtk.app.main.Home5Activity.RegisterProtocolActivity> r1 = com.rtk.app.main.Home5Activity.RegisterProtocolActivity.class
            com.rtk.app.tool.c.b(r0, r1, r5)
        L63:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.rtk.app.main.login.LoginActivity.N(java.lang.String[]):void");
    }

    private void O() {
        this.u.show();
        L(1);
        v.h(this.q, "userPhone", w);
        if (this.r) {
            v.h(this.q, "userPsw", x);
        } else {
            v.h(this.q, "userPsw", "");
        }
    }

    @Override // com.rtk.app.base.BaseActivity
    protected void A() {
    }

    public void L(int... iArr) {
        String sb;
        int i = iArr[0];
        if (i == 1) {
            y = 0;
            StringBuilder sb2 = new StringBuilder();
            sb2.append("member/loginVerify");
            sb2.append(y.u(this.q));
            sb2.append("&uname=");
            sb2.append(w);
            sb2.append("&upsw=");
            sb2.append(n.b(x));
            sb2.append("&device_id=");
            sb2.append(y.o(this.q));
            sb2.append("&device_name=");
            sb2.append(y.p(this.q));
            sb2.append("&client_id=");
            sb2.append(y.n());
            sb2.append("&key=");
            sb2.append(t.c0(c0.e(y.v(this.q, "uname=" + w, "upsw=" + n.b(x), "device_id=" + y.o(this.q), "device_name=" + y.p(this.q)))));
            sb = sb2.toString();
        } else if (i == 2) {
            StringBuilder sb3 = new StringBuilder();
            sb3.append("members/userLoginGetScore");
            sb3.append(y.u(this.q));
            sb3.append("&uid=");
            sb3.append(y.K());
            sb3.append("&token=");
            sb3.append(y.H());
            sb3.append("&key=");
            sb3.append(t.c0(c0.e(y.v(this.q, "uid=" + y.K(), "token=" + y.H()))));
            sb = sb3.toString();
            com.rtk.app.tool.o.h.l(this.q, this, iArr[0], com.rtk.app.tool.o.h.h(new String[0]).a(sb));
        } else if (i == 3) {
            StringBuilder sb4 = new StringBuilder();
            sb4.append("member/thirdLogin");
            sb4.append(y.u(this.q));
            sb4.append("&device_id=");
            sb4.append(y.o(this.q));
            sb4.append("&device_name=");
            sb4.append(y.p(this.q));
            sb4.append("&");
            sb4.append(this.v.getQuickLoginType_Head());
            sb4.append("=");
            sb4.append(this.v.getQuickLoginType_content());
            sb4.append("&key=");
            sb4.append(t.c0(c0.e(y.v(this.q, "device_id=" + y.o(this.q), "device_name=" + y.p(this.q)))));
            sb = sb4.toString();
        } else if (i != 4) {
            sb = null;
        } else {
            StringBuilder sb5 = new StringBuilder();
            sb5.append("members/userBaseInfo");
            sb5.append(y.u(this.q));
            sb5.append("&uid=");
            sb5.append(y.K());
            sb5.append("&token=");
            sb5.append(y.H());
            sb5.append("&key=");
            sb5.append(t.c0(c0.e(y.v(this.q, "uid=" + y.K(), "token=" + y.H()))));
            sb = sb5.toString();
        }
        if (c0.q(sb)) {
            return;
        }
        c0.u("LoginActivity", "请求接口" + y.d + sb);
        com.rtk.app.tool.o.h.l(this.q, this, iArr[0], com.rtk.app.tool.o.h.h(new String[0]).a(sb));
    }

    @Override // com.rtk.app.tool.o.h.j
    public void d(String str, int i) {
        c0.u("LoginActivity", "登录页面" + str);
        Gson create = new GsonBuilder().enableComplexMapKeySerialization().create();
        if (i != 1) {
            if (i != 3) {
                if (i != 4) {
                    return;
                }
                Home5ImfromationBean home5ImfromationBean = (Home5ImfromationBean) create.fromJson(str, Home5ImfromationBean.class);
                v.h(MyApplication.b(), v.f, str);
                this.u.dismiss();
                LoginBean loginBean = MainActivity.p;
                if (loginBean != null && loginBean.getData() != null) {
                    MainActivity.p.getData().setHome5BeanToLoginBean(home5ImfromationBean);
                }
                com.rtk.app.tool.c.a(this.f147c);
                return;
            }
            this.u.dismiss();
        }
        LoginBean loginBean2 = (LoginBean) create.fromJson(str, LoginBean.class);
        MainActivity.p = loginBean2;
        if (loginBean2.getCode() == 0) {
            t.N1(this.f147c, str);
            z = false;
            L(2);
            L(4);
            return;
        }
        com.rtk.app.tool.f.a(this.q, str, f.a.f);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.rtk.app.base.BaseActivity
    public void finish() {
        super.finish();
        if (z) {
            z = false;
            this.s.putExtra("isLoginSuccer", true);
            this.s.putExtra("isLoginOpen", true);
            this.f147c.setResult(100023, this.s);
            return;
        }
        this.s.putExtra("isLoginOpen", true);
        setResult(100023, this.s);
    }

    @Override // com.rtk.app.tool.o.h.j
    public void g(int i, String str, int i2) {
        c0.u("LoginActivity", "登录失败" + str);
        if (i2 != 3) {
            if (i2 != 4) {
                com.rtk.app.tool.f.a(this.q, str, f.a.f);
                this.u.dismiss();
                new a0(this.q, str);
                return;
            }
        } else if (i == 7713) {
            com.rtk.app.tool.f.a(this.q, "该账户未绑定手机号，请绑定手机号", f.a.f);
            t.k0(this.f147c, this.v);
            this.u.dismiss();
            return;
        }
        this.u.dismiss();
        finish();
    }

    @Override // com.rtk.app.base.f
    public void initData() {
        this.r = v.a(this.q, "LoginRemember");
        w = v.d(this.q, "userPhone");
        x = v.d(this.q, "userPsw");
        this.v = new BoundQQorWechatBean();
    }

    @Override // com.rtk.app.base.f
    public void initListener() {
        this.loginUsername.addTextChangedListener(new a(this));
    }

    @Override // com.rtk.app.base.f
    public void initView() {
        this.loginRemember.setSelected(this.r);
        this.loginUsername.setText(w);
        this.loginPwd.setText(x);
        this.u = new DialogForLoginProgressTip(this.q, "登录中请稍后...");
    }

    public void onCancel(Platform platform, int i) {
        this.u.dismiss();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Bundle bundle = new Bundle();
        w = this.loginUsername.getText().toString().trim();
        switch (view.getId()) {
            case R.id.login_closed /* 2131298987 */:
                com.rtk.app.tool.c.a((Activity) this.q);
                return;
            case R.id.login_for_qq /* 2131298988 */:
                if (!this.loginProtocol.isChecked()) {
                    com.rtk.app.tool.f.a(this.q, getString(R.string.user_user_protocol_string), f.a.f);
                    return;
                }
                this.u.show();
                Platform platform = ShareSDK.getPlatform(QQ.NAME);
                this.t = platform;
                platform.removeAccount(true);
                this.t.SSOSetting(false);
                this.t.setPlatformActionListener(this);
                this.t.showUser((String) null);
                return;
            case R.id.login_for_weChat /* 2131298989 */:
                if (!this.loginProtocol.isChecked()) {
                    com.rtk.app.tool.f.a(this.q, getString(R.string.user_user_protocol_string), f.a.f);
                    return;
                }
                this.u.show();
                Platform platform2 = ShareSDK.getPlatform(Wechat.NAME);
                this.t = platform2;
                platform2.removeAccount(true);
                this.t.SSOSetting(false);
                this.t.setPlatformActionListener(this);
                this.t.showUser((String) null);
                return;
            case R.id.login_forget /* 2131298990 */:
                bundle.putString("phone", w);
                com.rtk.app.tool.c.b((Activity) this.q, ForgetPswActivity.class, bundle);
                return;
            case R.id.login_loginBtu /* 2131298991 */:
                w = this.loginUsername.getText().toString().trim();
                String trim = this.loginPwd.getText().toString().trim();
                x = trim;
                if (c0.q(w, trim)) {
                    com.rtk.app.tool.f.a(this.q, "用户名或密码未填写", f.a.f);
                    return;
                } else if (this.loginProtocol.isChecked()) {
                    O();
                    return;
                } else {
                    com.rtk.app.tool.f.a(this.q, getString(R.string.user_user_protocol_string), f.a.f);
                    new DialogLoginUserAgreement(this.q, new s() { // from class: com.rtk.app.main.login.i
                        @Override // com.rtk.app.tool.s
                        public final void a(String[] strArr) {
                            LoginActivity.this.N(strArr);
                        }
                    }).show();
                    return;
                }
            case R.id.login_privacy_policy_tv /* 2131298992 */:
                com.rtk.app.tool.c.b((Activity) this.q, PrivacyOfUsageActivity.class, null);
                return;
            case R.id.login_protocol /* 2131298993 */:
            case R.id.login_pwd /* 2131298994 */:
            case R.id.login_username /* 2131298999 */:
            default:
                return;
            case R.id.login_pwd_eye /* 2131298995 */:
                this.loginPwd.setInputType(!this.loginPwdEye.isSelected() ? TbsListener.ErrorCode.NEEDDOWNLOAD_5 : 129);
                this.loginPwdEye.setSelected(!r8.isSelected());
                try {
                    EditText editText = this.loginPwd;
                    editText.setSelection(editText.getText().length());
                    return;
                } catch (Exception unused) {
                    return;
                }
            case R.id.login_register /* 2131298996 */:
                bundle.putString("phone", w);
                t.O0(this.f147c, w, this.v);
                return;
            case R.id.login_remember /* 2131298997 */:
                boolean z2 = !this.r;
                this.r = z2;
                this.loginRemember.setSelected(z2);
                v.e(this.q, "LoginRemember", Boolean.valueOf(this.r));
                return;
            case R.id.login_user_protocol_tv /* 2131298998 */:
                com.rtk.app.tool.c.b((Activity) this.q, RegisterProtocolActivity.class, null);
                return;
            case R.id.login_username_clear /* 2131299000 */:
                this.loginUsername.setText("");
                return;
        }
    }

    public void onComplete(Platform platform, int i, HashMap<String, Object> hashMap) {
        c0.u("LoginActivity", " 头像地址  " + platform.getDb().getUserIcon());
        if (platform.getName().equals("QQ")) {
            this.v.setQuickLoginType_Head("openid");
            this.v.setQuickLoginType_content(platform.getDb().getUserId());
            this.v.setQuickLoginName_Head("q_nickname");
            this.v.setQuickLoginName_content(u.c(platform.getDb().getUserName().trim().getBytes()));
            this.v.setQuickLoginIcon_Head("q_face");
            this.v.setQuickLoginIcon_content(u.c(platform.getDb().getUserIcon().trim().getBytes()));
        } else if (platform.getName().equals("Wechat")) {
            this.v.setQuickLoginType_Head("unionid");
            this.v.setQuickLoginType_content(platform.getDb().getUserId());
            this.v.setQuickLoginName_Head("w_nickname");
            this.v.setQuickLoginName_content(u.c(platform.getDb().getUserName().trim().getBytes()));
            this.v.setQuickLoginIcon_Head("w_face");
            this.v.setQuickLoginIcon_content(u.c(platform.getDb().getUserIcon().trim().getBytes()));
        }
        L(3);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.rtk.app.base.BaseActivity, com.rtk.app.custom.SwipeBackActivity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (Build.VERSION.SDK_INT >= 21) {
            Window window = getWindow();
            window.clearFlags(67108864);
            window.getDecorView().setSystemUiVisibility(LogType.UNEXP_ANR);
            window.addFlags(Integer.MIN_VALUE);
            window.setStatusBarColor(0);
        }
        setContentView(R.layout.activity_login);
        ButterKnife.a(this);
        this.q = this;
        this.s = new Intent();
        MyApplication.f(this.f147c);
    }

    public void onError(Platform platform, int i, Throwable th) {
        this.u.dismiss();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.rtk.app.base.BaseActivity
    public void onResume() {
        super.onResume();
        MobclickAgent.onResume(this.q);
        MyApplication.f(this.q);
        if (z) {
            finish();
        }
        if (y != 0) {
            try {
                w = this.loginUsername.getText().toString().trim();
                x = this.loginPwd.getText().toString().trim();
                L(1);
            } catch (Exception unused) {
            }
        }
    }
}
