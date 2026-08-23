package com.tencent.smtt.sdk;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: SDKEngine.java */
/* loaded from: /tmp/rtk_apk/classes3.dex */
public class d {
    static int a = 0;
    static boolean b = false;
    private static d e = null;
    private static int h = 0;
    private static int i = 3;
    private static String k;

    /* renamed from: c, reason: collision with root package name */
    private r f960c = null;
    private r d = null;
    private boolean f = false;
    private boolean g = false;
    private File j = null;

    private d() {
    }

    public static d a(boolean z) {
        if (e == null && z) {
            synchronized (d.class) {
                if (e == null) {
                    e = new d();
                }
            }
        }
        return e;
    }

    public static int d() {
        return h;
    }

    /* JADX WARN: Not initialized variable reg: 2, insn: 0x0054: MOVE (r1 I:??[OBJECT, ARRAY]) = (r2 I:??[OBJECT, ARRAY]), block:B:28:0x0054 */
    /* JADX WARN: Removed duplicated region for block: B:31:0x0057 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private int i() {
        /*
            r6 = this;
            r0 = 0
            r1 = 0
            java.io.File r2 = new java.io.File     // Catch: java.lang.Throwable -> L3f java.lang.Exception -> L41
            java.io.File r3 = r6.j     // Catch: java.lang.Throwable -> L3f java.lang.Exception -> L41
            java.lang.String r4 = "count.prop"
            r2.<init>(r3, r4)     // Catch: java.lang.Throwable -> L3f java.lang.Exception -> L41
            boolean r3 = r2.exists()     // Catch: java.lang.Throwable -> L3f java.lang.Exception -> L41
            if (r3 != 0) goto L12
            return r0
        L12:
            java.io.FileInputStream r3 = new java.io.FileInputStream     // Catch: java.lang.Throwable -> L3f java.lang.Exception -> L41
            r3.<init>(r2)     // Catch: java.lang.Throwable -> L3f java.lang.Exception -> L41
            java.io.BufferedInputStream r2 = new java.io.BufferedInputStream     // Catch: java.lang.Throwable -> L3f java.lang.Exception -> L41
            r2.<init>(r3)     // Catch: java.lang.Throwable -> L3f java.lang.Exception -> L41
            java.util.Properties r1 = new java.util.Properties     // Catch: java.lang.Exception -> L3d java.lang.Throwable -> L53
            r1.<init>()     // Catch: java.lang.Exception -> L3d java.lang.Throwable -> L53
            r1.load(r2)     // Catch: java.lang.Exception -> L3d java.lang.Throwable -> L53
            java.lang.String r3 = com.tencent.smtt.sdk.d.k     // Catch: java.lang.Exception -> L3d java.lang.Throwable -> L53
            java.lang.String r4 = "1"
            java.lang.String r1 = r1.getProperty(r3, r4)     // Catch: java.lang.Exception -> L3d java.lang.Throwable -> L53
            java.lang.Integer r1 = java.lang.Integer.valueOf(r1)     // Catch: java.lang.Exception -> L3d java.lang.Throwable -> L53
            int r0 = r1.intValue()     // Catch: java.lang.Exception -> L3d java.lang.Throwable -> L53
            r2.close()     // Catch: java.io.IOException -> L38
            goto L3c
        L38:
            r1 = move-exception
            r1.printStackTrace()
        L3c:
            return r0
        L3d:
            r1 = move-exception
            goto L45
        L3f:
            r0 = move-exception
            goto L55
        L41:
            r2 = move-exception
            r5 = r2
            r2 = r1
            r1 = r5
        L45:
            r1.printStackTrace()     // Catch: java.lang.Throwable -> L53
            if (r2 == 0) goto L52
            r2.close()     // Catch: java.io.IOException -> L4e
            goto L52
        L4e:
            r1 = move-exception
            r1.printStackTrace()
        L52:
            return r0
        L53:
            r0 = move-exception
            r1 = r2
        L55:
            if (r1 == 0) goto L5f
            r1.close()     // Catch: java.io.IOException -> L5b
            goto L5f
        L5b:
            r1 = move-exception
            r1.printStackTrace()
        L5f:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.smtt.sdk.d.i():int");
    }

    public boolean b() {
        return this.f;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public r c() {
        return this.f960c;
    }

    public String e() {
        r rVar = this.f960c;
        return (rVar == null || QbSdk.a) ? "system webview get nothing..." : rVar.a();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean f() {
        if (b) {
            if (k == null) {
                return false;
            }
            int i2 = i();
            if (i2 == 0) {
                b(1);
            } else {
                int i3 = i2 + 1;
                if (i3 > i) {
                    return false;
                }
                b(i3);
            }
        }
        return b;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean g() {
        return this.g;
    }

    public boolean h() {
        return QbSdk.useSoftWare();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean b(boolean z) {
        b = z;
        return z;
    }

    private void b(int i2) {
        String valueOf = String.valueOf(i2);
        Properties properties = new Properties();
        properties.setProperty(k, valueOf);
        try {
            properties.store(new FileOutputStream(new File(this.j, "count.prop")), (String) null);
        } catch (FileNotFoundException e2) {
            e2.printStackTrace();
        } catch (IOException e3) {
            e3.printStackTrace();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:60:0x00fb A[Catch: all -> 0x0168, TryCatch #1 {all -> 0x0168, blocks: (B:22:0x00a0, B:24:0x00a6, B:26:0x00b3, B:28:0x00ca, B:32:0x010f, B:33:0x0118, B:35:0x011b, B:37:0x011e, B:39:0x0124, B:40:0x012d, B:42:0x0148, B:43:0x0164, B:47:0x0155, B:48:0x0129, B:49:0x00d3, B:53:0x00de, B:60:0x00fb, B:62:0x0104), top: B:21:0x00a0, outer: #0 }] */
    /* JADX WARN: Removed duplicated region for block: B:62:0x0104 A[Catch: all -> 0x0168, TRY_LEAVE, TryCatch #1 {all -> 0x0168, blocks: (B:22:0x00a0, B:24:0x00a6, B:26:0x00b3, B:28:0x00ca, B:32:0x010f, B:33:0x0118, B:35:0x011b, B:37:0x011e, B:39:0x0124, B:40:0x012d, B:42:0x0148, B:43:0x0164, B:47:0x0155, B:48:0x0129, B:49:0x00d3, B:53:0x00de, B:60:0x00fb, B:62:0x0104), top: B:21:0x00a0, outer: #0 }] */
    /* JADX WARN: Removed duplicated region for block: B:65:0x010d  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x0101  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public synchronized void a(android.content.Context r11, boolean r12, boolean r13) {
        /*
            Method dump skipped, instructions count: 500
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.smtt.sdk.d.a(android.content.Context, boolean, boolean):void");
    }

    public r a() {
        if (this.f) {
            return this.f960c;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(int i2) {
        h = i2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(String str) {
        k = str;
    }
}
