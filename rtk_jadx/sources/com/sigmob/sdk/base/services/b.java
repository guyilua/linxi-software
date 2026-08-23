package com.sigmob.sdk.base.services;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.IntentFilter;
import android.content.pm.PackageInfo;
import android.os.Build;
import com.czhj.sdk.common.Constants;
import com.czhj.sdk.common.ThreadPool.ThreadPoolFactory;
import com.czhj.sdk.common.utils.AppPackageUtil;
import com.czhj.sdk.logger.SigmobLog;
import com.sigmob.sdk.base.common.ae;
import com.sigmob.sdk.base.common.u;
import com.sigmob.sdk.base.services.j;
import java.util.Date;
import java.util.List;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class b implements j.a {
    a a;
    k b = k.STOP;

    public b() {
        if (this.a == null) {
            this.a = new a();
        }
    }

    @SuppressLint({"SimpleDateFormat"})
    public static boolean a() {
        return com.sigmob.sdk.base.utils.g.a("BuriedPointConfig").getString(com.sigmob.sdk.base.k.f407c, "").equals(Constants.sdf.format(new Date()));
    }

    public static void b() {
        try {
            j();
        } catch (Throwable unused) {
        }
    }

    public static void c() {
        com.sigmob.sdk.base.utils.g.a("BuriedPointConfig").edit().putString(com.sigmob.sdk.base.k.f407c, Constants.sdf.format(new Date())).apply();
    }

    public static void d() {
        final Context e = com.sigmob.sdk.b.e();
        if (e == null || !com.sigmob.sdk.base.f.a().i() || a()) {
            return;
        }
        ThreadPoolFactory.BackgroundThreadPool.getInstance().submit(new Runnable() { // from class: com.sigmob.sdk.base.services.b.2
            @Override // java.lang.Runnable
            public void run() {
                List<String> O = com.sigmob.sdk.base.l.a().O();
                if (O.isEmpty()) {
                    return;
                }
                for (String str : O) {
                    ae.a(str, u.a(e, str));
                }
                b.c();
            }
        });
    }

    @SuppressLint({"SimpleDateFormat"})
    private static boolean d(Context context) {
        return com.sigmob.sdk.base.utils.g.a("BuriedPointConfig").getString(com.sigmob.sdk.base.k.b, "").equals(Constants.sdf.format(new Date()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static List<PackageInfo> e(Context context) {
        try {
            return AppPackageUtil.getPackageManager(context).getInstalledPackages(0);
        } catch (Throwable unused) {
            return null;
        }
    }

    private static void i() {
        final Context e = com.sigmob.sdk.b.e();
        if (d(e)) {
            return;
        }
        ThreadPoolFactory.BackgroundThreadPool.getInstance().submit(new Runnable() { // from class: com.sigmob.sdk.base.services.b.1
            @Override // java.lang.Runnable
            public void run() {
                try {
                    List e2 = b.e(e);
                    if (e2 == null) {
                        return;
                    }
                    for (int i = 0; i < e2.size(); i++) {
                        PackageInfo packageInfo = (PackageInfo) e2.get(i);
                        if ((packageInfo.applicationInfo.flags & 1) == 0) {
                            ae.a(packageInfo, 0);
                        }
                    }
                    com.sigmob.sdk.base.utils.g.a("BuriedPointConfig").edit().putString(com.sigmob.sdk.base.k.b, Constants.sdf.format(new Date())).apply();
                } catch (Throwable th) {
                    SigmobLog.e("update app info", th);
                }
            }
        });
    }

    /* JADX WARN: Code restructure failed: missing block: B:14:0x0039, code lost:
    
        if (com.sigmob.sdk.base.l.a().M() == false) goto L16;
     */
    /* JADX WARN: Removed duplicated region for block: B:17:0x003e A[Catch: all -> 0x0042, TRY_LEAVE, TryCatch #0 {all -> 0x0042, blocks: (B:2:0x0000, B:4:0x000a, B:9:0x0023, B:11:0x0029, B:13:0x0031, B:17:0x003e), top: B:1:0x0000 }] */
    /* JADX WARN: Removed duplicated region for block: B:21:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static void j() {
        /*
            com.sigmob.sdk.base.f r0 = com.sigmob.sdk.base.f.a()     // Catch: java.lang.Throwable -> L42
            boolean r0 = r0.i()     // Catch: java.lang.Throwable -> L42
            if (r0 == 0) goto L48
            com.sigmob.windad.WindAds r0 = com.sigmob.windad.WindAds.sharedAds()     // Catch: java.lang.Throwable -> L42
            com.sigmob.windad.WindAdOptions r0 = r0.getOptions()     // Catch: java.lang.Throwable -> L42
            com.sigmob.sdk.base.l r1 = com.sigmob.sdk.base.l.a()     // Catch: java.lang.Throwable -> L42
            int r1 = r1.X()     // Catch: java.lang.Throwable -> L42
            r2 = 0
            r3 = 1
            if (r1 == r3) goto L3b
            r4 = 2
            if (r1 == r4) goto L3c
            if (r0 == 0) goto L2e
            com.sigmob.windad.WindCustomController r0 = r0.getCustomController()     // Catch: java.lang.Throwable -> L42
            if (r0 == 0) goto L2e
            boolean r0 = r0.isCanUseAppList()     // Catch: java.lang.Throwable -> L42
            goto L2f
        L2e:
            r0 = 1
        L2f:
            if (r0 == 0) goto L3c
            com.sigmob.sdk.base.l r0 = com.sigmob.sdk.base.l.a()     // Catch: java.lang.Throwable -> L42
            boolean r0 = r0.M()     // Catch: java.lang.Throwable -> L42
            if (r0 != 0) goto L3c
        L3b:
            r2 = 1
        L3c:
            if (r2 == 0) goto L48
            i()     // Catch: java.lang.Throwable -> L42
            goto L48
        L42:
            r0 = move-exception
            java.lang.String r1 = "BuriedPointManager getInstance"
            com.czhj.sdk.logger.SigmobLog.e(r1, r0)
        L48:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sigmob.sdk.base.services.b.j():void");
    }

    public void a(Context context) {
        if (com.sigmob.sdk.base.l.a().W()) {
            return;
        }
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(com.sigmob.sdk.base.utils.a.a(com.sigmob.sdk.base.k.J));
        if (Build.VERSION.SDK_INT >= 27) {
            intentFilter.addAction(com.sigmob.sdk.base.utils.a.a(com.sigmob.sdk.base.k.K));
        }
        intentFilter.addAction(com.sigmob.sdk.base.utils.a.a(com.sigmob.sdk.base.k.H));
        intentFilter.addAction(com.sigmob.sdk.base.utils.a.a(com.sigmob.sdk.base.k.G));
        intentFilter.addAction(com.sigmob.sdk.base.utils.a.a(com.sigmob.sdk.base.k.I));
        intentFilter.addDataScheme("package");
        u.a(context, this.a, intentFilter);
    }

    public void b(Context context) {
        context.unregisterReceiver(this.a);
    }

    @Override // com.sigmob.sdk.base.services.j.a
    public boolean e() {
        k kVar = this.b;
        k kVar2 = k.RUNNING;
        if (kVar == kVar2) {
            return false;
        }
        a(com.sigmob.sdk.b.e());
        this.b = kVar2;
        return true;
    }

    @Override // com.sigmob.sdk.base.services.j.a
    public k f() {
        return this.b;
    }

    @Override // com.sigmob.sdk.base.services.j.a
    public void g() {
        if (this.b == k.RUNNING) {
            b(com.sigmob.sdk.b.e());
            this.b = k.STOP;
        }
    }

    @Override // com.sigmob.sdk.base.services.j.a
    public Error h() {
        return null;
    }
}
