package com.ss.android.socialbase.downloader.downloader;

import android.content.Context;
import com.ss.android.socialbase.downloader.depend.aa;
import com.ss.android.socialbase.downloader.depend.ae;
import com.ss.android.socialbase.downloader.network.IDownloadHttpService;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class DownloaderBuilder {
    private g chunkAdjustCalculator;
    private h chunkCntCalculator;
    private ExecutorService chunkDownloadExecutor;
    private final Context context;
    private ExecutorService cpuThreadExecutor;
    private ExecutorService dbThreadExecutor;
    private j downloadCache;
    private com.ss.android.socialbase.downloader.network.f downloadDns;
    private boolean downloadInMultiProcess;
    private l downloadLaunchHandler;
    private com.ss.android.socialbase.downloader.d.b downloadMonitorListener;
    private aa downloadSetting;
    private com.ss.android.socialbase.downloader.network.h headHttpService;
    private IDownloadHttpService httpService;
    private k idGenerator;
    private ExecutorService ioThreadExecutor;
    private int maxDownloadPoolSize;
    private ExecutorService mixApkDownloadExecutor;
    private ExecutorService mixDefaultDownloadExecutor;
    private ExecutorService mixFrequentDownloadExecutor;
    private q monitorConfig;
    private ae notificationClickCallback;
    private ExecutorService okHttpDispatcherExecutor;
    private u ttNetHandler;
    private int writeBufferSize;
    private List<com.ss.android.socialbase.downloader.depend.m> downloadCompleteHandlers = new ArrayList();
    private boolean needAutoRefreshUnSuccessTask = true;
    private int downloadExpSwitch = 1056964607;

    public DownloaderBuilder(Context context) {
        this.context = context;
    }

    public DownloaderBuilder addDownloadCompleteHandler(com.ss.android.socialbase.downloader.depend.m mVar) {
        synchronized (this.downloadCompleteHandlers) {
            if (mVar != null) {
                if (!this.downloadCompleteHandlers.contains(mVar)) {
                    this.downloadCompleteHandlers.add(mVar);
                    return this;
                }
            }
            return this;
        }
    }

    public Downloader build() {
        return new Downloader(this);
    }

    public DownloaderBuilder chunkAdjustCalculator(g gVar) {
        this.chunkAdjustCalculator = gVar;
        return this;
    }

    public DownloaderBuilder chunkCntCalculator(h hVar) {
        this.chunkCntCalculator = hVar;
        return this;
    }

    public DownloaderBuilder chunkThreadExecutor(ExecutorService executorService) {
        this.chunkDownloadExecutor = executorService;
        return this;
    }

    public DownloaderBuilder cpuThreadExecutor(ExecutorService executorService) {
        this.cpuThreadExecutor = executorService;
        return this;
    }

    public DownloaderBuilder dbThreadExecutor(ExecutorService executorService) {
        this.dbThreadExecutor = executorService;
        return this;
    }

    public DownloaderBuilder downloadCache(j jVar) {
        this.downloadCache = jVar;
        return this;
    }

    public DownloaderBuilder downloadDns(com.ss.android.socialbase.downloader.network.f fVar) {
        this.downloadDns = fVar;
        return this;
    }

    public DownloaderBuilder downloadExpSwitch(int i) {
        this.downloadExpSwitch = i;
        return this;
    }

    public DownloaderBuilder downloadInMultiProcess(boolean z) {
        this.downloadInMultiProcess = z;
        return this;
    }

    public DownloaderBuilder downloadLaunchHandler(l lVar) {
        this.downloadLaunchHandler = lVar;
        return this;
    }

    public DownloaderBuilder downloadMonitorListener(com.ss.android.socialbase.downloader.d.b bVar) {
        this.downloadMonitorListener = bVar;
        return this;
    }

    public DownloaderBuilder downloadSetting(aa aaVar) {
        this.downloadSetting = aaVar;
        return this;
    }

    public ExecutorService getCPUThreadExecutor() {
        return this.cpuThreadExecutor;
    }

    public g getChunkAdjustCalculator() {
        return this.chunkAdjustCalculator;
    }

    public h getChunkCntCalculator() {
        return this.chunkCntCalculator;
    }

    public ExecutorService getChunkThreadExecutor() {
        return this.chunkDownloadExecutor;
    }

    public Context getContext() {
        return this.context;
    }

    public ExecutorService getDBThreadExecutor() {
        return this.dbThreadExecutor;
    }

    public j getDownloadCache() {
        return this.downloadCache;
    }

    public List<com.ss.android.socialbase.downloader.depend.m> getDownloadCompleteHandlers() {
        return this.downloadCompleteHandlers;
    }

    public com.ss.android.socialbase.downloader.network.f getDownloadDns() {
        return this.downloadDns;
    }

    public int getDownloadExpSwitch() {
        return this.downloadExpSwitch;
    }

    public l getDownloadLaunchHandler() {
        return this.downloadLaunchHandler;
    }

    public com.ss.android.socialbase.downloader.d.b getDownloadMonitorListener() {
        return this.downloadMonitorListener;
    }

    public aa getDownloadSetting() {
        return this.downloadSetting;
    }

    public com.ss.android.socialbase.downloader.network.h getHeadHttpService() {
        return this.headHttpService;
    }

    public IDownloadHttpService getHttpService() {
        return this.httpService;
    }

    public ExecutorService getIOThreadExecutor() {
        return this.ioThreadExecutor;
    }

    public k getIdGenerator() {
        return this.idGenerator;
    }

    public int getMaxDownloadPoolSize() {
        return this.maxDownloadPoolSize;
    }

    public ExecutorService getMixApkDownloadExecutor() {
        return this.mixApkDownloadExecutor;
    }

    public ExecutorService getMixDefaultDownloadExecutor() {
        return this.mixDefaultDownloadExecutor;
    }

    public ExecutorService getMixFrequentDownloadExecutor() {
        return this.mixFrequentDownloadExecutor;
    }

    public q getMonitorConfig() {
        return this.monitorConfig;
    }

    public ae getNotificationClickCallback() {
        return this.notificationClickCallback;
    }

    public ExecutorService getOkHttpDispatcherExecutor() {
        return this.okHttpDispatcherExecutor;
    }

    public u getTTNetHandler() {
        return this.ttNetHandler;
    }

    public int getWriteBufferSize() {
        return this.writeBufferSize;
    }

    public DownloaderBuilder headHttpService(com.ss.android.socialbase.downloader.network.h hVar) {
        this.headHttpService = hVar;
        return this;
    }

    public DownloaderBuilder httpService(IDownloadHttpService iDownloadHttpService) {
        this.httpService = iDownloadHttpService;
        return this;
    }

    public DownloaderBuilder idGenerator(k kVar) {
        this.idGenerator = kVar;
        return this;
    }

    public DownloaderBuilder ioThreadExecutor(ExecutorService executorService) {
        this.ioThreadExecutor = executorService;
        return this;
    }

    public boolean isDownloadInMultiProcess() {
        return this.downloadInMultiProcess;
    }

    public DownloaderBuilder maxDownloadPoolSize(int i) {
        this.maxDownloadPoolSize = i;
        return this;
    }

    public DownloaderBuilder mixApkDownloadExecutor(ExecutorService executorService) {
        this.mixApkDownloadExecutor = executorService;
        return this;
    }

    public DownloaderBuilder mixDefaultDownloadExecutor(ExecutorService executorService) {
        this.mixDefaultDownloadExecutor = executorService;
        return this;
    }

    public DownloaderBuilder mixFrequentDownloadExecutor(ExecutorService executorService) {
        this.mixFrequentDownloadExecutor = executorService;
        return this;
    }

    public DownloaderBuilder monitorConfig(q qVar) {
        this.monitorConfig = qVar;
        return this;
    }

    public DownloaderBuilder needAutoRefreshUnSuccessTask(boolean z) {
        this.needAutoRefreshUnSuccessTask = z;
        return this;
    }

    public DownloaderBuilder notificationClickCallback(ae aeVar) {
        this.notificationClickCallback = aeVar;
        return this;
    }

    public DownloaderBuilder okHttpDispatcherExecutor(ExecutorService executorService) {
        this.okHttpDispatcherExecutor = executorService;
        return this;
    }

    public DownloaderBuilder ttNetHandler(u uVar) {
        this.ttNetHandler = uVar;
        return this;
    }

    public DownloaderBuilder writeBufferSize(int i) {
        this.writeBufferSize = i;
        return this;
    }

    public boolean needAutoRefreshUnSuccessTask() {
        return this.needAutoRefreshUnSuccessTask;
    }
}
