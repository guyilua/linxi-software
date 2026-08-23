package com.tencent.smtt.sdk;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.util.Log;
import com.ss.android.downloadad.api.constant.AdBaseConstants;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.smtt.sdk.TbsDownloadConfig;
import com.tencent.smtt.sdk.TbsLogReport;
import com.tencent.smtt.utils.Apn;
import com.tencent.smtt.utils.TbsLog;
import java.io.BufferedReader;
import java.io.Closeable;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.InetAddress;
import java.net.URL;
import java.util.HashSet;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.regex.Pattern;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: TbsApkDownloader.java */
/* loaded from: /tmp/rtk_apk/classes3.dex */
public class i {
    private static int d = 5;
    private static int e = 1;
    private static final String[] f = {"tbs_downloading_com.tencent.mtt", "tbs_downloading_com.tencent.mm", "tbs_downloading_com.tencent.mobileqq", "tbs_downloading_com.tencent.tbs", "tbs_downloading_com.qzone"};
    private Set<String> A;
    private boolean C;
    String a;
    private Context g;
    private String h;
    private String i;
    private String j;
    private File k;
    private long l;
    private boolean o;
    private int p;
    private int q;
    private boolean r;
    private boolean s;
    private HttpURLConnection t;
    private String u;
    private TbsLogReport.TbsLogInfo v;
    private String w;
    private int x;
    private boolean y;
    private Handler z;
    private int m = 30000;
    private int n = AdBaseConstants.DEFAULT_INSTALL_FINISH_TRY_INTERVAL_MS;
    private int B = d;
    String[] b = null;

    /* renamed from: c, reason: collision with root package name */
    int f963c = 0;

    public i(Context context) {
        Context applicationContext = context.getApplicationContext();
        this.g = applicationContext;
        this.v = TbsLogReport.getInstance(applicationContext).tbsLogInfo();
        this.A = new HashSet();
        this.u = "tbs_downloading_" + this.g.getPackageName();
        l.a();
        File s = l.s(this.g);
        this.k = s;
        Objects.requireNonNull(s, "TbsCorePrivateDir is null!");
        e();
        this.w = null;
        this.x = -1;
    }

    private boolean b(int i) {
        try {
            File file = new File(this.k, "x5.tbs");
            File a = a(this.g);
            if (a == null) {
                return false;
            }
            File file2 = new File(a, TbsDownloader.getOverSea(this.g) ? "x5.oversea.tbs.org" : "x5.tbs.org");
            file.delete();
            com.tencent.smtt.utils.f.b(file2, file);
            if (com.tencent.smtt.utils.a.a(this.g, file, 0L, i)) {
                return true;
            }
            TbsLog.i(TbsDownloader.LOGTAG, "[TbsApkDownloader.copyTbsApkFromBackupToInstall] verifyTbsApk error!!");
            return false;
        } catch (Exception e2) {
            e2.printStackTrace();
            TbsLog.e(TbsDownloader.LOGTAG, "[TbsApkDownloader.copyTbsApkFromBackupToInstall] Exception is " + e2.getMessage());
            return false;
        }
    }

    private void c(boolean z) {
        com.tencent.smtt.utils.q.a(this.g);
        TbsDownloadConfig tbsDownloadConfig = TbsDownloadConfig.getInstance(this.g);
        Map<String, Object> map = tbsDownloadConfig.a;
        Boolean bool = Boolean.FALSE;
        map.put(TbsDownloadConfig.TbsConfigKey.KEY_FULL_PACKAGE, bool);
        tbsDownloadConfig.a.put(TbsDownloadConfig.TbsConfigKey.KEY_NEEDDOWNLOAD, bool);
        tbsDownloadConfig.a.put(TbsDownloadConfig.TbsConfigKey.KEY_DOWNLOAD_INTERRUPT_CODE_REASON, -123);
        tbsDownloadConfig.commit();
        QbSdk.m.onDownloadFinish(z ? 100 : 120);
        int i = tbsDownloadConfig.mPreferences.getInt(TbsDownloadConfig.TbsConfigKey.KEY_RESPONSECODE, 0);
        boolean a = TbsDownloader.a(this.g);
        if (i == 5) {
            Bundle a2 = a(i, a);
            if (a2 == null) {
                return;
            }
            l.a().b(this.g, a2);
            return;
        }
        if (i != 3 && i <= 10000) {
            l.a().a(this.g, new File(this.k, "x5.tbs").getAbsolutePath(), tbsDownloadConfig.mPreferences.getInt(TbsDownloadConfig.TbsConfigKey.KEY_TBS_DOWNLOAD_V, 0));
            a(new File(this.k, "x5.tbs"), this.g);
            return;
        }
        File a3 = a(this.g);
        if (a3 != null) {
            l.a().b(this.g, a(i, a3, a));
            return;
        }
        c();
        tbsDownloadConfig.a.put(TbsDownloadConfig.TbsConfigKey.KEY_NEEDDOWNLOAD, Boolean.TRUE);
        tbsDownloadConfig.commit();
    }

