package com.tencent.smtt.utils;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.WindowManager;
import com.tencent.smtt.sdk.TbsConfig;
import com.tencent.smtt.sdk.TbsListener;
import com.tencent.smtt.sdk.WebView;

/* compiled from: SysCoreQUA2Utils.java */
/* loaded from: /tmp/rtk_apk/classes3.dex */
public class l {
    private static String a = null;
    private static String b = "GA";

    /* renamed from: c, reason: collision with root package name */
    private static String f987c = "GE";
    private static String d = "9422";
    private static String e = "0";
    private static String f = "";
    private static boolean g = false;
    private static boolean h = false;
    private static boolean i = false;

    public static String a(Context context) {
        if (!TextUtils.isEmpty(a)) {
            return a;
        }
        String a2 = a(context, String.valueOf(WebView.getTbsSDKVersion(context)), "0", b, f987c, d, e, f, g);
        a = a2;
        return a2;
    }

    private static int b(Context context) {
        Display defaultDisplay = ((WindowManager) context.getSystemService("window")).getDefaultDisplay();
        if (defaultDisplay != null) {
            return defaultDisplay.getWidth();
        }
        return -1;
    }

    private static int c(Context context) {
        Display defaultDisplay = ((WindowManager) context.getSystemService("window")).getDefaultDisplay();
        if (defaultDisplay != null) {
            return defaultDisplay.getHeight();
        }
        return -1;
    }

    private static boolean d(Context context) {
        if (h) {
            return i;
        }
        try {
            boolean z = (Math.min(b(context), c(context)) * TbsListener.ErrorCode.STARTDOWNLOAD_1) / e(context) >= 700;
            i = z;
            h = true;
            return z;
        } catch (Throwable unused) {
            return false;
        }
    }

    private static int e(Context context) {
        WindowManager windowManager = (WindowManager) context.getSystemService("window");
        DisplayMetrics displayMetrics = new DisplayMetrics();
        Display defaultDisplay = windowManager.getDefaultDisplay();
        if (defaultDisplay == null) {
            return TbsListener.ErrorCode.STARTDOWNLOAD_1;
        }
        defaultDisplay.getMetrics(displayMetrics);
        return displayMetrics.densityDpi;
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0095  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x00a8  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x00c5  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x00ec  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x010a  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x00c8  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static java.lang.String a(android.content.Context r11, java.lang.String r12, java.lang.String r13, java.lang.String r14, java.lang.String r15, java.lang.String r16, java.lang.String r17, java.lang.String r18, boolean r19) {
        /*
            Method dump skipped, instructions count: 298
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.smtt.utils.l.a(android.content.Context, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, boolean):java.lang.String");
    }

    private static void a(StringBuilder sb, String str, String str2) {
        sb.append("&");
        sb.append(str);
        sb.append("=");
        sb.append(str2);
    }

    private static String a(String str) {
        return "com.tencent.mm".equals(str) ? "WX" : TbsConfig.APP_QQ.equals(str) ? "QQ" : TbsConfig.APP_QZONE.equals(str) ? "QZ" : TbsConfig.APP_QB.equals(str) ? "QB" : "TRD";
    }

    private static String a() {
        return " " + Build.MODEL.replaceAll("[ |\\/|\\_|\\&|\\|]", "") + " ";
    }
}
