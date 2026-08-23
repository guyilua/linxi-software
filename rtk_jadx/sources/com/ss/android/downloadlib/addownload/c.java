package com.ss.android.downloadlib.addownload;

import com.ss.android.download.api.download.DownloadModel;
import com.ss.android.downloadad.api.download.AdDownloadModel;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class c {
    private static String a = "c";
    private static volatile c b;

    /* renamed from: c, reason: collision with root package name */
    private ConcurrentHashMap<Long, Runnable> f731c;

    public c() {
        this.f731c = null;
        this.f731c = new ConcurrentHashMap<>();
    }

    public static c a() {
        if (b == null) {
            synchronized (c.class) {
                if (b == null) {
                    b = new c();
                }
            }
        }
        return b;
    }

    public long b() {
        return k.j().optLong("quick_app_check_internal", 1200L);
    }

    public void a(e eVar, boolean z, int i, DownloadModel downloadModel) {
        if (downloadModel instanceof AdDownloadModel) {
            ((AdDownloadModel) downloadModel).setFunnelType(3);
        }
        long id = downloadModel.getId();
        if (i == 4) {
            if (!z) {
                a(id, false, 2);
                eVar.b(false);
                return;
            } else {
                a(id, true, 2);
                return;
            }
        }
        if (i == 5) {
            if (!z) {
                a(id, false, 1);
                eVar.c(false);
                return;
            } else {
                a(id, true, 1);
                return;
            }
        }
        if (i != 7) {
            return;
        }
        Runnable remove = this.f731c.remove(Long.valueOf(id));
        if (z) {
            com.ss.android.downloadlib.d.a.a().a(id, 1);
            a(id, true, 1);
        } else {
            if (remove != null) {
                com.ss.android.downloadlib.h.a().b().post(remove);
            }
            a(id, false, 1);
        }
    }

    private void a(long j, boolean z, int i) {
        com.ss.android.downloadlib.d.a.a().a(j, z, i);
        if (z) {
            k.v();
        }
    }

    public void a(final e eVar, final int i, final DownloadModel downloadModel) {
        com.ss.android.downloadlib.b.e.a().a(new com.ss.android.downloadlib.b.d() { // from class: com.ss.android.downloadlib.addownload.c.1
            @Override // com.ss.android.downloadlib.b.d
            public void a(boolean z) {
                c.this.a(eVar, z, i, downloadModel);
            }
        }, b());
    }

    public static boolean a(DownloadInfo downloadInfo) {
        return downloadInfo == null || downloadInfo.getStatus() == 0 || downloadInfo.getStatus() == -4;
    }
}
