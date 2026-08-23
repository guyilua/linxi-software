package com.rtk.app.main.dialogPack;

import android.content.Context;
import android.view.View;
import android.widget.TextView;
import com.rtk.app.R;
import com.rtk.app.tool.o.h;
import com.sigmob.sdk.downloader.f;
import com.umeng.analytics.pro.ak;
import java.util.HashMap;

/* compiled from: DialogUpdateSex.java */
/* loaded from: /tmp/rtk_apk/classes3.dex */
public class d0 extends o implements h.j {
    private TextView k;
    private TextView l;
    private TextView m;
    private com.rtk.app.tool.s n;
    private Context o;
    private int p;

    public d0(Context context, com.rtk.app.tool.s sVar) {
        super(context);
        this.p = 1;
        this.o = context;
        this.n = sVar;
        i(R.layout.dialog_update_sex_layout, 80);
        p();
        r();
    }

    private void q() {
        HashMap hashMap = new HashMap();
        Context context = this.o;
        hashMap.put("channel", com.rtk.app.tool.y.m(context, context.getPackageName()));
        hashMap.put("version", com.rtk.app.tool.y.i(this.o));
        hashMap.put(ak.aj, com.rtk.app.tool.y.g());
        hashMap.put("phone_model", com.rtk.app.tool.y.T());
        hashMap.put("gender", this.p + "");
        hashMap.put("uid", com.rtk.app.tool.y.K() + "");
        hashMap.put("token", com.rtk.app.tool.y.H());
        hashMap.put("key", com.rtk.app.tool.t.c0(com.rtk.app.tool.c0.e(com.rtk.app.tool.y.v(this.o, "uid=" + com.rtk.app.tool.y.K(), "token=" + com.rtk.app.tool.y.H(), "gender=" + this.p + ""))));
        Context context2 = this.o;
        StringBuilder sb = new StringBuilder();
        sb.append(com.rtk.app.tool.y.e);
        sb.append("user/info/gender");
        com.rtk.app.tool.o.h.j(context2, this, sb.toString(), 1, hashMap);
    }

    @Override // com.rtk.app.tool.o.h.j
    public void d(String str, int i) {
        com.rtk.app.tool.c0.u("DialogUpdateSex", "修改性别成功:" + str);
        com.rtk.app.tool.f.a(this.o, "修改性别成功", f.a.f);
        this.n.a(this.p + "");
    }

    @Override // com.rtk.app.tool.o.h.j
    public void g(int i, String str, int i2) {
        com.rtk.app.tool.c0.s("DialogUpdateSex", "修改性别失败:" + str);
        com.rtk.app.tool.f.a(this.o, str, f.a.f);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.dialog_update_sex_cancel /* 2131297388 */:
                dismiss();
                return;
            case R.id.dialog_update_sex_man /* 2131297389 */:
                this.p = 1;
                q();
                dismiss();
                return;
            case R.id.dialog_update_sex_woman /* 2131297390 */:
                this.p = 2;
                q();
                dismiss();
                return;
            default:
                return;
        }
    }

    public void p() {
        this.k = (TextView) findViewById(R.id.dialog_update_sex_man);
        this.l = (TextView) findViewById(R.id.dialog_update_sex_woman);
        this.m = (TextView) findViewById(R.id.dialog_update_sex_cancel);
    }

    public void r() {
        this.k.setOnClickListener(this);
        this.l.setOnClickListener(this);
        this.m.setOnClickListener(this);
    }
}
