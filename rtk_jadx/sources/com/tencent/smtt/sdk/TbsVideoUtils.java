package com.tencent.smtt.sdk;

import android.content.Context;
import com.tencent.smtt.export.external.DexLoader;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class TbsVideoUtils {
    private static p a;

    private static void a(Context context) {
        synchronized (TbsVideoUtils.class) {
            if (a == null) {
                d.a(true).a(context, false, false);
                r a2 = d.a(true).a();
                DexLoader b = a2 != null ? a2.b() : null;
                if (b != null) {
                    a = new p(b);
                }
            }
        }
    }

    public static void deleteVideoCache(Context context, String str) {
        a(context);
        p pVar = a;
        if (pVar != null) {
            pVar.a(context, str);
        }
    }

    public static String getCurWDPDecodeType(Context context) {
        a(context);
        p pVar = a;
        return pVar != null ? pVar.a(context) : "";
    }
}
