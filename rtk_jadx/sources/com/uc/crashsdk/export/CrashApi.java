package com.uc.crashsdk.export;

import android.app.Application;
import android.content.Context;
import android.os.Bundle;
import android.os.ParcelFileDescriptor;
import android.webkit.ValueCallback;
import com.uc.crashsdk.JNIBridge;
import com.uc.crashsdk.a.a;
import com.uc.crashsdk.a.d;
import com.uc.crashsdk.a.h;
import com.uc.crashsdk.b;
import com.uc.crashsdk.e;
import com.uc.crashsdk.g;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Objects;
import java.util.concurrent.Callable;

/* compiled from: ProGuard */
/* loaded from: /tmp/rtk_apk/classes3.dex */
public class CrashApi {
    private static CrashApi a = null;

    /* renamed from: c, reason: collision with root package name */
    private static boolean f1004c = true;
    private static boolean d = false;
    private boolean b;

    private CrashApi(Context context, CustomInfo customInfo, VersionInfo versionInfo, ICrashClient iCrashClient, boolean z, boolean z2, boolean z3) {
        this.b = false;
        Context a2 = a(context);
        b(a2);
        b.g = z2;
        b.h = z3;
        if (b.I()) {
            b(a2);
            a(a2, customInfo, versionInfo, iCrashClient);
            if (z) {
                a();
            }
            if (b.g && e.d("libcrashsdk.so")) {
                b.f = true;
                b();
                return;
            }
            return;
        }
        if (customInfo != null && versionInfo != null) {
            g.a(customInfo);
            try {
                e.a(e.d(customInfo.mIsInternational), true);
                a(a2, customInfo, versionInfo, iCrashClient);
            } catch (Throwable th) {
                a(th);
            }
            if (z) {
                try {
                    a();
                } catch (Throwable th2) {
                    a(th2);
                }
            }
            try {
                b.J();
                h.a();
                d.a();
                com.uc.crashsdk.a.g.j();
            } catch (Throwable th3) {
                com.uc.crashsdk.a.g.a(th3);
            }
            try {
                if (!b.a(a2)) {
                    a.d("crashsdk", "registerLifecycleCallbacks failed!");
                }
            } catch (Throwable th4) {
                com.uc.crashsdk.a.g.a(th4);
            }
            try {
                com.uc.crashsdk.a.n();
                try {
                    e.z();
                } catch (Throwable th5) {
                    com.uc.crashsdk.a.g.b(th5);
                }
                e.A();
            } catch (Throwable th6) {
                com.uc.crashsdk.a.g.a(th6);
            }
            try {
                if (g.r() && b.C() && !this.b) {
                    e.F();
                    this.b = true;
                    return;
                }
                return;
            } catch (Throwable th7) {
                com.uc.crashsdk.a.g.b(th7);
                return;
            }
        }
        a.d("crashsdk", "VersionInfo and CustomInfo can not be null!");
        throw null;
    }

    private static void a() {
        if (b.a) {
            a.b("Has enabled java log!");
            return;
        }
        e.r();
        e.n();
        b.a = true;
    }

    private static void b() {
        synchronized (b.e) {
            if (b.g && b.f) {
                if (b.b) {
                    a.b("Has enabled native log!");
                    return;
                }
                c();
                e.C();
                b.b = true;
                JNIBridge.cmd(6);
                g.d();
            }
        }
    }

    private static void c() {
        if (b.d) {
            return;
        }
        g.b();
        JNIBridge.cmd(5);
        g.c();
        b.d = true;
    }

    public static synchronized CrashApi createInstance(Context context, CustomInfo customInfo, VersionInfo versionInfo, ICrashClient iCrashClient, boolean z, boolean z2, boolean z3) {
        CrashApi crashApi;
        synchronized (CrashApi.class) {
            if (a == null) {
                a = new CrashApi(context, customInfo, versionInfo, iCrashClient, z, z2, z3);
            }
            crashApi = a;
        }
        return crashApi;
    }

    public static CrashApi createInstanceEx(Context context, String str, boolean z) {
        return createInstanceEx(context, str, z, null);
    }

    public static CrashApi getInstance() {
        return a;
    }

    public int addCachedInfo(String str, String str2) {
        if (str != null && str2 != null) {
            return com.uc.crashsdk.a.b(str, str2);
        }
        throw null;
    }