    private boolean d(boolean z) {
        File file;
        TbsLog.i(TbsDownloader.LOGTAG, "[TbsApkDownloader.deleteFile] isApk=" + z);
        if (z) {
            file = new File(this.k, "x5.tbs");
        } else {
            file = new File(this.k, "x5.tbs.temp");
        }
        if (file.exists()) {
            return file.delete();
        }
        return true;
    }

    private void e() {
        this.p = 0;
        this.q = 0;
        this.l = -1L;
        this.j = null;
        this.o = false;
        this.r = false;
        this.s = false;
        this.y = false;
    }

    private void f() {
        TbsLog.i(TbsDownloader.LOGTAG, "[TbsApkDownloader.closeHttpRequest]");
        HttpURLConnection httpURLConnection = this.t;
        if (httpURLConnection != null) {
            if (!this.r) {
                this.v.setResolveIp(a(httpURLConnection.getURL()));
            }
            try {
                this.t.disconnect();
            } catch (Throwable th) {
                TbsLog.e(TbsDownloader.LOGTAG, "[closeHttpRequest] mHttpRequest.disconnect() Throwable:" + th.toString());
            }
            this.t = null;
        }
        TbsLogReport.TbsLogInfo tbsLogInfo = this.v;
        int i = tbsLogInfo.a;
        if (!this.r && this.y) {
            tbsLogInfo.setEventTime(System.currentTimeMillis());
            String apnInfo = Apn.getApnInfo(this.g);
            if (apnInfo == null) {
                apnInfo = "";
            }
            int apnType = Apn.getApnType(this.g);
            this.v.setApn(apnInfo);
            this.v.setNetworkType(apnType);
            if (apnType != this.x || !apnInfo.equals(this.w)) {
                this.v.setNetworkChange(0);
            }
            TbsLogReport.TbsLogInfo tbsLogInfo2 = this.v;
            int i2 = tbsLogInfo2.a;
            if ((i2 == 0 || i2 == 107) && tbsLogInfo2.getDownFinalFlag() == 0) {
                if (!Apn.isNetworkAvailable(this.g)) {
                    a(101, (String) null, true);
                } else if (!k()) {
                    a(101, (String) null, true);
                }
            }
            if (TbsDownloader.a(this.g)) {
                TbsLogReport.getInstance(this.g).eventReport(TbsLogReport.EventType.TYPE_DOWNLOAD_DECOUPLE, this.v);
            } else {
                TbsLogReport.getInstance(this.g).eventReport(TbsLogReport.EventType.TYPE_DOWNLOAD, this.v);
            }
            this.v.resetArgs();
            if (i != 100) {
                QbSdk.m.onDownloadFinish(i);
                return;
            }
            return;
        }
        TbsDownloader.a = false;
    }

