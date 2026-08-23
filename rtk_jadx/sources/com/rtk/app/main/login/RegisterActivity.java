package com.rtk.app.main.login;

import android.R;
import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.rtk.app.base.BaseActivity;
import com.rtk.app.bean.BoundQQorWechatBean;
import com.rtk.app.bean.LoginBean;
import com.rtk.app.bean.RegisterAgreementBean;
import com.rtk.app.bean.RegisterBean;
import com.rtk.app.bean.ResponseDataBean;
import com.rtk.app.main.Home5Activity.PrivacyOfUsageActivity;
import com.rtk.app.main.Home5Activity.RegisterProtocolActivity;
import com.rtk.app.main.MainActivityPack.MainActivity;
import com.rtk.app.main.dialogPack.DialogForProgressTip;
import com.rtk.app.main.dialogPack.DialogRegisterOfUsage;
import com.rtk.app.tool.a0;
import com.rtk.app.tool.c0;
import com.rtk.app.tool.n;
import com.rtk.app.tool.o.h;
import com.rtk.app.tool.t;
import com.rtk.app.tool.y;
import com.sigmob.sdk.downloader.f;
import com.umeng.analytics.pro.ak;
import java.util.HashMap;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class RegisterActivity extends BaseActivity implements h.j, a0.a {
    private static a0 y;
    private Context q;

    @BindView
    Button registerGettokenBtu;

    @BindView
    EditText registerInputPsw;

    @BindView
    EditText registerInputPswAgain;

    @BindView
    EditText registerPhone;

    @BindView
    CheckBox registerProtocol;

    @BindView
    TextView registerSubmit;

    @BindView
    EditText registerToken;

    @BindView
    TextView registerTopBack;

    @BindView
    RelativeLayout registerTopLayout;

    @BindView
    TextView registerUserProtocolTv;

    @BindView
    TextView register_privacy_policy_tv;
    private RegisterBean v;
    private DialogForProgressTip w;
    private BoundQQorWechatBean x;
    private String r = "";
    private String s = "";
    private String t = "";
    private String u = "";

    @Override // com.rtk.app.base.BaseActivity
    protected void A() {
        t.S1(this.q, this.registerTopLayout, null, null, ((ViewGroup) findViewById(R.id.content)).getChildAt(0));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void L(int... iArr) {
        String sb;
        int i = iArr[0];
        if (i != 1) {
            if (i == 2) {
                this.w.show();
                HashMap hashMap = new HashMap();
                hashMap.put("channel", y.m(this.f147c, getPackageName()));
                hashMap.put("version", y.i(this.f147c));
                hashMap.put(ak.aj, y.g());
                hashMap.put("phone_model", y.T());
                hashMap.put("version_channel", y.i(this.q) + "_" + y.m(this.q, getPackageName()));
                hashMap.put("mobile", this.r);
                hashMap.put("msgcode", this.u);
                hashMap.put("upsw", this.s);
                hashMap.put(this.x.getQuickLoginType_Head(), this.x.getQuickLoginType_content());
                hashMap.put(this.x.getQuickLoginName_Head(), this.x.getQuickLoginName_content());
                hashMap.put(this.x.getQuickLoginIcon_Head(), this.x.getQuickLoginIcon_content());
                hashMap.put("key", t.c0(c0.e(y.v(this.q, "mobile=" + this.r, "upsw=" + this.s, "msgcode=" + this.u))));
                AppCompatActivity appCompatActivity = this.f147c;
                StringBuilder sb2 = new StringBuilder();
                sb2.append(y.d);
                sb2.append("member/register");
                com.rtk.app.tool.o.h.j(appCompatActivity, this, sb2.toString(), iArr[0], hashMap);
                StringBuilder sb3 = new StringBuilder();
                sb3.append("  注册页面  ");
                sb3.append(hashMap.toString());
                c0.u("RegisterActivity", sb3.toString());
            } else if (i == 3) {
                sb = "member/registerAgreement" + y.u(this.q) + "&key=" + t.c0(c0.e(y.v(this.q, new String[0])));
            } else if (i == 4) {
                StringBuilder sb4 = new StringBuilder();
                sb4.append("member/loginVerify");
                sb4.append(y.u(this.q));
                sb4.append("&uname=");
                sb4.append(this.r);
                sb4.append("&upsw=");
                sb4.append(n.b(this.s));
                sb4.append("&device_id=");
                sb4.append(y.o(this.q));
                sb4.append("&device_name=");
                sb4.append(y.p(this.q));
                sb4.append("&client_id=");
                sb4.append(y.n());
                sb4.append("&key=");
                sb4.append(t.c0(c0.e(y.v(this.q, "uname=" + this.r, "upsw=" + n.b(this.s), "device_id=" + y.o(this.q), "device_name=" + y.p(this.q)))));
                sb = sb4.toString();
            }
            sb = "";
        } else {
            StringBuilder sb5 = new StringBuilder();
            sb5.append("member/msgCode");
            sb5.append(y.u(this.q));
            sb5.append("&mobile=");
            sb5.append(this.r);
            sb5.append("&type=0&code=0&key=");
            sb5.append(t.c0(c0.e(y.v(this.q, "mobile=" + this.r, "type=0", "code=0"))));
            sb = sb5.toString();
        }
        if (c0.q(sb)) {
            return;
        }
        c0.u("RegisterActivity", "注册页面 请求接口  " + y.d + sb);
        com.rtk.app.tool.o.h.l(this.q, this, iArr[0], com.rtk.app.tool.o.h.h(new String[0]).a(sb));
    }

    @Override // com.rtk.app.tool.o.h.j
    public void d(String str, int i) {
        c0.u("RegisterActivity", "注册页面-->" + str);
        Gson create = new GsonBuilder().enableComplexMapKeySerialization().create();
        if (i == 1) {
            if (((ResponseDataBean) create.fromJson(str, ResponseDataBean.class)).getCode() == 0) {
                com.rtk.app.tool.f.a(this.q, "发送成功，请注意查收!", f.a.f);
                return;
            } else {
                com.rtk.app.tool.f.a(this.q, str, f.a.f);
                return;
            }
        }
        if (i == 2) {
            RegisterBean registerBean = (RegisterBean) create.fromJson(str, RegisterBean.class);
            this.v = registerBean;
            if (registerBean.getCode() == 0) {
                com.rtk.app.tool.f.a(this.q, "注册成功", f.a.f);
                L(4);
                return;
            } else {
                com.rtk.app.tool.f.a(this.q, str, f.a.f);
                return;
            }
        }
        if (i == 3) {
            c0.u("RegisterActivity", "用户协议" + str);
            new DialogRegisterOfUsage(this.q, (RegisterAgreementBean) create.fromJson(str, RegisterAgreementBean.class)).show();
            return;
        }
        if (i != 4) {
            return;
        }
        this.w.dismiss();
        LoginBean loginBean = (LoginBean) create.fromJson(str, LoginBean.class);
        MainActivity.p = loginBean;
        if (loginBean.getCode() == 0) {
            t.N1(this.f147c, str);
            com.rtk.app.tool.c.a((Activity) this.q);
        } else {
            com.rtk.app.tool.f.a(this.q, str, f.a.f);
        }
    }

    @Override // com.rtk.app.tool.o.h.j
    public void g(int i, String str, int i2) {
        com.rtk.app.tool.f.a(this.q, str, f.a.f);
        if (i2 == 2 || i2 == 4) {
            this.w.dismiss();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.rtk.app.base.f
    public void initData() {
        Bundle extras = getIntent().getExtras();
        this.r = extras.getString("phone");
        this.x = (BoundQQorWechatBean) extras.getSerializable("boundQQorWechatBean");
        this.registerPhone.setText(c0.q(this.r) ? "" : this.r);
    }

    @Override // com.rtk.app.base.f
    public void initListener() {
    }

    @Override // com.rtk.app.base.f
    public void initView() {
        this.w = new DialogForProgressTip(this.f147c, "注册中，请稍后...");
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        switch (view.getId()) {
            case com.rtk.app.R.id.register_gettokenBtu /* 2131299988 */:
                String trim = this.registerPhone.getText().toString().trim();
                this.r = trim;
                if (!c0.q(trim)) {
                    L(1);
                    this.registerToken.requestFocus();
                    t.s(this.registerToken, this.f147c);
                    y.start();
                    return;
                }
                com.rtk.app.tool.f.a(this.q, "号码不可为空!", 200);
                return;
            case com.rtk.app.R.id.register_privacy_policy_tv /* 2131299992 */:
                com.rtk.app.tool.c.b((Activity) this.q, PrivacyOfUsageActivity.class, null);
                return;
            case com.rtk.app.R.id.register_submit /* 2131299996 */:
                this.r = this.registerPhone.getText().toString().trim();
                this.s = this.registerInputPsw.getText().toString().trim();
                this.t = this.registerInputPswAgain.getText().toString().trim();
                this.u = this.registerToken.getText().toString().trim();
                if (!this.s.equals(this.t)) {
                    com.rtk.app.tool.f.a(this.q, "两次输入密码不相同！", 200);
                    return;
                }
                if (!this.registerProtocol.isChecked()) {
                    com.rtk.app.tool.f.a(this.q, getString(com.rtk.app.R.string.user_user_protocol_string), 200);
                    return;
                } else if (c0.q(this.r, this.s, this.t, this.u)) {
                    com.rtk.app.tool.f.a(this.q, "请填写完整信息", 200);
                    return;
                } else {
                    L(2);
                    return;
                }
            case com.rtk.app.R.id.register_top_back /* 2131299998 */:
                com.rtk.app.tool.c.a((Activity) this.q);
                return;
            case com.rtk.app.R.id.register_user_protocol_tv /* 2131300000 */:
                com.rtk.app.tool.c.b((Activity) this.q, RegisterProtocolActivity.class, null);
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
        setContentView(com.rtk.app.R.layout.activity_register);
        ButterKnife.a(this);
        this.q = this;
        y = new a0(60000L, 1000L, this);
    }

    @Override // com.rtk.app.tool.a0.a
    public void onFinish() {
        this.registerGettokenBtu.setText("获取验证码");
        this.registerGettokenBtu.setEnabled(true);
    }

    @Override // com.rtk.app.tool.a0.a
    public void onTick(long j) {
        this.registerGettokenBtu.setText((j / 1000) + "秒");
        this.registerGettokenBtu.setEnabled(false);
    }
}
