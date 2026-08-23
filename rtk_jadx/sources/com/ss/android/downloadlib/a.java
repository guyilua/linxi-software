package com.ss.android.downloadlib;

import android.content.Intent;
import android.content.pm.PackageInfo;
import android.os.Environment;
import android.text.TextUtils;
import android.util.Pair;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.WorkerThread;
import com.qq.e.comm.constants.ErrorCode;
import com.sigmob.sdk.downloader.f;
import com.ss.android.downloadad.api.constant.AdBaseConstants;
import com.ss.android.downloadlib.addownload.b.d;
import com.ss.android.downloadlib.addownload.k;
import com.ss.android.downloadlib.addownload.l;
import com.ss.android.downloadlib.g.m;
import com.ss.android.socialbase.appdownloader.b;
import com.ss.android.socialbase.downloader.a.a;
import com.ss.android.socialbase.downloader.constants.DownloadStatus;
import com.ss.android.socialbase.downloader.depend.af;
import com.ss.android.socialbase.downloader.downloader.Downloader;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import com.tencent.smtt.sdk.TbsListener;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class a implements com.ss.android.downloadad.api.a, b.c, a.InterfaceC0086a, af {
    private static String a = "a";
    private static volatile a d;
    private long b;

    /* renamed from: c, reason: collision with root package name */
    private b f709c;

    /* JADX INFO: Access modifiers changed from: private */
    @WorkerThread
    /* renamed from: com.ss.android.downloadlib.a$a, reason: collision with other inner class name */
    /* loaded from: /tmp/rtk_apk/classes3.dex */
    public class RunnableC0070a implements Runnable {
        private final int b;

        public RunnableC0070a(int i) {
            this.b = i;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                com.ss.android.downloadlib.addownload.b.f.a().b();
                ConcurrentHashMap<Long, com.ss.android.downloadad.api.a.b> c2 = com.ss.android.downloadlib.addownload.b.f.a().c();
                if (c2 == null || c2.isEmpty()) {
                    return;
                }
                a.this.a(c2, this.b);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: /tmp/rtk_apk/classes3.dex */
    public static class b implements Runnable {
        private long a;
        private int b;

        /* renamed from: c, reason: collision with root package name */
        private long f715c;
        private int d;
        private long e;

        /* JADX INFO: Access modifiers changed from: private */
        public void b() {
            this.e = System.currentTimeMillis();
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                if (a()) {
                    a.a().a(this.a, this.b);
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }

        private b(long j, int i, long j2, int i2) {
            this.a = j;
            this.b = i;
            this.f715c = j2;
            this.d = i2;
        }

        /* JADX WARN: Code restructure failed: missing block: B:16:0x0064, code lost:
        
            if (r9 < r1) goto L21;
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        boolean a() {
            /*
                Method dump skipped, instructions count: 257
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: com.ss.android.downloadlib.a.b.a():boolean");
        }

        private int a(boolean z, com.ss.android.downloadad.api.a.b bVar, DownloadInfo downloadInfo, boolean z2, JSONObject jSONObject) {
            com.ss.android.socialbase.downloader.g.a a = com.ss.android.socialbase.downloader.g.a.a(downloadInfo.getId());
            int i = 1;
            if (a.a("install_failed_check_ttmd5", 1) == 1) {
                int checkMd5Status = downloadInfo.checkMd5Status();
                try {
                    jSONObject.put("ttmd5_status", checkMd5Status);
                } catch (Throwable unused) {
                }
                if (!com.ss.android.socialbase.downloader.i.f.a(checkMd5Status)) {
                    return 2005;
                }
            }
            int i2 = this.d;
            if (i2 != 2000) {
                return i2;
            }
            if (a.a("install_failed_check_signature", 1) == 1 && m.e(k.a(), bVar.e())) {
                if (!m.a(m.i(k.a(), downloadInfo.getTargetFilePath()), m.h(k.a(), bVar.e()))) {
                    return 2006;
                }
            }
            if (!z) {
                return ErrorCode.INNER_ERROR;
            }
            long j = this.e;
            long j2 = this.f715c;
            if (j <= j2) {
                return f.a.f;
            }
            try {
                jSONObject.put("install_time", j - j2);
                if (bVar.C() <= this.f715c) {
                    i = 0;
                }
                jSONObject.put("install_again", i);
            } catch (Throwable unused2) {
            }
            if (z2) {
                return 2004;
            }
            return ErrorCode.NOT_INIT;
        }
    }

    private a() {
        com.ss.android.socialbase.appdownloader.b.a(this);
        com.ss.android.socialbase.downloader.a.a.a().a(this);
    }

    public static JSONObject b(JSONObject jSONObject, DownloadInfo downloadInfo) {
        if (jSONObject == null || downloadInfo == null || com.ss.android.socialbase.downloader.g.a.a(downloadInfo.getId()).a("download_event_opt", 1) == 0) {
            return jSONObject;
        }
        try {
            long b2 = m.b(0L);
            double d2 = b2;
            jSONObject.put("available_space", d2 / 1048576.0d);
            long totalBytes = downloadInfo.getTotalBytes();
            double d3 = totalBytes;
            jSONObject.put("apk_size", d3 / 1048576.0d);
            if (b2 > 0 && totalBytes > 0) {
                jSONObject.put("available_space_ratio", d2 / d3);
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
        return jSONObject;
    }

    public static String c(@NonNull DownloadInfo downloadInfo, @NonNull com.ss.android.downloadad.api.a.b bVar) {
        File file = new File(downloadInfo.getSavePath(), downloadInfo.getName());
        String str = null;
        if (file.exists()) {
            try {
                PackageInfo packageArchiveInfo = k.a().getPackageManager().getPackageArchiveInfo(file.getAbsolutePath(), com.ss.android.socialbase.appdownloader.c.a());
                if (packageArchiveInfo != null) {
                    str = packageArchiveInfo.packageName;
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        if (!TextUtils.isEmpty(str) && !str.equals(downloadInfo.getPackageName())) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("real_package_name", str);
                jSONObject.put("input_package_name", downloadInfo.getPackageName());
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
            com.ss.android.downloadlib.d.a.a().a("embeded_ad", "package_name_error", jSONObject, bVar);
            return str;
        }
        return downloadInfo.getPackageName();
    }

    synchronized void d() {
        b bVar = this.f709c;
        if (bVar != null) {
            bVar.b();
            this.f709c = null;
        }
    }

    public static a a() {
        if (d == null) {
            synchronized (a.class) {
                if (d == null) {
                    d = new a();
                }
            }
        }
        return d;
    }

    @WorkerThread
    public static synchronized void a(DownloadInfo downloadInfo, com.ss.android.downloadad.api.a.b bVar) {
        synchronized (a.class) {
            if (downloadInfo == null) {
                com.ss.android.downloadlib.e.c.a().a("onDownloadFinish info null");
                return;
            }
            if (bVar == null) {
                com.ss.android.downloadlib.e.c.a().a("onDownloadFinish nativeModel null");
                return;
            }
            if (bVar.G() != 1) {
                return;
            }
            com.ss.android.downloadlib.c.h.a().d(bVar);
            String c2 = c(downloadInfo, bVar);
            com.ss.android.downloadlib.addownload.b.f.a().b(downloadInfo.getUrl(), c2);
            Map<Long, com.ss.android.downloadad.api.a.b> a2 = com.ss.android.downloadlib.addownload.b.f.a().a(downloadInfo.getUrl(), c2);
            bVar.f(System.currentTimeMillis());
            bVar.e(2);
            bVar.b(c2);
            a2.put(Long.valueOf(bVar.b()), bVar);
            com.ss.android.downloadlib.addownload.b.i.a().a(a2.values());
            a(bVar);
            h.a().a(downloadInfo, c2);
            if (AdBaseConstants.MIME_APK.equals(downloadInfo.getMimeType())) {
                if (com.ss.android.downloadlib.g.e.a((com.ss.android.downloadad.api.a.a) bVar).a("enable_app_install_receiver", 1) != 1 && k.j().optInt("enable_app_install_receiver", 1) != 1) {
                    l.a().a(bVar);
                }
                a().b(downloadInfo, bVar);
                if (bVar.L()) {
                    com.ss.android.downloadlib.addownload.a.a.a().a(downloadInfo.getId(), bVar.b(), bVar.l(), c2, downloadInfo.getTitle(), bVar.d(), downloadInfo.getTargetFilePath());
                }
                bVar.b();
                bVar.d();
            }
        }
    }

    public void b(DownloadInfo downloadInfo, final com.ss.android.downloadad.api.a.b bVar) {
        if (downloadInfo == null || bVar == null || com.ss.android.socialbase.downloader.g.a.a(downloadInfo.getId()).a("install_finish_check_ttmd5", 1) == 0) {
            return;
        }
        final String targetFilePath = downloadInfo.getTargetFilePath();
        if (TextUtils.isEmpty(targetFilePath)) {
            return;
        }
        e.a().b(new Runnable() { // from class: com.ss.android.downloadlib.a.3
            @Override // java.lang.Runnable
            public void run() {
                String a2 = com.ss.android.downloadlib.g.a.a(targetFilePath);
                if (TextUtils.isEmpty(a2)) {
                    return;
                }
                k.a().getSharedPreferences("sp_ttdownloader_md5", 0).edit().putString(String.valueOf(bVar.b()), a2).apply();
            }
        });
    }

    @Override // com.ss.android.socialbase.downloader.a.a.InterfaceC0086a
    public void b() {
        com.ss.android.socialbase.downloader.c.a.b(a, "onAppForeground()");
        d();
        a(5);
    }

    @Override // com.ss.android.socialbase.downloader.a.a.InterfaceC0086a
    public void c() {
        com.ss.android.socialbase.downloader.c.a.b(a, "onAppBackground()");
        a(6);
    }

    private int b(com.ss.android.downloadad.api.a.b bVar) {
        int realStatus;
        double a2 = com.ss.android.socialbase.downloader.g.a.a(bVar.s()).a("download_failed_finally_hours", 48.0d);
        if (a2 <= 0.0d) {
            return -1;
        }
        if (System.currentTimeMillis() - bVar.H() < a2 * 60.0d * 60.0d * 1000.0d) {
            return 1;
        }
        if (bVar.d.get()) {
            return 0;
        }
        DownloadInfo downloadInfo = Downloader.getInstance(k.a()).getDownloadInfo(bVar.s());
        if (downloadInfo == null || (realStatus = downloadInfo.getRealStatus()) == -3 || realStatus == -4) {
            return -1;
        }
        if (!DownloadStatus.isDownloading(realStatus) && bVar.d.compareAndSet(false, true)) {
            try {
                JSONObject jSONObject = new JSONObject();
                a(jSONObject, downloadInfo);
                jSONObject.putOpt("download_status", Integer.valueOf(realStatus));
                jSONObject.putOpt("fail_status", Integer.valueOf(bVar.E()));
                jSONObject.putOpt("fail_msg", bVar.F());
                jSONObject.put("download_failed_times", bVar.x());
                if (downloadInfo.getTotalBytes() > 0) {
                    jSONObject.put("download_percent", downloadInfo.getCurBytes() / downloadInfo.getTotalBytes());
                }
                jSONObject.put("is_update_download", bVar.V() ? 1 : 2);
                com.ss.android.downloadlib.d.a.a().a(bVar.j(), "download_failed_finally", jSONObject, bVar);
                com.ss.android.downloadlib.addownload.b.i.a().a(bVar);
                return 0;
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
        return 1;
    }

    @WorkerThread
    public synchronized void a(final String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        if (!m.b()) {
            final com.ss.android.downloadad.api.a.b a2 = com.ss.android.downloadlib.addownload.b.f.a().a(str);
            if (a2 == null) {
                com.ss.android.downloadlib.addownload.b.d.a().a(str);
                return;
            }
            com.ss.android.downloadlib.addownload.e a3 = h.a().a(a2.a());
            if (a3 != null) {
                a3.f();
            }
            if (a2.f708c.get()) {
                return;
            }
            if (com.ss.android.socialbase.downloader.g.a.a(a2.s()).b("notification_opt_2") == 1) {
                com.ss.android.socialbase.downloader.notification.b.a().f(a2.s());
            }
            new com.ss.android.downloadlib.b.b().a(a2, new com.ss.android.downloadlib.b.g() { // from class: com.ss.android.downloadlib.a.1
                @Override // com.ss.android.downloadlib.b.g
                public void a(boolean z) {
                    com.ss.android.socialbase.downloader.c.a.b(a.a, "appBackForeground->".concat(String.valueOf(z)));
                    if (z) {
                        if (!(com.ss.android.downloadlib.b.f.c(a2) ? com.ss.android.downloadlib.b.a.a(str, a2) : false) && com.ss.android.downloadlib.b.f.d(a2) && a2.K() == 4) {
                            com.ss.android.downloadlib.addownload.a.a.a().a(a2);
                            return;
                        }
                        return;
                    }
                    if (com.ss.android.downloadlib.b.a.a(str, a2) || a2.K() != 4) {
                        return;
                    }
                    com.ss.android.downloadlib.addownload.a.a.a().a(a2);
                }
            }, com.ss.android.downloadlib.g.e.a((com.ss.android.downloadad.api.a.a) a2).a("try_applink_delay_after_installed", 0));
            com.ss.android.downloadlib.c.h.a().f(a2);
            a(str, a2);
            com.ss.android.downloadlib.addownload.a.a.a().b(str);
            DownloadInfo a4 = a((List<DownloadInfo>) Downloader.getInstance(k.a()).getSuccessedDownloadInfosWithMimeType(AdBaseConstants.MIME_APK), str);
            if (a4 != null) {
                if (com.ss.android.socialbase.downloader.g.a.a(a4.getId()).b("no_hide_notification") != 1) {
                    com.ss.android.socialbase.downloader.notification.b.a().a(a4.getId());
                }
                h.a().b(a4, str);
                com.ss.android.downloadlib.addownload.c.d.a(a4);
                return;
            }
            h.a().b(null, str);
            return;
        }
        throw new RuntimeException("handleAppInstalled in main thread.");
    }

    private JSONObject b(@NonNull DownloadInfo downloadInfo, com.ss.android.socialbase.appdownloader.a aVar) {
        com.ss.android.downloadad.api.a.b a2 = com.ss.android.downloadlib.addownload.b.f.a().a(downloadInfo);
        if (a2 == null) {
            return null;
        }
        JSONObject jSONObject = new JSONObject();
        aVar.a(jSONObject);
        try {
            jSONObject.put("download_id", downloadInfo.getId());
            jSONObject.put("name", downloadInfo.getName());
        } catch (Throwable th) {
            th.printStackTrace();
        }
        com.ss.android.downloadlib.g.f.a(jSONObject, downloadInfo.getId());
        com.ss.android.downloadlib.d.a.a().a("embeded_ad", "ah_result", jSONObject, a2);
        return jSONObject;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(DownloadInfo downloadInfo, com.ss.android.downloadad.api.a.b bVar, int i) {
        long max;
        if (downloadInfo == null || bVar == null) {
            return;
        }
        d();
        long currentTimeMillis = System.currentTimeMillis();
        bVar.b(currentTimeMillis);
        bVar.g(m.a(Environment.getDataDirectory(), -1L));
        if (i != 2000) {
            max = 2000;
        } else {
            long a2 = com.ss.android.socialbase.downloader.g.a.a(downloadInfo.getId()).a("check_install_failed_delay_time", 120000L);
            if (a2 < 0) {
                return;
            } else {
                max = Math.max(a2, 30000L);
            }
        }
        long j = max;
        b bVar2 = new b(bVar.b(), downloadInfo.getId(), currentTimeMillis, i);
        e.a().a(bVar2, j);
        this.f709c = bVar2;
        com.ss.android.downloadlib.addownload.b.i.a().a(bVar);
    }

    public void a(final long j, int i) {
        long a2 = com.ss.android.socialbase.downloader.g.a.a(i).a("check_install_finish_hijack_delay_time", 900000L);
        if (a2 < 0) {
            return;
        }
        e.a().a(new Runnable() { // from class: com.ss.android.downloadlib.a.2
            @Override // java.lang.Runnable
            public void run() {
                a.a().a(j);
            }
        }, Math.max(a2, 300000L));
    }

    public void a(long j) {
        d.a a2;
        int i;
        try {
            com.ss.android.downloadad.api.a.b d2 = com.ss.android.downloadlib.addownload.b.f.a().d(j);
            if (d2 != null && !m.b(d2) && !d2.f708c.get()) {
                Pair<d.a, Integer> b2 = com.ss.android.downloadlib.addownload.b.d.a().b(d2);
                if (b2 != null) {
                    a2 = (d.a) b2.first;
                    i = ((Integer) b2.second).intValue();
                } else {
                    a2 = com.ss.android.downloadlib.addownload.b.d.a().a(d2);
                    i = -1;
                }
                if (a2 == null) {
                    return;
                }
                com.ss.android.downloadlib.addownload.b.d.a().b(a2.a);
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("installed_app_name", a2.d);
                jSONObject.put("installed_pkg_name", a2.a);
                if (i != -1) {
                    jSONObject.put("error_code", i);
                    com.ss.android.downloadlib.g.f.a(jSONObject, d2.s());
                    com.ss.android.downloadlib.d.a.a().b("install_finish_hijack", jSONObject, d2);
                    return;
                }
                com.ss.android.downloadlib.d.a.a().b("install_finish_may_hijack", jSONObject, d2);
            }
        } catch (Throwable th) {
            com.ss.android.downloadlib.e.c.a().a(th, "trySendInstallFinishHijack");
        }
    }

    public void a(String str, com.ss.android.downloadad.api.a.b bVar) {
        if (bVar != null && m.b(bVar) && bVar.f708c.compareAndSet(false, true)) {
            com.ss.android.downloadlib.d.a.a().a(bVar.j(), com.sigmob.sdk.base.common.a.J, a(bVar, str, bVar.K() != 4 ? 3 : 4), bVar);
            com.ss.android.downloadlib.addownload.b.i.a().a(bVar);
        }
    }

    private static DownloadInfo a(List<DownloadInfo> list, String str) {
        if (list != null && !list.isEmpty() && !TextUtils.isEmpty(str)) {
            for (DownloadInfo downloadInfo : list) {
                if (downloadInfo != null) {
                    if (str.equals(downloadInfo.getPackageName())) {
                        return downloadInfo;
                    }
                    if (m.a(k.a(), downloadInfo.getTargetFilePath(), str)) {
                        return downloadInfo;
                    }
                }
            }
        }
        return null;
    }

    public static JSONObject a(JSONObject jSONObject, DownloadInfo downloadInfo) {
        if (jSONObject != null && downloadInfo != null) {
            int i = 1;
            if (com.ss.android.socialbase.downloader.g.a.a(downloadInfo.getId()).a("download_event_opt", 1) == 0) {
                return jSONObject;
            }
            try {
                jSONObject.put("download_id", downloadInfo.getId());
                jSONObject.put("name", downloadInfo.getName());
                jSONObject.put("cur_bytes", downloadInfo.getCurBytes());
                jSONObject.put("total_bytes", downloadInfo.getTotalBytes());
                jSONObject.put("network_quality", downloadInfo.getNetworkQuality());
                jSONObject.put("current_network_quality", com.ss.android.socialbase.downloader.network.k.a().b().name());
                jSONObject.put("only_wifi", downloadInfo.isOnlyWifi() ? 1 : 0);
                jSONObject.put("need_https_degrade", downloadInfo.isNeedHttpsToHttpRetry() ? 1 : 0);
                jSONObject.put("https_degrade_retry_used", downloadInfo.isHttpsToHttpRetryUsed() ? 1 : 0);
                jSONObject.put("chunk_count", downloadInfo.getChunkCount());
                jSONObject.put("retry_count", downloadInfo.getRetryCount());
                jSONObject.put("cur_retry_time", downloadInfo.getCurRetryTime());
                jSONObject.put("need_retry_delay", downloadInfo.isNeedRetryDelay() ? 1 : 0);
                jSONObject.put("backup_url_used", downloadInfo.isBackUpUrlUsed() ? 1 : 0);
                jSONObject.put("head_connection_error_msg", downloadInfo.getHeadConnectionException() != null ? downloadInfo.getHeadConnectionException() : "");
                jSONObject.put("need_independent_process", downloadInfo.isNeedIndependentProcess() ? 1 : 0);
                jSONObject.put("total_retry_count", downloadInfo.getTotalRetryCount());
                jSONObject.put("cur_retry_time_in_total", downloadInfo.getCurRetryTimeInTotal());
                jSONObject.put("real_download_time", downloadInfo.getRealDownloadTime());
                jSONObject.put("first_speed_time", downloadInfo.getFirstSpeedTime());
                jSONObject.put("all_connect_time", downloadInfo.getAllConnectTime());
                jSONObject.put("download_prepare_time", downloadInfo.getDownloadPrepareTime());
                jSONObject.put("download_time", downloadInfo.getRealDownloadTime() + downloadInfo.getAllConnectTime() + downloadInfo.getDownloadPrepareTime());
                jSONObject.put("chunk_downgrade_retry_used", downloadInfo.isChunkDowngradeRetryUsed() ? 1 : 0);
                jSONObject.put("need_chunk_downgrade_retry", downloadInfo.isNeedChunkDowngradeRetry() ? 1 : 0);
                jSONObject.put("failed_resume_count", downloadInfo.getFailedResumeCount());
                jSONObject.put("preconnect_level", downloadInfo.getPreconnectLevel());
                jSONObject.put("md5", downloadInfo.getMd5());
                jSONObject.put("expect_file_length", downloadInfo.getExpectFileLength());
                jSONObject.put("retry_schedule_count", downloadInfo.getRetryScheduleCount());
                jSONObject.put("rw_concurrent", downloadInfo.isRwConcurrent() ? 1 : 0);
                double curBytes = downloadInfo.getCurBytes() / 1048576.0d;
                double realDownloadTime = downloadInfo.getRealDownloadTime() / 1000.0d;
                if (curBytes > 0.0d && realDownloadTime > 0.0d) {
                    double d2 = curBytes / realDownloadTime;
                    try {
                        jSONObject.put("download_speed", d2);
                    } catch (Exception unused) {
                    }
                    com.ss.android.socialbase.downloader.c.a.b(a, "download speed : " + d2 + "MB/s");
                }
                try {
                    jSONObject.put("is_download_service_foreground", Downloader.getInstance(k.a()).isDownloadServiceForeground(downloadInfo.getId()) ? 1 : 0);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                if (downloadInfo.getBackUpUrls() != null) {
                    jSONObject.put("backup_url_count", downloadInfo.getBackUpUrls().size());
                    jSONObject.put("cur_backup_url_index", downloadInfo.getCurBackUpUrlIndex());
                }
                jSONObject.put("clear_space_restart_times", com.ss.android.downloadlib.addownload.c.d.a().b(downloadInfo.getUrl()));
                jSONObject.put("mime_type", downloadInfo.getMimeType());
                if (!com.ss.android.socialbase.downloader.i.f.c(k.a())) {
                    i = 2;
                }
                jSONObject.put("network_available", i);
                jSONObject.put("status_code", downloadInfo.getHttpStatusCode());
                b(jSONObject, downloadInfo);
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
        return jSONObject;
    }

    private static void a(com.ss.android.downloadad.api.a.b bVar) {
        if (bVar == null) {
            return;
        }
        String P = TextUtils.isEmpty(bVar.P()) ? "" : bVar.P();
        DownloadInfo downloadInfo = Downloader.getInstance(k.a()).getDownloadInfo(bVar.s());
        bVar.l("");
        com.ss.android.downloadlib.addownload.b.i.a().a(bVar);
        JSONObject a2 = a(new JSONObject(), downloadInfo);
        int i = 1;
        try {
            a2.putOpt("finish_reason", P);
            a2.putOpt("finish_from_reserve_wifi", Integer.valueOf(downloadInfo.isDownloadFromReserveWifi() ? 1 : 0));
        } catch (JSONException e) {
            e.printStackTrace();
        }
        com.ss.android.downloadad.api.a.b a3 = com.ss.android.downloadlib.addownload.b.f.a().a(downloadInfo);
        com.ss.android.downloadlib.g.f.a(a2, downloadInfo.getId());
        try {
            a2.put("download_failed_times", a3.x());
            a2.put("can_show_notification", com.ss.android.socialbase.appdownloader.e.d.a() ? 1 : 2);
            if (downloadInfo.getExpectFileLength() > 0 && downloadInfo.getTotalBytes() > 0) {
                a2.put("file_length_gap", downloadInfo.getExpectFileLength() - downloadInfo.getTotalBytes());
            }
            a2.put("ttmd5_status", downloadInfo.getTTMd5CheckStatus());
            a2.put("has_send_download_failed_finally", a3.d.get() ? 1 : 2);
            if (!a3.V()) {
                i = 2;
            }
            a2.put("is_update_download", i);
            com.ss.android.downloadlib.g.f.a(a3, a2);
        } catch (Throwable th) {
            th.printStackTrace();
        }
        com.ss.android.downloadlib.d.a.a().b(com.sigmob.sdk.base.common.a.H, a2, bVar);
    }

    private int a(com.ss.android.downloadad.api.a.b bVar, DownloadInfo downloadInfo, String str, JSONObject jSONObject) {
        int b2 = com.ss.android.socialbase.appdownloader.c.b(k.a(), downloadInfo);
        int b3 = m.b(k.a(), str);
        if (b2 > 0 && b3 > 0 && b2 != b3) {
            return b3 > b2 ? 3011 : 3010;
        }
        if (com.ss.android.socialbase.downloader.g.a.a(bVar.s()).a("install_finish_check_ttmd5", 1) != 1) {
            return ErrorCode.NETWORK_ERROR;
        }
        String string = k.a().getSharedPreferences("sp_ttdownloader_md5", 0).getString(String.valueOf(bVar.b()), null);
        if (TextUtils.isEmpty(string) && downloadInfo != null) {
            string = com.ss.android.downloadlib.g.a.a(downloadInfo.getTargetFilePath());
        }
        int a2 = com.ss.android.downloadlib.g.a.a(string, com.ss.android.downloadlib.g.a.b(str));
        try {
            jSONObject.put("ttmd5_status", a2);
        } catch (Throwable unused) {
        }
        return a2 == 0 ? ErrorCode.NETWORK_UNKNOWN : a2 == 1 ? ErrorCode.NETWORK_TIMEOUT : ErrorCode.NETWORK_ERROR;
    }

    @Override // com.ss.android.downloadad.api.a
    public void a(int i) {
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - this.b < 120000) {
            return;
        }
        e.a().a(new RunnableC0070a(i), this.b > 0 ? 2000L : 8000L);
        this.b = currentTimeMillis;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @WorkerThread
    public void a(@NonNull ConcurrentHashMap<Long, com.ss.android.downloadad.api.a.b> concurrentHashMap, int i) {
        ArrayList arrayList = new ArrayList();
        long currentTimeMillis = System.currentTimeMillis();
        for (com.ss.android.downloadad.api.a.b bVar : concurrentHashMap.values()) {
            if (bVar.f708c.get()) {
                if (currentTimeMillis - bVar.H() >= com.ss.android.socialbase.downloader.g.a.a(bVar.s()).a("start_event_expire_hours", TbsListener.ErrorCode.STARTDOWNLOAD_9) * 60 * 60 * 1000) {
                    arrayList.add(Long.valueOf(bVar.b()));
                }
            } else if (bVar.G() == 1) {
                if (b(bVar) <= 0 && currentTimeMillis - bVar.H() >= com.ss.android.socialbase.downloader.g.a.a(bVar.s()).a("start_event_expire_hours", TbsListener.ErrorCode.STARTDOWNLOAD_9) * 60 * 60 * 1000) {
                    arrayList.add(Long.valueOf(bVar.b()));
                }
            } else if (bVar.G() == 2) {
                if (!bVar.Y()) {
                    if (m.b(bVar)) {
                        if (bVar.K() == 4) {
                            i = bVar.K();
                        }
                        bVar.j(false);
                        com.ss.android.downloadlib.d.a.a().a(a(bVar, bVar.e(), i), bVar);
                        arrayList.add(Long.valueOf(bVar.b()));
                        com.ss.android.downloadlib.addownload.c.d.a(bVar);
                    } else if (bVar.Y() && bVar.K() == 4 && i == 1 && !m.b(bVar)) {
                        com.ss.android.downloadlib.g.l.a().a(a, "trySendAndRefreshAdEvent", "命中兜底逻辑,尝试对广播监听执行冷启兜底逻辑");
                        i.a().a(bVar);
                    } else if (currentTimeMillis - bVar.H() >= com.ss.android.socialbase.downloader.g.a.a(bVar.s()).a("finish_event_expire_hours", TbsListener.ErrorCode.STARTDOWNLOAD_9) * 60 * 60 * 1000) {
                        arrayList.add(Long.valueOf(bVar.b()));
                    } else if (TextUtils.isEmpty(bVar.e())) {
                        arrayList.add(Long.valueOf(bVar.b()));
                    }
                }
            } else {
                arrayList.add(Long.valueOf(bVar.b()));
            }
        }
        com.ss.android.downloadlib.addownload.b.f.a().a(arrayList);
    }

    @Override // com.ss.android.socialbase.appdownloader.b.c
    public void a(DownloadInfo downloadInfo, com.ss.android.socialbase.appdownloader.a aVar) {
        JSONObject b2;
        if (downloadInfo == null || aVar == null) {
            return;
        }
        JSONArray e = com.ss.android.socialbase.downloader.g.a.a(downloadInfo.getId()).e("ah_report_config");
        if (aVar.b != 0) {
            downloadInfo.getTempCacheData().remove("intent");
        }
        if (e == null || (b2 = b(downloadInfo, aVar)) == null) {
            return;
        }
        downloadInfo.getTempCacheData().put("ah_ext_json", b2);
    }

    @Override // com.ss.android.socialbase.downloader.depend.af
    public void a(@Nullable final DownloadInfo downloadInfo, @Nullable String str) {
        if (downloadInfo == null) {
            com.ss.android.downloadlib.e.c.a().a("info is null");
        } else if ((com.ss.android.socialbase.downloader.g.a.a(downloadInfo).b("check_applink_mode") & 2) != 0) {
            final JSONObject jSONObject = (JSONObject) downloadInfo.getTempCacheData().get("ah_ext_json");
            com.ss.android.downloadlib.b.e.a().b(new com.ss.android.downloadlib.b.d() { // from class: com.ss.android.downloadlib.a.4
                @Override // com.ss.android.downloadlib.b.d
                public void a(boolean z) {
                    if (!z) {
                        Intent intent = (Intent) downloadInfo.getTempCacheData().get("intent");
                        if (intent != null) {
                            downloadInfo.getTempCacheData().remove("intent");
                            com.ss.android.socialbase.appdownloader.c.a(k.a(), intent);
                            m.a(jSONObject, "backup", (Object) 1);
                        } else {
                            m.a(jSONObject, "backup", (Object) 2);
                        }
                    }
                    com.ss.android.downloadad.api.a.b a2 = com.ss.android.downloadlib.addownload.b.f.a().a(downloadInfo);
                    if (a2 != null) {
                        com.ss.android.downloadlib.d.a.a().a(z ? "installer_delay_success" : "installer_delay_failed", jSONObject, a2);
                    } else {
                        com.ss.android.downloadlib.e.c.a().b("ah nativeModel=null");
                    }
                    if (z) {
                        k.v();
                        k.a();
                    }
                }
            });
        }
    }

    private JSONObject a(com.ss.android.downloadad.api.a.b bVar, String str, int i) {
        com.ss.android.socialbase.appdownloader.a a2;
        JSONObject jSONObject = new JSONObject();
        try {
            DownloadInfo downloadInfo = Downloader.getInstance(k.a()).getDownloadInfo(bVar.s());
            jSONObject.putOpt("scene", Integer.valueOf(i));
            com.ss.android.downloadlib.g.f.a(jSONObject, bVar.s());
            com.ss.android.downloadlib.g.f.a(bVar, jSONObject);
            jSONObject.put("is_update_download", bVar.V() ? 1 : 2);
            jSONObject.put("install_after_back_app", bVar.ab() ? 1 : 2);
            jSONObject.putOpt("clean_space_install_params", bVar.R() ? "1" : "2");
            if (downloadInfo != null) {
                a(jSONObject, downloadInfo);
                try {
                    jSONObject.put("uninstall_resume_count", downloadInfo.getUninstallResumeCount());
                    if (bVar.C() > 0) {
                        long currentTimeMillis = System.currentTimeMillis() - bVar.C();
                        jSONObject.put("install_time", currentTimeMillis);
                        if (currentTimeMillis > com.ss.android.socialbase.downloader.g.a.a(downloadInfo.getId()).a("check_install_finish_expired_duration", 86400000L)) {
                            jSONObject.put("install_expired", 1);
                        } else {
                            jSONObject.put("install_expired", 0);
                        }
                    }
                } catch (Throwable unused) {
                }
                String a3 = com.ss.android.socialbase.downloader.i.f.a(downloadInfo.getTempCacheData().get("ah_attempt"), (String) null);
                if (!TextUtils.isEmpty(a3) && (a2 = com.ss.android.socialbase.appdownloader.a.a(a3)) != null) {
                    a2.a(jSONObject);
                }
            }
            int a4 = a(bVar, downloadInfo, str, jSONObject);
            jSONObject.put("fail_status", a4);
            if (a4 == 3000) {
                jSONObject.put("hijack", 2);
            } else if (a4 == 3001) {
                jSONObject.put("hijack", 0);
            } else {
                jSONObject.put("hijack", 1);
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
        return jSONObject;
    }

    public void a(DownloadInfo downloadInfo, long j, long j2, long j3, long j4, long j5, boolean z) {
        com.ss.android.downloadad.api.a.b a2 = com.ss.android.downloadlib.addownload.b.f.a().a(downloadInfo);
        if (a2 == null) {
            com.ss.android.downloadlib.e.c.a().a("trySendClearSpaceEvent nativeModel null");
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.putOpt("space_before", Double.valueOf(j / 1048576.0d));
            jSONObject.putOpt("space_cleaned", Double.valueOf((j2 - j) / 1048576.0d));
            jSONObject.putOpt("clean_up_time_cost", Long.valueOf(j4));
            jSONObject.putOpt("is_download_restarted", Integer.valueOf(z ? 1 : 0));
            jSONObject.putOpt("byte_required", Long.valueOf(j3));
            jSONObject.putOpt("byte_required_after", Double.valueOf((j3 - j2) / 1048576.0d));
            jSONObject.putOpt("clear_sleep_time", Long.valueOf(j5));
            com.ss.android.downloadlib.g.f.c(downloadInfo, jSONObject);
            com.ss.android.downloadlib.d.a.a().a("cleanup", jSONObject, a2);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
