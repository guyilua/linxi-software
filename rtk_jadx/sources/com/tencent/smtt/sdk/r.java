package com.tencent.smtt.sdk;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.smtt.export.external.DexLoader;
import com.tencent.smtt.export.external.TbsCoreSettings;
import com.tencent.smtt.export.external.libwebp;
import com.tencent.smtt.sdk.TbsListener;
import com.tencent.smtt.utils.TbsLog;
import java.util.Map;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: TbsWizard.java */
/* loaded from: /tmp/rtk_apk/classes3.dex */
public class r {
    private Context a;
    private Context b;

    /* renamed from: c, reason: collision with root package name */
    private String f968c;
    private String[] d;
    private DexLoader e;
    private String f;
    private String g = null;

    public r(Context context, Context context2, String str, String str2, String[] strArr, String str3) {
        boolean z;
        boolean z2;
        this.a = null;
        this.b = null;
        this.f968c = null;
        this.d = null;
        this.e = null;
        this.f = "TbsDexOpt";
        TbsLog.i("TbsWizard", "construction start...");
        if (context != null && ((context2 != null || TbsShareManager.getHostCorePathAppDefined() != null) && !TextUtils.isEmpty(str) && strArr != null && strArr.length != 0)) {
            this.a = context.getApplicationContext();
            if (context2.getApplicationContext() != null) {
                this.b = context2.getApplicationContext();
            } else {
                this.b = context2;
            }
            this.f968c = str;
            this.d = strArr;
            this.f = str2;
            for (int i = 0; i < this.d.length; i++) {
                TbsLog.i("TbsWizard", "#2 mDexFileList[" + i + "]: " + this.d[i]);
            }
            TbsLog.i("TbsWizard", "new DexLoader #2 libraryPath is " + str3 + " mCallerAppContext is " + this.a + " dexOutPutDir is " + str2);
            this.e = new DexLoader(str3, this.a, this.d, str2, QbSdk.n);
            System.currentTimeMillis();
            a(context);
            libwebp.loadWepLibraryIfNeed(context2, this.f968c);
            if ("com.nd.android.pandahome2".equals(this.a.getApplicationInfo().packageName)) {
                this.e.invokeStaticMethod("com.tencent.tbs.common.beacon.X5CoreBeaconUploader", "getInstance", new Class[]{Context.class}, this.a);
            }
            if (QbSdk.n != null) {
                try {
                    z = TbsPVConfig.getInstance(this.a).getTbsCoreSandboxModeEnable();
                } catch (Throwable unused) {
                    z = false;
                }
                try {
                    z2 = "true".equals(String.valueOf(QbSdk.n.get(TbsCoreSettings.TBS_SETTINGS_USE_SANDBOX)));
                } catch (Throwable th) {
                    th.printStackTrace();
                    z2 = false;
                }
                QbSdk.n.put(TbsCoreSettings.TBS_SETTINGS_USE_SANDBOX, Boolean.valueOf(z && z2));
                this.e.invokeStaticMethod("com.tencent.tbs.tbsshell.TBSShell", "initTbsSettings", new Class[]{Map.class}, QbSdk.n);
            }
            int b = b(context);
            if (b >= 0) {
                TbsLog.i("TbsWizard", "construction end...");
                return;
            }
            throw new Exception("TbsWizard init error: " + b + "; msg: " + this.g);
        }
        throw new Exception("TbsWizard paramter error:-1callerContext:" + context + "hostcontext" + context2 + "isEmpty" + TextUtils.isEmpty(str) + "dexfileList" + strArr);
    }

