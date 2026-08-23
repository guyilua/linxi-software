package com.ss.android.socialbase.downloader.impls;

import android.app.Notification;
import android.os.IBinder;
import android.os.RemoteException;
import com.ss.android.socialbase.downloader.depend.IDownloadFileUriProvider;
import com.ss.android.socialbase.downloader.depend.IDownloadListener;
import com.ss.android.socialbase.downloader.depend.ae;
import com.ss.android.socialbase.downloader.depend.aj;
import com.ss.android.socialbase.downloader.depend.z;
import com.ss.android.socialbase.downloader.downloader.Downloader;
import com.ss.android.socialbase.downloader.downloader.IndependentProcessDownloadService;
import com.ss.android.socialbase.downloader.downloader.i;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import com.ss.android.socialbase.downloader.model.DownloadTask;
import java.util.List;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class o implements com.ss.android.socialbase.downloader.downloader.m, com.ss.android.socialbase.downloader.downloader.n {
    private static final String a = "o";
    private volatile com.ss.android.socialbase.downloader.downloader.i b;

    /* renamed from: c, reason: collision with root package name */
    private com.ss.android.socialbase.downloader.downloader.o<IndependentProcessDownloadService> f890c;
    private com.ss.android.socialbase.downloader.downloader.m d = new p();

    public o() {
        com.ss.android.socialbase.downloader.downloader.o<IndependentProcessDownloadService> A = com.ss.android.socialbase.downloader.downloader.c.A();
        this.f890c = A;
        A.a(this);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.m
    public void a(int i) {
        if (this.b == null) {
            return;
        }
        try {
            this.b.a(i);
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.m
    public void b(DownloadInfo downloadInfo) {
    }

    @Override // com.ss.android.socialbase.downloader.downloader.m
    public boolean b(int i) {
        if (this.b == null) {
            return false;
        }
        try {
            return this.b.b(i);
        } catch (RemoteException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.m
    public void c(int i) {
        if (this.b == null) {
            return;
        }
        try {
            this.b.c(i);
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.m
    public void d(int i) {
        if (this.b == null) {
            return;
        }
        try {
            this.b.d(i);
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.m
    public long e(int i) {
        if (this.b == null) {
            return 0L;
        }
        try {
            return this.b.e(i);
        } catch (RemoteException e) {
            e.printStackTrace();
            return 0L;
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.m
    public int f(int i) {
        if (this.b == null) {
            return 0;
        }
        try {
            return this.b.f(i);
        } catch (RemoteException e) {
            e.printStackTrace();
            return 0;
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.m
    public boolean g(int i) {
        if (this.b == null) {
            return false;
        }
        try {
            return this.b.g(i);
        } catch (RemoteException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.m
    public DownloadInfo h(int i) {
        if (this.b == null) {
            return this.d.h(i);
        }
        try {
            return this.b.h(i);
        } catch (RemoteException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.m
    public List<com.ss.android.socialbase.downloader.model.b> i(int i) {
        if (this.b == null) {
            return this.d.i(i);
        }
        try {
            return this.b.i(i);
        } catch (RemoteException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.m
    public void j(int i) {
        if (this.b == null) {
            this.d.j(i);
            return;
        }
        try {
            this.b.j(i);
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.m
    public void k(int i) {
        com.ss.android.socialbase.downloader.downloader.o<IndependentProcessDownloadService> oVar = this.f890c;
        if (oVar != null) {
            oVar.a(i);
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.m
    public boolean l(int i) {
        if (this.b == null) {
            return false;
        }
        try {
            return this.b.k(i);
        } catch (RemoteException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.m
    public int m(int i) {
        if (this.b == null) {
            return com.ss.android.socialbase.downloader.downloader.d.a().b(i);
        }
        try {
            return this.b.m(i);
        } catch (RemoteException e) {
            e.printStackTrace();
            return -1;
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.m
    public boolean n(int i) {
        if (this.b == null) {
            return this.d.n(i);
        }
        try {
            return this.b.n(i);
        } catch (RemoteException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.m
    public void o(int i) {
        if (this.b == null) {
            this.d.o(i);
            return;
        }
        try {
            this.b.o(i);
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.m
    public boolean p(int i) {
        if (this.b == null) {
            return this.d.p(i);
        }
        try {
            return this.b.p(i);
        } catch (RemoteException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.m
    public z q(int i) {
        if (this.b == null) {
            return null;
        }
        try {
            return com.ss.android.socialbase.downloader.i.g.a(this.b.q(i));
        } catch (RemoteException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.m
    public ae r(int i) {
        if (this.b == null) {
            return null;
        }
        try {
            return com.ss.android.socialbase.downloader.i.g.a(this.b.r(i));
        } catch (RemoteException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.m
    public IDownloadFileUriProvider s(int i) {
        if (this.b == null) {
            return null;
        }
        try {
            return com.ss.android.socialbase.downloader.i.g.a(this.b.s(i));
        } catch (RemoteException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.m
    public void a(int i, boolean z) {
        if (this.b == null) {
            return;
        }
        try {
            this.b.a(i, z);
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.m
    public DownloadInfo b(String str, String str2) {
        return h(a(str, str2));
    }

    @Override // com.ss.android.socialbase.downloader.downloader.m
    public List<DownloadInfo> c(String str) {
        if (this.b == null) {
            return this.d.c(str);
        }
        try {
            return this.b.c(str);
        } catch (RemoteException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.m
    public List<DownloadInfo> d() {
        if (this.b == null) {
            return this.d.d();
        }
        try {
            return this.b.b();
        } catch (RemoteException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.m
    public List<DownloadInfo> e(String str) {
        if (this.b == null) {
            return null;
        }
        try {
            return this.b.d(str);
        } catch (RemoteException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.m
    public boolean f() {
        if (this.b == null) {
            return this.d.f();
        }
        try {
            return this.b.d();
        } catch (RemoteException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.m
    public void g() {
        if (this.b == null) {
            this.d.g();
            return;
        }
        try {
            this.b.e();
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.m
    public boolean h() {
        return this.b != null;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.n
    public void i() {
        this.b = null;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.m
    public List<DownloadInfo> b(String str) {
        if (this.b == null) {
            return this.d.b(str);
        }
        try {
            return this.b.b(str);
        } catch (RemoteException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.m
    public void a() {
        if (this.b == null) {
            return;
        }
        try {
            this.b.a();
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.m
    public void e() {
        com.ss.android.socialbase.downloader.downloader.o<IndependentProcessDownloadService> oVar = this.f890c;
        if (oVar != null) {
            oVar.f();
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.m
    public boolean c() {
        return com.ss.android.socialbase.downloader.downloader.c.P();
    }

    @Override // com.ss.android.socialbase.downloader.downloader.m
    public List<DownloadInfo> d(String str) {
        if (this.b == null) {
            return this.d.d(str);
        }
        try {
            return this.b.e(str);
        } catch (RemoteException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.m
    public void c(int i, boolean z) {
        if (this.b == null) {
            return;
        }
        try {
            this.b.d(i, z);
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.m
    public List<DownloadInfo> a(String str) {
        if (this.b == null) {
            return this.d.a(str);
        }
        try {
            return this.b.a(str);
        } catch (RemoteException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.m
    public void b(List<String> list) {
        if (this.b == null) {
            this.d.b(list);
            return;
        }
        try {
            this.b.b(list);
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.m
    public boolean c(DownloadInfo downloadInfo) {
        if (this.b == null) {
            return this.d.c(downloadInfo);
        }
        try {
            return this.b.b(downloadInfo);
        } catch (RemoteException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.m
    public int a(String str, String str2) {
        return com.ss.android.socialbase.downloader.downloader.c.a(str, str2);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.m
    public void b(int i, boolean z) {
        if (this.b == null) {
            this.d.b(i, z);
            return;
        }
        try {
            this.b.b(i, z);
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.m
    public void a(List<String> list) {
        if (this.b == null) {
            this.d.a(list);
            return;
        }
        try {
            this.b.a(list);
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.m
    public void b(int i, int i2, IDownloadListener iDownloadListener, com.ss.android.socialbase.downloader.constants.f fVar, boolean z) {
        if (this.b == null) {
            return;
        }
        try {
            this.b.a(i, i2, com.ss.android.socialbase.downloader.i.g.a(iDownloadListener, fVar != com.ss.android.socialbase.downloader.constants.f.SUB), fVar.ordinal(), z);
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.m
    public void a(int i, int i2, IDownloadListener iDownloadListener, com.ss.android.socialbase.downloader.constants.f fVar, boolean z) {
        if (this.b == null) {
            return;
        }
        try {
            this.b.b(i, i2, com.ss.android.socialbase.downloader.i.g.a(iDownloadListener, fVar != com.ss.android.socialbase.downloader.constants.f.SUB), fVar.ordinal(), z);
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.m
    public boolean b() {
        if (this.b == null) {
            com.ss.android.socialbase.downloader.c.a.d(a, "isServiceForeground, aidlService is null");
            return false;
        }
        com.ss.android.socialbase.downloader.c.a.c(a, "aidlService.isServiceForeground");
        try {
            return this.b.f();
        } catch (RemoteException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.m
    public void a(int i, int i2, IDownloadListener iDownloadListener, com.ss.android.socialbase.downloader.constants.f fVar, boolean z, boolean z2) {
        if (this.b == null) {
            return;
        }
        try {
            this.b.a(i, i2, com.ss.android.socialbase.downloader.i.g.a(iDownloadListener, fVar != com.ss.android.socialbase.downloader.constants.f.SUB), fVar.ordinal(), z, z2);
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.m
    public boolean a(DownloadInfo downloadInfo) {
        if (this.b == null) {
            return this.d.a(downloadInfo);
        }
        try {
            this.b.a(downloadInfo);
            return false;
        } catch (RemoteException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.m
    public void b(DownloadTask downloadTask) {
        com.ss.android.socialbase.downloader.downloader.o<IndependentProcessDownloadService> oVar;
        if (downloadTask == null || (oVar = this.f890c) == null) {
            return;
        }
        oVar.c(downloadTask);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.m
    public void b(int i, List<com.ss.android.socialbase.downloader.model.b> list) {
        if (this.b == null) {
            this.d.b(i, list);
            return;
        }
        try {
            this.b.a(i, list);
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.m
    public void a(int i, Notification notification) {
        if (this.b == null) {
            com.ss.android.socialbase.downloader.c.a.d(a, "startForeground, aidlService is null");
            return;
        }
        com.ss.android.socialbase.downloader.c.a.c(a, "aidlService.startForeground, id = ".concat(String.valueOf(i)));
        try {
            this.b.a(i, notification);
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.m
    public void a(boolean z, boolean z2) {
        if (this.b == null) {
            com.ss.android.socialbase.downloader.c.a.d(a, "stopForeground, aidlService is null");
            return;
        }
        com.ss.android.socialbase.downloader.c.a.c(a, "aidlService.stopForeground");
        try {
            this.b.a(z2);
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.m
    public void a(DownloadTask downloadTask) {
        com.ss.android.socialbase.downloader.downloader.o<IndependentProcessDownloadService> oVar;
        if (downloadTask == null || (oVar = this.f890c) == null) {
            return;
        }
        oVar.b(downloadTask);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.m
    public void a(int i, List<com.ss.android.socialbase.downloader.model.b> list) {
        if (this.b == null) {
            return;
        }
        try {
            this.b.b(i, list);
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.m
    public void a(com.ss.android.socialbase.downloader.model.b bVar) {
        if (this.b == null) {
            this.d.a(bVar);
            return;
        }
        try {
            this.b.a(bVar);
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.m
    public void a(int i, int i2, long j) {
        if (this.b == null) {
            this.d.a(i, i2, j);
            return;
        }
        try {
            this.b.a(i, i2, j);
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.m
    public void a(int i, int i2, int i3, long j) {
        if (this.b == null) {
            this.d.a(i, i2, i3, j);
            return;
        }
        try {
            this.b.a(i, i2, i3, j);
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.m
    public void a(int i, int i2, int i3, int i4) {
        if (this.b == null) {
            this.d.a(i, i2, i3, i4);
            return;
        }
        try {
            this.b.a(i, i2, i3, i4);
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.m
    public void a(aj ajVar) {
        if (this.b != null) {
            try {
                this.b.a(com.ss.android.socialbase.downloader.i.g.a(ajVar));
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.m
    public void a(int i, int i2) {
        if (this.b != null) {
            try {
                this.b.a(i, i2);
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.m
    public void a(int i, z zVar) {
        if (this.b != null) {
            try {
                this.b.a(i, com.ss.android.socialbase.downloader.i.g.a(zVar));
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.n
    public void a(IBinder iBinder) {
        this.b = i.a.a(iBinder);
        if (com.ss.android.socialbase.downloader.i.f.a()) {
            a(new aj() { // from class: com.ss.android.socialbase.downloader.impls.o.1
                @Override // com.ss.android.socialbase.downloader.depend.aj
                public void a(int i, int i2) {
                    if (i2 != 1) {
                        if (i2 == 2) {
                            Downloader.getInstance(com.ss.android.socialbase.downloader.downloader.c.O()).cancel(i);
                        }
                    } else {
                        Downloader.getInstance(com.ss.android.socialbase.downloader.downloader.c.O()).pause(i);
                        List<com.ss.android.socialbase.downloader.model.b> i3 = l.a(false).i(i);
                        if (i3 != null) {
                            l.a(true).a(i, com.ss.android.socialbase.downloader.i.f.a(i3));
                        }
                    }
                }
            });
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.m
    public void a(int i, long j) {
        if (this.b == null) {
            return;
        }
        try {
            this.b.a(i, j);
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }
}
