package com.tencent.smtt.sdk;

import android.content.Context;
import com.tencent.smtt.utils.TbsLog;
import java.nio.channels.FileLock;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: X5CoreEngine.java */
/* loaded from: /tmp/rtk_apk/classes3.dex */
public class t {
    private static t a;
    private static FileLock e;
    private u b;

    /* renamed from: c, reason: collision with root package name */
    private boolean f969c;
    private boolean d;

    private t() {
    }

    public static t a() {
        if (a == null) {
            synchronized (t.class) {
                if (a == null) {
                    a = new t();
                }
            }
        }
        return a;
    }

    public boolean b() {
        if (QbSdk.a) {
            return false;
        }
        return this.f969c;
    }

    public u c() {
        if (QbSdk.a) {
            return null;
        }
        return this.b;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean d() {
        return this.d;
    }

    public FileLock b(Context context) {
        TbsLog.i("X5CoreEngine", "tryTbsCoreLoadFileLock ##");
        FileLock fileLock = e;
        if (fileLock != null) {
            return fileLock;
        }
        synchronized (t.class) {
            if (e == null) {
                FileLock e2 = com.tencent.smtt.utils.f.e(context);
                e = e2;
                if (e2 == null) {
                    TbsLog.i("X5CoreEngine", "init -- sTbsCoreLoadFileLock failed!");
                } else {
                    TbsLog.i("X5CoreEngine", "init -- sTbsCoreLoadFileLock succeeded: " + e);
                }
            }
        }
        return e;
    }

    public u a(boolean z) {
        if (z) {
            return this.b;
        }
        return c();
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x0096 A[Catch: all -> 0x01c7, TRY_LEAVE, TryCatch #3 {, blocks: (B:3:0x0001, B:6:0x0023, B:8:0x0027, B:15:0x005f, B:17:0x0063, B:18:0x007a, B:20:0x0096, B:35:0x0109, B:37:0x0115, B:38:0x01c3, B:43:0x013a, B:45:0x0106, B:46:0x015e, B:48:0x0164, B:49:0x0184, B:50:0x01a4, B:52:0x01c0, B:55:0x0041, B:53:0x005c, B:57:0x0072, B:25:0x00a7, B:27:0x00ad, B:28:0x00b9, B:30:0x00bd, B:31:0x00ec, B:33:0x00f0, B:10:0x0032, B:12:0x003a), top: B:2:0x0001, inners: #1, #4 }] */
    /* JADX WARN: Removed duplicated region for block: B:50:0x01a4 A[Catch: all -> 0x01c7, TryCatch #3 {, blocks: (B:3:0x0001, B:6:0x0023, B:8:0x0027, B:15:0x005f, B:17:0x0063, B:18:0x007a, B:20:0x0096, B:35:0x0109, B:37:0x0115, B:38:0x01c3, B:43:0x013a, B:45:0x0106, B:46:0x015e, B:48:0x0164, B:49:0x0184, B:50:0x01a4, B:52:0x01c0, B:55:0x0041, B:53:0x005c, B:57:0x0072, B:25:0x00a7, B:27:0x00ad, B:28:0x00b9, B:30:0x00bd, B:31:0x00ec, B:33:0x00f0, B:10:0x0032, B:12:0x003a), top: B:2:0x0001, inners: #1, #4 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public synchronized void a(android.content.Context r11) {
        /*
            Method dump skipped, instructions count: 458
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.smtt.sdk.t.a(android.content.Context):void");
    }
}
