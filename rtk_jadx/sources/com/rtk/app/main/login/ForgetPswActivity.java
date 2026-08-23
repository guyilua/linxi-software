package com.rtk.app.main.login;

import android.R;
import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.rtk.app.base.BaseActivity;
import com.rtk.app.bean.BoundQQorWechatBean;
import com.rtk.app.bean.LoginBean;
import com.rtk.app.bean.MsgCodeBean;
import com.rtk.app.bean.ResponseDataBean;
import com.rtk.app.main.MainActivityPack.MainActivity;
import com.rtk.app.main.dialogPack.DialogForProgressTip;
import com.rtk.app.tool.a0;
import com.rtk.app.tool.c0;
import com.rtk.app.tool.n;
import com.rtk.app.tool.o.h;
import com.rtk.app.tool.t;
import com.rtk.app.tool.y;
import com.sigmob.sdk.downloader.f;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class ForgetPswActivity extends BaseActivity implements h.j, a0.a {
    private static a0 w;

    @BindView
    Button forgetPswGettokenBtu;

    @BindView
    EditText forgetPswInputPsw;

    @BindView
    EditText forgetPswInputPswAgain;

    @BindView
    EditText forgetPswPhone;

    @BindView
    TextView forgetPswSubmit;

    @BindView
    EditText forgetPswToken;

    @BindView
    RelativeLayout forgetPswTopLayout;
    private DialogForProgressTip q;
    private Context r;
    private String s = "";
    private String t = "";
    private String u = "";
    private String v = "";

    @Override // com.rtk.app.base.BaseActivity
    protected void A() {
        t.S1(this.r, this.forgetPswTopLayout, null, null, ((ViewGroup) findViewById(R.id.content)).getChildAt(0));
    }

    public void L(int... iArr) {
        String sb;
        int i = iArr[0];
        if (i == 1) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("member/msgCode");
            sb2.append(y.u(this.r));
            sb2.append("&mobile=");
            sb2.append(this.s);
            sb2.append("&type=1&code=0&key=");
            sb2.append(t.c0(c0.e(y.v(this.r, "mobile=" + this.s, "type=1", "code=0"))));
            sb = sb2.toString();
        } else if (i == 2) {
            StringBuilder sb3 = new StringBuilder();
            sb3.append("member/forgotPsw");
            sb3.append(y.u(this.r));
            sb3.append("&mobile=");
            sb3.append(this.s);
            sb3.append("&psw=");
            sb3.append(this.t);
            sb3.append("&cf_psw=");
            sb3.append(this.u);
            sb3.append("&msgcode=");
            sb3.append(this.v);
            sb3.append("&key=");
            sb3.append(t.c0(c0.e(y.v(this.r, "mobile=" + this.s, "psw=" + this.t, "cf_psw=" + this.u, "msgcode=" + this.v))));
            sb = sb3.toString();
        } else if (i != 3) {
            sb = "";
        } else {
            StringBuilder sb4 = new StringBuilder();
            sb4.append("member/loginVerify");
            sb4.append(y.u(this.r));
            sb4.append("&uname=");
            sb4.append(this.s);
            sb4.append("&upsw=");
            sb4.append(n.b(this.t));
            sb4.append("&device_id=");
            sb4.append(y.o(this.r));
            sb4.append("&device_name=");
            sb4.append(y.p(this.r));
            sb4.append("&client_id=");
            sb4.append(y.n());
            sb4.append("&key=");
            sb4.append(t.c0(c0.e(y.v(this.r, "uname=" + this.s, "upsw=" + n.b(this.t), "device_id=" + y.o(this.r), "device_name=" + y.p(this.r)))));
            sb = sb4.toString();
        }
        if (c0.q(sb)) {
            return;
        }
        com.rtk.app.tool.o.h.l(this.r, this, iArr[0], com.rtk.app.tool.o.h.h(new String[0]).a(sb));
    }

    @Override // com.rtk.app.tool.o.h.j
    public void d(String str, int i) {
        c0.u("ForgetPswActivity", "忘记密码页面" + str);
        Gson create = new GsonBuilder().enableComplexMapKeySerialization().create();
        if (i == 1) {
            if (((MsgCodeBean) create.fromJson(str, MsgCodeBean.class)).getCode() == 0) {
                com.rtk.app.tool.f.a(this.r, "发送成功，请注意查收!", f.a.f);
                return;
            }
            return;
        }
        if (i == 2) {
            ResponseDataBean responseDataBean = (ResponseDataBean) create.fromJson(str, ResponseDataBean.class);
            if (responseDataBean.getCode() == 0) {
                com.rtk.app.tool.f.a(this.r, responseDataBean.getMsg(), f.a.f);
                L(3);
                return;
            }
            return;
        }
        if (i != 3) {
            return;
        }
        this.q.dismiss();
        LoginBean loginBean = (LoginBean) create.fromJson(str, LoginBean.class);
        MainActivity.p = loginBean;
        if (loginBean.getCode() == 0) {
            t.N1(this.f147c, str);
            com.rtk.app.tool.c.a((Activity) this.r);
        } else {
            com.rtk.app.tool.f.a(this.r, str, f.a.f);
        }
    }

    @Override // com.rtk.app.tool.o.h.j
    public void g(int i, String str, int i2) {
        com.rtk.app.tool.f.a(this.r, str, 200);
        if (i2 == 1 && i == 7713) {
            t.O0(this.f147c, this.s, new BoundQQorWechatBean());
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.rtk.app.base.f
    public void initData() {
        String string = getIntent().getExtras().getString("phone");
        this.s = string;
        this.forgetPswPhone.setText(string);
    }

    @Override // com.rtk.app.base.f
    public void initListener() {
    }

    @Override // com.rtk.app.base.f
    public void initView() {
        this.q = new DialogForProgressTip(this.f147c, "注册中，请稍后...");
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int id = view.getId();
        if (id == 2131297606) {
            String trim = this.forgetPswPhone.getText().toString().trim();
            this.s = trim;
            if (!c0.q(trim)) {
                L(1);
                w.start();
                return;
            } else {
                com.rtk.app.tool.f.a(this.r, "号码不可为空!", 200);
                return;
            }
        }
        if (id != 2131297610) {
            if (id != 2131297612) {
                return;
            }
            com.rtk.app.tool.c.a((Activity) this.r);
            return;
        }
        this.s = this.forgetPswPhone.getText().toString().trim();
        this.t = this.forgetPswInputPsw.getText().toString().trim();
        this.u = this.forgetPswInputPswAgain.getText().toString().trim();
        this.v = this.forgetPswToken.getText().toString().trim();
        if (!this.t.equals(this.u)) {
            com.rtk.app.tool.f.a(this.r, "两次输入密码不相同！", 200);
        } else if (!c0.q(this.s, this.t, this.u, this.v)) {
            L(2);
        } else {
            com.rtk.app.tool.f.a(this.r, "请填写完整信息", 200);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.rtk.app.base.BaseActivity, com.rtk.app.custom.SwipeBackActivity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(com.rtk.app.R.layout.activity_forget_psw);
        ButterKnife.a(this);
        this.r = this;
        w = new a0(60000L, 1000L, this);
    }

    @Override // com.rtk.app.tool.a0.a
    public void onFinish() {
        this.forgetPswGettokenBtu.setText("获取验证码");
        this.forgetPswGettokenBtu.setEnabled(true);
    }

    @Override // com.rtk.app.tool.a0.a
    public void onTick(long j) {
        this.forgetPswGettokenBtu.setText((j / 1000) + "秒");
        this.forgetPswGettokenBtu.setEnabled(false);
    }
}
