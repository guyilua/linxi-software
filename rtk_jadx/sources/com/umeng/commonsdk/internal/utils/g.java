package com.umeng.commonsdk.internal.utils;

import android.os.Build;
import com.umeng.commonsdk.internal.utils.d;
import java.io.File;

/* compiled from: Root.java */
/* loaded from: /tmp/rtk_apk/classes3.dex */
public class g {
    public static boolean a() {
        return b() || c() || d() || e();
    }

    private static boolean b() {
        String str = Build.TAGS;
        return str != null && str.contains("test-keys");
    }

    private static boolean c() {
        try {
            if (new File("/system/app/Superuser.apk").exists()) {
                return true;
            }
        } catch (Exception unused) {
        }
        try {
            return new File("/system/app/Kinguser.apk").exists();
        } catch (Exception unused2) {
            return false;
        }
    }

    private static boolean d() {
        return new d().a(d.a.check_su_binary) != null;
    }

    private static boolean e() {
        String[] strArr = {"/bin", "/system/bin/", "/system/xbin/", "/system/sbin/", "/sbin/", "/vendor/bin/", "/su/bin/", "/data/local/xbin/", "/data/local/bin/", "/system/sd/xbin/", "/system/bin/failsafe/", "/data/local/"};
        for (int i = 0; i < 12; i++) {
            if (new File(strArr[i] + "su").exists()) {
                return true;
            }
        }
        return false;
    }
}
