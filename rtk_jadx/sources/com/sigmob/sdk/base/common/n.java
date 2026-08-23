package com.sigmob.sdk.base.common;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Build;
import android.text.TextUtils;
import com.czhj.sdk.common.network.Networking;
import com.czhj.sdk.common.utils.Md5Util;
import com.sigmob.sdk.base.common.ae;
import com.sigmob.sdk.base.models.BaseAdUnit;
import com.sigmob.sdk.base.models.IntentActions;
import com.sigmob.sdk.base.mta.PointCategory;
import com.sigmob.sdk.base.mta.PointEntitySigmob;
import com.sigmob.sdk.downloader.f;
import com.sigmob.sdk.downloader.l;
import com.sigmob.windad.WindAds;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class n {
    private static HashMap<String, com.sigmob.sdk.downloader.f> a = new HashMap<>();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.sigmob.sdk.base.common.n$2, reason: invalid class name */
    /* loaded from: /tmp/rtk_apk/classes3.dex */
    public static /* synthetic */ class AnonymousClass2 {
        static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[l.a.values().length];
            a = iArr;
            try {
                iArr[l.a.RUNNING.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[l.a.COMPLETED.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                a[l.a.PENDING.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                a[l.a.CANCELED.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    /* loaded from: /tmp/rtk_apk/classes3.dex */
    static class a extends BroadcastReceiver {
        static final String a = "downloadButtonAction";
        static final String b = "downloadAction";

        /* renamed from: c, reason: collision with root package name */
        private final com.sigmob.sdk.downloader.f f391c;
        private final BaseAdUnit d;
        private final String e;

        public a(com.sigmob.sdk.downloader.f fVar, String str, BaseAdUnit baseAdUnit) {
            this.f391c = fVar;
            this.e = str;
            this.d = baseAdUnit;
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            if (this.f391c == null || TextUtils.isEmpty(this.e)) {
                return;
            }
            if (!Objects.equals(intent.getAction(), this.e)) {
                if (com.sigmob.sdk.downloader.l.c(this.f391c)) {
                    WindAds.sharedAds().getHandler().post(new Runnable() { // from class: com.sigmob.sdk.base.common.n.a.2
                        @Override // java.lang.Runnable
                        public void run() {
                            p.a(com.sigmob.sdk.b.e(), a.this.f391c.n().getAbsolutePath(), a.this.d);
                        }
                    });
                }
            } else {
                if (!com.sigmob.sdk.downloader.l.a(this.f391c)) {
                    this.f391c.B();
                    return;
                }
                if (this.d != null) {
                    HashMap hashMap = new HashMap();
                    hashMap.put("result", "1");
                    hashMap.put("downloadId", this.d.getDownloadId());
                    BaseBroadcastReceiver.a(context, this.d.getUuid(), hashMap, IntentActions.ACTION_INTERSTITIAL_DOWNLOAD_PAUSE);
                }
                WindAds.sharedAds().getHandler().postDelayed(new Runnable() { // from class: com.sigmob.sdk.base.common.n.a.1
                    @Override // java.lang.Runnable
                    public void run() {
                        a.this.f391c.E();
                    }
                }, 200L);
            }
        }
    }

    public static int a(Context context, BaseAdUnit baseAdUnit) {
        final com.sigmob.sdk.downloader.f downloadTask = baseAdUnit.getDownloadTask();
        if (downloadTask == null || !com.sigmob.sdk.downloader.l.a(downloadTask)) {
            return -1;
        }
        HashMap hashMap = new HashMap();
        hashMap.put("result", "1");
        hashMap.put("downloadId", baseAdUnit.getDownloadId());
        BaseBroadcastReceiver.a(context, baseAdUnit.getUuid(), hashMap, IntentActions.ACTION_INTERSTITIAL_DOWNLOAD_PAUSE);
        WindAds.sharedAds().getHandler().postDelayed(new Runnable() { // from class: com.sigmob.sdk.base.common.n.1
            @Override // java.lang.Runnable
            public void run() {
                com.sigmob.sdk.downloader.f.this.E();
            }
        }, 200L);
        return 0;
    }

    private static String a(BaseAdUnit baseAdUnit, String str) {
        String apkMd5 = baseAdUnit.getApkMd5();
        if (TextUtils.isEmpty(apkMd5)) {
            apkMd5 = Md5Util.md5(str);
        }
        return apkMd5 + ".apk";
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static void a(final String str, final BaseAdUnit baseAdUnit, boolean z) {
        String str2;
        Object obj;
        final String str3;
        PendingIntent broadcast;
        com.sigmob.sdk.downloader.core.breakpoint.g c2;
        final Context e = com.sigmob.sdk.b.e();
        try {
            final com.sigmob.sdk.downloader.f downloadTask = baseAdUnit.getDownloadTask();
            if (downloadTask != null) {
                str3 = downloadTask.n().getAbsolutePath();
                try {
                    if (com.sigmob.sdk.downloader.l.c(downloadTask)) {
                        if (baseAdUnit.isRecord()) {
                            com.sigmob.sdk.base.network.g.a(baseAdUnit, com.sigmob.sdk.base.common.a.H);
                        }
                        WindAds.sharedAds().getHandler().post(new Runnable() { // from class: com.sigmob.sdk.base.common.n.6
                            @Override // java.lang.Runnable
                            public void run() {
                                p.a(com.sigmob.sdk.b.e(), com.sigmob.sdk.downloader.f.this.n().getAbsolutePath(), baseAdUnit);
                            }
                        });
                        return;
                    } else {
                        if (com.sigmob.sdk.downloader.l.a(downloadTask)) {
                            aj.a(e, "正在下载", 1).show();
                            HashMap hashMap = new HashMap();
                            hashMap.put("result", "1");
                            hashMap.put("downloadId", baseAdUnit.getDownloadId());
                            BaseBroadcastReceiver.a(e, baseAdUnit.getUuid(), hashMap, IntentActions.ACTION_INTERSTITIAL_DOWNLOAD_START);
                            return;
                        }
                        str2 = IntentActions.ACTION_INTERSTITIAL_DOWNLOAD_START;
                        obj = "downloadId";
                    }
                } catch (Throwable th) {
                    th = th;
                    str2 = IntentActions.ACTION_INTERSTITIAL_DOWNLOAD_START;
                    obj = "downloadId";
                    HashMap hashMap2 = new HashMap();
                    hashMap2.put("result", "0");
                    hashMap2.put(obj, baseAdUnit.getDownloadId());
                    BaseBroadcastReceiver.a(e, baseAdUnit.getUuid(), hashMap2, str2);
                    ae.a("download_start", "0", baseAdUnit, new ae.a() { // from class: com.sigmob.sdk.base.common.n.9
                        @Override // com.sigmob.sdk.base.common.ae.a
                        public void a(Object obj2) {
                            if (obj2 instanceof PointEntitySigmob) {
                                PointEntitySigmob pointEntitySigmob = (PointEntitySigmob) obj2;
                                pointEntitySigmob.setFinal_url(str);
                                HashMap hashMap3 = new HashMap();
                                hashMap3.put("apkfile", str3);
                                hashMap3.put("apkurl", str);
                                pointEntitySigmob.setOptions(hashMap3);
                            }
                        }
                    });
                    ae.a(PointCategory.APKDOWNLOAD, "start", baseAdUnit, new ae.a() { // from class: com.sigmob.sdk.base.common.n.10
                        @Override // com.sigmob.sdk.base.common.ae.a
                        public void a(Object obj2) {
                            if (obj2 instanceof PointEntitySigmob) {
                                PointEntitySigmob pointEntitySigmob = (PointEntitySigmob) obj2;
                                pointEntitySigmob.getOptions().put("status", String.valueOf(0));
                                pointEntitySigmob.getOptions().put("error", th.getMessage());
                                aj.a(e, "下载失败，" + th.getMessage(), 1).show();
                            }
                        }
                    });
                }
            } else {
                f.a c3 = new f.a(str, com.sigmob.sdk.base.utils.e.a(e)).a(baseAdUnit.getApkName()).c(false);
                c3.a(com.sigmob.sdk.downloader.core.c.d, Networking.getUserAgent());
                if (!z) {
                    c3 = c3.a(1);
                }
                downloadTask = c3.a();
                if (com.sigmob.sdk.downloader.l.a(downloadTask)) {
                    com.sigmob.sdk.downloader.g.j().a().a((com.sigmob.sdk.downloader.core.a) downloadTask);
                }
                File n = downloadTask.n();
                if (n != null && n.exists()) {
                    n.delete();
                }
                if (n.getParentFile().exists()) {
                    n.getParentFile().mkdirs();
                }
                com.sigmob.sdk.downloader.h hVar = new com.sigmob.sdk.downloader.h(com.sigmob.sdk.b.e()) { // from class: com.sigmob.sdk.base.common.n.7
                    private l.a d;

                    @Override // com.sigmob.sdk.downloader.h, com.sigmob.sdk.downloader.core.listener.c
                    protected void a(final com.sigmob.sdk.downloader.f fVar) {
                        this.d = l.a.COMPLETED;
                        super.a(fVar);
                        baseAdUnit.enableUseDownloadApk(true);
                        if (baseAdUnit.isRecord()) {
                            ae.b(PointCategory.DOWNLOAD_END, "1", baseAdUnit);
                            com.sigmob.sdk.base.network.g.a(baseAdUnit, com.sigmob.sdk.base.common.a.H);
                        }
                        WindAds.sharedAds().getHandler().post(new Runnable() { // from class: com.sigmob.sdk.base.common.n.7.1
                            @Override // java.lang.Runnable
                            public void run() {
                                p.a(com.sigmob.sdk.b.e(), fVar.n().getAbsolutePath(), baseAdUnit);
                            }
                        });
                        ae.a(PointCategory.APKDOWNLOAD, PointCategory.END, baseAdUnit, new ae.a() { // from class: com.sigmob.sdk.base.common.n.7.2
                            @Override // com.sigmob.sdk.base.common.ae.a
                            public void a(Object obj2) {
                                if (obj2 instanceof PointEntitySigmob) {
                                    ((PointEntitySigmob) obj2).getOptions().put("status", String.valueOf(1));
                                }
                            }
                        });
                        HashMap hashMap3 = new HashMap();
                        hashMap3.put("result", "1");
                        hashMap3.put("downloadId", baseAdUnit.getDownloadId());
                        BaseBroadcastReceiver.a(e, baseAdUnit.getUuid(), hashMap3, IntentActions.ACTION_INTERSTITIAL_DOWNLOAD_END);
                    }

                    @Override // com.sigmob.sdk.downloader.h, com.sigmob.sdk.downloader.core.listener.assist.a.InterfaceC0045a
                    public void a(com.sigmob.sdk.downloader.f fVar, int i, long j, long j2) {
                        super.a(fVar, i, j, j2);
                        HashMap hashMap3 = new HashMap();
                        hashMap3.put("result", "1");
                        hashMap3.put("downloadId", baseAdUnit.getDownloadId());
                        BaseBroadcastReceiver.a(e, baseAdUnit.getUuid(), hashMap3, IntentActions.ACTION_INTERSTITIAL_DOWNLOAD_START);
                    }

                    @Override // com.sigmob.sdk.downloader.h, com.sigmob.sdk.downloader.core.listener.assist.a.InterfaceC0045a
                    public void a(com.sigmob.sdk.downloader.f fVar, long j, long j2) {
                        this.d = l.a.RUNNING;
                        super.a(fVar, j, j2);
                        List<com.sigmob.sdk.videoAd.f> a2 = com.sigmob.sdk.videoAd.f.a(baseAdUnit.getDownloadQuarterTrack(), com.sigmob.sdk.base.common.a.p, j, j2);
                        if (a2.size() > 0) {
                            for (final com.sigmob.sdk.videoAd.f fVar2 : a2) {
                                fVar2.setTracked();
                                ae.a(PointCategory.APKDOWNLOAD, PointCategory.PROGRESS, baseAdUnit, new ae.a() { // from class: com.sigmob.sdk.base.common.n.7.6
                                    /* JADX WARN: Failed to find 'out' block for switch in B:15:0x003a. Please report as an issue. */
                                    @Override // com.sigmob.sdk.base.common.ae.a
                                    public void a(Object obj2) {
                                        Map options;
                                        int i;
                                        if (obj2 instanceof PointEntitySigmob) {
                                            PointEntitySigmob pointEntitySigmob = (PointEntitySigmob) obj2;
                                            String event = fVar2.getEvent();
                                            event.hashCode();
                                            char c4 = 65535;
                                            switch (event.hashCode()) {
                                                case -1986983435:
                                                    if (event.equals(com.sigmob.sdk.base.common.a.p)) {
                                                        c4 = 0;
                                                        break;
                                                    }
                                                    break;
                                                case 1832484244:
                                                    if (event.equals(com.sigmob.sdk.base.common.a.ab)) {
                                                        c4 = 1;
                                                        break;
                                                    }
                                                    break;
                                                case 1854577282:
                                                    if (event.equals(com.sigmob.sdk.base.common.a.aa)) {
                                                        c4 = 2;
                                                        break;
                                                    }
                                                    break;
                                            }
                                            switch (c4) {
                                                case 0:
                                                    options = pointEntitySigmob.getOptions();
                                                    i = 25;
                                                    options.put("status", String.valueOf(i));
                                                    return;
                                                case 1:
                                                    options = pointEntitySigmob.getOptions();
                                                    i = 75;
                                                    options.put("status", String.valueOf(i));
                                                    return;
                                                case 2:
                                                    options = pointEntitySigmob.getOptions();
                                                    i = 50;
                                                    options.put("status", String.valueOf(i));
                                                    return;
                                                default:
                                                    return;
                                            }
                                        }
                                    }
                                });
                            }
                        }
                    }

                    @Override // com.sigmob.sdk.downloader.h, com.sigmob.sdk.downloader.core.listener.c
                    protected void a(com.sigmob.sdk.downloader.f fVar, final Exception exc) {
                        this.d = l.a.UNKNOWN;
                        super.a(fVar, exc);
                        if (fVar.C()) {
                            return;
                        }
                        aj.a(e, "下载失败，" + exc.getMessage(), 1).show();
                        if (baseAdUnit.isRecord()) {
                            ae.b(PointCategory.DOWNLOAD_END, "0", baseAdUnit);
                        }
                        ae.a(PointCategory.APKDOWNLOAD, PointCategory.END, baseAdUnit, new ae.a() { // from class: com.sigmob.sdk.base.common.n.7.3
                            @Override // com.sigmob.sdk.base.common.ae.a
                            public void a(Object obj2) {
                                if (obj2 instanceof PointEntitySigmob) {
                                    PointEntitySigmob pointEntitySigmob = (PointEntitySigmob) obj2;
                                    pointEntitySigmob.getOptions().put("status", String.valueOf(0));
                                    pointEntitySigmob.getOptions().put("error", exc.getMessage());
                                }
                            }
                        });
                        HashMap hashMap3 = new HashMap();
                        hashMap3.put("result", "0");
                        hashMap3.put("downloadId", baseAdUnit.getDownloadId());
                        BaseBroadcastReceiver.a(e, baseAdUnit.getUuid(), hashMap3, IntentActions.ACTION_INTERSTITIAL_DOWNLOAD_END);
                    }

                    @Override // com.sigmob.sdk.downloader.h, com.sigmob.sdk.downloader.core.listener.c
                    protected void b(com.sigmob.sdk.downloader.f fVar) {
                        this.d = l.a.RUNNING;
                        super.b(fVar);
                        ae.a(PointCategory.APKDOWNLOAD, "start", baseAdUnit, new ae.a() { // from class: com.sigmob.sdk.base.common.n.7.4
                            @Override // com.sigmob.sdk.base.common.ae.a
                            public void a(Object obj2) {
                                if (obj2 instanceof PointEntitySigmob) {
                                    ((PointEntitySigmob) obj2).getOptions().put("status", String.valueOf(1));
                                }
                            }
                        });
                    }

                    @Override // com.sigmob.sdk.downloader.h, com.sigmob.sdk.downloader.core.listener.c
                    protected void c(com.sigmob.sdk.downloader.f fVar) {
                        l.a aVar = this.d;
                        l.a aVar2 = l.a.CANCELED;
                        if (aVar == aVar2) {
                            return;
                        }
                        this.d = aVar2;
                        super.c(fVar);
                        ae.a(PointCategory.APKDOWNLOAD, "pause", baseAdUnit, new ae.a() { // from class: com.sigmob.sdk.base.common.n.7.5
                            @Override // com.sigmob.sdk.base.common.ae.a
                            public void a(Object obj2) {
                                if (obj2 instanceof PointEntitySigmob) {
                                    ((PointEntitySigmob) obj2).getOptions().put("status", String.valueOf(1));
                                }
                            }
                        });
                    }
                };
                String str4 = "downloadButtonAction_" + baseAdUnit.getUuid() + "_" + downloadTask.c();
                Intent intent = new Intent(str4);
                intent.setPackage(com.sigmob.sdk.b.e().getPackageName());
                a aVar = new a(downloadTask, str4, baseAdUnit);
                str2 = IntentActions.ACTION_INTERSTITIAL_DOWNLOAD_START;
                try {
                    StringBuilder sb = new StringBuilder();
                    sb.append("downloadAction_");
                    obj = "downloadId";
                    try {
                        sb.append(baseAdUnit.getUuid());
                        sb.append("_");
                        sb.append(downloadTask.c());
                        IntentFilter intentFilter = new IntentFilter(sb.toString());
                        intentFilter.addAction(str4);
                        u.a(e, aVar, intentFilter);
                        Intent intent2 = new Intent("downloadAction_" + baseAdUnit.getUuid() + "_" + downloadTask.c());
                        intent2.setPackage(com.sigmob.sdk.b.e().getPackageName());
                        List<com.sigmob.sdk.videoAd.f> arrayList = new ArrayList<>();
                        arrayList.add(new com.sigmob.sdk.videoAd.f(com.sigmob.sdk.base.common.a.p, 0.25f));
                        arrayList.add(new com.sigmob.sdk.videoAd.f(com.sigmob.sdk.base.common.a.aa, 0.5f));
                        arrayList.add(new com.sigmob.sdk.videoAd.f(com.sigmob.sdk.base.common.a.ab, 0.75f));
                        baseAdUnit.setDownloadQuarterTrack(arrayList);
                        hVar.a(baseAdUnit.getIconUrl(), baseAdUnit.getAppName(), baseAdUnit.getDesc());
                        if (Build.VERSION.SDK_INT >= 31) {
                            hVar.a(PendingIntent.getBroadcast(com.sigmob.sdk.b.e(), 0, intent, 201326592));
                            broadcast = PendingIntent.getBroadcast(com.sigmob.sdk.b.e(), 0, intent2, 201326592);
                        } else {
                            hVar.a(PendingIntent.getBroadcast(com.sigmob.sdk.b.e(), 0, intent, 134217728));
                            broadcast = PendingIntent.getBroadcast(com.sigmob.sdk.b.e(), 0, intent2, 134217728);
                        }
                        hVar.b(broadcast);
                        downloadTask.a((com.sigmob.sdk.downloader.c) hVar);
                        baseAdUnit.setDownloadTask(downloadTask);
                        if (!baseAdUnit.isResumableDownload() && (c2 = com.sigmob.sdk.downloader.g.j().c()) != null) {
                            c2.b(downloadTask.c());
                        }
                        str3 = null;
                    } catch (Throwable th2) {
                        th = th2;
                        str3 = null;
                        HashMap hashMap22 = new HashMap();
                        hashMap22.put("result", "0");
                        hashMap22.put(obj, baseAdUnit.getDownloadId());
                        BaseBroadcastReceiver.a(e, baseAdUnit.getUuid(), hashMap22, str2);
                        ae.a("download_start", "0", baseAdUnit, new ae.a() { // from class: com.sigmob.sdk.base.common.n.9
                            @Override // com.sigmob.sdk.base.common.ae.a
                            public void a(Object obj2) {
                                if (obj2 instanceof PointEntitySigmob) {
                                    PointEntitySigmob pointEntitySigmob = (PointEntitySigmob) obj2;
                                    pointEntitySigmob.setFinal_url(str);
                                    HashMap hashMap3 = new HashMap();
                                    hashMap3.put("apkfile", str3);
                                    hashMap3.put("apkurl", str);
                                    pointEntitySigmob.setOptions(hashMap3);
                                }
                            }
                        });
                        ae.a(PointCategory.APKDOWNLOAD, "start", baseAdUnit, new ae.a() { // from class: com.sigmob.sdk.base.common.n.10
                            @Override // com.sigmob.sdk.base.common.ae.a
                            public void a(Object obj2) {
                                if (obj2 instanceof PointEntitySigmob) {
                                    PointEntitySigmob pointEntitySigmob = (PointEntitySigmob) obj2;
                                    pointEntitySigmob.getOptions().put("status", String.valueOf(0));
                                    pointEntitySigmob.getOptions().put("error", th.getMessage());
                                    aj.a(e, "下载失败，" + th.getMessage(), 1).show();
                                }
                            }
                        });
                    }
                } catch (Throwable th3) {
                    th = th3;
                    obj = "downloadId";
                    str3 = null;
                    HashMap hashMap222 = new HashMap();
                    hashMap222.put("result", "0");
                    hashMap222.put(obj, baseAdUnit.getDownloadId());
                    BaseBroadcastReceiver.a(e, baseAdUnit.getUuid(), hashMap222, str2);
                    ae.a("download_start", "0", baseAdUnit, new ae.a() { // from class: com.sigmob.sdk.base.common.n.9
                        @Override // com.sigmob.sdk.base.common.ae.a
                        public void a(Object obj2) {
                            if (obj2 instanceof PointEntitySigmob) {
                                PointEntitySigmob pointEntitySigmob = (PointEntitySigmob) obj2;
                                pointEntitySigmob.setFinal_url(str);
                                HashMap hashMap3 = new HashMap();
                                hashMap3.put("apkfile", str3);
                                hashMap3.put("apkurl", str);
                                pointEntitySigmob.setOptions(hashMap3);
                            }
                        }
                    });
                    ae.a(PointCategory.APKDOWNLOAD, "start", baseAdUnit, new ae.a() { // from class: com.sigmob.sdk.base.common.n.10
                        @Override // com.sigmob.sdk.base.common.ae.a
                        public void a(Object obj2) {
                            if (obj2 instanceof PointEntitySigmob) {
                                PointEntitySigmob pointEntitySigmob = (PointEntitySigmob) obj2;
                                pointEntitySigmob.getOptions().put("status", String.valueOf(0));
                                pointEntitySigmob.getOptions().put("error", th.getMessage());
                                aj.a(e, "下载失败，" + th.getMessage(), 1).show();
                            }
                        }
                    });
                }
            }
            try {
                baseAdUnit.setDownloadId(Long.valueOf(downloadTask.c()));
                downloadTask.B();
                aj.a(e, "已开始下载", 1).show();
                if (baseAdUnit.isRecord()) {
                    com.sigmob.sdk.base.network.g.a(baseAdUnit, "download_start");
                    ae.a("download_start", "1", baseAdUnit, new ae.a() { // from class: com.sigmob.sdk.base.common.n.8
                        @Override // com.sigmob.sdk.base.common.ae.a
                        public void a(Object obj2) {
                            if (obj2 instanceof PointEntitySigmob) {
                                PointEntitySigmob pointEntitySigmob = (PointEntitySigmob) obj2;
                                pointEntitySigmob.setFinal_url(str);
                                HashMap hashMap3 = new HashMap();
                                hashMap3.put("apkfile", str3);
                                hashMap3.put("apkurl", str);
                                pointEntitySigmob.setOptions(hashMap3);
                            }
                        }
                    });
                }
            } catch (Throwable th4) {
                th = th4;
                HashMap hashMap2222 = new HashMap();
                hashMap2222.put("result", "0");
                hashMap2222.put(obj, baseAdUnit.getDownloadId());
                BaseBroadcastReceiver.a(e, baseAdUnit.getUuid(), hashMap2222, str2);
                ae.a("download_start", "0", baseAdUnit, new ae.a() { // from class: com.sigmob.sdk.base.common.n.9
                    @Override // com.sigmob.sdk.base.common.ae.a
                    public void a(Object obj2) {
                        if (obj2 instanceof PointEntitySigmob) {
                            PointEntitySigmob pointEntitySigmob = (PointEntitySigmob) obj2;
                            pointEntitySigmob.setFinal_url(str);
                            HashMap hashMap3 = new HashMap();
                            hashMap3.put("apkfile", str3);
                            hashMap3.put("apkurl", str);
                            pointEntitySigmob.setOptions(hashMap3);
                        }
                    }
                });
                ae.a(PointCategory.APKDOWNLOAD, "start", baseAdUnit, new ae.a() { // from class: com.sigmob.sdk.base.common.n.10
                    @Override // com.sigmob.sdk.base.common.ae.a
                    public void a(Object obj2) {
                        if (obj2 instanceof PointEntitySigmob) {
                            PointEntitySigmob pointEntitySigmob = (PointEntitySigmob) obj2;
                            pointEntitySigmob.getOptions().put("status", String.valueOf(0));
                            pointEntitySigmob.getOptions().put("error", th.getMessage());
                            aj.a(e, "下载失败，" + th.getMessage(), 1).show();
                        }
                    }
                });
            }
        } catch (Throwable th5) {
            th = th5;
            str2 = IntentActions.ACTION_INTERSTITIAL_DOWNLOAD_START;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static void a(String str, final String str2, String str3, String str4, boolean z) {
        Context e;
        int i;
        final com.sigmob.sdk.downloader.f fVar = a.get(str);
        if (fVar != null) {
            if (com.sigmob.sdk.downloader.l.c(fVar)) {
                WindAds.sharedAds().getHandler().post(new Runnable() { // from class: com.sigmob.sdk.base.common.n.4
                    @Override // java.lang.Runnable
                    public void run() {
                        p.a(com.sigmob.sdk.b.e(), com.sigmob.sdk.downloader.f.this.n().getAbsolutePath(), (BaseAdUnit) null);
                    }
                });
                return;
            } else if (com.sigmob.sdk.downloader.l.a(fVar)) {
                aj.a(com.sigmob.sdk.b.e(), "正在下载", 1).show();
                return;
            } else {
                aj.a(com.sigmob.sdk.b.e(), "继续下载", 1).show();
                fVar.B();
                return;
            }
        }
        f.a c2 = new f.a(str2, com.sigmob.sdk.base.utils.e.a(com.sigmob.sdk.b.e())).a(str).c(false);
        c2.a(com.sigmob.sdk.downloader.core.c.d, Networking.getUserAgent());
        com.sigmob.sdk.downloader.f a2 = z ? c2.a() : c2.a(1).a();
        if (com.sigmob.sdk.downloader.l.a(a2)) {
            com.sigmob.sdk.downloader.g.j().a().a((com.sigmob.sdk.downloader.core.a) a2);
        }
        File n = a2.n();
        if (n != null && n.exists()) {
            n.delete();
        }
        if (n.getParentFile().exists()) {
            n.getParentFile().mkdirs();
        }
        final ArrayList arrayList = new ArrayList();
        arrayList.add(new com.sigmob.sdk.videoAd.f(com.sigmob.sdk.base.common.a.p, 0.25f));
        arrayList.add(new com.sigmob.sdk.videoAd.f(com.sigmob.sdk.base.common.a.aa, 0.5f));
        arrayList.add(new com.sigmob.sdk.videoAd.f(com.sigmob.sdk.base.common.a.ab, 0.75f));
        com.sigmob.sdk.downloader.h hVar = new com.sigmob.sdk.downloader.h(com.sigmob.sdk.b.e()) { // from class: com.sigmob.sdk.base.common.n.5
            private l.a d;

            @Override // com.sigmob.sdk.downloader.h, com.sigmob.sdk.downloader.core.listener.c
            protected void a(final com.sigmob.sdk.downloader.f fVar2) {
                this.d = l.a.COMPLETED;
                super.a(fVar2);
                WindAds.sharedAds().getHandler().post(new Runnable() { // from class: com.sigmob.sdk.base.common.n.5.1
                    @Override // java.lang.Runnable
                    public void run() {
                        p.a(com.sigmob.sdk.b.e(), fVar2.n().getAbsolutePath(), (BaseAdUnit) null);
                    }
                });
                ae.a(PointCategory.APKDOWNLOAD, PointCategory.END, (BaseAdUnit) null, new ae.a() { // from class: com.sigmob.sdk.base.common.n.5.2
                    @Override // com.sigmob.sdk.base.common.ae.a
                    public void a(Object obj) {
                        if (obj instanceof PointEntitySigmob) {
                            PointEntitySigmob pointEntitySigmob = (PointEntitySigmob) obj;
                            pointEntitySigmob.getOptions().put("status", String.valueOf(1));
                            pointEntitySigmob.getOptions().put("url", str2);
                        }
                    }
                });
            }

            @Override // com.sigmob.sdk.downloader.h, com.sigmob.sdk.downloader.core.listener.assist.a.InterfaceC0045a
            public void a(com.sigmob.sdk.downloader.f fVar2, int i2, long j, long j2) {
                super.a(fVar2, i2, j, j2);
            }

            @Override // com.sigmob.sdk.downloader.h, com.sigmob.sdk.downloader.core.listener.assist.a.InterfaceC0045a
            public void a(com.sigmob.sdk.downloader.f fVar2, long j, long j2) {
                this.d = l.a.RUNNING;
                super.a(fVar2, j, j2);
                List<com.sigmob.sdk.videoAd.f> a3 = com.sigmob.sdk.videoAd.f.a(arrayList, com.sigmob.sdk.base.common.a.p, j, j2);
                if (a3.size() > 0) {
                    for (final com.sigmob.sdk.videoAd.f fVar3 : a3) {
                        fVar3.setTracked();
                        ae.a(PointCategory.APKDOWNLOAD, PointCategory.PROGRESS, (BaseAdUnit) null, new ae.a() { // from class: com.sigmob.sdk.base.common.n.5.6
                            /* JADX WARN: Failed to find 'out' block for switch in B:15:0x0047. Please report as an issue. */
                            @Override // com.sigmob.sdk.base.common.ae.a
                            public void a(Object obj) {
                                Map options;
                                int i2;
                                if (obj instanceof PointEntitySigmob) {
                                    PointEntitySigmob pointEntitySigmob = (PointEntitySigmob) obj;
                                    pointEntitySigmob.getOptions().put("url", str2);
                                    String event = fVar3.getEvent();
                                    event.hashCode();
                                    char c3 = 65535;
                                    switch (event.hashCode()) {
                                        case -1986983435:
                                            if (event.equals(com.sigmob.sdk.base.common.a.p)) {
                                                c3 = 0;
                                                break;
                                            }
                                            break;
                                        case 1832484244:
                                            if (event.equals(com.sigmob.sdk.base.common.a.ab)) {
                                                c3 = 1;
                                                break;
                                            }
                                            break;
                                        case 1854577282:
                                            if (event.equals(com.sigmob.sdk.base.common.a.aa)) {
                                                c3 = 2;
                                                break;
                                            }
                                            break;
                                    }
                                    switch (c3) {
                                        case 0:
                                            options = pointEntitySigmob.getOptions();
                                            i2 = 25;
                                            options.put("status", String.valueOf(i2));
                                            return;
                                        case 1:
                                            options = pointEntitySigmob.getOptions();
                                            i2 = 75;
                                            options.put("status", String.valueOf(i2));
                                            return;
                                        case 2:
                                            options = pointEntitySigmob.getOptions();
                                            i2 = 50;
                                            options.put("status", String.valueOf(i2));
                                            return;
                                        default:
                                            return;
                                    }
                                }
                            }
                        });
                    }
                }
            }

            @Override // com.sigmob.sdk.downloader.h, com.sigmob.sdk.downloader.core.listener.c
            protected void a(com.sigmob.sdk.downloader.f fVar2, final Exception exc) {
                this.d = l.a.UNKNOWN;
                super.a(fVar2, exc);
                if (fVar2.C()) {
                    return;
                }
                aj.a(com.sigmob.sdk.b.e(), "下载失败，" + exc.getMessage(), 1).show();
                ae.a(PointCategory.APKDOWNLOAD, PointCategory.END, (BaseAdUnit) null, new ae.a() { // from class: com.sigmob.sdk.base.common.n.5.3
                    @Override // com.sigmob.sdk.base.common.ae.a
                    public void a(Object obj) {
                        if (obj instanceof PointEntitySigmob) {
                            PointEntitySigmob pointEntitySigmob = (PointEntitySigmob) obj;
                            pointEntitySigmob.getOptions().put("status", String.valueOf(0));
                            pointEntitySigmob.getOptions().put("error", exc.getMessage());
                            pointEntitySigmob.getOptions().put("url", str2);
                        }
                    }
                });
            }

            @Override // com.sigmob.sdk.downloader.h, com.sigmob.sdk.downloader.core.listener.c
            protected void b(com.sigmob.sdk.downloader.f fVar2) {
                this.d = l.a.RUNNING;
                super.b(fVar2);
                ae.a(PointCategory.APKDOWNLOAD, "start", (BaseAdUnit) null, new ae.a() { // from class: com.sigmob.sdk.base.common.n.5.4
                    @Override // com.sigmob.sdk.base.common.ae.a
                    public void a(Object obj) {
                        if (obj instanceof PointEntitySigmob) {
                            PointEntitySigmob pointEntitySigmob = (PointEntitySigmob) obj;
                            pointEntitySigmob.getOptions().put("status", String.valueOf(1));
                            pointEntitySigmob.getOptions().put("url", str2);
                        }
                    }
                });
            }

            @Override // com.sigmob.sdk.downloader.h, com.sigmob.sdk.downloader.core.listener.c
            protected void c(com.sigmob.sdk.downloader.f fVar2) {
                l.a aVar = this.d;
                l.a aVar2 = l.a.CANCELED;
                if (aVar == aVar2) {
                    return;
                }
                this.d = aVar2;
                super.c(fVar2);
                ae.a(PointCategory.APKDOWNLOAD, "pause", (BaseAdUnit) null, new ae.a() { // from class: com.sigmob.sdk.base.common.n.5.5
                    @Override // com.sigmob.sdk.base.common.ae.a
                    public void a(Object obj) {
                        if (obj instanceof PointEntitySigmob) {
                            PointEntitySigmob pointEntitySigmob = (PointEntitySigmob) obj;
                            pointEntitySigmob.getOptions().put("status", String.valueOf(1));
                            pointEntitySigmob.getOptions().put("url", str2);
                        }
                    }
                });
            }
        };
        String str5 = "downloadButtonAction_" + str + "_" + a2.c();
        Intent intent = new Intent(str5);
        intent.setPackage(com.sigmob.sdk.b.e().getPackageName());
        a aVar = new a(a2, str5, null);
        IntentFilter intentFilter = new IntentFilter("downloadAction_" + str + "_" + a2.c());
        intentFilter.addAction(str5);
        u.a(com.sigmob.sdk.b.e(), aVar, intentFilter);
        Intent intent2 = new Intent("downloadAction_" + str + "_" + a2.c());
        intent2.setPackage(com.sigmob.sdk.b.e().getPackageName());
        hVar.a(str3, str4, str);
        if (Build.VERSION.SDK_INT >= 31) {
            e = com.sigmob.sdk.b.e();
            i = 201326592;
        } else {
            e = com.sigmob.sdk.b.e();
            i = 134217728;
        }
        hVar.a(PendingIntent.getBroadcast(e, 0, intent, i));
        hVar.b(PendingIntent.getBroadcast(com.sigmob.sdk.b.e(), 0, intent2, i));
        a2.a((com.sigmob.sdk.downloader.c) hVar);
        a2.B();
        aj.a(com.sigmob.sdk.b.e(), "已开始下载", 1).show();
        a.put(str, a2);
    }

    public static int b(Context context, BaseAdUnit baseAdUnit) {
        com.sigmob.sdk.downloader.f downloadTask = baseAdUnit.getDownloadTask();
        if (downloadTask == null || com.sigmob.sdk.downloader.l.a(downloadTask)) {
            return -1;
        }
        downloadTask.B();
        return 0;
    }

    public static int c(Context context, BaseAdUnit baseAdUnit) {
        com.sigmob.sdk.downloader.f downloadTask = baseAdUnit.getDownloadTask();
        if (downloadTask == null) {
            return -1;
        }
        downloadTask.a((com.sigmob.sdk.downloader.c) null);
        downloadTask.E();
        com.sigmob.sdk.downloader.g.j().c().b(downloadTask.c());
        File m = downloadTask.m();
        if (m != null && m.exists()) {
            m.delete();
        }
        NotificationManager notificationManager = (NotificationManager) context.getSystemService("notification");
        if (notificationManager != null) {
            notificationManager.cancel(downloadTask.c());
        }
        File n = downloadTask.n();
        if (n != null && n.exists()) {
            n.delete();
        }
        HashMap hashMap = new HashMap();
        hashMap.put("result", "0");
        hashMap.put("downloadId", baseAdUnit.getDownloadId());
        BaseBroadcastReceiver.a(context, baseAdUnit.getUuid(), hashMap, IntentActions.ACTION_INTERSTITIAL_DOWNLOAD_END);
        baseAdUnit.setDownloadId(null);
        baseAdUnit.setDownloadTask(null);
        if (baseAdUnit.isRecord()) {
            ae.b(PointCategory.DOWNLOAD_END, "0", baseAdUnit);
        }
        ae.a(PointCategory.APKDOWNLOAD, PointCategory.END, baseAdUnit, new ae.a() { // from class: com.sigmob.sdk.base.common.n.3
            @Override // com.sigmob.sdk.base.common.ae.a
            public void a(Object obj) {
                if (obj instanceof PointEntitySigmob) {
                    PointEntitySigmob pointEntitySigmob = (PointEntitySigmob) obj;
                    pointEntitySigmob.getOptions().put("status", String.valueOf(0));
                    pointEntitySigmob.getOptions().put("error", "cancel download");
                }
            }
        });
        return 0;
    }

    public static long[] d(Context context, BaseAdUnit baseAdUnit) {
        l.a a2;
        long[] jArr = {-1, -1, 0};
        com.sigmob.sdk.downloader.f downloadTask = baseAdUnit.getDownloadTask();
        if (downloadTask == null) {
            return jArr;
        }
        com.sigmob.sdk.downloader.core.breakpoint.c y = downloadTask.y();
        if (y != null) {
            jArr[0] = y.i();
            jArr[1] = y.j();
            a2 = com.sigmob.sdk.downloader.l.b(downloadTask);
        } else {
            a2 = com.sigmob.sdk.downloader.l.a(baseAdUnit.getDownloadUrl(), com.sigmob.sdk.base.utils.e.a(context).getAbsolutePath(), baseAdUnit.getApkName());
        }
        int i = AnonymousClass2.a[a2.ordinal()];
        if (i == 1) {
            jArr[2] = 2;
        } else if (i == 2) {
            jArr[2] = 8;
        } else if (i == 3) {
            jArr[2] = 1;
        } else if (i != 4) {
            jArr[2] = 16;
        } else {
            jArr[2] = 4;
        }
        return jArr;
    }
}
