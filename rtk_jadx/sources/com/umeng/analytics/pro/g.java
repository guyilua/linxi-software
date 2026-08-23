package com.umeng.analytics.pro;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import java.util.concurrent.atomic.AtomicInteger;

/* compiled from: UMDBManager.java */
/* loaded from: /tmp/rtk_apk/classes3.dex */
class g {
    private static SQLiteOpenHelper b;
    private static Context d;
    private AtomicInteger a;

    /* renamed from: c, reason: collision with root package name */
    private SQLiteDatabase f1051c;

    /* compiled from: UMDBManager.java */
    /* loaded from: /tmp/rtk_apk/classes3.dex */
    private static class a {
        private static final g a = new g();

        private a() {
        }
    }

    public static g a(Context context) {
        if (d == null && context != null) {
            Context applicationContext = context.getApplicationContext();
            d = applicationContext;
            b = f.a(applicationContext);
        }
        return a.a;
    }

    public synchronized void b() {
        try {
            if (this.a.decrementAndGet() == 0) {
                this.f1051c.close();
            }
        } catch (Throwable unused) {
        }
    }

    private g() {
        this.a = new AtomicInteger();
    }

    public synchronized SQLiteDatabase a() {
        if (this.a.incrementAndGet() == 1) {
            this.f1051c = b.getWritableDatabase();
        }
        return this.f1051c;
    }
}
