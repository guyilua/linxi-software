package com.rtk.app.tool.DownLoadTool;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* compiled from: ObserverManager.java */
/* loaded from: /tmp/rtk_apk/classes3.dex */
public class x {

    /* renamed from: c, reason: collision with root package name */
    private static x f296c;
    private List<y> a = new ArrayList();
    private List<o> b = new ArrayList();

    public static x c() {
        if (f296c == null) {
            synchronized (x.class) {
                if (f296c == null) {
                    f296c = new x();
                }
            }
        }
        f296c.d(com.rtk.app.tool.y.q());
        return f296c;
    }

    public synchronized void a(y yVar) {
        this.a.add(yVar);
    }

    public void b(o oVar) {
        this.b.add(oVar);
        oVar.a(com.rtk.app.tool.y.q());
    }

    public void d(int i) {
        Iterator<o> it = this.b.iterator();
        while (it.hasNext()) {
            it.next().a(i);
        }
    }

    public synchronized void e(int i, int i2) {
        Iterator<y> it = this.a.iterator();
        while (it.hasNext()) {
            it.next().g(i, i2);
        }
    }

    public void f(int i, String str) {
        Iterator<y> it = this.a.iterator();
        while (it.hasNext()) {
            it.next().d(i, str);
        }
    }

    public synchronized void g(long j, long j2, int i, String str, long j3, long j4) {
        Iterator<y> it = this.a.iterator();
        while (it.hasNext()) {
            it.next().c(j, j2, i, str, j3, j4);
        }
    }

    public synchronized void h(int i) {
        Iterator<y> it = this.a.iterator();
        while (it.hasNext()) {
            it.next().a(i);
        }
    }

    public synchronized void i(int i) {
        Iterator<y> it = this.a.iterator();
        while (it.hasNext()) {
            it.next().h(i);
        }
    }

    public synchronized void j(int i) {
        Iterator<y> it = this.a.iterator();
        while (it.hasNext()) {
            it.next().f(i);
        }
    }

    public synchronized void k(int i) {
        Iterator<y> it = this.a.iterator();
        while (it.hasNext()) {
            it.next().e(i);
        }
    }

    public synchronized void l(int i) {
        Iterator<y> it = this.a.iterator();
        while (it.hasNext()) {
            it.next().b(i);
        }
    }

    public synchronized void m(y yVar) {
        this.a.remove(yVar);
    }

    public void n(o oVar) {
        this.b.remove(oVar);
    }
}
