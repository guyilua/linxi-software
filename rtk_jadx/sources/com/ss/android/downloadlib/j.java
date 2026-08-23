package com.ss.android.downloadlib;

import android.content.Context;
import android.text.TextUtils;
import androidx.annotation.MainThread;
import com.ss.android.download.api.config.IDownloadButtonClickListener;
import com.ss.android.download.api.config.OnItemClickListener;
import com.ss.android.download.api.download.DownloadController;
import com.ss.android.download.api.download.DownloadEventConfig;
import com.ss.android.download.api.download.DownloadModel;
import com.ss.android.download.api.download.DownloadStatusChangeListener;
import com.ss.android.downloadlib.addownload.k;
import com.ss.android.downloadlib.addownload.m;
import com.ss.android.socialbase.downloader.downloader.Downloader;
import com.ss.android.socialbase.downloader.model.DownloadInfo;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class j {
    private static volatile j a;
    private final com.ss.android.download.api.a b;

    /* renamed from: c, reason: collision with root package name */
    private final h f788c;
    private final com.ss.android.downloadad.api.a d;
    private com.ss.android.downloadad.api.b e;
    private long f;

    /* JADX INFO: Access modifiers changed from: private */
    public h h() {
        return this.f788c;
    }

    public void c() {
        this.f = System.currentTimeMillis();
    }

    public com.ss.android.downloadad.api.a d() {
        return this.d;
    }

    public com.ss.android.downloadad.api.b e() {
        if (this.e == null) {
            this.e = b.a();
        }
        return this.e;
    }

    public String f() {
        return k.o();
    }

    public void g() {
        e.a().f();
    }

    private j(Context context) {
        this.f788c = h.a();
        this.b = new f();
        this.f = System.currentTimeMillis();
        b(context);
        this.d = a.a();
    }

    public static j a(final Context context) {
        if (a == null) {
            synchronized (j.class) {
                if (a == null) {
                    com.ss.android.downloadlib.e.b.a(new Runnable() { // from class: com.ss.android.downloadlib.j.1
                        @Override // java.lang.Runnable
                        public void run() {
                            j unused = j.a = new j(context);
                        }
                    });
                }
            }
        }
        return a;
    }

    private void b(Context context) {
        k.a(context);
        Downloader.getInstance(k.a());
        com.ss.android.downloadlib.addownload.b.f.a().b();
        com.ss.android.socialbase.appdownloader.d.j().a(k.a(), "misc_config", new com.ss.android.downloadlib.c.g(), new com.ss.android.downloadlib.c.f(context), new c());
        com.ss.android.downloadlib.c.d dVar = new com.ss.android.downloadlib.c.d();
        com.ss.android.socialbase.appdownloader.d.j().a(dVar);
        Downloader.getInstance(context).registerDownloadCacheSyncListener(dVar);
        com.ss.android.socialbase.appdownloader.d.j().a(new m());
        com.ss.android.socialbase.downloader.downloader.c.a(new com.ss.android.downloadlib.c.e());
        com.ss.android.socialbase.appdownloader.d.j().a(com.ss.android.downloadlib.f.c.a());
    }

    public com.ss.android.download.api.a a() {
        return this.b;
    }

    public com.ss.android.download.api.a a(String str) {
        com.ss.android.download.api.config.f b = g.a().b();
        if (b != null && b.a(str)) {
            return b.b(str);
        }
        return this.b;
    }

    public long b() {
        return this.f;
    }

    @MainThread
    public void a(final Context context, final int i, final DownloadStatusChangeListener downloadStatusChangeListener, final DownloadModel downloadModel) {
        com.ss.android.downloadlib.e.b.a(new Runnable() { // from class: com.ss.android.downloadlib.j.4
            @Override // java.lang.Runnable
            public void run() {
                j.this.h().a(context, i, downloadStatusChangeListener, downloadModel);
            }
        });
    }

    public DownloadInfo b(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return com.ss.android.socialbase.appdownloader.d.j().a(k.a(), str);
    }

    @MainThread
    public void a(final String str, final long j, final int i, final DownloadEventConfig downloadEventConfig, final DownloadController downloadController, final OnItemClickListener onItemClickListener, final IDownloadButtonClickListener iDownloadButtonClickListener) {
        com.ss.android.downloadlib.e.b.a(new Runnable() { // from class: com.ss.android.downloadlib.j.5
            @Override // java.lang.Runnable
            public void run() {
                j.this.h().a(str, j, i, downloadEventConfig, downloadController, onItemClickListener, iDownloadButtonClickListener);
            }
        });
    }

    @MainThread
    public void a(final String str, final long j, final int i, final DownloadEventConfig downloadEventConfig, final DownloadController downloadController) {
        com.ss.android.downloadlib.e.b.a(new Runnable() { // from class: com.ss.android.downloadlib.j.6
            @Override // java.lang.Runnable
            public void run() {
                j.this.h().a(str, j, i, downloadEventConfig, downloadController);
            }
        });
    }

    @MainThread
    public void a(final String str, final long j, final int i, final DownloadEventConfig downloadEventConfig, final DownloadController downloadController, final IDownloadButtonClickListener iDownloadButtonClickListener) {
        com.ss.android.downloadlib.e.b.a(new Runnable() { // from class: com.ss.android.downloadlib.j.7
            @Override // java.lang.Runnable
            public void run() {
                j.this.h().a(str, j, i, downloadEventConfig, downloadController, iDownloadButtonClickListener);
            }
        });
    }

    @MainThread
    public void a(final String str, final int i) {
        com.ss.android.downloadlib.e.b.a(new Runnable() { // from class: com.ss.android.downloadlib.j.2
            @Override // java.lang.Runnable
            public void run() {
                j.this.h().a(str, i);
            }
        });
    }

    @MainThread
    public void a(final String str, final boolean z) {
        com.ss.android.downloadlib.e.b.a(new Runnable() { // from class: com.ss.android.downloadlib.j.3
            @Override // java.lang.Runnable
            public void run() {
                j.this.h().a(str, z);
            }
        });
    }

    public void a(com.ss.android.download.api.download.a.a aVar) {
        h().a(aVar);
    }

    public DownloadInfo a(String str, String str2, boolean z) {
        if (TextUtils.isEmpty(str2) && z) {
            return b(str);
        }
        return Downloader.getInstance(k.a()).getDownloadInfo(str, str2);
    }
}
