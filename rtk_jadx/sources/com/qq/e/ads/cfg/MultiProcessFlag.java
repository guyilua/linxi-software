package com.qq.e.ads.cfg;

import com.qq.e.comm.util.GDTLogger;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class MultiProcessFlag {
    private static boolean a;
    private static boolean b;

    public static boolean isMultiProcess() {
        return a;
    }

    public static void setMultiProcess(boolean z) {
        if (b) {
            GDTLogger.w("MultiProcessFlag已经设置过，再次设置无效");
        } else {
            b = true;
            a = z;
        }
    }
}
