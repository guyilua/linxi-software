package com.ss.android.socialbase.downloader.downloader;

import android.app.Notification;
import com.ss.android.socialbase.downloader.depend.IDownloadFileUriProvider;
import com.ss.android.socialbase.downloader.depend.IDownloadListener;
import com.ss.android.socialbase.downloader.depend.ae;
import com.ss.android.socialbase.downloader.depend.aj;
import com.ss.android.socialbase.downloader.depend.z;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import com.ss.android.socialbase.downloader.model.DownloadTask;
import java.util.List;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public interface m {
    int a(String str, String str2);

    List<DownloadInfo> a(String str);

    void a();

    void a(int i);

    void a(int i, int i2);

    void a(int i, int i2, int i3, int i4);

    void a(int i, int i2, int i3, long j);

    void a(int i, int i2, long j);

    void a(int i, int i2, IDownloadListener iDownloadListener, com.ss.android.socialbase.downloader.constants.f fVar, boolean z);

    void a(int i, int i2, IDownloadListener iDownloadListener, com.ss.android.socialbase.downloader.constants.f fVar, boolean z, boolean z2);

    void a(int i, long j);

    void a(int i, Notification notification);

    void a(int i, z zVar);

    void a(int i, List<com.ss.android.socialbase.downloader.model.b> list);

    void a(int i, boolean z);

    void a(aj ajVar);

    void a(DownloadTask downloadTask);

    void a(com.ss.android.socialbase.downloader.model.b bVar);

    void a(List<String> list);

    void a(boolean z, boolean z2);

    boolean a(DownloadInfo downloadInfo);

    DownloadInfo b(String str, String str2);

    List<DownloadInfo> b(String str);

    void b(int i, int i2, IDownloadListener iDownloadListener, com.ss.android.socialbase.downloader.constants.f fVar, boolean z);

    void b(int i, List<com.ss.android.socialbase.downloader.model.b> list);

    void b(int i, boolean z);

    void b(DownloadInfo downloadInfo);

    void b(DownloadTask downloadTask);

    void b(List<String> list);

    boolean b();

    boolean b(int i);

    List<DownloadInfo> c(String str);

    void c(int i);

    void c(int i, boolean z);

    boolean c();

    boolean c(DownloadInfo downloadInfo);

    List<DownloadInfo> d();

    List<DownloadInfo> d(String str);

    void d(int i);

    long e(int i);

    List<DownloadInfo> e(String str);

    void e();

    int f(int i);

    boolean f();

    void g();

    boolean g(int i);

    DownloadInfo h(int i);

    boolean h();

    List<com.ss.android.socialbase.downloader.model.b> i(int i);

    void j(int i);

    void k(int i);

    boolean l(int i);

    int m(int i);

    boolean n(int i);

    void o(int i);

    boolean p(int i);

    z q(int i);

    ae r(int i);

    IDownloadFileUriProvider s(int i);
}
