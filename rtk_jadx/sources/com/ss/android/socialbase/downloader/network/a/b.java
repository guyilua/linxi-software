package com.ss.android.socialbase.downloader.network.a;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Process;
import android.text.TextUtils;
import com.ss.android.socialbase.downloader.i.f;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import com.ss.android.socialbase.downloader.network.j;
import java.util.List;
import java.util.Map;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class b {
    static long a;
    static long b;

    /* renamed from: c, reason: collision with root package name */
    private static final HandlerThread f901c;
    private static final Handler d;

    static {
        HandlerThread handlerThread = new HandlerThread("Downloader-preconnecter");
        f901c = handlerThread;
        b();
        handlerThread.start();
        Handler handler = new Handler(handlerThread.getLooper());
        d = handler;
        handler.post(new Runnable() { // from class: com.ss.android.socialbase.downloader.network.a.b.1
            @Override // java.lang.Runnable
            public void run() {
                try {
                    Process.setThreadPriority(10);
                } catch (Throwable unused) {
                }
            }
        });
    }

    private static void b() {
        a = com.ss.android.socialbase.downloader.g.a.c().a("preconnect_connection_outdate_time", 300000L);
        b = com.ss.android.socialbase.downloader.g.a.c().a("preconnect_head_info_outdate_time", 300000L);
        a.a().a(com.ss.android.socialbase.downloader.g.a.c().a("preconnect_max_cache_size", 3));
    }

    public static Looper a() {
        return f901c.getLooper();
    }

    public static void a(final String str, final j jVar) {
        d.post(new Runnable() { // from class: com.ss.android.socialbase.downloader.network.a.b.2
            @Override // java.lang.Runnable
            public void run() {
                if (!TextUtils.isEmpty(str)) {
                    try {
                        try {
                            List<com.ss.android.socialbase.downloader.model.c> b2 = b.b(0L, null, null);
                            r1 = a.a().a(str) ? a.a().a(str, b2) : null;
                            if (r1 == null) {
                                c cVar = new c(str, b2, 0L);
                                try {
                                    cVar.a();
                                    if (cVar.e()) {
                                        a.a().a(str, cVar);
                                    }
                                    r1 = cVar;
                                } catch (Exception e) {
                                    e = e;
                                    r1 = cVar;
                                    e.printStackTrace();
                                    try {
                                        r1.c();
                                        return;
                                    } catch (Throwable unused) {
                                        return;
                                    }
                                } catch (Throwable th) {
                                    th = th;
                                    r1 = cVar;
                                    try {
                                        r1.c();
                                    } catch (Throwable unused2) {
                                    }
                                    throw th;
                                }
                            }
                            Map<String, String> i = r1.i();
                            j jVar2 = jVar;
                            if (jVar2 != null) {
                                jVar2.a(i);
                            }
                            try {
                                r1.c();
                            } catch (Throwable unused3) {
                            }
                        } catch (Exception e2) {
                            e = e2;
                        }
                    } catch (Throwable th2) {
                        th = th2;
                    }
                } else {
                    j jVar3 = jVar;
                    if (jVar3 != null) {
                        jVar3.a(null);
                    }
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static List<com.ss.android.socialbase.downloader.model.c> b(long j, DownloadInfo downloadInfo, List<com.ss.android.socialbase.downloader.model.c> list) {
        return f.a(list, downloadInfo == null ? null : downloadInfo.geteTag(), j, 0L);
    }
}
