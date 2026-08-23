package com.ss.android.downloadlib;

import android.os.Environment;
import android.os.Handler;
import android.os.Looper;
import androidx.annotation.NonNull;
import com.qq.e.comm.constants.ErrorCode;
import com.sigmob.sdk.base.mta.PointCategory;
import com.sigmob.sdk.downloader.f;
import com.ss.android.download.api.download.DownloadModel;
import com.ss.android.downloadlib.g.k;
import com.ss.android.downloadlib.g.m;
import com.ss.android.socialbase.downloader.a.a;
import com.ss.android.socialbase.downloader.exception.BaseException;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import com.tencent.smtt.sdk.TbsListener;
import org.json.JSONObject;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class c implements com.ss.android.socialbase.appdownloader.c.h {
    private static String a = "c";
    private Handler b = new Handler(Looper.getMainLooper());

    @Override // com.ss.android.socialbase.appdownloader.c.h
    public void a(DownloadInfo downloadInfo, BaseException baseException, int i) {
        final DownloadModel a2;
        if (downloadInfo == null) {
            return;
        }
        if (i == -1 && baseException != null) {
            JSONObject jSONObject = new JSONObject();
            com.ss.android.downloadlib.g.f.c(downloadInfo, jSONObject);
            a.a(jSONObject, downloadInfo);
            k.a(PointCategory.DOWNLOAD_FAILED, jSONObject.toString());
        }
        com.ss.android.downloadad.api.a.b a3 = com.ss.android.downloadlib.addownload.b.f.a().a(downloadInfo);
        if (a3 == null) {
            return;
        }
        try {
            if (i != -1) {
                if (i == -3) {
                    a.a(downloadInfo, a3);
                    return;
                }
                if (i == 2001) {
                    a.a().a(downloadInfo, a3, ErrorCode.INIT_ERROR);
                    return;
                } else {
                    if (i == 11) {
                        a.a().a(downloadInfo, a3, f.a.f);
                        if (a3.S()) {
                            return;
                        }
                        a(downloadInfo, a3);
                        return;
                    }
                    return;
                }
            }
            BaseException baseException2 = null;
            if (baseException != null) {
                if (com.ss.android.socialbase.downloader.g.a.a(downloadInfo.getId()).a("toast_without_network", 0) == 1 && baseException.getErrorCode() == 1049) {
                    this.b.post(new Runnable() { // from class: com.ss.android.downloadlib.c.1
                        @Override // java.lang.Runnable
                        public void run() {
                            com.ss.android.downloadlib.addownload.k.d().a(5, com.ss.android.downloadlib.addownload.k.a(), null, "无网络，请检查网络设置", null, 0);
                        }
                    });
                }
                if (com.ss.android.socialbase.downloader.i.f.h(baseException)) {
                    if (com.ss.android.downloadlib.addownload.k.n() != null) {
                        com.ss.android.downloadlib.addownload.k.n();
                        a3.b();
                    }
                    com.ss.android.downloadlib.d.a.a().a("download_failed_for_space", a3);
                    if (!a3.Q()) {
                        com.ss.android.downloadlib.d.a.a().a("download_can_restart", a3);
                        a(downloadInfo);
                    }
                    if ((com.ss.android.downloadlib.addownload.k.n() == null || !com.ss.android.downloadlib.addownload.k.n().c()) && (a2 = com.ss.android.downloadlib.addownload.b.f.a().a(a3.b())) != null && a2.isShowToast()) {
                        final com.ss.android.socialbase.downloader.g.a a4 = com.ss.android.socialbase.downloader.g.a.a(downloadInfo.getId());
                        if (a4.a("show_no_enough_space_toast", 0) == 1) {
                            this.b.post(new Runnable() { // from class: com.ss.android.downloadlib.c.2
                                @Override // java.lang.Runnable
                                public void run() {
                                    com.ss.android.downloadlib.addownload.k.d().a(2, com.ss.android.downloadlib.addownload.k.a(), a2, a4.a("no_enough_space_toast_text", "您的存储空间不足，请清理后再试"), null, 0);
                                }
                            });
                        }
                    }
                }
                baseException2 = new BaseException(baseException.getErrorCode(), m.a(baseException.getMessage(), com.ss.android.downloadlib.addownload.k.j().optInt("exception_msg_length", TbsListener.ErrorCode.INFO_CODE_MINIQB)));
            }
            com.ss.android.downloadlib.d.a.a().b(downloadInfo, baseException2);
            h.a().a(downloadInfo, baseException, "");
        } catch (Exception e) {
            com.ss.android.downloadlib.addownload.k.u().a(e, "onAppDownloadMonitorSend");
        }
    }

    private void a(final DownloadInfo downloadInfo, final com.ss.android.downloadad.api.a.b bVar) {
        final long a2 = m.a(Environment.getDataDirectory(), -1L);
        long min = Math.min(524288000L, m.a(Environment.getDataDirectory()) / 10);
        final long totalBytes = downloadInfo.getTotalBytes();
        final double d = (totalBytes * 2.5d) + min;
        if (a2 > -1 && totalBytes > -1) {
            double d2 = a2;
            if (d2 < d && d - d2 > com.ss.android.downloadlib.addownload.d.b()) {
                com.ss.android.downloadlib.addownload.d.a(downloadInfo.getId());
            }
        }
        com.ss.android.socialbase.downloader.a.a.a().a(new a.InterfaceC0086a() { // from class: com.ss.android.downloadlib.c.3
            @Override // com.ss.android.socialbase.downloader.a.a.InterfaceC0086a
            public void b() {
                if (!m.b(bVar)) {
                    long j = a2;
                    if (j <= -1 || totalBytes <= -1 || j >= d) {
                        return;
                    }
                    com.ss.android.downloadlib.d.a.a().a("clean_space_install", com.ss.android.downloadlib.addownload.d.a("install_no_enough_space"), bVar);
                    if (com.ss.android.downloadlib.addownload.d.a(downloadInfo, ((long) d) - a2)) {
                        com.ss.android.socialbase.downloader.a.a.a().b(this);
                        bVar.g(true);
                        return;
                    }
                    return;
                }
                com.ss.android.socialbase.downloader.a.a.a().b(this);
            }

            @Override // com.ss.android.socialbase.downloader.a.a.InterfaceC0086a
            public void c() {
            }
        });
    }

    private void a(@NonNull DownloadInfo downloadInfo) {
        if (com.ss.android.downloadlib.g.e.f(downloadInfo.getId())) {
            e.a().b(new com.ss.android.downloadlib.addownload.c.b(downloadInfo));
        }
    }
}
