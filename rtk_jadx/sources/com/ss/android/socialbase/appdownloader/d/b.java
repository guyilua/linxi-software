package com.ss.android.socialbase.appdownloader.d;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import com.ss.android.socialbase.appdownloader.d;
import com.ss.android.socialbase.downloader.downloader.Downloader;
import com.ss.android.socialbase.downloader.downloader.c;
import com.ss.android.socialbase.downloader.downloader.l;
import com.ss.android.socialbase.downloader.i.f;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import java.util.Iterator;
import java.util.List;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class b implements l {
    private List<Integer> a;
    private BroadcastReceiver b;

    /* JADX INFO: Access modifiers changed from: private */
    public void b(List<DownloadInfo> list, int i) {
        if (list == null || list.isEmpty()) {
            return;
        }
        d.j();
        Context O = c.O();
        if (O == null) {
            return;
        }
        boolean b = f.b(O);
        Iterator<DownloadInfo> it = list.iterator();
        while (it.hasNext()) {
            a(O, it.next(), b, i);
        }
        List<Integer> list2 = this.a;
        if (list2 == null || list2.isEmpty() || this.b != null) {
            return;
        }
        this.b = new BroadcastReceiver() { // from class: com.ss.android.socialbase.appdownloader.d.b.2
            @Override // android.content.BroadcastReceiver
            public void onReceive(Context context, Intent intent) {
                final Context applicationContext = context.getApplicationContext();
                if (f.b(applicationContext)) {
                    com.ss.android.socialbase.downloader.c.a.b("LaunchResume", "onReceive : wifi connected !!!");
                    c.l().execute(new Runnable() { // from class: com.ss.android.socialbase.appdownloader.d.b.2.1
                        @Override // java.lang.Runnable
                        public void run() {
                            try {
                                if (b.this.a != null && !b.this.a.isEmpty()) {
                                    int size = b.this.a.size();
                                    Integer[] numArr = new Integer[size];
                                    b.this.a.toArray(numArr);
                                    b.this.a.clear();
                                    for (int i2 = 0; i2 < size; i2++) {
                                        DownloadInfo downloadInfo = Downloader.getInstance(applicationContext).getDownloadInfo(numArr[i2].intValue());
                                        if (downloadInfo != null && (downloadInfo.getRealStatus() == -5 || (downloadInfo.getRealStatus() == -2 && downloadInfo.isPauseReserveOnWifi()))) {
                                            b.this.a(applicationContext, downloadInfo, true, 2);
                                        }
                                    }
                                }
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                        }
                    });
                    try {
                        applicationContext.unregisterReceiver(b.this.b);
                    } catch (Throwable th) {
                        th.printStackTrace();
                    }
                    b.this.b = null;
                }
            }
        };
        try {
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
            O.registerReceiver(this.b, intentFilter);
        } catch (Throwable th) {
            th.printStackTrace();
            this.b = null;
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.l
    public List<String> a() {
        return com.ss.android.socialbase.appdownloader.c.c();
    }

    @Override // com.ss.android.socialbase.downloader.downloader.l
    public void a(final List<DownloadInfo> list, final int i) {
        if (f.d()) {
            c.l().execute(new Runnable() { // from class: com.ss.android.socialbase.appdownloader.d.b.1
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        b.this.b(list, i);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            });
        } else {
            b(list, i);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:48:0x012f  */
    /* JADX WARN: Removed duplicated region for block: B:51:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void a(android.content.Context r18, com.ss.android.socialbase.downloader.model.DownloadInfo r19, boolean r20, int r21) {
        /*
            Method dump skipped, instructions count: 608
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ss.android.socialbase.appdownloader.d.b.a(android.content.Context, com.ss.android.socialbase.downloader.model.DownloadInfo, boolean, int):void");
    }

    private void a(DownloadInfo downloadInfo, Context context) {
        com.ss.android.socialbase.downloader.g.a a = com.ss.android.socialbase.downloader.g.a.a(downloadInfo.getId());
        int a2 = a.a("paused_resume_max_count", 0);
        double a3 = a.a("paused_resume_max_hours", 72.0d);
        int pausedResumeCount = downloadInfo.getPausedResumeCount();
        if (pausedResumeCount < a2 && ((double) (System.currentTimeMillis() - downloadInfo.getLastDownloadTime())) < a3 * 3600000.0d) {
            com.ss.android.socialbase.downloader.notification.a e = com.ss.android.socialbase.downloader.notification.b.a().e(downloadInfo.getId());
            if (e == null) {
                e = new com.ss.android.socialbase.appdownloader.e.a(context, downloadInfo.getId(), downloadInfo.getTitle(), downloadInfo.getSavePath(), downloadInfo.getName(), downloadInfo.getExtra());
                com.ss.android.socialbase.downloader.notification.b.a().a(e);
            } else {
                e.a(downloadInfo);
            }
            e.b(downloadInfo.getTotalBytes());
            e.a(downloadInfo.getCurBytes());
            e.a(downloadInfo.getStatus(), null, false, false);
            downloadInfo.setPausedResumeCount(pausedResumeCount + 1);
            downloadInfo.updateSpData();
        }
    }

    private boolean a(DownloadInfo downloadInfo) {
        if (com.ss.android.socialbase.downloader.g.a.a(downloadInfo.getId()).b("uninstall_can_not_resume_for_force_task", false)) {
            return f.a(downloadInfo, false, downloadInfo.getMd5());
        }
        return downloadInfo.isDownloaded();
    }
}
