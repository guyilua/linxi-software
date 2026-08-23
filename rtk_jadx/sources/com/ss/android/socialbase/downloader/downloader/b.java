package com.ss.android.socialbase.downloader.downloader;

import android.content.Context;
import android.text.TextUtils;
import com.ss.android.socialbase.downloader.depend.IDownloadFileUriProvider;
import com.ss.android.socialbase.downloader.depend.IDownloadListener;
import com.ss.android.socialbase.downloader.depend.ab;
import com.ss.android.socialbase.downloader.depend.z;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import com.ss.android.socialbase.downloader.model.DownloadTask;
import java.io.File;
import java.util.List;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: /tmp/rtk_apk/classes3.dex */
public class b {
    private String globalDefaultSavePath;
    private String globalDefaultSaveTempPath;

    public static DownloadTask with(Context context) {
        Downloader.getInstance(context);
        return new DownloadTask();
    }

    public void addMainThreadListener(int i, IDownloadListener iDownloadListener) {
        if (iDownloadListener == null) {
            return;
        }
        d.a().b(i, iDownloadListener, com.ss.android.socialbase.downloader.constants.f.MAIN, false);
    }

    public void addNotificationListener(int i, IDownloadListener iDownloadListener) {
        if (iDownloadListener == null) {
            return;
        }
        d.a().b(i, iDownloadListener, com.ss.android.socialbase.downloader.constants.f.NOTIFICATION, false);
    }

    public void addSubThreadListener(int i, IDownloadListener iDownloadListener) {
        if (iDownloadListener == null) {
            return;
        }
        d.a().b(i, iDownloadListener, com.ss.android.socialbase.downloader.constants.f.SUB, false);
    }

    public boolean canResume(int i) {
        return d.a().e(i);
    }

    public void cancel(int i) {
        cancel(i, true);
    }

    public void clearDownloadData(int i) {
        d.a().d(i, true);
    }

    public void destoryDownloader() {
        c.a();
    }

    public void forceDownloadIngoreRecommendSize(int i) {
        d.a().n(i);
    }

    public List<DownloadInfo> getAllDownloadInfo() {
        return d.a().e();
    }

    public long getCurBytes(int i) {
        return d.a().h(i);
    }

    public IDownloadFileUriProvider getDownloadFileUriProvider(int i) {
        return d.a().r(i);
    }

    public int getDownloadId(String str, String str2) {
        return d.a().a(str, str2);
    }

    public DownloadInfo getDownloadInfo(int i) {
        return d.a().k(i);
    }

    public List<DownloadInfo> getDownloadInfoList(String str) {
        return d.a().a(str);
    }

    public z getDownloadNotificationEventListener(int i) {
        return d.a().l(i);
    }

    public List<DownloadInfo> getDownloadingDownloadInfosWithMimeType(String str) {
        return d.a().e(str);
    }

    public List<DownloadInfo> getFailedDownloadInfosWithMimeType(String str) {
        return d.a().b(str);
    }

    public File getGlobalSaveDir() {
        return getGlobalSaveDir(this.globalDefaultSavePath, true);
    }

    public File getGlobalSaveTempDir() {
        return getGlobalSaveDir(this.globalDefaultSaveTempPath, false);
    }

    public r getReserveWifiStatusListener() {
        return c.R();
    }

    public int getStatus(int i) {
        return d.a().i(i);
    }

    public List<DownloadInfo> getSuccessedDownloadInfosWithMimeType(String str) {
        return d.a().c(str);
    }

    public List<DownloadInfo> getUnCompletedDownloadInfosWithMimeType(String str) {
        return d.a().d(str);
    }

    public boolean isDownloadCacheSyncSuccess() {
        return d.a().f();
    }

    public boolean isDownloadServiceForeground(int i) {
        return d.a().c(i).b();
    }

    public boolean isDownloadSuccessAndFileNotExist(DownloadInfo downloadInfo) {
        return d.a().a(downloadInfo);
    }

    public boolean isDownloading(int i) {
        boolean j;
        if (com.ss.android.socialbase.downloader.i.a.a(4194304)) {
            synchronized (this) {
                j = d.a().j(i);
            }
            return j;
        }
        return d.a().j(i);
    }

    public boolean isHttpServiceInit() {
        return d.a().d();
    }

    public void pause(int i) {
        d.a().d(i);
    }

    public void pauseAll() {
        d.a().c();
    }

    public void registerDownloadCacheSyncListener(com.ss.android.socialbase.downloader.depend.k kVar) {
        d.a().a(kVar);
    }

    public void registerDownloaderProcessConnectedListener(ab abVar) {
        d.a().a(abVar);
    }

