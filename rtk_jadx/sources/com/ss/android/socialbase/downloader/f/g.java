package com.ss.android.socialbase.downloader.f;

import com.ss.android.socialbase.downloader.exception.BaseException;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: /tmp/rtk_apk/classes3.dex */
public class g {

    /* renamed from: c, reason: collision with root package name */
    private final DownloadInfo f860c;
    private final com.ss.android.socialbase.downloader.g.a e;
    private final com.ss.android.socialbase.downloader.h.f f;
    private final c g;
    private BaseException h;
    private final boolean m;
    private final long n;
    private final long o;
    private final boolean p;
    private long q;
    private final List<l> a = new LinkedList();
    private final List<l> b = new ArrayList();
    private volatile boolean i = false;
    private volatile boolean j = false;
    private volatile boolean k = false;
    private volatile long r = 0;
    private volatile long s = 0;
    private final com.ss.android.socialbase.downloader.downloader.j d = com.ss.android.socialbase.downloader.downloader.c.y();
    private final com.ss.android.socialbase.downloader.a.a l = com.ss.android.socialbase.downloader.a.a.a();

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(DownloadInfo downloadInfo, com.ss.android.socialbase.downloader.h.f fVar, c cVar) {
        this.f860c = downloadInfo;
        this.f = fVar;
        this.g = cVar;
        com.ss.android.socialbase.downloader.g.a a = com.ss.android.socialbase.downloader.g.a.a(downloadInfo.getId());
        this.e = a;
        boolean z = a.a("sync_strategy", 0) == 1;
        this.m = z;
        if (z) {
            long a2 = a.a("sync_interval_ms_fg", 5000);
            long a3 = a.a("sync_interval_ms_bg", 1000);
            this.n = Math.max(a2, 500L);
            this.o = Math.max(a3, 500L);
        } else {
            this.n = 0L;
            this.o = 0L;
        }
        this.p = a.b("monitor_rw") == 1;
    }

    private boolean a(long j, long j2) {
        return j > 65536 && j2 > 500;
    }

    private void b(List<l> list) {
        Iterator<l> it = list.iterator();
        while (it.hasNext()) {
            it.next().c();
        }
    }

