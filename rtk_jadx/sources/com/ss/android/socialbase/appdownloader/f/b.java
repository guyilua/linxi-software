package com.ss.android.socialbase.appdownloader.f;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.text.TextUtils;
import com.ss.android.downloadad.api.constant.AdBaseConstants;
import com.ss.android.socialbase.downloader.depend.z;
import com.ss.android.socialbase.downloader.downloader.Downloader;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import java.io.File;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class b {
    public static void a(DownloadInfo downloadInfo) {
        b(downloadInfo);
    }

    private static void b(final DownloadInfo downloadInfo) {
        final Context O = com.ss.android.socialbase.downloader.downloader.c.O();
        boolean z = true;
        if (((downloadInfo.isAutoResumed() && !downloadInfo.isShowNotificationForNetworkResumed()) || com.ss.android.socialbase.appdownloader.c.b(downloadInfo.getExtra()) || TextUtils.isEmpty(downloadInfo.getMimeType()) || !downloadInfo.getMimeType().equals(AdBaseConstants.MIME_APK)) && com.ss.android.socialbase.downloader.g.a.a(downloadInfo.getId()).a("auto_install_when_resume", 0) != 1) {
            z = false;
        }
        final int a = z ? com.ss.android.socialbase.appdownloader.c.a(O, downloadInfo.getId(), false) : 2;
        com.ss.android.socialbase.downloader.downloader.c.l().execute(new Runnable() { // from class: com.ss.android.socialbase.appdownloader.f.b.1
            @Override // java.lang.Runnable
            public void run() {
                com.ss.android.socialbase.appdownloader.c.d b = com.ss.android.socialbase.appdownloader.d.j().b();
                z downloadNotificationEventListener = Downloader.getInstance(O).getDownloadNotificationEventListener(downloadInfo.getId());
                if (b == null && downloadNotificationEventListener == null) {
                    return;
                }
                File file = new File(downloadInfo.getSavePath(), downloadInfo.getName());
                if (file.exists()) {
                    try {
                        PackageInfo a2 = com.ss.android.socialbase.appdownloader.c.a(downloadInfo, file);
                        if (a2 != null) {
                            String packageName = (a == 1 || TextUtils.isEmpty(downloadInfo.getPackageName())) ? a2.packageName : downloadInfo.getPackageName();
                            if (b != null) {
                                b.a(downloadInfo.getId(), 1, packageName, -3, downloadInfo.getDownloadTime());
                            }
                            if (downloadNotificationEventListener != null) {
                                downloadNotificationEventListener.a(1, downloadInfo, packageName, "");
                            }
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        });
    }
}
