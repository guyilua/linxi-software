package com.tencent.smtt.utils;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.os.Build;
import com.tencent.smtt.sdk.TbsExtensionFunctionManager;
import com.tencent.smtt.sdk.TbsPVConfig;
import com.tencent.smtt.sdk.TbsShareManager;
import java.io.File;
import java.util.regex.Pattern;

/* compiled from: ApkUtil.java */
/* loaded from: /tmp/rtk_apk/classes3.dex */
public class a {
    public static final String a(boolean z) {
        return z ? "x5.decouple.backup" : "x5.backup";
    }

    public static boolean a(Context context, File file, long j, int i) {
        if (file != null && file.exists()) {
            if (j > 0 && j != file.length()) {
                return false;
            }
            try {
                if (i != a(context, file)) {
                    return false;
                }
                return "3082023f308201a8a00302010202044c46914a300d06092a864886f70d01010505003064310b30090603550406130238363110300e060355040813074265696a696e673110300e060355040713074265696a696e673110300e060355040a130754656e63656e74310c300a060355040b13035753443111300f0603550403130873616d75656c6d6f301e170d3130303732313036313835305a170d3430303731333036313835305a3064310b30090603550406130238363110300e060355040813074265696a696e673110300e060355040713074265696a696e673110300e060355040a130754656e63656e74310c300a060355040b13035753443111300f0603550403130873616d75656c6d6f30819f300d06092a864886f70d010101050003818d0030818902818100c209077044bd0d63ea00ede5b839914cabcc912a87f0f8b390877e0f7a2583f0d5933443c40431c35a4433bc4c965800141961adc44c9625b1d321385221fd097e5bdc2f44a1840d643ab59dc070cf6c4b4b4d98bed5cbb8046e0a7078ae134da107cdf2bfc9b440fe5cb2f7549b44b73202cc6f7c2c55b8cfb0d333a021f01f0203010001300d06092a864886f70d010105050003818100b007db9922774ef4ccfee81ba514a8d57c410257e7a2eba64bfa17c9e690da08106d32f637ac41fbc9f205176c71bde238c872c3ee2f8313502bee44c80288ea4ef377a6f2cdfe4d3653c145c4acfedbfbadea23b559d41980cc3cdd35d79a68240693739aabf5c5ed26148756cf88264226de394c8a24ac35b712b120d4d23a".equals(b.a(context, true, file));
            } catch (Exception unused) {
            }
        }
        return false;
    }

