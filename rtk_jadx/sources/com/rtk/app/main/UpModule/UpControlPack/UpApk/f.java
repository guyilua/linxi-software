package com.rtk.app.main.UpModule.UpControlPack.UpApk;

import com.rtk.app.tool.c0;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/* compiled from: UpObserverManager.java */
/* loaded from: /tmp/rtk_apk/classes3.dex */
public class f {
    public static Set<e> a = new HashSet();
    private static f b;

    public static f b() {
        if (b == null) {
            b = new f();
        }
        return b;
    }

    public void a(e eVar) {
        if (a.contains(eVar)) {
            return;
        }
        a.add(eVar);
    }

    public void c(long j, long j2, int i) {
        for (e eVar : a) {
            if (eVar.f == i) {
                eVar.s(j, j2, i);
            }
        }
    }

    public void d(int i) {
        Iterator<e> it = a.iterator();
        while (it.hasNext()) {
            it.next().r(i);
        }
    }

    public void e(int i) {
        c0.u("UP_TAG UpObserverManager", "等待网络中...222");
        for (e eVar : a) {
            if (eVar.f == i) {
                eVar.q(i);
            }
        }
    }

    public void f(int i) {
        boolean z = true;
        int i2 = 0;
        while (z) {
            i2++;
            try {
                if (a.size() == 0) {
                    z = false;
                }
                Iterator<e> it = a.iterator();
                int i3 = 0;
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    e next = it.next();
                    i3++;
                    if (next.f == i) {
                        h(next);
                        break;
                    } else if (i3 == a.size()) {
                        z = false;
                    }
                }
                if (i2 > 20) {
                    return;
                }
            } catch (Exception unused) {
                c0.u("UP_TAG UpObserverManager", "移除上传观察这异常");
                return;
            }
        }
    }

    public void g(List<e> list) {
        for (e eVar : list) {
            f(eVar.f);
            h(eVar);
        }
    }

    public void h(e eVar) {
        c0.u("UP_TAG UpObserverManager", "移除观察者被调用");
        if (eVar == null || !a.contains(eVar)) {
            return;
        }
        eVar.l(eVar.f);
        a.remove(eVar);
    }
}
