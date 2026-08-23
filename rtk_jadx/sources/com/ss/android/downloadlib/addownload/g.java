package com.ss.android.downloadlib.addownload;

import android.content.Context;
import com.ss.android.download.api.config.IDownloadButtonClickListener;
import com.ss.android.download.api.config.OnItemClickListener;
import com.ss.android.download.api.download.DownloadController;
import com.ss.android.download.api.download.DownloadEventConfig;
import com.ss.android.download.api.download.DownloadModel;
import com.ss.android.download.api.download.DownloadStatusChangeListener;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public interface g {
    g a(long j);

    g a(IDownloadButtonClickListener iDownloadButtonClickListener);

    g a(OnItemClickListener onItemClickListener);

    g a(String str);

    void a();

    void a(boolean z);

    boolean a(int i);

    g b(int i, DownloadStatusChangeListener downloadStatusChangeListener);

    g b(Context context);

    g b(DownloadController downloadController);

    g b(DownloadEventConfig downloadEventConfig);

    g b(DownloadModel downloadModel);

    void b(int i);

    boolean b();

    long d();

    void h();
}
