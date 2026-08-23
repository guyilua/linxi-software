package com.tencent.smtt.sdk;

import android.annotation.SuppressLint;
import android.app.ActivityManager;
import android.app.AlertDialog;
import android.content.ComponentName;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.content.pm.ProviderInfo;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.Parcelable;
import android.os.Process;
import android.text.TextUtils;
import android.util.Log;
import com.qq.e.comm.managers.setting.GlobalSetting;
import com.ss.android.downloadad.api.constant.AdBaseConstants;
import com.tencent.smtt.export.external.DexLoader;
import com.tencent.smtt.export.external.interfaces.IX5WebViewBase;
import com.tencent.smtt.sdk.TbsDownloadConfig;
import com.tencent.smtt.sdk.TbsDownloadUpload;
import com.tencent.smtt.sdk.TbsDownloader;
import com.tencent.smtt.sdk.TbsListener;
import com.tencent.smtt.utils.FileProvider;
import com.tencent.smtt.utils.TbsLog;
import com.tencent.smtt.utils.TbsLogClient;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import org.json.JSONArray;
import org.json.JSONObject;

@SuppressLint({"NewApi"})
/* loaded from: /tmp/rtk_apk/classes3.dex */
public class QbSdk {
    private static String A = null;
    private static boolean B = false;
    private static boolean C = true;
    private static TbsListener D = null;
    private static TbsListener E = null;
    public static final int EXTENSION_INIT_FAILURE = -99999;
    private static boolean F = false;
    public static final String FILERADER_MENUDATA = "menuData";
    private static boolean G = false;
    public static final String LOGIN_TYPE_KEY_PARTNER_CALL_POS = "PosID";
    public static final String LOGIN_TYPE_KEY_PARTNER_ID = "ChannelID";
    public static final String PARAM_KEY_FEATUREID = "param_key_featureid";
    public static final String PARAM_KEY_FUNCTIONID = "param_key_functionid";
    public static final String PARAM_KEY_POSITIONID = "param_key_positionid";
    public static final int QBMODE = 2;
    public static final String SVNVERSION = "jnizz";
    public static final int TBSMODE = 1;
    public static final String TID_QQNumber_Prefix = "QQ:";
    public static final int VERSION = 1;
    static boolean b = false;

    /* renamed from: c, reason: collision with root package name */
    static boolean f930c = true;
    static String d = null;
    static boolean e = false;
    static long f = 0;
    static long g = 0;
    static boolean i = true;
    public static boolean isDefaultDialog = false;
    static boolean j = true;
    static boolean k = false;
    public static boolean mDisableUseHostBackupCore = false;
    private static int o = 0;
    private static String p = "";
    private static Class<?> q = null;
    private static Object r = null;
    private static boolean s = false;
    public static boolean sIsVersionPrinted = false;
    private static String[] t = null;
    private static String u = "NULL";
    private static String v = "UNKNOWN";
    private static boolean w = false;
    private static int x = 0;
    private static int y = 170;
    private static String z;
    static Object h = new Object();
    static boolean a = false;
    static volatile boolean l = a;
    static TbsListener m = new TbsListener() { // from class: com.tencent.smtt.sdk.QbSdk.7
        @Override // com.tencent.smtt.sdk.TbsListener
        public void onDownloadFinish(int i2) {
            if (TbsDownloader.needDownloadDecoupleCore()) {
                TbsLog.i("QbSdk", "onDownloadFinish needDownloadDecoupleCore is true", true);
                TbsDownloader.a = true;
                return;
            }
            TbsLog.i("QbSdk", "onDownloadFinish needDownloadDecoupleCore is false", true);
            TbsDownloader.a = false;
            if (QbSdk.D != null) {
                QbSdk.D.onDownloadFinish(i2);
            }
            if (QbSdk.E != null) {
                QbSdk.E.onDownloadFinish(i2);
            }
        }

        @Override // com.tencent.smtt.sdk.TbsListener
        public void onDownloadProgress(int i2) {
            if (QbSdk.E != null) {
                QbSdk.E.onDownloadProgress(i2);
            }
            if (QbSdk.D != null) {
                QbSdk.D.onDownloadProgress(i2);
            }
        }

        @Override // com.tencent.smtt.sdk.TbsListener
        public void onInstallFinish(int i2) {
            if (i2 != 200) {
            }
            QbSdk.setTBSInstallingStatus(false);
            TbsDownloader.a = false;
            if (TbsDownloader.startDecoupleCoreIfNeeded()) {
                TbsDownloader.a = true;
            } else {
                TbsDownloader.a = false;
            }
            if (QbSdk.D != null) {
                QbSdk.D.onInstallFinish(i2);
            }
            if (QbSdk.E != null) {
                QbSdk.E.onInstallFinish(i2);
            }
        }
    };
    public static String KEY_SET_SENDREQUEST_AND_UPLOAD = "SET_SENDREQUEST_AND_UPLOAD";
    static Map<String, Object> n = null;

    /* loaded from: /tmp/rtk_apk/classes3.dex */
    public interface PreInitCallback {
        void onCoreInitFinished();

        void onViewInitFinished(boolean z);
    }

    static boolean b(Context context) {
        SharedPreferences sharedPreferences;
        if (context == null) {
            return false;
        }
        try {
            if (!context.getApplicationInfo().packageName.contains("com.tencent.portfolio")) {
                return true;
            }
            TbsLog.i("QbSdk", "clearPluginConfigFile #1");
            String string = TbsDownloadConfig.getInstance(context).mPreferences.getString(TbsDownloadConfig.TbsConfigKey.KEY_APP_VERSIONNAME, null);
            String str = context.getPackageManager().getPackageInfo("com.tencent.portfolio", 0).versionName;
            TbsLog.i("QbSdk", "clearPluginConfigFile oldAppVersionName is " + string + " newAppVersionName is " + str);
            if (string == null || string.contains(str) || (sharedPreferences = context.getSharedPreferences("plugin_setting", 0)) == null) {
                return true;
            }
            SharedPreferences.Editor edit = sharedPreferences.edit();
            edit.clear();
            edit.commit();
            TbsLog.i("QbSdk", "clearPluginConfigFile done");
            return true;
        } catch (Throwable th) {
            TbsLog.i("QbSdk", "clearPluginConfigFile error is " + th.getMessage());
            return false;
        }
    }

    public static boolean canLoadVideo(Context context) {
        Object a2 = com.tencent.smtt.utils.k.a(r, "canLoadVideo", (Class<?>[]) new Class[]{Integer.TYPE}, 0);
        if (a2 != null) {
            if (!((Boolean) a2).booleanValue()) {
                TbsCoreLoadStat.getInstance().a(context, TbsListener.ErrorCode.ERROR_CANLOADVIDEO_RETURN_FALSE);
            }
        } else {
            TbsCoreLoadStat.getInstance().a(context, TbsListener.ErrorCode.ERROR_CANLOADVIDEO_RETURN_NULL);
        }
        if (a2 == null) {
            return false;
        }
        return ((Boolean) a2).booleanValue();
    }

    public static boolean canLoadX5(Context context) {
        return a(context, false, false);
    }

    public static boolean canLoadX5FirstTimeThirdApp(Context context) {
        String absolutePath;
        try {
            if (context.getApplicationInfo().packageName.contains("com.moji.mjweather") && Build.VERSION.SDK_INT == 19) {
                return true;
            }
            if (q == null) {
                File q2 = l.a().q(context);
                if (q2 == null) {
                    TbsLog.e("QbSdk", "QbSdk canLoadX5FirstTimeThirdApp (false) optDir == null");
                    return false;
                }
                File file = new File(TbsShareManager.c(context), "tbs_sdk_extension_dex.jar");
                if (!file.exists()) {
                    TbsLog.e("QbSdk", "QbSdk canLoadX5FirstTimeThirdApp (false) dexFile.exists()=false", true);
                    return false;
                }
                if (TbsShareManager.getHostCorePathAppDefined() != null) {
                    absolutePath = TbsShareManager.getHostCorePathAppDefined();
                } else {
                    absolutePath = q2.getAbsolutePath();
                }
                String str = absolutePath;
                TbsLog.i("QbSdk", "QbSdk init optDirExtension #2 is " + str);
                TbsLog.i("QbSdk", "new DexLoader #2 dexFile is " + file.getAbsolutePath());
                t.a().b(context);
                com.tencent.smtt.utils.m.a(context);
                q = new DexLoader(file.getParent(), context, new String[]{file.getAbsolutePath()}, str, getSettings()).loadClass("com.tencent.tbs.sdk.extension.TbsSDKExtension");
                if (r == null) {
                    if (TbsShareManager.e(context) == null && TbsShareManager.getHostCorePathAppDefined() == null) {
                        TbsLogReport.getInstance(context.getApplicationContext()).setLoadErrorCode(TbsListener.ErrorCode.HOST_CONTEXT_IS_NULL, "host context is null!");
                        return false;
                    }
                    loadTBSSDKExtension(context, file.getParent());
                }
            }
            Object a2 = com.tencent.smtt.utils.k.a(r, "canLoadX5CoreForThirdApp", (Class<?>[]) new Class[0], new Object[0]);
            if (a2 == null || !(a2 instanceof Boolean)) {
                return false;
            }
            return ((Boolean) a2).booleanValue();
        } catch (Throwable th) {
            TbsLog.e("QbSdk", "canLoadX5FirstTimeThirdApp sys WebView: " + Log.getStackTraceString(th));
            return false;
        }
    }

