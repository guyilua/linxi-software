package com.ss.android.downloadlib;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.ss.android.download.api.config.l;
import com.ss.android.download.api.config.q;
import com.ss.android.download.api.config.u;
import com.ss.android.downloadlib.addownload.k;
import com.ss.android.socialbase.appdownloader.DownloadHandlerService;
import com.ss.android.socialbase.downloader.a.a;
import com.ss.android.socialbase.downloader.depend.ae;
import com.ss.android.socialbase.downloader.downloader.Downloader;
import com.ss.android.socialbase.downloader.downloader.DownloaderBuilder;
import com.ss.android.socialbase.downloader.model.DownloadInfo;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: /tmp/rtk_apk/classes3.dex */
public class f implements com.ss.android.download.api.a {
    @Override // com.ss.android.download.api.a
    public com.ss.android.download.api.a a(@NonNull com.ss.android.download.api.config.i iVar) {
        k.a(iVar);
        return this;
    }

    @Override // com.ss.android.download.api.a
    public com.ss.android.download.api.a a(@NonNull com.ss.android.download.api.config.g gVar) {
        k.a(gVar);
        return this;
    }

    @Override // com.ss.android.download.api.a
    public com.ss.android.download.api.a a(@NonNull l lVar) {
        k.a(lVar);
        return this;
    }

    @Override // com.ss.android.download.api.a
    public com.ss.android.download.api.a a(@NonNull com.ss.android.download.api.config.h hVar) {
        k.a(hVar);
        return this;
    }

    @Override // com.ss.android.download.api.a
    public com.ss.android.download.api.a a(@NonNull com.ss.android.download.api.config.j jVar) {
        k.a(jVar);
        return this;
    }

    @Override // com.ss.android.download.api.a
    public com.ss.android.download.api.a a(@NonNull com.ss.android.download.api.model.a aVar) {
        k.a(aVar);
        return this;
    }

    @Override // com.ss.android.download.api.a
    public com.ss.android.download.api.a a(String str) {
        k.a(str);
        return this;
    }

    @Override // com.ss.android.download.api.a
    public com.ss.android.download.api.a a(@NonNull final com.ss.android.download.api.config.b bVar) {
        k.a(bVar);
        com.ss.android.socialbase.downloader.a.a.a().a(new a.c() { // from class: com.ss.android.downloadlib.f.1
        });
        return this;
    }

    @Override // com.ss.android.download.api.a
    public com.ss.android.download.api.a a(DownloaderBuilder downloaderBuilder) {
        if (downloaderBuilder.getNotificationClickCallback() == null) {
            downloaderBuilder.notificationClickCallback(new ae() { // from class: com.ss.android.downloadlib.f.2
                private boolean d(DownloadInfo downloadInfo) {
                    String a;
                    u t = k.t();
                    if (t == null) {
                        return false;
                    }
                    com.ss.android.downloadad.api.a.b a2 = com.ss.android.downloadlib.addownload.b.f.a().a(downloadInfo);
                    if (a2 != null && a2.c()) {
                        a = com.ss.android.socialbase.downloader.g.a.a(downloadInfo.getId()).a("ad_notification_jump_url", (String) null);
                    } else {
                        a = com.ss.android.downloadlib.addownload.i.a(downloadInfo);
                    }
                    if (TextUtils.isEmpty(a)) {
                        return false;
                    }
                    return t.a(k.a(), a);
                }

                @Override // com.ss.android.socialbase.downloader.depend.ae
                public boolean a(DownloadInfo downloadInfo) {
                    com.ss.android.socialbase.downloader.g.a a = com.ss.android.socialbase.downloader.g.a.a(downloadInfo.getId());
                    if (a.b("notification_opt_2") == 1) {
                        if (downloadInfo.getStatus() == -2) {
                            DownloadHandlerService.a(k.a(), downloadInfo, com.ss.android.socialbase.appdownloader.d.j().b(), Downloader.getInstance(k.a()).getDownloadNotificationEventListener(downloadInfo.getId()));
                        }
                        return true;
                    }
                    boolean d = d(downloadInfo);
                    if (a.a("disable_delete_dialog", 0) == 1) {
                        return true;
                    }
                    return d;
                }

                @Override // com.ss.android.socialbase.downloader.depend.ae
                public boolean b(DownloadInfo downloadInfo) {
                    return false;
                }

                @Override // com.ss.android.socialbase.downloader.depend.ae
                public boolean c(DownloadInfo downloadInfo) {
                    if (downloadInfo == null) {
                        return false;
                    }
                    com.ss.android.downloadad.api.a.b a = com.ss.android.downloadlib.addownload.b.f.a().a(downloadInfo);
                    if (a != null) {
                        com.ss.android.downloadlib.b.a.a(a);
                    } else {
                        com.ss.android.downloadlib.g.i.b(k.a(), downloadInfo.getPackageName());
                    }
                    com.ss.android.socialbase.downloader.notification.b.a().f(downloadInfo.getId());
                    return true;
                }
            });
        }
        downloaderBuilder.addDownloadCompleteHandler(new com.ss.android.downloadlib.c.c());
        Downloader.initOrCover(downloaderBuilder, true);
        return this;
    }

    @Override // com.ss.android.download.api.a
    public com.ss.android.download.api.a a(q qVar) {
        k.a(qVar);
        return this;
    }

    @Override // com.ss.android.download.api.a
    public void a() {
        if (!k.x()) {
            com.ss.android.downloadlib.e.c.a().a("ttdownloader init error");
        }
        k.a(com.ss.android.downloadlib.e.c.a());
        try {
            com.ss.android.socialbase.appdownloader.d.j().b(k.w());
        } catch (Exception e) {
            e.printStackTrace();
        }
        com.ss.android.socialbase.appdownloader.d.j().a(a.a());
        e.a().b(new Runnable() { // from class: com.ss.android.downloadlib.f.3
            @Override // java.lang.Runnable
            public void run() {
                com.ss.android.socialbase.appdownloader.f.e.a("");
                if (com.ss.android.socialbase.appdownloader.f.e.o()) {
                    com.ss.android.socialbase.downloader.downloader.c.a(true);
                }
                if (com.ss.android.socialbase.downloader.g.a.c().a("disable_security_init", 1) == 1) {
                    com.ss.android.socialbase.appdownloader.f.f.a(k.a());
                }
            }
        });
    }
}
