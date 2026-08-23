package com.ss.android.socialbase.downloader.downloader;

import android.content.Context;
import com.ss.android.socialbase.downloader.depend.IDownloadFileUriProvider;
import com.ss.android.socialbase.downloader.depend.IDownloadListener;
import com.ss.android.socialbase.downloader.depend.ab;
import com.ss.android.socialbase.downloader.depend.z;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import java.io.File;
import java.util.List;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class Downloader extends b {
    private static volatile Downloader instance;

    static {
        c.a(new v());
        instance = null;
    }

    private Downloader() {
    }

    public static Downloader getInstance(Context context) {
        if (instance == null) {
            synchronized (Downloader.class) {
                if (instance == null) {
                    c.a(context);
                    instance = new Downloader();
                }
            }
        }
        return instance;
    }

    public static synchronized void init(DownloaderBuilder downloaderBuilder) {
        synchronized (Downloader.class) {
            initOrCover(downloaderBuilder, false);
        }
    }

    public static synchronized void initOrCover(DownloaderBuilder downloaderBuilder, boolean z) {
        synchronized (Downloader.class) {
            if (downloaderBuilder == null) {
                return;
            }
            if (instance == null) {
                instance = downloaderBuilder.build();
            } else if (!c.S()) {
                c.a(downloaderBuilder);
            } else {
                if (z) {
                    c.b(downloaderBuilder);
                }
            }
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.b
    public /* bridge */ /* synthetic */ void addMainThreadListener(int i, IDownloadListener iDownloadListener) {
        super.addMainThreadListener(i, iDownloadListener);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.b
    public /* bridge */ /* synthetic */ void addNotificationListener(int i, IDownloadListener iDownloadListener) {
        super.addNotificationListener(i, iDownloadListener);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.b
    public /* bridge */ /* synthetic */ void addSubThreadListener(int i, IDownloadListener iDownloadListener) {
        super.addSubThreadListener(i, iDownloadListener);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.b
    public /* bridge */ /* synthetic */ boolean canResume(int i) {
        return super.canResume(i);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.b
    public /* bridge */ /* synthetic */ void cancel(int i) {
        super.cancel(i);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.b
    public /* bridge */ /* synthetic */ void clearDownloadData(int i) {
        super.clearDownloadData(i);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.b
    public /* bridge */ /* synthetic */ void destoryDownloader() {
        super.destoryDownloader();
    }

    @Override // com.ss.android.socialbase.downloader.downloader.b
    public /* bridge */ /* synthetic */ void forceDownloadIngoreRecommendSize(int i) {
        super.forceDownloadIngoreRecommendSize(i);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.b
    public /* bridge */ /* synthetic */ List getAllDownloadInfo() {
        return super.getAllDownloadInfo();
    }

    @Override // com.ss.android.socialbase.downloader.downloader.b
    public /* bridge */ /* synthetic */ long getCurBytes(int i) {
        return super.getCurBytes(i);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.b
    public /* bridge */ /* synthetic */ IDownloadFileUriProvider getDownloadFileUriProvider(int i) {
        return super.getDownloadFileUriProvider(i);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.b
    public /* bridge */ /* synthetic */ int getDownloadId(String str, String str2) {
        return super.getDownloadId(str, str2);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.b
    public /* bridge */ /* synthetic */ DownloadInfo getDownloadInfo(int i) {
        return super.getDownloadInfo(i);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.b
    public /* bridge */ /* synthetic */ List getDownloadInfoList(String str) {
        return super.getDownloadInfoList(str);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.b
    public /* bridge */ /* synthetic */ z getDownloadNotificationEventListener(int i) {
        return super.getDownloadNotificationEventListener(i);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.b
    public /* bridge */ /* synthetic */ List getDownloadingDownloadInfosWithMimeType(String str) {
        return super.getDownloadingDownloadInfosWithMimeType(str);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.b
    public /* bridge */ /* synthetic */ List getFailedDownloadInfosWithMimeType(String str) {
        return super.getFailedDownloadInfosWithMimeType(str);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.b
    public /* bridge */ /* synthetic */ File getGlobalSaveDir() {
        return super.getGlobalSaveDir();
    }

    @Override // com.ss.android.socialbase.downloader.downloader.b
    public /* bridge */ /* synthetic */ File getGlobalSaveTempDir() {
        return super.getGlobalSaveTempDir();
    }

    @Override // com.ss.android.socialbase.downloader.downloader.b
    public /* bridge */ /* synthetic */ r getReserveWifiStatusListener() {
        return super.getReserveWifiStatusListener();
    }

    @Override // com.ss.android.socialbase.downloader.downloader.b
    public /* bridge */ /* synthetic */ int getStatus(int i) {
        return super.getStatus(i);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.b
    public /* bridge */ /* synthetic */ List getSuccessedDownloadInfosWithMimeType(String str) {
        return super.getSuccessedDownloadInfosWithMimeType(str);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.b
    public /* bridge */ /* synthetic */ List getUnCompletedDownloadInfosWithMimeType(String str) {
        return super.getUnCompletedDownloadInfosWithMimeType(str);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.b
    public /* bridge */ /* synthetic */ boolean isDownloadCacheSyncSuccess() {
        return super.isDownloadCacheSyncSuccess();
    }

    @Override // com.ss.android.socialbase.downloader.downloader.b
    public /* bridge */ /* synthetic */ boolean isDownloadServiceForeground(int i) {
        return super.isDownloadServiceForeground(i);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.b
    public /* bridge */ /* synthetic */ boolean isDownloadSuccessAndFileNotExist(DownloadInfo downloadInfo) {
        return super.isDownloadSuccessAndFileNotExist(downloadInfo);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.b
    public /* bridge */ /* synthetic */ boolean isDownloading(int i) {
        return super.isDownloading(i);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.b
    public /* bridge */ /* synthetic */ boolean isHttpServiceInit() {
        return super.isHttpServiceInit();
    }

    @Override // com.ss.android.socialbase.downloader.downloader.b
    public /* bridge */ /* synthetic */ void pause(int i) {
        super.pause(i);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.b
    public /* bridge */ /* synthetic */ void pauseAll() {
        super.pauseAll();
    }

    @Override // com.ss.android.socialbase.downloader.downloader.b
    public /* bridge */ /* synthetic */ void registerDownloadCacheSyncListener(com.ss.android.socialbase.downloader.depend.k kVar) {
        super.registerDownloadCacheSyncListener(kVar);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.b
    public /* bridge */ /* synthetic */ void registerDownloaderProcessConnectedListener(ab abVar) {
        super.registerDownloaderProcessConnectedListener(abVar);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.b
    public /* bridge */ /* synthetic */ void removeMainThreadListener(int i, IDownloadListener iDownloadListener) {
        super.removeMainThreadListener(i, iDownloadListener);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.b
    public /* bridge */ /* synthetic */ void removeNotificationListener(int i, IDownloadListener iDownloadListener) {
        super.removeNotificationListener(i, iDownloadListener);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.b
    public /* bridge */ /* synthetic */ void removeSubThreadListener(int i, IDownloadListener iDownloadListener) {
        super.removeSubThreadListener(i, iDownloadListener);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.b
    @Deprecated
    public /* bridge */ /* synthetic */ void removeTaskMainListener(int i) {
        super.removeTaskMainListener(i);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.b
    @Deprecated
    public /* bridge */ /* synthetic */ void removeTaskNotificationListener(int i) {
        super.removeTaskNotificationListener(i);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.b
    @Deprecated
    public /* bridge */ /* synthetic */ void removeTaskSubListener(int i) {
        super.removeTaskSubListener(i);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.b
    public /* bridge */ /* synthetic */ void restart(int i) {
        super.restart(i);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.b
    public /* bridge */ /* synthetic */ void restartAllFailedDownloadTasks(List list) {
        super.restartAllFailedDownloadTasks(list);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.b
    public /* bridge */ /* synthetic */ void restartAllPauseReserveOnWifiDownloadTasks(List list) {
        super.restartAllPauseReserveOnWifiDownloadTasks(list);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.b
    public /* bridge */ /* synthetic */ void resume(int i) {
        super.resume(i);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.b
    public /* bridge */ /* synthetic */ void setDefaultSavePath(String str) {
        super.setDefaultSavePath(str);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.b
    public /* bridge */ /* synthetic */ void setDefaultSaveTempPath(String str) {
        super.setDefaultSaveTempPath(str);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.b
    public /* bridge */ /* synthetic */ void setDownloadInMultiProcess() {
        super.setDownloadInMultiProcess();
    }

    @Override // com.ss.android.socialbase.downloader.downloader.b
    public /* bridge */ /* synthetic */ void setDownloadNotificationEventListener(int i, z zVar) {
        super.setDownloadNotificationEventListener(i, zVar);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.b
    public /* bridge */ /* synthetic */ void setLogLevel(int i) {
        super.setLogLevel(i);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.b
    @Deprecated
    public /* bridge */ /* synthetic */ void setMainThreadListener(int i, IDownloadListener iDownloadListener) {
        super.setMainThreadListener(i, iDownloadListener);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.b
    @Deprecated
    public /* bridge */ /* synthetic */ void setNotificationListener(int i, IDownloadListener iDownloadListener) {
        super.setNotificationListener(i, iDownloadListener);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.b
    public /* bridge */ /* synthetic */ void setReserveWifiStatusListener(r rVar) {
        super.setReserveWifiStatusListener(rVar);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.b
    @Deprecated
    public /* bridge */ /* synthetic */ void setSubThreadListener(int i, IDownloadListener iDownloadListener) {
        super.setSubThreadListener(i, iDownloadListener);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.b
    public /* bridge */ /* synthetic */ void setThrottleNetSpeed(int i, long j) {
        super.setThrottleNetSpeed(i, j);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.b
    public /* bridge */ /* synthetic */ void unRegisterDownloadCacheSyncListener(com.ss.android.socialbase.downloader.depend.k kVar) {
        super.unRegisterDownloadCacheSyncListener(kVar);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.b
    public /* bridge */ /* synthetic */ void unRegisterDownloaderProcessConnectedListener(ab abVar) {
        super.unRegisterDownloaderProcessConnectedListener(abVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Downloader(DownloaderBuilder downloaderBuilder) {
        c.a(downloaderBuilder);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.b
    public /* bridge */ /* synthetic */ void cancel(int i, boolean z) {
        super.cancel(i, z);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.b
    public /* bridge */ /* synthetic */ void clearDownloadData(int i, boolean z) {
        super.clearDownloadData(i, z);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.b
    public /* bridge */ /* synthetic */ DownloadInfo getDownloadInfo(String str, String str2) {
        return super.getDownloadInfo(str, str2);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.b
    @Deprecated
    public /* bridge */ /* synthetic */ void setMainThreadListener(int i, IDownloadListener iDownloadListener, boolean z) {
        super.setMainThreadListener(i, iDownloadListener, z);
    }
}