    public int addDumpFile(DumpFileInfo dumpFileInfo) {
        String str;
        Objects.requireNonNull(dumpFileInfo);
        String str2 = dumpFileInfo.mCategory;
        if (str2 != null && (str = dumpFileInfo.mFileTobeDump) != null) {
            int i = dumpFileInfo.mLogType;
            if ((1048849 & i) == 0) {
                return 0;
            }
            return com.uc.crashsdk.a.a(str2, str, dumpFileInfo.mIsEncrypted, dumpFileInfo.mWriteCategory, i, dumpFileInfo.mDeleteAfterDump);
        }
        throw null;
    }

    public void addHeaderInfo(String str, String str2) {
        Objects.requireNonNull(str);
        com.uc.crashsdk.a.a(str, str2);
    }

    public boolean addStatInfo(String str, String str2) {
        if (a("addStatInfo")) {
            return false;
        }
        if (!com.uc.crashsdk.a.g.a(str)) {
            if (str.length() <= 24) {
                if (str2 != null && str2.length() > 512) {
                    str2 = str2.substring(0, 512);
                }
                return h.a(str, str2);
            }
            throw new IllegalArgumentException("key is too long!");
        }
        throw null;
    }

    public void crashSoLoaded() {
        if (a("crashSoLoaded")) {
            return;
        }
        b.f = true;
        b();
        synchronized (b.e) {
            if (b.h && b.f && !b.f999c) {
                if (!b.d) {
                    c();
                    g.d();
                }
                e.w();
                b.f999c = true;
            }
        }
        com.uc.crashsdk.a.n();
        e.l();
    }

    public int createCachedInfo(String str, int i, int i2) {
        Objects.requireNonNull(str);
        if (i <= 0) {
            throw new IllegalArgumentException("capacity must > 0!");
        }
        if ((1048849 & i2) == 0) {
            return 0;
        }
        return com.uc.crashsdk.a.a(str, i, i2);
    }

    public void disableLog(int i) {
        synchronized (b.e) {
            b.b(i);
            if (LogType.isForJava(i) && b.a) {
                e.s();
                b.a = false;
            }
            if (LogType.isForNative(i)) {
                if (b.b) {
                    JNIBridge.cmd(9);
                    b.b = false;
                } else {
                    b.g = false;
                }
            }
            if (LogType.isForANR(i)) {
                b.a(false);
            }
            if (LogType.isForUnexp(i)) {
                if (b.f999c) {
                    if (e.y()) {
                        b.f999c = false;
                    }
                } else {
                    b.h = false;
                }
            }
        }
    }

    public boolean generateCustomLog(CustomLogInfo customLogInfo) {
        String str;
        StringBuilder sb;
        Objects.requireNonNull(customLogInfo);
        if (customLogInfo.mData != null && (str = customLogInfo.mLogType) != null) {
            if (!str.contains("_") && !customLogInfo.mLogType.contains(" ")) {
                ArrayList<Integer> arrayList = customLogInfo.mDumpTids;
                if (arrayList == null || arrayList.size() <= 0) {
                    sb = null;
                } else {
                    sb = new StringBuilder();
                    Iterator<Integer> it = customLogInfo.mDumpTids.iterator();
                    while (it.hasNext()) {
                        sb.append(it.next().intValue());
                        sb.append(" ");
                    }
                }
                long j = customLogInfo.mAddHeader ? 1L : 0L;
                if (customLogInfo.mAddFooter) {
                    j |= 2;
                }
                if (customLogInfo.mAddLogcat) {
                    j |= 4;
                }
                if (customLogInfo.mAddThreadsDump) {
                    j |= 8;
                }
                if (customLogInfo.mAddBuildId) {
                    j |= 16;
                }
                if (customLogInfo.mUploadNow) {
                    j |= 32;
                }
                return e.a(customLogInfo.mData, customLogInfo.mLogType, j, customLogInfo.mDumpFiles, customLogInfo.mCallbacks, customLogInfo.mCachedInfos, sb != null ? sb.toString() : null);
            }
            throw new IllegalArgumentException("mLogType can not contain char '_' and ' '");
        }
        throw new NullPointerException("mData or mLogType is null!");
    }

    public boolean generateTraces(String str, long j) {
        if (a("generateTraces")) {
            return false;
        }
        if (b.d) {
            return JNIBridge.nativeCmd(12, j, str, null) == 1;
        }
        a.d("crashsdk", "Crash so is not loaded!");
        return false;
    }

