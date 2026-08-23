package com.ss.android.downloadlib.c;

import android.content.pm.PackageInfo;
import com.ss.android.downloadlib.addownload.k;
import com.ss.android.socialbase.downloader.depend.m;
import com.ss.android.socialbase.downloader.model.DownloadInfo;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class b implements m {
    @Override // com.ss.android.socialbase.downloader.depend.m
    public void a(DownloadInfo downloadInfo) {
        PackageInfo a = com.ss.android.socialbase.appdownloader.c.a(k.a(), downloadInfo, downloadInfo.getSavePath(), downloadInfo.getName());
        if (a != null) {
            downloadInfo.setAppVersionCode(a.versionCode);
        }
    }

    @Override // com.ss.android.socialbase.downloader.depend.m
    public boolean b(DownloadInfo downloadInfo) {
        return downloadInfo != null && com.ss.android.downloadlib.g.e.b() && downloadInfo.getPackageInfo() == null;
    }
}
