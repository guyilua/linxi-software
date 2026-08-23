package com.ss.android.downloadlib.g;

import android.annotation.SuppressLint;
import android.app.ActivityManager;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.pm.Signature;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Environment;
import android.os.Looper;
import android.os.StatFs;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.WorkerThread;
import com.ss.android.download.api.config.o;
import com.ss.android.download.api.constant.BaseConstants;
import com.ss.android.download.api.download.DownloadModel;
import com.ss.android.socialbase.downloader.downloader.Downloader;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import java.io.File;
import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class m {
    private static Object[] b = new Object[0];

    /* renamed from: c, reason: collision with root package name */
    private static Object[] f781c = new Object[73];
    static final char[] a = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
    private static String d = null;

    public static boolean a(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return new File(str).exists();
    }

    public static boolean b(String str) {
        return !TextUtils.isEmpty(str) && new File(str).exists();
    }

    public static String c(Context context, String str) {
        if (context == null || TextUtils.isEmpty(str)) {
            return "";
        }
        try {
            PackageInfo packageInfo = context.getPackageManager().getPackageInfo(str, 0);
            return packageInfo != null ? packageInfo.versionName : "";
        } catch (PackageManager.NameNotFoundException unused) {
            return "";
        }
    }

    public static Drawable d(Context context, String str) {
        if (context != null && !TextUtils.isEmpty(str)) {
            try {
                PackageManager packageManager = context.getPackageManager();
                return packageManager.getApplicationInfo(str, 0).loadIcon(packageManager);
            } catch (PackageManager.NameNotFoundException unused) {
            }
        }
        return null;
    }

    public static boolean e(Context context, String str) {
        if (context == null) {
            context = com.ss.android.downloadlib.addownload.k.a();
        }
        if (context == null || TextUtils.isEmpty(str)) {
            return false;
        }
        try {
            return context.getPackageManager().getPackageInfo(str, 0) != null;
        } catch (Exception unused) {
            return false;
        }
    }

    public static boolean f(Context context, String str) {
        PackageInfo packageArchiveInfo;
        PackageInfo packageInfo;
        if (context == null || str == null || TextUtils.isEmpty(str)) {
            return false;
        }
        try {
            File file = new File(str);
            if (!file.exists() || (packageArchiveInfo = context.getPackageManager().getPackageArchiveInfo(file.getAbsolutePath(), 0)) == null) {
                return false;
            }
            String str2 = packageArchiveInfo.packageName;
            int i = packageArchiveInfo.versionCode;
            try {
                packageInfo = context.getPackageManager().getPackageInfo(str2, 0);
            } catch (PackageManager.NameNotFoundException unused) {
                packageInfo = null;
            }
            if (packageInfo == null) {
                return false;
            }
            return i <= packageInfo.versionCode;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public static Intent g(Context context, String str) {
        Intent launchIntentForPackage = context.getPackageManager().getLaunchIntentForPackage(str);
        if (launchIntentForPackage == null) {
            return null;
        }
        if (!launchIntentForPackage.hasCategory("android.intent.category.LAUNCHER")) {
            launchIntentForPackage.addCategory("android.intent.category.LAUNCHER");
        }
        launchIntentForPackage.setPackage(null);
        launchIntentForPackage.addFlags(2097152);
        launchIntentForPackage.addFlags(268435456);
        return launchIntentForPackage;
    }

    public static Signature[] h(Context context, String str) {
        try {
            PackageInfo packageInfo = context.getPackageManager().getPackageInfo(str, 64);
            if (packageInfo != null) {
                return packageInfo.signatures;
            }
            return null;
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
    }

    public static Signature[] i(Context context, String str) {
        try {
            PackageInfo packageArchiveInfo = context.getPackageManager().getPackageArchiveInfo(str, 64);
            if (packageArchiveInfo != null) {
                return packageArchiveInfo.signatures;
            }
            return null;
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
    }

    public static File j(Context context, String str) {
        File parentFile = context.getExternalFilesDir(null).getParentFile();
        File file = new File((parentFile != null ? parentFile.getParent() : null) + File.separator + str);
        StringBuilder sb = new StringBuilder("getExtDir: file.toString()-->");
        sb.append(file.toString());
        com.ss.android.socialbase.downloader.c.a.b("ToolUtils", sb.toString());
        return file;
    }

    public static long a(JSONObject jSONObject, String str) {
        return com.ss.android.download.api.c.b.a(jSONObject, str);
    }

    public static int b(Context context, String str) {
        if (context == null || TextUtils.isEmpty(str)) {
            return -1;
        }
        try {
            PackageInfo packageInfo = context.getPackageManager().getPackageInfo(str, 0);
            if (packageInfo != null) {
                return packageInfo.versionCode;
            }
            return -1;
        } catch (PackageManager.NameNotFoundException unused) {
            return -1;
        }
    }

    public static JSONObject a(JSONObject jSONObject, JSONObject jSONObject2) {
        return com.ss.android.download.api.c.b.a(jSONObject, jSONObject2);
    }

    @WorkerThread
    public static boolean c(String str) {
        File file;
        Context a2 = com.ss.android.downloadlib.addownload.k.a();
        if (TextUtils.isEmpty(str) || !e(a2, str)) {
            return false;
        }
        int i = a2.getApplicationInfo().targetSdkVersion;
        if (com.ss.android.downloadlib.addownload.k.j().optInt("get_ext_dir_mode") == 0 && Build.VERSION.SDK_INT >= 29 && ((i == 29 && !Environment.isExternalStorageLegacy()) || i > 29)) {
            return true;
        }
        try {
            if (Build.VERSION.SDK_INT >= 29 && a2.getApplicationInfo().targetSdkVersion >= 29 && com.ss.android.downloadlib.addownload.k.j().optInt("get_ext_dir_mode") == 1) {
                file = j(a2, str);
            } else {
                file = new File(Environment.getExternalStorageDirectory().getPath(), "android/data/".concat(String.valueOf(str)));
            }
            if (!file.exists()) {
                return false;
            }
            long a3 = g.a(file);
            PackageInfo packageInfo = a2.getPackageManager().getPackageInfo(str, 0);
            if (packageInfo != null) {
                if (packageInfo.lastUpdateTime < a3) {
                    return true;
                }
            }
            return false;
        } catch (Exception e) {
            e.printStackTrace();
            return true;
        }
    }

    @NonNull
    public static JSONObject a(JSONObject jSONObject) {
        return com.ss.android.download.api.c.b.a(jSONObject);
    }

    @NonNull
    public static JSONObject a(JSONObject... jSONObjectArr) {
        return com.ss.android.download.api.c.b.a(jSONObjectArr);
    }

    public static boolean a(Context context, Intent intent) {
        try {
            List<ResolveInfo> queryIntentActivities = context.getPackageManager().queryIntentActivities(intent, 65536);
            if (queryIntentActivities != null) {
                if (!queryIntentActivities.isEmpty()) {
                    return true;
                }
            }
        } catch (Exception unused) {
        }
        return false;
    }

    public static boolean b(com.ss.android.downloadad.api.a.b bVar) {
        if (bVar == null) {
            return false;
        }
        return a(bVar.e(), bVar.I(), bVar.J()).a();
    }

    public static boolean b(Context context, Intent intent) {
        if (intent == null) {
            return false;
        }
        if (context == null) {
            context = com.ss.android.downloadlib.addownload.k.a();
        }
        List<ResolveInfo> queryIntentActivities = context.getPackageManager().queryIntentActivities(intent, 65536);
        return queryIntentActivities != null && queryIntentActivities.size() > 0;
    }

    public static String a(long j) {
        DecimalFormat decimalFormat = new DecimalFormat("0.00");
        if (j >= 1073741824) {
            return (j / 1073741824) + "G";
        }
        if (j >= BaseConstants.MB_VALUE) {
            return (j / BaseConstants.MB_VALUE) + "M";
        }
        return decimalFormat.format(((float) j) / 1048576.0f) + "M";
    }

    public static long b(long j) {
        try {
            return a(Environment.getExternalStorageDirectory(), j);
        } catch (Exception e) {
            e.printStackTrace();
            return j;
        }
    }

    public static PackageInfo a(com.ss.android.downloadad.api.a.b bVar) {
        DownloadInfo downloadInfo;
        if (bVar == null || (downloadInfo = Downloader.getInstance(com.ss.android.downloadlib.addownload.k.a()).getDownloadInfo(bVar.s())) == null) {
            return null;
        }
        try {
            return com.ss.android.socialbase.appdownloader.c.a(com.ss.android.downloadlib.addownload.k.a(), downloadInfo, downloadInfo.getSavePath(), downloadInfo.getName());
        } catch (Throwable unused) {
            return null;
        }
    }

    public static boolean b() {
        return Looper.myLooper() == Looper.getMainLooper();
    }

    @NonNull
    public static HashMap<String, String> b(JSONObject jSONObject) {
        HashMap<String, String> hashMap = new HashMap<>();
        if (jSONObject != null) {
            try {
                Iterator<String> keys = jSONObject.keys();
                while (keys.hasNext()) {
                    String next = keys.next();
                    hashMap.put(next, jSONObject.optString(next));
                }
                return hashMap;
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return hashMap;
    }

    public static Drawable a(Context context, String str) {
        PackageManager packageManager;
        PackageInfo packageArchiveInfo;
        if (context != null && !TextUtils.isEmpty(str) && (packageArchiveInfo = (packageManager = context.getPackageManager()).getPackageArchiveInfo(str, 0)) != null) {
            ApplicationInfo applicationInfo = packageArchiveInfo.applicationInfo;
            applicationInfo.sourceDir = str;
            applicationInfo.publicSourceDir = str;
            try {
                return applicationInfo.loadIcon(packageManager);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    @SuppressLint({"MissingPermission"})
    public static void c() {
        try {
            if (com.ss.android.downloadlib.addownload.k.f().a(com.ss.android.downloadlib.addownload.k.a(), "android.permission.REORDER_TASKS")) {
                ActivityManager activityManager = (ActivityManager) com.ss.android.downloadlib.addownload.k.a().getSystemService("activity");
                for (ActivityManager.RunningTaskInfo runningTaskInfo : activityManager.getRunningTasks(20)) {
                    if (com.ss.android.downloadlib.addownload.k.a().getPackageName().equals(runningTaskInfo.topActivity.getPackageName())) {
                        activityManager.moveTaskToFront(runningTaskInfo.id, 1);
                        return;
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static com.ss.android.downloadlib.addownload.b.c a(String str, int i, String str2) {
        com.ss.android.downloadlib.addownload.b.c cVar = new com.ss.android.downloadlib.addownload.b.c();
        if (TextUtils.isEmpty(str)) {
            return cVar;
        }
        try {
            PackageInfo packageInfo = com.ss.android.downloadlib.addownload.k.a().getPackageManager().getPackageInfo(str, 0);
            if (packageInfo != null) {
                cVar.b(packageInfo.versionCode);
                cVar.a(com.ss.android.downloadlib.addownload.b.c.b);
                o h = com.ss.android.downloadlib.addownload.k.h();
                if (h != null && h.a() && !a(packageInfo.versionCode, i, packageInfo.versionName, str2)) {
                    cVar.a(com.ss.android.downloadlib.addownload.b.c.f725c);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return cVar;
    }

    private static boolean a(int i, int i2, String str, String str2) {
        if (i2 == 0 && TextUtils.isEmpty(str2)) {
            return true;
        }
        return (i2 > 0 && i >= i2) || a(str, str2) >= 0;
    }

    public static boolean a(DownloadModel downloadModel) {
        if (downloadModel == null) {
            return false;
        }
        return a(downloadModel.getPackageName(), downloadModel.getVersionCode(), downloadModel.getVersionName()).a();
    }

    public static boolean a(Context context, String str, String str2) {
        PackageInfo packageArchiveInfo;
        PackageInfo packageInfo;
        if (context == null || TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return false;
        }
        try {
            File file = new File(str);
            if (!file.exists() || (packageArchiveInfo = context.getPackageManager().getPackageArchiveInfo(file.getAbsolutePath(), 0)) == null || !packageArchiveInfo.packageName.equals(str2)) {
                return false;
            }
            int i = packageArchiveInfo.versionCode;
            try {
                packageInfo = context.getPackageManager().getPackageInfo(str2, 0);
            } catch (PackageManager.NameNotFoundException unused) {
                packageInfo = null;
            }
            if (packageInfo == null) {
                return false;
            }
            return i == packageInfo.versionCode;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public static boolean a(Signature[] signatureArr, Signature[] signatureArr2) {
        if (signatureArr == signatureArr2) {
            return true;
        }
        if (signatureArr == null || signatureArr2 == null || signatureArr.length != signatureArr2.length) {
            return false;
        }
        for (int i = 0; i < signatureArr.length; i++) {
            if ((signatureArr[i] == null && signatureArr2[i] != null) || (signatureArr[i] != null && !signatureArr[i].equals(signatureArr2[i]))) {
                return false;
            }
        }
        return true;
    }

    public static int a(Context context, float f) {
        return (int) ((f * context.getResources().getDisplayMetrics().density) + 0.5f);
    }

    public static String a(String str, int i) {
        return i == 0 ? "" : (TextUtils.isEmpty(str) || str.length() <= i) ? str : str.substring(0, i);
    }

    public static int a(String str, String str2) {
        try {
            if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
                if (str.equals(str2)) {
                    return 0;
                }
                String[] split = str.split("\\.");
                String[] split2 = str2.split("\\.");
                int min = Math.min(split.length, split2.length);
                int i = 0;
                int i2 = 0;
                while (i < min) {
                    i2 = Integer.parseInt(split[i]) - Integer.parseInt(split2[i]);
                    if (i2 != 0) {
                        break;
                    }
                    i++;
                }
                if (i2 != 0) {
                    return i2 > 0 ? 1 : -1;
                }
                for (int i3 = i; i3 < split.length; i3++) {
                    if (Integer.parseInt(split[i3]) > 0) {
                        return 1;
                    }
                }
                while (i < split2.length) {
                    if (Integer.parseInt(split2[i]) > 0) {
                        return -1;
                    }
                    i++;
                }
                return 0;
            }
        } catch (Exception unused) {
        }
        return -2;
    }

    public static String a(String... strArr) {
        return com.ss.android.download.api.c.b.a(strArr);
    }

    @NonNull
    public static <T> T a(T... tArr) {
        if (tArr != null) {
            for (T t : tArr) {
                if (t != null) {
                    return t;
                }
            }
            throw new IllegalArgumentException("args is null");
        }
        throw new IllegalArgumentException("args is null");
    }

    public static boolean a() {
        try {
            if (com.ss.android.downloadlib.addownload.k.a().getPackageManager().getPackageInfo(com.ss.android.downloadlib.addownload.k.a().getPackageName(), 0).applicationInfo.targetSdkVersion == 33) {
                return Build.VERSION.SDK_INT == 33;
            }
            return false;
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
            return false;
        }
    }

    public static long a(File file, long j) {
        if (file == null) {
            return j;
        }
        try {
            return com.ss.android.socialbase.downloader.i.f.d(file.getAbsolutePath());
        } catch (Exception e) {
            e.printStackTrace();
            return j;
        }
    }

    public static long a(File file) {
        if (file == null) {
            return -1L;
        }
        try {
            StatFs statFs = new StatFs(file.getAbsolutePath());
            if (Build.VERSION.SDK_INT >= 18) {
                return statFs.getTotalBytes();
            }
            return -1L;
        } catch (Throwable th) {
            th.printStackTrace();
            return -1L;
        }
    }

    public static void a(JSONObject jSONObject, String str, Object obj) {
        if (jSONObject == null || TextUtils.isEmpty(str)) {
            return;
        }
        try {
            jSONObject.putOpt(str, obj);
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}
