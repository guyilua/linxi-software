package com.ss.android.socialbase.downloader.h;

import android.util.SparseArray;
import com.ss.android.socialbase.downloader.exception.BaseException;
import com.ss.android.socialbase.downloader.model.DownloadTask;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class d {
    private static ExecutorService a = new ThreadPoolExecutor(2, 2, 60, TimeUnit.SECONDS, new LinkedBlockingQueue(), new a("Download_OP_Thread"));

    /* renamed from: c, reason: collision with root package name */
    private int f870c = 0;
    private volatile SparseArray<c> b = new SparseArray<>();

    public static void a(Runnable runnable) {
        a.execute(runnable);
    }

    private void b() {
        try {
            ArrayList arrayList = new ArrayList();
            for (int i = 0; i < this.b.size(); i++) {
                int keyAt = this.b.keyAt(i);
                if (!this.b.get(keyAt).d()) {
                    arrayList.add(Integer.valueOf(keyAt));
                }
            }
            for (int i2 = 0; i2 < arrayList.size(); i2++) {
                try {
                    Integer num = (Integer) arrayList.get(i2);
                    if (num != null) {
                        this.b.remove(num.intValue());
                    }
                } catch (Throwable th) {
                    th.printStackTrace();
                }
            }
        } catch (Throwable th2) {
            th2.printStackTrace();
        }
    }

    public void c(int i) {
        synchronized (d.class) {
            b();
            c cVar = this.b.get(i);
            if (cVar != null) {
                cVar.a();
                c(cVar);
                this.b.remove(i);
            }
        }
    }

    public void a(c cVar) {
        cVar.f();
        synchronized (d.class) {
            int i = this.f870c;
            if (i >= 500) {
                b();
                this.f870c = 0;
            } else {
                this.f870c = i + 1;
            }
            this.b.put(cVar.e(), cVar);
        }
        DownloadTask c2 = cVar.c();
        try {
            ExecutorService p = com.ss.android.socialbase.downloader.downloader.c.p();
            if (c2 != null && c2.getDownloadInfo() != null) {
                if ("mime_type_plg".equals(c2.getDownloadInfo().getMimeType()) && com.ss.android.socialbase.downloader.g.a.c().a("divide_plugin", 1) == 1) {
                    c2.getDownloadInfo().safePutToDBJsonData("executor_group", 3);
                }
                int executorGroup = c2.getDownloadInfo().getExecutorGroup();
                if (executorGroup == 3) {
                    p = com.ss.android.socialbase.downloader.downloader.c.n();
                } else if (executorGroup == 4) {
                    p = com.ss.android.socialbase.downloader.downloader.c.o();
                }
            }
            if (p != null) {
                if (com.ss.android.socialbase.downloader.g.a.a(cVar.e()).b("pause_with_interrupt", false)) {
                    cVar.a(p.submit(cVar));
                    return;
                } else {
                    p.execute(cVar);
                    return;
                }
            }
            com.ss.android.socialbase.downloader.d.a.a(c2.getMonitorDepend(), c2.getDownloadInfo(), new BaseException(1003, "execute failed cpu thread executor service is null"), c2.getDownloadInfo() != null ? c2.getDownloadInfo().getStatus() : 0);
        } catch (Exception e) {
            if (c2 != null) {
                com.ss.android.socialbase.downloader.d.a.a(c2.getMonitorDepend(), c2.getDownloadInfo(), new BaseException(1003, com.ss.android.socialbase.downloader.i.f.b(e, "DownloadThreadPoolExecute")), c2.getDownloadInfo() != null ? c2.getDownloadInfo().getStatus() : 0);
            }
            e.printStackTrace();
        } catch (OutOfMemoryError e2) {
            if (c2 != null) {
                com.ss.android.socialbase.downloader.d.a.a(c2.getMonitorDepend(), c2.getDownloadInfo(), new BaseException(1003, "execute OOM"), c2.getDownloadInfo() != null ? c2.getDownloadInfo().getStatus() : 0);
            }
            e2.printStackTrace();
        }
    }

    private void c(c cVar) {
        Future g;
        if (cVar == null) {
            return;
        }
        try {
            ExecutorService p = com.ss.android.socialbase.downloader.downloader.c.p();
            DownloadTask c2 = cVar.c();
            if (c2 != null && c2.getDownloadInfo() != null) {
                int executorGroup = c2.getDownloadInfo().getExecutorGroup();
                if (executorGroup == 3) {
                    p = com.ss.android.socialbase.downloader.downloader.c.n();
                } else if (executorGroup == 4) {
                    p = com.ss.android.socialbase.downloader.downloader.c.o();
                }
            }
            if (p == null || !(p instanceof ThreadPoolExecutor)) {
                return;
            }
            ((ThreadPoolExecutor) p).remove(cVar);
            if (!com.ss.android.socialbase.downloader.g.a.a(cVar.e()).b("pause_with_interrupt", false) || (g = cVar.g()) == null) {
                return;
            }
            g.cancel(true);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void b(c cVar) {
        if (cVar == null) {
            return;
        }
        synchronized (d.class) {
            try {
                if (com.ss.android.socialbase.downloader.i.a.a(524288)) {
                    int indexOfValue = this.b.indexOfValue(cVar);
                    if (indexOfValue >= 0) {
                        this.b.removeAt(indexOfValue);
                    }
                } else {
                    this.b.remove(cVar.e());
                }
            } finally {
            }
        }
    }

    public c b(int i) {
        synchronized (d.class) {
            b();
            c cVar = this.b.get(i);
            if (cVar == null) {
                return null;
            }
            cVar.b();
            c(cVar);
            this.b.remove(i);
            return cVar;
        }
    }

    public boolean a(int i) {
        synchronized (d.class) {
            boolean z = false;
            if (this.b != null && this.b.size() > 0) {
                c cVar = this.b.get(i);
                if (cVar != null && cVar.d()) {
                    z = true;
                }
                return z;
            }
            return false;
        }
    }

    public List<Integer> a() {
        ArrayList arrayList;
        synchronized (d.class) {
            b();
            arrayList = new ArrayList();
            for (int i = 0; i < this.b.size(); i++) {
                c cVar = this.b.get(this.b.keyAt(i));
                if (cVar != null) {
                    arrayList.add(Integer.valueOf(cVar.e()));
                }
            }
        }
        return arrayList;
    }

    public void a(int i, long j) {
        this.b.get(i);
    }
}
