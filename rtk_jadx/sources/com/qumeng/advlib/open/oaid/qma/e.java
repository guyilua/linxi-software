package com.qumeng.advlib.open.oaid.qma;

import android.app.Application;
import android.content.Context;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public final class e {
    private static com.qumeng.advlib.open.oaid.b a;

    private e() {
    }

    public static com.qumeng.advlib.open.oaid.b a(Context context) {
        if (context != null && !(context instanceof Application)) {
            context = context.getApplicationContext();
        }
        com.qumeng.advlib.open.oaid.b bVar = a;
        if (bVar != null) {
            return bVar;
        }
        com.qumeng.advlib.open.oaid.b b = b(context);
        a = b;
        if (b != null && b.a()) {
            return a;
        }
        com.qumeng.advlib.open.oaid.b c2 = c(context);
        a = c2;
        return c2;
    }

    private static com.qumeng.advlib.open.oaid.b b(Context context) {
        if (com.qumeng.advlib.open.oaid.c.d()) {
            return new c(context);
        }
        if (!com.qumeng.advlib.open.oaid.c.j() && !com.qumeng.advlib.open.oaid.c.e() && !com.qumeng.advlib.open.oaid.c.a()) {
            if (com.qumeng.advlib.open.oaid.c.h()) {
                return new h(context);
            }
            if (com.qumeng.advlib.open.oaid.c.i()) {
                return new i(context);
            }
            if (!com.qumeng.advlib.open.oaid.c.c() && !com.qumeng.advlib.open.oaid.c.b()) {
                if (com.qumeng.advlib.open.oaid.c.g() || com.qumeng.advlib.open.oaid.c.f()) {
                    return new g(context);
                }
                return null;
            }
            return new b(context);
        }
        return new j(context);
    }

    private static com.qumeng.advlib.open.oaid.b c(Context context) {
        d dVar = new d(context);
        return dVar.a() ? dVar : new a();
    }
}
