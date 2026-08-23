package com.sigmob.sdk.downloader;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.graphics.Bitmap;
import android.os.Build;
import android.text.TextUtils;
import android.util.Log;
import android.widget.RemoteViews;
import com.czhj.sdk.common.utils.ImageManager;
import com.czhj.sdk.common.utils.ResourceUtil;
import com.czhj.sdk.logger.SigmobLog;
import com.ss.android.download.api.constant.BaseConstants;
import com.tencent.mm.opensdk.constants.ConstantsAPI;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class h extends com.sigmob.sdk.downloader.core.listener.c {
    private Notification.Builder a;
    private NotificationManager b;
    private RemoteViews d;
    private Context e;

    public h(Context context) {
        this.e = context.getApplicationContext();
        this.d = new RemoteViews(context.getPackageName(), ResourceUtil.getLayoutId(context, "sig_download_notification_layout"));
    }

    public void a(PendingIntent pendingIntent) {
        this.d.setOnClickPendingIntent(ResourceUtil.getId(this.e, "sig_download_notification_button"), pendingIntent);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.sigmob.sdk.downloader.core.listener.c
    public void a(f fVar) {
        if (!fVar.m().renameTo(fVar.n())) {
            SigmobLog.e("download temp file renameTo failed");
        }
        SigmobLog.d("FileDownloaderNotificationListener completed ");
        this.d.setTextViewText(ResourceUtil.getId(this.e, "sig_download_notification_speed"), "下载完成,立即安装");
        this.d.setViewVisibility(ResourceUtil.getId(this.e, "sig_download_notification_button"), 4);
        this.d.setViewVisibility(ResourceUtil.getId(this.e, "sig_download_notification_status"), 8);
        this.a.setOngoing(false);
        this.a.setAutoCancel(true);
        this.b.notify(fVar.c(), this.a.build());
    }

    public void a(f fVar, int i, long j, long j2) {
        StringBuilder sb;
        String str;
        RemoteViews remoteViews = this.d;
        int id = ResourceUtil.getId(this.e, "sig_download_notification_speed");
        if (j > BaseConstants.MB_VALUE) {
            sb = new StringBuilder();
            sb.append((j / ConstantsAPI.AppSupportContentFlag.MMAPP_SUPPORT_XLS) / ConstantsAPI.AppSupportContentFlag.MMAPP_SUPPORT_XLS);
            str = "M/";
        } else {
            sb = new StringBuilder();
            sb.append(j / ConstantsAPI.AppSupportContentFlag.MMAPP_SUPPORT_XLS);
            str = "KB/";
        }
        sb.append(str);
        sb.append((j2 / ConstantsAPI.AppSupportContentFlag.MMAPP_SUPPORT_XLS) / ConstantsAPI.AppSupportContentFlag.MMAPP_SUPPORT_XLS);
        sb.append("M");
        remoteViews.setTextViewText(id, sb.toString());
        this.d.setTextViewText(ResourceUtil.getId(this.e, "sig_download_notification_status"), "正在下载");
        this.d.setViewVisibility(ResourceUtil.getId(this.e, "sig_download_notification_button"), 0);
        this.b.notify(fVar.c(), this.a.build());
    }

    public void a(f fVar, long j, long j2) {
        StringBuilder sb;
        String str;
        Log.d("NotificationActivity", "progress " + j);
        RemoteViews remoteViews = this.d;
        int id = ResourceUtil.getId(this.e, "sig_download_notification_speed");
        if (j > BaseConstants.MB_VALUE) {
            sb = new StringBuilder();
            sb.append((j / ConstantsAPI.AppSupportContentFlag.MMAPP_SUPPORT_XLS) / ConstantsAPI.AppSupportContentFlag.MMAPP_SUPPORT_XLS);
            str = "M/";
        } else {
            sb = new StringBuilder();
            sb.append(j / ConstantsAPI.AppSupportContentFlag.MMAPP_SUPPORT_XLS);
            str = "KB/";
        }
        sb.append(str);
        sb.append((j2 / ConstantsAPI.AppSupportContentFlag.MMAPP_SUPPORT_XLS) / ConstantsAPI.AppSupportContentFlag.MMAPP_SUPPORT_XLS);
        sb.append("M");
        remoteViews.setTextViewText(id, sb.toString());
        if (j2 > 0) {
            this.d.setProgressBar(ResourceUtil.getId(this.e, "sig_download_notification_progressBar"), 100, (int) ((j * 100) / j2), false);
        }
        this.d.setViewVisibility(ResourceUtil.getId(this.e, "sig_download_notification_button"), 0);
        this.b.notify(fVar.c(), this.a.build());
    }

    @Override // com.sigmob.sdk.downloader.core.listener.assist.a.InterfaceC0045a
    public void a(f fVar, com.sigmob.sdk.downloader.core.cause.b bVar) {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.sigmob.sdk.downloader.core.listener.c
    public void a(f fVar, Exception exc) {
        this.d.setTextViewText(ResourceUtil.getId(this.e, "sig_download_notification_status"), "下载失败");
        this.d.setTextViewText(ResourceUtil.getId(this.e, "sig_download_notification_button"), "重试");
        this.d.setViewVisibility(ResourceUtil.getId(this.e, "sig_download_notification_button"), 0);
        this.b.notify(fVar.c(), this.a.build());
    }

    public void a(String str, String str2, String str3) {
        this.b = (NotificationManager) this.e.getSystemService("notification");
        int i = Build.VERSION.SDK_INT;
        if (i >= 26) {
            this.b.createNotificationChannel(new NotificationChannel("sig_filedownloader_notification", "sig_filedownloader", 1));
        }
        this.a = i >= 26 ? new Notification.Builder(this.e, "sig_filedownloader_notification") : new Notification.Builder(this.e);
        this.d.setTextViewText(ResourceUtil.getId(this.e, "sig_download_notification_title"), str2);
        if (!TextUtils.isEmpty(str)) {
            try {
                com.sigmob.sdk.base.common.h.a().getBitmap(str, new ImageManager.BitmapLoadedListener() { // from class: com.sigmob.sdk.downloader.h.1
                    public void onBitmapLoadFailed() {
                    }

                    public void onBitmapLoaded(Bitmap bitmap) {
                        h.this.d.setImageViewBitmap(ResourceUtil.getId(h.this.e, "sig_download_notification_icon"), bitmap);
                    }
                });
            } catch (Throwable unused) {
            }
        }
        this.d.setProgressBar(ResourceUtil.getId(this.e, "sig_download_notification_progress"), 100, 0, false);
        this.d.setTextViewText(ResourceUtil.getId(this.e, "sig_download_notification_speed"), "0M/0M");
        this.d.setTextViewText(ResourceUtil.getId(this.e, "sig_download_notification_status"), "等待开始");
        this.d.setViewVisibility(ResourceUtil.getId(this.e, "sig_download_notification_button"), 0);
        this.a.setDefaults(4).setOngoing(true).setSmallIcon(this.e.getApplicationInfo().icon).setPriority(0);
        if (Build.VERSION.SDK_INT >= 24) {
            this.a.setCustomContentView(this.d);
        } else {
            this.a.setContent(this.d);
        }
    }

    public void b(PendingIntent pendingIntent) {
        this.a.setContentIntent(pendingIntent);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.sigmob.sdk.downloader.core.listener.c
    public void b(f fVar) {
        this.d.setTextViewText(ResourceUtil.getId(this.e, "sig_download_notification_status"), "准备下载");
        this.d.setTextViewText(ResourceUtil.getId(this.e, "sig_download_notification_button"), "暂停");
        this.d.setViewVisibility(ResourceUtil.getId(this.e, "sig_download_notification_button"), 0);
        this.b.notify(fVar.c(), this.a.build());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.sigmob.sdk.downloader.core.listener.c
    public void c(f fVar) {
        this.d.setTextViewText(ResourceUtil.getId(this.e, "sig_download_notification_status"), "下载暂停");
        this.d.setTextViewText(ResourceUtil.getId(this.e, "sig_download_notification_button"), "继续");
        this.d.setViewVisibility(ResourceUtil.getId(this.e, "sig_download_notification_button"), 0);
        this.b.notify(fVar.c(), this.a.build());
    }

    @Override // com.sigmob.sdk.downloader.core.listener.c
    protected void d(f fVar) {
    }
}
