package com.uc.crashsdk;

import android.os.Build;
import android.os.Bundle;
import com.sigmob.sdk.downloader.f;
import com.uc.crashsdk.export.CustomInfo;
import com.uc.crashsdk.export.VersionInfo;
import java.io.File;
import java.lang.reflect.Field;
import java.util.zip.ZipFile;

/* compiled from: ProGuard */
/* loaded from: /tmp/rtk_apk/classes3.dex */
public class g {
    public static RuntimeException a = null;
    public static RuntimeException b = null;

    /* renamed from: c, reason: collision with root package name */
    static final /* synthetic */ boolean f1006c = true;
    private static CustomInfo d;
    private static VersionInfo e;
    private static String g;
    private static String h;
    private static String i;
    private static String j;
    private static final Object f = new Object();
    private static final Object k = new Object();

    /* JADX INFO: Access modifiers changed from: package-private */
    public static long A() {
        return d.mMaxUploadBytesPerDay;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int B() {
        return d.mMaxUploadBuiltinLogCountPerDay;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int C() {
        return d.mMaxUploadCustomLogCountPerDay;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int D() {
        return d.mMaxCustomLogCountPerTypePerDay;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int E() {
        return d.mInfoUpdateInterval;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int F() {
        return d.mInfoSaveFrequency;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int G() {
        return d.mReservedJavaFileHandleCount;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int H() {
        return d.mFdDumpMinLimit;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int I() {
        return d.mThreadsDumpMinLimit;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean J() {
        return d.mAutoDetectLifeCycle;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean K() {
        return d.mMonitorBattery;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int L() {
        return d.mAnrTraceStrategy;
    }

    public static boolean M() {
        CustomInfo customInfo = d;
        return customInfo == null || customInfo.mDebug;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean N() {
        CustomInfo customInfo = d;
        return customInfo == null || customInfo.mPrintStackInfos;
    }

    public static boolean O() {
        return d.mEnableStatReport;
    }

    public static boolean P() {
        return d.mIsInternational;
    }

    public static boolean Q() {
        return d.mAddPvForNewDay;
    }

    public static String R() {
        if (com.uc.crashsdk.a.g.a(e.mVersion)) {
            return a.a();
        }
        return a(e.mVersion);
    }

    public static String S() {
        return com.uc.crashsdk.a.g.a(e.mSubVersion) ? "release" : e.mSubVersion;
    }

    public static String T() {
        if (com.uc.crashsdk.a.g.a(e.mBuildId)) {
            return X();
        }
        return a(e.mBuildId);
    }

    public static String U() {
        if (h == null) {
            h = com.uc.crashsdk.a.g.b() + File.separatorChar + d.mTagFilesFolderName + File.separatorChar;
        }
        return h;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String V() {
        if (i == null) {
            i = com.uc.crashsdk.a.g.b() + File.separatorChar + d.mCrashLogsFolderName + File.separatorChar;
        }
        return i;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String W() {
        if (j == null) {
            if (!com.uc.crashsdk.a.g.a(d.mLogsBackupPathName)) {
                String trim = d.mLogsBackupPathName.trim();
                String str = File.separator;
                if (!trim.endsWith(str)) {
                    trim = trim + str;
                }
                j = trim;
            } else {
                j = (com.uc.crashsdk.a.g.b() + File.separatorChar + "msdb" + File.separatorChar) + File.separatorChar + d.mCrashLogsFolderName + File.separatorChar;
            }
        }
        return j;
    }

    private static String X() {
        ZipFile zipFile;
        Throwable th;
        String str = g;
        if (str != null) {
            return str;
        }
        try {
            try {
                zipFile = new ZipFile(com.uc.crashsdk.a.g.c());
                try {
                    g = Long.toHexString(zipFile.getEntry("classes.dex").getCrc());
                    com.uc.crashsdk.a.a.a("crashsdk", "version unique build id: " + g);
                    zipFile.close();
                } catch (Throwable th2) {
                    th = th2;
                    try {
                        g = "";
                        com.uc.crashsdk.a.g.a(th);
                        if (zipFile != null) {
                            zipFile.close();
                        }
                        return g;
                    } catch (Throwable th3) {
                        if (zipFile != null) {
                            try {
                                zipFile.close();
                            } catch (Throwable unused) {
                            }
                        }
                        throw th3;
                    }
                }
            } catch (Throwable unused2) {
            }
        } catch (Throwable th4) {
            zipFile = null;
            th = th4;
        }
        return g;
    }

    private static void Y() {
        if (b.d) {
            JNIBridge.nativeSet(24, 1L, a.b, null);
        }
    }

    public static void a(CustomInfo customInfo, VersionInfo versionInfo) {
        CustomInfo customInfo2 = new CustomInfo(customInfo);
        d = customInfo2;
        c(customInfo2);
        if (!d.mZipLog) {
            a = new RuntimeException("initialize set mZipLog to false, info.mZipLog: " + customInfo.mZipLog);
        }
        if (d.mEncryptLog) {
            b = new RuntimeException("initialize set mEncryptLog to true, info.mEncryptLog: " + customInfo.mEncryptLog);
        }
        e = new VersionInfo(versionInfo);
        if (b.I()) {
            return;
        }
        try {
            a();
        } catch (Throwable th) {
            com.uc.crashsdk.a.g.a(th);
        }
    }

    public static void b() {
        JNIBridge.set(103, com.uc.crashsdk.a.g.b());
        JNIBridge.set(104, d.mTagFilesFolderName);
        JNIBridge.set(105, d.mCrashLogsFolderName);
        JNIBridge.set(106, W());
        JNIBridge.set(107, e.h());
        JNIBridge.set(108, b.a());
        JNIBridge.set(109, R());
        JNIBridge.set(110, S());
        JNIBridge.set(111, T());
        JNIBridge.set(112, "210105150455");
        JNIBridge.set(116, Build.MODEL);
        JNIBridge.set(117, Build.VERSION.RELEASE);
        JNIBridge.set(118, e.p());
        JNIBridge.set(5, d.mCallNativeDefaultHandler);
        JNIBridge.set(6, d.mDumpUserSolibBuildId);
        JNIBridge.set(7, d.mReservedNativeMemoryBytes);
        JNIBridge.set(100, d.mNativeCrashLogFileName);
        JNIBridge.set(101, d.mUnexpCrashLogFileName);
        JNIBridge.set(102, d.mAppId);
    }

    private static void c(CustomInfo customInfo) {
        if (customInfo.mZippedLogExtension == null) {
            customInfo.mZippedLogExtension = "";
        }
        if (!customInfo.mZippedLogExtension.equals(".tmp")) {
            if (customInfo.mOmitJavaCrash) {
                customInfo.mCallJavaDefaultHandler = false;
            }
            if (customInfo.mOmitNativeCrash) {
                customInfo.mCallNativeDefaultHandler = false;
            }
            long b2 = e.b();
            if (b2 >= 1) {
                customInfo.mMaxBuiltinLogFilesCount = 200;
                customInfo.mMaxCustomLogFilesCount = 100;
                customInfo.mMaxUploadBytesPerDay = 268435456L;
                customInfo.mMaxUploadBuiltinLogCountPerDay = f.a.f;
                customInfo.mMaxUploadCustomLogCountPerDay = f.a.f;
                customInfo.mMaxCustomLogCountPerTypePerDay = 100;
                customInfo.mMaxAnrLogCountPerProcess = 100;
                customInfo.mAnrTraceStrategy = 2;
                if (b2 >= 2) {
                    customInfo.mSyncUploadSetupCrashLogs = true;
                    customInfo.mSyncUploadLogs = true;
                    if (b2 >= 3) {
                        customInfo.mBackupLogs = true;
                        customInfo.mPrintStackInfos = true;
                        customInfo.mDebug = true;
                        return;
                    }
                    return;
                }
                return;
            }
            return;
        }
        throw new IllegalArgumentException("mZippedLogExtension can not be '.tmp'!");
    }

    public static void d() {
        JNIBridge.set(23, d.mIsInternational);
        if (b.E()) {
            JNIBridge.set(34, true);
        }
        if (e.i()) {
            JNIBridge.set(1, true);
        }
        JNIBridge.set(10, d.mFdDumpMinLimit);
        JNIBridge.nativeCmd(3, d.mReservedNativeFileHandleCount, null, null);
        JNIBridge.nativeSetForeground(b.y());
        JNIBridge.set(2, b.C());
        a.e();
        a.g();
        a.i();
        a.k();
        JNIBridge.set(113, a.a);
        JNIBridge.cmd(1);
        JNIBridge.set(22, d.mThreadsDumpMinLimit);
        JNIBridge.set(122, a.a());
        JNIBridge.set(33, a.c());
        Y();
        b.H();
        b.A();
        com.uc.crashsdk.a.g.k();
    }

    public static String e() {
        return d.mAppId;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean f() {
        if (com.uc.crashsdk.a.g.b(d.mJavaCrashLogFileName) || com.uc.crashsdk.a.g.b(d.mNativeCrashLogFileName)) {
            return true;
        }
        return com.uc.crashsdk.a.g.b(d.mUnexpCrashLogFileName);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String g() {
        return d.mJavaCrashLogFileName;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int h() {
        return d.mCrashRestartInterval;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean i() {
        return d.mCallJavaDefaultHandler;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean j() {
        return d.mDumpHprofDataForJavaOOM;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean k() {
        return d.mRenameFileToDefaultName;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int l() {
        return d.mMaxBuiltinLogFilesCount;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int m() {
        return d.mMaxCustomLogFilesCount;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int n() {
        return d.mMaxJavaLogcatLineCount;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int o() {
        return d.mUnexpDelayMillSeconds;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int p() {
        return d.mUnexpSubTypes;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean q() {
        return d.mBackupLogs;
    }

    public static boolean r() {
        return d.mSyncUploadSetupCrashLogs;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean s() {
        return d.mSyncUploadLogs;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean t() {
        return d.mOmitJavaCrash;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean u() {
        return d.mAutoDeleteOldVersionStats;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean v() {
        return d.mZipLog;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String w() {
        return d.mZippedLogExtension;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean x() {
        return d.mEncryptLog;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int y() {
        return d.mLogMaxBytesLimit;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int z() {
        return d.mLogMaxUploadBytesLimit;
    }

    public static void a(CustomInfo customInfo) {
        boolean z = f1006c;
        if (!z && customInfo.mTagFilesFolderName == null) {
            throw new AssertionError();
        }
        if (!z && customInfo.mCrashLogsFolderName == null) {
            throw new AssertionError();
        }
        if (customInfo.mTagFilesFolderName.equals(customInfo.mCrashLogsFolderName)) {
            throw new IllegalArgumentException("mTagFilesFolderName and mCrashLogsFolderName can not be set to the same!");
        }
    }

    public static void a(VersionInfo versionInfo) {
        synchronized (f) {
            e = new VersionInfo(versionInfo);
            e.c();
            if (b.d) {
                JNIBridge.set(109, R());
                JNIBridge.set(110, S());
                JNIBridge.set(111, T());
                JNIBridge.set(112, "210105150455");
                JNIBridge.cmd(2);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a() {
        b.v();
        b.u();
        if (d.mBackupLogs) {
            File file = new File(W());
            if (file.exists()) {
                return;
            }
            file.mkdirs();
        }
    }

    public static int b(CustomInfo customInfo) {
        int i2;
        int i3;
        boolean z;
        boolean z2;
        synchronized (k) {
            i2 = 0;
            if (customInfo != null) {
                c(customInfo);
                if (d == null) {
                    d = new CustomInfo();
                }
                CustomInfo customInfo2 = d;
                boolean z3 = true;
                if (a(customInfo.mAppId, customInfo2.mAppId)) {
                    i3 = 0;
                    z = false;
                } else {
                    String str = customInfo.mAppId;
                    customInfo2.mAppId = str;
                    if (b.d) {
                        JNIBridge.set(102, str);
                    }
                    i3 = 1;
                    z = true;
                }
                if (!a(customInfo.mJavaCrashLogFileName, customInfo2.mJavaCrashLogFileName)) {
                    customInfo2.mJavaCrashLogFileName = customInfo.mJavaCrashLogFileName;
                    i3++;
                }
                if (!a(customInfo.mNativeCrashLogFileName, customInfo2.mNativeCrashLogFileName)) {
                    String str2 = customInfo.mNativeCrashLogFileName;
                    customInfo2.mNativeCrashLogFileName = str2;
                    if (b.d) {
                        JNIBridge.set(100, str2);
                    }
                    i3++;
                    z = true;
                }
                if (!a(customInfo.mUnexpCrashLogFileName, customInfo2.mUnexpCrashLogFileName)) {
                    String str3 = customInfo.mUnexpCrashLogFileName;
                    customInfo2.mUnexpCrashLogFileName = str3;
                    if (b.d) {
                        JNIBridge.set(101, str3);
                    }
                    i3++;
                    z = true;
                }
                if (z) {
                    e.c();
                    if (b.d) {
                        JNIBridge.cmd(2);
                    }
                }
                boolean z4 = customInfo2.mPrintStackInfos;
                boolean z5 = customInfo.mPrintStackInfos;
                if (z4 != z5) {
                    customInfo2.mPrintStackInfos = z5;
                    if (b.d) {
                        JNIBridge.set(11, z5);
                    }
                    i3++;
                }
                boolean z6 = customInfo2.mDebug;
                boolean z7 = customInfo.mDebug;
                if (z6 != z7) {
                    customInfo2.mDebug = z7;
                    if (b.d) {
                        JNIBridge.set(18, z7);
                    }
                    i3++;
                }
                boolean z8 = customInfo2.mBackupLogs;
                boolean z9 = customInfo.mBackupLogs;
                if (z8 != z9) {
                    customInfo2.mBackupLogs = z9;
                    if (b.d) {
                        JNIBridge.set(12, z9);
                    }
                    i3++;
                }
                boolean z10 = customInfo2.mOmitNativeCrash;
                boolean z11 = customInfo.mOmitNativeCrash;
                if (z10 != z11) {
                    customInfo2.mOmitNativeCrash = z11;
                    if (b.d) {
                        JNIBridge.set(21, z11);
                    }
                    i3++;
                }
                int i4 = customInfo2.mCrashRestartInterval;
                int i5 = customInfo.mCrashRestartInterval;
                if (i4 != i5) {
                    customInfo2.mCrashRestartInterval = i5;
                    if (b.d) {
                        JNIBridge.set(13, i5);
                    }
                    if (customInfo2.mCrashRestartInterval >= 0) {
                        b.J();
                    }
                    i3++;
                }
                int i6 = customInfo2.mMaxBuiltinLogFilesCount;
                int i7 = customInfo.mMaxBuiltinLogFilesCount;
                if (i6 != i7) {
                    customInfo2.mMaxBuiltinLogFilesCount = i7;
                    if (b.d) {
                        JNIBridge.set(14, i7);
                    }
                    i3++;
                }
                int i8 = customInfo2.mMaxNativeLogcatLineCount;
                int i9 = customInfo.mMaxNativeLogcatLineCount;
                if (i8 != i9) {
                    customInfo2.mMaxNativeLogcatLineCount = i9;
                    if (b.d) {
                        JNIBridge.set(15, i9);
                    }
                    i3++;
                }
                int i10 = customInfo2.mMaxJavaLogcatLineCount;
                int i11 = customInfo.mMaxJavaLogcatLineCount;
                if (i10 != i11) {
                    customInfo2.mMaxJavaLogcatLineCount = i11;
                    i3++;
                }
                int i12 = customInfo2.mMaxUnexpLogcatLineCount;
                int i13 = customInfo.mMaxUnexpLogcatLineCount;
                if (i12 != i13) {
                    customInfo2.mMaxUnexpLogcatLineCount = i13;
                    if (b.d) {
                        JNIBridge.set(16, i13);
                    }
                    i3++;
                }
                int i14 = customInfo2.mMaxAnrLogcatLineCount;
                int i15 = customInfo.mMaxAnrLogcatLineCount;
                if (i14 != i15) {
                    customInfo2.mMaxAnrLogcatLineCount = i15;
                    if (b.d) {
                        JNIBridge.set(31, i15);
                    }
                    i3++;
                }
                boolean z12 = customInfo2.mZipLog;
                boolean z13 = customInfo.mZipLog;
                if (z12 != z13) {
                    customInfo2.mZipLog = z13;
                    if (!z13) {
                        com.uc.crashsdk.a.a.d("DEBUG", "updateCustomInfoImpl set mZipLog to false");
                        a = new RuntimeException("updateCustomInfoImpl set mZipLog to false");
                    }
                    i3++;
                    z2 = true;
                } else {
                    z2 = false;
                }
                if (a(customInfo.mZippedLogExtension, customInfo2.mZippedLogExtension)) {
                    z3 = z2;
                } else {
                    customInfo2.mZippedLogExtension = customInfo.mZippedLogExtension;
                    i3++;
                }
                if (z3 && b.d) {
                    JNIBridge.nativeSet(3, customInfo2.mZipLog ? 1L : 0L, customInfo2.mZippedLogExtension, null);
                }
                int i16 = customInfo2.mLogMaxBytesLimit;
                int i17 = customInfo.mLogMaxBytesLimit;
                if (i16 != i17) {
                    customInfo2.mLogMaxBytesLimit = i17;
                    if (b.d) {
                        JNIBridge.set(4, i17);
                    }
                    i3++;
                }
                boolean z14 = customInfo2.mEncryptLog;
                boolean z15 = customInfo.mEncryptLog;
                if (z14 != z15) {
                    customInfo2.mEncryptLog = z15;
                    if (z15) {
                        com.uc.crashsdk.a.a.d("DEBUG", "updateCustomInfoImpl set mEncryptLog to true");
                        b = new RuntimeException("updateCustomInfoImpl set mEncryptLog to true");
                    }
                    i3++;
                }
                boolean z16 = customInfo2.mSyncUploadSetupCrashLogs;
                boolean z17 = customInfo.mSyncUploadSetupCrashLogs;
                if (z16 != z17) {
                    customInfo2.mSyncUploadSetupCrashLogs = z17;
                    i3++;
                }
                boolean z18 = customInfo2.mSyncUploadLogs;
                boolean z19 = customInfo.mSyncUploadLogs;
                if (z18 != z19) {
                    customInfo2.mSyncUploadLogs = z19;
                    i3++;
                }
                int i18 = customInfo2.mMaxCustomLogFilesCount;
                int i19 = customInfo.mMaxCustomLogFilesCount;
                if (i18 != i19) {
                    customInfo2.mMaxCustomLogFilesCount = i19;
                    i3++;
                }
                boolean z20 = customInfo2.mOmitJavaCrash;
                boolean z21 = customInfo.mOmitJavaCrash;
                if (z20 != z21) {
                    customInfo2.mOmitJavaCrash = z21;
                    i3++;
                }
                int i20 = customInfo2.mLogMaxUploadBytesLimit;
                int i21 = customInfo.mLogMaxUploadBytesLimit;
                if (i20 != i21) {
                    customInfo2.mLogMaxUploadBytesLimit = i21;
                    i3++;
                }
                long j2 = customInfo2.mMaxUploadBytesPerDay;
                long j3 = customInfo.mMaxUploadBytesPerDay;
                if (j2 != j3) {
                    customInfo2.mMaxUploadBytesPerDay = j3;
                    i3++;
                }
                int i22 = customInfo2.mMaxUploadBuiltinLogCountPerDay;
                int i23 = customInfo.mMaxUploadBuiltinLogCountPerDay;
                if (i22 != i23) {
                    customInfo2.mMaxUploadBuiltinLogCountPerDay = i23;
                    i3++;
                }
                int i24 = customInfo2.mMaxUploadCustomLogCountPerDay;
                int i25 = customInfo.mMaxUploadCustomLogCountPerDay;
                if (i24 != i25) {
                    customInfo2.mMaxUploadCustomLogCountPerDay = i25;
                    i3++;
                }
                int i26 = customInfo2.mMaxCustomLogCountPerTypePerDay;
                int i27 = customInfo.mMaxCustomLogCountPerTypePerDay;
                if (i26 != i27) {
                    customInfo2.mMaxCustomLogCountPerTypePerDay = i27;
                    i3++;
                }
                int i28 = customInfo2.mMaxAnrLogCountPerProcess;
                int i29 = customInfo.mMaxAnrLogCountPerProcess;
                if (i28 != i29) {
                    customInfo2.mMaxAnrLogCountPerProcess = i29;
                    if (b.d) {
                        JNIBridge.set(32, d.mMaxAnrLogCountPerProcess);
                    }
                    i3++;
                }
                boolean z22 = customInfo2.mCallJavaDefaultHandler;
                boolean z23 = customInfo.mCallJavaDefaultHandler;
                if (z22 != z23) {
                    customInfo2.mCallJavaDefaultHandler = z23;
                    i3++;
                }
                boolean z24 = customInfo2.mCallNativeDefaultHandler;
                boolean z25 = customInfo.mCallNativeDefaultHandler;
                if (z24 != z25) {
                    customInfo2.mCallNativeDefaultHandler = z25;
                    i3++;
                    if (b.d) {
                        JNIBridge.set(5, d.mCallNativeDefaultHandler);
                    }
                }
                boolean z26 = customInfo2.mDumpUserSolibBuildId;
                boolean z27 = customInfo.mDumpUserSolibBuildId;
                if (z26 != z27) {
                    customInfo2.mDumpUserSolibBuildId = z27;
                    i3++;
                    if (b.d) {
                        JNIBridge.set(6, d.mDumpUserSolibBuildId);
                    }
                }
                boolean z28 = customInfo2.mDumpHprofDataForJavaOOM;
                boolean z29 = customInfo.mDumpHprofDataForJavaOOM;
                if (z28 != z29) {
                    customInfo2.mDumpHprofDataForJavaOOM = z29;
                    i3++;
                }
                boolean z30 = customInfo2.mRenameFileToDefaultName;
                boolean z31 = customInfo.mRenameFileToDefaultName;
                if (z30 != z31) {
                    customInfo2.mRenameFileToDefaultName = z31;
                    i3++;
                }
                boolean z32 = customInfo2.mAutoDeleteOldVersionStats;
                boolean z33 = customInfo.mAutoDeleteOldVersionStats;
                if (z32 != z33) {
                    customInfo2.mAutoDeleteOldVersionStats = z33;
                    i3++;
                }
                int i30 = customInfo2.mFdDumpMinLimit;
                int i31 = customInfo.mFdDumpMinLimit;
                if (i30 != i31) {
                    customInfo2.mFdDumpMinLimit = i31;
                    if (b.d) {
                        JNIBridge.set(10, i31);
                    }
                    i3++;
                }
                int i32 = customInfo2.mThreadsDumpMinLimit;
                int i33 = customInfo.mThreadsDumpMinLimit;
                if (i32 != i33) {
                    customInfo2.mThreadsDumpMinLimit = i33;
                    if (b.d) {
                        JNIBridge.set(22, i33);
                    }
                    i3++;
                }
                int i34 = customInfo2.mInfoUpdateInterval;
                int i35 = customInfo.mInfoUpdateInterval;
                if (i34 != i35) {
                    if (i34 <= 0 && i35 > 0) {
                        a.a(false);
                    }
                    customInfo2.mInfoUpdateInterval = customInfo.mInfoUpdateInterval;
                    i3++;
                }
                int i36 = customInfo2.mInfoSaveFrequency;
                int i37 = customInfo.mInfoSaveFrequency;
                if (i36 != i37) {
                    customInfo2.mInfoSaveFrequency = i37;
                    i3++;
                }
                long j4 = customInfo2.mDisableBackgroundSignals;
                long j5 = customInfo.mDisableBackgroundSignals;
                if (j4 != j5) {
                    customInfo2.mDisableBackgroundSignals = j5;
                    if (b.d) {
                        JNIBridge.set(9, j5);
                    }
                    i3++;
                }
                boolean z34 = customInfo2.mEnableStatReport;
                boolean z35 = customInfo.mEnableStatReport;
                if (z34 != z35) {
                    customInfo2.mEnableStatReport = z35;
                    if (z35) {
                        e.A();
                    }
                    i3++;
                }
                boolean z36 = customInfo2.mIsInternational;
                boolean z37 = customInfo.mIsInternational;
                if (z36 != z37) {
                    customInfo2.mIsInternational = z37;
                    if (b.d) {
                        JNIBridge.set(23, z37);
                    }
                    i3++;
                }
                boolean z38 = customInfo2.mAutoDetectLifeCycle;
                boolean z39 = customInfo.mAutoDetectLifeCycle;
                if (z38 != z39) {
                    customInfo2.mAutoDetectLifeCycle = z39;
                    if (z39) {
                        b.z();
                    }
                    i3++;
                }
                boolean z40 = customInfo2.mMonitorBattery;
                boolean z41 = customInfo.mMonitorBattery;
                if (z40 != z41) {
                    customInfo2.mMonitorBattery = z41;
                    e.c(b.y());
                    i3++;
                }
                int i38 = customInfo2.mUnexpSubTypes;
                int i39 = customInfo.mUnexpSubTypes;
                if (i38 != i39) {
                    customInfo2.mUnexpSubTypes = i39;
                    i3++;
                }
                i2 = i3;
            }
        }
        return i2;
    }

    public static void c() {
        JNIBridge.set(11, N());
        JNIBridge.set(12, d.mBackupLogs);
        JNIBridge.set(13, d.mCrashRestartInterval);
        JNIBridge.set(14, d.mMaxBuiltinLogFilesCount);
        JNIBridge.set(15, d.mMaxNativeLogcatLineCount);
        JNIBridge.set(16, d.mMaxUnexpLogcatLineCount);
        JNIBridge.set(31, d.mMaxAnrLogcatLineCount);
        JNIBridge.set(18, M());
        JNIBridge.set(20, Build.VERSION.SDK_INT);
        JNIBridge.set(21, d.mOmitNativeCrash);
        JNIBridge.set(32, d.mMaxAnrLogCountPerProcess);
        JNIBridge.set(8, d.mDisableSignals);
        JNIBridge.set(9, d.mDisableBackgroundSignals);
        CustomInfo customInfo = d;
        JNIBridge.nativeSet(3, customInfo.mZipLog ? 1L : 0L, customInfo.mZippedLogExtension, null);
        JNIBridge.set(4, d.mLogMaxBytesLimit);
        JNIBridge.set(119, Build.FINGERPRINT);
    }

    private static String a(String str) {
        return (str == null || !str.contains("_")) ? str : str.replaceAll("_", "-");
    }

    public static CustomInfo a(CustomInfo customInfo, Bundle bundle) {
        if (customInfo == null) {
            CustomInfo customInfo2 = d;
            if (customInfo2 == null) {
                customInfo = new CustomInfo();
            } else {
                customInfo = new CustomInfo(customInfo2);
            }
        }
        Field[] fields = customInfo.getClass().getFields();
        for (String str : bundle.keySet()) {
            for (Field field : fields) {
                if (field.getName().equals(str)) {
                    Object obj = bundle.get(str);
                    try {
                        field.set(customInfo, obj);
                    } catch (Exception e2) {
                        com.uc.crashsdk.a.g.a(e2);
                        StringBuilder sb = new StringBuilder("Field ");
                        sb.append(str);
                        sb.append(" must be a ");
                        sb.append(field.getType().getName());
                        sb.append(", but give a ");
                        sb.append(obj != null ? obj.getClass().getName() : "(null)");
                        throw new IllegalArgumentException(sb.toString());
                    }
                }
            }
        }
        return customInfo;
    }

    public static VersionInfo a(Bundle bundle) {
        VersionInfo versionInfo;
        VersionInfo versionInfo2 = e;
        if (versionInfo2 == null) {
            versionInfo = new VersionInfo();
        } else {
            versionInfo = new VersionInfo(versionInfo2);
        }
        String string = bundle.getString("mVersion");
        if (!com.uc.crashsdk.a.g.a(string)) {
            versionInfo.mVersion = string;
        }
        String string2 = bundle.getString("mSubVersion");
        if (!com.uc.crashsdk.a.g.a(string2)) {
            versionInfo.mSubVersion = string2;
        }
        String string3 = bundle.getString("mBuildId");
        if (!com.uc.crashsdk.a.g.a(string3)) {
            versionInfo.mBuildId = string3;
        }
        String string4 = bundle.getString("crver");
        if (!com.uc.crashsdk.a.g.a(string4)) {
            a.b = string4;
            Y();
        }
        return versionInfo;
    }

    private static boolean a(String str, String str2) {
        if (str == str2) {
            return true;
        }
        if (str == null || str2 == null) {
            return false;
        }
        return str.equals(str2);
    }
}
