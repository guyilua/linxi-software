package com.ss.android.downloadlib.addownload;

import com.ss.android.download.api.model.DownloadShortInfo;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class j {
    public static int a(int i, int i2) {
        return (i2 <= 0 || i2 >= 100 || !a(i)) ? i2 : (int) (Math.sqrt(i2) * 10.0d);
    }

    public static long a(int i, long j, long j2) {
        if (!a(i)) {
            return j;
        }
        if (j <= 0) {
            return 0L;
        }
        return j2 <= 0 ? j : (j2 * a(i, (int) ((j * 100) / j2))) / 100;
    }

    public static DownloadShortInfo a(DownloadShortInfo downloadShortInfo) {
        if (downloadShortInfo != null && a((int) downloadShortInfo.id)) {
            downloadShortInfo.currentBytes = a((int) downloadShortInfo.id, downloadShortInfo.currentBytes, downloadShortInfo.totalBytes);
        }
        return downloadShortInfo;
    }

    private static boolean a(int i) {
        return com.ss.android.socialbase.downloader.g.a.a(i).a("pause_optimise_pretend_download_percent_switch", 0) == 1 && com.ss.android.socialbase.downloader.g.a.a(i).a("pause_optimise_switch", 0) == 1;
    }
}
