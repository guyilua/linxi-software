package com.ss.android.socialbase.appdownloader.f.a;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import androidx.annotation.NonNull;
import java.io.File;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class e {
    /* JADX WARN: Code restructure failed: missing block: B:147:0x0068, code lost:
    
        r13 = r1.getInputStream(r2);
     */
    /* JADX WARN: Code restructure failed: missing block: B:148:0x006c, code lost:
    
        r4 = r1;
        r5 = r2;
        r1 = null;
        r13 = r13;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v0 */
    /* JADX WARN: Type inference failed for: r2v1, types: [java.io.FileInputStream] */
    /* JADX WARN: Type inference failed for: r2v10, types: [java.io.FileInputStream] */
    /* JADX WARN: Type inference failed for: r2v11 */
    /* JADX WARN: Type inference failed for: r2v13 */
    /* JADX WARN: Type inference failed for: r2v14 */
    /* JADX WARN: Type inference failed for: r2v3 */
    /* JADX WARN: Type inference failed for: r2v6 */
    /* JADX WARN: Type inference failed for: r2v9 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static android.content.pm.PackageInfo a(@androidx.annotation.NonNull java.io.File r13) {
        /*
            Method dump skipped, instructions count: 374
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ss.android.socialbase.appdownloader.f.a.e.a(java.io.File):android.content.pm.PackageInfo");
    }

    private static String a(int i) {
        return (i >>> 24) == 1 ? "android:" : "";
    }

    private static PackageInfo b(@NonNull Context context, @NonNull File file, int i) {
        PackageManager packageManager = context.getPackageManager();
        if (packageManager == null) {
            a("unzip_getpackagearchiveinfo", "packageManager == null");
            return null;
        }
        try {
            return packageManager.getPackageArchiveInfo(file.getPath(), i);
        } catch (Throwable th) {
            a("unzip_getpackagearchiveinfo", "pm.getPackageArchiveInfo failed: " + th.getMessage());
            return null;
        }
    }

    public static PackageInfo a(@NonNull Context context, @NonNull File file, int i) {
        int i2;
        if (com.ss.android.socialbase.downloader.i.a.a(268435456) && (i2 = Build.VERSION.SDK_INT) >= 21 && i2 < 26) {
            try {
                return a(file);
            } catch (Throwable th) {
                a("getPackageInfo::unzip_getpackagearchiveinfo", th.getMessage());
            }
        }
        return b(context, file, i);
    }

    private static void a(@NonNull String str, @NonNull String str2) {
        if (com.ss.android.socialbase.downloader.downloader.c.g() == null) {
            return;
        }
        try {
            new JSONObject().put("message", str2);
        } catch (JSONException unused) {
        }
    }

    private static String a(a aVar, int i) {
        int b = aVar.b(i);
        int c2 = aVar.c(i);
        if (b == 3) {
            return aVar.d(i);
        }
        return b == 2 ? String.format("?%s%08X", a(c2), Integer.valueOf(c2)) : (b < 16 || b > 31) ? String.format("<0x%X, type 0x%02X>", Integer.valueOf(c2), Integer.valueOf(b)) : String.valueOf(c2);
    }

    public static String a(Context context, PackageInfo packageInfo, String str) {
        ApplicationInfo applicationInfo;
        if (packageInfo == null || (applicationInfo = packageInfo.applicationInfo) == null) {
            return null;
        }
        applicationInfo.sourceDir = str;
        applicationInfo.publicSourceDir = str;
        try {
            return applicationInfo.loadLabel(context.getPackageManager()).toString();
        } catch (OutOfMemoryError e) {
            a("getPackageInfo::fail_load_label", e.getMessage());
            return null;
        }
    }
}
