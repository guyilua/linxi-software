package com.umeng.analytics.pro;

import com.umeng.analytics.AnalyticsConfig;
import java.lang.Thread;

/* compiled from: CrashHandler.java */
/* loaded from: /tmp/rtk_apk/classes3.dex */
public class p implements Thread.UncaughtExceptionHandler {
    private Thread.UncaughtExceptionHandler a;
    private t b;

    public p() {
        if (Thread.getDefaultUncaughtExceptionHandler() == this) {
            return;
        }
        this.a = Thread.getDefaultUncaughtExceptionHandler();
        Thread.setDefaultUncaughtExceptionHandler(this);
    }

    public void a(t tVar) {
        this.b = tVar;
    }

    @Override // java.lang.Thread.UncaughtExceptionHandler
    public void uncaughtException(Thread thread, Throwable th) {
        a(th);
        Thread.UncaughtExceptionHandler uncaughtExceptionHandler = this.a;
        if (uncaughtExceptionHandler == null || uncaughtExceptionHandler == Thread.getDefaultUncaughtExceptionHandler()) {
            return;
        }
        this.a.uncaughtException(thread, th);
    }

    private void a(Throwable th) {
        if (AnalyticsConfig.CATCH_EXCEPTION) {
            this.b.a(th);
        } else {
            this.b.a(null);
        }
    }
}
