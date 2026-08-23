package com.umeng.commonsdk.debug;

import android.util.Log;
import com.umeng.commonsdk.utils.UMUtils;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class UMRTLog {
    private static final String RTLOG_ENABLE = "1";
    private static final String RTLOG_PROP = "debug.umeng.rtlog";
    public static final String RTLOG_TAG = "MobclickRT";

    private UMRTLog() {
    }

    public static void d(String str, String str2) {
        if (shouldOutput()) {
            Log.d(str, warpperMsg(str2, false));
        }
    }

    public static void e(String str, String str2) {
        if (shouldOutput()) {
            Log.e(str, warpperMsg(str2, false));
        }
    }

    public static void i(String str, String str2) {
        if (shouldOutput()) {
            Log.i(str, warpperMsg(str2, false));
        }
    }

    public static void sd(String str, String str2) {
        if (shouldOutput()) {
            Log.d(str, warpperMsg(str2, true));
        }
    }

    public static void se(String str, String str2) {
        if (shouldOutput()) {
            Log.e(str, warpperMsg(str2, true));
        }
    }

    private static boolean shouldOutput() {
        return "1".equals(UMUtils.getSystemProperty(RTLOG_PROP, "0"));
    }

    public static void si(String str, String str2) {
        if (shouldOutput()) {
            Log.i(str, warpperMsg(str2, true));
        }
    }

    public static void sv(String str, String str2) {
        if (shouldOutput()) {
            Log.v(str, warpperMsg(str2, true));
        }
    }

    public static void sw(String str, String str2) {
        if (shouldOutput()) {
            Log.w(str, warpperMsg(str2, true));
        }
    }

    public static void v(String str, String str2) {
        if (shouldOutput()) {
            Log.v(str, warpperMsg(str2, false));
        }
    }

    public static void w(String str, String str2) {
        if (shouldOutput()) {
            Log.w(str, warpperMsg(str2, false));
        }
    }

    private static String warpperMsg(String str, boolean z) {
        if (!z) {
            return str;
        }
        StringBuffer stringBuffer = null;
        try {
            StackTraceElement[] stackTrace = new Throwable().getStackTrace();
            if (stackTrace.length >= 3) {
                String fileName = stackTrace[2].getFileName();
                String methodName = stackTrace[2].getMethodName();
                int lineNumber = stackTrace[2].getLineNumber();
                StringBuffer stringBuffer2 = new StringBuffer();
                stringBuffer2.append("<");
                stringBuffer2.append(fileName);
                stringBuffer2.append(":");
                stringBuffer2.append(methodName);
                stringBuffer2.append(":");
                stringBuffer2.append(lineNumber);
                stringBuffer2.append("> ");
                stringBuffer2.append(str);
                stringBuffer = stringBuffer2;
            }
            return stringBuffer.toString();
        } catch (Throwable unused) {
            return str;
        }
    }
}
