package com.ss.android.downloadlib.c;

import com.ss.android.downloadad.api.constant.AdBaseConstants;
import com.ss.android.downloadlib.addownload.k;
import com.ss.android.socialbase.downloader.depend.m;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import java.io.File;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class c implements m {
    @Override // com.ss.android.socialbase.downloader.depend.m
    public void a(DownloadInfo downloadInfo) {
        com.ss.android.download.api.config.m l = k.l();
        if (downloadInfo == null || l == null) {
            return;
        }
        File a = a(downloadInfo.getPackageName(), downloadInfo.getTargetFilePath());
        com.ss.android.downloadad.api.a.b a2 = com.ss.android.downloadlib.addownload.b.f.a().a(downloadInfo);
        if (a2 != null) {
            com.ss.android.downloadlib.g.m.a(a2.g());
        }
        downloadInfo.setMimeType(AdBaseConstants.MIME_APK);
        downloadInfo.setName(a.getName());
        downloadInfo.setMd5(null);
    }

    @Override // com.ss.android.socialbase.downloader.depend.m
    public boolean b(DownloadInfo downloadInfo) {
        if (downloadInfo != null) {
            return com.ss.android.download.api.c.b.a(com.ss.android.socialbase.downloader.g.a.a(downloadInfo.getId()), downloadInfo.getMimeType());
        }
        return false;
    }

    private File a(String str, String str2) {
        File file = new File(str2);
        String name = file.getName();
        int lastIndexOf = name.lastIndexOf(46);
        if (lastIndexOf > 0) {
            str = name.substring(0, lastIndexOf);
        }
        return new File(file.getParent(), str + ".apk");
    }
}