    public void removeMainThreadListener(int i, IDownloadListener iDownloadListener) {
        if (iDownloadListener == null) {
            return;
        }
        d.a().a(i, iDownloadListener, com.ss.android.socialbase.downloader.constants.f.MAIN, false);
    }

    public void removeNotificationListener(int i, IDownloadListener iDownloadListener) {
        if (iDownloadListener == null) {
            return;
        }
        d.a().a(i, iDownloadListener, com.ss.android.socialbase.downloader.constants.f.NOTIFICATION, false);
    }

    public void removeSubThreadListener(int i, IDownloadListener iDownloadListener) {
        if (iDownloadListener == null) {
            return;
        }
        d.a().a(i, iDownloadListener, com.ss.android.socialbase.downloader.constants.f.SUB, false);
    }

    @Deprecated
    public void removeTaskMainListener(int i) {
        d.a().a(i, null, com.ss.android.socialbase.downloader.constants.f.MAIN, true);
    }

    @Deprecated
    public void removeTaskNotificationListener(int i) {
        d.a().a(i, null, com.ss.android.socialbase.downloader.constants.f.NOTIFICATION, true);
    }

    @Deprecated
    public void removeTaskSubListener(int i) {
        d.a().a(i, null, com.ss.android.socialbase.downloader.constants.f.SUB, true);
    }

    public void restart(int i) {
        d.a().g(i);
    }

    public void restartAllFailedDownloadTasks(List<String> list) {
        d.a().a(list);
    }

    public void restartAllPauseReserveOnWifiDownloadTasks(List<String> list) {
        d.a().b(list);
    }

    public void resume(int i) {
        d.a().f(i);
    }

    public void setDefaultSavePath(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        this.globalDefaultSavePath = str;
    }

    public void setDefaultSaveTempPath(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        this.globalDefaultSaveTempPath = str;
    }

    public void setDownloadInMultiProcess() {
        if (com.ss.android.socialbase.downloader.i.a.a(4194304)) {
            synchronized (this) {
                c.b();
            }
        } else {
            c.b();
        }
    }

    public void setDownloadNotificationEventListener(int i, z zVar) {
        d.a().a(i, zVar);
    }

    public void setLogLevel(int i) {
        d.a().p(i);
    }

    @Deprecated
    public void setMainThreadListener(int i, IDownloadListener iDownloadListener) {
        if (iDownloadListener == null) {
            return;
        }
        d.a().b(i, iDownloadListener, com.ss.android.socialbase.downloader.constants.f.MAIN, true);
    }

    @Deprecated
    public void setNotificationListener(int i, IDownloadListener iDownloadListener) {
        if (iDownloadListener == null) {
            return;
        }
        d.a().b(i, iDownloadListener, com.ss.android.socialbase.downloader.constants.f.NOTIFICATION, true);
    }

    public void setReserveWifiStatusListener(r rVar) {
        c.a(rVar);
    }

    @Deprecated
    public void setSubThreadListener(int i, IDownloadListener iDownloadListener) {
        if (iDownloadListener == null) {
            return;
        }
        d.a().b(i, iDownloadListener, com.ss.android.socialbase.downloader.constants.f.SUB, true);
    }

    public void setThrottleNetSpeed(int i, long j) {
        d.a().a(i, j);
    }

    public void unRegisterDownloadCacheSyncListener(com.ss.android.socialbase.downloader.depend.k kVar) {
        d.a().b(kVar);
    }

    public void unRegisterDownloaderProcessConnectedListener(ab abVar) {
        d.a().b(abVar);
    }

    private File getGlobalSaveDir(String str, boolean z) {
        File file = null;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            File file2 = new File(str);
            try {
                if (!file2.exists()) {
                    file2.mkdirs();
                } else if (!file2.isDirectory()) {
                    if (!z) {
                        return null;
                    }
                    file2.delete();
                    file2.mkdirs();
                }
                return file2;
            } catch (Throwable unused) {
                file = file2;
                return file;
            }
        } catch (Throwable unused2) {
        }
    }

    public void cancel(int i, boolean z) {
        d.a().c(i, z);
    }

    public void clearDownloadData(int i, boolean z) {
        d.a().d(i, z);
    }

    public DownloadInfo getDownloadInfo(String str, String str2) {
        return d.a().b(str, str2);
    }

    @Deprecated
    public void setMainThreadListener(int i, IDownloadListener iDownloadListener, boolean z) {
        if (iDownloadListener == null) {
            return;
        }
        d.a().a(i, iDownloadListener, com.ss.android.socialbase.downloader.constants.f.MAIN, true, z);
    }
}
