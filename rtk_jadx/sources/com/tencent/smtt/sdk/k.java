package com.tencent.smtt.sdk;

import android.os.HandlerThread;

/* compiled from: TbsHandlerThread.java */
/* loaded from: /tmp/rtk_apk/classes3.dex */
class k extends HandlerThread {
    private static k a;

    public k(String str) {
        super(str);
    }

    public static synchronized k a() {
        k kVar;
        synchronized (k.class) {
            if (a == null) {
                k kVar2 = new k("TbsHandlerThread");
                a = kVar2;
                kVar2.start();
            }
            kVar = a;
        }
        return kVar;
    }
}
