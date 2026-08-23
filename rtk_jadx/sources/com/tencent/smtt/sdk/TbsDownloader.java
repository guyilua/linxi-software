package com.tencent.smtt.sdk;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.util.Log;
import com.tencent.smtt.sdk.TbsDownloadConfig;
import com.tencent.smtt.sdk.TbsDownloadUpload;
import com.tencent.smtt.sdk.TbsListener;
import com.tencent.smtt.utils.Apn;
import com.tencent.smtt.utils.TbsLog;
import com.umeng.umcrash.BuildConfig;
import java.io.File;
import java.io.FileOutputStream;
import java.nio.channels.FileLock;
import java.util.Locale;
import java.util.TimeZone;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class TbsDownloader {
    public static final boolean DEBUG_DISABLE_DOWNLOAD = false;
    public static boolean DOWNLOAD_OVERSEA_TBS = false;
    public static final String LOGTAG = "TbsDownload";
    public static final String TBS_METADATA = "com.tencent.mm.BuildInfo.CLIENT_VERSION";
    static boolean a = false;
    private static String b = null;

    /* renamed from: c, reason: collision with root package name */
    private static Context f940c = null;
    private static Handler d = null;
    private static String e = null;
    private static Object f = new byte[0];
    private static i g = null;
    private static HandlerThread h = null;
    private static boolean i = false;
    private static boolean j = false;
    private static boolean k = false;
    private static long l = -1;

    /* loaded from: /tmp/rtk_apk/classes3.dex */
    public interface TbsDownloaderCallback {
        void onNeedDownloadFinish(boolean z, int i);
    }

    private static String a(String str) {
        return str == null ? "" : str;
    }

    private static boolean c() {
        try {
            for (String str : TbsShareManager.getCoreProviderAppList()) {
                if (TbsShareManager.getSharedTbsCoreVersion(f940c, str) > 0) {
                    return true;
                }
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        return false;
    }

    private static synchronized void d() {
        synchronized (TbsDownloader.class) {
            if (h == null) {
                h = k.a();
                try {
                    g = new i(f940c);
                    d = new Handler(h.getLooper()) { // from class: com.tencent.smtt.sdk.TbsDownloader.1
                        @Override // android.os.Handler
                        public void handleMessage(Message message) {
                            FileLock fileLock;
                            int i2 = message.what;
                            if (i2 != 108) {
                                switch (i2) {
                                    case 100:
                                        boolean z = message.arg1 == 1;
                                        boolean b2 = TbsDownloader.b(true, false, false, message.arg2 == 1);
                                        Object obj = message.obj;
                                        if (obj != null && (obj instanceof TbsDownloaderCallback)) {
                                            TbsLog.i(TbsDownloader.LOGTAG, "needDownload-onNeedDownloadFinish needStartDownload=" + b2);
                                            String str = (TbsDownloader.f940c == null || TbsDownloader.f940c.getApplicationContext() == null || TbsDownloader.f940c.getApplicationContext().getApplicationInfo() == null) ? "" : TbsDownloader.f940c.getApplicationContext().getApplicationInfo().packageName;
                                            if (!b2 || z) {
                                                ((TbsDownloaderCallback) message.obj).onNeedDownloadFinish(b2, TbsDownloadConfig.getInstance(TbsDownloader.f940c).mPreferences.getInt(TbsDownloadConfig.TbsConfigKey.KEY_TBS_DOWNLOAD_V, 0));
                                            } else if ("com.tencent.mm".equals(str) || TbsConfig.APP_QQ.equals(str)) {
                                                TbsLog.i(TbsDownloader.LOGTAG, "needDownload-onNeedDownloadFinish in mm or QQ callback needStartDownload = " + b2);
                                                ((TbsDownloaderCallback) message.obj).onNeedDownloadFinish(b2, TbsDownloadConfig.getInstance(TbsDownloader.f940c).mPreferences.getInt(TbsDownloadConfig.TbsConfigKey.KEY_TBS_DOWNLOAD_V, 0));
                                            }
                                        }
                                        if (TbsShareManager.isThirdPartyApp(TbsDownloader.f940c) && b2) {
                                            TbsDownloader.startDownload(TbsDownloader.f940c);
                                            return;
                                        }
                                        return;
                                    case 101:
                                        break;
                                    case 102:
                                        TbsLog.i(TbsDownloader.LOGTAG, "[TbsDownloader.handleMessage] MSG_REPORT_DOWNLOAD_STAT");
                                        int a2 = TbsShareManager.isThirdPartyApp(TbsDownloader.f940c) ? TbsShareManager.a(TbsDownloader.f940c, false) : l.a().m(TbsDownloader.f940c);
                                        TbsLog.i(TbsDownloader.LOGTAG, "[TbsDownloader.handleMessage] localTbsVersion=" + a2);
                                        TbsDownloader.g.a(a2);
                                        TbsLogReport.getInstance(TbsDownloader.f940c).dailyReport();
                                        return;
                                    case 103:
                                        TbsLog.i(TbsDownloader.LOGTAG, "[TbsDownloader.handleMessage] MSG_CONTINUEINSTALL_TBSCORE");
                                        if (message.arg1 == 0) {
                                            l.a().a((Context) message.obj, true);
                                            return;
                                        } else {
                                            l.a().a((Context) message.obj, false);
                                            return;
                                        }
                                    case 104:
                                        TbsLog.i(TbsDownloader.LOGTAG, "[TbsDownloader.handleMessage] MSG_UPLOAD_TBSLOG");
                                        TbsLogReport.getInstance(TbsDownloader.f940c).reportTbsLog();
                                        return;
                                    default:
                                        return;
                                }
                            }
                            FileOutputStream fileOutputStream = null;
                            FileLock fileLock2 = null;
                            if (TbsShareManager.isThirdPartyApp(TbsDownloader.f940c)) {
                                fileLock = null;
                            } else {
                                FileOutputStream b3 = com.tencent.smtt.utils.f.b(TbsDownloader.f940c, false, "tbs_download_lock_file" + TbsDownloadConfig.getInstance(TbsDownloader.f940c).mPreferences.getInt(TbsDownloadConfig.TbsConfigKey.KEY_TBS_DOWNLOAD_V, 0) + ".txt");
                                if (b3 != null) {
                                    fileLock2 = com.tencent.smtt.utils.f.a(TbsDownloader.f940c, b3);
                                    if (fileLock2 == null) {
                                        QbSdk.m.onDownloadFinish(TbsListener.ErrorCode.NONEEDDOWNLOAD_OTHER_PROCESS_DOWNLOADING);
                                        TbsLog.i(TbsDownloader.LOGTAG, "file lock locked,wx or qq is downloading");
                                        TbsDownloadConfig.getInstance(TbsDownloader.f940c).setDownloadInterruptCode(-203);
                                        TbsLog.i(TbsDownloader.LOGTAG, "MSG_START_DOWNLOAD_DECOUPLECORE return #1");
                                        return;
                                    }
                                } else if (com.tencent.smtt.utils.f.a(TbsDownloader.f940c)) {
                                    TbsDownloadConfig.getInstance(TbsDownloader.f940c).setDownloadInterruptCode(-204);
                                    TbsLog.i(TbsDownloader.LOGTAG, "MSG_START_DOWNLOAD_DECOUPLECORE return #2");
                                    return;
                                }
                                FileLock fileLock3 = fileLock2;
                                fileOutputStream = b3;
                                fileLock = fileLock3;
                            }
                            boolean z2 = message.arg1 == 1;
                            TbsDownloadConfig tbsDownloadConfig = TbsDownloadConfig.getInstance(TbsDownloader.f940c);
                            if (TbsDownloader.b(false, z2, 108 == message.what, true)) {
                                if (z2 && l.a().b(TbsDownloader.f940c, TbsDownloadConfig.getInstance(TbsDownloader.f940c).mPreferences.getInt(TbsDownloadConfig.TbsConfigKey.KEY_TBS_DOWNLOAD_V, 0))) {
                                    QbSdk.m.onDownloadFinish(122);
                                    tbsDownloadConfig.setDownloadInterruptCode(-213);
                                } else if (tbsDownloadConfig.mPreferences.getBoolean(TbsDownloadConfig.TbsConfigKey.KEY_NEEDDOWNLOAD, false)) {
                                    TbsDownloadConfig.getInstance(TbsDownloader.f940c).setDownloadInterruptCode(-215);
                                    TbsDownloader.g.b(z2, 108 == message.what);
                                } else {
                                    QbSdk.m.onDownloadFinish(110);
                                }
                            } else {
                                QbSdk.m.onDownloadFinish(110);
                            }
                            TbsLog.i(TbsDownloader.LOGTAG, "------freeFileLock called :");
                            com.tencent.smtt.utils.f.a(fileLock, fileOutputStream);
                        }
                    };
                } catch (Exception unused) {
                    i = true;
                    TbsLog.e(LOGTAG, "TbsApkDownloader init has Exception");
                }
            }
        }
    }

    private static boolean e() {
        try {
            return TbsDownloadConfig.getInstance(f940c).mPreferences.getString(TbsDownloadConfig.TbsConfigKey.KEY_LAST_THIRDAPP_SENDREQUEST_COREVERSION, "").equals(g().toString());
        } catch (Exception unused) {
            return false;
        }
    }

    private static String[] f() {
        if (QbSdk.getOnlyDownload()) {
            return new String[]{f940c.getApplicationContext().getPackageName()};
        }
        String[] coreProviderAppList = TbsShareManager.getCoreProviderAppList();
        String packageName = f940c.getApplicationContext().getPackageName();
        if (!packageName.equals(TbsShareManager.f(f940c))) {
            return coreProviderAppList;
        }
        int length = coreProviderAppList.length;
        String[] strArr = new String[length + 1];
        System.arraycopy(coreProviderAppList, 0, strArr, 0, length);
        strArr[length] = packageName;
        return strArr;
    }

    private static JSONArray g() {
        if (!TbsShareManager.isThirdPartyApp(f940c)) {
            return null;
        }
        JSONArray jSONArray = new JSONArray();
        a(jSONArray);
        c(jSONArray);
        b(jSONArray);
        return jSONArray;
    }

    public static int getCoreShareDecoupleCoreVersion() {
        return l.a().h(f940c);
    }

    public static int getCoreShareDecoupleCoreVersionByContext(Context context) {
        return l.a().h(context);
    }

    public static synchronized boolean getOverSea(Context context) {
        boolean z;
        synchronized (TbsDownloader.class) {
            if (!k) {
                k = true;
                TbsDownloadConfig tbsDownloadConfig = TbsDownloadConfig.getInstance(context);
                if (tbsDownloadConfig.mPreferences.contains(TbsDownloadConfig.TbsConfigKey.KEY_IS_OVERSEA)) {
                    j = tbsDownloadConfig.mPreferences.getBoolean(TbsDownloadConfig.TbsConfigKey.KEY_IS_OVERSEA, false);
                    TbsLog.i(LOGTAG, "[TbsDownloader.getOverSea]  first called. sOverSea = " + j);
                }
                TbsLog.i(LOGTAG, "[TbsDownloader.getOverSea]  sOverSea = " + j);
            }
            z = j;
        }
        return z;
    }

    public static long getRetryIntervalInSeconds() {
        return l;
    }

    public static HandlerThread getsTbsHandlerThread() {
        return h;
    }

    private static boolean h() {
        TbsDownloadConfig tbsDownloadConfig = TbsDownloadConfig.getInstance(f940c);
        if (tbsDownloadConfig.mPreferences.getInt(TbsDownloadConfig.TbsConfigKey.KEY_DOWNLOAD_SUCCESS_RETRYTIMES, 0) >= tbsDownloadConfig.getDownloadSuccessMaxRetrytimes()) {
            TbsLog.i(LOGTAG, "[TbsDownloader.needStartDownload] out of success retrytimes", true);
            tbsDownloadConfig.setDownloadInterruptCode(-115);
            return false;
        }
        if (tbsDownloadConfig.mPreferences.getInt(TbsDownloadConfig.TbsConfigKey.KEY_DOWNLOAD_FAILED_RETRYTIMES, 0) >= tbsDownloadConfig.getDownloadFailedMaxRetrytimes()) {
            TbsLog.i(LOGTAG, "[TbsDownloader.needStartDownload] out of failed retrytimes", true);
            tbsDownloadConfig.setDownloadInterruptCode(-116);
            return false;
        }
        if (!com.tencent.smtt.utils.f.b(f940c)) {
            TbsLog.i(LOGTAG, "[TbsDownloader.needStartDownload] local rom freespace limit", true);
            tbsDownloadConfig.setDownloadInterruptCode(-117);
            return false;
        }
        if (System.currentTimeMillis() - tbsDownloadConfig.mPreferences.getLong(TbsDownloadConfig.TbsConfigKey.KEY_TBSDOWNLOAD_STARTTIME, 0L) <= 86400000) {
            long j2 = tbsDownloadConfig.mPreferences.getLong(TbsDownloadConfig.TbsConfigKey.KEY_TBSDOWNLOAD_FLOW, 0L);
            TbsLog.i(LOGTAG, "[TbsDownloader.needStartDownload] downloadFlow=" + j2);
            if (j2 >= tbsDownloadConfig.getDownloadMaxflow()) {
                TbsLog.i(LOGTAG, "[TbsDownloader.needStartDownload] failed because you exceeded max flow!", true);
                tbsDownloadConfig.setDownloadInterruptCode(-120);
                return false;
            }
        }
        return true;
    }

    public static boolean isDownloadForeground() {
        i iVar = g;
        return iVar != null && iVar.d();
    }

    public static synchronized boolean isDownloading() {
        boolean z;
        synchronized (TbsDownloader.class) {
            TbsLog.i(LOGTAG, "[TbsDownloader.isDownloading] is " + a);
            z = a;
        }
        return z;
    }

    public static boolean needDownload(Context context, boolean z) {
        return needDownload(context, z, false, true, null);
    }

    public static boolean needDownloadDecoupleCore() {
        int i2;
        if (TbsShareManager.isThirdPartyApp(f940c) || a(f940c)) {
            return false;
        }
        return System.currentTimeMillis() - TbsDownloadConfig.getInstance(f940c).mPreferences.getLong(TbsDownloadConfig.TbsConfigKey.KEY_LAST_DOWNLOAD_DECOUPLE_CORE, 0L) >= TbsDownloadConfig.getInstance(f940c).getRetryInterval() * 1000 && (i2 = TbsDownloadConfig.getInstance(f940c).mPreferences.getInt(TbsDownloadConfig.TbsConfigKey.KEY_DECOUPLECOREVERSION, 0)) > 0 && i2 != l.a().h(f940c) && TbsDownloadConfig.getInstance(f940c).mPreferences.getInt(TbsDownloadConfig.TbsConfigKey.KEY_TBS_DOWNLOAD_V, 0) != i2;
    }

    public static boolean needSendRequest(Context context, boolean z) {
        f940c = context.getApplicationContext();
        TbsLog.initIfNeed(context);
        boolean z2 = false;
        if (!a(f940c, z)) {
            return false;
        }
        int m = l.a().m(context);
        TbsLog.i(LOGTAG, "[TbsDownloader.needSendRequest] localTbsVersion=" + m);
        if (m > 0) {
            return false;
        }
        if (a(f940c, false, true)) {
            return true;
        }
        TbsDownloadConfig tbsDownloadConfig = TbsDownloadConfig.getInstance(f940c);
        boolean contains = tbsDownloadConfig.mPreferences.contains(TbsDownloadConfig.TbsConfigKey.KEY_NEEDDOWNLOAD);
        TbsLog.i(LOGTAG, "[TbsDownloader.needSendRequest] hasNeedDownloadKey=" + contains);
        boolean z3 = !contains ? true : tbsDownloadConfig.mPreferences.getBoolean(TbsDownloadConfig.TbsConfigKey.KEY_NEEDDOWNLOAD, false);
        TbsLog.i(LOGTAG, "[TbsDownloader.needSendRequest] needDownload=" + z3);
        if (z3 && h()) {
            z2 = true;
        }
        TbsLog.i(LOGTAG, "[TbsDownloader.needSendRequest] ret=" + z2);
        return z2;
    }

    public static void setAppContext(Context context) {
        if (context == null || context.getApplicationContext() == null) {
            return;
        }
        f940c = context.getApplicationContext();
    }

    public static void setRetryIntervalInSeconds(Context context, long j2) {
        if (context == null) {
            return;
        }
        if (context.getApplicationInfo().packageName.equals("com.tencent.qqlive")) {
            l = j2;
        }
        TbsLog.i(LOGTAG, "mRetryIntervalInSeconds is " + l);
    }

    public static boolean startDecoupleCoreIfNeeded() {
        TbsLog.i(LOGTAG, "startDecoupleCoreIfNeeded ");
        if (TbsShareManager.isThirdPartyApp(f940c)) {
            return false;
        }
        TbsLog.i(LOGTAG, "startDecoupleCoreIfNeeded #1");
        if (a(f940c) || d == null) {
            return false;
        }
        TbsLog.i(LOGTAG, "startDecoupleCoreIfNeeded #2");
        if (System.currentTimeMillis() - TbsDownloadConfig.getInstance(f940c).mPreferences.getLong(TbsDownloadConfig.TbsConfigKey.KEY_LAST_DOWNLOAD_DECOUPLE_CORE, 0L) < TbsDownloadConfig.getInstance(f940c).getRetryInterval() * 1000) {
            return false;
        }
        TbsLog.i(LOGTAG, "startDecoupleCoreIfNeeded #3");
        int i2 = TbsDownloadConfig.getInstance(f940c).mPreferences.getInt(TbsDownloadConfig.TbsConfigKey.KEY_DECOUPLECOREVERSION, 0);
        if (i2 > 0 && i2 != l.a().h(f940c)) {
            if (TbsDownloadConfig.getInstance(f940c).mPreferences.getInt(TbsDownloadConfig.TbsConfigKey.KEY_TBS_DOWNLOAD_V, 0) == i2 && TbsDownloadConfig.getInstance(f940c).mPreferences.getInt(TbsDownloadConfig.TbsConfigKey.KEY_TBS_DOWNLOAD_V_TYPE, 0) != 1) {
                TbsLog.i(LOGTAG, "startDecoupleCoreIfNeeded no need, KEY_TBS_DOWNLOAD_V is " + TbsDownloadConfig.getInstance(f940c).mPreferences.getInt(TbsDownloadConfig.TbsConfigKey.KEY_TBS_DOWNLOAD_V, 0) + " deCoupleCoreVersion is " + i2 + " KEY_TBS_DOWNLOAD_V_TYPE is " + TbsDownloadConfig.getInstance(f940c).mPreferences.getInt(TbsDownloadConfig.TbsConfigKey.KEY_TBS_DOWNLOAD_V_TYPE, 0));
            } else {
                TbsLog.i(LOGTAG, "startDecoupleCoreIfNeeded #4");
                a = true;
                d.removeMessages(108);
                Message obtain = Message.obtain(d, 108, QbSdk.m);
                obtain.arg1 = 0;
                obtain.sendToTarget();
                TbsDownloadConfig.getInstance(f940c).a.put(TbsDownloadConfig.TbsConfigKey.KEY_LAST_DOWNLOAD_DECOUPLE_CORE, Long.valueOf(System.currentTimeMillis()));
                return true;
            }
        } else {
            TbsLog.i(LOGTAG, "startDecoupleCoreIfNeeded no need, deCoupleCoreVersion is " + i2 + " getTbsCoreShareDecoupleCoreVersion is " + l.a().h(f940c));
        }
        return false;
    }

    public static void startDownload(Context context) {
        startDownload(context, false);
    }

    public static void stopDownload() {
        if (i) {
            return;
        }
        TbsLog.i(LOGTAG, "[TbsDownloader.stopDownload]");
        i iVar = g;
        if (iVar != null) {
            iVar.b();
        }
        Handler handler = d;
        if (handler != null) {
            handler.removeMessages(100);
            d.removeMessages(101);
            d.removeMessages(108);
        }
    }

    private static void b(JSONArray jSONArray) {
        if (TbsShareManager.getHostCorePathAppDefined() != null) {
            int a2 = l.a().a(TbsShareManager.getHostCorePathAppDefined());
            boolean z = false;
            int i2 = 0;
            while (true) {
                if (i2 >= jSONArray.length()) {
                    break;
                }
                if (jSONArray.optInt(i2) == a2) {
                    z = true;
                    break;
                }
                i2++;
            }
            if (z) {
                return;
            }
            jSONArray.put(a2);
        }
    }

    public static boolean needDownload(Context context, boolean z, boolean z2, TbsDownloaderCallback tbsDownloaderCallback) {
        return needDownload(context, z, z2, true, tbsDownloaderCallback);
    }

    public static synchronized void startDownload(Context context, boolean z) {
        synchronized (TbsDownloader.class) {
            TbsDownloadUpload tbsDownloadUpload = TbsDownloadUpload.getInstance(context);
            tbsDownloadUpload.a.put(TbsDownloadUpload.TbsUploadKey.KEY_STARTDOWNLOAD_CODE, Integer.valueOf(TbsListener.ErrorCode.STARTDOWNLOAD_1));
            tbsDownloadUpload.commit();
            TbsLog.i(LOGTAG, "[TbsDownloader.startDownload] sAppContext=" + f940c);
            if (l.b) {
                tbsDownloadUpload.a.put(TbsDownloadUpload.TbsUploadKey.KEY_STARTDOWNLOAD_CODE, Integer.valueOf(TbsListener.ErrorCode.STARTDOWNLOAD_2));
                tbsDownloadUpload.commit();
                return;
            }
            int i2 = 1;
            a = true;
            Context applicationContext = context.getApplicationContext();
            f940c = applicationContext;
            TbsDownloadConfig.getInstance(applicationContext).setDownloadInterruptCode(-200);
            if (Build.VERSION.SDK_INT < 8) {
                QbSdk.m.onDownloadFinish(110);
                TbsDownloadConfig.getInstance(f940c).setDownloadInterruptCode(-201);
                tbsDownloadUpload.a.put(TbsDownloadUpload.TbsUploadKey.KEY_STARTDOWNLOAD_CODE, Integer.valueOf(TbsListener.ErrorCode.STARTDOWNLOAD_3));
                tbsDownloadUpload.commit();
                return;
            }
            d();
            if (i) {
                QbSdk.m.onDownloadFinish(121);
                TbsDownloadConfig.getInstance(f940c).setDownloadInterruptCode(-202);
                tbsDownloadUpload.a.put(TbsDownloadUpload.TbsUploadKey.KEY_STARTDOWNLOAD_CODE, Integer.valueOf(TbsListener.ErrorCode.STARTDOWNLOAD_4));
                tbsDownloadUpload.commit();
                return;
            }
            if (z) {
                stopDownload();
            }
            d.removeMessages(101);
            d.removeMessages(100);
            Message obtain = Message.obtain(d, 101, QbSdk.m);
            if (!z) {
                i2 = 0;
            }
            obtain.arg1 = i2;
            obtain.sendToTarget();
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:37:0x017a, code lost:
    
        if (r9.equals(r5) != false) goto L46;
     */
    /* JADX WARN: Removed duplicated region for block: B:41:0x01ed  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static boolean a(android.content.Context r22, boolean r23, boolean r24) {
        /*
            Method dump skipped, instructions count: 531
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.smtt.sdk.TbsDownloader.a(android.content.Context, boolean, boolean):boolean");
    }

    public static boolean needDownload(Context context, boolean z, boolean z2, boolean z3, TbsDownloaderCallback tbsDownloaderCallback) {
        boolean contains;
        boolean z4;
        TbsLog.i(LOGTAG, "needDownload,process=" + QbSdk.getCurrentProcessName(context) + "stack=" + Log.getStackTraceString(new Throwable()));
        TbsDownloadUpload.clear();
        TbsDownloadUpload tbsDownloadUpload = TbsDownloadUpload.getInstance(context);
        tbsDownloadUpload.a.put(TbsDownloadUpload.TbsUploadKey.KEY_NEEDDOWNLOAD_CODE, Integer.valueOf(TbsListener.ErrorCode.NEEDDOWNLOAD_1));
        tbsDownloadUpload.commit();
        TbsLog.i(LOGTAG, "[TbsDownloader.needDownload] oversea=" + z + ",isDownloadForeground=" + z2);
        TbsLog.initIfNeed(context);
        if (l.b) {
            if (tbsDownloaderCallback != null) {
                tbsDownloaderCallback.onNeedDownloadFinish(false, 0);
            }
            TbsLog.i(LOGTAG, "[TbsDownloader.needDownload]#1,return false");
            tbsDownloadUpload.a.put(TbsDownloadUpload.TbsUploadKey.KEY_NEEDDOWNLOAD_RETURN, Integer.valueOf(TbsListener.ErrorCode.NEEDDOWNLOAD_FALSE_1));
            tbsDownloadUpload.commit();
            return false;
        }
        TbsLog.app_extra(LOGTAG, context);
        Context applicationContext = context.getApplicationContext();
        f940c = applicationContext;
        TbsDownloadConfig tbsDownloadConfig = TbsDownloadConfig.getInstance(applicationContext);
        tbsDownloadConfig.setDownloadInterruptCode(-100);
        if (!a(f940c, z)) {
            TbsLog.i(LOGTAG, "[TbsDownloader.needDownload]#2,return false");
            tbsDownloadUpload.a.put(TbsDownloadUpload.TbsUploadKey.KEY_NEEDDOWNLOAD_CODE, Integer.valueOf(TbsListener.ErrorCode.NEEDDOWNLOAD_2));
            tbsDownloadUpload.commit();
            tbsDownloadUpload.a.put(TbsDownloadUpload.TbsUploadKey.KEY_NEEDDOWNLOAD_RETURN, Integer.valueOf(TbsListener.ErrorCode.NEEDDOWNLOAD_FALSE_2));
            tbsDownloadUpload.commit();
            if (tbsDownloaderCallback != null) {
                tbsDownloaderCallback.onNeedDownloadFinish(false, 0);
            }
            return false;
        }
        d();
        if (i) {
            if (tbsDownloaderCallback != null) {
                tbsDownloaderCallback.onNeedDownloadFinish(false, 0);
            }
            tbsDownloadConfig.setDownloadInterruptCode(-105);
            TbsLog.i(LOGTAG, "[TbsDownloader.needDownload]#3,return false");
            tbsDownloadUpload.a.put(TbsDownloadUpload.TbsUploadKey.KEY_NEEDDOWNLOAD_CODE, Integer.valueOf(TbsListener.ErrorCode.NEEDDOWNLOAD_3));
            tbsDownloadUpload.commit();
            tbsDownloadUpload.a.put(TbsDownloadUpload.TbsUploadKey.KEY_NEEDDOWNLOAD_RETURN, Integer.valueOf(TbsListener.ErrorCode.NEEDDOWNLOAD_FALSE_3));
            tbsDownloadUpload.commit();
            if (tbsDownloaderCallback != null) {
                tbsDownloaderCallback.onNeedDownloadFinish(false, 0);
            }
            return false;
        }
        boolean a2 = a(f940c, z2, false);
        TbsLog.i(LOGTAG, "[TbsDownloader.needDownload],needSendRequest=" + a2);
        if (a2) {
            a(z2, tbsDownloaderCallback, z3);
            tbsDownloadConfig.setDownloadInterruptCode(-114);
        } else {
            tbsDownloadUpload.a.put(TbsDownloadUpload.TbsUploadKey.KEY_NEEDDOWNLOAD_CODE, Integer.valueOf(TbsListener.ErrorCode.NEEDDOWNLOAD_4));
            tbsDownloadUpload.commit();
        }
        d.removeMessages(102);
        Message.obtain(d, 102).sendToTarget();
        if (QbSdk.f930c || !TbsShareManager.isThirdPartyApp(context)) {
            contains = tbsDownloadConfig.mPreferences.contains(TbsDownloadConfig.TbsConfigKey.KEY_NEEDDOWNLOAD);
            TbsLog.i(LOGTAG, "[TbsDownloader.needDownload] hasNeedDownloadKey=" + contains);
            z4 = (contains || TbsShareManager.isThirdPartyApp(context)) ? tbsDownloadConfig.mPreferences.getBoolean(TbsDownloadConfig.TbsConfigKey.KEY_NEEDDOWNLOAD, false) : true;
        } else {
            z4 = false;
            contains = false;
        }
        TbsLog.i(LOGTAG, "[TbsDownloader.needDownload]#4,needDownload=" + z4 + ",hasNeedDownloadKey=" + contains);
        if (z4) {
            if (!h()) {
                TbsLog.i(LOGTAG, "[TbsDownloader.needDownload]#5,set needDownload = false");
                z4 = false;
            } else {
                tbsDownloadConfig.setDownloadInterruptCode(-118);
                TbsLog.i(LOGTAG, "[TbsDownloader.needDownload]#6");
            }
        } else {
            int m = l.a().m(f940c);
            TbsLog.i(LOGTAG, "[TbsDownloader.needDownload]#7,tbsLocalVersion=" + m + ",needSendRequest=" + a2);
            if (!a2 && m > 0) {
                tbsDownloadConfig.setDownloadInterruptCode(-119);
            } else {
                d.removeMessages(103);
                if (m <= 0 && !a2) {
                    Message.obtain(d, 103, 0, 0, f940c).sendToTarget();
                } else {
                    Message.obtain(d, 103, 1, 0, f940c).sendToTarget();
                }
                tbsDownloadConfig.setDownloadInterruptCode(-121);
            }
        }
        if (!a2 && tbsDownloaderCallback != null) {
            tbsDownloaderCallback.onNeedDownloadFinish(false, 0);
        }
        TbsLog.i(LOGTAG, "[TbsDownloader.needDownload] needDownload=" + z4);
        tbsDownloadUpload.a.put(TbsDownloadUpload.TbsUploadKey.KEY_NEEDDOWNLOAD_RETURN, Integer.valueOf(z4 ? TbsListener.ErrorCode.NEEDDOWNLOAD_TRUE : 174));
        tbsDownloadUpload.commit();
        return z4;
    }

    private static void c(JSONArray jSONArray) {
        boolean z;
        if (TbsPVConfig.getInstance(f940c).isDisableHostBackupCore()) {
            return;
        }
        for (String str : f()) {
            int backupCoreVersion = TbsShareManager.getBackupCoreVersion(f940c, str);
            boolean z2 = true;
            if (backupCoreVersion > 0) {
                Context packageContext = TbsShareManager.getPackageContext(f940c, str, false);
                if (packageContext == null || l.a().f(packageContext)) {
                    int i2 = 0;
                    while (true) {
                        if (i2 >= jSONArray.length()) {
                            z = false;
                            break;
                        } else {
                            if (jSONArray.optInt(i2) == backupCoreVersion) {
                                z = true;
                                break;
                            }
                            i2++;
                        }
                    }
                    if (!z) {
                        jSONArray.put(backupCoreVersion);
                    }
                } else {
                    TbsLog.e(LOGTAG, "host check failed,packageName = " + str);
                }
            }
            int backupDecoupleCoreVersion = TbsShareManager.getBackupDecoupleCoreVersion(f940c, str);
            if (backupDecoupleCoreVersion > 0) {
                Context packageContext2 = TbsShareManager.getPackageContext(f940c, str, false);
                if (packageContext2 == null || l.a().f(packageContext2)) {
                    int i3 = 0;
                    while (true) {
                        if (i3 >= jSONArray.length()) {
                            z2 = false;
                            break;
                        } else if (jSONArray.optInt(i3) == backupDecoupleCoreVersion) {
                            break;
                        } else {
                            i3++;
                        }
                    }
                    if (!z2) {
                        jSONArray.put(backupDecoupleCoreVersion);
                    }
                } else {
                    TbsLog.e(LOGTAG, "host check failed,packageName = " + str);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Can't wrap try/catch for region: R(33:25|(1:27)(1:128)|28|(1:30)(1:127)|31|(1:33)(1:126)|34|(1:36)|37|(2:39|(1:41)(2:42|(1:44)(2:45|(1:47))))|48|(1:50)|51|(4:53|54|55|(10:59|(3:61|(1:63)(1:119)|64)(1:(1:121)(1:122))|65|66|67|68|(4:101|(3:103|(1:105)|106)(1:116)|107|(1:(2:110|111)(1:(2:113|114)(1:115))))(1:71)|72|(8:81|82|(1:84)(1:(1:98))|85|86|87|88|90)(2:(1:76)(1:(1:80))|77)|78))|125|66|67|68|(0)|101|(0)(0)|107|(0)|72|(0)|81|82|(0)(0)|85|86|87|88|90) */
    /* JADX WARN: Code restructure failed: missing block: B:118:0x0222, code lost:
    
        r13 = -1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:91:0x0398, code lost:
    
        r0 = th;
     */
    /* JADX WARN: Code restructure failed: missing block: B:92:0x039c, code lost:
    
        r0.printStackTrace();
     */
    /* JADX WARN: Code restructure failed: missing block: B:93:0x039f, code lost:
    
        if (r25 != false) goto L125;
     */
    /* JADX WARN: Code restructure failed: missing block: B:94:0x03a1, code lost:
    
        r4.setDownloadInterruptCode(-106);
     */
    /* JADX WARN: Code restructure failed: missing block: B:95:0x03a7, code lost:
    
        r4.setDownloadInterruptCode(-206);
     */
    /* JADX WARN: Code restructure failed: missing block: B:99:0x039a, code lost:
    
        r0 = th;
     */
    /* JADX WARN: Removed duplicated region for block: B:103:0x023d  */
    /* JADX WARN: Removed duplicated region for block: B:109:0x02a8  */
    /* JADX WARN: Removed duplicated region for block: B:116:0x026d  */
    /* JADX WARN: Removed duplicated region for block: B:84:0x032e A[Catch: all -> 0x039a, TryCatch #1 {all -> 0x039a, blocks: (B:82:0x030c, B:84:0x032e, B:85:0x037b, B:98:0x0356), top: B:81:0x030c }] */
    /* JADX WARN: Removed duplicated region for block: B:97:0x0354  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static boolean b(final boolean r25, boolean r26, boolean r27, boolean r28) {
        /*
            Method dump skipped, instructions count: 942
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.smtt.sdk.TbsDownloader.b(boolean, boolean, boolean, boolean):boolean");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @TargetApi(11)
    public static void c(Context context) {
        SharedPreferences sharedPreferences;
        SharedPreferences sharedPreferences2;
        TbsDownloadConfig.getInstance(context).clear();
        TbsLogReport.getInstance(context).clear();
        i.c(context);
        int i2 = Build.VERSION.SDK_INT;
        if (i2 >= 11) {
            sharedPreferences = context.getSharedPreferences("tbs_extension_config", 4);
        } else {
            sharedPreferences = context.getSharedPreferences("tbs_extension_config", 0);
        }
        sharedPreferences.edit().clear().commit();
        if (i2 >= 11) {
            sharedPreferences2 = context.getSharedPreferences("tbs_preloadx5_check_cfg_file", 4);
        } else {
            sharedPreferences2 = context.getSharedPreferences("tbs_preloadx5_check_cfg_file", 0);
        }
        sharedPreferences2.edit().clear().commit();
    }

    private static boolean a(Context context, boolean z) {
        TbsDownloadConfig tbsDownloadConfig = TbsDownloadConfig.getInstance(context);
        int i2 = Build.VERSION.SDK_INT;
        if (i2 < 8) {
            tbsDownloadConfig.setDownloadInterruptCode(-102);
            return false;
        }
        if (!QbSdk.f930c && TbsShareManager.isThirdPartyApp(f940c) && !c()) {
            return false;
        }
        if (!tbsDownloadConfig.mPreferences.contains(TbsDownloadConfig.TbsConfigKey.KEY_IS_OVERSEA)) {
            if (z && !"com.tencent.mm".equals(context.getApplicationInfo().packageName)) {
                TbsLog.i(LOGTAG, "needDownload-oversea is true, but not WX");
                z = false;
            }
            tbsDownloadConfig.a.put(TbsDownloadConfig.TbsConfigKey.KEY_IS_OVERSEA, Boolean.valueOf(z));
            tbsDownloadConfig.commit();
            j = z;
            TbsLog.i(LOGTAG, "needDownload-first-called--isoversea = " + z);
        }
        if (getOverSea(context) && i2 != 16 && i2 != 17 && i2 != 18) {
            TbsLog.i(LOGTAG, "needDownload- return false,  because of  version is " + i2 + ", and overea");
            tbsDownloadConfig.setDownloadInterruptCode(-103);
            return false;
        }
        Matcher matcher = null;
        String string = tbsDownloadConfig.mPreferences.getString(TbsDownloadConfig.TbsConfigKey.KEY_DEVICE_CPUABI, null);
        e = string;
        if (TextUtils.isEmpty(string)) {
            return true;
        }
        try {
            matcher = Pattern.compile("i686|mips|x86_64").matcher(e);
        } catch (Exception unused) {
        }
        if (matcher == null || !matcher.find()) {
            return true;
        }
        TbsLog.e(LOGTAG, "can not support x86 devices!!");
        tbsDownloadConfig.setDownloadInterruptCode(-104);
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean a(Context context) {
        return TbsDownloadConfig.getInstance(context).mPreferences.getInt(TbsDownloadConfig.TbsConfigKey.KEY_DOWNLOADDECOUPLECORE, 0) == 1;
    }

    private static void a(boolean z, TbsDownloaderCallback tbsDownloaderCallback, boolean z2) {
        TbsLog.i(LOGTAG, "[TbsDownloader.queryConfig]");
        d.removeMessages(100);
        Message obtain = Message.obtain(d, 100);
        if (tbsDownloaderCallback != null) {
            obtain.obj = tbsDownloaderCallback;
        }
        obtain.arg1 = 0;
        obtain.arg1 = z ? 1 : 0;
        obtain.arg2 = z2 ? 1 : 0;
        obtain.sendToTarget();
    }

    private static void a(JSONArray jSONArray) {
        boolean z;
        String[] f2 = f();
        int length = f2.length;
        int i2 = 0;
        while (true) {
            boolean z2 = true;
            if (i2 >= length) {
                break;
            }
            String str = f2[i2];
            int sharedTbsCoreVersion = TbsShareManager.getSharedTbsCoreVersion(f940c, str);
            if (sharedTbsCoreVersion > 0) {
                Context packageContext = TbsShareManager.getPackageContext(f940c, str, true);
                if (packageContext == null || l.a().f(packageContext)) {
                    int i3 = 0;
                    while (true) {
                        if (i3 >= jSONArray.length()) {
                            z2 = false;
                            break;
                        } else if (jSONArray.optInt(i3) == sharedTbsCoreVersion) {
                            break;
                        } else {
                            i3++;
                        }
                    }
                    if (!z2) {
                        jSONArray.put(sharedTbsCoreVersion);
                    }
                } else {
                    TbsLog.e(LOGTAG, "host check failed,packageName = " + str);
                }
            }
            i2++;
        }
        for (String str2 : f()) {
            int coreShareDecoupleCoreVersion = TbsShareManager.getCoreShareDecoupleCoreVersion(f940c, str2);
            if (coreShareDecoupleCoreVersion > 0) {
                Context packageContext2 = TbsShareManager.getPackageContext(f940c, str2, true);
                if (packageContext2 == null || l.a().f(packageContext2)) {
                    int i4 = 0;
                    while (true) {
                        if (i4 >= jSONArray.length()) {
                            z = false;
                            break;
                        } else {
                            if (jSONArray.optInt(i4) == coreShareDecoupleCoreVersion) {
                                z = true;
                                break;
                            }
                            i4++;
                        }
                    }
                    if (!z) {
                        jSONArray.put(coreShareDecoupleCoreVersion);
                    }
                } else {
                    TbsLog.e(LOGTAG, "host check failed,packageName = " + str2);
                }
            }
        }
    }

    private static JSONObject a(boolean z, boolean z2, boolean z3) {
        int m;
        int i2;
        int i3;
        TbsLog.i(LOGTAG, "[TbsDownloader.postJsonData]isQuery: " + z + " forDecoupleCore is " + z3);
        TbsDownloadConfig tbsDownloadConfig = TbsDownloadConfig.getInstance(f940c);
        String b2 = b(f940c);
        String d2 = com.tencent.smtt.utils.b.d(f940c);
        String c2 = com.tencent.smtt.utils.b.c(f940c);
        String f2 = com.tencent.smtt.utils.b.f(f940c);
        String id = TimeZone.getDefault().getID();
        String str = id != null ? id : "";
        try {
            TelephonyManager telephonyManager = (TelephonyManager) f940c.getSystemService("phone");
            if (telephonyManager != null) {
                id = telephonyManager.getSimCountryIso();
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        String str2 = id != null ? id : "";
        JSONObject jSONObject = new JSONObject();
        try {
            boolean z4 = false;
            if (j.a(f940c).c("tpatch_num") < 5) {
                jSONObject.put("REQUEST_TPATCH", 1);
            } else {
                jSONObject.put("REQUEST_TPATCH", 0);
            }
            jSONObject.put("TIMEZONEID", str);
            jSONObject.put("COUNTRYISO", str2);
            jSONObject.put("PROTOCOLVERSION", 1);
            if (TbsShareManager.isThirdPartyApp(f940c)) {
                if (QbSdk.f930c) {
                    m = TbsShareManager.a(f940c, false);
                } else {
                    m = TbsDownloadConfig.getInstance(f940c).mPreferences.getInt(TbsDownloadConfig.TbsConfigKey.KEY_TBS_DOWNLOAD_V, 0);
                }
            } else {
                if (z3) {
                    m = l.a().i(f940c);
                } else {
                    m = l.a().m(f940c);
                }
                if (m == 0 && l.a().l(f940c)) {
                    m = -1;
                    if (TbsConfig.APP_QQ.equals(f940c.getApplicationInfo().packageName)) {
                        TbsDownloadUpload.clear();
                        TbsDownloadUpload tbsDownloadUpload = TbsDownloadUpload.getInstance(f940c);
                        tbsDownloadUpload.a.put(TbsDownloadUpload.TbsUploadKey.KEY_LOCAL_CORE_VERSION, -1);
                        tbsDownloadUpload.commit();
                        TbsPVConfig.releaseInstance();
                        if (TbsPVConfig.getInstance(f940c).getLocalCoreVersionMoreTimes() == 1) {
                            m = l.a().i(f940c);
                        }
                    }
                }
                TbsLog.i(LOGTAG, "[TbsDownloader.postJsonData] tbsLocalVersion=" + m + " isDownloadForeground=" + z2);
                if (z2 && !l.a().l(f940c)) {
                    m = 0;
                }
            }
            if (z) {
                jSONObject.put("FUNCTION", 2);
            } else {
                jSONObject.put("FUNCTION", m == 0 ? 0 : 1);
            }
            if (TbsShareManager.isThirdPartyApp(f940c)) {
                JSONArray g2 = g();
                jSONObject.put("TBSVLARR", g2);
                tbsDownloadConfig.a.put(TbsDownloadConfig.TbsConfigKey.KEY_LAST_THIRDAPP_SENDREQUEST_COREVERSION, g2.toString());
                tbsDownloadConfig.commit();
                if (QbSdk.f930c) {
                    jSONObject.put("THIRDREQ", 1);
                }
            } else {
                JSONArray a2 = a(z3);
                if (Apn.getApnType(f940c) != 3 && a2.length() != 0 && m == 0 && z) {
                    jSONObject.put("TBSBACKUPARR", a2);
                }
            }
            jSONObject.put("APPN", f940c.getPackageName());
            jSONObject.put("APPVN", a(tbsDownloadConfig.mPreferences.getString(TbsDownloadConfig.TbsConfigKey.KEY_APP_VERSIONNAME, null)));
            jSONObject.put("APPVC", tbsDownloadConfig.mPreferences.getInt(TbsDownloadConfig.TbsConfigKey.KEY_APP_VERSIONCODE, 0));
            jSONObject.put("APPMETA", a(tbsDownloadConfig.mPreferences.getString(TbsDownloadConfig.TbsConfigKey.KEY_APP_METADATA, null)));
            jSONObject.put("TBSSDKV", 43697);
            jSONObject.put("TBSV", m);
            jSONObject.put("DOWNLOADDECOUPLECORE", z3 ? 1 : 0);
            tbsDownloadConfig.a.put(TbsDownloadConfig.TbsConfigKey.KEY_DOWNLOADDECOUPLECORE, Integer.valueOf(z3 ? 1 : 0));
            tbsDownloadConfig.commit();
            if (m != 0) {
                jSONObject.put("TBSBACKUPV", g.b(z3));
            }
            jSONObject.put("CPU", e);
            jSONObject.put("UA", b2);
            jSONObject.put("IMSI", a(d2));
            jSONObject.put("IMEI", a(c2));
            jSONObject.put("ANDROID_ID", a(f2));
            if (!TbsShareManager.isThirdPartyApp(f940c)) {
                if (m != 0) {
                    jSONObject.put("STATUS", QbSdk.a(f940c, m) ? 0 : 1);
                } else {
                    jSONObject.put("STATUS", 0);
                }
                jSONObject.put("TBSDV", l.a().h(f940c));
            }
            boolean z5 = TbsDownloadConfig.getInstance(f940c).mPreferences.getBoolean(TbsDownloadConfig.TbsConfigKey.KEY_FULL_PACKAGE, false);
            Object a3 = QbSdk.a(f940c, "can_unlzma", (Bundle) null);
            if ((a3 == null || !(a3 instanceof Boolean)) ? false : ((Boolean) a3).booleanValue()) {
                i2 = 1;
                z4 = !z5;
            } else {
                i2 = 1;
            }
            if (z4) {
                jSONObject.put("REQUEST_LZMA", i2);
            }
            if (getOverSea(f940c)) {
                i3 = 1;
                jSONObject.put("OVERSEA", 1);
            } else {
                i3 = 1;
            }
            if (z2) {
                jSONObject.put("DOWNLOAD_FOREGROUND", i3);
            }
        } catch (Exception unused) {
        }
        TbsLog.i(LOGTAG, "[TbsDownloader.postJsonData] jsonData=" + jSONObject.toString());
        return jSONObject;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String b(Context context) {
        if (!TextUtils.isEmpty(b)) {
            return b;
        }
        Locale locale = Locale.getDefault();
        StringBuffer stringBuffer = new StringBuffer();
        String str = Build.VERSION.RELEASE;
        try {
            str = new String(str.getBytes("UTF-8"), "ISO8859-1");
        } catch (Exception unused) {
        }
        if (str == null) {
            stringBuffer.append(BuildConfig.VERSION_NAME);
        } else if (str.length() > 0) {
            stringBuffer.append(str);
        } else {
            stringBuffer.append(BuildConfig.VERSION_NAME);
        }
        stringBuffer.append("; ");
        String language = locale.getLanguage();
        if (language != null) {
            stringBuffer.append(language.toLowerCase());
            String country = locale.getCountry();
            if (country != null) {
                stringBuffer.append("-");
                stringBuffer.append(country.toLowerCase());
            }
        } else {
            stringBuffer.append("en");
        }
        if ("REL".equals(Build.VERSION.CODENAME)) {
            String str2 = Build.MODEL;
            try {
                str2 = new String(str2.getBytes("UTF-8"), "ISO8859-1");
            } catch (Exception unused2) {
            }
            if (str2 == null) {
                stringBuffer.append("; ");
            } else if (str2.length() > 0) {
                stringBuffer.append("; ");
                stringBuffer.append(str2);
            }
        }
        String str3 = Build.ID;
        if (str3 == null) {
            str3 = "";
        }
        String replaceAll = str3.replaceAll("[一-龥]", "");
        if (replaceAll == null) {
            stringBuffer.append(" Build/");
            stringBuffer.append(com.sigmob.sdk.archives.tar.e.V);
        } else if (replaceAll.length() > 0) {
            stringBuffer.append(" Build/");
            stringBuffer.append(replaceAll);
        }
        String format = String.format("Mozilla/5.0 (Linux; U; Android %s) AppleWebKit/533.1 (KHTML, like Gecko)Version/4.0 Mobile Safari/533.1", stringBuffer);
        b = format;
        return format;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static File b(int i2) {
        String[] coreProviderAppList = TbsShareManager.getCoreProviderAppList();
        int length = coreProviderAppList.length;
        File file = null;
        int i3 = 0;
        while (i3 < length) {
            String str = coreProviderAppList[i3];
            File file2 = new File(com.tencent.smtt.utils.f.a(f940c, str, 4, false), getOverSea(f940c) ? "x5.oversea.tbs.org" : "x5.tbs.org");
            if (file2.exists() && com.tencent.smtt.utils.a.a(f940c, file2) == i2) {
                TbsLog.i(LOGTAG, "local tbs version fond,path = " + file2.getAbsolutePath());
            } else {
                file2 = new File(com.tencent.smtt.utils.f.a(f940c, str, 4, false), "x5.tbs.decouple");
                if (file2.exists() && com.tencent.smtt.utils.a.a(f940c, file2) == i2) {
                    TbsLog.i(LOGTAG, "local tbs version fond,path = " + file2.getAbsolutePath());
                } else {
                    i3++;
                    file = file2;
                }
            }
            return file2;
        }
        return file;
    }

    /* JADX WARN: Can't wrap try/catch for region: R(17:16|(2:17|18)|19|(1:318)(6:25|26|27|(1:29)(1:314)|30|31)|(10:290|291|(1:293)(1:308)|294|(1:296)(1:307)|297|(1:299)(1:306)|300|(1:302)(1:305)|303)|33|(16:34|35|36|37|39|40|41|42|(4:272|273|(1:275)(1:277)|276)(1:44)|45|46|(1:48)|49|(3:51|(1:53)(1:267)|54)(1:269)|55|56)|(2:58|(11:60|61|62|63|64|65|66|67|2ac|77|(5:(1:80)(1:87)|81|(1:83)(1:86)|84|85)(20:(1:89)|(1:91)|92|(1:94)|(1:96)|97|(4:99|(1:101)|102|(1:104))(1:252)|105|(1:107)|108|109|(1:111)(1:250)|112|114|115|(1:120)|121|(1:(1:(2:130|131))(1:128))|134|(2:144|(6:146|(1:148)(1:154)|149|(1:151)|152|153)(5:155|(1:157)|158|(3:160|(1:162)(1:246)|163)(1:247)|(4:226|(2:228|(1:230)(1:(1:234)(1:(1:236)(1:237))))(3:238|(1:240)(1:(1:243)(1:(1:245)))|241)|231|232)(12:168|(1:170)(1:223)|171|(3:173|(1:175)(1:177)|176)|178|(1:180)|181|(4:195|(4:198|(1:210)(1:202)|203|(3:205|(1:207)(1:209)|208))|211|(2:(1:221)|222)(3:215|(1:217)(1:219)|218))(2:(1:187)(1:194)|188)|189|(1:191)|192|193)))(4:138|(1:140)(1:143)|141|142))))|264|61|62|63|64|65|66|67|2ac) */
    /* JADX WARN: Can't wrap try/catch for region: R(18:16|17|18|19|(1:318)(6:25|26|27|(1:29)(1:314)|30|31)|(10:290|291|(1:293)(1:308)|294|(1:296)(1:307)|297|(1:299)(1:306)|300|(1:302)(1:305)|303)|33|(16:34|35|36|37|39|40|41|42|(4:272|273|(1:275)(1:277)|276)(1:44)|45|46|(1:48)|49|(3:51|(1:53)(1:267)|54)(1:269)|55|56)|(2:58|(11:60|61|62|63|64|65|66|67|2ac|77|(5:(1:80)(1:87)|81|(1:83)(1:86)|84|85)(20:(1:89)|(1:91)|92|(1:94)|(1:96)|97|(4:99|(1:101)|102|(1:104))(1:252)|105|(1:107)|108|109|(1:111)(1:250)|112|114|115|(1:120)|121|(1:(1:(2:130|131))(1:128))|134|(2:144|(6:146|(1:148)(1:154)|149|(1:151)|152|153)(5:155|(1:157)|158|(3:160|(1:162)(1:246)|163)(1:247)|(4:226|(2:228|(1:230)(1:(1:234)(1:(1:236)(1:237))))(3:238|(1:240)(1:(1:243)(1:(1:245)))|241)|231|232)(12:168|(1:170)(1:223)|171|(3:173|(1:175)(1:177)|176)|178|(1:180)|181|(4:195|(4:198|(1:210)(1:202)|203|(3:205|(1:207)(1:209)|208))|211|(2:(1:221)|222)(3:215|(1:217)(1:219)|218))(2:(1:187)(1:194)|188)|189|(1:191)|192|193)))(4:138|(1:140)(1:143)|141|142))))|264|61|62|63|64|65|66|67|2ac) */
    /* JADX WARN: Code restructure failed: missing block: B:260:0x02a9, code lost:
    
        r11 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:262:0x029f, code lost:
    
        r13 = 0;
     */
    /* JADX WARN: Removed duplicated region for block: B:269:0x024a  */
    /* JADX WARN: Removed duplicated region for block: B:272:0x0213 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:290:0x012e A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:44:0x0221  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x022c A[Catch: Exception -> 0x0274, TryCatch #6 {Exception -> 0x0274, blocks: (B:46:0x0224, B:48:0x022c, B:49:0x0234, B:51:0x023c), top: B:45:0x0224 }] */
    /* JADX WARN: Removed duplicated region for block: B:51:0x023c A[Catch: Exception -> 0x0274, TRY_LEAVE, TryCatch #6 {Exception -> 0x0274, blocks: (B:46:0x0224, B:48:0x022c, B:49:0x0234, B:51:0x023c), top: B:45:0x0224 }] */
    /* JADX WARN: Removed duplicated region for block: B:58:0x0254 A[Catch: Exception -> 0x0271, TRY_LEAVE, TryCatch #8 {Exception -> 0x0271, blocks: (B:56:0x024c, B:58:0x0254), top: B:55:0x024c }] */
    /* JADX WARN: Removed duplicated region for block: B:69:0x02ad  */
    @android.annotation.TargetApi(11)
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static boolean a(java.lang.String r32, int r33, boolean r34, boolean r35, boolean r36) {
        /*
            Method dump skipped, instructions count: 2025
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.smtt.sdk.TbsDownloader.a(java.lang.String, int, boolean, boolean, boolean):boolean");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static File a(int i2) {
        String[] coreProviderAppList = TbsShareManager.getCoreProviderAppList();
        int length = coreProviderAppList.length;
        File file = null;
        int i3 = 0;
        while (true) {
            if (i3 >= length) {
                break;
            }
            String str = coreProviderAppList[i3];
            if (!str.equals(f940c.getApplicationInfo().packageName)) {
                file = new File(com.tencent.smtt.utils.f.a(f940c, str, 4, false), getOverSea(f940c) ? "x5.oversea.tbs.org" : "x5.tbs.org");
                if (file.exists()) {
                    if (com.tencent.smtt.utils.a.a(f940c, file) == i2) {
                        TbsLog.i(LOGTAG, "local tbs version fond,path = " + file.getAbsolutePath());
                        break;
                    }
                    TbsLog.i(LOGTAG, "version is not match");
                } else {
                    TbsLog.i(LOGTAG, "can not find local backup core file");
                }
            }
            i3++;
        }
        return file;
    }

    private static JSONArray a(boolean z) {
        File file;
        boolean z2;
        JSONArray jSONArray = new JSONArray();
        for (String str : TbsShareManager.getCoreProviderAppList()) {
            if (z) {
                file = new File(com.tencent.smtt.utils.f.a(f940c, str, 4, false), getOverSea(f940c) ? "x5.oversea.tbs.org" : "x5.tbs.org");
            } else {
                file = new File(com.tencent.smtt.utils.f.a(f940c, str, 4, false), "x5.tbs.decouple");
            }
            if (file.exists()) {
                long a2 = com.tencent.smtt.utils.a.a(f940c, file);
                if (a2 > 0) {
                    int i2 = 0;
                    while (true) {
                        if (i2 >= jSONArray.length()) {
                            z2 = false;
                            break;
                        }
                        if (jSONArray.optInt(i2) == a2) {
                            z2 = true;
                            break;
                        }
                        i2++;
                    }
                    if (!z2) {
                        jSONArray.put(a2);
                    }
                }
            }
        }
        return jSONArray;
    }
}
