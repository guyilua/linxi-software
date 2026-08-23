package com.ss.android.downloadlib.c;

import androidx.annotation.WorkerThread;
import com.ss.android.downloadlib.addownload.b.i;
import com.ss.android.downloadlib.g.m;
import com.ss.android.socialbase.downloader.depend.k;
import com.ss.android.socialbase.downloader.downloader.Downloader;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import org.json.JSONObject;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class d implements com.ss.android.socialbase.appdownloader.c.g, k {
    @Override // com.ss.android.socialbase.appdownloader.c.g
    public void a(DownloadInfo downloadInfo, boolean z) {
        if (downloadInfo == null) {
            return;
        }
        a(downloadInfo, downloadInfo.getRealStatus(), z);
    }

    @WorkerThread
    public void a(DownloadInfo downloadInfo, int i, boolean z) {
        com.ss.android.downloadlib.addownload.b.f.a().b();
        com.ss.android.downloadad.api.a.b a = com.ss.android.downloadlib.addownload.b.f.a().a(downloadInfo);
        if (a == null) {
            return;
        }
        try {
            if (z) {
                a.c(downloadInfo.getFailedResumeCount());
            } else if (a.D() == -1) {
                return;
            } else {
                a.c(-1);
            }
            i.a().a(a);
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("download_id", downloadInfo.getId());
            jSONObject.put("name", downloadInfo.getName());
            jSONObject.put("url", downloadInfo.getUrl());
            jSONObject.put("download_time", downloadInfo.getDownloadTime());
            jSONObject.put("download_status", i);
            jSONObject.put("cur_bytes", downloadInfo.getCurBytes());
            jSONObject.put("total_bytes", downloadInfo.getTotalBytes());
            int i2 = 1;
            jSONObject.put("only_wifi", downloadInfo.isOnlyWifi() ? 1 : 0);
            jSONObject.put("chunk_count", downloadInfo.getChunkCount());
            if (!z) {
                i2 = 2;
            }
            jSONObject.put("launch_resumed", i2);
            jSONObject.put("failed_resume_count", downloadInfo.getFailedResumeCount());
            com.ss.android.downloadlib.d.a.a().a("embeded_ad", "download_uncompleted", jSONObject, a);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    @Override // com.ss.android.socialbase.downloader.depend.k
    public void a() {
        com.ss.android.downloadlib.e.a().a(new Runnable() { // from class: com.ss.android.downloadlib.c.d.1
            @Override // java.lang.Runnable
            public void run() {
                DownloadInfo downloadInfo;
                int spIntVal;
                com.ss.android.downloadlib.addownload.b.f.a().b();
                for (com.ss.android.downloadad.api.a.b bVar : com.ss.android.downloadlib.addownload.b.f.a().c().values()) {
                    int s = bVar.s();
                    if (s != 0) {
                        com.ss.android.socialbase.downloader.g.a a = com.ss.android.socialbase.downloader.g.a.a(s);
                        if (a.b("notification_opt_2") == 1 && (downloadInfo = Downloader.getInstance(com.ss.android.downloadlib.addownload.k.a()).getDownloadInfo(s)) != null) {
                            if (m.b(bVar) && !m.c(bVar.e())) {
                                int spIntVal2 = downloadInfo.getSpIntVal("restart_notify_open_app_count");
                                if (spIntVal2 < a.a("noti_open_restart_times", 1)) {
                                    h.a().e(bVar);
                                    downloadInfo.setSpValue("restart_notify_open_app_count", String.valueOf(spIntVal2 + 1));
                                }
                            } else if (downloadInfo.getRealStatus() == -2) {
                                int spIntVal3 = downloadInfo.getSpIntVal("restart_notify_continue_count");
                                if (spIntVal3 < a.a("noti_continue_restart_times", 1)) {
                                    h.a().a(bVar);
                                    downloadInfo.setSpValue("restart_notify_continue_count", String.valueOf(spIntVal3 + 1));
                                }
                            } else if (downloadInfo.getRealStatus() == -3 && com.ss.android.socialbase.downloader.i.f.c(downloadInfo) && !m.b(bVar) && (spIntVal = downloadInfo.getSpIntVal("restart_notify_install_count")) < a.a("noti_install_restart_times", 1)) {
                                h.a().c(bVar);
                                downloadInfo.setSpValue("restart_notify_install_count", String.valueOf(spIntVal + 1));
                            }
                        }
                    }
                }
            }
        }, 5000L);
    }
}
