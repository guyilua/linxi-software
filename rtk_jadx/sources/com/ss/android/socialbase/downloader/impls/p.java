package com.ss.android.socialbase.downloader.impls;

import android.app.Notification;
import com.ss.android.socialbase.downloader.depend.IDownloadFileUriProvider;
import com.ss.android.socialbase.downloader.depend.IDownloadListener;
import com.ss.android.socialbase.downloader.depend.ae;
import com.ss.android.socialbase.downloader.depend.aj;
import com.ss.android.socialbase.downloader.depend.z;
import com.ss.android.socialbase.downloader.exception.BaseException;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import com.ss.android.socialbase.downloader.model.DownloadTask;
import java.util.List;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class p implements com.ss.android.socialbase.downloader.downloader.m {
    private final a a;
    private final com.ss.android.socialbase.downloader.downloader.j b;

    /* renamed from: c, reason: collision with root package name */
    private final com.ss.android.socialbase.downloader.downloader.o f891c;
    private final boolean d;

    public p() {
        this(false);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.m
    public void a(int i) {
        a aVar = this.a;
        if (aVar != null) {
            aVar.e(i);
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.m
    public boolean b(int i) {
        a aVar = this.a;
        if (aVar != null) {
            return aVar.n(i);
        }
        return false;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.m
    public void c(int i) {
        a aVar = this.a;
        if (aVar != null) {
            aVar.f(i);
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.m
    public void d(int i) {
        a aVar = this.a;
        if (aVar != null) {
            aVar.g(i);
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.m
    public long e(int i) {
        DownloadInfo b;
        com.ss.android.socialbase.downloader.downloader.j jVar = this.b;
        if (jVar == null || (b = jVar.b(i)) == null) {
            return 0L;
        }
        int chunkCount = b.getChunkCount();
        if (chunkCount <= 1) {
            return b.getCurBytes();
        }
        List<com.ss.android.socialbase.downloader.model.b> c2 = this.b.c(i);
        if (c2 == null || c2.size() != chunkCount) {
            return 0L;
        }
        return com.ss.android.socialbase.downloader.i.f.b(c2);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.m
    public void e() {
    }

    @Override // com.ss.android.socialbase.downloader.downloader.m
    public int f(int i) {
        DownloadInfo d;
        a aVar = this.a;
        if (aVar == null || (d = aVar.d(i)) == null) {
            return 0;
        }
        return d.getStatus();
    }

    @Override // com.ss.android.socialbase.downloader.downloader.m
    public boolean g(int i) {
        a aVar = this.a;
        if (aVar != null) {
            return aVar.a(i);
        }
        return false;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.m
    public DownloadInfo h(int i) {
        a aVar = this.a;
        if (aVar != null) {
            return aVar.d(i);
        }
        return null;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.m
    public List<com.ss.android.socialbase.downloader.model.b> i(int i) {
        return this.b.c(i);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.m
    public void j(int i) {
        a aVar = this.a;
        if (aVar != null) {
            aVar.m(i);
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.m
    public void k(int i) {
        com.ss.android.socialbase.downloader.c.a.a(i);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.m
    public boolean l(int i) {
        a aVar = this.a;
        if (aVar != null) {
            return aVar.k(i);
        }
        return false;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.m
    public int m(int i) {
        return com.ss.android.socialbase.downloader.downloader.d.a().a(i);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.m
    public boolean n(int i) {
        return this.b.e(i);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.m
    public void o(int i) {
        this.b.d(i);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.m
    public boolean p(int i) {
        return this.b.f(i);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.m
    public z q(int i) {
        a aVar = this.a;
        if (aVar != null) {
            return aVar.i(i);
        }
        return null;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.m
    public ae r(int i) {
        a aVar = this.a;
        ae h = aVar != null ? aVar.h(i) : null;
        return h == null ? com.ss.android.socialbase.downloader.downloader.c.K() : h;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.m
    public IDownloadFileUriProvider s(int i) {
        a aVar = this.a;
        if (aVar != null) {
            return aVar.j(i);
        }
        return null;
    }

    public p(boolean z) {
        this.a = com.ss.android.socialbase.downloader.downloader.c.D();
        this.b = com.ss.android.socialbase.downloader.downloader.c.y();
        if (!z) {
            this.f891c = com.ss.android.socialbase.downloader.downloader.c.z();
        } else {
            this.f891c = com.ss.android.socialbase.downloader.downloader.c.A();
        }
        this.d = com.ss.android.socialbase.downloader.g.a.c().b("service_alive", false);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.m
    public void a(int i, boolean z) {
        a aVar = this.a;
        if (aVar != null) {
            aVar.a(i, z);
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.m
    public List<DownloadInfo> b(String str) {
        com.ss.android.socialbase.downloader.downloader.j jVar = this.b;
        if (jVar != null) {
            return jVar.b(str);
        }
        return null;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.m
    public List<DownloadInfo> c(String str) {
        com.ss.android.socialbase.downloader.downloader.j jVar = this.b;
        if (jVar != null) {
            return jVar.c(str);
        }
        return null;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.m
    public List<DownloadInfo> d() {
        com.ss.android.socialbase.downloader.downloader.j jVar = this.b;
        if (jVar != null) {
            return jVar.b();
        }
        return null;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.m
    public void g() {
        this.b.c();
    }

    @Override // com.ss.android.socialbase.downloader.downloader.m
    public boolean h() {
        com.ss.android.socialbase.downloader.downloader.o oVar;
        return this.d && (oVar = this.f891c) != null && oVar.a();
    }

    @Override // com.ss.android.socialbase.downloader.downloader.m
    public boolean f() {
        return this.b.d();
    }

    @Override // com.ss.android.socialbase.downloader.downloader.m
    public void a() {
        a aVar = this.a;
        if (aVar != null) {
            aVar.b();
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.m
    public void b(List<String> list) {
        a aVar = this.a;
        if (aVar != null) {
            aVar.b(list);
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.m
    public boolean c() {
        return com.ss.android.socialbase.downloader.downloader.c.P();
    }

    public void d(int i, boolean z) {
        a aVar = this.a;
        if (aVar != null) {
            aVar.c(i, z);
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.m
    public void c(int i, boolean z) {
        com.ss.android.socialbase.downloader.downloader.d.a().a(i, z);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.m
    public void a(List<String> list) {
        a aVar = this.a;
        if (aVar != null) {
            aVar.a(list);
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.m
    public DownloadInfo b(String str, String str2) {
        return h(com.ss.android.socialbase.downloader.downloader.c.a(str, str2));
    }

    @Override // com.ss.android.socialbase.downloader.downloader.m
    public boolean c(DownloadInfo downloadInfo) {
        return this.b.a(downloadInfo);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.m
    public List<DownloadInfo> d(String str) {
        com.ss.android.socialbase.downloader.downloader.j jVar = this.b;
        if (jVar != null) {
            return jVar.d(str);
        }
        return null;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.m
    public List<DownloadInfo> e(String str) {
        a aVar = this.a;
        if (aVar != null) {
            return aVar.b(str);
        }
        return null;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.m
    public List<DownloadInfo> a(String str) {
        a aVar = this.a;
        if (aVar != null) {
            return aVar.a(str);
        }
        return null;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.m
    public void b(int i, boolean z) {
        a aVar = this.a;
        if (aVar != null) {
            aVar.b(i, z);
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.m
    public int a(String str, String str2) {
        return com.ss.android.socialbase.downloader.downloader.c.a(str, str2);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.m
    public void b(int i, int i2, IDownloadListener iDownloadListener, com.ss.android.socialbase.downloader.constants.f fVar, boolean z) {
        a aVar = this.a;
        if (aVar != null) {
            aVar.a(i, i2, iDownloadListener, fVar, z);
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.m
    public void a(int i, int i2, IDownloadListener iDownloadListener, com.ss.android.socialbase.downloader.constants.f fVar, boolean z) {
        a aVar = this.a;
        if (aVar != null) {
            aVar.b(i, i2, iDownloadListener, fVar, z);
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.m
    public boolean b() {
        com.ss.android.socialbase.downloader.downloader.o oVar = this.f891c;
        if (oVar != null) {
            return oVar.b();
        }
        return false;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.m
    public void a(int i, int i2, IDownloadListener iDownloadListener, com.ss.android.socialbase.downloader.constants.f fVar, boolean z, boolean z2) {
        a aVar = this.a;
        if (aVar != null) {
            aVar.a(i, i2, iDownloadListener, fVar, z, z2);
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.m
    public void b(DownloadTask downloadTask) {
        com.ss.android.socialbase.downloader.downloader.o oVar = this.f891c;
        if (oVar != null) {
            oVar.c(downloadTask);
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.m
    public boolean a(DownloadInfo downloadInfo) {
        if (downloadInfo == null) {
            return false;
        }
        boolean a = com.ss.android.socialbase.downloader.i.f.a(downloadInfo.getStatus(), downloadInfo.getSavePath(), downloadInfo.getName());
        if (a) {
            if (com.ss.android.socialbase.downloader.i.a.a(33554432)) {
                b(downloadInfo.getId(), true);
            } else {
                d(downloadInfo.getId(), true);
            }
        }
        return a;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.m
    public void b(DownloadInfo downloadInfo) {
        this.b.b(downloadInfo);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.m
    public void b(int i, List<com.ss.android.socialbase.downloader.model.b> list) {
        this.b.b(i, list);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.m
    public void a(int i, Notification notification) {
        com.ss.android.socialbase.downloader.downloader.o oVar = this.f891c;
        if (oVar != null) {
            oVar.a(i, notification);
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.m
    public void a(boolean z, boolean z2) {
        com.ss.android.socialbase.downloader.downloader.o oVar = this.f891c;
        if (oVar != null) {
            oVar.a(z2);
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.m
    public void a(DownloadTask downloadTask) {
        com.ss.android.socialbase.downloader.downloader.o oVar = this.f891c;
        if (oVar != null) {
            oVar.b(downloadTask);
        } else if (downloadTask != null) {
            com.ss.android.socialbase.downloader.d.a.a(downloadTask.getMonitorDepend(), downloadTask.getDownloadInfo(), new BaseException(1003, "downloadServiceHandler is null"), downloadTask.getDownloadInfo() != null ? downloadTask.getDownloadInfo().getStatus() : 0);
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.m
    public void a(int i, List<com.ss.android.socialbase.downloader.model.b> list) {
        this.b.a(i, list);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.m
    public void a(com.ss.android.socialbase.downloader.model.b bVar) {
        this.b.a(bVar);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.m
    public void a(int i, int i2, long j) {
        this.b.a(i, i2, j);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.m
    public void a(int i, int i2, int i3, long j) {
        this.b.a(i, i2, i3, j);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.m
    public void a(int i, int i2, int i3, int i4) {
        this.b.a(i, i2, i3, i4);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.m
    public void a(aj ajVar) {
        com.ss.android.socialbase.downloader.downloader.c.a(ajVar);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.m
    public void a(int i, int i2) {
        if (com.ss.android.socialbase.downloader.downloader.c.e() != null) {
            for (aj ajVar : com.ss.android.socialbase.downloader.downloader.c.e()) {
                if (ajVar != null) {
                    ajVar.a(i2, i);
                }
            }
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.m
    public void a(int i, z zVar) {
        a aVar = this.a;
        if (aVar != null) {
            aVar.a(i, zVar);
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.m
    public void a(int i, long j) {
        a aVar = this.a;
        if (aVar != null) {
            aVar.b(i, j);
        }
    }
}
