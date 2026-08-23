package com.rtk.app.tool.b0;

import com.rtk.app.tool.DownLoadTool.x;
import java.util.ArrayList;
import java.util.List;

/* compiled from: UserObserverManager.java */
/* loaded from: /tmp/rtk_apk/classes3.dex */
public class b {
    private static b b;
    private List<c> a = new ArrayList();

    public static b b() {
        if (b == null) {
            synchronized (x.class) {
                if (b == null) {
                    b = new b();
                }
            }
        }
        return b;
    }

    public void a(c cVar) {
        this.a.add(cVar);
    }

    public void c(c cVar) {
        this.a.remove(cVar);
    }

    public void d(List<c> list) {
        for (int i = 0; i < list.size(); i++) {
            b().c(list.get(i));
        }
    }

    public void e(int i, int i2) {
        for (int i3 = 0; i3 < this.a.size(); i3++) {
            if (this.a.get(i3) != null) {
                this.a.get(i3).a(i, i2);
            }
        }
    }
}
