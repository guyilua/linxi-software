package com.sigmob.sdk.base.common;

import android.content.ComponentName;
import android.content.Context;
import android.content.pm.PackageManager;
import com.czhj.sdk.common.mta.PointEntitySuper;
import com.czhj.sdk.logger.SigmobLog;
import com.sigmob.sdk.base.models.AppInfo;
import com.sigmob.sdk.base.models.rtb.Ad;
import com.sigmob.sdk.base.models.rtb.MaterialMeta;
import com.sigmob.sdk.downloader.f;
import com.sigmob.windad.WindAdError;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class f {
    private static Boolean a;

    public static String[] a() {
        Context e = com.sigmob.sdk.b.e();
        if (e == null) {
            return null;
        }
        try {
            return e.getPackageManager().getPackageInfo(e.getPackageName(), f.a.f548c).requestedPermissions;
        } catch (Throwable unused) {
            return null;
        }
    }

    public static WindAdError b() {
        Context e = com.sigmob.sdk.b.e();
        try {
            SigmobLog.e("checkActivity: " + AdActivity.class.getName());
            e.getPackageManager().getActivityInfo(new ComponentName(e, (Class<?>) AdActivity.class), 128);
        } catch (PackageManager.NameNotFoundException e2) {
            SigmobLog.e("checkActivity: " + e2.getMessage());
            return WindAdError.ERROR_LOAD_FILTER_FOR_ACTIVITY_ERROR;
        } catch (Throwable th) {
            th.printStackTrace();
        }
        try {
            if (!Ad.class.getName().endsWith("base.models.rtb.Ad")) {
                SigmobLog.e("checkProguard Ad: " + Ad.class.getName());
                return WindAdError.ERROR_LOAD_FILTER_FOR_PROGUARD_ERROR;
            }
            if (!MaterialMeta.class.getName().endsWith("base.models.rtb.MaterialMeta")) {
                SigmobLog.e("checkProguard Strategy: " + MaterialMeta.class.getName());
                return WindAdError.ERROR_LOAD_FILTER_FOR_PROGUARD_ERROR;
            }
            if (!AppInfo.class.getName().endsWith("base.models.AppInfo")) {
                SigmobLog.e("checkProguard AppInfo: " + AppInfo.class.getName());
                return WindAdError.ERROR_LOAD_FILTER_FOR_PROGUARD_ERROR;
            }
            if (PointEntitySuper.class.getName().endsWith("common.mta.PointEntitySuper")) {
                return null;
            }
            SigmobLog.e("checkProguard PointCategory: " + PointEntitySuper.class.getName());
            return WindAdError.ERROR_LOAD_FILTER_FOR_PROGUARD_ERROR;
        } catch (Throwable th2) {
            SigmobLog.e("checkProguard: " + th2.getMessage());
            return null;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:39:0x0088, code lost:
    
        r3 = com.sigmob.sdk.b.e().getPackageManager().getProviderInfo(new android.content.ComponentName(com.sigmob.sdk.b.e(), r7.name), 128).metaData;
     */
    /* JADX WARN: Code restructure failed: missing block: B:40:0x00a3, code lost:
    
        if (r3 == null) goto L40;
     */
    /* JADX WARN: Code restructure failed: missing block: B:41:0x00a5, code lost:
    
        r3 = r3.getInt("android.support.FILE_PROVIDER_PATHS");
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static synchronized boolean c() {
        /*
            Method dump skipped, instructions count: 311
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sigmob.sdk.base.common.f.c():boolean");
    }

    public static boolean d() {
        String[] a2 = a();
        if (a2 != null) {
            for (String str : a2) {
                if (str.equals("android.permission.QUERY_ALL_PACKAGES")) {
                    return true;
                }
            }
        }
        return false;
    }
}
