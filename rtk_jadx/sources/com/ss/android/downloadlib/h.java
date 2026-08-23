package com.ss.android.downloadlib;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import androidx.annotation.Nullable;
import com.ss.android.download.api.config.IDownloadButtonClickListener;
import com.ss.android.download.api.config.OnItemClickListener;
import com.ss.android.download.api.download.DownloadController;
import com.ss.android.download.api.download.DownloadEventConfig;
import com.ss.android.download.api.download.DownloadModel;
import com.ss.android.download.api.download.DownloadStatusChangeListener;
import com.ss.android.downloadad.api.download.AdDownloadModel;
import com.ss.android.downloadlib.addownload.k;
import com.ss.android.socialbase.downloader.exception.BaseException;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import java.lang.ref.SoftReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class h {
    private static volatile h a;
    private long f;

    /* renamed from: c, reason: collision with root package name */
    private final List<com.ss.android.downloadlib.addownload.g> f783c = new CopyOnWriteArrayList();
    private final Map<String, com.ss.android.downloadlib.addownload.g> d = new ConcurrentHashMap();
    private final CopyOnWriteArrayList<Object> e = new CopyOnWriteArrayList<>();
    private final Handler b = new Handler(Looper.getMainLooper());

    private h() {
    }

    private synchronized void b(Context context, int i, DownloadStatusChangeListener downloadStatusChangeListener, DownloadModel downloadModel) {
        if (this.f783c.size() <= 0) {
            c(context, i, downloadStatusChangeListener, downloadModel);
            return;
        }
        com.ss.android.downloadlib.addownload.g remove = this.f783c.remove(0);
        remove.b(context).b(i, downloadStatusChangeListener).b(downloadModel).a();
        this.d.put(downloadModel.getDownloadUrl(), remove);
    }

    private void c(Context context, int i, DownloadStatusChangeListener downloadStatusChangeListener, DownloadModel downloadModel) {
        if (downloadModel == null) {
            return;
        }
        com.ss.android.downloadlib.addownload.e eVar = new com.ss.android.downloadlib.addownload.e();
        eVar.b(context).b(i, downloadStatusChangeListener).b(downloadModel).a();
        this.d.put(downloadModel.getDownloadUrl(), eVar);
    }

    private void d() {
        long currentTimeMillis = System.currentTimeMillis();
        ArrayList arrayList = new ArrayList();
        for (com.ss.android.downloadlib.addownload.g gVar : this.f783c) {
            if (!gVar.b() && currentTimeMillis - gVar.d() > 300000) {
                gVar.h();
                arrayList.add(gVar);
            }
        }
        if (arrayList.isEmpty()) {
            return;
        }
        this.f783c.removeAll(arrayList);
    }

    public static h a() {
        if (a == null) {
            synchronized (h.class) {
                if (a == null) {
                    a = new h();
                }
            }
        }
        return a;
    }

    private void c() {
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - this.f < 300000) {
            return;
        }
        this.f = currentTimeMillis;
        if (this.f783c.isEmpty()) {
            return;
        }
        d();
    }

    public void a(Context context, int i, DownloadStatusChangeListener downloadStatusChangeListener, DownloadModel downloadModel) {
        com.ss.android.downloadlib.addownload.g gVar;
        if (downloadModel == null || TextUtils.isEmpty(downloadModel.getDownloadUrl())) {
            return;
        }
        boolean z = k.j().optInt("filter_download_url_key", 0) == 1;
        String a2 = com.ss.android.downloadlib.addownload.f.a().a(downloadModel.getDownloadUrl());
        if (z && !TextUtils.isEmpty(a2)) {
            gVar = this.d.get(a2);
            if (downloadModel instanceof AdDownloadModel) {
                AdDownloadModel adDownloadModel = (AdDownloadModel) downloadModel;
                if (TextUtils.isEmpty(adDownloadModel.getTaskKey())) {
                    adDownloadModel.setTaskKey(a2);
                }
            }
        } else {
            gVar = this.d.get(downloadModel.getDownloadUrl());
        }
        if (gVar != null) {
            gVar.b(context).b(i, downloadStatusChangeListener).b(downloadModel).a();
            return;
        }
        if (this.f783c.isEmpty()) {
            if (z) {
                if (!TextUtils.isEmpty(a2)) {
                    b(context, i, downloadStatusChangeListener, downloadModel, a2);
                    return;
                }
                String a3 = com.ss.android.downloadlib.addownload.f.a().a(downloadModel);
                if (!TextUtils.isEmpty(a3)) {
                    b(context, i, downloadStatusChangeListener, downloadModel, a3);
                    if (downloadModel instanceof AdDownloadModel) {
                        AdDownloadModel adDownloadModel2 = (AdDownloadModel) downloadModel;
                        if (TextUtils.isEmpty(adDownloadModel2.getTaskKey())) {
                            adDownloadModel2.setTaskKey(a3);
                            return;
                        }
                        return;
                    }
                    return;
                }
            }
            c(context, i, downloadStatusChangeListener, downloadModel);
            return;
        }
        if (z) {
            if (!TextUtils.isEmpty(a2)) {
                a(context, i, downloadStatusChangeListener, downloadModel, a2);
                return;
            }
            String a4 = com.ss.android.downloadlib.addownload.f.a().a(downloadModel);
            if (TextUtils.isEmpty(a4)) {
                b(context, i, downloadStatusChangeListener, downloadModel);
                return;
            }
            a(context, i, downloadStatusChangeListener, downloadModel, a4);
            if (downloadModel instanceof AdDownloadModel) {
                AdDownloadModel adDownloadModel3 = (AdDownloadModel) downloadModel;
                if (TextUtils.isEmpty(adDownloadModel3.getTaskKey())) {
                    adDownloadModel3.setTaskKey(a4);
                    return;
                }
                return;
            }
            return;
        }
        b(context, i, downloadStatusChangeListener, downloadModel);
    }

    private void b(Context context, int i, DownloadStatusChangeListener downloadStatusChangeListener, DownloadModel downloadModel, String str) {
        if (downloadModel == null) {
            return;
        }
        com.ss.android.downloadlib.addownload.e eVar = new com.ss.android.downloadlib.addownload.e();
        eVar.b(context).b(i, downloadStatusChangeListener).b(downloadModel).a(str).a();
        this.d.put(str, eVar);
        com.ss.android.downloadlib.addownload.f.a().a(str, downloadModel.getDownloadUrl());
    }

    public void b(final DownloadInfo downloadInfo, final String str) {
        this.b.post(new Runnable() { // from class: com.ss.android.downloadlib.h.4
            @Override // java.lang.Runnable
            public void run() {
                Iterator it = h.this.e.iterator();
                while (it.hasNext()) {
                    Object next = it.next();
                    if (next instanceof com.ss.android.download.api.download.a.a) {
                        ((com.ss.android.download.api.download.a.a) next).b(downloadInfo, str);
                    } else if (next instanceof SoftReference) {
                        SoftReference softReference = (SoftReference) next;
                        if (softReference.get() instanceof com.ss.android.download.api.download.a.a) {
                            ((com.ss.android.download.api.download.a.a) softReference.get()).b(downloadInfo, str);
                        }
                    }
                }
            }
        });
    }

    public Handler b() {
        return this.b;
    }

    public com.ss.android.downloadlib.addownload.e a(String str) {
        com.ss.android.downloadlib.addownload.g gVar;
        Map<String, com.ss.android.downloadlib.addownload.g> map = this.d;
        if (map != null && map.size() != 0 && !TextUtils.isEmpty(str)) {
            if (k.j().optInt("filter_download_url_key", 0) == 1) {
                gVar = this.d.get(com.ss.android.downloadlib.addownload.f.a().a(str));
            } else {
                gVar = this.d.get(str);
            }
            if (gVar instanceof com.ss.android.downloadlib.addownload.e) {
                return (com.ss.android.downloadlib.addownload.e) gVar;
            }
        }
        return null;
    }

    private synchronized void a(Context context, int i, DownloadStatusChangeListener downloadStatusChangeListener, DownloadModel downloadModel, String str) {
        if (this.f783c.size() <= 0) {
            b(context, i, downloadStatusChangeListener, downloadModel, str);
            return;
        }
        com.ss.android.downloadlib.addownload.g remove = this.f783c.remove(0);
        remove.b(context).b(i, downloadStatusChangeListener).b(downloadModel).a(str).a();
        this.d.put(str, remove);
        com.ss.android.downloadlib.addownload.f.a().a(str, downloadModel.getDownloadUrl());
    }

    public void a(String str, int i) {
        com.ss.android.downloadlib.addownload.g gVar;
        if (TextUtils.isEmpty(str)) {
            return;
        }
        boolean z = k.j().optInt("filter_download_url_key", 0) == 1;
        String a2 = com.ss.android.downloadlib.addownload.f.a().a(str);
        if (z && !TextUtils.isEmpty(a2)) {
            gVar = this.d.get(a2);
        } else {
            gVar = this.d.get(str);
        }
        if (gVar != null) {
            if (gVar.a(i)) {
                this.f783c.add(gVar);
                if (z && !TextUtils.isEmpty(a2)) {
                    this.d.remove(a2);
                    com.ss.android.downloadlib.addownload.f.a().b(a2);
                } else {
                    this.d.remove(str);
                }
            }
            c();
        }
    }

    public void a(String str, boolean z) {
        com.ss.android.downloadlib.addownload.g gVar;
        if (TextUtils.isEmpty(str)) {
            return;
        }
        boolean z2 = k.j().optInt("filter_download_url_key", 0) == 1;
        String a2 = com.ss.android.downloadlib.addownload.f.a().a(str);
        if (z2 && !TextUtils.isEmpty(a2)) {
            gVar = this.d.get(a2);
        } else {
            gVar = this.d.get(str);
        }
        if (gVar != null) {
            gVar.a(z);
        }
    }

    public void a(String str, long j, int i, DownloadEventConfig downloadEventConfig, DownloadController downloadController) {
        a(str, j, i, downloadEventConfig, downloadController, null, null);
    }

    public void a(String str, long j, int i, DownloadEventConfig downloadEventConfig, DownloadController downloadController, IDownloadButtonClickListener iDownloadButtonClickListener) {
        a(str, j, i, downloadEventConfig, downloadController, null, iDownloadButtonClickListener);
    }

    public void a(String str, long j, int i, DownloadEventConfig downloadEventConfig, DownloadController downloadController, OnItemClickListener onItemClickListener, IDownloadButtonClickListener iDownloadButtonClickListener) {
        com.ss.android.downloadlib.addownload.g gVar;
        if (TextUtils.isEmpty(str)) {
            return;
        }
        boolean z = k.j().optInt("filter_download_url_key", 0) == 1;
        String a2 = com.ss.android.downloadlib.addownload.f.a().a(str);
        if (z && !TextUtils.isEmpty(a2)) {
            gVar = this.d.get(a2);
        } else {
            gVar = this.d.get(str);
        }
        if (gVar != null) {
            gVar.a(j).b(downloadEventConfig).b(downloadController).a(onItemClickListener).a(iDownloadButtonClickListener).b(i);
        }
    }

    public void a(com.ss.android.download.api.download.a.a aVar) {
        if (aVar != null) {
            if (com.ss.android.socialbase.downloader.g.a.c().b("fix_listener_oom", false)) {
                this.e.add(new SoftReference(aVar));
            } else {
                this.e.add(aVar);
            }
        }
    }

    public void a(final DownloadModel downloadModel, @Nullable final DownloadController downloadController, @Nullable final DownloadEventConfig downloadEventConfig) {
        this.b.post(new Runnable() { // from class: com.ss.android.downloadlib.h.1
            @Override // java.lang.Runnable
            public void run() {
                Iterator it = h.this.e.iterator();
                while (it.hasNext()) {
                    Object next = it.next();
                    if (next instanceof com.ss.android.download.api.download.a.a) {
                        ((com.ss.android.download.api.download.a.a) next).a(downloadModel, downloadController, downloadEventConfig);
                    } else if (next instanceof SoftReference) {
                        SoftReference softReference = (SoftReference) next;
                        if (softReference.get() instanceof com.ss.android.download.api.download.a.a) {
                            ((com.ss.android.download.api.download.a.a) softReference.get()).a(downloadModel, downloadController, downloadEventConfig);
                        }
                    }
                }
            }
        });
    }

    public void a(final DownloadInfo downloadInfo, final BaseException baseException, final String str) {
        this.b.post(new Runnable() { // from class: com.ss.android.downloadlib.h.2
            @Override // java.lang.Runnable
            public void run() {
                Iterator it = h.this.e.iterator();
                while (it.hasNext()) {
                    Object next = it.next();
                    if (next instanceof com.ss.android.download.api.download.a.a) {
                        ((com.ss.android.download.api.download.a.a) next).a(downloadInfo, baseException, str);
                    } else if (next instanceof SoftReference) {
                        SoftReference softReference = (SoftReference) next;
                        if (softReference.get() instanceof com.ss.android.download.api.download.a.a) {
                            ((com.ss.android.download.api.download.a.a) softReference.get()).a(downloadInfo, baseException, str);
                        }
                    }
                }
            }
        });
    }

    public void a(final DownloadInfo downloadInfo, final String str) {
        this.b.post(new Runnable() { // from class: com.ss.android.downloadlib.h.3
            @Override // java.lang.Runnable
            public void run() {
                Iterator it = h.this.e.iterator();
                while (it.hasNext()) {
                    Object next = it.next();
                    if (next instanceof com.ss.android.download.api.download.a.a) {
                        ((com.ss.android.download.api.download.a.a) next).a(downloadInfo, str);
                    } else if (next instanceof SoftReference) {
                        SoftReference softReference = (SoftReference) next;
                        if (softReference.get() instanceof com.ss.android.download.api.download.a.a) {
                            ((com.ss.android.download.api.download.a.a) softReference.get()).a(downloadInfo, str);
                        }
                    }
                }
            }
        });
    }

    public void a(final DownloadInfo downloadInfo) {
        this.b.post(new Runnable() { // from class: com.ss.android.downloadlib.h.5
            @Override // java.lang.Runnable
            public void run() {
                Iterator it = h.this.e.iterator();
                while (it.hasNext()) {
                    Object next = it.next();
                    if (next instanceof com.ss.android.download.api.download.a.a) {
                        ((com.ss.android.download.api.download.a.a) next).a(downloadInfo);
                    } else if (next instanceof SoftReference) {
                        SoftReference softReference = (SoftReference) next;
                        if (softReference.get() instanceof com.ss.android.download.api.download.a.a) {
                            ((com.ss.android.download.api.download.a.a) softReference.get()).a(downloadInfo);
                        }
                    }
                }
            }
        });
    }
}
