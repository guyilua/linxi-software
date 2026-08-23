package com.umeng.commonsdk.statistics.internal;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.text.TextUtils;
import com.umeng.analytics.CoreProtocol;
import com.umeng.analytics.pro.l;
import com.umeng.analytics.pro.o;
import com.umeng.commonsdk.config.FieldManager;
import com.umeng.commonsdk.debug.UMLog;
import com.umeng.commonsdk.debug.UMRTLog;
import com.umeng.commonsdk.framework.UMEnvelopeBuild;
import com.umeng.commonsdk.framework.UMWorkDispatch;
import com.umeng.commonsdk.internal.crash.UMCrashManager;
import com.umeng.commonsdk.statistics.AnalyticsConstants;
import com.umeng.commonsdk.statistics.SdkVersion;
import com.umeng.commonsdk.statistics.UMServerURL;
import com.umeng.commonsdk.statistics.common.DataHelper;
import com.umeng.commonsdk.statistics.common.DeviceConfig;
import com.umeng.commonsdk.statistics.common.HelperUtils;
import com.umeng.commonsdk.statistics.idtracking.ImprintHandler;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.net.URL;
import java.net.UnknownHostException;
import java.security.SecureRandom;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLHandshakeException;
import org.apache.http.conn.ssl.SSLSocketFactory;

/* compiled from: NetworkHelper.java */
/* loaded from: /tmp/rtk_apk/classes3.dex */
public class c {
    private static boolean e = false;
    private static boolean f = false;
    private static boolean g = false;
    private String a = "10.0.0.172";
    private int b = 80;

    /* renamed from: c, reason: collision with root package name */
    private Context f1110c;
    private b d;

    public c(Context context) {
        this.f1110c = context;
    }

    private void b() {
        String imprintProperty = UMEnvelopeBuild.imprintProperty(this.f1110c, "domain_p", "");
        String imprintProperty2 = UMEnvelopeBuild.imprintProperty(this.f1110c, "domain_s", "");
        if (!TextUtils.isEmpty(imprintProperty)) {
            UMServerURL.DEFAULT_URL = DataHelper.assembleURL(imprintProperty);
        }
        if (!TextUtils.isEmpty(imprintProperty2)) {
            UMServerURL.SECONDARY_URL = DataHelper.assembleURL(imprintProperty2);
        }
        String imprintProperty3 = UMEnvelopeBuild.imprintProperty(this.f1110c, "oversea_domain_p", "");
        String imprintProperty4 = UMEnvelopeBuild.imprintProperty(this.f1110c, "oversea_domain_s", "");
        if (!TextUtils.isEmpty(imprintProperty3)) {
            UMServerURL.OVERSEA_DEFAULT_URL = DataHelper.assembleURL(imprintProperty3);
        }
        if (!TextUtils.isEmpty(imprintProperty4)) {
            UMServerURL.OVERSEA_SECONDARY_URL = DataHelper.assembleURL(imprintProperty4);
        }
        AnalyticsConstants.APPLOG_URL_LIST = new String[]{UMServerURL.OVERSEA_DEFAULT_URL, UMServerURL.OVERSEA_SECONDARY_URL};
        if (TextUtils.isEmpty(com.umeng.commonsdk.statistics.b.b)) {
            return;
        }
        if (com.umeng.commonsdk.statistics.b.b.startsWith("460") || com.umeng.commonsdk.statistics.b.b.startsWith("461")) {
            AnalyticsConstants.APPLOG_URL_LIST = new String[]{UMServerURL.DEFAULT_URL, UMServerURL.SECONDARY_URL};
        }
    }

    private void c() {
        if (g) {
            return;
        }
        ImprintHandler.getImprintService(this.f1110c).registImprintCallback(AnalyticsConstants.CFG_FIELD_KEY, new UMImprintChangeCallback() { // from class: com.umeng.commonsdk.statistics.internal.c.1
            @Override // com.umeng.commonsdk.statistics.internal.UMImprintChangeCallback
            public void onImprintValueChanged(String str, String str2) {
                if (FieldManager.b()) {
                    FieldManager.a().a(c.this.f1110c, str2);
                    UMRTLog.e(UMRTLog.RTLOG_TAG, "--->>> apply imprint change and exit: key=" + str + "; value= " + str2);
                    UMWorkDispatch.sendEvent(c.this.f1110c, com.umeng.commonsdk.internal.a.w, com.umeng.commonsdk.internal.b.a(c.this.f1110c).a(), null);
                }
            }
        });
        g = true;
    }

