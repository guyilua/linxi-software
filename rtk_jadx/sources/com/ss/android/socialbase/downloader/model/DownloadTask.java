package com.ss.android.socialbase.downloader.model;

import android.util.SparseArray;
import androidx.annotation.NonNull;
import com.ss.android.socialbase.downloader.constants.EnqueueType;
import com.ss.android.socialbase.downloader.constants.f;
import com.ss.android.socialbase.downloader.depend.IDownloadFileUriProvider;
import com.ss.android.socialbase.downloader.depend.IDownloadInterceptor;
import com.ss.android.socialbase.downloader.depend.IDownloadListener;
import com.ss.android.socialbase.downloader.depend.ae;
import com.ss.android.socialbase.downloader.depend.m;
import com.ss.android.socialbase.downloader.depend.n;
import com.ss.android.socialbase.downloader.depend.r;
import com.ss.android.socialbase.downloader.depend.w;
import com.ss.android.socialbase.downloader.depend.x;
import com.ss.android.socialbase.downloader.depend.z;
import com.ss.android.socialbase.downloader.downloader.g;
import com.ss.android.socialbase.downloader.downloader.h;
import com.ss.android.socialbase.downloader.downloader.p;
import com.ss.android.socialbase.downloader.downloader.s;
import com.ss.android.socialbase.downloader.exception.BaseException;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONObject;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class DownloadTask {
    private boolean autoSetHashCodeForSameTask;
    private g chunkAdjustCalculator;
    private h chunkStrategy;
    private n depend;
    private r diskSpaceHandler;
    private final List<m> downloadCompleteHandlers;
    private DownloadInfo downloadInfo;
    private DownloadInfo.a downloadInfoBuilder;
    private IDownloadFileUriProvider fileUriProvider;
    private w forbiddenHandler;
    private int hashCodeForSameTask;
    private IDownloadInterceptor interceptor;
    private final SparseArray<IDownloadListener> mainThreadListeners;
    private x monitorDepend;
    private boolean needDelayForCacheSync;
    private ae notificationClickCallback;
    private z notificationEventListener;
    private final SparseArray<IDownloadListener> notificationListeners;
    private s retryDelayTimeCalculator;
    private final SparseArray<f> singleListenerHashCodeMap;
    private final Map<f, IDownloadListener> singleListenerMap;
    private final SparseArray<IDownloadListener> subThreadListeners;

    public DownloadTask() {
        this.singleListenerMap = new ConcurrentHashMap();
        this.singleListenerHashCodeMap = new SparseArray<>();
        this.needDelayForCacheSync = false;
        this.downloadCompleteHandlers = new ArrayList();
        this.autoSetHashCodeForSameTask = true;
        this.downloadInfoBuilder = new DownloadInfo.a();
        this.mainThreadListeners = new SparseArray<>();
        this.subThreadListeners = new SparseArray<>();
        this.notificationListeners = new SparseArray<>();
    }

    private void addAll(SparseArray sparseArray, SparseArray sparseArray2) {
        if (sparseArray == null || sparseArray2 == null) {
            return;
        }
        int size = sparseArray.size();
        for (int i = 0; i < size; i++) {
            int keyAt = sparseArray.keyAt(i);
            sparseArray2.put(keyAt, sparseArray.get(keyAt));
        }
    }

    private void copyListeners(SparseArray<IDownloadListener> sparseArray, SparseArray<IDownloadListener> sparseArray2) {
        sparseArray.clear();
        for (int i = 0; i < sparseArray2.size(); i++) {
            int keyAt = sparseArray2.keyAt(i);
            IDownloadListener iDownloadListener = sparseArray2.get(keyAt);
            if (iDownloadListener != null) {
                sparseArray.put(keyAt, iDownloadListener);
            }
        }
    }

    private void removeAll(SparseArray sparseArray, SparseArray sparseArray2) {
        if (sparseArray == null || sparseArray2 == null) {
            return;
        }
        int size = sparseArray2.size();
        for (int i = 0; i < size; i++) {
            sparseArray.remove(sparseArray2.keyAt(i));
        }
    }

    private void setChunkCalculator() {
        if (this.downloadInfo.getThrottleNetSpeed() > 0) {
            chunkStategy(new h() { // from class: com.ss.android.socialbase.downloader.model.DownloadTask.2
                @Override // com.ss.android.socialbase.downloader.downloader.h
                public int a(long j) {
                    return 1;
                }
            });
        }
    }

    public DownloadTask addDownloadCompleteHandler(m mVar) {
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

    public void addDownloadListener(int i, IDownloadListener iDownloadListener, f fVar, boolean z) {
        Map<f, IDownloadListener> map;
        if (iDownloadListener == null) {
            return;
        }
        if (z && (map = this.singleListenerMap) != null) {
            map.put(fVar, iDownloadListener);
            synchronized (this.singleListenerHashCodeMap) {
                this.singleListenerHashCodeMap.put(i, fVar);
            }
        }
        SparseArray<IDownloadListener> downloadListeners = getDownloadListeners(fVar);
        if (downloadListeners == null) {
            return;
        }
        synchronized (downloadListeners) {
            downloadListeners.put(i, iDownloadListener);
        }
    }

    public void addListenerToDownloadingSameTask() {
        com.ss.android.socialbase.downloader.c.a.b("DownloadTask", "same task just tryDownloading, so add listener in last task instead of tryDownload");
        DownloadInfo downloadInfo = this.downloadInfo;
        if (downloadInfo != null && !downloadInfo.isAddListenerToSameTask()) {
            this.downloadInfo.setAddListenerToSameTask(true);
        }
        addListenerToDownloadingSameTask(f.MAIN);
        addListenerToDownloadingSameTask(f.SUB);
        com.ss.android.socialbase.downloader.d.a.a(this.monitorDepend, this.downloadInfo, new BaseException(1003, "has another same task, add Listener to old task"), 0);
    }

    public DownloadTask addListenerToSameTask(boolean z) {
        this.downloadInfoBuilder.p(z);
        return this;
    }

    public void asyncDownload(final p pVar) {
        com.ss.android.socialbase.downloader.h.d.a(new Runnable() { // from class: com.ss.android.socialbase.downloader.model.DownloadTask.1
            @Override // java.lang.Runnable
            public void run() {
                DownloadTask.this.download();
            }
        });
    }

    public synchronized int autoCalAndGetHashCodeForSameTask() {
        IDownloadListener singleDownloadListener = getSingleDownloadListener(f.MAIN);
        if (singleDownloadListener == null) {
            singleDownloadListener = getSingleDownloadListener(f.SUB);
        }
        if (singleDownloadListener != null) {
            this.hashCodeForSameTask = singleDownloadListener.hashCode();
        }
        return this.hashCodeForSameTask;
    }

    public DownloadTask autoResumed(boolean z) {
        this.downloadInfoBuilder.f(z);
        return this;
    }

    public DownloadTask autoSetHashCodeForSameTask(boolean z) {
        this.autoSetHashCodeForSameTask = z;
        return this;
    }

    public DownloadTask backUpUrlRetryCount(int i) {
        this.downloadInfoBuilder.c(i);
        return this;
    }

    public DownloadTask backUpUrls(List<String> list) {
        this.downloadInfoBuilder.b(list);
        return this;
    }

    public boolean canShowNotification() {
        DownloadInfo downloadInfo = this.downloadInfo;
        if (downloadInfo != null) {
            return downloadInfo.canShowNotification();
        }
        return false;
    }

    public DownloadTask chunkAdjustCalculator(g gVar) {
        this.chunkAdjustCalculator = gVar;
        return this;
    }

    public DownloadTask chunkStategy(h hVar) {
        this.chunkStrategy = hVar;
        return this;
    }

    public void copyInterfaceFromNewTask(DownloadTask downloadTask) {
        this.chunkAdjustCalculator = downloadTask.chunkAdjustCalculator;
        this.chunkStrategy = downloadTask.chunkStrategy;
        this.singleListenerMap.clear();
        this.singleListenerMap.putAll(downloadTask.singleListenerMap);
        synchronized (this.mainThreadListeners) {
            this.mainThreadListeners.clear();
            addAll(downloadTask.mainThreadListeners, this.mainThreadListeners);
        }
        synchronized (this.subThreadListeners) {
            this.subThreadListeners.clear();
            addAll(downloadTask.subThreadListeners, this.subThreadListeners);
        }
        synchronized (this.notificationListeners) {
            this.notificationListeners.clear();
            addAll(downloadTask.notificationListeners, this.notificationListeners);
        }
        this.notificationEventListener = downloadTask.notificationEventListener;
        this.interceptor = downloadTask.interceptor;
        this.depend = downloadTask.depend;
        this.monitorDepend = downloadTask.monitorDepend;
        this.forbiddenHandler = downloadTask.forbiddenHandler;
        this.diskSpaceHandler = downloadTask.diskSpaceHandler;
        this.retryDelayTimeCalculator = downloadTask.retryDelayTimeCalculator;
        this.notificationClickCallback = downloadTask.notificationClickCallback;
        this.fileUriProvider = downloadTask.fileUriProvider;
        synchronized (this.downloadCompleteHandlers) {
            this.downloadCompleteHandlers.clear();
            this.downloadCompleteHandlers.addAll(downloadTask.downloadCompleteHandlers);
        }
    }

    public void copyListenerFromPendingTask(DownloadTask downloadTask) {
        for (Map.Entry<f, IDownloadListener> entry : downloadTask.singleListenerMap.entrySet()) {
            if (entry != null && !this.singleListenerMap.containsKey(entry.getKey())) {
                this.singleListenerMap.put(entry.getKey(), entry.getValue());
            }
        }
        try {
            if (downloadTask.mainThreadListeners.size() != 0) {
                synchronized (this.mainThreadListeners) {
                    removeAll(this.mainThreadListeners, downloadTask.mainThreadListeners);
                    addAll(downloadTask.mainThreadListeners, this.mainThreadListeners);
                }
            }
            if (downloadTask.subThreadListeners.size() != 0) {
                synchronized (this.subThreadListeners) {
                    removeAll(this.subThreadListeners, downloadTask.subThreadListeners);
                    addAll(downloadTask.subThreadListeners, this.subThreadListeners);
                }
            }
            if (downloadTask.notificationListeners.size() != 0) {
                synchronized (this.notificationListeners) {
                    removeAll(this.notificationListeners, downloadTask.notificationListeners);
                    addAll(downloadTask.notificationListeners, this.notificationListeners);
                }
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public DownloadTask deleteCacheIfCheckFailed(boolean z) {
        this.downloadInfoBuilder.t(z);
        return this;
    }

    public DownloadTask depend(n nVar) {
        this.depend = nVar;
        return this;
    }

    public DownloadTask diskSpaceHandler(r rVar) {
        this.diskSpaceHandler = rVar;
        return this;
    }

    public DownloadTask distinctDirectory(boolean z) {
        this.downloadInfoBuilder.u(z);
        return this;
    }

    public int download() {
        this.downloadInfo = this.downloadInfoBuilder.a();
        DownloadInfo b = com.ss.android.socialbase.downloader.downloader.c.y().b(this.downloadInfo.getId());
        if (b == null) {
            this.downloadInfo.generateTaskId();
            com.ss.android.socialbase.downloader.d.a.a(this, (BaseException) null, 0);
        } else {
            this.downloadInfo.copyTaskIdFromCacheData(b);
        }
        setChunkCalculator();
        com.ss.android.socialbase.downloader.downloader.d.a().a(this);
        DownloadInfo downloadInfo = this.downloadInfo;
        if (downloadInfo == null) {
            return 0;
        }
        return downloadInfo.getId();
    }

    public DownloadTask downloadSetting(JSONObject jSONObject) {
        this.downloadInfoBuilder.a(jSONObject);
        return this;
    }

    public DownloadTask enqueueType(EnqueueType enqueueType) {
        this.downloadInfoBuilder.a(enqueueType);
        return this;
    }

    public DownloadTask executorGroup(int i) {
        this.downloadInfoBuilder.f(i);
        return this;
    }

    public DownloadTask expectFileLength(long j) {
        this.downloadInfoBuilder.a(j);
        return this;
    }

    public DownloadTask expiredRedownload(boolean z) {
        this.downloadInfoBuilder.s(z);
        return this;
    }

    public DownloadTask extra(String str) {
        this.downloadInfoBuilder.g(str);
        return this;
    }

    public DownloadTask extraHeaders(List<c> list) {
        this.downloadInfoBuilder.a(list);
        return this;
    }

    public DownloadTask extraMonitorStatus(int[] iArr) {
        this.downloadInfoBuilder.b(iArr);
        return this;
    }

    public DownloadTask fileUriProvider(IDownloadFileUriProvider iDownloadFileUriProvider) {
        this.fileUriProvider = iDownloadFileUriProvider;
        return this;
    }

    public DownloadTask forbiddenHandler(w wVar) {
        this.forbiddenHandler = wVar;
        return this;
    }

    public DownloadTask force(boolean z) {
        this.downloadInfoBuilder.b(z);
        return this;
    }

    public g getChunkAdjustCalculator() {
        return this.chunkAdjustCalculator;
    }

    public h getChunkStrategy() {
        return this.chunkStrategy;
    }

    public n getDepend() {
        return this.depend;
    }

    public r getDiskSpaceHandler() {
        return this.diskSpaceHandler;
    }

    public m getDownloadCompleteHandlerByIndex(int i) {
        synchronized (this.downloadCompleteHandlers) {
            if (i >= this.downloadCompleteHandlers.size()) {
                return null;
            }
            return this.downloadCompleteHandlers.get(i);
        }
    }

    @NonNull
    public List<m> getDownloadCompleteHandlers() {
        return this.downloadCompleteHandlers;
    }

    public int getDownloadId() {
        DownloadInfo downloadInfo = this.downloadInfo;
        if (downloadInfo == null) {
            return 0;
        }
        return downloadInfo.getId();
    }

    public DownloadInfo getDownloadInfo() {
        return this.downloadInfo;
    }

    public IDownloadListener getDownloadListenerByIndex(f fVar, int i) {
        SparseArray<IDownloadListener> downloadListeners = getDownloadListeners(fVar);
        if (downloadListeners == null || i < 0) {
            return null;
        }
        synchronized (downloadListeners) {
            if (i >= downloadListeners.size()) {
                return null;
            }
            return downloadListeners.get(downloadListeners.keyAt(i));
        }
    }

    public int getDownloadListenerSize(f fVar) {
        int size;
        SparseArray<IDownloadListener> downloadListeners = getDownloadListeners(fVar);
        if (downloadListeners == null) {
            return 0;
        }
        synchronized (downloadListeners) {
            size = downloadListeners.size();
        }
        return size;
    }

    public SparseArray<IDownloadListener> getDownloadListeners(f fVar) {
        if (fVar == f.MAIN) {
            return this.mainThreadListeners;
        }
        if (fVar == f.SUB) {
            return this.subThreadListeners;
        }
        if (fVar == f.NOTIFICATION) {
            return this.notificationListeners;
        }
        return null;
    }

    public IDownloadFileUriProvider getFileUriProvider() {
        return this.fileUriProvider;
    }

    public w getForbiddenHandler() {
        return this.forbiddenHandler;
    }

    public int getHashCodeForSameTask() {
        return this.hashCodeForSameTask;
    }

    public IDownloadInterceptor getInterceptor() {
        return this.interceptor;
    }

    public x getMonitorDepend() {
        return this.monitorDepend;
    }

    public ae getNotificationClickCallback() {
        return this.notificationClickCallback;
    }

    public z getNotificationEventListener() {
        return this.notificationEventListener;
    }

    public s getRetryDelayTimeCalculator() {
        return this.retryDelayTimeCalculator;
    }

    public IDownloadListener getSingleDownloadListener(f fVar) {
        return this.singleListenerMap.get(fVar);
    }

    public DownloadTask hashCodeForSameTask(int i) {
        this.hashCodeForSameTask = i;
        return this;
    }

    public DownloadTask headConnectionAvailable(boolean z) {
        this.downloadInfoBuilder.m(z);
        return this;
    }

    public DownloadTask iconUrl(String str) {
        this.downloadInfoBuilder.m(str);
        return this;
    }

    public DownloadTask ignoreDataVerify(boolean z) {
        this.downloadInfoBuilder.n(z);
        return this;
    }

    public DownloadTask interceptor(IDownloadInterceptor iDownloadInterceptor) {
        this.interceptor = iDownloadInterceptor;
        return this;
    }

    public boolean isAutoSetHashCodeForSameTask() {
        return this.autoSetHashCodeForSameTask;
    }

    public boolean isNeedDelayForCacheSync() {
        return this.needDelayForCacheSync;
    }

    public DownloadTask isOpenLimitSpeed(boolean z) {
        this.downloadInfoBuilder.r(z);
        return this;
    }

    public DownloadTask mainThreadListener(IDownloadListener iDownloadListener) {
        return iDownloadListener == null ? this : mainThreadListenerWithHashCode(iDownloadListener.hashCode(), iDownloadListener);
    }

    public DownloadTask mainThreadListenerWithHashCode(int i, IDownloadListener iDownloadListener) {
        if (iDownloadListener != null) {
            synchronized (this.mainThreadListeners) {
                this.mainThreadListeners.put(i, iDownloadListener);
            }
            Map<f, IDownloadListener> map = this.singleListenerMap;
            f fVar = f.MAIN;
            map.put(fVar, iDownloadListener);
            synchronized (this.singleListenerHashCodeMap) {
                this.singleListenerHashCodeMap.put(i, fVar);
            }
        }
        return this;
    }

    public DownloadTask maxBytes(int i) {
        this.downloadInfoBuilder.a(i);
        return this;
    }

    public DownloadTask maxProgressCount(int i) {
        this.downloadInfoBuilder.d(i);
        return this;
    }

    public DownloadTask md5(String str) {
        this.downloadInfoBuilder.j(str);
        return this;
    }

    public DownloadTask mimeType(String str) {
        this.downloadInfoBuilder.h(str);
        return this;
    }

    public DownloadTask minProgressTimeMsInterval(int i) {
        this.downloadInfoBuilder.e(i);
        return this;
    }

    public DownloadTask monitorDepend(x xVar) {
        this.monitorDepend = xVar;
        return this;
    }

    public DownloadTask monitorScene(String str) {
        this.downloadInfoBuilder.l(str);
        return this;
    }

    public DownloadTask name(String str) {
        this.downloadInfoBuilder.a(str);
        return this;
    }

    public DownloadTask needChunkDowngradeRetry(boolean z) {
        this.downloadInfoBuilder.o(z);
        return this;
    }

    public DownloadTask needDefaultHttpServiceBackUp(boolean z) {
        this.downloadInfoBuilder.h(z);
        return this;
    }

    public DownloadTask needHttpsToHttpRetry(boolean z) {
        this.downloadInfoBuilder.d(z);
        return this;
    }

    public DownloadTask needIndependentProcess(boolean z) {
        this.downloadInfoBuilder.l(z);
        return this;
    }

    public DownloadTask needPostProgress(boolean z) {
        this.downloadInfoBuilder.c(z);
        return this;
    }

    public DownloadTask needRetryDelay(boolean z) {
        this.downloadInfoBuilder.j(z);
        return this;
    }

    public DownloadTask needReuseChunkRunnable(boolean z) {
        this.downloadInfoBuilder.i(z);
        return this;
    }

    public DownloadTask needReuseFirstConnection(boolean z) {
        this.downloadInfoBuilder.k(z);
        return this;
    }

    public DownloadTask needSDKMonitor(boolean z) {
        this.downloadInfoBuilder.q(z);
        return this;
    }

    @Deprecated
    public DownloadTask newSaveTempFileEnable(boolean z) {
        return this;
    }

    public DownloadTask notificationClickCallback(ae aeVar) {
        this.notificationClickCallback = aeVar;
        return this;
    }

    public DownloadTask notificationEventListener(z zVar) {
        this.notificationEventListener = zVar;
        return this;
    }

    public DownloadTask notificationListener(IDownloadListener iDownloadListener) {
        return iDownloadListener == null ? this : notificationListenerWithHashCode(iDownloadListener.hashCode(), iDownloadListener);
    }

    public DownloadTask notificationListenerWithHashCode(int i, IDownloadListener iDownloadListener) {
        if (iDownloadListener != null) {
            synchronized (this.notificationListeners) {
                this.notificationListeners.put(i, iDownloadListener);
            }
            Map<f, IDownloadListener> map = this.singleListenerMap;
            f fVar = f.NOTIFICATION;
            map.put(fVar, iDownloadListener);
            synchronized (this.singleListenerHashCodeMap) {
                this.singleListenerHashCodeMap.put(i, fVar);
            }
        }
        return this;
    }

    public DownloadTask onlyWifi(boolean z) {
        this.downloadInfoBuilder.a(z);
        return this;
    }

    public DownloadTask outIp(String[] strArr) {
        this.downloadInfoBuilder.a(strArr);
        return this;
    }

    public DownloadTask outSize(int[] iArr) {
        this.downloadInfoBuilder.a(iArr);
        return this;
    }

    public DownloadTask packageName(String str) {
        this.downloadInfoBuilder.i(str);
        return this;
    }

    public void removeDownloadListener(int i, IDownloadListener iDownloadListener, f fVar, boolean z) {
        int indexOfValue;
        SparseArray<IDownloadListener> downloadListeners = getDownloadListeners(fVar);
        if (downloadListeners == null) {
            if (z && this.singleListenerMap.containsKey(fVar)) {
                this.singleListenerMap.remove(fVar);
                return;
            }
            return;
        }
        synchronized (downloadListeners) {
            if (z) {
                if (this.singleListenerMap.containsKey(fVar)) {
                    iDownloadListener = this.singleListenerMap.get(fVar);
                    this.singleListenerMap.remove(fVar);
                }
                if (iDownloadListener != null && (indexOfValue = downloadListeners.indexOfValue(iDownloadListener)) >= 0 && indexOfValue < downloadListeners.size()) {
                    downloadListeners.removeAt(indexOfValue);
                }
            } else {
                downloadListeners.remove(i);
                synchronized (this.singleListenerHashCodeMap) {
                    f fVar2 = this.singleListenerHashCodeMap.get(i);
                    if (fVar2 != null && this.singleListenerMap.containsKey(fVar2)) {
                        this.singleListenerMap.remove(fVar2);
                        this.singleListenerHashCodeMap.remove(i);
                    }
                }
            }
        }
    }

    public DownloadTask retryCount(int i) {
        this.downloadInfoBuilder.b(i);
        return this;
    }

    public DownloadTask retryDelayTimeArray(String str) {
        this.downloadInfoBuilder.k(str);
        return this;
    }

    public DownloadTask retryDelayTimeCalculator(s sVar) {
        this.retryDelayTimeCalculator = sVar;
        return this;
    }

    public DownloadTask savePath(String str) {
        this.downloadInfoBuilder.e(str);
        return this;
    }

    public DownloadTask setAutoInstall(boolean z) {
        this.downloadInfoBuilder.v(z);
        return this;
    }

    public DownloadTask setDownloadCompleteHandlers(List<m> list) {
        if (list != null && !list.isEmpty()) {
            Iterator<m> it = list.iterator();
            while (it.hasNext()) {
                addDownloadCompleteHandler(it.next());
            }
        }
        return this;
    }

    public void setDownloadListeners(SparseArray<IDownloadListener> sparseArray, f fVar) {
        if (sparseArray == null) {
            return;
        }
        try {
            if (fVar == f.MAIN) {
                synchronized (this.mainThreadListeners) {
                    copyListeners(this.mainThreadListeners, sparseArray);
                }
                return;
            } else if (fVar == f.SUB) {
                synchronized (this.subThreadListeners) {
                    copyListeners(this.subThreadListeners, sparseArray);
                }
                return;
            } else {
                if (fVar == f.NOTIFICATION) {
                    synchronized (this.notificationListeners) {
                        copyListeners(this.notificationListeners, sparseArray);
                    }
                    return;
                }
                return;
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
        th.printStackTrace();
    }

    public void setNeedDelayForCacheSync(boolean z) {
        this.needDelayForCacheSync = z;
    }

    public void setNotificationEventListener(z zVar) {
        this.notificationEventListener = zVar;
    }

    public DownloadTask showNotification(boolean z) {
        this.downloadInfoBuilder.e(z);
        return this;
    }

    public DownloadTask showNotificationForAutoResumed(boolean z) {
        this.downloadInfoBuilder.g(z);
        return this;
    }

    public DownloadTask subThreadListener(IDownloadListener iDownloadListener) {
        return iDownloadListener == null ? this : subThreadListenerWithHashCode(iDownloadListener.hashCode(), iDownloadListener);
    }

    public DownloadTask subThreadListenerWithHashCode(int i, IDownloadListener iDownloadListener) {
        if (iDownloadListener != null) {
            synchronized (this.subThreadListeners) {
                this.subThreadListeners.put(i, iDownloadListener);
            }
            Map<f, IDownloadListener> map = this.singleListenerMap;
            f fVar = f.SUB;
            map.put(fVar, iDownloadListener);
            synchronized (this.singleListenerHashCodeMap) {
                this.singleListenerHashCodeMap.put(i, fVar);
            }
        }
        return this;
    }

    public DownloadTask taskKey(String str) {
        this.downloadInfoBuilder.d(str);
        return this;
    }

    public DownloadTask tempPath(String str) {
        this.downloadInfoBuilder.f(str);
        return this;
    }

    public DownloadTask throttleNetSpeed(long j) {
        this.downloadInfoBuilder.b(j);
        return this;
    }

    public DownloadTask title(String str) {
        this.downloadInfoBuilder.b(str);
        return this;
    }

    public DownloadTask ttnetProtectTimeout(long j) {
        this.downloadInfoBuilder.c(j);
        return this;
    }

    public DownloadTask url(String str) {
        this.downloadInfoBuilder.c(str);
        return this;
    }

    private void addListenerToDownloadingSameTask(f fVar) {
        SparseArray<IDownloadListener> downloadListeners = getDownloadListeners(fVar);
        synchronized (downloadListeners) {
            for (int i = 0; i < downloadListeners.size(); i++) {
                IDownloadListener iDownloadListener = downloadListeners.get(downloadListeners.keyAt(i));
                if (iDownloadListener != null) {
                    com.ss.android.socialbase.downloader.downloader.d.a().b(getDownloadId(), iDownloadListener, fVar, false);
                }
            }
        }
    }

    public DownloadTask(DownloadInfo downloadInfo) {
        this();
        this.downloadInfo = downloadInfo;
    }
}
