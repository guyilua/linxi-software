package com.ss.android.socialbase.downloader.f;

import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import com.ss.android.socialbase.downloader.exception.BaseException;
import com.ss.android.socialbase.downloader.h.e;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import com.ss.android.socialbase.downloader.network.c;
import java.net.InetAddress;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class k implements f, c.a {
    private int A;
    private final boolean B;
    private final DownloadInfo a;
    private final n b;

    /* renamed from: c, reason: collision with root package name */
    private final b f862c;
    private final com.ss.android.socialbase.downloader.h.f d;
    private final g e;
    private com.ss.android.socialbase.downloader.model.d j;
    private com.ss.android.socialbase.downloader.model.d k;
    private long m;
    private int p;
    private BaseException q;
    private volatile boolean r;
    private final com.ss.android.socialbase.downloader.i.e t;
    private final com.ss.android.socialbase.downloader.h.e u;
    private long w;
    private long x;
    private long y;
    private float z;
    private volatile boolean f = false;
    private volatile boolean g = false;
    private final List<m> h = new ArrayList();
    private final List<q> i = new ArrayList();
    private volatile boolean l = true;
    private final LinkedList<i> n = new LinkedList<>();
    private final List<i> o = new ArrayList();
    private final Object s = new Object();
    private volatile boolean v = false;
    private final e.b C = new e.b() { // from class: com.ss.android.socialbase.downloader.f.k.1
        private int b;

        @Override // com.ss.android.socialbase.downloader.h.e.b
        public long a() {
            if (k.this.f || k.this.g) {
                return -1L;
            }
            synchronized (k.this) {
                if (k.this.j == null && k.this.k == null) {
                    long j = k.this.w;
                    if (j <= 0) {
                        return -1L;
                    }
                    this.b++;
                    m a = k.this.a(false, System.currentTimeMillis(), j);
                    if (a == null) {
                        return j;
                    }
                    Log.i("SegmentDispatcher", "connectWatcher: switchUrl and reconnect");
                    k.this.c(a);
                    a.f();
                    return ((this.b / k.this.i.size()) + 1) * j;
                }
                return -1L;
            }
        }
    };
    private final e.b D = new e.b() { // from class: com.ss.android.socialbase.downloader.f.k.2
        @Override // com.ss.android.socialbase.downloader.h.e.b
        public long a() {
            return k.this.r();
        }
    };

    public k(@NonNull DownloadInfo downloadInfo, @NonNull n nVar, com.ss.android.socialbase.downloader.h.f fVar) {
        this.a = downloadInfo;
        this.b = nVar;
        b bVar = new b(nVar.d(), nVar.e());
        this.f862c = bVar;
        this.d = fVar;
        this.e = new g(downloadInfo, fVar, bVar);
        this.u = new com.ss.android.socialbase.downloader.h.e();
        this.t = new com.ss.android.socialbase.downloader.i.e();
        this.B = com.ss.android.socialbase.downloader.g.a.a(downloadInfo.getId()).b("debug") == 1;
    }

    private void h() {
        if (this.x > 0) {
            this.y = System.currentTimeMillis();
            this.u.a(this.D, 0L);
        }
    }

    private void i() {
        List<String> backUpUrls;
        int l = this.b.l();
        if (l <= 0) {
            this.l = false;
            e();
            return;
        }
        com.ss.android.socialbase.downloader.network.c a = com.ss.android.socialbase.downloader.network.c.a();
        a.a(this.a.getUrl(), this, 2000L);
        if (l <= 2 || (backUpUrls = this.a.getBackUpUrls()) == null) {
            return;
        }
        for (String str : backUpUrls) {
            if (!TextUtils.isEmpty(str)) {
                a.a(str, this, 2000L);
            }
        }
    }

    private q j() {
        q qVar;
        synchronized (this) {
            int size = this.p % this.i.size();
            if (this.b.b()) {
                this.p++;
            }
            qVar = this.i.get(size);
        }
        return qVar;
    }

    private void k() {
        com.ss.android.socialbase.downloader.c.a.c("SegmentDispatcher", "onComplete");
        this.f862c.c();
        synchronized (this.s) {
            this.s.notify();
        }
    }

    private boolean l() {
        Iterator<m> it = this.h.iterator();
        while (it.hasNext()) {
            if (!it.next().g()) {
                return false;
            }
        }
        return true;
    }

    private void m() {
        int size;
        if (this.m > 0 && (size = this.o.size()) > 1) {
            ArrayList<i> arrayList = null;
            int i = 0;
            for (int i2 = 1; i2 < size; i2++) {
                i iVar = this.o.get(i);
                i iVar2 = this.o.get(i2);
                if (iVar.e() > iVar2.c() && iVar2.a() <= 0 && iVar2.a == null) {
                    if (arrayList == null) {
                        arrayList = new ArrayList(1);
                    }
                    arrayList.add(iVar2);
                    if (this.B) {
                        Log.w("SegmentDispatcher", "clearCovered, covered = " + iVar2 + ", prev = " + iVar);
                    }
                } else if (iVar2.e() > iVar.e()) {
                    i++;
                }
            }
            if (arrayList != null) {
                for (i iVar3 : arrayList) {
                    this.o.remove(iVar3);
                    for (m mVar : this.h) {
                        if (mVar.a == iVar3) {
                            if (this.B) {
                                Log.w("SegmentDispatcher", "clearCoveredSegmentLocked: reconnect, segment = " + iVar3 + ", threadIndex = " + mVar.f864c);
                            }
                            mVar.a(true);
                        }
                    }
                }
            }
        }
    }

    private boolean n() {
        long j = this.m;
        if (j <= 0) {
            this.r = false;
            return false;
        }
        synchronized (this) {
            long a = o.a(this.o);
            com.ss.android.socialbase.downloader.c.a.c("SegmentDispatcher", "isAllContentDownloaded: firstOffset = ".concat(String.valueOf(a)));
            if (a >= j) {
                this.r = true;
                return true;
            }
            this.r = false;
            return false;
        }
    }

    private long o() {
        Iterator<m> it = this.h.iterator();
        long j = 0;
        while (it.hasNext()) {
            j += it.next().b();
        }
        return j;
    }

    private i p() {
        int i = 0;
        while (true) {
            i q = q();
            if (q == null) {
                return null;
            }
            m mVar = q.a;
            if (mVar == null) {
                return q;
            }
            if (q.j() >= 2) {
                return null;
            }
            long currentTimeMillis = System.currentTimeMillis();
            b(currentTimeMillis);
            if (currentTimeMillis - mVar.f > 2000 && a(mVar, currentTimeMillis - 2000, currentTimeMillis, 500L, 1.0d)) {
                if (this.B) {
                    Log.i("SegmentDispatcher", "obtainSegmentWhenNoNewSegment: isDownloadSpeedPoor segment = " + q + ", owner.threadIndex = " + mVar.f864c);
                }
                return q;
            }
            int i2 = i + 1;
            if (i > 2) {
                if (this.B) {
                    Log.i("SegmentDispatcher", "obtainSegmentWhenNoNewSegment: waitCount > 2, return segment = ".concat(String.valueOf(q)));
                }
                return q;
            }
            try {
                synchronized (this) {
                    wait(500L);
                }
                i = i2;
            } catch (InterruptedException unused) {
                return null;
            }
        }
    }

    private i q() {
        int j;
        i iVar = null;
        int i = Integer.MAX_VALUE;
        for (i iVar2 : this.o) {
            if (a(iVar2) > 0 && (j = iVar2.j()) < i) {
                iVar = iVar2;
                i = j;
            }
        }
        return iVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public long r() {
        if (this.f || this.g) {
            return -1L;
        }
        long currentTimeMillis = System.currentTimeMillis();
        synchronized (this) {
            b(currentTimeMillis);
            long k = this.b.k();
            if (k > 0) {
                long j = this.y;
                if (j > 0 && currentTimeMillis - j > k && a(currentTimeMillis, k)) {
                    this.y = currentTimeMillis;
                    this.A++;
                }
            }
        }
        return 2000L;
    }

    private void b(List<i> list) {
        long totalBytes = this.a.getTotalBytes();
        this.m = totalBytes;
        if (totalBytes <= 0) {
            this.m = this.a.getExpectFileLength();
            com.ss.android.socialbase.downloader.c.a.c("SegmentDispatcher", "initSegments: getExpectFileLength = " + this.m);
        }
        synchronized (this) {
            this.n.clear();
            if (list != null && !list.isEmpty()) {
                Iterator<i> it = list.iterator();
                while (it.hasNext()) {
                    a((List<i>) this.n, new i(it.next()), false);
                }
                d(this.n);
                c(this.n);
                com.ss.android.socialbase.downloader.c.a.c("SegmentDispatcher", "initSegments: totalLength = " + this.m);
            }
            a((List<i>) this.n, new i(0L, -1L), false);
            com.ss.android.socialbase.downloader.c.a.c("SegmentDispatcher", "initSegments: totalLength = " + this.m);
        }
    }

    private void c() {
        BaseException baseException;
        synchronized (this.s) {
            if (this.j == null && this.k == null) {
                this.s.wait();
            }
        }
        if (this.j == null && this.k == null && (baseException = this.q) != null) {
            throw baseException;
        }
    }

    private void d() {
        try {
            this.e.a((d) this.f862c);
        } catch (p unused) {
        } catch (BaseException e) {
            com.ss.android.socialbase.downloader.c.a.e("SegmentDispatcher", "dispatchSegments: loopAndWrite e = ".concat(String.valueOf(e)));
            a(e);
            throw e;
        }
        if (this.g || this.f) {
            return;
        }
        try {
            synchronized (this) {
                while (!this.n.isEmpty()) {
                    i poll = this.n.poll();
                    if (poll != null) {
                        a(this.o, poll, true);
                    }
                }
                c(this.o);
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
        if (this.v && this.q != null) {
            com.ss.android.socialbase.downloader.c.a.e("SegmentDispatcher", "dispatchSegments: loopAndWrite  failedException = " + this.q);
            throw this.q;
        }
        if (this.a.getCurBytes() != this.a.getTotalBytes()) {
            com.ss.android.socialbase.downloader.d.a.a(this.a, this.o);
        }
        com.ss.android.socialbase.downloader.c.a.c("SegmentDispatcher", "dispatchSegments::download finished");
    }

    private void e() {
        int i;
        if (this.m <= 0 || this.l) {
            i = 1;
        } else {
            i = this.b.a();
            int h = (int) (this.m / this.b.h());
            if (i > h) {
                i = h;
            }
        }
        com.ss.android.socialbase.downloader.c.a.c("SegmentDispatcher", "dispatchReadThread: totalLength = " + this.m + ", threadCount = " + i);
        int i2 = i > 0 ? i : 1;
        synchronized (this) {
            do {
                if (this.h.size() >= i2) {
                    break;
                }
                if (!this.g && !this.f) {
                    a(j());
                }
                return;
            } while (!this.b.f());
        }
    }

    private void f() {
        this.i.add(new q(this.a.getUrl(), true));
        List<String> backUpUrls = this.a.getBackUpUrls();
        if (backUpUrls != null) {
            for (String str : backUpUrls) {
                if (!TextUtils.isEmpty(str)) {
                    this.i.add(new q(str, false));
                }
            }
        }
        this.b.a(this.i.size());
    }

    private void g() {
        n nVar = this.b;
        this.w = nVar.j();
        this.x = nVar.k();
        this.z = nVar.o();
        int i = this.A;
        if (i > 0) {
            this.u.a(this.C, i);
        }
    }

    public boolean a(List<i> list) {
        try {
            f();
            b(list);
            e();
            g();
            i();
            long currentTimeMillis = System.currentTimeMillis();
            try {
                c();
                long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
                this.a.increaseAllConnectTime(currentTimeMillis2);
                this.a.setFirstSpeedTime(currentTimeMillis2);
                if (!this.g && !this.f) {
                    this.d.a(this.m);
                    h();
                    d();
                    return true;
                }
                if (!this.g && !this.f) {
                    com.ss.android.socialbase.downloader.c.a.c("SegmentDispatcher", "finally pause");
                    b();
                }
                this.u.b();
                return true;
            } catch (Throwable th) {
                long currentTimeMillis3 = System.currentTimeMillis() - currentTimeMillis;
                this.a.increaseAllConnectTime(currentTimeMillis3);
                this.a.setFirstSpeedTime(currentTimeMillis3);
                throw th;
            }
        } finally {
            if (!this.g && !this.f) {
                com.ss.android.socialbase.downloader.c.a.c("SegmentDispatcher", "finally pause");
                b();
            }
            this.u.b();
        }
    }

    private void c(List<i> list) {
        long b = o.b(list);
        com.ss.android.socialbase.downloader.c.a.c("SegmentDispatcher", "checkDownloadBytes: getCurBytes = " + this.a.getCurBytes() + ", totalBytes = " + this.a.getTotalBytes() + ", downloadedBytes = " + b);
        if (b > this.a.getTotalBytes() && this.a.getTotalBytes() > 0) {
            b = this.a.getTotalBytes();
        }
        if (this.a.getCurBytes() == this.a.getTotalBytes() || this.a.getCurBytes() == b) {
            return;
        }
        this.a.setCurBytes(b);
    }

    /* JADX WARN: Code restructure failed: missing block: B:27:0x0097, code lost:
    
        if ((r10.e() - r24.e()) < (r14 / 2)) goto L32;
     */
    /* JADX WARN: Removed duplicated region for block: B:32:0x00e8  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private void e(com.ss.android.socialbase.downloader.f.m r23, com.ss.android.socialbase.downloader.f.i r24) {
        /*
            Method dump skipped, instructions count: 644
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ss.android.socialbase.downloader.f.k.e(com.ss.android.socialbase.downloader.f.m, com.ss.android.socialbase.downloader.f.i):void");
    }

    private void b(String str, List<q> list) {
        int a;
        if (this.B) {
            Iterator<q> it = list.iterator();
            while (it.hasNext()) {
                Log.i("SegmentDispatcher", "addIpListLocked: urlRecord = ".concat(String.valueOf(it.next())));
            }
        }
        int l = this.b.l();
        if ((l == 1 || l == 3) && (a = a(str)) >= 0 && a < this.i.size()) {
            this.i.addAll(a + 1, list);
        } else {
            this.i.addAll(list);
        }
    }

    private List<q> c(String str, List<InetAddress> list) {
        boolean z;
        if (list != null && !list.isEmpty()) {
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            int i = 0;
            for (InetAddress inetAddress : list) {
                if (inetAddress != null) {
                    String hostAddress = inetAddress.getHostAddress();
                    if (!TextUtils.isEmpty(hostAddress)) {
                        if (this.B) {
                            Log.i("SegmentDispatcher", "onDnsResolved: ip = ".concat(String.valueOf(hostAddress)));
                        }
                        q qVar = new q(str, hostAddress);
                        LinkedList linkedList = (LinkedList) linkedHashMap.get(qVar.f865c);
                        if (linkedList == null) {
                            linkedList = new LinkedList();
                            linkedHashMap.put(qVar.f865c, linkedList);
                        }
                        linkedList.add(qVar);
                        i++;
                    }
                }
            }
            if (i > 0) {
                ArrayList arrayList = new ArrayList();
                do {
                    Iterator it = linkedHashMap.entrySet().iterator();
                    z = false;
                    while (it.hasNext()) {
                        LinkedList linkedList2 = (LinkedList) ((Map.Entry) it.next()).getValue();
                        if (linkedList2 != null && !linkedList2.isEmpty()) {
                            arrayList.add((q) linkedList2.pollFirst());
                            i--;
                            z = true;
                        }
                    }
                    if (i <= 0) {
                        break;
                    }
                } while (z);
                return arrayList;
            }
        }
        return null;
    }

    private void d(List<i> list) {
        i iVar = list.get(0);
        long c2 = iVar.c();
        if (c2 > 0) {
            i iVar2 = new i(0L, c2 - 1);
            Log.w("SegmentDispatcher", "fixSegmentsLocked: first = " + iVar + ", add new first = " + iVar2);
            a(list, iVar2, true);
        }
        Iterator<i> it = list.iterator();
        if (it.hasNext()) {
            i next = it.next();
            while (it.hasNext()) {
                i next2 = it.next();
                if (next.f() < next2.c() - 1) {
                    com.ss.android.socialbase.downloader.c.a.d("SegmentDispatcher", "fixSegment: segment = " + next + ", new end = " + (next2.c() - 1));
                    next.c(next2.c() - 1);
                }
                next = next2;
            }
        }
        i iVar3 = list.get(list.size() - 1);
        long totalBytes = this.a.getTotalBytes();
        if (totalBytes <= 0 || (iVar3.f() != -1 && iVar3.f() < totalBytes - 1)) {
            com.ss.android.socialbase.downloader.c.a.d("SegmentDispatcher", "fixSegment: last segment = " + iVar3 + ", new end=-1");
            iVar3.c(-1L);
        }
    }

    private i b(m mVar, q qVar) {
        while (!this.n.isEmpty()) {
            i poll = this.n.poll();
            if (poll != null) {
                a(this.o, poll, true);
                if (a(poll) > 0 || this.m <= 0) {
                    return poll;
                }
            }
        }
        m();
        i c2 = c(mVar, qVar);
        if (c2 != null && a(c2) > 0) {
            a(this.o, c2, true);
            return c2;
        }
        i p = p();
        if (p != null) {
            return p;
        }
        return null;
    }

    @Override // com.ss.android.socialbase.downloader.f.f
    public void b(m mVar, i iVar) {
        synchronized (this) {
            e(mVar, iVar);
        }
    }

    @Override // com.ss.android.socialbase.downloader.network.c.a
    public void a(String str, List<InetAddress> list) {
        if (this.g || this.f) {
            return;
        }
        List<q> list2 = null;
        try {
            list2 = c(str, list);
        } catch (Throwable th) {
            th.printStackTrace();
        }
        synchronized (this) {
            if (list2 != null) {
                b(str, list2);
            }
            this.l = false;
            this.b.a(this.i.size());
            Log.i("SegmentDispatcher", "onDnsResolved: dispatchReadThread");
            e();
        }
    }

    @Override // com.ss.android.socialbase.downloader.f.f
    public void b(m mVar) {
        com.ss.android.socialbase.downloader.c.a.c("SegmentDispatcher", "onReaderExit: threadIndex = " + mVar.f864c);
        synchronized (this) {
            mVar.c(true);
            this.h.remove(mVar);
            m();
            if (!this.h.isEmpty()) {
                if (n()) {
                    Log.i("SegmentDispatcher", "onReaderExit: allContentDownloaded");
                    Iterator<m> it = this.h.iterator();
                    while (it.hasNext()) {
                        it.next().e();
                    }
                }
            }
            k();
        }
    }

    @Override // com.ss.android.socialbase.downloader.f.f
    public void c(m mVar, i iVar) {
        synchronized (this) {
            if (iVar.a == mVar) {
                com.ss.android.socialbase.downloader.c.a.c("SegmentDispatcher", "unApplySegment ".concat(String.valueOf(iVar)));
                iVar.d(mVar.d());
                iVar.a = null;
                mVar.a();
            }
        }
    }

    @Override // com.ss.android.socialbase.downloader.f.f
    public e d(m mVar, i iVar) {
        e a;
        synchronized (this) {
            l lVar = new l(this.a, this.f862c, iVar);
            this.e.a(lVar);
            a = lVar.a();
        }
        return a;
    }

    private int a(String str) {
        int size = this.i.size();
        for (int i = 0; i < size; i++) {
            if (TextUtils.equals(this.i.get(i).a, str)) {
                return i;
            }
        }
        return -1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean c(m mVar) {
        synchronized (this) {
            q d = d(mVar);
            if (d == null) {
                return false;
            }
            return mVar.a(d);
        }
    }

    private q d(m mVar) {
        q qVar;
        Iterator<q> it = this.i.iterator();
        q qVar2 = null;
        while (true) {
            if (!it.hasNext()) {
                qVar = null;
                break;
            }
            qVar = it.next();
            if (qVar != mVar.b && !qVar.d()) {
                if (qVar2 == null) {
                    qVar2 = qVar;
                }
                if (qVar.a() <= 0) {
                    break;
                }
            }
        }
        if (this.b.b()) {
            if (qVar != null) {
                return qVar;
            }
            if (this.b.c()) {
                return null;
            }
        }
        return qVar2;
    }

    private void a(List<i> list, i iVar, boolean z) {
        long c2 = iVar.c();
        int size = list.size();
        int i = 0;
        while (i < size && c2 >= list.get(i).c()) {
            i++;
        }
        list.add(i, iVar);
        if (z) {
            iVar.a(size);
        }
    }

    private void b(m mVar, i iVar, q qVar, com.ss.android.socialbase.downloader.model.d dVar) {
        m mVar2 = iVar.a;
        if (mVar2 != null && mVar2 != mVar) {
            throw new j(1, "segment already has an owner");
        }
        if (mVar.h() == iVar.e()) {
            if (!dVar.b()) {
                if (iVar.e() <= 0) {
                    com.ss.android.socialbase.downloader.c.a.e("SegmentDispatcher", "parseHttpResponse: segment.getCurrentOffsetRead = " + iVar.e());
                    if (!dVar.a()) {
                        throw new com.ss.android.socialbase.downloader.exception.b(1004, dVar.f898c, "2: response code error : " + dVar.f898c + " segment=" + iVar);
                    }
                } else {
                    throw new com.ss.android.socialbase.downloader.exception.b(1004, dVar.f898c, "1: response code error : " + dVar.f898c + " segment=" + iVar);
                }
            }
            if (qVar.d) {
                if (this.j == null) {
                    this.j = dVar;
                    synchronized (this.s) {
                        this.s.notify();
                    }
                    com.ss.android.socialbase.downloader.h.f fVar = this.d;
                    if (fVar != null) {
                        fVar.a(qVar.a, dVar.b, iVar.e());
                    }
                    long j = dVar.j();
                    if (j > 0) {
                        for (i iVar2 : this.o) {
                            if (iVar2.f() <= 0 || iVar2.f() > j - 1) {
                                iVar2.c(j - 1);
                            }
                        }
                        return;
                    }
                    return;
                }
                return;
            }
            a(dVar);
            if (this.k == null) {
                this.k = dVar;
                if (this.a.getTotalBytes() <= 0) {
                    long j2 = dVar.j();
                    com.ss.android.socialbase.downloader.c.a.c("SegmentDispatcher", "checkSegmentHttpResponse:len=" + j2 + ",url=" + qVar.a);
                    this.a.setTotalBytes(j2);
                }
                synchronized (this.s) {
                    this.s.notify();
                }
                return;
            }
            return;
        }
        throw new j(5, "applySegment");
    }

    /* JADX WARN: Removed duplicated region for block: B:35:0x00b7  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private com.ss.android.socialbase.downloader.f.i c(com.ss.android.socialbase.downloader.f.m r28, com.ss.android.socialbase.downloader.f.q r29) {
        /*
            Method dump skipped, instructions count: 486
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ss.android.socialbase.downloader.f.k.c(com.ss.android.socialbase.downloader.f.m, com.ss.android.socialbase.downloader.f.q):com.ss.android.socialbase.downloader.f.i");
    }

    private float d(m mVar, q qVar) {
        long b = mVar.b();
        int size = this.h.size();
        if (size <= 1) {
            size = this.b.a();
        }
        float f = 1.0f;
        if (b <= 0) {
            float m = this.b.m();
            if (m <= com.sigmob.sdk.base.blurkit.c.d || m >= 1.0f) {
                m = 1.0f / size;
            }
            if (mVar.f864c == 0) {
                return m;
            }
            if (size > 1) {
                f = 1.0f - m;
                size--;
            }
        } else {
            long o = o();
            if (o > b) {
                return ((float) b) / ((float) o);
            }
        }
        return f / size;
    }

    private void a(q qVar) {
        m mVar = new m(this.a, this, this.f862c, qVar, this.h.size());
        this.h.add(mVar);
        mVar.a(com.ss.android.socialbase.downloader.downloader.c.q().submit(mVar));
    }

    @Override // com.ss.android.socialbase.downloader.f.f
    public void a(m mVar) {
        if (this.B) {
            com.ss.android.socialbase.downloader.c.a.c("SegmentDispatcher", "onReaderRun, threadIndex = " + mVar.f864c);
        }
    }

    @Override // com.ss.android.socialbase.downloader.f.f
    public i a(m mVar, q qVar) {
        if (this.f || this.g) {
            return null;
        }
        synchronized (this) {
            i b = b(mVar, qVar);
            if (b != null) {
                b.h();
                if (b.j() > 1) {
                    return new i(b);
                }
            }
            return b;
        }
    }

    @Override // com.ss.android.socialbase.downloader.f.f
    public void a(m mVar, i iVar) {
        synchronized (this) {
            iVar.i();
        }
    }

    @Override // com.ss.android.socialbase.downloader.f.f
    public void a(m mVar, i iVar, q qVar, com.ss.android.socialbase.downloader.model.d dVar) {
        synchronized (this) {
            if (!this.f && !this.g) {
                b(mVar, iVar, qVar, dVar);
                mVar.b(false);
                if (this.m <= 0) {
                    long totalBytes = this.a.getTotalBytes();
                    this.m = totalBytes;
                    if (totalBytes <= 0) {
                        this.m = dVar.j();
                    }
                    e();
                } else if (this.b.f()) {
                    e();
                }
            } else {
                throw new p("connected");
            }
        }
    }

    @Override // com.ss.android.socialbase.downloader.f.f
    public void a(m mVar, q qVar, i iVar, BaseException baseException, int i, int i2) {
        boolean b = com.ss.android.socialbase.downloader.i.f.b(baseException);
        int errorCode = baseException.getErrorCode();
        if (errorCode == 1047 || errorCode == 1074 || errorCode == 1055) {
            b = true;
        }
        if (b || i >= i2) {
            c(mVar);
        }
    }

    public void b() {
        com.ss.android.socialbase.downloader.c.a.c("SegmentDispatcher", "pause1");
        this.g = true;
        synchronized (this) {
            Iterator<m> it = this.h.iterator();
            while (it.hasNext()) {
                it.next().e();
            }
        }
        this.e.b();
        this.f862c.c();
    }

    @Override // com.ss.android.socialbase.downloader.f.f
    public void a(m mVar, q qVar, i iVar, BaseException baseException) {
        synchronized (this) {
            com.ss.android.socialbase.downloader.c.a.e("SegmentDispatcher", "onSegmentFailed: segment = " + iVar + ", e = " + baseException);
            mVar.b(true);
            if (mVar.f864c == 0) {
                this.q = baseException;
            }
            if (l()) {
                if (this.q == null) {
                    this.q = baseException;
                }
                this.v = true;
                a(this.q);
            }
        }
    }

    private void b(long j) {
        this.t.a(this.a.getCurBytes(), j);
        Iterator<m> it = this.h.iterator();
        while (it.hasNext()) {
            it.next().b(j);
        }
    }

    private void a(BaseException baseException) {
        com.ss.android.socialbase.downloader.c.a.e("SegmentDispatcher", "onError, e = ".concat(String.valueOf(baseException)));
        this.q = baseException;
        this.f862c.c();
        synchronized (this) {
            Iterator<m> it = this.h.iterator();
            while (it.hasNext()) {
                it.next().e();
            }
        }
    }

    private void a(com.ss.android.socialbase.downloader.model.d dVar) {
        com.ss.android.socialbase.downloader.model.d dVar2 = this.j;
        if (dVar2 == null && (dVar2 = this.k) == null) {
            return;
        }
        long j = dVar.j();
        long j2 = dVar2.j();
        if (j != j2) {
            String str = "total len not equals,len=" + j + ",sLen=" + j2 + ",code=" + dVar.f898c + ",sCode=" + dVar2.f898c + ",range=" + dVar.e() + ",sRange = " + dVar2.e() + ",url = " + dVar.a + ",sUrl=" + dVar2.a;
            com.ss.android.socialbase.downloader.c.a.e("SegmentDispatcher", str);
            if (j > 0 && j2 > 0) {
                throw new BaseException(1074, str);
            }
        }
        String c2 = dVar.c();
        String c3 = dVar2.c();
        if (TextUtils.equals(c2, c3)) {
            return;
        }
        String str2 = "etag not equals with main url, etag = " + c2 + ", mainEtag = " + c3;
        com.ss.android.socialbase.downloader.c.a.e("SegmentDispatcher", str2);
        if (!TextUtils.isEmpty(c2) && !TextUtils.isEmpty(c3) && !c2.equalsIgnoreCase(c3)) {
            throw new BaseException(1074, str2);
        }
    }

    public void a() {
        com.ss.android.socialbase.downloader.c.a.c("SegmentDispatcher", "cancel");
        this.f = true;
        synchronized (this) {
            Iterator<m> it = this.h.iterator();
            while (it.hasNext()) {
                it.next().e();
            }
        }
        this.e.a();
        this.f862c.c();
    }

    private int a(long j) {
        int size = this.o.size();
        for (int i = 0; i < size; i++) {
            i iVar = this.o.get(i);
            if (iVar.c() == j) {
                return i;
            }
            if (iVar.c() > j) {
                return -1;
            }
        }
        return -1;
    }

    private long a(int i, int i2) {
        i iVar = this.o.get(i);
        long a = a(iVar);
        int i3 = i + 1;
        i iVar2 = i3 < i2 ? this.o.get(i3) : null;
        if (iVar2 == null) {
            return a;
        }
        long c2 = iVar2.c() - iVar.e();
        return a == -1 ? c2 : Math.min(a, c2);
    }

    private long a(i iVar) {
        long b = iVar.b();
        if (b != -1) {
            return b;
        }
        long j = this.m;
        return j > 0 ? j - iVar.e() : b;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public m a(boolean z, long j, long j2) {
        m mVar = null;
        for (m mVar2 : this.h) {
            if (mVar2.f864c != 0 || z) {
                if (mVar2.d > 0 && mVar2.e <= 0 && j - mVar2.d > j2 && (mVar == null || mVar2.d < mVar.d)) {
                    mVar = mVar2;
                }
            }
        }
        return mVar;
    }

    private boolean a(m mVar, long j, long j2, long j3, double d) {
        if (mVar.f <= 0) {
            return false;
        }
        long b = this.t.b(j, j2);
        int size = this.h.size();
        long j4 = size > 0 ? b / size : b;
        long a = mVar.a(j, j2);
        if (a >= j3 && a >= j4 * d) {
            return false;
        }
        Log.i("SegmentDispatcher", "isDownloadSpeedPoor: totalSpeed = " + b + ", threadAvgSpeed = " + j4 + ", poorSpeed = " + j3 + ", speed = " + a + ",threadIndex = " + mVar.f864c);
        return true;
    }

    private boolean a(long j, long j2) {
        long j3 = j - j2;
        long b = this.t.b(j3, j);
        int size = this.h.size();
        if (size > 0) {
            b /= size;
        }
        m a = a(j3, j, Math.max(10.0f, ((float) b) * this.z), size / 2);
        if (a != null) {
            c(a);
            com.ss.android.socialbase.downloader.c.a.d("SegmentDispatcher", "handlePoorReadThread: reconnect for poor speed, threadIndex = " + a.f864c);
            a.f();
            return true;
        }
        m a2 = a(true, j, j2);
        if (a2 == null) {
            return false;
        }
        c(a2);
        com.ss.android.socialbase.downloader.c.a.d("SegmentDispatcher", "handlePoorReadThread: reconnect for connect timeout, threadIndex = " + a2.f864c);
        a2.f();
        return true;
    }

    private m a(long j, long j2, long j3, int i) {
        long j4;
        long j5 = Long.MAX_VALUE;
        int i2 = 0;
        m mVar = null;
        for (m mVar2 : this.h) {
            if (mVar2.f > 0) {
                i2++;
                long j6 = j5;
                if (mVar2.f < j) {
                    long a = mVar2.a(j, j2);
                    if (this.B) {
                        Log.i("SegmentDispatcher", "findPoorReadThread: speed = " + a + ", threadIndex = " + mVar2.f864c);
                        j4 = 0;
                    } else {
                        j4 = 0;
                    }
                    if (a >= j4 && a < j6) {
                        j5 = a;
                        mVar = mVar2;
                    }
                }
                j5 = j6;
            }
        }
        long j7 = j5;
        if (mVar == null || i2 < i || j7 >= j3) {
            return null;
        }
        com.ss.android.socialbase.downloader.c.a.c("SegmentDispatcher", "findPoorReadThread: ----------- minSpeed = " + j7 + ", threadIndex = " + mVar.f864c);
        return mVar;
    }
}
