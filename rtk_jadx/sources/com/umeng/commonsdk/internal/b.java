package com.umeng.commonsdk.internal;

import android.content.Context;

/* compiled from: UMInternalData.java */
/* loaded from: /tmp/rtk_apk/classes3.dex */
public class b {
    private static b b;
    private Context a;

    /* renamed from: c, reason: collision with root package name */
    private c f1090c;

    private b(Context context) {
        this.a = context;
        this.f1090c = new c(context);
    }

    public static synchronized b a(Context context) {
        b bVar;
        synchronized (b.class) {
            if (b == null) {
                b = new b(context.getApplicationContext());
            }
            bVar = b;
        }
        return bVar;
    }

    public c a() {
        return this.f1090c;
    }
}
