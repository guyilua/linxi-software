package com.ss.android.socialbase.appdownloader;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import com.sigmob.sdk.downloader.f;
import com.ss.android.download.api.constant.BaseConstants;
import com.ss.android.downloadad.api.constant.AdBaseConstants;
import com.ss.android.socialbase.appdownloader.c.j;
import com.ss.android.socialbase.downloader.constants.DownloadStatus;
import com.ss.android.socialbase.downloader.depend.z;
import com.ss.android.socialbase.downloader.downloader.Downloader;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import com.tencent.mm.opensdk.constants.ConstantsAPI;
import java.io.File;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class c {
    private static int a;
    private static NotificationChannel b;

    /* JADX INFO: Access modifiers changed from: private */
    public static int d(Context context, int i, boolean z) {
        if (com.ss.android.socialbase.downloader.g.a.a(i).b("notification_opt_2") == 1) {
            com.ss.android.socialbase.downloader.notification.b.a().f(i);
        }
        a((Activity) h.a().b());
        if (com.ss.android.socialbase.downloader.g.a.a(i).a("install_queue_enable", 0) == 1) {
            return h.a().a(context, i, z);
        }
        return b(context, i, z);
    }

    private static String a(long j, long j2, String str, boolean z) {
        double d = j;
        if (j2 > 1) {
            d /= j2;
        }
        if (!z && !"GB".equals(str) && !"TB".equals(str)) {
            return new DecimalFormat("#").format(d) + " " + str;
        }
        return new DecimalFormat("#.##").format(d) + " " + str;
    }

    public static String b(long j) {
        long[] jArr = {1099511627776L, 1073741824, BaseConstants.MB_VALUE, ConstantsAPI.AppSupportContentFlag.MMAPP_SUPPORT_XLS, 1};
        String[] strArr = {"TB", "GB", "MB", "KB", "B"};
        if (j < 1) {
            return "0 " + strArr[4];
        }
        for (int i = 0; i < 5; i++) {
            long j2 = jArr[i];
            if (j >= j2) {
                return a(j, j2, strArr[i]);
            }
        }
        return null;
    }

    public static boolean c(Context context, DownloadInfo downloadInfo) {
        if (context == null || downloadInfo == null || TextUtils.isEmpty(downloadInfo.getSavePath()) || TextUtils.isEmpty(downloadInfo.getName())) {
            return false;
        }
        return b(context, downloadInfo, a(context, downloadInfo, downloadInfo.getSavePath(), downloadInfo.getName()));
    }

    public static String a(long j) {
        return a(j, true);
    }

    public static boolean c(String str) {
        return !TextUtils.isEmpty(str) && str.equals(AdBaseConstants.MIME_APK);
    }

    public static String a(long j, boolean z) {
        long[] jArr = {1099511627776L, 1073741824, BaseConstants.MB_VALUE, ConstantsAPI.AppSupportContentFlag.MMAPP_SUPPORT_XLS, 1};
        String[] strArr = {"TB", "GB", "MB", "KB", "B"};
        if (j < 1) {
            return "0 " + strArr[4];
        }
        for (int i = 0; i < 5; i++) {
            long j2 = jArr[i];
            if (j >= j2) {
                return a(j, j2, strArr[i], z);
            }
        }
        return null;
    }

    public static List<String> c() {
        ArrayList arrayList = new ArrayList(2);
        arrayList.add(AdBaseConstants.MIME_APK);
        arrayList.add("application/ttpatch");
        return arrayList;
    }

    public static int b(final Context context, final int i, final boolean z) {
        final DownloadInfo downloadInfo = Downloader.getInstance(context).getDownloadInfo(i);
        if (downloadInfo != null && AdBaseConstants.MIME_APK.equals(downloadInfo.getMimeType()) && !TextUtils.isEmpty(downloadInfo.getSavePath()) && !TextUtils.isEmpty(downloadInfo.getName())) {
            final File file = new File(downloadInfo.getSavePath(), downloadInfo.getName());
            if (file.exists()) {
                com.ss.android.socialbase.downloader.downloader.c.b(new Runnable() { // from class: com.ss.android.socialbase.appdownloader.c.2
                    @Override // java.lang.Runnable
                    public void run() {
                        d.j().k();
                        int a2 = c.a(context, i, z, downloadInfo, file);
                        if (a2 == 1 && d.j().q() != null) {
                            d.j().q().a(downloadInfo, null);
                        }
                        c.b(downloadInfo, z, a2);
                    }
                });
                return 1;
            }
        }
        b(downloadInfo, z, 2);
        return 2;
    }

    private static JSONObject d(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            return new JSONObject(str);
        } catch (Throwable unused) {
            return null;
        }
    }

    private static String a(long j, long j2, String str) {
        double d = j;
        if (j2 > 1) {
            d /= j2;
        }
        if ("MB".equals(str)) {
            return new DecimalFormat("#").format(d) + str;
        }
        return new DecimalFormat("#.##").format(d) + str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void b(DownloadInfo downloadInfo, boolean z, int i) {
        if (downloadInfo == null) {
            return;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("by_user", z ? 1 : 2);
            jSONObject.put("view_result", i);
            jSONObject.put("real_package_name", downloadInfo.getFilePackageName());
        } catch (Exception e) {
            e.printStackTrace();
        }
        com.ss.android.socialbase.downloader.downloader.c.Q().a(downloadInfo.getId(), "install_view_result", jSONObject);
    }

    public static int a(final Context context, final int i, final boolean z) {
        j g = d.j().g();
        if (g == null) {
            return d(context, i, z);
        }
        DownloadInfo downloadInfo = Downloader.getInstance(context).getDownloadInfo(i);
        a = 1;
        g.a(downloadInfo, new com.ss.android.socialbase.appdownloader.c.i() { // from class: com.ss.android.socialbase.appdownloader.c.1
            @Override // com.ss.android.socialbase.appdownloader.c.i
            public void a() {
                int unused = c.a = c.d(context, i, z);
            }
        });
        return a;
    }

    public static boolean b(Context context, DownloadInfo downloadInfo, PackageInfo packageInfo) {
        return a(context, downloadInfo, packageInfo, false);
    }

    /* JADX WARN: Code restructure failed: missing block: B:13:0x003a, code lost:
    
        if (r0 == null) goto L75;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static int a(android.content.Context r5, int r6, boolean r7, com.ss.android.socialbase.downloader.model.DownloadInfo r8, java.io.File r9) {
        /*
            Method dump skipped, instructions count: 290
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ss.android.socialbase.appdownloader.c.a(android.content.Context, int, boolean, com.ss.android.socialbase.downloader.model.DownloadInfo, java.io.File):int");
    }

    public static int b(Context context, DownloadInfo downloadInfo) {
        if (context != null && downloadInfo != null && !TextUtils.isEmpty(downloadInfo.getSavePath()) && !TextUtils.isEmpty(downloadInfo.getName())) {
            int appVersionCode = downloadInfo.getAppVersionCode();
            if (appVersionCode > 0) {
                return appVersionCode;
            }
            try {
                PackageInfo a2 = a(context, downloadInfo, downloadInfo.getSavePath(), downloadInfo.getName());
                if (a2 != null) {
                    int i = a2.versionCode;
                    downloadInfo.setAppVersionCode(i);
                    return i;
                }
            } catch (Throwable unused) {
            }
        }
        return 0;
    }

    public static String b() {
        return com.ss.android.socialbase.downloader.i.f.e();
    }

    public static boolean b(String str) {
        JSONObject jSONObject;
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        try {
            jSONObject = new JSONObject(str);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        if (!jSONObject.optBoolean("bind_app", false)) {
            if (jSONObject.optBoolean("auto_install_with_notification", true)) {
                return false;
            }
        }
        return true;
    }

    @TargetApi(26)
    public static String b(@NonNull Context context) {
        try {
            if (b == null) {
                NotificationChannel notificationChannel = new NotificationChannel("111111", "channel_appdownloader", 3);
                b = notificationChannel;
                notificationChannel.setSound(null, null);
                b.setShowBadge(false);
                ((NotificationManager) context.getSystemService("notification")).createNotificationChannel(b);
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
        return "111111";
    }

    public static int a(Context context, Intent intent) {
        try {
            if (d.j().p() != null) {
                if (d.j().p().a(intent)) {
                    return 1;
                }
            }
        } catch (Throwable unused) {
        }
        try {
            context.startActivity(intent);
            return 1;
        } catch (Throwable unused2) {
            return 0;
        }
    }

    public static boolean a(Context context, DownloadInfo downloadInfo, PackageInfo packageInfo) {
        if (packageInfo == null || packageInfo.packageName.equals(downloadInfo.getPackageName())) {
            return false;
        }
        com.ss.android.socialbase.appdownloader.c.d b2 = d.j().b();
        if (b2 != null) {
            b2.a(downloadInfo.getId(), 8, downloadInfo.getPackageName(), packageInfo.packageName, "");
            if (b2.a()) {
                return true;
            }
        }
        z downloadNotificationEventListener = Downloader.getInstance(context).getDownloadNotificationEventListener(downloadInfo.getId());
        if (downloadNotificationEventListener == null) {
            return false;
        }
        downloadNotificationEventListener.a(8, downloadInfo, packageInfo.packageName, "");
        com.ss.android.socialbase.appdownloader.c.c a2 = d.j().a();
        return (a2 instanceof com.ss.android.socialbase.appdownloader.c.a) && ((com.ss.android.socialbase.appdownloader.c.a) a2).b();
    }

    public static boolean a(Context context, int i, File file) {
        if (com.ss.android.socialbase.downloader.g.a.a(i).a("back_miui_silent_install", 1) == 1) {
            return false;
        }
        if ((com.ss.android.socialbase.appdownloader.f.e.m() || com.ss.android.socialbase.appdownloader.f.e.n()) && com.ss.android.socialbase.downloader.i.j.a(context, "com.miui.securitycore", "com.miui.enterprise.service.EntInstallService")) {
            Intent intent = new Intent();
            intent.setComponent(new ComponentName("com.miui.securitycore", "com.miui.enterprise.service.EntInstallService"));
            Bundle bundle = new Bundle();
            bundle.putInt("userId", 0);
            bundle.putInt("flag", 256);
            bundle.putString("apkPath", file.getPath());
            bundle.putString("installerPkg", "com.miui.securitycore");
            intent.putExtras(bundle);
            try {
                context.startService(intent);
                return true;
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return false;
    }

    public static int a() {
        if (d.j().f()) {
            return f.a.d;
        }
        return 0;
    }

    /* JADX WARN: Removed duplicated region for block: B:8:0x0021 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static android.net.Uri a(int r1, com.ss.android.socialbase.downloader.depend.IDownloadFileUriProvider r2, android.content.Context r3, java.lang.String r4, java.io.File r5) {
        /*
            if (r2 == 0) goto Lb
            java.lang.String r1 = r5.getAbsolutePath()     // Catch: java.lang.Throwable -> L1e
            android.net.Uri r1 = r2.getUriForFile(r4, r1)     // Catch: java.lang.Throwable -> L1e
            goto L1f
        Lb:
            com.ss.android.socialbase.appdownloader.d r2 = com.ss.android.socialbase.appdownloader.d.j()
            com.ss.android.socialbase.appdownloader.c.f r2 = r2.e()
            if (r2 == 0) goto L1e
            java.lang.String r0 = r5.getAbsolutePath()     // Catch: java.lang.Throwable -> L1e
            android.net.Uri r1 = r2.a(r1, r4, r0)     // Catch: java.lang.Throwable -> L1e
            goto L1f
        L1e:
            r1 = 0
        L1f:
            if (r1 != 0) goto L3b
            int r2 = android.os.Build.VERSION.SDK_INT     // Catch: java.lang.Throwable -> L37
            r0 = 24
            if (r2 < r0) goto L32
            boolean r2 = android.text.TextUtils.isEmpty(r4)     // Catch: java.lang.Throwable -> L37
            if (r2 != 0) goto L32
            android.net.Uri r1 = androidx.core.content.FileProvider.getUriForFile(r3, r4, r5)     // Catch: java.lang.Throwable -> L37
            goto L3b
        L32:
            android.net.Uri r1 = android.net.Uri.fromFile(r5)     // Catch: java.lang.Throwable -> L37
            goto L3b
        L37:
            r2 = move-exception
            r2.printStackTrace()
        L3b:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ss.android.socialbase.appdownloader.c.a(int, com.ss.android.socialbase.downloader.depend.IDownloadFileUriProvider, android.content.Context, java.lang.String, java.io.File):android.net.Uri");
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static Intent a(Context context, DownloadInfo downloadInfo, @NonNull File file, boolean z, int[] iArr) {
        Uri a2 = a(downloadInfo.getId(), Downloader.getInstance(context).getDownloadFileUriProvider(downloadInfo.getId()), context, d.j().d(), file);
        if (a2 == null) {
            return null;
        }
        Intent intent = new Intent("android.intent.action.VIEW");
        if (Build.VERSION.SDK_INT >= 24) {
            intent.addFlags(1);
        }
        intent.setDataAndType(a2, AdBaseConstants.MIME_APK);
        com.ss.android.socialbase.appdownloader.c.d b2 = d.j().b();
        int a3 = b2 != null ? b2.a(downloadInfo.getId(), z) : 0;
        z downloadNotificationEventListener = Downloader.getInstance(context).getDownloadNotificationEventListener(downloadInfo.getId());
        int i = a3;
        if (downloadNotificationEventListener != null) {
            i = downloadNotificationEventListener.a(z);
        }
        iArr[0] = i;
        if (i != 0) {
            return null;
        }
        return intent;
    }

    public static boolean a(DownloadInfo downloadInfo, String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        if (TextUtils.isEmpty(downloadInfo.getPackageName()) || !str.equals(downloadInfo.getPackageName())) {
            return !TextUtils.isEmpty(downloadInfo.getName()) && a(com.ss.android.socialbase.downloader.downloader.c.O(), downloadInfo, str);
        }
        return true;
    }

    public static boolean a(Context context, DownloadInfo downloadInfo, String str) {
        if (context == null) {
            return false;
        }
        try {
            File file = new File(downloadInfo.getSavePath(), downloadInfo.getName());
            PackageInfo packageInfo = null;
            if (file.exists()) {
                Log.e("AppDownloadUtils", "isPackageNameEqualsWithApk fileName:" + downloadInfo.getName() + " apkFileSize：" + file.length() + " fileUrl：" + downloadInfo.getUrl());
                PackageInfo a2 = a(downloadInfo, file);
                if (a2 == null || !a2.packageName.equals(str)) {
                    return false;
                }
                int i = a2.versionCode;
                try {
                    packageInfo = context.getPackageManager().getPackageInfo(str, a());
                } catch (PackageManager.NameNotFoundException unused) {
                }
                if (packageInfo == null || i != packageInfo.versionCode) {
                    return false;
                }
            } else {
                if (!com.ss.android.socialbase.downloader.g.a.a(downloadInfo.getId()).a("install_callback_error")) {
                    return false;
                }
                String a3 = com.ss.android.socialbase.downloader.i.f.a(downloadInfo.getTempCacheData().get("extra_apk_package_name"), (String) null);
                int a4 = com.ss.android.socialbase.downloader.i.f.a(downloadInfo.getTempCacheData().get("extra_apk_version_code"), 0);
                if (a3 == null || TextUtils.isEmpty(a3) || !a3.equals(str)) {
                    return false;
                }
                try {
                    packageInfo = context.getPackageManager().getPackageInfo(str, a());
                } catch (PackageManager.NameNotFoundException unused2) {
                }
                if (packageInfo == null || a4 != packageInfo.versionCode) {
                    return false;
                }
            }
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public static boolean a(Context context, DownloadInfo downloadInfo, PackageInfo packageInfo, boolean z) {
        PackageInfo packageInfo2;
        if (packageInfo == null) {
            return false;
        }
        String str = packageInfo.packageName;
        int i = packageInfo.versionCode;
        if (downloadInfo != null) {
            downloadInfo.setAppVersionCode(i);
        }
        try {
            packageInfo2 = context.getPackageManager().getPackageInfo(str, a());
        } catch (PackageManager.NameNotFoundException unused) {
            packageInfo2 = null;
        }
        if (packageInfo2 == null) {
            return false;
        }
        int i2 = packageInfo2.versionCode;
        return z ? i < i2 : (downloadInfo == null || com.ss.android.socialbase.downloader.g.a.a(downloadInfo.getId()).a("install_with_same_version_code", 0) != 1) ? i <= i2 : i < i2;
    }

    public static boolean a(Context context, DownloadInfo downloadInfo) {
        return a(context, downloadInfo, true);
    }

    public static boolean a(Context context, DownloadInfo downloadInfo, boolean z) {
        if (downloadInfo == null) {
            return false;
        }
        String packageName = downloadInfo.getPackageName();
        int appVersionCode = downloadInfo.getAppVersionCode();
        if (appVersionCode <= 0 && z) {
            return c(context, downloadInfo);
        }
        PackageInfo packageInfo = null;
        try {
            packageInfo = context.getPackageManager().getPackageInfo(packageName, a());
        } catch (PackageManager.NameNotFoundException unused) {
        }
        if (packageInfo == null) {
            return false;
        }
        return com.ss.android.socialbase.downloader.g.a.a(downloadInfo.getId()).a("install_with_same_version_code", 0) == 1 ? appVersionCode < packageInfo.versionCode : appVersionCode <= packageInfo.versionCode;
    }

    public static PackageInfo a(Context context, DownloadInfo downloadInfo, String str, String str2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return null;
        }
        File file = new File(str, str2);
        if (!file.exists()) {
            return null;
        }
        Log.e("AppDownloadUtils", "isApkInstalled apkFileSize：fileName:" + file.getPath() + " apkFileSize" + file.length());
        return a(downloadInfo, file);
    }

    /* JADX WARN: Code restructure failed: missing block: B:31:0x0056, code lost:
    
        if (android.text.TextUtils.isEmpty(r4) == false) goto L26;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static java.lang.String a(java.lang.String r3, java.lang.String r4, java.lang.String r5, boolean r6) {
        /*
            boolean r0 = android.text.TextUtils.isEmpty(r3)
            java.lang.String r1 = ""
            if (r0 == 0) goto L9
            return r1
        L9:
            android.net.Uri r3 = android.net.Uri.parse(r3)
            java.lang.String r0 = "default.apk"
            java.lang.String r2 = ".."
            if (r6 == 0) goto L34
            boolean r6 = android.text.TextUtils.isEmpty(r4)
            if (r6 == 0) goto L5a
            java.lang.String r4 = r3.getLastPathSegment()
            boolean r4 = android.text.TextUtils.isEmpty(r4)
            if (r4 != 0) goto L32
            java.lang.String r4 = r3.getLastPathSegment()
            boolean r4 = r4.contains(r2)
            if (r4 != 0) goto L32
            java.lang.String r4 = r3.getLastPathSegment()
            goto L5a
        L32:
            r4 = r0
            goto L5a
        L34:
            java.lang.String r6 = r3.getLastPathSegment()
            boolean r6 = android.text.TextUtils.isEmpty(r6)
            if (r6 != 0) goto L4c
            java.lang.String r6 = r3.getLastPathSegment()
            boolean r6 = r6.contains(r2)
            if (r6 != 0) goto L4c
            java.lang.String r1 = r3.getLastPathSegment()
        L4c:
            boolean r3 = android.text.TextUtils.isEmpty(r1)
            if (r3 == 0) goto L59
            boolean r3 = android.text.TextUtils.isEmpty(r4)
            if (r3 != 0) goto L32
            goto L5a
        L59:
            r4 = r1
        L5a:
            boolean r3 = c(r5)
            if (r3 == 0) goto L77
            java.lang.String r3 = ".apk"
            boolean r5 = r4.endsWith(r3)
            if (r5 != 0) goto L77
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>()
            r5.append(r4)
            r5.append(r3)
            java.lang.String r4 = r5.toString()
        L77:
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ss.android.socialbase.appdownloader.c.a(java.lang.String, java.lang.String, java.lang.String, boolean):java.lang.String");
    }

    public static String a(String str, com.ss.android.socialbase.downloader.g.a aVar) {
        JSONObject d;
        String format;
        if (aVar == null || (d = aVar.d("download_dir")) == null) {
            return "";
        }
        String optString = d.optString("dir_name");
        if (!TextUtils.isEmpty(optString) && optString.startsWith("/")) {
            optString = optString.substring(1);
        }
        if (TextUtils.isEmpty(optString)) {
            return optString;
        }
        if (!optString.contains("%s")) {
            format = optString + str;
        } else {
            try {
                format = String.format(optString, str);
            } catch (Throwable unused) {
            }
        }
        optString = format;
        return optString.length() > 255 ? optString.substring(optString.length() - 255) : optString;
    }

    public static boolean a(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        try {
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return new JSONObject(str).optBoolean("bind_app", false);
    }

    public static int a(int i) {
        if (i == 0) {
            return 0;
        }
        if (i == -2) {
            return 2;
        }
        if (i == 1) {
            return 4;
        }
        if (DownloadStatus.isDownloading(i) || i == 11) {
            return 1;
        }
        return DownloadStatus.isDownloadOver(i) ? 3 : 0;
    }

    /* JADX WARN: Code restructure failed: missing block: B:15:0x003b, code lost:
    
        if (r0 != null) goto L22;
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x003d, code lost:
    
        r0.recycle();
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x0041, code lost:
    
        if (r0 != null) goto L22;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static boolean a(android.content.Context r6) {
        /*
            int r0 = android.os.Build.VERSION.SDK_INT
            r1 = 0
            r2 = 20
            if (r0 <= r2) goto L44
            if (r6 != 0) goto La
            goto L44
        La:
            r0 = 0
            int r2 = com.ss.android.socialbase.appdownloader.e.b()     // Catch: java.lang.Throwable -> L41
            android.content.res.Resources r3 = r6.getResources()     // Catch: java.lang.Throwable -> L41
            int r2 = r3.getColor(r2)     // Catch: java.lang.Throwable -> L41
            int r3 = com.ss.android.socialbase.appdownloader.e.c()     // Catch: java.lang.Throwable -> L41
            int r4 = com.ss.android.socialbase.appdownloader.e.d()     // Catch: java.lang.Throwable -> L41
            r5 = 2
            int[] r5 = new int[r5]     // Catch: java.lang.Throwable -> L41
            r5[r1] = r3     // Catch: java.lang.Throwable -> L41
            r3 = 1
            r5[r3] = r4     // Catch: java.lang.Throwable -> L41
            int r4 = com.ss.android.socialbase.appdownloader.e.e()     // Catch: java.lang.Throwable -> L41
            android.content.res.TypedArray r0 = r6.obtainStyledAttributes(r4, r5)     // Catch: java.lang.Throwable -> L41
            int r6 = r0.getColor(r1, r1)     // Catch: java.lang.Throwable -> L41
            if (r2 != r6) goto L3b
            if (r0 == 0) goto L3a
            r0.recycle()     // Catch: java.lang.Throwable -> L3a
        L3a:
            return r3
        L3b:
            if (r0 == 0) goto L44
        L3d:
            r0.recycle()     // Catch: java.lang.Throwable -> L44
            goto L44
        L41:
            if (r0 == 0) goto L44
            goto L3d
        L44:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ss.android.socialbase.appdownloader.c.a(android.content.Context):boolean");
    }

    public static void a(DownloadInfo downloadInfo, boolean z, boolean z2) {
        d.j().a(new f(com.ss.android.socialbase.downloader.downloader.c.O(), downloadInfo.getUrl()).a(downloadInfo.getTitle()).b(downloadInfo.getName()).c(downloadInfo.getSavePath()).a(downloadInfo.isShowNotification()).b(downloadInfo.isAutoInstallWithoutNotification()).c(downloadInfo.isOnlyWifi() || z2).e(downloadInfo.getExtra()).f(downloadInfo.getMimeType()).a(downloadInfo.getExtraHeaders()).e(true).b(downloadInfo.getRetryCount()).c(downloadInfo.getBackUpUrlRetryCount()).b(downloadInfo.getBackUpUrls()).d(downloadInfo.getMinProgressTimeMsInterval()).e(downloadInfo.getMaxProgressCount()).f(z).d(downloadInfo.isNeedHttpsToHttpRetry()).g(downloadInfo.getPackageName()).h(downloadInfo.getMd5()).a(downloadInfo.getExpectFileLength()).i(downloadInfo.isNeedDefaultHttpServiceBackUp()).j(downloadInfo.isNeedReuseFirstConnection()).l(downloadInfo.isNeedIndependentProcess()).a(downloadInfo.getEnqueueType()).n(downloadInfo.isForce()).m(downloadInfo.isHeadConnectionAvailable()).g(downloadInfo.isNeedRetryDelay()).i(downloadInfo.getRetryDelayTimeArray()).a(d(downloadInfo.getDownloadSettingString())).k(downloadInfo.getIconUrl()).f(downloadInfo.getExecutorGroup()).p(downloadInfo.isAutoInstall()));
    }

    public static void a(Activity activity) {
        if (activity != null) {
            try {
                if (activity.isFinishing()) {
                    return;
                }
                activity.finish();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public static PackageInfo a(DownloadInfo downloadInfo, File file) {
        if (downloadInfo == null) {
            return com.ss.android.socialbase.appdownloader.f.a.e.a(com.ss.android.socialbase.downloader.downloader.c.O(), file, a());
        }
        PackageInfo packageInfo = downloadInfo.getPackageInfo();
        if (packageInfo != null) {
            return packageInfo;
        }
        PackageInfo a2 = com.ss.android.socialbase.appdownloader.f.a.e.a(com.ss.android.socialbase.downloader.downloader.c.O(), file, a());
        downloadInfo.setPackageInfo(a2);
        return a2;
    }

    public static int a(Context context, float f) {
        return (int) ((f * context.getResources().getDisplayMetrics().density) + 0.5f);
    }
}