    private boolean g() {
        File file = new File(com.tencent.smtt.utils.f.a(this.g, 4), TbsDownloader.getOverSea(this.g) ? "x5.oversea.tbs.org" : "x5.tbs.org");
        int i = TbsDownloadConfig.getInstance(this.g).mPreferences.getInt(TbsDownloadConfig.TbsConfigKey.KEY_USE_BACKUP_VERSION, 0);
        if (i == 0) {
            i = TbsDownloadConfig.getInstance(this.g).mPreferences.getInt(TbsDownloadConfig.TbsConfigKey.KEY_TBS_DOWNLOAD_V, 0);
        }
        return com.tencent.smtt.utils.a.a(this.g, file, 0L, i);
    }

    private void h() {
        try {
            File file = new File(com.tencent.smtt.utils.f.a(this.g, 4), TbsDownloader.getOverSea(this.g) ? "x5.oversea.tbs.org" : "x5.tbs.org");
            if (file.exists()) {
                file.delete();
                File[] listFiles = file.getParentFile().listFiles();
                Pattern compile = Pattern.compile(com.tencent.smtt.utils.a.a(TbsDownloader.a(this.g)) + "(.*)");
                for (File file2 : listFiles) {
                    if (compile.matcher(file2.getName()).find() && file2.isFile() && file2.exists()) {
                        file2.delete();
                    }
                }
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    private boolean i() {
        return new File(this.k, "x5.tbs.temp").exists();
    }

    private long j() {
        File file = new File(this.k, "x5.tbs.temp");
        if (file.exists()) {
            return file.length();
        }
        return 0L;
    }

    private boolean k() {
        InputStreamReader inputStreamReader;
        BufferedReader bufferedReader;
        Throwable th;
        InputStream inputStream;
        boolean z = false;
        try {
            inputStream = Runtime.getRuntime().exec("ping www.qq.com").getInputStream();
            try {
                inputStreamReader = new InputStreamReader(inputStream);
                try {
                    bufferedReader = new BufferedReader(inputStreamReader);
                    int i = 0;
                    do {
                        try {
                            String readLine = bufferedReader.readLine();
                            if (readLine == null) {
                                break;
                            }
                            if (readLine.contains("TTL") || readLine.contains("ttl")) {
                                z = true;
                                break;
                            }
                            i++;
                        } catch (Throwable th2) {
                            th = th2;
                            try {
                                th.printStackTrace();
                                return z;
                            } finally {
                                a(inputStream);
                                a(inputStreamReader);
                                a(bufferedReader);
                            }
                        }
                    } while (i < 5);
                } catch (Throwable th3) {
                    bufferedReader = null;
                    th = th3;
                }
            } catch (Throwable th4) {
                bufferedReader = null;
                th = th4;
                inputStreamReader = null;
            }
        } catch (Throwable th5) {
            inputStreamReader = null;
            bufferedReader = null;
            th = th5;
            inputStream = null;
        }
        return z;
    }

    private long l() {
        int i = this.p;
        return (i == 1 || i == 2) ? i * 20000 : (i == 3 || i == 4) ? 100000L : 200000L;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean m() {
        boolean z = false;
        boolean z2 = Apn.getApnType(this.g) == 3;
        TbsLog.i(TbsDownloader.LOGTAG, "[TbsApkDwonloader.detectWifiNetworkAvailable] isWifi=" + z2);
        String str = null;
        HttpURLConnection httpURLConnection = null;
        if (z2) {
            String wifiSSID = Apn.getWifiSSID(this.g);
            TbsLog.i(TbsDownloader.LOGTAG, "[TbsApkDwonloader.detectWifiNetworkAvailable] localBSSID=" + wifiSSID);
            try {
                HttpURLConnection httpURLConnection2 = (HttpURLConnection) new URL("http://pms.mb.qq.com/rsp204").openConnection();
                try {
                    httpURLConnection2.setInstanceFollowRedirects(false);
                    httpURLConnection2.setConnectTimeout(10000);
                    httpURLConnection2.setReadTimeout(10000);
                    httpURLConnection2.setUseCaches(false);
                    httpURLConnection2.getInputStream();
                    int responseCode = httpURLConnection2.getResponseCode();
                    TbsLog.i(TbsDownloader.LOGTAG, "[TbsApkDwonloader.detectWifiNetworkAvailable] responseCode=" + responseCode);
                    boolean z3 = responseCode == 204;
                    if (httpURLConnection2 != null) {
                        try {
                            httpURLConnection2.disconnect();
                        } catch (Exception unused) {
                        }
                    }
                    str = wifiSSID;
                    z = z3;
                } catch (Throwable th) {
                    th = th;
                    httpURLConnection = httpURLConnection2;
                    try {
                        th.printStackTrace();
                        if (httpURLConnection != null) {
                            try {
                                httpURLConnection.disconnect();
                            } catch (Exception unused2) {
                            }
                        }
                        str = wifiSSID;
                        if (!z) {
                            this.A.add(str);
                            n();
                            this.z.sendMessageDelayed(this.z.obtainMessage(150, str), 120000L);
                        }
                        if (z) {
                            this.A.remove(str);
                        }
                        return z;
                    } catch (Throwable th2) {
                        if (httpURLConnection != null) {
                            try {
                                httpURLConnection.disconnect();
                            } catch (Exception unused3) {
                            }
                        }
                        throw th2;
                    }
                }
            } catch (Throwable th3) {
                th = th3;
            }
        }
        if (!z && !TextUtils.isEmpty(str) && !this.A.contains(str)) {
            this.A.add(str);
            n();
            this.z.sendMessageDelayed(this.z.obtainMessage(150, str), 120000L);
        }
        if (z && this.A.contains(str)) {
            this.A.remove(str);
        }
        return z;
    }

    private void n() {
        if (this.z == null) {
            this.z = new Handler(k.a().getLooper()) { // from class: com.tencent.smtt.sdk.i.1
                @Override // android.os.Handler
                public void handleMessage(Message message) {
                    if (message.what == 150) {
                        i.this.m();
                    }
                }
            };
        }
    }

    private void a(String str) {
        URL url = new URL(str);
        HttpURLConnection httpURLConnection = this.t;
        if (httpURLConnection != null) {
            try {
                httpURLConnection.disconnect();
            } catch (Throwable th) {
                TbsLog.e(TbsDownloader.LOGTAG, "[initHttpRequest] mHttpRequest.disconnect() Throwable:" + th.toString());
            }
        }
        HttpURLConnection httpURLConnection2 = (HttpURLConnection) url.openConnection();
        this.t = httpURLConnection2;
        httpURLConnection2.setRequestProperty(com.sigmob.sdk.downloader.core.c.d, TbsDownloader.b(this.g));
        this.t.setRequestProperty("Accept-Encoding", "identity");
        this.t.setRequestMethod("GET");
        this.t.setInstanceFollowRedirects(false);
        this.t.setConnectTimeout(this.n);
        this.t.setReadTimeout(this.m);
    }

    public boolean d() {
        TbsLog.i(TbsDownloader.LOGTAG, "[TbsApkDownloader.isDownloadForeground] mIsDownloadForeground=" + this.C);
        return this.C;
    }

    /*  JADX ERROR: Types fix failed
        jadx.core.utils.exceptions.JadxOverflowException: Type inference error: updates count limit reached
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:96)
        */
    public void b(boolean r40, boolean r41) {
        /*
            Method dump skipped, instructions count: 3255
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.smtt.sdk.i.b(boolean, boolean):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:27:0x008b  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x00ef  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean a(boolean r9, boolean r10) {
        /*
            Method dump skipped, instructions count: 320
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.smtt.sdk.i.a(boolean, boolean):boolean");
    }

    /* JADX WARN: Code restructure failed: missing block: B:19:0x0085, code lost:
    
        if (r10 != r8) goto L22;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private boolean c(boolean r13, boolean r14) {
        /*
            Method dump skipped, instructions count: 490
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.smtt.sdk.i.c(boolean, boolean):boolean");
    }

    public boolean a() {
        TbsLog.i("TbsApkDownloader", "verifyAndInstallDecoupleCoreFromBackup #1");
        try {
            File file = new File(com.tencent.smtt.utils.f.a(this.g, 4), "x5.tbs.decouple");
            if (file.exists()) {
                TbsLog.i("TbsApkDownloader", "verifyAndInstallDecoupleCoreFromBackup #2");
            } else {
                File b = TbsDownloader.b(TbsDownloadConfig.getInstance(this.g).mPreferences.getInt(TbsDownloadConfig.TbsConfigKey.KEY_DECOUPLECOREVERSION, -1));
                if (b != null && b.exists()) {
                    com.tencent.smtt.utils.f.b(b, file);
                }
            }
            Context context = this.g;
            if (!com.tencent.smtt.utils.a.a(context, file, 0L, TbsDownloadConfig.getInstance(context).mPreferences.getInt(TbsDownloadConfig.TbsConfigKey.KEY_DECOUPLECOREVERSION, -1))) {
                return false;
            }
            TbsLog.i("TbsApkDownloader", "verifyAndInstallDecoupleCoreFromBackup #3");
            return l.a().e(this.g);
        } catch (Exception unused) {
            return false;
        }
    }

    public void c() {
        b();
        d(false);
        d(true);
    }

    public static void c(Context context) {
        try {
            l.a();
            File s = l.s(context);
            new File(s, "x5.tbs").delete();
            new File(s, "x5.tbs.temp").delete();
            File a = a(context);
            if (a != null) {
                new File(a, "x5.tbs.org").delete();
                new File(a, "x5.oversea.tbs.org").delete();
                File[] listFiles = a.listFiles();
                Pattern compile = Pattern.compile(com.tencent.smtt.utils.a.a(true) + "(.*)");
                for (File file : listFiles) {
                    if (compile.matcher(file.getName()).find() && file.isFile() && file.exists()) {
                        file.delete();
                    }
                }
                Pattern compile2 = Pattern.compile(com.tencent.smtt.utils.a.a(false) + "(.*)");
                for (File file2 : listFiles) {
                    if (compile2.matcher(file2.getName()).find() && file2.isFile() && file2.exists()) {
                        file2.delete();
                    }
                }
            }
        } catch (Exception unused) {
        }
    }

    public boolean a(boolean z) {
        String[] strArr;
        int i;
        if ((z && !m() && (!QbSdk.getDownloadWithoutWifi() || !Apn.isNetworkAvailable(this.g))) || (strArr = this.b) == null || (i = this.f963c) < 0 || i >= strArr.length) {
            return false;
        }
        this.f963c = i + 1;
        this.j = strArr[i];
        this.p = 0;
        this.q = 0;
        this.l = -1L;
        this.o = false;
        this.r = false;
        this.s = false;
        this.y = false;
        return true;
    }

    private long a(long j, long j2) {
        long currentTimeMillis = System.currentTimeMillis();
        this.v.setDownConsumeTime(currentTimeMillis - j);
        this.v.setDownloadSize(j2);
        return currentTimeMillis;
    }

    private void a(int i, String str, boolean z) {
        if (z || this.p > this.B) {
            this.v.setErrorCode(i);
            this.v.setFailDetail(str);
        }
    }

    private String a(Throwable th) {
        String stackTraceString = Log.getStackTraceString(th);
        return stackTraceString.length() > 1024 ? stackTraceString.substring(0, WXMediaMessage.DESCRIPTION_LENGTH_LIMIT) : stackTraceString;
    }

    public Bundle a(int i, boolean z) {
        File q;
        int i2;
        File f2;
        if (z) {
            q = l.a().p(this.g);
            i2 = l.a().h(this.g);
        } else {
            q = l.a().q(this.g);
            i2 = l.a().i(this.g);
        }
        File file = new File(this.k, "x5.tbs");
        String absolutePath = file.exists() ? file.getAbsolutePath() : null;
        if (absolutePath == null) {
            return null;
        }
        int i3 = TbsDownloadConfig.getInstance(this.g).mPreferences.getInt(TbsDownloadConfig.TbsConfigKey.KEY_TBS_DOWNLOAD_V, 0);
        if (z) {
            f2 = l.a().f(this.g, 6);
        } else {
            f2 = l.a().f(this.g, 5);
        }
        Bundle bundle = new Bundle();
        bundle.putInt("operation", i);
        bundle.putInt("old_core_ver", i2);
        bundle.putInt("new_core_ver", i3);
        bundle.putString("old_apk_location", q.getAbsolutePath());
        bundle.putString("new_apk_location", f2.getAbsolutePath());
        bundle.putString("diff_file_location", absolutePath);
        String a = com.tencent.smtt.utils.f.a(this.g, 7);
        File file2 = new File(a);
        if (!file2.exists()) {
            file2.mkdirs();
        }
        bundle.putString("backup_apk", new File(a, i3 + ".tbs").getAbsolutePath());
        return bundle;
    }

    public Bundle a(int i, File file, boolean z) {
        File file2;
        if (z) {
            file2 = new File(file, "x5.tbs.decouple");
        } else {
            file2 = new File(file, TbsDownloader.getOverSea(this.g) ? "x5.oversea.tbs.org" : "x5.tbs.org");
        }
        int a = com.tencent.smtt.utils.a.a(this.g, file2);
        File file3 = new File(this.k, "x5.tbs");
        String absolutePath = file3.exists() ? file3.getAbsolutePath() : null;
        int i2 = TbsDownloadConfig.getInstance(this.g).mPreferences.getInt(TbsDownloadConfig.TbsConfigKey.KEY_TBS_DOWNLOAD_V, 0);
        Bundle bundle = new Bundle();
        bundle.putInt("operation", i);
        bundle.putInt("old_core_ver", a);
        bundle.putInt("new_core_ver", i2);
        bundle.putString("old_apk_location", file2.getAbsolutePath());
        bundle.putString("new_apk_location", absolutePath);
        bundle.putString("diff_file_location", absolutePath);
        return bundle;
    }

    private void a(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (IOException unused) {
            }
        }
    }

    private void a(long j) {
        this.p++;
        if (j <= 0) {
            try {
                j = l();
            } catch (Exception unused) {
                return;
            }
        }
        Thread.sleep(j);
    }

    private String a(URL url) {
        try {
            return InetAddress.getByName(url.getHost()).getHostAddress();
        } catch (Error e2) {
            e2.printStackTrace();
            return "";
        } catch (Exception e3) {
            e3.printStackTrace();
            return "";
        }
    }

    @TargetApi(8)
    static File a(Context context) {
        try {
            File file = Build.VERSION.SDK_INT >= 8 ? new File(com.tencent.smtt.utils.f.a(context, 4)) : null;
            if (file != null && !file.exists() && !file.isDirectory()) {
                file.mkdirs();
            }
            return file;
        } catch (Exception e2) {
            e2.printStackTrace();
            TbsLog.e(TbsDownloader.LOGTAG, "[TbsApkDownloader.backupApkPath] Exception is " + e2.getMessage());
            return null;
        }
    }

    private static File a(Context context, int i) {
        File file = new File(com.tencent.smtt.utils.f.a(context, i));
        if (file.exists() && file.isDirectory()) {
            if (new File(file, TbsDownloader.getOverSea(context) ? "x5.oversea.tbs.org" : "x5.tbs.org").exists()) {
                return file;
            }
        }
        return null;
    }

    public void a(int i) {
        if (l.a().t(this.g)) {
            l.a().b();
            try {
                File file = new File(this.k, "x5.tbs");
                int a = com.tencent.smtt.utils.a.a(this.g, file);
                if (-1 == a || (i > 0 && i == a)) {
                    com.tencent.smtt.utils.f.b(file);
                }
            } catch (Exception unused) {
            }
        }
    }

    public static void a(File file, Context context) {
        File file2;
        synchronized (com.tencent.smtt.utils.a.class) {
            if (file != null) {
                if (file.exists()) {
                    try {
                        File a = a(context);
                        if (a != null) {
                            if (TbsDownloadConfig.getInstance(context).mPreferences.getInt(TbsDownloadConfig.TbsConfigKey.KEY_TBS_DOWNLOAD_V_TYPE, 0) == 1) {
                                file2 = new File(a, "x5.tbs.decouple");
                            } else {
                                file2 = new File(a, TbsDownloader.getOverSea(context) ? "x5.oversea.tbs.org" : "x5.tbs.org");
                            }
                            file2.delete();
                            com.tencent.smtt.utils.f.b(file, file2);
                            boolean contains = file2.getName().contains("tbs.org");
                            boolean contains2 = file2.getName().contains("x5.tbs.decouple");
                            if (contains2 || contains) {
                                File[] listFiles = a.listFiles();
                                Pattern compile = Pattern.compile(com.tencent.smtt.utils.a.a(contains2) + "(.*)");
                                for (File file3 : listFiles) {
                                    if (compile.matcher(file3.getName()).find() && file3.isFile() && file3.exists()) {
                                        file3.delete();
                                    }
                                }
                                File file4 = new File(a, com.tencent.smtt.utils.a.a(contains2) + "." + TbsDownloadConfig.getInstance(context).mPreferences.getInt(TbsDownloadConfig.TbsConfigKey.KEY_TBS_DOWNLOAD_V, 0));
                                if (file4.exists()) {
                                    TbsLog.e(TbsDownloader.LOGTAG, "[TbsApkDownloader.backupTbsApk]delete bacup config file error ");
                                    return;
                                }
                                file4.createNewFile();
                            }
                            if (TbsDownloadConfig.getInstance(context).mPreferences.getInt(TbsDownloadConfig.TbsConfigKey.KEY_TBS_DOWNLOAD_V_TYPE, 0) != 1 && TbsDownloadConfig.getInstance(context).mPreferences.getInt(TbsDownloadConfig.TbsConfigKey.KEY_DECOUPLECOREVERSION, 0) == com.tencent.smtt.utils.a.a(context, file)) {
                                int i = TbsDownloadConfig.getInstance(context).mPreferences.getInt(TbsDownloadConfig.TbsConfigKey.KEY_RESPONSECODE, 0);
                                if (i == 5 || i == 3) {
                                    TbsLog.i("TbsApkDownloader", "response code=" + i + "return backup decouple apk");
                                }
                                File file5 = new File(a, "x5.tbs.decouple");
                                if (com.tencent.smtt.utils.a.a(context, file) != com.tencent.smtt.utils.a.a(context, file5)) {
                                    file5.delete();
                                    com.tencent.smtt.utils.f.b(file, file5);
                                }
                            }
                        }
                    } catch (Exception unused) {
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @TargetApi(8)
    public static File b(Context context) {
        try {
            if (Build.VERSION.SDK_INT < 8) {
                return null;
            }
            File a = a(context, 4);
            if (a == null) {
                a = a(context, 3);
            }
            if (a == null) {
                a = a(context, 2);
            }
            return a == null ? a(context, 1) : a;
        } catch (Exception e2) {
            e2.printStackTrace();
            TbsLog.e(TbsDownloader.LOGTAG, "[TbsApkDownloader.backupApkPath] Exception is " + e2.getMessage());
            return null;
        }
    }

    public int b(boolean z) {
        File a = a(this.g);
        if (z) {
            if (a == null) {
                return 0;
            }
            return com.tencent.smtt.utils.a.a(this.g, new File(a, "x5.tbs.decouple"));
        }
        if (a == null) {
            return 0;
        }
        return com.tencent.smtt.utils.a.a(this.g, new File(a, TbsDownloader.getOverSea(this.g) ? "x5.oversea.tbs.org" : "x5.tbs.org"));
    }

    public void b() {
        this.r = true;
        if (TbsShareManager.isThirdPartyApp(this.g)) {
            TbsLogReport.TbsLogInfo tbsLogInfo = TbsLogReport.getInstance(this.g).tbsLogInfo();
            tbsLogInfo.setErrorCode(-309);
            tbsLogInfo.setFailDetail(new Exception());
            if (TbsDownloader.a(this.g)) {
                TbsLogReport.getInstance(this.g).eventReport(TbsLogReport.EventType.TYPE_DOWNLOAD_DECOUPLE, tbsLogInfo);
            } else {
                TbsLogReport.getInstance(this.g).eventReport(TbsLogReport.EventType.TYPE_DOWNLOAD, tbsLogInfo);
            }
        }
    }
}