    public String getCrashLogUploadUrl() {
        if (a("getCrashLogUploadUrl")) {
            return null;
        }
        return e.k();
    }

    public ParcelFileDescriptor getHostFd() {
        return e.D();
    }

    public ParcelFileDescriptor getIsolatedHostFd() {
        return e.D();
    }

    public int getLastExitType() {
        if (a("getLastExitType")) {
            return 1;
        }
        return b.F();
    }

    public int getLastExitTypeEx() {
        if (a("getLastExitTypeEx")) {
            return 1;
        }
        return b.G();
    }

    public Throwable getUncaughtException() {
        return e.u();
    }

    public int getUnexpReason() {
        if (a("getUnexpReason")) {
            return 100;
        }
        return e.v();
    }

    public void onExit() {
        b.t();
    }

    public boolean registerCallback(int i, ValueCallback<Bundle> valueCallback) {
        Objects.requireNonNull(valueCallback);
        if (i == 1) {
            return com.uc.crashsdk.d.a(valueCallback);
        }
        if (i == 2) {
            return com.uc.crashsdk.d.c(valueCallback);
        }
        if (i == 3) {
            return com.uc.crashsdk.d.d(valueCallback);
        }
        if (i == 4) {
            return com.uc.crashsdk.d.b(valueCallback);
        }
        throw new IllegalArgumentException("Unknown event type: " + i);
    }

    public int registerInfoCallback(String str, int i) {
        Objects.requireNonNull(str);
        if ((1048849 & i) == 0) {
            return 0;
        }
        return com.uc.crashsdk.a.a(str, i, null, 0L, 0);
    }

    public int registerThread(int i, String str) {
        return com.uc.crashsdk.a.a(i, str);
    }

    public int reportCrashStats(boolean z) {
        if (a("reportCrashStats")) {
            return 0;
        }
        return e.b(z, true);
    }

    public int resetCrashStats(boolean z) {
        if (a("resetCrashStats")) {
            return 0;
        }
        return e.e(z);
    }

    public void setForeground(boolean z) {
        b.b(z);
    }

    public boolean setHostFd(ParcelFileDescriptor parcelFileDescriptor) {
        return e.a(parcelFileDescriptor);
    }

    public boolean setIsolatedHostFd(ParcelFileDescriptor parcelFileDescriptor) {
        return e.a(parcelFileDescriptor);
    }

    public void setNewInstall() {
        if (a("setNewInstall")) {
            return;
        }
        b.s();
    }

    public int updateCustomInfo(CustomInfo customInfo) {
        Objects.requireNonNull(customInfo);
        return g.b(customInfo);
    }

    public boolean updateUnexpInfo() {
        if (a("updateUnexpInfo")) {
            return false;
        }
        return com.uc.crashsdk.a.a(true);
    }

    public void updateVersionInfo(VersionInfo versionInfo) {
        Objects.requireNonNull(versionInfo);
        g.a(versionInfo);
    }

    public void uploadCrashLogs() {
        if (a("uploadCrashLogs")) {
            return;
        }
        e.a(false, true);
    }

    public static CrashApi createInstanceEx(Context context, String str, boolean z, Bundle bundle) {
        return createInstanceEx(context, str, z, bundle, null);
    }

    public static CrashApi createInstanceEx(Context context, String str, boolean z, Bundle bundle, ICrashClient iCrashClient) {
        CrashApi crashApi = a;
        if (crashApi != null) {
            return crashApi;
        }
        if (bundle == null) {
            bundle = new Bundle();
        }
        f1004c = bundle.getBoolean("useApplicationContext", true);
        Context a2 = a(context);
        b(a2);
        CustomInfo customInfo = new CustomInfo(str);
        customInfo.mEnableStatReport = true;
        customInfo.mZipLog = true;
        customInfo.mPrintStackInfos = z;
        CustomInfo a3 = g.a(customInfo, bundle);
        VersionInfo a4 = g.a(bundle);
        boolean z2 = bundle.getBoolean("enableJavaLog", true);
        boolean z3 = bundle.getBoolean("enableNativeLog", true);
        boolean z4 = bundle.getBoolean("enableUnexpLog", b.C());
        boolean z5 = bundle.getBoolean("enableANRLog", true);
        CrashApi createInstance = createInstance(a2, a3, a4, iCrashClient, z2, z3, z4);
        b.a(z5);
        if (z3 || z4) {
            if (e.d("libcrashsdk.so")) {
                createInstance.crashSoLoaded();
            } else {
                a.d("crashsdk", "load libcrashsdk.so failed!");
            }
        }
        int i = bundle.getInt("uploadLogDelaySeconds", 15);
        if (i >= 0 && b.C()) {
            e.b(i);
        }
        return createInstance;
    }