    public static void canOpenFile(final Context context, final String str, final ValueCallback<Boolean> valueCallback) {
        new Thread() { // from class: com.tencent.smtt.sdk.QbSdk.1
            @Override // java.lang.Thread, java.lang.Runnable
            public void run() {
                t a2 = t.a();
                a2.a(context);
                final boolean a3 = a2.b() ? a2.c().a(context, str) : false;
                new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.tencent.smtt.sdk.QbSdk.1.1
                    @Override // java.lang.Runnable
                    public void run() {
                        valueCallback.onReceiveValue(Boolean.valueOf(a3));
                    }
                });
            }
        }.start();
    }

    public static boolean canOpenMimeFileType(Context context, String str) {
        if (!a(context, false)) {
        }
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v11, types: [java.util.Properties] */
    /* JADX WARN: Type inference failed for: r6v4, types: [java.io.FileInputStream, java.io.InputStream] */
    public static boolean canOpenWebPlus(Context context) {
        ?? fileInputStream;
        if (x == 0) {
            x = a.a();
        }
        TbsLog.i("QbSdk", "canOpenWebPlus - totalRAM: " + x);
        boolean z2 = false;
        if (Build.VERSION.SDK_INT < 7 || x < y || context == null) {
            return false;
        }
        BufferedInputStream bufferedInputStream = null;
        try {
            BufferedInputStream bufferedInputStream2 = new BufferedInputStream(new FileInputStream(new File(l.a().q(context), "tbs.conf")));
            try {
                Properties properties = new Properties();
                properties.load(bufferedInputStream2);
                String property = properties.getProperty("android_sdk_max_supported");
                String property2 = properties.getProperty("android_sdk_min_supported");
                int parseInt = Integer.parseInt(property);
                int parseInt2 = Integer.parseInt(property2);
                int parseInt3 = Integer.parseInt(Build.VERSION.SDK);
                if (parseInt3 <= parseInt && parseInt3 >= parseInt2) {
                    int parseInt4 = Integer.parseInt(properties.getProperty("tbs_core_version"));
                    try {
                        bufferedInputStream2.close();
                    } catch (Exception unused) {
                    }
                    try {
                        fileInputStream = new FileInputStream(new File(l.s(context), "tbs_extension.conf"));
                        try {
                            ?? properties2 = new Properties();
                            properties2.load(fileInputStream);
                            int parseInt5 = Integer.parseInt(properties2.getProperty("tbs_local_version"));
                            int parseInt6 = Integer.parseInt(properties2.getProperty(TbsDownloadConfig.TbsConfigKey.KEY_APP_VERSIONCODE_FOR_SWITCH));
                            if (parseInt4 != 88888888 && parseInt5 != 88888888 && parseInt4 <= parseInt5 && parseInt4 == parseInt5 && ((parseInt6 <= 0 || parseInt6 == com.tencent.smtt.utils.b.b(context)) && Boolean.parseBoolean(properties2.getProperty("x5_disabled")))) {
                                if (!TbsDownloadConfig.getInstance(context.getApplicationContext()).mPreferences.getBoolean(TbsDownloadConfig.TbsConfigKey.KEY_SWITCH_BACKUPCORE_ENABLE, false)) {
                                    z2 = true;
                                }
                            }
                        } catch (Throwable unused2) {
                            bufferedInputStream = fileInputStream;
                            try {
                                TbsLog.i("QbSdk", "canOpenWebPlus - isX5Disabled Exception");
                                if (bufferedInputStream != null) {
                                    try {
                                        bufferedInputStream.close();
                                    } catch (Exception unused3) {
                                    }
                                }
                                z2 = true;
                                return !z2;
                            } catch (Throwable th) {
                                if (bufferedInputStream != null) {
                                    try {
                                        bufferedInputStream.close();
                                    } catch (Exception unused4) {
                                    }
                                }
                                throw th;
                            }
                        }
                    } catch (Throwable unused5) {
                    }
                    try {
                        fileInputStream.close();
                    } catch (Exception unused6) {
                        return !z2;
                    }
                }
                TbsLog.i("QbSdk", "canOpenWebPlus - sdkVersion: " + parseInt3);
                try {
                    bufferedInputStream2.close();
                } catch (Exception unused7) {
                }
                return false;
            } catch (Throwable th2) {
                th = th2;
                bufferedInputStream = bufferedInputStream2;
                try {
                    th.printStackTrace();
                    TbsLog.i("QbSdk", "canOpenWebPlus - canLoadX5 Exception");
                    if (bufferedInputStream != null) {
                        try {
                            bufferedInputStream.close();
                        } catch (Exception unused8) {
                        }
                    }
                    return false;
                } catch (Throwable th3) {
                    if (bufferedInputStream != null) {
                        try {
                            bufferedInputStream.close();
                        } catch (Exception unused9) {
                        }
                    }
                    throw th3;
                }
            }
        } catch (Throwable th4) {
            th = th4;
        }
    }

    public static boolean canUseVideoFeatrue(Context context, int i2) {
        Object a2 = com.tencent.smtt.utils.k.a(r, "canUseVideoFeatrue", (Class<?>[]) new Class[]{Integer.TYPE}, Integer.valueOf(i2));
        if (a2 == null || !(a2 instanceof Boolean)) {
            return false;
        }
        return ((Boolean) a2).booleanValue();
    }

    public static boolean checkApkExist(Context context, String str) {
        if (str != null && !"".equals(str)) {
            try {
                context.getPackageManager().getApplicationInfo(str, 8192);
                return true;
            } catch (PackageManager.NameNotFoundException unused) {
            }
        }
        return false;
    }

    public static boolean checkContentProviderPrivilage(Context context) {
        if (context == null || context.getApplicationInfo().targetSdkVersion < 24 || Build.VERSION.SDK_INT < 24 || TbsConfig.APP_QQ.equals(context.getApplicationInfo().packageName)) {
            return true;
        }
        try {
            if (!TextUtils.isEmpty(context.getPackageManager().getProviderInfo(new ComponentName(context.getPackageName(), "androidx.core.content.FileProvider"), 0).authority)) {
                return true;
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        ProviderInfo resolveContentProvider = context.getPackageManager().resolveContentProvider(context.getApplicationInfo().packageName + ".provider", 128);
        if (resolveContentProvider == null) {
            Log.e("QbSdk", "Must declare com.tencent.smtt.utils.FileProvider in AndroidManifest above Android 7.0,please view document in x5.tencent.com");
        }
        return resolveContentProvider != null;
    }

    public static void checkTbsValidity(Context context) {
        if (context == null || com.tencent.smtt.utils.m.b(context)) {
            return;
        }
        TbsLog.e("QbSdk", "sys WebView: SysWebViewForcedBy checkTbsValidity");
        TbsCoreLoadStat.getInstance().a(context, TbsListener.ErrorCode.INFO_CORE_CHECK_VALIDITY_FALSE);
        forceSysWebView();
    }

    public static void clear(Context context) {
    }

    /* JADX WARN: Removed duplicated region for block: B:6:0x0066  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x006c A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static void clearAllWebViewCache(android.content.Context r6, boolean r7) {
        /*
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "clearAllWebViewCache("
            r0.append(r1)
            r0.append(r6)
            java.lang.String r1 = ", "
            r0.append(r1)
            r0.append(r7)
            java.lang.String r1 = ")"
            r0.append(r1)
            java.lang.String r0 = r0.toString()
            java.lang.String r1 = "QbSdk"
            com.tencent.smtt.utils.TbsLog.i(r1, r0)
            r0 = 1
            r2 = 0
            com.tencent.smtt.sdk.WebView r3 = new com.tencent.smtt.sdk.WebView     // Catch: java.lang.Throwable -> L48
            r3.<init>(r6)     // Catch: java.lang.Throwable -> L48
            com.tencent.smtt.export.external.extension.interfaces.IX5WebViewClientExtension r3 = r3.getWebViewClientExtension()     // Catch: java.lang.Throwable -> L48
            if (r3 == 0) goto L64
            com.tencent.smtt.sdk.t r2 = com.tencent.smtt.sdk.t.a()     // Catch: java.lang.Throwable -> L45
            if (r2 == 0) goto L43
            boolean r3 = r2.b()     // Catch: java.lang.Throwable -> L45
            if (r3 == 0) goto L43
            com.tencent.smtt.sdk.u r2 = r2.c()     // Catch: java.lang.Throwable -> L45
            r2.a(r6, r7)     // Catch: java.lang.Throwable -> L45
        L43:
            r2 = 1
            goto L64
        L45:
            r2 = move-exception
            r3 = 1
            goto L4b
        L48:
            r3 = move-exception
            r2 = r3
            r3 = 0
        L4b:
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            java.lang.String r5 = "clearAllWebViewCache exception 2 -- "
            r4.append(r5)
            java.lang.String r2 = android.util.Log.getStackTraceString(r2)
            r4.append(r2)
            java.lang.String r2 = r4.toString()
            com.tencent.smtt.utils.TbsLog.e(r1, r2)
            r2 = r3
        L64:
            if (r2 == 0) goto L6c
            java.lang.String r6 = "is_in_x5_mode --> no need to clear system webview!"
            com.tencent.smtt.utils.TbsLog.i(r1, r6)
            return
        L6c:
            android.webkit.WebView r2 = new android.webkit.WebView     // Catch: java.lang.Throwable -> Lb9
            r2.<init>(r6)     // Catch: java.lang.Throwable -> Lb9
            int r3 = android.os.Build.VERSION.SDK_INT     // Catch: java.lang.Throwable -> Lb9
            r4 = 11
            if (r3 < r4) goto L86
            java.lang.String r3 = "searchBoxJavaBridge_"
            r2.removeJavascriptInterface(r3)     // Catch: java.lang.Throwable -> Lb9
            java.lang.String r3 = "accessibility"
            r2.removeJavascriptInterface(r3)     // Catch: java.lang.Throwable -> Lb9
            java.lang.String r3 = "accessibilityTraversal"
            r2.removeJavascriptInterface(r3)     // Catch: java.lang.Throwable -> Lb9
        L86:
            r2.clearCache(r0)     // Catch: java.lang.Throwable -> Lb9
            if (r7 == 0) goto L95
            android.webkit.CookieSyncManager.createInstance(r6)     // Catch: java.lang.Throwable -> Lb9
            android.webkit.CookieManager r7 = android.webkit.CookieManager.getInstance()     // Catch: java.lang.Throwable -> Lb9
            r7.removeAllCookie()     // Catch: java.lang.Throwable -> Lb9
        L95:
            android.webkit.WebViewDatabase r7 = android.webkit.WebViewDatabase.getInstance(r6)     // Catch: java.lang.Throwable -> Lb9
            r7.clearUsernamePassword()     // Catch: java.lang.Throwable -> Lb9
            android.webkit.WebViewDatabase r7 = android.webkit.WebViewDatabase.getInstance(r6)     // Catch: java.lang.Throwable -> Lb9
            r7.clearHttpAuthUsernamePassword()     // Catch: java.lang.Throwable -> Lb9
            android.webkit.WebViewDatabase r6 = android.webkit.WebViewDatabase.getInstance(r6)     // Catch: java.lang.Throwable -> Lb9
            r6.clearFormData()     // Catch: java.lang.Throwable -> Lb9
            android.webkit.WebStorage r6 = android.webkit.WebStorage.getInstance()     // Catch: java.lang.Throwable -> Lb9
            r6.deleteAllData()     // Catch: java.lang.Throwable -> Lb9
            android.webkit.WebIconDatabase r6 = android.webkit.WebIconDatabase.getInstance()     // Catch: java.lang.Throwable -> Lb9
            r6.removeAllIcons()     // Catch: java.lang.Throwable -> Lb9
            goto Ld2
        Lb9:
            r6 = move-exception
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            r7.<init>()
            java.lang.String r0 = "clearAllWebViewCache exception 1 -- "
            r7.append(r0)
            java.lang.String r6 = android.util.Log.getStackTraceString(r6)
            r7.append(r6)
            java.lang.String r6 = r7.toString()
            com.tencent.smtt.utils.TbsLog.e(r1, r6)
        Ld2:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.smtt.sdk.QbSdk.clearAllWebViewCache(android.content.Context, boolean):void");
    }

    public static void closeFileReader(Context context) {
        t a2 = t.a();
        a2.a(context);
        if (a2.b()) {
            a2.c().p();
        }
    }

    public static void continueLoadSo(Context context) {
        if ("com.tencent.mm".equals(getCurrentProcessName(context)) && WebView.mWebViewCreated) {
            com.tencent.smtt.utils.k.a(r, "continueLoadSo", (Class<?>[]) new Class[0], new Object[0]);
        }
    }

    public static boolean createMiniQBShortCut(Context context, String str, String str2, Drawable drawable) {
        t a2;
        if (context != null && !TbsDownloader.getOverSea(context) && !isMiniQBShortCutExist(context, str, str2) && (a2 = t.a()) != null && a2.b()) {
            Bitmap bitmap = drawable instanceof BitmapDrawable ? ((BitmapDrawable) drawable).getBitmap() : null;
            DexLoader b2 = a2.c().b();
            TbsLog.e("QbSdk", "qbsdk createMiniQBShortCut");
            Object invokeStaticMethod = b2.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "createMiniQBShortCut", new Class[]{Context.class, String.class, String.class, Bitmap.class}, context, str, str2, bitmap);
            TbsLog.e("QbSdk", "qbsdk after createMiniQBShortCut ret: " + invokeStaticMethod);
            if (invokeStaticMethod != null) {
                return true;
            }
        }
        return false;
    }

    public static boolean deleteMiniQBShortCut(Context context, String str, String str2) {
        t a2;
        return (context == null || TbsDownloader.getOverSea(context) || (a2 = t.a()) == null || !a2.b() || a2.c().b().invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "deleteMiniQBShortCut", new Class[]{Context.class, String.class, String.class}, context, str, str2) == null) ? false : true;
    }

    public static void disAllowThirdAppDownload() {
        f930c = false;
    }

    public static void disableAutoCreateX5Webview() {
        j = false;
    }

    public static void fileInfoDetect(Context context, String str, android.webkit.ValueCallback<String> valueCallback) {
        t a2 = t.a();
        if (a2 == null || !a2.b()) {
            return;
        }
        try {
            a2.c().b().invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "fileInfoDetect", new Class[]{Context.class, String.class, android.webkit.ValueCallback.class}, context, str, valueCallback);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public static void forceSysWebView() {
        b = true;
        u = "SysWebViewForcedByOuter: " + Log.getStackTraceString(new Throwable());
        TbsLog.e("QbSdk", "sys WebView: SysWebViewForcedByOuter");
    }

    public static long getApkFileSize(Context context) {
        if (context != null) {
            return TbsDownloadConfig.getInstance(context.getApplicationContext()).mPreferences.getLong(TbsDownloadConfig.TbsConfigKey.KEY_TBSAPKFILESIZE, 0L);
        }
        return 0L;
    }

    public static String getCurrentProcessName(Context context) {
        try {
            int myPid = Process.myPid();
            String str = "";
            for (ActivityManager.RunningAppProcessInfo runningAppProcessInfo : ((ActivityManager) context.getApplicationContext().getSystemService("activity")).getRunningAppProcesses()) {
                if (runningAppProcessInfo.pid == myPid) {
                    str = runningAppProcessInfo.processName;
                }
            }
            return str;
        } catch (Throwable unused) {
            return "";
        }
    }

    public static String[] getDexLoaderFileList(Context context, Context context2, String str) {
        String[] strArr = t;
        if (strArr instanceof String[]) {
            int length = strArr.length;
            String[] strArr2 = new String[length];
            for (int i2 = 0; i2 < length; i2++) {
                strArr2[i2] = str + t[i2];
            }
            return strArr2;
        }
        Object a2 = com.tencent.smtt.utils.k.a(r, "getJarFiles", (Class<?>[]) new Class[]{Context.class, Context.class, String.class}, context, context2, str);
        if (!(a2 instanceof String[])) {
            a2 = new String[]{""};
        }
        return (String[]) a2;
    }

    public static boolean getDownloadWithoutWifi() {
        return F;
    }

    public static boolean getIsSysWebViewForcedByOuter() {
        return b;
    }

    public static boolean getJarFilesAndLibraryPath(Context context) {
        Object obj = r;
        if (obj == null) {
            TbsLog.i("QbSdk", "getJarFilesAndLibraryPath sExtensionObj is null");
            return false;
        }
        Bundle bundle = (Bundle) com.tencent.smtt.utils.k.a(obj, "canLoadX5CoreAndNotLoadSo", (Class<?>[]) new Class[]{Integer.TYPE}, 43697);
        if (bundle == null) {
            TbsLog.i("QbSdk", "getJarFilesAndLibraryPath bundle is null and coreverison is " + l.a().a(true, context));
            return false;
        }
        t = bundle.getStringArray("tbs_jarfiles");
        d = bundle.getString("tbs_librarypath");
        return true;
    }

    public static String getMiniQBVersion(Context context) {
        t a2 = t.a();
        a2.a(context);
        if (a2 == null || !a2.b()) {
            return null;
        }
        return a2.c().f();
    }

    public static boolean getOnlyDownload() {
        return k;
    }

    public static String getQQBuildNumber() {
        return A;
    }

    public static Map<String, Object> getSettings() {
        return n;
    }

    public static boolean getTBSInstalling() {
        return G;
    }

    public static String getTID() {
        return z;
    }

    public static String getTbsResourcesPath(Context context) {
        return TbsShareManager.g(context);
    }

    public static int getTbsSdkVersion() {
        return 43697;
    }

    public static int getTbsVersion(Context context) {
        if (TbsShareManager.isThirdPartyApp(context)) {
            return TbsShareManager.a(context, false);
        }
        return l.a().i(context);
    }

    public static int getTbsVersionForCrash(Context context) {
        if (TbsShareManager.isThirdPartyApp(context)) {
            return TbsShareManager.a(context, false);
        }
        int j2 = l.a().j(context);
        if (j2 == 0 && j.a(context).c() == 3) {
            reset(context);
        }
        return j2;
    }

    public static int getTmpDirTbsVersion(Context context) {
        if (j.a(context).c() == 2) {
            return l.a().e(context, 0);
        }
        if (j.a(context).b("copy_status") == 1) {
            return l.a().e(context, 1);
        }
        return 0;
    }

    public static void initBuglyAsync(boolean z2) {
        i = z2;
    }

    public static void initForinitAndNotLoadSo(Context context) {
        if (q == null) {
            File q2 = l.a().q(context);
            if (q2 == null) {
                Log.e("QbSdk", "QbSdk initForinitAndNotLoadSo optDir == null");
                return;
            }
            File file = new File(q2, "tbs_sdk_extension_dex.jar");
            if (!file.exists()) {
                Log.e("QbSdk", "QbSdk initForinitAndNotLoadSo dexFile.exists()=false");
                return;
            }
            String absolutePath = q2.getAbsolutePath();
            t.a().b(context);
            com.tencent.smtt.utils.m.a(context);
            q = new DexLoader(file.getParent(), context, new String[]{file.getAbsolutePath()}, absolutePath, getSettings()).loadClass("com.tencent.tbs.sdk.extension.TbsSDKExtension");
        }
    }

    public static void initTbsSettings(Map<String, Object> map) {
        Map<String, Object> map2 = n;
        if (map2 == null) {
            n = map;
            return;
        }
        try {
            map2.putAll(map);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public static void initX5Environment(final Context context, final PreInitCallback preInitCallback) {
        if (context == null) {
            TbsLog.e("QbSdk", "initX5Environment,context=null");
            return;
        }
        b(context);
        E = new TbsListener() { // from class: com.tencent.smtt.sdk.QbSdk.5
            @Override // com.tencent.smtt.sdk.TbsListener
            public void onDownloadFinish(int i2) {
            }

            @Override // com.tencent.smtt.sdk.TbsListener
            public void onDownloadProgress(int i2) {
            }

            @Override // com.tencent.smtt.sdk.TbsListener
            public void onInstallFinish(int i2) {
                QbSdk.preInit(context, preInitCallback);
            }
        };
        if (TbsShareManager.isThirdPartyApp(context)) {
            l.a().b(context, d.a == 0);
        }
        TbsDownloader.needDownload(context, false, false, true, new TbsDownloader.TbsDownloaderCallback() { // from class: com.tencent.smtt.sdk.QbSdk.6
            @Override // com.tencent.smtt.sdk.TbsDownloader.TbsDownloaderCallback
            public void onNeedDownloadFinish(boolean z2, int i2) {
                if (TbsShareManager.findCoreForThirdPartyApp(context) == 0 && !TbsShareManager.getCoreDisabled()) {
                    TbsShareManager.forceToLoadX5ForThirdApp(context, false);
                }
                if (QbSdk.i && TbsShareManager.isThirdPartyApp(context)) {
                    TbsExtensionFunctionManager.getInstance().initTbsBuglyIfNeed(context);
                }
                QbSdk.preInit(context, preInitCallback);
            }
        });
    }

    public static boolean installLocalQbApk(Context context, String str, String str2, Bundle bundle) {
        d a2 = d.a(true);
        a2.a(context, false, false);
        if (a2 == null || !a2.b()) {
            return false;
        }
        return a2.a().a(context, str, str2, bundle);
    }

    public static boolean intentDispatch(WebView webView, Intent intent, String str, String str2) {
        String str3;
        if (webView == null) {
            return false;
        }
        if (str.startsWith("mttbrowser://miniqb/ch=icon?")) {
            Context context = webView.getContext();
            int indexOf = str.indexOf("url=");
            String substring = indexOf > 0 ? str.substring(indexOf + 4) : null;
            HashMap hashMap = new HashMap();
            try {
                str3 = context.getApplicationInfo().packageName;
            } catch (Exception e2) {
                e2.printStackTrace();
                str3 = "unknown";
            }
            hashMap.put(LOGIN_TYPE_KEY_PARTNER_ID, str3);
            hashMap.put(LOGIN_TYPE_KEY_PARTNER_CALL_POS, "14004");
            if (com.tencent.smtt.sdk.a.c.a(context, "miniqb://home".equals(substring) ? "qb://navicard/addCard?cardId=168&cardName=168" : substring, hashMap, "QbSdk.startMiniQBToLoadUrl", null) != 0) {
                t a2 = t.a();
                if (a2 != null && a2.b() && a2.c().a(context, substring, null, str2, null) == 0) {
                    return true;
                }
                webView.loadUrl(substring);
            }
        } else {
            webView.loadUrl(str);
        }
        return false;
    }

    public static boolean isMiniQBShortCutExist(Context context, String str, String str2) {
        t a2;
        Object invokeStaticMethod;
        if (context == null || TbsDownloader.getOverSea(context) || (a2 = t.a()) == null || !a2.b() || (invokeStaticMethod = a2.c().b().invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "isMiniQBShortCutExist", new Class[]{Context.class, String.class}, context, str)) == null) {
            return false;
        }
        Boolean bool = Boolean.FALSE;
        if (invokeStaticMethod instanceof Boolean) {
            bool = (Boolean) invokeStaticMethod;
        }
        return bool.booleanValue();
    }

    public static boolean isNeedInitX5FirstTime() {
        return w;
    }

    public static boolean isSuportOpenFile(String str, int i2) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        String[] strArr = {"rar", com.sigmob.sdk.archives.d.e, "tar", "bz2", "gz", "7z", "doc", "docx", "ppt", "pptx", "xls", "xlsx", "txt", "pdf", "epub", "chm", "html", "htm", "xml", "mht", "url", "ini", "log", "bat", "php", "js", "lrc", "jpg", "jpeg", "png", "gif", "bmp", "tiff", "webp", "mp3", "m4a", "aac", "amr", "wav", "ogg", "mid", "ra", "wma", "mpga", "ape", "flac", "RTSP", "RTP", "SDP", "RTMP", "mp4", "flv", "avi", "3gp", "3gpp", "webm", "ts", "ogv", "m3u8", "asf", "wmv", "rmvb", "rm", "f4v", "dat", "mov", "mpg", "mkv", "mpeg", "mpeg1", "mpeg2", "xvid", "dvd", "vcd", "vob", "divx"};
        String[] strArr2 = {"doc", "docx", "ppt", "pptx", "xls", "xlsx", "txt", "pdf", "epub"};
        if (i2 == 1) {
            return Arrays.asList(strArr2).contains(str.toLowerCase());
        }
        if (i2 != 2) {
            return false;
        }
        return Arrays.asList(strArr).contains(str.toLowerCase());
    }

    public static boolean isTbsCoreInited() {
        d a2 = d.a(false);
        return a2 != null && a2.g();
    }

    public static boolean isX5DisabledSync(Context context) {
        if (j.a(context).c() == 2) {
            return false;
        }
        if (!c(context)) {
            return true;
        }
        int i2 = l.a().i(context);
        Object obj = r;
        Class cls = Integer.TYPE;
        Object a2 = com.tencent.smtt.utils.k.a(obj, "isX5DisabledSync", (Class<?>[]) new Class[]{cls, cls}, Integer.valueOf(i2), 43697);
        if (a2 != null) {
            return ((Boolean) a2).booleanValue();
        }
        return true;
    }

    public static void loadTBSSDKExtension(Context context, String str) {
        Constructor<?> constructor;
        boolean z2;
        if (r != null) {
            return;
        }
        synchronized (QbSdk.class) {
            if (r != null) {
                return;
            }
            if (q == null) {
                TbsLog.i("QbSdk", "QbSdk loadTBSSDKExtension sExtensionClass is null");
            }
            try {
                constructor = q.getConstructor(Context.class, Context.class, String.class, String.class, String.class);
                z2 = true;
            } catch (Throwable unused) {
                constructor = null;
                z2 = false;
            }
            try {
                if (TbsShareManager.isThirdPartyApp(context)) {
                    Context e2 = TbsShareManager.e(context);
                    if (e2 == null && TbsShareManager.getHostCorePathAppDefined() == null) {
                        TbsLogReport.getInstance(context.getApplicationContext()).setLoadErrorCode(TbsListener.ErrorCode.HOST_CONTEXT_IS_NULL, "host context is null!");
                    } else if (z2) {
                        r = constructor.newInstance(context, e2, TbsShareManager.getHostCorePathAppDefined(), str, null);
                    } else if (e2 == null) {
                        r = q.getConstructor(Context.class, Context.class, String.class).newInstance(context, e2, TbsShareManager.getHostCorePathAppDefined(), str, null);
                    } else {
                        r = q.getConstructor(Context.class, Context.class).newInstance(context, e2);
                    }
                } else if (!z2) {
                    Constructor<?> constructor2 = q.getConstructor(Context.class, Context.class);
                    if (context.getApplicationContext() != null) {
                        context = context.getApplicationContext();
                    }
                    r = constructor2.newInstance(context, context);
                } else {
                    String str2 = (!"com.tencent.mm".equals(getCurrentProcessName(context)) || WebView.mWebViewCreated) ? null : "notLoadSo";
                    if (context.getApplicationContext() != null) {
                        context = context.getApplicationContext();
                    }
                    r = constructor.newInstance(context, context, null, str, str2);
                }
            } catch (Throwable th) {
                TbsLog.e("QbSdk", "throwable" + Log.getStackTraceString(th));
            }
        }
    }

    public static void openBrowserList(Context context, String str, ValueCallback<String> valueCallback) {
        openBrowserList(context, str, null, valueCallback);
    }

    public static int openFileReader(Context context, String str, HashMap<String, String> hashMap, ValueCallback<String> valueCallback) {
        TbsCoreLoadStat.getInstance().a(context, TbsListener.ErrorCode.INFO_CODE_FILEREADER_OPENFILEREADER_COUNTS);
        if (!checkContentProviderPrivilage(context)) {
            return -5;
        }
        if (str != null) {
            String substring = str.substring(str.lastIndexOf(".") + 1, str.length());
            if ("apk".equalsIgnoreCase(substring)) {
                Intent intent = new Intent("android.intent.action.VIEW");
                if (context != null && context.getApplicationInfo().targetSdkVersion >= 24 && Build.VERSION.SDK_INT >= 24) {
                    intent.addFlags(1);
                }
                Uri a2 = FileProvider.a(context, str);
                if (a2 == null) {
                    valueCallback.onReceiveValue("uri failed");
                    return -6;
                }
                intent.setDataAndType(a2, AdBaseConstants.MIME_APK);
                context.startActivity(intent);
                TbsCoreLoadStat.getInstance().a(context, TbsListener.ErrorCode.INFO_CODE_FILEREADER_OPENFILEREADER_APKFILE);
                Log.e("QbSdk", "open openFileReader ret = 4");
                return 4;
            }
            if (com.tencent.smtt.sdk.a.c.b(context)) {
                if (!a(context, str, substring)) {
                    Log.e("QbSdk", "openFileReader open in QB isQBSupport: false  ret = 3");
                    openFileReaderListWithQBDownload(context, str, valueCallback);
                    TbsCoreLoadStat.getInstance().a(context, TbsListener.ErrorCode.INFO_CODE_FILEREADER_OPENFILEREADER_NOTSUPPORT);
                    return 3;
                }
                if (startQBForDoc(context, str, 4, 0, substring, a(context, hashMap))) {
                    if (valueCallback != null) {
                        valueCallback.onReceiveValue("open QB");
                    }
                    TbsCoreLoadStat.getInstance().a(context, TbsListener.ErrorCode.INFO_CODE_FILEREADER_OPENFILEREADER_NOTSUPPORT);
                    Log.e("QbSdk", "open openFileReader open QB ret = 1");
                    return 1;
                }
                Log.d("QbSdk", "openFileReader startQBForDoc return false");
            } else {
                Log.d("QbSdk", "openFileReader QQ browser not installed");
            }
            if (hashMap == null) {
                hashMap = new HashMap<>();
            }
            hashMap.put("local", "true");
            TbsLog.setWriteLogJIT(true);
            int startMiniQBToLoadUrl = startMiniQBToLoadUrl(context, str, hashMap, valueCallback);
            if (startMiniQBToLoadUrl != 0) {
                openFileReaderListWithQBDownload(context, str, valueCallback);
                TbsLogReport.getInstance(context).setLoadErrorCode(TbsListener.ErrorCode.INFO_CODE_FILEREADER_OPENFILEREADER_MINIQBFAILED, "" + startMiniQBToLoadUrl);
                return 3;
            }
            TbsCoreLoadStat.getInstance().a(context, TbsListener.ErrorCode.INFO_CODE_FILEREADER_OPENFILEREADER_MINIQBSUCCESS);
            return 2;
        }
        if (valueCallback != null) {
            valueCallback.onReceiveValue("filepath error");
        }
        TbsCoreLoadStat.getInstance().a(context, TbsListener.ErrorCode.INFO_CODE_FILEREADER_OPENFILEREADER_FILEPATHISNULL);
        Log.e("QbSdk", "open openFileReader filepath error ret -1");
        return -1;
    }

    public static void openFileReaderListWithQBDownload(Context context, String str, ValueCallback<String> valueCallback) {
        openFileReaderListWithQBDownload(context, str, null, valueCallback);
    }

    public static synchronized void preInit(Context context) {
        synchronized (QbSdk.class) {
            preInit(context, null);
        }
    }

    public static void reset(Context context) {
        reset(context, false);
    }

    public static void resetDecoupleCore(Context context) {
        TbsLog.e("QbSdk", "QbSdk resetDecoupleCore!", true);
        try {
            com.tencent.smtt.utils.f.b(l.a().p(context));
        } catch (Throwable th) {
            TbsLog.e("QbSdk", "QbSdk resetDecoupleCore exception:" + Log.getStackTraceString(th));
        }
    }

    public static void setCurrentID(String str) {
        if (str != null && str.startsWith(TID_QQNumber_Prefix)) {
            String substring = str.substring(3);
            z = "0000000000000000".substring(substring.length()) + substring;
        }
    }

    public static void setDisableUnpreinitBySwitch(boolean z2) {
        B = z2;
        TbsLog.i("QbSdk", "setDisableUnpreinitBySwitch -- mDisableUnpreinitBySwitch is " + B);
    }

    public static void setDisableUseHostBackupCoreBySwitch(boolean z2) {
        mDisableUseHostBackupCore = z2;
        TbsLog.i("QbSdk", "setDisableUseHostBackupCoreBySwitch -- mDisableUseHostBackupCore is " + mDisableUseHostBackupCore);
    }

    public static void setDownloadWithoutWifi(boolean z2) {
        F = z2;
    }

    public static void setNeedInitX5FirstTime(boolean z2) {
        w = z2;
    }

    public static void setOnlyDownload(boolean z2) {
        k = z2;
    }

    public static void setQQBuildNumber(String str) {
        A = str;
    }

    public static void setTBSInstallingStatus(boolean z2) {
        G = z2;
    }

    public static void setTbsListener(TbsListener tbsListener) {
        D = tbsListener;
    }

    public static void setTbsLogClient(TbsLogClient tbsLogClient) {
        TbsLog.setTbsLogClient(tbsLogClient);
    }

    public static void setUploadCode(Context context, int i2) {
        if (i2 >= 130 && i2 <= 139) {
            TbsDownloadUpload tbsDownloadUpload = TbsDownloadUpload.getInstance(context);
            tbsDownloadUpload.a.put(TbsDownloadUpload.TbsUploadKey.KEY_NEEDDOWNLOAD_CODE, Integer.valueOf(i2));
            tbsDownloadUpload.commit();
        } else {
            if (i2 < 150 || i2 > 159) {
                return;
            }
            TbsDownloadUpload tbsDownloadUpload2 = TbsDownloadUpload.getInstance(context);
            tbsDownloadUpload2.a.put(TbsDownloadUpload.TbsUploadKey.KEY_STARTDOWNLOAD_CODE, Integer.valueOf(i2));
            tbsDownloadUpload2.commit();
        }
    }

    public static int startMiniQBToLoadUrl(Context context, String str, HashMap<String, String> hashMap, android.webkit.ValueCallback<String> valueCallback) {
        TbsCoreLoadStat.getInstance().a(context, TbsListener.ErrorCode.INFO_CODE_MINIQB_STARTMINIQBTOLOADURL_COUNTS);
        if (context == null) {
            return -100;
        }
        t a2 = t.a();
        a2.a(context);
        if (a2.b()) {
            if (context != null && context.getApplicationInfo().packageName.equals("com.nd.android.pandahome2") && getTbsVersion(context) < 25487) {
                return -101;
            }
            int a3 = a2.c().a(context, str, hashMap, null, valueCallback);
            if (a3 == 0) {
                TbsCoreLoadStat.getInstance().a(context, TbsListener.ErrorCode.INFO_CODE_MINIQB_STARTMINIQBTOLOADURL_SUCCESS);
            } else {
                TbsLogReport.getInstance(context).setLoadErrorCode(504, "" + a3);
            }
            Log.e("QbSdk", "startMiniQBToLoadUrl  ret = " + a3);
            return a3;
        }
        TbsCoreLoadStat.getInstance().a(context, TbsListener.ErrorCode.INFO_CODE_MINIQB_STARTMINIQBTOLOADURL_ISNOTX5CORE);
        Log.e("QbSdk", "startMiniQBToLoadUrl  ret = -102");
        return -102;
    }

    public static boolean startQBForDoc(Context context, String str, int i2, int i3, String str2, Bundle bundle) {
        HashMap hashMap = new HashMap();
        hashMap.put(LOGIN_TYPE_KEY_PARTNER_ID, context.getApplicationContext().getApplicationInfo().processName);
        hashMap.put(LOGIN_TYPE_KEY_PARTNER_CALL_POS, Integer.toString(i2));
        return com.tencent.smtt.sdk.a.c.a(context, str, i3, str2, hashMap, bundle);
    }

    public static boolean startQBForVideo(Context context, String str, int i2) {
        HashMap hashMap = new HashMap();
        hashMap.put(LOGIN_TYPE_KEY_PARTNER_ID, context.getApplicationInfo().processName);
        hashMap.put(LOGIN_TYPE_KEY_PARTNER_CALL_POS, Integer.toString(i2));
        return com.tencent.smtt.sdk.a.c.a(context, str, (HashMap<String, String>) hashMap);
    }

    public static boolean startQBToLoadurl(Context context, String str, int i2, WebView webView) {
        t a2;
        Object invokeStaticMethod;
        IX5WebViewBase iX5WebViewBase;
        HashMap hashMap = new HashMap();
        hashMap.put(LOGIN_TYPE_KEY_PARTNER_ID, context.getApplicationInfo().processName);
        hashMap.put(LOGIN_TYPE_KEY_PARTNER_CALL_POS, Integer.toString(i2));
        if (webView == null) {
            try {
                String str2 = context.getPackageManager().getPackageInfo(context.getPackageName(), 0).packageName;
                if ((str2 == "com.tencent.mm" || str2 == TbsConfig.APP_QQ) && (a2 = t.a()) != null && a2.b() && (invokeStaticMethod = a2.c().b().invokeStaticMethod("com.tencent.smtt.webkit.WebViewList", "getCurrentMainWebviewJustForQQandWechat", new Class[0], new Object[0])) != null && (iX5WebViewBase = (IX5WebViewBase) invokeStaticMethod) != null) {
                    webView = (WebView) iX5WebViewBase.getView().getParent();
                }
            } catch (Exception unused) {
            }
        }
        return com.tencent.smtt.sdk.a.c.a(context, str, hashMap, "QbSdk.startQBToLoadurl", webView) == 0;
    }

    public static boolean startQBWithBrowserlist(Context context, String str, int i2) {
        boolean startQBToLoadurl = startQBToLoadurl(context, str, i2, null);
        if (!startQBToLoadurl) {
            openBrowserList(context, str, null);
        }
        return startQBToLoadurl;
    }

    public static boolean startQbOrMiniQBToLoadUrl(Context context, String str, HashMap<String, String> hashMap, ValueCallback<String> valueCallback) {
        if (context == null) {
            return false;
        }
        t a2 = t.a();
        a2.a(context);
        if (hashMap != null && "5".equals(hashMap.get(LOGIN_TYPE_KEY_PARTNER_CALL_POS)) && a2.b()) {
        }
        if (com.tencent.smtt.sdk.a.c.a(context, str, hashMap, "QbSdk.startMiniQBToLoadUrl", null) != 0) {
            return a2.b() && (context == null || !context.getApplicationInfo().packageName.equals("com.nd.android.pandahome2") || getTbsVersion(context) >= 25487) && a2.c().a(context, str, hashMap, null, valueCallback) == 0;
        }
        return true;
    }

    public static void unForceSysWebView() {
        b = false;
        TbsLog.e("QbSdk", "sys WebView: unForceSysWebView called");
    }

    public static synchronized boolean unPreInit(Context context) {
        synchronized (QbSdk.class) {
        }
        return true;
    }

    public static boolean useSoftWare() {
        Object obj = r;
        if (obj == null) {
            return false;
        }
        Object a2 = com.tencent.smtt.utils.k.a(obj, "useSoftWare", (Class<?>[]) new Class[0], new Object[0]);
        if (a2 == null) {
            a2 = com.tencent.smtt.utils.k.a(r, "useSoftWare", (Class<?>[]) new Class[]{Integer.TYPE}, Integer.valueOf(a.a()));
        }
        if (a2 == null) {
            return false;
        }
        return ((Boolean) a2).booleanValue();
    }

    @SuppressLint({"NewApi"})
    private static boolean a(Context context, boolean z2) {
        int i2;
        File file;
        String absolutePath;
        TbsLog.initIfNeed(context);
        if (!sIsVersionPrinted) {
            TbsLog.i("QbSdk", "svn revision: jnizz; SDK_VERSION_CODE: 43697; SDK_VERSION_NAME: 4.3.0.1148");
            sIsVersionPrinted = true;
        }
        if (a && !z2) {
            TbsLog.e("QbSdk", "QbSdk init: " + v, false);
            TbsCoreLoadStat.getInstance().a(context, TbsListener.ErrorCode.INFO_SDKINIT_IS_SYS_FORCED, new Throwable(v));
            return false;
        }
        if (b) {
            TbsLog.e("QbSdk", "QbSdk init mIsSysWebViewForcedByOuter = true", true);
            TbsCoreLoadStat.getInstance().a(context, 402, new Throwable(u));
            return false;
        }
        if (!C) {
            d(context);
        }
        try {
            File q2 = l.a().q(context);
            if (q2 == null) {
                TbsLog.e("QbSdk", "QbSdk init (false) optDir == null");
                TbsCoreLoadStat.getInstance().a(context, TbsListener.ErrorCode.ERROR_TBSCORE_SHARE_DIR, new Throwable("QbSdk.init (false) TbsCoreShareDir is null"));
                return false;
            }
            if (TbsShareManager.isThirdPartyApp(context)) {
                int i3 = o;
                if (i3 != 0 && i3 != TbsShareManager.d(context)) {
                    q = null;
                    r = null;
                    TbsLog.e("QbSdk", "QbSdk init (false) ERROR_UNMATCH_TBSCORE_VER_THIRDPARTY!");
                    TbsCoreLoadStat.getInstance().a(context, 302, new Throwable("sTbsVersion: " + o + "; AvailableTbsCoreVersion: " + TbsShareManager.d(context)));
                    return false;
                }
                o = TbsShareManager.d(context);
            } else {
                if (o != 0) {
                    i2 = l.a().a(true, context);
                    if (o != i2) {
                        q = null;
                        r = null;
                        TbsLog.e("QbSdk", "QbSdk init (false) not isThirdPartyApp tbsCoreInstalledVer=" + i2, true);
                        TbsLog.e("QbSdk", "QbSdk init (false) not isThirdPartyApp sTbsVersion=" + o, true);
                        TbsCoreLoadStat.getInstance().a(context, 303, new Throwable("sTbsVersion: " + o + "; tbsCoreInstalledVer: " + i2));
                        return false;
                    }
                } else {
                    i2 = 0;
                }
                o = i2;
            }
            if (q != null && r != null) {
                return true;
            }
            if (TbsShareManager.isThirdPartyApp(context)) {
                if (TbsShareManager.j(context)) {
                    file = new File(TbsShareManager.c(context), "tbs_sdk_extension_dex.jar");
                } else {
                    TbsCoreLoadStat.getInstance().a(context, 304, new Throwable("isShareTbsCoreAvailable false!"));
                    return false;
                }
            } else {
                file = new File(l.a().q(context), "tbs_sdk_extension_dex.jar");
            }
            if (!file.exists()) {
                try {
                    TbsLog.e("QbSdk", "QbSdk init (false) tbs_sdk_extension_dex.jar is not exist!");
                    int i4 = l.a().i(context);
                    if (new File(file.getParentFile(), "tbs_jars_fusion_dex.jar").exists()) {
                        if (i4 > 0) {
                            TbsCoreLoadStat.getInstance().a(context, TbsListener.ErrorCode.INFO_MISS_SDKEXTENSION_JAR_WITH_FUSION_DEX_WITH_CORE, new Exception("tbs_sdk_extension_dex not exist(with fusion dex)!" + i4));
                        } else {
                            TbsCoreLoadStat.getInstance().a(context, TbsListener.ErrorCode.INFO_MISS_SDKEXTENSION_JAR_WITH_FUSION_DEX_WITHOUT_CORE, new Exception("tbs_sdk_extension_dex not exist(with fusion dex)!" + i4));
                        }
                    } else if (i4 > 0) {
                        TbsCoreLoadStat.getInstance().a(context, TbsListener.ErrorCode.INFO_INFO_MISS_SDKEXTENSION_JAR_WITHOUT_FUSION_DEX_WITH_CORE, new Exception("tbs_sdk_extension_dex not exist(without fusion dex)!" + i4));
                    } else {
                        TbsCoreLoadStat.getInstance().a(context, TbsListener.ErrorCode.INFO_INFO_MISS_SDKEXTENSION_JAR_WITHOUT_FUSION_DEX_WITHOUT_CORE, new Exception("tbs_sdk_extension_dex not exist(without fusion dex)!" + i4));
                    }
                } catch (Throwable th) {
                    th.printStackTrace();
                }
                return false;
            }
            if (TbsShareManager.getHostCorePathAppDefined() != null) {
                absolutePath = TbsShareManager.getHostCorePathAppDefined();
            } else {
                absolutePath = q2.getAbsolutePath();
            }
            String str = absolutePath;
            TbsLog.i("QbSdk", "QbSdk init optDirExtension #1 is " + str);
            TbsLog.i("QbSdk", "new DexLoader #1 dexFile is " + file.getAbsolutePath());
            t.a().b(context);
            com.tencent.smtt.utils.m.a(context);
            q = new DexLoader(file.getParent(), context, new String[]{file.getAbsolutePath()}, str, getSettings()).loadClass("com.tencent.tbs.sdk.extension.TbsSDKExtension");
            loadTBSSDKExtension(context, file.getParent());
            com.tencent.smtt.utils.k.a(r, "setClientVersion", (Class<?>[]) new Class[]{Integer.TYPE}, 1);
            return true;
        } catch (Throwable th2) {
            TbsLog.e("QbSdk", "QbSdk init Throwable: " + Log.getStackTraceString(th2));
            TbsCoreLoadStat.getInstance().a(context, TbsListener.ErrorCode.THROWABLE_QBSDK_INIT, th2);
            return false;
        }
    }

    private static boolean c(Context context) {
        File file;
        String absolutePath;
        try {
            if (q != null) {
                return true;
            }
            File q2 = l.a().q(context);
            if (q2 == null) {
                TbsLog.e("QbSdk", "QbSdk initForX5DisableConfig (false) optDir == null");
                return false;
            }
            if (TbsShareManager.isThirdPartyApp(context)) {
                if (TbsShareManager.j(context)) {
                    file = new File(TbsShareManager.c(context), "tbs_sdk_extension_dex.jar");
                } else {
                    TbsCoreLoadStat.getInstance().a(context, 304);
                    return false;
                }
            } else {
                file = new File(l.a().q(context), "tbs_sdk_extension_dex.jar");
            }
            if (!file.exists()) {
                TbsCoreLoadStat.getInstance().a(context, 406, new Exception("initForX5DisableConfig failure -- tbs_sdk_extension_dex.jar is not exist!"));
                return false;
            }
            if (TbsShareManager.getHostCorePathAppDefined() != null) {
                absolutePath = TbsShareManager.getHostCorePathAppDefined();
            } else {
                absolutePath = q2.getAbsolutePath();
            }
            String str = absolutePath;
            TbsLog.i("QbSdk", "QbSdk init optDirExtension #3 is " + str);
            TbsLog.i("QbSdk", "new DexLoader #4 dexFile is " + file.getAbsolutePath());
            t.a().b(context);
            com.tencent.smtt.utils.m.a(context);
            q = new DexLoader(file.getParent(), context, new String[]{file.getAbsolutePath()}, str, getSettings()).loadClass("com.tencent.tbs.sdk.extension.TbsSDKExtension");
            loadTBSSDKExtension(context, file.getParent());
            com.tencent.smtt.utils.k.a(r, "setClientVersion", (Class<?>[]) new Class[]{Integer.TYPE}, 1);
            return true;
        } catch (Throwable th) {
            TbsLog.e("QbSdk", "initForX5DisableConfig sys WebView: " + Log.getStackTraceString(th));
            return false;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:24:0x00f8  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x007b A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static void d(android.content.Context r11) {
        /*
            Method dump skipped, instructions count: 336
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.smtt.sdk.QbSdk.d(android.content.Context):void");
    }

    public static void openBrowserList(Context context, String str, Bundle bundle, final ValueCallback<String> valueCallback) {
        if (context == null) {
            return;
        }
        String string = bundle != null ? bundle.getString("ChannelId") : "";
        Intent intent = new Intent("android.intent.action.VIEW");
        intent.addCategory("android.intent.category.DEFAULT");
        intent.setData(Uri.parse(str));
        String c2 = com.tencent.smtt.sdk.b.a.d.c(str);
        isDefaultDialog = false;
        com.tencent.smtt.sdk.b.a.c cVar = new com.tencent.smtt.sdk.b.a.c(context, "选择其它应用打开", intent, valueCallback, c2, string);
        String a2 = cVar.a();
        if (a2 != null && !TextUtils.isEmpty(a2)) {
            if (TbsConfig.APP_QB.equals(a2)) {
                intent.putExtra(LOGIN_TYPE_KEY_PARTNER_ID, context.getApplicationContext().getPackageName());
                intent.putExtra(LOGIN_TYPE_KEY_PARTNER_CALL_POS, GlobalSetting.NATIVE_EXPRESS_AD);
            }
            intent.setPackage(a2);
            intent.putExtra("big_brother_source_key", string);
            context.startActivity(intent);
            if (valueCallback != null) {
                valueCallback.onReceiveValue("default browser:" + a2);
                return;
            }
            return;
        }
        if (isDefaultDialog) {
            new AlertDialog.Builder(context).setTitle("提示").setMessage("此文件无法打开").setPositiveButton("确定", new DialogInterface.OnClickListener() { // from class: com.tencent.smtt.sdk.QbSdk.10
                @Override // android.content.DialogInterface.OnClickListener
                public void onClick(DialogInterface dialogInterface, int i2) {
                }
            }).show();
            if (valueCallback != null) {
                valueCallback.onReceiveValue("can not open");
                return;
            }
            return;
        }
        cVar.show();
        cVar.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.tencent.smtt.sdk.QbSdk.2
            @Override // android.content.DialogInterface.OnDismissListener
            public void onDismiss(DialogInterface dialogInterface) {
                ValueCallback valueCallback2 = ValueCallback.this;
                if (valueCallback2 != null) {
                    valueCallback2.onReceiveValue("TbsReaderDialogClosed");
                }
            }
        });
    }

    public static void openFileReaderListWithQBDownload(Context context, String str, Bundle bundle, final ValueCallback<String> valueCallback) {
        if (context == null || context.getApplicationInfo().packageName.equals("com.tencent.qim") || context.getApplicationInfo().packageName.equals("com.tencent.tim") || context.getApplicationInfo().packageName.equals("com.tencent.androidqqmail")) {
            return;
        }
        String string = bundle != null ? bundle.getString("ChannelId") : "";
        Intent intent = new Intent("android.intent.action.VIEW");
        intent.addCategory("android.intent.category.DEFAULT");
        String c2 = com.tencent.smtt.sdk.b.a.d.c(str);
        if (context != null && context.getApplicationInfo().targetSdkVersion >= 24 && Build.VERSION.SDK_INT >= 24) {
            intent.addFlags(1);
        }
        Uri a2 = FileProvider.a(context, str);
        if (a2 == null) {
            valueCallback.onReceiveValue("uri failed");
            return;
        }
        intent.setDataAndType(a2, c2);
        isDefaultDialog = false;
        com.tencent.smtt.sdk.b.a.c cVar = new com.tencent.smtt.sdk.b.a.c(context, "选择其它应用打开", intent, valueCallback, c2, string);
        String a3 = cVar.a();
        if (a3 != null && !TextUtils.isEmpty(a3) && checkApkExist(context, a3)) {
            if (TbsConfig.APP_QB.equals(a3)) {
                intent.putExtra(LOGIN_TYPE_KEY_PARTNER_ID, context.getApplicationContext().getPackageName());
                intent.putExtra(LOGIN_TYPE_KEY_PARTNER_CALL_POS, GlobalSetting.NATIVE_EXPRESS_AD);
            }
            if (!TextUtils.isEmpty(string)) {
                intent.putExtra("big_brother_source_key", string);
            }
            intent.setPackage(a3);
            context.startActivity(intent);
            if (valueCallback != null) {
                valueCallback.onReceiveValue("default browser:" + a3);
                return;
            }
            return;
        }
        if ("com.tencent.rtxlite".equalsIgnoreCase(context.getApplicationContext().getPackageName()) && isDefaultDialog) {
            new AlertDialog.Builder(context).setTitle("提示").setMessage("此文件无法打开").setPositiveButton("确定", new DialogInterface.OnClickListener() { // from class: com.tencent.smtt.sdk.QbSdk.8
                @Override // android.content.DialogInterface.OnClickListener
                public void onClick(DialogInterface dialogInterface, int i2) {
                }
            }).show();
            return;
        }
        if (isDefaultDialog) {
            if (valueCallback != null) {
                valueCallback.onReceiveValue("can not open");
            }
        } else {
            try {
                cVar.show();
                cVar.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.tencent.smtt.sdk.QbSdk.9
                    @Override // android.content.DialogInterface.OnDismissListener
                    public void onDismiss(DialogInterface dialogInterface) {
                        ValueCallback valueCallback2 = ValueCallback.this;
                        if (valueCallback2 != null) {
                            valueCallback2.onReceiveValue("TbsReaderDialogClosed");
                        }
                    }
                });
            } catch (Exception e2) {
                e2.printStackTrace();
                valueCallback.onReceiveValue("TbsReaderDialogClosed");
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x005b A[Catch: all -> 0x007b, TryCatch #0 {all -> 0x007b, blocks: (B:3:0x0008, B:5:0x000e, B:7:0x0014, B:11:0x002e, B:13:0x005b, B:15:0x0060), top: B:2:0x0008 }] */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0060 A[Catch: all -> 0x007b, TRY_LEAVE, TryCatch #0 {all -> 0x007b, blocks: (B:3:0x0008, B:5:0x000e, B:7:0x0014, B:11:0x002e, B:13:0x005b, B:15:0x0060), top: B:2:0x0008 }] */
    /* JADX WARN: Removed duplicated region for block: B:19:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static void reset(android.content.Context r5, boolean r6) {
        /*
            java.lang.String r0 = "QbSdk"
            java.lang.String r1 = "QbSdk reset!"
            r2 = 1
            com.tencent.smtt.utils.TbsLog.e(r0, r1, r2)
            com.tencent.smtt.sdk.TbsDownloader.stopDownload()     // Catch: java.lang.Throwable -> L7b
            r1 = 0
            if (r6 == 0) goto L2d
            boolean r6 = com.tencent.smtt.sdk.TbsShareManager.isThirdPartyApp(r5)     // Catch: java.lang.Throwable -> L7b
            if (r6 != 0) goto L2d
            com.tencent.smtt.sdk.l r6 = com.tencent.smtt.sdk.l.a()     // Catch: java.lang.Throwable -> L7b
            int r6 = r6.h(r5)     // Catch: java.lang.Throwable -> L7b
            com.tencent.smtt.sdk.l r3 = com.tencent.smtt.sdk.l.a()     // Catch: java.lang.Throwable -> L7b
            int r3 = r3.i(r5)     // Catch: java.lang.Throwable -> L7b
            r4 = 43300(0xa924, float:6.0676E-41)
            if (r6 <= r4) goto L2d
            if (r6 == r3) goto L2d
            r6 = 1
            goto L2e
        L2d:
            r6 = 0
        L2e:
            com.tencent.smtt.sdk.TbsDownloader.c(r5)     // Catch: java.lang.Throwable -> L7b
            java.lang.String r3 = "tbs"
            java.io.File r3 = r5.getDir(r3, r1)     // Catch: java.lang.Throwable -> L7b
            java.lang.String r4 = "core_share_decouple"
            com.tencent.smtt.utils.f.a(r3, r1, r4)     // Catch: java.lang.Throwable -> L7b
            java.lang.String r3 = "delete downloaded apk success"
            com.tencent.smtt.utils.TbsLog.i(r0, r3, r2)     // Catch: java.lang.Throwable -> L7b
            java.lang.ThreadLocal<java.lang.Integer> r2 = com.tencent.smtt.sdk.l.a     // Catch: java.lang.Throwable -> L7b
            java.lang.Integer r3 = java.lang.Integer.valueOf(r1)     // Catch: java.lang.Throwable -> L7b
            r2.set(r3)     // Catch: java.lang.Throwable -> L7b
            java.io.File r2 = new java.io.File     // Catch: java.lang.Throwable -> L7b
            java.io.File r3 = r5.getFilesDir()     // Catch: java.lang.Throwable -> L7b
            java.lang.String r4 = "bugly_switch.txt"
            r2.<init>(r3, r4)     // Catch: java.lang.Throwable -> L7b
            boolean r3 = r2.exists()     // Catch: java.lang.Throwable -> L7b
            if (r3 == 0) goto L5e
            r2.delete()     // Catch: java.lang.Throwable -> L7b
        L5e:
            if (r6 == 0) goto L94
            com.tencent.smtt.sdk.l r6 = com.tencent.smtt.sdk.l.a()     // Catch: java.lang.Throwable -> L7b
            java.io.File r6 = r6.p(r5)     // Catch: java.lang.Throwable -> L7b
            com.tencent.smtt.sdk.l r2 = com.tencent.smtt.sdk.l.a()     // Catch: java.lang.Throwable -> L7b
            java.io.File r1 = r2.f(r5, r1)     // Catch: java.lang.Throwable -> L7b
            com.tencent.smtt.utils.f.b(r6, r1)     // Catch: java.lang.Throwable -> L7b
            com.tencent.smtt.sdk.l r6 = com.tencent.smtt.sdk.l.a()     // Catch: java.lang.Throwable -> L7b
            r6.b(r5)     // Catch: java.lang.Throwable -> L7b
            goto L94
        L7b:
            r5 = move-exception
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            r6.<init>()
            java.lang.String r1 = "QbSdk reset exception:"
            r6.append(r1)
            java.lang.String r5 = android.util.Log.getStackTraceString(r5)
            r6.append(r5)
            java.lang.String r5 = r6.toString()
            com.tencent.smtt.utils.TbsLog.e(r0, r5)
        L94:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.smtt.sdk.QbSdk.reset(android.content.Context, boolean):void");
    }

    public static synchronized void preInit(final Context context, final PreInitCallback preInitCallback) {
        synchronized (QbSdk.class) {
            TbsLog.initIfNeed(context);
            TbsLog.i("QbSdk", "preInit -- processName: " + getCurrentProcessName(context));
            TbsLog.i("QbSdk", "preInit -- stack: " + Log.getStackTraceString(new Throwable("#")));
            l = a;
            if (!s) {
                final Handler handler = new Handler(Looper.getMainLooper()) { // from class: com.tencent.smtt.sdk.QbSdk.3
                    @Override // android.os.Handler
                    public void handleMessage(Message message) {
                        u c2;
                        PreInitCallback preInitCallback2;
                        int i2 = message.what;
                        if (i2 == 1) {
                            boolean unused = QbSdk.B = TbsExtensionFunctionManager.getInstance().canUseFunction(context, TbsExtensionFunctionManager.DISABLE_UNPREINIT);
                            if (QbSdk.j && (c2 = t.a().c()) != null) {
                                c2.a(context);
                            }
                            PreInitCallback preInitCallback3 = preInitCallback;
                            if (preInitCallback3 != null) {
                                preInitCallback3.onViewInitFinished(true);
                            }
                            TbsLog.writeLogToDisk();
                            return;
                        }
                        if (i2 != 2) {
                            if (i2 == 3 && (preInitCallback2 = preInitCallback) != null) {
                                preInitCallback2.onCoreInitFinished();
                                return;
                            }
                            return;
                        }
                        PreInitCallback preInitCallback4 = preInitCallback;
                        if (preInitCallback4 != null) {
                            preInitCallback4.onViewInitFinished(false);
                        }
                        TbsLog.writeLogToDisk();
                    }
                };
                Thread thread = new Thread() { // from class: com.tencent.smtt.sdk.QbSdk.4
                    @Override // java.lang.Thread, java.lang.Runnable
                    public void run() {
                        int a2 = l.a().a(true, context);
                        TbsDownloader.setAppContext(context);
                        TbsLog.i("QbSdk", "QbSdk preinit ver is " + a2);
                        if (a2 == 0) {
                            l.a().b(context, true);
                        }
                        TbsLog.i("QbSdk", "preInit -- prepare initAndLoadSo");
                        d.a(true).a(context, false, false);
                        t a3 = t.a();
                        a3.a(context);
                        boolean b2 = a3.b();
                        handler.sendEmptyMessage(3);
                        if (!b2) {
                            handler.sendEmptyMessage(2);
                        } else {
                            handler.sendEmptyMessage(1);
                        }
                    }
                };
                thread.setName("tbs_preinit");
                thread.setPriority(10);
                thread.start();
                s = true;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static String b() {
        Object invokeStaticMethod;
        t a2 = t.a();
        if (a2 == null || !a2.b() || (invokeStaticMethod = a2.c().b().invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "getGUID", new Class[0], new Object[0])) == null || !(invokeStaticMethod instanceof String)) {
            return null;
        }
        return (String) invokeStaticMethod;
    }

    static boolean a(Context context) {
        try {
            if (q != null) {
                return true;
            }
            File q2 = l.a().q(context);
            if (q2 == null) {
                TbsLog.e("QbSdk", "QbSdk initExtension (false) optDir == null");
                return false;
            }
            File file = new File(q2, "tbs_sdk_extension_dex.jar");
            if (!file.exists()) {
                TbsLog.e("QbSdk", "QbSdk initExtension (false) dexFile.exists()=false", true);
                return false;
            }
            TbsLog.i("QbSdk", "new DexLoader #3 dexFile is " + file.getAbsolutePath());
            t.a().b(context);
            com.tencent.smtt.utils.m.a(context);
            q = new DexLoader(file.getParent(), context, new String[]{file.getAbsolutePath()}, q2.getAbsolutePath(), getSettings()).loadClass("com.tencent.tbs.sdk.extension.TbsSDKExtension");
            loadTBSSDKExtension(context, file.getParent());
            return true;
        } catch (Throwable th) {
            TbsLog.e("QbSdk", "initExtension sys WebView: " + Log.getStackTraceString(th));
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Bundle a(Context context, Bundle bundle) {
        if (!a(context)) {
            TbsLogReport.getInstance(context).setInstallErrorCode(TbsListener.ErrorCode.INCR_UPDATE_ERROR, "initForPatch return false!");
            return null;
        }
        Object a2 = com.tencent.smtt.utils.k.a(r, "incrUpdate", (Class<?>[]) new Class[]{Context.class, Bundle.class}, context, bundle);
        if (a2 != null) {
            return (Bundle) a2;
        }
        TbsLogReport.getInstance(context).setInstallErrorCode(TbsListener.ErrorCode.INCR_UPDATE_ERROR, "incrUpdate return null!");
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean a(Context context, int i2) {
        return a(context, i2, AdBaseConstants.DEFAULT_INSTALL_FINISH_TRY_INTERVAL_MS);
    }

    static boolean a(Context context, int i2, int i3) {
        Map<String, Object> map = n;
        if (map != null && map.containsKey(KEY_SET_SENDREQUEST_AND_UPLOAD) && n.get(KEY_SET_SENDREQUEST_AND_UPLOAD).equals("false")) {
            TbsLog.i("QbSdk", "[QbSdk.isX5Disabled] -- SET_SENDREQUEST_AND_UPLOAD is false");
            return true;
        }
        l.a().b(context, d.a == 0);
        if (!c(context)) {
            return true;
        }
        Object obj = r;
        Class cls = Integer.TYPE;
        Object a2 = com.tencent.smtt.utils.k.a(obj, "isX5Disabled", (Class<?>[]) new Class[]{cls, cls, cls}, Integer.valueOf(i2), 43697, Integer.valueOf(i3));
        if (a2 != null) {
            return ((Boolean) a2).booleanValue();
        }
        Object a3 = com.tencent.smtt.utils.k.a(r, "isX5Disabled", (Class<?>[]) new Class[]{cls, cls}, Integer.valueOf(i2), 43697);
        if (a3 != null) {
            return ((Boolean) a3).booleanValue();
        }
        return true;
    }

    /*  JADX ERROR: JadxRuntimeException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxRuntimeException: Can't find top splitter block for handler:B:93:0x0145
        	at jadx.core.utils.BlockUtils.getTopSplitterForHandler(BlockUtils.java:1166)
        	at jadx.core.dex.visitors.regions.RegionMaker.processTryCatchBlocks(RegionMaker.java:1022)
        	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:55)
        */
    static boolean a(android.content.Context r10, boolean r11, boolean r12) {
        /*
            Method dump skipped, instructions count: 845
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.smtt.sdk.QbSdk.a(android.content.Context, boolean, boolean):boolean");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static synchronized void a(Context context, String str) {
        synchronized (QbSdk.class) {
            if (a) {
                return;
            }
            a = true;
            v = "forceSysWebViewInner: " + str;
            TbsLog.e("QbSdk", "QbSdk.SysWebViewForcedInner..." + v);
            TbsCoreLoadStat.getInstance().a(context, 401, new Throwable(v));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String a() {
        return p;
    }

    private static boolean a(Context context, String str, String str2) {
        return isSuportOpenFile(str2, 2);
    }

    private static Bundle a(Context context, Map<String, String> map) {
        if (map == null) {
            return null;
        }
        try {
            Bundle bundle = new Bundle();
            bundle.putString("style", map.get("style") == null ? "0" : map.get("style"));
            try {
                bundle.putInt("topBarBgColor", Color.parseColor(map.get("topBarBgColor")));
            } catch (Exception unused) {
            }
            if (map != null && map.containsKey(FILERADER_MENUDATA)) {
                JSONObject jSONObject = new JSONObject(map.get(FILERADER_MENUDATA));
                JSONArray jSONArray = jSONObject.getJSONArray("menuItems");
                if (jSONArray != null) {
                    ArrayList<? extends Parcelable> arrayList = new ArrayList<>();
                    for (int i2 = 0; i2 < jSONArray.length() && i2 < 5; i2++) {
                        try {
                            JSONObject jSONObject2 = (JSONObject) jSONArray.get(i2);
                            arrayList.add(i2, BitmapFactory.decodeResource(context.getResources(), jSONObject2.getInt("iconResId")));
                            jSONObject2.put("iconResId", i2);
                        } catch (Exception unused2) {
                        }
                    }
                    bundle.putParcelableArrayList("resArray", arrayList);
                }
                bundle.putString(FILERADER_MENUDATA, jSONObject.toString());
            }
            return bundle;
        } catch (Exception e2) {
            e2.printStackTrace();
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Object a(Context context, String str, Bundle bundle) {
        if (!a(context)) {
            return Integer.valueOf(EXTENSION_INIT_FAILURE);
        }
        Object a2 = com.tencent.smtt.utils.k.a(r, "miscCall", (Class<?>[]) new Class[]{String.class, Bundle.class}, str, bundle);
        if (a2 != null) {
            return a2;
        }
        return null;
    }
}
