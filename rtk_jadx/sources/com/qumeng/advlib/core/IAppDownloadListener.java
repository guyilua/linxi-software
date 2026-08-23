package com.qumeng.advlib.core;

import androidx.annotation.Keep;

@Keep
/* loaded from: /tmp/rtk_apk/classes3.dex */
public interface IAppDownloadListener {
    void onDownloadActive(long j, long j2, String str);

    void onDownloadCompleted(String str);

    void onDownloadFailed();

    void onDownloadPaused(long j, long j2, String str);

    void onIdle();

    void onInstalled(String str);
}
