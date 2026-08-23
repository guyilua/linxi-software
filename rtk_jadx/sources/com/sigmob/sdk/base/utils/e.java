package com.sigmob.sdk.base.utils;

import android.content.Context;
import android.os.Environment;
import com.czhj.sdk.common.utils.FileUtil;
import com.czhj.sdk.logger.SigmobLog;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Arrays;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public final class e {
    public static String a = "SigHtmlResource";
    public static String b = "SigHtmlPrivacy";

    /* renamed from: c, reason: collision with root package name */
    public static String f438c = "SigZipResource";
    public static String d = "SigCrashResource";
    private static String e;
    private static String f;
    private static File g;
    private static String h;

    public static File a(Context context) {
        try {
            if (g == null) {
                File file = new File(d(), "SigDownload");
                g = file;
                if (!file.exists()) {
                    g.mkdirs();
                }
            }
        } catch (Throwable unused) {
        }
        return g;
    }

    public static File a(File file, String str) {
        if (file == null || str == null) {
            return null;
        }
        return new File(file, str);
    }

    public static File a(String str, String str2) {
        if (str == null || str2 == null) {
            return null;
        }
        return new File(str, str2);
    }

    public static String a() {
        if (e == null) {
            File cacheDir = com.sigmob.sdk.b.e().getCacheDir();
            if (cacheDir != null && h != null) {
                File file = new File(cacheDir, h);
                if (!file.exists()) {
                    file.mkdirs();
                }
                cacheDir = file;
            }
            e = cacheDir.getAbsolutePath();
        }
        return e;
    }

    public static String a(String str) {
        int lastIndexOf = str.lastIndexOf(".");
        return lastIndexOf != -1 ? str.substring(lastIndexOf) : "";
    }

    public static void a(Context context, String str) {
        h = str;
    }

    public static File[] a(File[] fileArr, int i) {
        if (fileArr == null || fileArr.length == 0) {
            return null;
        }
        ArrayList arrayList = new ArrayList(Arrays.asList(fileArr));
        for (int i2 = 0; i2 < fileArr.length && arrayList.size() > i; i2++) {
            File file = fileArr[i2];
            if (file.exists()) {
                file.delete();
                arrayList.remove(file);
                SigmobLog.d("file delete " + file.getName());
            }
        }
        return (File[]) arrayList.toArray(new File[0]);
    }

    public static File b(String str, String str2) {
        try {
            File a2 = a(d(), a);
            if (!a2.exists()) {
                a2.mkdirs();
            }
            File file = new File(a2, str2);
            SigmobLog.d("SigHtmlResource: " + file.getAbsolutePath());
            if (file.exists()) {
                file.delete();
            }
            file.createNewFile();
            FileWriter fileWriter = new FileWriter(file, true);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            bufferedWriter.write(str);
            bufferedWriter.newLine();
            bufferedWriter.close();
            fileWriter.close();
            return file;
        } catch (Exception e2) {
            e2.printStackTrace();
            return null;
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
    }

    public static String b() {
        String str = a() + File.separator + "videoAd";
        File file = new File(str);
        if (!file.exists()) {
            file.mkdirs();
        }
        return str;
    }

    public static String b(String str) {
        int lastIndexOf = str.lastIndexOf(".");
        return lastIndexOf != -1 ? str.substring(0, lastIndexOf) : str;
    }

    public static String c() {
        String str = a() + File.separator + "webCache";
        File file = new File(str);
        if (!file.exists()) {
            file.mkdirs();
        }
        return str;
    }

    public static synchronized String c(String str) {
        String sb;
        synchronized (e.class) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append(a());
            String str2 = File.separator;
            sb2.append(str2);
            sb2.append("splashAdUnit");
            sb2.append(str2);
            sb2.append(str);
            sb = sb2.toString();
        }
        return sb;
    }

    public static File d(String str) {
        try {
            File a2 = a(d(), str);
            if (a2 != null && !a2.exists()) {
                a2.mkdirs();
            }
            return a2;
        } catch (Throwable unused) {
            return null;
        }
    }

    public static String d() {
        if (f == null) {
            boolean equals = Environment.getExternalStorageState().equals("mounted");
            boolean isExternalStorageRemovable = Environment.isExternalStorageRemovable();
            File file = null;
            if (equals && !isExternalStorageRemovable) {
                file = com.sigmob.sdk.b.e().getExternalCacheDir();
            }
            if (file == null) {
                file = com.sigmob.sdk.b.e().getCacheDir();
            }
            if (file != null && h != null) {
                File file2 = new File(file, h);
                if (!file2.exists()) {
                    file2.mkdirs();
                }
                f = file2.getAbsolutePath();
            }
        }
        return f;
    }

    public static File e(String str) {
        if (str == null) {
            return null;
        }
        return new File(str);
    }

    public static String e() {
        String str = a() + File.separator + "splashAd";
        File file = new File(str);
        if (!file.exists()) {
            file.mkdirs();
        }
        return str;
    }

    public static File f(String str) {
        try {
            File a2 = a(d(), str);
            if (a2 != null && !a2.exists()) {
                a2.mkdirs();
            }
            return a2;
        } catch (Throwable unused) {
            return null;
        }
    }

    public static String f() {
        String str = a() + File.separator + "nativeAd";
        File file = new File(str);
        if (!file.exists()) {
            file.mkdirs();
        }
        return str;
    }

    public static String g() {
        String str = a() + File.separator + "downloadAPKLog";
        try {
            File file = new File(str);
            if (!file.exists()) {
                file.mkdirs();
            }
        } catch (Throwable unused) {
        }
        return str;
    }

    public static synchronized String h() {
        String sb;
        synchronized (e.class) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append(a());
            String str = File.separator;
            sb2.append(str);
            sb2.append("logger");
            sb2.append(str);
            sb2.append("sdkLog.log");
            sb = sb2.toString();
        }
        return sb;
    }

    public static void i() {
        try {
            if (e != null) {
                File file = new File(e);
                if (file.exists()) {
                    FileUtil.deleteDirectory(e);
                }
                if (!file.exists() || file.isFile()) {
                    file.mkdirs();
                }
            }
        } catch (Throwable unused) {
        }
    }

    public static File j() {
        try {
            File a2 = a(d(), d);
            if (!a2.exists()) {
                a2.mkdirs();
            }
            return a(a2, String.format("%d.log", Long.valueOf(System.currentTimeMillis() / 1000)));
        } catch (Throwable th) {
            SigmobLog.d("createCrash fail", th);
            return null;
        }
    }

    public static File[] k() {
        try {
            File a2 = a(d(), d);
            if (a2.exists()) {
                return FileUtil.orderByDate(a2.getAbsolutePath());
            }
            a2.mkdirs();
            return null;
        } catch (Throwable unused) {
            return null;
        }
    }
}
