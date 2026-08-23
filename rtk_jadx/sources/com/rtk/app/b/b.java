package com.rtk.app.b;

import android.text.TextUtils;
import android.util.Log;
import de.mindpipe.android.logging.log4j.LogConfigurator;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;

/* compiled from: RTKLog.java */
/* loaded from: /tmp/rtk_apk/classes3.dex */
public class b {
    public static boolean a = true;
    public static boolean b = false;

    /* renamed from: c, reason: collision with root package name */
    public static String f146c = "rtk_log";

    public static void a() {
        LogConfigurator logConfigurator = new LogConfigurator();
        try {
            logConfigurator.setFileName(d.e() + d.f() + ".log");
            logConfigurator.setMaxBackupSize(50);
            logConfigurator.setMaxFileSize(10485760L);
            logConfigurator.setUseFileAppender(true);
            logConfigurator.setImmediateFlush(true);
            logConfigurator.setRootLevel(Level.DEBUG);
            logConfigurator.setFilePattern("%d\t%p/%c:\t%m%n");
            logConfigurator.configure();
            Log.e("Log4J", "Log4j config finish");
        } catch (Throwable th) {
            logConfigurator.setResetConfiguration(true);
            Log.e("Log4J", "Log4j config error, use default config. Error:" + th);
        }
    }

    public static void b(String str) {
        c(f146c, str);
    }

    public static void c(String str, String str2) {
        if (a) {
            e(str).debug(str2 + f());
        }
    }

    public static void d(String str, String str2) {
        if (a) {
            e(str).error(str2 + f());
        }
    }

    private static Logger e(String str) {
        if (!b) {
            b = true;
            a();
        }
        if (TextUtils.isEmpty(str)) {
            return Logger.getRootLogger();
        }
        return Logger.getLogger(str);
    }

    private static String f() {
        try {
            StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
            return String.format("  - %s, line: %d, method: %s", stackTrace[4].getFileName(), Integer.valueOf(stackTrace[4].getLineNumber()), stackTrace[4].getMethodName());
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }

    public static void g(String str, String str2) {
        if (a) {
            Logger e = e(str);
            if (str2 == null) {
                e.info("");
                return;
            }
            e.info(str2 + f());
        }
    }

    public static void h(String str, String str2) {
        if (a) {
            e(str).warn(str2 + f());
        }
    }
}
