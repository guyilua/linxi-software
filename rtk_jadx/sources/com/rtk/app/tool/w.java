package com.rtk.app.tool;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;

/* compiled from: SignTool.java */
/* loaded from: /tmp/rtk_apk/classes3.dex */
public class w {
    public static Signature[] a(Context context, String str) {
        if (str != null && str.length() != 0) {
            try {
                PackageInfo packageInfo = context.getPackageManager().getPackageInfo(str, 64);
                if (packageInfo == null) {
                    return null;
                }
                return packageInfo.signatures;
            } catch (PackageManager.NameNotFoundException unused) {
            }
        }
        return null;
    }

    public static String b(Context context, String str) {
        Signature[] a = a(context, str);
        if (a == null || a.length == 0) {
            return null;
        }
        return n.c(a[0].toByteArray());
    }
}
