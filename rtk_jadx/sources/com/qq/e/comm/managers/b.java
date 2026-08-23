package com.qq.e.comm.managers;

import com.qq.e.comm.managers.plugin.e;
import com.qq.e.comm.util.GDTLogger;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: /tmp/rtk_apk/classes3.dex */
public class b implements Runnable {
    final /* synthetic */ boolean a;
    final /* synthetic */ a b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(a aVar, boolean z) {
        this.b = aVar;
        this.a = z;
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            this.b.d.getPOFactory(this.a, true);
            this.b.b = true;
        } catch (e e) {
            GDTLogger.e(e.getMessage(), e);
        }
    }
}
