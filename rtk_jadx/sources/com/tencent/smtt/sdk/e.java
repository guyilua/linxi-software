package com.tencent.smtt.sdk;

import android.database.sqlite.SQLiteException;
import java.lang.Thread;

/* compiled from: SQLiteUncaughtExceptionHandler.java */
/* loaded from: /tmp/rtk_apk/classes3.dex */
public class e implements Thread.UncaughtExceptionHandler {
    @Override // java.lang.Thread.UncaughtExceptionHandler
    public void uncaughtException(Thread thread, Throwable th) {
        if (!(th instanceof SQLiteException)) {
            throw new RuntimeException(th);
        }
    }
}
