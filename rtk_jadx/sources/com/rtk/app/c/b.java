package com.rtk.app.c;

import android.os.Bundle;

/* compiled from: RTKBundle.java */
/* loaded from: /tmp/rtk_apk/classes3.dex */
public final class b {
    private static b a;
    private static Bundle b;

    private b() {
        b = new Bundle();
    }

    public static synchronized b a() {
        b bVar;
        synchronized (b.class) {
            if (a == null) {
                a = new b();
            }
            bVar = a;
        }
        return bVar;
    }

    public Bundle b(String str, String str2) {
        b.putString(str, str2);
        return b;
    }
}
