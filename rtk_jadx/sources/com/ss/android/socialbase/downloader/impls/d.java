package com.ss.android.socialbase.downloader.impls;

import android.database.sqlite.SQLiteException;
import android.os.Build;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import android.util.SparseArray;
import com.ss.android.socialbase.downloader.downloader.c;
import com.ss.android.socialbase.downloader.downloader.t;
import com.ss.android.socialbase.downloader.exception.BaseException;
import com.ss.android.socialbase.downloader.h.h;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class d implements com.ss.android.socialbase.downloader.downloader.j {
    private t b;

    /* renamed from: c, reason: collision with root package name */
    private volatile boolean f884c;
    private volatile boolean d;
    private com.ss.android.socialbase.downloader.h.h f;
    private h.a e = new h.a() { // from class: com.ss.android.socialbase.downloader.impls.d.1
        @Override // com.ss.android.socialbase.downloader.h.h.a
        public void a(Message message) {
            if (message.what == 1) {
                com.ss.android.socialbase.downloader.downloader.c.l().execute(new Runnable() { // from class: com.ss.android.socialbase.downloader.impls.d.1.1
                    @Override // java.lang.Runnable
                    public void run() {
                        try {
                            d.this.i();
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                });
            }
        }
    };
    private final k a = new k();

    public d() {
        this.f = null;
        if (com.ss.android.socialbase.downloader.g.a.c().a("fix_sigbus_downloader_db")) {
            if (!com.ss.android.socialbase.downloader.i.f.a() && com.ss.android.socialbase.downloader.downloader.c.T()) {
                this.b = com.ss.android.socialbase.downloader.downloader.c.U().a(new c.a.InterfaceC0105a() { // from class: com.ss.android.socialbase.downloader.impls.d.2
                    @Override // com.ss.android.socialbase.downloader.downloader.c.a.InterfaceC0105a
                    public void a() {
                        d.this.b = new com.ss.android.socialbase.downloader.b.e();
                        Log.e("DefaultDownloadCache", "rebind error,use backup sqlDownloadCache");
                    }
                });
            } else {
                this.b = new com.ss.android.socialbase.downloader.b.e();
            }
        } else {
            this.b = new com.ss.android.socialbase.downloader.b.e();
        }
        this.f884c = false;
        this.f = new com.ss.android.socialbase.downloader.h.h(Looper.getMainLooper(), this.e);
        g();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j() {
        synchronized (this) {
            this.f884c = true;
            notifyAll();
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.j
    public List<DownloadInfo> c(String str) {
        return this.a.c(str);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.j
    public boolean d() {
        return this.f884c;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.j
    public boolean e() {
        if (this.f884c) {
            return true;
        }
        synchronized (this) {
            if (!this.f884c) {
                com.ss.android.socialbase.downloader.c.a.d("DefaultDownloadCache", "ensureDownloadCacheSyncSuccess: waiting start!!!!");
                try {
                    wait(5000L);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                com.ss.android.socialbase.downloader.c.a.d("DefaultDownloadCache", "ensureDownloadCacheSyncSuccess: waiting end!!!!");
            }
        }
        return this.f884c;
    }

    public t f() {
        return this.b;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.j
    public DownloadInfo g(int i) {
        DownloadInfo g = this.a.g(i);
        c(g);
        return g;
    }

    public void h() {
        long j;
        if (com.ss.android.socialbase.downloader.g.a.c().a("task_resume_delay")) {
            j = 4000;
        } else {
            j = Build.VERSION.SDK_INT >= 23 ? 1000L : 5000L;
        }
        this.f.sendMessageDelayed(this.f.obtainMessage(1), j);
    }

    public void i() {
        List<String> list;
        ArrayList arrayList;
        DownloadInfo downloadInfo;
        DownloadInfo downloadInfo2;
        if (this.f884c) {
            if (this.d) {
                com.ss.android.socialbase.downloader.c.a.b("DefaultDownloadCache", "resumeUnCompleteTask: has resumed, return!!!");
                return;
            }
            this.d = true;
            if (com.ss.android.socialbase.downloader.i.f.a()) {
                com.ss.android.socialbase.downloader.downloader.l x = com.ss.android.socialbase.downloader.downloader.c.x();
                if (x != null) {
                    list = x.a();
                    arrayList = (list == null || list.isEmpty()) ? null : new ArrayList();
                } else {
                    list = null;
                    arrayList = null;
                }
                SparseArray sparseArray = new SparseArray();
                synchronized (this) {
                    SparseArray<DownloadInfo> a = this.a.a();
                    for (int i = 0; i < a.size(); i++) {
                        int keyAt = a.keyAt(i);
                        if (keyAt != 0 && (downloadInfo2 = a.get(keyAt)) != null) {
                            sparseArray.put(keyAt, downloadInfo2);
                        }
                    }
                }
                if (sparseArray.size() == 0) {
                    return;
                }
                for (int i2 = 0; i2 < sparseArray.size(); i2++) {
                    int keyAt2 = sparseArray.keyAt(i2);
                    if (keyAt2 != 0 && (downloadInfo = (DownloadInfo) sparseArray.get(keyAt2)) != null) {
                        int realStatus = downloadInfo.getRealStatus();
                        int statusAtDbInit = downloadInfo.getStatusAtDbInit();
                        if (statusAtDbInit > 0 && statusAtDbInit <= 11) {
                            com.ss.android.socialbase.downloader.d.a.a(com.ss.android.socialbase.downloader.downloader.c.g(), downloadInfo, (BaseException) null, -5);
                        }
                        if (list != null && arrayList != null && downloadInfo.getMimeType() != null && list.contains(downloadInfo.getMimeType()) && (com.ss.android.socialbase.downloader.g.a.a(downloadInfo.getId()).b("enable_notification_ui") >= 2 || realStatus != -2 || downloadInfo.isPauseReserveOnWifi())) {
                            downloadInfo.setDownloadFromReserveWifi(false);
                            arrayList.add(downloadInfo);
                        }
                    }
                }
                if (x == null || arrayList == null || arrayList.isEmpty()) {
                    return;
                }
                x.a(arrayList, 1);
            }
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.j
    public Map<Long, com.ss.android.socialbase.downloader.f.i> l(int i) {
        Map<Long, com.ss.android.socialbase.downloader.f.i> l = this.a.l(i);
        if (l != null && !l.isEmpty()) {
            return l;
        }
        Map<Long, com.ss.android.socialbase.downloader.f.i> l2 = this.b.l(i);
        this.a.a(i, l2);
        return l2;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.j
    public void m(int i) {
        this.a.m(i);
        this.b.m(i);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.j
    public List<com.ss.android.socialbase.downloader.f.i> n(int i) {
        List<com.ss.android.socialbase.downloader.f.i> n = this.a.n(i);
        return (n == null || n.size() == 0) ? this.b.n(i) : n;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.j
    public DownloadInfo b(int i) {
        return this.a.b(i);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.j
    public List<com.ss.android.socialbase.downloader.model.b> c(int i) {
        return this.a.c(i);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.j
    public List<DownloadInfo> d(String str) {
        return this.a.d(str);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.j
    public boolean f(int i) {
        if (com.ss.android.socialbase.downloader.i.f.b()) {
            com.ss.android.socialbase.downloader.downloader.m a = l.a(true);
            if (a != null) {
                a.p(i);
            } else {
                this.b.f(i);
            }
        } else {
            this.b.f(i);
        }
        return this.a.f(i);
    }

    public k a() {
        return this.a;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.j
    public List<DownloadInfo> b(String str) {
        return this.a.b(str);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.j
    public void c() {
        try {
            this.a.c();
        } catch (SQLiteException e) {
            e.printStackTrace();
        }
        if (com.ss.android.socialbase.downloader.i.f.b()) {
            com.ss.android.socialbase.downloader.downloader.m a = l.a(true);
            if (a != null) {
                a.g();
                return;
            } else {
                this.b.c();
                return;
            }
        }
        this.b.c();
    }

    @Override // com.ss.android.socialbase.downloader.downloader.j
    public void d(int i) {
        this.a.d(i);
        if (com.ss.android.socialbase.downloader.i.f.b()) {
            com.ss.android.socialbase.downloader.downloader.m a = l.a(true);
            if (a != null) {
                a.o(i);
                return;
            } else {
                this.b.d(i);
                return;
            }
        }
        this.b.d(i);
    }

    public void g() {
        List<com.ss.android.socialbase.downloader.model.b> list;
        DownloadInfo downloadInfo;
        com.ss.android.socialbase.downloader.downloader.c.a(com.ss.android.socialbase.downloader.constants.d.SYNC_START);
        final SparseArray<DownloadInfo> sparseArray = new SparseArray<>();
        final SparseArray<List<com.ss.android.socialbase.downloader.model.b>> sparseArray2 = new SparseArray<>();
        synchronized (this.a) {
            SparseArray<DownloadInfo> a = this.a.a();
            for (int i = 0; i < a.size(); i++) {
                int keyAt = a.keyAt(i);
                if (keyAt != 0 && (downloadInfo = a.get(keyAt)) != null) {
                    sparseArray.put(keyAt, downloadInfo);
                }
            }
            SparseArray<List<com.ss.android.socialbase.downloader.model.b>> f = this.a.f();
            for (int i2 = 0; i2 < f.size(); i2++) {
                int keyAt2 = f.keyAt(i2);
                if (keyAt2 != 0 && (list = f.get(keyAt2)) != null) {
                    sparseArray2.put(keyAt2, new CopyOnWriteArrayList(list));
                }
            }
        }
        this.b.a(sparseArray, sparseArray2, new com.ss.android.socialbase.downloader.b.d() { // from class: com.ss.android.socialbase.downloader.impls.d.3
            @Override // com.ss.android.socialbase.downloader.b.d
            public void a() {
                synchronized (d.this.a) {
                    SparseArray<DownloadInfo> a2 = d.this.a.a();
                    if (sparseArray != null) {
                        for (int i3 = 0; i3 < sparseArray.size(); i3++) {
                            int keyAt3 = sparseArray.keyAt(i3);
                            if (keyAt3 != 0) {
                                a2.put(keyAt3, (DownloadInfo) sparseArray.get(keyAt3));
                            }
                        }
                    }
                    SparseArray<List<com.ss.android.socialbase.downloader.model.b>> f2 = d.this.a.f();
                    if (sparseArray2 != null) {
                        for (int i4 = 0; i4 < sparseArray2.size(); i4++) {
                            int keyAt4 = sparseArray2.keyAt(i4);
                            if (keyAt4 != 0) {
                                f2.put(keyAt4, (List) sparseArray2.get(keyAt4));
                            }
                        }
                    }
                }
                d.this.j();
                d.this.h();
                com.ss.android.socialbase.downloader.downloader.c.a(com.ss.android.socialbase.downloader.constants.d.SYNC_SUCCESS);
            }
        });
    }

    @Override // com.ss.android.socialbase.downloader.downloader.j
    public List<DownloadInfo> a(String str) {
        return this.a.a(str);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.j
    public List<DownloadInfo> b() {
        return this.a.b();
    }

    @Override // com.ss.android.socialbase.downloader.downloader.j
    public void a(com.ss.android.socialbase.downloader.model.b bVar) {
        synchronized (this.a) {
            this.a.a(bVar);
        }
        if (com.ss.android.socialbase.downloader.i.f.b()) {
            com.ss.android.socialbase.downloader.downloader.m a = l.a(true);
            if (a != null) {
                a.a(bVar);
                return;
            } else {
                this.b.a(bVar);
                return;
            }
        }
        this.b.a(bVar);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.j
    public void b(com.ss.android.socialbase.downloader.model.b bVar) {
        if (com.ss.android.socialbase.downloader.i.f.b()) {
            com.ss.android.socialbase.downloader.downloader.m a = l.a(true);
            if (a != null) {
                a.a(bVar);
                return;
            } else {
                this.b.a(bVar);
                return;
            }
        }
        this.b.a(bVar);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.j
    public DownloadInfo h(int i) {
        DownloadInfo h = this.a.h(i);
        c(h);
        return h;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.j
    public DownloadInfo j(int i) {
        DownloadInfo j = this.a.j(i);
        c(j);
        return j;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.j
    public DownloadInfo d(int i, long j) {
        DownloadInfo d = this.a.d(i, j);
        b(i, (List<com.ss.android.socialbase.downloader.model.b>) null);
        return d;
    }

    private void c(DownloadInfo downloadInfo) {
        a(downloadInfo, true);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.j
    public DownloadInfo b(int i, long j) {
        DownloadInfo b = this.a.b(i, j);
        b(i, (List<com.ss.android.socialbase.downloader.model.b>) null);
        return b;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.j
    public DownloadInfo c(int i, long j) {
        DownloadInfo c2 = this.a.c(i, j);
        b(i, (List<com.ss.android.socialbase.downloader.model.b>) null);
        return c2;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.j
    public boolean e(int i) {
        try {
            if (com.ss.android.socialbase.downloader.i.f.b()) {
                com.ss.android.socialbase.downloader.downloader.m a = l.a(true);
                if (a != null) {
                    a.n(i);
                } else {
                    this.b.e(i);
                }
            } else {
                this.b.e(i);
            }
        } catch (SQLiteException e) {
            e.printStackTrace();
        }
        return this.a.e(i);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.j
    public void b(DownloadInfo downloadInfo) {
        if (downloadInfo == null) {
            return;
        }
        this.a.a(downloadInfo);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.j
    public void b(int i, List<com.ss.android.socialbase.downloader.model.b> list) {
        try {
            a(this.a.b(i));
            if (list == null) {
                list = this.a.c(i);
            }
            if (com.ss.android.socialbase.downloader.i.f.b()) {
                com.ss.android.socialbase.downloader.downloader.m a = l.a(true);
                if (a != null) {
                    a.b(i, list);
                    return;
                } else {
                    this.b.b(i, list);
                    return;
                }
            }
            this.b.b(i, list);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.j
    public void a(int i, int i2, long j) {
        this.a.a(i, i2, j);
        if (com.ss.android.socialbase.downloader.i.f.b()) {
            com.ss.android.socialbase.downloader.downloader.m a = l.a(true);
            if (a != null) {
                a.a(i, i2, j);
                return;
            } else {
                this.b.a(i, i2, j);
                return;
            }
        }
        this.b.a(i, i2, j);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.j
    public void a(int i, int i2, int i3, long j) {
        if (com.ss.android.socialbase.downloader.i.f.b()) {
            com.ss.android.socialbase.downloader.downloader.m a = l.a(true);
            if (a != null) {
                a.a(i, i2, i3, j);
                return;
            } else {
                this.b.a(i, i2, i3, j);
                return;
            }
        }
        this.b.a(i, i2, i3, j);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.j
    public void a(int i, int i2, int i3, int i4) {
        if (com.ss.android.socialbase.downloader.i.f.b()) {
            com.ss.android.socialbase.downloader.downloader.m a = l.a(true);
            if (a != null) {
                a.a(i, i2, i3, i4);
                return;
            } else {
                this.b.a(i, i2, i3, i4);
                return;
            }
        }
        this.b.a(i, i2, i3, i4);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.j
    public DownloadInfo a(int i, int i2) {
        DownloadInfo a = this.a.a(i, i2);
        c(a);
        return a;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.j
    public boolean a(DownloadInfo downloadInfo) {
        if (downloadInfo == null) {
            return false;
        }
        boolean a = this.a.a(downloadInfo);
        c(downloadInfo);
        return a;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.j
    public DownloadInfo a(int i, long j, String str, String str2) {
        DownloadInfo a = this.a.a(i, j, str, str2);
        c(a);
        return a;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.j
    public DownloadInfo i(int i) {
        DownloadInfo i2 = this.a.i(i);
        c(i2);
        return i2;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.j
    public DownloadInfo a(int i, long j) {
        DownloadInfo a = this.a.a(i, j);
        a(a, false);
        return a;
    }

    private void a(DownloadInfo downloadInfo, boolean z) {
        if (downloadInfo == null) {
            return;
        }
        if (!com.ss.android.socialbase.downloader.i.f.b()) {
            this.b.a(downloadInfo);
            return;
        }
        if (z) {
            com.ss.android.socialbase.downloader.downloader.m a = l.a(true);
            if (a != null) {
                a.c(downloadInfo);
            } else {
                this.b.a(downloadInfo);
            }
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.j
    public void a(int i, List<com.ss.android.socialbase.downloader.model.b> list) {
        if (list == null || list.size() == 0) {
            return;
        }
        this.a.a(i, list);
        if (com.ss.android.socialbase.downloader.i.f.c()) {
            this.b.b(i, list);
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.j
    public boolean a(int i, Map<Long, com.ss.android.socialbase.downloader.f.i> map) {
        this.a.a(i, map);
        this.b.a(i, map);
        return false;
    }
}
