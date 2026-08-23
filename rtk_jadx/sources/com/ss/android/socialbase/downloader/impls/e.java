package com.ss.android.socialbase.downloader.impls;

import com.ss.android.socialbase.downloader.constants.DownloadStatus;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import com.ss.android.socialbase.downloader.model.DownloadTask;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.ThreadPoolExecutor;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class e extends a {
    private static com.ss.android.socialbase.downloader.h.d b;

    public e() {
        b = new com.ss.android.socialbase.downloader.h.d();
    }

    public static void c(List<Callable<Object>> list) {
        ExecutorService q = com.ss.android.socialbase.downloader.downloader.c.q();
        if (q != null) {
            q.invokeAll(list);
        }
    }

    public static List<Future> d(List<Runnable> list) {
        ExecutorService q = com.ss.android.socialbase.downloader.downloader.c.q();
        ArrayList arrayList = new ArrayList(list.size());
        Iterator<Runnable> it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(q.submit(it.next()));
        }
        return arrayList;
    }

    public static Runnable e(List<Future> list) {
        BlockingQueue<Runnable> queue;
        Runnable runnable;
        if (list != null && !list.isEmpty()) {
            try {
                ExecutorService q = com.ss.android.socialbase.downloader.downloader.c.q();
                if ((q instanceof ThreadPoolExecutor) && (queue = ((ThreadPoolExecutor) q).getQueue()) != null && !queue.isEmpty()) {
                    Iterator<Future> it = list.iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            runnable = null;
                            break;
                        }
                        Future next = it.next();
                        if ((next instanceof Runnable) && queue.remove(next)) {
                            runnable = (Runnable) next;
                            break;
                        }
                    }
                    if (runnable != null) {
                        list.remove(runnable);
                        return runnable;
                    }
                }
            } catch (Throwable th) {
                com.ss.android.socialbase.downloader.c.a.d("DefaultDownloadEngine", "getUnstartedTask() error: " + th.toString());
            }
        }
        return null;
    }

    @Override // com.ss.android.socialbase.downloader.impls.a
    public boolean a(int i) {
        DownloadInfo d;
        com.ss.android.socialbase.downloader.h.d dVar = b;
        if (dVar == null || !dVar.a(i) || (d = d(i)) == null) {
            return false;
        }
        if (DownloadStatus.isDownloading(d.getStatus())) {
            return true;
        }
        b(i);
        return false;
    }

    @Override // com.ss.android.socialbase.downloader.impls.a
    public void b(int i) {
        com.ss.android.socialbase.downloader.h.d dVar = b;
        if (dVar == null) {
            return;
        }
        dVar.c(i);
    }

    @Override // com.ss.android.socialbase.downloader.impls.a
    protected com.ss.android.socialbase.downloader.h.c c(int i) {
        com.ss.android.socialbase.downloader.h.d dVar = b;
        if (dVar == null) {
            return null;
        }
        return dVar.b(i);
    }

    @Override // com.ss.android.socialbase.downloader.impls.a
    public void a(com.ss.android.socialbase.downloader.h.c cVar) {
        com.ss.android.socialbase.downloader.h.d dVar = b;
        if (dVar == null) {
            return;
        }
        dVar.b(cVar);
    }

    @Override // com.ss.android.socialbase.downloader.impls.a
    public void a(int i, DownloadTask downloadTask) {
        if (downloadTask == null) {
            return;
        }
        com.ss.android.socialbase.downloader.c.a.b("DownloadTask", "start doDownload for task : ".concat(String.valueOf(i)));
        b.a(new com.ss.android.socialbase.downloader.h.c(downloadTask, this.a));
    }

    @Override // com.ss.android.socialbase.downloader.impls.a
    public List<Integer> a() {
        return b.a();
    }

    @Override // com.ss.android.socialbase.downloader.impls.a
    public void a(int i, long j) {
        com.ss.android.socialbase.downloader.h.d dVar = b;
        if (dVar == null) {
            return;
        }
        dVar.a(i, j);
    }
}
