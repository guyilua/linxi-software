package com.ss.android.download.api.download.a;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.ss.android.download.api.download.DownloadController;
import com.ss.android.download.api.download.DownloadEventConfig;
import com.ss.android.download.api.download.DownloadModel;
import com.ss.android.socialbase.downloader.exception.BaseException;
import com.ss.android.socialbase.downloader.model.DownloadInfo;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public interface a {
    void a(@NonNull DownloadModel downloadModel, @Nullable DownloadController downloadController, @Nullable DownloadEventConfig downloadEventConfig);

    void a(@NonNull DownloadInfo downloadInfo);

    void a(@NonNull DownloadInfo downloadInfo, BaseException baseException, String str);

    void a(@NonNull DownloadInfo downloadInfo, String str);

    void b(@Nullable DownloadInfo downloadInfo, String str);
}
