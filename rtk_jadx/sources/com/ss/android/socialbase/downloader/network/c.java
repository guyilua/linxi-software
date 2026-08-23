package com.ss.android.socialbase.downloader.network;

import android.os.Handler;
import java.net.InetAddress;
import java.util.List;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class c {
    private final com.ss.android.socialbase.downloader.i.h<String, b> a;
    private final Handler b;

    /* renamed from: c, reason: collision with root package name */
    private final Handler f905c;

    /* loaded from: /tmp/rtk_apk/classes3.dex */
    public interface a {
        void a(String str, List<InetAddress> list);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: /tmp/rtk_apk/classes3.dex */
    public static class b {
        List<InetAddress> a;
        long b;

        private b() {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.ss.android.socialbase.downloader.network.c$c, reason: collision with other inner class name */
    /* loaded from: /tmp/rtk_apk/classes3.dex */
    public static class C0113c {
        private static final c a = new c();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:38:0x0085, code lost:
    
        r10 = r2.a;
     */
    /* JADX WARN: Removed duplicated region for block: B:34:0x008e A[Catch: all -> 0x0095, TRY_LEAVE, TryCatch #2 {all -> 0x0095, blocks: (B:2:0x0000, B:3:0x000a, B:8:0x0016, B:11:0x0034, B:15:0x003a, B:17:0x0052, B:23:0x005e, B:25:0x0063, B:28:0x0078, B:31:0x007f, B:32:0x0087, B:34:0x008e, B:38:0x0085, B:39:0x0069, B:44:0x0073, B:48:0x0094, B:41:0x006d, B:5:0x000b, B:6:0x0013, B:20:0x0058), top: B:1:0x0000, inners: #0, #1, #3 }] */
    /* JADX WARN: Removed duplicated region for block: B:36:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void b(final java.lang.String r8, final com.ss.android.socialbase.downloader.network.c.a r9, long r10) {
        /*
            r7 = this;
            android.net.Uri r0 = android.net.Uri.parse(r8)     // Catch: java.lang.Throwable -> L95
            java.lang.String r0 = r0.getHost()     // Catch: java.lang.Throwable -> L95
            com.ss.android.socialbase.downloader.i.h<java.lang.String, com.ss.android.socialbase.downloader.network.c$b> r1 = r7.a     // Catch: java.lang.Throwable -> L95
            monitor-enter(r1)     // Catch: java.lang.Throwable -> L95
            com.ss.android.socialbase.downloader.i.h<java.lang.String, com.ss.android.socialbase.downloader.network.c$b> r2 = r7.a     // Catch: java.lang.Throwable -> L92
            java.lang.Object r2 = r2.get(r0)     // Catch: java.lang.Throwable -> L92
            com.ss.android.socialbase.downloader.network.c$b r2 = (com.ss.android.socialbase.downloader.network.c.b) r2     // Catch: java.lang.Throwable -> L92
            monitor-exit(r1)     // Catch: java.lang.Throwable -> L92
            if (r2 == 0) goto L3a
            com.ss.android.socialbase.downloader.g.a r1 = com.ss.android.socialbase.downloader.g.a.c()     // Catch: java.lang.Throwable -> L95
            java.lang.String r3 = "dns_expire_min"
            r4 = 10
            int r1 = r1.a(r3, r4)     // Catch: java.lang.Throwable -> L95
            long r3 = java.lang.System.currentTimeMillis()     // Catch: java.lang.Throwable -> L95
            long r5 = r2.b     // Catch: java.lang.Throwable -> L95
            long r3 = r3 - r5
            int r1 = r1 * 60
            int r1 = r1 * 1000
            long r5 = (long) r1     // Catch: java.lang.Throwable -> L95
            int r1 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r1 >= 0) goto L3a
            if (r9 == 0) goto L39
            java.util.List<java.net.InetAddress> r10 = r2.a     // Catch: java.lang.Throwable -> L95
            r9.a(r8, r10)     // Catch: java.lang.Throwable -> L95
        L39:
            return
        L3a:
            com.ss.android.socialbase.downloader.network.c$2 r1 = new com.ss.android.socialbase.downloader.network.c$2     // Catch: java.lang.Throwable -> L95
            r1.<init>()     // Catch: java.lang.Throwable -> L95
            android.os.Handler r3 = r7.f905c     // Catch: java.lang.Throwable -> L95
            r3.postDelayed(r1, r10)     // Catch: java.lang.Throwable -> L95
            r10 = 0
            com.ss.android.socialbase.downloader.g.a r11 = com.ss.android.socialbase.downloader.g.a.c()     // Catch: java.lang.Throwable -> L95
            java.lang.String r3 = "use_host_dns"
            r4 = 1
            int r11 = r11.a(r3, r4)     // Catch: java.lang.Throwable -> L95
            if (r11 != r4) goto L61
            com.ss.android.socialbase.downloader.network.f r11 = com.ss.android.socialbase.downloader.downloader.c.v()     // Catch: java.lang.Throwable -> L95
            if (r11 == 0) goto L61
            java.util.List r10 = r11.a(r0)     // Catch: java.lang.Throwable -> L5d
            goto L61
        L5d:
            r11 = move-exception
            r11.printStackTrace()     // Catch: java.lang.Throwable -> L95
        L61:
            if (r10 == 0) goto L69
            boolean r11 = r10.isEmpty()     // Catch: java.lang.Throwable -> L95
            if (r11 == 0) goto L76
        L69:
            com.ss.android.socialbase.downloader.network.f r11 = com.ss.android.socialbase.downloader.downloader.c.w()     // Catch: java.lang.Throwable -> L95
            java.util.List r10 = r11.a(r0)     // Catch: java.lang.Throwable -> L72
            goto L76
        L72:
            r11 = move-exception
            r11.printStackTrace()     // Catch: java.lang.Throwable -> L95
        L76:
            if (r10 == 0) goto L83
            boolean r11 = r10.isEmpty()     // Catch: java.lang.Throwable -> L95
            if (r11 == 0) goto L7f
            goto L83
        L7f:
            r7.a(r0, r10)     // Catch: java.lang.Throwable -> L95
            goto L87
        L83:
            if (r2 == 0) goto L87
            java.util.List<java.net.InetAddress> r10 = r2.a     // Catch: java.lang.Throwable -> L95
        L87:
            android.os.Handler r11 = r7.f905c     // Catch: java.lang.Throwable -> L95
            r11.removeCallbacks(r1)     // Catch: java.lang.Throwable -> L95
            if (r9 == 0) goto L91
            r9.a(r8, r10)     // Catch: java.lang.Throwable -> L95
        L91:
            return
        L92:
            r8 = move-exception
            monitor-exit(r1)     // Catch: java.lang.Throwable -> L92
            throw r8     // Catch: java.lang.Throwable -> L95
        L95:
            r8 = move-exception
            r8.printStackTrace()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ss.android.socialbase.downloader.network.c.b(java.lang.String, com.ss.android.socialbase.downloader.network.c$a, long):void");
    }

    private c() {
        this.a = new com.ss.android.socialbase.downloader.i.h<>(4, 16, false);
        this.b = new Handler(com.ss.android.socialbase.downloader.network.a.b.a());
        this.f905c = new Handler(com.ss.android.socialbase.downloader.h.e.a());
    }

    public static c a() {
        return C0113c.a;
    }

    public void a(final String str, final a aVar, final long j) {
        this.b.post(new Runnable() { // from class: com.ss.android.socialbase.downloader.network.c.1
            @Override // java.lang.Runnable
            public void run() {
                c.this.b(str, aVar, j);
            }
        });
    }

    private void a(String str, List<InetAddress> list) {
        synchronized (this.a) {
            b bVar = this.a.get(str);
            if (bVar == null) {
                bVar = new b();
                this.a.put(str, bVar);
            }
            bVar.a = list;
            bVar.b = System.currentTimeMillis();
        }
    }
}
