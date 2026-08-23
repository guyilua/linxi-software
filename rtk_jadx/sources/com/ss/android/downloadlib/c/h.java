package com.ss.android.downloadlib.c;

import androidx.annotation.NonNull;
import com.ss.android.downloadlib.addownload.k;
import com.ss.android.downloadlib.g.m;
import com.ss.android.socialbase.downloader.downloader.Downloader;
import com.ss.android.socialbase.downloader.exception.BaseException;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import org.json.JSONObject;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class h {

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: /tmp/rtk_apk/classes3.dex */
    public static class a {
        private static h a = new h();
    }

    public void b(com.ss.android.downloadad.api.a.b bVar) {
        if (bVar == null) {
            return;
        }
        b(bVar, com.ss.android.socialbase.downloader.g.a.a(bVar.s()).a("noti_continue_delay_secs", 5));
    }

    public void c(@NonNull com.ss.android.downloadad.api.a.b bVar) {
        c(bVar, 5L);
    }

    public void d(@NonNull com.ss.android.downloadad.api.a.b bVar) {
        c(bVar, com.ss.android.socialbase.downloader.g.a.a(bVar.s()).a("noti_install_delay_secs", 5));
    }

    public void e(@NonNull com.ss.android.downloadad.api.a.b bVar) {
        a(bVar, 5L);
    }

    public void f(@NonNull com.ss.android.downloadad.api.a.b bVar) {
        a(bVar, com.ss.android.socialbase.downloader.g.a.a(bVar.s()).a("noti_open_delay_secs", 5));
    }

    private h() {
    }

    public static h a() {
        return a.a;
    }

    private void b(@NonNull final com.ss.android.downloadad.api.a.b bVar, long j) {
        final int s = bVar.s();
        if (com.ss.android.socialbase.downloader.g.a.a(s).b("notification_opt_2") != 1) {
            return;
        }
        a(s);
        com.ss.android.downloadlib.e.a().a(new Runnable() { // from class: com.ss.android.downloadlib.c.h.1
            @Override // java.lang.Runnable
            public void run() {
                DownloadInfo downloadInfo = Downloader.getInstance(k.a()).getDownloadInfo(s);
                JSONObject jSONObject = new JSONObject();
                m.a(jSONObject, "ttdownloader_type", (Object) 1);
                com.ss.android.downloadlib.g.f.c(downloadInfo, jSONObject);
                if (downloadInfo != null && -2 == downloadInfo.getRealStatus() && !downloadInfo.isPauseReserveOnWifi()) {
                    h.this.a(s, bVar, jSONObject);
                } else {
                    m.a(jSONObject, "error_code", (Object) 1001);
                }
                com.ss.android.downloadlib.d.a.a().b("download_notification_try_show", jSONObject, bVar);
            }
        }, j * 1000);
    }

    private void c(@NonNull final com.ss.android.downloadad.api.a.b bVar, long j) {
        final int s = bVar.s();
        if (com.ss.android.socialbase.downloader.g.a.a(s).b("notification_opt_2") != 1) {
            return;
        }
        a(s);
        com.ss.android.downloadlib.e.a().a(new Runnable() { // from class: com.ss.android.downloadlib.c.h.2
            @Override // java.lang.Runnable
            public void run() {
                DownloadInfo downloadInfo = Downloader.getInstance(k.a()).getDownloadInfo(s);
                JSONObject jSONObject = new JSONObject();
                m.a(jSONObject, "ttdownloader_type", (Object) 2);
                com.ss.android.downloadlib.g.f.c(downloadInfo, jSONObject);
                if (!m.b(bVar)) {
                    h.this.a(s, bVar, jSONObject);
                } else {
                    m.a(jSONObject, "error_code", (Object) 1002);
                }
                com.ss.android.downloadlib.d.a.a().b("download_notification_try_show", jSONObject, bVar);
            }
        }, j * 1000);
    }

    public void a(com.ss.android.downloadad.api.a.b bVar) {
        b(bVar, 5L);
    }

    public void a(@NonNull final com.ss.android.downloadad.api.a.b bVar, long j) {
        final int s = bVar.s();
        if (com.ss.android.socialbase.downloader.g.a.a(s).b("notification_opt_2") != 1) {
            return;
        }
        a(s);
        com.ss.android.downloadlib.e.a().a(new Runnable() { // from class: com.ss.android.downloadlib.c.h.3
            @Override // java.lang.Runnable
            public void run() {
                DownloadInfo downloadInfo = Downloader.getInstance(k.a()).getDownloadInfo(s);
                JSONObject jSONObject = new JSONObject();
                m.a(jSONObject, "ttdownloader_type", (Object) 3);
                com.ss.android.downloadlib.g.f.c(downloadInfo, jSONObject);
                if (!m.c(bVar.e())) {
                    h.this.a(s, bVar, jSONObject);
                } else {
                    m.a(jSONObject, "error_code", (Object) 1003);
                }
                com.ss.android.downloadlib.d.a.a().b("download_notification_try_show", jSONObject, bVar);
            }
        }, j * 1000);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, com.ss.android.downloadad.api.a.b bVar, JSONObject jSONObject) {
        if (!com.ss.android.socialbase.appdownloader.e.d.a()) {
            m.a(jSONObject, "error_code", (Object) 1004);
            return;
        }
        DownloadInfo downloadInfo = Downloader.getInstance(k.a()).getDownloadInfo(i);
        if (downloadInfo == null) {
            m.a(jSONObject, "error_code", (Object) 1005);
            return;
        }
        if (com.ss.android.socialbase.downloader.notification.b.a().e(i) != null) {
            com.ss.android.socialbase.downloader.notification.b.a().f(i);
        }
        com.ss.android.socialbase.appdownloader.e.a aVar = new com.ss.android.socialbase.appdownloader.e.a(k.a(), i, downloadInfo.getTitle(), downloadInfo.getSavePath(), downloadInfo.getName(), downloadInfo.getExtra());
        aVar.a(downloadInfo.getCurBytes());
        aVar.b(downloadInfo.getTotalBytes());
        aVar.a(downloadInfo.getStatus(), null, false, false);
        com.ss.android.socialbase.downloader.notification.b.a().a(aVar);
        aVar.a((BaseException) null, false);
        com.ss.android.downloadlib.d.a.a().b("download_notification_show", jSONObject, bVar);
    }

    public void a(int i) {
        DownloadInfo downloadInfo;
        if (com.ss.android.socialbase.appdownloader.e.c.a().a(i) != null || (downloadInfo = Downloader.getInstance(k.a()).getDownloadInfo(i)) == null) {
            return;
        }
        com.ss.android.socialbase.appdownloader.e.c.a().a(i, downloadInfo.getIconUrl());
    }
}
