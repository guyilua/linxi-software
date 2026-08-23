package com.ss.android.socialbase.appdownloader;

import android.content.Context;
import android.content.IntentFilter;
import android.os.Build;
import android.os.Environment;
import android.text.TextUtils;
import com.sigmob.sdk.base.k;
import com.ss.android.downloadad.api.constant.AdBaseConstants;
import com.ss.android.socialbase.appdownloader.c.j;
import com.ss.android.socialbase.appdownloader.c.m;
import com.ss.android.socialbase.appdownloader.c.o;
import com.ss.android.socialbase.downloader.depend.ac;
import com.ss.android.socialbase.downloader.depend.af;
import com.ss.android.socialbase.downloader.depend.z;
import com.ss.android.socialbase.downloader.downloader.Downloader;
import com.ss.android.socialbase.downloader.impls.r;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import com.ss.android.socialbase.downloader.model.DownloadTask;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class d {
    private static final String a = "d";
    private static volatile d b = null;
    private static boolean f = false;
    private static boolean g = false;
    private static boolean h = false;

    /* renamed from: c, reason: collision with root package name */
    private String f806c;
    private String d;
    private Future i;
    private int j;
    private com.ss.android.socialbase.appdownloader.c.c m;
    private com.ss.android.socialbase.appdownloader.c.d n;
    private com.ss.android.socialbase.appdownloader.c.h o;
    private com.ss.android.socialbase.appdownloader.c.g p;
    private m q;
    private com.ss.android.socialbase.appdownloader.c.f r;
    private j s;
    private ac t;
    private af u;
    private o v;
    private DownloadReceiver e = new DownloadReceiver();
    private boolean k = false;
    private boolean l = false;

    private d() {
    }

    public static d j() {
        if (b == null) {
            synchronized (d.class) {
                if (b == null) {
                    b = new d();
                }
            }
        }
        return b;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void s() {
        synchronized (this.e) {
            if (g) {
                return;
            }
            try {
                IntentFilter intentFilter = new IntentFilter();
                intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
                IntentFilter intentFilter2 = new IntentFilter();
                intentFilter2.addAction("android.intent.action.MEDIA_MOUNTED");
                intentFilter2.addDataScheme(k.y);
                com.ss.android.socialbase.downloader.downloader.c.O().registerReceiver(this.e, intentFilter);
                com.ss.android.socialbase.downloader.downloader.c.O().registerReceiver(this.e, intentFilter2);
                g = true;
            } catch (Exception e) {
                e.printStackTrace();
            }
            com.ss.android.socialbase.downloader.c.a.b(a, "registerDownloadReceiver mIsRegistered:" + g);
        }
    }

    private void t() {
        if (Build.VERSION.SDK_INT >= 21) {
            r.a(new r.b() { // from class: com.ss.android.socialbase.appdownloader.d.3
                @Override // com.ss.android.socialbase.downloader.impls.r.b
                public void a(DownloadInfo downloadInfo, long j, boolean z, int i) {
                    RetryJobSchedulerService.a(downloadInfo, j, z, i);
                }
            });
        }
    }

    public com.ss.android.socialbase.appdownloader.c.h c() {
        return this.o;
    }

    public String d() {
        return this.d;
    }

    public com.ss.android.socialbase.appdownloader.c.f e() {
        return this.r;
    }

    public boolean f() {
        return com.ss.android.socialbase.downloader.g.a.b().optInt("package_flag_config", 1) == 1;
    }

    public j g() {
        return this.s;
    }

    public File h() {
        return Downloader.getInstance(com.ss.android.socialbase.downloader.downloader.c.O()).getGlobalSaveDir();
    }

    public String i() {
        return this.f806c;
    }

    public void k() {
        if (com.ss.android.socialbase.downloader.g.a.c().a("enable_app_install_receiver", 1) <= 0) {
            com.ss.android.socialbase.downloader.c.a.b(a, "disable app install receiver");
            return;
        }
        synchronized (this.e) {
            try {
                if (h) {
                    return;
                }
                try {
                    IntentFilter intentFilter = new IntentFilter();
                    intentFilter.addAction("android.intent.action.PACKAGE_ADDED");
                    intentFilter.addAction("android.intent.action.PACKAGE_REPLACED");
                    intentFilter.addDataScheme("package");
                    com.ss.android.socialbase.downloader.downloader.c.O().registerReceiver(this.e, intentFilter);
                    h = true;
                    o oVar = this.v;
                    if (oVar != null) {
                        oVar.a();
                    }
                } catch (Throwable th) {
                    th.printStackTrace();
                }
                com.ss.android.socialbase.downloader.c.a.b(a, "tryRegisterTempAppInstallDownloadReceiver mIsAppInstallRegistered:" + g);
            } finally {
                b(0);
            }
        }
    }

    public void l() {
        o oVar;
        synchronized (this.e) {
            try {
                if (g) {
                    com.ss.android.socialbase.downloader.downloader.c.O().unregisterReceiver(this.e);
                    if (h && (oVar = this.v) != null) {
                        oVar.b();
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            g = false;
            h = false;
        }
        com.ss.android.socialbase.downloader.c.a.b(a, "registerDownloadReceiver unRegisterDownloadReceiver");
    }

    public m m() {
        return this.q;
    }

    public com.ss.android.socialbase.appdownloader.c.g n() {
        return this.p;
    }

    public com.ss.android.socialbase.downloader.downloader.r o() {
        return Downloader.getInstance(com.ss.android.socialbase.downloader.downloader.c.O()).getReserveWifiStatusListener();
    }

    public ac p() {
        return this.t;
    }

    public af q() {
        return this.u;
    }

    private void c(Context context) {
        if (context == null || f) {
            return;
        }
        com.ss.android.socialbase.downloader.constants.e.a(AdBaseConstants.MIME_APK);
        com.ss.android.socialbase.downloader.downloader.c.a(context);
        com.ss.android.socialbase.downloader.downloader.c.a(new com.ss.android.socialbase.appdownloader.d.b());
        if (this.l) {
            com.ss.android.socialbase.downloader.downloader.c.a(new Runnable() { // from class: com.ss.android.socialbase.appdownloader.d.1
                @Override // java.lang.Runnable
                public void run() {
                    d.this.s();
                }
            }, 5L, TimeUnit.SECONDS);
        } else {
            s();
        }
        t();
        f = true;
    }

    public com.ss.android.socialbase.appdownloader.c.d b() {
        return this.n;
    }

    public com.ss.android.socialbase.appdownloader.c.c a() {
        return this.m;
    }

    public void b(String str) {
        Downloader.getInstance(com.ss.android.socialbase.downloader.downloader.c.O()).setDefaultSavePath(str);
    }

    private void b(int i) {
        this.j = com.ss.android.socialbase.downloader.g.a.c().a("app_install_keep_receiver_time_s", 60);
        com.ss.android.socialbase.downloader.c.a.b(a, "tryUnRegisterTempAppInstallDownloadReceiver mAppInstallReceiverKeepTime:" + this.j);
        if (this.j <= 0) {
            return;
        }
        if (i > 0) {
            this.j = i;
        }
        Future future = this.i;
        if (future != null) {
            try {
                future.cancel(true);
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
        this.i = com.ss.android.socialbase.downloader.downloader.c.a(new Runnable() { // from class: com.ss.android.socialbase.appdownloader.d.2
            @Override // java.lang.Runnable
            public void run() {
                com.ss.android.socialbase.downloader.c.a.b(d.a, "registerDownloadReceiver tryUnRegisterTempAppInstallDownloadReceiver run inner");
                d.this.l();
                d.this.s();
            }
        }, this.j, TimeUnit.SECONDS);
    }

    public void a(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        this.d = str;
    }

    public void a(j jVar) {
        this.s = jVar;
    }

    @Deprecated
    public void a(Context context, String str, com.ss.android.socialbase.appdownloader.c.c cVar, com.ss.android.socialbase.appdownloader.c.d dVar, com.ss.android.socialbase.appdownloader.c.h hVar) {
        if (cVar != null) {
            this.m = cVar;
        }
        if (dVar != null) {
            this.n = dVar;
        }
        if (hVar != null) {
            this.o = hVar;
        }
        c(context);
    }

    public static boolean a(Context context, int i) {
        return c.a(context, i, true) == 1;
    }

    private DownloadInfo b(Context context, String str) {
        List<DownloadInfo> downloadInfoList = Downloader.getInstance(context).getDownloadInfoList(str);
        if (downloadInfoList == null) {
            return null;
        }
        for (DownloadInfo downloadInfo : downloadInfoList) {
            if (downloadInfo != null && downloadInfo.isSavePathRedirected()) {
                return downloadInfo;
            }
        }
        return null;
    }

    public void a(Context context, int i, int i2) {
        try {
            switch (i2) {
                case -4:
                case -1:
                    Downloader.getInstance(context).restart(i);
                    return;
                case -3:
                    c.a(context, i, true);
                    return;
                case -2:
                    Downloader.getInstance(context).resume(i);
                    return;
                case 0:
                case 6:
                default:
                    return;
                case 1:
                case 2:
                case 3:
                case 4:
                case 5:
                case 7:
                case 8:
                    Downloader.getInstance(context).pause(i);
                    return;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public List<DownloadInfo> b(Context context) {
        return Downloader.getInstance(context).getDownloadingDownloadInfosWithMimeType(AdBaseConstants.MIME_APK);
    }

    /* JADX WARN: Can't wrap try/catch for region: R(27:37|(1:39)|40|(2:44|45)|48|(1:116)(1:55)|56|(2:62|(1:64)(19:65|66|(1:68)|69|(3:71|(2:74|72)|75)|76|77|78|(1:80)(1:113)|81|82|(6:87|(1:110)(1:91)|92|(1:96)|(1:(1:108)(1:107))|109)|111|(1:89)|110|92|(2:94|96)|(0)|109))|115|66|(0)|69|(0)|76|77|78|(0)(0)|81|82|(8:84|87|(0)|110|92|(0)|(0)|109)|111|(0)|110|92|(0)|(0)|109) */
    /* JADX WARN: Removed duplicated region for block: B:113:0x0175 A[Catch: all -> 0x0190, TryCatch #0 {all -> 0x0190, blocks: (B:78:0x0169, B:80:0x016f, B:81:0x017a, B:113:0x0175), top: B:77:0x0169 }] */
    /* JADX WARN: Removed duplicated region for block: B:68:0x0142 A[Catch: all -> 0x0393, TryCatch #1 {all -> 0x0393, blocks: (B:7:0x0010, B:11:0x0023, B:14:0x002c, B:16:0x003a, B:17:0x0042, B:19:0x004a, B:20:0x0053, B:23:0x005a, B:25:0x0066, B:28:0x0072, B:30:0x0080, B:31:0x0084, B:33:0x008b, B:37:0x0093, B:40:0x009e, B:42:0x00b2, B:48:0x00cc, B:51:0x00e5, B:53:0x00eb, B:56:0x00fc, B:58:0x0102, B:60:0x0108, B:62:0x010e, B:64:0x0114, B:65:0x0122, B:66:0x013c, B:68:0x0142, B:69:0x0147, B:71:0x0151, B:72:0x0155, B:74:0x015b, B:76:0x0165, B:82:0x0190, B:84:0x0196, B:89:0x01a2, B:91:0x01ae, B:92:0x01be, B:94:0x033a, B:96:0x0344, B:99:0x034f, B:101:0x0355, B:103:0x035b, B:105:0x0365, B:107:0x036b, B:108:0x037b), top: B:6:0x0010 }] */
    /* JADX WARN: Removed duplicated region for block: B:71:0x0151 A[Catch: all -> 0x0393, TryCatch #1 {all -> 0x0393, blocks: (B:7:0x0010, B:11:0x0023, B:14:0x002c, B:16:0x003a, B:17:0x0042, B:19:0x004a, B:20:0x0053, B:23:0x005a, B:25:0x0066, B:28:0x0072, B:30:0x0080, B:31:0x0084, B:33:0x008b, B:37:0x0093, B:40:0x009e, B:42:0x00b2, B:48:0x00cc, B:51:0x00e5, B:53:0x00eb, B:56:0x00fc, B:58:0x0102, B:60:0x0108, B:62:0x010e, B:64:0x0114, B:65:0x0122, B:66:0x013c, B:68:0x0142, B:69:0x0147, B:71:0x0151, B:72:0x0155, B:74:0x015b, B:76:0x0165, B:82:0x0190, B:84:0x0196, B:89:0x01a2, B:91:0x01ae, B:92:0x01be, B:94:0x033a, B:96:0x0344, B:99:0x034f, B:101:0x0355, B:103:0x035b, B:105:0x0365, B:107:0x036b, B:108:0x037b), top: B:6:0x0010 }] */
    /* JADX WARN: Removed duplicated region for block: B:80:0x016f A[Catch: all -> 0x0190, TryCatch #0 {all -> 0x0190, blocks: (B:78:0x0169, B:80:0x016f, B:81:0x017a, B:113:0x0175), top: B:77:0x0169 }] */
    /* JADX WARN: Removed duplicated region for block: B:89:0x01a2 A[Catch: all -> 0x0393, TryCatch #1 {all -> 0x0393, blocks: (B:7:0x0010, B:11:0x0023, B:14:0x002c, B:16:0x003a, B:17:0x0042, B:19:0x004a, B:20:0x0053, B:23:0x005a, B:25:0x0066, B:28:0x0072, B:30:0x0080, B:31:0x0084, B:33:0x008b, B:37:0x0093, B:40:0x009e, B:42:0x00b2, B:48:0x00cc, B:51:0x00e5, B:53:0x00eb, B:56:0x00fc, B:58:0x0102, B:60:0x0108, B:62:0x010e, B:64:0x0114, B:65:0x0122, B:66:0x013c, B:68:0x0142, B:69:0x0147, B:71:0x0151, B:72:0x0155, B:74:0x015b, B:76:0x0165, B:82:0x0190, B:84:0x0196, B:89:0x01a2, B:91:0x01ae, B:92:0x01be, B:94:0x033a, B:96:0x0344, B:99:0x034f, B:101:0x0355, B:103:0x035b, B:105:0x0365, B:107:0x036b, B:108:0x037b), top: B:6:0x0010 }] */
    /* JADX WARN: Removed duplicated region for block: B:94:0x033a A[Catch: all -> 0x0393, TryCatch #1 {all -> 0x0393, blocks: (B:7:0x0010, B:11:0x0023, B:14:0x002c, B:16:0x003a, B:17:0x0042, B:19:0x004a, B:20:0x0053, B:23:0x005a, B:25:0x0066, B:28:0x0072, B:30:0x0080, B:31:0x0084, B:33:0x008b, B:37:0x0093, B:40:0x009e, B:42:0x00b2, B:48:0x00cc, B:51:0x00e5, B:53:0x00eb, B:56:0x00fc, B:58:0x0102, B:60:0x0108, B:62:0x010e, B:64:0x0114, B:65:0x0122, B:66:0x013c, B:68:0x0142, B:69:0x0147, B:71:0x0151, B:72:0x0155, B:74:0x015b, B:76:0x0165, B:82:0x0190, B:84:0x0196, B:89:0x01a2, B:91:0x01ae, B:92:0x01be, B:94:0x033a, B:96:0x0344, B:99:0x034f, B:101:0x0355, B:103:0x035b, B:105:0x0365, B:107:0x036b, B:108:0x037b), top: B:6:0x0010 }] */
    /* JADX WARN: Removed duplicated region for block: B:98:0x034d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public int a(com.ss.android.socialbase.appdownloader.f r23) {
        /*
            Method dump skipped, instructions count: 957
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ss.android.socialbase.appdownloader.d.a(com.ss.android.socialbase.appdownloader.f):int");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(DownloadTask downloadTask, int i, boolean z) {
        if (downloadTask == null) {
            return;
        }
        downloadTask.download();
        DownloadInfo downloadInfo = downloadTask.getDownloadInfo();
        if (downloadInfo != null) {
            downloadInfo.setAntiHijackErrorCode(i);
        }
        if (downloadInfo == null || !z) {
            return;
        }
        downloadInfo.setSavePathRedirected(z);
    }

    private List<com.ss.android.socialbase.downloader.model.c> a(List<com.ss.android.socialbase.downloader.model.c> list) {
        ArrayList arrayList = new ArrayList();
        boolean z = false;
        if (list != null && list.size() > 0) {
            for (com.ss.android.socialbase.downloader.model.c cVar : list) {
                if (cVar != null && !TextUtils.isEmpty(cVar.a()) && !TextUtils.isEmpty(cVar.b())) {
                    if (cVar.a().equals(com.sigmob.sdk.downloader.core.c.d)) {
                        z = true;
                    }
                    arrayList.add(new com.ss.android.socialbase.downloader.model.c(cVar.a(), cVar.b()));
                }
            }
        }
        if (!z) {
            arrayList.add(new com.ss.android.socialbase.downloader.model.c(com.sigmob.sdk.downloader.core.c.d, com.ss.android.socialbase.appdownloader.b.a.a));
        }
        return arrayList;
    }

    public String a(String str, String str2) {
        return (TextUtils.isEmpty(str) || !str.endsWith(".apk") || c.c(str2)) ? str2 : AdBaseConstants.MIME_APK;
    }

    private z a(final com.ss.android.socialbase.appdownloader.c.e eVar) {
        if (eVar == null) {
            return null;
        }
        return new z() { // from class: com.ss.android.socialbase.appdownloader.d.6
            @Override // com.ss.android.socialbase.downloader.depend.z
            public void a(int i, DownloadInfo downloadInfo, String str, String str2) {
                if (i != 1 && i != 3) {
                    switch (i) {
                        case 5:
                        case 6:
                        case 7:
                            break;
                        case 8:
                            downloadInfo.getPackageName();
                            return;
                        case 9:
                            com.ss.android.socialbase.downloader.downloader.c.O();
                            return;
                        default:
                            return;
                    }
                }
                downloadInfo.getStatus();
                downloadInfo.getDownloadTime();
            }

            @Override // com.ss.android.socialbase.downloader.depend.z
            public boolean a(boolean z) {
                return eVar.a(z);
            }

            @Override // com.ss.android.socialbase.downloader.depend.z
            public String a() {
                return eVar.a();
            }
        };
    }

    public DownloadInfo a(Context context, String str) {
        if (!TextUtils.isEmpty(str) && context != null) {
            try {
                DownloadInfo a2 = a(context, str, h());
                if (a2 == null) {
                    a2 = a(context, str, context.getExternalFilesDir(Environment.DIRECTORY_DOWNLOADS));
                }
                if (a2 == null) {
                    a2 = a(context, str, Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS));
                }
                if (a2 == null) {
                    a2 = a(context, str, context.getFilesDir());
                }
                return (a2 == null && com.ss.android.socialbase.downloader.g.a.c().a("get_download_info_by_list")) ? b(context, str) : a2;
            } catch (Throwable th) {
                com.ss.android.socialbase.downloader.c.a.b(a, String.format("getAppDownloadInfo error:%s", th.getMessage()));
            }
        }
        return null;
    }

    private DownloadInfo a(Context context, String str, File file) {
        if (context == null || TextUtils.isEmpty(str) || file == null) {
            return null;
        }
        return Downloader.getInstance(context).getDownloadInfo(str, file.getAbsolutePath());
    }

    public List<DownloadInfo> a(Context context) {
        return Downloader.getInstance(context).getUnCompletedDownloadInfosWithMimeType(AdBaseConstants.MIME_APK);
    }

    public void a(com.ss.android.socialbase.appdownloader.c.g gVar) {
        this.p = gVar;
    }

    public void a(com.ss.android.socialbase.downloader.downloader.r rVar) {
        Downloader.getInstance(com.ss.android.socialbase.downloader.downloader.c.O()).setReserveWifiStatusListener(rVar);
    }

    public void a(ac acVar) {
        this.t = acVar;
    }

    public void a(af afVar) {
        this.u = afVar;
    }

    public void a(int i) {
        if (com.ss.android.socialbase.downloader.g.a.c().a("enable_app_install_receiver", 1) <= 0) {
            return;
        }
        k();
        b(i);
    }

    public void a(o oVar) {
        this.v = oVar;
    }

    public void a(boolean z) {
        this.l = z;
    }
}
