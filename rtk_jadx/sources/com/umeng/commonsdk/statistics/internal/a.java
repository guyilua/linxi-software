package com.umeng.commonsdk.statistics.internal;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import com.umeng.analytics.pro.ak;
import com.umeng.commonsdk.internal.crash.UMCrashManager;
import com.umeng.commonsdk.statistics.common.HelperUtils;
import com.umeng.commonsdk.utils.UMUtils;

/* compiled from: HeaderHelper.java */
/* loaded from: /tmp/rtk_apk/classes3.dex */
public class a {
    private static Context a;
    private String b;

    /* renamed from: c, reason: collision with root package name */
    private String f1109c;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: HeaderHelper.java */
    /* renamed from: com.umeng.commonsdk.statistics.internal.a$a, reason: collision with other inner class name */
    /* loaded from: /tmp/rtk_apk/classes3.dex */
    public static class C0132a {
        private static final a a = new a();

        private C0132a() {
        }
    }

    public static a a(Context context) {
        if (a == null && context != null) {
            a = context.getApplicationContext();
        }
        return C0132a.a;
    }

    private void e(String str) {
        try {
            this.b = str.replaceAll("&=", " ").replaceAll("&&", " ").replaceAll("==", "/") + "/Android/" + Build.DISPLAY + "/" + Build.MODEL + "/" + Build.VERSION.RELEASE + " " + HelperUtils.getUmengMD5(UMUtils.getAppkey(a));
        } catch (Throwable th) {
            UMCrashManager.reportCrash(a, th);
        }
    }

    private void f(String str) {
        try {
            String str2 = str.split("&&")[0];
            if (TextUtils.isEmpty(str2)) {
                return;
            }
            String[] split = str2.split("&=");
            StringBuilder sb = new StringBuilder();
            sb.append(ak.aP);
            for (String str3 : split) {
                if (!TextUtils.isEmpty(str3)) {
                    String substring = str3.substring(0, 2);
                    if (substring.endsWith("=")) {
                        substring = substring.replace("=", "");
                    }
                    sb.append(substring);
                }
            }
            this.f1109c = sb.toString();
        } catch (Throwable th) {
            UMCrashManager.reportCrash(a, th);
        }
    }

    public boolean b(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return str.startsWith(ak.aH);
    }

    public boolean c(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return str.startsWith(ak.aD);
    }

    public void d(String str) {
        String substring = str.substring(0, str.indexOf(95));
        f(substring);
        e(substring);
    }

    private a() {
        this.b = null;
        this.f1109c = null;
    }

    public String b() {
        return this.b;
    }

    public boolean a(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return str.startsWith(ak.av);
    }

    public String a() {
        return this.f1109c;
    }
}
