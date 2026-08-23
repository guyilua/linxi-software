package com.umeng.commonsdk.stateless;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.text.TextUtils;
import com.umeng.commonsdk.framework.UMEnvelopeBuild;
import com.umeng.commonsdk.internal.crash.UMCrashManager;
import com.umeng.commonsdk.statistics.common.DataHelper;
import com.umeng.commonsdk.statistics.common.DeviceConfig;

/* compiled from: UMSLNetWorkSenderHelper.java */
/* loaded from: /tmp/rtk_apk/classes3.dex */
public class c {
    private String a = "10.0.0.172";
    private int b = 80;

    /* renamed from: c, reason: collision with root package name */
    private Context f1099c;

    public c(Context context) {
        this.f1099c = context;
    }

    private void a() {
        String imprintProperty = UMEnvelopeBuild.imprintProperty(this.f1099c, "sl_domain_p", "");
        if (TextUtils.isEmpty(imprintProperty)) {
            return;
        }
        a.i = DataHelper.assembleStatelessURL(imprintProperty);
    }

    private void b() {
        String imprintProperty = UMEnvelopeBuild.imprintProperty(this.f1099c, "sl_domain_p", "");
        String imprintProperty2 = UMEnvelopeBuild.imprintProperty(this.f1099c, "oversea_sl_domain_p", "");
        if (!TextUtils.isEmpty(imprintProperty)) {
            a.h = DataHelper.assembleStatelessURL(imprintProperty);
        }
        if (!TextUtils.isEmpty(imprintProperty2)) {
            a.k = DataHelper.assembleStatelessURL(imprintProperty2);
        }
        a.i = a.k;
        if (TextUtils.isEmpty(com.umeng.commonsdk.statistics.b.b)) {
            return;
        }
        if (com.umeng.commonsdk.statistics.b.b.startsWith("460") || com.umeng.commonsdk.statistics.b.b.startsWith("461")) {
            a.i = a.h;
        }
    }

    private boolean c() {
        NetworkInfo activeNetworkInfo;
        String extraInfo;
        Context context = this.f1099c;
        if (context == null || context.getPackageManager().checkPermission("android.permission.ACCESS_NETWORK_STATE", this.f1099c.getPackageName()) != 0) {
            return false;
        }
        try {
            ConnectivityManager connectivityManager = (ConnectivityManager) this.f1099c.getSystemService("connectivity");
            if (DeviceConfig.checkPermission(this.f1099c, "android.permission.ACCESS_NETWORK_STATE") && connectivityManager != null && (activeNetworkInfo = connectivityManager.getActiveNetworkInfo()) != null && activeNetworkInfo.getType() != 1 && (extraInfo = activeNetworkInfo.getExtraInfo()) != null) {
                if (!extraInfo.equals("cmwap") && !extraInfo.equals("3gwap")) {
                    if (extraInfo.equals("uniwap")) {
                    }
                }
                return true;
            }
        } catch (Throwable th) {
            UMCrashManager.reportCrash(this.f1099c, th);
        }
        return false;
    }

    /* JADX WARN: Code restructure failed: missing block: B:22:0x0110, code lost:
    
        if (r13 == null) goto L52;
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x013f, code lost:
    
        return r2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x0112, code lost:
    
        com.umeng.commonsdk.debug.UMRTLog.e(com.umeng.commonsdk.debug.UMRTLog.RTLOG_TAG, "--->>> stateless: disconnect connection.");
        r13.disconnect();
     */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x013c, code lost:
    
        if (r13 == null) goto L52;
     */
    /* JADX WARN: Code restructure failed: missing block: B:44:0x012b, code lost:
    
        if (r13 == null) goto L52;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r13v1, types: [javax.net.ssl.HttpsURLConnection, java.lang.String] */
    /* JADX WARN: Type inference failed for: r13v16 */
    /* JADX WARN: Type inference failed for: r13v17 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean a(byte[] r11, java.lang.String r12, java.lang.String r13, java.lang.String r14) {
        /*
            Method dump skipped, instructions count: 349
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.umeng.commonsdk.stateless.c.a(byte[], java.lang.String, java.lang.String, java.lang.String):boolean");
    }
}
