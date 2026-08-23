package com.ss.android.socialbase.appdownloader.e;

import android.app.Notification;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Build;
import android.widget.RemoteViews;
import com.ss.android.downloadad.api.constant.AdBaseConstants;
import com.ss.android.socialbase.appdownloader.DownloadHandlerService;
import com.ss.android.socialbase.appdownloader.e;
import com.ss.android.socialbase.downloader.exception.BaseException;
import com.ss.android.socialbase.downloader.model.DownloadInfo;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class a extends com.ss.android.socialbase.downloader.notification.a {
    private final Context b;

    /* renamed from: c, reason: collision with root package name */
    private final Resources f809c;
    private String d;
    private String e;
    private String f;

    public a(Context context, int i, String str, String str2, String str3, String str4) {
        super(i, str);
        this.e = str2;
        this.d = str3;
        this.f = str4;
        Context applicationContext = context.getApplicationContext();
        this.b = applicationContext;
        this.f809c = applicationContext.getResources();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:150:0x03e1  */
    /* JADX WARN: Removed duplicated region for block: B:156:0x041e  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x020d  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x0239  */
    /* JADX WARN: Type inference failed for: r10v14, types: [int, boolean] */
    /* JADX WARN: Type inference failed for: r10v18 */
    /* JADX WARN: Type inference failed for: r10v25 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private android.app.Notification b(com.ss.android.socialbase.downloader.exception.BaseException r25, boolean r26) {
        /*
            Method dump skipped, instructions count: 1429
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ss.android.socialbase.appdownloader.e.a.b(com.ss.android.socialbase.downloader.exception.BaseException, boolean):android.app.Notification");
    }

    private RemoteViews i() {
        RemoteViews remoteViews = new RemoteViews(this.b.getPackageName(), e.a());
        if (Build.VERSION.SDK_INT > 20) {
            try {
                if (com.ss.android.socialbase.appdownloader.c.a(this.b)) {
                    remoteViews.setInt(e.f(), "setBackgroundColor", this.b.getResources().getColor(e.r()));
                }
            } catch (Throwable unused) {
            }
        }
        return remoteViews;
    }

    /*  JADX ERROR: JadxRuntimeException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxRuntimeException: Can't find top splitter block for handler:B:17:0x0044
        	at jadx.core.utils.BlockUtils.getTopSplitterForHandler(BlockUtils.java:1166)
        	at jadx.core.dex.visitors.regions.RegionMaker.processTryCatchBlocks(RegionMaker.java:1022)
        	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:55)
        */
    private androidx.core.app.NotificationCompat.Builder j() {
        /*
            r3 = this;
            com.ss.android.socialbase.appdownloader.d r0 = com.ss.android.socialbase.appdownloader.d.j()
            java.lang.String r0 = r0.i()
            int r1 = android.os.Build.VERSION.SDK_INT
            r2 = 26
            if (r1 >= r2) goto L16
            androidx.core.app.NotificationCompat$Builder r0 = new androidx.core.app.NotificationCompat$Builder
            android.content.Context r1 = r3.b
            r0.<init>(r1)
            goto L4b
        L16:
            boolean r1 = android.text.TextUtils.isEmpty(r0)
            if (r1 == 0) goto L22
            android.content.Context r0 = r3.b
            java.lang.String r0 = com.ss.android.socialbase.appdownloader.c.b(r0)
        L22:
            com.ss.android.socialbase.appdownloader.d r1 = com.ss.android.socialbase.appdownloader.d.j()     // Catch: java.lang.NoSuchMethodError -> L44
            com.ss.android.socialbase.appdownloader.c.m r1 = r1.m()     // Catch: java.lang.NoSuchMethodError -> L44
            if (r1 == 0) goto L3b
            com.ss.android.socialbase.appdownloader.d r1 = com.ss.android.socialbase.appdownloader.d.j()     // Catch: java.lang.NoSuchMethodError -> L44
            com.ss.android.socialbase.appdownloader.c.m r1 = r1.m()     // Catch: java.lang.NoSuchMethodError -> L44
            android.content.Context r2 = r3.b     // Catch: java.lang.NoSuchMethodError -> L44
            androidx.core.app.NotificationCompat$Builder r0 = r1.a(r2, r0)     // Catch: java.lang.NoSuchMethodError -> L44
            goto L4b
        L3b:
            androidx.core.app.NotificationCompat$Builder r1 = new androidx.core.app.NotificationCompat$Builder     // Catch: java.lang.NoSuchMethodError -> L44
            android.content.Context r2 = r3.b     // Catch: java.lang.NoSuchMethodError -> L44
            r1.<init>(r2, r0)     // Catch: java.lang.NoSuchMethodError -> L44
            r0 = r1
            goto L4b
        L44:
            androidx.core.app.NotificationCompat$Builder r0 = new androidx.core.app.NotificationCompat$Builder
            android.content.Context r1 = r3.b
            r0.<init>(r1)
        L4b:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ss.android.socialbase.appdownloader.e.a.j():androidx.core.app.NotificationCompat$Builder");
    }

    @Override // com.ss.android.socialbase.downloader.notification.a
    public void a(DownloadInfo downloadInfo) {
        super.a(downloadInfo);
        this.e = downloadInfo.getSavePath();
        this.d = downloadInfo.getName();
        this.f = downloadInfo.getExtra();
    }

    @Override // com.ss.android.socialbase.downloader.notification.a
    public void a(BaseException baseException, boolean z) {
        if (this.b == null) {
            return;
        }
        try {
            Notification b = b(baseException, z);
            this.a = b;
            a(b);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private boolean a(BaseException baseException, com.ss.android.socialbase.downloader.g.a aVar, DownloadInfo downloadInfo) {
        return baseException != null && (baseException.getErrorCode() == 1013 || baseException.getErrorCode() == 1049) && downloadInfo != null && AdBaseConstants.MIME_APK.contains(downloadInfo.getMimeType()) && aVar.a("notification_text_opt", 0) == 1;
    }

    private int a(int i, int i2) {
        if (com.ss.android.socialbase.downloader.g.a.a(i2).b("notification_opt_2") == 1) {
            return e.v();
        }
        if (i == 1 || i == 4) {
            return e.t();
        }
        if (i == 2) {
            return e.u();
        }
        if (i == 3) {
            return e.v();
        }
        return 0;
    }

    private PendingIntent a(String str, int i, int i2) {
        Intent intent = new Intent(this.b, (Class<?>) DownloadHandlerService.class);
        intent.setAction(str);
        intent.putExtra("extra_click_download_ids", i2);
        intent.putExtra("extra_click_download_type", i);
        intent.putExtra("extra_from_notification", true);
        return PendingIntent.getService(this.b, i2, intent, 201326592);
    }

    private int a(int i) {
        if (com.ss.android.socialbase.downloader.g.a.a(i).b("enable_notification_ui") > 0) {
            return e.h();
        }
        return e.g();
    }
}
