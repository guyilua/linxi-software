package com.ss.android.socialbase.downloader.i;

import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.os.RemoteException;
import android.text.TextUtils;
import android.util.SparseArray;
import com.ss.android.socialbase.downloader.depend.IDownloadFileUriProvider;
import com.ss.android.socialbase.downloader.depend.IDownloadInterceptor;
import com.ss.android.socialbase.downloader.depend.IDownloadListener;
import com.ss.android.socialbase.downloader.depend.ad;
import com.ss.android.socialbase.downloader.depend.ae;
import com.ss.android.socialbase.downloader.depend.ag;
import com.ss.android.socialbase.downloader.depend.ai;
import com.ss.android.socialbase.downloader.depend.aj;
import com.ss.android.socialbase.downloader.depend.e;
import com.ss.android.socialbase.downloader.depend.f;
import com.ss.android.socialbase.downloader.depend.g;
import com.ss.android.socialbase.downloader.depend.h;
import com.ss.android.socialbase.downloader.depend.i;
import com.ss.android.socialbase.downloader.depend.j;
import com.ss.android.socialbase.downloader.depend.l;
import com.ss.android.socialbase.downloader.depend.m;
import com.ss.android.socialbase.downloader.depend.n;
import com.ss.android.socialbase.downloader.depend.o;
import com.ss.android.socialbase.downloader.depend.p;
import com.ss.android.socialbase.downloader.depend.q;
import com.ss.android.socialbase.downloader.depend.r;
import com.ss.android.socialbase.downloader.depend.s;
import com.ss.android.socialbase.downloader.depend.t;
import com.ss.android.socialbase.downloader.depend.u;
import com.ss.android.socialbase.downloader.depend.v;
import com.ss.android.socialbase.downloader.depend.w;
import com.ss.android.socialbase.downloader.depend.x;
import com.ss.android.socialbase.downloader.depend.y;
import com.ss.android.socialbase.downloader.depend.z;
import com.ss.android.socialbase.downloader.exception.BaseException;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import com.ss.android.socialbase.downloader.model.DownloadTask;
import com.ss.android.socialbase.downloader.model.a;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class g {
    private static Handler a = new Handler(Looper.getMainLooper());

    public static com.ss.android.socialbase.downloader.model.a a(final DownloadTask downloadTask) {
        if (downloadTask == null) {
            return null;
        }
        return new a.AbstractBinderC0110a() { // from class: com.ss.android.socialbase.downloader.i.g.1
            @Override // com.ss.android.socialbase.downloader.model.a
            public DownloadInfo a() {
                return DownloadTask.this.getDownloadInfo();
            }

            @Override // com.ss.android.socialbase.downloader.model.a
            public com.ss.android.socialbase.downloader.depend.e b() {
                return g.a(DownloadTask.this.getChunkStrategy());
            }

            @Override // com.ss.android.socialbase.downloader.model.a
            public y c() {
                return g.a(DownloadTask.this.getNotificationEventListener());
            }

            @Override // com.ss.android.socialbase.downloader.model.a
            public ad d() {
                return g.a(DownloadTask.this.getNotificationClickCallback());
            }

            @Override // com.ss.android.socialbase.downloader.model.a
            public com.ss.android.socialbase.downloader.depend.h e() {
                return g.a(DownloadTask.this.getInterceptor());
            }

            @Override // com.ss.android.socialbase.downloader.model.a
            public com.ss.android.socialbase.downloader.depend.f f() {
                return g.a(DownloadTask.this.getDepend());
            }

            @Override // com.ss.android.socialbase.downloader.model.a
            public u g() {
                return g.a(DownloadTask.this.getForbiddenHandler());
            }

            @Override // com.ss.android.socialbase.downloader.model.a
            public ag h() {
                return g.a(DownloadTask.this.getRetryDelayTimeCalculator());
            }

            @Override // com.ss.android.socialbase.downloader.model.a
            public p i() {
                return g.a(DownloadTask.this.getDiskSpaceHandler());
            }

            @Override // com.ss.android.socialbase.downloader.model.a
            public com.ss.android.socialbase.downloader.depend.j j() {
                return g.a(DownloadTask.this.getMonitorDepend());
            }

            @Override // com.ss.android.socialbase.downloader.model.a
            public com.ss.android.socialbase.downloader.depend.g k() {
                return g.a(DownloadTask.this.getFileUriProvider());
            }

            @Override // com.ss.android.socialbase.downloader.model.a
            public int l() {
                return DownloadTask.this.getDownloadCompleteHandlers().size();
            }

            @Override // com.ss.android.socialbase.downloader.model.a
            public int a(int i) {
                return DownloadTask.this.getDownloadListenerSize(f.e(i));
            }

            @Override // com.ss.android.socialbase.downloader.model.a
            public com.ss.android.socialbase.downloader.depend.i b(int i) {
                return g.a(DownloadTask.this.getSingleDownloadListener(f.e(i)), i != com.ss.android.socialbase.downloader.constants.f.SUB.ordinal());
            }

            @Override // com.ss.android.socialbase.downloader.model.a
            public l c(int i) {
                return g.a(DownloadTask.this.getDownloadCompleteHandlerByIndex(i));
            }

            @Override // com.ss.android.socialbase.downloader.model.a
            public com.ss.android.socialbase.downloader.depend.i a(int i, int i2) {
                return g.a(DownloadTask.this.getDownloadListenerByIndex(f.e(i), i2), i != com.ss.android.socialbase.downloader.constants.f.SUB.ordinal());
            }
        };
    }

    public static com.ss.android.socialbase.downloader.depend.i a(final IDownloadListener iDownloadListener, final boolean z) {
        if (iDownloadListener == null) {
            return null;
        }
        return new i.a() { // from class: com.ss.android.socialbase.downloader.i.g.12
            @Override // com.ss.android.socialbase.downloader.depend.i
            public int a() {
                return IDownloadListener.this.hashCode();
            }

            @Override // com.ss.android.socialbase.downloader.depend.i
            public void b(final DownloadInfo downloadInfo) {
                if (z) {
                    g.a.post(new Runnable() { // from class: com.ss.android.socialbase.downloader.i.g.12.5
                        @Override // java.lang.Runnable
                        public void run() {
                            IDownloadListener.this.onStart(downloadInfo);
                        }
                    });
                } else {
                    IDownloadListener.this.onStart(downloadInfo);
                }
            }

            @Override // com.ss.android.socialbase.downloader.depend.i
            public void c(final DownloadInfo downloadInfo) {
                if (z) {
                    g.a.post(new Runnable() { // from class: com.ss.android.socialbase.downloader.i.g.12.6
                        @Override // java.lang.Runnable
                        public void run() {
                            IDownloadListener.this.onProgress(downloadInfo);
                        }
                    });
                } else {
                    IDownloadListener.this.onProgress(downloadInfo);
                }
            }

            @Override // com.ss.android.socialbase.downloader.depend.i
            public void d(final DownloadInfo downloadInfo) {
                if (z) {
                    g.a.post(new Runnable() { // from class: com.ss.android.socialbase.downloader.i.g.12.7
                        @Override // java.lang.Runnable
                        public void run() {
                            IDownloadListener.this.onPause(downloadInfo);
                        }
                    });
                } else {
                    IDownloadListener.this.onPause(downloadInfo);
                }
            }

            @Override // com.ss.android.socialbase.downloader.depend.i
            public void e(final DownloadInfo downloadInfo) {
                if (z) {
                    g.a.post(new Runnable() { // from class: com.ss.android.socialbase.downloader.i.g.12.8
                        @Override // java.lang.Runnable
                        public void run() {
                            IDownloadListener.this.onSuccessed(downloadInfo);
                        }
                    });
                } else {
                    IDownloadListener.this.onSuccessed(downloadInfo);
                }
            }

            @Override // com.ss.android.socialbase.downloader.depend.i
            public void f(final DownloadInfo downloadInfo) {
                if (z) {
                    g.a.post(new Runnable() { // from class: com.ss.android.socialbase.downloader.i.g.12.10
                        @Override // java.lang.Runnable
                        public void run() {
                            IDownloadListener.this.onCanceled(downloadInfo);
                        }
                    });
                } else {
                    IDownloadListener.this.onCanceled(downloadInfo);
                }
            }

            @Override // com.ss.android.socialbase.downloader.depend.i
            public void g(final DownloadInfo downloadInfo) {
                if (z) {
                    g.a.post(new Runnable() { // from class: com.ss.android.socialbase.downloader.i.g.12.11
                        @Override // java.lang.Runnable
                        public void run() {
                            IDownloadListener.this.onFirstStart(downloadInfo);
                        }
                    });
                } else {
                    IDownloadListener.this.onFirstStart(downloadInfo);
                }
            }

            @Override // com.ss.android.socialbase.downloader.depend.i
            public void h(final DownloadInfo downloadInfo) {
                if (z) {
                    g.a.post(new Runnable() { // from class: com.ss.android.socialbase.downloader.i.g.12.12
                        @Override // java.lang.Runnable
                        public void run() {
                            IDownloadListener.this.onFirstSuccess(downloadInfo);
                        }
                    });
                } else {
                    IDownloadListener.this.onFirstSuccess(downloadInfo);
                }
            }

            @Override // com.ss.android.socialbase.downloader.depend.i
            public void i(final DownloadInfo downloadInfo) {
                IDownloadListener iDownloadListener2 = IDownloadListener.this;
                if (iDownloadListener2 instanceof s) {
                    if (z) {
                        g.a.post(new Runnable() { // from class: com.ss.android.socialbase.downloader.i.g.12.4
                            @Override // java.lang.Runnable
                            public void run() {
                                ((s) IDownloadListener.this).a(downloadInfo);
                            }
                        });
                    } else {
                        ((s) iDownloadListener2).a(downloadInfo);
                    }
                }
            }

            @Override // com.ss.android.socialbase.downloader.depend.i
            public void a(final DownloadInfo downloadInfo) {
                if (z) {
                    g.a.post(new Runnable() { // from class: com.ss.android.socialbase.downloader.i.g.12.1
                        @Override // java.lang.Runnable
                        public void run() {
                            IDownloadListener.this.onPrepare(downloadInfo);
                        }
                    });
                } else {
                    IDownloadListener.this.onPrepare(downloadInfo);
                }
            }

            @Override // com.ss.android.socialbase.downloader.depend.i
            public void b(final DownloadInfo downloadInfo, final BaseException baseException) {
                if (z) {
                    g.a.post(new Runnable() { // from class: com.ss.android.socialbase.downloader.i.g.12.2
                        @Override // java.lang.Runnable
                        public void run() {
                            IDownloadListener.this.onRetry(downloadInfo, baseException);
                        }
                    });
                } else {
                    IDownloadListener.this.onRetry(downloadInfo, baseException);
                }
            }

            @Override // com.ss.android.socialbase.downloader.depend.i
            public void c(final DownloadInfo downloadInfo, final BaseException baseException) {
                if (z) {
                    g.a.post(new Runnable() { // from class: com.ss.android.socialbase.downloader.i.g.12.3
                        @Override // java.lang.Runnable
                        public void run() {
                            IDownloadListener.this.onRetryDelay(downloadInfo, baseException);
                        }
                    });
                } else {
                    IDownloadListener.this.onRetryDelay(downloadInfo, baseException);
                }
            }

            @Override // com.ss.android.socialbase.downloader.depend.i
            public void a(final DownloadInfo downloadInfo, final BaseException baseException) {
                if (z) {
                    g.a.post(new Runnable() { // from class: com.ss.android.socialbase.downloader.i.g.12.9
                        @Override // java.lang.Runnable
                        public void run() {
                            IDownloadListener.this.onFailed(downloadInfo, baseException);
                        }
                    });
                } else {
                    IDownloadListener.this.onFailed(downloadInfo, baseException);
                }
            }
        };
    }

    public static y a(final z zVar) {
        if (zVar == null) {
            return null;
        }
        return new y.a() { // from class: com.ss.android.socialbase.downloader.i.g.23
            @Override // com.ss.android.socialbase.downloader.depend.y
            public void a(int i, DownloadInfo downloadInfo, String str, String str2) {
                z.this.a(i, downloadInfo, str, str2);
            }

            @Override // com.ss.android.socialbase.downloader.depend.y
            public boolean a(boolean z) {
                return z.this.a(z);
            }

            @Override // com.ss.android.socialbase.downloader.depend.y
            public String a() {
                return z.this.a();
            }
        };
    }

    public static ad a(final ae aeVar) {
        if (aeVar == null) {
            return null;
        }
        return new ad.a() { // from class: com.ss.android.socialbase.downloader.i.g.26
            @Override // com.ss.android.socialbase.downloader.depend.ad
            public boolean a(DownloadInfo downloadInfo) {
                return ae.this.a(downloadInfo);
            }

            @Override // com.ss.android.socialbase.downloader.depend.ad
            public boolean b(DownloadInfo downloadInfo) {
                return ae.this.b(downloadInfo);
            }

            @Override // com.ss.android.socialbase.downloader.depend.ad
            public boolean c(DownloadInfo downloadInfo) {
                return ae.this.c(downloadInfo);
            }
        };
    }

    public static ag a(final com.ss.android.socialbase.downloader.downloader.s sVar) {
        if (sVar == null) {
            return null;
        }
        return new ag.a() { // from class: com.ss.android.socialbase.downloader.i.g.27
            @Override // com.ss.android.socialbase.downloader.depend.ag
            public long a(int i, int i2) {
                return com.ss.android.socialbase.downloader.downloader.s.this.a(i, i2);
            }
        };
    }

    public static u a(final w wVar) {
        if (wVar == null) {
            return null;
        }
        return new u.a() { // from class: com.ss.android.socialbase.downloader.i.g.28
            @Override // com.ss.android.socialbase.downloader.depend.u
            public boolean a(t tVar) {
                return w.this.a(g.a(tVar));
            }
        };
    }

    public static com.ss.android.socialbase.downloader.depend.g a(final IDownloadFileUriProvider iDownloadFileUriProvider) {
        if (iDownloadFileUriProvider == null) {
            return null;
        }
        return new g.a() { // from class: com.ss.android.socialbase.downloader.i.g.29
            @Override // com.ss.android.socialbase.downloader.depend.g
            public Uri a(String str, String str2) {
                return IDownloadFileUriProvider.this.getUriForFile(str, str2);
            }
        };
    }

    public static v a(final t tVar) {
        if (tVar == null) {
            return null;
        }
        return new v() { // from class: com.ss.android.socialbase.downloader.i.g.30
            @Override // com.ss.android.socialbase.downloader.depend.v
            public void a(List<String> list) {
                try {
                    t.this.a(list);
                } catch (RemoteException e) {
                    e.printStackTrace();
                }
            }

            @Override // com.ss.android.socialbase.downloader.depend.v
            public boolean a() {
                try {
                    return t.this.a();
                } catch (RemoteException e) {
                    e.printStackTrace();
                    return false;
                }
            }
        };
    }

    public static p a(final r rVar) {
        if (rVar == null) {
            return null;
        }
        return new p.a() { // from class: com.ss.android.socialbase.downloader.i.g.31
            @Override // com.ss.android.socialbase.downloader.depend.p
            public boolean a(long j, long j2, o oVar) {
                return r.this.a(j, j2, g.a(oVar));
            }
        };
    }

    public static q a(final o oVar) {
        if (oVar == null) {
            return null;
        }
        return new q() { // from class: com.ss.android.socialbase.downloader.i.g.2
            @Override // com.ss.android.socialbase.downloader.depend.q
            public void a() {
                try {
                    o.this.a();
                } catch (RemoteException e) {
                    e.printStackTrace();
                }
            }
        };
    }

    public static com.ss.android.socialbase.downloader.depend.f a(final n nVar) {
        if (nVar == null) {
            return null;
        }
        return new f.a() { // from class: com.ss.android.socialbase.downloader.i.g.3
            @Override // com.ss.android.socialbase.downloader.depend.f
            public void a(DownloadInfo downloadInfo, BaseException baseException, int i) {
                n.this.a(downloadInfo, baseException, i);
            }
        };
    }

    public static com.ss.android.socialbase.downloader.depend.j a(final x xVar) {
        if (xVar == null) {
            return null;
        }
        return new j.a() { // from class: com.ss.android.socialbase.downloader.i.g.4
            @Override // com.ss.android.socialbase.downloader.depend.j
            public void a(String str) {
                if (TextUtils.isEmpty(str)) {
                    return;
                }
                try {
                    x.this.a(new JSONObject(str));
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }

            @Override // com.ss.android.socialbase.downloader.depend.j
            public int[] b() {
                x xVar2 = x.this;
                if (xVar2 instanceof com.ss.android.socialbase.downloader.depend.c) {
                    return ((com.ss.android.socialbase.downloader.depend.c) xVar2).a();
                }
                return null;
            }

            @Override // com.ss.android.socialbase.downloader.depend.j
            public String a() {
                return x.this.b();
            }
        };
    }

    public static com.ss.android.socialbase.downloader.depend.e a(final com.ss.android.socialbase.downloader.downloader.h hVar) {
        if (hVar == null) {
            return null;
        }
        return new e.a() { // from class: com.ss.android.socialbase.downloader.i.g.5
            @Override // com.ss.android.socialbase.downloader.depend.e
            public int a(long j) {
                return com.ss.android.socialbase.downloader.downloader.h.this.a(j);
            }
        };
    }

    public static com.ss.android.socialbase.downloader.depend.h a(final IDownloadInterceptor iDownloadInterceptor) {
        if (iDownloadInterceptor == null) {
            return null;
        }
        return new h.a() { // from class: com.ss.android.socialbase.downloader.i.g.6
            @Override // com.ss.android.socialbase.downloader.depend.h
            public boolean a() {
                return IDownloadInterceptor.this.intercepte();
            }
        };
    }

    public static DownloadTask a(com.ss.android.socialbase.downloader.model.a aVar) {
        if (aVar == null) {
            return null;
        }
        try {
            DownloadTask downloadTask = new DownloadTask(aVar.a());
            downloadTask.chunkStategy(a(aVar.b())).notificationEventListener(a(aVar.c())).interceptor(a(aVar.e())).depend(a(aVar.f())).monitorDepend(a(aVar.j())).forbiddenHandler(a(aVar.g())).diskSpaceHandler(a(aVar.i())).fileUriProvider(a(aVar.k())).notificationClickCallback(a(aVar.d())).retryDelayTimeCalculator(a(aVar.h()));
            com.ss.android.socialbase.downloader.constants.f fVar = com.ss.android.socialbase.downloader.constants.f.MAIN;
            com.ss.android.socialbase.downloader.depend.i b = aVar.b(fVar.ordinal());
            if (b != null) {
                downloadTask.mainThreadListenerWithHashCode(b.hashCode(), a(b));
            }
            com.ss.android.socialbase.downloader.constants.f fVar2 = com.ss.android.socialbase.downloader.constants.f.SUB;
            com.ss.android.socialbase.downloader.depend.i b2 = aVar.b(fVar2.ordinal());
            if (b2 != null) {
                downloadTask.subThreadListenerWithHashCode(b2.hashCode(), a(b2));
            }
            com.ss.android.socialbase.downloader.constants.f fVar3 = com.ss.android.socialbase.downloader.constants.f.NOTIFICATION;
            com.ss.android.socialbase.downloader.depend.i b3 = aVar.b(fVar3.ordinal());
            if (b3 != null) {
                downloadTask.notificationListenerWithHashCode(b3.hashCode(), a(b3));
            }
            a(downloadTask, aVar, fVar);
            a(downloadTask, aVar, fVar2);
            a(downloadTask, aVar, fVar3);
            a(downloadTask, aVar);
            return downloadTask;
        } catch (RemoteException e) {
            e.printStackTrace();
            return null;
        }
    }

    private static void a(DownloadTask downloadTask, com.ss.android.socialbase.downloader.model.a aVar, com.ss.android.socialbase.downloader.constants.f fVar) {
        SparseArray<IDownloadListener> sparseArray = new SparseArray<>();
        for (int i = 0; i < aVar.a(fVar.ordinal()); i++) {
            com.ss.android.socialbase.downloader.depend.i a2 = aVar.a(fVar.ordinal(), i);
            if (a2 != null) {
                sparseArray.put(a2.a(), a(a2));
            }
        }
        downloadTask.setDownloadListeners(sparseArray, fVar);
    }

    private static void a(DownloadTask downloadTask, com.ss.android.socialbase.downloader.model.a aVar) {
        for (int i = 0; i < aVar.l(); i++) {
            l c2 = aVar.c(i);
            if (c2 != null) {
                downloadTask.addDownloadCompleteHandler(a(c2));
            }
        }
    }

    public static z a(final y yVar) {
        if (yVar == null) {
            return null;
        }
        return new z() { // from class: com.ss.android.socialbase.downloader.i.g.7
            @Override // com.ss.android.socialbase.downloader.depend.z
            public void a(int i, DownloadInfo downloadInfo, String str, String str2) {
                try {
                    y.this.a(i, downloadInfo, str, str2);
                } catch (RemoteException e) {
                    e.printStackTrace();
                }
            }

            @Override // com.ss.android.socialbase.downloader.depend.z
            public boolean a(boolean z) {
                try {
                    return y.this.a(z);
                } catch (RemoteException e) {
                    e.printStackTrace();
                    return false;
                }
            }

            @Override // com.ss.android.socialbase.downloader.depend.z
            public String a() {
                try {
                    return y.this.a();
                } catch (RemoteException e) {
                    e.printStackTrace();
                    return null;
                }
            }
        };
    }

    public static m a(final l lVar) {
        if (lVar == null) {
            return null;
        }
        return new m() { // from class: com.ss.android.socialbase.downloader.i.g.8
            @Override // com.ss.android.socialbase.downloader.depend.m
            public void a(DownloadInfo downloadInfo) {
                try {
                    l.this.a(downloadInfo);
                } catch (RemoteException e) {
                    throw new BaseException(1008, e);
                }
            }

            @Override // com.ss.android.socialbase.downloader.depend.m
            public boolean b(DownloadInfo downloadInfo) {
                try {
                    return l.this.b(downloadInfo);
                } catch (RemoteException e) {
                    e.printStackTrace();
                    return false;
                }
            }
        };
    }

    public static l a(final m mVar) {
        if (mVar == null) {
            return null;
        }
        return new l.a() { // from class: com.ss.android.socialbase.downloader.i.g.9
            @Override // com.ss.android.socialbase.downloader.depend.l
            public void a(DownloadInfo downloadInfo) {
                try {
                    m.this.a(downloadInfo);
                } catch (BaseException e) {
                    throw new IllegalArgumentException(e);
                }
            }

            @Override // com.ss.android.socialbase.downloader.depend.l
            public boolean b(DownloadInfo downloadInfo) {
                return m.this.b(downloadInfo);
            }
        };
    }

    public static ae a(final ad adVar) {
        if (adVar == null) {
            return null;
        }
        return new ae() { // from class: com.ss.android.socialbase.downloader.i.g.10
            @Override // com.ss.android.socialbase.downloader.depend.ae
            public boolean a(DownloadInfo downloadInfo) {
                try {
                    return ad.this.a(downloadInfo);
                } catch (RemoteException e) {
                    e.printStackTrace();
                    return false;
                }
            }

            @Override // com.ss.android.socialbase.downloader.depend.ae
            public boolean b(DownloadInfo downloadInfo) {
                try {
                    return ad.this.b(downloadInfo);
                } catch (RemoteException e) {
                    e.printStackTrace();
                    return false;
                }
            }

            @Override // com.ss.android.socialbase.downloader.depend.ae
            public boolean c(DownloadInfo downloadInfo) {
                try {
                    return ad.this.c(downloadInfo);
                } catch (RemoteException e) {
                    e.printStackTrace();
                    return false;
                }
            }
        };
    }

    public static com.ss.android.socialbase.downloader.downloader.h a(final com.ss.android.socialbase.downloader.depend.e eVar) {
        if (eVar == null) {
            return null;
        }
        return new com.ss.android.socialbase.downloader.downloader.h() { // from class: com.ss.android.socialbase.downloader.i.g.11
            @Override // com.ss.android.socialbase.downloader.downloader.h
            public int a(long j) {
                try {
                    return com.ss.android.socialbase.downloader.depend.e.this.a(j);
                } catch (RemoteException e) {
                    e.printStackTrace();
                    return 0;
                }
            }
        };
    }

    public static n a(final com.ss.android.socialbase.downloader.depend.f fVar) {
        if (fVar == null) {
            return null;
        }
        return new n() { // from class: com.ss.android.socialbase.downloader.i.g.13
            @Override // com.ss.android.socialbase.downloader.depend.n
            public void a(DownloadInfo downloadInfo, BaseException baseException, int i) {
                if (downloadInfo == null) {
                    return;
                }
                try {
                    com.ss.android.socialbase.downloader.depend.f.this.a(downloadInfo, baseException, i);
                } catch (RemoteException e) {
                    e.printStackTrace();
                }
            }
        };
    }

    public static x a(final com.ss.android.socialbase.downloader.depend.j jVar) {
        if (jVar == null) {
            return null;
        }
        return new com.ss.android.socialbase.downloader.depend.c() { // from class: com.ss.android.socialbase.downloader.i.g.14
            @Override // com.ss.android.socialbase.downloader.depend.x
            public void a(JSONObject jSONObject) {
                if (jSONObject == null) {
                    return;
                }
                try {
                    com.ss.android.socialbase.downloader.depend.j.this.a(jSONObject.toString());
                } catch (RemoteException e) {
                    e.printStackTrace();
                }
            }

            @Override // com.ss.android.socialbase.downloader.depend.x
            public String b() {
                try {
                    return com.ss.android.socialbase.downloader.depend.j.this.a();
                } catch (RemoteException e) {
                    e.printStackTrace();
                    return "";
                }
            }

            @Override // com.ss.android.socialbase.downloader.depend.c
            public int[] a() {
                try {
                    return com.ss.android.socialbase.downloader.depend.j.this.b();
                } catch (RemoteException e) {
                    e.printStackTrace();
                    return null;
                }
            }
        };
    }

    public static w a(final u uVar) {
        if (uVar == null) {
            return null;
        }
        return new w() { // from class: com.ss.android.socialbase.downloader.i.g.15
            @Override // com.ss.android.socialbase.downloader.depend.w
            public boolean a(v vVar) {
                try {
                    return u.this.a(g.a(vVar));
                } catch (RemoteException e) {
                    e.printStackTrace();
                    return false;
                }
            }
        };
    }

    public static t a(final v vVar) {
        if (vVar == null) {
            return null;
        }
        return new t.a() { // from class: com.ss.android.socialbase.downloader.i.g.16
            @Override // com.ss.android.socialbase.downloader.depend.t
            public void a(List<String> list) {
                v.this.a(list);
            }

            @Override // com.ss.android.socialbase.downloader.depend.t
            public boolean a() {
                return v.this.a();
            }
        };
    }

    public static ai a(final aj ajVar) {
        if (ajVar == null) {
            return null;
        }
        return new ai.a() { // from class: com.ss.android.socialbase.downloader.i.g.17
            @Override // com.ss.android.socialbase.downloader.depend.ai
            public void a(int i, int i2) {
                aj.this.a(i, i2);
            }
        };
    }

    public static aj a(final ai aiVar) {
        if (aiVar == null) {
            return null;
        }
        return new aj() { // from class: com.ss.android.socialbase.downloader.i.g.18
            @Override // com.ss.android.socialbase.downloader.depend.aj
            public void a(int i, int i2) {
                try {
                    ai.this.a(i, i2);
                } catch (RemoteException e) {
                    e.printStackTrace();
                }
            }
        };
    }

    public static r a(final p pVar) {
        if (pVar == null) {
            return null;
        }
        return new r() { // from class: com.ss.android.socialbase.downloader.i.g.19
            @Override // com.ss.android.socialbase.downloader.depend.r
            public boolean a(long j, long j2, q qVar) {
                try {
                    return p.this.a(j, j2, g.a(qVar));
                } catch (RemoteException e) {
                    e.printStackTrace();
                    return false;
                }
            }
        };
    }

    public static o a(final q qVar) {
        if (qVar == null) {
            return null;
        }
        return new o.a() { // from class: com.ss.android.socialbase.downloader.i.g.20
            @Override // com.ss.android.socialbase.downloader.depend.o
            public void a() {
                q.this.a();
            }
        };
    }

    public static com.ss.android.socialbase.downloader.downloader.s a(final ag agVar) {
        if (agVar == null) {
            return null;
        }
        return new com.ss.android.socialbase.downloader.downloader.s() { // from class: com.ss.android.socialbase.downloader.i.g.21
            @Override // com.ss.android.socialbase.downloader.downloader.s
            public long a(int i, int i2) {
                try {
                    return ag.this.a(i, i2);
                } catch (RemoteException e) {
                    e.printStackTrace();
                    return 0L;
                }
            }
        };
    }

    public static IDownloadInterceptor a(final com.ss.android.socialbase.downloader.depend.h hVar) {
        if (hVar == null) {
            return null;
        }
        return new IDownloadInterceptor() { // from class: com.ss.android.socialbase.downloader.i.g.22
            @Override // com.ss.android.socialbase.downloader.depend.IDownloadInterceptor
            public boolean intercepte() {
                try {
                    return com.ss.android.socialbase.downloader.depend.h.this.a();
                } catch (RemoteException e) {
                    e.printStackTrace();
                    return false;
                }
            }
        };
    }

    public static IDownloadFileUriProvider a(final com.ss.android.socialbase.downloader.depend.g gVar) {
        if (gVar == null) {
            return null;
        }
        return new IDownloadFileUriProvider() { // from class: com.ss.android.socialbase.downloader.i.g.24
            @Override // com.ss.android.socialbase.downloader.depend.IDownloadFileUriProvider
            public Uri getUriForFile(String str, String str2) {
                try {
                    return com.ss.android.socialbase.downloader.depend.g.this.a(str, str2);
                } catch (RemoteException e) {
                    e.printStackTrace();
                    return null;
                }
            }
        };
    }

    public static IDownloadListener a(final com.ss.android.socialbase.downloader.depend.i iVar) {
        if (iVar == null) {
            return null;
        }
        return new s() { // from class: com.ss.android.socialbase.downloader.i.g.25
            @Override // com.ss.android.socialbase.downloader.depend.s
            public void a(DownloadInfo downloadInfo) {
                try {
                    com.ss.android.socialbase.downloader.depend.i.this.i(downloadInfo);
                } catch (RemoteException e) {
                    e.printStackTrace();
                }
            }

            @Override // com.ss.android.socialbase.downloader.depend.IDownloadListener
            public void onCanceled(DownloadInfo downloadInfo) {
                try {
                    com.ss.android.socialbase.downloader.depend.i.this.f(downloadInfo);
                } catch (RemoteException e) {
                    e.printStackTrace();
                }
            }

            @Override // com.ss.android.socialbase.downloader.depend.IDownloadListener
            public void onFailed(DownloadInfo downloadInfo, BaseException baseException) {
                try {
                    com.ss.android.socialbase.downloader.depend.i.this.a(downloadInfo, baseException);
                } catch (RemoteException e) {
                    e.printStackTrace();
                }
            }

            @Override // com.ss.android.socialbase.downloader.depend.IDownloadListener
            public void onFirstStart(DownloadInfo downloadInfo) {
                try {
                    com.ss.android.socialbase.downloader.depend.i.this.g(downloadInfo);
                } catch (RemoteException e) {
                    e.printStackTrace();
                }
            }

            @Override // com.ss.android.socialbase.downloader.depend.IDownloadListener
            public void onFirstSuccess(DownloadInfo downloadInfo) {
                try {
                    com.ss.android.socialbase.downloader.depend.i.this.h(downloadInfo);
                } catch (RemoteException e) {
                    e.printStackTrace();
                }
            }

            @Override // com.ss.android.socialbase.downloader.depend.IDownloadListener
            public void onPause(DownloadInfo downloadInfo) {
                try {
                    com.ss.android.socialbase.downloader.depend.i.this.d(downloadInfo);
                } catch (RemoteException e) {
                    e.printStackTrace();
                }
            }

            @Override // com.ss.android.socialbase.downloader.depend.IDownloadListener
            public void onPrepare(DownloadInfo downloadInfo) {
                try {
                    com.ss.android.socialbase.downloader.depend.i.this.a(downloadInfo);
                } catch (RemoteException e) {
                    e.printStackTrace();
                }
            }

            @Override // com.ss.android.socialbase.downloader.depend.IDownloadListener
            public void onProgress(DownloadInfo downloadInfo) {
                try {
                    com.ss.android.socialbase.downloader.depend.i.this.c(downloadInfo);
                } catch (RemoteException e) {
                    e.printStackTrace();
                }
            }

            @Override // com.ss.android.socialbase.downloader.depend.IDownloadListener
            public void onRetry(DownloadInfo downloadInfo, BaseException baseException) {
                try {
                    com.ss.android.socialbase.downloader.depend.i.this.b(downloadInfo, baseException);
                } catch (RemoteException e) {
                    e.printStackTrace();
                }
            }

            @Override // com.ss.android.socialbase.downloader.depend.IDownloadListener
            public void onRetryDelay(DownloadInfo downloadInfo, BaseException baseException) {
                try {
                    com.ss.android.socialbase.downloader.depend.i.this.c(downloadInfo, baseException);
                } catch (RemoteException e) {
                    e.printStackTrace();
                }
            }

            @Override // com.ss.android.socialbase.downloader.depend.IDownloadListener
            public void onStart(DownloadInfo downloadInfo) {
                try {
                    com.ss.android.socialbase.downloader.depend.i.this.b(downloadInfo);
                } catch (RemoteException e) {
                    e.printStackTrace();
                }
            }

            @Override // com.ss.android.socialbase.downloader.depend.IDownloadListener
            public void onSuccessed(DownloadInfo downloadInfo) {
                try {
                    com.ss.android.socialbase.downloader.depend.i.this.e(downloadInfo);
                } catch (RemoteException e) {
                    e.printStackTrace();
                }
            }
        };
    }
}