    private void d() {
        if (f) {
            return;
        }
        UMRTLog.e(UMRTLog.RTLOG_TAG, "--->>> 注册零号报文 imprint 应答处理回调。");
        ImprintHandler.getImprintService(this.f1110c).registPreProcessCallback(AnalyticsConstants.ZERO_RESPONSE_FLAG, new UMImprintPreProcessCallback() { // from class: com.umeng.commonsdk.statistics.internal.c.2
            @Override // com.umeng.commonsdk.statistics.internal.UMImprintPreProcessCallback
            public boolean onPreProcessImprintKey(String str, String str2) {
                UMRTLog.e(UMRTLog.RTLOG_TAG, "--->>> onImprintValueChanged: key=" + str + "; value= " + str2);
                FieldManager.a().a(c.this.f1110c);
                UMWorkDispatch.sendEvent(c.this.f1110c, com.umeng.commonsdk.internal.a.s, com.umeng.commonsdk.internal.b.a(c.this.f1110c).a(), null);
                ImprintHandler.getImprintService(c.this.f1110c).a(AnalyticsConstants.ZERO_RESPONSE_FLAG);
                return true;
            }
        });
        ImprintHandler.getImprintService(this.f1110c).registImprintCallback(AnalyticsConstants.CFG_FIELD_KEY, new UMImprintChangeCallback() { // from class: com.umeng.commonsdk.statistics.internal.c.3
            @Override // com.umeng.commonsdk.statistics.internal.UMImprintChangeCallback
            public void onImprintValueChanged(String str, String str2) {
                UMRTLog.e(UMRTLog.RTLOG_TAG, "--->>> first onImprintValueChanged: key=" + str + "; value= " + str2);
                FieldManager.a().a(c.this.f1110c, str2);
                UMWorkDispatch.sendEvent(c.this.f1110c, com.umeng.commonsdk.internal.a.s, com.umeng.commonsdk.internal.b.a(c.this.f1110c).a(), null);
                if (FieldManager.allow(com.umeng.commonsdk.utils.b.E)) {
                    UMRTLog.i(UMRTLog.RTLOG_TAG, "--->>> recv zcfg response: foregound count timer enabled.");
                    if (!UMWorkDispatch.eventHasExist()) {
                        UMWorkDispatch.sendEventEx(c.this.f1110c, o.a.C, CoreProtocol.getInstance(c.this.f1110c), null, 0L);
                    }
                }
                if (FieldManager.allow(com.umeng.commonsdk.utils.b.F)) {
                    UMRTLog.i(UMRTLog.RTLOG_TAG, "--->>> recv zcfg response: FirstResumeTrigger enabled.");
                    l.a(c.this.f1110c).b(c.this.f1110c);
                }
                ImprintHandler.getImprintService(c.this.f1110c).unregistImprintCallback(AnalyticsConstants.CFG_FIELD_KEY, this);
            }
        });
        f = true;
    }

    private boolean e() {
        NetworkInfo activeNetworkInfo;
        String extraInfo;
        if (this.f1110c.getPackageManager().checkPermission("android.permission.ACCESS_NETWORK_STATE", this.f1110c.getPackageName()) != 0) {
            return false;
        }
        try {
            ConnectivityManager connectivityManager = (ConnectivityManager) this.f1110c.getSystemService("connectivity");
            if (DeviceConfig.checkPermission(this.f1110c, "android.permission.ACCESS_NETWORK_STATE") && connectivityManager != null && (activeNetworkInfo = connectivityManager.getActiveNetworkInfo()) != null && activeNetworkInfo.getType() != 1 && (extraInfo = activeNetworkInfo.getExtraInfo()) != null) {
                if (!extraInfo.equals("cmwap") && !extraInfo.equals("3gwap")) {
                    if (extraInfo.equals("uniwap")) {
                    }
                }
                return true;
            }
        } catch (Throwable th) {
            UMCrashManager.reportCrash(this.f1110c, th);
        }
        return false;
    }

