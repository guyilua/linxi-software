package com.rtk.app.tool;

import android.content.Context;
import com.rtk.app.main.MyApplication;

/* compiled from: CustomToast.java */
/* loaded from: /tmp/rtk_apk/classes3.dex */
public class f {
    private static long a;

    public static void a(Context context, String str, int i) {
        if (str.equals("空指针异常")) {
            return;
        }
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - a >= 1000) {
            com.hjq.toast.k.l(str);
            a = currentTimeMillis;
        }
    }

    public static void b(Context context, String str, int i) {
        new com.rtk.app.main.dialogPack.a0(MyApplication.b(), str);
    }
}
