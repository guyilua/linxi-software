package com.tencent.smtt.utils;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.provider.Settings;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import com.umeng.analytics.pro.bz;
import java.io.File;
import java.io.InputStream;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.net.NetworkInterface;
import java.security.cert.Certificate;
import java.util.Collections;
import java.util.Enumeration;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;

/* compiled from: AppUtil.java */
/* loaded from: /tmp/rtk_apk/classes3.dex */
public class b {
    public static String a = "";
    public static String b = "";

    /* renamed from: c, reason: collision with root package name */
    public static String f973c = "";
    public static String d = "";
    public static String e = "";

    public static String a(Context context) {
        try {
            return context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionName;
        } catch (Exception unused) {
            return null;
        }
    }

    private static String a(String str) {
        return str == null ? "" : str;
    }

    public static int b(Context context) {
        try {
            return context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionCode;
        } catch (Exception unused) {
            return 0;
        }
    }

    public static String c(Context context) {
        if (!TextUtils.isEmpty(a)) {
            return a;
        }
        try {
            return ((TelephonyManager) context.getSystemService("phone")).getDeviceId();
        } catch (Exception e2) {
            e2.printStackTrace();
            return "";
        }
    }

    public static String d(Context context) {
        if (!TextUtils.isEmpty(b)) {
            return b;
        }
        try {
            return ((TelephonyManager) context.getSystemService("phone")).getSubscriberId();
        } catch (Exception e2) {
            e2.printStackTrace();
            return "";
        }
    }

