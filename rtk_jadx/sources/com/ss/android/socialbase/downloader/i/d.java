package com.ss.android.socialbase.downloader.i;

import com.ss.android.socialbase.downloader.model.DownloadInfo;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class d {
    public static boolean a(DownloadInfo downloadInfo) {
        return downloadInfo != null && com.ss.android.socialbase.downloader.g.a.a(downloadInfo.getId()).b("optimize_head_request") == 1;
    }

    public static boolean b(DownloadInfo downloadInfo) {
        return downloadInfo != null && com.ss.android.socialbase.downloader.g.a.a(downloadInfo.getId()).b("optimize_save_path") == 1;
    }
}