    private int b(Context context) {
        Object invokeStaticMethod;
        int i;
        if (this.b == null && TbsShareManager.getHostCorePathAppDefined() != null) {
            DexLoader dexLoader = this.e;
            invokeStaticMethod = dexLoader.invokeStaticMethod("com.tencent.tbs.tbsshell.TBSShell", "initTesRuntimeEnvironment", new Class[]{Context.class, Context.class, DexLoader.class, String.class, String.class, String.class, Integer.TYPE, String.class, String.class}, context, this.b, dexLoader, this.f968c, this.f, TbsConfig.TBS_SDK_VERSIONNAME, 43697, QbSdk.a(), TbsShareManager.getHostCorePathAppDefined());
        } else {
            TbsLog.i("TbsWizard", "initTesRuntimeEnvironment callerContext is " + context + " mHostContext is " + this.b + " mDexLoader is " + this.e + " mtbsInstallLocation is " + this.f968c + " mDexOptPath is " + this.f);
            DexLoader dexLoader2 = this.e;
            invokeStaticMethod = dexLoader2.invokeStaticMethod("com.tencent.tbs.tbsshell.TBSShell", "initTesRuntimeEnvironment", new Class[]{Context.class, Context.class, DexLoader.class, String.class, String.class, String.class, Integer.TYPE, String.class}, context, this.b, dexLoader2, this.f968c, this.f, TbsConfig.TBS_SDK_VERSIONNAME, 43697, QbSdk.a());
        }
        if (invokeStaticMethod == null) {
            c();
            d();
            DexLoader dexLoader3 = this.e;
            invokeStaticMethod = dexLoader3.invokeStaticMethod("com.tencent.tbs.tbsshell.TBSShell", "initTesRuntimeEnvironment", new Class[]{Context.class, Context.class, DexLoader.class, String.class, String.class}, context, this.b, dexLoader3, this.f968c, this.f);
        }
        if (invokeStaticMethod == null) {
            i = -3;
        } else if (invokeStaticMethod instanceof Integer) {
            i = ((Integer) invokeStaticMethod).intValue();
        } else if (invokeStaticMethod instanceof Throwable) {
            TbsCoreLoadStat.getInstance().a(this.a, TbsListener.ErrorCode.THROWABLE_INITTESRUNTIMEENVIRONMENT, (Throwable) invokeStaticMethod);
            i = -5;
        } else {
            i = -4;
        }
        if (i < 0) {
            Object invokeStaticMethod2 = this.e.invokeStaticMethod("com.tencent.tbs.tbsshell.TBSShell", "getLoadFailureDetails", new Class[0], new Object[0]);
            if (invokeStaticMethod2 instanceof Throwable) {
                Throwable th = (Throwable) invokeStaticMethod2;
                this.g = "#" + th.getMessage() + "; cause: " + th.getCause() + "; th: " + th;
            }
            if (invokeStaticMethod2 instanceof String) {
                this.g = (String) invokeStaticMethod2;
            }
        } else {
            this.g = null;
        }
        return i;
    }

    private void c() {
        this.e.invokeStaticMethod("com.tencent.tbs.tbsshell.TBSShell", "setTesSdkVersionName", new Class[]{String.class}, TbsConfig.TBS_SDK_VERSIONNAME);
    }

    private void d() {
        this.e.setStaticField("com.tencent.tbs.tbsshell.TBSShell", "VERSION", 43697);
    }

    /* JADX WARN: Removed duplicated region for block: B:10:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0018  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    void a(android.content.Context r3) {
        /*
            r2 = this;
            java.util.Map<java.lang.String, java.lang.Object> r0 = com.tencent.smtt.sdk.QbSdk.n
            if (r0 == 0) goto L15
            java.lang.String r1 = "check_tbs_validity"
            java.lang.Object r0 = r0.get(r1)
            boolean r1 = r0 instanceof java.lang.Boolean
            if (r1 == 0) goto L15
            java.lang.Boolean r0 = (java.lang.Boolean) r0
            boolean r0 = r0.booleanValue()
            goto L16
        L15:
            r0 = 0
        L16:
            if (r0 == 0) goto L1b
            com.tencent.smtt.utils.m.b(r3)
        L1b:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.smtt.sdk.r.a(android.content.Context):void");
    }

    public void a(Context context, Context context2, String str, String str2, String[] strArr, String str3) {
        this.a = context.getApplicationContext();
        if (this.b.getApplicationContext() != null) {
            this.b = this.b.getApplicationContext();
        }
        this.f968c = str;
        this.d = strArr;
        this.f = str2;
        libwebp.loadWepLibraryIfNeed(context2, str);
        Map<String, Object> map = QbSdk.n;
        if (map != null) {
            this.e.invokeStaticMethod("com.tencent.tbs.tbsshell.TBSShell", "initTbsSettings", new Class[]{Map.class}, map);
        }
        int b = b(context);
        if (b >= 0) {
            return;
        }
        throw new Exception("continueInit init error: " + b + "; msg: " + this.g);
    }

    public String a() {
        String str = null;
        Object invokeStaticMethod = this.e.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "invokeStaticMethod", new Class[]{Boolean.TYPE, String.class, String.class, Class[].class, Object[].class}, Boolean.TRUE, "com.tencent.smtt.util.CrashTracker", "getCrashExtraInfo", null, new Object[0]);
        if (invokeStaticMethod == null) {
            invokeStaticMethod = this.e.invokeStaticMethod("com.tencent.smtt.util.CrashTracker", "getCrashExtraInfo", null, new Object[0]);
        }
        if (invokeStaticMethod != null) {
            str = String.valueOf(invokeStaticMethod) + " ReaderPackName=" + TbsReaderView.gReaderPackName + " ReaderPackVersion=" + TbsReaderView.gReaderPackVersion;
        }
        return str == null ? "X5 core get nothing..." : str;
    }

    public DexLoader b() {
        return this.e;
    }

    public boolean a(Context context, String str, String str2, Bundle bundle) {
        Object invokeStaticMethod = this.e.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "installLocalQbApk", new Class[]{Context.class, String.class, String.class, Bundle.class}, context, str, str2, bundle);
        if (invokeStaticMethod == null) {
            return false;
        }
        return ((Boolean) invokeStaticMethod).booleanValue();
    }
}