    public int registerInfoCallback(String str, int i, Callable<String> callable) {
        if (str == null || callable == null) {
            throw null;
        }
        if ((1048849 & i) == 0) {
            return 0;
        }
        return com.uc.crashsdk.a.a(str, i, callable, 0L, 0);
    }

    public int updateCustomInfo(Bundle bundle) {
        Objects.requireNonNull(bundle);
        return updateCustomInfo(g.a((CustomInfo) null, bundle));
    }

    public void updateVersionInfo(Bundle bundle) {
        Objects.requireNonNull(bundle);
        updateVersionInfo(g.a(bundle));
    }

    private static void a(Context context, CustomInfo customInfo, VersionInfo versionInfo, ICrashClient iCrashClient) {
        com.uc.crashsdk.d.a(iCrashClient);
        g.a(customInfo, versionInfo);
        if (b.I()) {
            return;
        }
        e.o();
        e.a(context);
        e.b(context);
    }

    public int addDumpFile(String str, String str2, int i, Bundle bundle) {
        DumpFileInfo dumpFileInfo = new DumpFileInfo(str, str2, i);
        if (bundle != null) {
            dumpFileInfo.mIsEncrypted = bundle.getBoolean("mIsEncrypted", dumpFileInfo.mIsEncrypted);
            dumpFileInfo.mWriteCategory = bundle.getBoolean("mWriteCategory", dumpFileInfo.mWriteCategory);
            dumpFileInfo.mDeleteAfterDump = bundle.getBoolean("mDeleteAfterDump", dumpFileInfo.mDeleteAfterDump);
        }
        return addDumpFile(dumpFileInfo);
    }

    private static Context a(Context context) {
        if (context != null) {
            if (!f1004c || (context instanceof Application) || ((context = context.getApplicationContext()) != null && (context instanceof Application))) {
                return context;
            }
            a.d("crashsdk", "Can not get Application context from given context!");
            throw new IllegalArgumentException("Can not get Application context from given context!");
        }
        a.d("crashsdk", "context can not be null!");
        throw null;
    }

    private static void b(Context context) {
        try {
            if (d) {
                return;
            }
            com.uc.crashsdk.a.g.a(context);
            com.uc.crashsdk.a.a = context.getPackageName();
            d = true;
        } catch (Throwable th) {
            a(th);
        }
    }

    private static void a(Throwable th) {
        new e().a(Thread.currentThread(), th, true);
    }

    public boolean generateCustomLog(StringBuffer stringBuffer, String str, Bundle bundle) {
        CustomLogInfo customLogInfo = new CustomLogInfo(stringBuffer, str);
        if (bundle != null) {
            customLogInfo.mAddHeader = bundle.getBoolean("mAddHeader", customLogInfo.mAddHeader);
            customLogInfo.mAddFooter = bundle.getBoolean("mAddFooter", customLogInfo.mAddFooter);
            customLogInfo.mAddLogcat = bundle.getBoolean("mAddLogcat", customLogInfo.mAddLogcat);
            customLogInfo.mUploadNow = bundle.getBoolean("mUploadNow", customLogInfo.mUploadNow);
            customLogInfo.mAddThreadsDump = bundle.getBoolean("mAddThreadsDump", customLogInfo.mAddThreadsDump);
            customLogInfo.mAddBuildId = bundle.getBoolean("mAddBuildId", customLogInfo.mAddBuildId);
            customLogInfo.mDumpFiles = bundle.getStringArrayList("mDumpFiles");
            customLogInfo.mCallbacks = bundle.getStringArrayList("mCallbacks");
            customLogInfo.mCachedInfos = bundle.getStringArrayList("mCachedInfos");
            customLogInfo.mDumpTids = bundle.getIntegerArrayList("mDumpTids");
        }
        return generateCustomLog(customLogInfo);
    }

    private static boolean a(String str) {
        if (!b.I()) {
            return false;
        }
        a.d("crashsdk", "Can not call '" + str + "' in isolated process!");
        return true;
    }
}
