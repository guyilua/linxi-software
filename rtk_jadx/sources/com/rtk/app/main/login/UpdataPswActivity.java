package com.rtk.app.main.login;

import android.R;
import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.rtk.app.base.BaseActivity;
import com.rtk.app.bean.ResponseDataBean;
import com.rtk.app.tool.c0;
import com.rtk.app.tool.o.h;
import com.rtk.app.tool.t;
import com.rtk.app.tool.y;
import com.sigmob.sdk.downloader.f;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class UpdataPswActivity extends BaseActivity implements h.j {
    private Context q;
    private String r = "";
    private String s = "";
    private String t = "";
    private int u;

    @BindView
    EditText updataPswLastPsw;

    @BindView
    EditText updataPswNewPsw;

    @BindView
    EditText updataPswPswAgain;

    @BindView
    Button updataPswSubmit;

    @BindView
    TextView updataPswTopBack;

    @BindView
    LinearLayout updataPswTopLayout;

    @Override // com.rtk.app.base.BaseActivity
    protected void A() {
        t.S1(this.q, this.updataPswTopLayout, null, null, ((ViewGroup) findViewById(R.id.content)).getChildAt(0));
    }

    public void L(int... iArr) {
        this.u = y.I(this.q);
        Context context = this.q;
        com.rtk.app.tool.o.i h = com.rtk.app.tool.o.h.h(new String[0]);
        StringBuilder sb = new StringBuilder();
        sb.append("member/updatePsw");
        sb.append(y.u(this.q));
        sb.append("&uid=");
        sb.append(this.u);
        sb.append("&psw=");
        sb.append(this.s);
        sb.append("&cf_psw=");
        sb.append(this.t);
        sb.append("&old_psw=");
        sb.append(this.r);
        sb.append("&token=");
        sb.append(y.G(this.q));
        sb.append("&key=");
        sb.append(t.c0(c0.e(y.v(this.q, "psw=" + this.s, "cf_psw=" + this.t, "old_psw=" + this.r, "uid=" + this.u))));
        com.rtk.app.tool.o.h.l(context, this, 1, h.a(sb.toString()));
    }

    @Override // com.rtk.app.tool.o.h.j
    public void d(String str, int i) {
        c0.u("UpdataPswActivity", "修改密码" + str);
        this.updataPswSubmit.setEnabled(true);
        Gson create = new GsonBuilder().enableComplexMapKeySerialization().create();
        if (i != 1) {
            return;
        }
        ResponseDataBean responseDataBean = (ResponseDataBean) create.fromJson(str, ResponseDataBean.class);
        if (responseDataBean.getCode() == 0) {
            com.rtk.app.tool.f.a(this.q, "修改成功！", f.a.f);
            com.rtk.app.tool.c.a((Activity) this.q);
        } else {
            com.rtk.app.tool.f.a(this.q, responseDataBean.getMsg(), f.a.f);
            this.updataPswSubmit.setEnabled(true);
        }
    }

    @Override // com.rtk.app.tool.o.h.j
    public void g(int i, String str, int i2) {
        com.rtk.app.tool.f.a(this.q, str, f.a.f);
        this.updataPswSubmit.setEnabled(true);
    }

    @Override // com.rtk.app.base.f
    public void initData() {
    }

    @Override // com.rtk.app.base.f
    public void initListener() {
    }

    @Override // com.rtk.app.base.f
    public void initView() {
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        switch (view.getId()) {
            case com.rtk.app.R.id.updataPsw_submit /* 2131301105 */:
                this.updataPswSubmit.setEnabled(false);
                this.r = this.updataPswLastPsw.getText().toString().trim();
                this.s = this.updataPswNewPsw.getText().toString().trim();
                String trim = this.updataPswPswAgain.getText().toString().trim();
                this.t = trim;
                if (!this.s.equals(trim)) {
                    com.rtk.app.tool.f.a(this.q, "两次密码不相同", f.a.f);
                    this.updataPswSubmit.setEnabled(true);
                    return;
                } else if (!c0.q(this.r, this.s, this.t)) {
                    L(new int[0]);
                    return;
                } else {
                    com.rtk.app.tool.f.a(this.q, "请填写完整信息", f.a.f);
                    return;
                }
            case com.rtk.app.R.id.updataPsw_top_back /* 2131301106 */:
                com.rtk.app.tool.c.a((Activity) this.q);
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
        setContentView(com.rtk.app.R.layout.activity_updata_psw);
        ButterKnife.a(this);
        this.q = this;
    }
}
