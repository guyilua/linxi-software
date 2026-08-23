package com.ss.android.socialbase.downloader.depend;

import com.ss.android.socialbase.downloader.exception.BaseException;
import com.ss.android.socialbase.downloader.model.DownloadInfo;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public abstract class d extends AbsDownloadListener implements s {
    private void a(int i, DownloadInfo downloadInfo, BaseException baseException, boolean z) {
        if (downloadInfo == null || !downloadInfo.canShowNotification() || i == 4) {
            return;
        }
        com.ss.android.socialbase.downloader.notification.a e = com.ss.android.socialbase.downloader.notification.b.a().e(downloadInfo.getId());
        if (e == null) {
            e = a();
        }
        e.b(downloadInfo.getTotalBytes());
        if (i == -3) {
            e.a(downloadInfo.getTotalBytes());
        } else {
            e.a(downloadInfo.getCurBytes());
        }
        e.a(i, baseException, z);
    }

    private void b(DownloadInfo downloadInfo) {
        if (downloadInfo == null || !downloadInfo.canShowNotification()) {
            return;
        }
        com.ss.android.socialbase.downloader.notification.a e = com.ss.android.socialbase.downloader.notification.b.a().e(downloadInfo.getId());
        if (e == null) {
            com.ss.android.socialbase.downloader.notification.b.a().a(a());
        } else {
            e.a(downloadInfo);
        }
    }

    private void c(DownloadInfo downloadInfo) {
        if (downloadInfo != null && downloadInfo.canShowNotification() && downloadInfo.getStatus() == 4) {
            com.ss.android.socialbase.downloader.notification.a e = com.ss.android.socialbase.downloader.notification.b.a().e(downloadInfo.getId());
            if (e == null) {
                e = a();
            }
            e.a(downloadInfo.getCurBytes(), downloadInfo.getTotalBytes());
        }
    }

    protected abstract com.ss.android.socialbase.downloader.notification.a a();

    @Override // com.ss.android.socialbase.downloader.depend.AbsDownloadListener, com.ss.android.socialbase.downloader.depend.IDownloadListener
    public void onFailed(DownloadInfo downloadInfo, BaseException baseException) {
        super.onFailed(downloadInfo, baseException);
        a(-1, downloadInfo, baseException, false);
    }

    @Override // com.ss.android.socialbase.downloader.depend.AbsDownloadListener, com.ss.android.socialbase.downloader.depend.IDownloadListener
    public void onPause(DownloadInfo downloadInfo) {
        super.onPause(downloadInfo);
        a(-2, downloadInfo, null, false);
    }

    @Override // com.ss.android.socialbase.downloader.depend.AbsDownloadListener, com.ss.android.socialbase.downloader.depend.IDownloadListener
    public void onPrepare(DownloadInfo downloadInfo) {
        super.onPrepare(downloadInfo);
        b(downloadInfo);
        a(1, downloadInfo, null, true);
    }

    @Override // com.ss.android.socialbase.downloader.depend.AbsDownloadListener, com.ss.android.socialbase.downloader.depend.IDownloadListener
    public void onProgress(DownloadInfo downloadInfo) {
        super.onProgress(downloadInfo);
        c(downloadInfo);
    }

    @Override // com.ss.android.socialbase.downloader.depend.AbsDownloadListener, com.ss.android.socialbase.downloader.depend.IDownloadListener
    public void onStart(DownloadInfo downloadInfo) {
        super.onStart(downloadInfo);
        a(2, downloadInfo, null, false);
    }

    @Override // com.ss.android.socialbase.downloader.depend.AbsDownloadListener, com.ss.android.socialbase.downloader.depend.IDownloadListener
    public void onSuccessed(DownloadInfo downloadInfo) {
        super.onSuccessed(downloadInfo);
        a(-3, downloadInfo, null, false);
    }

    @Override // com.ss.android.socialbase.downloader.depend.s
    public void a(DownloadInfo downloadInfo) {
        if (downloadInfo == null || downloadInfo.isAutoInstallWithoutNotification()) {
            return;
        }
        a(11, downloadInfo, null, true);
    }
}
