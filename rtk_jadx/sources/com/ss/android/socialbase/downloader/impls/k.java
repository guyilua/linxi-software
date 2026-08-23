package com.ss.android.socialbase.downloader.impls;

import android.text.TextUtils;
import android.util.SparseArray;
import com.ss.android.socialbase.downloader.constants.DownloadStatus;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class k implements com.ss.android.socialbase.downloader.downloader.j {
    private final SparseArray<DownloadInfo> a = new SparseArray<>();
    private final SparseArray<List<com.ss.android.socialbase.downloader.model.b>> b = new SparseArray<>();

    /* renamed from: c, reason: collision with root package name */
    private final SparseArray<Map<Long, com.ss.android.socialbase.downloader.f.i>> f889c = new SparseArray<>();

    public SparseArray<DownloadInfo> a() {
        return this.a;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.j
    public void a(int i, int i2, int i3, int i4) {
    }

    @Override // com.ss.android.socialbase.downloader.downloader.j
    public synchronized DownloadInfo b(int i) {
        DownloadInfo downloadInfo;
        try {
            downloadInfo = this.a.get(i);
        } catch (Exception e) {
            e.printStackTrace();
            downloadInfo = null;
        }
        return downloadInfo;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.j
    public void b(int i, List<com.ss.android.socialbase.downloader.model.b> list) {
    }

    @Override // com.ss.android.socialbase.downloader.downloader.j
    public void b(com.ss.android.socialbase.downloader.model.b bVar) {
    }

    @Override // com.ss.android.socialbase.downloader.downloader.j
    public synchronized List<DownloadInfo> c(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        if (this.a.size() == 0) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < this.a.size(); i++) {
            DownloadInfo downloadInfo = this.a.get(this.a.keyAt(i));
            if (downloadInfo != null && !TextUtils.isEmpty(downloadInfo.getMimeType()) && downloadInfo.getMimeType().equals(str) && downloadInfo.getStatus() == -3) {
                arrayList.add(downloadInfo);
            }
        }
        return arrayList;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.j
    public synchronized List<DownloadInfo> d(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        if (this.a.size() == 0) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < this.a.size(); i++) {
            DownloadInfo downloadInfo = this.a.get(this.a.keyAt(i));
            if (downloadInfo != null && !TextUtils.isEmpty(downloadInfo.getMimeType()) && downloadInfo.getMimeType().equals(str) && DownloadStatus.isUnCompletedStatus(downloadInfo.getStatus())) {
                arrayList.add(downloadInfo);
            }
        }
        return arrayList;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.j
    public boolean d() {
        return false;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.j
    public boolean e() {
        return false;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.j
    public synchronized boolean e(int i) {
        this.a.remove(i);
        return true;
    }

    public SparseArray<List<com.ss.android.socialbase.downloader.model.b>> f() {
        return this.b;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.j
    public DownloadInfo g(int i) {
        DownloadInfo b = b(i);
        if (b != null) {
            b.setStatus(2);
        }
        return b;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.j
    public DownloadInfo h(int i) {
        DownloadInfo b = b(i);
        if (b != null) {
            b.setStatus(5);
            b.setFirstDownload(false);
        }
        return b;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.j
    public DownloadInfo i(int i) {
        DownloadInfo b = b(i);
        if (b != null) {
            b.setStatus(1);
        }
        return b;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.j
    public DownloadInfo j(int i) {
        DownloadInfo b = b(i);
        if (b != null) {
            b.setStatus(-7);
        }
        return b;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.j
    public synchronized Map<Long, com.ss.android.socialbase.downloader.f.i> l(int i) {
        return this.f889c.get(i);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.j
    public synchronized void m(int i) {
        this.f889c.remove(i);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.j
    public synchronized List<com.ss.android.socialbase.downloader.f.i> n(int i) {
        Map<Long, com.ss.android.socialbase.downloader.f.i> map = this.f889c.get(i);
        if (map != null && !map.isEmpty()) {
            return new ArrayList(map.values());
        }
        return null;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.j
    public synchronized List<DownloadInfo> a(String str) {
        ArrayList arrayList;
        arrayList = new ArrayList();
        try {
            int size = this.a.size();
            for (int i = 0; i < size; i++) {
                DownloadInfo valueAt = this.a.valueAt(i);
                if (str != null && str.equals(valueAt.getUrl())) {
                    arrayList.add(valueAt);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return arrayList;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.j
    public boolean f(int i) {
        e(i);
        d(i);
        m(i);
        return true;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.j
    public synchronized List<DownloadInfo> b(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        if (this.a.size() == 0) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < this.a.size(); i++) {
            DownloadInfo downloadInfo = this.a.get(this.a.keyAt(i));
            if (downloadInfo != null && !TextUtils.isEmpty(downloadInfo.getMimeType()) && downloadInfo.getMimeType().equals(str) && DownloadStatus.isFailedStatus(downloadInfo.getStatus())) {
                arrayList.add(downloadInfo);
            }
        }
        return arrayList;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.j
    public void a(com.ss.android.socialbase.downloader.model.b bVar) {
        int k = bVar.k();
        List<com.ss.android.socialbase.downloader.model.b> list = this.b.get(k);
        if (list == null) {
            list = new ArrayList<>();
            this.b.put(k, list);
        }
        list.add(bVar);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.j
    public synchronized void a(int i, int i2, long j) {
        List<com.ss.android.socialbase.downloader.model.b> c2 = c(i);
        if (c2 == null) {
            return;
        }
        for (com.ss.android.socialbase.downloader.model.b bVar : c2) {
            if (bVar != null && bVar.s() == i2) {
                bVar.b(j);
                return;
            }
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.j
    public synchronized List<com.ss.android.socialbase.downloader.model.b> c(int i) {
        return this.b.get(i);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.j
    public synchronized void d(int i) {
        this.b.remove(i);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.j
    public synchronized void c() {
        this.a.clear();
        this.b.clear();
    }

    @Override // com.ss.android.socialbase.downloader.downloader.j
    public DownloadInfo d(int i, long j) {
        DownloadInfo b = b(i);
        if (b != null) {
            b.setCurBytes(j, false);
            b.setStatus(-2);
        }
        return b;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.j
    public synchronized List<DownloadInfo> b() {
        if (this.a.size() == 0) {
            return null;
        }
        ArrayList arrayList = new ArrayList(this.a.size());
        for (int i = 0; i < this.a.size(); i++) {
            DownloadInfo valueAt = this.a.valueAt(i);
            if (valueAt != null) {
                arrayList.add(valueAt);
            }
        }
        return arrayList;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.j
    public DownloadInfo c(int i, long j) {
        DownloadInfo b = b(i);
        if (b != null) {
            b.setCurBytes(j, false);
            b.setStatus(-3);
            b.setFirstDownload(false);
            b.setFirstSuccess(false);
        }
        return b;
    }

    /* JADX WARN: Code restructure failed: missing block: B:21:0x002b, code lost:
    
        if (r0.g() == null) goto L30;
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x002d, code lost:
    
        r3 = r0.g().iterator();
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x0039, code lost:
    
        if (r3.hasNext() == false) goto L46;
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x003b, code lost:
    
        r5 = r3.next();
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x0041, code lost:
    
        if (r5 == null) goto L49;
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x0047, code lost:
    
        if (r5.s() != r4) goto L50;
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x0049, code lost:
    
        r5.b(r6);
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x004d, code lost:
    
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:40:0x004f, code lost:
    
        return;
     */
    @Override // com.ss.android.socialbase.downloader.downloader.j
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public synchronized void a(int r3, int r4, int r5, long r6) {
        /*
            r2 = this;
            monitor-enter(r2)
            java.util.List r3 = r2.c(r3)     // Catch: java.lang.Throwable -> L52
            if (r3 != 0) goto L9
            monitor-exit(r2)
            return
        L9:
            java.util.Iterator r3 = r3.iterator()     // Catch: java.lang.Throwable -> L52
        Ld:
            boolean r0 = r3.hasNext()     // Catch: java.lang.Throwable -> L52
            if (r0 == 0) goto L50
            java.lang.Object r0 = r3.next()     // Catch: java.lang.Throwable -> L52
            com.ss.android.socialbase.downloader.model.b r0 = (com.ss.android.socialbase.downloader.model.b) r0     // Catch: java.lang.Throwable -> L52
            if (r0 == 0) goto Ld
            int r1 = r0.s()     // Catch: java.lang.Throwable -> L52
            if (r1 != r5) goto Ld
            boolean r1 = r0.f()     // Catch: java.lang.Throwable -> L52
            if (r1 != 0) goto Ld
            java.util.List r3 = r0.g()     // Catch: java.lang.Throwable -> L52
            if (r3 == 0) goto L50
            java.util.List r3 = r0.g()     // Catch: java.lang.Throwable -> L52
            java.util.Iterator r3 = r3.iterator()     // Catch: java.lang.Throwable -> L52
        L35:
            boolean r5 = r3.hasNext()     // Catch: java.lang.Throwable -> L52
            if (r5 == 0) goto L4e
            java.lang.Object r5 = r3.next()     // Catch: java.lang.Throwable -> L52
            com.ss.android.socialbase.downloader.model.b r5 = (com.ss.android.socialbase.downloader.model.b) r5     // Catch: java.lang.Throwable -> L52
            if (r5 == 0) goto L35
            int r0 = r5.s()     // Catch: java.lang.Throwable -> L52
            if (r0 != r4) goto L35
            r5.b(r6)     // Catch: java.lang.Throwable -> L52
            monitor-exit(r2)
            return
        L4e:
            monitor-exit(r2)
            return
        L50:
            monitor-exit(r2)
            return
        L52:
            r3 = move-exception
            monitor-exit(r2)
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ss.android.socialbase.downloader.impls.k.a(int, int, int, long):void");
    }

    @Override // com.ss.android.socialbase.downloader.downloader.j
    public DownloadInfo b(int i, long j) {
        DownloadInfo b = b(i);
        if (b != null) {
            b.setCurBytes(j, false);
            b.setStatus(-1);
            b.setFirstDownload(false);
        }
        return b;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.j
    public void b(DownloadInfo downloadInfo) {
        a(downloadInfo);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.j
    public synchronized DownloadInfo a(int i, int i2) {
        DownloadInfo b;
        b = b(i);
        if (b != null) {
            b.setChunkCount(i2);
        }
        return b;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.j
    public synchronized boolean a(DownloadInfo downloadInfo) {
        boolean z = true;
        if (downloadInfo == null) {
            return true;
        }
        if (this.a.get(downloadInfo.getId()) == null) {
            z = false;
        }
        this.a.put(downloadInfo.getId(), downloadInfo);
        return z;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.j
    public DownloadInfo a(int i, long j, String str, String str2) {
        DownloadInfo b = b(i);
        if (b != null) {
            b.setTotalBytes(j);
            b.seteTag(str);
            if (TextUtils.isEmpty(b.getName()) && !TextUtils.isEmpty(str2)) {
                b.setName(str2);
            }
            b.setStatus(3);
        }
        return b;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.j
    public DownloadInfo a(int i, long j) {
        DownloadInfo b = b(i);
        if (b != null) {
            b.setCurBytes(j, false);
            if (b.getStatus() != -3 && b.getStatus() != -2 && !DownloadStatus.isFailedStatus(b.getStatus()) && b.getStatus() != -4) {
                b.setStatus(4);
            }
        }
        return b;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.j
    public synchronized void a(int i, List<com.ss.android.socialbase.downloader.model.b> list) {
        if (list == null) {
            return;
        }
        d(i);
        for (com.ss.android.socialbase.downloader.model.b bVar : list) {
            if (bVar != null) {
                a(bVar);
                if (bVar.f()) {
                    Iterator<com.ss.android.socialbase.downloader.model.b> it = bVar.g().iterator();
                    while (it.hasNext()) {
                        a(it.next());
                    }
                }
            }
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.j
    public synchronized boolean a(int i, Map<Long, com.ss.android.socialbase.downloader.f.i> map) {
        this.f889c.put(i, map);
        return false;
    }
}
