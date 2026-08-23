package com.rtk.app.main.dialogPack;

import android.content.Context;
import com.rtk.app.main.MainActivityPack.MainActivity;
import com.rtk.app.tool.o.h;
import com.sigmob.sdk.downloader.f;
import com.umeng.analytics.pro.ak;
import java.util.Date;
import java.util.HashMap;

/* compiled from: DialogUpdateBirth.java */
/* loaded from: /tmp/rtk_apk/classes3.dex */
public class c0 extends com.codbking.widget.b implements h.j {
    private com.rtk.app.tool.s n;
    private Context o;
    private long p;

    public c0(Context context, com.rtk.app.tool.s sVar) {
        super(context);
        this.o = context;
        this.n = sVar;
        n(28);
        k(new Date(90, 1, 1));
        l("请选择时间");
        m(com.codbking.widget.i.a.d);
        i((com.codbking.widget.f) null);
        j(new com.codbking.widget.g() { // from class: com.rtk.app.main.dialogPack.m
            public final void a(Date date) {
                c0.this.q(date);
            }
        });
    }

    private void o() {
        HashMap hashMap = new HashMap();
        Context context = this.o;
        hashMap.put("channel", com.rtk.app.tool.y.m(context, context.getPackageName()));
        hashMap.put("version", com.rtk.app.tool.y.i(this.o));
        hashMap.put(ak.aj, com.rtk.app.tool.y.g());
        hashMap.put("phone_model", com.rtk.app.tool.y.T());
        hashMap.put("birthday", this.p + "");
        hashMap.put("uid", com.rtk.app.tool.y.K() + "");
        hashMap.put("token", com.rtk.app.tool.y.H());
        hashMap.put("key", com.rtk.app.tool.t.c0(com.rtk.app.tool.c0.e(com.rtk.app.tool.y.v(this.o, "uid=" + com.rtk.app.tool.y.K(), "token=" + com.rtk.app.tool.y.H(), "birthday=" + this.p + ""))));
        Context context2 = this.o;
        StringBuilder sb = new StringBuilder();
        sb.append(com.rtk.app.tool.y.e);
        sb.append("user/info/birthday");
        com.rtk.app.tool.o.h.j(context2, this, sb.toString(), 1, hashMap);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: p, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void q(Date date) {
        this.p = date.getTime() / 1000;
        MainActivity.p.getData().setBirthday((int) this.p);
        o();
    }

    @Override // com.rtk.app.tool.o.h.j
    public void d(String str, int i) {
        com.rtk.app.tool.c0.u("DialogUpdateBirth", "修改生日成功:" + str);
        com.rtk.app.tool.f.a(this.o, "修改生日成功", f.a.f);
        this.n.a(this.p + "");
    }

    @Override // com.rtk.app.tool.o.h.j
    public void g(int i, String str, int i2) {
        com.rtk.app.tool.c0.s("DialogUpdateBirth", "修改生日失败:" + str);
        com.rtk.app.tool.f.a(this.o, str, f.a.f);
    }
}