    private void c() {
        boolean z = this.p;
        long nanoTime = z ? System.nanoTime() : 0L;
        DownloadInfo downloadInfo = this.f860c;
        com.ss.android.socialbase.downloader.downloader.j jVar = this.d;
        List<l> list = this.a;
        List<l> list2 = this.b;
        Map<Long, i> l = jVar.l(downloadInfo.getId());
        if (l == null) {
            l = new HashMap<>(4);
        }
        boolean z2 = false;
        synchronized (this) {
            a(list);
            try {
                b(list);
                z2 = true;
            } catch (Throwable th) {
                th.printStackTrace();
            }
            a(list, l);
            if (list2.size() > 0) {
                c(list2);
                list.removeAll(list2);
                list2.clear();
            }
        }
        if (z2) {
            downloadInfo.updateRealDownloadTime(true);
            jVar.a(downloadInfo.getId(), l);
            jVar.a(downloadInfo);
            this.r = downloadInfo.getCurBytes();
        }
        if (z) {
            this.q += System.nanoTime() - nanoTime;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(l lVar) {
        synchronized (this) {
            this.a.add(lVar);
        }
    }

    public void b() {
        this.j = true;
        this.i = true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Code restructure failed: missing block: B:196:0x028d, code lost:
    
        r3.b(r15);
     */
    /* JADX WARN: Code restructure failed: missing block: B:254:0x00b8, code lost:
    
        if (r13 <= 0) goto L68;
     */
    /* JADX WARN: Code restructure failed: missing block: B:257:0x00bb, code lost:
    
        r3.b(r13);
     */
    /* JADX WARN: Removed duplicated region for block: B:130:0x0398 A[Catch: all -> 0x03ad, TryCatch #5 {all -> 0x03ad, blocks: (B:137:0x01e8, B:139:0x01ec, B:142:0x01f2, B:144:0x01f8, B:145:0x01fb, B:147:0x020a, B:191:0x0287, B:192:0x0289, B:81:0x0309, B:83:0x0313, B:85:0x0317, B:128:0x0392, B:130:0x0398, B:131:0x039b, B:132:0x03ac), top: B:6:0x0027, inners: #6 }] */
    /* JADX WARN: Removed duplicated region for block: B:139:0x01ec A[Catch: all -> 0x03ad, TryCatch #5 {all -> 0x03ad, blocks: (B:137:0x01e8, B:139:0x01ec, B:142:0x01f2, B:144:0x01f8, B:145:0x01fb, B:147:0x020a, B:191:0x0287, B:192:0x0289, B:81:0x0309, B:83:0x0313, B:85:0x0317, B:128:0x0392, B:130:0x0398, B:131:0x039b, B:132:0x03ac), top: B:6:0x0027, inners: #6 }] */
    /* JADX WARN: Removed duplicated region for block: B:144:0x01f8 A[Catch: all -> 0x03ad, TryCatch #5 {all -> 0x03ad, blocks: (B:137:0x01e8, B:139:0x01ec, B:142:0x01f2, B:144:0x01f8, B:145:0x01fb, B:147:0x020a, B:191:0x0287, B:192:0x0289, B:81:0x0309, B:83:0x0313, B:85:0x0317, B:128:0x0392, B:130:0x0398, B:131:0x039b, B:132:0x03ac), top: B:6:0x0027, inners: #6 }] */
    /* JADX WARN: Removed duplicated region for block: B:149:0x0211  */
    /* JADX WARN: Removed duplicated region for block: B:158:0x0233 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:184:0x021b A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:203:0x02ae A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:229:0x0296 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:264:0x00dc A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:36:0x03c1  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x03e4 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:72:0x03cb A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:83:0x0313 A[Catch: all -> 0x03ad, TryCatch #5 {all -> 0x03ad, blocks: (B:137:0x01e8, B:139:0x01ec, B:142:0x01f2, B:144:0x01f8, B:145:0x01fb, B:147:0x020a, B:191:0x0287, B:192:0x0289, B:81:0x0309, B:83:0x0313, B:85:0x0317, B:128:0x0392, B:130:0x0398, B:131:0x039b, B:132:0x03ac), top: B:6:0x0027, inners: #6 }] */
    /* JADX WARN: Removed duplicated region for block: B:97:0x033f A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void a(com.ss.android.socialbase.downloader.f.d r31) {
        /*
            Method dump skipped, instructions count: 1082
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ss.android.socialbase.downloader.f.g.a(com.ss.android.socialbase.downloader.f.d):void");
    }

    private void c(List<l> list) {
        Iterator<l> it = list.iterator();
        while (it.hasNext()) {
            it.next().d();
        }
    }

    private void a(long j, boolean z) {
        long j2 = j - this.s;
        if (this.m) {
            if (j2 <= (this.l.b() ? this.n : this.o)) {
                return;
            }
        } else {
            long curBytes = this.f860c.getCurBytes() - this.r;
            if (!z && !a(curBytes, j2)) {
                return;
            }
        }
        c();
        this.s = j;
    }

    private void a(e eVar) {
        synchronized (this) {
            this.b.add((l) eVar);
        }
    }

    private void a(List<l> list) {
        Iterator<l> it = list.iterator();
        while (it.hasNext()) {
            it.next().b();
        }
    }

    private void a(List<l> list, Map<Long, i> map) {
        Iterator<l> it = list.iterator();
        while (it.hasNext()) {
            i e = it.next().e();
            i iVar = map.get(Long.valueOf(e.c()));
            if (iVar == null) {
                map.put(Long.valueOf(e.c()), new i(e));
            } else {
                iVar.a(e.d());
                iVar.c(e.f());
            }
        }
    }

    public void a() {
        this.k = true;
        this.i = true;
    }
}
