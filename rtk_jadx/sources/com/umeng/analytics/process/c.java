package com.umeng.analytics.process;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import com.umeng.commonsdk.service.UMGlobalContext;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

/* compiled from: UMProcessDBManager.java */
/* loaded from: /tmp/rtk_apk/classes3.dex */
class c {
    private static c a;
    private ConcurrentHashMap<String, a> b = new ConcurrentHashMap<>();

    /* renamed from: c, reason: collision with root package name */
    private Context f1070c;

    private c() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static c a(Context context) {
        if (a == null) {
            synchronized (c.class) {
                if (a == null) {
                    a = new c();
                }
            }
        }
        c cVar = a;
        cVar.f1070c = context;
        return cVar;
    }

    private a c(String str) {
        if (this.b.get(str) == null) {
            a a2 = a.a(this.f1070c, str);
            this.b.put(str, a2);
            return a2;
        }
        return this.b.get(str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized void b(String str) {
        c(str).b();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: UMProcessDBManager.java */
    /* loaded from: /tmp/rtk_apk/classes3.dex */
    public static class a {
        private AtomicInteger a = new AtomicInteger();
        private SQLiteOpenHelper b;

        /* renamed from: c, reason: collision with root package name */
        private SQLiteDatabase f1071c;

        private a() {
        }

        static a a(Context context, String str) {
            Context appContext = UMGlobalContext.getAppContext(context);
            a aVar = new a();
            aVar.b = b.a(appContext, str);
            return aVar;
        }

        synchronized void b() {
            try {
                if (this.a.decrementAndGet() == 0) {
                    this.f1071c.close();
                }
            } catch (Throwable unused) {
            }
        }

        synchronized SQLiteDatabase a() {
            if (this.a.incrementAndGet() == 1) {
                this.f1071c = this.b.getWritableDatabase();
            }
            return this.f1071c;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized SQLiteDatabase a(String str) {
        return c(str).a();
    }
}
