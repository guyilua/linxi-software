package com.rtk.app.tool;

import android.content.Context;

/* compiled from: DensityUtil.java */
/* loaded from: /tmp/rtk_apk/classes3.dex */
public class h {
    public static int a(float f, Context context) {
        return (int) ((f * context.getResources().getDisplayMetrics().density) + 0.5f);
    }
}
