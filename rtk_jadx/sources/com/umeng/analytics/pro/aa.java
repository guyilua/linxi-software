package com.umeng.analytics.pro;

import android.content.Context;
import android.os.Looper;

/* compiled from: OpenDeviceId.java */
/* loaded from: /tmp/rtk_apk/classes3.dex */
public class aa {
    private static z a = null;
    private static boolean b = false;

    public static synchronized String a(Context context) {
        synchronized (aa.class) {
            try {
                if (context != null) {
                    if (Looper.myLooper() != Looper.getMainLooper()) {
                        b(context);
                        z zVar = a;
                        if (zVar != null) {
                            try {
                                return zVar.a(context);
                            } catch (Exception unused) {
                            }
                        }
                        return null;
                    }
                    throw new IllegalStateException("Cannot be called from the main thread");
                }
                throw new RuntimeException("Context is null");
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    private static void b(Context context) {
        if (a != null || b) {
            return;
        }
        synchronized (aa.class) {
            if (a == null && !b) {
                a = ac.a(context);
                b = true;
            }
        }
    }
}
