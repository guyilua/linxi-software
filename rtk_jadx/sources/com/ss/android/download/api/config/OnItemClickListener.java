package com.ss.android.download.api.config;

import com.ss.android.download.api.download.DownloadController;
import com.ss.android.download.api.download.DownloadEventConfig;
import com.ss.android.download.api.download.DownloadModel;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public interface OnItemClickListener {
    void onItemClick(DownloadModel downloadModel, DownloadEventConfig downloadEventConfig, DownloadController downloadController);
}