    /* JADX WARN: Code restructure failed: missing block: B:21:0x0037, code lost:
    
        r1 = java.lang.Integer.parseInt(r1[1].trim());
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x0042, code lost:
    
        r6.close();
        r2.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x004d, code lost:
    
        r2.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:45:0x0071, code lost:
    
        if (r2 != null) goto L20;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r6v0, types: [java.io.File] */
    /* JADX WARN: Type inference failed for: r6v10 */
    /* JADX WARN: Type inference failed for: r6v3 */
    /* JADX WARN: Type inference failed for: r6v7, types: [java.io.BufferedReader] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static int b(java.io.File r6) {
        /*
            java.lang.Class<com.tencent.smtt.utils.a> r0 = com.tencent.smtt.utils.a.class
            monitor-enter(r0)
            r1 = 0
            java.util.jar.JarFile r2 = new java.util.jar.JarFile     // Catch: java.lang.Throwable -> L5d java.lang.Exception -> L62
            r2.<init>(r6)     // Catch: java.lang.Throwable -> L5d java.lang.Exception -> L62
            java.lang.String r6 = "assets/webkit/tbs.conf"
            java.util.jar.JarEntry r6 = r2.getJarEntry(r6)     // Catch: java.lang.Throwable -> L53 java.lang.Exception -> L58
            java.io.InputStream r6 = r2.getInputStream(r6)     // Catch: java.lang.Throwable -> L53 java.lang.Exception -> L58
            java.io.InputStreamReader r3 = new java.io.InputStreamReader     // Catch: java.lang.Throwable -> L53 java.lang.Exception -> L58
            r3.<init>(r6)     // Catch: java.lang.Throwable -> L53 java.lang.Exception -> L58
            java.io.BufferedReader r6 = new java.io.BufferedReader     // Catch: java.lang.Throwable -> L53 java.lang.Exception -> L58
            r6.<init>(r3)     // Catch: java.lang.Throwable -> L53 java.lang.Exception -> L58
        L1d:
            java.lang.String r1 = r6.readLine()     // Catch: java.lang.Exception -> L51 java.lang.Throwable -> L77
            if (r1 == 0) goto L4a
            java.lang.String r3 = "tbs_core_version"
            boolean r3 = r1.contains(r3)     // Catch: java.lang.Exception -> L51 java.lang.Throwable -> L77
            if (r3 == 0) goto L1d
            java.lang.String r3 = "="
            java.lang.String[] r1 = r1.split(r3)     // Catch: java.lang.Exception -> L51 java.lang.Throwable -> L77
            if (r1 == 0) goto L1d
            int r3 = r1.length     // Catch: java.lang.Exception -> L51 java.lang.Throwable -> L77
            r4 = 2
            if (r3 != r4) goto L1d
            r3 = 1
            r1 = r1[r3]     // Catch: java.lang.Exception -> L51 java.lang.Throwable -> L77
            java.lang.String r1 = r1.trim()     // Catch: java.lang.Exception -> L51 java.lang.Throwable -> L77
            int r1 = java.lang.Integer.parseInt(r1)     // Catch: java.lang.Exception -> L51 java.lang.Throwable -> L77
            r6.close()     // Catch: java.lang.Exception -> L48 java.lang.Throwable -> L6f
            r2.close()     // Catch: java.lang.Exception -> L48 java.lang.Throwable -> L6f
        L48:
            monitor-exit(r0)     // Catch: java.lang.Throwable -> L6f
            return r1
        L4a:
            r6.close()     // Catch: java.lang.Throwable -> L6f java.lang.Exception -> L74
        L4d:
            r2.close()     // Catch: java.lang.Throwable -> L6f java.lang.Exception -> L74
            goto L74
        L51:
            r1 = move-exception
            goto L66
        L53:
            r6 = move-exception
            r5 = r1
            r1 = r6
            r6 = r5
            goto L78
        L58:
            r6 = move-exception
            r5 = r1
            r1 = r6
            r6 = r5
            goto L66
        L5d:
            r6 = move-exception
            r2 = r1
            r1 = r6
            r6 = r2
            goto L78
        L62:
            r6 = move-exception
            r2 = r1
            r1 = r6
            r6 = r2
        L66:
            r1.printStackTrace()     // Catch: java.lang.Throwable -> L77
            if (r6 == 0) goto L71
            r6.close()     // Catch: java.lang.Throwable -> L6f java.lang.Exception -> L74
            goto L71
        L6f:
            r6 = move-exception
            goto L83
        L71:
            if (r2 == 0) goto L74
            goto L4d
        L74:
            r6 = -1
            monitor-exit(r0)     // Catch: java.lang.Throwable -> L6f
            return r6
        L77:
            r1 = move-exception
        L78:
            if (r6 == 0) goto L7d
            r6.close()     // Catch: java.lang.Throwable -> L6f java.lang.Exception -> L82
        L7d:
            if (r2 == 0) goto L82
            r2.close()     // Catch: java.lang.Throwable -> L6f java.lang.Exception -> L82
        L82:
            throw r1     // Catch: java.lang.Throwable -> L6f
        L83:
            monitor-exit(r0)     // Catch: java.lang.Throwable -> L6f
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.smtt.utils.a.b(java.io.File):int");
    }

    /* JADX WARN: Not initialized variable reg: 5, insn: 0x0068: MOVE (r3 I:??[OBJECT, ARRAY]) = (r5 I:??[OBJECT, ARRAY]), block:B:35:0x0068 */
    /* JADX WARN: Removed duplicated region for block: B:38:0x006b A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static java.lang.String a(java.io.File r10) {
        /*
            r0 = 16
            char[] r1 = new char[r0]
            r1 = {x0074: FILL_ARRAY_DATA , data: [48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 97, 98, 99, 100, 101, 102} // fill-array
            r2 = 32
            char[] r2 = new char[r2]
            r3 = 0
            java.lang.String r4 = "MD5"
            java.security.MessageDigest r4 = java.security.MessageDigest.getInstance(r4)     // Catch: java.lang.Throwable -> L55 java.lang.Exception -> L57
            java.io.FileInputStream r5 = new java.io.FileInputStream     // Catch: java.lang.Throwable -> L55 java.lang.Exception -> L57
            r5.<init>(r10)     // Catch: java.lang.Throwable -> L55 java.lang.Exception -> L57
            r10 = 8192(0x2000, float:1.148E-41)
            byte[] r10 = new byte[r10]     // Catch: java.lang.Exception -> L53 java.lang.Throwable -> L67
        L1b:
            int r6 = r5.read(r10)     // Catch: java.lang.Exception -> L53 java.lang.Throwable -> L67
            r7 = -1
            r8 = 0
            if (r6 == r7) goto L27
            r4.update(r10, r8, r6)     // Catch: java.lang.Exception -> L53 java.lang.Throwable -> L67
            goto L1b
        L27:
            byte[] r10 = r4.digest()     // Catch: java.lang.Exception -> L53 java.lang.Throwable -> L67
            r4 = 0
        L2c:
            if (r8 >= r0) goto L45
            r6 = r10[r8]     // Catch: java.lang.Exception -> L53 java.lang.Throwable -> L67
            int r7 = r4 + 1
            int r9 = r6 >>> 4
            r9 = r9 & 15
            char r9 = r1[r9]     // Catch: java.lang.Exception -> L53 java.lang.Throwable -> L67
            r2[r4] = r9     // Catch: java.lang.Exception -> L53 java.lang.Throwable -> L67
            int r4 = r7 + 1
            r6 = r6 & 15
            char r6 = r1[r6]     // Catch: java.lang.Exception -> L53 java.lang.Throwable -> L67
            r2[r7] = r6     // Catch: java.lang.Exception -> L53 java.lang.Throwable -> L67
            int r8 = r8 + 1
            goto L2c
        L45:
            java.lang.String r10 = new java.lang.String     // Catch: java.lang.Exception -> L53 java.lang.Throwable -> L67
            r10.<init>(r2)     // Catch: java.lang.Exception -> L53 java.lang.Throwable -> L67
            r5.close()     // Catch: java.io.IOException -> L4e
            goto L52
        L4e:
            r0 = move-exception
            r0.printStackTrace()
        L52:
            return r10
        L53:
            r10 = move-exception
            goto L59
        L55:
            r10 = move-exception
            goto L69
        L57:
            r10 = move-exception
            r5 = r3
        L59:
            r10.printStackTrace()     // Catch: java.lang.Throwable -> L67
            if (r5 == 0) goto L66
            r5.close()     // Catch: java.io.IOException -> L62
            goto L66
        L62:
            r10 = move-exception
            r10.printStackTrace()
        L66:
            return r3
        L67:
            r10 = move-exception
            r3 = r5
        L69:
            if (r3 == 0) goto L73
            r3.close()     // Catch: java.io.IOException -> L6f
            goto L73
        L6f:
            r0 = move-exception
            r0.printStackTrace()
        L73:
            throw r10
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.smtt.utils.a.a(java.io.File):java.lang.String");
    }

    public static int a(Context context, File file) {
        try {
            return a(context, file, Build.VERSION.SDK_INT >= 20 ? !TbsExtensionFunctionManager.getInstance().canUseFunction(context, TbsExtensionFunctionManager.DISABLE_GET_APK_VERSION_SWITCH_FILE_NAME) : false);
        } catch (Exception unused) {
            TbsLog.i("ApkUtil", "getApkVersion Failed");
            return 0;
        }
    }

    private static int a(boolean z, File file) {
        try {
            File parentFile = file.getParentFile();
            if (parentFile == null) {
                return -1;
            }
            File[] listFiles = parentFile.listFiles();
            Pattern compile = Pattern.compile(a(z) + "(.*)");
            for (File file2 : listFiles) {
                if (compile.matcher(file2.getName()).find() && file2.isFile() && file2.exists()) {
                    return Integer.parseInt(file2.getName().substring(file2.getName().lastIndexOf(".") + 1));
                }
            }
            return -1;
        } catch (Exception unused) {
            return -1;
        }
    }

    public static int a(Context context, File file, boolean z) {
        if (file != null) {
            try {
                if (file.exists()) {
                    boolean contains = file.getName().contains("tbs.org");
                    boolean contains2 = file.getName().contains("x5.tbs.decouple");
                    if (contains || contains2) {
                        int a = a(contains2, file);
                        if (a > 0) {
                            return a;
                        }
                        if (!TbsShareManager.isThirdPartyApp(context) && !file.getAbsolutePath().contains(context.getApplicationInfo().packageName)) {
                            return 0;
                        }
                    }
                    int i = Build.VERSION.SDK_INT;
                    boolean z2 = (i == 23 || i == 25) && Build.MANUFACTURER.toLowerCase().contains("mi");
                    TbsPVConfig.releaseInstance();
                    int readApk = TbsPVConfig.getInstance(context).getReadApk();
                    if (readApk == 1) {
                        z = false;
                        z2 = false;
                    } else if (readApk == 2) {
                        return 0;
                    }
                    if (z || z2) {
                        int b = b(file);
                        if (b > 0) {
                            return b;
                        }
                    }
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
        if (file == null || !file.exists()) {
            return 0;
        }
        try {
            PackageInfo packageArchiveInfo = context.getPackageManager().getPackageArchiveInfo(file.getAbsolutePath(), 1);
            if (packageArchiveInfo != null) {
                return packageArchiveInfo.versionCode;
            }
            return 0;
        } catch (Throwable th2) {
            th2.printStackTrace();
            return -1;
        }
    }
}
