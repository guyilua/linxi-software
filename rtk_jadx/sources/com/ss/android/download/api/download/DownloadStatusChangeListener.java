package com.ss.android.download.api.download;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.ss.android.download.api.model.DownloadShortInfo;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public interface DownloadStatusChangeListener {
    void onDownloadActive(DownloadShortInfo downloadShortInfo, int i);

    void onDownloadFailed(DownloadShortInfo downloadShortInfo);

    void onDownloadFinished(DownloadShortInfo downloadShortInfo);

    void onDownloadPaused(DownloadShortInfo downloadShortInfo, int i);

    void onDownloadStart(@NonNull DownloadModel downloadModel, @Nullable DownloadController downloadController);

    void onIdle();

    void onInstalled(DownloadShortInfo downloadShortInfo);
}