    public static String e(Context context) {
        if (TextUtils.isEmpty(d)) {
            if (Build.VERSION.SDK_INT < 23) {
                try {
                    WifiManager wifiManager = (WifiManager) context.getApplicationContext().getSystemService("wifi");
                    WifiInfo connectionInfo = wifiManager == null ? null : wifiManager.getConnectionInfo();
                    d = connectionInfo == null ? "" : connectionInfo.getMacAddress();
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
            } else {
                d = b();
            }
        }
        return d;
    }

    public static String f(Context context) {
        if (!TextUtils.isEmpty(e)) {
            return e;
        }
        try {
            e = Settings.Secure.getString(context.getContentResolver(), "android_id");
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        return e;
    }

    public static String a(Context context, String str) {
        try {
            String valueOf = String.valueOf(context.getPackageManager().getApplicationInfo(context.getPackageName(), 128).metaData.get(str));
            try {
                return String.valueOf(Integer.toHexString(Integer.parseInt(valueOf)));
            } catch (Exception unused) {
                return valueOf;
            }
        } catch (Exception unused2) {
            return null;
        }
    }

    public static String b() {
        try {
            for (NetworkInterface networkInterface : Collections.list(NetworkInterface.getNetworkInterfaces())) {
                if (networkInterface.getName().equalsIgnoreCase("wlan0")) {
                    byte[] hardwareAddress = networkInterface.getHardwareAddress();
                    if (hardwareAddress == null) {
                        return "";
                    }
                    StringBuilder sb = new StringBuilder();
                    for (byte b2 : hardwareAddress) {
                        sb.append(String.format("%02X:", Byte.valueOf(b2)));
                    }
                    if (sb.length() > 0) {
                        sb.deleteCharAt(sb.length() - 1);
                    }
                    return sb.toString();
                }
            }
            return "02:00:00:00:00:00";
        } catch (Exception unused) {
            return "02:00:00:00:00:00";
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:29:0x0065, code lost:
    
        if (r3 == null) goto L29;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static java.lang.String a() {
        /*
            java.lang.String r0 = "os.arch"
            java.lang.String r1 = com.tencent.smtt.utils.b.f973c
            boolean r1 = android.text.TextUtils.isEmpty(r1)
            if (r1 != 0) goto Ld
            java.lang.String r0 = com.tencent.smtt.utils.b.f973c
            return r0
        Ld:
            r1 = 0
            java.lang.Runtime r2 = java.lang.Runtime.getRuntime()     // Catch: java.lang.Throwable -> L4f
            java.lang.String r3 = "getprop ro.product.cpu.abi"
            java.lang.Process r2 = r2.exec(r3)     // Catch: java.lang.Throwable -> L4f
            java.io.InputStreamReader r3 = new java.io.InputStreamReader     // Catch: java.lang.Throwable -> L4f
            java.io.InputStream r2 = r2.getInputStream()     // Catch: java.lang.Throwable -> L4f
            r3.<init>(r2)     // Catch: java.lang.Throwable -> L4f
            java.io.BufferedReader r2 = new java.io.BufferedReader     // Catch: java.lang.Throwable -> L4a
            r2.<init>(r3)     // Catch: java.lang.Throwable -> L4a
            java.lang.String r1 = r2.readLine()     // Catch: java.lang.Throwable -> L48
            java.lang.String r4 = "x86"
            boolean r1 = r1.contains(r4)     // Catch: java.lang.Throwable -> L48
            if (r1 == 0) goto L39
            java.lang.String r1 = "i686"
            java.lang.String r0 = a(r1)     // Catch: java.lang.Throwable -> L48
            goto L41
        L39:
            java.lang.String r1 = java.lang.System.getProperty(r0)     // Catch: java.lang.Throwable -> L48
            java.lang.String r0 = a(r1)     // Catch: java.lang.Throwable -> L48
        L41:
            r2.close()     // Catch: java.io.IOException -> L44
        L44:
            r3.close()     // Catch: java.io.IOException -> L68
            goto L68
        L48:
            r1 = move-exception
            goto L53
        L4a:
            r2 = move-exception
            r5 = r2
            r2 = r1
            r1 = r5
            goto L53
        L4f:
            r2 = move-exception
            r3 = r1
            r1 = r2
            r2 = r3
        L53:
            java.lang.String r0 = java.lang.System.getProperty(r0)     // Catch: java.lang.Throwable -> L69
            java.lang.String r0 = a(r0)     // Catch: java.lang.Throwable -> L69
            r1.printStackTrace()     // Catch: java.lang.Throwable -> L69
            if (r2 == 0) goto L65
            r2.close()     // Catch: java.io.IOException -> L64
            goto L65
        L64:
        L65:
            if (r3 == 0) goto L68
            goto L44
        L68:
            return r0
        L69:
            r0 = move-exception
            if (r2 == 0) goto L71
            r2.close()     // Catch: java.io.IOException -> L70
            goto L71
        L70:
        L71:
            if (r3 == 0) goto L76
            r3.close()     // Catch: java.io.IOException -> L76
        L76:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.smtt.utils.b.a():java.lang.String");
    }

    /* JADX WARN: Removed duplicated region for block: B:44:0x0066 A[Catch: all -> 0x0077, TryCatch #2 {all -> 0x0077, blocks: (B:42:0x0056, B:44:0x0066, B:46:0x0071), top: B:41:0x0056 }] */
    /* JADX WARN: Removed duplicated region for block: B:51:0x009c  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x00b6  */
    /* JADX WARN: Removed duplicated region for block: B:55:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static java.lang.String a(android.content.Context r5, boolean r6, java.io.File r7) {
        /*
            java.lang.String r0 = "AppUtil"
            java.lang.String r1 = ""
            if (r7 == 0) goto Ld0
            boolean r2 = r7.exists()
            if (r2 != 0) goto Le
            goto Ld0
        Le:
            if (r6 == 0) goto L56
            r6 = 0
            r2 = 2
            byte[] r2 = new byte[r2]     // Catch: java.lang.Throwable -> L3a java.lang.Exception -> L3c
            java.io.RandomAccessFile r3 = new java.io.RandomAccessFile     // Catch: java.lang.Throwable -> L3a java.lang.Exception -> L3c
            java.lang.String r4 = "r"
            r3.<init>(r7, r4)     // Catch: java.lang.Throwable -> L3a java.lang.Exception -> L3c
            r3.read(r2)     // Catch: java.lang.Exception -> L38 java.lang.Throwable -> L4b
            java.lang.String r6 = new java.lang.String     // Catch: java.lang.Exception -> L38 java.lang.Throwable -> L4b
            r6.<init>(r2)     // Catch: java.lang.Exception -> L38 java.lang.Throwable -> L4b
            java.lang.String r2 = "PK"
            boolean r6 = r6.equalsIgnoreCase(r2)     // Catch: java.lang.Exception -> L38 java.lang.Throwable -> L4b
            if (r6 != 0) goto L34
            r3.close()     // Catch: java.io.IOException -> L2f
            goto L33
        L2f:
            r5 = move-exception
            r5.printStackTrace()
        L33:
            return r1
        L34:
            r3.close()     // Catch: java.io.IOException -> L46
            goto L56
        L38:
            r6 = move-exception
            goto L3f
        L3a:
            r5 = move-exception
            goto L4d
        L3c:
            r1 = move-exception
            r3 = r6
            r6 = r1
        L3f:
            r6.printStackTrace()     // Catch: java.lang.Throwable -> L4b
            r3.close()     // Catch: java.io.IOException -> L46
            goto L56
        L46:
            r6 = move-exception
            r6.printStackTrace()
            goto L56
        L4b:
            r5 = move-exception
            r6 = r3
        L4d:
            r6.close()     // Catch: java.io.IOException -> L51
            goto L55
        L51:
            r6 = move-exception
            r6.printStackTrace()
        L55:
            throw r5
        L56:
            android.content.Context r6 = r5.getApplicationContext()     // Catch: java.lang.Throwable -> L77
            java.lang.String r6 = r6.getPackageName()     // Catch: java.lang.Throwable -> L77
            java.lang.String r1 = "com.jd.jrapp"
            boolean r6 = r6.contains(r1)     // Catch: java.lang.Throwable -> L77
            if (r6 == 0) goto L7c
            java.lang.String r6 = "[AppUtil.getSignatureFromApk]  #1"
            com.tencent.smtt.utils.TbsLog.i(r0, r6)     // Catch: java.lang.Throwable -> L77
            java.lang.String r6 = a(r7)     // Catch: java.lang.Throwable -> L77
            if (r6 == 0) goto L7c
            java.lang.String r1 = "[AppUtil.getSignatureFromApk]  #2"
            com.tencent.smtt.utils.TbsLog.i(r0, r1)     // Catch: java.lang.Throwable -> L77
            return r6
        L77:
            java.lang.String r6 = "[AppUtil.getSignatureFromApk]  #3"
            com.tencent.smtt.utils.TbsLog.i(r0, r6)
        L7c:
            java.lang.String r6 = "[AppUtil.getSignatureFromApk]  #4"
            com.tencent.smtt.utils.TbsLog.i(r0, r6)
            r6 = 0
            java.lang.String r6 = a(r5, r7, r6)
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "[AppUtil.getSignatureFromApk]  android api signature="
            r1.append(r2)
            r1.append(r6)
            java.lang.String r1 = r1.toString()
            com.tencent.smtt.utils.TbsLog.i(r0, r1)
            if (r6 != 0) goto Lb4
            java.lang.String r6 = a(r7)
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "[AppUtil.getSignatureFromApk]  java get signature="
            r1.append(r2)
            r1.append(r6)
            java.lang.String r1 = r1.toString()
            com.tencent.smtt.utils.TbsLog.i(r0, r1)
        Lb4:
            if (r6 != 0) goto Lcf
            r6 = 1
            java.lang.String r6 = a(r5, r7, r6)
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>()
            java.lang.String r7 = "[AppUtil.getSignatureFromApk]  android reflection signature="
            r5.append(r7)
            r5.append(r6)
            java.lang.String r5 = r5.toString()
            com.tencent.smtt.utils.TbsLog.i(r0, r5)
        Lcf:
            return r6
        Ld0:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.smtt.utils.b.a(android.content.Context, boolean, java.io.File):java.lang.String");
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0031 A[Catch: Exception -> 0x0036, TRY_LEAVE, TryCatch #0 {Exception -> 0x0036, blocks: (B:4:0x0007, B:6:0x001e, B:8:0x0022, B:10:0x0025, B:12:0x0031, B:17:0x0029, B:19:0x0010), top: B:2:0x0005 }] */
    /* JADX WARN: Removed duplicated region for block: B:16:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static java.lang.String a(android.content.Context r3, java.io.File r4, boolean r5) {
        /*
            java.lang.String r0 = "AppUtil"
            r1 = 65
            r2 = 0
            if (r5 == 0) goto L10
            java.lang.String r3 = r4.getAbsolutePath()     // Catch: java.lang.Exception -> L36
            android.content.pm.PackageInfo r3 = a(r3, r1)     // Catch: java.lang.Exception -> L36
            goto L1c
        L10:
            android.content.pm.PackageManager r3 = r3.getPackageManager()     // Catch: java.lang.Exception -> L36
            java.lang.String r5 = r4.getAbsolutePath()     // Catch: java.lang.Exception -> L36
            android.content.pm.PackageInfo r3 = r3.getPackageArchiveInfo(r5, r1)     // Catch: java.lang.Exception -> L36
        L1c:
            if (r3 == 0) goto L2e
            android.content.pm.Signature[] r3 = r3.signatures     // Catch: java.lang.Exception -> L36
            if (r3 == 0) goto L29
            int r5 = r3.length     // Catch: java.lang.Exception -> L36
            if (r5 <= 0) goto L29
            r5 = 0
            r3 = r3[r5]     // Catch: java.lang.Exception -> L36
            goto L2f
        L29:
            java.lang.String r3 = "[getSignatureFromApk] pkgInfo is not null BUT signatures is null!"
            com.tencent.smtt.utils.TbsLog.w(r0, r3)     // Catch: java.lang.Exception -> L36
        L2e:
            r3 = r2
        L2f:
            if (r3 == 0) goto L4f
            java.lang.String r2 = r3.toCharsString()     // Catch: java.lang.Exception -> L36
            goto L4f
        L36:
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String r5 = "getSign "
            r3.append(r5)
            r3.append(r4)
            java.lang.String r4 = "failed"
            r3.append(r4)
            java.lang.String r3 = r3.toString()
            com.tencent.smtt.utils.TbsLog.i(r0, r3)
        L4f:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.smtt.utils.b.a(android.content.Context, java.io.File, boolean):java.lang.String");
    }

    private static String a(File file) {
        try {
            JarFile jarFile = new JarFile(file);
            byte[] bArr = new byte[8192];
            String a2 = a(a(jarFile, jarFile.getJarEntry("AndroidManifest.xml"), bArr)[0].getEncoded());
            Enumeration<JarEntry> entries = jarFile.entries();
            while (entries.hasMoreElements()) {
                JarEntry nextElement = entries.nextElement();
                String name = nextElement.getName();
                if (name != null) {
                    Certificate[] a3 = a(jarFile, nextElement, bArr);
                    String a4 = a3 != null ? a(a3[0].getEncoded()) : null;
                    if (a4 == null) {
                        if (!name.startsWith("META-INF/")) {
                            return null;
                        }
                    } else if (!a4.equals(a2)) {
                        return null;
                    }
                }
            }
            return a2;
        } catch (Exception e2) {
            e2.printStackTrace();
            return null;
        }
    }

    private static PackageInfo a(String str, int i) {
        Class<?> cls;
        try {
            Class<?> cls2 = Class.forName("android.content.pm.PackageParser");
            Class<?>[] declaredClasses = cls2.getDeclaredClasses();
            int length = declaredClasses.length;
            int i2 = 0;
            while (true) {
                if (i2 >= length) {
                    cls = null;
                    break;
                }
                cls = declaredClasses[i2];
                if (cls.getName().compareTo("android.content.pm.PackageParser$Package") == 0) {
                    break;
                }
                i2++;
            }
            Constructor<?> constructor = cls2.getConstructor(String.class);
            Class<?> cls3 = Integer.TYPE;
            Method declaredMethod = cls2.getDeclaredMethod("parsePackage", File.class, String.class, DisplayMetrics.class, cls3);
            Method declaredMethod2 = cls2.getDeclaredMethod("collectCertificates", cls, cls3);
            Class<?> cls4 = Long.TYPE;
            Method declaredMethod3 = cls2.getDeclaredMethod("generatePackageInfo", cls, int[].class, cls3, cls4, cls4);
            constructor.setAccessible(true);
            declaredMethod.setAccessible(true);
            declaredMethod2.setAccessible(true);
            declaredMethod3.setAccessible(true);
            Object newInstance = constructor.newInstance(str);
            DisplayMetrics displayMetrics = new DisplayMetrics();
            displayMetrics.setToDefaults();
            Object invoke = declaredMethod.invoke(newInstance, new File(str), str, displayMetrics, 0);
            if (invoke == null) {
                return null;
            }
            if ((i & 64) != 0) {
                declaredMethod2.invoke(newInstance, invoke, 0);
            }
            return (PackageInfo) declaredMethod3.invoke(null, invoke, null, Integer.valueOf(i), 0, 0);
        } catch (Exception e2) {
            e2.printStackTrace();
            return null;
        }
    }

    private static Certificate[] a(JarFile jarFile, JarEntry jarEntry, byte[] bArr) {
        InputStream inputStream = jarFile.getInputStream(jarEntry);
        do {
        } while (inputStream.read(bArr, 0, bArr.length) != -1);
        inputStream.close();
        if (jarEntry != null) {
            return jarEntry.getCertificates();
        }
        return null;
    }

    private static String a(byte[] bArr) {
        int length = bArr.length;
        char[] cArr = new char[length * 2];
        for (int i = 0; i < length; i++) {
            byte b2 = bArr[i];
            int i2 = (b2 >> 4) & 15;
            int i3 = i * 2;
            cArr[i3] = (char) (i2 >= 10 ? (i2 + 97) - 10 : i2 + 48);
            int i4 = b2 & bz.m;
            cArr[i3 + 1] = (char) (i4 >= 10 ? (i4 + 97) - 10 : i4 + 48);
        }
        return new String(cArr);
    }
}
