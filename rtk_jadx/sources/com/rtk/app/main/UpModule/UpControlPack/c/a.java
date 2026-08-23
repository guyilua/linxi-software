package com.rtk.app.main.UpModule.UpControlPack.c;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* compiled from: UpIconNumObserverManager.java */
/* loaded from: /tmp/rtk_apk/classes3.dex */
public class a {
    private static a b;
    private List<c> a = new ArrayList();

    public static a b() {
        if (b == null) {
            b = new a();
        }
        return b;
    }

    public void a(c cVar) {
        cVar.a(com.rtk.app.main.UpModule.UpControlPack.b.i().j());
        this.a.add(cVar);
    }

    public void c(c cVar) {
        this.a.add(cVar);
    }

    public void d(int i) {
        Iterator<c> it = this.a.iterator();
        while (it.hasNext()) {
            it.next().a(i);
        }
    }
}
