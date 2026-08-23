package com.ss.android.socialbase.appdownloader;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.os.IBinder;
import android.text.TextUtils;
import android.widget.Toast;
import androidx.annotation.NonNull;
import com.ss.android.downloadad.api.constant.AdBaseConstants;
import com.ss.android.socialbase.appdownloader.view.DownloadTaskDeleteActivity;
import com.ss.android.socialbase.downloader.depend.ae;
import com.ss.android.socialbase.downloader.depend.z;
import com.ss.android.socialbase.downloader.downloader.Downloader;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import java.io.File;
import java.util.ArrayList;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class DownloadHandlerService extends Service {
    private static final String a = DownloadHandlerService.class.getSimpleName();

    private boolean a(Intent intent) {
        if (intent == null) {
            return false;
        }
        String action = intent.getAction();
        if (TextUtils.isEmpty(action)) {
            return false;
        }
        int intExtra = intent.getIntExtra("extra_click_download_ids", 0);
        intent.getIntExtra("extra_click_download_type", 0);
        com.ss.android.socialbase.appdownloader.c.d b = d.j().b();
        z downloadNotificationEventListener = Downloader.getInstance(this).getDownloadNotificationEventListener(intExtra);
        if (intent.getBooleanExtra("extra_from_notification", false) && com.ss.android.socialbase.downloader.g.a.a(intExtra).b("notification_opt_2") == 1) {
            com.ss.android.socialbase.downloader.notification.b.a().f(intExtra);
        }
        DownloadInfo downloadInfo = Downloader.getInstance(this).getDownloadInfo(intExtra);
        if (downloadInfo == null) {
            return false;
        }
        if (action.equals("android.ss.intent.action.DOWNLOAD_CLICK_CONTENT")) {
            a(downloadInfo, b, downloadNotificationEventListener);
        } else if (action.equals("android.ss.intent.action.DOWNLOAD_OPEN")) {
            a(this, downloadInfo, b, downloadNotificationEventListener);
        } else if (action.equals("android.ss.intent.action.DOWNLOAD_CLICK_BTN")) {
            if (downloadInfo.getStatus() == 0) {
                return false;
            }
            a(this, downloadInfo, b, downloadNotificationEventListener);
            if (downloadInfo.isDownloadOverStatus() && com.ss.android.socialbase.downloader.g.a.a(intExtra).a("no_hide_notification", 0) == 0) {
                if (!(com.ss.android.socialbase.downloader.g.a.a(intExtra).b("enable_notification_ui") >= 2 && downloadInfo.getStatus() == -1)) {
                    com.ss.android.socialbase.downloader.notification.b.a().a(intExtra);
                    com.ss.android.socialbase.downloader.notification.b.a().f(intExtra);
                }
            }
        } else if (action.equals("android.ss.intent.action.DOWNLOAD_DELETE")) {
            b(downloadInfo, b, downloadNotificationEventListener);
        } else if (action.equals("android.ss.intent.action.DOWNLOAD_HIDE")) {
            com.ss.android.socialbase.downloader.notification.b.a().a(intExtra);
        } else if (action.equals("android.intent.action.MEDIA_MOUNTED")) {
            com.ss.android.socialbase.downloader.downloader.c.l().execute(new Runnable() { // from class: com.ss.android.socialbase.appdownloader.DownloadHandlerService.1
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        ArrayList arrayList = new ArrayList();
                        arrayList.add(AdBaseConstants.MIME_APK);
                        arrayList.add("mime_type_plg");
                        Downloader.getInstance(com.ss.android.socialbase.downloader.downloader.c.O()).restartAllFailedDownloadTasks(arrayList);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            });
            return true;
        }
        return false;
    }

    private void b(@NonNull DownloadInfo downloadInfo, com.ss.android.socialbase.appdownloader.c.d dVar, z zVar) {
        int id = downloadInfo.getId();
        Intent intent = new Intent(this, (Class<?>) DownloadTaskDeleteActivity.class);
        intent.putExtra("extra_click_download_ids", id);
        intent.addFlags(268435456);
        startActivity(intent);
        com.ss.android.socialbase.downloader.notification.b.a().a(id);
        downloadInfo.updateDownloadTime();
        if (dVar != null) {
            dVar.a(id, 7, "", downloadInfo.getStatus(), downloadInfo.getDownloadTime());
        }
        if (zVar != null) {
            zVar.a(7, downloadInfo, "", "");
        }
    }

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override // android.app.Service
    public void onCreate() {
        super.onCreate();
        com.ss.android.socialbase.downloader.downloader.c.a(this);
    }

    @Override // android.app.Service
    public int onStartCommand(Intent intent, int i, int i2) {
        super.onStartCommand(intent, i, i2);
        if (com.ss.android.socialbase.downloader.c.a.a()) {
            com.ss.android.socialbase.downloader.c.a.b(a, "onStartCommand");
        }
        a(intent);
        stopSelf();
        return 2;
    }

    private static void a(Context context, DownloadInfo downloadInfo) {
        if (com.ss.android.socialbase.downloader.i.f.b(context.getApplicationContext()) && downloadInfo.isPauseReserveOnWifi()) {
            downloadInfo.stopPauseReserveOnWifi();
        }
    }

    private static void a(Context context, final com.ss.android.socialbase.appdownloader.c.d dVar, final DownloadInfo downloadInfo) {
        if (downloadInfo == null) {
            return;
        }
        final z downloadNotificationEventListener = Downloader.getInstance(context).getDownloadNotificationEventListener(downloadInfo.getId());
        if (dVar == null && downloadNotificationEventListener == null) {
            return;
        }
        com.ss.android.socialbase.downloader.downloader.c.l().execute(new Runnable() { // from class: com.ss.android.socialbase.appdownloader.DownloadHandlerService.2
            @Override // java.lang.Runnable
            public void run() {
                PackageInfo a2;
                try {
                    File file = new File(DownloadInfo.this.getSavePath(), DownloadInfo.this.getName());
                    if (file.exists()) {
                        try {
                            String str = (com.ss.android.socialbase.downloader.downloader.c.O() == null || (a2 = c.a(DownloadInfo.this, file)) == null) ? "" : a2.packageName;
                            com.ss.android.socialbase.appdownloader.c.d dVar2 = dVar;
                            if (dVar2 != null) {
                                dVar2.a(DownloadInfo.this.getId(), 3, str, -3, DownloadInfo.this.getDownloadTime());
                            }
                            z zVar = downloadNotificationEventListener;
                            if (zVar != null) {
                                zVar.a(3, DownloadInfo.this, str, "");
                            }
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
            }
        });
    }

    /* JADX WARN: Removed duplicated region for block: B:13:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:5:0x001a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private void a(@androidx.annotation.NonNull com.ss.android.socialbase.downloader.model.DownloadInfo r8, com.ss.android.socialbase.appdownloader.c.d r9, com.ss.android.socialbase.downloader.depend.z r10) {
        /*
            r7 = this;
            int r1 = r8.getId()
            com.ss.android.socialbase.downloader.downloader.d r0 = com.ss.android.socialbase.downloader.downloader.d.a()
            com.ss.android.socialbase.downloader.depend.ae r0 = r0.m(r1)
            if (r0 == 0) goto L17
            boolean r0 = r0.a(r8)     // Catch: java.lang.Throwable -> L13
            goto L18
        L13:
            r0 = move-exception
            r0.printStackTrace()
        L17:
            r0 = 0
        L18:
            if (r0 != 0) goto L51
            android.content.Intent r0 = new android.content.Intent
            java.lang.Class<com.ss.android.socialbase.appdownloader.view.DownloadTaskDeleteActivity> r2 = com.ss.android.socialbase.appdownloader.view.DownloadTaskDeleteActivity.class
            r0.<init>(r7, r2)
            java.lang.String r2 = "extra_click_download_ids"
            r0.putExtra(r2, r1)
            r2 = 268435456(0x10000000, float:2.524355E-29)
            r0.addFlags(r2)
            r7.startActivity(r0)
            com.ss.android.socialbase.downloader.notification.b r0 = com.ss.android.socialbase.downloader.notification.b.a()
            r0.a(r1)
            r8.updateDownloadTime()
            if (r9 == 0) goto L49
            r2 = 7
            int r4 = r8.getStatus()
            long r5 = r8.getDownloadTime()
            java.lang.String r3 = ""
            r0 = r9
            r0.a(r1, r2, r3, r4, r5)
        L49:
            if (r10 == 0) goto L51
            r9 = 7
            java.lang.String r0 = ""
            r10.a(r9, r8, r0, r0)
        L51:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ss.android.socialbase.appdownloader.DownloadHandlerService.a(com.ss.android.socialbase.downloader.model.DownloadInfo, com.ss.android.socialbase.appdownloader.c.d, com.ss.android.socialbase.downloader.depend.z):void");
    }

    private static void a(Context context, int i, boolean z) {
        boolean z2;
        ae m;
        DownloadInfo downloadInfo;
        if (z && (m = com.ss.android.socialbase.downloader.downloader.d.a().m(i)) != null) {
            try {
                downloadInfo = Downloader.getInstance(context).getDownloadInfo(i);
            } catch (Throwable th) {
                th.printStackTrace();
            }
            if (downloadInfo != null) {
                z2 = m.b(downloadInfo);
                if (z2 && c.a(context, i, true) == 0) {
                    Toast.makeText(context, "Open Fail!", 0).show();
                }
                return;
            }
        }
        z2 = false;
        if (z2) {
            return;
        }
        Toast.makeText(context, "Open Fail!", 0).show();
    }

    public static void a(Context context, DownloadInfo downloadInfo, com.ss.android.socialbase.appdownloader.c.d dVar, z zVar) {
        com.ss.android.socialbase.downloader.notification.a e;
        int id = downloadInfo.getId();
        ae m = com.ss.android.socialbase.downloader.downloader.d.a().m(id);
        if (AdBaseConstants.MIME_APK.equals(downloadInfo.getMimeType()) && m != null && c.a(context, downloadInfo) && m.c(downloadInfo)) {
            return;
        }
        boolean z = false;
        switch (downloadInfo.getStatus()) {
            case -4:
            case -1:
                if (com.ss.android.socialbase.downloader.g.a.a(id).b("enable_notification_ui") >= 2 && downloadInfo.isOnlyWifi()) {
                    downloadInfo.setOnlyWifi(false);
                }
                Downloader.getInstance(context).restart(id);
                return;
            case -3:
                a(com.ss.android.socialbase.downloader.downloader.c.O(), id, true);
                a(context, dVar, downloadInfo);
                if (com.ss.android.socialbase.downloader.g.a.a(id).a("notification_click_install_auto_cancel", 1) != 0 || (e = com.ss.android.socialbase.downloader.notification.b.a().e(id)) == null) {
                    z = true;
                } else {
                    e.g();
                    e.a(-3, null, false, true);
                }
                if (z) {
                    com.ss.android.socialbase.downloader.notification.b.a().a(id);
                    return;
                }
                return;
            case -2:
                if (com.ss.android.socialbase.downloader.downloader.d.a().e(id)) {
                    Downloader.getInstance(context).resume(id);
                } else {
                    c.a(downloadInfo, true, false);
                }
                if (dVar != null) {
                    dVar.a(id, 6, "", downloadInfo.getStatus(), downloadInfo.getDownloadTime());
                }
                if (zVar != null) {
                    zVar.a(6, downloadInfo, "", "");
                    return;
                }
                return;
            case 0:
            default:
                return;
            case 1:
            case 2:
            case 3:
            case 4:
            case 5:
                Downloader.getInstance(context).pause(id);
                a(context, downloadInfo);
                if (dVar != null) {
                    dVar.a(id, 5, "", downloadInfo.getStatus(), downloadInfo.getDownloadTime());
                }
                if (zVar != null) {
                    zVar.a(5, downloadInfo, "", "");
                    return;
                }
                return;
        }
    }
}
