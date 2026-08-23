package com.ss.android.socialbase.downloader.c;

import android.text.TextUtils;
import android.util.Log;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class a {
    private static int a = 4;
    private static AbstractC0089a b;

    /* renamed from: com.ss.android.socialbase.downloader.c.a$a, reason: collision with other inner class name */
    /* loaded from: /tmp/rtk_apk/classes3.dex */
    public static abstract class AbstractC0089a {
    }

    public static void a(int i) {
        a = i;
    }

    public static String b(String str) {
        return !TextUtils.isEmpty(str) ? "Downloader-".concat(String.valueOf(str)) : "DownloaderLogger";
    }

    public static void c(String str, String str2) {
        if (str2 == null) {
            return;
        }
        if (a <= 4) {
            Log.i(b(str), str2);
        }
        if (b != null) {
            b(str);
        }
    }

    public static void d(String str, String str2) {
        if (str2 == null) {
            return;
        }
        if (a <= 5) {
            Log.w(b(str), str2);
        }
        if (b != null) {
            b(str);
        }
    }

    public static void e(String str, String str2) {
        if (str2 == null) {
            return;
        }
        if (a <= 6) {
            Log.e(b(str), str2);
        }
        if (b != null) {
            b(str);
        }
    }

    public static boolean a() {
        return a <= 3;
    }

    public static void a(String str, String str2) {
        if (str2 == null || b == null) {
            return;
        }
        b(str);
    }

    public static void b(String str, String str2) {
        if (str2 == null) {
            return;
        }
        if (a <= 3) {
            b(str);
        }
        if (b != null) {
            b(str);
        }
    }

    public static void a(String str) {
        b("DownloaderLogger", str);
    }

    public static void c(String str) {
        d("DownloaderLogger", str);
    }

    public static void a(String str, String str2, Throwable th) {
        if (str2 == null && th == null) {
            return;
        }
        if (a <= 3) {
            b(str);
        }
        if (b != null) {
            b(str);
        }
    }

    public static void b(String str, String str2, Throwable th) {
        if (str2 == null && th == null) {
            return;
        }
        if (a <= 6) {
            Log.e(b(str), str2, th);
        }
        if (b != null) {
            b(str);
        }
    }
}
