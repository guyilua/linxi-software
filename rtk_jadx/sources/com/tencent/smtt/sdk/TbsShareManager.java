package com.tencent.smtt.sdk;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.os.Looper;
import android.text.TextUtils;
import android.util.Log;
import com.tencent.smtt.sdk.TbsListener;
import com.tencent.smtt.utils.TbsLog;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class TbsShareManager {
    private static Context a = null;
    private static boolean b = false;

    /* renamed from: c, reason: collision with root package name */
    private static String f946c = null;
    private static String d = null;
    private static int e = 0;
    private static String f = null;
    private static boolean g = false;
    private static boolean h = false;
    private static boolean i = false;
    private static String j = null;
    private static boolean k = false;
    private static boolean l = false;
    public static boolean mHasQueryed = false;

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(Context context) {
        TbsLog.i("TbsShareManager", "shareTbsCore #1");
        try {
            TbsLinuxToolsJni tbsLinuxToolsJni = new TbsLinuxToolsJni(context);
            a(context, tbsLinuxToolsJni, l.a().q(context));
            File r = l.a().r(context);
            TbsLog.i("TbsShareManager", "shareTbsCore tbsShareDir is " + r.getAbsolutePath());
            tbsLinuxToolsJni.a(r.getAbsolutePath(), "755");
        } catch (Throwable th) {
            TbsLog.i("TbsShareManager", "shareTbsCore tbsShareDir error is " + th.getMessage() + " ## " + th.getCause());
            th.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void b(Context context) {
        try {
            a(context, new TbsLinuxToolsJni(context), l.a().p(context));
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String c(Context context) {
        j(context);
        return d;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int d(Context context) {
        return a(context, true);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Context e(Context context) {
        j(context);
        String str = f;
        Context context2 = null;
        if (str != null) {
            Context packageContext = getPackageContext(context, str, true);
            if (l.a().f(packageContext)) {
                context2 = packageContext;
            }
        }
        return f946c != null ? a : context2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static synchronized String f(Context context) {
        BufferedInputStream bufferedInputStream;
        synchronized (TbsShareManager.class) {
            try {
                File tbsShareFile = getTbsShareFile(context, "core_info");
                if (tbsShareFile == null) {
                    return null;
                }
                bufferedInputStream = new BufferedInputStream(new FileInputStream(tbsShareFile));
                try {
                    Properties properties = new Properties();
                    properties.load(bufferedInputStream);
                    String property = properties.getProperty("core_packagename", "");
                    if (!"".equals(property)) {
                        try {
                            bufferedInputStream.close();
                        } catch (Exception unused) {
                        }
                        return property;
                    }
                    try {
                        bufferedInputStream.close();
                    } catch (Exception unused2) {
                    }
                    return null;
                } catch (Throwable th) {
                    th = th;
                    try {
                        th.printStackTrace();
                        if (bufferedInputStream != null) {
                            try {
                                bufferedInputStream.close();
                            } catch (Exception unused3) {
                            }
                        }
                        return null;
                    } catch (Throwable th2) {
                        if (bufferedInputStream != null) {
                            try {
                                bufferedInputStream.close();
                            } catch (Exception unused4) {
                            }
                        }
                        throw th2;
                    }
                }
            } catch (Throwable th3) {
                th = th3;
                bufferedInputStream = null;
            }
        }
    }

    public static int findCoreForThirdPartyApp(Context context) {
        n(context);
        TbsLog.i("TbsShareManager", "core_info mAvailableCoreVersion is " + e + " mAvailableCorePath is " + d + " mSrcPackageName is " + f);
        if (f == null) {
            TbsLog.e("TbsShareManager", "mSrcPackageName is null !!!");
        }
        String str = f;
        if (str != null && str.equals("AppDefined")) {
            if (e != l.a().a(f946c)) {
                e = 0;
                d = null;
                f = null;
                TbsLog.i("TbsShareManager", "check AppDefined core is error src is " + e + " dest is " + l.a().a(f946c));
            }
        } else if (!k(context) && !l(context)) {
            e = 0;
            d = null;
            f = null;
            TbsLog.i("TbsShareManager", "core_info error checkCoreInfo is false and checkCoreInOthers is false ");
        }
        if (e > 0) {
            ApplicationInfo applicationInfo = context.getApplicationInfo();
            if ((!("com.tencent.android.qqdownloader".equals(applicationInfo.packageName) || "com.jd.jrapp".equals(applicationInfo.packageName)) ? QbSdk.a(context, e) : false) || g) {
                e = 0;
                d = null;
                f = null;
                TbsLog.i("TbsShareManager", "core_info error QbSdk.isX5Disabled ");
            }
        }
        return e;
    }

    public static boolean forceLoadX5FromTBSDemo(Context context) {
        int sharedTbsCoreVersion;
        if (context == null || l.a().a(context, (File[]) null) || (sharedTbsCoreVersion = getSharedTbsCoreVersion(context, TbsConfig.APP_DEMO)) <= 0) {
            return false;
        }
        writeProperties(context, Integer.toString(sharedTbsCoreVersion), TbsConfig.APP_DEMO, l.a().q(getPackageContext(context, TbsConfig.APP_DEMO, true)).getAbsolutePath(), "1");
        return true;
    }

    public static void forceToLoadX5ForThirdApp(Context context, boolean z) {
        File r;
        int a2;
        try {
            if (QbSdk.isNeedInitX5FirstTime() && isThirdPartyApp(context) && !QbSdk.getOnlyDownload() && (r = l.a().r(context)) != null) {
                if (z && new File(r, "core_info").exists()) {
                    return;
                }
                if (f946c != null && (a2 = l.a().a(f946c)) > 0) {
                    d = f946c;
                    f = "AppDefined";
                    e = a2;
                    TbsLog.i("TbsShareManager", "forceToLoadX5ForThirdApp #1 -- mAvailableCoreVersion: " + e + " " + Log.getStackTraceString(new Throwable("#")));
                    writeProperties(context, Integer.toString(e), f, d, Integer.toString(1));
                    return;
                }
                TbsLog.i("TbsShareManager", "forceToLoadX5ForThirdApp #1");
                int h2 = h(context);
                int i2 = l.a().i(context);
                TbsLog.i("TbsShareManager", "forceToLoadX5ForThirdApp coreVersionFromConfig is " + h2);
                TbsLog.i("TbsShareManager", "forceToLoadX5ForThirdApp coreVersionFromCoreShare is " + i2);
                String[] coreProviderAppList = getCoreProviderAppList();
                for (String str : coreProviderAppList) {
                    int coreShareDecoupleCoreVersion = getCoreShareDecoupleCoreVersion(context, str);
                    if (coreShareDecoupleCoreVersion >= h2 && coreShareDecoupleCoreVersion >= i2 && coreShareDecoupleCoreVersion > 0) {
                        d = l.a().c(context, getPackageContext(context, str, true)).getAbsolutePath();
                        f = str;
                        e = coreShareDecoupleCoreVersion;
                        TbsLog.i("TbsShareManager", "forceToLoadX5ForThirdApp #2 -- mAvailableCoreVersion: " + e + " " + Log.getStackTraceString(new Throwable("#")));
                        if (QbSdk.canLoadX5FirstTimeThirdApp(context)) {
                            int b2 = com.tencent.smtt.utils.b.b(context);
                            TbsLog.i("TbsShareManager", "forceToLoadX5ForThirdApp #2");
                            writeProperties(context, Integer.toString(e), f, d, Integer.toString(b2));
                            return;
                        } else {
                            e = 0;
                            d = null;
                            f = null;
                        }
                    }
                }
                for (String str2 : coreProviderAppList) {
                    int sharedTbsCoreVersion = getSharedTbsCoreVersion(context, str2);
                    if (sharedTbsCoreVersion >= h2 && sharedTbsCoreVersion >= i2 && sharedTbsCoreVersion > 0) {
                        d = l.a().b(context, getPackageContext(context, str2, true)).getAbsolutePath();
                        f = str2;
                        e = sharedTbsCoreVersion;
                        TbsLog.i("TbsShareManager", "forceToLoadX5ForThirdApp #3 -- mAvailableCoreVersion: " + e + " " + Log.getStackTraceString(new Throwable("#")));
                        if (QbSdk.canLoadX5FirstTimeThirdApp(context)) {
                            writeProperties(context, Integer.toString(e), f, d, Integer.toString(com.tencent.smtt.utils.b.b(context)));
                            return;
                        } else {
                            e = 0;
                            d = null;
                            f = null;
                        }
                    }
                }
                if (TbsPVConfig.getInstance(a).isDisableHostBackupCore()) {
                    return;
                }
                if (Thread.currentThread() != Looper.getMainLooper().getThread()) {
                    for (String str3 : coreProviderAppList) {
                        int backupCoreVersion = getBackupCoreVersion(context, str3);
                        if (backupCoreVersion >= h2 && backupCoreVersion >= i2 && backupCoreVersion > 0) {
                            TbsLog.i("TbsShareManager", "find host backup core to unzip forceload coreVersion is " + backupCoreVersion + " packageName is " + str3);
                            l.a().a(context, getBackupCoreFile(context, str3), backupCoreVersion);
                            TbsLog.i("TbsShareManager", "find host backup core to unzip forceload after unzip ");
                            return;
                        }
                        int backupDecoupleCoreVersion = getBackupDecoupleCoreVersion(context, str3);
                        if (backupDecoupleCoreVersion >= h2 && backupDecoupleCoreVersion >= i2 && backupDecoupleCoreVersion > 0) {
                            TbsLog.i("TbsShareManager", "find host backup core to unzip forceload decouple coreVersion is " + backupDecoupleCoreVersion + " packageName is " + str3);
                            l.a().a(context, getBackupCoreFile(context, str3), backupDecoupleCoreVersion);
                            TbsLog.i("TbsShareManager", "find host backup decouple core to unzip forceload after unzip ");
                            return;
                        }
                    }
                    return;
                }
                TbsLog.i("TbsShareManager", "in mainthread so do not find host backup core to install ");
            }
        } catch (Exception unused) {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String g(Context context) {
        try {
            n(context);
            String str = d;
            if (str != null && !TextUtils.isEmpty(str)) {
                return d + File.separator + "res.apk";
            }
            return null;
        } catch (Throwable th) {
            Log.e("", "getTbsResourcesPath exception: " + Log.getStackTraceString(th));
            return null;
        }
    }

    public static File getBackupCoreFile(Context context, String str) {
        try {
            File file = new File(new File(com.tencent.smtt.utils.f.a(getPackageContext(context, str, false), 4)), "x5.tbs.org");
            if (file.exists()) {
                return file;
            }
            return null;
        } catch (Throwable unused) {
            return null;
        }
    }

    public static int getBackupCoreVersion(Context context, String str) {
        try {
            File file = new File(new File(com.tencent.smtt.utils.f.a(getPackageContext(context, str, false), 4)), "x5.tbs.org");
            if (file.exists()) {
                return com.tencent.smtt.utils.a.b(file);
            }
        } catch (Throwable unused) {
        }
        return 0;
    }

    public static File getBackupDecoupleCoreFile(Context context, String str) {
        try {
            File file = new File(new File(com.tencent.smtt.utils.f.a(getPackageContext(context, str, true), 4)), "x5.tbs.decouple");
            if (file.exists()) {
                return file;
            }
            return null;
        } catch (Throwable unused) {
            return null;
        }
    }

    public static int getBackupDecoupleCoreVersion(Context context, String str) {
        try {
            File file = new File(new File(com.tencent.smtt.utils.f.a(getPackageContext(context, str, false), 4)), "x5.tbs.decouple");
            if (file.exists()) {
                return com.tencent.smtt.utils.a.b(file);
            }
        } catch (Throwable unused) {
        }
        return 0;
    }

    public static boolean getCoreDisabled() {
        return g;
    }

    public static boolean getCoreFormOwn() {
        return k;
    }

    public static String[] getCoreProviderAppList() {
        return new String[]{TbsConfig.APP_DEMO, "com.tencent.mm", TbsConfig.APP_QQ, TbsConfig.APP_QZONE};
    }

    public static int getCoreShareDecoupleCoreVersion(Context context, String str) {
        Context packageContext = getPackageContext(context, str, true);
        if (packageContext != null) {
            return l.a().h(packageContext);
        }
        return 0;
    }

    public static String getHostCorePathAppDefined() {
        return f946c;
    }

    public static long getHostCoreVersions(Context context) {
        long sharedTbsCoreVersion;
        long sharedTbsCoreVersion2;
        long j2;
        long j3 = 0;
        for (String str : getCoreProviderAppList()) {
            if (str.equalsIgnoreCase("com.tencent.mm")) {
                sharedTbsCoreVersion2 = getSharedTbsCoreVersion(context, str);
                j2 = 10000000000L;
            } else if (str.equalsIgnoreCase(TbsConfig.APP_QQ)) {
                sharedTbsCoreVersion2 = getSharedTbsCoreVersion(context, str);
                j2 = 100000;
            } else if (str.equalsIgnoreCase(TbsConfig.APP_QZONE)) {
                sharedTbsCoreVersion = getSharedTbsCoreVersion(context, str);
                j3 += sharedTbsCoreVersion;
            }
            sharedTbsCoreVersion = sharedTbsCoreVersion2 * j2;
            j3 += sharedTbsCoreVersion;
        }
        return j3;
    }

    public static Context getPackageContext(Context context, String str, boolean z) {
        if (z) {
            try {
                if (!context.getPackageName().equals(str) && TbsPVConfig.getInstance(context).isEnableNoCoreGray()) {
                    TbsLog.i("TbsShareManager", "gray no core app,skip get context");
                    return null;
                }
            } catch (PackageManager.NameNotFoundException unused) {
                return null;
            } catch (Exception e2) {
                e2.printStackTrace();
                return null;
            }
        }
        return context.createPackageContext(str, 2);
    }

    public static int getSharedTbsCoreVersion(Context context, String str) {
        Context packageContext = getPackageContext(context, str, true);
        if (packageContext != null) {
            return l.a().i(packageContext);
        }
        return 0;
    }

    public static File getTbsShareFile(Context context, String str) {
        File r = l.a().r(context);
        if (r == null) {
            return null;
        }
        File file = new File(r, str);
        if (file.exists()) {
            return file;
        }
        try {
            file.createNewFile();
            return file;
        } catch (IOException e2) {
            e2.printStackTrace();
            return null;
        }
    }

    static synchronized int h(Context context) {
        synchronized (TbsShareManager.class) {
            TbsLog.i("TbsShareManager", "readCoreVersionFromConfig #1");
            BufferedInputStream bufferedInputStream = null;
            try {
                File tbsShareFile = getTbsShareFile(context, "core_info");
                if (tbsShareFile == null) {
                    TbsLog.i("TbsShareManager", "readCoreVersionFromConfig #2");
                    return 0;
                }
                BufferedInputStream bufferedInputStream2 = new BufferedInputStream(new FileInputStream(tbsShareFile));
                try {
                    Properties properties = new Properties();
                    properties.load(bufferedInputStream2);
                    String property = properties.getProperty("core_version", "");
                    if (!"".equals(property)) {
                        TbsLog.i("TbsShareManager", "readCoreVersionFromConfig #3");
                        int max = Math.max(Integer.parseInt(property), 0);
                        try {
                            bufferedInputStream2.close();
                        } catch (Exception e2) {
                            e2.printStackTrace();
                        }
                        return max;
                    }
                    TbsLog.i("TbsShareManager", "readCoreVersionFromConfig #4");
                    try {
                        bufferedInputStream2.close();
                    } catch (Exception e3) {
                        e3.printStackTrace();
                    }
                    return 0;
                } catch (Throwable th) {
                    bufferedInputStream = bufferedInputStream2;
                    th = th;
                    try {
                        th.printStackTrace();
                        TbsLog.i("TbsShareManager", "readCoreVersionFromConfig #5");
                        return -2;
                    } finally {
                        if (bufferedInputStream != null) {
                            try {
                                bufferedInputStream.close();
                            } catch (Exception e4) {
                                e4.printStackTrace();
                            }
                        }
                    }
                }
            } catch (Throwable th2) {
                th = th2;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean i(Context context) {
        try {
            if (e == 0) {
                findCoreForThirdPartyApp(context);
            }
            int i2 = e;
            if (i2 == 0) {
                TbsLog.addLog(TbsLog.TBSLOG_CODE_SDK_NO_SHARE_X5CORE, null, new Object[0]);
                return false;
            }
            if (f946c == null) {
                if (i2 != 0 && getSharedTbsCoreVersion(context, f) == e) {
                    return true;
                }
            } else if (i2 != 0 && l.a().a(f946c) == e) {
                return true;
            }
            if (l(context)) {
                return true;
            }
            TbsCoreLoadStat.getInstance().a(context, TbsListener.ErrorCode.INFO_CORE_EXIST_NOT_LOAD, new Throwable("mAvailableCoreVersion=" + e + "; mSrcPackageName=" + f + "; getSharedTbsCoreVersion(ctx, mSrcPackageName) is " + getSharedTbsCoreVersion(context, f) + "; getHostCoreVersions is " + getHostCoreVersions(context)));
            d = null;
            e = 0;
            TbsLog.addLog(TbsLog.TBSLOG_CODE_SDK_CONFLICT_X5CORE, null, new Object[0]);
            QbSdk.a(context, "TbsShareManager::isShareTbsCoreAvailableInner forceSysWebViewInner!");
            return false;
        } catch (Throwable th) {
            th.printStackTrace();
            TbsLog.addLog(TbsLog.TBSLOG_CODE_SDK_UNAVAIL_X5CORE, null, new Object[0]);
            return false;
        }
    }

    public static boolean isThirdPartyApp(Context context) {
        Context context2;
        try {
            context2 = a;
        } catch (Throwable th) {
            th.printStackTrace();
        }
        if (context2 != null && context2.equals(context.getApplicationContext())) {
            return b;
        }
        Context applicationContext = context.getApplicationContext();
        a = applicationContext;
        String packageName = applicationContext.getPackageName();
        for (String str : getCoreProviderAppList()) {
            if (packageName.equals(str)) {
                b = false;
                return false;
            }
        }
        b = true;
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean j(Context context) {
        return b(context, true);
    }

    private static boolean k(Context context) {
        String str = f;
        if (str == null) {
            return false;
        }
        return e == getSharedTbsCoreVersion(context, str) || e == getCoreShareDecoupleCoreVersion(context, f);
    }

    private static boolean l(Context context) {
        if (QbSdk.getOnlyDownload()) {
            return false;
        }
        String[] coreProviderAppList = getCoreProviderAppList();
        for (String str : coreProviderAppList) {
            int i2 = e;
            if (i2 > 0 && i2 == getSharedTbsCoreVersion(context, str)) {
                Context packageContext = getPackageContext(context, str, true);
                if (l.a().f(context)) {
                    d = l.a().b(context, packageContext).getAbsolutePath();
                    f = str;
                    return true;
                }
            }
        }
        for (String str2 : coreProviderAppList) {
            int i3 = e;
            if (i3 > 0 && i3 == getCoreShareDecoupleCoreVersion(context, str2)) {
                Context packageContext2 = getPackageContext(context, str2, true);
                if (l.a().f(context)) {
                    d = l.a().c(context, packageContext2).getAbsolutePath();
                    f = str2;
                    return true;
                }
            }
        }
        return false;
    }

    private static boolean m(Context context) {
        if (context == null) {
            return false;
        }
        writeProperties(context, Integer.toString(0), "", "", Integer.toString(0));
        return true;
    }

    private static void n(Context context) {
        Throwable th;
        BufferedInputStream bufferedInputStream;
        File tbsShareFile;
        Context context2;
        if (l) {
            return;
        }
        synchronized (TbsShareManager.class) {
            if (l) {
                return;
            }
            try {
                tbsShareFile = getTbsShareFile(context, "core_info");
            } catch (Throwable th2) {
                th = th2;
                bufferedInputStream = null;
            }
            if (tbsShareFile == null) {
                return;
            }
            bufferedInputStream = new BufferedInputStream(new FileInputStream(tbsShareFile));
            try {
                Properties properties = new Properties();
                properties.load(bufferedInputStream);
                String property = properties.getProperty("core_version", "");
                if (!"".equals(property)) {
                    e = Math.max(Integer.parseInt(property), 0);
                    TbsLog.i("TbsShareManager", "loadProperties -- mAvailableCoreVersion: " + e + " " + Log.getStackTraceString(new Throwable("#")));
                }
                String property2 = properties.getProperty("core_packagename", "");
                if (!"".equals(property2)) {
                    f = property2;
                }
                String str = f;
                if (str != null && (context2 = a) != null) {
                    if (str.equals(context2.getPackageName())) {
                        k = true;
                    } else {
                        k = false;
                    }
                }
                String property3 = properties.getProperty("core_path", "");
                if (!"".equals(property3)) {
                    d = property3;
                }
                String property4 = properties.getProperty("app_version", "");
                if (!"".equals(property4)) {
                    j = property4;
                }
                g = Boolean.parseBoolean(properties.getProperty("core_disabled", "false"));
                l = true;
            } catch (Throwable th3) {
                th = th3;
                try {
                    th.printStackTrace();
                    if (bufferedInputStream != null) {
                        try {
                            bufferedInputStream.close();
                        } catch (Exception e2) {
                            e = e2;
                            e.printStackTrace();
                        }
                    }
                } finally {
                }
            }
            try {
                bufferedInputStream.close();
            } catch (Exception e3) {
                e = e3;
                e.printStackTrace();
            }
        }
    }

    public static void setHostCorePathAppDefined(String str) {
        f946c = str;
    }

    /* JADX WARN: Removed duplicated region for block: B:95:0x02e5 A[ADDED_TO_REGION] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static synchronized void writeCoreInfoForThirdPartyApp(android.content.Context r11, int r12, boolean r13) {
        /*
            Method dump skipped, instructions count: 751
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.smtt.sdk.TbsShareManager.writeCoreInfoForThirdPartyApp(android.content.Context, int, boolean):void");
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:64:0x00e1 -> B:24:0x00e4). Please report as a decompilation issue!!! */
    public static void writeProperties(Context context, String str, String str2, String str3, String str4) {
        BufferedOutputStream bufferedOutputStream;
        File tbsShareFile;
        int i2;
        TbsLog.i("TbsShareManager", "writeProperties coreVersion is " + str + " corePackageName is " + str2 + " corePath is " + str3);
        StringBuilder sb = new StringBuilder();
        sb.append("writeProperties -- stack: ");
        sb.append(Log.getStackTraceString(new Throwable("#")));
        TbsLog.i("TbsShareManager", sb.toString());
        BufferedInputStream bufferedInputStream = null;
        try {
            try {
                tbsShareFile = getTbsShareFile(context, "core_info");
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        } catch (Throwable th) {
            th = th;
            bufferedOutputStream = null;
        }
        if (tbsShareFile == null) {
            TbsDownloadConfig.getInstance(a).setDownloadInterruptCode(-405);
            return;
        }
        BufferedInputStream bufferedInputStream2 = new BufferedInputStream(new FileInputStream(tbsShareFile));
        try {
            Properties properties = new Properties();
            properties.load(bufferedInputStream2);
            try {
                i2 = Integer.parseInt(str);
            } catch (Exception unused) {
                i2 = 0;
            }
            if (i2 != 0) {
                properties.setProperty("core_version", str);
                properties.setProperty("core_disabled", String.valueOf(false));
                properties.setProperty("core_packagename", str2);
                properties.setProperty("core_path", str3);
                properties.setProperty("app_version", str4);
            } else {
                properties.setProperty("core_disabled", String.valueOf(true));
            }
            BufferedOutputStream bufferedOutputStream2 = new BufferedOutputStream(new FileOutputStream(tbsShareFile));
            try {
                properties.store(bufferedOutputStream2, (String) null);
                l = false;
                TbsDownloadConfig.getInstance(a).setDownloadInterruptCode(-406);
                try {
                    bufferedInputStream2.close();
                } catch (Exception e3) {
                    e3.printStackTrace();
                }
                bufferedOutputStream2.close();
            } catch (Throwable th2) {
                bufferedInputStream = bufferedInputStream2;
                bufferedOutputStream = bufferedOutputStream2;
                th = th2;
                try {
                    th.printStackTrace();
                    if (bufferedInputStream != null) {
                        try {
                            bufferedInputStream.close();
                        } catch (Exception e4) {
                            e4.printStackTrace();
                        }
                    }
                    if (bufferedOutputStream != null) {
                        bufferedOutputStream.close();
                    }
                } finally {
                }
            }
        } catch (Throwable th3) {
            th = th3;
            bufferedOutputStream = null;
            bufferedInputStream = bufferedInputStream2;
        }
    }

    private static String[] d(Context context, boolean z) {
        if (QbSdk.getOnlyDownload()) {
            return new String[]{context.getApplicationContext().getPackageName()};
        }
        return z ? new String[]{context.getApplicationContext().getPackageName()} : getCoreProviderAppList();
    }

    private static void c(Context context, boolean z) {
        BufferedOutputStream bufferedOutputStream;
        File tbsShareFile;
        BufferedInputStream bufferedInputStream = null;
        try {
            tbsShareFile = getTbsShareFile(context, "core_info");
        } catch (Throwable th) {
            th = th;
            bufferedOutputStream = null;
        }
        if (tbsShareFile == null) {
            return;
        }
        BufferedInputStream bufferedInputStream2 = new BufferedInputStream(new FileInputStream(tbsShareFile));
        try {
            Properties properties = new Properties();
            properties.load(bufferedInputStream2);
            properties.setProperty("core_disabled", String.valueOf(false));
            if (z) {
                String absolutePath = l.a().q(context).getAbsolutePath();
                String packageName = context.getApplicationContext().getPackageName();
                int b2 = com.tencent.smtt.utils.b.b(context);
                properties.setProperty("core_packagename", packageName);
                properties.setProperty("core_path", absolutePath);
                properties.setProperty("app_version", String.valueOf(b2));
            }
            bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(tbsShareFile));
            try {
                properties.store(bufferedOutputStream, (String) null);
                try {
                    bufferedInputStream2.close();
                } catch (Exception unused) {
                }
            } catch (Throwable th2) {
                th = th2;
                bufferedInputStream = bufferedInputStream2;
                try {
                    th.printStackTrace();
                    if (bufferedInputStream != null) {
                        try {
                            bufferedInputStream.close();
                        } catch (Exception unused2) {
                        }
                    }
                    if (bufferedOutputStream == null) {
                        return;
                    }
                    bufferedOutputStream.close();
                } finally {
                }
            }
        } catch (Throwable th3) {
            th = th3;
            bufferedOutputStream = null;
        }
        try {
            bufferedOutputStream.close();
        } catch (Exception unused3) {
        }
    }

    static boolean b(Context context, boolean z) {
        if (i(context)) {
            return true;
        }
        if (!z) {
            return false;
        }
        QbSdk.a(context, "TbsShareManager::isShareTbsCoreAvailable forceSysWebViewInner!");
        return false;
    }

    private static void a(Context context, TbsLinuxToolsJni tbsLinuxToolsJni, File file) {
        TbsLog.i("TbsShareManager", "shareAllDirsAndFiles #1");
        if (file != null && file.exists() && file.isDirectory()) {
            TbsLog.i("TbsShareManager", "shareAllDirsAndFiles dir is " + file.getAbsolutePath());
            tbsLinuxToolsJni.a(file.getAbsolutePath(), "755");
            for (File file2 : file.listFiles()) {
                if (file2.isFile()) {
                    if (file2.getAbsolutePath().indexOf(".so") > 0) {
                        tbsLinuxToolsJni.a(file2.getAbsolutePath(), "755");
                    } else {
                        tbsLinuxToolsJni.a(file2.getAbsolutePath(), "644");
                    }
                } else if (file2.isDirectory()) {
                    a(context, tbsLinuxToolsJni, file2);
                } else {
                    TbsLog.e("TbsShareManager", "unknown file type.", true);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String a() {
        return d;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int a(Context context, boolean z) {
        b(context, z);
        return e;
    }

    private static void a(Context context, int i2) {
        if (TbsPVConfig.getInstance(a).isDisableHostBackupCore() || !l.a().t(context)) {
            return;
        }
        String[] strArr = {TbsConfig.APP_DEMO, "com.tencent.mm", TbsConfig.APP_QQ, TbsConfig.APP_QZONE, context.getPackageName()};
        TbsLog.i("TbsShareManager", "find host backup core to unzip #1" + Log.getStackTraceString(new Throwable()));
        int i3 = 0;
        while (true) {
            if (i3 >= 5) {
                break;
            }
            String str = strArr[i3];
            if (i2 == getBackupCoreVersion(context, str)) {
                if (l.a().f(getPackageContext(context, str, false))) {
                    File backupCoreFile = getBackupCoreFile(context, str);
                    if (com.tencent.smtt.utils.a.a(context, backupCoreFile, 0L, i2)) {
                        TbsLog.i("TbsShareManager", "find host backup core to unzip normal coreVersion is " + i2 + " packageName is " + str);
                        l.a().b(context, backupCoreFile, i2);
                        break;
                    }
                } else {
                    continue;
                }
                i3++;
            } else {
                if (i2 == getBackupDecoupleCoreVersion(context, str) && l.a().f(getPackageContext(context, str, false))) {
                    File backupDecoupleCoreFile = getBackupDecoupleCoreFile(context, str);
                    if (com.tencent.smtt.utils.a.a(context, backupDecoupleCoreFile, 0L, i2)) {
                        TbsLog.i("TbsShareManager", "find host backup core to unzip decouple coreVersion is " + i2 + " packageName is " + str);
                        l.a().b(context, backupDecoupleCoreFile, i2);
                        break;
                    }
                }
                i3++;
            }
        }
        l.a().b();
    }
}
