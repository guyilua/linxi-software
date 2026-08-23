package com.umeng.commonsdk.internal.crash;

import java.io.PrintWriter;
import java.io.StringWriter;

/* compiled from: UMCrashUtils.java */
/* loaded from: /tmp/rtk_apk/classes3.dex */
public class a {
    public static String a(Throwable th) {
        String str = null;
        if (th == null) {
            return null;
        }
        try {
            StringWriter stringWriter = new StringWriter();
            PrintWriter printWriter = new PrintWriter(stringWriter);
            th.printStackTrace(printWriter);
            for (Throwable cause = th.getCause(); cause != null; cause = cause.getCause()) {
                cause.printStackTrace(printWriter);
            }
            str = stringWriter.toString();
            printWriter.close();
            stringWriter.close();
            return str;
        } catch (Exception unused) {
            return str;
        }
    }
}
