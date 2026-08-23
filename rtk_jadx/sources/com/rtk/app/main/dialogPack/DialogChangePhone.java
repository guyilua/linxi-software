package com.rtk.app.main.dialogPack;

import android.content.Context;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.google.gson.GsonBuilder;
import com.rtk.app.R;
import com.rtk.app.bean.ResponseDataBean;
import com.rtk.app.main.MainActivityPack.MainActivity;
import com.rtk.app.tool.a0;
import com.rtk.app.tool.o.h;
import com.sigmob.sdk.downloader.f;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class DialogChangePhone extends o implements View.OnClickListener, h.j, a0.a {
    private static com.rtk.app.tool.a0 p;

    @BindView
    EditText dialogChangePhonePhone;

    @BindView
    TextView dialogChangePhoneSubmit;

    @BindView
    EditText dialogChangePhoneToken;
    private Context k;
    private String l;
    private String m;
    private com.rtk.app.tool.s n;
    private String o;

    @BindView
    Button registerGettokenBtu;

    public DialogChangePhone(Context context, String str, com.rtk.app.tool.s sVar) {
        super(context);
        this.k = context;
        this.o = str;
        this.n = sVar;
        p = new com.rtk.app.tool.a0(60000L, 1000L, this);
        i(R.layout.dialog_change_phone, 17);
        ButterKnife.b(this, getWindow().getDecorView());
        q();
    }

    @Override // com.rtk.app.tool.o.h.j
    public void d(String str, int i) {
        com.rtk.app.tool.c0.u("DialogChangePhone", i + "  修改手机号   " + str);
        ResponseDataBean responseDataBean = (ResponseDataBean) new GsonBuilder().enableComplexMapKeySerialization().create().fromJson(str, ResponseDataBean.class);
        if (i == 1) {
            com.rtk.app.tool.f.a(this.k, responseDataBean.getMsg(), f.a.f);
        } else {
            if (i != 2) {
                return;
            }
            com.rtk.app.tool.f.a(this.k, responseDataBean.getMsg(), f.a.f);
            dismiss();
            this.n.a(this.l);
        }
    }

    @Override // com.rtk.app.tool.o.h.j
    public void g(int i, String str, int i2) {
        com.rtk.app.tool.c0.u("DialogChangePhone", i2 + "  修改手机号   " + str);
        if (i2 == 1) {
            com.rtk.app.tool.f.a(this.k, str, f.a.f);
            p.cancel();
            p.onFinish();
        } else {
            if (i2 != 2) {
                return;
            }
            this.dialogChangePhonePhone.setEnabled(true);
            com.rtk.app.tool.f.a(this.k, str, f.a.f);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.m = this.dialogChangePhoneToken.getText().toString().trim();
        this.l = this.dialogChangePhonePhone.getText().toString().trim();
        int id = view.getId();
        if (id == 2131297123) {
            if (!com.rtk.app.tool.c0.q(this.l, this.m)) {
                this.dialogChangePhonePhone.setEnabled(false);
                p(2);
                return;
            } else {
                com.rtk.app.tool.f.a(this.k, "请输入新手机和验证码", f.a.f);
                return;
            }
        }
        if (id != 2131299988) {
            return;
        }
        if (!com.rtk.app.tool.c0.q(this.l)) {
            p(1);
            p.start();
        } else {
            com.rtk.app.tool.f.a(this.k, "请输入手机号！", f.a.f);
        }
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

    public void p(int i) {
        String sb;
        if (i == 1) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("member/msgCode");
            sb2.append(com.rtk.app.tool.y.u(this.k));
            sb2.append("&mobile=");
            sb2.append(this.l);
            sb2.append("&type=0&code=0&key=");
            sb2.append(com.rtk.app.tool.t.c0(com.rtk.app.tool.c0.e(com.rtk.app.tool.y.v(this.k, "mobile=" + this.l, "type=0", "code=0"))));
            sb = sb2.toString();
        } else if (i != 2) {
            sb = "";
        } else {
            StringBuilder sb3 = new StringBuilder();
            sb3.append("member/modifyMobile");
            sb3.append(com.rtk.app.tool.y.u(this.k));
            sb3.append("&uid=");
            sb3.append(MainActivity.p.getData().getUid());
            sb3.append("&token=");
            sb3.append(com.rtk.app.tool.y.H());
            sb3.append("&mobile=");
            sb3.append(this.l);
            sb3.append("&code=");
            sb3.append(this.m);
            sb3.append("&pwd=");
            sb3.append(this.o);
            sb3.append("&key=");
            sb3.append(com.rtk.app.tool.t.c0(com.rtk.app.tool.c0.e(com.rtk.app.tool.y.v(this.k, "uid=" + MainActivity.p.getData().getUid(), "token=" + com.rtk.app.tool.y.H(), "mobile=" + this.l, "code=" + this.m, "pwd=" + this.o))));
            sb = sb3.toString();
        }
        if (com.rtk.app.tool.c0.q(sb)) {
            return;
        }
        com.rtk.app.tool.o.h.l(this.k, this, i, com.rtk.app.tool.o.h.h(new String[0]).a(sb));
    }

    public void q() {
        this.registerGettokenBtu.setOnClickListener(this);
        this.dialogChangePhoneSubmit.setOnClickListener(this);
    }
}
