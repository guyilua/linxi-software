package com.ss.android.downloadad.api;

import android.app.Dialog;
import android.content.Context;
import android.net.Uri;
import com.ss.android.download.api.config.IDownloadButtonClickListener;
import com.ss.android.download.api.download.DownloadController;
import com.ss.android.download.api.download.DownloadEventConfig;
import com.ss.android.download.api.download.DownloadModel;
import com.ss.android.download.api.download.DownloadStatusChangeListener;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public interface b {
    Dialog a(Context context, String str, boolean z, DownloadModel downloadModel, DownloadEventConfig downloadEventConfig, DownloadController downloadController, DownloadStatusChangeListener downloadStatusChangeListener, int i);

    Dialog a(Context context, String str, boolean z, DownloadModel downloadModel, DownloadEventConfig downloadEventConfig, DownloadController downloadController, DownloadStatusChangeListener downloadStatusChangeListener, int i, IDownloadButtonClickListener iDownloadButtonClickListener);

    boolean a(long j);

    boolean a(long j, int i);

    boolean a(Context context, long j, String str, DownloadStatusChangeListener downloadStatusChangeListener, int i);

    boolean a(Context context, Uri uri, DownloadModel downloadModel, DownloadEventConfig downloadEventConfig, DownloadController downloadController);

    boolean a(Context context, Uri uri, DownloadModel downloadModel, DownloadEventConfig downloadEventConfig, DownloadController downloadController, IDownloadButtonClickListener iDownloadButtonClickListener);
}
