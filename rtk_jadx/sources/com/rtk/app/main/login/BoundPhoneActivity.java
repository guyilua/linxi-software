package com.rtk.app.main.login;

import android.R;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.rtk.app.base.BaseActivity;
import com.rtk.app.bean.BoundQQorWechatBean;
import com.rtk.app.bean.LoginBean;
import com.rtk.app.bean.ResponseDataBean;
import com.rtk.app.main.MainActivityPack.MainActivity;
import com.rtk.app.main.dialogPack.DialogForEnSure;
import com.rtk.app.tool.a0;
import com.rtk.app.tool.c0;
import com.rtk.app.tool.o.h;
import com.rtk.app.tool.s;
import com.rtk.app.tool.t;
import com.rtk.app.tool.y;
import com.sigmob.sdk.downloader.f;
import com.umeng.analytics.pro.ak;
import java.util.HashMap;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class BoundPhoneActivity extends BaseActivity implements h.j, a0.a {

    @BindView
    Button boundPhoneGettokenBtu;

    @BindView
    EditText boundPhonePhone;

    @BindView
    TextView boundPhoneSubmit;

    @BindView
    EditText boundPhoneToken;

    @BindView
    TextView boundPhoneTopBack;

    @BindView
    LinearLayout boundPhoneTopLayout;
    private a0 q;
    private ResponseDataBean s;
    private BoundQQorWechatBean u;
    private String r = "";
    private String t = "";

    /* loaded from: /tmp/rtk_apk/classes3.dex */
    class a implements s {
        a() {
        }

        @Override // com.rtk.app.tool.s
        public void a(String... strArr) {
            BoundPhoneActivity.this.t = "1";
            BoundPhoneActivity.this.M(2);
            BoundPhoneActivity.this.t = "";
        }
    }

    @Override // com.rtk.app.base.BaseActivity
    protected void A() {
        t.S1(this.f147c, this.boundPhoneTopLayout, null, null, ((ViewGroup) findViewById(R.id.content)).getChildAt(0));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void M(int... iArr) {
        String sb;
        int i = iArr[0];
        if (i != 1) {
            if (i == 2) {
                HashMap hashMap = new HashMap();
                hashMap.put("channel", y.m(this.f147c, getPackageName()));
                hashMap.put("version", y.i(this.f147c));
                hashMap.put(ak.aj, y.g());
                hashMap.put("phone_model", y.T());
                hashMap.put("mobile", this.boundPhonePhone.getText().toString().trim());
                hashMap.put("code", this.boundPhoneToken.getText().toString().trim());
                hashMap.put("alread", this.t);
                hashMap.put(this.u.getQuickLoginType_Head(), this.u.getQuickLoginType_content());
                hashMap.put(this.u.getQuickLoginName_Head(), this.u.getQuickLoginName_content());
                hashMap.put(this.u.getQuickLoginIcon_Head(), this.u.getQuickLoginIcon_content());
                hashMap.put("key", t.c0(c0.e(y.v(this.f147c, "mobile=" + this.boundPhonePhone.getText().toString().trim(), "code=" + this.boundPhoneToken.getText().toString().trim()))));
                AppCompatActivity appCompatActivity = this.f147c;
                StringBuilder sb2 = new StringBuilder();
                sb2.append(y.d);
                sb2.append("member/thirdLoginBind");
                com.rtk.app.tool.o.h.j(appCompatActivity, this, sb2.toString(), iArr[0], hashMap);
                c0.u("BoundPhoneActivity", "快捷登录map请求  " + hashMap.toString());
            } else if (i == 3) {
                StringBuilder sb3 = new StringBuilder();
                sb3.append("members/userLoginGetScore");
                sb3.append(y.u(this.f147c));
                sb3.append("&uid=");
                sb3.append(y.K());
                sb3.append("&token=");
                sb3.append(y.H());
                sb3.append("&key=");
                sb3.append(t.c0(c0.e(y.v(this.f147c, "uid=" + y.K(), "token=" + y.H()))));
                sb = sb3.toString();
                com.rtk.app.tool.o.h.l(this.f147c, this, iArr[0], com.rtk.app.tool.o.h.h(new String[0]).a(sb));
            }
            sb = "";
        } else {
            StringBuilder sb4 = new StringBuilder();
            sb4.append("member/msgCode");
            sb4.append(y.u(this.f147c));
            sb4.append("&mobile=");
            sb4.append(this.r);
            sb4.append("&type=1&code=0&tag=1&key=");
            sb4.append(t.c0(c0.e(y.v(this.f147c, "mobile=" + this.r, "type=1", "code=0"))));
            sb = sb4.toString();
        }
        if (c0.q(sb)) {
            return;
        }
        c0.u("BoundPhoneActivity", "请求接口地址 " + y.d + sb);
        com.rtk.app.tool.o.h.l(this.f147c, this, iArr[0], com.rtk.app.tool.o.h.h(new String[0]).a(sb));
    }

    @Override // com.rtk.app.tool.o.h.j
    public void d(String str, int i) {
        if (i == 1) {
            ResponseDataBean responseDataBean = (ResponseDataBean) this.g.fromJson(str, ResponseDataBean.class);
            this.s = responseDataBean;
            if (responseDataBean.getCode() == 0) {
                com.rtk.app.tool.f.a(this.f147c, "发送成功，请注意查收!", f.a.f);
                return;
            } else {
                com.rtk.app.tool.f.a(this.f147c, str, f.a.f);
                return;
            }
        }
        if (i != 2) {
            return;
        }
        c0.u("BoundPhoneActivity", "绑定成功" + str);
        LoginBean loginBean = (LoginBean) this.g.fromJson(str, LoginBean.class);
        if (loginBean.getCode() == 0) {
            MainActivity.p = loginBean;
            t.N1(this.f147c, str);
            com.rtk.app.tool.c.a(this.f147c);
            M(3);
            return;
        }
        com.rtk.app.tool.f.a(this.f147c, str, f.a.f);
    }

    @Override // com.rtk.app.tool.o.h.j
    public void g(int i, String str, int i2) {
        if (i2 == 1) {
            if (i == 7726) {
                c0.u("BoundPhoneActivity", "账户未注册");
                com.rtk.app.tool.f.a(this.f147c, str, f.a.f);
                t.O0(this.f147c, this.r, this.u);
                finish();
                return;
            }
            return;
        }
        if (i2 != 2) {
            com.rtk.app.tool.f.a(this.f147c, str, f.a.f);
        } else if (i == 9108) {
            com.rtk.app.tool.f.a(this.f147c, str, f.a.f);
            new DialogForEnSure(this.f147c, str, new a()).show();
        } else {
            com.rtk.app.tool.f.a(this.f147c, str, f.a.f);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.rtk.app.base.f
    public void initData() {
        this.u = (BoundQQorWechatBean) getIntent().getExtras().getSerializable("boundQQorWechatBean");
    }

    @Override // com.rtk.app.base.f
    public void initListener() {
    }

    @Override // com.rtk.app.base.f
    public void initView() {
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int id = view.getId();
        if (id != 2131296813) {
            if (id == 2131296815) {
                M(2);
                return;
            } else {
                if (id != 2131296817) {
                    return;
                }
                finish();
                return;
            }
        }
        String trim = this.boundPhonePhone.getText().toString().trim();
        this.r = trim;
        if (!c0.q(trim)) {
            M(1);
            this.boundPhoneToken.requestFocus();
            this.q.start();
            return;
        }
        com.rtk.app.tool.f.a(this.f147c, "号码不可为空!", 200);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.rtk.app.base.BaseActivity, com.rtk.app.custom.SwipeBackActivity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(com.rtk.app.R.layout.activity_bound_phone);
        ButterKnife.a(this);
        this.q = new a0(60000L, 1000L, this);
    }

    @Override // com.rtk.app.tool.a0.a
    public void onFinish() {
        this.boundPhoneGettokenBtu.setText("获取验证码");
        this.boundPhoneGettokenBtu.setEnabled(true);
    }

    @Override // com.rtk.app.tool.a0.a
    public void onTick(long j) {
        this.boundPhoneGettokenBtu.setText((j / 1000) + "秒");
        this.boundPhoneGettokenBtu.setEnabled(false);
    }
}
