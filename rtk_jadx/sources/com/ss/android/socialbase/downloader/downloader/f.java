package com.ss.android.socialbase.downloader.downloader;

import android.content.Context;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteFullException;
import android.os.Handler;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Log;
import android.util.SparseArray;
import com.ss.android.socialbase.downloader.constants.DownloadStatus;
import com.ss.android.socialbase.downloader.depend.IDownloadListener;
import com.ss.android.socialbase.downloader.depend.ah;
import com.ss.android.socialbase.downloader.depend.x;
import com.ss.android.socialbase.downloader.exception.BaseException;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import com.ss.android.socialbase.downloader.model.DownloadTask;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.atomic.AtomicLong;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class f {
    private static final String a = "f";
    private final boolean b;

    /* renamed from: c, reason: collision with root package name */
    private DownloadInfo f855c;
    private final j d;
    private final Handler e;
    private DownloadTask f;
    private SparseArray<IDownloadListener> g;
    private SparseArray<IDownloadListener> h;
    private SparseArray<IDownloadListener> i;
    private boolean j = false;
    private volatile long k = 0;
    private final AtomicLong l = new AtomicLong();
    private boolean m = false;
    private int n;
    private long o;
    private com.ss.android.socialbase.downloader.depend.n p;
    private x q;

    public f(DownloadTask downloadTask, Handler handler) {
        this.f = downloadTask;
        j();
        this.e = handler;
        this.d = c.y();
        DownloadInfo downloadInfo = downloadTask.getDownloadInfo();
        if (downloadInfo != null) {
            this.b = com.ss.android.socialbase.downloader.g.a.a(downloadInfo.getId()).a("fix_start_with_file_exist_update_error");
        } else {
            this.b = false;
        }
    }

    private void j() {
        DownloadTask downloadTask = this.f;
        if (downloadTask != null) {
            this.f855c = downloadTask.getDownloadInfo();
            this.g = this.f.getDownloadListeners(com.ss.android.socialbase.downloader.constants.f.MAIN);
            this.i = this.f.getDownloadListeners(com.ss.android.socialbase.downloader.constants.f.NOTIFICATION);
            this.h = this.f.getDownloadListeners(com.ss.android.socialbase.downloader.constants.f.SUB);
            this.p = this.f.getDepend();
            this.q = this.f.getMonitorDepend();
        }
    }

    private void k() {
        ExecutorService l = c.l();
        if (l != null) {
            l.execute(new Runnable() { // from class: com.ss.android.socialbase.downloader.downloader.f.1
                @Override // java.lang.Runnable
                public void run() {
                    f.this.d.i(f.this.f855c.getId());
                    f.this.a(1, (BaseException) null);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void l() {
        try {
            com.ss.android.socialbase.downloader.c.a.b(a, "saveFileAsTargetName onSuccess");
            try {
                m();
                this.f855c.setFirstSuccess(false);
                this.f855c.setSuccessByCache(false);
                a(-3, (BaseException) null);
                this.d.c(this.f855c.getId(), this.f855c.getTotalBytes());
                this.d.d(this.f855c.getId());
                this.d.m(this.f855c.getId());
            } catch (BaseException e) {
                a(e);
            }
        } catch (Throwable th) {
            a(new BaseException(1008, com.ss.android.socialbase.downloader.i.f.b(th, "onCompleted")));
        }
    }

    private void m() {
        List<com.ss.android.socialbase.downloader.depend.m> downloadCompleteHandlers = this.f.getDownloadCompleteHandlers();
        if (downloadCompleteHandlers.isEmpty()) {
            return;
        }
        DownloadInfo downloadInfo = this.f855c;
        a(11, (BaseException) null);
        this.d.a(downloadInfo);
        for (com.ss.android.socialbase.downloader.depend.m mVar : downloadCompleteHandlers) {
            try {
                if (mVar.b(downloadInfo)) {
                    mVar.a(downloadInfo);
                    this.d.a(downloadInfo);
                }
            } catch (BaseException e) {
                throw e;
            } catch (Throwable th) {
                throw new BaseException(1071, th);
            }
        }
    }

    public void d() {
        this.f855c.setStatus(-2);
        try {
            this.d.d(this.f855c.getId(), this.f855c.getCurBytes());
        } catch (SQLiteException e) {
            e.printStackTrace();
        }
        a(-2, (BaseException) null);
    }

    public void e() {
        this.f855c.setStatus(-7);
        try {
            this.d.j(this.f855c.getId());
        } catch (SQLiteException e) {
            e.printStackTrace();
        }
        a(-7, (BaseException) null);
    }

    public void f() {
        this.f855c.setFirstDownload(false);
        if (!this.f855c.isIgnoreDataVerify() && this.f855c.getCurBytes() != this.f855c.getTotalBytes()) {
            com.ss.android.socialbase.downloader.c.a.b(a, this.f855c.getErrorBytesLog());
            a(new com.ss.android.socialbase.downloader.exception.f(1027, "current bytes is not equals to total bytes, bytes changed with process : " + this.f855c.getByteInvalidRetryStatus()));
            return;
        }
        if (this.f855c.getCurBytes() <= 0) {
            com.ss.android.socialbase.downloader.c.a.b(a, this.f855c.getErrorBytesLog());
            a(new com.ss.android.socialbase.downloader.exception.f(1026, "curBytes is 0, bytes changed with process : " + this.f855c.getByteInvalidRetryStatus()));
            return;
        }
        if (!this.f855c.isIgnoreDataVerify() && this.f855c.getTotalBytes() <= 0) {
            com.ss.android.socialbase.downloader.c.a.b(a, this.f855c.getErrorBytesLog());
            a(new com.ss.android.socialbase.downloader.exception.f(1044, "TotalBytes is 0, bytes changed with process : " + this.f855c.getByteInvalidRetryStatus()));
            return;
        }
        com.ss.android.socialbase.downloader.c.a.b(a, this.f855c.getName() + " onCompleted start save file as target name");
        x xVar = this.q;
        DownloadTask downloadTask = this.f;
        if (downloadTask != null) {
            xVar = downloadTask.getMonitorDepend();
        }
        com.ss.android.socialbase.downloader.i.f.a(this.f855c, xVar, new ah() { // from class: com.ss.android.socialbase.downloader.downloader.f.2
            @Override // com.ss.android.socialbase.downloader.depend.ah
            public void a() {
                f.this.l();
            }

            @Override // com.ss.android.socialbase.downloader.depend.ah
            public void a(BaseException baseException) {
                String str = f.a;
                StringBuilder sb = new StringBuilder("saveFileAsTargetName onFailed : ");
                sb.append(baseException != null ? baseException.getErrorMessage() : "");
                com.ss.android.socialbase.downloader.c.a.b(str, sb.toString());
                f.this.a(baseException);
            }
        });
    }

    public void g() {
        if (this.b) {
            m();
            com.ss.android.socialbase.downloader.c.a.b(a, "onCompleteForFileExist");
            this.f855c.setSuccessByCache(true);
            a(-3, (BaseException) null);
            this.d.c(this.f855c.getId(), this.f855c.getTotalBytes());
            this.d.d(this.f855c.getId());
            this.d.a(this.f855c);
            this.d.m(this.f855c.getId());
            return;
        }
        m();
        com.ss.android.socialbase.downloader.c.a.b(a, "onCompleteForFileExist");
        this.f855c.setSuccessByCache(true);
        a(-3, (BaseException) null);
        this.d.c(this.f855c.getId(), this.f855c.getTotalBytes());
        this.d.d(this.f855c.getId());
        this.d.m(this.f855c.getId());
    }

    public void h() {
        this.f855c.setStatus(8);
        this.f855c.setAsyncHandleStatus(com.ss.android.socialbase.downloader.constants.a.ASYNC_HANDLE_WAITING);
        com.ss.android.socialbase.downloader.impls.a D = c.D();
        if (D != null) {
            D.a(this.f855c.getId(), this.f.getHashCodeForSameTask(), 8);
        }
    }

    public void b() {
        if (this.f855c.canSkipStatusHandler()) {
            this.f855c.changeSkipStatus();
            return;
        }
        this.d.g(this.f855c.getId());
        if (this.f855c.isFirstDownload()) {
            a(6, (BaseException) null);
        }
        a(2, (BaseException) null);
    }

    public void c() {
        a(-4, (BaseException) null);
    }

    private BaseException c(BaseException baseException) {
        Context O;
        if (com.ss.android.socialbase.downloader.g.a.a(this.f855c.getId()).a("download_failed_check_net", 1) != 1 || !com.ss.android.socialbase.downloader.i.f.i(baseException) || (O = c.O()) == null || com.ss.android.socialbase.downloader.i.f.c(O)) {
            return baseException;
        }
        return new BaseException(this.f855c.isOnlyWifi() ? 1013 : 1049, baseException.getErrorMessage());
    }

    public void a() {
        if (this.f855c.canSkipStatusHandler()) {
            return;
        }
        this.f855c.setStatus(1);
        k();
    }

    public void a(long j, String str, String str2) {
        this.f855c.setTotalBytes(j);
        this.f855c.seteTag(str);
        if (!TextUtils.isEmpty(str2) && TextUtils.isEmpty(this.f855c.getName())) {
            this.f855c.setName(str2);
        }
        try {
            this.d.a(this.f855c.getId(), j, str, str2);
        } catch (Exception e) {
            e.printStackTrace();
        }
        a(3, (BaseException) null);
        this.o = this.f855c.getMinByteIntervalForPostToMainThread(j);
        this.n = this.f855c.getMinProgressTimeMsInterval();
        this.j = true;
        com.ss.android.socialbase.downloader.impls.r.a().e();
    }

    private void b(BaseException baseException) {
        Log.getStackTraceString(new Throwable());
        if (baseException != null && baseException.getCause() != null && (baseException.getCause() instanceof SQLiteFullException)) {
            try {
                this.d.f(this.f855c.getId());
            } catch (SQLiteException e) {
                e.printStackTrace();
            }
        } else {
            try {
                try {
                    this.d.b(this.f855c.getId(), this.f855c.getCurBytes());
                } catch (SQLiteException e2) {
                    e2.printStackTrace();
                }
            } catch (SQLiteException unused) {
                this.d.f(this.f855c.getId());
            }
        }
        BaseException c2 = c(baseException);
        this.f855c.setFailedException(c2);
        a(c2 instanceof com.ss.android.socialbase.downloader.exception.e ? -2 : -1, c2);
        if (com.ss.android.socialbase.downloader.g.a.a(this.f855c.getId()).a("retry_schedule", 0) > 0) {
            com.ss.android.socialbase.downloader.impls.r.a().a(this.f855c);
        }
    }

    public boolean a(long j) {
        this.l.addAndGet(j);
        this.f855c.increaseCurBytes(j);
        long uptimeMillis = SystemClock.uptimeMillis();
        return a(uptimeMillis, b(uptimeMillis));
    }

    private boolean b(long j) {
        boolean z = true;
        if (!this.m) {
            this.m = true;
            return true;
        }
        long j2 = j - this.k;
        if (this.l.get() < this.o && j2 < this.n) {
            z = false;
        }
        if (z) {
            this.k = j;
            this.l.set(0L);
        }
        return z;
    }

    public void a(BaseException baseException, boolean z) {
        this.f855c.setFirstDownload(false);
        this.l.set(0L);
        b(baseException, z);
    }

    public void a(com.ss.android.socialbase.downloader.model.b bVar, BaseException baseException, boolean z) {
        this.f855c.setFirstDownload(false);
        this.l.set(0L);
        this.d.h(this.f855c.getId());
        a(z ? 10 : 9, baseException, true);
    }

    private void b(BaseException baseException, boolean z) {
        this.d.h(this.f855c.getId());
        a(z ? 7 : 5, baseException);
    }

    public void a(BaseException baseException) {
        this.f855c.setFirstDownload(false);
        b(baseException);
    }

    public void a(String str) {
        com.ss.android.socialbase.downloader.c.a.b(a, "onCompleteForFileExist existTargetFileName is " + str + " but curName is " + this.f855c.getName());
        if (this.b) {
            com.ss.android.socialbase.downloader.i.f.a(this.f855c, str);
            m();
            this.f855c.setSuccessByCache(true);
            a(-3, (BaseException) null);
            this.d.a(this.f855c);
            return;
        }
        this.d.a(this.f855c);
        com.ss.android.socialbase.downloader.i.f.a(this.f855c, str);
        this.f855c.setSuccessByCache(true);
        m();
        a(-3, (BaseException) null);
    }

    private boolean a(long j, boolean z) {
        boolean z2 = false;
        if (this.f855c.getCurBytes() == this.f855c.getTotalBytes()) {
            try {
                this.d.a(this.f855c.getId(), this.f855c.getCurBytes());
            } catch (Exception e) {
                e.printStackTrace();
            }
            return false;
        }
        if (this.j) {
            this.j = false;
            this.f855c.setStatus(4);
        }
        if (this.f855c.isNeedPostProgress() && z) {
            z2 = true;
        }
        a(4, (BaseException) null, z2);
        return z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, BaseException baseException) {
        a(i, baseException, true);
    }

    private void a(int i, BaseException baseException, boolean z) {
        SparseArray<IDownloadListener> sparseArray;
        SparseArray<IDownloadListener> sparseArray2;
        int status = this.f855c.getStatus();
        if (status == -3 && i == 4) {
            return;
        }
        j();
        if (i != 4 && DownloadStatus.isRealTimeUploadStatus(i)) {
            this.f855c.updateRealDownloadTime(false);
            if (DownloadStatus.isTimeUploadStatus(i)) {
                this.f855c.updateDownloadTime();
            }
        }
        if (!this.f855c.isAddListenerToSameTask()) {
            com.ss.android.socialbase.downloader.d.a.a(this.f, baseException, i);
        }
        if (i == 6) {
            this.f855c.setStatus(2);
        } else if (i == -6) {
            this.f855c.setStatus(-3);
        } else {
            this.f855c.setStatus(i);
        }
        if (status == -3 || status == -1) {
            if (this.f855c.getRetryDelayStatus() == com.ss.android.socialbase.downloader.constants.g.DELAY_RETRY_DOWNLOADING) {
                this.f855c.setRetryDelayStatus(com.ss.android.socialbase.downloader.constants.g.DELAY_RETRY_DOWNLOADED);
            }
            if (this.f855c.getAsyncHandleStatus() == com.ss.android.socialbase.downloader.constants.a.ASYNC_HANDLE_DOWNLOADING) {
                this.f855c.setAsyncHandleStatus(com.ss.android.socialbase.downloader.constants.a.ASYNC_HANDLE_DOWNLOADED);
            }
            if (this.f855c.getByteInvalidRetryStatus() == com.ss.android.socialbase.downloader.constants.b.BYTE_INVALID_RETRY_STATUS_DOWNLOADING) {
                this.f855c.setByteInvalidRetryStatus(com.ss.android.socialbase.downloader.constants.b.BYTE_INVALID_RETRY_STATUS_DOWNLOADED);
            }
        }
        com.ss.android.socialbase.downloader.i.c.a(i, this.h, true, this.f855c, baseException);
        if (i == -4) {
            return;
        }
        if (z && this.e != null && (((sparseArray = this.g) != null && sparseArray.size() > 0) || ((sparseArray2 = this.i) != null && sparseArray2.size() > 0 && (this.f855c.canShowNotification() || this.f855c.isAutoInstallWithoutNotification())))) {
            this.e.obtainMessage(i, this.f855c.getId(), this.f.getHashCodeForSameTask(), baseException).sendToTarget();
            return;
        }
        com.ss.android.socialbase.downloader.impls.a D = c.D();
        if (D != null) {
            D.a(this.f855c.getId(), this.f.getHashCodeForSameTask(), i);
        }
    }
}
