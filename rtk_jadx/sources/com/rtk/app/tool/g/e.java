package com.rtk.app.tool.g;

import android.app.Activity;
import android.content.Context;
import com.rtk.app.main.MyApplication;
import com.rtk.app.main.dialogPack.DialogTeenModeTimeOut;
import com.rtk.app.tool.c0;
import com.rtk.app.tool.s;
import com.rtk.app.tool.v;

/* compiled from: TeenModeTraceBean.java */
/* loaded from: /tmp/rtk_apk/classes3.dex */
public class e {
    private static e h;
    private long a;
    private long b;

    /* renamed from: c, reason: collision with root package name */
    private long f303c;
    private boolean e;
    private DialogTeenModeTimeOut g;
    private long d = 0;
    private boolean f = false;

    public e(boolean z) {
        this.e = z;
    }

    public static e c() {
        if (h == null) {
            h = new e(v.a(MyApplication.b(), "IS_OPEN_TENN_MODE"));
        }
        return h;
    }

    public static void h(Context context) {
        long b = com.rtk.app.c.d.b();
        long currentTimeMillis = System.currentTimeMillis();
        e b2 = d.c(context).b(b);
        if (b2 == null) {
            c0.u("TeenModeTraceBean", "青少年模式 teenModeTraceBean null");
            d.c(context).d(b, currentTimeMillis);
            m(d.c(context).b(b));
        } else {
            m(b2);
        }
        c0.u("TeenModeTraceBean", "青少年模式 usedTime:" + c().f());
        c().l(currentTimeMillis);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: j, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void k(String[] strArr) {
        this.f = true;
    }

    private void l(long j) {
        this.b = j;
    }

    private static void m(e eVar) {
        h = eVar;
    }

    private void q(Activity activity) {
        if (this.f) {
            return;
        }
        DialogTeenModeTimeOut dialogTeenModeTimeOut = this.g;
        if (dialogTeenModeTimeOut != null) {
            dialogTeenModeTimeOut.show();
            return;
        }
        DialogTeenModeTimeOut dialogTeenModeTimeOut2 = new DialogTeenModeTimeOut(activity, new s() { // from class: com.rtk.app.tool.g.a
            @Override // com.rtk.app.tool.s
            public final void a(String[] strArr) {
                e.this.k(strArr);
            }
        });
        this.g = dialogTeenModeTimeOut2;
        dialogTeenModeTimeOut2.show();
    }

    public void a(Activity activity) {
        if (c().f() > c().e()) {
            c0.u("TeenModeTraceBean", "当前已经使用时间" + c().f());
            q(activity);
            DialogTeenModeTimeOut dialogTeenModeTimeOut = this.g;
            if (dialogTeenModeTimeOut == null) {
                return;
            }
            dialogTeenModeTimeOut.r("使用超时提示");
            this.g.q("您已达青少年模式本日单次使用时长限制，无法继续使用APP。需监护人输入密码暂时关闭青少年模式后才可继续使用。");
        }
    }

    public long b() {
        return this.b;
    }

    public long d() {
        return this.d;
    }

    public long e() {
        if (this.a == 0) {
            this.a = v.c(MyApplication.b(), "TENN_MODE_MAST_TIME").longValue();
        }
        c0.u("TeenModeTraceBean", "当前最大使用时间" + this.a);
        return this.a;
    }

    public long f() {
        return this.f303c;
    }

    public boolean g(Activity activity) {
        int a = com.rtk.app.c.d.a();
        if (a < 22 && a >= 6) {
            return false;
        }
        q(activity);
        DialogTeenModeTimeOut dialogTeenModeTimeOut = this.g;
        if (dialogTeenModeTimeOut == null) {
            return true;
        }
        dialogTeenModeTimeOut.r("限制使用提示");
        this.g.q("您已达青少年模式限制使用时段（22点-6点），无法继续使用APP。需监护人输入密码暂时关闭青少年模式后才可继续使用。");
        return true;
    }

    public boolean i() {
        boolean a = v.a(MyApplication.b(), "IS_OPEN_TENN_MODE");
        this.e = a;
        return a;
    }

    public void n(long j) {
        this.d = j;
    }

    public void o(long j) {
        v.g(MyApplication.b(), "TENN_MODE_MAST_TIME", Long.valueOf(j));
        this.a = j;
        c0.u("TeenModeTraceBean", "当前最大使用时间" + j);
    }

    public void p(long j) {
        this.f303c = j;
        if (this.d == 0 || j == 0) {
            n(j);
        }
    }

    public e(int i, long j, long j2, long j3) {
        this.f303c = j3;
    }
}
