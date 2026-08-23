package com.ss.android.socialbase.downloader.downloader;

import com.ss.android.socialbase.downloader.model.DownloadInfo;
import java.util.List;
import java.util.Map;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public interface j {
    DownloadInfo a(int i, int i2);

    DownloadInfo a(int i, long j);

    DownloadInfo a(int i, long j, String str, String str2);

    List<DownloadInfo> a(String str);

    void a(int i, int i2, int i3, int i4);

    void a(int i, int i2, int i3, long j);

    void a(int i, int i2, long j);

    void a(int i, List<com.ss.android.socialbase.downloader.model.b> list);

    void a(com.ss.android.socialbase.downloader.model.b bVar);

    boolean a(int i, Map<Long, com.ss.android.socialbase.downloader.f.i> map);

    boolean a(DownloadInfo downloadInfo);

    DownloadInfo b(int i);

    DownloadInfo b(int i, long j);

    List<DownloadInfo> b();

    List<DownloadInfo> b(String str);

    void b(int i, List<com.ss.android.socialbase.downloader.model.b> list);

    void b(DownloadInfo downloadInfo);

    void b(com.ss.android.socialbase.downloader.model.b bVar);

    DownloadInfo c(int i, long j);

    List<com.ss.android.socialbase.downloader.model.b> c(int i);

    List<DownloadInfo> c(String str);

    void c();

    DownloadInfo d(int i, long j);

    List<DownloadInfo> d(String str);

    void d(int i);

    boolean d();

    boolean e();

    boolean e(int i);

    boolean f(int i);

    DownloadInfo g(int i);

    DownloadInfo h(int i);

    DownloadInfo i(int i);

    DownloadInfo j(int i);

    Map<Long, com.ss.android.socialbase.downloader.f.i> l(int i);

    void m(int i);

    List<com.ss.android.socialbase.downloader.f.i> n(int i);
}
