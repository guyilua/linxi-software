package com.tencent.smtt.sdk;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import android.util.Log;
import com.ss.android.downloadad.api.constant.AdBaseConstants;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.smtt.sdk.TbsDownloadConfig;
import com.tencent.smtt.utils.TbsLog;
import com.tencent.smtt.utils.g;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Map;
import org.json.JSONArray;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class TbsLogReport {
    private static TbsLogReport a;
    private Handler b;

    /* renamed from: c, reason: collision with root package name */
    private Context f941c;
    private boolean d = false;

    /* loaded from: /tmp/rtk_apk/classes3.dex */
    public enum EventType {
        TYPE_DOWNLOAD(0),
        TYPE_INSTALL(1),
        TYPE_LOAD(2),
        TYPE_DOWNLOAD_DECOUPLE(3),
        TYPE_INSTALL_DECOUPLE(4),
        TYPE_COOKIE_DB_SWITCH(5),
        TYPE_SDK_REPORT_INFO(6);

        int a;

        EventType(int i) {
            this.a = i;
        }
    }

    /* loaded from: /tmp/rtk_apk/classes3.dex */
    public static class TbsLogInfo implements Cloneable {
        int a;
        private long b;

        /* renamed from: c, reason: collision with root package name */
        private String f942c;
        private String d;
        private int e;
        private int f;
        private int g;
        private int h;
        private String i;
        private int j;
        private int k;
        private long l;
        private long m;
        private int n;
        private String o;
        private String p;
        private long q;

        protected Object clone() {
            try {
                return super.clone();
            } catch (CloneNotSupportedException unused) {
                return this;
            }
        }

        public int getDownFinalFlag() {
            return this.k;
        }

        public void resetArgs() {
            this.b = 0L;
            this.f942c = null;
            this.d = null;
            this.e = 0;
            this.f = 0;
            this.g = 0;
            this.h = 2;
            this.i = "unknown";
            this.j = 0;
            this.k = 2;
            this.l = 0L;
            this.m = 0L;
            this.n = 1;
            this.a = 0;
            this.o = null;
            this.p = null;
            this.q = 0L;
        }

        public void setApn(String str) {
            this.i = str;
        }

        public void setCheckErrorDetail(String str) {
            setErrorCode(108);
            this.o = str;
        }

        public void setDownConsumeTime(long j) {
            this.m += j;
        }

        public void setDownFinalFlag(int i) {
            this.k = i;
        }

        public void setDownloadCancel(int i) {
            this.g = i;
        }

        public void setDownloadSize(long j) {
            this.q += j;
        }

        public void setDownloadUrl(String str) {
            if (this.f942c == null) {
                this.f942c = str;
                return;
            }
            this.f942c += ";" + str;
        }

        public void setErrorCode(int i) {
            if (i != 100 && i != 110 && i != 120 && i != 111 && i < 400) {
                TbsLog.i(TbsDownloader.LOGTAG, "error occured, errorCode:" + i, true);
            }
            if (i == 111) {
                TbsLog.i(TbsDownloader.LOGTAG, "you are not in wifi, downloading stoped", true);
            }
            this.a = i;
        }

        public void setEventTime(long j) {
            this.b = j;
        }

        public void setFailDetail(String str) {
            if (str == null) {
                return;
            }
            if (str.length() > 1024) {
                str = str.substring(0, WXMediaMessage.DESCRIPTION_LENGTH_LIMIT);
            }
            this.p = str;
        }

        public void setHttpCode(int i) {
            this.e = i;
        }

        public void setNetworkChange(int i) {
            this.n = i;
        }

        public void setNetworkType(int i) {
            this.j = i;
        }

        public void setPatchUpdateFlag(int i) {
            this.f = i;
        }

        public void setPkgSize(long j) {
            this.l = j;
        }

        public void setResolveIp(String str) {
            this.d = str;
        }

        public void setUnpkgFlag(int i) {
            this.h = i;
        }

        private TbsLogInfo() {
            resetArgs();
        }

        public void setFailDetail(Throwable th) {
            if (th == null) {
                this.p = "";
                return;
            }
            String stackTraceString = Log.getStackTraceString(th);
            if (stackTraceString.length() > 1024) {
                stackTraceString = stackTraceString.substring(0, WXMediaMessage.DESCRIPTION_LENGTH_LIMIT);
            }
            this.p = stackTraceString;
        }
    }

    private TbsLogReport(Context context) {
        this.b = null;
        this.f941c = context.getApplicationContext();
        HandlerThread handlerThread = new HandlerThread("TbsLogReportThread");
        handlerThread.start();
        this.b = new Handler(handlerThread.getLooper()) { // from class: com.tencent.smtt.sdk.TbsLogReport.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                int i = message.what;
                if (i != 600) {
                    if (i == 601) {
                        TbsLogReport.this.b();
                        return;
                    }
                    return;
                }
                Object obj = message.obj;
                if (obj instanceof TbsLogInfo) {
                    try {
                        int i2 = message.arg1;
                        TbsLogReport.this.a(i2, (TbsLogInfo) obj);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c() {
        SharedPreferences.Editor edit = d().edit();
        edit.remove("tbs_download_upload");
        edit.commit();
    }

    private SharedPreferences d() {
        return this.f941c.getSharedPreferences("tbs_download_stat", 4);
    }

    public static TbsLogReport getInstance(Context context) {
        if (a == null) {
            synchronized (TbsLogReport.class) {
                if (a == null) {
                    a = new TbsLogReport(context);
                }
            }
        }
        return a;
    }

    public void clear() {
        try {
            SharedPreferences.Editor edit = d().edit();
            edit.clear();
            edit.commit();
        } catch (Exception unused) {
        }
    }

    public void dailyReport() {
        this.b.sendEmptyMessage(601);
    }

    public void eventReport(EventType eventType, TbsLogInfo tbsLogInfo) {
        try {
            TbsLogInfo tbsLogInfo2 = (TbsLogInfo) tbsLogInfo.clone();
            Message obtainMessage = this.b.obtainMessage();
            obtainMessage.what = AdBaseConstants.DEFAULT_BROADCAST_CHECK_TIME;
            obtainMessage.arg1 = eventType.a;
            obtainMessage.obj = tbsLogInfo2;
            this.b.sendMessage(obtainMessage);
        } catch (Throwable th) {
            TbsLog.w("upload", "[TbsLogReport.eventReport] error, message=" + th.getMessage());
        }
    }

    public boolean getShouldUploadEventReport() {
        return this.d;
    }

    /* JADX WARN: Code restructure failed: missing block: B:49:0x012e, code lost:
    
        if (r0 != 0) goto L29;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:50:0x0129 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:54:0x0122 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:67:0x0160  */
    /* JADX WARN: Removed duplicated region for block: B:69:? A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:70:0x0159 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:74:0x0152 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r0v12, types: [java.io.File] */
    /* JADX WARN: Type inference failed for: r0v13, types: [java.io.File] */
    /* JADX WARN: Type inference failed for: r0v20 */
    /* JADX WARN: Type inference failed for: r0v3, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r0v5 */
    /* JADX WARN: Type inference failed for: r0v6 */
    /* JADX WARN: Type inference failed for: r0v8 */
    /* JADX WARN: Type inference failed for: r0v9 */
    /* JADX WARN: Type inference failed for: r8v1 */
    /* JADX WARN: Type inference failed for: r8v10, types: [java.io.ByteArrayOutputStream] */
    /* JADX WARN: Type inference failed for: r8v4, types: [java.io.ByteArrayOutputStream] */
    /* JADX WARN: Type inference failed for: r8v9 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void reportTbsLog() {
        /*
            Method dump skipped, instructions count: 356
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.smtt.sdk.TbsLogReport.reportTbsLog():void");
    }

    public void setInstallErrorCode(int i, String str) {
        setInstallErrorCode(i, str, EventType.TYPE_INSTALL);
    }

    public void setLoadErrorCode(int i, String str) {
        TbsLogInfo tbsLogInfo = tbsLogInfo();
        tbsLogInfo.setErrorCode(i);
        tbsLogInfo.setEventTime(System.currentTimeMillis());
        tbsLogInfo.setFailDetail(str);
        eventReport(EventType.TYPE_LOAD, tbsLogInfo);
    }

    public void setShouldUploadEventReport(boolean z) {
        this.d = z;
    }

    public TbsLogInfo tbsLogInfo() {
        return new TbsLogInfo();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b() {
        Map<String, Object> map = QbSdk.n;
        if (map != null && map.containsKey(QbSdk.KEY_SET_SENDREQUEST_AND_UPLOAD) && QbSdk.n.get(QbSdk.KEY_SET_SENDREQUEST_AND_UPLOAD).equals("false")) {
            TbsLog.i("upload", "[TbsLogReport.sendLogReportRequest] -- SET_SENDREQUEST_AND_UPLOAD is false");
            return;
        }
        TbsLog.i(TbsDownloader.LOGTAG, "[TbsApkDownloadStat.reportDownloadStat]");
        JSONArray a2 = a();
        if (a2 != null && a2.length() != 0) {
            TbsLog.i(TbsDownloader.LOGTAG, "[TbsApkDownloadStat.reportDownloadStat] jsonArray:" + a2);
            try {
                TbsLog.i(TbsDownloader.LOGTAG, "[TbsApkDownloadStat.reportDownloadStat] response:" + com.tencent.smtt.utils.g.a(com.tencent.smtt.utils.n.a(this.f941c).c(), a2.toString().getBytes("utf-8"), new g.a() { // from class: com.tencent.smtt.sdk.TbsLogReport.3
                    @Override // com.tencent.smtt.utils.g.a
                    public void a(int i) {
                        TbsLog.i(TbsDownloader.LOGTAG, "[TbsApkDownloadStat.reportDownloadStat] onHttpResponseCode:" + i);
                        if (i < 300) {
                            TbsLogReport.this.c();
                        }
                    }
                }, true) + " testcase: -1");
                return;
            } catch (Throwable th) {
                th.printStackTrace();
                return;
            }
        }
        TbsLog.i(TbsDownloader.LOGTAG, "[TbsApkDownloadStat.reportDownloadStat] no data");
    }

    public void setInstallErrorCode(int i, String str, EventType eventType) {
        if (i != 200 && i != 220 && i != 221) {
            TbsLog.i(TbsDownloader.LOGTAG, "error occured in installation, errorCode:" + i, true);
        }
        TbsLogInfo tbsLogInfo = tbsLogInfo();
        tbsLogInfo.setFailDetail(str);
        a(i, tbsLogInfo, eventType);
    }

    private void a(int i, TbsLogInfo tbsLogInfo, EventType eventType) {
        tbsLogInfo.setErrorCode(i);
        tbsLogInfo.setEventTime(System.currentTimeMillis());
        QbSdk.m.onInstallFinish(i);
        eventReport(eventType, tbsLogInfo);
    }

    public void setInstallErrorCode(int i, Throwable th) {
        TbsLogInfo tbsLogInfo = tbsLogInfo();
        tbsLogInfo.setFailDetail(th);
        a(i, tbsLogInfo, EventType.TYPE_INSTALL);
    }

    public void setLoadErrorCode(int i, Throwable th) {
        String str;
        if (th != null) {
            str = "msg: " + th.getMessage() + "; err: " + th + "; cause: " + Log.getStackTraceString(th.getCause());
            if (str.length() > 1024) {
                str = str.substring(0, WXMediaMessage.DESCRIPTION_LENGTH_LIMIT);
            }
        } else {
            str = "NULL";
        }
        setLoadErrorCode(i, str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, TbsLogInfo tbsLogInfo) {
        StringBuilder sb = new StringBuilder();
        sb.append(a(i));
        sb.append(a(com.tencent.smtt.utils.b.c(this.f941c)));
        sb.append(a(com.tencent.smtt.utils.l.a(this.f941c)));
        sb.append(a(l.a().i(this.f941c)));
        String str = Build.MODEL;
        try {
            str = new String(str.getBytes("UTF-8"), "ISO8859-1");
        } catch (Exception unused) {
        }
        sb.append(a(str));
        String packageName = this.f941c.getPackageName();
        sb.append(a(packageName));
        if ("com.tencent.mm".equals(packageName)) {
            sb.append(a(com.tencent.smtt.utils.b.a(this.f941c, TbsDownloader.TBS_METADATA)));
        } else {
            sb.append(a(com.tencent.smtt.utils.b.b(this.f941c)));
        }
        sb.append(a(a(tbsLogInfo.b)));
        sb.append(a(tbsLogInfo.f942c));
        sb.append(a(tbsLogInfo.d));
        sb.append(a(tbsLogInfo.e));
        sb.append(a(tbsLogInfo.f));
        sb.append(a(tbsLogInfo.g));
        sb.append(a(tbsLogInfo.h));
        sb.append(a(tbsLogInfo.i));
        sb.append(a(tbsLogInfo.j));
        sb.append(a(tbsLogInfo.k));
        sb.append(b(tbsLogInfo.q));
        sb.append(b(tbsLogInfo.l));
        sb.append(b(tbsLogInfo.m));
        sb.append(a(tbsLogInfo.n));
        sb.append(a(tbsLogInfo.a));
        sb.append(a(tbsLogInfo.o));
        sb.append(a(tbsLogInfo.p));
        sb.append(a(TbsDownloadConfig.getInstance(this.f941c).mPreferences.getInt(TbsDownloadConfig.TbsConfigKey.KEY_TBS_DOWNLOAD_V, 0)));
        sb.append(a(com.tencent.smtt.utils.b.f(this.f941c)));
        sb.append(a("4.3.0.1148_43697"));
        sb.append(false);
        SharedPreferences d = d();
        JSONArray a2 = a();
        JSONArray jSONArray = new JSONArray();
        if (jSONArray.length() >= 5) {
            for (int i2 = 4; i2 >= 1; i2--) {
                try {
                    jSONArray.put(a2.get(jSONArray.length() - i2));
                } catch (Exception unused2) {
                    TbsLog.e("upload", "JSONArray transform error!");
                }
            }
            a2 = jSONArray;
        }
        a2.put(sb.toString());
        SharedPreferences.Editor edit = d.edit();
        edit.putString("tbs_download_upload", a2.toString());
        edit.commit();
        if (this.d || i != EventType.TYPE_LOAD.a) {
            b();
        }
    }

    private String b(long j) {
        return j + "|";
    }

    /* loaded from: /tmp/rtk_apk/classes3.dex */
    private static class a {
        private final String a;
        private final String b;

        public a(String str, String str2) {
            this.a = str;
            this.b = str2;
        }

        /* JADX WARN: Can't wrap try/catch for region: R(8:3|4|(7:5|6|7|8|9|10|11)|(10:13|14|15|16|(2:17|(1:19)(1:20))|21|22|23|24|25)|26|27|28|29) */
        /* JADX WARN: Code restructure failed: missing block: B:35:0x008d, code lost:
        
            r0 = move-exception;
         */
        /* JADX WARN: Code restructure failed: missing block: B:36:0x008e, code lost:
        
            r0.printStackTrace();
         */
        /* JADX WARN: Removed duplicated region for block: B:48:0x0079 A[EXC_TOP_SPLITTER, SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:52:0x006f A[EXC_TOP_SPLITTER, SYNTHETIC] */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:111:0x00d4 -> B:29:0x00d7). Please report as a decompilation issue!!! */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public void a() {
            /*
                Method dump skipped, instructions count: 238
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: com.tencent.smtt.sdk.TbsLogReport.a.a():void");
        }

        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:35:0x003d -> B:12:0x0040). Please report as a decompilation issue!!! */
        private static void a(File file) {
            RandomAccessFile randomAccessFile;
            RandomAccessFile randomAccessFile2 = null;
            RandomAccessFile randomAccessFile3 = null;
            randomAccessFile2 = null;
            try {
                try {
                    try {
                        randomAccessFile = new RandomAccessFile(file, "rw");
                    } catch (Throwable th) {
                        th = th;
                    }
                } catch (Exception e) {
                    e = e;
                }
            } catch (IOException e2) {
                e2.printStackTrace();
                randomAccessFile2 = randomAccessFile2;
            }
            try {
                int parseInt = Integer.parseInt("00001000", 2);
                randomAccessFile.seek(7L);
                int read = randomAccessFile.read();
                if ((read & parseInt) > 0) {
                    randomAccessFile.seek(7L);
                    randomAccessFile.write((~parseInt) & 255 & read);
                }
                randomAccessFile.close();
                randomAccessFile2 = read;
            } catch (Exception e3) {
                e = e3;
                randomAccessFile3 = randomAccessFile;
                e.printStackTrace();
                randomAccessFile2 = randomAccessFile3;
                if (randomAccessFile3 != null) {
                    randomAccessFile3.close();
                    randomAccessFile2 = randomAccessFile3;
                }
            } catch (Throwable th2) {
                th = th2;
                randomAccessFile2 = randomAccessFile;
                if (randomAccessFile2 != null) {
                    try {
                        randomAccessFile2.close();
                    } catch (IOException e4) {
                        e4.printStackTrace();
                    }
                }
                throw th;
            }
        }
    }

    private JSONArray a() {
        String string = d().getString("tbs_download_upload", null);
        if (string == null) {
            return new JSONArray();
        }
        try {
            JSONArray jSONArray = new JSONArray(string);
            if (jSONArray.length() > 5) {
                JSONArray jSONArray2 = new JSONArray();
                int length = jSONArray.length() - 1;
                if (length > jSONArray.length() - 5) {
                    jSONArray2.put(jSONArray.get(length));
                    return jSONArray2;
                }
            }
            return jSONArray;
        } catch (Exception unused) {
            return new JSONArray();
        }
    }

    private String a(long j) {
        try {
            return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.getDefault()).format(new Date(j));
        } catch (Exception unused) {
            return null;
        }
    }

    private String a(String str) {
        StringBuilder sb = new StringBuilder();
        if (str == null) {
            str = "";
        }
        sb.append(str);
        sb.append("|");
        return sb.toString();
    }

    private String a(int i) {
        return i + "|";
    }
}
