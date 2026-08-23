package com.ss.android.socialbase.downloader.depend;

import com.ss.android.socialbase.downloader.model.DownloadInfo;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public abstract class a extends AbsDownloadListener implements s {
    private static final String a = "a";

    public void a(DownloadInfo downloadInfo) {
        if (!com.ss.android.socialbase.downloader.c.a.a() || downloadInfo == null) {
            return;
        }
        com.ss.android.socialbase.downloader.c.a.b(a, " onWaitingDownloadCompleteHandler -- " + downloadInfo.getName());
    }
}