    public void a(b bVar) {
        this.d = bVar;
    }

    private void a() {
        String imprintProperty = UMEnvelopeBuild.imprintProperty(this.f1110c, "domain_p", "");
        String imprintProperty2 = UMEnvelopeBuild.imprintProperty(this.f1110c, "domain_s", "");
        if (!TextUtils.isEmpty(imprintProperty)) {
            UMServerURL.DEFAULT_URL = DataHelper.assembleURL(imprintProperty);
        }
        if (!TextUtils.isEmpty(imprintProperty2)) {
            UMServerURL.SECONDARY_URL = DataHelper.assembleURL(imprintProperty2);
        }
        AnalyticsConstants.APPLOG_URL_LIST = new String[]{UMServerURL.DEFAULT_URL, UMServerURL.SECONDARY_URL};
    }

    public byte[] a(byte[] bArr, boolean z, boolean z2, String str) {
        if (SdkVersion.SDK_TYPE == 0) {
            a();
        } else {
            UMServerURL.DEFAULT_URL = UMServerURL.OVERSEA_DEFAULT_URL;
            UMServerURL.SECONDARY_URL = UMServerURL.OVERSEA_SECONDARY_URL;
            b();
        }
        int i = 0;
        byte[] bArr2 = null;
        while (true) {
            String[] strArr = AnalyticsConstants.APPLOG_URL_LIST;
            if (i >= strArr.length) {
                break;
            }
            String str2 = strArr[i];
            if (z2) {
                d();
            } else {
                c();
            }
            bArr2 = a(bArr, str2 + File.separator + str);
            if (bArr2 != null) {
                b bVar = this.d;
                if (bVar != null) {
                    bVar.onRequestSucceed(z);
                }
            } else {
                b bVar2 = this.d;
                if (bVar2 != null) {
                    bVar2.onRequestFailed();
                }
                i++;
            }
        }
        return bArr2;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Not initialized variable reg: 6, insn: 0x0183: IF  (r6 I:??[int, boolean, OBJECT, ARRAY, byte, short, char]) == (0 ??[int, boolean, OBJECT, ARRAY, byte, short, char])  -> B:113:0x018f, block:B:112:0x0183 */
    public byte[] a(byte[] bArr, String str) {
        HttpsURLConnection httpsURLConnection;
        OutputStream outputStream;
        OutputStream outputStream2;
        boolean z;
        try {
            try {
                b bVar = this.d;
                if (bVar != null) {
                    bVar.onRequestStart();
                }
                if (e()) {
                    httpsURLConnection = (HttpsURLConnection) new URL(str).openConnection(new Proxy(Proxy.Type.HTTP, new InetSocketAddress(this.a, this.b)));
                } else {
                    httpsURLConnection = (HttpsURLConnection) new URL(str).openConnection();
                }
                try {
                    z = true;
                    if (!e) {
                        httpsURLConnection.setHostnameVerifier(SSLSocketFactory.STRICT_HOSTNAME_VERIFIER);
                        SSLContext sSLContext = SSLContext.getInstance("TLS");
                        sSLContext.init(null, null, new SecureRandom());
                        httpsURLConnection.setSSLSocketFactory(sSLContext.getSocketFactory());
                        e = true;
                    }
                    httpsURLConnection.setRequestProperty("X-Umeng-UTC", String.valueOf(System.currentTimeMillis()));
                    httpsURLConnection.setRequestProperty("X-Umeng-Sdk", a.a(this.f1110c).b());
                    httpsURLConnection.setRequestProperty("Content-Type", a.a(this.f1110c).a());
                    httpsURLConnection.setRequestProperty("Msg-Type", "envelope/json");
                    httpsURLConnection.setRequestProperty("X-Umeng-Pro-Ver", "1.0.0");
                    httpsURLConnection.setConnectTimeout(30000);
                    httpsURLConnection.setReadTimeout(30000);
                    httpsURLConnection.setRequestMethod("POST");
                    httpsURLConnection.setDoOutput(true);
                    httpsURLConnection.setDoInput(true);
                    httpsURLConnection.setUseCaches(false);
                    outputStream = httpsURLConnection.getOutputStream();
                } catch (UnknownHostException unused) {
                    outputStream = null;
                } catch (SSLHandshakeException unused2) {
                    outputStream = null;
                } catch (Throwable unused3) {
                    outputStream = null;
                }
            } catch (Throwable th) {
                if (outputStream2 != null) {
                    try {
                        outputStream2.close();
                    } catch (Exception e2) {
                        UMCrashManager.reportCrash(this.f1110c, e2);
                    }
                }
                if (str == 0) {
                    throw th;
                }
                try {
                    str.getInputStream().close();
                } catch (IOException unused4) {
                }
                str.disconnect();
                throw th;
            }
        } catch (UnknownHostException unused5) {
            httpsURLConnection = null;
            outputStream = null;
        } catch (SSLHandshakeException unused6) {
            httpsURLConnection = null;
            outputStream = null;
        } catch (Throwable unused7) {
            httpsURLConnection = null;
            outputStream = null;
        }
        try {
            outputStream.write(bArr);
            outputStream.flush();
            httpsURLConnection.connect();
            b bVar2 = this.d;
            if (bVar2 != null) {
                bVar2.onRequestEnd();
            }
            int responseCode = httpsURLConnection.getResponseCode();
            String headerField = httpsURLConnection.getHeaderField("Content-Type");
            if (TextUtils.isEmpty(headerField) || !headerField.equalsIgnoreCase("application/thrift")) {
                z = false;
            }
            boolean z2 = AnalyticsConstants.UM_DEBUG;
            if (responseCode != 200 || !z) {
                if (outputStream != null) {
                    try {
                        outputStream.close();
                    } catch (Exception e3) {
                        UMCrashManager.reportCrash(this.f1110c, e3);
                    }
                }
                if (httpsURLConnection != null) {
                    try {
                        httpsURLConnection.getInputStream().close();
                    } catch (IOException unused8) {
                    }
                    httpsURLConnection.disconnect();
                }
                return null;
            }
            InputStream inputStream = httpsURLConnection.getInputStream();
            try {
                byte[] readStreamToByteArray = HelperUtils.readStreamToByteArray(inputStream);
                if (outputStream != null) {
                    try {
                        outputStream.close();
                    } catch (Exception e4) {
                        UMCrashManager.reportCrash(this.f1110c, e4);
                    }
                }
                if (httpsURLConnection != null) {
                    try {
                        httpsURLConnection.getInputStream().close();
                    } catch (IOException unused9) {
                    }
                    httpsURLConnection.disconnect();
                }
                return readStreamToByteArray;
            } finally {
                HelperUtils.safeClose(inputStream);
            }
        } catch (UnknownHostException unused10) {
            UMLog.aq("A_10200", 2, "\\|");
            if (outputStream != null) {
                try {
                    outputStream.close();
                } catch (Exception e5) {
                    UMCrashManager.reportCrash(this.f1110c, e5);
                }
            }
            if (httpsURLConnection != null) {
                try {
                    httpsURLConnection.getInputStream().close();
                } catch (IOException unused11) {
                }
                httpsURLConnection.disconnect();
            }
            return null;
        } catch (SSLHandshakeException unused12) {
            UMLog.aq("A_10201", 2, "\\|");
            if (outputStream != null) {
                try {
                    outputStream.close();
                } catch (Exception e6) {
                    UMCrashManager.reportCrash(this.f1110c, e6);
                }
            }
            if (httpsURLConnection != null) {
                try {
                    httpsURLConnection.getInputStream().close();
                } catch (IOException unused13) {
                }
                httpsURLConnection.disconnect();
            }
            return null;
        } catch (Throwable unused14) {
            if (outputStream != null) {
                try {
                    outputStream.close();
                } catch (Exception e7) {
                    UMCrashManager.reportCrash(this.f1110c, e7);
                }
            }
            if (httpsURLConnection != null) {
                try {
                    httpsURLConnection.getInputStream().close();
                } catch (IOException unused15) {
                }
                httpsURLConnection.disconnect();
            }
            return null;
        }
    }
}
